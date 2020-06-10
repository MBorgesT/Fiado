package gui_admin;

import gui_cliente.*;
import dao.AtendenteDAO;
import dao.CompraDAO;
import dao.PagamentoDAO;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Atendente;
import models.Cliente;
import models.Compra;
import models.Pagamento;
import org.json.JSONException;
import org.json.JSONObject;
import printers.ComprovantePrinter;

public class HistoricoPagamentosAdmin extends javax.swing.JFrame {

    Cliente cliente;
    ArrayList<Pagamento> arrayPagamentos;
    ArrayList<Compra> comprasNaTabela;
    Pagamento pagamentoSelecionado;

    public HistoricoPagamentosAdmin(Cliente cliente) {
        initComponents();

        this.cliente = cliente;
        this.arrayPagamentos = PagamentoDAO.selectPagamentosFromCliente(cliente.getIdCliente());

        labelNomeCliente.setText(cliente.getNome());

        DefaultTableModel model = (DefaultTableModel) tabelaPagamentos.getModel();
        for (int i = 0; i < arrayPagamentos.size(); i++) {
            model.addRow(arrayPagamentos.get(i).pagamentoObjectArray());
        }

        tabelaPagamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tabelaPagamentos.rowAtPoint(evt.getPoint());
                if (row >= 0) {
                    selecionarPagamento(arrayPagamentos.get(row));
                    botaoImprimirNotaCliente.setEnabled(true);
                    botaoImprimirNotaPadaria.setEnabled(true);
                }
            }
        });

    }

    private void selecionarPagamento(Pagamento pagamento) {
        pagamentoSelecionado = pagamento;
        
        Atendente atendente = AtendenteDAO.selectAtendenteById(pagamento.getIdAtendente());
        campoAtendente.setText(atendente.getNome());

        campoObservacao.setText(pagamento.getObservacao());

        comprasNaTabela = CompraDAO.selectComprasFromPagamento(pagamento.getIdPagamento());
        DefaultTableModel model = (DefaultTableModel) tabelaCompras.getModel();
        model.setRowCount(0);
        for (int i = 0; i < comprasNaTabela.size(); i++) {
            model.addRow(comprasNaTabela.get(i).compraObjectArraySimple());
        }
    }

    private HistoricoPagamentosAdmin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPagamentos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        campoObservacao = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaCompras = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        campoAtendente = new javax.swing.JTextField();
        botaoImprimirNotaCliente = new javax.swing.JButton();
        botaoImprimirNotaPadaria = new javax.swing.JButton();
        labelNomeCliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Histórico de Pagamentos");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/icons/administrator-48.png")).getImage());
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/payment-48.png"))); // NOI18N
        jLabel1.setText("Histórico de Pagamentos");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabelaPagamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaPagamentos);
        if (tabelaPagamentos.getColumnModel().getColumnCount() > 0) {
            tabelaPagamentos.getColumnModel().getColumn(0).setResizable(false);
            tabelaPagamentos.getColumnModel().getColumn(0).setPreferredWidth(160);
            tabelaPagamentos.getColumnModel().getColumn(1).setResizable(false);
            tabelaPagamentos.getColumnModel().getColumn(1).setPreferredWidth(100);
        }

        campoObservacao.setEditable(false);
        campoObservacao.setColumns(20);
        campoObservacao.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        campoObservacao.setLineWrap(true);
        campoObservacao.setRows(5);
        jScrollPane2.setViewportView(campoObservacao);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("<html>Observações do pagamento selecionado:</html>");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Compras:");

        tabelaCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tabelaCompras);
        if (tabelaCompras.getColumnModel().getColumnCount() > 0) {
            tabelaCompras.getColumnModel().getColumn(0).setResizable(false);
            tabelaCompras.getColumnModel().getColumn(0).setPreferredWidth(160);
            tabelaCompras.getColumnModel().getColumn(1).setResizable(false);
            tabelaCompras.getColumnModel().getColumn(1).setPreferredWidth(100);
        }

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("<html>Atendente que realizou o pagamento:</html>");

        campoAtendente.setEditable(false);
        campoAtendente.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        botaoImprimirNotaCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoImprimirNotaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/printer-blue-32.png"))); // NOI18N
        botaoImprimirNotaCliente.setText("Nota do Cliente");
        botaoImprimirNotaCliente.setEnabled(false);
        botaoImprimirNotaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoImprimirNotaClienteActionPerformed(evt);
            }
        });

        botaoImprimirNotaPadaria.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoImprimirNotaPadaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/printer-green-32.png"))); // NOI18N
        botaoImprimirNotaPadaria.setText("Nota da Padaria");
        botaoImprimirNotaPadaria.setEnabled(false);
        botaoImprimirNotaPadaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoImprimirNotaPadariaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(campoAtendente)
                    .addComponent(botaoImprimirNotaCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoImprimirNotaPadaria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoImprimirNotaCliente)
                        .addGap(18, 18, 18)
                        .addComponent(botaoImprimirNotaPadaria)))
                .addContainerGap())
        );

        labelNomeCliente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelNomeCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/customer-red.png"))); // NOI18N
        labelNomeCliente.setText("MARCOS CÉSAR PLACEHOLDER");
        labelNomeCliente.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelNomeCliente)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelNomeCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoImprimirNotaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoImprimirNotaClienteActionPerformed
        String[] options = {"SIM", "NÃO"};
        int reply = JOptionPane.showOptionDialog(null, "Realmente deseja imprimir o comprovante do cliente?", "Recibo",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                options, options[0]);
        
        if (reply == 0) ComprovantePrinter.printComprovantePagamento(pagamentoSelecionado, true);
    }//GEN-LAST:event_botaoImprimirNotaClienteActionPerformed

    private void botaoImprimirNotaPadariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoImprimirNotaPadariaActionPerformed
        String[] options = {"SIM", "NÃO"};
        int reply = JOptionPane.showOptionDialog(null, "Realmente deseja imprimir o comprovante da padaria?", "Recibo",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                options, options[0]);
        
        if (reply == 0) ComprovantePrinter.printComprovantePagamento(pagamentoSelecionado, false);
    }//GEN-LAST:event_botaoImprimirNotaPadariaActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistoricoPagamentosAdmin().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoImprimirNotaCliente;
    private javax.swing.JButton botaoImprimirNotaPadaria;
    private javax.swing.JTextField campoAtendente;
    private javax.swing.JTextArea campoObservacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelNomeCliente;
    private javax.swing.JTable tabelaCompras;
    private javax.swing.JTable tabelaPagamentos;
    // End of variables declaration//GEN-END:variables
}
