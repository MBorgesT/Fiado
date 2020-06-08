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
import models.Pagamento;

public class PagamentoDAO {

    private static Pagamento extractPagamentoFromRs(ResultSet rs) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Calendar data = Calendar.getInstance();
            data.setTime(sdf.parse(rs.getString("data")));

            return new Pagamento(
                    rs.getInt("idPagamento"),
                    rs.getInt("idCliente"),
                    rs.getInt("idAtendente"),
                    rs.getFloat("valor"),
                    data,
                    rs.getString("observacao")
            );
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "extractPagamentoFromRs", JOptionPane.WARNING_MESSAGE);
        } catch (ParseException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "extractPagamentoFromRs", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    public static int insertPagamento(Pagamento pagamento) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/matheus/NetBeansProjects/Fiado/src/dao/fiado.db");
            String sql = "INSERT INTO pagamento(idCliente, idAtendente, valor, data, observacao) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String data = sdf.format(pagamento.getData().getTime());

            ps.setInt(1, pagamento.getIdCliente());
            ps.setInt(2, pagamento.getIdAtendente());
            ps.setFloat(3, pagamento.getValor());
            ps.setString(4, data);
            ps.setString(5, pagamento.getObservacao());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            int insertedId;
            if (rs.next()) {
                insertedId = rs.getInt(1);
            } else {
                insertedId = 0;
            }

            conn.close();

            JOptionPane.showMessageDialog(null, "Pagamento efetuado com sucesso", "Atenção", JOptionPane.INFORMATION_MESSAGE);

            return insertedId;
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "insertPagamento", JOptionPane.WARNING_MESSAGE);
        }
        return 0;
    }

    public static ArrayList<Pagamento> selectPagamentosFromCliente(int idCliente) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/matheus/NetBeansProjects/Fiado/src/dao/fiado.db");
            Statement stmt = conn.createStatement();

            ArrayList<Pagamento> arrayPagamentos = new ArrayList<>();

            ResultSet rs = stmt.executeQuery("SELECT * FROM pagamento WHERE idCliente = " + String.valueOf(idCliente));

            while (rs.next()) {
                arrayPagamentos.add(extractPagamentoFromRs(rs));
            }
            
            conn.close();
            
            return arrayPagamentos;
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "selectPagamentosFromCliente", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

}
