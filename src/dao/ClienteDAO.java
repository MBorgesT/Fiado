package dao;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Cliente;
import models.Endereco;

public class ClienteDAO {

    private static Cliente extractClienteFromRs(ResultSet rs) {
        try {
            Connection conn = DriverManager.getConnection(DAOPaths.dbPath);

            PreparedStatement enderecoStmt = conn.prepareStatement("SELECT * FROM endereco WHERE idEndereco = ?");
            ResultSet enderecoRs;
            Endereco endereco;

            int idEndereco = rs.getInt("idEndereco");
            enderecoStmt.setInt(1, idEndereco);
            enderecoRs = enderecoStmt.executeQuery();
            endereco = new Endereco(
                    enderecoRs.getInt("idEndereco"),
                    enderecoRs.getInt("numero"),
                    enderecoRs.getString("logradouro"),
                    enderecoRs.getString("bairro"),
                    enderecoRs.getString("cidade"),
                    enderecoRs.getString("referencia")
            );

            int ativo = rs.getInt("ativo");
            boolean isAtivo;
            if (ativo == 1) {
                isAtivo = true;
            } else {
                isAtivo = false;
            }

            int atendente = rs.getInt("atendente");
            boolean isAtendente;
            if (atendente == 1) {
                isAtendente = true;
            } else {
                isAtendente = false;
            }

            conn.close();

            return (new Cliente(
                    rs.getInt("idCliente"),
                    rs.getString("nome"),
                    rs.getString("telefone1"),
                    rs.getString("telefone2"),
                    rs.getString("cpf"),
                    rs.getString("senha"),
                    rs.getBytes("salt"),
                    endereco,
                    isAtivo,
                    isAtendente,
                    rs.getInt("idAtendente")
            ));
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "extractClienteFromRs", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    public static ArrayList selectAllClientes() {
        try {
            Connection conn = DriverManager.getConnection(DAOPaths.dbPath);

            Statement stmt = conn.createStatement();
            ResultSet rs;
            ArrayList<Cliente> arrayClientes = new ArrayList<>();

            rs = stmt.executeQuery("SELECT * FROM cliente");

            while (rs.next()) {
                arrayClientes.add(extractClienteFromRs(rs));
            }

            conn.close();

            return arrayClientes;
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "selectAllClientes", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    public static boolean insertCliente(Cliente c) {
        try {
            Connection conn = DriverManager.getConnection(DAOPaths.dbPath);
            String sql = "INSERT INTO endereco(logradouro, numero, bairro, cidade, referencia) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            Endereco e = c.getEndereco();
            ps.setString(1, e.getLogradouro());
            ps.setInt(2, e.getNumero());
            ps.setString(3, e.getBairro());
            ps.setString(4, e.getCidade());
            ps.setString(5, e.getReferencia());
            ps.executeUpdate();

            int idEndereco = ps.getGeneratedKeys().getInt(1);

            sql = "INSERT INTO cliente(nome, telefone1, telefone2, cpf, idEndereco, senha, salt, ativo, atendente, idAtendente) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);

            ps.setString(1, c.getNome());
            ps.setString(2, c.getTelefone1());
            ps.setString(3, c.getTelefone2());
            ps.setString(4, c.getCpf());
            ps.setInt(5, idEndereco);
            ps.setString(6, c.getSenha());
            ps.setBytes(7, c.getSalt());
            ps.setInt(8, c.isAtivo() ? 1 : 0);
            ps.setInt(9, c.isAtendente() ? 1 : 0);
            ps.setInt(10, c.getIdAtendente());
            ps.executeUpdate();

            conn.close();

            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "Atenção", JOptionPane.INFORMATION_MESSAGE);

            return true;
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "insertCliente", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    public static boolean updateCliente(Cliente c) {
        try {
            Connection conn = DriverManager.getConnection(DAOPaths.dbPath);
            String sql = "UPDATE endereco SET logradouro = ?, numero = ?, bairro = ?, cidade = ?, referencia = ? WHERE idEndereco = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            Endereco e = c.getEndereco();
            ps.setString(1, e.getLogradouro());
            ps.setInt(2, e.getNumero());
            ps.setString(3, e.getBairro());
            ps.setString(4, e.getCidade());
            ps.setString(5, e.getReferencia());
            ps.setInt(6, e.getIdEndereco());
            ps.executeUpdate();

            sql = "UPDATE cliente SET nome = ?, telefone1 = ?, telefone2 = ?, cpf = ?, senha = ?, salt = ? WHERE idCliente = ?";
            ps = conn.prepareStatement(sql);

            int isAtivo = c.isAtivo() ? 1 : 0;
            ps.setString(1, c.getNome());
            ps.setString(2, c.getTelefone1());
            ps.setString(3, c.getTelefone2());
            ps.setString(4, c.getCpf());
            ps.setString(5, c.getSenha());
            ps.setBytes(6, c.getSalt());
            ps.setInt(7, c.getIdCliente());
            ps.executeUpdate();

            conn.close();

            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso", "Atenção", JOptionPane.INFORMATION_MESSAGE);

            return true;
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "updateCliente", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    public static boolean checarExistenciaCpf(String cpf) {
        try {
            Connection conn = DriverManager.getConnection(DAOPaths.dbPath);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT idCliente FROM cliente WHERE cpf = '" + cpf + "'");

            conn.close();

            return rs.next() == true;
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "checarExistenciaCpf", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    public static boolean checarExistenciaCpfOnUpdate(String cpf, int idCliente) {
        try {
            Connection conn = DriverManager.getConnection(DAOPaths.dbPath);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT idCliente FROM cliente WHERE cpf = '" + cpf + "' AND idCliente != " + String.valueOf(idCliente));

            conn.close();

            return rs.next() == true;
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "checarExistenciaCpfUpdate", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    public static Cliente selectClienteById(int idCliente) {
        try {
            Connection conn = DriverManager.getConnection(DAOPaths.dbPath);
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM cliente WHERE idCliente = " + String.valueOf(idCliente));

            rs.next();
            Cliente cliente = extractClienteFromRs(rs);

            conn.close();

            return cliente;
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "selectClienteById", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    public static float calcularValorEmDebito(int idCliente) {
        try {
            Connection conn = DriverManager.getConnection(DAOPaths.dbPath);
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT valor FROM compra WHERE estaPago = 0 AND idCliente = " + String.valueOf(idCliente) + " AND ((entrega = 0)  OR  (entrega = 1 AND entregaValidada = 1))");

            float valorTotal = 0;
            while (rs.next()) {
                valorTotal += rs.getFloat("valor");
            }

            conn.close();

            return valorTotal;
        } catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "calcularValorEmDebito", JOptionPane.WARNING_MESSAGE);
        }
        return 0;
    }

    public static String dataCompraNaoPagaMaisAntiga(int idCliente) {
        try {
            Connection conn = DriverManager.getConnection(DAOPaths.dbPath);
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT data FROM compra WHERE estaPago = 0 AND idCliente = " + String.valueOf(idCliente));

            ArrayList<Calendar> arrayDatas = new ArrayList<>();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            while (rs.next()) {
                Calendar data = Calendar.getInstance();
                data.setTime(sdf.parse(rs.getString("data")));
                arrayDatas.add(data);
            }

            conn.close();

            if (arrayDatas.size() == 0) {
                return "";
            } else if (arrayDatas.size() == 1) {
                return sdf.format(arrayDatas.get(0).getTime());
            } else {
                Calendar dataMaisAntiga = arrayDatas.get(0);
                for (int i = 1; i < arrayDatas.size(); i++) {
                    if (arrayDatas.get(i).before(dataMaisAntiga)) {
                        dataMaisAntiga = arrayDatas.get(i);
                    }
                }
                return sdf.format(dataMaisAntiga.getTime());
            }
        } catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "compraNaoPagaMaisAntiga", JOptionPane.WARNING_MESSAGE);
        } catch (ParseException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "compraNaoPagaMaisAntiga", JOptionPane.WARNING_MESSAGE);
        }
        return "";
    }

    public static boolean updateEstadoAtivoCliente(int idCliente, boolean isAtivo) {
        try {
            Connection conn = DriverManager.getConnection(DAOPaths.dbPath);
            String sql = "UPDATE cliente SET ativo = ? WHERE idCliente = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, isAtivo ? 1 : 0);
            ps.setInt(2, idCliente);

            ps.executeUpdate();

            conn.close();

            return true;
        } catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "updateEstadoAtivoCliente", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
    
    public static boolean updateEstadoAtendenteCliente(int idCliente, boolean isAtendente, int idAtendente){
        try {
            Connection conn = DriverManager.getConnection(DAOPaths.dbPath);
            String sql = "UPDATE cliente SET atendente = ?, idAtendente = ? WHERE idCliente = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, isAtendente ? 1 : 0);
            ps.setInt(2, idAtendente);
            ps.setInt(3, idCliente);

            ps.executeUpdate();

            conn.close();

            return true;
        } catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "updateEstadoAtendenteCliente", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    public static boolean atendenteJaCadastrado(int idAtendente) {
        try {
            Connection conn = DriverManager.getConnection(DAOPaths.dbPath);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT idCliente FROM cliente WHERE atendente = 1 AND idAtendente = " + String.valueOf(idAtendente));

            conn.close();

            return rs.next() == true;
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "atendenteJaCadastrado", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
    
    public static boolean existeComprasRelacionadas(int idCliente) {
        try {
            Connection conn = DriverManager.getConnection(DAOPaths.dbPath);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT idCompra FROM compra WHERE idCliente = " + String.valueOf(idCliente));

            conn.close();

            return rs.next() == true;
        } catch (SQLException e) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "existeComprasRelacionadas", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
    
    public static boolean deleteCliente(int idCliente){
        try {
            Connection conn = DriverManager.getConnection(DAOPaths.dbPath);
            String sql = "DELETE FROM cliente WHERE idCliente = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, idCliente);

            ps.executeUpdate();

            conn.close();

            return true;
        } catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "deleteCliente", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
}
