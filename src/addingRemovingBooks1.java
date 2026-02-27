//import com.mysql.cj.xdevapi.Statement;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author zeynep
 */
public class addingRemovingBooks1 extends javax.swing.JFrame {

   Connection conn;

    public addingRemovingBooks1() {
        initComponents();
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kullanici_veritabani?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "1234");
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
public void deleteBookFromDatabase(int bookId, Connection conn) {
        try {
            String query = "DELETE FROM kitaplar WHERE id = ?"; // kitabı ID'ye göre sil
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, bookId); // silinecek kitabın ID'sini parametre olarak yerleştirmek için
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(addingRemovingBooks1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox_kitapTuru = new javax.swing.JComboBox<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btn_sil = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtyazar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtkitapSayfa = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtkitapadi = new javax.swing.JTextField();
        btn_kitabiDuzenle = new javax.swing.JButton();
        btn_kitabiSec = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        txt_yazarAdi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_kitapSayfa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_kitapAdi = new javax.swing.JTextField();
        txt_kitapTürü = new javax.swing.JTextField();
        btn_kitabiEkle = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1_yenile = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox_kitapTuru.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Şiir", "Hikaye", "Roman" }));
        jComboBox_kitapTuru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_kitapTuruActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        btn_sil.setText("Kitabı Sil");
        btn_sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_silActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_sil)
                .addGap(41, 41, 41))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(btn_sil)
                .addGap(83, 83, 83))
        );

        jTabbedPane1.addTab("Sil", jPanel3);

        jLabel6.setText("Yazar Adı:");

        jLabel7.setText("Kitap Sayfası:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable1);

        jLabel9.setText("Kitap Adı:");

        btn_kitabiDuzenle.setText("Kitabı Düzenle");
        btn_kitabiDuzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kitabiDuzenleActionPerformed(evt);
            }
        });

        btn_kitabiSec.setText("Kitabı Seç");
        btn_kitabiSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kitabiSecActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_kitabiDuzenle)
                .addGap(52, 52, 52))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtyazar)
                            .addComponent(txtkitapadi, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtkitapSayfa, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_kitabiSec))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_kitabiSec)
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtkitapadi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtkitapSayfa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtyazar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_kitabiDuzenle)
                .addGap(15, 15, 15))
        );

        jTabbedPane1.addTab("Düzenle", jPanel4);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable3);

        jLabel2.setText("Yazar Adı:");

        jLabel3.setText("Kitap Sayfası:");

        jLabel4.setText("Kitap Türü");

        jLabel1.setText("Kitap Adı:");

        btn_kitabiEkle.setText("Kitabı Ekle");
        btn_kitabiEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kitabiEkleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_yazarAdi)
                            .addComponent(txt_kitapAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_kitapSayfa, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_kitapTürü, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_kitabiEkle)
                .addGap(52, 52, 52))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_kitapAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt_kitapSayfa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_yazarAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(txt_kitapTürü, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_kitabiEkle)
                .addGap(15, 15, 15))
        );

        jTabbedPane1.addTab("Ekle", jPanel2);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 2, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Kitap Düzenleme");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel5)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem1_yenile.setText("yenile");
        jMenuItem1_yenile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1_yenileActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1_yenile);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addComponent(jComboBox_kitapTuru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox_kitapTuru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTabbedPane1)
                        .addGap(109, 109, 109))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_silActionPerformed
//tablodan seçilen satırı aldım
        int selectedRow = jTable2.getSelectedRow();

        if (selectedRow != -1) {

            int bookId = (int) jTable2.getValueAt(selectedRow, 0);

            // veritabanından kitabı silme fonksiyonu
            deleteBookFromDatabase(bookId, conn);

            // tablodan kitabı sil
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.removeRow(selectedRow);

            javax.swing.JOptionPane.showMessageDialog(this, "Kitap başarıyla silindi!");
        } else {

            javax.swing.JOptionPane.showMessageDialog(this, "Lütfen silmek istediğiniz kitabı seçin.");
        }

    }//GEN-LAST:event_btnkitapSilActionPerformed    }//GEN-LAST:event_btn_silActionPerformed

    private void jComboBox_kitapTuruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_kitapTuruActionPerformed
       String selectedBookType = (String) jComboBox_kitapTuru.getSelectedItem(); // comboboxtan seçilen türe göre listeleme
        fetchDataForBookType(jComboBox_kitapTuru, jTable1);
        fetchDataForBookType(jComboBox_kitapTuru, jTable2);
        fetchDataForBookType(jComboBox_kitapTuru, jTable3);
    }//GEN-LAST:event_jComboBox_kitapTuruActionPerformed

    private void btn_kitabiEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kitabiEkleActionPerformed
try {
            String bookName = txt_kitapAdi.getText();
            String yazarAdi = txt_yazarAdi.getText();
            int sayfaSayi = Integer.parseInt(txt_kitapSayfa.getText());
            String bookType = txt_kitapTürü.getText();

            // veritabanına kitap ekleme fonksiyonu
            int generatedId = addBookDatabase(bookName, yazarAdi, sayfaSayi, bookType);

            // JTable'a yeni satır ekliyoruz
            DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
            model.addRow(new Object[]{generatedId, bookName, yazarAdi, sayfaSayi}); // ID'yi de ekliyoruz

            javax.swing.JOptionPane.showMessageDialog(this, "Kitap Eklendi");

            txt_kitapAdi.setText("");
            txt_yazarAdi.setText("");
            txt_kitapSayfa.setText("");
            txt_kitapTürü.setText("");

        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Kitap eklemek için lütfen tüm alanları doldurun!");
        }    }//GEN-LAST:event_btn_kitabiEkleActionPerformed

    private void btn_kitabiDuzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kitabiDuzenleActionPerformed
try {
            String bookName = txtkitapadi.getText();
            String authorName = txtyazar.getText();
            int pageCount = Integer.parseInt(txtkitapSayfa.getText());
            int selectedRow = jTable1.getSelectedRow();

            if (selectedRow != -1) {
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                int id = (int) model.getValueAt(selectedRow, 0); 

                updateBookInDatabase(bookName, authorName, pageCount, id, conn);

               
                model.setValueAt(bookName, selectedRow, 1);
                model.setValueAt(authorName, selectedRow, 2);
                model.setValueAt(pageCount, selectedRow, 3);
               
            } else {
                // hiçbir satır seçilmemişse uyarı göster
                javax.swing.JOptionPane.showMessageDialog(this, "Lütfen güncellemek istediğiniz kitabı seçin!", "Hata", javax.swing.JOptionPane.ERROR_MESSAGE);
            }

            txtkitapSayfa.setText("");
            txtkitapadi.setText("");
            txtyazar.setText("");

            javax.swing.JOptionPane.showMessageDialog(this, "Kitap başarıyla güncellendi!");
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Lütfen tüm alanları doğru bir şekilde doldurun!", "Hata", javax.swing.JOptionPane.ERROR_MESSAGE);
        }    }//GEN-LAST:event_btn_kitabiDuzenleActionPerformed

    private void btn_kitabiSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kitabiSecActionPerformed
int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            
            String bookName = (String) jTable1.getValueAt(selectedRow, 1);
            String authorName = (String) jTable1.getValueAt(selectedRow, 2);
            int pageCount = (int) jTable1.getValueAt(selectedRow, 3);
            String bookType = (String) jComboBox_kitapTuru.getSelectedItem();

            txtkitapadi.setText(bookName);
            txtyazar.setText(authorName);
            txtkitapSayfa.setText(String.valueOf(pageCount));
        }    }//GEN-LAST:event_btn_kitabiSecActionPerformed

    private void jMenuItem1_yenileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1_yenileActionPerformed
fetchDataForBookType(jComboBox_kitapTuru, jTable1);
        fetchDataForBookType(jComboBox_kitapTuru, jTable2);
        fetchDataForBookType(jComboBox_kitapTuru, jTable3);    }//GEN-LAST:event_jMenuItem1_yenileActionPerformed

    public void fetchDataForBookType(JComboBox<String> comboBox, JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        PreparedStatement ps;

        try {

            String selectedBookType = (String) comboBox.getSelectedItem();
            
        //kitap türüne göre sql sorgusu
            ps = conn.prepareStatement("SELECT * FROM kitaplar WHERE kitap_turu = ?");
            ps.setString(1, selectedBookType); 
            ResultSet rs = ps.executeQuery();

            model.setRowCount(0);

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
    //database'e kitap eklemek için
    public int addBookDatabase(String bookName, String yazarAdi, int sayfaSayi, String bookType) {
        int generatedId = -1; 

        try {
            String query = "INSERT INTO kitaplar( kitap_adi , yazar_adi , sayfa_sayisi , kitap_turu) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, bookName);
            ps.setString(2, yazarAdi);
            ps.setInt(3, sayfaSayi);
            ps.setString(4, bookType);

            ps.executeUpdate();
            // otomatik oluşturulan ID'yi al
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                generatedId = rs.getInt(1); // İlk sütundan otomatik ID alınır
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(addingRemovingBooks1.class.getName()).log(Level.SEVERE, null, ex);

        }
        return generatedId; // otomatik oluşturulan ID'yi döndür

    }

    //database'de kitanı güncellemek için
    public void updateBookInDatabase(String bookName, String authorName, int pageCount, int id, Connection conn) {
        try {
            String query = "UPDATE kitaplar SET kitap_adi = ?, yazar_adi = ?, sayfa_sayisi = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, bookName);
            ps.setString(2, authorName);
            ps.setInt(3, pageCount);
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(addingRemovingBooks1.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(addingRemovingBooks1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addingRemovingBooks1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addingRemovingBooks1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addingRemovingBooks1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addingRemovingBooks1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_kitabiDuzenle;
    private javax.swing.JButton btn_kitabiEkle;
    private javax.swing.JButton btn_kitabiSec;
    private javax.swing.JButton btn_sil;
    private javax.swing.JComboBox<String> jComboBox_kitapTuru;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1_yenile;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField txt_kitapAdi;
    private javax.swing.JTextField txt_kitapSayfa;
    private javax.swing.JTextField txt_kitapTürü;
    private javax.swing.JTextField txt_yazarAdi;
    private javax.swing.JTextField txtkitapSayfa;
    private javax.swing.JTextField txtkitapadi;
    private javax.swing.JTextField txtyazar;
    // End of variables declaration//GEN-END:variables
}
