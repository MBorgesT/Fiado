package validation;

import java.awt.Component;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import models.Atendente;
import models.Cliente;
import security.Hash;

public class PagarComprasValidation {

    private JPasswordField campoSenhaCliente, campoSenhaAtendente;
    private Cliente cliente;
    private Atendente atendente;

    public PagarComprasValidation(JPanel panel, Cliente cliente, Atendente atendente) {
        this.cliente = cliente;
        this.atendente = atendente;

        Component[] components = panel.getComponents();
        HashMap componentMap = new HashMap<String, Component>();
        for (int i = 0; i < components.length; i++) {
            componentMap.put(components[i].getName(), components[i]);
        }

        campoSenhaCliente = (JPasswordField) componentMap.get("campoSenhaCliente");
        campoSenhaAtendente = (JPasswordField) componentMap.get("campoSenhaAtendente");
    }

    public boolean validate(){
        return (!temCamposVazios()
                && validarSenhaCliente()
                && validarSenhaCliente()
        );
    }
    
    private boolean temCamposVazios(){
        if (String.valueOf(campoSenhaCliente.getPassword()).isEmpty() || String.valueOf(campoSenhaAtendente.getPassword()).isEmpty()){
            JOptionPane.showMessageDialog(null, "Favor preencher todos os campos obrigatórios", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }else{
            return false;
        }
    }
    
    private boolean validarSenhaCliente() {
        boolean isCorrect = Hash.verifyPassword(String.valueOf(campoSenhaCliente.getPassword()), cliente.getSenha(), cliente.getSalt());
        if (isCorrect) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "A senha do cliente está incorreta", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    private boolean validarSenhaAtendente() {
        boolean isCorrect = Hash.verifyPassword(String.valueOf(campoSenhaAtendente.getPassword()), atendente.getSenha(), atendente.getSalt());
        if (isCorrect) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "A senha do atendente está incorreta", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

}
