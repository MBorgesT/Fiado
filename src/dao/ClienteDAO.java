package dao;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.Cliente;
import models.Endereco;

public class ClienteDAO {

    private Cliente extractClienteFromRs(ResultSet rs) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/matheus/NetBeansProjects/Fiado/src/dao/fiado.db");

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

        conn.close();

        return (new Cliente(
                rs.getInt("idCliente"),
                rs.getString("nome"),
                rs.getString("telefone1"),
                rs.getString("telefone2"),
                rs.getString("cpf"),
                rs.getString("senha"),
                rs.getString("salt"),
                endereco,
                isAtivo
        ));
    }

    public ArrayList getAllClientes() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/matheus/NetBeansProjects/Fiado/src/dao/fiado.db");

        Statement stmt = conn.createStatement();
        ResultSet rs;
        ArrayList<Cliente> arrayClientes = new ArrayList<>();

        rs = stmt.executeQuery("SELECT * FROM cliente");

        while (rs.next()) {
            arrayClientes.add(extractClienteFromRs(rs));
        }

        conn.close();

        return arrayClientes;
    }

    public void insertCliente(Cliente c) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/matheus/NetBeansProjects/Fiado/src/dao/fiado.db");
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

        sql = "INSERT INTO cliente(nome, telefone1, telefone2, cpf, idEndereco, senha, salt, ativo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        ps = conn.prepareStatement(sql);

        int isAtivo = c.isAtivo() ? 1 : 0;
        ps.setString(1, c.getNome());
        ps.setString(2, c.getTelefone1());
        ps.setString(3, c.getTelefone2());
        ps.setString(4, c.getCpf());
        ps.setInt(5, idEndereco);
        ps.setString(6, c.getSenha());
        ps.setString(7, c.getSalt());
        ps.setInt(8, isAtivo);
        ps.executeUpdate();

        conn.close();

        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "Atenção", JOptionPane.INFORMATION_MESSAGE);
    }

    public void updateCliente(Cliente c) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/matheus/NetBeansProjects/Fiado/src/dao/fiado.db");
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

        sql = "UPDATE cliente SET nome = ?, telefone1 = ?, telefone2 = ?, cpf = ?, senha = ?, ativo = ? WHERE idCliente = ?";
        ps = conn.prepareStatement(sql);

        int isAtivo = c.isAtivo() ? 1 : 0;
        ps.setString(1, c.getNome());
        ps.setString(2, c.getTelefone1());
        ps.setString(3, c.getTelefone2());
        ps.setString(4, c.getCpf());
        ps.setString(5, c.getSenha());
        ps.setInt(6, isAtivo);
        ps.setInt(7, c.getIdCliente());
        ps.executeUpdate();

        conn.close();
        
        JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso", "Atenção", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean checarExistenciaCpf(String cpf) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/matheus/NetBeansProjects/Fiado/src/dao/fiado.db");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT idCliente FROM cliente WHERE cpf = '" + cpf + "'");

        conn.close();

        return rs.next() == true;
    }

    public boolean checarExistenciaCpfUpdate(String cpf, int idCliente) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/matheus/NetBeansProjects/Fiado/src/dao/fiado.db");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT idCliente FROM cliente WHERE cpf = '" + cpf + "' AND idCliente != " + String.valueOf(idCliente));

        conn.close();

        return rs.next() == true;
    }
    
    public boolean checarSenha(int idCliente, String hashedPw) throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/matheus/NetBeansProjects/Fiado/src/dao/fiado.db");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT senha FROM cliente WHERE idCliente = " + String.valueOf(idCliente));
        conn.close();
        
        rs.next();
        String dbPw = rs.getString("senha");
        
        if (hashedPw.equals(dbPw)) return true;
        else return false;
    }
}
