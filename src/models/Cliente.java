package models;

public class Cliente {
    private int idCliente;
    private String nome, telefone1, telefone2, cpf, senha, salt;
    private Endereco endereco;
    private boolean ativo;

    public Cliente(int idCliente, String nome, String telefone1, String telefone2, String cpf, String senha, String salt, Endereco endereco, boolean ativo) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.cpf = cpf;
        this.senha = senha;
        this.salt = salt;
        this.endereco = endereco;
        this.ativo = ativo;
    }

    public Cliente(String nome, String telefone1, String telefone2, String cpf, String senha, String salt, Endereco endereco, boolean ativo) {
        this.nome = nome;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.cpf = cpf;
        this.senha = senha;
        this.salt = salt;
        this.endereco = endereco;
        this.ativo = ativo;
    }
    
    public Object[] clienteObjectArray(){
        return new Object[]{
            idCliente,
            nome
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

    public String getSalt() {
        return salt;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public boolean isAtivo() {
        return ativo;
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
