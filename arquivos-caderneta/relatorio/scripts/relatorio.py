from models import Compra
from datetime import datetime, timedelta
from common import cursor, config_path

arq = open(config_path, 'r')
config = arq.read().splitlines()
print(config)

inicio = datetime.strptime(config[0], '%d/%m/%Y')
fim = datetime.strptime(config[1], '%d/%m/%Y')

fim += timedelta(days=1) # para, na hora de filtrar, incluir o dia inteiro referente ao fim

int_bool = lambda x: x == 1

compras = []
cursor.execute('SELECT * FROM compra')
for l in cursor.fetchall():
	c = Compra(
			l[0],
			l[1],
			l[2],
			l[3],
			datetime.strptime(l[4], '%d/%m/%Y %H:%M:%S'),
			l[5],
			int_bool(l[6]),
			l[7],
			int_bool(l[8]),
			int_bool(l[9])
		)

	if (c.data >= inicio and c.data <= fim) and not(c.entrega and not c.entregaValidada):
		compras.append(c)


import pizza_totais, pizza_clientes, pizza_clientes_nao_pago, pizza_entregas, stacked_vendas_por_dia


stacked_vendas_por_dia.gerar_imagem(compras)

pizza_totais.gerar_imagem(compras)
pizza_clientes.gerar_imagem(compras)
pizza_clientes_nao_pago.gerar_imagem(compras)
pizza_entregas.gerar_imagem(compras)