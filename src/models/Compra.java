package models;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Compra {

    private int idCompra, idCliente, idAtendente, idPagamento;
    private float valor;
    private Calendar data;
    private String observacao;
    private boolean estaPago, entrega, entregaValidada;

    public Compra(int idCompra, int idCliente, int idAtendente, int idPagamento, float valor, Calendar data, String observacao, boolean estaPago, boolean entrega, boolean entregaValidada) {
        this.idCompra = idCompra;
        this.idCliente = idCliente;
        this.idAtendente = idAtendente;
        this.idPagamento = idPagamento;
        this.valor = valor;
        this.data = data;
        this.observacao = observacao;
        this.estaPago = estaPago;
        this.entrega = entrega;
        this.entregaValidada = entregaValidada;
    }

    public Compra(int idCliente, int idAtendente, float valor, Calendar data, String observacao, boolean estaPago, boolean entrega) {
        this.idCliente = idCliente;
        this.idAtendente = idAtendente;
        this.valor = valor;
        this.data = data;
        this.observacao = observacao;
        this.estaPago = estaPago;
        this.entrega = entrega;
    }

    public Compra(int idCliente, float valor, Calendar data, String observacao, boolean estaPago, boolean entrega, boolean entregaValidada) {
        this.idCliente = idCliente;
        this.valor = valor;
        this.data = data;
        this.observacao = observacao;
        this.estaPago = estaPago;
        this.entrega = entrega;
        this.entregaValidada = entregaValidada;
    }

    @Override
    public String toString() {
        return "Compra{" + "idCompra=" + idCompra + ", idCliente=" + idCliente + ", idAtendente=" + idAtendente + ", idPagamento=" + idPagamento + ", valor=" + valor + ", data=" + data + ", observacao=" + observacao + ", estaPago=" + estaPago + '}';
    }

    public String getFormattedValor() {
        String valor = String.format("%.02f", this.getValor());
        valor = valor.replace('.', ',');
        return valor;
    }

    public String getFormattedData() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(data.getTime());
    }

    public Object[] compraObjectArray() {
        String strPago;

        if (estaPago) {
            strPago = "SIM";
            return new Object[]{
                null,
                this.getFormattedData(),
                this.getFormattedValor(),
                strPago,
                this.isEntrega() && this.isEntregaValidada() ? "ENTREGA" : ""
            };
        } else {
            strPago = "NÃO";
            return new Object[]{
                false,
                this.getFormattedData(),
                this.getFormattedValor(),
                strPago,
                this.isEntrega() && this.isEntregaValidada() ? "ENTREGA" : ""
            };
        }

    }

    public Object[] compraObjectArrayAdmin() {
        String strPago;
        String entrega;

        if (estaPago) {
            strPago = "SIM";
        } else {
            strPago = "NÃO";
        }
        
        if (this.isEntrega() && this.isEntregaValidada()){
            entrega = "ENTREGA";
        }else if (this.isEntrega() && !this.isEntregaValidada()){
            entrega = "NÃO VALIDADA";
        }else{
            entrega = "";
        }

        return new Object[]{
            this.getFormattedData(),
            this.getFormattedValor(),
            strPago,
            entrega
        };
    }

    public Object[] compraObjectArraySimple() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        return new Object[]{
            sdf.format(data.getTime()),
            this.getFormattedValor()
        };
    }

    public int getIdCompra() {
        return idCompra;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdAtendente() {
        return idAtendente;
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public float getValor() {
        return valor;
    }

    public Calendar getData() {
        return data;
    }

    public String getObservacao() {
        return observacao;
    }

    public boolean isEstaPago() {
        return estaPago;
    }

    public boolean isEntrega() {
        return entrega;
    }

    public boolean isEntregaValidada() {
        return entregaValidada;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

}
