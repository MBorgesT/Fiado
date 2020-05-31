package models;

public class Endereco {
    private int idEndereco, numero;
    private String logradouro, bairro, cidade, referencia;

    public Endereco(int idEndereco, int numero, String logradouro, String bairro, String cidade, String referencia) {
        this.idEndereco = idEndereco;
        this.numero = numero;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.referencia = referencia;
    }

    public Endereco(int numero, String logradouro, String bairro, String cidade, String referencia) {
        this.numero = numero;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.referencia = referencia;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public int getNumero() {
        return numero;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    
    
    
}
