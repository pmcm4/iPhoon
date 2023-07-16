/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;


import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class updateRec extends javax.swing.JFrame {

    /**
     * Creates new form updateRec
     */
    public updateRec() {
        initComponents();
    }
    int TyphoonID,Typhoon_No, ImageID, TyphoonID_Image, signal_no, AreaPeople, Year, SignalNumber, HighestWinds, LowestPressure, Total_Fatal, s=0;
    float AreaGDP, Total_Damage;
    char Area_ID, AreaID;
    String AreaName, AreaCapital, InterName, DateFormed, EnteredPH, LeftPH, DateDissolved, BagyoName, category, ImageName, ImagePath, ImageFile, path = null, fname=null; 
    File f = null;
    private ImageIcon format = null;
    byte[] pimage=null;
    DefaultTableModel model;

    updateRec(String ID) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this();
        typhoonID_lbl.setText(ID);
        try {   
            
            int id = Integer.parseInt(typhoonID_lbl.getText());
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select *, IFNULL(Total_Fatal, 0) as totFAT from typhoon WHERE TyphoonID="+id+"");
            
            while(rs.next()){
                
                String inName = rs.getString("InterName");
                String LocName = rs.getString("BagyoName");
                int yearno = rs.getInt("year");
                String SigNo = rs.getString("SignalNumber");
                String dForm = rs.getString("DateFormed");
                String dDi = rs.getString("DateDissolved");
                String ePH = rs.getString("EnteredPH");
                String lPH = rs.getString("LeftPH");
                String hWinds = rs.getString("HighestWinds");
                String lPress = rs.getString("LowestPressure");
                String totFat = rs.getString("totFAT");
                int totDmg = rs.getInt("Total_Damage");
                
                
                java.util.Date fdate = new SimpleDateFormat("yyyy-mm-dd").parse(dForm);
                java.util.Date ddate = new SimpleDateFormat("yyyy-mm-dd").parse(dDi);
                java.util.Date edate = new SimpleDateFormat("yyyy-mm-dd").parse(ePH);
                java.util.Date ldate = new SimpleDateFormat("yyyy-mm-dd").parse(lPH);
                
                
                intName.setText(String.valueOf(inName));
                lName.setText(String.valueOf(LocName)); 
                signo.setSelectedItem(String.valueOf(SigNo));   //.getSelectedItem().toString()
                yyyy.setText(String.valueOf(yearno));
                dFormed.setDate(fdate);
                dDiss.setDate(ddate);
                entPH.setDate(edate);
                leftPH.setDate(ldate);
                hWind.setText(String.valueOf(hWinds));
                lPressure.setText(String.valueOf(lPress));
                totfat.setText(String.valueOf(totFat));
                totdmg.setText(String.valueOf(totDmg));
                
                
                
            }
        }catch(Exception e){
            e.printStackTrace();
            
        }
        
                try {   
            SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
            int id = Integer.parseInt(typhoonID_lbl.getText());
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from affected WHERE Typhoon_No="+id+"");
            DecimalFormat df = new DecimalFormat("$#,##0.00;(#,##0.00)");
            DecimalFormat ff = new DecimalFormat("#,##0;(#,##0)");
            while(rs.next()){
                
                int tid = rs.getInt("Typhoon_No");
                String aID = rs.getString("Area_ID");
                    
                Object[] obj = {tid,aID};
                model = (DefaultTableModel) affected_tbl.getModel();
                model.addRow(obj);
                
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
                try{
            int id = Integer.parseInt(typhoonID_lbl.getText());
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery("select * from image_tbl WHERE TyphoonID_Image="+id+"");
            while(rs.next()){
                String iPath = rs.getString("ImagePath");
                
                
                
                ImageIcon ii = new ImageIcon(iPath);
                Image img = ii.getImage().getScaledInstance(570, 380, Image.SCALE_SMOOTH);
                imageLBL.setIcon(new ImageIcon(img));
 
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
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        dFormed = new com.toedter.calendar.JDateChooser();
        dDiss = new com.toedter.calendar.JDateChooser();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        entPH = new com.toedter.calendar.JDateChooser();
        leftPH = new com.toedter.calendar.JDateChooser();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        imageLBL = new javax.swing.JLabel();
        view = new javax.swing.JButton();
        view1 = new javax.swing.JButton();
        intName = new javax.swing.JTextField();
        hWind = new javax.swing.JTextField();
        lPressure = new javax.swing.JTextField();
        totdmg = new javax.swing.JTextField();
        totfat = new javax.swing.JTextField();
        yyyy = new javax.swing.JTextField();
        lName = new javax.swing.JTextField();
        aID_del = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        affected_tbl = new rojeru_san.complementos.RSTableMetro();
        delete = new javax.swing.JButton();
        aIDc = new javax.swing.JComboBox<>();
        signo = new javax.swing.JComboBox<>();
        imagePath = new javax.swing.JTextField();
        view4 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        view5 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        typhoonID_lbl = new javax.swing.JTextField();
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
        back = new javax.swing.JLabel();
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

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Int'l Name:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 55, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Local Name:");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(636, 55, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Signal No:");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 81, -1, -1));

        dFormed.setToolTipText("");
        jPanel4.add(dFormed, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 50, 140, 30));
        jPanel4.add(dDiss, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 140, 140, 30));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Left PH Date:");
        jPanel4.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 110, -1, 30));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Year:");
        jPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 81, -1, -1));
        jPanel4.add(entPH, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 80, 140, 30));
        jPanel4.add(leftPH, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 110, 140, 30));

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setText("Highest Winds:");
        jPanel4.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 107, -1, -1));

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("Lowest Pressure:");
        jPanel4.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 133, -1, -1));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setText("Total Damage:");
        jPanel4.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(621, 133, -1, -1));

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel38.setText("Total Fatalities:");
        jPanel4.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(622, 107, -1, -1));

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel40.setText("Other Areas Affected:");
        jPanel4.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, -1, 33));

        imageLBL.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true));
        jPanel4.add(imageLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 210, 513, 329));

        view.setText("Update");
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
        jPanel4.add(view, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 140, 93, 33));

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
        jPanel4.add(view1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 590, 93, 33));
        jPanel4.add(intName, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 55, 179, -1));
        jPanel4.add(hWind, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 107, 179, -1));
        jPanel4.add(lPressure, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 133, 179, -1));
        jPanel4.add(totdmg, new org.netbeans.lib.awtextra.AbsoluteConstraints(715, 133, 179, -1));
        jPanel4.add(totfat, new org.netbeans.lib.awtextra.AbsoluteConstraints(715, 107, 179, -1));
        jPanel4.add(yyyy, new org.netbeans.lib.awtextra.AbsoluteConstraints(715, 81, 179, -1));
        jPanel4.add(lName, new org.netbeans.lib.awtextra.AbsoluteConstraints(715, 55, 179, -1));

        aID_del.setEditable(false);
        aID_del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aID_delActionPerformed(evt);
            }
        });
        jPanel4.add(aID_del, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 350, 90, 33));

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

        jPanel4.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 215, 239));

        delete.setText("Delete");
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel4.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, 93, 33));

        aIDc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TWN", "CHN", "PRK", "KOR", "JPN", "GUM", "FSM", "VNM", "KHM", "RUS", "LAO", "THA", "MNP", "HKG", "MMR", "MYS", "CAN", "IND", "PLW", "MAC", "LKA", "IDN", "BGD", "MHL" }));
        aIDc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                aIDcItemStateChanged(evt);
            }
        });
        jPanel4.add(aIDc, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, -1, 33));

        signo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        jPanel4.add(signo, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 81, 179, -1));

        imagePath.setText("File Name");
        jPanel4.add(imagePath, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 550, 350, 33));

        view4.setText("Browse");
        view4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view4ActionPerformed(evt);
            }
        });
        jPanel4.add(view4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 550, 93, 33));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setText("Typhoon ID:");
        jPanel4.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, 30));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText("Date Dissolved:");
        jPanel4.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 140, -1, 30));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setText("Entered PH Date:");
        jPanel4.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 80, -1, 30));

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setText("Date Formed:");
        jPanel4.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 50, -1, 30));

        view5.setText("Add");
        view5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                view5MouseClicked(evt);
            }
        });
        view5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view5ActionPerformed(evt);
            }
        });
        jPanel4.add(view5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, 93, 33));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setText("Selected:");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 60, -1));

        typhoonID_lbl.setEditable(false);
        jPanel4.add(typhoonID_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 50, 33));

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

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 680));

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

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/im_project/back.png"))); // NOI18N
        back.setToolTipText("");
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        jPanel2.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 0, -1, 28));

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

    private void viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewMouseClicked
        if(yyyy.getText().isEmpty() || intName.getText().isEmpty() || lName.getText().isEmpty() || signo.getSelectedItem().toString().isEmpty() || dFormed.toString().isEmpty() ||
            entPH.toString().isEmpty() || leftPH.toString().isEmpty() || dDiss.toString().isEmpty() || hWind.getText().isEmpty() ||
            lPressure.getText().isEmpty() || totfat.getText().isEmpty() || totdmg.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Missing Fields!");
        }
        else{
            try {
                Connection con = DBConnection.getConnection();
                try {
                        int id = Integer.parseInt(typhoonID_lbl.getText());
                        Statement st = con.createStatement();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
                        PreparedStatement ps = null;
                        Statement st2 = con.createStatement();
                        String query = ("UPDATE typhoon set year=?, InterName=?, BagyoName=?, SignalNumber=?, DateFormed=?, EnteredPH=?, LeftPH=?, DateDissolved=?, HighestWinds=?, LowestPressure=?, Total_Fatal=?, Total_Damage=? WHERE TyphoonID="+id+"");
                        ps = con.prepareStatement(query);
                        
                        SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");   
                            ps.setInt(1, Integer.valueOf(yyyy.getText()));
                            ps.setString(2, intName.getText());
                            ps.setString(3, lName.getText());
                            ps.setInt(4, Integer.valueOf(signo.getSelectedItem().toString()));
                            ps.setString(5, (Date_Format.format(dFormed.getDate())));
                            ps.setString(6, (Date_Format.format(entPH.getDate())));
                            ps.setString(7, (Date_Format.format(leftPH.getDate())));
                            ps.setString(8, (Date_Format.format(dDiss.getDate())));
                            ps.setInt(9, Integer.valueOf(hWind.getText()));
                            ps.setInt(10, Integer.valueOf(lPressure.getText()));
                            ps.setInt(11, Integer.valueOf(totfat.getText()));
                            ps.setInt(12, Integer.valueOf(totdmg.getText()));
                            
                            ps.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Update Success!");
                    
                }catch (NumberFormatException  ex){
                      JOptionPane.showMessageDialog(this, "Invalid Input Type!");
                }

            } catch (Exception e) {
                e.printStackTrace();

            }

        }

    }//GEN-LAST:event_viewMouseClicked

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewActionPerformed

    private void view1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view1ActionPerformed
        

    }//GEN-LAST:event_view1ActionPerformed

    private void affected_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_affected_tblMouseClicked
        DefaultTableModel model = (DefaultTableModel) affected_tbl.getModel();
        int Myindex = affected_tbl.getSelectedRow();
        aID_del.setText(model.getValueAt(Myindex, 1).toString());
    }//GEN-LAST:event_affected_tblMouseClicked

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
            if(aID_del.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "No Area Selected");
        }
        else{
            try {
                Connection con = DBConnection.getConnection();
                try {
                        int id = Integer.parseInt(typhoonID_lbl.getText());
                        Statement st = con.createStatement();
                        PreparedStatement ps = null;
                        Statement st2 = con.createStatement();
                        String query = ("DELETE FROM affected WHERE Area_ID='"+aID_del.getText()+"'");
                        ps = con.prepareStatement(query);
                        ps.executeUpdate();
                        aID_del.setText("");
                        Object[] obj = {aID_del.getText()};
                        model = (DefaultTableModel) affected_tbl.getModel();
                        model.setRowCount(0);
                        
                         try {   
                            SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
                            Statement st3 = con.createStatement();
                            ResultSet rs = st3.executeQuery("select * from affected WHERE Typhoon_No="+id+"");
                            DecimalFormat df = new DecimalFormat("$#,##0.00;(#,##0.00)");
                            DecimalFormat ff = new DecimalFormat("#,##0;(#,##0)");
                            while(rs.next()){
                
                                int tid = rs.getInt("Typhoon_No");
                                String aID = rs.getString("Area_ID");

                                Object[] obj2 = {tid,aID};
                                model = (DefaultTableModel) affected_tbl.getModel();
                                model.addRow(obj2);
                            }

                        }catch(Exception e){
                            e.printStackTrace();

                        }
                        
                        
                        
                }catch (Exception e){
                      e.printStackTrace();
                }

            } catch (Exception e) {
                e.printStackTrace();

            }

        }

    }//GEN-LAST:event_deleteMouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

    private void aIDcItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_aIDcItemStateChanged

    }//GEN-LAST:event_aIDcItemStateChanged

    private void view4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view4ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter fnwf = new FileNameExtensionFilter("PNG JPG AND JPEG","png","jpeg","jpg");
        fileChooser.addChoosableFileFilter(fnwf);
        int load = fileChooser.showOpenDialog(null);

        if(load==fileChooser.APPROVE_OPTION){
            f = fileChooser.getSelectedFile();
            path = f.getAbsolutePath();
            imagePath.setText(path);
            ImageIcon ii = new ImageIcon(path);
            Image img = ii.getImage().getScaledInstance(570, 380, Image.SCALE_SMOOTH);
            imageLBL.setIcon(new ImageIcon(img));
        }

    }//GEN-LAST:event_view4ActionPerformed

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

    private void view5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view5MouseClicked
       
        
        
        try {
            Connection con = DBConnection.getConnection();
            Statement st2 = con.createStatement();
            PreparedStatement add = con.prepareStatement("insert into affected values(?,?)");
                add.setInt(1, Integer.valueOf(typhoonID_lbl.getText()));
                add.setString(2, aIDc.getSelectedItem().toString());
                
                
                Statement ex = con.createStatement();
                String selectQuery1 = "SELECT * FROM typhoon WHERE TyphoonID="+typhoonID_lbl.getText()+"";
                System.out.println(selectQuery1);
                ResultSet rs2 = ex.executeQuery(selectQuery1);
                if(rs2.next()==false){
                    JOptionPane.showMessageDialog(this, "Typhoon ID "+typhoonID_lbl.getText()+" does not exist!"+"\nPlease refer to step 1");
                }else{
                Statement dup = con.createStatement();
                String selectQuery = "SELECT * FROM affected WHERE Typhoon_No="+typhoonID_lbl.getText()+" AND Area_ID='"+aIDc.getSelectedItem().toString()+"'";
                System.out.println(selectQuery);
                ResultSet rs = dup.executeQuery(selectQuery);
                 if (rs.next()==true){
                JOptionPane.showMessageDialog(this, "Area ID '"+aIDc.getSelectedItem().toString()+"' already exists in Typhoon ID "+typhoonID_lbl.getText()+"");
            }else{
                int id = Integer.parseInt(typhoonID_lbl.getText());
          try {
                int setInt = Integer.valueOf(typhoonID_lbl.getText());
                String areaID = aIDc.getSelectedItem().toString();
 
                Object[] obj = {setInt, areaID};
                model = (DefaultTableModel) affected_tbl.getModel();
                
                model.addRow(obj);
     
        } catch (Exception e) {
            e.printStackTrace();

        }
                int row = add.executeUpdate();
               
                 }
                    
        
        
           } 
          } catch (Exception e) {
            e.printStackTrace();

        }
              
        
    }//GEN-LAST:event_view5MouseClicked

    private void view5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_view5ActionPerformed

    private void view1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view1MouseClicked
         if(imagePath.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Missing Fields!");
        }
        else{
            try {
                System.out.print("Image Path - "+ path);
                System.out.print("Image Name - "+ f.getName());
                File f = new File(path);
                Connection con = DBConnection.getConnection();
                try {
                        InputStream is = new FileInputStream(f);
                        int id = Integer.parseInt(typhoonID_lbl.getText());
                        Statement st = con.createStatement();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
                        PreparedStatement ps = null;
                        Statement st2 = con.createStatement();
                        String query = ("UPDATE image_tbl set ImageName=?, ImagePath=?, ImageFile=? WHERE ImageID="+id+"");
                            ps = con.prepareStatement(query);
                            ps.setString(1, f.getName());
                            ps.setString(2, path);
                            ps.setBlob(3, is);
                            
                            
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Update Success!");
                    
                }catch (Exception e){
                      e.printStackTrace();
                      
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Missing Fields!");

            }

        }

    }//GEN-LAST:event_view1MouseClicked

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        new ManageRecords().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backMouseClicked

    private void aID_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aID_delActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aID_delActionPerformed

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
            java.util.logging.Logger.getLogger(updateRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateRec().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aID_del;
    private javax.swing.JComboBox<String> aIDc;
    public rojeru_san.complementos.RSTableMetro affected_tbl;
    private javax.swing.JLabel back;
    private javax.swing.JLabel close;
    private com.toedter.calendar.JDateChooser dDiss;
    private com.toedter.calendar.JDateChooser dFormed;
    private javax.swing.JButton delete;
    private com.toedter.calendar.JDateChooser entPH;
    private javax.swing.JTextField hWind;
    private javax.swing.JLabel imageLBL;
    private javax.swing.JTextField imagePath;
    private javax.swing.JTextField intName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField lName;
    private javax.swing.JTextField lPressure;
    private com.toedter.calendar.JDateChooser leftPH;
    private javax.swing.JComboBox<String> signo;
    private javax.swing.JTextField totdmg;
    private javax.swing.JTextField totfat;
    private javax.swing.JTextField typhoonID_lbl;
    private javax.swing.JButton view;
    private javax.swing.JButton view1;
    private javax.swing.JButton view4;
    private javax.swing.JButton view5;
    private javax.swing.JTextField yyyy;
    // End of variables declaration//GEN-END:variables
}
