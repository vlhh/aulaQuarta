/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoNota1;

/**
 *
 * @author vitoria.schneider
 */
public class TelaContas extends javax.swing.JFrame {

    /**
     * Creates new form TelaContas
     */
    
    Conta objetoConta;
    
    public TelaContas() {
        initComponents();
        
        Conta objetoConta = new Conta("Viória",13123123,2000,213123);        
        System.out.println("saldo na conta: " +objetoConta.getSaldoConta());
        
        Conta objetoConta2 = new Conta("Viória2",82347234,800,234234);        
        System.out.println("saldo na conta: "+ objetoConta2.getSaldoConta());
        
        
        //prencheer os campos na tela
        lblNomeConta1.setText("nome: " + objetoConta.getTitular());
        lblNomeConta2.setText("nome: " + objetoConta2.getTitular());
        
        lblNumero.setText("num : " +objetoConta.getNumConta());
        lblNumero2.setText("num : " +objetoConta2.getNumConta());
        
        lblSaldo.setText("saldo :" +objetoConta.getSaldoConta());
        lblSaldo2.setText("saldo :" +objetoConta2.getSaldoConta());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bntAlterarNome = new javax.swing.JButton();
        lblNomeConta1 = new javax.swing.JLabel();
        lblNomeConta2 = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        lblNumero2 = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();
        lblSaldo2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bntAlterarNome.setBackground(new java.awt.Color(240, 165, 240));
        bntAlterarNome.setForeground(new java.awt.Color(0, 123, 65));
        bntAlterarNome.setText("botao");
        bntAlterarNome.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bntAlterarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAlterarNomeActionPerformed(evt);
            }
        });

        lblNomeConta1.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        lblNomeConta1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNomeConta1.setText("conta1");

        lblNomeConta2.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        lblNomeConta2.setText("conta2");

        lblNumero.setText("número conta");

        lblNumero2.setText("número conta");

        lblSaldo.setText("saldo");

        lblSaldo2.setText("saldo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(bntAlterarNome, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomeConta1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))))
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomeConta2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblSaldo2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblNumero2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNomeConta1, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(lblNomeConta2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(lblSaldo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(bntAlterarNome, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntAlterarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAlterarNomeActionPerformed
        lblNomeConta1.setText("saldo");
    }//GEN-LAST:event_bntAlterarNomeActionPerformed

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
            java.util.logging.Logger.getLogger(TelaContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaContas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntAlterarNome;
    private javax.swing.JLabel lblNomeConta1;
    private javax.swing.JLabel lblNomeConta2;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblNumero2;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblSaldo2;
    // End of variables declaration//GEN-END:variables
}
