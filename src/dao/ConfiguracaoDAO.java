package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Cliente;
import security.Hash;

public class ConfiguracaoDAO {

    public static int selectDiasNotificacao() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/matheus/NetBeansProjects/Fiado/src/dao/fiado.db");
            Statement stmt = conn.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT diasNotificacao FROM configuracao");

            int diasNotificacao;

            if (rs.next()) {
                diasNotificacao = rs.getInt("diasNotificacao");
            } else {
                diasNotificacao = 0;
            }

            conn.close();

            return diasNotificacao;

        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "selectDiasNotificacao", JOptionPane.WARNING_MESSAGE);
        }
        return 0;
    }

    public static boolean validarSenha(String senha) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/matheus/NetBeansProjects/Fiado/src/dao/fiado.db");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT senha, salt FROM configuracao WHERE idConfiguracao = 1");
            
            rs.next();
            String hashedPw = rs.getString("senha");
            byte[] salt = rs.getBytes("salt");
            
            
            conn.close();
            
            return Hash.verifyPassword(senha, hashedPw, salt);
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "validarSenha", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    public static void updateDiasNotificacao(int diasNotificacao) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/matheus/NetBeansProjects/Fiado/src/dao/fiado.db");
            String sql = "UPDATE configuracao SET diasNotificacao = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, diasNotificacao);
            ps.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "updateDiasNotificacao", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void updateSenha(String hashedPw, byte[] salt) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/matheus/NetBeansProjects/Fiado/src/dao/fiado.db");
            String sql = "UPDATE configuracao SET senha = ?, salt = ? WHERE idConfiguracao = 1";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, hashedPw);
            ps.setBytes(2, salt);

            ps.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "updateSenha", JOptionPane.WARNING_MESSAGE);
        }
    }

}
