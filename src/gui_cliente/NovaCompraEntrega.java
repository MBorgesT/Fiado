package gui_cliente;

import dao.AtendenteDAO;
import dao.CompraDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Atendente;
import models.Cliente;
import models.Compra;
import printers.ComprovantePrinter;
import validation.CompraEntregaFormValidation;

public class NovaCompraEntrega extends javax.swing.JFrame {

    Cliente cliente;
    ArrayList<Atendente> todosAtendentes;
    Calendar now;

    public NovaCompraEntrega(Cliente cliente) {
        initComponents();

        this.cliente = cliente;
        
        ArrayList<Atendente> auxAtendentes = AtendenteDAO.selectTodosAtendentesAtivos();
        if (cliente.isAtendente()){
            this.todosAtendentes = new ArrayList<>();
            for (Atendente atendente: auxAtendentes){
                if (cliente.getIdAtendente() != atendente.getIdAtendente()){
                    todosAtendentes.add(atendente);
                }
            }
        }else{
            this.todosAtendentes = auxAtendentes;
        }

        this.now = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        campoDataHora.setText(sdf.format(this.now.getTime()));

        campoNomeCliente.setText(cliente.getNome());
    }

    private NovaCompraEntrega() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        formPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        campoValor = new javax.swing.JTextField();
        campoDataHora = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        campoNomeCliente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoObservacao = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        botaoCancelar = new javax.swing.JButton();
        botaoConfirmar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nova Compra");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/icons/basket-48.png")).getImage());
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/motorcycle-48.png"))); // NOI18N
        jLabel1.setText("Nova Compra para Entrega");

        formPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Valor (R$):");

        campoValor.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        campoValor.setName("valor"); // NOI18N

        campoDataHora.setEditable(false);
        campoDataHora.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Data e Hora:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Cliente:");

        campoNomeCliente.setEditable(false);
        campoNomeCliente.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Observação:");

        campoObservacao.setColumns(20);
        campoObservacao.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        campoObservacao.setLineWrap(true);
        campoObservacao.setRows(5);
        campoObservacao.setName(""); // NOI18N
        jScrollPane1.setViewportView(campoObservacao);

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("*");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setText("*");

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 51, 51));
        jLabel14.setText("*");

        javax.swing.GroupLayout formPanelLayout = new javax.swing.GroupLayout(formPanel);
        formPanel.setLayout(formPanelLayout);
        formPanelLayout.setHorizontalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(campoNomeCliente)
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formPanelLayout.createSequentialGroup()
                                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoValor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(formPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10)))
                                .addGap(18, 18, 18)
                                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(formPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11))
                                    .addComponent(campoDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel8)
                            .addGroup(formPanelLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        formPanelLayout.setVerticalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botaoCancelar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        botaoConfirmar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ok.png"))); // NOI18N
        botaoConfirmar.setText("Confirmar");
        botaoConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 51));
        jLabel9.setText("* Campos Obrigatórios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(formPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(formPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCancelar)
                    .addComponent(botaoConfirmar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmarActionPerformed
        String[] options = {"SIM", "NÃO"};
        int reply = JOptionPane.showOptionDialog(null, "Realmente deseja realizar a compra?", "Pagamento",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                options, options[0]);

        if (reply == 0) {
            if (new CompraEntregaFormValidation(formPanel, cliente).validate()) {
                String strValor = campoValor.getText();
                strValor = strValor.replaceAll(",", ".");
                float valor = Float.parseFloat(strValor);

                Compra compra = new Compra(
                        cliente.getIdCliente(),
                        valor,
                        this.now,
                        campoObservacao.getText().toUpperCase(),
                        false,
                        true,
                        false
                );

                int insertedId = CompraDAO.insertCompraEntrega(compra);
                if (insertedId != 0) {
                    compra.setIdCompra(insertedId);
                    
                    ComprovantePrinter.printComprovanteCompraEntrega(compra, true);

                    try {
                        Thread.currentThread().sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(NovaCompraEntrega.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    JOptionPane.showMessageDialog(null, "Confirme para imprimir a nota da padaria", "Recibo", JOptionPane.INFORMATION_MESSAGE);
                    ComprovantePrinter.printComprovanteCompraEntrega(compra, false);

                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Houve um erro com o banco de dados. Favor reiniciar o programa e tentar novamente", "Erro", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                System.out.println("fodeo");
            }
        }
    }//GEN-LAST:event_botaoConfirmarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NovaCompraEntrega().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoConfirmar;
    private javax.swing.JTextField campoDataHora;
    private javax.swing.JTextField campoNomeCliente;
    private javax.swing.JTextArea campoObservacao;
    private javax.swing.JTextField campoValor;
    private javax.swing.JPanel formPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
