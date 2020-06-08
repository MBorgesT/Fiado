package models;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Pagamento {
    
    private int idPagamento, idCliente, idAtendente;
    private float valor;
    private Calendar data;
    private String observacao;

    public Pagamento(int idPagamento, int idCliente, int idAtendente, float valor, Calendar data, String observacao) {
        this.idPagamento = idPagamento;
        this.idCliente = idCliente;
        this.idAtendente = idAtendente;
        this.valor = valor;
        this.data = data;
        this.observacao = observacao;
    }

    public Pagamento(int idCliente, int idAtendente, float valor, Calendar data, String observacao) {
        this.idCliente = idCliente;
        this.idAtendente = idAtendente;
        this.valor = valor;
        this.data = data;
        this.observacao = observacao;
    }
    
    public String getFormattedValor() {
        String valor = String.format("%.02f", this.getValor());
        valor = valor.replace('.', ',');
        return valor;
    }

    public String getFormattedData() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(this.data.getTime());
    }
    
    public Object[] pagamentoObjectArray(){
        return new Object[]{
            this.getFormattedData(),
            this.getFormattedValor()
        };
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdAtendente() {
        return idAtendente;
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

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }
    
}
