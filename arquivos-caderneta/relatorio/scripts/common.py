import sqlite3
conn = sqlite3.connect('/home/matheus/arquivos-caderneta/database/atual/caderneta.db')
cursor = conn.cursor()


imagens_path = '/home/matheus/arquivos-caderneta/relatorio/imagens/'
config_path = '/home/matheus/arquivos-caderneta/relatorio/scripts/config.txt'