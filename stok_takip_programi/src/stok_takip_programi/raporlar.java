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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CASPER
 */
public class raporlar extends javax.swing.JFrame {

    /**
     * Creates new form raporlar
     */
     
    
    public raporlar() {
        super("Rapor Ekranı");

        initComponents();
        
        String baslik[] = new String[]{"Kategori", "Ürün Adı","Fiyat", "Adet", "Toplam Ücret" };  

        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con = null;
            Statement st,st1 = null;
            ResultSet rs,rs1 = null;
            
            con = DriverManager.getConnection("jdbc:mysql://localhost/stok_takip", "root", "");
            
            st = con.createStatement();
            st1 = con.createStatement();
            
            rs = st.executeQuery("select *, (fiyat*adet) as Toplam_Fiyat from satislar");
            rs.last();
            
            int ali = Integer.parseInt(rs.getString("Toplam_Fiyat"));
            
           // alttaki 3 satırda raporlar formundak toplam tutarı ekrana yazdırdık
            rs1 = st1.executeQuery("select sum(fiyat*adet) as ToplamFiyat from satislar");
            rs1.last();
            toplam_tutar.setText(rs1.getString(1)+" TL");
            
            int kayitsayisi = rs.getRow();
            rs.beforeFirst();

            Object data[][] = new Object[kayitsayisi][];
            int i = 0;

            while (rs.next()) {

                data[i] = new Object[]{  
                    
                    rs.getString("kategori"),  
                    rs.getString("urunadi"), 
                    rs.getString("fiyat"),
                    rs.getString("adet"),
                    rs.getString("Toplam_Fiyat")
                };
                i++;
            }
            
            
            con.close();
            rapor_tablosu.setModel(new DefaultTableModel(data, baslik));
            
        } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_satis = new javax.swing.JLabel();
        toplam_tutar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        rapor_tablosu = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_cikis = new javax.swing.JButton();
        resim = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 500));
        getContentPane().setLayout(null);

        lbl_satis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_satis.setText("Toplam Satış Tutarı");
        getContentPane().add(lbl_satis);
        lbl_satis.setBounds(10, 11, 116, 17);

        toplam_tutar.setEnabled(false);
        getContentPane().add(toplam_tutar);
        toplam_tutar.setBounds(144, 11, 170, 30);

        rapor_tablosu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(rapor_tablosu);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 50, 601, 284);

        jButton1.setText("STOK EKRANI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(40, 362, 151, 61);

        jButton2.setText("KULLANICI EKLE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(456, 362, 147, 61);

        jButton4.setText("SATIŞ EKRANI");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(242, 362, 144, 61);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(433, 352, 0, 0);
        jLabel1.getAccessibleContext().setAccessibleName("kullanici");

        btn_cikis.setText("ÇIKIŞ");
        btn_cikis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cikisActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cikis);
        btn_cikis.setBounds(611, 15, 63, 25);

        resim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        resim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stok_takip_programi/background.jpg"))); // NOI18N
        getContentPane().add(resim);
        resim.setBounds(0, 0, 690, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        urun_ekle goster = new urun_ekle();
        goster.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        uye_ekle goster = new uye_ekle();
        goster.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        satislar goster = new satislar();
        goster.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btn_cikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cikisActionPerformed
        
        raporlar kapat = new raporlar();
        kapat.setVisible(false);
        dispose();
        
    }//GEN-LAST:event_btn_cikisActionPerformed

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
            java.util.logging.Logger.getLogger(raporlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(raporlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(raporlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(raporlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new raporlar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cikis;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_satis;
    private javax.swing.JTable rapor_tablosu;
    private javax.swing.JLabel resim;
    private javax.swing.JTextField toplam_tutar;
    // End of variables declaration//GEN-END:variables
}
