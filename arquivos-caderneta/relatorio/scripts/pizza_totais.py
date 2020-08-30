import matplotlib.pyplot as plt
from common import imagens_path

def gerar_imagem(compras):
	valor_total = 0.0
	valor_pagas = 0.0
	valor_n_pagas = 0.0

	for c in compras:
		valor_total += c.valor
		if (c.estaPago):
			valor_pagas += c.valor
		else:
			valor_n_pagas += c.valor


	formatar = lambda x: '(R$' + ("{:.2f}".format(x)).replace('.', ',') + ')'

	labels = ['PAGAS ' + formatar(valor_pagas), 'NÃO PAGAS ' + formatar(valor_n_pagas)]
	sizes = [valor_pagas/valor_total, valor_n_pagas/valor_total]
	explode = (0.1, 0)
	colors = ['#38AFA0', '#D84A3F']

	fig1, ax1 = plt.subplots()

	ax1.pie(sizes, explode=explode, autopct='%1.1f%%',
        shadow=False, startangle=90, colors=colors)
	ax1.axis('equal')
	ax1.legend(labels)
	ax1.set_title('Totais de compras pagas e não pagas', )

	plt.tight_layout()
	plt.savefig(imagens_path + 'totais.png')
	plt.clf()
