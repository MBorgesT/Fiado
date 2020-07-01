
package gui_cliente;

import models.Cliente;

public class EntregaOpcoes extends javax.swing.JFrame {

    Cliente cliente;
    
    public EntregaOpcoes(Cliente cliente) {
        initComponents();
        this.cliente = cliente;
    }

    private EntregaOpcoes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        botaoNovaEntrega = new javax.swing.JButton();
        botaoValidarEntrega = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Opções de Entrega");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/motorcycle-48.png"))); // NOI18N
        jLabel1.setText("Entregas");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        botaoNovaEntrega.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoNovaEntrega.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/basket-32.png"))); // NOI18N
        botaoNovaEntrega.setText("Nova Compra para Entrega");
        botaoNovaEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovaEntregaActionPerformed(evt);
            }
        });

        botaoValidarEntrega.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoValidarEntrega.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/validate_recepit-32.png"))); // NOI18N
        botaoValidarEntrega.setText("Validar Entrega");
        botaoValidarEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoValidarEntregaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoNovaEntrega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoValidarEntrega, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoNovaEntrega)
                .addGap(18, 18, 18)
                .addComponent(botaoValidarEntrega)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoNovaEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovaEntregaActionPerformed
        new NovaCompraEntrega(cliente).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botaoNovaEntregaActionPerformed

    private void botaoValidarEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoValidarEntregaActionPerformed
        new ValidarEntrega(cliente).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botaoValidarEntregaActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EntregaOpcoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoNovaEntrega;
    private javax.swing.JButton botaoValidarEntrega;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
