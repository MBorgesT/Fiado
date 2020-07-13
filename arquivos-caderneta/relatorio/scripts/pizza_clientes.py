import matplotlib.pyplot as plt
from common import cursor, imagens_path

def gerar_imagem(compras):
	valor_total = 0.0

	valores = dict()
	for c in compras:
		valores[c.idCliente] = 0

	for c in compras:
		valores[c.idCliente] += c.valor
		valor_total += c.valor

	clientes = dict()
	for v in valores:
		cursor.execute('SELECT nome FROM cliente WHERE idCliente = ' + str(v))
		nome = cursor.fetchall()[0]
		clientes[v] = (valores[v], *nome)


	clientes_ord = sorted(clientes.items(), key = lambda x: x[1][0], reverse=True)

	primeiros = clientes_ord[:12]


	sizes = [x[1][0]/valor_total for x in primeiros]
	soma = 0
	for x in primeiros:
		soma += x[1][0]

	labels = [x[1][1] for x in primeiros]
	values = [x[1][0] for x in primeiros]

	if len(primeiros) == 12: 
		labels += ['OUTROS']
		values += [valor_total-soma]
		sizes.append((valor_total - soma)/valor_total)

	formatar = lambda x: '(R$' +  ("{:.2f}".format(x)).replace('.', ',') + ')'
	legend = [str(x[0]) + ' ' + formatar(x[1]) for x in zip(labels, values)]


	valor_abs = lambda x: 'R$' + ("{:.2f}".format((x/100) * valor_total)).replace('.', ',')

	fig1, ax1 = plt.subplots()
	ax1.pie(sizes, autopct='%1.1f%%', shadow=False, startangle=90)
	ax1.axis('equal')
	ax1.legend(legend, loc="center left", bbox_to_anchor=(1, 0, 0.5, 1))
	ax1.set_title('Compras realizadas pelos doze maiores clientes')

	plt.savefig(imagens_path + 'clientes.png', bbox_inches='tight')

