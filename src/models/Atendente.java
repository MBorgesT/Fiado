package models;

public class Atendente {
    private int idAtendente;
    private String nome, senha, salt;

    public Atendente(int idAtendente, String nome, String senha, String salt) {
        this.idAtendente = idAtendente;
        this.nome = nome;
        this.senha = senha;
    }

    public Atendente(String nome, String senha, String salt) {
        this.nome = nome;
        this.senha = senha;
        this.salt = salt;
    }
    
    public Object[] atendenteObjectArray(){
        return new Object[]{
            idAtendente,
            nome
        };
    }

    public int getIdAtendente() {
        return idAtendente;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getSalt() {
        return salt;
    }
}
