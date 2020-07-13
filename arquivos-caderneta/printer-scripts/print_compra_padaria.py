from escpos.printer import Usb
from unidecode import unidecode
import json

file = open('/home/matheus/arquivos-caderneta/printer-scripts/compra.json')
json_data = json.load(file)

printer = Usb(0x0416, 0x5011)


id_compra = json_data['id_compra']
data = json_data['data']
valor = json_data['valor']
cliente = json_data['cliente']
atendente = json_data['atendente']
observacao = json_data['observacao']


cliente = unidecode(cliente)
atendente = unidecode(atendente)
observacao = unidecode(observacao)
    

printer.set(align='center', width=2, height=2, invert=True)
printer.text(' Paes & Cia \n\n')

printer.set(align='center', width=2, height=1)
printer.text('Recibo de\ncompra\n\n')

printer.set(align='left')
printer.text('ID: ' + id_compra + '\n')
printer.text('Data: ' + data + '\n')
printer.text('Valor: R$ ' + valor + '\n')
printer.text('Cliente: ' + cliente + '\n')
printer.text('Atendente: ' + atendente + '\n')
if (observacao != 'null'):
	printer.text('Observacao: ' + observacao + '\n')

printer.text('\n\n')
printer.set(align='center', width=1, height=2)
printer.text('Este recibo pertence a Padaria. Favor nao entregar ao cliente.')

printer.cut()
