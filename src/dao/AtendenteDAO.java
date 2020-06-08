package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Atendente;

public class AtendenteDAO {

    private static Atendente extractAtendenteFromRs(ResultSet rs) {
        try {
            byte[] salt = rs.getBytes("salt");

            Atendente atendente = new Atendente(
                    rs.getInt("idAtendente"),
                    rs.getString("nome"),
                    rs.getString("senha"),
                    rs.getBytes("salt"));

            atendente.setSalt(salt);
            // até agora não entendi porque caralhos o salt não está funcionando no construtor
            // mas assim funcionou, então fica na gambiarra

            return atendente;
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "extractAtendenteFromRs", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    public static ArrayList selectAllAtendentes() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/matheus/NetBeansProjects/Fiado/src/dao/fiado.db");
            Statement stmt = conn.createStatement();

            ArrayList<Atendente> arrayAtendentes = new ArrayList<>();

            ResultSet rs = stmt.executeQuery("SELECT * FROM atendente");

            while (rs.next()) {
                arrayAtendentes.add(extractAtendenteFromRs(rs));
            }

            conn.close();

            return arrayAtendentes;
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "Atenção", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    public static void insertAtendente(Atendente atendente) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/matheus/NetBeansProjects/Fiado/src/dao/fiado.db");
            String sql = "INSERT INTO atendente(nome, senha, salt) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, atendente.getNome());
            ps.setString(2, atendente.getSenha());
            ps.setBytes(3, atendente.getSalt());
            ps.executeUpdate();

            conn.close();

            JOptionPane.showMessageDialog(null, "Atendente cadastrado com sucesso", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "insertAtendente", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static Atendente selectAtendenteById(int idAtendente) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/matheus/NetBeansProjects/Fiado/src/dao/fiado.db");
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM atendente WHERE idAtendente = " + String.valueOf(idAtendente));
            
            rs.next();
            Atendente atendente = extractAtendenteFromRs(rs);
            
            return atendente;
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "selectAtendenteById", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }
}
