package validation;

import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BuscaComprasFormValidation {

    JFormattedTextField campoDataDe, campoDataAte;
    JComboBox<String> comboBoxValor;
    JTextField campoValor1, campoValor2;
    JCheckBox checkBoxPagoSim, checkBoxPagoNao, checkBoxEntregaSim, checkBoxEntregaNao;

    public BuscaComprasFormValidation(JPanel panel) {
        Component[] panels = panel.getComponents();
        ArrayList<Component> components = new ArrayList<>();
        for (Component p : panels) {
            if (p instanceof JPanel) {
                for (Component c : ((JPanel) p).getComponents()) {
                    components.add(c);
                }
            }
        }

        HashMap componentMap = new HashMap<String, Component>();
        for (int i = 0; i < components.size(); i++) {
            componentMap.put(components.get(i).getName(), components.get(i));
        }

        campoDataDe = (JFormattedTextField) componentMap.get("campoDataDe");
        campoDataAte = (JFormattedTextField) componentMap.get("campoDataAte");
        comboBoxValor = (JComboBox<String>) componentMap.get("comboBoxValor");
        campoValor1 = (JTextField) componentMap.get("campoValor1");
        campoValor2 = (JTextField) componentMap.get("campoValor2");
        checkBoxPagoSim = (JCheckBox) componentMap.get("checkBoxPagoSim");
        checkBoxPagoNao = (JCheckBox) componentMap.get("checkBoxPagoNao");
        checkBoxEntregaSim = (JCheckBox) componentMap.get("checkBoxEntregaSim");
        checkBoxEntregaNao = (JCheckBox) componentMap.get("checkBoxEntregaNao");
    }

    public boolean validate() {
        return (validateDates()
                && validateValores()
                && validadePagoCheckBoxes()
                && validadeEntregaCheckBoxes());
    }

    public boolean datasVazias() {
        String de = campoDataDe.getText();
        de = de.replace("/", "").trim();

        String ate = campoDataAte.getText();
        ate = ate.replace("/", "").trim();

        return de.isEmpty() && ate.isEmpty();
    }

    public boolean dataDeVazia() {
        String de = campoDataDe.getText();
        de = de.replace("/", "").trim();

        return de.isEmpty();
    }

    public boolean dataAteVazia() {
        String ate = campoDataAte.getText();
        ate = ate.replace("/", "").trim();

        return ate.isEmpty();
    }

    public boolean valoresVazios() {
        return campoValor1.getText().isEmpty() && campoValor2.getText().isEmpty();
    }

    public boolean valor1Vazio() {
        return campoValor1.getText().isEmpty();
    }

    public boolean valor2Vazio() {
        return campoValor2.getText().isEmpty();
    }

    private boolean validateDates() {
        if (datasVazias()) {
            return true;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                if (!dataDeVazia()) {
                    sdf.parse(campoDataDe.getText());
                }
                if (!dataAteVazia()) {
                    sdf.parse(campoDataAte.getText());
                }
                return true;
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Pelo menos uma das datas está incorreta", "Atenção", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }
    }

    private boolean validateValores() {
        if (valoresVazios()) {
            return true;
        } else {
            if (comboBoxValor.getSelectedIndex() == 2) {
                String valor1 = campoValor1.getText();
                String valor2 = campoValor2.getText();

                valor1 = valor1.replaceAll(",", ".");
                valor2 = valor2.replaceAll(",", ".");

                try {
                    Float.parseFloat(valor1);
                    Float.parseFloat(valor2);
                    return true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "O formato de pelo menos uma dos valores está incorreto", "Atenção", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            }else{
                String valor1 = campoValor1.getText();

                valor1 = valor1.replaceAll(",", ".");

                try {
                    Float.parseFloat(valor1);
                    return true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "O formato de pelo menos uma dos valores está incorreto", "Atenção", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            }
        }
    }

    private boolean validadePagoCheckBoxes() {
        if (checkBoxPagoSim.isSelected() || checkBoxPagoNao.isSelected()) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Você precisa informar se deseja buscar por compras pagas ou não", "Atenção", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
    private boolean validadeEntregaCheckBoxes() {
        if (checkBoxEntregaSim.isSelected() || checkBoxEntregaNao.isSelected()) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Você precisa informar se deseja buscar por entregas ou não", "Atenção", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
}
