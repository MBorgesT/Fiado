package gui_admin;

import dao.CompraDAO;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import models.Cliente;
import models.Compra;
import validation.BuscaComprasFormValidation;

public class HistoricoComprasAdmin extends javax.swing.JFrame {

    ArrayList<Compra> arrayCompras;
    ArrayList<Compra> comprasNaTabela;
    Cliente cliente;
    Compra compraSelecionada;

    public HistoricoComprasAdmin(Cliente cliente) {
        initComponents();

        this.cliente = cliente;
        this.arrayCompras = CompraDAO.selectTodasComprasFromCliente(cliente.getIdCliente());
        this.comprasNaTabela = arrayCompras;
        this.compraSelecionada = null;

        labelNomeCliente.setText(cliente.getNome());

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
                int row = tabelaCompras.rowAtPoint(e.getPoint());
                if (row >= 0) {
                    compraSelecionada = comprasNaTabela.get(row);
                }else{
                    compraSelecionada = null;
                }
            }
        });

    }

    private HistoricoComprasAdmin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void resetTabela() {
        this.arrayCompras = CompraDAO.selectTodasComprasFromCliente(cliente.getIdCliente());
        
        botaoLimpar.doClick();
    }

    private void createTable() {
        tabelaCompras.getColumnModel().getColumn(2).setCellRenderer(new NewCellRenderer());
        tabelaCompras.getColumnModel().getColumn(3).setCellRenderer(new NewCellRenderer());
    }

    public void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tabelaCompras.getModel();

        model.setRowCount(0);
        for (Compra c : comprasNaTabela) {
            model.addRow(c.compraObjectArrayAdmin());
        }
        
        setValorComprasSomadas();
    }
    
    private void setValorComprasSomadas(){
        float valorTotal = 0;
        for (Compra c: comprasNaTabela){
            valorTotal += c.getValor();
        }
        String strValorTotal = "R$ " + String.format("%.02f", valorTotal).replace(".", ",");
        campoValorComprasNaTabela.setText(strValorTotal);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        labelNomeCliente = new javax.swing.JLabel();
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
        checkBoxPagoSim = new javax.swing.JCheckBox();
        checkBoxPagoNao = new javax.swing.JCheckBox();
        botaoLimpar = new javax.swing.JButton();
        botaoBuscar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        checkBoxEntregaSim = new javax.swing.JCheckBox();
        checkBoxEntregaNao = new javax.swing.JCheckBox();
        botaoMaisInfoCompra = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaCompras = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        campoValorComprasNaTabela = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Histórico de Compras");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/icons/administrator-48.png")).getImage());
        setResizable(false);

        labelNomeCliente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelNomeCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/customer-red.png"))); // NOI18N
        labelNomeCliente.setText("MARCO AURÉLIO PLACEHOLDER");

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

        checkBoxPagoSim.setSelected(true);
        checkBoxPagoSim.setText("Sim");
        checkBoxPagoSim.setName("checkBoxPagoSim"); // NOI18N

        checkBoxPagoNao.setSelected(true);
        checkBoxPagoNao.setText("Não");
        checkBoxPagoNao.setName("checkBoxPagoNao"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkBoxPagoSim)
                .addGap(18, 18, 18)
                .addComponent(checkBoxPagoNao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkBoxPagoSim)
                    .addComponent(checkBoxPagoNao))
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

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel7.setText("Entrega?");

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        checkBoxEntregaSim.setSelected(true);
        checkBoxEntregaSim.setText("Sim");
        checkBoxEntregaSim.setName("checkBoxEntregaSim"); // NOI18N

        checkBoxEntregaNao.setSelected(true);
        checkBoxEntregaNao.setText("Não");
        checkBoxEntregaNao.setName("checkBoxEntregaNao"); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkBoxEntregaSim)
                .addGap(18, 18, 18)
                .addComponent(checkBoxEntregaNao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkBoxEntregaSim)
                    .addComponent(checkBoxEntregaNao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout formPanelLayout = new javax.swing.GroupLayout(formPanel);
        formPanel.setLayout(formPanelLayout);
        formPanelLayout.setHorizontalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(formPanelLayout.createSequentialGroup()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(formPanelLayout.createSequentialGroup()
                    .addComponent(botaoLimpar)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoBuscar))
                .addGroup(formPanelLayout.createSequentialGroup()
                    .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel5)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(formPanelLayout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(93, 93, 93)
                            .addComponent(jLabel7)))
                    .addGap(0, 0, Short.MAX_VALUE)))
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
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botaoLimpar)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botaoBuscar))))
        );

        botaoMaisInfoCompra.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoMaisInfoCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/more-info.png"))); // NOI18N
        botaoMaisInfoCompra.setText("Mais Informações da Compra");
        botaoMaisInfoCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoMaisInfoCompraActionPerformed(evt);
            }
        });

        tabelaCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Data", "Valor (R$)", "Está paga?", "Entrega?"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabelaCompras);
        if (tabelaCompras.getColumnModel().getColumnCount() > 0) {
            tabelaCompras.getColumnModel().getColumn(0).setPreferredWidth(160);
            tabelaCompras.getColumnModel().getColumn(1).setPreferredWidth(90);
        }

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sigma.png"))); // NOI18N
        jLabel1.setText("Soma das compras na tabela:");

        campoValorComprasNaTabela.setEditable(false);
        campoValorComprasNaTabela.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(botaoMaisInfoCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addComponent(campoValorComprasNaTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator2))
                    .addComponent(formPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNomeCliente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(labelNomeCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoValorComprasNaTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(formPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botaoMaisInfoCompra))
                    .addComponent(jScrollPane2))
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
                    

                    if (!checkBoxPagoSim.isSelected() && c.isEstaPago()) {
                        flag = false;
                    }
                    if (!checkBoxPagoNao.isSelected() && !c.isEstaPago()) {
                        flag = false;
                    }
                    
                    
                    if (!checkBoxEntregaSim.isSelected() && c.isEntrega()) {
                        flag = false;
                    }
                    if (!checkBoxEntregaNao.isSelected() && !c.isEntrega()){
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
        checkBoxPagoSim.setSelected(true);
        checkBoxPagoNao.setSelected(true);

        comprasNaTabela = arrayCompras;
        fillTable();
    }//GEN-LAST:event_botaoLimparActionPerformed

    private void botaoMaisInfoCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoMaisInfoCompraActionPerformed
        if (Objects.isNull(compraSelecionada)){
            JOptionPane.showMessageDialog(null, "Favor selecionar uma compra na tabela para realizar essa operação", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }else{
            new MaisInfoCompraAdmin(compraSelecionada, this).setVisible(true);
        }
    }//GEN-LAST:event_botaoMaisInfoCompraActionPerformed

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
            java.util.logging.Logger.getLogger(HistoricoComprasAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoricoComprasAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoricoComprasAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoricoComprasAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistoricoComprasAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoBuscar;
    private javax.swing.JButton botaoLimpar;
    private javax.swing.JButton botaoMaisInfoCompra;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JFormattedTextField campoDataAte;
    private javax.swing.JFormattedTextField campoDataDe;
    private javax.swing.JTextField campoValor1;
    private javax.swing.JTextField campoValor2;
    private javax.swing.JTextField campoValorComprasNaTabela;
    private javax.swing.JCheckBox checkBoxEntregaNao;
    private javax.swing.JCheckBox checkBoxEntregaSim;
    private javax.swing.JCheckBox checkBoxPagoNao;
    private javax.swing.JCheckBox checkBoxPagoSim;
    private javax.swing.JComboBox<String> comboBoxValor;
    private javax.swing.JPanel formPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelNomeCliente;
    private javax.swing.JTable tabelaCompras;
    // End of variables declaration//GEN-END:variables

    public static class NewCellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
            Component c = null;
            if (col == 2) {
                c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

                String valueStr = (String) value;
                c.setForeground(valueStr.contains("SIM") ? new Color(0, 163, 16) : Color.RED);
            }
            if (col == 3) {
                c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

                String valueStr = (String) value;
                c.setForeground(valueStr.contains("ENTREGA") ? Color.BLUE : Color.RED);
            }

            return c;
        }

    }
}
