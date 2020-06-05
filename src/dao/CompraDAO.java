package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
                    (rs.getInt("estaPago") == 1)
            );
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "extractCompraFromRs", JOptionPane.WARNING_MESSAGE);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, e, "extractClienteFromRs", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    public static ArrayList<Compra> selectComprasFromCliente(int idCliente) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/matheus/NetBeansProjects/Fiado/src/dao/fiado.db");
            Statement stmt = conn.createStatement();
            
            ArrayList<Compra> arrayCompras = new ArrayList<>();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM compra WHERE idCliente = " + String.valueOf(idCliente));
            
            while (rs.next()) {
                arrayCompras.add(extractCompraFromRs(rs));
            }
            
            conn.close();
            
            return arrayCompras;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "selectComprasFromCliente", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    public static int insertCompra(Compra compra){
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/matheus/NetBeansProjects/Fiado/src/dao/fiado.db");
            String sql = "INSERT INTO compra(idCliente, idAtendente, valor, data, observacao, estaPago) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String data = sdf.format(compra.getData().getTime());
            
            ps.setInt(1, compra.getIdCliente());
            ps.setInt(2, compra.getIdAtendente());
            ps.setFloat(3, compra.getValor());
            ps.setString(4, data);
            ps.setString(5, compra.getObservacao());
            ps.setInt(6, compra.isEstaPago() ? 1 : 0);
            
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
            JOptionPane.showMessageDialog(null, e, "insertCompra", JOptionPane.WARNING_MESSAGE);
        }
        return 0;
    }

    public static void updateSetPagamento(int idPagamento, int idCompra){
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/matheus/NetBeansProjects/Fiado/src/dao/fiado.db");
            String sql = "UPDATE compra SET idPagamento = ?, estaPago = 1 WHERE idCompra = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, idPagamento);
            ps.setInt(2, idCompra);
            
            ps.executeUpdate();
            
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "updateSetPagamento", JOptionPane.WARNING_MESSAGE);
        }
    }

}
