package models;

public class Atendente {
    private int idAtendente;
    private String nome, senha;
    private byte[] salt;
    private boolean ativo;

    public Atendente(int idAtendente, String nome, String senha, byte[] salt, boolean ativo) {
        this.idAtendente = idAtendente;
        this.nome = nome;
        this.senha = senha;
        this.salt = salt;
        this.ativo = ativo;
    }

    public Atendente(String nome, String senha, byte[] salt, boolean ativo) {
        this.nome = nome;
        this.senha = senha;
        this.salt = salt;
        this.ativo = true;
    }

    @Override
    public String toString() {
        return "Atendente{" + "idAtendente=" + idAtendente + ", nome=" + nome + ", senha=" + senha + ", salt=" + salt + ", ativo=" + ativo + '}';
    }
    
    public Object[] atendenteObjectArray(){
        return new Object[]{
            idAtendente,
            nome,
            ativo ? "SIM" : "NÃO"
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
