
package gui_cliente;

import models.Compra;
import printers.ComprovantePrinter;

public class ImpressaoNovaCompra extends javax.swing.JFrame {

    private Compra compra;
    
    public ImpressaoNovaCompra(Compra compra) {
        initComponents();
        
        this.compra = compra;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botaoImprimirNotaCliente = new javax.swing.JButton();
        botaoImprimirNotaPadaria = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Impressão");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/icons/basket-48.png")).getImage());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        botaoImprimirNotaCliente.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        botaoImprimirNotaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/printer-blue-32.png"))); // NOI18N
        botaoImprimirNotaCliente.setText("Imprimir Nota do Cliente");
        botaoImprimirNotaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoImprimirNotaClienteActionPerformed(evt);
            }
        });

        botaoImprimirNotaPadaria.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        botaoImprimirNotaPadaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/printer-green-32.png"))); // NOI18N
        botaoImprimirNotaPadaria.setText("Imprimir Nota da Padaria");
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(botaoImprimirNotaCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoImprimirNotaPadaria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoImprimirNotaCliente)
                .addGap(18, 18, 18)
                .addComponent(botaoImprimirNotaPadaria)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<html><div style='text-align: center;'>Compra realizada com sucesso!</html>");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoImprimirNotaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoImprimirNotaClienteActionPerformed
        ComprovantePrinter.printComprovanteCompra(compra, true);
    }//GEN-LAST:event_botaoImprimirNotaClienteActionPerformed

    private void botaoImprimirNotaPadariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoImprimirNotaPadariaActionPerformed
        ComprovantePrinter.printComprovanteCompra(compra, false);
    }//GEN-LAST:event_botaoImprimirNotaPadariaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoImprimirNotaCliente;
    private javax.swing.JButton botaoImprimirNotaPadaria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
