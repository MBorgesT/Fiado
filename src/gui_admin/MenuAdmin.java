/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_admin;

import java.util.ArrayList;
import models.Cliente;
import dao.ClienteDAO;
import dao.AtendenteDAO;
import dao.CompraDAO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Atendente;
import validation.BuscaClienteAdminValidation;

/**
 *
 * @author matheus
 */
public class MenuAdmin extends javax.swing.JFrame {

    private ArrayList<Cliente> todosClientes;
    private ArrayList<Atendente> todosAtendentes;

    private ArrayList<Cliente> clientesNaTabela;
    private ArrayList<Atendente> atendentesNaTabela;

    private Cliente clienteSelecionado;
    private Atendente atendenteSelecionado;

    public MenuAdmin() {
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
                int row = tabelaClientes.rowAtPoint(evt.getPoint());
                if (row >= 0) {
                    selecionarCliente(clientesNaTabela.get(row));
                }
            }
        });
    }

    private void criarTabelaAtendenteListeners() {
        tabelaAtendentes.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tabelaAtendentes.rowAtPoint(evt.getPoint());
                if (row >= 0) {
                    selecionarAtendente(atendentesNaTabela.get(row));
                }
            }
        });
    }

    private void fillTables() {
        fillClientesTable();
        fillAtendentesTable();
    }

    private void fillClientesTable() {
        DefaultTableModel tabelaClientesModel = (DefaultTableModel) tabelaClientes.getModel();

        tabelaClientesModel.setRowCount(0);
        for (Cliente c : clientesNaTabela) {
            tabelaClientesModel.addRow(c.clienteObjectArrayComplete());
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

        if (c.isAtivo()) {
            botaoDesAtivar.setText("Desativar");
            ImageIcon icon = new ImageIcon(getClass().getResource("/icons/toggle-off.png"));
            botaoDesAtivar.setIcon(icon);
        } else {
            botaoDesAtivar.setText("Ativar");
            ImageIcon icon = new ImageIcon(getClass().getResource("/icons/toggle-on.png"));
            botaoDesAtivar.setIcon(icon);
        }

        botaoDesAtivar.setEnabled(true);
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
        botaoBuscarCliente = new javax.swing.JButton();
        clientesButtonPanel = new javax.swing.JPanel();
        botaoDesAtivar = new javax.swing.JButton();
        botaoMaisInfoCliente1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        labelClienteSelecionado = new javax.swing.JLabel();
        botaoDeselecionarCliente = new javax.swing.JButton();
        formPanel = new javax.swing.JPanel();
        campoBuscaNomeId = new javax.swing.JTextField();
        idClienteRadioButton = new javax.swing.JRadioButton();
        nomeClienteRadioButton = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        comboBoxBuscaValor = new javax.swing.JComboBox<>();
        campoBuscaValor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        checkBoxSim = new javax.swing.JCheckBox();
        checkBoxNao = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        campoDiasNotificacao = new javax.swing.JTextField();
        botaoLimparBuscaCliente = new javax.swing.JButton();
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
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu do Administrador");
        setResizable(false);

        jTabbedPane1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        tabelaClientes.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Valor em débito", "Compra mais antiga em débito", "Ativo?"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
            tabelaClientes.getColumnModel().getColumn(1).setPreferredWidth(320);
            tabelaClientes.getColumnModel().getColumn(2).setResizable(false);
            tabelaClientes.getColumnModel().getColumn(2).setPreferredWidth(125);
            tabelaClientes.getColumnModel().getColumn(3).setResizable(false);
            tabelaClientes.getColumnModel().getColumn(3).setPreferredWidth(200);
            tabelaClientes.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Busca:");

        botaoBuscarCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        botaoBuscarCliente.setText("Buscar");
        botaoBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBuscarClienteActionPerformed(evt);
            }
        });

        clientesButtonPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        botaoDesAtivar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoDesAtivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/toggle-on.png"))); // NOI18N
        botaoDesAtivar.setText("Desativar");
        botaoDesAtivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDesAtivarActionPerformed(evt);
            }
        });

        botaoMaisInfoCliente1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoMaisInfoCliente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/more-info.png"))); // NOI18N
        botaoMaisInfoCliente1.setText("Mais Informações");
        botaoMaisInfoCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoMaisInfoCliente1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout clientesButtonPanelLayout = new javax.swing.GroupLayout(clientesButtonPanel);
        clientesButtonPanel.setLayout(clientesButtonPanelLayout);
        clientesButtonPanelLayout.setHorizontalGroup(
            clientesButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientesButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clientesButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoMaisInfoCliente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoDesAtivar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        clientesButtonPanelLayout.setVerticalGroup(
            clientesButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientesButtonPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoDesAtivar)
                .addGap(18, 18, 18)
                .addComponent(botaoMaisInfoCliente1)
                .addContainerGap())
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

        formPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        campoBuscaNomeId.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        campoBuscaNomeId.setName("campoBuscaNomeId"); // NOI18N

        buscaClientesButtonGroup.add(idClienteRadioButton);
        idClienteRadioButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        idClienteRadioButton.setText("ID");
        idClienteRadioButton.setName("idClienteRadioButton"); // NOI18N

        buscaClientesButtonGroup.add(nomeClienteRadioButton);
        nomeClienteRadioButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        nomeClienteRadioButton.setSelected(true);
        nomeClienteRadioButton.setText("Nome");
        nomeClienteRadioButton.setName("nomeClienteRadioButton"); // NOI18N

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Valor em débito:");

        comboBoxBuscaValor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        comboBoxBuscaValor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acima de", "Abaixo de" }));
        comboBoxBuscaValor.setName("comboBoxBuscaValor"); // NOI18N

        campoBuscaValor.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        campoBuscaValor.setName("campoBuscaValor"); // NOI18N

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Bloqueado:");

        checkBoxSim.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        checkBoxSim.setSelected(true);
        checkBoxSim.setText("Sim");
        checkBoxSim.setName("checkBoxSim"); // NOI18N

        checkBoxNao.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        checkBoxNao.setSelected(true);
        checkBoxNao.setText("Não");
        checkBoxNao.setName("checkBoxNao"); // NOI18N

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("Dias passados com compras não pagas:");

        campoDiasNotificacao.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        campoDiasNotificacao.setName("campoDiasNotificacao"); // NOI18N

        javax.swing.GroupLayout formPanelLayout = new javax.swing.GroupLayout(formPanel);
        formPanel.setLayout(formPanelLayout);
        formPanelLayout.setHorizontalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoDiasNotificacao)
                    .addComponent(campoBuscaNomeId)
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formPanelLayout.createSequentialGroup()
                                .addComponent(nomeClienteRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(idClienteRadioButton))
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addGroup(formPanelLayout.createSequentialGroup()
                                .addComponent(checkBoxSim)
                                .addGap(18, 18, 18)
                                .addComponent(checkBoxNao))
                            .addComponent(jLabel9)
                            .addGroup(formPanelLayout.createSequentialGroup()
                                .addComponent(comboBoxBuscaValor, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(campoBuscaValor, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addContainerGap())
        );
        formPanelLayout.setVerticalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idClienteRadioButton)
                    .addComponent(nomeClienteRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoBuscaNomeId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxBuscaValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoBuscaValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoDiasNotificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkBoxSim)
                    .addComponent(checkBoxNao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botaoLimparBuscaCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoLimparBuscaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/eraser.png"))); // NOI18N
        botaoLimparBuscaCliente.setText("Limpar");
        botaoLimparBuscaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLimparBuscaClienteActionPerformed(evt);
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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(clientesButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clientePanelLayout.createSequentialGroup()
                        .addComponent(botaoLimparBuscaCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoBuscarCliente))
                    .addComponent(formPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        clientePanelLayout.setVerticalGroup(
            clientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clientePanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(formPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(clientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoBuscarCliente)
                            .addComponent(botaoLimparBuscaCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(clientesButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
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
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bread-48.png"))); // NOI18N
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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
                    .addGroup(atendentePanelLayout.createSequentialGroup()
                        .addGroup(atendentePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomeAtendenteRadioButton)
                            .addComponent(idAtendenteRadioButton)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoBuscaAtendentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoAtendenteBuscar)
                        .addGap(184, 184, 184)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(atendentesButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Atendente", new javax.swing.ImageIcon(getClass().getResource("/icons/bread-48.png")), atendentePanel); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/warning-48.png"))); // NOI18N
        jLabel3.setText("Avisos e Bloqueios:");

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("<html>Limite de dias com conta não paga para mostrar aviso ao realizar uma compra:</html>");

        jTextField1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jTextField1)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("Nova senha:");

        jPasswordField1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jPasswordField2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("Digite novamente a senha:");

        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("<html>A senha deve conter pelo menos 8 caracteres</html>");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordField2)
                    .addComponent(jPasswordField1)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/padlock-48.png"))); // NOI18N
        jLabel11.setText("Senha de Administrador:");

        javax.swing.GroupLayout configuracoesPanelLayout = new javax.swing.GroupLayout(configuracoesPanel);
        configuracoesPanel.setLayout(configuracoesPanelLayout);
        configuracoesPanelLayout.setHorizontalGroup(
            configuracoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(configuracoesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(configuracoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jLabel11)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(812, Short.MAX_VALUE))
        );
        configuracoesPanelLayout.setVerticalGroup(
            configuracoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(configuracoesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(369, Short.MAX_VALUE))
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
        if (new BuscaClienteAdminValidation(formPanel).validate()) {
            clientesNaTabela = new ArrayList<>();
            boolean flag;

            for (Cliente cliente : todosClientes) {
                flag = true;

                if (!campoBuscaNomeId.getText().isEmpty()) {
                    String searchParam = campoBuscaNomeId.getText();

                    if (nomeClienteRadioButton.isSelected()) {
                        searchParam = searchParam.toUpperCase();

                        if (!cliente.getNome().contains(searchParam)) {
                            flag = false;
                        }
                    } else {
                        if (Integer.parseInt(searchParam) != cliente.getIdCliente()) {
                            flag = false;
                        }
                    }
                }

                if (!campoBuscaValor.getText().isEmpty()) {
                    float searchParam = Float.parseFloat(campoBuscaValor.getText());
                    float valorEmDebito = ClienteDAO.calcularValorEmDebito(cliente.getIdCliente());

                    if (comboBoxBuscaValor.getSelectedIndex() == 0 && valorEmDebito <= searchParam) {
                        flag = false;
                    } else if (comboBoxBuscaValor.getSelectedIndex() == 1 && valorEmDebito >= searchParam) {
                        flag = false;
                    }
                }

                if (!campoDiasNotificacao.getText().isEmpty()) {
                    int diasNotificacao = Integer.parseInt(campoDiasNotificacao.getText());
                    if (!CompraDAO.clienteExcedeDiasNotificacao(cliente.getIdCliente(), diasNotificacao)) {
                        flag = false;
                    }
                }

                if (!checkBoxSim.isSelected() && cliente.isAtivo()) {
                    flag = false;
                }

                if (!checkBoxNao.isSelected() && !cliente.isAtivo()) {
                    flag = false;
                }

                if (flag) {
                    clientesNaTabela.add(cliente);
                }

            }

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

        botaoDesAtivar.setEnabled(false);
    }//GEN-LAST:event_botaoDeselecionarClienteActionPerformed

    private void botaoDeselecionarAtendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDeselecionarAtendenteActionPerformed
        atendenteSelecionado = null;
        botaoDeselecionarAtendente.setEnabled(false);
        labelAtendenteSelecionado.setText(" ");

        botaoMaisInfoAtendente.setEnabled(false);
    }//GEN-LAST:event_botaoDeselecionarAtendenteActionPerformed

    private void botaoDesAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDesAtivarActionPerformed
        String acao;
        if (clienteSelecionado.isAtivo()) {
            acao = "desativar";
        } else {
            acao = "ativar";
        }

        String[] options = {"SIM", "NÃO"};
        int reply = JOptionPane.showOptionDialog(null, "Você realmente deseja " + acao + " a conta do cliente?", "Atenção",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                options, options[0]);

        if (reply == 0) {
            ClienteDAO.updateEstadoAtivoCliente(clienteSelecionado.getIdCliente(), !clienteSelecionado.isAtivo());
            clienteSelecionado.setAtivo(!clienteSelecionado.isAtivo());
            selecionarCliente(clienteSelecionado);
        }
    }//GEN-LAST:event_botaoDesAtivarActionPerformed

    private void botaoNovoAtendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoAtendenteActionPerformed
        new NovoAtendente(this).setVisible(true);
    }//GEN-LAST:event_botaoNovoAtendenteActionPerformed

    private void botaoMaisInfoAtendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoMaisInfoAtendenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoMaisInfoAtendenteActionPerformed

    private void botaoMaisInfoCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoMaisInfoCliente1ActionPerformed
        new MaisInfoClienteAdmin(clienteSelecionado).setVisible(true);
    }//GEN-LAST:event_botaoMaisInfoCliente1ActionPerformed

    private void botaoLimparBuscaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparBuscaClienteActionPerformed
        campoBuscaNomeId.setText("");
        campoBuscaValor.setText("");
        campoDiasNotificacao.setText("");

        checkBoxSim.setSelected(true);
        checkBoxNao.setSelected(true);

        clientesNaTabela = todosClientes;
        fillClientesTable();
    }//GEN-LAST:event_botaoLimparBuscaClienteActionPerformed

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
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel atendentePanel;
    private javax.swing.JPanel atendentesButtonPanel;
    private javax.swing.JButton botaoAtendenteBuscar;
    private javax.swing.JButton botaoBuscarCliente;
    private javax.swing.JButton botaoDesAtivar;
    private javax.swing.JButton botaoDeselecionarAtendente;
    private javax.swing.JButton botaoDeselecionarCliente;
    private javax.swing.JButton botaoLimparBuscaCliente;
    private javax.swing.JButton botaoMaisInfoAtendente;
    private javax.swing.JButton botaoMaisInfoCliente1;
    private javax.swing.JButton botaoNovoAtendente;
    private javax.swing.ButtonGroup buscaAtendentesButtonGroup;
    private javax.swing.ButtonGroup buscaClientesButtonGroup;
    private javax.swing.JTextField campoBuscaAtendentes;
    private javax.swing.JTextField campoBuscaNomeId;
    private javax.swing.JTextField campoBuscaValor;
    private javax.swing.JTextField campoDiasNotificacao;
    private javax.swing.JCheckBox checkBoxNao;
    private javax.swing.JCheckBox checkBoxSim;
    private javax.swing.JPanel clientePanel;
    private javax.swing.JPanel clientesButtonPanel;
    private javax.swing.JComboBox<String> comboBoxBuscaValor;
    private javax.swing.JPanel configuracoesPanel;
    private javax.swing.JPanel formPanel;
    private javax.swing.JRadioButton idAtendenteRadioButton;
    private javax.swing.JRadioButton idClienteRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelAtendenteSelecionado;
    private javax.swing.JLabel labelClienteSelecionado;
    private javax.swing.JRadioButton nomeAtendenteRadioButton;
    private javax.swing.JRadioButton nomeClienteRadioButton;
    private javax.swing.JTable tabelaAtendentes;
    private javax.swing.JTable tabelaClientes;
    // End of variables declaration//GEN-END:variables
}
