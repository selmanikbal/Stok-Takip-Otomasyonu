/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stok_takip_programi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CASPER
 */
public class satislar extends javax.swing.JFrame {

    /**
     * Creates new form satislar
     */
    
    
    private void satisurunGuncelle(){
    
     try {
            String baslik[] = new String[]{ "Kategori", "Ürün Adı", "Beden", "Renk", "Fiyat", "Adet", "Açıklama" };  
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = null;
            Statement st = null;
            ResultSet rs = null;

            con = DriverManager.getConnection("jdbc:mysql://localhost/stok_takip", "root", "");
            
            st = con.createStatement();                
            rs = st.executeQuery("select * from satislar ORDER BY id DESC");
            rs.last();
           
            int kayitsayisi = rs.getRow();
            rs.beforeFirst();

            Object data[][] = new Object[kayitsayisi][];
            int i = 0;

            while (rs.next()) {

                data[i] = new Object[]{  
                    
                    
                    rs.getString("kategori"),  
                    rs.getString("urunadi"),
                    rs.getString("beden"),
                    rs.getString("renk"),  
                    rs.getString("fiyat"),
                    rs.getString("adet"),
                    rs.getString("aciklama"), 
                };
                i++;
            }
           
            con.close();
            satis_urunler_tablosu.setModel(new DefaultTableModel(data, baslik));
            
        } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
    }
    
    private void UrunListeGuncelle(){
    
     try {
             String baslik[] = new String[]{"id","Kategori", "Ürün Adı", "Beden", "Renk", "Fiyat", "Adet", "Açıklama" };  
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = null;
            Statement st = null;
            ResultSet rs = null;

            con = DriverManager.getConnection("jdbc:mysql://localhost/stok_takip", "root", "");
            
            st = con.createStatement();                
            rs = st.executeQuery("select * from urunler");
            rs.last();
           
            int kayitsayisi = rs.getRow();
            rs.beforeFirst();

            Object data[][] = new Object[kayitsayisi][];
            int i = 0;

            while (rs.next()) {

                data[i] = new Object[]{  
                 rs.getInt("id"),
                    rs.getString("kategori"),  
                    rs.getString("urunadi"),
                    rs.getString("beden"),
                    rs.getString("renk"),  
                    rs.getString("fiyat"),
                    rs.getString("adet"),
                    rs.getString("aciklama"),
                       
                };
                i++;
            }
           
            con.close();
            urunler_tablosu.setModel(new DefaultTableModel(data, baslik));
            
        } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
    }
    
    
    public satislar() 
    {
        super("Satış Ekranı");
        initComponents();
        
        String baslik[] = new String[]{"id", "Kategori", "Ürün Adı", "Beden", "Renk", "Fiyat", "Adet", "Açıklama" };
        String baslik1[] = new String[]{"id", "Kategori", "Ürün Adı", "Beden", "Renk", "Fiyat", "Adet", "Açıklama" }; 

        try {
            
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = null;
            Statement st,st1 = null;
            ResultSet rs,rs1 = null;

            con = DriverManager.getConnection("jdbc:mysql://localhost/stok_takip", "root", "");
            
            st = con.createStatement();  
            st1 = con.createStatement();
            rs = st.executeQuery("select * from urunler ORDER BY id DESC");
            rs1 = st1.executeQuery("select * from satislar ORDER BY id DESC");
            rs.last();
            rs1.last();
            
            int kayitsayisi = rs.getRow();
            rs.beforeFirst();

            Object data[][] = new Object[kayitsayisi][];
            int i = 0;

            while (rs.next()) {

                data[i] = new Object[]{  
                    
                    rs.getString("kategori"),  
                    rs.getString("urunadi"),
                    rs.getString("beden"),
                    rs.getString("renk"),  
                    rs.getString("fiyat"),
                    rs.getString("adet"),
                    rs.getString("aciklama"), 
                };
                i++;
            }
            //
            urunler_tablosu.setModel(new DefaultTableModel(data, baslik));
            
            //
            int kayitsayisi1 = rs1.getRow();
            rs1.beforeFirst();

            Object data1[][] = new Object[kayitsayisi1][];
            int j = 0;

            while (rs1.next()) {

                data1[j] = new Object[]{  
                    
                    rs1.getString("id"),
                    rs1.getString("kategori"),  
                    rs1.getString("urunadi"),
                    rs1.getString("beden"),
                    rs1.getString("renk"),  
                    rs1.getString("fiyat"),
                    rs1.getString("adet"),
                    rs1.getString("aciklama"), 
                };
                j++;
            }
           
            //con.close();
            satis_urunler_tablosu.setModel(new DefaultTableModel(data1, baslik1));
            
        } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
        
        UrunListeGuncelle();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adet = new javax.swing.JTextField();
        lbl_fiyat2 = new javax.swing.JLabel();
        aciklama = new javax.swing.JTextField();
        beden = new javax.swing.JTextField();
        lbl_fiyat1 = new javax.swing.JLabel();
        lbl_adi = new javax.swing.JLabel();
        lbl_kategori = new javax.swing.JLabel();
        adi = new javax.swing.JTextField();
        guncelle = new javax.swing.JButton();
        lbl_renk = new javax.swing.JLabel();
        kategori = new javax.swing.JTextField();
        lbl_fiyat = new javax.swing.JLabel();
        renk = new javax.swing.JTextField();
        fiyat = new javax.swing.JTextField();
        lbl_renk1 = new javax.swing.JLabel();
        lbl_filtrele = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        urunler_tablosu = new javax.swing.JTable();
        arama_alani = new javax.swing.JTextField();
        arama = new javax.swing.JButton();
        cikis = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        satis_urunler_tablosu = new javax.swing.JTable();
        lbl_satislar = new javax.swing.JLabel();
        lbl_stok = new javax.swing.JLabel();
        lbl_satis_filtrele = new javax.swing.JLabel();
        satis_arama = new javax.swing.JButton();
        satis_ara = new javax.swing.JTextField();
        resim = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(825, 670));
        getContentPane().setLayout(null);
        getContentPane().add(adet);
        adet.setBounds(76, 255, 170, 30);

        lbl_fiyat2.setText("Açıklama");
        getContentPane().add(lbl_fiyat2);
        lbl_fiyat2.setBounds(25, 311, 120, 16);
        getContentPane().add(aciklama);
        aciklama.setBounds(76, 303, 170, 30);
        getContentPane().add(beden);
        beden.setBounds(76, 118, 170, 30);

        lbl_fiyat1.setText("Adet");
        getContentPane().add(lbl_fiyat1);
        lbl_fiyat1.setBounds(25, 263, 100, 16);

        lbl_adi.setText("Ürün Adı");
        getContentPane().add(lbl_adi);
        lbl_adi.setBounds(25, 78, 90, 16);

        lbl_kategori.setText("Kategori");
        getContentPane().add(lbl_kategori);
        lbl_kategori.setBounds(26, 38, 70, 16);
        getContentPane().add(adi);
        adi.setBounds(76, 70, 170, 30);

        guncelle.setText("Satışı Gerçekleştir");
        guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guncelleActionPerformed(evt);
            }
        });
        getContentPane().add(guncelle);
        guncelle.setBounds(100, 360, 135, 25);

        lbl_renk.setText("Renk");
        getContentPane().add(lbl_renk);
        lbl_renk.setBounds(25, 174, 110, 16);
        getContentPane().add(kategori);
        kategori.setBounds(76, 30, 170, 30);

        lbl_fiyat.setText("Fiyat");
        getContentPane().add(lbl_fiyat);
        lbl_fiyat.setBounds(25, 215, 70, 16);
        getContentPane().add(renk);
        renk.setBounds(76, 166, 170, 30);
        getContentPane().add(fiyat);
        fiyat.setBounds(76, 207, 170, 30);

        lbl_renk1.setText("Beden");
        getContentPane().add(lbl_renk1);
        lbl_renk1.setBounds(25, 126, 80, 16);

        lbl_filtrele.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_filtrele.setText("Filtrele");
        getContentPane().add(lbl_filtrele);
        lbl_filtrele.setBounds(279, 35, 37, 17);

        urunler_tablosu.setModel(new javax.swing.table.DefaultTableModel(
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
        urunler_tablosu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                urunler_tablosuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(urunler_tablosu);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(279, 116, 509, 207);
        getContentPane().add(arama_alani);
        arama_alani.setBounds(326, 30, 170, 30);

        arama.setText("Ara");
        arama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aramaActionPerformed(evt);
            }
        });
        getContentPane().add(arama);
        arama.setBounds(510, 34, 53, 25);

        cikis.setText("ÇIKIŞ");
        cikis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cikisActionPerformed(evt);
            }
        });
        getContentPane().add(cikis);
        cikis.setBounds(707, 11, 90, 25);

        satis_urunler_tablosu.setModel(new javax.swing.table.DefaultTableModel(
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
        satis_urunler_tablosu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                satis_urunler_tablosuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(satis_urunler_tablosu);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(280, 420, 509, 207);

        lbl_satislar.setText("Satışı Yapılan Ürünler");
        getContentPane().add(lbl_satislar);
        lbl_satislar.setBounds(280, 390, 160, 16);

        lbl_stok.setText("Stoktaki Ürünler");
        getContentPane().add(lbl_stok);
        lbl_stok.setBounds(279, 92, 170, 16);

        lbl_satis_filtrele.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_satis_filtrele.setText("Filtrele");
        getContentPane().add(lbl_satis_filtrele);
        lbl_satis_filtrele.setBounds(279, 338, 37, 17);

        satis_arama.setText("Ara");
        satis_arama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                satis_aramaActionPerformed(evt);
            }
        });
        getContentPane().add(satis_arama);
        satis_arama.setBounds(510, 337, 53, 25);
        getContentPane().add(satis_ara);
        satis_ara.setBounds(326, 333, 170, 30);

        resim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        resim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stok_takip_programi/background.jpg"))); // NOI18N
        getContentPane().add(resim);
        resim.setBounds(0, 0, 820, 650);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guncelleActionPerformed

        try {
            
            int row = urunler_tablosu.getSelectedRow();            
            int secim_yap=Integer.parseInt((urunler_tablosu.getValueAt(row, 0)).toString());
             
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = null;
            Statement st = null;
            ResultSet rs = null;

            con = DriverManager.getConnection("jdbc:mysql://localhost/stok_takip", "root", "");
            st = con.createStatement();
            
            rs = st.executeQuery("select * from urunler where id='"+secim_yap+"'");
            rs.next();
            
            int eski_adet=Integer.parseInt(rs.getString("adet"));            
            int satilan_adet = Integer.parseInt(adet.getText());
            int kalan = eski_adet - satilan_adet;
            
            String sorgu1 = "UPDATE urunler SET kategori='"+kategori.getText()+"'"
            +",urunadi='"+adi.getText()+"'"
            +",beden='"+beden.getText()+"'"
            +",renk='"+renk.getText()+"'"
            +",fiyat='"+fiyat.getText()+"'"
            +",adet='"+kalan+"'"
            +",aciklama='"+aciklama.getText()+"' where id='"+secim_yap+"'";
            
            
            int fiyati = Integer.parseInt(fiyat.getText());
            int Toplam_fiyat =fiyati;
            
            String sorgu = "INSERT INTO satislar (kategori,urunadi,beden,renk,fiyat,adet,aciklama)" 
                        + " VALUES ('"+kategori.getText()+"', '"+adi.getText()+"', '"+beden.getText()+"'"
                        +", '"+renk.getText()+"', '"+Toplam_fiyat+"', '"+adet.getText()+"'"
                        +", '"+aciklama.getText()+"')";
            
            
            
            st.executeUpdate(sorgu);
            st.executeUpdate(sorgu1);

            JOptionPane.showMessageDialog(null, adi.getText() + " adlı ürün satılmışır.");

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
        
        satisurunGuncelle();
        UrunListeGuncelle();

    }//GEN-LAST:event_guncelleActionPerformed

    private void urunler_tablosuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_urunler_tablosuMouseClicked

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement st1 =null;

        try {

            int row = urunler_tablosu.getSelectedRow();            
            int secim_yap=Integer.parseInt((urunler_tablosu.getValueAt(row, 0)).toString());
    
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/stok_takip", "root", "");

            String sorgu = "select * from urunler where id='"+secim_yap+"'";
            
            st = con.createStatement();
            rs = st.executeQuery(sorgu);
      
               
            if(rs.last()){

                kategori.setText(rs.getString("kategori"));
                adi.setText(rs.getString("urunadi"));
                beden.setText(rs.getString("beden"));
                renk.setText(rs.getString("renk"));
                fiyat.setText(rs.getString("fiyat"));
                adet.setText(rs.getString("adet"));
                aciklama.setText(rs.getString("aciklama"));
            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
    }//GEN-LAST:event_urunler_tablosuMouseClicked

    private void aramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aramaActionPerformed

        String ara =arama_alani.getText();
        String baslik[] = new String[]{"Kategori", "Ürün Adı", "Beden", "Renk", "Fiyat", "Adet", "Açıklama" };

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = null;
            Statement st = null;
            ResultSet rs = null;

            con = DriverManager.getConnection("jdbc:mysql://localhost/stok_takip", "root", "");

            String sorgu ="select * from urunler where urunadi like '%"+arama_alani.getText()+"%' or"
            +" kategori like '%"+arama_alani.getText()+"%' or"
            +" beden like '%"+arama_alani.getText()+"%' or"
            +" renk like '%"+arama_alani.getText()+"%' ";

            st = con.createStatement();
            rs = st.executeQuery(sorgu);

            rs.last();

            int say = rs.getRow();
            rs.beforeFirst();

            String sayi = null;
            sayi = String.valueOf(rs.getRow());

            if(say < 1){
                JOptionPane.showMessageDialog(null, "Aradığınız Ürün Bulunamadı!");
            }
            else{
                Object data[][] = new Object[say][];
                int i = 0;

                while (rs.next()) {

                    data[i] = new Object[]{

                        rs.getString("kategori"),
                        rs.getString("urunadi"),
                        rs.getString("beden"),
                        rs.getString("renk"),
                        rs.getString("fiyat"),
                        rs.getString("adet"),
                        rs.getString("aciklama"),
                    };
                    i++;
                }
                urunler_tablosu.setModel(new DefaultTableModel(data, baslik));
            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }

    }//GEN-LAST:event_aramaActionPerformed

    private void cikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cikisActionPerformed

        urun_ekle a = new urun_ekle();
        a.setVisible(false);
        dispose();

    }//GEN-LAST:event_cikisActionPerformed

    private void satis_urunler_tablosuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_satis_urunler_tablosuMouseClicked

        
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement st1 =null;

        try {

            int row = satis_urunler_tablosu.getSelectedRow();            
            int secim_yap=Integer.parseInt((satis_urunler_tablosu.getValueAt(row, 0)).toString());

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/stok_takip", "root", "");

            String sorgu = "select * from satislar where id='"+secim_yap+"'";
            //st = con.createStatement();
            st = con.createStatement();
            rs = st.executeQuery(sorgu);
   
            if(rs.last()){

                kategori.setText(rs.getString("kategori"));
                adi.setText(rs.getString("urunadi"));
                beden.setText(rs.getString("beden"));
                renk.setText(rs.getString("renk"));
                fiyat.setText(rs.getString("fiyat"));
                adet.setText(rs.getString("adet"));
                aciklama.setText(rs.getString("aciklama"));
            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
        
        
    }//GEN-LAST:event_satis_urunler_tablosuMouseClicked

    private void satis_aramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_satis_aramaActionPerformed
        
        
        String baslik[] = new String[]{"Kategori", "Ürün Adı", "Beden", "Renk", "Fiyat", "Adet", "Açıklama" };

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = null;
            Statement st = null;
            ResultSet rs = null;

            con = DriverManager.getConnection("jdbc:mysql://localhost/stok_takip", "root", "");

            String sorgu ="select * from satislar where urunadi like '%"+satis_ara.getText()+"%' or"
            +" kategori like '%"+satis_ara.getText()+"%' or"
            +" beden like '%"+satis_ara.getText()+"%' or"
            +" renk like '%"+satis_ara.getText()+"%' or"
            +" adet like '%"+satis_ara.getText()+"%' ";

            st = con.createStatement();
            rs = st.executeQuery(sorgu);

            rs.last();

            int say = rs.getRow();
            rs.beforeFirst();

            String sayi = null;
            sayi = String.valueOf(rs.getRow());

            if(say < 1){
                JOptionPane.showMessageDialog(null, "Aradığınız Ürün Bulunamadı!");
            }
            else{
                Object data[][] = new Object[say][];
                int i = 0;

                while (rs.next()) {

                    data[i] = new Object[]{

                        rs.getString("kategori"),
                        rs.getString("urunadi"),
                        rs.getString("beden"),
                        rs.getString("renk"),
                        rs.getString("fiyat"),
                        rs.getString("adet"),
                        rs.getString("aciklama"),
                    };
                    i++;
                }
                satis_urunler_tablosu.setModel(new DefaultTableModel(data, baslik));
            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritabanına bağlantı sağlanamadı! " + ex.toString());
        }
        
    }//GEN-LAST:event_satis_aramaActionPerformed

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
            java.util.logging.Logger.getLogger(satislar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(satislar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(satislar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(satislar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new satislar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aciklama;
    private javax.swing.JTextField adet;
    private javax.swing.JTextField adi;
    private javax.swing.JButton arama;
    private javax.swing.JTextField arama_alani;
    private javax.swing.JTextField beden;
    private javax.swing.JButton cikis;
    private javax.swing.JTextField fiyat;
    private javax.swing.JButton guncelle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField kategori;
    private javax.swing.JLabel lbl_adi;
    private javax.swing.JLabel lbl_filtrele;
    private javax.swing.JLabel lbl_fiyat;
    private javax.swing.JLabel lbl_fiyat1;
    private javax.swing.JLabel lbl_fiyat2;
    private javax.swing.JLabel lbl_kategori;
    private javax.swing.JLabel lbl_renk;
    private javax.swing.JLabel lbl_renk1;
    private javax.swing.JLabel lbl_satis_filtrele;
    private javax.swing.JLabel lbl_satislar;
    private javax.swing.JLabel lbl_stok;
    private javax.swing.JTextField renk;
    private javax.swing.JLabel resim;
    private javax.swing.JTextField satis_ara;
    private javax.swing.JButton satis_arama;
    private javax.swing.JTable satis_urunler_tablosu;
    private javax.swing.JTable urunler_tablosu;
    // End of variables declaration//GEN-END:variables
}
