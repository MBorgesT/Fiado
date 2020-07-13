package validation;

import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class RelatorioValidation {

    private JFormattedTextField dataDe, dataAte;

    public RelatorioValidation(JPanel panel) {
        Component[] components = panel.getComponents();
        HashMap componentMap = new HashMap<String, Component>();
        for (int i = 0; i < components.length; i++) {
            componentMap.put(components[i].getName(), components[i]);
        }

        dataDe = (JFormattedTextField) componentMap.get("dataDe");
        dataAte = (JFormattedTextField) componentMap.get("dataAte");
    }

    public boolean validate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(dataDe.getText());
            sdf.parse(dataAte.getText());
            
            return true;
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Pelo menos uma das datas está incorreta", "Atenção", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

}
