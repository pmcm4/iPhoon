/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author pmora
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        typhoon_records();
        signal_names();
        area_info();
        affected();
        total_records();
        avgDecade();
        avgYear();
        htotDmg();
        htotFat();
        ltotwind();
        ltotpress();
    }

    DefaultTableModel model;

    //display typhoon records data to table
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

    public void area_info() {

        try {
            
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from areas ");
            DecimalFormat df = new DecimalFormat("$#,##0.00;(#,##0.00)");
            DecimalFormat ff = new DecimalFormat("#,##0;(#,##0)");
            while (rs.next()) {

                String areaID = rs.getString("AreaID");
                String areaName = rs.getString("AreaName");
                String areaCapital = rs.getString("AreaCapital");
                String areaPeople = ff.format(rs.getInt("AreaPeople"));
                String areaGDP = df.format(rs.getDouble("AreaGDP"));

                Object[] obj = {areaID, areaName, areaCapital, areaPeople, areaGDP};
                model = (DefaultTableModel) area_tbl.getModel();
                model.addRow(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void signal_names() {

        try {

            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from signal_cat");
            while (rs.next()) {

                int signalNo = rs.getInt("signal_no");
                String catName = rs.getString("category");

                Object[] obj = {signalNo, catName};
                model = (DefaultTableModel) signalCat_tbl.getModel();
                model.addRow(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void affected() {
        try {

            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from affected");
            while (rs.next()) {
                int typhoonNo = rs.getInt("Typhoon_No");
                String areaID = rs.getString("Area_ID");
                Object[] obj = {typhoonNo, areaID};
                model = (DefaultTableModel) affected_tbl.getModel();
                model.addRow(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void total_records() {

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select COUNT(typhoonID) as Total from typhoon");
            while (rs.next()) {

                int total = rs.getInt("Total");

                total_records.setText(String.valueOf(total));

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void avgDecade() {

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            Statement st2 = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(typhoonID) as TOTAL2000 FROM typhoon WHERE year BETWEEN 2000 AND 2009");
            ResultSet rs2 = st2.executeQuery("SELECT COUNT(typhoonID) as TOTAL2010 FROM typhoon WHERE year BETWEEN 2010 AND 2020");
            while (rs.next() && rs2.next()) {

                int avgDecade = rs.getInt("TOTAL2000");
                int avgDecade2 = rs2.getInt("TOTAL2010");

                avg_decade.setText(String.valueOf((avgDecade + avgDecade2) / 2));

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void avgYear() {

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(typhoonID)/22 as TOTAL FROM typhoon");
            DecimalFormat df = new DecimalFormat("#,##0.00;(#,##0.00)");
            while (rs.next()) {

                String avg_Year = df.format(rs.getDouble("TOTAL"));
                avg_year.setText(String.valueOf(avg_Year));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    public void htotDmg() {

        try {
            Connection con = DBConnection.getConnection();
             DecimalFormat df = new DecimalFormat("$#,##0.00;(#,##0.00)");
                Statement st2 = con.createStatement();
                ResultSet rs2 = st2.executeQuery("SELECT TyphoonID, Total_Damage from typhoon Order by Total_Damage desc LIMIT 1");
                
                while(rs2.next()){
                int id1 = rs2.getInt("TyphoonID");
                aa.setText(String.valueOf("(Typhoon Id "+id1+")"));
                String max = df.format(rs2.getDouble("Total_Damage"));
                hdmg.setText(String.valueOf(max));
                
                }
               
                
            
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
     public void htotFat() {

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select MAX(Total_Fatal) as htotfat from typhoon");
             DecimalFormat df = new DecimalFormat("#,##0;(#,##0)"); 
                     
            while (rs.next()) {

                String max = df.format(rs.getDouble("htotfat"));
                 hfat.setText(String.valueOf(max));
                
                Statement st2 = con.createStatement();
                ResultSet rs2 = st2.executeQuery("SELECT TyphoonID from typhoon Order by Total_Fatal desc LIMIT 1");
                
                while(rs2.next()){
                int id1 = rs2.getInt("TyphoonID");
                idfat.setText(String.valueOf("(Typhoon Id "+id1+")"));
                
                }
               
                
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
     public void ltotwind() {

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select MIN(HighestWinds) as ltotwinds from typhoon");
             DecimalFormat df = new DecimalFormat("#,##0;(#,##0)"); 
                     
            while (rs.next()) {

                String max = df.format(rs.getDouble("ltotwinds"));
                 lowWind.setText(String.valueOf(max));
                
                Statement st2 = con.createStatement();
                ResultSet rs2 = st2.executeQuery("SELECT TyphoonID from typhoon WHERE HighestWinds <> 0 Order by HighestWinds LIMIT 1");
                
                while(rs2.next()){
                int id1 = rs2.getInt("TyphoonID");
                idlwind.setText(String.valueOf("(Typhoon Id "+id1+")"));
                
                }
               
                
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
     public void ltotpress() {

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select MIN(LowestPressure) as ltotwinds from typhoon");
             DecimalFormat df = new DecimalFormat("#,##0;(#,##0)"); 
                     
            while (rs.next()) {

                String max = df.format(rs.getDouble("ltotwinds"));
                 lowpress.setText(String.valueOf(max));
                
                Statement st2 = con.createStatement();
                ResultSet rs2 = st2.executeQuery("SELECT TyphoonID from typhoon WHERE LowestPressure <> 0 Order by LowestPressure LIMIT 1");
                
                while(rs2.next()){
                int id1 = rs2.getInt("TyphoonID");
                idpress.setText(String.valueOf("(Typhoon Id "+id1+")"));
                
                }
               
                
            }
        } catch (Exception e) {
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
        jPanel11 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        typhoon_record_tbl = new rojeru_san.complementos.RSTableMetro();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        signalCat_tbl = new rojeru_san.complementos.RSTableMetro();
        jScrollPane6 = new javax.swing.JScrollPane();
        affected_tbl = new rojeru_san.complementos.RSTableMetro();
        jScrollPane7 = new javax.swing.JScrollPane();
        area_tbl = new rojeru_san.complementos.RSTableMetro();
        jLabel19 = new javax.swing.JLabel();
        total_records = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        avg_year = new javax.swing.JLabel();
        avg_decade = new javax.swing.JLabel();
        view = new javax.swing.JButton();
        searchbar = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        BagyoField = new javax.swing.JTextField();
        ID_text = new javax.swing.JTextField();
        refresh = new javax.swing.JLabel();
        arID = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        aa = new javax.swing.JLabel();
        hdmg = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        idfat = new javax.swing.JLabel();
        hfat = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        idpress = new javax.swing.JLabel();
        idlwind = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lowWind = new javax.swing.JLabel();
        lowpress = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
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

        jPanel14.setBackground(new java.awt.Color(203, 203, 203));
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel14MouseClicked(evt);
            }
        });
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setText("Manage Records");
        jPanel14.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

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

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 680));

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
            typhoon_record_tbl.getColumnModel().getColumn(0).setPreferredWidth(30);
            typhoon_record_tbl.getColumnModel().getColumn(1).setPreferredWidth(23);
            typhoon_record_tbl.getColumnModel().getColumn(2).setPreferredWidth(45);
            typhoon_record_tbl.getColumnModel().getColumn(3).setPreferredWidth(45);
            typhoon_record_tbl.getColumnModel().getColumn(4).setPreferredWidth(45);
        }

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 124, 1038, 253));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Signal Categories");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 380, 160, -1));

        signalCat_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Signal Number", "Category Name"
            }
        ));
        signalCat_tbl.setColorBackgoundHead(new java.awt.Color(255, 255, 255));
        signalCat_tbl.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        signalCat_tbl.setColorBordeHead(new java.awt.Color(204, 204, 204));
        signalCat_tbl.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        signalCat_tbl.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        signalCat_tbl.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        signalCat_tbl.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        signalCat_tbl.setColorSelBackgound(new java.awt.Color(0, 0, 0));
        signalCat_tbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        signalCat_tbl.setFuenteFilas(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        signalCat_tbl.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        signalCat_tbl.setFuenteHead(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        signalCat_tbl.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane5.setViewportView(signalCat_tbl);
        if (signalCat_tbl.getColumnModel().getColumnCount() > 0) {
            signalCat_tbl.getColumnModel().getColumn(0).setPreferredWidth(30);
            signalCat_tbl.getColumnModel().getColumn(1).setPreferredWidth(23);
        }

        jPanel4.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1049, 406, 239, 138));

        affected_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Typhoon ID", "Area ID"
            }
        ));
        affected_tbl.setColorBackgoundHead(new java.awt.Color(255, 255, 255));
        affected_tbl.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        affected_tbl.setColorBordeHead(new java.awt.Color(204, 204, 204));
        affected_tbl.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        affected_tbl.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        affected_tbl.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        affected_tbl.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        affected_tbl.setColorSelBackgound(new java.awt.Color(0, 0, 0));
        affected_tbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        affected_tbl.setFuenteFilas(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        affected_tbl.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        affected_tbl.setFuenteHead(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        affected_tbl.setGridColor(new java.awt.Color(204, 204, 204));
        affected_tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                affected_tblMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(affected_tbl);
        if (affected_tbl.getColumnModel().getColumnCount() > 0) {
            affected_tbl.getColumnModel().getColumn(0).setPreferredWidth(30);
            affected_tbl.getColumnModel().getColumn(1).setPreferredWidth(23);
        }

        jPanel4.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(879, 406, 164, 253));

        area_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Area ID", "Area Name", "Area Capital", "Area People", "Area GDP"
            }
        ));
        area_tbl.setColorBackgoundHead(new java.awt.Color(255, 255, 255));
        area_tbl.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        area_tbl.setColorBordeHead(new java.awt.Color(204, 204, 204));
        area_tbl.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        area_tbl.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        area_tbl.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        area_tbl.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        area_tbl.setColorSelBackgound(new java.awt.Color(0, 0, 0));
        area_tbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        area_tbl.setFuenteFilas(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        area_tbl.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        area_tbl.setFuenteHead(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        area_tbl.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane7.setViewportView(area_tbl);
        if (area_tbl.getColumnModel().getColumnCount() > 0) {
            area_tbl.getColumnModel().getColumn(0).setPreferredWidth(30);
            area_tbl.getColumnModel().getColumn(1).setPreferredWidth(23);
            area_tbl.getColumnModel().getColumn(2).setPreferredWidth(40);
        }

        jPanel4.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 406, 623, 253));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("Total Records from 2000-Current:");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, 20));

        total_records.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel4.add(total_records, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 62, 21));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("Average Typhoon per Decade(2000-2020):");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, 20));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("Average Typhoon per Year:");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, -1, 20));

        avg_year.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel4.add(avg_year, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 60, 21));

        avg_decade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel4.add(avg_decade, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 60, 20));

        view.setText("View Typhoon");
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
        jPanel4.add(view, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 637, -1, 20));

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
        jPanel4.add(searchbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1047, 88, 241, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setText("Selected:");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1049, 562, -1, -1));

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
        jPanel4.add(BagyoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1119, 596, 150, 30));

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
        jPanel4.add(ID_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(1119, 555, 150, 30));

        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im_project/PngItem_804922.png"))); // NOI18N
        refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshMouseClicked(evt);
            }
        });
        jPanel4.add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 90, -1, 25));

        arID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        arID.setText("    ");
        jPanel4.add(arID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 590, 40, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setText("Highest Fatalities:");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, -1, 30));

        aa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel4.add(aa, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, 180, 30));

        hdmg.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        hdmg.setText("test");
        jPanel4.add(hdmg, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, 170, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setText("Highest Damage:");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, -1, 30));

        idfat.setText("jLabel2");
        jPanel4.add(idfat, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 40, 200, 30));

        hfat.setText("jLabel2");
        jPanel4.add(hfat, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 40, 70, 30));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setText("Highest Fatalities:");
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, -1, 30));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setText("Highest Damage:");
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, -1, 30));

        idpress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        idpress.setText("Lowest Fatalities:");
        jPanel4.add(idpress, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 40, -1, 30));

        idlwind.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        idlwind.setText("Lowest Damage:");
        jPanel4.add(idlwind, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 20, -1, 30));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel29.setText("Lowest Winds Obtained:");
        jPanel4.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 20, -1, 30));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel30.setText("Lowest Pressure Obtained:");
        jPanel4.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 40, -1, 30));

        lowWind.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lowWind.setText("999");
        jPanel4.add(lowWind, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 20, 40, 30));

        lowpress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lowpress.setText("999");
        jPanel4.add(lowpress, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 40, 50, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Typhoon Records");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 160, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel28.setText("Area Information");
        jPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 160, -1));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel31.setText("Affected");
        jPanel4.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 380, 160, -1));

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

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(1304, 756));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

    private void ID_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ID_textKeyReleased

    }//GEN-LAST:event_ID_textKeyReleased

    private void ID_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ID_textActionPerformed

    private void ID_textMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ID_textMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ID_textMouseClicked

    private void BagyoFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BagyoFieldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_BagyoFieldKeyReleased

    private void BagyoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BagyoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BagyoFieldActionPerformed

    private void BagyoFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BagyoFieldMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BagyoFieldMouseClicked

    private void searchbarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchbarKeyReleased
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            Statement st2 = con.createStatement();
            ResultSet rs = st.executeQuery("select *, IFNULL(Total_Fatal, 'NULL')as TOTFATAL , IFNULL(InterName, 'N/A') as InterName_NULL  from typhoon");
            DecimalFormat df = new DecimalFormat("$#,##0.00;(#,##0.00)");
            while (rs.next()) {
                String query = "select * from typhoon where InterName=? OR BagyoName=? OR typhoonID=?";
                PreparedStatement pst1 = con.prepareStatement(query);
                pst1.setString(1, searchbar.getText());
                pst1.setString(2, searchbar.getText());
                pst1.setString(3, searchbar.getText());
                ResultSet rs1 = pst1.executeQuery();

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
                typhoon_record_tbl.setModel(DbUtils.resultSetToTableModel(rs1));
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

    }//GEN-LAST:event_searchbarKeyReleased

    private void searchbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchbarActionPerformed

    private void searchbarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbarMouseClicked
        searchbar.setText("");
    }//GEN-LAST:event_searchbarMouseClicked

    private void viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewMouseClicked
        
    }//GEN-LAST:event_viewMouseClicked

    private void typhoon_record_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_typhoon_record_tblMouseClicked
        DefaultTableModel model = (DefaultTableModel) typhoon_record_tbl.getModel();
        int Myindex = typhoon_record_tbl.getSelectedRow();
        ID_text.setText(model.getValueAt(Myindex, 0).toString());
        BagyoField.setText(model.getValueAt(Myindex, 3).toString());


    }//GEN-LAST:event_typhoon_record_tblMouseClicked

    private void refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseClicked
        new Home().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_refreshMouseClicked

    private void ID_textPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_ID_textPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_ID_textPropertyChange

    private void affected_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_affected_tblMouseClicked

    }//GEN-LAST:event_affected_tblMouseClicked

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
        try {
            String ID = ID_text.getText();

            new indivRecord(ID).setVisible(true);
            this.dispose();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_viewActionPerformed

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        new testTables().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel11MouseClicked

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked
       new ManageRecords().setVisible(true);
        this.dispose();
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

    public void search(String query) {

    }

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BagyoField;
    public javax.swing.JTextField ID_text;
    private javax.swing.JLabel aa;
    private rojeru_san.complementos.RSTableMetro affected_tbl;
    private javax.swing.JLabel arID;
    private rojeru_san.complementos.RSTableMetro area_tbl;
    private javax.swing.JLabel avg_decade;
    private javax.swing.JLabel avg_year;
    private javax.swing.JLabel close;
    private javax.swing.JLabel hdmg;
    private javax.swing.JLabel hfat;
    private javax.swing.JLabel idfat;
    private javax.swing.JLabel idlwind;
    private javax.swing.JLabel idpress;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
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
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lowWind;
    private javax.swing.JLabel lowpress;
    private javax.swing.JLabel refresh;
    private javax.swing.JTextField searchbar;
    private rojeru_san.complementos.RSTableMetro signalCat_tbl;
    private javax.swing.JLabel total_records;
    private rojeru_san.complementos.RSTableMetro typhoon_record_tbl;
    private javax.swing.JButton view;
    // End of variables declaration//GEN-END:variables
}
