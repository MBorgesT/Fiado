package gui_cliente;

import dao.CompraDAO;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import models.Cliente;
import models.Compra;
import tCompras.TabelaCompras.ConditionalCheckBoxRenderer;
import validation.BuscaComprasFormValidation;

public class HistoricoCompras extends javax.swing.JFrame {

    ArrayList<Compra> arrayCompras;
    ArrayList<Compra> comprasNaTabela;
    Cliente cliente;
    Compra compraSelecionada;

    public HistoricoCompras(ArrayList<Compra> arrayCompras, Cliente cliente) {
        initComponents();

        this.arrayCompras = arrayCompras;
        this.comprasNaTabela = arrayCompras;
        this.cliente = cliente;
        this.compraSelecionada = null;

        labelNomeCliente.setText(cliente.getNome());
        campoValorComprasSelecionadas.setText("R$ 0,00");

        createTable();

        fillTable();

        comboBoxValor.addActionListener((ActionEvent e) -> {
            if (comboBoxValor.getSelectedIndex() == 2) {
                campoValor2.setEditable(true);
            } else {
                campoValor2.setEditable(false);
                campoValor2.setText("");
            }
        });

        tabelaCompras.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                setSomaValores();

                int row = tabelaCompras.rowAtPoint(e.getPoint());
                if (row >= 0) {
                    compraSelecionada = comprasNaTabela.get(row);
                }else{
                    compraSelecionada = null;
                }
            }
        });

    }

    private void setSomaValores() {
        float somaValores = 0;
        for (int i = 0; i < tabelaCompras.getRowCount(); i++) {
            if (!arrayCompras.get(i).isEstaPago() && (boolean) tabelaCompras.getValueAt(i, 0)) {
                somaValores += arrayCompras.get(i).getValor();
            }
        }

        String somaValoresStr = String.format("%.02f", somaValores);
        somaValoresStr = somaValoresStr.replace('.', ',');
        campoValorComprasSelecionadas.setText("R$ " + somaValoresStr);
    }

    private HistoricoCompras() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void createTable() {
        tabelaCompras.getColumnModel().getColumn(0).setCellRenderer(new ConditionalCheckBoxRenderer());
        tabelaCompras.getColumnModel().getColumn(3).setCellRenderer(new ConditionalCheckBoxRenderer());
    }

    private void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tabelaCompras.getModel();

        model.setRowCount(0);
        for (Compra c : comprasNaTabela) {
            model.addRow(c.compraObjectArray());
        }
    }

    public void updateTabela() {
        arrayCompras = CompraDAO.selectComprasFromCliente(cliente.getIdCliente());
        comprasNaTabela = arrayCompras;
        fillTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        labelNomeCliente = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCompras = new tCompras.TabelaCompras();
        formPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        campoDataDe = new javax.swing.JFormattedTextField();
        campoDataAte = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        comboBoxValor = new javax.swing.JComboBox<>();
        campoValor1 = new javax.swing.JTextField();
        campoValor2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        checkBoxSim = new javax.swing.JCheckBox();
        checkBoxNao = new javax.swing.JCheckBox();
        botaoLimpar = new javax.swing.JButton();
        botaoBuscar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        botaoPagarCompras = new javax.swing.JButton();
        botaoSelecionarTodasCompras = new javax.swing.JButton();
        botaoMaisInfoCompra = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        campoValorComprasSelecionadas = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        botaoSelecionarTodasCompras1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Histórico de Compras");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/icons/basket-48.png")).getImage());
        setResizable(false);

        labelNomeCliente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelNomeCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/customer-red.png"))); // NOI18N
        labelNomeCliente.setText("MARCO AURÉLIO PLACEHOLDER");

        tabelaCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Pagar", "Data", "Valor (R$)", "Está pago?"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaCompras);
        if (tabelaCompras.getColumnModel().getColumnCount() > 0) {
            tabelaCompras.getColumnModel().getColumn(0).setResizable(false);
            tabelaCompras.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabelaCompras.getColumnModel().getColumn(1).setResizable(false);
            tabelaCompras.getColumnModel().getColumn(1).setPreferredWidth(160);
            tabelaCompras.getColumnModel().getColumn(2).setResizable(false);
            tabelaCompras.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabelaCompras.getColumnModel().getColumn(3).setResizable(false);
            tabelaCompras.getColumnModel().getColumn(3).setPreferredWidth(90);
        }

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel2.setText("Data:");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("A partir de:");

        try {
            campoDataDe.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoDataDe.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        campoDataDe.setName("campoDataDe"); // NOI18N

        try {
            campoDataAte.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoDataAte.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        campoDataAte.setName("campoDataAte"); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Até:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(campoDataDe, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoDataAte, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoDataAte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoDataDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel5.setText("Valor:");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        comboBoxValor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        comboBoxValor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acima de", "Abaixo de", "Entre" }));
        comboBoxValor.setName("comboBoxValor"); // NOI18N

        campoValor1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        campoValor1.setName("campoValor1"); // NOI18N

        campoValor2.setEditable(false);
        campoValor2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        campoValor2.setName("campoValor2"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBoxValor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(campoValor1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoValor2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboBoxValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoValor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoValor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel6.setText("Está pago?");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        checkBoxSim.setSelected(true);
        checkBoxSim.setText("Sim");
        checkBoxSim.setName("checkBoxSim"); // NOI18N

        checkBoxNao.setSelected(true);
        checkBoxNao.setText("Não");
        checkBoxNao.setName("checkBoxNao"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkBoxSim)
                .addGap(18, 18, 18)
                .addComponent(checkBoxNao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkBoxSim)
                    .addComponent(checkBoxNao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botaoLimpar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/eraser.png"))); // NOI18N
        botaoLimpar.setText("Limpar");
        botaoLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLimparActionPerformed(evt);
            }
        });

        botaoBuscar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        botaoBuscar.setText("Buscar");
        botaoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout formPanelLayout = new javax.swing.GroupLayout(formPanel);
        formPanel.setLayout(formPanelLayout);
        formPanelLayout.setHorizontalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(formPanelLayout.createSequentialGroup()
                .addComponent(botaoLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoBuscar))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2)
            .addComponent(jLabel5)
            .addComponent(jLabel6)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        formPanelLayout.setVerticalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoLimpar)
                    .addComponent(botaoBuscar))
                .addGap(26, 26, 26)
                .addComponent(jSeparator1))
        );

        botaoPagarCompras.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoPagarCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/payment-32.png"))); // NOI18N
        botaoPagarCompras.setText("Pagar Compras Selecionadas");
        botaoPagarCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPagarComprasActionPerformed(evt);
            }
        });

        botaoSelecionarTodasCompras.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoSelecionarTodasCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ok.png"))); // NOI18N
        botaoSelecionarTodasCompras.setText("Selecionar Todas Compras da Tabela");
        botaoSelecionarTodasCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSelecionarTodasComprasActionPerformed(evt);
            }
        });

        botaoMaisInfoCompra.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoMaisInfoCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/more-info.png"))); // NOI18N
        botaoMaisInfoCompra.setText("Mais Informações da Compra");
        botaoMaisInfoCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoMaisInfoCompraActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sigma.png"))); // NOI18N
        jLabel7.setText("Soma das compras selecionadas:");

        campoValorComprasSelecionadas.setEditable(false);
        campoValorComprasSelecionadas.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        botaoSelecionarTodasCompras1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoSelecionarTodasCompras1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
        botaoSelecionarTodasCompras1.setText("Deselecionar Todas Compras da Tabela");
        botaoSelecionarTodasCompras1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSelecionarTodasCompras1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(campoValorComprasSelecionadas, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(formPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelNomeCliente)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botaoSelecionarTodasCompras1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botaoSelecionarTodasCompras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(botaoMaisInfoCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botaoPagarCompras, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE))
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNomeCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoValorComprasSelecionadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(formPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSelecionarTodasCompras)
                    .addComponent(botaoPagarCompras))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSelecionarTodasCompras1)
                    .addComponent(botaoMaisInfoCompra))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBuscarActionPerformed
        try {
            BuscaComprasFormValidation validator = new BuscaComprasFormValidation(formPanel);
            if (validator.validate()) {

                comprasNaTabela = new ArrayList<>();
                boolean flag;

                for (Compra c : arrayCompras) {

                    flag = true;

                    if (!validator.datasVazias()) {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Calendar dataDe = null, dataAte = null;

                        if (!validator.dataDeVazia() && !validator.dataAteVazia()) {
                            dataDe = Calendar.getInstance();
                            dataDe.setTime(sdf.parse(campoDataDe.getText()));

                            dataAte = Calendar.getInstance();
                            dataAte.setTime(sdf.parse(campoDataAte.getText()));

                            if (c.getData().before(dataDe)) {
                                System.out.println("before");
                            }
                            if (c.getData().after(dataAte)) {
                                System.out.println("after");
                            }

                            if (c.getData().before(dataDe) || c.getData().after(dataAte)) {
                                flag = false;
                            }
                        } else if (!validator.dataDeVazia()) {
                            dataDe = Calendar.getInstance();
                            dataDe.setTime(sdf.parse(campoDataDe.getText()));

                            if (c.getData().before(dataDe)) {
                                flag = false;
                            }
                        } else {
                            dataAte = Calendar.getInstance();
                            dataAte.setTime(sdf.parse(campoDataAte.getText()));

                            if (c.getData().after(dataAte)) {
                                flag = false;
                            }
                        }
                    }

                    if (!validator.valoresVazios()) {
                        switch (comboBoxValor.getSelectedIndex()) {
                            case 0:
                                if (c.getValor() <= Float.parseFloat(campoValor1.getText())) {
                                    flag = false;
                                }
                                break;
                            case 1:
                                if (c.getValor() >= Float.parseFloat(campoValor1.getText())) {
                                    flag = false;
                                }
                                break;
                            default:
                                if (c.getValor() < Float.parseFloat(campoValor1.getText()) || c.getValor() > Float.parseFloat(campoValor2.getText())) {
                                    flag = false;
                                }
                                break;
                        }
                    }

                    if (!checkBoxSim.isSelected() && c.isEstaPago()) {
                        flag = false;
                    }
                    if (!checkBoxNao.isSelected() && !c.isEstaPago()) {
                        flag = false;
                    }

                    if (flag) {
                        comprasNaTabela.add(c);
                    }
                }
                
                fillTable();
            }
        } catch (ParseException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_botaoBuscarActionPerformed

    private void botaoLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparActionPerformed
        campoDataDe.setText("");
        campoDataAte.setText("");
        campoValor1.setText("");
        campoValor2.setText("");
        checkBoxSim.setSelected(true);
        checkBoxNao.setSelected(true);

        comprasNaTabela = arrayCompras;
        fillTable();
        setSomaValores();
    }//GEN-LAST:event_botaoLimparActionPerformed

    private void botaoSelecionarTodasComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSelecionarTodasComprasActionPerformed
        DefaultTableModel model = (DefaultTableModel) tabelaCompras.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            if (!comprasNaTabela.get(i).isEstaPago()) {
                model.setValueAt(true, i, 0);
            }
        }
        
        setSomaValores();
    }//GEN-LAST:event_botaoSelecionarTodasComprasActionPerformed

    private void botaoPagarComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPagarComprasActionPerformed
        ArrayList<Compra> comprasParaPagar = new ArrayList<>();
        for (int i = 0; i < tabelaCompras.getRowCount(); i++) {
            if (!comprasNaTabela.get(i).isEstaPago()) {
                if ((boolean) tabelaCompras.getValueAt(i, 0)) {
                    comprasParaPagar.add(comprasNaTabela.get(i));
                }
            }
        }

        if (comprasParaPagar.isEmpty()) {
            JOptionPane.showMessageDialog(null, "É necessário que pelo menos uma compra esteja selecionada para efetuar a operação", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        } else {
            new PagarCompras(comprasParaPagar, cliente, this).setVisible(true);
        }
    }//GEN-LAST:event_botaoPagarComprasActionPerformed

    private void botaoMaisInfoCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoMaisInfoCompraActionPerformed
        if (Objects.isNull(compraSelecionada)){
            JOptionPane.showMessageDialog(null, "Favor selecionar uma compra na tabela para realizar essa operação", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }else{
            new MaisInfoCompra(compraSelecionada).setVisible(true);
        }
    }//GEN-LAST:event_botaoMaisInfoCompraActionPerformed

    private void botaoSelecionarTodasCompras1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSelecionarTodasCompras1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) tabelaCompras.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            if (!comprasNaTabela.get(i).isEstaPago()) {
                model.setValueAt(false, i, 0);
            }
        }
        
        setSomaValores();
    }//GEN-LAST:event_botaoSelecionarTodasCompras1ActionPerformed

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
            java.util.logging.Logger.getLogger(HistoricoCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoricoCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoricoCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoricoCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistoricoCompras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoBuscar;
    private javax.swing.JButton botaoLimpar;
    private javax.swing.JButton botaoMaisInfoCompra;
    private javax.swing.JButton botaoPagarCompras;
    private javax.swing.JButton botaoSelecionarTodasCompras;
    private javax.swing.JButton botaoSelecionarTodasCompras1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JFormattedTextField campoDataAte;
    private javax.swing.JFormattedTextField campoDataDe;
    private javax.swing.JTextField campoValor1;
    private javax.swing.JTextField campoValor2;
    private javax.swing.JTextField campoValorComprasSelecionadas;
    private javax.swing.JCheckBox checkBoxNao;
    private javax.swing.JCheckBox checkBoxSim;
    private javax.swing.JComboBox<String> comboBoxValor;
    private javax.swing.JPanel formPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelNomeCliente;
    private tCompras.TabelaCompras tabelaCompras;
    // End of variables declaration//GEN-END:variables

}
