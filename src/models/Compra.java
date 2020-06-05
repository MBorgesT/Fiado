package models;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Compra {

    private int idCompra, idCliente, idAtendente, idPagamento;
    private float valor;
    private Calendar data;
    private String observacao;
    private boolean estaPago;

    public Compra(int idCompra, int idCliente, int idAtendente, int idPagamento, float valor, Calendar data, String observacao, boolean estaPago) {
        this.idCompra = idCompra;
        this.idCliente = idCliente;
        this.idAtendente = idAtendente;
        this.idPagamento = idPagamento;
        this.valor = valor;
        this.data = data;
        this.observacao = observacao;
        this.estaPago = estaPago;
    }

    public Compra(int idCliente, int idAtendente, float valor, Calendar data, String observacao, boolean estaPago) {
        this.idCliente = idCliente;
        this.idAtendente = idAtendente;
        this.idPagamento = idPagamento;
        this.valor = valor;
        this.data = data;
        this.observacao = observacao;
        this.estaPago = estaPago;
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
                strPago
            };
        } else {
            strPago = "NÃO";
            return new Object[]{
                false,
                this.getFormattedData(),
                this.getFormattedValor(),
                strPago
            };
        }
    }

    public Object[] compraObjectArraySimple() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String strPago;

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

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

}
