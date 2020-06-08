/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_cliente;

import dao.ClienteDAO;
import dao.CompraDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import models.Cliente;
import models.Endereco;
import security.Hash;
import validation.ClienteFormValidation;

/**
 *
 * @author matheus
 */
public class MaisInfoCliente extends javax.swing.JFrame {

    MenuPrincipal menuPrincipal;
    Cliente cliente;
    boolean editando;

    public MaisInfoCliente(MenuPrincipal menuPrincipal, Cliente cliente) {
        initComponents();

        this.menuPrincipal = menuPrincipal;
        this.cliente = cliente;
        
        editando = false;

        preencherCampos();
        alternarEditableTextFields(false);
    }

    private MaisInfoCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void preencherCampos() {
        idLabel.setText("ID: " + String.valueOf(cliente.getIdCliente()));
        nomeTextField.setText(cliente.getNome());
        telefone1TextField.setText(cliente.getTelefone1());
        telefone2TextField.setText(cliente.getTelefone2());
        cpfTextField.setText(cliente.getCpf());
        senhaTextField.setText("");
        confirmarSenhaTextField.setText("");

        Endereco endereco = cliente.getEndereco();
        logradouroTextField.setText(endereco.getLogradouro());
        numeroTextField.setText(String.valueOf(endereco.getNumero()));
        bairroTextField.setText(endereco.getBairro());
        cidadeTextField.setText(endereco.getCidade());
        referenciaTextField.setText(endereco.getReferencia());
    }

    private void alternarEditableTextFields(boolean b) {
        nomeTextField.setEditable(b);
        telefone1TextField.setEditable(b);
        telefone2TextField.setEditable(b);
        senhaTextField.setEditable(b);
        confirmarSenhaTextField.setEditable(b);

        logradouroTextField.setEditable(b);
        numeroTextField.setEditable(b);
        bairroTextField.setEditable(b);
        cidadeTextField.setEditable(b);
        referenciaTextField.setEditable(b);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idLabel = new javax.swing.JLabel();
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
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        botaoEditarInfo = new javax.swing.JButton();
        botaoHistoricoPagamentos = new javax.swing.JButton();
        botaoHistoricoCompras = new javax.swing.JButton();
        botaoCancelarEdicao = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mais Informações de Cliente");

        idLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        idLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/customer-red.png"))); // NOI18N
        idLabel.setText("ID: 1234");

        formPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        cpfTextField.setEditable(false);
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

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 51, 51));
        jLabel14.setText("*");

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 51, 51));
        jLabel15.setText("*");

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

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("A senha deve conter entre 6 e 8");

        jLabel23.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 51, 51));
        jLabel23.setText("caracteres e conter somente números");

        javax.swing.GroupLayout formPanelLayout = new javax.swing.GroupLayout(formPanel);
        formPanel.setLayout(formPanelLayout);
        formPanelLayout.setHorizontalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addComponent(referenciaTextField)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formPanelLayout.createSequentialGroup()
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nomeTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, formPanelLayout.createSequentialGroup()
                                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(formPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15))
                                    .addComponent(telefone1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(telefone2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(formPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(cpfTextField))))
                        .addGap(12, 12, 12))
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
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel23))
                            .addGroup(formPanelLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel1)))
                        .addGap(0, 29, Short.MAX_VALUE))
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
                            .addGroup(formPanelLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14))
                            .addComponent(jLabel11)
                            .addGroup(formPanelLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        formPanelLayout.setVerticalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formPanelLayout.createSequentialGroup()
                                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(telefone1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(formPanelLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(telefone2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cpfTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senhaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmarSenhaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(referenciaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botaoEditarInfo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoEditarInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.png"))); // NOI18N
        botaoEditarInfo.setText("Editar Informações");
        botaoEditarInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarInfoActionPerformed(evt);
            }
        });

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

        botaoCancelarEdicao.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoCancelarEdicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
        botaoCancelarEdicao.setText("Cancelar Edição");
        botaoCancelarEdicao.setEnabled(false);
        botaoCancelarEdicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarEdicaoActionPerformed(evt);
            }
        });

        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("* Campos obrigatórios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(idLabel)
                        .addGap(324, 324, 324)
                        .addComponent(jLabel13))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(formPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botaoEditarInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botaoCancelarEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botaoHistoricoPagamentos, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(botaoHistoricoCompras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel13)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(formPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoEditarInfo)
                        .addGap(18, 18, 18)
                        .addComponent(botaoCancelarEdicao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoHistoricoCompras)
                        .addGap(18, 18, 18)
                        .addComponent(botaoHistoricoPagamentos)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoEditarInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarInfoActionPerformed
        if (editando) {
            String[] options = {"SIM", "NÃO"};
            int reply = JOptionPane.showOptionDialog(null, "Você realmente deseja salvar as alterações?", "Alterações",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                    options, options[0]);

            if (reply == 0) {
                if (new ClienteFormValidation(formPanel, cliente).validate()) {
                    byte[] salt = cliente.getSalt();
                    String hashedPw = Hash.hashPassword(String.valueOf(senhaTextField.getPassword()), salt).get();

                    Endereco e = cliente.getEndereco();
                    e.setNumero(Integer.parseInt(numeroTextField.getText()));
                    e.setLogradouro(logradouroTextField.getText().toUpperCase());
                    e.setBairro(bairroTextField.getText().toUpperCase());
                    e.setCidade(cidadeTextField.getText().toUpperCase());
                    e.setReferencia(referenciaTextField.getText().toUpperCase());

                    cliente.setEndereco(e);
                    cliente.setNome(nomeTextField.getText().toUpperCase());
                    cliente.setTelefone1(telefone1TextField.getText().toUpperCase());
                    cliente.setTelefone2(telefone2TextField.getText().toUpperCase());
                    cliente.setCpf(cpfTextField.getText().toUpperCase());
                    cliente.setSenha(hashedPw);

                    ClienteDAO.updateCliente(cliente);

                    botaoCancelarEdicao.doClick();

                    editando = false;
                }
            }
        } else {
            editando = true;

            alternarEditableTextFields(true);

            botaoEditarInfo.setIcon(new ImageIcon(getClass().getResource("/icons/save-alterations.png")));
            botaoEditarInfo.setText("Salvar Alterações");

            botaoCancelarEdicao.setEnabled(true);
            botaoHistoricoCompras.setEnabled(false);
            botaoHistoricoPagamentos.setEnabled(false);
        }
    }//GEN-LAST:event_botaoEditarInfoActionPerformed

    private void botaoCancelarEdicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarEdicaoActionPerformed
        editando = false;

        alternarEditableTextFields(false);

        botaoEditarInfo.setIcon(new ImageIcon(getClass().getResource("/icons/edit.png")));
        botaoEditarInfo.setText("Editar Alterações");

        botaoCancelarEdicao.setEnabled(false);
        botaoHistoricoCompras.setEnabled(true);
        botaoHistoricoPagamentos.setEnabled(true);

        preencherCampos();
    }//GEN-LAST:event_botaoCancelarEdicaoActionPerformed

    private void botaoHistoricoComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoHistoricoComprasActionPerformed
        new HistoricoCompras(CompraDAO.selectComprasFromCliente(cliente.getIdCliente()), cliente).setVisible(true);
    }//GEN-LAST:event_botaoHistoricoComprasActionPerformed

    private void botaoHistoricoPagamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoHistoricoPagamentosActionPerformed
        new HistoricoPagamentos(cliente).setVisible(true);
    }//GEN-LAST:event_botaoHistoricoPagamentosActionPerformed

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
            java.util.logging.Logger.getLogger(MaisInfoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MaisInfoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MaisInfoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MaisInfoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MaisInfoCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bairroTextField;
    private javax.swing.JButton botaoCancelarEdicao;
    private javax.swing.JButton botaoEditarInfo;
    private javax.swing.JButton botaoHistoricoCompras;
    private javax.swing.JButton botaoHistoricoPagamentos;
    private javax.swing.JTextField cidadeTextField;
    private javax.swing.JPasswordField confirmarSenhaTextField;
    private javax.swing.JFormattedTextField cpfTextField;
    private javax.swing.JPanel formPanel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField logradouroTextField;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JTextField numeroTextField;
    private javax.swing.JTextField referenciaTextField;
    private javax.swing.JPasswordField senhaTextField;
    private javax.swing.JTextField telefone1TextField;
    private javax.swing.JTextField telefone2TextField;
    // End of variables declaration//GEN-END:variables
}
