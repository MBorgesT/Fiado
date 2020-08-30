import matplotlib.pyplot as plt
import numpy as np
from common import imagens_path
from datetime import datetime, timedelta

def gerar_imagem(compras):
	inicio = 99
	fim = -1

	for c in compras:
		if c.data.hour < inicio:
			inicio = c.data.hour
		if c.data.hour > fim:
			fim = c.data.hour


	horarios_dict = dict()
	for i in range(inicio, fim+1):
		horarios_dict[i] = 0


	for c in compras:
		horarios_dict[c.data.hour] += 1


	horarios_list = list(horarios_dict.items())

	x_data = [x[1] for x in horarios_list]

	print('inicio: ', inicio)
	print('fim:', fim)



	fig, axs = plt.subplots(1, 2, sharey=True, tight_layout=True)
	plt.ylabel('Total de vendas')
	plt.xlabel('Horário do dia')

	axs[0].hist(np.arange(inicio, fim+1))
	axs[1].hist(x_data)

	plt.savefig(imagens_path + 'vendas_por_horario.png', bbox_inches='tight')
	plt.clf()