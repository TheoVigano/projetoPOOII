package view;

import controller.UsuarioController;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import utils.Util;

public class FrLogin extends javax.swing.JFrame {

    public FrLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        edtUsuario = new javax.swing.JTextField();
        edtSenha = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlPrincipal.setBackground(new java.awt.Color(51, 51, 51));
        pnlPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsuario.setBackground(new java.awt.Color(204, 204, 204));
        lblUsuario.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(204, 204, 204));
        lblUsuario.setText("Usuário");
        pnlPrincipal.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        lblSenha.setBackground(new java.awt.Color(204, 204, 204));
        lblSenha.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        lblSenha.setForeground(new java.awt.Color(204, 204, 204));
        lblSenha.setText("Senha");
        pnlPrincipal.add(lblSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        edtUsuario.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        pnlPrincipal.add(edtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 250, -1));

        edtSenha.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        edtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtSenhaActionPerformed(evt);
            }
        });
        pnlPrincipal.add(edtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 250, -1));

        btnEntrar.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(0, 0, 0));
        btnEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key.png"))); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEntrarMouseClicked(evt);
            }
        });
        btnEntrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEntrarKeyPressed(evt);
            }
        });
        pnlPrincipal.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 140, 40));

        lblTitulo.setBackground(new java.awt.Color(204, 204, 204));
        lblTitulo.setFont(new java.awt.Font("Noto Sans Lao", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(204, 204, 204));
        lblTitulo.setText("LOGIN");
        pnlPrincipal.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        pnlPrincipal.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void edtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtSenhaActionPerformed

    private void btnEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseClicked
        logar();
    }//GEN-LAST:event_btnEntrarMouseClicked

    private void btnEntrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEntrarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            logar();
        }
    }//GEN-LAST:event_btnEntrarKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Util objeto = new Util();
        this.setIconImage(Util.getIcone());
    }//GEN-LAST:event_formWindowOpened

    private boolean verificarCampo() {
        if (edtUsuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Usuário em branco");
            return false;
        }
        if (new String(edtSenha.getPassword()).isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Senha em branco");
            return false;
        }
        return true;
    }

    private void logar() {
        //verifica se os campos estão preenchidos
        if (!verificarCampo()) {
            return;
        }

        //pega os dados digitados
        String usuario = edtUsuario.getText();
        String senha = new String(edtSenha.getPassword());

        //criptografa a senha
        senha = Util.calcularHash(senha);

        //instancia o controller
        UsuarioController controller = new UsuarioController();

        //verifica se o usuário existe no banco
        if (controller.autenticar(usuario, senha)) {
            //abre a tela principal
            FrMenu telaMenu = new FrMenu();
            telaMenu.setVisible(true);
            this.setVisible(false);
        } else {
            //mensagem de erro
            JOptionPane.showMessageDialog(rootPane, "Usuário não encontrado");
        }
    }

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
            java.util.logging.Logger.getLogger(FrLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JPasswordField edtSenha;
    private javax.swing.JTextField edtUsuario;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
