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
            //byte[] salt = rs.getBytes("salt");
            //boolean ativo = rs.getInt("ativo") == 1 ? true : false;

            Atendente atendente = new Atendente(
                    rs.getInt("idAtendente"),
                    rs.getString("nome"),
                    rs.getString("senha"),
                    rs.getBytes("salt"), 
                    (rs.getInt("ativo") == 1)
            );

            //atendente.setSalt(salt);
            //atendente.setAtivo(ativo);
            // até agora não entendi porque caralhos o salt não está funcionando no construtor
            // mas assim funcionou, então fica na gambiarra

            return atendente;
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "extractAtendenteFromRs", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    public static ArrayList selectTodosAtendentes() {
        try {
            Connection conn = DriverManager.getConnection(DAOPaths.dbPath);
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

    public static ArrayList selectTodosAtendentesAtivos() {
        try {
            Connection conn = DriverManager.getConnection(DAOPaths.dbPath);
            Statement stmt = conn.createStatement();

            ArrayList<Atendente> arrayAtendentes = new ArrayList<>();

            ResultSet rs = stmt.executeQuery("SELECT * FROM atendente WHERE ativo = 1");

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

    public static boolean insertAtendente(Atendente atendente) {
        try {
            Connection conn = DriverManager.getConnection(DAOPaths.dbPath);
            String sql = "INSERT INTO atendente(nome, senha, salt, ativo) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, atendente.getNome());
            ps.setString(2, atendente.getSenha());
            ps.setBytes(3, atendente.getSalt());
            ps.setInt(4, atendente.isAtivo() ? 1 : 0);
            ps.executeUpdate();

            conn.close();

            JOptionPane.showMessageDialog(null, "Atendente cadastrado com sucesso", "Atenção", JOptionPane.INFORMATION_MESSAGE);

            return true;
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "insertAtendente", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    public static boolean updateAtendente(Atendente atendente) {
        try {
            Connection conn = DriverManager.getConnection(DAOPaths.dbPath);
            String sql = "UPDATE atendente SET nome = ?, senha = ?, salt = ? WHERE idAtendente = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, atendente.getNome());
            ps.setString(2, atendente.getSenha());
            ps.setBytes(3, atendente.getSalt());
            ps.setInt(4, atendente.getIdAtendente());
            
            ps.executeUpdate();
            
            conn.close();
            
            return true;
        } catch (SQLException e) {
            Logger.getLogger(AtendenteDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "updateAtendente", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    public static Atendente selectAtendenteById(int idAtendente) {
        try {
            Connection conn = DriverManager.getConnection(DAOPaths.dbPath);
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM atendente WHERE idAtendente = " + String.valueOf(idAtendente));

            Atendente atendente;
            if (rs.next()){
                atendente = extractAtendenteFromRs(rs);
            }else{
                return null;
            }

            conn.close();

            return atendente;
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "selectAtendenteById", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    public static boolean updateEstadoAtivoAtendente(int idAtendente, boolean isAtivo) {
        try {
            Connection conn = DriverManager.getConnection(DAOPaths.dbPath);
            String sql = "UPDATE atendente SET ativo = ? WHERE idAtendente = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, isAtivo ? 1 : 0);
            ps.setInt(2, idAtendente);

            ps.executeUpdate();

            conn.close();

            return true;
        } catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "updateEstadoAtivoCliente", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
    
        
    public static boolean existeComprasOuPagamentosRelacionados(int idAtendente) {
        try {
            Connection conn = DriverManager.getConnection(DAOPaths.dbPath);
            Statement stmt = conn.createStatement();
            ResultSet rs1 = stmt.executeQuery("SELECT idAtendente FROM compra WHERE idAtendente = " + String.valueOf(idAtendente));
            ResultSet rs2 = stmt.executeQuery("SELECT idAtendente FROM pagamento WHERE idAtendente = " + String.valueOf(idAtendente));

            conn.close();

            return rs1.next() || rs2.next();
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "existeComprasRelacionadas", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
    
    public static boolean deleteAtendente(int idAtendente){
        try {
            Connection conn = DriverManager.getConnection(DAOPaths.dbPath);
            String sql;
            PreparedStatement ps;
            
            
            sql = "UPDATE cliente SET atendente = 0, idAtendente = -1 WHERE idAtendente = ?";
            ps = conn.prepareStatement(sql);
            
            ps.setInt(1, idAtendente);
            
            ps.executeUpdate();
            
            
            sql = "DELETE FROM atendente WHERE idAtendente = ?";
            ps = conn.prepareStatement(sql);

            ps.setInt(1, idAtendente);

            ps.executeUpdate();
            

            conn.close();

            return true;
        } catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "deleteAtendente", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
}
