/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FeeCounter1.java
 *
 * Created on Sep 29, 2009, 10:08:40 AM
 */

package com.duc.FeeDepartment;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//import com.duc.ImportSection.*;
import java.net.InetAddress;
import java.text.Format;
import java.util.Vector;
import static com.duc.DatabaseConnection.DatabaseConnection.*;
/**
 *
 * @author Ravi Dangaich
 */
public class FeeCounter1 extends javax.swing.JInternalFrame {
DefaultTableModel dm,dm1;
//DateFormat df;
//MapForIndex mp=new MapForIndex();

HashMap sessionmap=mp.getSessionIndexToName();
HashMap sessionmap1=mp.getSessionIndexFromName();
    HashMap month=mp.mapMonth();
    HashMap month1=mp.mapMonth1();
    HashMap classmap=mp.getClassIndexName();
 HashMap classmap1=mp.getClassIndexFromName();
 HashMap sectionmap=mp.getSectionIndexName();
 HashMap sectionmap1=mp.getSectionIndexFromName();

  HashMap admissionfeemap=mp.getAdmissionFeeIndexToName();
    HashMap periodicfeemap=mp.getPeriodicFeeIndexToName();

    HashMap monthlyfeemap=mp.getMonthlyFeeIndexToName();
    HashMap otherfeemap=mp.getLedgerOtherFeeIndexToName();

    HashMap headfeetypemap=mp.getFeeHeadIndexFromFeeTypeInFeeDues();

     HashMap admissionfeemap1=mp.getAdmissionFeeIndexFromName();
    HashMap periodicfeemap1=mp.getPeriodicFeeIndexFromName();

    HashMap monthlyfeemap1=mp.getMonthlyFeeIndexFromName();
    HashMap otherfeemap1=mp.getLedgerOtherFeeIndexFromName();
HashMap invname=mpi.getInventoryNameFromIndex();
HashMap invname1=mpi.getInventoryNameToIndex();

    /** Creates new form FeeCounter1 */
    public FeeCounter1() {
        initComponents();
    //date=datum;
        fromClass();
       // fromSection();
        //fromRoll();
        dm = (DefaultTableModel) jTable1.getModel();
        dm.setRowCount(0);

        dm1 = (DefaultTableModel) jXTable1.getModel();
        dm1.setRowCount(0);

    //    dm1 = (DefaultTableModel) jTable2.getModel();
      //  dm1.setRowCount(2);
        // df=new SimpleDateFormat("yyyy-MM-dd");
cashCheck.setSelected(true);
jPanel6.setVisible(false);
//jPanel5.setVisible(false);
jButton12.setVisible(false);
//jButton11.setVisible(false);
//jButton20.setVisible(false);

jButton1.setVisible(false);  //full pay button
jButton18.setVisible(false);  // manual pay button


jButton22.setVisible(false);
 usedsurplustext.setText(String.valueOf(0));
 
 buttonGroup1.add(classmonthlyfee);
 buttonGroup1.add(studentmonthlyfee);

  buttonGroup2.add(classadmissionfee);
 buttonGroup2.add(studentadmissionfee);

  buttonGroup3.add(classperiodicfee);
 buttonGroup3.add(studentperiodicfee);
 buttonGroup4.add(cashCheck);
 buttonGroup4.add(chequeCheck);
 buttonGroup4.add(ddCheck);
 
//jComboBox3.setForeground(Color.BLUE);
fromSession();
//.setVisible(true);
garbageCollection();
//jTable2.setVisible(false);
jComboBox3.setVisible(false);

classadmissionfee.setVisible(false);
                                            studentadmissionfee.setVisible(false);
                                            jButton12.setVisible(false);

                                          //  jCheckBox1.setSelected(false);
                                            //jButton20.setVisible(false);

                                            classperiodicfee.setVisible(false);
                                            studentperiodicfee.setVisible(false);
                                            jButton22.setVisible(false);

    }
     public void garbageCollection()
    {
        int SIZE = 200;
        StringBuffer s;
    for (int i = 0; i < SIZE; i++) {
    }
    System.out.println("Garbage Collection started explicitly.");
    long time = System.currentTimeMillis();
    System.gc();
    System.out.println("It took " + (System.currentTimeMillis()-time) + " ms");

    }
    
   
 public void fromClass()
    {
         try
    {

System.out.println("con of Fee Deposit Section="+con);
         ps = con.prepareStatement("select * from classsetup");

             rs = ps.executeQuery();


            while (rs.next())
            {
        jComboBox1.addItem(rs.getString(1));


            }

 // con.close();
         }
    catch(Exception e)
    {
        System.err.println("Error is"+e);
    }

    }

  /*  public void fromSection()
    {
        try
    {

  
         ps = con.prepareStatement("select sectiontitle from sectionsetuplist");

             rs = ps.executeQuery();
         while (rs.next())
            {
        jComboBox2.addItem(rs.getString(1));

         }
         }
    catch(Exception e)
    {
        System.err.println("Error is"+e);
    }


    }*/
/*
public void fromRoll()
    {
        try
    {

         ps = con.prepareStatement("select  distinct roll from studententry");

             rs = ps.executeQuery();


            while (rs.next())
            {
        jComboBox4.addItem(rs.getInt(1));


            }
      }
    catch(Exception e)
    {
        System.err.println("Error is"+e);
    }


    }


public void classFilter()
    {
          // //con=com.duc.DatabaseConnection.DatabaseConnection.con;
        try
        {
            ps = con.prepareStatement("select *from sectionsetup where classtitle=?");
            ps.setInt(1, Integer.parseInt(classmap1.get(jComboBox1.getSelectedItem().toString()).toString()));
             rs = ps.executeQuery();
            int i = 0,j=0;

//jComboBox2.removeAllItems();

            while(rs.next())
            {

  //              jComboBox2.addItem(sectionmap1.get(rs.getInt(2)));

            }

        }  catch(Exception e)
        {
            e.printStackTrace();
        }


    }

*/

    
/*public void sectionFilter()
    {
         int i = 0,j=0;  //con=com.duc.DatabaseConnection.DatabaseConnection.con;
        try
        {
            ps = con.prepareStatement("select *from studententry where class =? and section=?");
            ps.setString(1, classmap1.get(jComboBox1.getSelectedItem().toString()).toString());
            ps.setString(2, sectionmap1.get(jComboBox2.getSelectedItem().toString()).toString());
             rs = ps.executeQuery();


jComboBox4.removeAllItems();

            while(rs.next())
            {

                jComboBox4.addItem(rs.getString(11));
                i++;

            }

//con.close();

        }  catch(Exception e)
        {
            e.printStackTrace();
        }


    }
*/
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        admissionnumber = new javax.swing.JTextField();
        cmbMonth = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        classmonthlyfee = new javax.swing.JRadioButton();
        studentmonthlyfee = new javax.swing.JRadioButton();
        jComboBox3 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        totaldues = new javax.swing.JTextField();
        collected = new javax.swing.JTextField();
        remaining = new javax.swing.JTextField();
        totalsurplus = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        usedsurplustext = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        mini = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jPanel5 = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        classadmissionfee = new javax.swing.JRadioButton();
        studentadmissionfee = new javax.swing.JRadioButton();
        studentperiodicfee = new javax.swing.JRadioButton();
        classperiodicfee = new javax.swing.JRadioButton();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jButton8 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        confirmmsg = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        chequeddnumber = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        bankdetail = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        amt = new javax.swing.JTextField();
        cashCheck = new javax.swing.JRadioButton();
        jLabel24 = new javax.swing.JLabel();
        ddCheck = new javax.swing.JRadioButton();
        chequeCheck = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane15 = new javax.swing.JScrollPane();
        jXTable1 = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Fee Deposit Section");
        setNextFocusableComponent(jPanel2);

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(51, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setNextFocusableComponent(admissionnumber);

        jComboBox1.setForeground(new java.awt.Color(153, 0, 51));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose", "All" }));
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setText("Class");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setText("Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setText("Adm. No.");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        admissionnumber.setForeground(new java.awt.Color(255, 0, 51));
        admissionnumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                admissionnumberFocusGained(evt);
            }
        });
        admissionnumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                admissionnumberKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                admissionnumberKeyTyped(evt);
            }
        });

        cmbMonth.setForeground(new java.awt.Color(0, 0, 204));
        cmbMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December", "Quarterly", "Half-Yearly", "Yearly" }));
        cmbMonth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbMonthMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmbMonthMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cmbMonthMousePressed(evt);
            }
        });
        cmbMonth.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                cmbMonthMouseDragged(evt);
            }
        });
        cmbMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMonthItemStateChanged(evt);
            }
        });
        cmbMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMonthActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel13.setText("Month");

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton10.setForeground(new java.awt.Color(0, 0, 255));
        jButton10.setText("Load Fee");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        classmonthlyfee.setBackground(new java.awt.Color(51, 204, 255));
        classmonthlyfee.setFont(new java.awt.Font("Tahoma", 1, 12));
        classmonthlyfee.setText("Class");

        studentmonthlyfee.setBackground(new java.awt.Color(51, 204, 255));
        studentmonthlyfee.setFont(new java.awt.Font("Tahoma", 1, 12));
        studentmonthlyfee.setText("Student");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sibling" }));
        jComboBox3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox3MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jComboBox3MousePressed(evt);
            }
        });
        jComboBox3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jComboBox3MouseDragged(evt);
            }
        });
        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox3ItemStateChanged(evt);
            }
        });
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                        .addGap(9, 9, 9)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(classmonthlyfee, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(studentmonthlyfee)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10)
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                .addGap(6, 6, 6))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(admissionnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox3, 0, 91, Short.MAX_VALUE))
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(admissionnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cmbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10)
                    .addComponent(classmonthlyfee)
                    .addComponent(studentmonthlyfee))
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Adm. No.", "Session", "Fee Head", "Amt. Dues", "Month", "Paid"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel5.setText("Total Dues");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel6.setText("Collected");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel7.setText("Remaining");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel8.setText("Surplus");

        totaldues.setEditable(false);

        collected.setEditable(false);

        remaining.setEditable(false);

        totalsurplus.setEditable(false);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton4.setForeground(new java.awt.Color(0, 0, 255));
        jButton4.setText("Use Surplus");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        usedsurplustext.setEditable(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel16.setText("Used Surplus");

        mini.setBackground(new java.awt.Color(0, 153, 255));
        mini.setFont(new java.awt.Font("Tahoma", 1, 12));
        mini.setText("Mini");
        mini.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(mini)
                        .addGap(31, 31, 31)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usedsurplustext, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totaldues, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(remaining, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(totalsurplus)
                            .addComponent(collected, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(totaldues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(collected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(totalsurplus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(remaining, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jLabel16)
                    .addComponent(usedsurplustext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mini))
                .addGap(117, 117, 117))
        );

        jPanel4.setBackground(new java.awt.Color(0, 153, 255));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton3.setForeground(new java.awt.Color(0, 0, 255));
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton17.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton17.setForeground(new java.awt.Color(0, 0, 255));
        jButton17.setText("Pay");
        jButton17.setNextFocusableComponent(jButton3);
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jButton17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton17KeyPressed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 255));
        jButton1.setText("F.Pay");
        jButton1.setNextFocusableComponent(jButton17);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton18.setForeground(new java.awt.Color(0, 0, 255));
        jButton18.setText("Manual Pay ");
        jButton18.setNextFocusableComponent(jButton3);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jButton18.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton18KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton18, 0, 0, Short.MAX_VALUE)
                    .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton17)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton18)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        jTextPane3.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane3.setEditable(false);
        jTextPane3.setFont(new java.awt.Font("Tahoma", 1, 24));
        jTextPane3.setForeground(new java.awt.Color(51, 0, 255));
        jTextPane3.setText("                                                           Pay Your Fee");
        jScrollPane4.setViewportView(jTextPane3);

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));

        jButton12.setFont(new java.awt.Font("Tahoma", 1, 11));
        jButton12.setForeground(new java.awt.Color(0, 0, 255));
        jButton12.setText("Load Fee");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton22.setFont(new java.awt.Font("Tahoma", 1, 11));
        jButton22.setForeground(new java.awt.Color(0, 0, 255));
        jButton22.setText("Load Fee");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        classadmissionfee.setBackground(new java.awt.Color(153, 204, 255));
        classadmissionfee.setFont(new java.awt.Font("Tahoma", 1, 11));
        classadmissionfee.setForeground(new java.awt.Color(0, 0, 255));
        classadmissionfee.setText("Class");

        studentadmissionfee.setBackground(new java.awt.Color(153, 204, 255));
        studentadmissionfee.setFont(new java.awt.Font("Tahoma", 1, 11));
        studentadmissionfee.setForeground(new java.awt.Color(0, 0, 255));
        studentadmissionfee.setText("Student");

        studentperiodicfee.setBackground(new java.awt.Color(153, 204, 255));
        studentperiodicfee.setFont(new java.awt.Font("Tahoma", 1, 11));
        studentperiodicfee.setForeground(new java.awt.Color(0, 0, 255));
        studentperiodicfee.setText("Student");

        classperiodicfee.setBackground(new java.awt.Color(153, 204, 255));
        classperiodicfee.setFont(new java.awt.Font("Tahoma", 1, 11));
        classperiodicfee.setForeground(new java.awt.Color(0, 0, 255));
        classperiodicfee.setText("Class");

        jCheckBox2.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox2.setText("Admission Fee");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox3.setText("Periodic Fee");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox2)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(classadmissionfee)
                        .addGap(7, 7, 7)
                        .addComponent(studentadmissionfee)
                        .addGap(18, 18, 18)
                        .addComponent(jButton12))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(classperiodicfee)
                        .addGap(18, 18, 18)
                        .addComponent(studentperiodicfee)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton22))
                    .addComponent(jCheckBox3))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classadmissionfee)
                    .addComponent(studentadmissionfee)
                    .addComponent(jButton12))
                .addGap(36, 36, 36)
                .addComponent(jCheckBox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classperiodicfee)
                    .addComponent(studentperiodicfee)
                    .addComponent(jButton22))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton8.setForeground(new java.awt.Color(0, 0, 255));
        jButton8.setText("Any Other Fee");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton14.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton14.setForeground(new java.awt.Color(0, 0, 255));
        jButton14.setText("Waiver");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton16.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton16.setForeground(new java.awt.Color(0, 0, 255));
        jButton16.setText("Remove Fee");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton2.setForeground(new java.awt.Color(0, 0, 255));
        jButton2.setText("Statement");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton19.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton19.setForeground(new java.awt.Color(0, 0, 255));
        jButton19.setText("Customize Fee");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton5.setForeground(new java.awt.Color(0, 0, 255));
        jButton5.setText("Adv. Payment");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        confirmmsg.setForeground(new java.awt.Color(51, 255, 51));
        confirmmsg.setText("--------------------------Confirmation----------------------");

        jPanel6.setBackground(new java.awt.Color(153, 102, 255));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel21.setText("Ch. No.");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel23.setText("Bank Detail");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel25.setText("Amt.");

        amt.setText("0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(chequeddnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(amt))
                    .addComponent(bankdetail, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(amt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chequeddnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(bankdetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
        );

        cashCheck.setBackground(new java.awt.Color(0, 102, 204));
        cashCheck.setFont(new java.awt.Font("Tahoma", 1, 12));
        cashCheck.setText("Cash");
        cashCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashCheckActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel24.setText("Pyt. Mode");

        ddCheck.setBackground(new java.awt.Color(0, 102, 204));
        ddCheck.setFont(new java.awt.Font("Tahoma", 1, 12));
        ddCheck.setText("DD");
        ddCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddCheckActionPerformed(evt);
            }
        });

        chequeCheck.setBackground(new java.awt.Color(0, 102, 204));
        chequeCheck.setFont(new java.awt.Font("Tahoma", 1, 12));
        chequeCheck.setText("Cheque");
        chequeCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chequeCheckActionPerformed(evt);
            }
        });

        jTextPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane1.setEditable(false);
        jScrollPane2.setViewportView(jTextPane1);

        jXTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "Adm. No.", "Father Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jXTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXTable1MouseClicked(evt);
            }
        });
        jXTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jXTable1KeyTyped(evt);
            }
        });
        jScrollPane15.setViewportView(jXTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addComponent(cashCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chequeCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(ddCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton16)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton5)))
                    .addComponent(confirmmsg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1022, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1022, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ddCheck)
                                    .addComponent(jLabel24)
                                    .addComponent(chequeCheck)
                                    .addComponent(cashCheck))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton19)
                            .addComponent(jButton5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton16)
                            .addComponent(jButton8)
                            .addComponent(jButton14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(confirmmsg)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
 change=0;
      // TODO add your handling code here:
}//GEN-LAST:event_jComboBox1ActionPerformed

public void studentDetail(ResultSet rs)
{
     int i=0,j=0;
    try{
              while(rs.next())
            {
                j++;

            }
            rs.first();
            rs.previous();
            dm.setRowCount(j);
            while(rs.next())
            {
          dm.setValueAt(rs.getString(1), i, 0);
              
                dm.setValueAt(sessionmap.get(rs.getInt(9)),i,1);
                if(rs.getInt(8)==1)
                dm.setValueAt(admissionfeemap.get(rs.getInt(5)), i, 2);
                if(rs.getInt(8)==0)
                dm.setValueAt(monthlyfeemap.get(rs.getInt(5)), i, 2);
                if(rs.getInt(8)==2)
                dm.setValueAt(periodicfeemap.get(rs.getInt(5)), i, 2);
                dm.setValueAt(rs.getDouble(6), i, 3);
                dm.setValueAt(month.get(rs.getInt(7)), i, 4);
              dm.setValueAt(0.0, i, 5);
              if(rs.getInt(8)==3)
              {
                  mp.getLedgerOtherFeeIndexToName();
                  if(otherfeemap.get(rs.getInt(5)).equals("Inventory Purchase"))
                       dm.setValueAt(invname.get(rs.getInt(10)), i, 2);
                  else
                  dm.setValueAt(otherfeemap.get(rs.getInt(5)), i, 2);


              }
                  i++;

                  confirmmsg.setForeground(Color.GREEN);
                                 confirmmsg.setText("Total Dues loaded");
            }

 collected.setText("");
    //
    }catch(Exception e)
    {
e.printStackTrace();
    }
  sumOfDues();
  loadSurplus();
  //insertIntoSurplus();
}

public void loadBlankFeeTable()
{
    int i=0,j=0;
    try{
            for(i=0;i<dm.getRowCount();i++)
            {


                dm.setValueAt(0, i, 0);
                dm.setValueAt("", i, 1);
                dm.setValueAt("", i, 2);
                dm.setValueAt(0, i, 3);
                dm.setValueAt("", i, 4);
                dm.setValueAt(0, i, 5);
              

            }

 collected.setText("");
    remaining.setText("");
    totaldues.setText("");
    totalsurplus.setText("");
    }catch(Exception e)
    {
e.printStackTrace();
    }
}
public void loadSurplus()
{
      ////con=com.duc.DatabaseConnection.DatabaseConnection.con;
      try
      {
          ps=con.prepareStatement("select * from studentsurplus where studentid=?");
          ps.setString(1,admissionnumber.getText());
          rs=ps.executeQuery();
          rs.next();
           totalsurplus.setText(String.valueOf(rs.getDouble(2)));

  // con.close();
      }catch(Exception e)
      {
          if(rs==null)
              totalsurplus.setText("0.0");

      }
}
public void sumOfDues()
{
    Double totaldues=0.0;
    int rowcount=dm.getRowCount();
    for(int i=0;i<rowcount;i++)
    {
        System.out.println("rd");
        totaldues+=Double.parseDouble(dm.getValueAt(i,3).toString());

    }   this.totaldues.setText(String.valueOf(totaldues));
    remaining.setText(String.valueOf(totaldues));
}
public void sumOfPayments()
{
    Double dues=0.0,totalpayment=0.0,totalremaining=0.0,net=0.0,surplus=0.0,k=0.0;
    int rowcount=dm.getRowCount();
    if(!totalsurplus.getText().isEmpty())
     surplus=Double.valueOf(totalsurplus.getText().toString());
    for(int i=0;i<rowcount;i++)
    {

        totalpayment+=Double.parseDouble(dm.getValueAt(i,5).toString());

    }
collected.setText(String.valueOf(totalpayment));


        for( int i=0;i<rowcount;i++)
    {

      net=Double.parseDouble(dm.getValueAt(i,3).toString())-Double.parseDouble(dm.getValueAt(i,5).toString());
      if(net<0 && Double.parseDouble(dm.getValueAt(i,3).toString())>0)//
      {
         dm.setValueAt(dm.getValueAt(i,3), i, 5);
          surplus+=Math.abs(net);
        //  k+=Math.abs(net);
        //  System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"+k);
        //  surplus1=k;
 //System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"+surplus1);

      }
      if(net>0)
          totalremaining+=Math.abs(net);

        }
surplus1=surplus-Double.valueOf(totalsurplus.getText().toString());
//surplus1=k;
System.out.println("surplus15555555555555555555555555555555555=== "+surplus1);
        totalsurplus.setText(String.valueOf(surplus));
   remaining.setText(String.valueOf(totalremaining));
   //todaySurplus(Math.abs(net));
}

public void todaySurplus(Double todaysurplus)
{
       double surplus=0.0;
            String id;
//con=com.duc.DatabaseConnection.DatabaseConnection.con;
try
{
    ps=con.prepareStatement("select * from studenttodaysurplus where studentid=? and date=?");
    ps.setString(1,admissionnumber.getText());
    ps.setString(2, datum);
    rs=ps.executeQuery();

    if(!rs.next())
    {
        if(todaysurplus>0)
        {

    ps=con.prepareStatement("insert into studenttodaysurplus values(?,?,?)");
    ps.setString(1,admissionnumber.getText());
   //if(chequebutton3.isSelected() || dddButton2.isSelected())
   // ps.setDouble(2,todaysurplus+Double.parseDouble(amt.getText())-Double.parseDouble(collected.getText()));
  // else
    ps.setDouble(2,todaysurplus);

    ps.setString(3, datum);

    ps.executeUpdate();
        }
    } else
    {

        surplus=rs.getDouble(2);
        ps=con.prepareStatement("update studenttodaysurplus set surplus=? where studentid=? and date=?");
    

        ps.setDouble(1,surplus+todaysurplus);
        
        ps.setString(2,admissionnumber.getText());
         ps.setString(3, datum);
        
        ps.executeUpdate();
    }
//con.close();
    }catch(Exception e)
{
    e.printStackTrace();
     System.out.println("ravi");

}
      System.out.println("ravi");


}

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:

         int keycode=evt.getID();
        String id;
        if(keycode==KeyEvent.KEY_TYPED) {
            if(!jTextField1.getText().isEmpty()) {
                id=jTextField1.getText();
                loadAdmissionNoTable(id);
            }
        }
}//GEN-LAST:event_jTextField1KeyTyped

    private void admissionnumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_admissionnumberKeyPressed

        jCheckBox2.setSelected(false);
        classadmissionfee.setVisible(false);
                                            studentadmissionfee.setVisible(false);
                                            jButton12.setVisible(false);

         //                                   jCheckBox1.setSelected(false);
           //                                 jButton20.setVisible(false);
jCheckBox3.setSelected(false);
                                            classperiodicfee.setVisible(false);
                                            studentperiodicfee.setVisible(false);
                                            jButton22.setVisible(false);



        chequeddnumber.setText("");
bankdetail.setText("");
        jButton1.setEnabled(true);
jButton17.setEnabled(true);
jButton18.setEnabled(true);
        jButton3.setEnabled(true);
        click=0;
        cashCheck.setSelected(true);
        if(cashCheck.isSelected()==true)
                            jPanel6.setVisible(false);
        waivestudent=0.0;
        extrawaiver=0.0;
        surplus1=0.0;
        waiverMonth="";
        waiverPaid="";
        waiverDues="";
        waiverhead="";
        usedsurplustext.setText(String.valueOf(0));
       // jCheckBox1.setSelected(false);
        if(!admissionnumber.getText().isEmpty())
            loadBlankFeeTable();
        int keycode=evt.getKeyCode();
        if(keycode==KeyEvent.VK_ENTER) {
            if(!admissionnumber.getText().isEmpty()) {
                 confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
                getStudentName();
                studentDetailOnBasisOfId();
               // int l=matchIdForRelaxedStudent(admissionnumber.getText());
                int r=matchIdForCustomizedStudent(admissionnumber.getText());
               // System.out.println(l);
              flushTemporaryReceiptTable();
              loadSibling();
            }else {
                confirmmsg.setForeground(Color.RED);
                confirmmsg.setText("Admission No. Empty");
               JOptionPane.showConfirmDialog(null,"Admission No. Empty","Admission No. empty",JOptionPane.OK_CANCEL_OPTION);
            }// TODO add your handling code here:
}//GEN-LAST:event_admissionnumberKeyPressed
    }
        private void admissionnumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_admissionnumberKeyTyped
            // TODO add your handling code here:
}//GEN-LAST:event_admissionnumberKeyTyped

        public void loadSibling()
        {
            try
            {
              ps=con.prepareStatement("select sibling1studentid,sibling2studentid from studentfamily where studentid=?");
              ps.setString(1,admissionnumber.getText());
              rs=ps.executeQuery();
              if(rs.next())
              {
                  
                 // jTable2.setVisible(true);
                  if(rs.getString(1).equals("null") && rs.getString(2).equals("null"))
                  {
                      jComboBox3.setVisible(false);
                  }

                  else
                  {
                 //     jComboBox3.removeAllItems();
                     if(jComboBox3.getItemCount()>1)
                      {
                      jComboBox3.removeItemAt(1);
                      jComboBox3.removeItemAt(1);
                     }
                    //  System.out.println("dsfffffffffffffffffffffffffffffff");
                //  dm1.setValueAt(rs.getString(1), 0, 0);
                 // dm1.setValueAt(rs.getString(2),1,0);
                      //jComboBox3.removeAllItems();
                //jComboBox3.addItem("choose");
                  //    }
                      jComboBox3.addItem(rs.getString(1));
                   jComboBox3.addItem(rs.getString(2));
jComboBox3.setVisible(true);
                  System.out.println(rs.getString(1));
              }
              }
              else
              {
               ps=con.prepareStatement("select sibling1studentid,studentid from studentfamily where sibling2studentid=?");
              ps.setString(1,admissionnumber.getText());
              rs=ps.executeQuery();
              if(rs.next())
              {
                   //jComboBox3.removeAllItems();
                 // jTable2.setVisible(true);
                  if(rs.getString(1).equals("null") && rs.getString(2).equals("null"))
                  {
                      jComboBox3.setVisible(false);
                  }

                  else
                  {
                      if(jComboBox3.getItemCount()>1)
                      {
                      jComboBox3.removeItemAt(1);
                      jComboBox3.removeItemAt(1);
                     }
               //       jComboBox3.removeAllItems();
                     //  jComboBox3.addItem("choose");
                    //  System.out.println("dsfffffffffffffffffffffffffffffff");
                //  dm1.setValueAt(rs.getString(1), 0, 0);
                 // dm1.setValueAt(rs.getString(2),1,0);
                      jComboBox3.addItem(rs.getString(1));
                   jComboBox3.addItem(rs.getString(2));
jComboBox3.setVisible(true);
                  System.out.println(rs.getString(1));
              }
              }else
                  {
               ps=con.prepareStatement("select studentid,sibling2studentid from studentfamily where sibling1studentid=?");
              ps.setString(1,admissionnumber.getText());
              rs=ps.executeQuery();
              if(rs.next())
              {
                   //jComboBox3.removeAllItems();
                 // jTable2.setVisible(true);
                  if(rs.getString(1).equals("null") && rs.getString(2).equals("null"))
                  {
                      jComboBox3.setVisible(false);
                  }

                  else
                  {
                      if(jComboBox3.getItemCount()>1)
                      {
                      jComboBox3.removeItemAt(1);
                      jComboBox3.removeItemAt(1);
                     }
                   //   jComboBox3.removeAllItems();
                    //  System.out.println("dsfffffffffffffffffffffffffffffff");
                //  dm1.setValueAt(rs.getString(1), 0, 0);
                 // dm1.setValueAt(rs.getString(2),1,0);
                    //jComboBox3.addItem("choose");
                       jComboBox3.addItem(rs.getString(1));
                   jComboBox3.addItem(rs.getString(2));
jComboBox3.setVisible(true);
                  System.out.println(rs.getString(1));
              }
              }       else
                      jComboBox3.setVisible(false);
                  }
              }
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        public void loadStudentMonthlyFee()
        {
            int monthcount=0;
            int choose=JOptionPane.showConfirmDialog(null,"Click this to load fee for a particular student,whose Fee is not loaded..\nDo you want load Now?","Load Monthly fee",JOptionPane.OK_CANCEL_OPTION);
            if(choose==JOptionPane.OK_OPTION) {
              
                if(cmbMonth.getSelectedItem().equals("choose"))
                {
                    confirmmsg.setForeground(Color.RED);
                confirmmsg.setText("Month Not Set");
                    JOptionPane.showConfirmDialog(null,"Month Not Set","Month Setter",JOptionPane.OK_CANCEL_OPTION);
                     confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");

                }
                    else{
                    if(admissionnumber.getText().isEmpty())
                    {
                        confirmmsg.setForeground(Color.RED);
                confirmmsg.setText("Admission No. Empty");
                        JOptionPane.showConfirmDialog(null,"Admission No. Empty","Admission No.Setter",JOptionPane.OK_CANCEL_OPTION);
                         confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
                    }
                  
                    else {
                        if(cmbMonth.getSelectedItem().equals("Quarterly") || cmbMonth.getSelectedItem().equals("Half-Yearly")|| cmbMonth.getSelectedItem().equals("Yearly")  )
                    {
                        if(cmbMonth.getSelectedItem().equals("Quarterly"))
                            monthcount=3;
                        if(cmbMonth.getSelectedItem().equals("Half-Yearly"))
                            monthcount=6;
                        if(cmbMonth.getSelectedItem().equals("Yearly"))
                            monthcount=12;
                        Format formatter = new SimpleDateFormat("MMMM");
    String monthofadmission = formatter.format(new java.util.Date());

    //System.out.println("ddddddddddd"+Qmonth);
    for(int i=0;i<monthcount;i++)
    { int Qmonth=Integer.parseInt(month1.get(monthofadmission).toString());
        Qmonth=Qmonth+i;
      if(Qmonth>12)

        Qmonth=Qmonth-12;


        loadCustomizedParticularStudentStructure(Qmonth);
                         loadParticularStudentStructure(Qmonth);
                    System.out.println("ravi dangaich");
    }
                     
     if(cmbMonth.getSelectedItem().equals("Quarterly"))
                           JOptionPane.showConfirmDialog(null,"Quaterly Fee Loaded","Quaterly Fee",JOptionPane.OK_CANCEL_OPTION);

                        if(cmbMonth.getSelectedItem().equals("Half-Yearly"))
                           JOptionPane.showConfirmDialog(null,"Half-Yearly Fee Loaded","Half-yearly Fee",JOptionPane.OK_CANCEL_OPTION);

                        if(cmbMonth.getSelectedItem().equals("Yearly"))
                            JOptionPane.showConfirmDialog(null,"Yearly Fee Loaded","Yearly Fee",JOptionPane.OK_CANCEL_OPTION);

                          // confirmmsg.setForeground(Color.GREEN);
               // confirmmsg.setText("--------------------------Confirmation----------------------");
                    }
                        else
                        {
                        if(matchIdForCustomizedStudent(admissionnumber.getText())==1)
                        loadCustomizedParticularStudentStructure(Integer.parseInt(month1.get(cmbMonth.getSelectedItem().toString()).toString()));
                  // else loadParticularStudentStructure();
                     loadParticularStudentStructure(Integer.parseInt(month1.get(cmbMonth.getSelectedItem().toString()).toString()));
                    // TODO add your handling code here:
                    }
                    }
                    }}}
public void loadClassMonthlyFee()
{
    int monthcount=0;
     int choose=JOptionPane.showConfirmDialog(null,"Click this only once in a month to load the fee of whole class.\nDo you want load Now?","Load Monthly fee",JOptionPane.OK_CANCEL_OPTION);
            if(choose==JOptionPane.OK_OPTION) {
                if(jComboBox1.getSelectedItem().equals("choose")) {
                    confirmmsg.setForeground(Color.RED);
                confirmmsg.setText("Class Not Set");
                    JOptionPane.showConfirmDialog(null,"Class Not Set","Class Setter",JOptionPane.OK_CANCEL_OPTION);
                     confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
                } else {
                    if(cmbMonth.getSelectedItem().equals("choose"))
                    {
                        confirmmsg.setForeground(Color.RED);
                confirmmsg.setText("Month Not Set");
                        JOptionPane.showConfirmDialog(null,"Month Not Set","Month Setter",JOptionPane.OK_CANCEL_OPTION);
                         confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
                    }
                    if(cmbMonth.getSelectedItem().equals("Quarterly") || cmbMonth.getSelectedItem().equals("Half-Yearly")|| cmbMonth.getSelectedItem().equals("Yearly")  )
                    {
                        if(cmbMonth.getSelectedItem().equals("Quarterly"))
                            monthcount=3;
                        if(cmbMonth.getSelectedItem().equals("Half-Yearly"))
                            monthcount=6;
                        if(cmbMonth.getSelectedItem().equals("Yearly"))
                            monthcount=12;
                        Format formatter = new SimpleDateFormat("MMMM");
    String monthofadmission = formatter.format(new java.util.Date());

    //System.out.println("ddddddddddd"+Qmonth);
    for(int i=0;i<monthcount;i++)
    { int Qmonth=Integer.parseInt(month1.get(monthofadmission).toString());
        Qmonth=Qmonth+i;
      if(Qmonth>12)

        Qmonth=Qmonth-12;


        loadAllCustomizedStudentOfClass(Qmonth);
                        getMonthlyFeeStructure(Qmonth);
                    System.out.println("ravi dangaich");
    }
                        //confirmmsg.setForeground(Color.RED);
                //confirmmsg.setText("Month Not Set");
                       if(cmbMonth.getSelectedItem().equals("Quarterly"))
                           JOptionPane.showConfirmDialog(null,"Quaterly Fee Loaded","Quaterly Fee",JOptionPane.OK_CANCEL_OPTION);

                        if(cmbMonth.getSelectedItem().equals("Half-Yearly"))
                           JOptionPane.showConfirmDialog(null,"Half-Yearly Fee Loaded","Half-yearly Fee",JOptionPane.OK_CANCEL_OPTION);

                        if(cmbMonth.getSelectedItem().equals("Yearly"))
                            JOptionPane.showConfirmDialog(null,"Yearly Fee Loaded","Yearly Fee",JOptionPane.OK_CANCEL_OPTION);
                        // confirmmsg.setForeground(Color.GREEN);
               // confirmmsg.setText("--------------------------Confirmation----------------------");
                    }
                        else {
                        loadAllCustomizedStudentOfClass(Integer.parseInt(month1.get(cmbMonth.getSelectedItem().toString()).toString()));
                        getMonthlyFeeStructure(Integer.parseInt(month1.get(cmbMonth.getSelectedItem().toString()).toString()));
                    System.out.println("ravi dangaich");

                 
                    }}// TODO add your handling code here:
            }

            // TODO add your handling code here:
}


public void loadAllCustomizedStudentOfClass(int month)
{
  //con=com.duc.DatabaseConnection.DatabaseConnection.con;
            try
            {
                int monthfee1=0,head1=0;

//ps=con.prepareStatement("select * from restrictfeemonthwise");
    //ps.setString(1,admissionnumber.getText());
 //   rs5=ps.executeQuery();



     ps=con.prepareStatement("Select studentid,head,amount,class,ledgercode,feeheadtype,customizationdate from feecustomization left join studententry on studentid=id where class=? and feeheadtype=0");
            ps.setString(1,classmap1.get(jComboBox1.getSelectedItem().toString()).toString());
            // ps.setInt(2,Integer.parseInt(jTextField2.getText()));
            rs1=ps.executeQuery();
            while(rs1.next()) {
              
                head=rs1.getInt(2);
                amount=rs1.getDouble(3);
                ledgercode=rs1.getInt(5);
                ps=con.prepareStatement("select * from restrictfeemonthwise where month=? and feeid=?");
   ps.setInt(1,month);
   ps.setInt(2,head);
    rs5=ps.executeQuery();
  if(!rs5.next()) {
                ps=con.prepareStatement("select * from studententry where id=? and status!=0");
    ps.setString(1,rs1.getString(1));
    rs2=ps.executeQuery();
    while(rs2.next())
    {
    int classroom1=rs2.getInt(9);
    int section=rs2.getInt(10);
    int roll=rs2.getInt(11);
ps=con.prepareStatement("select * from feedues where studentid=? and head=? and month=? and feetype=0 and session=?");
        ps.setString(1, rs1.getString(1));
        ps.setInt(2, head);
        ps.setInt(3,month);
        ps.setInt(4,sessionValue);
        //ps.setInt(4, rs1.getInt(6));
        rs=ps.executeQuery();
        if(!rs.next())
        {
           
             ps=con.prepareStatement("insert into feedues values(?,?,?,?,?,?,?,?,?)");
System.out.println("r7");
    ps.setString(1,rs1.getString(1));
  
    ps.setInt(2,head);
    ps.setDouble(3, amount);
    ps.setInt(4, month);
    ps.setString(5, datum);
     ps.setInt(6,0);
     ps.setInt(7,ledgercode);
     ps.setInt(8,0);
     ps.setInt(9,sessionValue);
  System.out.println("done");
ps.executeUpdate();
System.out.println("done");

        }
        }//con.close();
            
            }
            }
            }catch(Exception e)
            {
e.printStackTrace();
            }
}

public void loadAllCustomizedStudentOfSchool(int month)
{
  //con=com.duc.DatabaseConnection.DatabaseConnection.con;
            try
            {
int monthfee1=0,head1=0;

     ps=con.prepareStatement("select studentid,head,amount,class,ledgercode,feeheadtype,customizationdate from feecustomization left join studententry on studentid=id where feeheadtype=0");
          
            rs1=ps.executeQuery();
            
            while(rs1.next()) {
                 head=rs1.getInt(2);
                amount=rs1.getDouble(3);
                ledgercode=rs1.getInt(5);
               // if(!(month==6 && monthlyfeemap.get(head).equals("Transport Fee")) )  ///it will not dues the transport fee for the month of june
          ps=con.prepareStatement("select * from restrictfeemonthwise where month=? and feeid=?");
   ps.setInt(1,month);
   ps.setInt(2,head);
    rs5=ps.executeQuery();
  if(!rs5.next())
                {
                ps=con.prepareStatement("select * from studententry where id=? and status!=0");
    ps.setString(1,rs1.getString(1));
    rs2=ps.executeQuery();
    while(rs2.next())
    {
    int classroom1=rs2.getInt(9);
    int section=rs2.getInt(10);
    int roll=rs2.getInt(11);
ps=con.prepareStatement("select * from feedues where studentid=? and head=? and month=? and feetype=0 and session=?");
        ps.setString(1, rs1.getString(1));
        ps.setInt(2, head);
        ps.setInt(3,month);
        ps.setInt(4,sessionValue);
        rs=ps.executeQuery();
        if(!rs.next())
        {
            
             ps=con.prepareStatement("insert into feedues values(?,?,?,?,?,?,?,?,?)");
System.out.println("r7");
    ps.setString(1,rs1.getString(1));
   
    ps.setInt(2,head);
    ps.setDouble(3, amount);
    ps.setInt(4, month);
    ps.setString(5, datum);
     ps.setInt(6,0);
     ps.setInt(7,ledgercode);
     ps.setInt(8,0);
     ps.setInt(9,sessionValue);
  System.out.println("done");
ps.executeUpdate();
System.out.println("done");
            }
        }    

 }
          }
            
            }catch(Exception e)
            {
e.printStackTrace();
            }
}

public void loadAllPeriodicCustomizedStudentOfClass(String stdclass,String month,int feehead,Double feeamount,int ledcode)
{
  //con=com.duc.DatabaseConnection.DatabaseConnection.con;
            try
            {

     ps=con.prepareStatement("Select studentid,head,amount,class,ledgercode,feeheadtype,customizationdate from feecustomization left join studententry on studentid=id  where class=? and head=? and feeheadtype=2");
            ps.setInt(1,Integer.parseInt(classmap1.get(stdclass).toString()));
             ps.setInt(2,feehead);
            rs1=ps.executeQuery();
            while(rs1.next())
            {
                 head=Integer.parseInt(periodicfeemap1.get(feehead).toString());
                amount=rs1.getDouble(3);
                ledgercode=ledcode;
                ps=con.prepareStatement("select * from studententry where id=? and status!=0");
    ps.setString(1,rs1.getString(1));
    rs2=ps.executeQuery();
    while(rs2.next())
    {
    String classroom1=rs2.getString(9);
    String section=rs2.getString(10);
    int roll=rs2.getInt(11);
ps=con.prepareStatement("select * from feedues where studentid=? and groupid=0 and head=? and month=? and feetype=? and session=?");
        ps.setString(1, rs1.getString(1));
        ps.setInt(2, head);
        ps.setInt(3,Integer.parseInt(month1.get(month).toString()));
        rs=ps.executeQuery();
        if(!rs.next())
        {
             ps=con.prepareStatement("insert into feedues values(?,?,?,?,?,?,?,?,?)");
System.out.println("r7");
    ps.setString(1,rs1.getString(1));
  
    ps.setInt(2,head);
    ps.setDouble(3, amount);
    ps.setInt(4, Integer.parseInt(month1.get(month).toString()));
    ps.setString(5, datum);
     ps.setInt(6,0);
     ps.setInt(7,ledgercode);
     ps.setInt(8,rs1.getInt(6));
     ps.setInt(9,sessionValue);
  System.out.println("done");
ps.executeUpdate();
System.out.println("done");

        }      //con.close();
            }
            }
            }catch(Exception e)
            {
e.printStackTrace();
            }
}

public void loadAllAnnualPeriodicCustomizedStudentOfClass(String stdclass,String month,int feehead,Double feeamount,int ledcode)
{
  //con=com.duc.DatabaseConnection.DatabaseConnection.con;
            try
            {

     ps=con.prepareStatement("Select studentid,head,amount,class,ledgercode,feeheadtype,customizationdate from feecustomization left join studententry on studentid=id where class=? and head=? and feeheadtype=2");
            ps.setInt(1,Integer.parseInt(classmap1.get(stdclass).toString()));
             ps.setInt(2,feehead);
            rs1=ps.executeQuery();
            while(rs1.next())
            {
                 head=feehead;
                amount=rs1.getDouble(3);
                ledgercode=ledcode;
                ps=con.prepareStatement("select * from studententry where id=? and status!=0");
    ps.setString(1,rs1.getString(1));
    rs2=ps.executeQuery();
    while(rs2.next())
    {
    //String classroom1=rs2.getString(9);
    String section=rs2.getString(10);
    int roll=rs2.getInt(11);
ps=con.prepareStatement("select studentid,class,section,roll,head,dues,month from feedues left join studententry on studentid=id  where class=? and studentid=? and groupid=1 and head=? and feetype=2 and session=?");
ps.setInt(1, Integer.parseInt(classmap1.get(stdclass).toString()));
ps.setString(2, rs1.getString(1));
        ps.setInt(3, head);
         ps.setInt(4,sessionValue);
        //ps.setString(3,month);
        rs=ps.executeQuery();
        if(!rs.next())
        {
             ps=con.prepareStatement("insert into feedues values(?,?,?,?,?,?,?,?,?)");
System.out.println("r7");
    ps.setString(1,rs1.getString(1));
  
    ps.setInt(2,head);
    ps.setDouble(3, amount);
    ps.setInt(4, Integer.parseInt(month1.get(month).toString()));
    ps.setString(5, datum);
     ps.setInt(6,1);
     ps.setInt(7,ledgercode);
     ps.setInt(8,2);
     ps.setInt(9,sessionValue);
  System.out.println("done");
ps.executeUpdate();
System.out.println("tttttttttttttttt");

        }      //con.close();
            }
            }
            }catch(Exception e)
            {
e.printStackTrace();
            }
}
    public void getMonthlyFeeStructure(int month)
    {
          confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
          
        count1=0;
        try {
            int monthfee1=0,head1=0;

            //ps=con.prepareStatement("select * from restrictfeemonthwise");
    //ps.setString(1,admissionnumber.getText());
    //rs5=ps.executeQuery();

            ps=con.prepareStatement("Select * from monthlyfeeamounthead left join monthlyfeehead on feeid=`monthlyfeeamounthead`.head where class=? and status=1");;
            ps.setString(1,classmap1.get(jComboBox1.getSelectedItem().toString()).toString());
            rs=ps.executeQuery();
            while(rs.next()) {
               // feeid=rs.getInt(1);
                head=rs.getInt(1);
                amount=rs.getDouble(2);
                ledgercode=rs.getInt(4);
                ps=con.prepareStatement("select * from restrictfeemonthwise where month=? and feeid=?");
   ps.setInt(1,month);
   ps.setInt(2,head);
    rs5=ps.executeQuery();
  if(!rs5.next()) {
//if(amount!=0.0)
                insertAllStudentStructure(head, amount,ledgercode,month);
                 }
            }
          
        }catch(Exception e) {
            e.printStackTrace();
    }System.out.println("Structure not found"); }

     public void getMonthlyFeeStructureForSchool(int month)
    {
          confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
          
        count1=0;
        int stdclass;
        try {
            int monthfee1=0,head1=0;

//ps=con.prepareStatement("select * from restrictfeemonthwise");
    //ps.setString(1,admissionnumber.getText());
  //  rs5=ps.executeQuery();

            ps=con.prepareStatement("Select * from monthlyfeeamounthead left join monthlyfeehead on feeid=`monthlyfeeamounthead`.head where status=1");
            //ps.setString(1,jComboBox1.getSelectedItem().toString());
            rs=ps.executeQuery();
            while(rs.next()) {
               // feeid=rs.getInt(1);
                head=rs.getInt(1);
                amount=rs.getDouble(2);
                ledgercode=rs.getInt(4);
                stdclass=rs.getInt(3);
                ps=con.prepareStatement("select * from restrictfeemonthwise where month=? and feeid=?");
   ps.setInt(1,month);
   ps.setInt(2,head);
    rs5=ps.executeQuery();
  if(!rs5.next()) {
               // insert(head,amount);
                insertAllStudentMonthlyStructureForSchool(stdclass,head, amount,ledgercode,month);
                 }
            }
           
        }catch(Exception e) {
            e.printStackTrace();
    }System.out.println("Structure not found"); }

    
        private void cmbMonthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbMonthMouseClicked
            // TODO add your handling code here:
}//GEN-LAST:event_cmbMonthMouseClicked

        private void cmbMonthMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbMonthMouseEntered
            // TODO add your handling code here:
}//GEN-LAST:event_cmbMonthMouseEntered

        private void cmbMonthMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbMonthMousePressed
            // TODO add your handling code here:
}//GEN-LAST:event_cmbMonthMousePressed

        private void cmbMonthMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbMonthMouseDragged
            // TODO add your handling code here:
}//GEN-LAST:event_cmbMonthMouseDragged

        private void cmbMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMonthItemStateChanged
            // TODO add your handling code here:
}//GEN-LAST:event_cmbMonthItemStateChanged

        private void cmbMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMonthActionPerformed
            // TODO add your handling code here:
}//GEN-LAST:event_cmbMonthActionPerformed

        private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

            if(jComboBox1.getSelectedItem().toString().equals("All"))
                loadSchoolMonthlyFee();
            else
            {
            if(classmonthlyfee.isSelected()==false && studentmonthlyfee.isSelected()==false)
            {
                JOptionPane.showConfirmDialog(null,"select one radio button","Select Fee Mode",JOptionPane.OK_OPTION);
            }else
            {
            if(classmonthlyfee.isSelected())
                loadClassMonthlyFee();
            else
            loadStudentMonthlyFee();
            }
            }
}//GEN-LAST:event_jButton10ActionPerformed
                    
                    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
                        useSurplus();
                        // TODO add your handling code here:
}//GEN-LAST:event_jButton4ActionPerformed

                    public void lumpSump()
                    {
                        // if(jCheckBox1.isSelected())
                           loadLumpsumpAmount();
                       //else
                           deLoadLumpsumpAmount();
                    }
                    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                       if(click>0)
                       {
                           JOptionPane.showMessageDialog(null,"Fine / Random button remain unpressed");
                           
                       }
                       else
                       {
                         /*  jButton17.setEnabled(false);
                           loadLumpsumpAmount();
                        sumOfPayments();
                        jButton17.setBackground(Color.BLUE);*/
                       //  amt.setText(collected.getText());
                        if(chequeCheck.isSelected() && amt.getText().isEmpty())
                           JOptionPane.showMessageDialog(null,"Fill Cheque Amount","Fill Amount",JOptionPane.PLAIN_MESSAGE);
                        else
                        {
                            if(ddCheck.isSelected() && amt.getText().isEmpty())
                           JOptionPane.showMessageDialog(null,"Fill DD Amount","Fill Amount",JOptionPane.PLAIN_MESSAGE);
                            else
                            {

                              jButton17.setEnabled(false);
                              jButton18.setEnabled(false);
                           loadLumpsumpAmount();
                        sumOfPayments();
                        jButton17.setBackground(Color.BLUE);
                         feeReceipt();
                       }
                        }
                       }
}//GEN-LAST:event_jButton1ActionPerformed

                    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
                    jButton3.setEnabled(false);
                        if(click>0)
                       {
                           JOptionPane.showMessageDialog(null,"Fine / Random button remain unpressed");

                       }
                        else
                        {
                        jButton3.setBackground(Color.LIGHT_GRAY);
                        //jButton18.setBackground(Color.GREEN);
                        insertIntoFeeWaiver(waivestudent,(waivestudent-extrawaiver),sessionValue);
                        insertIntoFeePaid();
                        insertIntoSurplus();
                       
                        todaySurplus(surplus1+extrawaiver+payamount1);
                        // todaySurplus(surplus1+extrawaiver);
                         System.out.println("rrrrddddddddddd==="+surplus1);
                        updateReceiptInfo();
                        flushTemporaryReceiptTable();
                        refreshTableAfterPayment();
                        updateDuesOnPayment();
                      
                        decreaseSurplus(Double.parseDouble(totalsurplus.getText()));
                        decreaseTodaySurplus();
                        usedSurplusDateWise();
                        
                        extrawaiver=0.0;
                        surplus1=0.0;
                        payamount1=0.0;

                        if(chequeCheck.isSelected() )
                            insertChequeDdDescription(1);
                        if(ddCheck.isSelected())
                           insertChequeDdDescription(2);

                       // jButton3.setSelected(false);
                        }
                        smsPaymentOnUpdate();
                        // TODO add your handling code here:
}//GEN-LAST:event_jButton3ActionPerformed

                    public void feeReceipt()
                    {
                        ReceiptPrint();
                        jButton3.setBackground(Color.RED);
                        jButton17.setBackground(Color.LIGHT_GRAY);
                    }
                    public void refresh()
                    {
                           jButton1.setEnabled(true);
jButton17.setEnabled(true);

                        jButton3.setEnabled(true);
                        click=0;
                        //jButton18.setBackground(Color.LIGHT_GRAY);
                        cashCheck.setSelected(true);
                        if(cashCheck.isSelected()==true)
                            jPanel6.setVisible(false);
                        waivestudent=0.0;
                        extrawaiver=0.0;
                        surplus1=0.0;
                        waiverMonth="";
                        waiverPaid="";
                        waiverDues="";
                        waiverhead="";
                        usedsurplustext.setText(String.valueOf(0));
                        if(!admissionnumber.getText().isEmpty()) {

                             confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
                            getStudentName();
                            studentDetailOnBasisOfId();

                            int r=matchIdForCustomizedStudent(admissionnumber.getText());

                        }else
                        {
                            confirmmsg.setForeground(Color.RED);
                confirmmsg.setText("Admission No. Empty");
                            JOptionPane.showConfirmDialog(null,"Admission No. Empty","Admission No. empty",JOptionPane.OK_CANCEL_OPTION);
                             confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
                        }
                         //jCheckBox1.setSelected(false);
                        flushTemporaryReceiptTable();
                    }
                    public void smsPaymentOnUpdate()
                    {
                        try
 {
        ps=con.prepareStatement("select access from smsaccess where module=? ");
    ps.setString(1,"Fee Deposit");
    rs=ps.executeQuery();
    if(rs.next())
    {
    if(rs.getInt(1)==1)
      smsPayment();
    //  else JOptionPane.showConfirmDialog(null,"Add SMS package access from Accessories","Contact Administrator",JOptionPane.OK_OPTION);
    else confirmmsg.setText("Add SMS package");

    }else confirmmsg.setText("Add SMS package");
    //else confirmmsg.setText("Add SMS package");
                        }catch(Exception e)
{
    e.printStackTrace();
}

                    }
                    public void smsPayment()
                    {

             String id=null;
           if(admissionnumber.getText().isEmpty())
          {
               JOptionPane.showConfirmDialog(null,"Mobile no. Field is empty","Mobile Empty",JOptionPane.OK_OPTION);

           }
           else
           {
                 try
                 {
    //  String inputLine;
             ps=con.prepareStatement("select phone from studententry where id=?");
                     ps.setString(1, admissionnumber.getText());
             rs=ps.executeQuery();
             if(rs.next())
             {
                 id=rs.getString(1);
             }
Double payable=Double.parseDouble(collected.getText())-waivestudent;
   String msg="Thanks for paying an amount of Rs"+String.valueOf(payable);
    System.out.println("message"+msg);

    //if(jCheckBox1.isSelected())
     //   id=jTextField2.getText().trim();
    //else
       // System.out.println("ravi"+dm.getValueAt(crow,9));
    String newmsg=msg.replace(" ","%20");
    System.out.println("New message"+newmsg);

 /*  if(dm.getValueAt(crow,9).equals("null"))
      {
          JOptionPane.showConfirmDialog(null,"Mobile no. Field is empty","Mobile Empty",JOptionPane.OK_OPTION);
      }
      else
      {*/
        // id=dm.getValueAt(crow,9).toString().trim();
       //   System.out.println("number"+id);
         if(id.isEmpty())
          {
          JOptionPane.showConfirmDialog(null,"Mobile no. is not valid","Mobile No. Invalid",JOptionPane.OK_OPTION);
      }
      else
      {
          InetAddress thisIp =InetAddress.getLocalHost();
            String ip=thisIp.getHostAddress();
      new com.duc.Accessories.SendSms().SmsCommon(admissionnumber.getText(),id,newmsg,ip);
      }
     // }
    }catch(Exception e)
    {
        JOptionPane.showConfirmDialog(null,"Mobile no. Field is empty","Mobile Empty",JOptionPane.OK_OPTION);

        e.printStackTrace();
    }
         }
         }
public void loadSchoolMonthlyFee()
{
    //String select=jComboBox3.getSelectedItem().toString();
    int monthcount=0;
  
     int choose=JOptionPane.showConfirmDialog(null,"Click this to load the fee of whole institute monthly/Quarterly/Half-yearly \nDo you want load Now?","Load Monthly fee",JOptionPane.OK_CANCEL_OPTION);
            if(choose==JOptionPane.OK_OPTION) {
                 
                    if(cmbMonth.getSelectedItem().equals("choose"))
                    {
                        confirmmsg.setForeground(Color.RED);
                confirmmsg.setText("Month Not Set");
                        JOptionPane.showConfirmDialog(null,"Month Not Set","Month Setter",JOptionPane.OK_CANCEL_OPTION);
                         confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
                    }
                    if(cmbMonth.getSelectedItem().equals("Quarterly") || cmbMonth.getSelectedItem().equals("Half-Yearly")|| cmbMonth.getSelectedItem().equals("Yearly")  )
                    {
                        if(cmbMonth.getSelectedItem().equals("Quarterly"))
                            monthcount=3;
                        if(cmbMonth.getSelectedItem().equals("Half-Yearly"))
                            monthcount=6;
                        if(cmbMonth.getSelectedItem().equals("Yearly"))
                            monthcount=12;
                        Format formatter = new SimpleDateFormat("MMMM");
    String monthofadmission = formatter.format(new java.util.Date());
    
    //System.out.println("ddddddddddd"+Qmonth);
    for(int i=0;i<monthcount;i++)
    { int Qmonth=Integer.parseInt(month1.get(monthofadmission).toString());
        Qmonth=Qmonth+i;
      if(Qmonth>12)
            
        Qmonth=Qmonth-12;
      

        loadAllCustomizedStudentOfSchool(Qmonth);
                        getMonthlyFeeStructureForSchool(Qmonth);
                    System.out.println("ravi dangaich");
    }
                       
                       if(cmbMonth.getSelectedItem().equals("Quarterly"))
                           JOptionPane.showConfirmDialog(null,"Quaterly Fee Loaded","Quaterly Fee",JOptionPane.OK_CANCEL_OPTION);

                        if(cmbMonth.getSelectedItem().equals("Half-Yearly"))
                           JOptionPane.showConfirmDialog(null,"Half-Yearly Fee Loaded","Half-yearly Fee",JOptionPane.OK_CANCEL_OPTION);

                        if(cmbMonth.getSelectedItem().equals("Yearly"))
                            JOptionPane.showConfirmDialog(null,"Yearly Fee Loaded","Yearly Fee",JOptionPane.OK_CANCEL_OPTION);
                       // confirmmsg.setForeground(Color.GREEN);
               // confirmmsg.setText("--------------------------Confirmation----------------------");
                    }
                        else {
                        loadAllCustomizedStudentOfSchool(Integer.parseInt(month1.get(cmbMonth.getSelectedItem().toString()).toString()));
                        getMonthlyFeeStructureForSchool(Integer.parseInt(month1.get(cmbMonth.getSelectedItem().toString()).toString()));
                    System.out.println("ravi dangaich");

                  }}// TODO add your handling code here:
            }

 public void fromSession()
    {
         try
       {
           ps = con.prepareStatement("select sessiontitle,sessionid,status from sessionsetup ");

           rs = ps.executeQuery();
           // int i = 0,j=0;
          while(rs.next())
            {
                
              if(rs.getInt(3)==1)
                  sessionValue=rs.getInt(2);

            }



         }
         catch(Exception e)
         {
             e.printStackTrace();
    }



    }
public void insertChequeDdDescription(int mode)
{
     //con=com.duc.DatabaseConnection.DatabaseConnection.con;
     try
     {
         ps=con.prepareStatement("insert into paymentmode(studentid,mode,chequeddno,bankname,amount,date,session,clear) values(?,?,?,?,?,?,?,?)");
         ps.setString(1,admissionnumber.getText());
         ps.setInt(2,mode);
         ps.setInt(3,Integer.parseInt(chequeddnumber.getText()));
         ps.setString(4,bankdetail.getText());
         ps.setDouble(5,Double.parseDouble(amt.getText()));
         ps.setString(6, datum);
         ps.setInt(7,sessionValue);
ps.setInt(8,0);
         ps.executeUpdate();


     }catch(Exception e)
     {
         e.printStackTrace();
     }
}



public void updateReceiptInfo()
{
try
{
        fillTemporaryReceiptTable();

          //con=com.duc.DatabaseConnection.DatabaseConnection.con;
          ps=con.prepareStatement("insert into receiptnumber (studentid,date,month,receipt,surplus,waiver,session,newsurplus,surplusused,waiverreason) values(?,?,?,?,?,?,?,?,?,?)");
          ps.setString(1, admissionnumber.getText());
          ps.setString(2,datum);
          ps.setString(3,s);
          ps.setInt(4,receipt_no);
          ps.setDouble(5,surplus);
          ps.setDouble(6, waivestudent);
          ps.setDouble(7,sessionValue);
          ps.setDouble(8, surplus1+extrawaiver+payamount1);
          ps.setDouble(9, Double.parseDouble(usedsurplustext.getText()));
          ps.setString(10, reason);
          ps.executeUpdate();

          ps=con.prepareStatement("select head,SUM(dues) as total_dues,SUM(paid) as total_paid,SUM(remaining) as total_left,groupid from temporarytableforreceipt group by head,groupid");
          rs = ps.executeQuery();
          int feetype=0,feehead=0,group_id=0;
          while(rs.next())
                {
              group_id=0;
                 try
                 {
                  System.out.println("First Step AAAA");
                  feetype=mp.getFeeTypeFromHead(rs.getString(1));
                  //System.out.println("BBB");
                  if(feetype==-1)
                  {
                    try
                    {
                    feetype=3;
                    feehead=mp.getFeeHeadIndexFromFeeTypeAndFeeHead(feetype,"Inventory Purchase");
                    group_id=Integer.parseInt(invname1.get(rs.getString(1)).toString());
                    }
                    catch(Exception e)
                    {

                    }
                  }
                  else
                  feehead=mp.getFeeHeadIndexFromFeeTypeAndFeeHead(feetype,rs.getString(1));
                  System.out.println("Feetype= "+feetype+" Feehead= "+feehead);
                  System.out.println("Head: "+rs.getString(1)+" Index: "+feehead+" Type: "+feetype);
                 }
                 catch(Exception e)
                 {
                  System.out.println("Error occured...."+e);
                  e.printStackTrace();
                 }
                    ps=con.prepareStatement("insert into payreceiptinfo (receiptnumber,feetype,feehead,totaldues,totalpaid,totalremaining,session,groupid) values(?,?,?,?,?,?,?,?)");
                    ps.setInt(1, receipt_no);
                    ps.setInt(2,feetype);
                    ps.setInt(3,feehead);
                    ps.setDouble(4, rs.getDouble(2));
                    ps.setDouble(5, rs.getDouble(3));
                    ps.setDouble(6, rs.getDouble(4));
                    ps.setDouble(7,sessionValue);
                    ps.setInt(8,group_id);
                    ps.executeUpdate();
                }
          //con.close();
}
catch(Exception e)
{
   System.err.println("Error in updating payreceiptinfo "+e);
   e.printStackTrace();
}

}

public void fillTemporaryReceiptTable()
{
  if (admissionnumber.getText().equals(""))
    {
       System.out.println("No Admission Number Selected");
       return;
    }

    if(collected.getText().isEmpty())
    {
       confirmmsg.setForeground(Color.RED);
                confirmmsg.setText("No Payment is made !");
        JOptionPane.showMessageDialog(null, " No Payment is made !");
         confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
         return;
    }

    try
    {
        if(Double.parseDouble(collected.getText())<=0.0)
    {
             confirmmsg.setForeground(Color.RED);
                confirmmsg.setText("No Payment is made !");
         JOptionPane.showMessageDialog(null, " No Payment is made !");
          confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
         return;
    }
    }
    catch(Exception e)
    {
         System.err.println("Error in Receipt print");
    }




   try {


         /* put entries in hash map and check whether any payment has made or not */

         ps=con.prepareStatement("select * from temporarytableforreceipt");
         rs=ps.executeQuery();
         if(rs.next())
         {
          System.out.println("<<<<<<Found data in temporary table for receipt >>>>>>>>>>");
          return;
         }


         int c=dm.getRowCount();
         int group_id=0;
         for(int z=0;z<c;z++)
         {
             ps=con.prepareStatement("insert into temporarytableforreceipt (head,dues,paid,remaining,month,groupid) values(?,?,?,?,?,?)");
             ps.setString(1,String.valueOf(dm.getValueAt(z, 2)) );
             ps.setDouble(2,Double.parseDouble(String.valueOf(dm.getValueAt(z, 3))));
             ps.setDouble(3,Double.parseDouble(String.valueOf(dm.getValueAt(z, 5))));
             Double temp=Double.parseDouble(String.valueOf(dm.getValueAt(z, 3))) -Double.parseDouble(String.valueOf(dm.getValueAt(z, 5)));
             if(temp<0.0)
             temp=0.0;
             ps.setDouble(4,temp );
             ps.setInt(5,Integer.parseInt(String.valueOf(month1.get(dm.getValueAt(z,4)))) );

             try
             {
              group_id=Integer.parseInt(invname1.get(String.valueOf(dm.getValueAt(z, 2))).toString());
             }
             catch(Exception e)
             {
             group_id=0;
             }
             System.out.println("group id is "+group_id);            
             ps.setInt(6,group_id);             
             ps.executeUpdate();
             System.out.println("Data inserted in temporary table (Direct Update)");
         }



         ps=con.prepareStatement("Select distinct month from temporarytableforreceipt order by month");
         rs = ps.executeQuery();
         s =null;

         if(!rs.next())
         {
           System.out.println("No Payments made");
           return ;
         }

         rs.previous();
         while(rs.next())
         {
             if (s==null)
              s=String.valueOf(month.get(rs.getInt(1)));
             else
             s=s+" & "+String.valueOf(month.get(rs.getInt(1)));
         }

          receipt_no=0;
          surplus=Double.parseDouble(totalsurplus.getText());
          ps=con.prepareStatement("select Max(receipt) from receiptnumber where session=?" );
          ps.setInt(1, sessionValue);
          rs=ps.executeQuery();
          
          if(rs.next())
          receipt_no=rs.getInt(1)+1;
          else
          receipt_no=1;

               //con.close();
            }
               catch (Exception ex)
            {
               Logger.getLogger(FeeCounter1.class.getName()).log(Level.SEVERE, null, ex);
               System.err.println("Error Occured ......"+ex);
               //JOptionPane.showMessageDialog(null, " Choose Admission Number First!");
            }
}

public void ReceiptPrint()
{
System.out.println("Inside receipt print");

    /*Firstly check whether admission number is entered or not */
    if (admissionnumber.getText().equals(""))
    {
       System.out.println("No Admission Number Selected");
       return;
    }

    if(collected.getText().isEmpty())
    {
         confirmmsg.setForeground(Color.RED);
        confirmmsg.setText("No Payment is made !");
       JOptionPane.showMessageDialog(null, " No Payment is made !");
        confirmmsg.setForeground(Color.GREEN);
        confirmmsg.setText("--------------------------Confirmation----------------------");
         return;
    }

    try
    {
        if(Double.parseDouble(collected.getText())<=0.0)
    {
             confirmmsg.setForeground(Color.RED);
                confirmmsg.setText("No Payment is made !");
         JOptionPane.showMessageDialog(null, " No Payment is made !");
          confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
         return;
    }
    }
    catch(Exception e)
    {
         System.err.println("Error in Receipt print");
         return;
    }

   try {
          flushTemporaryReceiptTable();
          //con=com.duc.DatabaseConnection.DatabaseConnection.con;

         /* put entries in hash map and check whether any payment has made or not */
         //System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
         HashMap map = new HashMap();
         int c=dm.getRowCount();
         int gid=0;
         for(int z=0;z<c;z++)
         {
             ps=con.prepareStatement("insert into temporarytableforreceipt (head,dues,paid,remaining,month,groupid) values(?,?,?,?,?,?)");
             ps.setString(1,String.valueOf(dm.getValueAt(z, 2)));
             ps.setDouble(2,Double.parseDouble(String.valueOf(dm.getValueAt(z, 3))));
             ps.setDouble(3,Double.parseDouble(String.valueOf(dm.getValueAt(z, 5))));
             Double temp=Double.parseDouble(String.valueOf(dm.getValueAt(z, 3))) -Double.parseDouble(String.valueOf(dm.getValueAt(z, 5)));
             if(temp<0.0)
             temp=0.0;
             ps.setDouble(4,temp);
             ps.setInt(5,Integer.parseInt(String.valueOf(month1.get(dm.getValueAt(z,4)))));
             System.out.println("Checking for the group id");

             try
             {
              gid=Integer.parseInt(invname1.get(String.valueOf(dm.getValueAt(z, 2))).toString());
             }
             catch(Exception e)
             {
               gid=0;
             }             

             System.out.println("Group id is "+ gid);
             
             ps.setInt(6, gid);
             ps.executeUpdate();
             System.out.println("Pay Receipt Option ....Data inserted in temporary table");
         }



         ps=con.prepareStatement("Select distinct month from temporarytableforreceipt order by month");
         rs = ps.executeQuery();
         s =null;

         if(!rs.next())
         {
           System.out.println("No Payments made");
           return ;
         }

         rs.previous();
         while(rs.next())
         {
             if (s==null)
              s=String.valueOf(month.get(rs.getInt(1))).substring(0,3);
             else
             s=s+" & "+String.valueOf(month.get(rs.getInt(1))).substring(0,3);
         }

          ps=con.prepareStatement("select institutename, instituteaddress from instituteregistration" );
          rs = ps.executeQuery();
          rs.next();
          map.put("schoolname",rs.getString(1));
          map.put("schooladdress",rs.getString(2));

          BufferedImage bimg = null;
         try
          {
            bimg = ImageIO.read(new File("images/logo.jpg"));
          }
        catch (Exception ex)
        {
            System.out.println("Error in ...."+ex);
        }
        map.put("logo",bimg);


          //System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
          ps=con.prepareStatement("select id,name,class,section,roll,fathername from studententry where id=?" );
          ps.setString(1, admissionnumber.getText());
          rs = ps.executeQuery();
          rs.next();
          map.put("id",rs.getString(1));
          map.put("name",rs.getString(2));
          map.put("class",classmap.get(rs.getInt(3)));
          map.put("section",sectionmap.get(rs.getInt(4)));
          map.put("roll",rs.getString(5));
          map.put("father",rs.getString(6));
          map.put("month",s);
          map.put("presurplus",Double.parseDouble(usedsurplustext.getText()));

          String mode_sel="";
          
          if(cashCheck.isSelected())
          mode_sel="Cash";
          else if(chequeCheck.isSelected())
          mode_sel="Cheque"+", No. "+ chequeddnumber.getText();
          else if(ddCheck.isSelected())
          mode_sel="DD"+", No. "+ chequeddnumber.getText();


          map.put("paymode",mode_sel);
          /* generate a receipt number*/
         System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

          surplus=Double.parseDouble(totalsurplus.getText());
          map.put("surplus",surplus);
          map.put("waiver",waivestudent);
          System.out.println("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
          map.put("reason",reason);
          System.out.println("lklklklklklklkl");
          
          ps=con.prepareStatement("select sessiontitle from sessionsetup where status=1");          
          rs=ps.executeQuery();
          if(rs.next())
          map.put("session",rs.getString(1));
          else
          map.put("session","");

          /*select the receipt number*/

          ps=con.prepareStatement("select Max(receipt) from receiptnumber where session=?" );
          ps.setInt(1, sessionValue);
          rs=ps.executeQuery();

          receipt_no=0;
          if(rs.next())
          receipt_no=rs.getInt(1)+1;
          else
          receipt_no=1;
          map.put("receipt",receipt_no);

          System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");

          /*Query for the jasper report */
          ps=con.prepareStatement("select head,SUM(dues) as total_dues,SUM(paid) as total_paid,SUM(remaining) as total_left from temporarytableforreceipt group by head");
          rs = ps.executeQuery();

            if(!rs.next())
            {
                 confirmmsg.setForeground(Color.RED);
                confirmmsg.setText("No Payment is made !");
                JOptionPane.showMessageDialog(null, " No Payment is made !");
                 confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
                return;
            }
                rs.previous();

                /* insert receipt full information*/


                /* Printing jasper report*/
                JRResultSetDataSource src = new JRResultSetDataSource(rs);
                JasperReport js=null;
                if(mini.isSelected())
                js = JasperCompileManager.compileReport("reports/fee/mini_pay_receipt.jrxml");
                else
                js = JasperCompileManager.compileReport("reports/fee/pay_receipt.jrxml");
                JasperPrint pr = JasperFillManager.fillReport(js, map,src);
                JasperViewer jv = new JasperViewer(pr, false);
                jv.setTitle("Student Payment Receipt");
                jv.setVisible(true);
                //con.close();
            }
               catch (Exception ex)
            {
               Logger.getLogger(FeeCounter1.class.getName()).log(Level.SEVERE, null, ex);
               System.err.println("Error Occured ......"+ex);
               //JOptionPane.showMessageDialog(null, " Choose Admission Number First!");
            }
}



public void loadClassAdmissionFee()
          {
                  int choose=JOptionPane.showConfirmDialog(null,"Click this only once to load the admissionfee of whole class.\nDo you want load Now?","Load Admission fee",JOptionPane.OK_CANCEL_OPTION);
                        if(choose==JOptionPane.OK_OPTION) {
                            if(jComboBox1.getSelectedItem().equals("choose")) {
                                 confirmmsg.setForeground(Color.RED);
                confirmmsg.setText("Class Not Set!");
                                JOptionPane.showConfirmDialog(null,"Class Not Set","Class Setter",JOptionPane.OK_CANCEL_OPTION);
                                  confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");

                            }else {
                                if(cmbMonth.getSelectedItem().equals("choose") || cmbMonth.getSelectedItem().equals("Quarterly") || cmbMonth.getSelectedItem().equals("Half-Yearly") || cmbMonth.getSelectedItem().equals("Yearly"))
                                {
                                   confirmmsg.setForeground(Color.RED);
                confirmmsg.setText("Month Not Set!");
                                    JOptionPane.showConfirmDialog(null,"Month Not Set","Month Setter",JOptionPane.OK_CANCEL_OPTION);
                                     confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
                                }
                                else getAdmissionFeeStructure();
                            }  }         // TODO add your handling code here:
          }

 public void getAdmissionFeeStructure()
{
     confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
    //con=com.duc.DatabaseConnection.DatabaseConnection.con;
       // int feeid;
        try {
            ps=con.prepareStatement("select * from admissionfeeamounthead left join admissionfeehead on feeid=`admissionfeeamounthead`.head where class=? and status=1");
            ps.setString(1,classmap1.get(jComboBox1.getSelectedItem().toString()).toString());
            rs=ps.executeQuery();
            count1=0;
            while(rs.next()) {
               // feeid=rs.getInt(1);
                head=rs.getInt(1);
                amount=rs.getDouble(2);
                ledgercode=rs.getInt(4);
                insertAdmissionDues(head,amount,ledgercode);
            }
        
        }catch(Exception e) {
            e.printStackTrace();
    }System.out.println("Structure not found");
}


public void loadCustomizedParticularStudentStructure(int month)
{
     //con=com.duc.DatabaseConnection.DatabaseConnection.con;
            try
            {
                int monthfee1=0,head1=0;
/*
ps=con.prepareStatement("select * from restrictfeemonthwise where month=?");
   ps.setInt(1,month);
    rs5=ps.executeQuery();

*/

                  ps=con.prepareStatement("select * from studententry where id=? and status!=0");
    ps.setString(1,admissionnumber.getText());
    rs=ps.executeQuery();
   while(rs.next())
   {
    int studentclass=rs.getInt(9);

     ps=con.prepareStatement("Select studentid,head,amount,class,ledgercode,feeheadtype,customizationdate from feecustomization left join studententry on studentid=id where class=? and studentid=? and feeheadtype=0");
            ps.setInt(1,studentclass);
             ps.setString(2,admissionnumber.getText());
            rs=ps.executeQuery();
            count=0;
            while(rs.next()) {
               // feeid=rs.getInt(1);
                head=rs.getInt(2);
                amount=rs.getDouble(3);
                ledgercode=rs.getInt(5);
               // while(rs5.next())
                ps=con.prepareStatement("select * from restrictfeemonthwise where month=? and feeid=?");
   ps.setInt(1,month);
   ps.setInt(2,head);
    rs5=ps.executeQuery();
  if(!rs5.next()) {
//if(amount!=0.0)
                insertParticularStudentMonthlyStructure(head,amount,ledgercode,month);
                 }
               

            }
             confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("Customized fee loaded!");
           // JOptionPane.showConfirmDialog(null,"Customized fee loaded","Customize Loaded",JOptionPane.OK_OPTION);
   }  }catch(Exception e)
            {
e.printStackTrace();
JOptionPane.showConfirmDialog(null,"Invalid Admission No.","Invalid",JOptionPane.OK_OPTION);
 confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
            }

}

public void refreshTableAfterPayment()
{
    int i=0;Double dues,payment,netvalue;

            for(i=0;i<dm.getRowCount();i++)
            {
dues=Double.parseDouble(dm.getValueAt(i,3).toString());
payment=Double.parseDouble(dm.getValueAt(i,5).toString());
netvalue=dues-payment;
if(netvalue>0)
                dm.setValueAt(netvalue, i, 3);
else
    dm.setValueAt(0, i, 3);



            }
    System.out.println("rrrrrrrrrr");
}

public void insertAdmissionDues(int head,Double amount,int ledgercode)
{
  try
          {
                 ps=con.prepareStatement("select * from studententry where class=? and status!=0");
                 ps.setString(1, classmap1.get(jComboBox1.getSelectedItem().toString()).toString());

        rs1=ps.executeQuery();

while(rs1.next())
{

    ps=con.prepareStatement("select studentid,class,section,roll,head,dues,month from feedues left join studententry on studentid=id  where  class=? and groupid=1 and studentid=? and head=? and feetype=1 and session=?");

        //ps.setString(1, jCmboBox3.getSelectedItem().toString());
        ps.setString(1, classmap1.get(jComboBox1.getSelectedItem().toString()).toString());
         ps.setString(2, rs1.getString(1));
         ps.setInt(3, head);
          ps.setInt(4,sessionValue);
 System.out.println("r1");
        rs2=ps.executeQuery();
        if(!rs2.next())
        {

                ps=con.prepareStatement("insert into feedues values(?,?,?,?,?,?,?,?,?)");
System.out.println("r7");
    ps.setString(1,rs1.getString(1));
  
    ps.setInt(2,head);
    ps.setDouble(3, amount);
    ps.setInt(4, Integer.parseInt(month1.get(cmbMonth.getSelectedItem().toString()).toString()));
    ps.setString(5, datum);
     ps.setInt(6,1);
     ps.setInt(7,ledgercode);
     ps.setInt(8,1);
     ps.setInt(9,sessionValue);
  System.out.println("done");
ps.executeUpdate();
System.out.println("done");

confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("Class Admission Fee loaded!");
//con.close();
}
          }

          }catch(Exception e)
            {
e.printStackTrace();
            }
           
}

public void insertPeriodicAnnualDues(String stdclass,String month,int head,Double amount,int ledgercode)
{
  try
          {
                 ps=con.prepareStatement("select * from studententry where class=? and status!=0");

                 ps.setInt(1, Integer.parseInt(classmap1.get(stdclass).toString()));

        rs1=ps.executeQuery();

while(rs1.next())
{

    ps=con.prepareStatement("select studentid,class,section,roll,head,dues,month from feedues left join studententry on studentid=id  where  class=? and groupid=1 and studentid=? and head=? and feetype=2 and session=?");

        //ps.setString(1, jComboBox3.getSelectedItem().toString());
        ps.setInt(1, Integer.parseInt(classmap1.get(stdclass).toString()));
         ps.setString(2, rs1.getString(1));
         ps.setInt(3, head);
         ps.setInt(4,sessionValue);
 System.out.println("r1");
        rs2=ps.executeQuery();
        if(!rs2.next())
        {

                ps=con.prepareStatement("insert into feedues values(?,?,?,?,?,?,?,?,?)");
System.out.println("r7");
    ps.setString(1,rs1.getString(1));
   
    ps.setInt(2,head);
    ps.setDouble(3, amount);
    ps.setInt(4, Integer.parseInt(month1.get(month).toString()));
    ps.setString(5, datum);
     ps.setInt(6,1);
     ps.setInt(7,ledgercode);
     ps.setInt(8,2);
     ps.setInt(9,sessionValue);
  System.out.println("done");
ps.executeUpdate();
System.out.println("gggggggggggg");
//con.close();
}
          }

          }catch(Exception e)
            {
e.printStackTrace();
            }

}
                    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
                  if(classadmissionfee.isSelected()==false && studentadmissionfee.isSelected()==false)
            {
                JOptionPane.showConfirmDialog(null,"select one radio button","Select Fee Mode",JOptionPane.OK_OPTION);
            }else
            {
            if(classadmissionfee.isSelected())
                loadClassAdmissionFee();
            else
            loadStudentAdmissionFee();
            }
}//GEN-LAST:event_jButton12ActionPerformed
                            
                                private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
                                  
                                     if(cmbMonth.getSelectedItem().toString().equals("Quarterly"))
                                      return;
                                      if(cmbMonth.getSelectedItem().toString().equals("Half-Yearly"))
                                          return;
                                          if(cmbMonth.getSelectedItem().toString().equals("Yearly"))
                                              return;
                                    // if(dm.getValueAt(head, count))
                                    payRandom();
                                    // TODO add your handling code here:
}//GEN-LAST:event_jButton8ActionPerformed


                                public void payRandom()
                                {
                                      click++;
                                    if(click==1) {
                                        if(admissionnumber.getText().isEmpty()) {
                                             confirmmsg.setForeground(Color.RED);
                confirmmsg.setText("Admission No. Empty!");
                                            JOptionPane.showConfirmDialog(null,"Admission No. Empty","Admission No. empty",JOptionPane.OK_CANCEL_OPTION);
                                             confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
                                            click=0;
                                        } else {
                                            if(cmbMonth.getSelectedItem().toString().equals("choose")) {
                                                 confirmmsg.setForeground(Color.RED);
                                 confirmmsg.setText("Month not set!");
                                                JOptionPane.showConfirmDialog(null,"Month not set","month setter",JOptionPane.OK_CANCEL_OPTION);
                                                 confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
                                                click=0;  } else { //studentDetailOnBasisOfId();
                                                insertLastRow();
                                                confirmmsg.setForeground(Color.RED);
                                 confirmmsg.setText("Press Random Button Again!");
                                                JOptionPane.showConfirmDialog(null,"press again after setting the values","Alarm",JOptionPane.OK_OPTION);
                                               //  confirmmsg.setForeground(Color.GREEN);
               // confirmmsg.setText("--------------------------Confirmation----------------------");
                                                jButton8.setBackground(Color.RED);
                                                }
                                        }
                                    }

                                    if(click>1) {
                                        // insertIntoRelaxation();

                                        insertCustomizeFee();
confirmmsg.setForeground(Color.GREEN);
                                 confirmmsg.setText("Random Fee Dues Credited..Press Refresh");
                                        jButton8.setBackground(Color.lightGray);
                                        click=0;}
                                }

public void loadStudentAdmissionFee()
                                {
                                     int choose=JOptionPane.showConfirmDialog(null,"Click this to load admission fee for a particular student..\nDo you want load Now?","Load Monthly fee",JOptionPane.OK_CANCEL_OPTION);
                        if(choose==JOptionPane.OK_OPTION) {

                            if(cmbMonth.getSelectedItem().equals("choose") || cmbMonth.getSelectedItem().equals("Quarterly") || cmbMonth.getSelectedItem().equals("Half-Yearly") || cmbMonth.getSelectedItem().equals("Yearly"))
                                {
                                confirmmsg.setForeground(Color.RED);
                confirmmsg.setText("Month Not Set!");
                                JOptionPane.showConfirmDialog(null,"Month Not Set","Month Setter",JOptionPane.OK_CANCEL_OPTION);
                                 confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
                            }
                            else{
                                if(admissionnumber.getText().isEmpty())
                                {
                                     confirmmsg.setForeground(Color.RED);
                confirmmsg.setText("Admission No. Empty!");
                                    JOptionPane.showConfirmDialog(null,"Admission No. Empty","Admission No.Setter",JOptionPane.OK_CANCEL_OPTION);
                                     confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
                                }
                                else {loadParticularStudentAdmissionStructure();
                                // TODO add your handling code here:
                                }
                            }}}
 public void payFine()
 {
     click++;
  if(click==1)
  {
     if(admissionnumber.getText().isEmpty())
     {
         confirmmsg.setForeground(Color.RED);
                                 confirmmsg.setText("Admission No. Empty!");
     JOptionPane.showConfirmDialog(null,"Admission No. Empty","Admission No. empty",JOptionPane.OK_CANCEL_OPTION);
      confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
     click=0;
     }
    else
    {
        if(cmbMonth.getSelectedItem().toString().equals("choose"))
    {
             confirmmsg.setForeground(Color.RED);
                                 confirmmsg.setText("Month not set!");
        JOptionPane.showConfirmDialog(null,"Month not set","month setter",JOptionPane.OK_CANCEL_OPTION);
         confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
      click=0;  }
        else
{
insertLastRowAsFine();
                                 confirmmsg.setForeground(Color.RED);
                                 confirmmsg.setText("Press Fine Button Again!");
JOptionPane.showConfirmDialog(null,"press again after setting the values","Alarm",JOptionPane.OK_OPTION);
           // jButton13.setBackground(Color.RED);
}
 }
  }
 if(click>1)
 {
insertCustomizeFee();
confirmmsg.setForeground(Color.GREEN);
                                 confirmmsg.setText("Fine Dues Credited..Press Refresh");
//jButton13.setBackground(Color.lightGray);
 click=0;}
 }
 
 public void insertLastRowAsFine()
 {
     //con=com.duc.DatabaseConnection.DatabaseConnection.con;
     try
     {
         ps=con.prepareStatement("select * from studententry where id=?");
         ps.setString(1,admissionnumber.getText());
         rs=ps.executeQuery();
         if(rs.next())
         {
             int rowcount=dm.getRowCount();
     System.out.println("row"+rowcount);
    dm.setRowCount(rowcount+1);
   
    dm.setValueAt(admissionnumber.getText(), rowcount, 0);
    dm.setValueAt(sessionmap.get(sessionValue), rowcount, 1);
  
    dm.setValueAt(cmbMonth.getSelectedItem().toString(), rowcount,4);
    dm.setValueAt("Fine", rowcount,2);
         }else
         {
              confirmmsg.setForeground(Color.RED);
                confirmmsg.setText("Invalid Student!");
             JOptionPane.showConfirmDialog(null,"Invalid Student!","Invalid Student",JOptionPane.OK_OPTION);
             confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
         }
     }catch(Exception e)
     {
         e.printStackTrace();
     }


 }


                                public void Fine()
                                {
                                     if(cmbMonth.getSelectedItem().toString().equals("Quarterly"))
                                      return;
                                      if(cmbMonth.getSelectedItem().toString().equals("Half-Yearly"))
                                          return;
                                          if(cmbMonth.getSelectedItem().toString().equals("Yearly"))
                                              return;
                                          //button 13
                                    payFine();
                                }
                                private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
                                    if(admissionnumber.getText().isEmpty()) {
                                        confirmmsg.setForeground(Color.RED);
                                 confirmmsg.setText("Admission No. Empty!");
                                        JOptionPane.showConfirmDialog(null,"Admission No. Empty","Admission No. empty",JOptionPane.OK_CANCEL_OPTION);
                                         confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");

                                    } else
                                    {
                                         reason=(JOptionPane.showInputDialog("Reason for concession/waiver?"));


                                        //waiver();// TODO add your handling code here:
                                        waiverPartWise();
                                    }
                                    //insertIntoFeeWaiver(waivestudent,(waivestudent-extrawaiver));
}//GEN-LAST:event_jButton14ActionPerformed

                                private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
                                    int feeid=0,feetype=0,groupid1 = 0;
                                    try {
                                        int currentrow=jTable1.getSelectedRow();
                                        System.out.println("current row is "+currentrow);

                                       sessionval=Integer.parseInt(sessionmap1.get(dm.getValueAt(currentrow,1)).toString());
                                        //con=com.duc.DatabaseConnection.DatabaseConnection.con;

                                   ps=con.prepareStatement("select * from monthlyfeehead where head=?");
                                   ps.setString(1,dm.getValueAt(currentrow,2).toString());
                                   rs=ps.executeQuery();
                                   if(rs.next())
                                   {
                                       feeid=rs.getInt(1);
                                       feetype=0;
                                       groupid1=0;
                                       System.out.println("inside monthly feehead");
                                   }

                                   System.out.println("feehead is "+feeid);
                                    System.out.println("feehead is "+feeid);
                                     System.out.println("feehead is "+feeid);
                                      System.out.println("feehead is "+feeid);
                                       System.out.println("feehead is "+feeid);
                                        System.out.println("feehead is "+feeid);
                                         System.out.println("feehead is "+feeid);
                                          System.out.println("feehead is "+feeid);
                                           System.out.println("feehead is "+feeid);


                                   ps=con.prepareStatement("select * from admissionfeehead where head=?");
                                   ps.setString(1,dm.getValueAt(currentrow,2).toString());
                                   rs=ps.executeQuery();
                                   if(rs.next())
                                   {
                                       feeid=rs.getInt(1);
                                       feetype=1;
                                       groupid1=1;

                                       System.out.println("inside admission feehead");
                                   }

                                    ps=con.prepareStatement("select * from periodicfeehead where head=?");
                                   ps.setString(1,dm.getValueAt(currentrow,2).toString());
                                   rs=ps.executeQuery();
                                   if(rs.next())
                                   {
                                       feeid=rs.getInt(1);
                                       feetype=2;

                                       if(rs.getInt(3)==1)
                                       groupid1=1;
                                       else
                                       groupid1=0;

                                       System.out.println("inside periodic feehead");
                                   }

                                    ps=con.prepareStatement("select * from ledgerotherfeeheadcode where feehead=?");
                                   ps.setString(1,dm.getValueAt(currentrow,2).toString());
                                   rs=ps.executeQuery();
                                   if(rs.next())
                                   {
                                       feeid=rs.getInt(3);
                                       feetype=3;
                                       groupid1=0;

                                       System.out.println("inside ledger feehead");
                                   }

                                   ps=con.prepareStatement("select * from inventorydeposit where invname=?");
                                   ps.setString(1,dm.getValueAt(currentrow,2).toString());
                                   rs=ps.executeQuery();
                                   if(rs.next())
                                   {
                                       feeid=Integer.parseInt(otherfeemap1.get("Inventory Purchase").toString());
                                       feetype=3;
                                       groupid1=rs.getInt(1);

                                       System.out.println("inside inventory feehead");
                                   }
System.out.println("hello");System.out.println("hello");System.out.println("hello");
                                        System.out.println ("Head="+feeid+" and Type="+feetype+" and Groupid="+groupid1);
System.out.println("hello");

                                        ps=con.prepareStatement("delete from feedues where studentid=? and head=? and dues=? and month=? and feetype=? and session=? and groupid=?");
                                        ps.setString(1,dm.getValueAt(currentrow,0).toString());
                                        ps.setInt(2,feeid);
                                        ps.setDouble(3,Double.parseDouble(dm.getValueAt(currentrow,3).toString()));
                                        ps.setInt(4,Integer.parseInt(month1.get(dm.getValueAt(currentrow,4).toString()).toString()));
                                        ps.setInt(5,feetype);
                                        ps.setInt(6,sessionval);
                                        ps.setInt(7,groupid1);

                                        System.out.println("first quesy is     "+ps);

                                        ps.executeUpdate();

                                        ps=con.prepareStatement("insert into feeremoved values(?,?,?,?,?,?,?,?)");
                                        ps.setString(1,dm.getValueAt(currentrow,0).toString());
                                        if(feetype==0)
                                        ps.setInt(2,Integer.parseInt(monthlyfeemap1.get(dm.getValueAt(currentrow,2).toString()).toString()));
                                        else
                                        {
                                            System.out.println("rdx123456    ...........");
                                        if(feetype==1)
                                        ps.setInt(2,Integer.parseInt(admissionfeemap1.get(dm.getValueAt(currentrow,2).toString()).toString()));

                                            else
                                            {
                                        if(feetype==2)
                                        ps.setInt(2,Integer.parseInt(periodicfeemap1.get(dm.getValueAt(currentrow,2).toString()).toString()));

                                                else
                                                {
                                                    if(feetype==3 && groupid1==0)
                                        ps.setInt(2,Integer.parseInt(otherfeemap1.get(dm.getValueAt(currentrow,2).toString()).toString()));
                                         else
                                             ps.setInt(2,Integer.parseInt(otherfeemap1.get("Inventory Purchase").toString()));
                                        }
                                        }
                                    }
                                            ps.setDouble(3,Double.parseDouble(dm.getValueAt(currentrow,3).toString()));
                                        ps.setInt(4,Integer.parseInt(month1.get(dm.getValueAt(currentrow,4).toString()).toString()));
                                         ps.setString(5,datum);
                                         ps.setInt(6,feetype);
                                         ps.setInt(7,sessionval);
                                         ps.setInt(8,groupid1);

                                         System.out.println("another quesry is ");
                                          ps.executeUpdate();

                                          dm.removeRow(currentrow);
                                         confirmmsg.setForeground(Color.GREEN);
                                          confirmmsg.setText("Fee is removed from Dues!");
                                        //JOptionPane.showConfirmDialog(null,"Fee is removed from Dues","Remove alarm",JOptionPane.OK_OPTION);

                                    }catch(Exception e) {
                                        e.printStackTrace();
                                    }

                                    // TODO add your handling code here:
}//GEN-LAST:event_jButton16ActionPerformed

                                private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                                    StatementPrint();     // TODO add your handling code here:
}//GEN-LAST:event_jButton2ActionPerformed

                                private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
                                    // JOptionPane.showConfirmDialog(null,"make sure ","Customization alarm",JOptionPane.OK_OPTION);
                                    insertIntoCustomization();
                                    sumOfDues();
                                    
}//GEN-LAST:event_jButton19ActionPerformed

                                private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
          try
          {
                                     ps=con.prepareStatement("Select * from ledgerotherfeeheadcode where feehead=?");
         ps.setString(1,"Surplus");
         rs=ps.executeQuery();

         if(!rs.next())
         {
        ps=con.prepareStatement("insert into ledgerotherfeeheadcode (feehead) values(?)");
                ps.setString(1,"Surplus");
                //ps.setInt(2,0);
                ps.executeUpdate();
         }

    /*    ps=con.prepareStatement("Select * from ledgerotherfeeheadcode where feehead=?");
         ps.setString(1,"Surplus");
         rs=ps.executeQuery();

         if(rs.next())
         {
         ledcode=rs.getInt(2);
         feeid=rs.getInt(3);
         }*/
          }catch(Exception e)
          {
              e.printStackTrace();
          }
                                    // TODO add your handling code here:
                                    if(admissionnumber.getText().isEmpty())
                                    {
                                        confirmmsg.setForeground(Color.RED);
                                        confirmmsg.setText("Admission No. Empty!");
                                        JOptionPane.showConfirmDialog(null,"Admission No. Empty","Admission No. empty",JOptionPane.OK_CANCEL_OPTION);
                                         confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
                                    }
                                        else {
                                        try {

                                            //con=com.duc.DatabaseConnection.DatabaseConnection.con;
                                             ps = con.prepareStatement("select status from studententry where id=?");
                                                ps.setString(1,admissionnumber.getText());
                                              rs = ps.executeQuery();
                                             if(rs.next())
                                                      {
                                               int status=rs.getInt(1);
                                                 if(status==0)
                                                 {
                                                     confirmmsg.setForeground(Color.GREEN);
                                                     confirmmsg.setText("Ex Student! Adv. can't be paid");
                                                 JOptionPane.showConfirmDialog(null,"Ex Student!! Advance cannot be paid","Ex Student Prompt",JOptionPane.OK_CANCEL_OPTION);
                                                  confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");

                                                 }else
                                                 {
                                            advance=Double.parseDouble(JOptionPane.showInputDialog("advance amount?"));
                                            System.out.println("advance"+advance);
                                            totalsurplus.setText(String.valueOf(Double.parseDouble(totalsurplus.getText())+advance));


                                            insertIntoSurplusFromAdvance();
                                            todaySurplus(advance);
                                            InsertBlankReceipt();
                                                 }
                                            }

                                        }

                                        catch(Exception e) {
                                            e.printStackTrace();
                                            JOptionPane.showConfirmDialog(null,"Advance Empty","Advance Input",JOptionPane.OK_CANCEL_OPTION);
                                             confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
                                        }
}//GEN-LAST:event_jButton5ActionPerformed
                                }

                                public void InsertBlankReceipt()
                                {                                  
                                  try
                                  {
                                    ps=con.prepareStatement("select sessionid from sessionsetup where status=1");
                                    rs=ps.executeQuery();
                                    rs.next();
                                    int session=rs.getInt(1);

                                    ps=con.prepareStatement("select Max(receipt) from receiptnumber");
                                    rs=ps.executeQuery();
                                    rs.next();

                                    ps=con.prepareStatement("insert into receiptnumber(receipt,studentid,date,month,surplus,waiver,session,newsurplus,surplusused) values(?,?,(select current_date()),(select date_format(current_date(),'%M')),?,0.0,?,?,0.0)");
                                    ps.setInt(1, rs.getInt(1)+1);
                                    ps.setString(2, admissionnumber.getText());
                                    ps.setDouble(3,advance);
                                    ps.setInt(4,session);
                                    ps.setDouble(5, advance);
                                    ps.executeUpdate();

                                       ps=con.prepareStatement("Select * from ledgerotherfeeheadcode where feehead=?");
         ps.setString(1,"Surplus");
         rs1=ps.executeQuery();
         rs1.next();


                                    ps=con.prepareStatement("insert into payreceiptinfo(receiptnumber,feetype,feehead,totaldues,totalpaid,totalremaining,session) values(?,?,?,0.0,0.0,0.0,?)");
                                    ps.setInt(1, rs.getInt(1)+1);
                                    ps.setInt(2,3);
                                    ps.setInt(3,rs1.getInt(3));
                                    ps.setInt(4,session);
                                    ps.executeUpdate();

                                  }
                                  catch(Exception e)
                                  {
                                   e.printStackTrace();
                                  }
                                }
                                    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed

                                        // TODO add your handling code here:
}//GEN-LAST:event_jPanel1KeyPressed

                                    private void admissionnumberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_admissionnumberFocusGained
                                        // TODO add your handling code here:
                                    }//GEN-LAST:event_admissionnumberFocusGained

                                    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed


                                         if(classperiodicfee.isSelected()==false && studentperiodicfee.isSelected()==false)
            {
                JOptionPane.showConfirmDialog(null,"select one radio button","Select Fee Mode",JOptionPane.OK_OPTION);
            }else
            {
            if(classperiodicfee.isSelected())
                loadClassPeriodicFee();
            else
            loadStudentPeriodicFee();
            }
                                         
                                    }//GEN-LAST:event_jButton22ActionPerformed

                                    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
                                      
                                    }//GEN-LAST:event_jComboBox1MouseClicked

                                    private void miniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miniActionPerformed
                                        // TODO add your handling code here:
                                    }//GEN-LAST:event_miniActionPerformed

                                    private void cashCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashCheckActionPerformed
                                         if(cashCheck.isSelected()==true)
                                           jPanel6.setVisible(false);
                                    }//GEN-LAST:event_cashCheckActionPerformed

                                    private void ddCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddCheckActionPerformed
                                       if(ddCheck.isSelected()==true)
                                           jPanel6.setVisible(true);
                                       jLabel21.setText("DD No.");
                                       amt.setText(collected.getText());
                                    }//GEN-LAST:event_ddCheckActionPerformed

                                    private void chequeCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chequeCheckActionPerformed
                                       if(chequeCheck.isSelected()==true)
                                           jPanel6.setVisible(true);
                                        jLabel21.setText("Ch. No.");
                                         amt.setText(collected.getText());
                                    }//GEN-LAST:event_chequeCheckActionPerformed

                                    private void jButton17KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton17KeyPressed

                                        //FeePrint();
}//GEN-LAST:event_jButton17KeyPressed

                                    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
/*jButton1.setEnabled(false);
                                        payAmount();
        sumOfPayments();
                        jButton17.setBackground(Color.BLUE);
                         //amt.setText(collected.getText());
                         feeReceipt();
*/
                                        int i=0;
try
            {

                 for(i=0;i<dm.getRowCount();i++)
            {
if(Double.parseDouble(dm.getValueAt(i,5).toString())!=0)
{
    manualPay();
    return;
}
}
}catch(Exception e)
{
    e.printStackTrace();
}
                          if(click>0)
                       {
                           JOptionPane.showMessageDialog(null,"Fine / Random button remain unpressed");

                       }
                       else
                       {
                         /*  jButton17.setEnabled(false);
                           loadLumpsumpAmount();
                        sumOfPayments();
                        jButton17.setBackground(Color.BLUE);*/
                       //  amt.setText(collected.getText());
                        if(chequeCheck.isSelected() && amt.getText().isEmpty())
                           JOptionPane.showMessageDialog(null,"Fill Cheque Amount","Fill Amount",JOptionPane.PLAIN_MESSAGE);
                        else
                        {
                            if(ddCheck.isSelected() && amt.getText().isEmpty())
                           JOptionPane.showMessageDialog(null,"Fill DD Amount","Fill Amount",JOptionPane.PLAIN_MESSAGE);
                            else
                            {
/*
                              jButton17.setEnabled(false);
                           loadLumpsumpAmount();
                        sumOfPayments();
                        jButton17.setBackground(Color.BLUE);
                         feeReceipt();*/

                                jButton1.setEnabled(false);
                                jButton18.setEnabled(false);
                                        payAmount();
        sumOfPayments();
                        jButton17.setBackground(Color.BLUE);
                         //amt.setText(collected.getText());
                         feeReceipt();
                       }
                        }
                       }
                         // TODO add your handling code here:
}//GEN-LAST:event_jButton17ActionPerformed

                                    private void jComboBox3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox3MouseClicked
                                        // TODO add your handling code here:
                                    }//GEN-LAST:event_jComboBox3MouseClicked

                                    private void jComboBox3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox3MouseEntered
                                        // TODO add your handling code here:
                                    }//GEN-LAST:event_jComboBox3MouseEntered

                                    private void jComboBox3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox3MousePressed
                                        // TODO add your handling code here:
                                    }//GEN-LAST:event_jComboBox3MousePressed

                                    private void jComboBox3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox3MouseDragged
                                        // TODO add your handling code here:
                                    }//GEN-LAST:event_jComboBox3MouseDragged

                                    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox3ItemStateChanged
                                        // TODO add your handling code here:
                                    }//GEN-LAST:event_jComboBox3ItemStateChanged

                                    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
                                      if(!jComboBox3.getSelectedItem().toString().equals("Sibling"))
                                          setAdmissionNo(jComboBox3.getSelectedItem().toString());// TODO add your handling code here:
                                    }//GEN-LAST:event_jComboBox3ActionPerformed

                                    private void jXTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTable1MouseClicked
                                      // int crow=jXTable1.getSelectedRow();
                                        int crow=jXTable1.convertRowIndexToModel(jXTable1.getSelectedRow());

                                        String id=(jXTable1.getValueAt(crow,1).toString());

                                        admissionnumber.setText(id.trim());
                                        //jXImagePanel1.setImage(null);
                                       // loadStudent();
                                     //   loadPicture();
                                       // loadStudentDetail();
                                        setAdmissionNo(id);
}//GEN-LAST:event_jXTable1MouseClicked

                                    private void jXTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jXTable1KeyTyped
                                        // TODO add your handling code here:
}//GEN-LAST:event_jXTable1KeyTyped

                                    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
                                    manualPay();
                                    }//GEN-LAST:event_jButton18ActionPerformed

                                    private void jButton18KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton18KeyPressed
                                        // TODO add your handling code here:
                                    }//GEN-LAST:event_jButton18KeyPressed

                                    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
                                        // TODO add your handling code here:if(jCheckBox2.isSelected())
                                        if(jCheckBox3.isSelected())
                                        {
                                            jCheckBox2.setSelected(false);
                                            classadmissionfee.setVisible(false);
                                            studentadmissionfee.setVisible(false);
                                            jButton12.setVisible(false);

                                            //jCheckBox1.setSelected(false);
                                            //jButton20.setVisible(false);

                                            classperiodicfee.setVisible(true);
                                            studentperiodicfee.setVisible(true);
                                            jButton22.setVisible(true);



                                        }
                                        else
                                        {
                                            classperiodicfee.setVisible(false);
                                            studentperiodicfee.setVisible(false);
                                            jButton22.setVisible(false);


                                        }
                                    }//GEN-LAST:event_jCheckBox3ActionPerformed

                                    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
                                        // TODO add your handling code here:
                                        if(jCheckBox2.isSelected())
                                        {
                                            classadmissionfee.setVisible(true);
                                            studentadmissionfee.setVisible(true);
                                            jButton12.setVisible(true);

                                          //  jCheckBox1.setSelected(false);
                                            //jButton20.setVisible(false);

                                           jCheckBox3.setSelected(false);
                                            classperiodicfee.setVisible(false);
                                            studentperiodicfee.setVisible(false);
                                            jButton22.setVisible(false);



                                        }
                                        else
                                        {
                                            classadmissionfee.setVisible(false);
                                            studentadmissionfee.setVisible(false);
                                            jButton12.setVisible(false);


                                        }
                                    }//GEN-LAST:event_jCheckBox2ActionPerformed

                                    public void manualPay()
                                    {
//                                           jButton1.setEnabled(false);
  //                                     jButton17.setEnabled(false);

    //    sumOfPayments();

//                         feeReceipt();


                          if(click>0)
                       {
                           JOptionPane.showMessageDialog(null,"Fine / Random button remain unpressed");

                       }
                       else
                       {

                        if(chequeCheck.isSelected() && amt.getText().isEmpty())
                           JOptionPane.showMessageDialog(null,"Fill Cheque Amount","Fill Amount",JOptionPane.PLAIN_MESSAGE);
                        else
                        {
                            if(ddCheck.isSelected() && amt.getText().isEmpty())
                           JOptionPane.showMessageDialog(null,"Fill DD Amount","Fill Amount",JOptionPane.PLAIN_MESSAGE);
                            else
                            {


                                jButton1.setEnabled(false);
                                jButton17.setEnabled(false);

        sumOfPayments();

                         feeReceipt();
                       }
                        }
                       }
                                    }
                                    public void loadAdmissionNoTable(String id)
 {
     int i=0,j=0;
     //  con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

       {
   try
   {
        System.out.println("FDF");
       ps=con.prepareStatement("select * from studententry where name like ? or id=?");
       ps.setString(1,id+"%");
         ps.setString(2,id);
       rs=ps.executeQuery();
      // System.out.println("rd1");
        while(rs.next())
            {
                j++;
              //  System.out.println("rd2");
            }
            rs.first();
            rs.previous();
            dm1.setRowCount(j);
            while(rs.next())
            {


                dm1.setValueAt(rs.getString(2), i, 0);
                dm1.setValueAt(rs.getString(1), i, 1);
                dm1.setValueAt(rs.getString(3), i, 2);
                //jXTable2.removeAll();

              //  System.out.println("rd3");


                i++;
            }


   }catch(Exception e)
   {
e.printStackTrace();
   }
        }
}


                                    public void payAmount()
                                    {
                                         Double payamount=Double.parseDouble(JOptionPane.showInputDialog("Pay amount?",totaldues.getText()));
                                         if(payamount>0.0)
                                         {
                                         for(int i=0;i<dm.getRowCount();i++)
            {
                                 Double displayedamount=(Double) dm.getValueAt(i,3);

                                 Double amountpaid=(Double) dm.getValueAt(i,5);//
                               //  if(displayedamount>=payamount)//
                                 if(displayedamount-amountpaid<=payamount)
                                 {
                                     dm.setValueAt(displayedamount, i,5);
                                     payamount=payamount-(displayedamount-amountpaid);
                                 }
                                 else
                                 {
                                     dm.setValueAt(amountpaid+payamount, i,5);
                                     payamount=0.0;
                                 }

            }
                                         if(payamount>0.0)
                                         {
                                             totalsurplus.setText(String.valueOf(Double.parseDouble(totalsurplus.getText())+payamount));
                                             payamount1=payamount;
System.out.println("ssssssssssssssssssssssssssssssssssssssssssssssssss==="+payamount1);
                                         }
                                    }
                                         else
                                         {
                                             JOptionPane.showMessageDialog(null,"Amount must be greater than 0");
                                         }
                                    }

                                    public void loadStudentPeriodicFee()
                                    {
                                         if(jComboBox1.getSelectedItem().equals("choose")) {
                    confirmmsg.setForeground(Color.RED);
                                 confirmmsg.setText("Class Not Set");
                    JOptionPane.showConfirmDialog(null,"Class Not Set","Class Setter",JOptionPane.OK_CANCEL_OPTION);
                     confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
                } else {
                   if(cmbMonth.getSelectedItem().equals("choose") || cmbMonth.getSelectedItem().equals("Quarterly") || cmbMonth.getSelectedItem().equals("Half-Yearly") || cmbMonth.getSelectedItem().equals("Yearly"))

                    {
                        confirmmsg.setForeground(Color.RED);
                                 confirmmsg.setText("Month Not Set");
                        JOptionPane.showConfirmDialog(null,"Month Not Set","Month Setter",JOptionPane.OK_CANCEL_OPTION);
                         confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
                    }
                    else {
                       // loadAllCustomizedStudentOfClass();
                        String stdclass=jComboBox1.getSelectedItem().toString();
                        String month=cmbMonth.getSelectedItem().toString();
                        String stdid=admissionnumber.getText();
                        //getPeriodicFeeStructure();
                        com.duc.FeeDepartment.PeriodicFeeAmount r=   new com.duc.FeeDepartment.PeriodicFeeAmount();
 this.add(r,0);
 r.stdclass=stdclass;
 r.month=month;
 r.stdid=stdid;
      r.setVisible(true);
     
               r.oldFeeHeadAmount();
      System.out.println("ravi dangaich");

                 }}
                                    }
public void loadClassPeriodicFee()
{
     if(jComboBox1.getSelectedItem().equals("choose")) {
                    confirmmsg.setForeground(Color.RED);
                                 confirmmsg.setText("Class Not Set");
                    JOptionPane.showConfirmDialog(null,"Class Not Set","Class Setter",JOptionPane.OK_CANCEL_OPTION);
                     confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
                } else {
                    if(cmbMonth.getSelectedItem().equals("choose") || cmbMonth.getSelectedItem().equals("Quarterly") || cmbMonth.getSelectedItem().equals("Half-Yearly") || cmbMonth.getSelectedItem().equals("Yearly"))
                    {
                         confirmmsg.setForeground(Color.RED);
                                 confirmmsg.setText("Month Not Set");
                        JOptionPane.showConfirmDialog(null,"Month Not Set","Month Setter",JOptionPane.OK_CANCEL_OPTION);
                         confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
                    }
                    else {
                       // loadAllCustomizedStudentOfClass();
                        String stdclass=jComboBox1.getSelectedItem().toString();
                        String month=cmbMonth.getSelectedItem().toString();
                        //getPeriodicFeeStructure();
                        com.duc.FeeDepartment.PeriodicFeeAmount r=   new com.duc.FeeDepartment.PeriodicFeeAmount();
 this.add(r,0);
 r.stdclass=stdclass;
 r.month=month;
      r.setVisible(true);
      //r.oldFeeHeadAmountShowFromFeeCounter(stdclass);
               r.oldFeeHeadAmount();
      System.out.println("ravi dangaich");

                   }}
}

                                public void waiverPartWise()
                                        {
                                          Double waivecurrent=Double.parseDouble(JOptionPane.showInputDialog("Pay concession/waiver?"));
                     
                                          waivestudent=waivecurrent;
                                          if(waivecurrent>0.0)
                                         {
                                         for(int i=0;i<dm.getRowCount();i++)
                                      {
                                             if(waivecurrent>0.0)
                                         {

                                             

                                 Double displayedDues=(Double) dm.getValueAt(i,3);
                                 if(displayedDues>=waivecurrent)
                                 {
                                     dm.setValueAt(waivecurrent, i,5);
                                    waivecurrent=0.0;
                                  
                                    waiverhead=waiverhead.concat(dm.getValueAt(i,2).toString());
      waiverDues=(dm.getValueAt(i,3).toString().concat("+"+waiverDues));

       waiverMonth=(dm.getValueAt(i,4).toString().concat("+"+waiverMonth));

       waiverPaid=(dm.getValueAt(i,5).toString().concat("+"+waiverPaid));
                                 }
                                 else
                                 {

                                     dm.setValueAt(displayedDues, i,5);
                                     waivecurrent=waivecurrent-displayedDues;

                                     waiverhead=waiverhead.concat(dm.getValueAt(i,2).toString());
      waiverDues=(dm.getValueAt(i,3).toString().concat("+"+waiverDues));

       waiverMonth=(dm.getValueAt(i,4).toString().concat("+"+waiverMonth));
       waiverPaid=(dm.getValueAt(i,5).toString().concat("+"+waiverPaid));
                                 }

            }
                                         }                       if(waivecurrent>0.0)
                                         {
                                             totalsurplus.setText(String.valueOf(Double.parseDouble(totalsurplus.getText())+waivecurrent));
extrawaiver=waivecurrent;
                                         }
                                         
                                    }
                                         else
                                         {
                                             JOptionPane.showMessageDialog(null,"Amount must be greater than 0");
                                         }
                                    }
 public void waiverPartWise1()
 {

   /*   currentrow=jTable1.getSelectedRow();
      waiverhead=waiverhead.concat(dm.getValueAt(currentrow,2).toString());
      waiverDues=(dm.getValueAt(currentrow,3).toString().concat("+"+waiverDues));

       waiverMonth=(dm.getValueAt(currentrow,4).toString().concat("+"+waiverMonth));
      System.out.println(waiverhead);
     Double newdues=0.0,extrawaivercurrent=0.0,waivecurrent=0.0,actualdues=Double.parseDouble(dm.getValueAt(currentrow,3).toString());
     Double actualpaid=Double.parseDouble(dm.getValueAt(currentrow,5).toString());
//     int choose=JOptionPane.showConfirmDialog(null,"Do you want to Waive the student","Waive Student",JOptionPane.OK_CANCEL_OPTION);
  //   if(choose==JOptionPane.OK_OPTION)
     {
     waivecurrent=Double.parseDouble(JOptionPane.showInputDialog("Waived amount?"));
         waivestudent=waivestudent+waivecurrent;
 sessionval=Integer.parseInt(sessionmap1.get(dm.getValueAt(currentrow,1)).toString());
     }
   // newdues=Double.parseDouble(dm.getValueAt(currentrow,5).toString())-(waivestudent + Double.parseDouble(dm.getValueAt(currentrow,7).toString()));
    newdues=Double.parseDouble(dm.getValueAt(currentrow,3).toString())-(waivecurrent + Double.parseDouble(dm.getValueAt(currentrow,5).toString()));
     if(newdues>0)
    {
        actualdues=actualdues-waivecurrent;
        actualpaid=waivecurrent +actualpaid;
        dm.setValueAt(actualpaid, currentrow, 5);
        waiverPaid=(dm.getValueAt(currentrow,5).toString().concat("+"+waiverPaid));
      //  insertIntoFeeWaiver(waivestudent,waivestudent);

    }
    else
    {
        actualdues=0.0;
        dm.setValueAt(dm.getValueAt(currentrow,3), currentrow, 5);
                extrawaiver=extrawaiver+Math.abs(newdues);
                System.out.println("extrawaiver="+extrawaiver);
                extrawaivercurrent=Math.abs(newdues);
                 waiverPaid=(dm.getValueAt(currentrow,5).toString().concat("+"+waiverPaid));
           if(extrawaiver>0.0)
             totalsurplus.setText(String.valueOf(Double.parseDouble(totalsurplus.getText())+ extrawaivercurrent));
              
    }*/

 }

 public void insertIntoFeeWaiver(Double waivergiven,Double waiverused,int sessionval)
 {
   
            int i=0;
            try
            {
 if(waivestudent!=0)
 {
                      ps=con.prepareStatement("insert into feewaiver values(?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1,dm.getValueAt(currentrow,0).toString());
               // ps.setString(2,dm.getValueAt(currentrow,4).toString());
ps.setString(2,waiverhead);
                //ps.setDouble(3,Double.parseDouble(dm.getValueAt(currentrow,5).toString()));
ps.setString(3,waiverDues);
                //ps.setString(4,dm.getValueAt(currentrow,6).toString());
ps.setString(4,waiverMonth);
                 System.out.println("r3");
                //ps.setDouble(5,Double.parseDouble(dm.getValueAt(currentrow,7).toString()));
                 ps.setString(5,waiverPaid);
                 ps.setDouble(6,waivergiven);
                  ps.setDouble(7,waiverused);

                 ps.setString(8, datum);
 ps.setInt(9,sessionval);
 ps.setString(10,reason);
                ps.executeUpdate();
       // con.close();
 }  }

            catch(Exception e)
            {
                System.out.print("dddddddddddddddd");
e.printStackTrace();
            }

 }
 public int matchIdForCustomizedStudent(String id)
 {
     //con=com.duc.DatabaseConnection.DatabaseConnection.con;
     try
     {
         ps=con.prepareStatement("select  * from feecustomization where studentid=?");
         ps.setString(1, id);
         rs=ps.executeQuery();
         if(rs.next())
         {
             confirmmsg.setForeground(Color.GREEN);
                                 confirmmsg.setText("Customized Fee is set for this student");
             //JOptionPane.showConfirmDialog(null, "Customized Fee is set for this student","Customized Window Prompt",JOptionPane.OK_CANCEL_OPTION);
         return 1;
         }
         else return 0;
     }catch(Exception e)
     {
         e.printStackTrace();
     }
return 0; }

 public void refundStudent()
 {
     int feeid=0;
     //con=com.duc.DatabaseConnection.DatabaseConnection.con;
     Double refundstudent=0.0;
     int choose=JOptionPane.showConfirmDialog(null,"Do you want to refund the student","Refund Student",JOptionPane.OK_CANCEL_OPTION);
     if(choose==JOptionPane.OK_OPTION){
     refundstudent=Double.parseDouble(JOptionPane.showInputDialog("Refunded amount?"));

     try
     {
         ps=con.prepareStatement("select * from admissionfeehead where head='Security Fee'");
         rs=ps.executeQuery();
         if(rs.next())
             feeid=rs.getInt(1);

ps=con.prepareStatement("select * from feepaid where studentid=? and head=? and feetype=1");
ps.setString(1,admissionnumber.getText());

ps.setInt(2,feeid);

rs=ps.executeQuery();
if(rs.next())
{

Double deposit=rs.getDouble(5);
Double actualsecurity=rs.getDouble(3);
Double returnedvalue=rs.getDouble(7);
Double dep=0.0;
ps=con.prepareStatement("select * from studentrefund where studentid=? and type=1");
ps.setString(1,admissionnumber.getText());
rs=ps.executeQuery();
if(rs.next())
{
   dep=rs.getDouble(2);
   System.out.println("Dep="+dep);
}
deposit=deposit-dep;
if(deposit!=0.0)

{

if(deposit>=refundstudent)
{
   /* deposit=deposit-refundstudent;

    returnedvalue=returnedvalue+refundstudent;
    actualsecurity=actualsecurity- returnedvalue;
    ps=con.prepareStatement("update feepaid set paid=?,date=?,remaining=? where studentid=? and head=?");
    ps.setDouble(1, deposit);
    System.out.println("sdfdsssssssssssss");
   ps.setString(2, datum);
    ps.setDouble(3,returnedvalue);
      ps.setString(4,admissionnumber.getText());
    ps.setInt(5,feeid);
    ps.executeUpdate();*/
    Double localrefund=0.0;
ps=con.prepareStatement("select * from studentrefund where studentid=? and type=1");
ps.setString(1,admissionnumber.getText());
rs=ps.executeQuery();
if(rs.next())
{
    ps=con.prepareStatement("update studentrefund set refund=?,date=? where studentid=? and type=1");
ps.setDouble(1, (dep+refundstudent));
System.out.println("Dep+rs="+(dep+refundstudent));
ps.setString(2,datum);
    ps.setString(3,admissionnumber.getText());
    ps.executeUpdate();
}else
{
    ps=con.prepareStatement("insert into studentrefund values(?,?,?,?)");
ps.setString(1,admissionnumber.getText());

ps.setDouble(2,refundstudent);
ps.setInt(3,1);
ps.setString(4,datum);

ps.executeUpdate();


}

    confirmmsg.setForeground(Color.GREEN);
                                 confirmmsg.setText("Security Fee Refunded!");
                                 JOptionPane.showConfirmDialog(null,"Security Fee Refunded","Refund Student",JOptionPane.OK_CANCEL_OPTION);
                                 //confirmmsg.setForeground(Color.GREEN);
                                 confirmmsg.setText("--------------------------Confirmation----------------------");
}else 
{
    confirmmsg.setForeground(Color.RED);
                                 confirmmsg.setText("Entered amount>Security Fee");
    JOptionPane.showConfirmDialog(null,"Entered amount is greater than security","Refund Student",JOptionPane.OK_CANCEL_OPTION);
     confirmmsg.setForeground(Color.GREEN);
                                 confirmmsg.setText("--------------------------Confirmation----------------------");
}
     }

     else
     {
    confirmmsg.setForeground(Color.RED);
                                 confirmmsg.setText("Security Fee already Refunded!");
    JOptionPane.showConfirmDialog(null,"Security Fee already Refunded","Refund Student",JOptionPane.OK_CANCEL_OPTION);
     confirmmsg.setForeground(Color.GREEN);
                                 confirmmsg.setText("--------------------------Confirmation----------------------");
     }
     }
else
{
   confirmmsg.setForeground(Color.RED);
                                 confirmmsg.setText("No Security Fee paid by this student!");
    JOptionPane.showConfirmDialog(null,"No Security Fee paid by this student","No Refund Student",JOptionPane.OK_CANCEL_OPTION);
    confirmmsg.setForeground(Color.GREEN);
                                 confirmmsg.setText("--------------------------Confirmation----------------------");
}
     }catch(Exception e)
     {
e.printStackTrace();
//JOptionPane.showConfirmDialog(null,"Invalid Admission Number","Invalid Student",JOptionPane.OK_CANCEL_OPTION);
     }
     }else
     {

     }
 }

  public void flushTemporaryReceiptTable()
 {
try
{
   //con=com.duc.DatabaseConnection.DatabaseConnection.con;
   ps=con.prepareStatement("delete from temporarytableforreceipt");
   ps.executeUpdate();
  // con.close();
}
catch(Exception e)
{
    System.err.println("Data flush error  ..."+e);
}
 }



public void insertIntoCustomization()
{
     int k=0;

//con=com.duc.DatabaseConnection.DatabaseConnection.con;
int ledcode;
int feeheadtype=0;
int feestatus=0;
int head1int=0;
try
{
    int rowselect=jTable1.getSelectedRow();
    String id=dm.getValueAt(rowselect, 0).toString();
     
          
              String head1=dm.getValueAt(rowselect, 2).toString();
              Double dues=Double.parseDouble(dm.getValueAt(rowselect, 3).toString());
              String month=dm.getValueAt(rowselect, 4).toString();
 ps=con.prepareStatement("select * from monthlyfeehead where head=?");
            ps.setString(1,head1);
            rs=ps.executeQuery();
            if(rs.next())
            {
feeheadtype=0;
feestatus=0;
            confirmmsg.setForeground(Color.GREEN);
                                 confirmmsg.setText("Admission deductions..!");
                }

            ps=con.prepareStatement("select * from admissionfeehead where head=?");
            ps.setString(1,head1);
            rs=ps.executeQuery();
            if(rs.next())
            {
feeheadtype=1;
feestatus=1;
            confirmmsg.setForeground(Color.GREEN);
                                 confirmmsg.setText("Admission deductions..!");
                }

             ps=con.prepareStatement("select * from periodicfeehead where head=?");
            ps.setString(1,head1);
            rs=ps.executeQuery();
            if(rs.next())
            {
feeheadtype=2;
if(rs.getInt(3)==1)
    feestatus=1;
            confirmmsg.setForeground(Color.GREEN);
                                 confirmmsg.setText("periodic fee deductions..!");
                 confirmmsg.setText("--------------------------Confirmation----------------------");
            }

            ps=con.prepareStatement("select * from ledgerotherfeeheadcode where feehead=?");
            ps.setString(1,head1);
            rs=ps.executeQuery();
            if(rs.next())
            {
feeheadtype=3;

            confirmmsg.setForeground(Color.GREEN);
                                 confirmmsg.setText("Other fee deductions..!");
              //  JOptionPane.showConfirmDialog(null,"For admission fee deductions use Waiver option","Waiver Alarm",JOptionPane.OK_CANCEL_OPTION);
                // confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
            }
              //  else
   {
                if(feeheadtype==0)
       head1int= Integer.parseInt(monthlyfeemap1.get(head1).toString());
       if(feeheadtype==1)
       head1int= Integer.parseInt(admissionfeemap1.get(head1).toString());
       if(feeheadtype==2)
       head1int= Integer.parseInt(periodicfeemap1.get(head1).toString());
                if(feeheadtype==3)
       head1int= Integer.parseInt(otherfeemap1.get(head1).toString());


         ps=con.prepareStatement("select * from feedues where studentid=? and month=? and head=? and feetype=? and session=?");
           ps.setString(1,id);
       ps.setInt(2, Integer.parseInt(month1.get(month).toString()));

       ps.setInt(3,head1int);

       ps.setInt(4,feeheadtype);
       ps.setInt(5,sessionValue);
           rs=ps.executeQuery();

           System.out.println("id="+id+"month="+month+"fee HEad Type="+feeheadtype+"head="+head1int+"sessionn="+sessionValue);
           if(rs.next())
           {
            ledcode=rs.getInt(7);

   ps=con.prepareStatement("select * from feecustomization where studentid=? and head=? and feeheadtype=?");
           ps.setString(1,id);

       ps.setInt(2,head1int);
       ps.setInt(3,feeheadtype);
           rs=ps.executeQuery();
         //  System.out.println("rs="+rs.next());
           if(rs.next())
           {
  ps=con.prepareStatement("delete from feecustomization where studentid=? and head=? and feeheadtype=? ");
  ps.setString(1,id);
  ps.setInt(2, head1int);
  ps.setInt(3,feeheadtype);
   ps.executeUpdate();

     
    ps=con.prepareStatement("insert into feecustomization values(?,?,?,?,?,?)");
   ps.setString(1,id);
    ps.setInt(2,head1int);
    ps.setDouble(3,dues);
    //ps.setString(4,studentclass);
    ps.setInt(4, ledcode);
    ps.setInt(5, feeheadtype);
     ps.setString(6, datum);

System.out.println("new entry");

         ps.executeUpdate();
 
   confirmmsg.setForeground(Color.GREEN);
                                 confirmmsg.setText("Fee is Customized");
 JOptionPane.showMessageDialog(null,"Selected Fee is Customized","Customization alarm",JOptionPane.NO_OPTION);
  confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
        System.out.println("Done");
      }

           else
  {

 ps=con.prepareStatement("insert into feecustomization values(?,?,?,?,?,?)");
   ps.setString(1,id);
    ps.setInt(2,head1int);
    ps.setDouble(3,dues);
    //ps.setString(4,studentclass);
ps.setInt(4, ledcode);
ps.setInt(5, feeheadtype);
 ps.setString(6, datum);
System.out.println("new entry");
ps.executeUpdate();
confirmmsg.setForeground(Color.GREEN);
                                 confirmmsg.setText("Fee is Customized");

 JOptionPane.showConfirmDialog(null,"Fee is Customized","Customization alarm",JOptionPane.PLAIN_MESSAGE);
  confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
         
           }


             
              {

                ps=con.prepareStatement("delete from feedues where studentid=? and month=? and head=? and feetype=? and session=?");
       ps.setString(1,id);
       ps.setInt(2, Integer.parseInt(month1.get(month).toString()));
       ps.setInt(3, head1int);
       ps.setInt(4,feeheadtype);
        ps.setInt(5,sessionValue);
       ps.executeUpdate();


              ps=con.prepareStatement("insert into feedues values(?,?,?,?,?,?,?,?,?)");
System.out.println("r7");
    ps.setString(1,id);
   
    ps.setInt(2,head1int);
    ps.setDouble(3, dues);
    ps.setInt(4, Integer.parseInt(month1.get(month).toString()));
    ps.setString(5, datum);
     ps.setInt(6,feestatus);
     ps.setInt(7, ledcode);
     ps.setInt(8,feeheadtype);
     ps.setInt(9, sessionValue);
  System.out.println("done");
ps.executeUpdate();
System.out.println("done");
         }

   
}
else
    JOptionPane.showConfirmDialog(null,"Firstly deposit selected fee for the current session and then customized..","Fee Customization Alarm",JOptionPane.PLAIN_MESSAGE);

   }
}catch(Exception e)
    {
     e.printStackTrace();
    }
}



  public void StatementPrint()
 {
          try {

          //con=com.duc.DatabaseConnection.DatabaseConnection.con;
          HashMap map = new HashMap();
          ps=con.prepareStatement("select id,name,class,section,roll,fathername from studententry where id=?" );
          ps.setString(1, admissionnumber.getText());
          rs = ps.executeQuery();

          rs.next();

          map.put("id",rs.getString(1));
          map.put("name",rs.getString(2));
          map.put("class",classmap.get(rs.getInt(3)));
          map.put("section",sectionmap.get(rs.getInt(4)));
          map.put("roll",rs.getString(5));
          map.put("father",rs.getString(6));
        // System.out.println("r1");

          ps=con.prepareStatement("select institutename, instituteaddress from instituteregistration" );
          rs = ps.executeQuery();
          rs.next();
          map.put("schoolname",rs.getString(1));
          map.put("schooladdress",rs.getString(2));

          BufferedImage bimg = null;
       try
          {
            bimg = ImageIO.read(new File("images/logo.jpg"));
          }
       catch (Exception ex)
        {
          ex.printStackTrace();
        }
       map.put("logo",bimg);

          ps=con.prepareStatement("select head,remaining,dues,month,paid,date_format(date,'%d %M, %Y'),feetype from feepaid where studentid=? and dues!=0 order by month,head,date asc ");
          ps.setString(1, admissionnumber.getText());
          rs = ps.executeQuery();

            if(!rs.next())
            {
                confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("No Result Found !!");
                JOptionPane.showMessageDialog(null, " No Result Found !!");
                confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
                return;
            }
            else
            rs.previous();
           Vector collection=new Vector();
           while(rs.next())
           {
             collection.add(new StatementPrintReport(mp.getFeeHeadNameFromFeeTypeAndHeadIndex(rs.getInt(7), rs.getInt(1)), rs.getDouble(3), rs.getDouble(5), rs.getDouble(2),String.valueOf(mp.mapMonth().get(rs.getInt(4))), rs.getString(6)));
           }
                JRBeanCollectionDataSource src = new JRBeanCollectionDataSource(collection);
                JasperReport js = JasperCompileManager.compileReport("reports/fee/classic.jrxml");
                JasperPrint pr = JasperFillManager.fillReport(js, map,src);
                JasperViewer jv = new JasperViewer(pr, false);
                jv.setTitle("Student Payment and Dues Statements ");
                jv.setVisible(true);
            }
            catch (Exception ex) {
               Logger.getLogger(FeeCounter1.class.getName()).log(Level.SEVERE, null, ex);
               confirmmsg.setForeground(Color.GREEN);
                                 confirmmsg.setText("Choose Admission Number First!");
               JOptionPane.showMessageDialog(null, " Choose Admission Number First!");
                confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
            }

 }



 public void FeePrint()
 {
     try
     {
       jTable1.print();
     }catch(Exception e)
     {
         e.printStackTrace();
     }
 }
 public void FeePrint1()
{
       JRTableModelDataSource src = new JRTableModelDataSource(dm);
        HashMap map = new HashMap();
        BufferedImage bimg = null;
       try {
            bimg = ImageIO.read(new File("images/schoolfee.jpg"));
//bimg = ImageIO.read(new File("./img/SchoolPlusLogo.jpg"));

        } catch (Exception ex) {
           Logger.getLogger(FeeCounter1.class.getName()).log(Level.SEVERE, null, ex);
        }
       map.put("logo",bimg);
        try {
                JasperReport js = JasperCompileManager.compileReport("reports/fee/feereceipt.jrxml");
              // JasperReport js = JasperCompileManager.compileReport("./reports/report2.jrxml");
                JasperPrint pr = JasperFillManager.fillReport(js, map,src);
                JasperViewer jv = new JasperViewer(pr, false);
                jv.setVisible(true);
            }
            catch (Exception ex) {
               Logger.getLogger(FeeCounter1.class.getName()).log(Level.SEVERE, null, ex);
            }

}

 public void waiver()
 {
Double actualamount=0.0;
      int currentrow=jTable1.getSelectedRow();

                dm.setValueAt(dm.getValueAt(currentrow,5), currentrow, 7);
                dm.setValueAt(0, currentrow, 5);

 }
public void insertLastRow()
{
   
     try
     {
         ps=con.prepareStatement("select * from studententry where id=?");
         ps.setString(1,admissionnumber.getText());
         rs=ps.executeQuery();
         if(rs.next())
         {
             int rowcount=dm.getRowCount();
     System.out.println("row"+rowcount);
    dm.setRowCount(rowcount+1);
   
    dm.setValueAt(admissionnumber.getText(), rowcount, 0);
     dm.setValueAt(sessionmap.get(sessionValue), rowcount, 1);
  
    dm.setValueAt(cmbMonth.getSelectedItem().toString(), rowcount,4);
   
         }else
         {
              confirmmsg.setForeground(Color.RED);
                confirmmsg.setText("Invalid Student!");
             JOptionPane.showConfirmDialog(null,"Invalid Student!","Invalid Student",JOptionPane.OK_OPTION);
             confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
         }
     }catch(Exception e)
     {
         e.printStackTrace();
     }


}
public void insertCustomizeFee()
{
int ledcode=0;int feeid=0;
    {
    //con=com.duc.DatabaseConnection.DatabaseConnection.con;
    int count=dm.getRowCount();
    count--;
    System.out.println("row"+count);
    try
    {
       
        ps=con.prepareStatement("select * from ledgerotherfeeheadcode where feehead=?");
         ps.setString(1,dm.getValueAt(count,2).toString());
         rs=ps.executeQuery();
         if(!rs.next())
        {
        ps=con.prepareStatement("insert into ledgerotherfeeheadcode (feehead) values(?)");
        ps.setString(1,dm.getValueAt(count,2).toString());
        ps.executeUpdate();
        }
          ps=con.prepareStatement("Select * from ledgerotherfeeheadcode where feehead=?");

             ps.setString(1,dm.getValueAt(count,2).toString());

               rs=ps.executeQuery();
           if(rs.next())
           {
            ledcode=rs.getInt(2);
feeid=rs.getInt(3);
           }
     ps=con.prepareStatement("insert into feedues values(?,?,?,?,?,?,?,?,?)");

   Double dues=Double.parseDouble(dm.getValueAt(count,3).toString());
 
   String id=admissionnumber.getText();
   String date=datum;
     ps.setString(1,id);
 
    ps.setInt(2,feeid);
    ps.setDouble(3,dues);
    ps.setInt(4, Integer.parseInt(month1.get(cmbMonth.getSelectedItem().toString()).toString()));
    ps.setString(5, datum);
     ps.setInt(6,0);
     ps.setInt(7,ledcode);
     ps.setInt(8,3);
     ps.setInt(9,sessionValue);
  System.out.println("done");
ps.executeUpdate();
System.out.println("done");
//con.close();
            
                 JOptionPane.showConfirmDialog(null,"Field Empty","Fee Head/Fee Dues Empty",JOptionPane.PLAIN_MESSAGE);
      
    }
    catch(Exception e)
    {
        click=0;
       JOptionPane.showConfirmDialog(null,"Fee Head/Fee Dues Empty ","Field Empty",JOptionPane.PLAIN_MESSAGE);
         e.printStackTrace();
}
} }


public void insertIntoSurplusFromAdvance()
{
    Double surplus=0.0;
      //con=com.duc.DatabaseConnection.DatabaseConnection.con;
     try {
         ps=con.prepareStatement("select * from studentsurplus where studentid=?");
    ps.setString(1,admissionnumber.getText());
    rs=ps.executeQuery();
   if(rs.next())
   {
    surplus=rs.getDouble(2);
    ps=con.prepareStatement("update studentsurplus set surplus=? where studentid=?");
        ps.setDouble(1,advance+surplus);
        ps.setString(2,admissionnumber.getText());
        ps.executeUpdate();
}
   else
   {
       ps=con.prepareStatement("insert into studentsurplus values(?,?,?,?)");
    ps.setString(1,admissionnumber.getText());
    ps.setDouble(2,advance);
    ps.setString(3, datum);
    ps.setInt(4,0);//ledgercode
    ps.executeUpdate();

   }
     }catch(Exception e)
{
    e.printStackTrace();
}
}

public void insertIntoTodaySurplusFromAdvance()
{
    Double surplus=0.0;
      //con=com.duc.DatabaseConnection.DatabaseConnection.con;
     try {
         ps=con.prepareStatement("select * from studenttodaysurplus where studentid=? and date=?");
    ps.setString(1,admissionnumber.getText());
    ps.setString(2,datum );
    rs=ps.executeQuery();
   if(rs.next())
   {
    surplus=rs.getDouble(2);
    ps=con.prepareStatement("update studenttodaysurplus set surplus=? where studentid=?");
        ps.setDouble(1,advance+surplus);
        ps.setString(2,admissionnumber.getText());
        ps.executeUpdate();
}
   else
   {
       ps=con.prepareStatement("insert into studenttodaysurplus values(?,?,?)");
    ps.setString(1,admissionnumber.getText());
    ps.setDouble(2,advance);
    ps.setString(3, datum);
    ps.executeUpdate();

   }
     }catch(Exception e)
{
    e.printStackTrace();
}
}
public void loadParticularStudentAdmissionStructure()
{
confirmmsg.setForeground(Color.GREEN);
                                 confirmmsg.setText("----Confirmation----");
     //con=com.duc.DatabaseConnection.DatabaseConnection.con;
            try
            {

                  ps=con.prepareStatement("select * from studententry where id=?");
    ps.setString(1,admissionnumber.getText());
    rs=ps.executeQuery();
    rs.next();
    int studentclass=rs.getInt(9);

     ps=con.prepareStatement("select * from admissionfeeamounthead left join admissionfeehead on feeid=`admissionfeeamounthead`.head where class=? and status=1");
            ps.setInt(1,studentclass);
            rs=ps.executeQuery();
            count=0;
            while(rs.next()) {
               // feeid=rs.getInt(1);
                head=rs.getInt(1);
                amount=rs.getDouble(2);
                ledgercode=rs.getInt(4);
                insertParticularStudentAdmissionStructure(head,amount,ledgercode);

            }
            }catch(Exception e)
            {
e.printStackTrace();
                          confirmmsg.setForeground(Color.RED);
                                 confirmmsg.setText("Invalid Admission No.!");
JOptionPane.showConfirmDialog(null," Invalid Admission No.","Invalid",JOptionPane.OK_OPTION);
 confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
            }




}

public void loadParticularStudentAdmissionStructureFromAddStudent(String id,String studentclass,String doa)
{
fromSession();
     //con=com.duc.DatabaseConnection.DatabaseConnection.con;
            try
            {

                  ps=con.prepareStatement("select * from studententry where id=?");
                  System.out.println("id="+id);
    ps.setString(1,id);
    System.out.println("r1");
    rs=ps.executeQuery();
    rs.next();
   // String studentclass=rs.getString(9);

     ps=con.prepareStatement("select * from admissionfeeamounthead left join admissionfeehead on feeid=`admissionfeeamounthead`.head where class=? and status=1");
            ps.setString(1,classmap1.get(studentclass).toString());
            System.out.println("r2");
            rs=ps.executeQuery();
             count=0;
            while(rs.next()) {
               // feeid=rs.getInt(1);
                head=rs.getInt(1);
                System.out.println("r3");
                amount=rs.getDouble(2);
                System.out.println("r3");
                ledgercode=rs.getInt(4);
                insertParticularStudentStructureFromAddStudent(head,amount,id,doa,ledgercode);
          }
        // con.close();
            }catch(Exception e)
            {
e.printStackTrace();
            }
     confirmmsg.setForeground(Color.GREEN);
                                 confirmmsg.setText("Admission Fee loaded!");
     JOptionPane.showConfirmDialog(null,"Admission Fee loaded","Admission Fee",JOptionPane.OK_OPTION);
      confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
}

        public void loadParticularStudentStructure(int month)
        {
           confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
            //con=com.duc.DatabaseConnection.DatabaseConnection.con;
           int monthfee1=0,head1=0;
                try
            {

             /*    ps=con.prepareStatement("select * from restrictfeemonthwise where month=?");
    ps.setInt(1,month);
    rs5=ps.executeQuery();*/
   // rs.next();
   // int studentclass=rs.getInt(9);

                  ps=con.prepareStatement("select * from studententry where id=?");
    ps.setString(1,admissionnumber.getText());
    rs=ps.executeQuery();
    rs.next();
    int studentclass=rs.getInt(9);

     ps=con.prepareStatement("Select * from monthlyfeeamounthead left join monthlyfeehead on feeid=`monthlyfeeamounthead`.head where class=? and status=1");;
            ps.setInt(1,studentclass);
            rs=ps.executeQuery();
            count=0;
            while(rs.next()) {

                head=rs.getInt(1);
                amount=rs.getDouble(2);
ledgercode=rs.getInt(4);
 ps=con.prepareStatement("select * from restrictfeemonthwise  where month=? and feeid=?");
   ps.setInt(1,month);
   ps.setInt(2,head);
    rs5=ps.executeQuery();
  if(!rs5.next()) {
//if(amount!=0.0)
                insertParticularStudentMonthlyStructure(head,amount,ledgercode,month);
                 }
                
 }


            
           }catch(Exception e)
            {
e.printStackTrace();
confirmmsg.setForeground(Color.RED);
                                 confirmmsg.setText("Invalid Admission No.!");
JOptionPane.showConfirmDialog(null," Invalid Admission No.","Invalid",JOptionPane.OK_OPTION);
 confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
            }

        }
 public void insertParticularStudentMonthlyStructure(int head,Double amount,int ledgercode,int month)
        {
  try
          {

      ps=con.prepareStatement("select * from studententry where id=? and status!=0");
        ps.setString(1,admissionnumber.getText());

        rs1=ps.executeQuery();
        while(rs1.next())
        {

    ps=con.prepareStatement("select * from feedues where  month=? and groupid=0 and studentid=? and head=? and feetype=0 and session=?");

        ps.setInt(1,month);
        ps.setString(2, admissionnumber.getText());
         ps.setInt(3,head);
         ps.setInt(4,sessionValue);

        rs2=ps.executeQuery();
        if(!rs2.next())
        {
            //if(!(amount==0  && monthlyfeemap.get(head).equals("Transport Fee")))// since it prohibits conceession fee to be loaded from feecutomization
            {
               
                ps=con.prepareStatement("insert into feedues values(?,?,?,?,?,?,?,?,?)");
System.out.println("r7");
    ps.setString(1,rs1.getString(1));
  
    ps.setInt(2,head);
    ps.setDouble(3, amount);
    ps.setInt(4,month);
    ps.setString(5, datum);
     ps.setInt(6,0);
     ps.setInt(7,ledgercode);
     ps.setInt(8,0);
     ps.setInt(9,sessionValue);
  System.out.println("done");
ps.executeUpdate();
System.out.println("done");

 confirmmsg.setForeground(Color.GREEN);
                                 confirmmsg.setText("Student fee loaded!");
            }
}
        

        }

   ps = con.prepareStatement("select status from studententry where id=?");
        ps.setString(1,admissionnumber.getText());
        rs4 = ps.executeQuery();
if(rs4.next())
{
    int status=rs4.getInt(1);
    if(status==0)
    {
        confirmmsg.setForeground(Color.GREEN);
                                 confirmmsg.setText("Ex Student!");
        JOptionPane.showConfirmDialog(null,"Ex Student","Ex Student Prompt",JOptionPane.OK_CANCEL_OPTION);
         confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
    }
}
  }catch(Exception e)
            {
e.printStackTrace();
            }
        }

  public void insertParticularStudentPeriodicStructure(String stdid,String month,int head,Double amount,int ledgercode)
        {
  try
          {


      ps=con.prepareStatement("select * from studententry where id=? and status!=0");
        ps.setString(1,stdid);

        rs1=ps.executeQuery();
        while(rs1.next())
        {

    ps=con.prepareStatement("select * from feedues where  month=? and groupid=0 and studentid=? and head=? and feetype=2 and session=?");

        ps.setInt(1,Integer.parseInt(month1.get(month).toString()));
        ps.setString(2, stdid);
         ps.setInt(3,head);
 ps.setInt(4,sessionValue);
        rs2=ps.executeQuery();
        if(!rs2.next())
        {

                ps=con.prepareStatement("insert into feedues values(?,?,?,?,?,?,?,?,?)");
System.out.println("r7");
    ps.setString(1,rs1.getString(1));
  
    ps.setInt(2,head);
    ps.setDouble(3, amount);
    ps.setInt(4, Integer.parseInt(month1.get(month).toString()));
    ps.setString(5, datum);
     ps.setInt(6,0);
     ps.setInt(7,ledgercode);
     ps.setInt(8,2);
     ps.setInt(9,sessionValue);
  System.out.println("done");
ps.executeUpdate();
System.out.println("done");
//con.close();
}


        }
  ps = con.prepareStatement("select status from studententry where id=?");
        ps.setString(1,stdid);
        rs4 = ps.executeQuery();
if(rs4.next())
{
    int status=rs4.getInt(1);
    if(status==0)
    {
      confirmmsg.setForeground(Color.GREEN);
                                 confirmmsg.setText("Ex Student!");
     JOptionPane.showConfirmDialog(null,"Ex Student","Ex Student Prompt",JOptionPane.OK_CANCEL_OPTION);
      confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
}
}
  }catch(Exception e)
            {
e.printStackTrace();
            }
        }

  public void insertParticularStudentCustomizedPeriodicStructure(String stdid,String month,int feehead,Double feeamount,int ledcode)
        {
  try
          {

       ps=con.prepareStatement("Select * from feecustomization where studentid=? and head=? and feeheadtype=2");
            ps.setString(1,stdid);
             ps.setInt(2,feehead);
            rs1=ps.executeQuery();
            if(rs1.next())
            {
                 head=feehead;
                amount=rs1.getDouble(3);
                ledgercode=ledcode;

      ps=con.prepareStatement("select * from studententry where id=? and status!=0");
        ps.setString(1,stdid);

        rs1=ps.executeQuery();
        while(rs1.next())
        {

    ps=con.prepareStatement("select * from feedues where  month=? and groupid=0 and studentid=? and head=? and feetype=2 and session=?");

        ps.setInt(1, Integer.parseInt(month1.get(month).toString()));
        ps.setString(2, stdid);
         ps.setInt(3,head);
ps.setInt(4,sessionValue);
        rs2=ps.executeQuery();
        if(!rs2.next())
        {

                ps=con.prepareStatement("insert into feedues values(?,?,?,?,?,?,?,?,?)");
System.out.println("r7");
    ps.setString(1,rs1.getString(1));
   
    ps.setInt(2,head);
    ps.setDouble(3, amount);
    ps.setInt(4, Integer.parseInt(month1.get(month).toString()));
    ps.setString(5, datum);
     ps.setInt(6,0);
     ps.setInt(7,ledgercode);
     ps.setInt(8,2);
     ps.setInt(9,sessionValue);
  System.out.println("done");
ps.executeUpdate();
System.out.println("done");
//con.close();
}


        }
  ps = con.prepareStatement("select status from studententry where id=?");
        ps.setString(1,stdid);
        rs4 = ps.executeQuery();
if(rs4.next())
{
    int status=rs4.getInt(1);
    if(status==0)
    {
      confirmmsg.setForeground(Color.GREEN);
                                 confirmmsg.setText("Ex Student!");
     JOptionPane.showConfirmDialog(null,"Ex Student","Ex Student Prompt",JOptionPane.OK_CANCEL_OPTION);
      confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
}
}
            }
  }catch(Exception e)
            {
e.printStackTrace();
            }
        }

  public void insertParticularStudentCustomizedAnnualPeriodicStructure(String stdid,String month,int feehead,Double feeamount,int ledcode)
        {
  try
          {

       ps=con.prepareStatement("Select * from feecustomization where studentid=? and head=? and feeheadtype=2");
            ps.setString(1,stdid);
             ps.setInt(2,feehead);
            rs1=ps.executeQuery();
            if(rs1.next())
            {
                 head=feehead;
                amount=rs1.getDouble(3);
                ledgercode=ledcode;

      ps=con.prepareStatement("select * from studententry where id=? and status!=0");
        ps.setString(1,stdid);

        rs1=ps.executeQuery();
        while(rs1.next())
        {

    ps=con.prepareStatement("select * from feedues where groupid=1 and studentid=? and head=? and feetype=2 and session=?");

       // ps.setString(1, month);
        ps.setString(1, stdid);
         ps.setInt(2,head);
ps.setInt(3,sessionValue);
        rs2=ps.executeQuery();
        if(!rs2.next())
        {

                ps=con.prepareStatement("insert into feedues values(?,?,?,?,?,?,?,?,?)");
System.out.println("r7");
    ps.setString(1,rs1.getString(1));
   
    ps.setInt(2,head);
    ps.setDouble(3, amount);
    ps.setInt(4, Integer.parseInt(month1.get(month).toString()));
    ps.setString(5, datum);
     ps.setInt(6,1);
     ps.setInt(7,ledgercode);
     ps.setInt(8,2);
     ps.setInt(9,sessionValue);
  System.out.println("done");
ps.executeUpdate();
System.out.println("done");
//con.close();
}


        }
  ps = con.prepareStatement("select status from studententry where id=?");
        ps.setString(1,stdid);
        rs4 = ps.executeQuery();
if(rs4.next())
{
    int status=rs4.getInt(1);
    if(status==0)
    {
      confirmmsg.setForeground(Color.GREEN);
                                 confirmmsg.setText("Ex Student!");
     JOptionPane.showConfirmDialog(null,"Ex Student","Ex Student Prompt",JOptionPane.OK_CANCEL_OPTION);
      confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
}
}
            }
  }catch(Exception e)
            {
e.printStackTrace();
            }
        }
        public void insertParticularStudentAdmissionStructure(int head,Double amount,int ledgercode)
        {
   try
          {

      ps=con.prepareStatement("select * from studententry where id=? and status!=0");
        ps.setString(1,admissionnumber.getText());

        rs1=ps.executeQuery();
        while(rs1.next())
        {

    ps=con.prepareStatement("select * from feedues where  groupid=1 and studentid=? and head=? and feetype=1 and session=?");

        //ps.setString(1, jComboBox3.getSelectedItem().toString());
        ps.setString(1, admissionnumber.getText());
         ps.setInt(2,head);
ps.setInt(3,sessionValue);
        rs2=ps.executeQuery();
        if(!rs2.next())
        {

                ps=con.prepareStatement("insert into feedues values(?,?,?,?,?,?,?,?,?)");
System.out.println("r7");
    ps.setString(1,rs1.getString(1));
   
    ps.setInt(2,head);
    ps.setDouble(3, amount);
    ps.setInt(4, Integer.parseInt(month1.get(cmbMonth.getSelectedItem().toString()).toString()));
    ps.setString(5, datum);
     ps.setInt(6,1);
     ps.setInt(7,ledgercode);
     ps.setInt(8,1);
     ps.setInt(9,sessionValue);
  System.out.println("done");
ps.executeUpdate();
System.out.println("done");
confirmmsg.setForeground(Color.GREEN);
                                 confirmmsg.setText("Admission fee loaded!");
//con.close();
}

        }
    ps = con.prepareStatement("select status from studententry where id=?");
        ps.setString(1,admissionnumber.getText());
        rs4 = ps.executeQuery();
if(rs4.next())
{
    int status=rs4.getInt(1);
    if(status==0)
    {
        confirmmsg.setForeground(Color.GREEN);
                                 confirmmsg.setText("Ex Student!");
     JOptionPane.showConfirmDialog(null,"Ex Student","Ex Student Prompt",JOptionPane.OK_CANCEL_OPTION);
      confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
}}
   }catch(Exception e)
            {
e.printStackTrace();
            }
        }
public void insertParticularStudentAnnualStructure(String stdid,String month,int head,Double amount,int ledgercode)
        {
   try
          {

      ps=con.prepareStatement("select * from studententry where id=? and status!=0");
        ps.setString(1,stdid);

        rs1=ps.executeQuery();
        while(rs1.next())
        {

    ps=con.prepareStatement("select * from feedues where  groupid=1 and studentid=? and head=? and feetype=2 and session=?");

        //ps.setString(1, jComboBox3.getSelectedItem().toString());
        ps.setString(1, stdid);
         ps.setInt(2,head);
ps.setInt(3,sessionValue);
        rs2=ps.executeQuery();
        if(!rs2.next())
        {

                ps=con.prepareStatement("insert into feedues values(?,?,?,?,?,?,?,?,?)");
System.out.println("r7");
    ps.setString(1,rs1.getString(1));
  
    ps.setInt(2,head);
    ps.setDouble(3, amount);
    ps.setInt(4, Integer.parseInt(month1.get(month).toString()));
    ps.setString(5, datum);
     ps.setInt(6,1);
     ps.setInt(7,ledgercode);
     ps.setInt(8,2);
     ps.setInt(9,sessionValue);
  System.out.println("done");
ps.executeUpdate();
System.out.println("done");
//con.close();
}


        }
    ps = con.prepareStatement("select status from studententry where id=?");
        ps.setString(1,stdid);
        rs4 = ps.executeQuery();
if(rs4.next())
{
    int status=rs4.getInt(1);
    if(status==0)
    {
        confirmmsg.setForeground(Color.GREEN);
                                 confirmmsg.setText("Ex Student!");
     JOptionPane.showConfirmDialog(null,"Ex Student","Ex Student Prompt",JOptionPane.OK_CANCEL_OPTION);
      confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
}
}
   }catch(Exception e)
            {
e.printStackTrace();
            }
        }

        public void insertAllStudentStructure(int head,Double amount,int ledgercode,int month)
        {
           

          try
          {
                 ps=con.prepareStatement("select * from studententry where class=? and status!=0");
       
                 ps.setString(1, classmap1.get(jComboBox1.getSelectedItem().toString()).toString());

        rs1=ps.executeQuery();
        //System.out.println(jComboBox1.getSelectedItem().toString());

while(rs1.next())
{
    System.out.println("raviddddddd5555");
    ps=con.prepareStatement("select studentid,class,section,roll,head,dues,month,groupid,feetype from feedues left join studententry on studentid=id where  month=? and class=? and groupid=0 and studentid=? and head=? and feetype=0 and session=?");

        ps.setInt(1, month);
        ps.setInt(2, Integer.parseInt(classmap1.get(jComboBox1.getSelectedItem().toString()).toString()));
         ps.setString(3, rs1.getString(1));
         ps.setInt(4,head);
         ps.setInt(5,sessionValue);
 System.out.println("r1");
        rs2=ps.executeQuery();
        if(!rs2.next())
        {
      // if(!(amount==0  && monthlyfeemap.get(head).equals("Transport Fee")))//it prohibits the concessioned fee to be loaded into feedues
        {
          // if(!(month==6 && monthlyfeemap.get(head).equals("Transport Fee")) )  ///it will not dues the transport fee for the month of june
            {
                ps=con.prepareStatement("insert into feedues values(?,?,?,?,?,?,?,?,?)");
System.out.println("r7");
    ps.setString(1,rs1.getString(1));
    
    ps.setInt(2,head);
    ps.setDouble(3, amount);
    ps.setInt(4, month);
    ps.setString(5, datum);
     ps.setInt(6,0);
     ps.setInt(7,ledgercode);
     ps.setInt(8,0);
      ps.setInt(9,sessionValue);
  System.out.println("done");
ps.executeUpdate();
System.out.println("done");
 confirmmsg.setForeground(Color.GREEN);
                                 confirmmsg.setText("Class Monthly Fee loaded!");
            //JOptionPane.showConfirmDialog(null," Student fee loaded","fee loaded",JOptionPane.OK_OPTION);
//con.close();
}
       }
        }     }

          }catch(Exception e)
            {
e.printStackTrace();
            }
        }


         public void insertAllStudentMonthlyStructureForSchool(int stdclass,int head,Double amount,int ledgercode,int month)
        {


          try
          {
                 ps=con.prepareStatement("select * from studententry where class=? and status!=0");

                 ps.setInt(1,stdclass);

        rs1=ps.executeQuery();
        //System.out.println(jComboBox1.getSelectedItem().toString());

while(rs1.next())
{
    System.out.println("raviddddddd5555");
    ps=con.prepareStatement("select studentid,class,section,roll,head,dues,month,groupid,feetype from feedues left join studententry on studentid=id where  month=? and class=? and groupid=0 and studentid=? and head=? and feetype=0 and session=?");

        ps.setInt(1, month);
        ps.setInt(2,rs1.getInt(9));
         ps.setString(3, rs1.getString(1));
         ps.setInt(4,head);
         ps.setInt(5,sessionValue);
 System.out.println("r1");
        rs2=ps.executeQuery();
        if(!rs2.next())
        {
//if(!(amount==0  && monthlyfeemap.get(head).equals("Transport Fee"))) //it prohibits the concessioned fee to be loaded into feedues
{
   // if(!(month==6 && monthlyfeemap.get(head).equals("Transport Fee")) )  ///it will not dues the transport fee for the month of june
            {
                ps=con.prepareStatement("insert into feedues values(?,?,?,?,?,?,?,?,?)");
System.out.println("r7");
    ps.setString(1,rs1.getString(1));
 
    ps.setInt(2,head);
    ps.setDouble(3, amount);
    ps.setInt(4, month);
    ps.setString(5, datum);
     ps.setInt(6,0);
     ps.setInt(7,ledgercode);
     ps.setInt(8,0);
     ps.setInt(9,sessionValue);
  System.out.println("done");
ps.executeUpdate();
System.out.println("done");
 confirmmsg.setForeground(Color.GREEN);
                                 confirmmsg.setText("Institute Monthly Fee loaded!");
    }
}
        }    }

          }catch(Exception e)
            {
e.printStackTrace();
            }
        }

        
public void insertPeriodicStudentStructure(String stdclass,String month,int head,Double amount,int ledgercode)
        {


          try
          {
                 ps=con.prepareStatement("select * from studententry where class=? and status!=0");

                 ps.setInt(1, Integer.parseInt(classmap1.get(stdclass).toString()));

        rs1=ps.executeQuery();
       // System.out.println(jComboBox1.getSelectedItem().toString());

while(rs1.next())
{
    System.out.println("raviddddddd5555");
    ps=con.prepareStatement("select studentid,class,section,roll,head,dues,month,groupid,feetype from feedues left join studententry on studentid=id  where  month=? and class=? and groupid=0 and studentid=? and head=? and feetype=2 and session=?");

        ps.setInt(1, Integer.parseInt(month1.get(month).toString()));
        ps.setInt(2, Integer.parseInt(classmap1.get(stdclass).toString()));
         ps.setString(3, rs1.getString(1));
         ps.setInt(4,head);
         ps.setInt(5,sessionValue);
 System.out.println("r1");
        rs2=ps.executeQuery();
        if(!rs2.next())
        {

                ps=con.prepareStatement("insert into feedues values(?,?,?,?,?,?,?,?,?)");
System.out.println("r7");
    ps.setString(1,rs1.getString(1));
   
    ps.setInt(2,head);
    ps.setDouble(3, amount);
    ps.setInt(4,Integer.parseInt(month1.get(month).toString()));
    ps.setString(5, datum);
     ps.setInt(6,0);
     ps.setInt(7,ledgercode);
     ps.setInt(8,2);
     ps.setInt(9,sessionValue);
  System.out.println("done");
ps.executeUpdate();
System.out.println("done");

}
          }

          }catch(Exception e)
            {
e.printStackTrace();
            }
        }


        public void insertParticularStudentStructureFromAddStudent(int head,Double amount,String id,String doa,int ledgercode)
        {

             try
          {

      ps=con.prepareStatement("select * from studententry where id=?");
        ps.setString(1,id);

        rs1=ps.executeQuery();
        rs1.next();

    ps=con.prepareStatement("select studentid,class,section,roll,head,dues,month,groupid,feetype from feedues left join studententry on studentid=id  where groupid=1 and studentid=? and head=? and feetype=1 and session=?");

        //ps.setString(1,doa);
        ps.setString(1, id);
         ps.setInt(2,head);
ps.setInt(3,sessionValue);
        rs2=ps.executeQuery();
        if(!rs2.next())
        {

                ps=con.prepareStatement("insert into feedues values(?,?,?,?,?,?,?,?,?)");
System.out.println("r7");
    ps.setString(1,rs1.getString(1));
   
    ps.setInt(2,head);
    ps.setDouble(3, amount);
    ps.setInt(4, Integer.parseInt(month1.get(doa).toString()));
    ps.setString(5, datum);
     ps.setInt(6,1);
     ps.setInt(7,ledgercode);
     ps.setInt(8,1);
     ps.setInt(9,sessionValue);
  System.out.println("done");
ps.executeUpdate();
System.out.println("done");
//con.close();
}


          }catch(Exception e)
            {
e.printStackTrace();
            }
        }


        public void useSurplus()
{
           
    Double newsurplus=0.0,newsurplus1=0.0;
    Double setvalue=0.0;
    int currentrow=jTable1.getSelectedRow();
    // newsurplus=Double.parseDouble(totalsurplus.getText())-Double.parseDouble(dm.getValueAt(currentrow,5).toString());

    newsurplus=Double.parseDouble(dm.getValueAt(currentrow,3).toString())-Double.parseDouble(dm.getValueAt(currentrow,5).toString());

    if(newsurplus>=0)
      {
           newsurplus1=Double.parseDouble(totalsurplus.getText())-newsurplus;
          if(newsurplus1>0)
          {
         setvalue=newsurplus+Double.parseDouble(dm.getValueAt(currentrow,5).toString());
    dm.setValueAt(setvalue, currentrow, 5);
    // decreaseSurplus(newsurplus);
   remaining.setText(String.valueOf(Double.parseDouble(remaining.getText())-newsurplus));
      totalsurplus.setText(String.valueOf(newsurplus1));
      usedsurplustext.setText(String.valueOf(Double.parseDouble(usedsurplustext.getText())+newsurplus));
          }
    else {
          newsurplus1=0.0;

  setvalue=Double.parseDouble(totalsurplus.getText())+Double.parseDouble(dm.getValueAt(currentrow,5).toString());
    dm.setValueAt(setvalue, currentrow, 5);
    remaining.setText(String.valueOf(Double.parseDouble(remaining.getText())-Double.parseDouble(totalsurplus.getText())));
 //decreaseSurplus(newsurplus);
     usedsurplustext.setText(String.valueOf(Double.parseDouble(usedsurplustext.getText())+Double.parseDouble(totalsurplus.getText())));
 totalsurplus.setText(String.valueOf(newsurplus1));
 
      }
}
        }
public void decreaseSurplus(Double newsurplus)
{
     double surplus=0.0;
//con=com.duc.DatabaseConnection.DatabaseConnection.con;
try
{
    ps=con.prepareStatement("select * from studentsurplus where studentid=?");
    ps.setString(1,admissionnumber.getText());
    rs=ps.executeQuery();
  rs.next();
        //surplus=rs.getDouble(2);
        ps=con.prepareStatement("update studentsurplus set surplus=? where studentid=?");
        ps.setDouble(1,newsurplus);
        ps.setString(2,admissionnumber.getText());
        ps.executeUpdate();

       // con.close();

}catch(Exception e)
{
    e.printStackTrace();
}
}

public void decreaseTodaySurplus()
{
     double surplus=0.0,nettodaysurplus=0.0;
//con=com.duc.DatabaseConnection.DatabaseConnection.con;
try
{
    ps=con.prepareStatement("select * from studenttodaysurplus where studentid=? and date=?");
    ps.setString(1,admissionnumber.getText());
    ps.setString(2, datum );
    rs=ps.executeQuery();
  if(rs.next())
  {
        surplus=rs.getDouble(2);
        ps=con.prepareStatement("update studenttodaysurplus set surplus=? where studentid=? and date=?");
        nettodaysurplus=surplus-Double.parseDouble(usedsurplustext.getText());
        if(nettodaysurplus>0)
        ps.setDouble(1,nettodaysurplus);
        else ps.setDouble(1,0);
        ps.setString(2,admissionnumber.getText());
         ps.setString(3, datum );
        ps.executeUpdate();
  }
       // con.close();

}catch(Exception e)
{
    e.printStackTrace();
}
}

public void usedSurplusDateWise()
{
    double surplus=0.0;
            String id;
//con=com.duc.DatabaseConnection.DatabaseConnection.con;
try
{
    ps=con.prepareStatement("select * from studentusedsurplus where studentid=? and date=?");
    ps.setString(1,admissionnumber.getText());
    ps.setString(2, datum);

    rs=ps.executeQuery();

    if(!rs.next())
    {
        if(Double.parseDouble(usedsurplustext.getText())>0)
        {
           ps=con.prepareStatement("select * from studenttodaysurplus where date=?");
           ps.setString(1, datum);
           rs=ps.executeQuery();
           if(!rs.next())
           {      
    ps.setString(1,admissionnumber.getText());

    ps=con.prepareStatement("insert into studentusedsurplus  values(?,?,?)");
    ps.setString(1,admissionnumber.getText());
   // ps.setDouble(2,Double.parseDouble(totalsurplus.getText()));
    ps.setDouble(2,Double.parseDouble(usedsurplustext.getText()));

    ps.setString(3, datum);

    ps.executeUpdate();
           }
       }
    } else
    {
        surplus=rs.getDouble(2);
        
        ps=con.prepareStatement("update studentusedsurplus  set surplus=? where studentid=? and date=?");
        ps.setDouble(1,surplus+Double.parseDouble(usedsurplustext.getText()));
        ps.setString(2,admissionnumber.getText());
         ps.setString(3, datum);
        ps.executeUpdate();
    
    }
//con.close();
    }catch(Exception e)
{
    e.printStackTrace();
}
      System.out.println("ravi");


}

        public void loadLumpsumpAmount()
        {
            int i=0;
            Double total=0.0;

         //  if()
            for(i=0;i<dm.getRowCount();i++)
            {
if(Double.parseDouble(dm.getValueAt(i,3).toString())>0)
{
    Double diff=Double.parseDouble(dm.getValueAt(i, 3).toString())-Double.parseDouble(dm.getValueAt(i, 5).toString());
    if(diff>0)
                dm.setValueAt(Double.parseDouble(dm.getValueAt(i,5).toString())+diff, i, 5);
    total=total+diff;
}


            }

           
            Double remain=Double.parseDouble(remaining.getText())-total;
            remaining.setText(remain.toString());
        }

 public void deLoadLumpsumpAmount()
        {
            int i=0;

         //  if()
            for(i=0;i<dm.getRowCount();i++)
            {
if(Double.parseDouble(dm.getValueAt(i,3).toString())>0)
                dm.setValueAt(0, i, 5);



            }

             remaining.setText(totaldues.getText());
             loadSurplus();
             usedsurplustext.setText(String.valueOf(0));
             collected.setText(String.valueOf(0));

        }
        public void updateDuesOnPayment()
        {
            int feeid=0,feetype1=0,groupid1=0;
            int i=0;double dues=0.0;
            //con=com.duc.DatabaseConnection.DatabaseConnection.con;
            for(i=0;i<dm.getRowCount();i++)
            {
if(Double.parseDouble(dm.getValueAt(i,5).toString())!=0)
{

                try
                {

                     
                                   System.out.println("11111111111111");

                                    ps=con.prepareStatement("select * from admissionfeehead where head=?");
                                   ps.setString(1,dm.getValueAt(i,2).toString());
                                   rs=ps.executeQuery();
                                   if(rs.next())
                                   {
                                       feeid=rs.getInt(1);
                                       feetype1=1;
                                       groupid1=1;
                                   }
System.out.println("111111111111112222222222222222");
                                    ps=con.prepareStatement("select * from periodicfeehead where head=?");
                                   ps.setString(1,dm.getValueAt(i,2).toString());
                                   rs=ps.executeQuery();
                                   if(rs.next())
                                   {
                                       feeid=rs.getInt(1);
                                       feetype1=2;
                                       if(rs.getInt(3)==1)
                                           groupid1=1;
                                       else
                                       groupid1=0;
                                   }
System.out.println("1111111111111133333333333333");
                                    ps=con.prepareStatement("select * from ledgerotherfeeheadcode where feehead=?");
                                   ps.setString(1,dm.getValueAt(i,2).toString());
                                   rs=ps.executeQuery();
                                   if(rs.next())
                                   {
                                       feeid=rs.getInt(3);
                                       feetype1=3;
                                       groupid1=0;
                                   }
System.out.println("1111111111111144444444444444");

ps=con.prepareStatement("select * from monthlyfeehead where head=?");
                                   ps.setString(1,dm.getValueAt(i,2).toString());
                                   rs=ps.executeQuery();
                                   if(rs.next())
                                   {
                                       feeid=rs.getInt(1);
                                       feetype1=0;
                                       groupid1=0;
                                   }

                                   ps=con.prepareStatement("select * from inventorydeposit left join invclasswise on InventoryId=invid where invname=? and classid=?");
                                   ps.setString(1,dm.getValueAt(i,2).toString());
                                   ps.setInt(2,Integer.parseInt(classmap1.get(jComboBox1.getSelectedItem().toString()).toString()));
                                   rs=ps.executeQuery();
                                   if(rs.next())
                                   {
                                       groupid1=rs.getInt(1);
                                       ps=con.prepareStatement("select * from ledgerotherfeeheadcode where feehead=?");
                                   ps.setString(1,"Inventory Purchase");
                                   rs=ps.executeQuery();
                                   if(rs.next())
                                   {
                                       feeid=rs.getInt(3);
                                       feetype1=3;
                                   }

                                   }
                   //
                    ps=con.prepareStatement("update feedues set dues=? where studentid=? and head=? and month=? and feetype=? and groupid=? and session=?");
                    //if(dues>0.0)
                    ps.setDouble(1, Double.parseDouble(dm.getValueAt(i,3).toString()));
                    //else ps.setDouble(1,0.0);
                    ps.setString(2,dm.getValueAt(i,0).toString());

                     ps.setInt(3,feeid);
                      ps.setInt(4,Integer.parseInt(month1.get(dm.getValueAt(i,4).toString()).toString()));
                      ps.setInt(5,feetype1);
                      ps.setInt(6, groupid1);
                      ps.setInt(7,sessionValue);
                      ps.executeUpdate();

                      System.out.println(dues);


                }catch(Exception e)
                {
                    System.out.print("Erorrrrrrrreeeeeeeeee");
                   e.printStackTrace();
                }
            }
            }
        }
        public void insertIntoFeePaid()
        {
            int feeid=0,feetype1=0,groupid1=0;
            //con=com.duc.DatabaseConnection.DatabaseConnection.con;
            int i=0;
            try
            {

                 for(i=0;i<dm.getRowCount();i++)
            {
if(Double.parseDouble(dm.getValueAt(i,5).toString())!=0)
{
     ps=con.prepareStatement("select * from monthlyfeehead where head=?");
                                   ps.setString(1,dm.getValueAt(i,2).toString());
                                   rs=ps.executeQuery();
                                   if(rs.next())
                                   {
                                       feeid=rs.getInt(1);
                                       feetype1=0;
                                       System.out.println("ffffffffffffffff");
                                       groupid1=0;
                                   }

                                  ps=con.prepareStatement("select * from admissionfeehead where head=?");
                                   ps.setString(1,dm.getValueAt(i,2).toString());
                                   rs=ps.executeQuery();
                                   if(rs.next())
                                   {
                                       feeid=rs.getInt(1);
                                       feetype1=1;
                                       System.out.println("in admission");
                                       groupid1=1;
                                   }

                                    ps=con.prepareStatement("select * from periodicfeehead where head=?");
                                   ps.setString(1,dm.getValueAt(i,2).toString());
                                   rs=ps.executeQuery();
                                   if(rs.next())
                                   {
                                       feeid=rs.getInt(1);
                                       feetype1=2;
                                       System.out.println("in periodic");
                                       if(rs.getInt(3)==1)
                                       groupid1=1;
                                       else
                                           groupid1=0;
                                   }

                                    ps=con.prepareStatement("select * from ledgerotherfeeheadcode where feehead=?");
                                   ps.setString(1,dm.getValueAt(i,2).toString());
                                   rs=ps.executeQuery();
                                   if(rs.next())
                                   {
                                       feeid=rs.getInt(3);
                                       feetype1=3;
                                       System.out.println("in Ledger");
                                       groupid1=0;
                                   }

                                   ps=con.prepareStatement("select * from inventorydeposit left join invclasswise on InventoryId=invid where invname=? and classid=?");
                                   ps.setString(1,dm.getValueAt(i,2).toString());
                                  ps.setInt(2,Integer.parseInt(classmap1.get(jComboBox1.getSelectedItem().toString()).toString()));
                                   
                                   rs=ps.executeQuery();
                                   if(rs.next())
                                   {
                                       groupid1=rs.getInt(1);
                                       ps=con.prepareStatement("select * from ledgerotherfeeheadcode where feehead=?");
                                   ps.setString(1,"Inventory Purchase");
                                   rs=ps.executeQuery();
                                   if(rs.next())
                                   {
                                       feeid=rs.getInt(3);
                                       feetype1=3;
                                       System.out.println("in Ledger11");
                                   }
                                       //feeid=rs.getInt(3);
                                       //feetype1=3;
                                       //System.out.println("in Ledger");
                                   }

    ps=con.prepareStatement("select * from feedues where studentid=? and head=? and month=? and feetype=? and session=? and groupid=?");
     ps.setString(1,dm.getValueAt(i,0).toString());
      ps.setInt(2,feeid);
      ps.setInt(3,Integer.parseInt(month1.get(dm.getValueAt(i,4).toString()).toString()));
      ps.setInt(4,feetype1);
      ps.setInt(5,Integer.parseInt(sessionmap1.get(dm.getValueAt(i,1).toString()).toString()));
      ps.setInt(6,groupid1);
      rs=ps.executeQuery();
      rs.next();
      int ledcode=rs.getInt(7);

  /*    ps=con.prepareStatement("select * from feepaid where studentid=? and head=? and month=? and feetype=? and session=?");
      ps.setString(1,dm.getValueAt(i,0).toString());
      ps.setInt(2,feeid);
      ps.setInt(3,Integer.parseInt(month1.get(dm.getValueAt(i,4).toString()).toString()));
      ps.setInt(4,feetype1);
      ps.setInt(5,Integer.parseInt(sessionmap1.get(dm.getValueAt(i,1).toString()).toString()));
      rs=ps.executeQuery();
      if(!rs.next())*/
      {
     // int ledcode=rs.getInt(7);
                ps=con.prepareStatement("insert into feepaid values(?,?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1,dm.getValueAt(i,0).toString());
              
                 System.out.println("r2");
                //ps.setInt(4,Integer.parseInt(dm.getValueAt(i,3).toString()));
                ps.setInt(2,feeid);
                ps.setDouble(3,Double.parseDouble(dm.getValueAt(i,3).toString()));
                ps.setInt(4,Integer.parseInt(month1.get(dm.getValueAt(i,4).toString()).toString()));
                 System.out.println("r3");
                ps.setDouble(5,Double.parseDouble(dm.getValueAt(i,5).toString()));
                 ps.setString(6, datum);
                 Double duespaiddiff=Double.parseDouble(dm.getValueAt(i,3).toString())-Double.parseDouble(dm.getValueAt(i,5).toString());
                 if(duespaiddiff<0)
                 ps.setDouble(7,0);
                 else
                     ps.setDouble(7,duespaiddiff);
                 ps.setInt(8, ledcode);
                 ps.setInt(9,feetype1);
                 ps.setInt(10,Integer.parseInt(sessionmap1.get(dm.getValueAt(i,1)).toString()));
                 ps.setInt(11,groupid1);
                ps.executeUpdate();


}
}
                 }
            }

            catch(Exception e)
            {
//e.printStackTrace();
System.out.print("Erorrrrrrrreeeeeeeeeehhhhhhhhhhhhhhhhhh");
                   e.printStackTrace();
            }
        }
        public void insertIntoSurplus()
        {
            double surplus=0.0;
            String id;
//con=com.duc.DatabaseConnection.DatabaseConnection.con;
try
{
    ps=con.prepareStatement("select * from studentsurplus where studentid=?");
    ps.setString(1,admissionnumber.getText());
    rs=ps.executeQuery();

    if(!rs.next())
    {
        if(Double.parseDouble(totalsurplus.getText())>0)
        {
    ps=con.prepareStatement("insert into studentsurplus values(?,?,?,?)");
    ps.setString(1,admissionnumber.getText());
   
     ps.setDouble(2,Double.parseDouble(totalsurplus.getText()));
    ps.setString(3, datum);
ps.setInt(4,0);//ledgercode
    ps.executeUpdate();
        }
    } else
    {
        surplus=rs.getDouble(2);
        ps=con.prepareStatement("update studentsurplus set surplus=? where studentid=?");
    
        ps.setDouble(1,Double.parseDouble(totalsurplus.getText()));
        ps.setString(2,admissionnumber.getText());
        ps.executeUpdate();
    }
//con.close();
    }catch(Exception e)
{
    e.printStackTrace();
}
      System.out.println("ravi");  }

        public void insertIntoTodaySurplus(Double todaysurplus)
        {
            double surplus=0.0;
            String id;
//con=com.duc.DatabaseConnection.DatabaseConnection.con;
try
{
    ps=con.prepareStatement("select * from studentsurplus where studentid=? and date=?");
    ps.setString(1,admissionnumber.getText());
    ps.setString(2,datum);
    rs=ps.executeQuery();

    if(!rs.next())
    {
        System.out.println("fgggggggggggggggggggggggjjjjjj");
    ps=con.prepareStatement("insert into studentsurplus values(?,?,?,?)");
    ps.setString(1,admissionnumber.getText());
    ps.setDouble(2,todaysurplus);
    ps.setString(3, datum);
    ps.setInt(4,0);//ledgercode

    ps.executeUpdate();

    } else
    {
        surplus=rs.getDouble(2);
        ps=con.prepareStatement("update studentsurplus set surplus=? where studentid=?");
        ps.setDouble(1,Double.parseDouble(totalsurplus.getText()));
        ps.setString(2,admissionnumber.getText());
        ps.executeUpdate();
    }
//con.close();
    }catch(Exception e)
{
    e.printStackTrace();
}
      System.out.println("ravi");  }

   public void showAllStudentDetail()
   {
       confirmmsg.setForeground(Color.GREEN);
                                 confirmmsg.setText("----Confirmation----");
     
         int i=0,j=0;

     try
     {
       ps=con.prepareStatement("select studentid,class,section,roll,head,dues,month,feetype,session from feedues left join studententry on studentid=id where dues!=0 and session=? order by studentid") ;
ps.setInt(1,sessionValue);
       rs=ps.executeQuery();
      studentDetail(rs);

 // con.close();
     }catch(Exception e)
   {
e.printStackTrace();
   }
   }


    public void studentDetailOnBasisOfId()
{
        try
     {
         //if(Double.parseDouble(dm.getValueAt(i,5).toString())!=0)
       ps=con.prepareStatement("select studentid,class,section,roll,head,dues,month,feetype,session,groupid from feedues left join studententry on studentid=id where studentid=? and dues!=0");
      ps.setString(1,admissionnumber.getText());
         //ps.setInt(2,id);
      System.out.println("n");
       rs=ps.executeQuery();
if(rs.next())
{
      rs.previous();
      studentDetail(rs);

}

           else
           {
           ps=con.prepareStatement("select studentid,class,section,roll,head,dues,month,feetype,session from feedues left join studententry on studentid=id where studentid=? and dues=0");
      ps.setString(1,admissionnumber.getText());
         //ps.setInt(2,id);
      System.out.println("n");
       rs=ps.executeQuery();
       if(rs.next())
       {
           confirmmsg.setForeground(Color.GREEN);
                               confirmmsg.setText("Fee Record Present");
         //  JOptionPane.showConfirmDialog(null,"Fee Record Present","Fee Record Present",JOptionPane.OK_CANCEL_OPTION);
            // confirmmsg.setForeground(Color.GREEN);
               // confirmmsg.setText("--------------------------Confirmation----------------------");

           }
       else
       {
           confirmmsg.setForeground(Color.GREEN);
                                 confirmmsg.setText("No Fee Record");
          // JOptionPane.showConfirmDialog(null,"No Fee Record","No Fee Record",JOptionPane.OK_CANCEL_OPTION);
            // confirmmsg.setForeground(Color.GREEN);
               // confirmmsg.setText("--------------------------Confirmation----------------------");
       }
         loadBlankFeeTable();
           }
}

   catch(Exception e)
   {
e.printStackTrace();
   }
         showSurplus();

}

    public void showSurplus()
    {
        //con=com.duc.DatabaseConnection.DatabaseConnection.con;
        try
        {
             ps=con.prepareStatement("select * from studentsurplus where studentid=?");
    ps.setString(1,admissionnumber.getText());
    rs=ps.executeQuery();
    if(rs.next())
    totalsurplus.setText(String.valueOf(rs.getDouble(2)));
    else totalsurplus.setText(String.valueOf(0));

        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }
public void getStudentName()
{
    int counts,ind=0;
    try
    {
      ps = con.prepareStatement("select * from studententry where id=?");
ps.setString(1,admissionnumber.getText());
             rs = ps.executeQuery();
if(rs.next()==false)
{
    confirmmsg.setForeground(Color.GREEN);
                                 confirmmsg.setText("Invalid Student");
             JOptionPane.showConfirmDialog(null,"Invalid Student","Invalid Student",JOptionPane.OK_CANCEL_OPTION);
 //confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
}//rs.next();
else
{
    
jTextField1.setText(rs.getString(2));
jComboBox1.setSelectedItem(classmap.get(rs.getInt(9)));
/*
counts=jComboBox2.getItemCount();
String section=sectionmap.get(rs.getInt(10)).toString();
  for( int i=0;i<=counts-1;i++)
                    {
                        if(jComboBox2.getItemAt(i).equals(section))
                             ind = i;
                    }
                     jComboBox2.setSelectedIndex(ind);
//ind=0;
                     counts=jComboBox4.getItemCount();
int roll=rs.getInt(11);
  for( int i=0;i<=counts-1;i++)
                    {
                        if(jComboBox4.getItemAt(i).equals(roll))
                             ind= i;
                    }
                     jComboBox4.setSelectedIndex(ind);
*/
}

  //con.close();
      }
    catch(Exception e)
    {
        System.err.println("Error is"+e);
    }

}

public void setAdmissionNo(String id)
{
    admissionnumber.setText(id);
    int keycode=KeyEvent.VK_ENTER;
if(keycode==KeyEvent.VK_ENTER)
{
     if(!admissionnumber.getText().isEmpty())
{
    getStudentName();
         studentDetailOnBasisOfId();

int r=matchIdForCustomizedStudent(admissionnumber.getText());

}
}
}

public void setAdmissionNoForStatement(String id)
{
    admissionnumber.setText(id);
    StatementPrint();
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField admissionnumber;
    private javax.swing.JTextField amt;
    private javax.swing.JTextField bankdetail;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JRadioButton cashCheck;
    private javax.swing.JRadioButton chequeCheck;
    private javax.swing.JTextField chequeddnumber;
    private javax.swing.JRadioButton classadmissionfee;
    private javax.swing.JRadioButton classmonthlyfee;
    private javax.swing.JRadioButton classperiodicfee;
    private javax.swing.JComboBox cmbMonth;
    private javax.swing.JTextField collected;
    private javax.swing.JLabel confirmmsg;
    private javax.swing.JRadioButton ddCheck;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTable jXTable1;
    private javax.swing.JCheckBox mini;
    private javax.swing.JTextField remaining;
    private javax.swing.JRadioButton studentadmissionfee;
    private javax.swing.JRadioButton studentmonthlyfee;
    private javax.swing.JRadioButton studentperiodicfee;
    private javax.swing.JTextField totaldues;
    private javax.swing.JTextField totalsurplus;
    private javax.swing.JTextField usedsurplustext;
    // End of variables declaration//GEN-END:variables

ResultSet rs,rs1,rs2,rs3,rs4,rs5;
PreparedStatement ps,ps1;
static int change=-1;static int head;Double amount;int ledgercode;
static Double advance=0.0;
static int click=0;
static int click1=0;
static int count=0,count1=0;
static Double waivestudent=0.0,extrawaiver=0.0;
static int currentrow=0;
int receipt_no=0;
String s=null;
Double surplus=0.0;
static String waiverhead="",waiverPaid="",waiverMonth="",waiverDues=" ";
Double todaysurplus=0.0,surplus1=0.0,payamount1=0.0;
public Integer sessionValue=0,sessionval=0;
String reason="";
//Double waiverDues=0.0;
//public String date=null;
}
