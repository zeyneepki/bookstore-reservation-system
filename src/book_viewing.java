
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author zeynep
 */
public class book_viewing extends javax.swing.JFrame {

    Connection conn;

    /**
     * Creates new form book_viewing
     */
    public book_viewing() {
        initComponents();
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kullanici_veritabani?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "1234");
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        fetchDataForBookType("Roman", table_kitaplarListesi3, conn);
        fetchDataForBookType("Hikaye", table_kitaplarListesi1, conn);
        fetchDataForBookType("Şiir", table_kitaplarListesi2, conn);

    }
  //kitap bilgilerini veri tabanından alıp tabloya atmak için
    public void fetchDataForBookType(String bookType, JTable table, Connection conn) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        PreparedStatement ps;

        try {
            // kitap türüne göre sql sorgusu 
            ps = conn.prepareStatement("SELECT * FROM kitaplar WHERE kitap_turu = ?");
            ps.setString(1, bookType); 
            ResultSet rs = ps.executeQuery();

            // tabloyu temizlemek için
            model.setRowCount(0);

            // verileri döngü ile tabloya ekleme
            while (rs.next()) {
                int id = rs.getInt("id");
                String kitapAdi = rs.getString("kitap_adi");
                String yazarAdi = rs.getString("yazar_adi");
                int sayfaSayisi = rs.getInt("sayfa_sayisi");

                
                model.addRow(new Object[]{id, kitapAdi, yazarAdi, sayfaSayisi});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(book_viewing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //kitap adına göre veri tabanında arama yaparak kitaba göre bilgileri tabloya eklemek için fonksiyon
    private void searchByBookName(String bookName, JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); 

        PreparedStatement ps = null;
        try {
            //kitap adına göre sql sorgusu 
            String query = "SELECT * FROM kitaplar WHERE kitap_adi LIKE ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, bookName); 

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // Veritabanından kitap bilgilerini alıyor
                int id = rs.getInt("id");
                String kitapAdi = rs.getString("kitap_adi");
                String yazarAdi = rs.getString("yazar_adi");
                int sayfaSayisi = rs.getInt("sayfa_sayisi");

                
                model.addRow(new Object[]{id, kitapAdi, yazarAdi, sayfaSayisi});

                
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
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btn_romanAra = new javax.swing.JButton();
        txt_roman = new javax.swing.JTextField();
        btn_rezervasyonYaptirRoman = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_kitaplarListesi3 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btn_hikayeAra = new javax.swing.JButton();
        txt_hikaye = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_kitaplarListesi1 = new javax.swing.JTable();
        btn_rezervasyonYaptirHikaye = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btn_siirAra = new javax.swing.JButton();
        txt_siir = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_kitaplarListesi2 = new javax.swing.JTable();
        btn_rezervasyonYaptirSiir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Kitap Görüntüleme");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        btn_romanAra.setText("Roman Ara");
        btn_romanAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_romanAraActionPerformed(evt);
            }
        });

        txt_roman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_romanActionPerformed(evt);
            }
        });

        btn_rezervasyonYaptirRoman.setText("Rezervasyon Yap");
        btn_rezervasyonYaptirRoman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rezervasyonYaptirRomanActionPerformed(evt);
            }
        });

        table_kitaplarListesi3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Kitap Adı", "Yazar Adı", "Kitap Sayfası"
            }
        ));
        jScrollPane4.setViewportView(table_kitaplarListesi3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_roman, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btn_romanAra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 150, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_rezervasyonYaptirRoman, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(210, 210, 210))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_romanAra)
                            .addComponent(txt_roman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(208, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_rezervasyonYaptirRoman)
                        .addGap(151, 151, 151))))
        );

        jTabbedPane1.addTab("Roman", jPanel2);

        btn_hikayeAra.setText("Hikaye Ara");
        btn_hikayeAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hikayeAraActionPerformed(evt);
            }
        });

        txt_hikaye.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hikayeActionPerformed(evt);
            }
        });

        table_kitaplarListesi1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "djsjss", "sjsjsjs", null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Kitap Adı", "Yazar Adı", "Kitap Sayfası"
            }
        ));
        jScrollPane2.setViewportView(table_kitaplarListesi1);

        btn_rezervasyonYaptirHikaye.setText("Rezervasyon Yap");
        btn_rezervasyonYaptirHikaye.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rezervasyonYaptirHikayeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(787, Short.MAX_VALUE)
                .addComponent(btn_rezervasyonYaptirHikaye, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(txt_hikaye, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addComponent(btn_hikayeAra))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap()))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(370, Short.MAX_VALUE)
                .addComponent(btn_rezervasyonYaptirHikaye)
                .addGap(109, 109, 109))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_hikayeAra)
                        .addComponent(txt_hikaye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(28, 28, 28)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(163, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Hikaye", jPanel3);

        btn_siirAra.setText("Şiir Ara");
        btn_siirAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_siirAraActionPerformed(evt);
            }
        });

        txt_siir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_siirActionPerformed(evt);
            }
        });

        table_kitaplarListesi2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "hahha", "ahahah", null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Kitap Adı", "Yazar Adı", "Kitap Sayfası"
            }
        ));
        jScrollPane3.setViewportView(table_kitaplarListesi2);

        btn_rezervasyonYaptirSiir.setText("Rezervasyon Yap");
        btn_rezervasyonYaptirSiir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rezervasyonYaptirSiirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_rezervasyonYaptirSiir, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 868, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addComponent(txt_siir, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(38, 38, 38)
                    .addComponent(btn_siirAra)
                    .addGap(632, 632, 632)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(btn_rezervasyonYaptirSiir)
                .addGap(75, 75, 75))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_siirAra)
                        .addComponent(txt_siir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(452, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Şiir", jPanel4);

        jMenu1.setText("File");

        jMenuItem3.setText("Rezervasyon sayfasına git");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("çıkış");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Yenile");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_romanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_romanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_romanActionPerformed

    private void btn_romanAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_romanAraActionPerformed
        //kullanıcının girdiği romanı tablodan arıyor
        String roman = txt_roman.getText();
        searchByBookName(roman, table_kitaplarListesi3);
    }//GEN-LAST:event_btn_romanAraActionPerformed

    private void btn_hikayeAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hikayeAraActionPerformed
        String hikaye = txt_hikaye.getText();
        searchByBookName(hikaye, table_kitaplarListesi1);
    }//GEN-LAST:event_btn_hikayeAraActionPerformed

    private void txt_hikayeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hikayeActionPerformed
    }//GEN-LAST:event_txt_hikayeActionPerformed

    private void btn_siirAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_siirAraActionPerformed
        String siir = txt_siir.getText();
        searchByBookName(siir, table_kitaplarListesi2);

    }//GEN-LAST:event_btn_siirAraActionPerformed

    private void txt_siirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_siirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_siirActionPerformed

    private void btn_rezervasyonYaptirHikayeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rezervasyonYaptirHikayeActionPerformed
        int selectedRow = table_kitaplarListesi1.getSelectedRow();
        if (selectedRow != -1) {
         String selectedBook = (String) table_kitaplarListesi1.getValueAt(selectedRow, 1);

            book_reservation rezervasyon = new book_reservation(selectedBook);

            rezervasyon.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btn_rezervasyonYaptirHikayeActionPerformed

    private void btn_rezervasyonYaptirSiirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rezervasyonYaptirSiirActionPerformed
        int selectedRow = table_kitaplarListesi2.getSelectedRow();
        if (selectedRow != -1) {
            String selectedBook = (String) table_kitaplarListesi2.getValueAt(selectedRow, 1);

            book_reservation rezervasyon = new book_reservation(selectedBook);

            rezervasyon.setVisible(true);
            this.setVisible(false);}    }//GEN-LAST:event_btn_rezervasyonYaptirSiirActionPerformed

    private void btn_rezervasyonYaptirRomanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rezervasyonYaptirRomanActionPerformed
// kullanıcı kitap listesinden bir satır seçer ve seçilen kitabın adını alarak rezervasyon frame'ine geçiş yapar.
        int selectedRow = table_kitaplarListesi3.getSelectedRow();
        if (selectedRow != -1) {
            String selectedBook = (String) table_kitaplarListesi3.getValueAt(selectedRow, 1);

            book_reservation rezervasyon = new book_reservation(selectedBook);

            rezervasyon.setVisible(true);
            this.setVisible(false);

    }//GEN-LAST:event_btn_rezervasyonYaptirRomanActionPerformed
    }
    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
//bu frame'i kapatır ve userlogin'e geçer
        this.setVisible(false);
user_login giris = new user_login();
giris.setVisible(true);
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
     
        //fetchDataForBookType("Roman", table_kitaplarListesi3, conn);
    }//GEN-LAST:event_jMenu4ActionPerformed

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
       //tıklandığında tabloları günceller
        fetchDataForBookType("Roman", table_kitaplarListesi3, conn);
        fetchDataForBookType("Hikaye", table_kitaplarListesi1, conn);
        fetchDataForBookType("Şiir", table_kitaplarListesi2, conn);

    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
    //tıklandığında rezervasyon sayfasına gider
        this.setVisible(false);
    String selectedBook = "Seçilen Kitap Adı";

book_reservation rezervasyon = new book_reservation( selectedBook);
rezervasyon.setVisible(true);        
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
            java.util.logging.Logger.getLogger(book_viewing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(book_viewing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(book_viewing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(book_viewing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new book_viewing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_hikayeAra;
    private javax.swing.JButton btn_rezervasyonYaptirHikaye;
    private javax.swing.JButton btn_rezervasyonYaptirRoman;
    private javax.swing.JButton btn_rezervasyonYaptirSiir;
    private javax.swing.JButton btn_romanAra;
    private javax.swing.JButton btn_siirAra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable table_kitaplarListesi1;
    private javax.swing.JTable table_kitaplarListesi2;
    private javax.swing.JTable table_kitaplarListesi3;
    private javax.swing.JTextField txt_hikaye;
    private javax.swing.JTextField txt_roman;
    private javax.swing.JTextField txt_siir;
    // End of variables declaration//GEN-END:variables
}
