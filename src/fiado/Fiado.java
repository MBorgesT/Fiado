package fiado;

import gui.MenuPrincipal;
import java.sql.SQLException;
import security.Hash;
import dao.ClienteDAO;
import gui.HistoricoCompras;
import gui.NovaCompra;
import validation.CompraFormValidation;

public class Fiado {

    public static void main(String[] args) throws SQLException {
        new MenuPrincipal().setVisible(true);
    }
    
}
