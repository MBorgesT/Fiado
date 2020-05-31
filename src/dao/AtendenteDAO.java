package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.Atendente;

public class AtendenteDAO {

    private Atendente extractAtendenteFromRs(ResultSet rs) throws SQLException {
        return new Atendente(
                rs.getInt("idAtendente"),
                rs.getString("nome"),
                rs.getString("senha"),
                rs.getString("salt")
        );
    }

    public ArrayList getAllAtendentes() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/matheus/NetBeansProjects/Fiado/src/dao/fiado.db");
        Statement stmt = conn.createStatement();

        ArrayList<Atendente> arrayAtendentes = new ArrayList<>();

        ResultSet rs = stmt.executeQuery("SELECT * FROM atendente");

        while (rs.next()) {
            arrayAtendentes.add(extractAtendenteFromRs(rs));
        }

        conn.close();

        return arrayAtendentes;
    }

    public void insertAtendente(Atendente atendente) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/matheus/NetBeansProjects/Fiado/src/dao/fiado.db");
        String sql = "INSERT INTO atendente(nome, senha, salt) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, atendente.getNome());
        ps.setString(2, atendente.getSenha());
        ps.setString(3, atendente.getSalt());
        ps.executeUpdate();

        conn.close();

        JOptionPane.showMessageDialog(null, "Atendente cadastrado com sucesso", "Atenção", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean checarSenha(int idAtendente, String hashedPw) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/matheus/NetBeansProjects/Fiado/src/dao/fiado.db");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT senha FROM atendente WHERE idAtendente = " + String.valueOf(idAtendente));
        conn.close();

        rs.next();
        String dbPw = rs.getString("senha");

        if (hashedPw.equals(dbPw)) {
            return true;
        } else {
            return false;
        }
    }
}
