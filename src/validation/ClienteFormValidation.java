package validation;

import dao.ClienteDAO;
import java.awt.Component;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Objects;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import models.Cliente;

public class ClienteFormValidation {

    JTextField nome, telefone1, telefone2, logradouro, numero, bairro, cidade, referencia;
    JFormattedTextField cpf;
    JPasswordField senha, confirmarSenha;
    Cliente cliente;

    public ClienteFormValidation(JPanel panel) {
        cliente = null;
        
        Component[] components = panel.getComponents();
        HashMap componentMap = new HashMap<String, Component>();
        for (int i = 0; i < components.length; i++) {
            componentMap.put(components[i].getName(), components[i]);
        }

        nome = (JTextField) componentMap.get("nome");
        telefone1 = (JTextField) componentMap.get("telefone1");
        telefone2 = (JTextField) componentMap.get("telefone2");
        logradouro = (JTextField) componentMap.get("logradouro");
        numero = (JTextField) componentMap.get("numero");
        bairro = (JTextField) componentMap.get("bairro");
        cidade = (JTextField) componentMap.get("cidade");
        referencia = (JTextField) componentMap.get("referencia");

        cpf = (JFormattedTextField) componentMap.get("cpf");

        senha = (JPasswordField) componentMap.get("senha");
        confirmarSenha = (JPasswordField) componentMap.get("confirmarSenha");
    }

    public ClienteFormValidation(JPanel panel, Cliente cliente) {
        this.cliente = cliente;
        
        Component[] components = panel.getComponents();
        HashMap componentMap = new HashMap<String, Component>();
        for (int i = 0; i < components.length; i++) {
            componentMap.put(components[i].getName(), components[i]);
        }

        nome = (JTextField) componentMap.get("nome");
        telefone1 = (JTextField) componentMap.get("telefone1");
        telefone2 = (JTextField) componentMap.get("telefone2");
        logradouro = (JTextField) componentMap.get("logradouro");
        numero = (JTextField) componentMap.get("numero");
        bairro = (JTextField) componentMap.get("bairro");
        cidade = (JTextField) componentMap.get("cidade");
        referencia = (JTextField) componentMap.get("referencia");

        cpf = (JFormattedTextField) componentMap.get("cpf");

        senha = (JPasswordField) componentMap.get("senha");
        confirmarSenha = (JPasswordField) componentMap.get("confirmarSenha");
    }

    public boolean validate() {
        try {
            return (validarNumeroValorInteiro()
                    && !temCampoVazio()
                    && isCPF()
                    && podeUsarEsseCpf()
                    && senhasSaoIguais()
                    && validarSenhaTamanho()
                    && validarSenhaNumeros());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Atenção", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    private boolean validarNumeroValorInteiro() {
        try {
            Integer.parseInt(numero.getText());
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O campo de número só pode conter somente valores numéricos", "Atenção", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    private boolean temCampoVazio() {
        if (nome.getText().isEmpty()
                || telefone1.getText().isEmpty()
                || cpf.getText().isEmpty()
                || String.valueOf(senha.getPassword()).isEmpty()
                || String.valueOf(confirmarSenha.getPassword()).isEmpty()
                || logradouro.getText().isEmpty()
                || numero.getText().isEmpty()
                || bairro.getText().isEmpty()
                || cidade.getText().isEmpty()
        ) {
            JOptionPane.showMessageDialog(null, "Favor preencher todos os campos obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE);
            return true;
        } else {
            return false;
        }
    }

    private boolean isCPF() {
        String CPF = cpf.getText();
        CPF = CPF.replaceAll("\\.", "");
        CPF = CPF.replaceAll("-", "");

        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000")
                || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11)) {
            JOptionPane.showMessageDialog(null, "O CPF inserido é inválido", "Atenção", JOptionPane.WARNING_MESSAGE);
            return (false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0         
                // (48 eh a posicao de '0' na tabela ASCII)         
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48); // converte no respectivo caractere numerico
            }
            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
                return (true);
            } else {
                JOptionPane.showMessageDialog(null, "O CPF inserido é inválido", "Atenção", JOptionPane.WARNING_MESSAGE);
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    private boolean podeUsarEsseCpf() throws SQLException {
        boolean cpfEstaCadastrado;
        if (Objects.isNull(cliente)) {
            cpfEstaCadastrado = new ClienteDAO().checarExistenciaCpf(cpf.getText());
        } else {
            if (cliente.getCpf().equals(cpf.getText())){
                cpfEstaCadastrado = false;
            }else{
                cpfEstaCadastrado = new ClienteDAO().checarExistenciaCpfOnUpdate(cpf.getText(), cliente.getIdCliente());
            }
        }

        if (!cpfEstaCadastrado) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Esse CPF já está cadastrado", "Atenção", JOptionPane.WARNING_MESSAGE);
            return false;
        }
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

        if (senha.length() >= 6 && senha.length() <= 8) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "As senhas precisam ter entre 6 e 8 dígitos", "Atenção", JOptionPane.WARNING_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "As senhas só podem conter números", "Atenção", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
}
