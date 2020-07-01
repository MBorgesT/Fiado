/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_admin;

import dao.AtendenteDAO;
import dao.ClienteDAO;
import gui_cliente.*;
import dao.CompraDAO;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import models.Atendente;
import models.Cliente;
import models.Endereco;

/**
 *
 * @author matheus
 */
public class MaisInfoClienteAdmin extends javax.swing.JFrame {

    Cliente cliente;
    ArrayList<Atendente> atendentesNoComboBox;
    boolean editando;

    public MaisInfoClienteAdmin(Cliente cliente) {
        initComponents();

        this.cliente = cliente;

        editando = false;

        preencherCampos();
    }

    private MaisInfoClienteAdmin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void preencherCampos() {
        idLabel.setText("ID: " + String.valueOf(cliente.getIdCliente()));
        nomeTextField.setText(cliente.getNome());
        telefone1TextField.setText(cliente.getTelefone1());
        telefone2TextField.setText(cliente.getTelefone2());
        cpfTextField.setText(cliente.getCpf());

        Endereco endereco = cliente.getEndereco();
        logradouroTextField.setText(endereco.getLogradouro());
        numeroTextField.setText(String.valueOf(endereco.getNumero()));
        bairroTextField.setText(endereco.getBairro());
        cidadeTextField.setText(endereco.getCidade());
        referenciaTextField.setText(endereco.getReferencia());

        atendentesNoComboBox = AtendenteDAO.selectTodosAtendentesAtivos();
        for (Atendente atendente : atendentesNoComboBox) {
            comboBoxAtendente.addItem(atendente.getNome());
        }

        if (cliente.isAtendente()) {
            atendenteSimRadioButton.setSelected(true);
            for (int i = 0; i < atendentesNoComboBox.size(); i++) {
                if (cliente.getIdAtendente() == atendentesNoComboBox.get(i).getIdAtendente()) {
                    comboBoxAtendente.setSelectedIndex(i);
                }
            }
        } else {
            atendenteNaoRadioButton.setSelected(true);
            comboBoxAtendente.setSelectedIndex(-1);
            labelQuem.setVisible(false);
            comboBoxAtendente.setVisible(false);
        }
    }
    
    private boolean validarAlteracaoAtendente() {
        if (atendenteNaoRadioButton.isSelected()){
            return true;
        } else {
            int idAtendente = atendentesNoComboBox.get(comboBoxAtendente.getSelectedIndex()).getIdAtendente();
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

        atendenteButtonGroup = new javax.swing.ButtonGroup();
        idLabel = new javax.swing.JLabel();
        formPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        nomeTextField = new javax.swing.JTextField();
        telefone1TextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
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
        jSeparator1 = new javax.swing.JSeparator();
        cpfTextField = new javax.swing.JTextField();
        botaoHistoricoPagamentos = new javax.swing.JButton();
        botaoHistoricoCompras = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        atendenteSimRadioButton = new javax.swing.JRadioButton();
        atendenteNaoRadioButton = new javax.swing.JRadioButton();
        labelQuem = new javax.swing.JLabel();
        comboBoxAtendente = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        botaoAlterarAtendente = new javax.swing.JButton();
        botaoCancelarAlteracao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mais Informações de Cliente");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/icons/administrator-48.png")).getImage());

        idLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        idLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/customer-red.png"))); // NOI18N
        idLabel.setText("ID: 1234");

        formPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Nome:");

        nomeTextField.setEditable(false);
        nomeTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        nomeTextField.setName("nome"); // NOI18N

        telefone1TextField.setEditable(false);
        telefone1TextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        telefone1TextField.setName("telefone1"); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Telefone 1:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("CPF:");

        telefone2TextField.setEditable(false);
        telefone2TextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        telefone2TextField.setName("telefone2"); // NOI18N

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Telefone 2:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Logradouro:");

        logradouroTextField.setEditable(false);
        logradouroTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        logradouroTextField.setName("logradouro"); // NOI18N

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Número:");

        numeroTextField.setEditable(false);
        numeroTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        numeroTextField.setName("numero"); // NOI18N

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("Cidade:");

        cidadeTextField.setEditable(false);
        cidadeTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cidadeTextField.setName("cidade"); // NOI18N

        bairroTextField.setEditable(false);
        bairroTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        bairroTextField.setName("bairro"); // NOI18N

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("Bairro:");

        referenciaTextField.setEditable(false);
        referenciaTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        referenciaTextField.setName("referencia"); // NOI18N

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("Referência:");

        cpfTextField.setEditable(false);
        cpfTextField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout formPanelLayout = new javax.swing.GroupLayout(formPanel);
        formPanel.setLayout(formPanelLayout);
        formPanelLayout.setHorizontalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomeTextField)
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(telefone1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(telefone2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formPanelLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 124, Short.MAX_VALUE))
                            .addComponent(cpfTextField)))
                    .addComponent(jSeparator1)
                    .addComponent(referenciaTextField)
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(numeroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formPanelLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(bairroTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(cidadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(logradouroTextField)
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel11)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        formPanelLayout.setVerticalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(formPanelLayout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(telefone1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(formPanelLayout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(telefone2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cpfTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(27, 27, 27)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logradouroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numeroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bairroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cidadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(referenciaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        botaoHistoricoPagamentos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoHistoricoPagamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/payment-32.png"))); // NOI18N
        botaoHistoricoPagamentos.setText("Histórico de Pagamentos");
        botaoHistoricoPagamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoHistoricoPagamentosActionPerformed(evt);
            }
        });

        botaoHistoricoCompras.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoHistoricoCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/basket-32.png"))); // NOI18N
        botaoHistoricoCompras.setText("Histórico de Compras");
        botaoHistoricoCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoHistoricoComprasActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("É um atendente?");

        atendenteButtonGroup.add(atendenteSimRadioButton);
        atendenteSimRadioButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        atendenteSimRadioButton.setText("Sim");
        atendenteSimRadioButton.setEnabled(false);
        atendenteSimRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atendenteSimRadioButtonActionPerformed(evt);
            }
        });

        atendenteButtonGroup.add(atendenteNaoRadioButton);
        atendenteNaoRadioButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        atendenteNaoRadioButton.setText("Não");
        atendenteNaoRadioButton.setEnabled(false);
        atendenteNaoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atendenteNaoRadioButtonActionPerformed(evt);
            }
        });

        labelQuem.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labelQuem.setText("Quem?");

        comboBoxAtendente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        comboBoxAtendente.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(atendenteSimRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(atendenteNaoRadioButton)))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelQuem)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(comboBoxAtendente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelQuem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(atendenteSimRadioButton)
                    .addComponent(atendenteNaoRadioButton)
                    .addComponent(comboBoxAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botaoAlterarAtendente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoAlterarAtendente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.png"))); // NOI18N
        botaoAlterarAtendente.setText("Alterar Estado de Atendente");
        botaoAlterarAtendente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAlterarAtendenteActionPerformed(evt);
            }
        });

        botaoCancelarAlteracao.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoCancelarAlteracao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
        botaoCancelarAlteracao.setText("Cancelar Alteração");
        botaoCancelarAlteracao.setEnabled(false);
        botaoCancelarAlteracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarAlteracaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idLabel)
                    .addComponent(formPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botaoHistoricoCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoHistoricoPagamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botaoCancelarAlteracao, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoAlterarAtendente)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(idLabel)
                .addGap(6, 6, 6)
                .addComponent(formPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoHistoricoPagamentos)
                    .addComponent(botaoHistoricoCompras))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCancelarAlteracao)
                    .addComponent(botaoAlterarAtendente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoHistoricoComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoHistoricoComprasActionPerformed
        new HistoricoComprasAdmin(cliente).setVisible(true);
    }//GEN-LAST:event_botaoHistoricoComprasActionPerformed

    private void botaoHistoricoPagamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoHistoricoPagamentosActionPerformed
        new HistoricoPagamentosAdmin(cliente).setVisible(true);
    }//GEN-LAST:event_botaoHistoricoPagamentosActionPerformed

    private void botaoAlterarAtendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAlterarAtendenteActionPerformed
        if (editando) {
            String[] options = {"SIM", "NÃO"};
            int reply = JOptionPane.showOptionDialog(null, "Você realmente deseja salvar as alterações?", "Alterações",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                    options, options[0]);

            if (reply == 0 && validarAlteracaoAtendente()) {
                boolean isAtendente = atendenteSimRadioButton.isSelected();
                int idAtendente = isAtendente ? atendentesNoComboBox.get(comboBoxAtendente.getSelectedIndex()).getIdAtendente() : -1;

                if (ClienteDAO.updateEstadoAtendenteCliente(cliente.getIdCliente(), isAtendente, idAtendente)) {
                    JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso", "Atenção", JOptionPane.INFORMATION_MESSAGE);

                    editando = false;

                    cliente.setAtendente(isAtendente);
                    cliente.setIdAtendente(idAtendente);

                    botaoCancelarAlteracao.setEnabled(false);
                    atendenteSimRadioButton.setEnabled(false);
                    atendenteNaoRadioButton.setEnabled(false);
                    comboBoxAtendente.setEnabled(false);

                    botaoAlterarAtendente.setIcon(new ImageIcon(getClass().getResource("/icons/edit.png")));
                    botaoAlterarAtendente.setText("Alterar Estado de Atendente");
                } else {
                    JOptionPane.showMessageDialog(null, "Houve um erro com o banco de dados. Favor reiniciar o programa e tentar novamente", "Erro", JOptionPane.WARNING_MESSAGE);
                }
            }
        } else {
            editando = true;

            botaoAlterarAtendente.setIcon(new ImageIcon(getClass().getResource("/icons/save-alterations.png")));
            botaoAlterarAtendente.setText("Salvar Alterações");

            botaoCancelarAlteracao.setEnabled(true);
            atendenteSimRadioButton.setEnabled(true);
            atendenteNaoRadioButton.setEnabled(true);
            comboBoxAtendente.setEnabled(true);
        }
    }//GEN-LAST:event_botaoAlterarAtendenteActionPerformed

    private void botaoCancelarAlteracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarAlteracaoActionPerformed
        editando = false;
        botaoCancelarAlteracao.setEnabled(false);
        atendenteSimRadioButton.setEnabled(false);
        atendenteNaoRadioButton.setEnabled(false);
        comboBoxAtendente.setEnabled(false);

        if (cliente.isAtendente()) {
            atendenteSimRadioButton.setSelected(true);
            for (int i = 0; i < atendentesNoComboBox.size(); i++) {
                if (cliente.getIdAtendente() == atendentesNoComboBox.get(i).getIdAtendente()) {
                    comboBoxAtendente.setSelectedIndex(i);
                }
            }
        } else {
            atendenteNaoRadioButton.setSelected(true);
            comboBoxAtendente.setSelectedIndex(-1);
            labelQuem.setVisible(false);
            comboBoxAtendente.setVisible(false);
        }
        
        botaoAlterarAtendente.setIcon(new ImageIcon(getClass().getResource("/icons/edit.png")));
        botaoAlterarAtendente.setText("Alterar Estado de Atendente");
    }//GEN-LAST:event_botaoCancelarAlteracaoActionPerformed

    private void atendenteNaoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atendenteNaoRadioButtonActionPerformed
        labelQuem.setVisible(false);
        comboBoxAtendente.setVisible(false);
        comboBoxAtendente.setSelectedIndex(-1);
    }//GEN-LAST:event_atendenteNaoRadioButtonActionPerformed

    private void atendenteSimRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atendenteSimRadioButtonActionPerformed
        labelQuem.setVisible(true);
        comboBoxAtendente.setVisible(true);
        
        if (cliente.isAtendente()){
            for (int i = 0; i < atendentesNoComboBox.size(); i++) {
                if (cliente.getIdAtendente() == atendentesNoComboBox.get(i).getIdAtendente()) {
                    comboBoxAtendente.setSelectedIndex(i);
                }
            }
        }else{
            comboBoxAtendente.setSelectedIndex(-1);
        }
    }//GEN-LAST:event_atendenteSimRadioButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MaisInfoClienteAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MaisInfoClienteAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MaisInfoClienteAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MaisInfoClienteAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MaisInfoClienteAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup atendenteButtonGroup;
    private javax.swing.JRadioButton atendenteNaoRadioButton;
    private javax.swing.JRadioButton atendenteSimRadioButton;
    private javax.swing.JTextField bairroTextField;
    private javax.swing.JButton botaoAlterarAtendente;
    private javax.swing.JButton botaoCancelarAlteracao;
    private javax.swing.JButton botaoHistoricoCompras;
    private javax.swing.JButton botaoHistoricoPagamentos;
    private javax.swing.JTextField cidadeTextField;
    private javax.swing.JComboBox<String> comboBoxAtendente;
    private javax.swing.JTextField cpfTextField;
    private javax.swing.JPanel formPanel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelQuem;
    private javax.swing.JTextField logradouroTextField;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JTextField numeroTextField;
    private javax.swing.JTextField referenciaTextField;
    private javax.swing.JTextField telefone1TextField;
    private javax.swing.JTextField telefone2TextField;
    // End of variables declaration//GEN-END:variables
}
