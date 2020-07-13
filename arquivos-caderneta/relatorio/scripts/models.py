class Compra:
	def __init__(self, idCompra, idCliente, idAtendente, valor, data, observacao, estaPago, idPagamento, entrega, entregaValidada):
		self.idCompra = idCompra
		self.idCliente = idCliente
		self.idAtendente = idAtendente
		self.valor = valor
		self.data = data
		self.observacao = observacao
		self.estaPago = estaPago
		self.idPagamento = idPagamento
		self.entrega = entrega
		self.entregaValidada = entregaValidada

