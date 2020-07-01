
package validation;

import dao.AtendenteDAO;
import dao.CompraDAO;
import java.awt.Component;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import models.Atendente;
import models.Cliente;
import models.Compra;
import security.Hash;

public class ValidarEntregaFormValidation {
    
    private JTextField idEntrega;
    private JPasswordField senhaAtendente;
    
    private Cliente cliente;
    private Atendente atendente;
    
    public ValidarEntregaFormValidation(JPanel panel, Cliente cliente, Atendente atendente) {
        this.cliente = cliente;
        this.atendente = atendente;
        
        Component[] components = panel.getComponents();
        HashMap componentMap = new HashMap<String, Component>();
        for (int i = 0; i < components.length; i++) {
            componentMap.put(components[i].getName(), components[i]);
        }

        idEntrega = (JTextField) componentMap.get("idEntrega");
        senhaAtendente = (JPasswordField) componentMap.get("senhaAtendente");
    }
    
    public boolean validate(){
        return validarIdVazio()
                && validarIdInteger()
                && validarCompraExiste()
                && validarEntregaPertenceCliente()
                && validarSenhaAtendente();
    }
    
    private boolean validarIdVazio(){
        if (idEntrega.getText().equals("")){
            JOptionPane.showMessageDialog(null, "O campo de ID da Entrega não pode estar vazio", "Atenção", JOptionPane.WARNING_MESSAGE);
            return false;
        }else{
            return true;
        }
    }
    
    private boolean validarIdInteger(){
        try {
            Integer.parseInt(idEntrega.getText());
            return true;
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "O campo de ID da Entrega só pode conter números", "Atenção", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
    private boolean validarCompraExiste(){
        Compra compra = CompraDAO.selectCompra(Integer.parseInt(idEntrega.getText()));
        if (compra != null){
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Esta entrega não existe", "Atenção", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
    private boolean validarEntregaPertenceCliente(){
        Compra compra = CompraDAO.selectCompra(Integer.parseInt(idEntrega.getText()));
        if (compra.getIdCliente() == cliente.getIdCliente()){
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Esta entrega não pertence ao cliente selecionado", "Atenção", JOptionPane.WARNING_MESSAGE);
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
