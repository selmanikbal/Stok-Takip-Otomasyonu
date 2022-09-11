/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stok_takip_programi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author CASPER
 */
public class unuttum extends javax.swing.JFrame {

    /**
     * Creates new form unuttum
     */
    public unuttum() {
        
        super("Şifremi Unuttum Formu");
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_email = new javax.swing.JLabel();
        sifre_goster = new javax.swing.JButton();
        email_alani = new javax.swing.JTextField();
        cikis = new javax.swing.JButton();
        resim = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(430, 220));
        getContentPane().setLayout(null);

        lbl_email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_email.setText("E-Posta Adresiniz");
        getContentPane().add(lbl_email);
        lbl_email.setBounds(40, 50, 103, 17);

        sifre_goster.setText("Şifreyi Göster");
        sifre_goster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sifre_gosterActionPerformed(evt);
            }
        });
        getContentPane().add(sifre_goster);
        sifre_goster.setBounds(180, 100, 170, 35);
        getContentPane().add(email_alani);
        email_alani.setBounds(180, 50, 170, 30);

        cikis.setText("ÇIKIŞ");
        cikis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cikisActionPerformed(evt);
            }
        });
        getContentPane().add(cikis);
        cikis.setBounds(310, 10, 90, 25);

        resim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        resim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stok_takip_programi/background.jpg"))); // NOI18N
        getContentPane().add(resim);
        resim.setBounds(0, 0, 420, 200);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sifre_gosterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sifre_gosterActionPerformed
        
            String email=email_alani.getText();
                
            try {
                    
                if (email.equals("")) {

                    JOptionPane.showMessageDialog(this, "Lütfen E-Posta Adresinizi Giriniz!");

                } else {            
                    Class.forName("com.mysql.jdbc.Driver");

                    Connection con = null;
                    Statement st = null;
                    ResultSet rs = null;
                    
                    con = DriverManager.getConnection("jdbc:mysql://localhost/stok_takip", "root", "");
                    st = con.createStatement();
                    
                    rs = st.executeQuery("select * from uyeler where email='"+email+"'");
                    
                    if(rs.next()){
                       
                        JOptionPane.showMessageDialog(null, "Şifreniz: " + rs.getString("parola"));
                        
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Böyle Bir E-Posta Kayıtlı Değil!"); 
                    }
                }
            
            } catch (ClassNotFoundException ex) {
                 JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
            }
        
    }//GEN-LAST:event_sifre_gosterActionPerformed

    private void cikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cikisActionPerformed

        urun_ekle a = new urun_ekle();
        a.setVisible(false);
        dispose();
    }//GEN-LAST:event_cikisActionPerformed

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
            java.util.logging.Logger.getLogger(unuttum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(unuttum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(unuttum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(unuttum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new unuttum().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cikis;
    private javax.swing.JTextField email_alani;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel resim;
    private javax.swing.JButton sifre_goster;
    // End of variables declaration//GEN-END:variables
}