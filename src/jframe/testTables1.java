/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pmora
 */
public class testTables1 extends javax.swing.JFrame {

    /**
     * Creates new form retired_typhoon
     */
    public testTables1() {
        initComponents();
        nooflad();
        nooflad2();
        

    }
        DefaultTableModel model;
 
    
     
     public void nooflad(){
         Connection con = DBConnection.getConnection();
        try{
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT AreaName, AreaGDP, COUNT(TyphoonID) as count\n" +
"	  FROM typhoon AS a, affected AS b, areas AS c\n" +
"	  WHERE a.TyphoonID = b.Typhoon_No AND b.Area_ID = c.AreaID\n" +
"	  GROUP BY AreaName\n" +
"	  HAVING COUNT(TyphoonID) > 1\n" +
"	  ORDER BY 3 DESC;");
             DecimalFormat df = new DecimalFormat("$#,##0;(#,##0)"); 
            while (rs.next()) {
               
               String aname = rs.getString("AreaName");
               String agdp = df.format(rs.getDouble("AreaGDP"));
               int land = rs.getInt("count");
               
                Object[] obj = {aname, agdp, land};
                model = (DefaultTableModel) lad.getModel();
                model.addRow(obj);
            }  
            
        }catch(Exception e){
            e.printStackTrace();
        }
     }
     public void nooflad2(){
         Connection con = DBConnection.getConnection();
        try{
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT year, category, COUNT(SignalNumber) as count\n" +
"	  FROM typhoon AS a, signal_cat AS b\n" +
"	  WHERE a.SignalNumber = b.signal_no\n" +
"	  GROUP BY year, category");
             DecimalFormat df = new DecimalFormat("$#,##0;(#,##0)"); 
            while (rs.next()) {
               int yyyy = rs.getInt("year");
               String cname = rs.getString("category");
               int land = rs.getInt("count");
               
                Object[] obj = {yyyy, cname, land};
                model = (DefaultTableModel) lad1.getModel();
                model.addRow(obj);
            }  
            
        }catch(Exception e){
            e.printStackTrace();
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

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        arID = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        lad = new rojeru_san.complementos.RSTableMetro();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        lad1 = new rojeru_san.complementos.RSTableMetro();
        jLabel4 = new javax.swing.JLabel();
        materialButton6 = new necesario.MaterialButton();
        materialButton3 = new necesario.MaterialButton();
        materialButton7 = new necesario.MaterialButton();
        materialButton5 = new necesario.MaterialButton();
        materialButton4 = new necesario.MaterialButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        close = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(234, 234, 234));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(249, 249, 249));
        jPanel1.setForeground(new java.awt.Color(249, 249, 249));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(203, 203, 203));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Features");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 56, 117, 31));

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

        jPanel11.setBackground(new java.awt.Color(153, 153, 153));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
        });
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setText("Record Viewing");
        jPanel11.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel3.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 232, 37));

        jPanel14.setBackground(new java.awt.Color(203, 203, 203));
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel14MouseClicked(evt);
            }
        });
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setText("Manage Records");
        jPanel14.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanel3.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 232, 37));

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

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 680));

        arID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        arID.setText("    ");
        jPanel4.add(arID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 647, 40, 30));

        lad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Area Name", "Area GDP", "No. of Typhoons Landed"
            }
        ));
        lad.setColorBackgoundHead(new java.awt.Color(255, 255, 255));
        lad.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        lad.setColorBordeHead(new java.awt.Color(204, 204, 204));
        lad.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        lad.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        lad.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        lad.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        lad.setColorSelBackgound(new java.awt.Color(0, 0, 0));
        lad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lad.setFuenteFilas(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lad.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lad.setFuenteHead(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lad.setGridColor(new java.awt.Color(204, 204, 204));
        lad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ladMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(lad);

        jPanel4.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 700, 190));

        jLabel2.setText("Displays the year, typhoon category and the total number of times it occured on each year.");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 590, 24));

        lad1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Year", "Category", "No. of Typhoons"
            }
        ));
        lad1.setColorBackgoundHead(new java.awt.Color(255, 255, 255));
        lad1.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        lad1.setColorBordeHead(new java.awt.Color(204, 204, 204));
        lad1.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        lad1.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        lad1.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        lad1.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        lad1.setColorSelBackgound(new java.awt.Color(0, 0, 0));
        lad1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lad1.setFuenteFilas(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lad1.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lad1.setFuenteHead(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lad1.setGridColor(new java.awt.Color(204, 204, 204));
        lad1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lad1MouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(lad1);

        jPanel4.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 700, 240));

        jLabel4.setText("Displays how many typhoons landed on each affected and its GDP.");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 480, 24));

        materialButton6.setText("5");
        materialButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                materialButton6MouseClicked(evt);
            }
        });
        materialButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialButton6ActionPerformed(evt);
            }
        });
        jPanel4.add(materialButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, 90, 30));

        materialButton3.setText("4");
        materialButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                materialButton3MouseClicked(evt);
            }
        });
        materialButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(materialButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, 90, 30));

        materialButton7.setText("3");
        materialButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                materialButton7MouseClicked(evt);
            }
        });
        materialButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialButton7ActionPerformed(evt);
            }
        });
        jPanel4.add(materialButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 90, 30));

        materialButton5.setBackground(new java.awt.Color(204, 204, 204));
        materialButton5.setText("2");
        materialButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(materialButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 90, 30));

        materialButton4.setText("1");
        materialButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                materialButton4MouseClicked(evt);
            }
        });
        materialButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(materialButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 90, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1000, 610));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Typhoon Database System");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel18.setText("iPhoon");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 26, 1000, 660));

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
        jPanel2.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 0, -1, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        new ManageRecords().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel11MouseClicked

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        new AddRecord().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel10MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        new Home().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel14MouseClicked

    private void ladMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ladMouseClicked

    }//GEN-LAST:event_ladMouseClicked

    private void lad1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lad1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lad1MouseClicked

    private void materialButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_materialButton6ActionPerformed

    private void materialButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_materialButton3ActionPerformed

    private void materialButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_materialButton7ActionPerformed

    private void materialButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_materialButton5ActionPerformed

    private void materialButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_materialButton4ActionPerformed

    private void materialButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_materialButton4MouseClicked
    new testTables().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_materialButton4MouseClicked

    private void materialButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_materialButton7MouseClicked
       new testTables2().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_materialButton7MouseClicked

    private void materialButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_materialButton3MouseClicked
        new testTables3().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_materialButton3MouseClicked

    private void materialButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_materialButton6MouseClicked
        new testTables4().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_materialButton6MouseClicked

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
            java.util.logging.Logger.getLogger(testTables1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(testTables1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(testTables1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(testTables1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new testTables1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel arID;
    private javax.swing.JLabel close;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
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
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private rojeru_san.complementos.RSTableMetro lad;
    private rojeru_san.complementos.RSTableMetro lad1;
    private necesario.MaterialButton materialButton3;
    private necesario.MaterialButton materialButton4;
    private necesario.MaterialButton materialButton5;
    private necesario.MaterialButton materialButton6;
    private necesario.MaterialButton materialButton7;
    // End of variables declaration//GEN-END:variables
}