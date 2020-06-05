package models;

public class Atendente {
    private int idAtendente;
    private String nome, senha;
    byte[] salt;

    public Atendente(int idAtendente, String nome, String senha, byte[] salt) {
        this.idAtendente = idAtendente;
        this.nome = nome;
        this.senha = senha;
    }

    public Atendente(String nome, String senha, byte[] salt) {
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

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }
}
