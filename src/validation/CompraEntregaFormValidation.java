package validation;

import dao.AtendenteDAO;
import dao.ClienteDAO;
import java.awt.Component;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import models.Cliente;
import security.Hash;

public class CompraEntregaFormValidation {

    JTextField valor;
    JComboBox<String> atendentesComboBox;

    Cliente cliente;

    public CompraEntregaFormValidation(JPanel panel, Cliente cliente) {
        this.cliente = cliente;

        Component[] components = panel.getComponents();
        HashMap componentMap = new HashMap<String, Component>();
        for (int i = 0; i < components.length; i++) {
            componentMap.put(components[i].getName(), components[i]);
        }

        valor = (JTextField) componentMap.get("valor");
        atendentesComboBox = (JComboBox<String>) componentMap.get("atendentesComboBox");
    }

    public boolean validate() {
        return (!temCampoVazio()
                && validarCampoValor());

    }

    private boolean temCampoVazio() {
        if (valor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor preencher todos os campos obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE);
            return true;
        } else {
            return false;
        }
    }

    private boolean validarCampoValor() {
        String valor = this.valor.getText();
        valor = valor.replaceAll(",", ".");

        try {
            Float.parseFloat(valor);
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O valor da compra é inválido", "Atenção", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
}
