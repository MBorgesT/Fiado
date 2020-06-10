/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_cliente;

import java.util.ArrayList;
import models.Cliente;
import dao.ClienteDAO;
import dao.CompraDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author matheus
 */
public class MenuPrincipal extends javax.swing.JFrame {

    private ArrayList<Cliente> todosClientes;

    private ArrayList<Cliente> clientesNaTabela;

    private Cliente clienteSelecionado;

    public MenuPrincipal() {
        initComponents();

        todosClientes = ClienteDAO.selectAllClientes();

        clientesNaTabela = todosClientes;

        botaoDeselecionarCliente.doClick();

        fillClientesTable();
    }

    private void criarTabelaClienteListeners() {
        tabelaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tabelaClientes.rowAtPoint(evt.getPoint());
                if (row >= 0) {
                    selecionarCliente(clientesNaTabela.get(row));
                }
            }
        });
    }

    private void fillClientesTable() {
        DefaultTableModel tabelaClientesModel = (DefaultTableModel) tabelaClientes.getModel();

        tabelaClientesModel.setRowCount(0);
        for (Cliente c : clientesNaTabela) {
            tabelaClientesModel.addRow(c.clienteObjectArray());
        }

        criarTabelaClienteListeners();
    }

    private void selecionarCliente(Cliente c) {
        clienteSelecionado = c;
        botaoDeselecionarCliente.setEnabled(true);
        labelClienteSelecionado.setText("<html>" + c.getNome() + "</html>");

        botaoNovaCompra.setEnabled(true);
        botaoRealizarPagamento.setEnabled(true);
        botaoMaisInfoCliente.setEnabled(true);
    }

    public void resetTabelaClientes() {
        todosClientes = new ClienteDAO().selectAllClientes();
        clientesNaTabela = todosClientes;
        fillClientesTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buscaClientesButtonGroup = new javax.swing.ButtonGroup();
        buscaAtendentesButtonGroup = new javax.swing.ButtonGroup();
        clientePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        idClienteRadioButton = new javax.swing.JRadioButton();
        nomeClienteRadioButton = new javax.swing.JRadioButton();
        campoBuscaClientes = new javax.swing.JTextField();
        botaoBuscarCliente = new javax.swing.JButton();
        clientesButtonPanel = new javax.swing.JPanel();
        botaoRealizarPagamento = new javax.swing.JButton();
        botaoNovaCompra = new javax.swing.JButton();
        botaoMaisInfoCliente = new javax.swing.JButton();
        botaoNovoCliente = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        labelClienteSelecionado = new javax.swing.JLabel();
        botaoDeselecionarCliente = new javax.swing.JButton();
        botaoLimparBusca = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fiado");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/icons/basket-48.png")).getImage());
        setResizable(false);

        tabelaClientes.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaClientes);
        if (tabelaClientes.getColumnModel().getColumnCount() > 0) {
            tabelaClientes.getColumnModel().getColumn(0).setResizable(false);
            tabelaClientes.getColumnModel().getColumn(0).setPreferredWidth(75);
            tabelaClientes.getColumnModel().getColumn(1).setResizable(false);
            tabelaClientes.getColumnModel().getColumn(1).setPreferredWidth(725);
        }

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Busca:");

        buscaClientesButtonGroup.add(idClienteRadioButton);
        idClienteRadioButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        idClienteRadioButton.setText("ID");

        buscaClientesButtonGroup.add(nomeClienteRadioButton);
        nomeClienteRadioButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        nomeClienteRadioButton.setSelected(true);
        nomeClienteRadioButton.setText("Nome");

        campoBuscaClientes.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        campoBuscaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoBuscaClientesActionPerformed(evt);
            }
        });

        botaoBuscarCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        botaoBuscarCliente.setText("Buscar");
        botaoBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBuscarClienteActionPerformed(evt);
            }
        });

        clientesButtonPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        botaoRealizarPagamento.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoRealizarPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/payment-32.png"))); // NOI18N
        botaoRealizarPagamento.setText("Realizar Pagamento");
        botaoRealizarPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRealizarPagamentoActionPerformed(evt);
            }
        });

        botaoNovaCompra.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoNovaCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/basket-32.png"))); // NOI18N
        botaoNovaCompra.setText("Nova Compra");
        botaoNovaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovaCompraActionPerformed(evt);
            }
        });

        botaoMaisInfoCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoMaisInfoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/more-info.png"))); // NOI18N
        botaoMaisInfoCliente.setText("Mais Informações");
        botaoMaisInfoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoMaisInfoClienteActionPerformed(evt);
            }
        });

        botaoNovoCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoNovoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/new-customer.png"))); // NOI18N
        botaoNovoCliente.setText("Novo Cliente");
        botaoNovoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovoClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout clientesButtonPanelLayout = new javax.swing.GroupLayout(clientesButtonPanel);
        clientesButtonPanel.setLayout(clientesButtonPanelLayout);
        clientesButtonPanelLayout.setHorizontalGroup(
            clientesButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientesButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clientesButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoNovaCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoRealizarPagamento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoMaisInfoCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoNovoCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        clientesButtonPanelLayout.setVerticalGroup(
            clientesButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientesButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoNovaCompra)
                .addGap(18, 18, 18)
                .addComponent(botaoRealizarPagamento)
                .addGap(18, 18, 18)
                .addComponent(botaoMaisInfoCliente)
                .addGap(18, 18, 18)
                .addComponent(botaoNovoCliente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/customer-red.png"))); // NOI18N
        jLabel2.setText("Cliente selecionado:");

        labelClienteSelecionado.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelClienteSelecionado.setText("Marcos César Placeholder");

        botaoDeselecionarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/close-cross.png"))); // NOI18N
        botaoDeselecionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDeselecionarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(botaoDeselecionarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelClienteSelecionado)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoDeselecionarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelClienteSelecionado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botaoLimparBusca.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoLimparBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/eraser.png"))); // NOI18N
        botaoLimparBusca.setText("Limpar");
        botaoLimparBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLimparBuscaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout clientePanelLayout = new javax.swing.GroupLayout(clientePanel);
        clientePanel.setLayout(clientePanelLayout);
        clientePanelLayout.setHorizontalGroup(
            clientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(clientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clientePanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nomeClienteRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(idClienteRadioButton))
                    .addComponent(campoBuscaClientes)
                    .addComponent(clientesButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clientePanelLayout.createSequentialGroup()
                        .addComponent(botaoLimparBusca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoBuscarCliente)))
                .addContainerGap())
        );
        clientePanelLayout.setVerticalGroup(
            clientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clientePanelLayout.createSequentialGroup()
                        .addGroup(clientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(idClienteRadioButton)
                            .addComponent(nomeClienteRadioButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoBuscaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(clientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botaoBuscarCliente)
                            .addComponent(botaoLimparBusca))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(clientesButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(clientePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(clientePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBuscarClienteActionPerformed
        String searchParam = campoBuscaClientes.getText();
        if (!searchParam.isEmpty()) {
            if (idClienteRadioButton.isSelected()) {
                try {
                    int idBusca = Integer.parseInt(searchParam);
                    clientesNaTabela = new ArrayList<>();

                    boolean flag = false;
                    for (Cliente c : todosClientes) {
                        if (c.getIdCliente() == idBusca) {
                            clientesNaTabela.add(c);
                            flag = true;
                            break;
                        }
                    }

                    fillClientesTable();

                    if (!flag) {
                        JOptionPane.showMessageDialog(null, "Não foi possível achar um resultado", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Favor inserir somente números no campo de busca por ID", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                searchParam = searchParam.toUpperCase();
                clientesNaTabela = new ArrayList<>();

                boolean flag = false;
                for (Cliente c : todosClientes) {
                    if (c.getNome().contains(searchParam)) {
                        clientesNaTabela.add(c);
                        flag = true;
                    }
                }

                fillClientesTable();

                if (!flag) {
                    JOptionPane.showMessageDialog(null, "Não foi possível achar um resultado", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else {
            clientesNaTabela = todosClientes;
            fillClientesTable();
        }
        botaoDeselecionarCliente.doClick();
    }//GEN-LAST:event_botaoBuscarClienteActionPerformed

    private void botaoDeselecionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDeselecionarClienteActionPerformed
        clienteSelecionado = null;
        botaoDeselecionarCliente.setEnabled(false);
        labelClienteSelecionado.setText(" ");

        botaoNovaCompra.setEnabled(false);
        botaoRealizarPagamento.setEnabled(false);
        botaoMaisInfoCliente.setEnabled(false);
    }//GEN-LAST:event_botaoDeselecionarClienteActionPerformed

    private void botaoNovoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoClienteActionPerformed
        new AtendenteAccessControl(new NovoCliente(this)).setVisible(true);
    }//GEN-LAST:event_botaoNovoClienteActionPerformed

    private void botaoMaisInfoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoMaisInfoClienteActionPerformed
        new AtendenteAccessControl(new MaisInfoCliente(this, clienteSelecionado)).setVisible(true);
    }//GEN-LAST:event_botaoMaisInfoClienteActionPerformed

    private void botaoNovaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovaCompraActionPerformed
        if (clienteSelecionado.isAtivo()) {
            if (CompraDAO.clienteExcedeDiasNotificacao(clienteSelecionado.getIdCliente())) {
                String[] options = {"SIM", "NÃO"};
                int reply = JOptionPane.showOptionDialog(null, "Há compras não pagas que excedem o limite de dias sem pagamento. Deseja continuar?", "Atenção",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
                        options, options[0]);

                if (reply == 0) {
                    new NovaCompra(clienteSelecionado).setVisible(true);
                }
            } else {
                new NovaCompra(clienteSelecionado).setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "O cliente não está ativo, portanto não poderá realizar compras", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botaoNovaCompraActionPerformed

    private void botaoRealizarPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRealizarPagamentoActionPerformed
        HistoricoCompras hc = new HistoricoCompras(CompraDAO.selectComprasFromCliente(clienteSelecionado.getIdCliente()), clienteSelecionado);
        new AtendenteAccessControl(hc).setVisible(true);
    }//GEN-LAST:event_botaoRealizarPagamentoActionPerformed

    private void botaoLimparBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparBuscaActionPerformed
        campoBuscaClientes.setText("");
        clientesNaTabela = todosClientes;
        fillClientesTable();
    }//GEN-LAST:event_botaoLimparBuscaActionPerformed

    private void campoBuscaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoBuscaClientesActionPerformed
        botaoBuscarCliente.doClick();
    }//GEN-LAST:event_campoBuscaClientesActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoBuscarCliente;
    private javax.swing.JButton botaoDeselecionarCliente;
    private javax.swing.JButton botaoLimparBusca;
    private javax.swing.JButton botaoMaisInfoCliente;
    private javax.swing.JButton botaoNovaCompra;
    private javax.swing.JButton botaoNovoCliente;
    private javax.swing.JButton botaoRealizarPagamento;
    private javax.swing.ButtonGroup buscaAtendentesButtonGroup;
    private javax.swing.ButtonGroup buscaClientesButtonGroup;
    private javax.swing.JTextField campoBuscaClientes;
    private javax.swing.JPanel clientePanel;
    private javax.swing.JPanel clientesButtonPanel;
    private javax.swing.JRadioButton idClienteRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelClienteSelecionado;
    private javax.swing.JRadioButton nomeClienteRadioButton;
    private javax.swing.JTable tabelaClientes;
    // End of variables declaration//GEN-END:variables
}
