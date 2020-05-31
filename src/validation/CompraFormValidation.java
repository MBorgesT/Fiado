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
    
    public boolean validate(){
        try {
            return (!temCampoVazio()
                    && validarCampoValor()
                    && validarSenhaAtendente()
                    && validarSenhaCliente());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Atenção", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    private boolean temCampoVazio() {
        if (valor.getText().isEmpty()
                || atendentesComboBox.getSelectedIndex() == -1
                || String.valueOf(senhaAtendente.getPassword()).isEmpty()
                || String.valueOf(senhaCliente.getPassword()).isEmpty()) {
            JOptionPane.showMessageDialog(null, "Favor preencher todos os campos obrigatórios", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            return false;
        }
    }
    
    private boolean validarCampoValor(){
        String valor = this.valor.getText();
        valor = valor.replaceAll(",",".");
        
        try{
            Float.parseFloat(valor);
            return true;
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "O valor da compra está incorreto", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
    
    private boolean validarSenhaCliente() throws SQLException{
        String hashedPw = (Hash.hashPassword(String.valueOf(senhaCliente.getPassword()), cliente.getSalt())).get();
        
        if (new ClienteDAO().checarSenha(cliente.getIdCliente(), hashedPw)){
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "A senha do cliente está incorreta", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
    
    private boolean validarSenhaAtendente() throws SQLException{
        System.out.println(atendente.getSalt());
        String hashedPw = (Hash.hashPassword(String.valueOf(senhaAtendente.getPassword()), atendente.getSalt())).get();
        
        if (new AtendenteDAO().checarSenha(atendente.getIdAtendente(), hashedPw)){
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "A senha do cliente está incorreta", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
}
