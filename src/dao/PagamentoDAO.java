package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import models.Pagamento;

public class PagamentoDAO {

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
            JOptionPane.showMessageDialog(null, e, "Atenção", JOptionPane.WARNING_MESSAGE);
        }
        return 0;
    }

}
