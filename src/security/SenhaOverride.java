package security;

import dao.DAOPaths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SenhaOverride {

    public static void main(String[] args) throws SQLException {

        Connection conn = DriverManager.getConnection(DAOPaths.dbPath);
        String sql = "UPDATE configuracao SET senha = ?, salt = ? WHERE idConfiguracao = 1";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        Scanner scanner = new Scanner(System.in);
        String novaSenha = scanner.next();
        
        byte[] salt = Hash.generateSalt();
        String hashedPw = Hash.hashPassword(novaSenha, salt).get();

        ps.setString(1, hashedPw);
        ps.setBytes(2, salt);

        ps.executeUpdate();

        conn.close();

    }

}
