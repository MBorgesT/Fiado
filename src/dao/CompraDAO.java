package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Compra;

public class CompraDAO {

    private static Compra extractCompraFromRs(ResultSet rs) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Calendar data = Calendar.getInstance();
            data.setTime(sdf.parse(rs.getString("data")));
            
            return new Compra(
                    rs.getInt("idCompra"),
                    rs.getInt("idCliente"),
                    rs.getInt("idAtendente"),
                    rs.getInt("idPagamento"),
                    rs.getFloat("valor"),
                    data,
                    rs.getString("observacao"),
                    (rs.getInt("estaPago") == 1),
                    (rs.getInt("entrega") == 1),
                    (rs.getInt("entregaValidada") == 1)
            );
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "extractCompraFromRs", JOptionPane.WARNING_MESSAGE);
        } catch (ParseException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "extractClienteFromRs", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    public static ArrayList<Compra> selectTodasComprasFromCliente(int idCliente) {
        try {
            Connection conn = DriverManager.getConnection(DAOPaths.dbPath);
            Statement stmt = conn.createStatement();

            ArrayList<Compra> arrayCompras = new ArrayList<>();

            ResultSet rs = stmt.executeQuery("SELECT * FROM compra WHERE idCliente = " + String.valueOf(idCliente));

            while (rs.next()) {
                arrayCompras.add(extractCompraFromRs(rs));
            }

            conn.close();

            return arrayCompras;
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "selectTodasComprasFromCliente", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    public static ArrayList<Compra> selectComprasValidasFromCliente(int idCliente) {
        try {
            Connection conn = DriverManager.getConnection(DAOPaths.dbPath);
            Statement stmt = conn.createStatement();

            ArrayList<Compra> arrayCompras = new ArrayList<>();

            ResultSet rs = stmt.executeQuery("SELECT * FROM compra WHERE idCliente = " + String.valueOf(idCliente) + 
                    " AND ((entrega = 0)  OR  (entrega = 1 AND entregaValidada = 1))");

            while (rs.next()) {
                arrayCompras.add(extractCompraFromRs(rs));
            }

            conn.close();

            return arrayCompras;
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "selectComprasValidadasFromCliente", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    public static ArrayList<Compra> selectComprasFromPagamento(int idPagamento) {
        try {
            Connection conn = DriverManager.getConnection(DAOPaths.dbPath);
            Statement stmt = conn.createStatement();

            ArrayList<Compra> arrayCompras = new ArrayList<>();

            ResultSet rs = stmt.executeQuery("SELECT * FROM compra WHERE idPagamento = " + String.valueOf(idPagamento));

            while (rs.next()) {
                arrayCompras.add(extractCompraFromRs(rs));
            }

            conn.close();

            return arrayCompras;
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "selectComprasFromCliente", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    public static int insertCompra(Compra compra) {
        try {
            Connection conn = DriverManager.getConnection(DAOPaths.dbPath);
            String sql = "INSERT INTO compra(idCliente, idAtendente, valor, data, observacao, estaPago, entrega) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String data = sdf.format(compra.getData().getTime());

            ps.setInt(1, compra.getIdCliente());
            ps.setInt(2, compra.getIdAtendente());
            ps.setFloat(3, compra.getValor());
            ps.setString(4, data);
            ps.setString(5, compra.getObservacao());
            ps.setInt(6, compra.isEstaPago() ? 1 : 0);
            ps.setInt(7, compra.isEntrega() ? 1 : 0);

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            int insertedId;
            if (rs.next()) {
                insertedId = rs.getInt(1);
            } else {
                insertedId = 0;
            }

            conn.close();

            JOptionPane.showMessageDialog(null, "Compra efetuada com sucesso", "Atenção", JOptionPane.INFORMATION_MESSAGE);

            return insertedId;
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "insertCompra", JOptionPane.WARNING_MESSAGE);
        }
        return 0;
    }
    
    public static int insertCompraEntrega(Compra compra) {
        try {
            Connection conn = DriverManager.getConnection(DAOPaths.dbPath);
            String sql = "INSERT INTO compra(idCliente, valor, data, observacao, estaPago, entrega, entregaValidada) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String data = sdf.format(compra.getData().getTime());

            ps.setInt(1, compra.getIdCliente());
            ps.setFloat(2, compra.getValor());
            ps.setString(3, data);
            ps.setString(4, compra.getObservacao());
            ps.setInt(5, compra.isEstaPago() ? 1 : 0);
            ps.setInt(6, compra.isEntrega() ? 1 : 0);
            ps.setInt(7, compra.isEntregaValidada() ? 1 : 0);

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            int insertedId;
            if (rs.next()) {
                insertedId = rs.getInt(1);
            } else {
                insertedId = 0;
            }

            conn.close();

            JOptionPane.showMessageDialog(null, "Compra efetuada com sucesso", "Atenção", JOptionPane.INFORMATION_MESSAGE);

            return insertedId;
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "insertCompraEntrega", JOptionPane.WARNING_MESSAGE);
        }
        return 0;
    }

    public static void updateSetPagamento(int idPagamento, int idCompra) {
        try {
            Connection conn = DriverManager.getConnection(DAOPaths.dbPath);
            String sql = "UPDATE compra SET idPagamento = ?, estaPago = 1 WHERE idCompra = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, idPagamento);
            ps.setInt(2, idCompra);

            ps.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "updateSetPagamento", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static boolean clienteExcedeDiasNotificacao(int idCliente) {
        try {
            int diasNotificacao = ConfiguracaoDAO.selectDiasNotificacao();

            Connection conn = DriverManager.getConnection(DAOPaths.dbPath);
            Statement stmt = conn.createStatement();
            String sql = "SELECT data FROM compra WHERE estaPago = 0 AND idCliente = " + String.valueOf(idCliente) + " AND (entrega = 0 OR (entrega = 1 AND entregaValidada = 1))";
            ResultSet rs = stmt.executeQuery(sql);

            boolean flag = false;
            while (rs.next()) {
                String dataStr = rs.getString("data");

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Calendar dataCompra = Calendar.getInstance();
                dataCompra.setTime(sdf.parse(dataStr));

                int diasEntre = (int) ChronoUnit.DAYS.between(dataCompra.toInstant(), Calendar.getInstance().toInstant());

                if (diasEntre >= diasNotificacao) {
                    flag = true;
                }
            }

            conn.close();

            return flag;
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "clienteExcedeDiasNotificacao", JOptionPane.WARNING_MESSAGE);
        } catch (ParseException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "clienteExcedeDiasNotificacao", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    public static boolean clienteExcedeDiasNotificacao(int idCliente, int diasNotificacao) {
        try {
            Connection conn = DriverManager.getConnection(DAOPaths.dbPath);
            Statement stmt = conn.createStatement();
            String sql = "SELECT data FROM compra WHERE estaPago = 0 AND idCliente = " + String.valueOf(idCliente) + " AND (entrega = 0 OR (entrega = 1 AND entregaValidada = 1))";
            ResultSet rs = stmt.executeQuery(sql);

            boolean flag = false;
            while (rs.next()) {
                String dataStr = rs.getString("data");

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Calendar dataCompra = Calendar.getInstance();
                dataCompra.setTime(sdf.parse(dataStr));

                int diasEntre = (int) ChronoUnit.DAYS.between(dataCompra.toInstant(), Calendar.getInstance().toInstant());

                if (diasEntre >= diasNotificacao) {
                    flag = true;
                }
            }

            conn.close();

            return flag;
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "clienteExcedeDiasNotificacao", JOptionPane.WARNING_MESSAGE);
        } catch (ParseException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "clienteExcedeDiasNotificacao", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    public static boolean deleteCompra(Compra compra) {
        try {
            Connection conn = DriverManager.getConnection(DAOPaths.dbPath);
            String sql = "INSERT INTO compraExcluida(idCompra, idCliente, idAtendente, valor, data, observacao, estaPago, entrega, entregaValidada) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String data = sdf.format(compra.getData().getTime());

            ps.setInt(1, compra.getIdCompra());
            ps.setInt(2, compra.getIdCliente());
            ps.setInt(3, compra.getIdAtendente());
            ps.setFloat(4, compra.getValor());
            ps.setString(5, data);
            ps.setString(6, compra.getObservacao());
            ps.setInt(7, compra.isEstaPago() ? 1 : 0);
            ps.setInt(8, compra.isEntrega() ? 1 : 0);
            ps.setInt(9, compra.isEntregaValidada() ? 1 : 0);
            
            ps.executeUpdate();
            
            
            sql = "DELETE FROM compra WHERE idCompra = ?";
            ps = conn.prepareStatement(sql);
            
            ps.setInt(1, compra.getIdCompra());

            ps.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "deleteCompra", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
    
    public static Compra selectCompra(int idCompra){
        try {
            Connection conn = DriverManager.getConnection(DAOPaths.dbPath);
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM compra WHERE idCompra = " + String.valueOf(idCompra));

            Compra compra;
            if (rs.next()){
                compra = extractCompraFromRs(rs);
            }else{
                return null;
            }

            conn.close();

            return compra;
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "selectCompra", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }
    
    public static boolean updateValidarEntrega(int idAtendente, int idCompra){
        try {
            Connection conn = DriverManager.getConnection(DAOPaths.dbPath);
            String sql = "UPDATE compra SET idAtendente = ?, entregaValidada = 1 WHERE idCompra = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, idAtendente);
            ps.setInt(2, idCompra);

            ps.executeUpdate();

            conn.close();
            
            return true;
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "updateValidarCompra", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

}
