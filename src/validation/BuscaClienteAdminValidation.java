package validation;

import java.awt.Component;
import java.util.HashMap;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class BuscaClienteAdminValidation {

    private JRadioButton nomeClienteRadioButton, idClienteRadioButton;
    private JTextField campoBuscaNomeId, campoBuscaValor, campoDiasNotificacao;
    private JComboBox buscaValorComboBox;
    private JCheckBox checkBoxClienteSim, checkBoxClienteNao;

    public BuscaClienteAdminValidation(JPanel panel) {
        Component[] components = panel.getComponents();
        HashMap componentMap = new HashMap<String, Component>();
        for (int i = 0; i < components.length; i++) {
            componentMap.put(components[i].getName(), components[i]);
        }

        nomeClienteRadioButton = (JRadioButton) componentMap.get("nomeClienteRadioButton");
        idClienteRadioButton = (JRadioButton) componentMap.get("idClienteRadioButton");

        campoBuscaNomeId = (JTextField) componentMap.get("campoBuscaNomeId");
        campoBuscaValor = (JTextField) componentMap.get("campoBuscaValor");
        campoDiasNotificacao = (JTextField) componentMap.get("campoDiasNotificacao");

        buscaValorComboBox = (JComboBox) componentMap.get("buscaValorComboBox");

        checkBoxClienteSim = (JCheckBox) componentMap.get("checkBoxClienteSim");
        checkBoxClienteNao = (JCheckBox) componentMap.get("checkBoxClienteNao");
    }

    public boolean validate() {
        return (validarCampoNomeOuId()
                && validarCampoValor()
                && validarCampoDiasNotificacoes()
                && validarCheckBoxesBloqueio()
        );
    }

    private boolean validarCampoNomeOuId() {
        if (idClienteRadioButton.isSelected() && !campoBuscaNomeId.getText().isEmpty()) {
            try {
                Integer.parseInt(campoBuscaNomeId.getText());
                return true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "O campo de ID precisa ser um número", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        } else {
            return true;
        }
    }

    private boolean validarCampoValor() {
        if (!campoBuscaValor.getText().isEmpty()) {
            try {
                Float.parseFloat(campoBuscaValor.getText());
                return true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "O campo de valor só pode conter números", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        } else {
            return true;
        }
    }

    private boolean validarCampoDiasNotificacoes() {
        if (!campoDiasNotificacao.getText().isEmpty()) {
            try {
                Integer.parseInt(campoDiasNotificacao.getText());
                return true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "O campo de dias para notificação só pode conter números", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        } else {
            return true;
        }
    }

    private boolean validarCheckBoxesBloqueio() {
        if (checkBoxClienteSim.isSelected() || checkBoxClienteNao.isSelected()) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Favor selecionar pelo menos uma das opções sobre bloqueio", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

}
