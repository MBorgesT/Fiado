package models;

import dao.ClienteDAO;
import dao.CompraDAO;

public class Cliente {
    private int idCliente, idAtendente;
    private String nome, telefone1, telefone2, cpf, senha;
    private byte[] salt;
    private Endereco endereco;
    private boolean ativo, atendente;

    public Cliente(int idCliente, String nome, String telefone1, String telefone2, String cpf, String senha, byte[] salt, Endereco endereco, boolean ativo, boolean atendente, int idAtendente) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.cpf = cpf;
        this.senha = senha;
        this.salt = salt;
        this.endereco = endereco;
        this.ativo = ativo;
        this.atendente = atendente;
        this.idAtendente = idAtendente;
    }

    public Cliente(String nome, String telefone1, String telefone2, String cpf, String senha, byte[] salt, Endereco endereco, boolean ativo, boolean atendente, int idAtendente) {
        this.nome = nome;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.cpf = cpf;
        this.senha = senha;
        this.salt = salt;
        this.endereco = endereco;
        this.ativo = ativo;
        this.atendente = atendente;
        this.idAtendente = idAtendente;
    }
    
    public Object[] clienteObjectArray(){
        return new Object[]{
            idCliente,
            nome
        };
    }
    
    public Object[] clienteObjectArrayComplete(){
        String valorEmDebito = String.format("%.02f", ClienteDAO.calcularValorEmDebito(idCliente));
        valorEmDebito = valorEmDebito.replace('.', ',');
        valorEmDebito = "R$ " + valorEmDebito;
        
        return new Object[]{
            idCliente,
            nome,
            valorEmDebito,
            ClienteDAO.dataCompraNaoPagaMaisAntiga(idCliente),
            isAtivo() ? "SIM" : "NÃO"
        };
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public byte[] getSalt() {
        return salt;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public int getIdAtendente() {
        return idAtendente;
    }

    public boolean isAtendente() {
        return atendente;
    }
    
    

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    
}
