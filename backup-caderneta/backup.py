from __future__ import print_function
import pickle
import os.path
from googleapiclient.discovery import build
from googleapiclient.http import MediaFileUpload
from google_auth_oauthlib.flow import InstalledAppFlow
from google.auth.transport.requests import Request

import sys
from datetime import datetime


# If modifying these scopes, delete the file token.pickle.
SCOPES = ['https://www.googleapis.com/auth/drive.file']

def main():

	creds = None

	if os.path.exists('token.pickle'):
		with open('token.pickle', 'rb') as token:
			creds = pickle.load(token)

	if not creds or not creds.valid:
		if creds and creds.expired and creds.refresh_token:
			creds.refresh(Request())
		else:
			flow = InstalledAppFlow.from_client_secrets_file(
				'credentials.json', SCOPES)
			creds = flow.run_local_server(port=0)

		with open('token.pickle', 'wb') as token:
			pickle.dump(creds, token)

	drive_service = build('drive', 'v3', credentials=creds)



	# store backup

	now = datetime.now()
	year_folder_id = None
	month_folder_id = None


	response = drive_service.files().list(q="mimeType = 'application/vnd.google-apps.folder'",
										  spaces='drive', 
										  fields='nextPageToken, files(id, name)').execute()

	flag = False
	for file in response.get('files', []):
		if file.get('name') == str(now.year):
			year_folder_id = file.get('id')
			flag = True

	if (flag == False):
		file_metadata = {
			'name': str(now.year),
			'mimeType': 'application/vnd.google-apps.folder'
		}
		file = drive_service.files().create(body=file_metadata,
											fields='id').execute()

		year_folder_id = file.get('id')


	response = drive_service.files().list(q="mimeType = 'application/vnd.google-apps.folder' and '{}' in parents".format(year_folder_id),
										  spaces='drive', 
										  fields='nextPageToken, files(id, name)').execute()

	flag = False
	for file in response.get('files', []):
		if (file.get('name') == str(now.month)):
			month_folder_id = file.get('id')
			flag = True

	if (flag == False):
		file_metadata = {
			'name': str(now.month),
			'mimeType': 'application/vnd.google-apps.folder',
			'parents': [str(year_folder_id)]
		}
		file = drive_service.files().create(body=file_metadata,
											fields='id').execute()

		month_folder_id = file.get('id')


	period = sys.argv[1]
	file_name = str(now.year) + '-' + str(now.month) + '-' + str(now.day) + '-' + period + '.db'
	file_metadata = {
		'name': file_name,
		'parents': [month_folder_id]
	}

	media = MediaFileUpload(
		'/home/matheus/NetBeansProjects/Fiado/src/dao/fiado.db',
		resumable=True
	)

	file = drive_service.files().create(body=file_metadata,
										media_body=media,
										fields='id').execute()

	print('File ID: %s' % file.get('id'))



if __name__ == '__main__':
    main()