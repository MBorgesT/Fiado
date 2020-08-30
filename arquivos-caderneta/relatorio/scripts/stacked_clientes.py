import matplotlib.pyplot as plt
import numpy as np
from common import imagens_path, cursor
from datetime import datetime, timedelta

def gerar_imagem(compras):
	valores = dict()
	for c in compras:
		valores[c.idCliente] = [0,0]

	for c in compras:
		if c.estaPago:
			valores[c.idCliente][0] += c.valor
		else:
			valores[c.idCliente][1] += c.valor

	clientes = dict()
	for v in valores:
		cursor.execute('SELECT nome FROM cliente WHERE idCliente = ' + str(v))
		nome = cursor.fetchall()[0]
		clientes[v] = (valores[v], *nome)


	clientes_ord = sorted(clientes.items(), key = lambda x: x[1][0][0] + x[1][0][1], reverse=True)

	primeiros = clientes_ord[:15]
	primeiros.reverse()


	nomes = [x[1][1] for x in primeiros]
	compras_pagas = [x[1][0][0] for x in primeiros]
	compras_debito = [x[1][0][1] for x in primeiros]


	barras_pago = plt.barh(nomes, compras_pagas, color='#38AFA0')
	barras_debito = plt.barh(nomes, compras_debito, left=compras_pagas, color='#D84A3F')

	plt.ylabel('Clientes')
	plt.xlabel('Valor das compras (R$)')
	plt.title('Compras dos quinze maiores clientes')
	plt.legend((barras_pago, barras_debito), ('Pagas', 'Não pagas'))

	plt.grid(axis='x', linestyle='--')

	plt.savefig(imagens_path + 'stacked_clientes.png', bbox_inches='tight')
	plt.clf()