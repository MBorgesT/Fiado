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
import dao.ConfiguracaoDAO;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import models.Atendente;
import security.Hash;
import validation.BuscaClienteAdminValidation;
import validation.ConfiguracaoSenhaFormValidation;

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

    private boolean diasNotificacaoAlterado;
    private boolean senhaAlterada;

    public MenuAdmin() {
        initComponents();

        todosClientes = ClienteDAO.selectAllClientes();
        todosAtendentes = AtendenteDAO.selectTodosAtendentes();

        clientesNaTabela = todosClientes;
        atendentesNaTabela = todosAtendentes;

        botaoDeselecionarCliente.doClick();
        botaoDeselecionarAtendente.doClick();

        fillTables();

        // pagina de configuracoes
        this.diasNotificacaoAlterado = false;
        this.senhaAlterada = false;

        campoLimiteDiasAviso.setText(String.valueOf(ConfiguracaoDAO.selectDiasNotificacao()));

        setupConfiguracao();
    }

    private void setupConfiguracao() {
        campoLimiteDiasAviso.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
                botaoCancelarEdicao.setEnabled(true);
                botaoSalvarEdicao.setEnabled(true);
                diasNotificacaoAlterado = true;
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                botaoCancelarEdicao.setEnabled(true);
                botaoSalvarEdicao.setEnabled(true);
                diasNotificacaoAlterado = true;
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                botaoCancelarEdicao.setEnabled(true);
                botaoSalvarEdicao.setEnabled(true);
                diasNotificacaoAlterado = true;
            }
        });

        campoNovaSenha.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
                botaoCancelarEdicao.setEnabled(true);
                botaoSalvarEdicao.setEnabled(true);
                senhaAlterada = true;
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                botaoCancelarEdicao.setEnabled(true);
                botaoSalvarEdicao.setEnabled(true);
                senhaAlterada = true;
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                botaoCancelarEdicao.setEnabled(true);
                botaoSalvarEdicao.setEnabled(true);
                senhaAlterada = true;
            }
        });

        campoConfirmarNovaSenha.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
                botaoCancelarEdicao.setEnabled(true);
                botaoSalvarEdicao.setEnabled(true);
                senhaAlterada = true;
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                botaoCancelarEdicao.setEnabled(true);
                botaoSalvarEdicao.setEnabled(true);
                senhaAlterada = true;
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                botaoCancelarEdicao.setEnabled(true);
                botaoSalvarEdicao.setEnabled(true);
                senhaAlterada = true;
            }
        });
    }

    private void setupTabelaClientes() {
        tabelaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tabelaClientes.rowAtPoint(evt.getPoint());
                if (row >= 0) {
                    selecionarCliente(clientesNaTabela.get(row));
                }
            }
        });

        tabelaClientes.getColumnModel().getColumn(4).setCellRenderer(new SimNaoRenderer());
    }

    private void setupTabelaAtendentes() {
        tabelaAtendentes.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tabelaAtendentes.rowAtPoint(evt.getPoint());
                if (row >= 0) {
                    selecionarAtendente(atendentesNaTabela.get(row));
                }
            }
        });

        tabelaAtendentes.getColumnModel().getColumn(2).setCellRenderer(new SimNaoRenderer());
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

        setupTabelaClientes();
    }

    private void fillAtendentesTable() {
        DefaultTableModel tabelaAtendentesModel = (DefaultTableModel) tabelaAtendentes.getModel();

        tabelaAtendentesModel.setRowCount(0);
        for (Atendente a : atendentesNaTabela) {
            tabelaAtendentesModel.addRow(a.atendenteObjectArray());
        }

        setupTabelaAtendentes();
    }

    private void selecionarCliente(Cliente c) {
        clienteSelecionado = c;
        botaoDeselecionarCliente.setEnabled(true);
        labelClienteSelecionado.setText("<html>" + c.getNome() + "</html>");

        if (c.isAtivo()) {
            botaoDesAtivarCliente.setText("Desativar");
            ImageIcon icon = new ImageIcon(getClass().getResource("/icons/toggle-off.png"));
            botaoDesAtivarCliente.setIcon(icon);
        } else {
            botaoDesAtivarCliente.setText("Ativar");
            ImageIcon icon = new ImageIcon(getClass().getResource("/icons/toggle-on.png"));
            botaoDesAtivarCliente.setIcon(icon);
        }

        botaoDesAtivarCliente.setEnabled(true);
        botaoMaisInfoCliente.setEnabled(true);
    }

    private void selecionarAtendente(Atendente a) {
        atendenteSelecionado = a;
        botaoDeselecionarAtendente.setEnabled(true);
        labelAtendenteSelecionado.setText("<html>" + a.getNome() + "</html>");

        if (a.isAtivo()) {
            botaoDesAtivarAtendente.setText("Desativar");
            ImageIcon icon = new ImageIcon(getClass().getResource("/icons/toggle-on.png"));
            botaoDesAtivarAtendente.setIcon(icon);
        } else {
            botaoDesAtivarAtendente.setText("Ativar");
            ImageIcon icon = new ImageIcon(getClass().getResource("/icons/toggle-off.png"));
            botaoDesAtivarAtendente.setIcon(icon);
        }

        botaoDesAtivarAtendente.setEnabled(true);
        botaoMaisInfoAtendente.setEnabled(true);
    }

    public void resetTabelaClientes() {
        todosClientes = new ClienteDAO().selectAllClientes();
        clientesNaTabela = todosClientes;
        fillClientesTable();
    }

    public void resetTabelaAtendentes() {
        todosAtendentes = new AtendenteDAO().selectTodosAtendentesAtivos();
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
        botaoDesAtivarCliente = new javax.swing.JButton();
        botaoMaisInfoCliente = new javax.swing.JButton();
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
        checkBoxClienteSim = new javax.swing.JCheckBox();
        checkBoxClienteNao = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        campoDiasNotificacao = new javax.swing.JTextField();
        botaoLimparBuscaCliente = new javax.swing.JButton();
        atendentePanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaAtendentes = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        botaoAtendenteBuscar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        labelAtendenteSelecionado = new javax.swing.JLabel();
        botaoDeselecionarAtendente = new javax.swing.JButton();
        atendentesButtonPanel = new javax.swing.JPanel();
        botaoDesAtivarAtendente = new javax.swing.JButton();
        botaoNovoAtendente = new javax.swing.JButton();
        botaoMaisInfoAtendente = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        campoBuscaAtendentes = new javax.swing.JTextField();
        idAtendenteRadioButton = new javax.swing.JRadioButton();
        nomeAtendenteRadioButton = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        checkBoxAtendenteSim = new javax.swing.JCheckBox();
        checkBoxAtendenteNao = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        configuracoesPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        campoLimiteDiasAviso = new javax.swing.JTextField();
        senhaFormPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        campoNovaSenha = new javax.swing.JPasswordField();
        campoConfirmarNovaSenha = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        botaoCancelarEdicao = new javax.swing.JButton();
        botaoSalvarEdicao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu do Administrador");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/icons/administrator-48.png")).getImage());
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
            tabelaClientes.getColumnModel().getColumn(4).setPreferredWidth(60);
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

        botaoDesAtivarCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoDesAtivarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/toggle-on.png"))); // NOI18N
        botaoDesAtivarCliente.setText("Desativar");
        botaoDesAtivarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDesAtivarClienteActionPerformed(evt);
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

        javax.swing.GroupLayout clientesButtonPanelLayout = new javax.swing.GroupLayout(clientesButtonPanel);
        clientesButtonPanel.setLayout(clientesButtonPanelLayout);
        clientesButtonPanelLayout.setHorizontalGroup(
            clientesButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientesButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clientesButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoMaisInfoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoDesAtivarCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        clientesButtonPanelLayout.setVerticalGroup(
            clientesButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientesButtonPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoDesAtivarCliente)
                .addGap(18, 18, 18)
                .addComponent(botaoMaisInfoCliente)
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
        jLabel8.setText("Ativo:");

        checkBoxClienteSim.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        checkBoxClienteSim.setSelected(true);
        checkBoxClienteSim.setText("Sim");
        checkBoxClienteSim.setName("checkBoxClienteSim"); // NOI18N

        checkBoxClienteNao.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        checkBoxClienteNao.setSelected(true);
        checkBoxClienteNao.setText("Não");
        checkBoxClienteNao.setName("checkBoxClienteNao"); // NOI18N

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
                                .addComponent(checkBoxClienteSim)
                                .addGap(18, 18, 18)
                                .addComponent(checkBoxClienteNao))
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
                    .addComponent(checkBoxClienteSim)
                    .addComponent(checkBoxClienteNao))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(clientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botaoBuscarCliente)
                            .addComponent(botaoLimparBuscaCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
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
                "ID", "Nome", "Ativo?"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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
            tabelaAtendentes.getColumnModel().getColumn(2).setResizable(false);
            tabelaAtendentes.getColumnModel().getColumn(2).setPreferredWidth(60);
        }

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Busca:");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
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

        botaoDesAtivarAtendente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoDesAtivarAtendente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/toggle-on.png"))); // NOI18N
        botaoDesAtivarAtendente.setText("Desativar");
        botaoDesAtivarAtendente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDesAtivarAtendenteActionPerformed(evt);
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

        botaoMaisInfoAtendente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoMaisInfoAtendente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/more-info.png"))); // NOI18N
        botaoMaisInfoAtendente.setText("Mais Informações");
        botaoMaisInfoAtendente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoMaisInfoAtendenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout atendentesButtonPanelLayout = new javax.swing.GroupLayout(atendentesButtonPanel);
        atendentesButtonPanel.setLayout(atendentesButtonPanelLayout);
        atendentesButtonPanelLayout.setHorizontalGroup(
            atendentesButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(atendentesButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(atendentesButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoNovoAtendente, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                    .addComponent(botaoDesAtivarAtendente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                    .addComponent(botaoMaisInfoAtendente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE))
                .addContainerGap())
        );
        atendentesButtonPanelLayout.setVerticalGroup(
            atendentesButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(atendentesButtonPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoDesAtivarAtendente)
                .addGap(18, 18, 18)
                .addComponent(botaoMaisInfoAtendente)
                .addGap(18, 18, 18)
                .addComponent(botaoNovoAtendente)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        campoBuscaAtendentes.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        buscaAtendentesButtonGroup.add(idAtendenteRadioButton);
        idAtendenteRadioButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        idAtendenteRadioButton.setText("ID");

        buscaAtendentesButtonGroup.add(nomeAtendenteRadioButton);
        nomeAtendenteRadioButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        nomeAtendenteRadioButton.setSelected(true);
        nomeAtendenteRadioButton.setText("Nome");

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setText("Ativo:");

        checkBoxAtendenteSim.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        checkBoxAtendenteSim.setSelected(true);
        checkBoxAtendenteSim.setText("Sim");

        checkBoxAtendenteNao.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        checkBoxAtendenteNao.setSelected(true);
        checkBoxAtendenteNao.setText("Não");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoBuscaAtendentes)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(nomeAtendenteRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(idAtendenteRadioButton))
                            .addComponent(jLabel14)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(checkBoxAtendenteSim)
                                .addGap(18, 18, 18)
                                .addComponent(checkBoxAtendenteNao)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeAtendenteRadioButton)
                    .addComponent(idAtendenteRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoBuscaAtendentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkBoxAtendenteSim)
                    .addComponent(checkBoxAtendenteNao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/eraser.png"))); // NOI18N
        jButton1.setText("Limpar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout atendentePanelLayout = new javax.swing.GroupLayout(atendentePanel);
        atendentePanel.setLayout(atendentePanelLayout);
        atendentePanelLayout.setHorizontalGroup(
            atendentePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(atendentePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(atendentePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(atendentesButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(atendentePanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(atendentePanelLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoAtendenteBuscar)))
                .addContainerGap())
        );
        atendentePanelLayout.setVerticalGroup(
            atendentePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(atendentePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(atendentePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
                    .addGroup(atendentePanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(atendentePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(botaoAtendenteBuscar))
                        .addGap(80, 80, 80)
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

        campoLimiteDiasAviso.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(campoLimiteDiasAviso)
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
                .addComponent(campoLimiteDiasAviso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        senhaFormPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("Nova senha:");

        campoNovaSenha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        campoNovaSenha.setName("senha"); // NOI18N

        campoConfirmarNovaSenha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        campoConfirmarNovaSenha.setName("confirmarSenha"); // NOI18N

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("Digite novamente a senha:");

        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("<html>A senha deve conter pelo menos 8 caracteres</html>");

        javax.swing.GroupLayout senhaFormPanelLayout = new javax.swing.GroupLayout(senhaFormPanel);
        senhaFormPanel.setLayout(senhaFormPanelLayout);
        senhaFormPanelLayout.setHorizontalGroup(
            senhaFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(senhaFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(senhaFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoConfirmarNovaSenha)
                    .addComponent(campoNovaSenha)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE))
                .addContainerGap())
        );
        senhaFormPanelLayout.setVerticalGroup(
            senhaFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, senhaFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoConfirmarNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/padlock-48.png"))); // NOI18N
        jLabel11.setText("Senha de Administrador:");

        botaoCancelarEdicao.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoCancelarEdicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
        botaoCancelarEdicao.setText("Cancelar Edição");
        botaoCancelarEdicao.setEnabled(false);
        botaoCancelarEdicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarEdicaoActionPerformed(evt);
            }
        });

        botaoSalvarEdicao.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoSalvarEdicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save-32.png"))); // NOI18N
        botaoSalvarEdicao.setText("Salvar");
        botaoSalvarEdicao.setEnabled(false);
        botaoSalvarEdicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarEdicaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout configuracoesPanelLayout = new javax.swing.GroupLayout(configuracoesPanel);
        configuracoesPanel.setLayout(configuracoesPanelLayout);
        configuracoesPanelLayout.setHorizontalGroup(
            configuracoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(configuracoesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(configuracoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(configuracoesPanelLayout.createSequentialGroup()
                        .addGroup(configuracoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jLabel11)
                            .addComponent(senhaFormPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 812, Short.MAX_VALUE))
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, configuracoesPanelLayout.createSequentialGroup()
                        .addComponent(botaoCancelarEdicao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoSalvarEdicao)))
                .addContainerGap())
        );
        configuracoesPanelLayout.setVerticalGroup(
            configuracoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(configuracoesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(senhaFormPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(configuracoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSalvarEdicao)
                    .addComponent(botaoCancelarEdicao))
                .addContainerGap())
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

                if (!checkBoxClienteSim.isSelected() && cliente.isAtivo()) {
                    flag = false;
                }

                if (!checkBoxClienteNao.isSelected() && !cliente.isAtivo()) {
                    flag = false;
                }

                if (flag) {
                    clientesNaTabela.add(cliente);
                }

            }

            fillClientesTable();
            botaoDeselecionarCliente.doClick();
        }
    }//GEN-LAST:event_botaoBuscarClienteActionPerformed

    private void botaoAtendenteBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtendenteBuscarActionPerformed
        String searchParam = campoBuscaAtendentes.getText().toUpperCase();

        boolean campoBuscaVazio = campoBuscaAtendentes.getText().equals("");

        boolean flagNumberParseEx = true;
        if (idAtendenteRadioButton.isSelected() && !campoBuscaVazio) {
            try {
                Integer.parseInt(searchParam);
            } catch (NumberFormatException e) {
                flagNumberParseEx = false;
                JOptionPane.showMessageDialog(null, "O campo de busca por ID só deve conter valores numéricos", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        }

        boolean flagCheckBoxes = true;
        if (!checkBoxAtendenteSim.isSelected() && !checkBoxAtendenteNao.isSelected()) {
            flagCheckBoxes = false;
            JOptionPane.showMessageDialog(null, "Você precisa informar se deseja buscar por atendentes ativos ou não", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }

        if (flagNumberParseEx && flagCheckBoxes) {
            atendentesNaTabela = new ArrayList<>();

            boolean flag;
            for (Atendente atendente : todosAtendentes) {
                flag = true;

                if (!campoBuscaVazio) {
                    if (nomeAtendenteRadioButton.isSelected()) {
                        if (!atendente.getNome().contains(searchParam)) {
                            flag = false;
                        }
                    } else {
                        if (atendente.getIdAtendente() != Integer.parseInt(searchParam)) {
                            flag = false;
                        }
                    }
                }

                if (!checkBoxAtendenteSim.isSelected() && atendente.isAtivo()) {
                    flag = false;
                }

                if (!checkBoxAtendenteNao.isSelected() && !atendente.isAtivo()) {
                    flag = false;
                }

                if (flag) {
                    atendentesNaTabela.add(atendente);
                }

            }

            fillAtendentesTable();
            botaoDesAtivarAtendente.doClick();
        }
    }//GEN-LAST:event_botaoAtendenteBuscarActionPerformed

    private void botaoDeselecionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDeselecionarClienteActionPerformed
        clienteSelecionado = null;
        botaoDeselecionarCliente.setEnabled(false);
        labelClienteSelecionado.setText(" ");

        botaoDesAtivarCliente.setEnabled(false);
        botaoMaisInfoCliente.setEnabled(false);
    }//GEN-LAST:event_botaoDeselecionarClienteActionPerformed

    private void botaoDeselecionarAtendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDeselecionarAtendenteActionPerformed
        atendenteSelecionado = null;
        botaoDeselecionarAtendente.setEnabled(false);
        labelAtendenteSelecionado.setText(" ");

        botaoMaisInfoAtendente.setEnabled(false);
        botaoDesAtivarAtendente.setEnabled(false);
    }//GEN-LAST:event_botaoDeselecionarAtendenteActionPerformed

    private void botaoDesAtivarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDesAtivarClienteActionPerformed
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
            fillClientesTable();
        }
    }//GEN-LAST:event_botaoDesAtivarClienteActionPerformed

    private void botaoNovoAtendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoAtendenteActionPerformed
        new NovoAtendente(this).setVisible(true);
    }//GEN-LAST:event_botaoNovoAtendenteActionPerformed

    private void botaoDesAtivarAtendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDesAtivarAtendenteActionPerformed
        String acao;
        if (atendenteSelecionado.isAtivo()) {
            acao = "desativar";
        } else {
            acao = "ativar";
        }

        String[] options = {"SIM", "NÃO"};
        int reply = JOptionPane.showOptionDialog(null, "Você realmente deseja " + acao + " a conta do atendente?", "Atenção",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                options, options[0]);

        if (reply == 0) {
            AtendenteDAO.updateEstadoAtivoAtendente(atendenteSelecionado.getIdAtendente(), !atendenteSelecionado.isAtivo());
            atendenteSelecionado.setAtivo(!atendenteSelecionado.isAtivo());
            selecionarAtendente(atendenteSelecionado);
            fillAtendentesTable();
        }
    }//GEN-LAST:event_botaoDesAtivarAtendenteActionPerformed

    private void botaoMaisInfoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoMaisInfoClienteActionPerformed
        new MaisInfoClienteAdmin(clienteSelecionado).setVisible(true);
    }//GEN-LAST:event_botaoMaisInfoClienteActionPerformed

    private void botaoLimparBuscaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparBuscaClienteActionPerformed
        campoBuscaNomeId.setText("");
        campoBuscaValor.setText("");
        campoDiasNotificacao.setText("");

        checkBoxClienteSim.setSelected(true);
        checkBoxClienteNao.setSelected(true);

        clientesNaTabela = todosClientes;
        fillClientesTable();
    }//GEN-LAST:event_botaoLimparBuscaClienteActionPerformed

    private void botaoMaisInfoAtendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoMaisInfoAtendenteActionPerformed
        new MaisInfoAtendenteAdmin(atendenteSelecionado).setVisible(true);
    }//GEN-LAST:event_botaoMaisInfoAtendenteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        campoBuscaAtendentes.setText("");
        checkBoxAtendenteSim.setSelected(true);
        checkBoxAtendenteNao.setSelected(true);
        fillAtendentesTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botaoCancelarEdicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarEdicaoActionPerformed
        campoLimiteDiasAviso.setText(String.valueOf(ConfiguracaoDAO.selectDiasNotificacao()));

        campoNovaSenha.setText("");
        campoConfirmarNovaSenha.setText("");
    }//GEN-LAST:event_botaoCancelarEdicaoActionPerformed

    private void botaoSalvarEdicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarEdicaoActionPerformed
        boolean flagDias = true, flagSenha = true;

        if (diasNotificacaoAlterado) {
            if (!campoDiasNotificacao.getText().isEmpty()) {
                try {
                    int novoDiasNotificacao = Integer.parseInt(campoDiasNotificacao.getText());
                    ConfiguracaoDAO.updateDiasNotificacao(novoDiasNotificacao);
                    diasNotificacaoAlterado = false;
                    JOptionPane.showMessageDialog(null, "Limite de dias para notificação atualizado com sucesso", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException e) {
                    flagDias = false;
                    JOptionPane.showMessageDialog(null, "O valor de limite de dias para notificação precisa ser numérico", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                flagDias = false;
                JOptionPane.showMessageDialog(null, "O campo de limite de dias para notificação não pode estar vazio", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        if (senhaAlterada) {
            if (new ConfiguracaoSenhaFormValidation(senhaFormPanel).validate()) {
                byte[] salt = Hash.generateSalt();
                String cleanPw = String.valueOf(campoNovaSenha.getPassword());
                String hashedPw = Hash.hashPassword(cleanPw, salt).get();

                if (ConfiguracaoDAO.updateSenha(hashedPw, salt)) {
                    campoNovaSenha.setText("");
                    campoConfirmarNovaSenha.setText("");
                    JOptionPane.showMessageDialog(null, "Senha atualizada com sucesso", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    flagSenha = false;
                }
            }else{
                flagSenha = false;
            }
        }

        if (flagDias && flagSenha) {
            botaoCancelarEdicao.setEnabled(false);
            botaoSalvarEdicao.setEnabled(false);
        }
    }//GEN-LAST:event_botaoSalvarEdicaoActionPerformed

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
    private javax.swing.JButton botaoCancelarEdicao;
    private javax.swing.JButton botaoDesAtivarAtendente;
    private javax.swing.JButton botaoDesAtivarCliente;
    private javax.swing.JButton botaoDeselecionarAtendente;
    private javax.swing.JButton botaoDeselecionarCliente;
    private javax.swing.JButton botaoLimparBuscaCliente;
    private javax.swing.JButton botaoMaisInfoAtendente;
    private javax.swing.JButton botaoMaisInfoCliente;
    private javax.swing.JButton botaoNovoAtendente;
    private javax.swing.JButton botaoSalvarEdicao;
    private javax.swing.ButtonGroup buscaAtendentesButtonGroup;
    private javax.swing.ButtonGroup buscaClientesButtonGroup;
    private javax.swing.JTextField campoBuscaAtendentes;
    private javax.swing.JTextField campoBuscaNomeId;
    private javax.swing.JTextField campoBuscaValor;
    private javax.swing.JPasswordField campoConfirmarNovaSenha;
    private javax.swing.JTextField campoDiasNotificacao;
    private javax.swing.JTextField campoLimiteDiasAviso;
    private javax.swing.JPasswordField campoNovaSenha;
    private javax.swing.JCheckBox checkBoxAtendenteNao;
    private javax.swing.JCheckBox checkBoxAtendenteSim;
    private javax.swing.JCheckBox checkBoxClienteNao;
    private javax.swing.JCheckBox checkBoxClienteSim;
    private javax.swing.JPanel clientePanel;
    private javax.swing.JPanel clientesButtonPanel;
    private javax.swing.JComboBox<String> comboBoxBuscaValor;
    private javax.swing.JPanel configuracoesPanel;
    private javax.swing.JPanel formPanel;
    private javax.swing.JRadioButton idAtendenteRadioButton;
    private javax.swing.JRadioButton idClienteRadioButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelAtendenteSelecionado;
    private javax.swing.JLabel labelClienteSelecionado;
    private javax.swing.JRadioButton nomeAtendenteRadioButton;
    private javax.swing.JRadioButton nomeClienteRadioButton;
    private javax.swing.JPanel senhaFormPanel;
    private javax.swing.JTable tabelaAtendentes;
    private javax.swing.JTable tabelaClientes;
    // End of variables declaration//GEN-END:variables

    public static class SimNaoRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

            String valueStr = (String) value;
            c.setForeground(valueStr.contains("SIM") ? new Color(0, 163, 16) : Color.RED);

            return c;
        }

    }

}
