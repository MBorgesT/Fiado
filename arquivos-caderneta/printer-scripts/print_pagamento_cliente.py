from escpos.printer import Usb
from unidecode import unidecode
import json

file = open('/home/matheus/arquivos-caderneta/printer-scripts/pagamento.json')
json_data = json.load(file)

printer = Usb(0x0416, 0x5011)


id_pagamento = json_data['id_pagamento']
data = json_data['data']
valor = json_data['valor']
cliente = json_data['cliente']
atendente = json_data['atendente']
observacao = json_data['observacao']

qtd_compras = int(json_data['qtd_compras'])
compras_list = []
for i in range(qtd_compras):
	data_aux = json_data['compra_data' + str(i)]
	valor_aux = json_data['compra_valor' + str(i)]
	compras_list.append([data_aux, valor_aux])


printer.set(align='center', width=2, height=2)
printer.text('Paes & Cia\n\n')

printer.set(align='center', width=2, height=1)
printer.text('Recibo de\npagamento\n\n')

printer.set(align='left', width=1, height=1)
printer.text('ID: ' + id_pagamento + '\n')
printer.text('Data: ' + data + '\n')
printer.text('Valor total: R$ ' + valor + '\n')
printer.text('Cliente: ' + cliente + '\n')
printer.text('Atendente: ' + atendente + '\n')
if (observacao != 'null'):
	printer.text('Observacao: ' + observacao + '\n')

printer.text('\n')
for compra in compras_list:
	len_compra = len(compra[1])
	str_spaces = ''
	for i in range(13 - len_compra):
		str_spaces += ' '

	printer.text(compra[0] + str_spaces +  compra[1] + '\n')

printer.text('\n\n')
printer.set(align='center')
printer.text('__________________________\n')
printer.text('Atendente\n\n\n')

printer.text('__________________________\n')
printer.text('Cliente')

printer.text('\n\n')
printer.text('Agradecemos a preferencia')

printer.cut()