/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_cliente;

import dao.AtendenteDAO;
import dao.ClienteDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;
import models.Atendente;
import models.Cliente;
import models.Endereco;
import security.Hash;
import validation.ClienteFormValidation;

/**
 *
 * @author matheus
 */
public class NovoCliente extends javax.swing.JFrame {

    MenuPrincipal menuPrincipal;
    ArrayList<Atendente> todosAtendentes;

    public NovoCliente(MenuPrincipal menuPrincipal) {
        initComponents();
        this.menuPrincipal = menuPrincipal;
        
        comboBoxAtendentes.setVisible(false);
        quemLabel.setVisible(false);
        asteriscoAtendente.setVisible(false);
        
        this.todosAtendentes = AtendenteDAO.selectTodosAtendentesAtivos();
        
        for (Atendente a: todosAtendentes)
            comboBoxAtendentes.addItem(a.getNome());
    }

    private NovoCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean validarAlteracaoAtendente() {
        if (radioButtonNao.isSelected()){
            return true;
        } else {
            int idAtendente = todosAtendentes.get(comboBoxAtendentes.getSelectedIndex()).getIdAtendente();
            if (ClienteDAO.atendenteJaCadastrado(idAtendente)){
                JOptionPane.showMessageDialog(null, "Este atendente já está cadastradoc como cliente", "Atenção", JOptionPane.WARNING_MESSAGE);
                return false;
            } else {
                return true;
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupIsAtendente = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        formPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        nomeTextField = new javax.swing.JTextField();
        telefone1TextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cpfTextField = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        senhaTextField = new javax.swing.JPasswordField();
        telefone2TextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        logradouroTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        numeroTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cidadeTextField = new javax.swing.JTextField();
        bairroTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        referenciaTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        confirmarSenhaTextField = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        radioButtonSim = new javax.swing.JRadioButton();
        radioButtonNao = new javax.swing.JRadioButton();
        comboBoxAtendentes = new javax.swing.JComboBox<>();
        quemLabel = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        asteriscoAtendente = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        botaoCancelar = new javax.swing.JButton();
        botaoCadastrar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/icons/basket-48.png")).getImage());
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/customer-red.png"))); // NOI18N
        jLabel1.setText("Novo Cliente");

        formPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        formPanel.setName(""); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Nome:");

        nomeTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        nomeTextField.setName("nome"); // NOI18N

        telefone1TextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        telefone1TextField.setName("telefone1"); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Telefone 1:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("CPF:");

        try {
            cpfTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cpfTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cpfTextField.setName("cpf"); // NOI18N

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Senha:");

        senhaTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        senhaTextField.setName("senha"); // NOI18N

        telefone2TextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        telefone2TextField.setName("telefone2"); // NOI18N

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Telefone 2:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Logradouro:");

        logradouroTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        logradouroTextField.setName("logradouro"); // NOI18N

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Número:");

        numeroTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        numeroTextField.setName("numero"); // NOI18N

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("Cidade:");

        cidadeTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cidadeTextField.setName("cidade"); // NOI18N

        bairroTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        bairroTextField.setName("bairro"); // NOI18N

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("Bairro:");

        referenciaTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        referenciaTextField.setName("referencia"); // NOI18N

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("Referência:");

        confirmarSenhaTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        confirmarSenhaTextField.setName("confirmarSenha"); // NOI18N

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("Confirme a senha:");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("*");

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 51, 51));
        jLabel14.setText("*");

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 51, 51));
        jLabel16.setText("*");

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 51, 51));
        jLabel17.setText("*");

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 51, 51));
        jLabel18.setText("*");

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 51, 51));
        jLabel19.setText("*");

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 51, 51));
        jLabel20.setText("*");

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 51, 51));
        jLabel21.setText("*");

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 51, 51));
        jLabel22.setText("*");

        jLabel23.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 51, 51));
        jLabel23.setText("A senha deve ter entre 6 e 8");

        jLabel24.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 51, 51));
        jLabel24.setText("caracteres e conter somente números");

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel25.setText("É um atendente?");

        buttonGroupIsAtendente.add(radioButtonSim);
        radioButtonSim.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        radioButtonSim.setText("Sim");
        radioButtonSim.setName("radioButtonSim"); // NOI18N
        radioButtonSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonSimActionPerformed(evt);
            }
        });

        buttonGroupIsAtendente.add(radioButtonNao);
        radioButtonNao.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        radioButtonNao.setSelected(true);
        radioButtonNao.setText("Não");
        radioButtonNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonNaoActionPerformed(evt);
            }
        });

        comboBoxAtendentes.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        comboBoxAtendentes.setName("comboBoxAtendentes"); // NOI18N

        quemLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        quemLabel.setText("Quem?");

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 51, 51));
        jLabel26.setText("*");

        asteriscoAtendente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        asteriscoAtendente.setForeground(new java.awt.Color(255, 51, 51));
        asteriscoAtendente.setText("*");

        javax.swing.GroupLayout formPanelLayout = new javax.swing.GroupLayout(formPanel);
        formPanel.setLayout(formPanelLayout);
        formPanelLayout.setHorizontalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formPanelLayout.createSequentialGroup()
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nomeTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, formPanelLayout.createSequentialGroup()
                                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(formPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(telefone1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(telefone2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(formPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel16)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(cpfTextField))))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formPanelLayout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formPanelLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20))
                            .addComponent(numeroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formPanelLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(bairroTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formPanelLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel22))
                            .addComponent(cidadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formPanelLayout.createSequentialGroup()
                        .addComponent(logradouroTextField)
                        .addContainerGap())
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addGroup(formPanelLayout.createSequentialGroup()
                                .addComponent(radioButtonSim)
                                .addGap(18, 18, 18)
                                .addComponent(radioButtonNao)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26)
                        .addGap(30, 30, 30)
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formPanelLayout.createSequentialGroup()
                                .addComponent(quemLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(asteriscoAtendente)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(formPanelLayout.createSequentialGroup()
                                .addComponent(comboBoxAtendentes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formPanelLayout.createSequentialGroup()
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(referenciaTextField))
                        .addContainerGap())
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formPanelLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13))
                            .addComponent(jLabel11)
                            .addGroup(formPanelLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19))
                            .addGroup(formPanelLayout.createSequentialGroup()
                                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(formPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel17))
                                    .addComponent(senhaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(formPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel18))
                                    .addComponent(confirmarSenhaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addGroup(formPanelLayout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabel23)))))
                        .addContainerGap(35, Short.MAX_VALUE))))
        );
        formPanelLayout.setVerticalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formPanelLayout.createSequentialGroup()
                                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(telefone1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(formPanelLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(telefone2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cpfTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senhaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmarSenhaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logradouroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numeroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bairroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cidadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(referenciaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(quemLabel)
                    .addComponent(jLabel26)
                    .addComponent(asteriscoAtendente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioButtonNao, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(radioButtonSim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboBoxAtendentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        botaoCancelar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        botaoCadastrar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ok.png"))); // NOI18N
        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 51, 51));
        jLabel15.setText("* Campos Obrigatórios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(formPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCadastrar)
                    .addComponent(botaoCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed
        if (new ClienteFormValidation(formPanel).validate()) {
            byte[] salt = Hash.generateSalt();
            String hashedPw = Hash.hashPassword(String.valueOf(senhaTextField.getPassword()), salt).get();

            Endereco e = new Endereco(
                    Integer.parseInt(numeroTextField.getText()),
                    logradouroTextField.getText().toUpperCase(),
                    bairroTextField.getText().toUpperCase(),
                    cidadeTextField.getText().toUpperCase(),
                    referenciaTextField.getText().toUpperCase()
            );
            
            boolean isAtendente = false;
            int idAtendente = 0;
            if (radioButtonSim.isSelected()){
                isAtendente = true;
                int indexComboBox = comboBoxAtendentes.getSelectedIndex();
                idAtendente = todosAtendentes.get(indexComboBox).getIdAtendente();
            }

            Cliente c = new Cliente(
                    nomeTextField.getText().toUpperCase(),
                    telefone1TextField.getText().toUpperCase(),
                    telefone2TextField.getText().toUpperCase(),
                    cpfTextField.getText().toUpperCase(),
                    hashedPw,
                    salt,
                    e,
                    true,
                    isAtendente,
                    isAtendente ? idAtendente : -1
            );

            if (ClienteDAO.insertCliente(c) == false) {
                JOptionPane.showMessageDialog(null, "Houve um erro com o banco de dados. Favor reiniciar o programa e tentar novamente", "Erro", JOptionPane.WARNING_MESSAGE);
            } else {
                menuPrincipal.resetTabelaClientes();
                this.dispose();
            }
        } else {
            System.out.println("nao validou cadastro cliente");
        }
    }//GEN-LAST:event_botaoCadastrarActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void radioButtonSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonSimActionPerformed
        comboBoxAtendentes.setVisible(true);
        quemLabel.setVisible(true);
        asteriscoAtendente.setVisible(true);
    }//GEN-LAST:event_radioButtonSimActionPerformed

    private void radioButtonNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonNaoActionPerformed
        comboBoxAtendentes.setSelectedIndex(-1);
        
        comboBoxAtendentes.setVisible(false);
        quemLabel.setVisible(false);
        asteriscoAtendente.setVisible(false);
    }//GEN-LAST:event_radioButtonNaoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NovoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NovoCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel asteriscoAtendente;
    private javax.swing.JTextField bairroTextField;
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.ButtonGroup buttonGroupIsAtendente;
    private javax.swing.JTextField cidadeTextField;
    private javax.swing.JComboBox<String> comboBoxAtendentes;
    private javax.swing.JPasswordField confirmarSenhaTextField;
    private javax.swing.JFormattedTextField cpfTextField;
    private javax.swing.JPanel formPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField logradouroTextField;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JTextField numeroTextField;
    private javax.swing.JLabel quemLabel;
    private javax.swing.JRadioButton radioButtonNao;
    private javax.swing.JRadioButton radioButtonSim;
    private javax.swing.JTextField referenciaTextField;
    private javax.swing.JPasswordField senhaTextField;
    private javax.swing.JTextField telefone1TextField;
    private javax.swing.JTextField telefone2TextField;
    // End of variables declaration//GEN-END:variables
}
