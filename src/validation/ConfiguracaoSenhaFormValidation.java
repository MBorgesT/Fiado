/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import java.awt.Component;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class ConfiguracaoSenhaFormValidation {

    private JPasswordField senha, confirmarSenha;

    public ConfiguracaoSenhaFormValidation(JPanel panel) {
        Component[] components = panel.getComponents();
        HashMap componentMap = new HashMap<String, Component>();
        for (int i = 0; i < components.length; i++) {
            componentMap.put(components[i].getName(), components[i]);
        }

        senha = (JPasswordField) componentMap.get("senha");
        confirmarSenha = (JPasswordField) componentMap.get("confirmarSenha");
    }

    public boolean validate() {
        return (senhasSaoIguais()
                && validarSenhaTamanho()
        );
    }

    private boolean senhasSaoIguais() {
        if (String.valueOf(senha.getPassword()).equals(String.valueOf(confirmarSenha.getPassword()))) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "As senhas informadas não são iguais", "Atenção", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    private boolean validarSenhaTamanho() {
        String senha = String.valueOf(this.senha.getPassword());

        if (senha.length() >= 8) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "As senhas precisam ter entre 6 e 8 dígitos", "Atenção", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
}
