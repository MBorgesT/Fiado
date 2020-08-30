import matplotlib.pyplot as plt
import numpy as np
from common import imagens_path
from datetime import datetime, timedelta

def gerar_imagem(compras):
	inicio = compras[0].data
	fim = compras[0].data

	for c in compras:
		if c.data < inicio:
			inicio = c.data
		if c.data > fim:
			fim = c.data

	dias_datetime = np.arange(inicio, fim+timedelta(days=1), timedelta(days=1)).astype(datetime)
	for d in dias_datetime:
		print(d.strftime('%d/%m/%Y'))

	vendas_dias = dict()

	for d in dias_datetime:
		aux = d.strftime('%d/%m/%Y')
		vendas_dias[aux] = [0, 0]

	for c in compras:
		aux = c.data.strftime('%d/%m/%Y')
		if (c.data.hour < 12):
			vendas_dias[aux][0] += c.valor
		else:
			vendas_dias[aux][1] += c.valor


	array_vendas = list(vendas_dias.items())

	dias = []
	for d in dias_datetime:
		dias.append(d.strftime('%d/%m/%Y'))

	vendas_manha = [x[1][0] for x in array_vendas]
	vendas_tarde = [x[1][1] for x in array_vendas]


	barras_manha = plt.bar(dias, vendas_manha)
	barras_tarde = plt.bar(dias, vendas_tarde, bottom=vendas_manha)

	plt.ylabel('Valor em R$')
	plt.title('Vendas por dia')
	plt.xticks(dias, rotation='vertical')
	plt.legend((barras_manha, barras_tarde), ('Manhã', 'Tarde'))

	if (len(dias) > 28):
		ax = plt.gca()
		ax.set_xticks(ax.get_xticks()[::7])
	
	plt.grid(axis='y', linestyle='--')

	plt.savefig(imagens_path + 'vendas_por_dia.png', bbox_inches='tight')
	plt.clf()
