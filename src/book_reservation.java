
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.JMenuItem;

import javax.swing.JPopupMenu;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author zeynep
 */
public class book_reservation extends javax.swing.JFrame {

    private static Connection conn;
    private static PreparedStatement ps;

    public book_reservation(String selectedBook) {
        initComponents();

        //kullanıcı tarafından seçilen kitabı label'a yazar
        lbl_selectedBook.setText(selectedBook);
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/kullanici_veritabani?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "1234");
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        // JPopupMenu oluşturma
        JPopupMenu popupMenu = new JPopupMenu();

// tıkladığımda detayları göster çıkması için
        JMenuItem showDetailsItem = new JMenuItem("Detayları Göster");
        popupMenu.add(showDetailsItem);

// sağa tıklama yapabilmek için
        lbl_selectedBook.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        String bookName = lbl_selectedBook.getText();
        PreparedStatement ps = null;
        try {
            // kitap adına göre sql sorgusu(label içine diğer sayfadan kitap adı geldi)
            String query = "SELECT * FROM kitaplar WHERE kitap_adi LIKE ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, bookName);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // Veritabanından kitap bilgilerini aldım
                int id = rs.getInt("id");
                String kitapAdi = rs.getString("kitap_adi");
                String yazarAdi = rs.getString("yazar_adi");
                int sayfaSayisi = rs.getInt("sayfa_sayisi");

                showDetailsItem.addActionListener(e -> {
                    //veritabanından kitap tablosundan isme göre sorgulama yapıp kitap bilgilerini çektim
                    JOptionPane.showMessageDialog(this, "Kitap Bilgileri:\n"
                            + "ID: " + id + "\n"
                            + "Kitap Adı: " + kitapAdi + "\n"
                            + "Yazar Adı: " + yazarAdi + "\n"
                            + "Sayfa Sayısı: " + sayfaSayisi, "Detaylar", JOptionPane.INFORMATION_MESSAGE);
                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(book_viewing.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_selectedBook = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbox_alimTarihi = new javax.swing.JComboBox<>();
        cmbox_teslimTarihi = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbox_sube = new javax.swing.JComboBox<>();
        chbox_kullanimSarti = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jspin_miktar = new javax.swing.JSpinner();
        btn_rezervasyon = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Rezervasyon");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        lbl_selectedBook.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_selectedBook.setText(".");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Seçtiğiniz kitap:");

        jLabel5.setBackground(new java.awt.Color(153, 153, 153));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Rezervasyon Yapmak İstediğiniz Tarihleri Seçiniz:");

        cmbox_alimTarihi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2025-01-13", "2025-01-14", "2025-01-15", "2025-01-16", "2025-01-17", "2025-01-18", "2025-01-19", "2025-01-20", "2025-01-21", "2025-01-22", "2025-01-23", "2025-01-24", "2025-01-26", "2025-01-27", "2025-01-28", "2025-01-29", "2025-01-30", " " }));
        cmbox_alimTarihi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbox_alimTarihiActionPerformed(evt);
            }
        });

        cmbox_teslimTarihi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2025-01-13", "2025-01-14", "2025-01-15", "2025-01-16", "2025-01-17", "2025-01-18", "2025-01-19", "2025-01-20", "2025-01-21", "2025-01-22", "2025-01-23", "2025-01-24", "2025-01-26", "2025-01-27", "2025-01-28", "2025-01-29", "2025-01-30", " " }));
        cmbox_teslimTarihi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbox_teslimTarihiActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Alma Tarihi:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Teslim Tarihi:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Teslim Alacağınız Şubeyi Seçiniz:");

        cmbox_sube.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Karaköy Şubesi,Galataport Yanı", "Eminönü Şubesi,Mısır Çarşısı Girişi", "Kadıköy Şubesi,Boğa Heykeli Karşısı", "Üsküdar Şubesi,Nevmekan 1.kat" }));
        cmbox_sube.setMinimumSize(new java.awt.Dimension(224, 30));
        cmbox_sube.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbox_subeActionPerformed(evt);
            }
        });

        chbox_kullanimSarti.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        chbox_kullanimSarti.setText("Kullanım Şartlarını Kabul Ediyorum.");
        chbox_kullanimSarti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbox_kullanimSartiActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("İstediğiniz Miktarı Seçiniz:");

        btn_rezervasyon.setText("Rezervasyonu Onayla");
        btn_rezervasyon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rezervasyonActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jList1);

        jMenu1.setText("File");

        jMenuItem2.setText("kitap görüntüleme sayfasına git");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);
        jMenu1.add(jSeparator3);

        jMenuItem3.setText("çıkış yap");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);
        jMenu1.add(jSeparator2);
        jMenu1.add(jSeparator1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("eski rezervasyonlar");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jCheckBoxMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(lbl_selectedBook, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(29, 29, 29)
                                .addComponent(jspin_miktar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_rezervasyon, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(50, 50, 50)
                                .addComponent(cmbox_sube, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(105, 105, 105)
                                .addComponent(jLabel6)
                                .addGap(27, 27, 27)
                                .addComponent(cmbox_alimTarihi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmbox_teslimTarihi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(chbox_kullanimSarti, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 6, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lbl_selectedBook))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jspin_miktar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbox_alimTarihi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cmbox_teslimTarihi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbox_sube, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addComponent(chbox_kullanimSarti)
                .addGap(18, 18, 18)
                .addComponent(btn_rezervasyon)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chbox_kullanimSartiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbox_kullanimSartiActionPerformed
        
        if (chbox_kullanimSarti.isSelected()) {
            int sonuc = JOptionPane.showConfirmDialog(this, "KVKK kapsamında verileri saklıyoruz.Kabul ediyor musunuz?", "KVKK Bilgilendirme", JOptionPane.YES_NO_OPTION);
            if (sonuc == JOptionPane.NO_OPTION) { 

                chbox_kullanimSarti.setSelected(false);
                JOptionPane.showMessageDialog(this, "Kullanım şartlarını kabul etmeden devam edemezsiniz.", "Uyarı", JOptionPane.WARNING_MESSAGE);
            }

        }
    }//GEN-LAST:event_chbox_kullanimSartiActionPerformed

    private void btn_rezervasyonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rezervasyonActionPerformed

        if (!chbox_kullanimSarti.isSelected()) {//kullanım şartı seçilmediyse devam edemez
            JOptionPane.showMessageDialog(this, "Kullanım şartlarını kabul etmeden rezervasyonu onaylayamazsınız!");
            return;
        }
        String kitapAdi = (String) lbl_selectedBook.getText();
        String miktar = jspin_miktar.getValue().toString();
        if (Integer.parseInt(miktar) <= 0) {
            JOptionPane.showMessageDialog(this, "Kitap miktarı 0'dan büyük olmalıdır. Lütfen geçerli bir miktar seçiniz!", "Hata", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String alimTarihi = (String) cmbox_alimTarihi.getSelectedItem();
        String teslimTarihi = (String) cmbox_teslimTarihi.getSelectedItem();
        String teslimAlinacakSube = (String) cmbox_sube.getSelectedItem();
       //girilen bilgilere göre ekrana rezervasyon detaylarını yazdırıyorum.
        JOptionPane.showMessageDialog(this, "Rezervasyonunuz onaylandı: \n"
                + "Kitap Adı:" + kitapAdi + "\n"
                + "Kitap Miktarı : " + miktar + "\n"
                + "Alma Tarihi : " + alimTarihi + "\n"
                + "Teslim Tarihi : " + teslimTarihi + "\n"
                + "Teslim Alınacak Şube : " + teslimAlinacakSube, "Rezervasyon", JOptionPane.INFORMATION_MESSAGE);

        try {
            ps = conn.prepareStatement("INSERT INTO reservations(book_name, quantity, pickup_date, return_date,branch) VALUES (?,?,?,?,?)");
            

            ps.setString(1, kitapAdi);
            ps.setString(2, miktar);
            ps.setString(3, alimTarihi);
            ps.setString(4, teslimTarihi);
            ps.setString(5, teslimAlinacakSube);

            System.out.println(ps.executeUpdate());

        } catch (SQLException e) {

            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace(); // Hata detaylarını konsola yazdırır
        }


    }//GEN-LAST:event_btn_rezervasyonActionPerformed

    private void cmbox_alimTarihiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbox_alimTarihiActionPerformed
       // String selectedAlimTarihi = (String) cmbox_alimTarihi.getSelectedItem();

    }//GEN-LAST:event_cmbox_alimTarihiActionPerformed

    private void cmbox_teslimTarihiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbox_teslimTarihiActionPerformed
    }//GEN-LAST:event_cmbox_teslimTarihiActionPerformed

    private void cmbox_subeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbox_subeActionPerformed
    }//GEN-LAST:event_cmbox_subeActionPerformed

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        DefaultListModel<String> listModel = new DefaultListModel<>(); // JList için model oluştur
        jList1.setModel(listModel); 

        try {
            // rezervasyon tablosundaki tüm kitap adlarını almak için SQL sorgusu
            ps = conn.prepareStatement("SELECT book_name FROM reservations");
            ResultSet rs = ps.executeQuery();

          
            listModel.clear();

            // veritabanındaki tüm kitap adlarını JList'e ekle(rezervasyondaki)
            while (rs.next()) {
                String kitapAdi = rs.getString("book_name");
                listModel.addElement(kitapAdi); 
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); 
            Logger.getLogger(book_viewing.class.getName()).log(Level.SEVERE, null, ex);
}    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        //kitap görüntülemeye gitmek için
        this.setVisible(false);
        book_viewing giris = new book_viewing();
        giris.setVisible(true);       
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       //çıkış için
        this.setVisible(false);
        user_login giris = new user_login();
        giris.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(book_reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(book_reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(book_reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(book_reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        String selectedBook = "Kitap";

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new book_reservation(selectedBook).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_rezervasyon;
    private javax.swing.JCheckBox chbox_kullanimSarti;
    private javax.swing.JComboBox<String> cmbox_alimTarihi;
    private javax.swing.JComboBox<String> cmbox_sube;
    private javax.swing.JComboBox<String> cmbox_teslimTarihi;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JSpinner jspin_miktar;
    private javax.swing.JLabel lbl_selectedBook;
    // End of variables declaration//GEN-END:variables
}
