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
import models.Atendente;
import models.Cliente;
import security.Hash;

public class CompraFormValidation {

    JTextField valor;
    JComboBox<String> atendentesComboBox;
    JPasswordField senhaAtendente, senhaCliente;

    Cliente cliente;
    Atendente atendente;

    public CompraFormValidation(JPanel panel, Cliente cliente, Atendente atendente) {
        this.cliente = cliente;
        this.atendente = atendente;

        Component[] components = panel.getComponents();
        HashMap componentMap = new HashMap<String, Component>();
        for (int i = 0; i < components.length; i++) {
            componentMap.put(components[i].getName(), components[i]);
        }

        valor = (JTextField) componentMap.get("valor");
        atendentesComboBox = (JComboBox<String>) componentMap.get("atendentesComboBox");
        senhaAtendente = (JPasswordField) componentMap.get("senhaAtendente");
        senhaCliente = (JPasswordField) componentMap.get("senhaCliente");
    }

    public boolean validate() {
        return (!temCampoVazio()
                && validarCampoValor()
                && validarSenhaAtendente()
                && validarSenhaCliente());

    }

    private boolean temCampoVazio() {
        if (valor.getText().isEmpty()
                || atendentesComboBox.getSelectedIndex() == -1
                || String.valueOf(senhaAtendente.getPassword()).isEmpty()
                || String.valueOf(senhaCliente.getPassword()).isEmpty()) {
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

    private boolean validarSenhaCliente() {
        boolean isCorrect = Hash.verifyPassword(String.valueOf(senhaCliente.getPassword()), cliente.getSenha(), cliente.getSalt());
        if (isCorrect) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "A senha do cliente está incorreta", "Atenção", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    private boolean validarSenhaAtendente() {
        boolean isCorrect = Hash.verifyPassword(String.valueOf(senhaAtendente.getPassword()), atendente.getSenha(), atendente.getSalt());
        if (isCorrect) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "A senha do atendente está incorreta", "Atenção", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
}
