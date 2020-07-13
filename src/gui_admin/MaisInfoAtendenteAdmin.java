package gui_admin;

import dao.AtendenteDAO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import models.Atendente;
import security.Hash;
import validation.AtendenteFormValidation;

public class MaisInfoAtendenteAdmin extends javax.swing.JFrame {

    private Atendente atendente;
    private MenuAdmin menuAdmin;
    private boolean editando;

    public MaisInfoAtendenteAdmin(Atendente atendente, MenuAdmin telaAnterior) {
        initComponents();

        this.atendente = atendente;
        this.menuAdmin = telaAnterior;

        labelId.setText("ID: " + String.valueOf(atendente.getIdAtendente()));
        campoNome.setText(atendente.getNome());

        this.editando = false;

        labelInfoSenha1.setVisible(false);
        labelInfoSenha2.setVisible(false);
        ast1.setVisible(false);
        ast2.setVisible(false);
        ast3.setVisible(false);

        if (AtendenteDAO.existeComprasOuPagamentosRelacionados(atendente.getIdAtendente())) {
            botaoExcluirAtendente.setVisible(false);
        }
    }

    private MaisInfoAtendenteAdmin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void preencherCampos() {
        campoNome.setText(atendente.getNome());
        campoSenha.setText("");
        campoConfirmarSenha.setText("");
    }

    private void alterarEditableCampos(boolean b) {
        campoNome.setEditable(b);
        campoSenha.setEditable(b);
        campoConfirmarSenha.setEditable(b);

        labelInfoSenha1.setVisible(b);
        labelInfoSenha2.setVisible(b);
        ast1.setVisible(b);
        ast2.setVisible(b);
        ast3.setVisible(b);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelId = new javax.swing.JLabel();
        formPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoSenha = new javax.swing.JPasswordField();
        campoConfirmarSenha = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        labelInfoSenha2 = new javax.swing.JLabel();
        labelInfoSenha1 = new javax.swing.JLabel();
        ast1 = new javax.swing.JLabel();
        ast3 = new javax.swing.JLabel();
        ast2 = new javax.swing.JLabel();
        botaoEditarInfo = new javax.swing.JButton();
        botaoCancelarEdicao = new javax.swing.JButton();
        botaoExcluirAtendente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mais Informações do Atendente");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/icons/administrator-48.png")).getImage());

        labelId.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelId.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bread-48.png"))); // NOI18N
        labelId.setText("ID: 123");

        formPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Nome:");

        campoNome.setEditable(false);
        campoNome.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        campoNome.setName("nome"); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Senha:");

        campoSenha.setEditable(false);
        campoSenha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        campoSenha.setName("senha"); // NOI18N

        campoConfirmarSenha.setEditable(false);
        campoConfirmarSenha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        campoConfirmarSenha.setName("confirmarSenha"); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Confirme a senha:");

        labelInfoSenha2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        labelInfoSenha2.setForeground(new java.awt.Color(255, 51, 51));
        labelInfoSenha2.setText("caracteres e conter somente números");

        labelInfoSenha1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        labelInfoSenha1.setForeground(new java.awt.Color(255, 51, 51));
        labelInfoSenha1.setText("A senha deve conter entre 6 e 8");

        ast1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ast1.setForeground(new java.awt.Color(255, 51, 51));
        ast1.setText("*");

        ast3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ast3.setForeground(new java.awt.Color(255, 51, 51));
        ast3.setText("*");

        ast2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ast2.setForeground(new java.awt.Color(255, 51, 51));
        ast2.setText("*");

        javax.swing.GroupLayout formPanelLayout = new javax.swing.GroupLayout(formPanel);
        formPanel.setLayout(formPanelLayout);
        formPanelLayout.setHorizontalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formPanelLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ast2))
                            .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(formPanelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ast3)))
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelInfoSenha1)
                                .addGap(53, 53, 53))
                            .addGroup(formPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelInfoSenha2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formPanelLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ast1))
                            .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        formPanelLayout.setVerticalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(labelInfoSenha1)
                            .addComponent(ast3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelInfoSenha2)))
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ast1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(ast2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botaoEditarInfo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoEditarInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.png"))); // NOI18N
        botaoEditarInfo.setText("Editar Informações");
        botaoEditarInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarInfoActionPerformed(evt);
            }
        });

        botaoCancelarEdicao.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoCancelarEdicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
        botaoCancelarEdicao.setText("Cancelar Edição");
        botaoCancelarEdicao.setEnabled(false);
        botaoCancelarEdicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarEdicaoActionPerformed(evt);
            }
        });

        botaoExcluirAtendente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botaoExcluirAtendente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.png"))); // NOI18N
        botaoExcluirAtendente.setText("Excluir Atendente");
        botaoExcluirAtendente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirAtendenteActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(formPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botaoCancelarEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botaoEditarInfo)))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoExcluirAtendente)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelId)
                    .addComponent(botaoExcluirAtendente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoEditarInfo)
                    .addComponent(botaoCancelarEdicao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoEditarInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarInfoActionPerformed
        if (editando) {
            String[] options = {"SIM", "NÃO"};
            int reply = JOptionPane.showOptionDialog(null, "Você realmente deseja salvar as alterações?", "Alterações",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                    options, options[0]);

            if (reply == 0 && new AtendenteFormValidation(formPanel).validate()) {
                byte[] salt = Hash.generateSalt();
                String hashedPw = Hash.hashPassword(String.valueOf(campoSenha.getPassword()), salt).get();

                System.out.println(atendente.toString());
                Atendente updatedAtendente = new Atendente(
                        atendente.getIdAtendente(),
                        campoNome.getText().toUpperCase(),
                        hashedPw,   
                        salt,
                        atendente.isAtivo()
                );
                updatedAtendente.setSalt(salt);
                System.out.println(updatedAtendente.getSalt().toString());

                if (AtendenteDAO.updateAtendente(updatedAtendente)) {
                    this.atendente = updatedAtendente;
                    menuAdmin.selecionarAtendente(updatedAtendente);
                    
                    menuAdmin.resetTabelaAtendentes();

                    campoNome.setText(atendente.getNome());

                    botaoCancelarEdicao.doClick();

                    editando = false;

                    preencherCampos();

                    JOptionPane.showMessageDialog(null, "Atendente atualizado com sucesso", "Informação", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Houve um erro com o banco de dados. Favor reiniciar o programa e tentar novamente", "Erro", JOptionPane.WARNING_MESSAGE);
                }
                
                Atendente aux = AtendenteDAO.selectAtendenteById(updatedAtendente.getIdAtendente());
                System.out.println(aux.toString());
                System.out.println(aux.getSalt().toString());
            }

        } else {
            editando = true;
            alterarEditableCampos(true);

            botaoEditarInfo.setIcon(new ImageIcon(getClass().getResource("/icons/save-alterations.png")));
            botaoEditarInfo.setText("Salvar Alterações");

            botaoCancelarEdicao.setEnabled(true);
        }
    }//GEN-LAST:event_botaoEditarInfoActionPerformed

    private void botaoCancelarEdicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarEdicaoActionPerformed
        editando = false;

        alterarEditableCampos(false);

        botaoEditarInfo.setIcon(new ImageIcon(getClass().getResource("/icons/edit.png")));
        botaoEditarInfo.setText("Editar Informações");

        botaoCancelarEdicao.setEnabled(false);
        preencherCampos();
    }//GEN-LAST:event_botaoCancelarEdicaoActionPerformed

    private void botaoExcluirAtendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirAtendenteActionPerformed
        if (AtendenteDAO.existeComprasOuPagamentosRelacionados(atendente.getIdAtendente())) {
            JOptionPane.showMessageDialog(null, "Não se pode excluir atendentes com compras realizadas", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
            if (AtendenteDAO.deleteAtendente(atendente.getIdAtendente())) {
                menuAdmin.fillTables();
                JOptionPane.showMessageDialog(null, "Atendente excluido com sucesso", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
        }
    }//GEN-LAST:event_botaoExcluirAtendenteActionPerformed

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
            java.util.logging.Logger.getLogger(MaisInfoAtendenteAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MaisInfoAtendenteAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MaisInfoAtendenteAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MaisInfoAtendenteAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MaisInfoAtendenteAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ast1;
    private javax.swing.JLabel ast2;
    private javax.swing.JLabel ast3;
    private javax.swing.JButton botaoCancelarEdicao;
    private javax.swing.JButton botaoEditarInfo;
    private javax.swing.JButton botaoExcluirAtendente;
    private javax.swing.JPasswordField campoConfirmarSenha;
    private javax.swing.JTextField campoNome;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JPanel formPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelInfoSenha1;
    private javax.swing.JLabel labelInfoSenha2;
    // End of variables declaration//GEN-END:variables
}
