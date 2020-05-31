package validation;

import java.awt.Component;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AtendenteFormValidation {

    JTextField nome;
    JPasswordField senha, confirmarSenha;

    public AtendenteFormValidation(JPanel panel) {
        Component[] components = panel.getComponents();
        HashMap componentMap = new HashMap<String, Component>();
        for (int i = 0; i < components.length; i++) {
            componentMap.put(components[i].getName(), components[i]);
        }

        nome = (JTextField) componentMap.get("nome");
        senha = (JPasswordField) componentMap.get("senha");
        confirmarSenha = (JPasswordField) componentMap.get("confirmarSenha");
    }

    public boolean validate() {
        return (!temCampoVazio()
                && senhasSaoIguais()
                && validarSenhaTamanho()
                && validarSenhaNumeros());
    }

    private boolean temCampoVazio() {
        if (nome.getText().isEmpty()
                || String.valueOf(senha.getPassword()).isEmpty()
                || String.valueOf(confirmarSenha.getPassword()).isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor preencher todos os campos obrigatórios", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            return false;
        }
    }

    private boolean senhasSaoIguais() {
        if (String.valueOf(senha.getPassword()).equals(String.valueOf(confirmarSenha.getPassword()))) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "As senhas informadas não são iguais", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    private boolean validarSenhaTamanho() {
        String senha = String.valueOf(this.senha.getPassword());

        if (senha.length() >= 6 && senha.length() <= 8) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "As senhas precisam ter entre 6 e 8 dígitos", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    private boolean validarSenhaNumeros() {
        String senha = String.valueOf(this.senha.getPassword());

        boolean flag = true;
        for (char c : senha.toCharArray()) {
            if (!Character.isDigit(c)) {
                flag = false;
            }
        }

        if (flag) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "As senhas só podem conter números", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
}
