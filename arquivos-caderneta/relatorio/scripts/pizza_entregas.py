import matplotlib.pyplot as plt
from common import imagens_path

def gerar_imagem(compras):
	valor_total = 0.0
	valor_entregas = 0.0
	valor_balcao = 0.0

	for c in compras:
		valor_total += c.valor
		if (c.entrega):
			valor_entregas += c.valor
		else:
			valor_balcao += c.valor


	formatar = lambda x: '(R$' + ("{:.2f}".format(x)).replace('.', ',') + ')'

	labels = ['ENTREGAS ' + formatar(valor_entregas), 'BALCÃO ' + formatar(valor_balcao)]
	sizes = [valor_entregas/valor_total, valor_balcao/valor_total]
	explode = (0.1, 0)

	fig1, ax1 = plt.subplots()

	ax1.pie(sizes, autopct='%1.1f%%',
        shadow=False, startangle=90)
	ax1.axis('equal')
	ax1.legend(labels)
	ax1.set_title('Entregas e vendas no balcão')

	plt.tight_layout()
	plt.savefig(imagens_path + 'entregas.png')