/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import java.awt.Image;
import java.io.File;
import static java.lang.System.load;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pmora
 */
public class indivRecord extends javax.swing.JFrame {

    /**
     * Creates new form indivRecord
     */
    public indivRecord() {
        initComponents();
        
    }
     String path = null, imagePath;
            File f = null;
     private ImageIcon format = null;
    DefaultTableModel model;
    indivRecord(String ID) {
        this();
        
        typhoonID.setText(ID);
        
        try {   
            SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd");
            int id = Integer.parseInt(typhoonID.getText());
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from typhoon WHERE TyphoonID="+id+"");
            DecimalFormat df = new DecimalFormat("$#,##0.00;(#,##0.00)");
            while(rs.next()){
                
                String intName = rs.getString("InterName");
                String yyyy = rs.getString("year");
                String LocName = rs.getString("BagyoName");
                String dForm = dateFormat.format(rs.getDate("DateFormed"));
                String dDiss = dateFormat.format(rs.getDate("DateDissolved"));
                String ePH = dateFormat.format(rs.getDate("EnteredPH"));
                String lPH = dateFormat.format(rs.getDate("LeftPH"));
                String hWinds = rs.getString("HighestWinds");
                String lPress = rs.getString("LowestPressure");
                String totFat = rs.getString("Total_Fatal");
                String totDmg = df.format(rs.getDouble("Total_Damage"));
                
                InterName_val.setText(String.valueOf(intName));
                year.setText(String.valueOf(yyyy));
                LocalName1.setText(String.valueOf(LocName));
                DateFormed.setText(String.valueOf(dForm));
                DateDissolved.setText(String.valueOf(dDiss));
                entPH.setText(String.valueOf(ePH));
                lefPH.setText(String.valueOf(lPH));
                HighestWinds.setText(String.valueOf(hWinds+" km/h"));
                LowestPressure.setText(String.valueOf(lPress+" hPa"));
                TotalFatalities.setText(String.valueOf(totFat+" people"));
                TotalDamage.setText(String.valueOf(totDmg));
                
                
                
                
               
                
            }
        }catch(Exception e){
            e.printStackTrace();
            
        }
        try {   
            SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
            int id = Integer.parseInt(typhoonID.getText());
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT AreaID, AreaName, AreaCapital, AreaPeople, AreaGDP\n" +
            "FROM areas as a, affected as b\n" +
            "WHERE a.AreaID = b.Area_ID AND b.Typhoon_No = "+id+"");
            DecimalFormat df = new DecimalFormat("$#,##0.00;(#,##0.00)");
            DecimalFormat ff = new DecimalFormat("#,##0;(#,##0)");
            while(rs.next()){
                    
                    String aID = rs.getString("AreaID");
                    String aName = rs.getString("AreaName");
                    String aCap = rs.getString("AreaCapital");
                    String aPOP = ff.format(rs.getInt("AreaPeople"));
                    String aGDP = df.format(rs.getDouble("AreaGDP"));
                    
                Object[] obj = {aID, aName, aCap, aPOP, aGDP};
                model = (DefaultTableModel) other_ar_aff1.getModel();
                model.addRow(obj);

                
            }
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
        
        
        try{
            int id = Integer.parseInt(typhoonID.getText());
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery("select * from image_tbl WHERE TyphoonID_Image="+id+"");
            while(rs.next()){
                String iPath = rs.getString("ImagePath");

                
                
                ImageIcon ii = new ImageIcon(iPath);
                Image img = ii.getImage().getScaledInstance(570, 380, Image.SCALE_SMOOTH);
                image.setIcon(new ImageIcon(img));

                }
            
        }catch(Exception e){
            
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
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
        LowestPressure = new javax.swing.JLabel();
        image = new javax.swing.JLabel();
        InterName_val = new javax.swing.JLabel();
        DateFormed = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        DateDissolved = new javax.swing.JLabel();
        entPH = new javax.swing.JLabel();
        lefPH = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        TotalDamage = new javax.swing.JLabel();
        HighestWinds = new javax.swing.JLabel();
        TotalFatalities = new javax.swing.JLabel();
        LocalName1 = new javax.swing.JLabel();
        typhoonID = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        other_ar_aff1 = new rojeru_san.complementos.RSTableMetro();
        year = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        close = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel21.setBackground(new java.awt.Color(234, 234, 234));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel22.setBackground(new java.awt.Color(249, 249, 249));
        jPanel22.setForeground(new java.awt.Color(249, 249, 249));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel24.setBackground(new java.awt.Color(203, 203, 203));
        jPanel24.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("View Data");
        jPanel24.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 56, 117, 31));

        jPanel11.setBackground(new java.awt.Color(204, 204, 204));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
        });
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setText("Record Viewing");
        jPanel11.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel24.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 232, 37));

        jPanel14.setBackground(new java.awt.Color(203, 203, 203));
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel14MouseClicked(evt);
            }
        });
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setText("Manage Records");
        jPanel14.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel24.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 232, 37));

        jPanel10.setBackground(new java.awt.Color(203, 203, 203));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
        });
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setText("Add Records");
        jPanel10.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel24.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 232, 37));

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Overview");
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel24.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 93, 232, 37));

        jPanel12.setBackground(new java.awt.Color(204, 204, 204));
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel12MouseClicked(evt);
            }
        });
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setText("Create Areas");
        jPanel12.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel24.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 232, 37));

        jPanel23.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 680));

        LowestPressure.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        LowestPressure.setText("960 ");
        jPanel23.add(LowestPressure, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 260, 33));

        image.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true));
        jPanel23.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 570, 380));

        InterName_val.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        InterName_val.setText("Ketsana");
        jPanel23.add(InterName_val, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 160, 50));

        DateFormed.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        DateFormed.setText("Sep 24");
        jPanel23.add(DateFormed, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 90, 33));

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel45.setText("Lowest Pressure");
        jPanel23.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 160, 30));

        DateDissolved.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        DateDissolved.setText("Sep 30");
        jPanel23.add(DateDissolved, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 210, 90, 33));

        entPH.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        entPH.setText("Sep 25");
        jPanel23.add(entPH, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 210, 90, 33));

        lefPH.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lefPH.setText("Sep 26");
        jPanel23.add(lefPH, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 210, 90, 33));

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel58.setText("Other Areas Affected");
        jPanel23.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 300, 250, 33));

        TotalDamage.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        TotalDamage.setText("1,150,000,000.00");
        jPanel23.add(TotalDamage, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, 340, 33));

        HighestWinds.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        HighestWinds.setText("130");
        jPanel23.add(HighestWinds, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 260, 33));

        TotalFatalities.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        TotalFatalities.setText("130");
        jPanel23.add(TotalFatalities, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 70, 280, 33));

        LocalName1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        LocalName1.setText("Ondoy");
        jPanel23.add(LocalName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 400, 60));

        typhoonID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        typhoonID.setText("122");
        jPanel23.add(typhoonID, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 179, 33));

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel47.setText("Typhoon");
        jPanel23.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 80, 30));

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel48.setText("Dissipated");
        jPanel23.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 150, 80, 30));

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im_project/line.png"))); // NOI18N
        jPanel23.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, 670, 30));

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel55.setText("Highest Winds");
        jPanel23.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 160, 30));

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel56.setText("Total Damages");
        jPanel23.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 40, 160, 30));

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel57.setText("Total Fatalities");
        jPanel23.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 100, 160, 30));

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel59.setText("International Name");
        jPanel23.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 160, 30));

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel60.setText("Formed");
        jPanel23.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, 70, 30));

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel62.setText("Entered PAR");
        jPanel23.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 150, 110, 30));

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel63.setText("Left PAR");
        jPanel23.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 150, 80, 30));

        other_ar_aff1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Area ID", "Area Name", "Area Capital", "Area Population"
            }
        ));
        other_ar_aff1.setColorBackgoundHead(new java.awt.Color(51, 51, 51));
        other_ar_aff1.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        other_ar_aff1.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        other_ar_aff1.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        other_ar_aff1.setColorSelBackgound(new java.awt.Color(0, 0, 0));
        other_ar_aff1.setFuenteHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jScrollPane1.setViewportView(other_ar_aff1);
        if (other_ar_aff1.getColumnModel().getColumnCount() > 0) {
            other_ar_aff1.getColumnModel().getColumn(0).setPreferredWidth(25);
        }

        jPanel23.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 340, -1, 320));

        year.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        year.setText("Sep 30");
        jPanel23.add(year, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 230, 90, 33));

        jPanel22.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1310, 680));

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel50.setText("Typhoon Database System");
        jPanel22.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel51.setText("iPhoon");
        jPanel22.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel21.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 26, 1310, 730));

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im_project/lights.png"))); // NOI18N
        jPanel21.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 7, -1, -1));

        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im_project/redo.png"))); // NOI18N
        jLabel53.setToolTipText("");
        jPanel21.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 0, -1, 28));

        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im_project/mini logo.png"))); // NOI18N
        jPanel21.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im_project/back.png"))); // NOI18N
        back.setToolTipText("");
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backMouseEntered(evt);
            }
        });
        jPanel21.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 0, -1, 28));

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im_project/User-Interface-Delete-Sign-icon.png"))); // NOI18N
        close.setToolTipText("");
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        jPanel21.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 0, -1, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        new Home().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backMouseClicked

    private void backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_backMouseEntered

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
            java.util.logging.Logger.getLogger(indivRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(indivRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(indivRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(indivRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new indivRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DateDissolved;
    private javax.swing.JLabel DateFormed;
    private javax.swing.JLabel HighestWinds;
    public javax.swing.JLabel InterName_val;
    public javax.swing.JLabel LocalName1;
    private javax.swing.JLabel LowestPressure;
    private javax.swing.JLabel TotalDamage;
    private javax.swing.JLabel TotalFatalities;
    private javax.swing.JLabel back;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel close;
    private javax.swing.JLabel entPH;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lefPH;
    private rojeru_san.complementos.RSTableMetro other_ar_aff1;
    private static javax.swing.JLabel typhoonID;
    private javax.swing.JLabel year;
    // End of variables declaration//GEN-END:variables
}
