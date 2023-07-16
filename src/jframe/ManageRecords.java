/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author pmora
 */
public class ManageRecords extends javax.swing.JFrame {

    /**
     * Creates new form ManageRecords
     */
    public ManageRecords() {
        initComponents();
         typhoon_records();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    DefaultTableModel model;
    public void typhoon_records() {

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            Statement st2 = con.createStatement();
            ResultSet rs = st.executeQuery("select *, IFNULL(Total_Fatal, 'NULL')as TOTFATAL , IFNULL(InterName, 'N/A') as InterName_NULL  from typhoon");
            DecimalFormat df = new DecimalFormat("$#,##0.00;(#,##0.00)");
            while (rs.next()) {

                int typhoonID = rs.getInt("TyphoonID");
                int Year = rs.getInt("year");
                String IntName = rs.getString("InterName_NULL");
                String BagName = rs.getString("BagyoName");
                int signo = rs.getInt("SignalNumber");
                String dForm = dateFormat.format(rs.getDate("DateFormed"));
                String ePH = dateFormat.format(rs.getDate("EnteredPH"));
                String lPH = dateFormat.format(rs.getDate("LeftPH"));
                String dDiss = dateFormat.format(rs.getDate("DateDissolved"));
                int hWind = rs.getInt("HighestWinds");
                int lPress = rs.getInt("LowestPressure");
                String tot_fat = rs.getString("TOTFATAL");
                String tot_dmg = df.format(rs.getDouble("Total_Damage"));

                Object[] obj = {typhoonID, Year, IntName, BagName, signo, dForm, ePH, ePH, dDiss, hWind, lPress, tot_fat, tot_dmg};
                model = (DefaultTableModel) typhoon_record_tbl.getModel();
                model.addRow(obj);

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        typhoon_record_tbl = new rojeru_san.complementos.RSTableMetro();
        jLabel8 = new javax.swing.JLabel();
        view = new javax.swing.JButton();
        searchbar = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        BagyoField = new javax.swing.JTextField();
        ID_text = new javax.swing.JTextField();
        refresh = new javax.swing.JLabel();
        view1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        close = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(234, 234, 234));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(249, 249, 249));
        jPanel1.setForeground(new java.awt.Color(249, 249, 249));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        typhoon_record_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Year", "Int'l Name", "Local Name", "Signal No.", "Date Formed", "Entered PH", "Left PH", "Date Dissolved", "Highest Winds", "Lowest Pressure", "Total Fatalities", "Total Damage"
            }
        ));
        typhoon_record_tbl.setColorBackgoundHead(new java.awt.Color(255, 255, 255));
        typhoon_record_tbl.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        typhoon_record_tbl.setColorBordeHead(new java.awt.Color(204, 204, 204));
        typhoon_record_tbl.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        typhoon_record_tbl.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        typhoon_record_tbl.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        typhoon_record_tbl.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        typhoon_record_tbl.setColorSelBackgound(new java.awt.Color(204, 204, 204));
        typhoon_record_tbl.setColorSelForeground(new java.awt.Color(0, 0, 0));
        typhoon_record_tbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        typhoon_record_tbl.setFuenteFilas(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        typhoon_record_tbl.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        typhoon_record_tbl.setFuenteHead(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        typhoon_record_tbl.setGridColor(new java.awt.Color(204, 204, 204));
        typhoon_record_tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                typhoon_record_tblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(typhoon_record_tbl);
        if (typhoon_record_tbl.getColumnModel().getColumnCount() > 0) {
            typhoon_record_tbl.getColumnModel().getColumn(0).setPreferredWidth(20);
            typhoon_record_tbl.getColumnModel().getColumn(1).setPreferredWidth(25);
            typhoon_record_tbl.getColumnModel().getColumn(2).setPreferredWidth(45);
            typhoon_record_tbl.getColumnModel().getColumn(3).setPreferredWidth(45);
            typhoon_record_tbl.getColumnModel().getColumn(4).setPreferredWidth(50);
            typhoon_record_tbl.getColumnModel().getColumn(11).setPreferredWidth(60);
            typhoon_record_tbl.getColumnModel().getColumn(12).setPreferredWidth(70);
        }

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 1090, 460));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Typhoon Records");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 170, -1));

        view.setText("Delete");
        view.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewMouseClicked(evt);
            }
        });
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });
        jPanel4.add(view, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 590, 100, 20));

        searchbar.setText("Search by ID, local, or international name"); // NOI18N
        searchbar.setToolTipText("");
        searchbar.setName(""); // NOI18N
        searchbar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchbarMouseClicked(evt);
            }
        });
        searchbar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbarActionPerformed(evt);
            }
        });
        searchbar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchbarKeyReleased(evt);
            }
        });
        jPanel4.add(searchbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 40, 241, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setText("Selected:");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 560, -1, -1));

        BagyoField.setText("Local Name"); // NOI18N
        BagyoField.setToolTipText("");
        BagyoField.setName(""); // NOI18N
        BagyoField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BagyoFieldMouseClicked(evt);
            }
        });
        BagyoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BagyoFieldActionPerformed(evt);
            }
        });
        BagyoField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BagyoFieldKeyReleased(evt);
            }
        });
        jPanel4.add(BagyoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 590, 150, 30));

        ID_text.setText("ID");
        ID_text.setToolTipText("");
        ID_text.setName(""); // NOI18N
        ID_text.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ID_textMouseClicked(evt);
            }
        });
        ID_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID_textActionPerformed(evt);
            }
        });
        ID_text.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                ID_textPropertyChange(evt);
            }
        });
        ID_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ID_textKeyReleased(evt);
            }
        });
        jPanel4.add(ID_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 550, 150, 30));

        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im_project/PngItem_804922.png"))); // NOI18N
        refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshMouseClicked(evt);
            }
        });
        jPanel4.add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 40, -1, 25));

        view1.setText("Update");
        view1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                view1MouseClicked(evt);
            }
        });
        view1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view1ActionPerformed(evt);
            }
        });
        jPanel4.add(view1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 560, 100, 20));

        jPanel3.setBackground(new java.awt.Color(203, 203, 203));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("View Data");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 56, 117, 31));

        jPanel11.setBackground(new java.awt.Color(204, 204, 204));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
        });
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setText("Record Viewing");
        jPanel11.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel3.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 232, 37));

        jPanel14.setBackground(new java.awt.Color(153, 153, 153));
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel14MouseClicked(evt);
            }
        });
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setText("Manage Records");
        jPanel14.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel3.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 232, 37));

        jPanel10.setBackground(new java.awt.Color(203, 203, 203));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
        });
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setText("Add Records");
        jPanel10.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 232, 37));

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Overview");
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 93, 232, 37));

        jPanel12.setBackground(new java.awt.Color(204, 204, 204));
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel12MouseClicked(evt);
            }
        });
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setText("Create Areas");
        jPanel12.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel3.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 232, 37));

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 200, 680));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1310, 680));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Typhoon Database System");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel18.setText("iPhoon");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 26, 1310, 730));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im_project/lights.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 7, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im_project/redo.png"))); // NOI18N
        jLabel10.setToolTipText("");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 0, -1, 28));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im_project/mini logo.png"))); // NOI18N
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im_project/back.png"))); // NOI18N
        jLabel3.setToolTipText("");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 0, -1, 28));

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im_project/User-Interface-Delete-Sign-icon.png"))); // NOI18N
        close.setToolTipText("");
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        jPanel2.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 0, -1, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1310, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 756, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void typhoon_record_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_typhoon_record_tblMouseClicked
        DefaultTableModel model = (DefaultTableModel) typhoon_record_tbl.getModel();
        int Myindex = typhoon_record_tbl.getSelectedRow();
        ID_text.setText(model.getValueAt(Myindex, 0).toString());
        BagyoField.setText(model.getValueAt(Myindex, 3).toString());

    }//GEN-LAST:event_typhoon_record_tblMouseClicked

    private void viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewMouseClicked
    if(ID_text.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "No Area Selected");
        }
        else{
            try {
                Connection con = DBConnection.getConnection();
                try {
                        int id = Integer.parseInt(ID_text.getText());
                        Statement st = con.createStatement();
                        PreparedStatement ps = null;
                        Statement st2 = con.createStatement();
                        String query = ("DELETE FROM typhoon WHERE TyphoonID="+id+"");
                        ps = con.prepareStatement(query);
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Typhoon"+id+" deleted");
                        ID_text.setText("");
                        Object[] obj = {ID_text.getText()};
                        model = (DefaultTableModel) typhoon_record_tbl.getModel();
                        model.setRowCount(0);
                        new ManageRecords().setVisible(true);
                        this.dispose();
                        

                        
                }catch (Exception e){
                 JOptionPane.showMessageDialog(this, "Missing Fields!");
                }

            } catch (Exception e) {
                e.printStackTrace();

            }

        }

    }//GEN-LAST:event_viewMouseClicked

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
      
    }//GEN-LAST:event_viewActionPerformed

    private void searchbarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbarMouseClicked
        searchbar.setText("");
    }//GEN-LAST:event_searchbarMouseClicked

    private void searchbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchbarActionPerformed

    private void searchbarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchbarKeyReleased
        try {
            Connection con = DBConnection.getConnection();
            String query = "select * from typhoon where InterName=? OR BagyoName=? OR typhoonID=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, searchbar.getText());
            pst.setString(2, searchbar.getText());
            pst.setString(3, searchbar.getText());
            ResultSet rs = pst.executeQuery();
            typhoon_record_tbl.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();

        }
    }//GEN-LAST:event_searchbarKeyReleased

    private void BagyoFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BagyoFieldMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BagyoFieldMouseClicked

    private void BagyoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BagyoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BagyoFieldActionPerformed

    private void BagyoFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BagyoFieldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_BagyoFieldKeyReleased

    private void ID_textMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ID_textMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ID_textMouseClicked

    private void ID_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ID_textActionPerformed

    private void ID_textPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_ID_textPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_ID_textPropertyChange

    private void ID_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ID_textKeyReleased

    }//GEN-LAST:event_ID_textKeyReleased

    private void refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseClicked
        new ManageRecords().setVisible(true);
    }//GEN-LAST:event_refreshMouseClicked

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

    private void view1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view1MouseClicked
            this.dispose();
    }//GEN-LAST:event_view1MouseClicked

    private void view1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view1ActionPerformed
        try {
            String ID = ID_text.getText();

            new updateRec(ID).setVisible(true);
        } catch (Exception e) {

        }
    }//GEN-LAST:event_view1ActionPerformed

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        new testTables().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel11MouseClicked

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel14MouseClicked

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        new AddRecord().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel10MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        new Home().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked
        new addAreas().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel12MouseClicked

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
            java.util.logging.Logger.getLogger(ManageRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageRecords().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BagyoField;
    public javax.swing.JTextField ID_text;
    private javax.swing.JLabel close;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel refresh;
    private javax.swing.JTextField searchbar;
    private rojeru_san.complementos.RSTableMetro typhoon_record_tbl;
    private javax.swing.JButton view;
    private javax.swing.JButton view1;
    // End of variables declaration//GEN-END:variables
}