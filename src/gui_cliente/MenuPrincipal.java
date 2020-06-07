/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;
import models.Cliente;
import dao.ClienteDAO;
import dao.AtendenteDAO;
import dao.CompraDAO;
import java.awt.Component;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Atendente;

/**
 *
 * @author matheus
 */
public class MenuPrincipal extends javax.swing.JFrame {

    private ArrayList<Cliente> todosClientes;
    private ArrayList<Atendente> todosAtendentes;

    private ArrayList<Cliente> clientesNaTabela;
    private ArrayList<Atendente> atendentesNaTabela;

    private Cliente clienteSelecionado;
    private Atendente atendenteSelecionado;

    public MenuPrincipal() throws SQLException {
        initComponents();

        todosClientes = ClienteDAO.selectAllClientes();
        todosAtendentes = AtendenteDAO.selectAllAtendentes();

        clientesNaTabela = todosClientes;
        atendentesNaTabela = todosAtendentes;

        botaoDeselecionarCliente.doClick();
        botaoDeselecionarAtendente.doClick();

        fillTables();
    }

    private void criarTabelaClienteListeners() {
        tabelaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() >= 2) {
                    int row = tabelaClientes.rowAtPoint(evt.getPoint());
                    if (row >= 0) {
                        selecionarCliente(clientesNaTabela.get(row));
                    }
                }
            }
        });
    }

    private void criarTabelaAtendenteListeners() {
        tabelaAtendentes.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() >= 2) {
                    int row = tabelaAtendentes.rowAtPoint(evt.getPoint());
                    if (row >= 0) {
                        selecionarAtendente(atendentesNaTabela.get(row));
                    }
                }
            }
        });
    }

    private void fillTables() throws SQLException {
        fillClientesTable();
        fillAtendentesTable();
    }

    private void fillClientesTable() {
        DefaultTableModel tabelaClientesModel = (DefaultTableModel) tabelaClientes.getModel();

        tabelaClientesModel.setRowCount(0);
        for (Cliente c : clientesNaTabela) {
            tabelaClientesModel.addRow(c.clienteObjectArray());
        }

        criarTabelaClienteListeners();
    }

    private void fillAtendentesTable() {
        DefaultTableModel tabelaAtendentesModel = (DefaultTableModel) tabelaAtendentes.getModel();

        tabelaAtendentesModel.setRowCount(0);
        for (Atendente a : atendentesNaTabela) {
            tabelaAtendentesModel.addRow(a.atendenteObjectArray());
        }

        criarTabelaAtendenteListeners();
    }

    private void selecionarCliente(Cliente c) {
        clienteSelecionado = c;
        botaoDeselecionarCliente.setEnabled(true);
        labelClienteSelecionado.setText("<html>" + c.getNome() + "</html>");

        botaoNovaCompra.setEnabled(true);
        botaoRealizarPagamento.setEnabled(true);
        botaoMaisInfoCliente.setEnabled(true);
    }

    private void selecionarAtendente(Atendente a) {
        atendenteSelecionado = a;
        botaoDeselecionarAtendente.setEnabled(true);
        labelAtendenteSelecionado.setText("<html>" + a.getNome() + "</html>");

        botaoMaisInfoAtendente.setEnabled(true);
    }

    public void resetTabelaClientes() {
        todosClientes = new ClienteDAO().selectAllClientes();
        clientesNaTabela = todosClientes;
        fillClientesTable();
    }

    public void resetTabelaAtendentes() {
        todosAtendentes = new AtendenteDAO().selectAllAtendentes();
        atendentesNaTabela = todosAtendentes;
        fillAtendentesTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buscaClientesButtonGroup = new javax.swing.ButtonGroup();
        buscaAtendentesButtonGroup = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
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
        atendentePanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaAtendentes = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        nomeAtendenteRadioButton = new javax.swing.JRadioButton();
        idAtendenteRadioButton = new javax.swing.JRadioButton();
        campoBuscaAtendentes = new javax.swing.JTextField();
        botaoAtendenteBuscar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        labelAtendenteSelecionado = new javax.swing.JLabel();
        botaoDeselecionarAtendente = new javax.swing.JButton();
        atendentesButtonPanel = new javax.swing.JPanel();
        botaoMaisInfoAtendente = new javax.swing.JButton();
        botaoNovoAtendente = new javax.swing.JButton();
        configuracoesPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fiado");
        setResizable(false);

        jTabbedPane1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

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
        idClienteRadioButton.setSelected(true);
        idClienteRadioButton.setText("ID");

        buscaClientesButtonGroup.add(nomeClienteRadioButton);
        nomeClienteRadioButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        nomeClienteRadioButton.setText("Nome");

        campoBuscaClientes.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

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
                    .addComponent(botaoNovaCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
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
                .addContainerGap()
                .addComponent(labelClienteSelecionado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoDeselecionarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                        .addComponent(idClienteRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nomeClienteRadioButton))
                    .addComponent(campoBuscaClientes)
                    .addComponent(clientesButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clientePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
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
                        .addComponent(botaoBuscarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)
                        .addComponent(clientesButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Cliente", new javax.swing.ImageIcon(getClass().getResource("/icons/customer-blue.png")), clientePanel); // NOI18N

        tabelaAtendentes.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tabelaAtendentes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabelaAtendentes);
        if (tabelaAtendentes.getColumnModel().getColumnCount() > 0) {
            tabelaAtendentes.getColumnModel().getColumn(0).setResizable(false);
            tabelaAtendentes.getColumnModel().getColumn(0).setPreferredWidth(75);
            tabelaAtendentes.getColumnModel().getColumn(1).setResizable(false);
            tabelaAtendentes.getColumnModel().getColumn(1).setPreferredWidth(725);
        }

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Busca:");

        buscaAtendentesButtonGroup.add(nomeAtendenteRadioButton);
        nomeAtendenteRadioButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        nomeAtendenteRadioButton.setText("Nome");

        buscaAtendentesButtonGroup.add(idAtendenteRadioButton);
        idAtendenteRadioButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        idAtendenteRadioButton.setSelected(true);
        idAtendenteRadioButton.setText("ID");

        campoBuscaAtendentes.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        botaoAtendenteBuscar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoAtendenteBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        botaoAtendenteBuscar.setText("Buscar");
        botaoAtendenteBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAtendenteBuscarActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bread.png"))); // NOI18N
        jLabel5.setText("Atendente selecionado:");

        labelAtendenteSelecionado.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelAtendenteSelecionado.setText("Mário César Placeholder");

        botaoDeselecionarAtendente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/close-cross.png"))); // NOI18N
        botaoDeselecionarAtendente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDeselecionarAtendenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoDeselecionarAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelAtendenteSelecionado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(botaoDeselecionarAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelAtendenteSelecionado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        atendentesButtonPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        botaoMaisInfoAtendente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoMaisInfoAtendente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/more-info.png"))); // NOI18N
        botaoMaisInfoAtendente.setText("Mais Informações");
        botaoMaisInfoAtendente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoMaisInfoAtendenteActionPerformed(evt);
            }
        });

        botaoNovoAtendente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoNovoAtendente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bread-plus.png"))); // NOI18N
        botaoNovoAtendente.setText("Novo Atendente");
        botaoNovoAtendente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovoAtendenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout atendentesButtonPanelLayout = new javax.swing.GroupLayout(atendentesButtonPanel);
        atendentesButtonPanel.setLayout(atendentesButtonPanelLayout);
        atendentesButtonPanelLayout.setHorizontalGroup(
            atendentesButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(atendentesButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(atendentesButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoMaisInfoAtendente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoNovoAtendente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        atendentesButtonPanelLayout.setVerticalGroup(
            atendentesButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(atendentesButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoMaisInfoAtendente)
                .addGap(18, 18, 18)
                .addComponent(botaoNovoAtendente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout atendentePanelLayout = new javax.swing.GroupLayout(atendentePanel);
        atendentePanel.setLayout(atendentePanelLayout);
        atendentePanelLayout.setHorizontalGroup(
            atendentePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(atendentePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(atendentePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(atendentePanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(idAtendenteRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nomeAtendenteRadioButton))
                    .addComponent(campoBuscaAtendentes)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, atendentePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botaoAtendenteBuscar))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(atendentesButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        atendentePanelLayout.setVerticalGroup(
            atendentePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(atendentePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(atendentePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
                    .addGroup(atendentePanelLayout.createSequentialGroup()
                        .addGroup(atendentePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomeAtendenteRadioButton)
                            .addComponent(idAtendenteRadioButton)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoBuscaAtendentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoAtendenteBuscar)
                        .addGap(151, 151, 151)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(atendentesButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Atendente", new javax.swing.ImageIcon(getClass().getResource("/icons/bread.png")), atendentePanel); // NOI18N

        javax.swing.GroupLayout configuracoesPanelLayout = new javax.swing.GroupLayout(configuracoesPanel);
        configuracoesPanel.setLayout(configuracoesPanelLayout);
        configuracoesPanelLayout.setHorizontalGroup(
            configuracoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1145, Short.MAX_VALUE)
        );
        configuracoesPanelLayout.setVerticalGroup(
            configuracoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 721, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Configurações", new javax.swing.ImageIcon(getClass().getResource("/icons/gear.png")), configuracoesPanel); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
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
                    if (c.getNome().startsWith(searchParam)) {
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
    }//GEN-LAST:event_botaoBuscarClienteActionPerformed

    private void botaoAtendenteBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtendenteBuscarActionPerformed
        String searchParam = campoBuscaAtendentes.getText();
        if (!searchParam.isEmpty()) {
            if (idAtendenteRadioButton.isSelected()) {
                try {
                    int idBusca = Integer.parseInt(searchParam);
                    atendentesNaTabela = new ArrayList<>();

                    boolean flag = false;
                    for (Atendente a : todosAtendentes) {
                        if (a.getIdAtendente() == idBusca) {
                            atendentesNaTabela.add(a);
                            flag = true;
                            break;
                        }
                    }

                    fillAtendentesTable();

                    if (!flag) {
                        new JOptionPane().showMessageDialog(null, "Não foi possível achar um resultado", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    new JOptionPane().showMessageDialog(null, "Favor inserir somente números no campo de busca por ID", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                searchParam = searchParam.toUpperCase();
                atendentesNaTabela = new ArrayList<>();

                boolean flag = false;
                for (Atendente a : todosAtendentes) {
                    if (a.getNome().contains(searchParam)) {
                        atendentesNaTabela.add(a);
                        flag = true;
                    }
                }

                fillClientesTable();

                if (!flag) {
                    new JOptionPane().showMessageDialog(null, "Não foi possível achar um resultado", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else {
            atendentesNaTabela = todosAtendentes;
            fillAtendentesTable();
        }
    }//GEN-LAST:event_botaoAtendenteBuscarActionPerformed

    private void botaoDeselecionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDeselecionarClienteActionPerformed
        clienteSelecionado = null;
        botaoDeselecionarCliente.setEnabled(false);
        labelClienteSelecionado.setText(" ");

        botaoNovaCompra.setEnabled(false);
        botaoRealizarPagamento.setEnabled(false);
        botaoMaisInfoCliente.setEnabled(false);
    }//GEN-LAST:event_botaoDeselecionarClienteActionPerformed

    private void botaoDeselecionarAtendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDeselecionarAtendenteActionPerformed
        atendenteSelecionado = null;
        botaoDeselecionarAtendente.setEnabled(false);
        labelAtendenteSelecionado.setText(" ");

        botaoMaisInfoAtendente.setEnabled(false);
    }//GEN-LAST:event_botaoDeselecionarAtendenteActionPerformed

    private void botaoNovoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoClienteActionPerformed
        new AtendenteAccessControl(new NovoCliente(this)).setVisible(true);
    }//GEN-LAST:event_botaoNovoClienteActionPerformed

    private void botaoMaisInfoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoMaisInfoClienteActionPerformed
        new AtendenteAccessControl(new MaisInfoCliente(this, clienteSelecionado)).setVisible(true);
    }//GEN-LAST:event_botaoMaisInfoClienteActionPerformed

    private void botaoNovoAtendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoAtendenteActionPerformed
        new NovoAtendente(this).setVisible(true);
    }//GEN-LAST:event_botaoNovoAtendenteActionPerformed

    private void botaoMaisInfoAtendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoMaisInfoAtendenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoMaisInfoAtendenteActionPerformed

    private void botaoNovaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovaCompraActionPerformed
        new NovaCompra(clienteSelecionado, todosAtendentes).setVisible(true);
    }//GEN-LAST:event_botaoNovaCompraActionPerformed

    private void botaoRealizarPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRealizarPagamentoActionPerformed
        new HistoricoCompras(CompraDAO.selectComprasFromCliente(clienteSelecionado.getIdCliente()), clienteSelecionado).setVisible(true);
    }//GEN-LAST:event_botaoRealizarPagamentoActionPerformed

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
                try {
                    new MenuPrincipal().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel atendentePanel;
    private javax.swing.JPanel atendentesButtonPanel;
    private javax.swing.JButton botaoAtendenteBuscar;
    private javax.swing.JButton botaoBuscarCliente;
    private javax.swing.JButton botaoDeselecionarAtendente;
    private javax.swing.JButton botaoDeselecionarCliente;
    private javax.swing.JButton botaoMaisInfoAtendente;
    private javax.swing.JButton botaoMaisInfoCliente;
    private javax.swing.JButton botaoNovaCompra;
    private javax.swing.JButton botaoNovoAtendente;
    private javax.swing.JButton botaoNovoCliente;
    private javax.swing.JButton botaoRealizarPagamento;
    private javax.swing.ButtonGroup buscaAtendentesButtonGroup;
    private javax.swing.ButtonGroup buscaClientesButtonGroup;
    private javax.swing.JTextField campoBuscaAtendentes;
    private javax.swing.JTextField campoBuscaClientes;
    private javax.swing.JPanel clientePanel;
    private javax.swing.JPanel clientesButtonPanel;
    private javax.swing.JPanel configuracoesPanel;
    private javax.swing.JRadioButton idAtendenteRadioButton;
    private javax.swing.JRadioButton idClienteRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelAtendenteSelecionado;
    private javax.swing.JLabel labelClienteSelecionado;
    private javax.swing.JRadioButton nomeAtendenteRadioButton;
    private javax.swing.JRadioButton nomeClienteRadioButton;
    private javax.swing.JTable tabelaAtendentes;
    private javax.swing.JTable tabelaClientes;
    // End of variables declaration//GEN-END:variables
}
