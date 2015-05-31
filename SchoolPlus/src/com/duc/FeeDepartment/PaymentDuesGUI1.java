/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PaymentDuesGUI1.java
 *
 * Created on Sep 26, 2009, 5:02:04 PM
 */

package com.duc.FeeDepartment;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import com.duc.ImportSection.*;
import java.io.File;
import java.net.InetAddress;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable.PrintMode;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import static com.duc.DatabaseConnection.DatabaseConnection.*;

/**
 *
 * @author Ravi Dangaich
 */
public class PaymentDuesGUI1 extends javax.swing.JInternalFrame {
DefaultTableModel dm;
//DateFormat df;
//MapForIndex mp=new MapForIndex();

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

    /** Creates new form PaymentDuesGUI1 */
    public PaymentDuesGUI1() {
        initComponents();
        pack();
        System.out.println("con of paymentDuesGUI1="+con);
         
        dm = (DefaultTableModel) jTable1.getModel();
        dm.setRowCount(0);
      //  df=new SimpleDateFormat("yyyy-MM-dd");
         datefrom.setDateFormat(df);
          dateto.setDateFormat(df);
        
     
        fromClass();
         fromFeeDuesHead();
         fromFeePaidHead();
         fromSession();

        
    }


      
     public void fromClass()
    {
         try
    {
      ps = con.prepareStatement("select * from classsetup");

             rs = ps.executeQuery();


            while (rs.next())
            {
        classDuesCombo.addItem(rs.getString(1));
         classPaymentCombo.addItem(rs.getString(1));


            }
 // con.close();
         }
    catch(Exception e)
    {
        System.err.println("Error is"+e);
    }

    }

    public void fromSection()
    {
        try
    {
        ps = con.prepareStatement("select * from sectionsetuplist");

             rs = ps.executeQuery();


            while (rs.next())
            {
        sectionDuesCombo.addItem(rs.getString(1));
        sectionpaymentCombo.addItem(rs.getString(1));


            }
 //con.close();
        }
    catch(Exception e)
    {
        System.err.println("Error is"+e);
    }


    }


    public void fromFeeDuesHead()
    {
         try
    {

         ps = con.prepareStatement("select distinct head from feedues where feetype=0");

             rs = ps.executeQuery();


            while (rs.next())
            {

         feeHeadDuesCombo.addItem(monthlyfeemap.get(rs.getInt(1)));
       
            }

             ps = con.prepareStatement("select distinct head from feedues where feetype=1");

             rs = ps.executeQuery();


            while (rs.next())
            {

         feeHeadDuesCombo.addItem(admissionfeemap.get(rs.getInt(1)));

            }

              ps = con.prepareStatement("select distinct head from feedues where feetype=2");

             rs = ps.executeQuery();


            while (rs.next())
            {

         feeHeadDuesCombo.addItem(periodicfeemap.get(rs.getInt(1)));

            }

              ps = con.prepareStatement("select distinct head from feedues where feetype=3");

             rs = ps.executeQuery();


            while (rs.next())
            {

         feeHeadDuesCombo.addItem(otherfeemap.get(rs.getInt(1)));

            }

 // con.close();
         }
    catch(Exception e)
    {
        System.err.println("Error is"+e);
    }

    }
public void fromFeePaidHead()
    {
         try
    {
      ps = con.prepareStatement("select distinct head from feepaid where feetype=0");

             rs = ps.executeQuery();


            while (rs.next())
            {

         feeHeadPaymentCombo.addItem(monthlyfeemap.get(rs.getInt(1)));
         
            }

             ps = con.prepareStatement("select distinct head from feepaid where feetype=1");

             rs = ps.executeQuery();


            while (rs.next())
            {

         feeHeadPaymentCombo.addItem(admissionfeemap.get(rs.getInt(1)));

            }

              ps = con.prepareStatement("select distinct head from feepaid where feetype=2");

             rs = ps.executeQuery();


            while (rs.next())
            {

         feeHeadPaymentCombo.addItem(periodicfeemap.get(rs.getInt(1)));

            }

              ps = con.prepareStatement("select distinct head from feepaid where feetype=3");

             rs = ps.executeQuery();


            while (rs.next())
            {

         feeHeadPaymentCombo.addItem(otherfeemap.get(rs.getInt(1)));

            }

 // con.close();
         }
    catch(Exception e)
    {
        System.err.println("Error is"+e);
    }

    }

public void classFilter()
    {
           //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        try
        {
            ps = con.prepareStatement("select *from sectionsetup where classtitle=?");
            ps.setInt(1, Integer.parseInt(classmap1.get(classDuesCombo.getSelectedItem().toString()).toString()));
             rs = ps.executeQuery();
            int i = 0,j=0;

sectionDuesCombo.removeAllItems();

            while(rs.next())
            {

                sectionDuesCombo.addItem(sectionmap.get(rs.getInt(2)));

            }

//con.close();
             }  catch(Exception e)
        {
            e.printStackTrace();
        }


    }
public void sectionFilter()
    {
         int i = 0,j=0;  //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        try
        {
            ps = con.prepareStatement("select *from studententry where class =? and section=?");
            ps.setInt(1, Integer.parseInt(classmap1.get(classDuesCombo.getSelectedItem().toString()).toString()));
            ps.setInt(2, Integer.parseInt(sectionmap1.get(sectionDuesCombo.getSelectedItem().toString()).toString()));
             rs = ps.executeQuery();


rollDuesCombo.removeAllItems();

            while(rs.next())
            {

                rollDuesCombo.addItem(rs.getString(11));
                i++;

            }

//con.close();
             }  catch(Exception e)
        {
            e.printStackTrace();
        }


    }
public void classStudentFilter()
{
    //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        try
        {
            ps = con.prepareStatement("select *from studententry where class =?");
            ps.setInt(1, Integer.parseInt(classmap1.get(classDuesCombo.getSelectedItem().toString()).toString()));
           // ps.setString(2, jComboBox2.getSelectedItem().toString());
             rs = ps.executeQuery();
            int i = 0,j=0;

rollDuesCombo.removeAllItems();

            while(rs.next())
            {

                rollDuesCombo.addItem(rs.getString(11));

            }

//con.close();
             }  catch(Exception e)
        {
            e.printStackTrace();
        }


}


public void classFilterForPayment()
    {
          // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        try
        {
            ps = con.prepareStatement("select * from sectionsetup where classtitle=?");
            ps.setInt(1, Integer.parseInt(classmap1.get(classPaymentCombo.getSelectedItem().toString()).toString()));
             rs = ps.executeQuery();
            int i = 0,j=0;

sectionpaymentCombo.removeAllItems();

            while(rs.next())
            {

                sectionpaymentCombo.addItem(sectionmap.get(rs.getInt(2)));

            }

//con.close();
           }  catch(Exception e)
        {
            e.printStackTrace();
        }


    }
public void sectionFilterForPayment()
    {
         int i = 0,j=0;
         //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        try
        {
            ps = con.prepareStatement("select *from studententry where class =? and section=?");
            ps.setInt(1, Integer.parseInt(classmap1.get(classPaymentCombo.getSelectedItem().toString()).toString()));
            ps.setInt(2, Integer.parseInt(sectionmap1.get(sectionpaymentCombo.getSelectedItem().toString()).toString()));
             rs = ps.executeQuery();


rollPaymentCombo.removeAllItems();

            while(rs.next())
            {

                rollPaymentCombo.addItem(rs.getString(11));
                i++;

            }

//con.close();
           }  catch(Exception e)
        {
            e.printStackTrace();
        }


    }
public void classStudentFilterForPayment()
{
    //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        try
        {
            ps = con.prepareStatement("select *from studententry where class =?");
            ps.setInt(1, Integer.parseInt(classmap1.get(classPaymentCombo.getSelectedItem().toString()).toString()));
           // ps.setString(2, jComboBox2.getSelectedItem().toString());
             rs = ps.executeQuery();
            int i = 0,j=0;

rollPaymentCombo.removeAllItems();

            while(rs.next())
            {

                rollPaymentCombo.addItem(rs.getString(11));

            }

        }  catch(Exception e)
        {
            e.printStackTrace();
        }


}

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        admissionnoDues = new javax.swing.JTextField();
        classDuesCombo = new javax.swing.JComboBox();
        sectionDuesCombo = new javax.swing.JComboBox();
        rollDuesCombo = new javax.swing.JComboBox();
        feeHeadDuesCombo = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        showAllDues = new javax.swing.JButton();
        totalDuesButton = new javax.swing.JButton();
        sessionCombo = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        datefrom = new datechooser.beans.DateChooserCombo();
        dateto = new datechooser.beans.DateChooserCombo();
        allpaymentsButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jPanel5 = new javax.swing.JPanel();
        admissionnoPayment = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        rollPaymentCombo = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        classPaymentCombo = new javax.swing.JComboBox();
        sectionpaymentCombo = new javax.swing.JComboBox();
        feeHeadPaymentCombo = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        showAllPayment = new javax.swing.JButton();
        netBalanceButton = new javax.swing.JButton();
        sessionCombo1 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        totalpaid = new javax.swing.JLabel();
        totaldues = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        exitButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Payment-Dues Display");

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setText("Admission No.");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("Class");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setText("Section");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setText("Roll No.");

        admissionnoDues.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                admissionnoDuesKeyPressed(evt);
            }
        });

        classDuesCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        classDuesCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classDuesComboActionPerformed(evt);
            }
        });

        sectionDuesCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        sectionDuesCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sectionDuesComboMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sectionDuesComboMouseEntered(evt);
            }
        });

        rollDuesCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        rollDuesCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rollDuesComboMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rollDuesComboMouseEntered(evt);
            }
        });

        feeHeadDuesCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        feeHeadDuesCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feeHeadDuesComboActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel17.setText("Fee Head");

        showAllDues.setFont(new java.awt.Font("Tahoma", 1, 12));
        showAllDues.setForeground(new java.awt.Color(0, 0, 255));
        showAllDues.setText("ShowAll");
        showAllDues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllDuesActionPerformed(evt);
            }
        });

        totalDuesButton.setFont(new java.awt.Font("Tahoma", 1, 12));
        totalDuesButton.setForeground(new java.awt.Color(0, 0, 255));
        totalDuesButton.setText("Total Dues");
        totalDuesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalDuesButtonActionPerformed(evt);
            }
        });

        sessionCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choose" }));
        sessionCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sessionComboActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel7.setText("Session");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                                .addGap(18, 18, 18))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(classDuesCombo, javax.swing.GroupLayout.Alignment.TRAILING, 0, 139, Short.MAX_VALUE)
                            .addComponent(sectionDuesCombo, javax.swing.GroupLayout.Alignment.TRAILING, 0, 139, Short.MAX_VALUE)
                            .addComponent(admissionnoDues, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(rollDuesCombo, 0, 81, Short.MAX_VALUE)
                        .addGap(77, 77, 77))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sessionCombo, javax.swing.GroupLayout.Alignment.TRAILING, 0, 137, Short.MAX_VALUE)
                            .addComponent(feeHeadDuesCombo, 0, 137, Short.MAX_VALUE))
                        .addGap(19, 19, 19))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(showAllDues, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(totalDuesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(admissionnoDues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(classDuesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(sectionDuesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rollDuesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(feeHeadDuesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sessionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showAllDues)
                    .addComponent(totalDuesButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel6.setText("Date To");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel5.setText("Date From");

        allpaymentsButton.setFont(new java.awt.Font("Tahoma", 1, 12));
        allpaymentsButton.setForeground(new java.awt.Color(0, 0, 255));
        allpaymentsButton.setText("All Payments(Date-Wise)");
        allpaymentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allpaymentsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(datefrom, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(allpaymentsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(dateto, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(datefrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(dateto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(allpaymentsButton)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Admission No.", "Name", "Class", "Section", "Roll", "Fee Head", "Dues", "Month", "Paid", "Last Updated"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("Total");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel10.setForeground(new java.awt.Color(204, 0, 0));
        jLabel10.setText("Total");

        jTextPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jTextPane1.setText("                                                                  Payments and Dues Section");
        jScrollPane2.setViewportView(jTextPane1);

        jTextPane3.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane3.setEditable(false);
        jTextPane3.setText("View Payments and Dues Details for a particular student and the class with all the related fee heads.");
        jScrollPane4.setViewportView(jTextPane3);

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));

        admissionnoPayment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                admissionnoPaymentKeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel11.setText("Admission No.");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel13.setText("Section");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel12.setText("Class");

        rollPaymentCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        rollPaymentCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rollPaymentComboMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rollPaymentComboMouseEntered(evt);
            }
        });
        rollPaymentCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollPaymentComboActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel14.setText("Roll No.");

        classPaymentCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        classPaymentCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classPaymentComboActionPerformed(evt);
            }
        });

        sectionpaymentCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        sectionpaymentCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sectionpaymentComboMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sectionpaymentComboMouseEntered(evt);
            }
        });
        sectionpaymentCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sectionpaymentComboActionPerformed(evt);
            }
        });

        feeHeadPaymentCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        feeHeadPaymentCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feeHeadPaymentComboActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel18.setText("Fee Head");

        showAllPayment.setFont(new java.awt.Font("Tahoma", 1, 12));
        showAllPayment.setForeground(new java.awt.Color(0, 0, 255));
        showAllPayment.setText("ShowAll");
        showAllPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllPaymentActionPerformed(evt);
            }
        });

        netBalanceButton.setFont(new java.awt.Font("Tahoma", 1, 12));
        netBalanceButton.setForeground(new java.awt.Color(0, 0, 255));
        netBalanceButton.setText("Net Balance");
        netBalanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                netBalanceButtonActionPerformed(evt);
            }
        });

        sessionCombo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choose" }));
        sessionCombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sessionCombo1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel8.setText("Session");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                    .addGap(27, 27, 27))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(29, 29, 29)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(sessionCombo1, 0, 137, Short.MAX_VALUE)
                                .addGap(23, 23, 23))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sectionpaymentCombo, 0, 137, Short.MAX_VALUE)
                                    .addComponent(classPaymentCombo, javax.swing.GroupLayout.Alignment.TRAILING, 0, 137, Short.MAX_VALUE)
                                    .addComponent(feeHeadPaymentCombo, 0, 137, Short.MAX_VALUE)
                                    .addComponent(admissionnoPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(rollPaymentCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(showAllPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(netBalanceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(55, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(admissionnoPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classPaymentCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sectionpaymentCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(rollPaymentCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(feeHeadPaymentCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sessionCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showAllPayment)
                    .addComponent(netBalanceButton))
                .addGap(23, 23, 23))
        );

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel15.setForeground(new java.awt.Color(51, 0, 51));
        jLabel15.setText(" Dues Section");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel16.setForeground(new java.awt.Color(51, 0, 51));
        jLabel16.setText("   Payment Section");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel19.setForeground(new java.awt.Color(51, 0, 51));
        jLabel19.setText("Date Wise payments");

        totalpaid.setFont(new java.awt.Font("Tahoma", 1, 12));
        totalpaid.setText("0.0");

        totaldues.setFont(new java.awt.Font("Tahoma", 1, 12));
        totaldues.setText("0.0");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton1.setForeground(new java.awt.Color(0, 0, 255));
        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        exitButton1.setFont(new java.awt.Font("Tahoma", 1, 12));
        exitButton1.setForeground(new java.awt.Color(255, 153, 0));
        exitButton1.setText("SMS");
        exitButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel15))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(176, 176, 176))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 931, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 912, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 309, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totaldues, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalpaid, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, 0, 201, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(totalpaid)
                        .addComponent(jLabel10)
                        .addComponent(totaldues)
                        .addComponent(jLabel9))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(exitButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 932, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void admissionnoDuesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_admissionnoDuesKeyPressed
        if(!admissionnoDues.getText().isEmpty())
        {
            viewDefaultersList();
         sumOfPaid();
sumOfDues();
        }// TODO add your handling code here:
}//GEN-LAST:event_admissionnoDuesKeyPressed

    private void classDuesComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classDuesComboActionPerformed
        changesection=0;
        changeroll=0;
         if(!classDuesCombo.getSelectedItem().equals("choose"))
            {
        classFilter();
        classStudentFilter();
        studentDetailOnBasisOfClass();
         sumOfPaid();
sumOfDues();
         }else dm.setRowCount(0);
             // TODO add your handling code here:
}//GEN-LAST:event_classDuesComboActionPerformed

    private void sectionDuesComboMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sectionDuesComboMouseEntered
       // TODO add your handling code here:
}//GEN-LAST:event_sectionDuesComboMouseEntered

        private void rollDuesComboMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rollDuesComboMouseEntered
           
}//GEN-LAST:event_rollDuesComboMouseEntered

        private void feeHeadDuesComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feeHeadDuesComboActionPerformed
            viewDuesOnFeeHeadBasis();
            sumOfPaid();
sumOfDues();// TODO add your handling code here:
}//GEN-LAST:event_feeHeadDuesComboActionPerformed

        private void showAllDuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAllDuesActionPerformed
            showAllDefaultersList();
            sumOfPaid();
            sumOfDues();// TODO add your handling code here:
}//GEN-LAST:event_showAllDuesActionPerformed

        private void totalDuesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalDuesButtonActionPerformed
             aggregateOfDefaultersList();
             sumOfPaid();
             sumOfDues();// TODO add your handling code here:
}//GEN-LAST:event_totalDuesButtonActionPerformed

        private void allpaymentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allpaymentsButtonActionPerformed
            dateDurationPayment();
             sumOfPaid();
              totaldues.setText("");
//sumOfDues();// TODO add your handling code here:
}//GEN-LAST:event_allpaymentsButtonActionPerformed

        private void admissionnoPaymentKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_admissionnoPaymentKeyPressed
            if(!admissionnoPayment.getText().isEmpty()) 
            {
                viewPaymentList();
            sumOfPaid();
//sumOfDues();
totaldues.setText("");
            }// TODO add your handling code here:
}//GEN-LAST:event_admissionnoPaymentKeyPressed

        private void rollPaymentComboMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rollPaymentComboMouseEntered
               // TODO add your handling code here:
}//GEN-LAST:event_rollPaymentComboMouseEntered

        private void classPaymentComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classPaymentComboActionPerformed
            changesection=0;
            changeroll=0;
            if(!classPaymentCombo.getSelectedItem().equals("choose"))
            {
            classFilterForPayment();
            classStudentFilterForPayment();
            studentDetailOnBasisOfClassForPayment();
            sumOfPaid();
             totaldues.setText("");
            }
            else dm.setRowCount(0);
//sumOfDues();// TODO add your handling code here:
}//GEN-LAST:event_classPaymentComboActionPerformed

        private void sectionpaymentComboMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sectionpaymentComboMouseEntered
                // TODO add your handling code here:
}//GEN-LAST:event_sectionpaymentComboMouseEntered

        private void feeHeadPaymentComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feeHeadPaymentComboActionPerformed
            viewPaymentOnFeeHeadBasis();
            sumOfPaid();
             totaldues.setText("");
//sumOfDues();// TODO add your handling code here:
}//GEN-LAST:event_feeHeadPaymentComboActionPerformed

        private void showAllPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAllPaymentActionPerformed
            showAllPaymentList();
             sumOfPaid();
              totaldues.setText("");
//sumOfDues();// TODO add your handling code here:
}//GEN-LAST:event_showAllPaymentActionPerformed

        private void netBalanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_netBalanceButtonActionPerformed
            aggregateBalance();
             sumOfPaid();
             totaldues.setText("");
//sumOfDues();// TODO add your handling code here:
}//GEN-LAST:event_netBalanceButtonActionPerformed

        private void sectionDuesComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sectionDuesComboMouseClicked
            int keycode=evt.getID();
        if(keycode==MouseEvent.MOUSE_CLICKED) {
          /*  if(changesection==sectionDuesCombo.getItemCount()-1) changesection=-1;
            changesection++;
            sectionDuesCombo.setSelectedIndex(changesection);*/
             if(classDuesCombo.getSelectedItem().equals("choose"))
                JOptionPane.showConfirmDialog(null,"Select Class","Class Selection",JOptionPane.OK_OPTION);
            else if(!sectionDuesCombo.getSelectedItem().equals("choose"))
            {
            sectionFilter();
            studentDetailOnBasisOfSection();
             sumOfPaid();
sumOfDues();
        }
        }
        }//GEN-LAST:event_sectionDuesComboMouseClicked

        private void rollDuesComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rollDuesComboMouseClicked
            int keycode=evt.getID();

            if(keycode==MouseEvent.MOUSE_CLICKED) {
               /* if(changeroll==rollDuesCombo.getItemCount()-1) changeroll=-1;
                changeroll++;
                if(changeroll<rollDuesCombo.getItemCount())
                    rollDuesCombo.setSelectedIndex(changeroll);
                //sectionFilter();*/
                if(classDuesCombo.getSelectedItem().equals("choose"))
                JOptionPane.showConfirmDialog(null,"Select Class","Class Selection",JOptionPane.OK_OPTION);
                else
                {
                studentDetailOnBasisOfRoll();
                sumOfPaid();
sumOfDues();// TODO add your handling code here:
            }
            }
        }//GEN-LAST:event_rollDuesComboMouseClicked

        private void sectionpaymentComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sectionpaymentComboMouseClicked
           int keycode=evt.getID();
            if(keycode==MouseEvent.MOUSE_CLICKED) {
              /*  if(changesection==sectionpaymentCombo.getItemCount()-1) changesection=-1;
                changesection++;
                sectionpaymentCombo.setSelectedIndex(changesection);*/
          if(classPaymentCombo.getSelectedItem().equals("choose"))
                JOptionPane.showConfirmDialog(null,"Select Class","Class Selection",JOptionPane.OK_OPTION);
            else if(!sectionpaymentCombo.getSelectedItem().equals("choose"))
            {

            sectionFilterForPayment();
                studentDetailOnBasisOfSectionForPayment();
                sumOfPaid();
                 totaldues.setText("");

            }
            }
//sumOfDues();// TODO add your handling code here:
            
        }//GEN-LAST:event_sectionpaymentComboMouseClicked

        private void rollPaymentComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rollPaymentComboMouseClicked
          int keycode=evt.getID();

            if(keycode==MouseEvent.MOUSE_CLICKED) {
             /*   if(changeroll==rollPaymentCombo.getItemCount()-1) changeroll=-1;
                changeroll++;
                if(changeroll<rollPaymentCombo.getItemCount())
                    rollPaymentCombo.setSelectedIndex(changeroll);*/
                //sectionFilter();
                if(classPaymentCombo.getSelectedItem().equals("choose"))
                JOptionPane.showConfirmDialog(null,"Select Class","Class Selection",JOptionPane.OK_OPTION);
                else
                {
                studentDetailOnBasisOfRollForPayment();
                sumOfPaid();
                 totaldues.setText("");
//sumOfDues();// TODO add your handling code here:
            }
            }
        }//GEN-LAST:event_rollPaymentComboMouseClicked

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try
        {
        String s="Student Payment-Dues Result";
        MessageFormat header=new MessageFormat(s);
        jTable1.print(PrintMode.FIT_WIDTH, header, null);
        }

        catch(Exception e)
        {
         System.err.println("Error in printing student search");
        }
        }//GEN-LAST:event_jButton1ActionPerformed

        private void sessionComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sessionComboActionPerformed
            sessionWiseDues();
            sumOfPaid();
sumOfDues();// TODO add your handling code here:
}//GEN-LAST:event_sessionComboActionPerformed

        private void sessionCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sessionCombo1ActionPerformed
            if(!sessionCombo1.getSelectedItem().equals("choose"))
            {
            sessionWisePayments();
            sumOfPaid();
             totaldues.setText("");
            }
//sumOfDues();// TODO add your handling code here:
        }//GEN-LAST:event_sessionCombo1ActionPerformed

        private void exitButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButton1ActionPerformed
       //  smsDues();   // TODO add your handling code here:
              try
 {
        ps=con.prepareStatement("select access from smsaccess where module=? ");
    ps.setString(1,"Payment and Dues");
    rs=ps.executeQuery();
    if(rs.next())
    {
    if(rs.getInt(1)==1)
        smsDues();
      else JOptionPane.showConfirmDialog(null,"Add SMS package access from Accessories","Contact Administrator",JOptionPane.OK_OPTION);
       // jCheckBox1.setSelected(false);

    }else JOptionPane.showConfirmDialog(null,"Add SMS package access from Accessories","Contact Administrator",JOptionPane.OK_OPTION);
      }catch(Exception e)
{
    e.printStackTrace();
}
        }//GEN-LAST:event_exitButton1ActionPerformed

        private void rollPaymentComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rollPaymentComboActionPerformed
          // studentDetailOnBasisOfRollForPayment();
                //sumOfPaid();
                // totaldues.setText("");
        }//GEN-LAST:event_rollPaymentComboActionPerformed

        private void sectionpaymentComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sectionpaymentComboActionPerformed
         /*    if(classPaymentCombo.getSelectedItem().equals("choose"))
                JOptionPane.showConfirmDialog(null,"Select Class","Class Selection",JOptionPane.OK_OPTION);
            else if(!sectionpaymentCombo.getSelectedItem().equals("choose"))
            {

            sectionFilterForPayment();
                studentDetailOnBasisOfSectionForPayment();
                sumOfPaid();
                 totaldues.setText("");

            }*/
        }//GEN-LAST:event_sectionpaymentComboActionPerformed

       
        
        public void smsDues()
 {
       String id=null;
           if(admissionnoDues.getText().isEmpty())
          {
               JOptionPane.showConfirmDialog(null,"Mobile no. Field is empty","Mobile Empty",JOptionPane.OK_OPTION);

           }
           else
           {
                 try
                 {
    //  String inputLine;
             ps=con.prepareStatement("select phone from studententry where id=?");
                     ps.setString(1, admissionnoDues.getText());
             rs=ps.executeQuery();
             if(rs.next())
             {
                 id=rs.getString(1);
             }
//Double payable=Double.parseDouble(collected.getText())-waivestudent;
   String msg="You are requested to clear your Dues amount of Rs."+totaldues.getText();
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
      new com.duc.Accessories.SendSms().SmsCommon(admissionnoDues.getText(),id,newmsg,ip);
      }
     // }
    }catch(Exception e)
    {
        JOptionPane.showConfirmDialog(null,"Mobile no. Field is empty","Mobile Empty",JOptionPane.OK_OPTION);

        e.printStackTrace();
    }
         }
 }

        public void sessionWiseDues()
        {
     try
     {
       ps=con.prepareStatement("select studentid,class,section,roll,head,dues,month,date,feetype,name from feedues left join studententry on studentid=id where session= ? and dues!=0 order by studentid") ;
      ps.setInt(1,Integer.parseInt(sessionmap1.get(sessionCombo.getSelectedItem()).toString()));
         //ps.setInt(2,id);
      System.out.println("n1");
       rs=ps.executeQuery();
      studentDetail(rs);

 // con.close();
     }catch(Exception e)
   {
e.printStackTrace();
   }
        }
        public void sessionWisePayments()
        {
             try
     {
       ps=con.prepareStatement("select studentid,class,section,roll,head,dues,month,paid,date,remaining,feetype,name from feepaid left join studententry on studentid=id where session=? and paid!=0 order by studentid") ;
      ps.setInt(1,Integer.parseInt(sessionmap1.get(sessionCombo1.getSelectedItem()).toString()));
      //ps.setInt(2,id);
      System.out.println("n2");
       rs=ps.executeQuery();
      studentDetailForPayment(rs);
      // con.close();
     }catch(Exception e)
   {
   e.printStackTrace();
   }
      }

public void sumOfPaid()
{
    Double totalpaid=0.0;
    int rowcount=dm.getRowCount();
    for(int i=0;i<rowcount;i++)
    {
        System.out.println("rd");
        totalpaid+=Double.parseDouble(dm.getValueAt(i,8).toString());

    }   this.totalpaid.setText(String.valueOf(totalpaid));
}
        public void sumOfDues()
{
    Double totaldues=0.0;
    int rowcount=dm.getRowCount();
    for(int i=0;i<rowcount;i++)
    {
        System.out.println("rd");
        totaldues+=Double.parseDouble(dm.getValueAt(i,6).toString());

    }   this.totaldues.setText(String.valueOf(totaldues));
}

         public void durationWiseDues()
  {
       //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

     try
     {
         // ps=con.prepareStatement("select * from feedues where dues!=0 order by studentid");
      ps=con.prepareStatement("select studentid,class,section,roll,head,remaining,month,date,feetype from feepaid ledt join studententry on studentid=id where dues!=0 and date>=? and date<=? and session=? order by studentid") ;
      ps.setString(1,datefrom.getText());
      ps.setString(2,dateto.getText());
        ps.setInt(3,sessionValue);
      System.out.println("n3");
       rs=ps.executeQuery();
     // System.out.println("gender"+rs);

studentDetail(rs);
 //con.close();
     }catch(Exception e)
   {
e.printStackTrace();
   }
  }


  public void aggregateBalance()
{
    int i=0,j=0,feetype=0;
   // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
         ps=con.prepareStatement("select studentid,class,section,roll,head,dues,month,paid,date,remaining,feetype,name from feepaid left join studententry on studentid=id where paid!=0 and dues!=0 and session=? order by studentid");
         ps.setInt(1,sessionValue);
        rs=ps.executeQuery();

        while(rs.next())
            {
                j++;

            }
            rs.first();
            rs.previous();
             System.out.println("rd"+j);

            dm.setRowCount(j);
           // System.out.println(rs.getString(2));
            while(rs.next())
            {
feetype=rs.getInt(11);
            dm.setValueAt(rs.getString(1), i, 0);
            dm.setValueAt(rs.getString(12), i, 1);
            dm.setValueAt(classmap.get(rs.getInt(2)), i, 2);
            dm.setValueAt(sectionmap.get(rs.getInt(3)), i, 3);
            dm.setValueAt(rs.getInt(4), i, 4);
             if(feetype==0)
            dm.setValueAt(monthlyfeemap.get(rs.getInt(5)), i, 5);
            if(feetype==1)
            dm.setValueAt(admissionfeemap.get(rs.getInt(5)), i, 5);
            if(feetype==2)
            dm.setValueAt(periodicfeemap.get(rs.getInt(5)), i, 5);
            if(feetype==3)
            dm.setValueAt(otherfeemap.get(rs.getInt(5)), i, 5);
            dm.setValueAt(rs.getDouble(6), i, 6);
             dm.setValueAt(month.get(rs.getInt(7)), i, 7);
              dm.setValueAt(rs.getDouble(8), i, 8);
            dm.setValueAt(rs.getString(9), i, 9);

            i++;
        }
double total=0.0;
  // int count=0;

for(int k=j;k>1;k--)
{
    if(dm.getValueAt(k-1, 0).toString().equals(dm.getValueAt(k-2, 0).toString()))
    {
       // total+=Double.parseDouble(dm.getValueAt(k-1, 5).toString());
        dm.setValueAt("", k-1, 0);
        dm.setValueAt("", k-1, 1);
        dm.setValueAt("", k-1, 2);
        dm.setValueAt("", k-1, 3);

}


}
for(int k=j;k>=1;k--)
{
    total=Double.parseDouble(dm.getValueAt(k-1, 5).toString())-Double.parseDouble(dm.getValueAt(k-1, 7).toString());
     //System.out.println("total"+total);
     dm.setValueAt(dm.getValueAt(k-1, 2)+"         Balance="+total, k-1, 2);
}


    }catch(Exception e)
    {
e.printStackTrace();
    }
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
                //j++;
              sessionCombo.addItem(rs.getString(1));
               sessionCombo1.addItem(rs.getString(1));

                if(rs.getInt(3)==1)
                  sessionValue=rs.getInt(2);
   }

         }
         catch(Exception e)
         {
             e.printStackTrace();
    }
   }
  public void aggregateOfDefaultersList()
  {
       int i=0,j=0;
    //con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
         ps=con.prepareStatement("select distinct studentid from feedues where dues!=0 and session=? order by studentid");
        ps.setInt(1,sessionValue);
        rs=ps.executeQuery();

        while(rs.next())
            {
                j++;

            }
            rs.first();
            rs.previous();

            System.out.println("rd"+j);

            dm.setRowCount(j);

            while(rs.next())
            {

            dm.setValueAt(rs.getString(1), i, 0);


            i++;
        }
    }catch(Exception e)
        {

        }
    int r;
     try
    {
         for(r=0;r<dm.getRowCount();r++)
         {
         ps=con.prepareStatement("select sum(dues)sum from feedues where studentid=? and session=? and dues!=0");
        ps.setString(1,dm.getValueAt(r, 0).toString());
          ps.setInt(2,sessionValue);
        rs=ps.executeQuery();
        rs.next();
dm.setValueAt(rs.getDouble(1), r,5);

        }
     }
    catch(Exception e)
        {
        e.printStackTrace();

        }
try
    {
         for(r=0;r<dm.getRowCount();r++)
         {
         ps=con.prepareStatement("select studentid,class,section,roll,head,dues,month,date,feetype,name from feedues left join studententry on studentid=id where studentid=?  and session=? and dues!=0 order by studentid");
        ps.setString(1,dm.getValueAt(r, 0).toString());
          ps.setInt(2,sessionValue);
        rs=ps.executeQuery();
        rs.next();
        dm.setValueAt(rs.getString(10), i,1);
dm.setValueAt(classmap.get(rs.getInt(2)), r, 2);
            dm.setValueAt(sectionmap.get(rs.getInt(3)), r, 3);
           dm.setValueAt(rs.getInt(4), r, 4);
            dm.setValueAt("Total Dues", r, 5);
            dm.setValueAt("", r, 7);
            dm.setValueAt(0, r, 8);
           dm.setValueAt(rs.getString(8), r, 9);

        }
     }
    catch(Exception e)
        {
        e.printStackTrace();

        }
  }
 public void  dateDurationPayment()
  {
      // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

     try
     {
       ps=con.prepareStatement("select studentid,class,section,roll,head,dues,month,paid,date,remaining,feetype,name from feepaid left join studententry on studentid=id where date>=? and date<=? and session=? order by studentid") ;
      ps.setString(1,datefrom.getText());
      ps.setString(2,dateto.getText());
        ps.setInt(3,sessionValue);
      System.out.println("n4");
       rs=ps.executeQuery();
     // System.out.println("gender"+rs);

studentDetailForPayment(rs);
 //con.close();
     }catch(Exception e)
   {
e.printStackTrace();
   }
  }
  public void viewDuesOnFeeHeadBasis()
{
    int i=0,j=0;
    int feeid=0,feetype=0;
    //con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
        if(classDuesCombo.getSelectedItem().toString().equals("choose"))
        {

           

         ps=con.prepareStatement("select * from monthlyfeehead where head=?");
                                   ps.setString(1,feeHeadDuesCombo.getSelectedItem().toString());
                                   rs=ps.executeQuery();
                                   if(rs.next())
                                   {
                                       feeid=rs.getInt(1);
feetype=0;
                                       System.out.println("ffffffffffffffff");
                                   }

                                  ps=con.prepareStatement("select * from admissionfeehead where head=?");
                                   ps.setString(1,feeHeadDuesCombo.getSelectedItem().toString());
                                   rs=ps.executeQuery();
                                   if(rs.next())
                                   {
                                       feeid=rs.getInt(1);
feetype=1;
                                       System.out.println("in admission");
                                   }

                                    ps=con.prepareStatement("select * from periodicfeehead where head=?");
                                   ps.setString(1,feeHeadDuesCombo.getSelectedItem().toString());
                                   rs=ps.executeQuery();
                                   if(rs.next())
                                   {
                                       feeid=rs.getInt(1);
feetype=2;
                                       System.out.println("in periodic");
                                   }

                                    ps=con.prepareStatement("select * from ledgerotherfeeheadcode where feehead=?");
                                   ps.setString(1,feeHeadDuesCombo.getSelectedItem().toString());
                                   rs=ps.executeQuery();
                                   if(rs.next())
                                   {
                                       feeid=rs.getInt(3);
feetype=3;
                                       System.out.println("ij edger");
                                   }
 ps=con.prepareStatement("select studentid,class,section,roll,head,dues,month,date,feetype,name from feedues left join studententry on studentid=id where head=? and dues!=0 and session=? and feetype=? order by studentid");

            ps.setInt(1,feeid);
              ps.setInt(2,sessionValue);
              ps.setInt(3,feetype);
        }

        else
        {
           ps=con.prepareStatement("select * from monthlyfeehead where head=?");
                                   ps.setString(1,feeHeadDuesCombo.getSelectedItem().toString());
                                   rs=ps.executeQuery();
                                   if(rs.next())
                                   {
                                       feeid=rs.getInt(1);
feetype=0;
                                       System.out.println("ffffffffffffffff");
                                   }

                                  ps=con.prepareStatement("select * from admissionfeehead where head=?");
                                   ps.setString(1,feeHeadDuesCombo.getSelectedItem().toString());
                                   rs=ps.executeQuery();
                                   if(rs.next())
                                   {
                                       feeid=rs.getInt(1);
feetype=1;
                                       System.out.println("in admission");
                                   }

                                    ps=con.prepareStatement("select * from periodicfeehead where head=?");
                                   ps.setString(1,feeHeadDuesCombo.getSelectedItem().toString());
                                   rs=ps.executeQuery();
                                   if(rs.next())
                                   {
                                       feeid=rs.getInt(1);
feetype=2;
                                       System.out.println("in periodic");
                                   }

                                    ps=con.prepareStatement("select * from ledgerotherfeeheadcode where feehead=?");
                                   ps.setString(1,feeHeadDuesCombo.getSelectedItem().toString());
                                   rs=ps.executeQuery();
                                   if(rs.next())
                                   {
                                       feeid=rs.getInt(3);
feetype=3;
                                       System.out.println("ij edger");
                                   }
  ps=con.prepareStatement("select studentid,class,section,roll,head,dues,month,date,feetype,name from feedues left join studententry on studentid=id where head=? and class=? and dues!=0 and session=? order by studentid");

            ps.setInt(1,feeid);
         ps.setInt(2,Integer.parseInt(classmap1.get(classDuesCombo.getSelectedItem().toString()).toString()));
           ps.setInt(3,sessionValue);
        }
         rs=ps.executeQuery();

        while(rs.next())
            {
                j++;

            }
            rs.first();
            rs.previous();
             System.out.println("rd"+j);

            dm.setRowCount(j);

            while(rs.next())
            {

            dm.setValueAt(rs.getString(1), i, 0);
            dm.setValueAt(rs.getString(10), i, 1);
            dm.setValueAt(classmap.get(rs.getInt(2)), i, 2);
            dm.setValueAt(sectionmap.get(rs.getInt(3)), i, 3);
            dm.setValueAt(rs.getInt(4), i, 4);
            if(feetype==0)
            dm.setValueAt(monthlyfeemap.get(rs.getInt(5)), i, 5);
            if(feetype==1)
            dm.setValueAt(admissionfeemap.get(rs.getInt(5)), i, 5);
            if(feetype==2)
            dm.setValueAt(periodicfeemap.get(rs.getInt(5)), i, 5);
            if(feetype==3)
            dm.setValueAt(otherfeemap.get(rs.getInt(5)), i, 5);
            dm.setValueAt(rs.getDouble(6), i, 6);
            dm.setValueAt(month.get(rs.getInt(7)), i, 7);
             dm.setValueAt(0, i, 8);
            dm.setValueAt(rs.getString(8), i, 9);

            i++;
        }


    }catch(Exception e)
    {
e.printStackTrace();
    }
}


  public void viewPaymentOnFeeHeadBasis()
{
     int i=0,j=0;
     int feeid=0,feetype=0;
  //  con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {


        ps=con.prepareStatement("select * from monthlyfeehead where head=?");
                                   ps.setString(1,feeHeadPaymentCombo.getSelectedItem().toString());
                                   rs=ps.executeQuery();
                                   if(rs.next())
                                   {
                                       feeid=rs.getInt(1);
feetype=0;
                                       System.out.println("ffffffffffffffff");
                                   }

                                  ps=con.prepareStatement("select * from admissionfeehead where head=?");
                                   ps.setString(1,feeHeadPaymentCombo.getSelectedItem().toString());
                                   rs=ps.executeQuery();
                                   if(rs.next())
                                   {
                                       feeid=rs.getInt(1);
feetype=1;
                                       System.out.println("in admission");
                                   }

                                    ps=con.prepareStatement("select * from periodicfeehead where head=?");
                                   ps.setString(1,feeHeadPaymentCombo.getSelectedItem().toString());
                                   rs=ps.executeQuery();
                                   if(rs.next())
                                   {
                                       feeid=rs.getInt(1);
feetype=2;
                                       System.out.println("in periodic");
                                   }

                                    ps=con.prepareStatement("select * from ledgerotherfeeheadcode where feehead=?");
                                   ps.setString(1,feeHeadPaymentCombo.getSelectedItem().toString());
                                   rs=ps.executeQuery();
                                   if(rs.next())
                                   {
                                       feeid=rs.getInt(3);
feetype=3;
                                       System.out.println("ij edger");
                                   }
         ps=con.prepareStatement("select studentid,class,section,roll,head,dues,month,paid,date,remaining,name from feepaid left join studententry on studentid=id where head=? and paid!=0 and session=? and feetype=? order by studentid");
        ps.setInt(1,feeid);
          ps.setInt(2,sessionValue);
          ps.setInt(3,feetype);
        rs=ps.executeQuery();

        while(rs.next())
            {
                j++;

            }
            rs.first();
            rs.previous();
            System.out.println("rd"+j);

            dm.setRowCount(j);

            while(rs.next())
            {

            dm.setValueAt(rs.getString(1), i, 0);
            dm.setValueAt(rs.getString(11), i, 1);
            dm.setValueAt(classmap.get(rs.getInt(2)), i, 2);
            dm.setValueAt(sectionmap.get(rs.getInt(3)), i, 3);
            dm.setValueAt(rs.getInt(4), i,4);
           if(feetype==0)
            dm.setValueAt(monthlyfeemap.get(rs.getInt(5)), i, 5);
            if(feetype==1)
            dm.setValueAt(admissionfeemap.get(rs.getInt(5)), i,5);
            if(feetype==2)
            dm.setValueAt(periodicfeemap.get(rs.getInt(5)), i, 5);
            if(feetype==3)
            dm.setValueAt(otherfeemap.get(rs.getInt(5)), i,5);
            dm.setValueAt(rs.getDouble(6),i,6);
            dm.setValueAt(month.get(rs.getInt(7)),i,7);
            dm.setValueAt(rs.getDouble(8), i,8);
            dm.setValueAt(rs.getString(9), i,9);

            i++;
        }
for(int k=j;k>1;k--)
{
    if(dm.getValueAt(k-1, 0).toString().equals(dm.getValueAt(k-2, 0).toString()))
    {
        dm.setValueAt("", k-1, 0);
        dm.setValueAt("", k-1, 1);
        dm.setValueAt("", k-1, 2);
        dm.setValueAt("", k-1, 3);
}

}

    }catch(Exception e)
    {
e.printStackTrace();
    }
}

  public void showAllPaymentList()
{
     int i=0,j=0,feetype=0;;
   // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
         ps=con.prepareStatement("select studentid,class,section,roll,head,dues,month,paid,date,remaining,feetype,name from feepaid left join studententry on studentid=id where paid!=0 and dues!=0 and session=? order by studentid");
         ps.setInt(1,sessionValue);
        rs=ps.executeQuery();
   while(rs.next())
            {
                j++;

            }
            rs.first();
            rs.previous();
            System.out.println("rd"+j);

            dm.setRowCount(j);
           // System.out.println(rs.getString(2));
            while(rs.next())
            {
feetype=rs.getInt(11);
            dm.setValueAt(rs.getString(1), i, 0);
            dm.setValueAt(rs.getString(12), i, 1);
            dm.setValueAt(classmap.get(rs.getInt(2)), i, 2);
            dm.setValueAt(sectionmap.get(rs.getInt(3)), i, 3);
            dm.setValueAt(rs.getInt(4), i,4);
             if(feetype==0)
            dm.setValueAt(monthlyfeemap.get(rs.getInt(5)), i, 5);
            if(feetype==1)
            dm.setValueAt(admissionfeemap.get(rs.getInt(5)), i, 5);
            if(feetype==2)
            dm.setValueAt(periodicfeemap.get(rs.getInt(5)), i, 5);
            if(feetype==3)
            dm.setValueAt(otherfeemap.get(rs.getInt(5)), i,5);
            dm.setValueAt(rs.getDouble(6), i, 6);
             dm.setValueAt(month.get(rs.getInt(7)), i, 7);
              dm.setValueAt(rs.getDouble(8), i, 8);
            dm.setValueAt(rs.getString(9), i, 9);

            i++;
        }

for(int k=j;k>1;k--)
{
    if(dm.getValueAt(k-1, 0).toString().equals(dm.getValueAt(k-2, 0).toString()))
    {
        dm.setValueAt("", k-1, 0);
        dm.setValueAt("", k-1, 1);
        dm.setValueAt("", k-1, 2);
        dm.setValueAt("", k-1, 3);
}

}

    }catch(Exception e)
    {
e.printStackTrace();
    }
}
public void studentDetailOnBasisOfRollForPayment()
{
   // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

     try
     {
       ps=con.prepareStatement("select studentid,class,section,roll,head,dues,month,paid,date,remaining,feetype,name from feepaid left join studententry on studentid=id where class= ? and section=? and roll=? and paid!=0 and session=? order by studentid") ;
      ps.setInt(1,Integer.parseInt(classmap1.get(classPaymentCombo.getSelectedItem().toString()).toString()));
      ps.setInt(2,Integer.parseInt(sectionmap1.get(sectionpaymentCombo.getSelectedItem().toString()).toString()));
       ps.setInt(3,Integer.parseInt(rollPaymentCombo.getSelectedItem().toString()));
         ps.setInt(4,sessionValue);
      System.out.println("n5");
       rs=ps.executeQuery();
     // System.out.println("gender"+rs);

studentDetailForPayment(rs);
 //con.close();
     }catch(Exception e)
   {
e.printStackTrace();
   }

}
public void studentDetailOnBasisOfRoll()
{
   // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

     try
     {
       ps=con.prepareStatement("select studentid,class,section,roll,head,dues,month,date,feetype,name from feedues left join studententry on studentid=id where class= ? and section=? and roll=? and dues!=0 and session=? order by studentid") ;
      ps.setInt(1,Integer.parseInt(classmap1.get(classDuesCombo.getSelectedItem().toString()).toString()));
      ps.setInt(2,Integer.parseInt(sectionmap1.get(sectionDuesCombo.getSelectedItem().toString()).toString()));
       ps.setInt(3,Integer.parseInt(rollDuesCombo.getSelectedItem().toString()));
         ps.setInt(4,sessionValue);
      System.out.println("n6");
       rs=ps.executeQuery();
     // System.out.println("gender"+rs);

studentDetail(rs);
 //con.close();
     }catch(Exception e)
   {
e.printStackTrace();
   }

}
public void studentDetailOnBasisOfSection()
{
   /// con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

     try
     {
       ps=con.prepareStatement("select studentid,class,section,roll,head,dues,month,date,feetype,name from feedues left join studententry on studentid=id where class= ? and section=? and dues!=0 and session=? order by studentid") ;
      ps.setInt(1,Integer.parseInt(classmap1.get(classDuesCombo.getSelectedItem().toString()).toString()));
      ps.setInt(2,Integer.parseInt(sectionmap1.get(sectionDuesCombo.getSelectedItem().toString()).toString()));
        ps.setInt(3,sessionValue);
      System.out.println("n7");
       rs=ps.executeQuery();
   
studentDetail(rs);
 //con.close();
     }catch(Exception e)
   {
e.printStackTrace();
   }

}

public void studentDetailOnBasisOfSectionForPayment()
{
   // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

     try
     {
       ps=con.prepareStatement("select studentid,class,section,roll,head,dues,month,paid,date,remaining,feetype,name from feepaid left join studententry on studentid=id where class= ? and section=? and paid!=0 and session=? order by studentid") ;
      ps.setInt(1,Integer.parseInt(classmap1.get(classPaymentCombo.getSelectedItem().toString()).toString()));
      ps.setInt(2,Integer.parseInt(sectionmap1.get(sectionpaymentCombo.getSelectedItem().toString()).toString()));
        ps.setInt(3,sessionValue);
      System.out.println("n8");
       rs=ps.executeQuery();
     // System.out.println("gender"+rs);

studentDetailForPayment(rs);
 //con.close();
     }catch(Exception e)
   {
e.printStackTrace();
   }

}
public void viewDefaultersList()
{
    int i=0,j=0,feetype=0;
   // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
         ps=con.prepareStatement("select studentid,class,section,roll,head,dues,month,date,feetype,name from feedues left join studententry on studentid=id where studentid=? and session=? and dues!=0 order by studentid");
        ps.setString(1,admissionnoDues.getText());
          ps.setInt(2,sessionValue);
        rs=ps.executeQuery();
    while(rs.next())
            {
                j++;

            }
            rs.first();
            rs.previous();

            System.out.println("rd"+j);

            dm.setRowCount(j);

            while(rs.next())
            {
feetype=rs.getInt(9);
            dm.setValueAt(rs.getString(1), i, 0);
            dm.setValueAt(rs.getString(10), i, 1);
            dm.setValueAt(classmap.get(rs.getInt(2)), i, 2);
            dm.setValueAt(sectionmap.get(rs.getInt(3)), i, 3);
            dm.setValueAt(rs.getInt(4), i, 4);
           if(feetype==0)
            dm.setValueAt(monthlyfeemap.get(rs.getInt(5)), i, 5);
            if(feetype==1)
            dm.setValueAt(admissionfeemap.get(rs.getInt(5)), i, 5);
            if(feetype==2)
            dm.setValueAt(periodicfeemap.get(rs.getInt(5)), i, 5);
            if(feetype==3)
            dm.setValueAt(otherfeemap.get(rs.getInt(5)), i, 5);
            dm.setValueAt(rs.getDouble(6), i, 6);
            dm.setValueAt(month.get(rs.getInt(7)), i, 7);
             dm.setValueAt(0, i, 8);
            dm.setValueAt(rs.getString(8), i, 9);

            i++;
        }
for(int k=j;k>1;k--)
{
    if(dm.getValueAt(k-1, 0).toString().equals(dm.getValueAt(k-2, 0).toString()))
    {
        dm.setValueAt("", k-1, 0);
        dm.setValueAt("", k-1, 1);
        dm.setValueAt("", k-1, 2);
        dm.setValueAt("", k-1, 3);
}

}
    }catch(Exception e)
    {
e.printStackTrace();
    }
}

public void viewPaymentList()
{
    int i=0,j=0,feetype=0;
   // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
         ps=con.prepareStatement("select studentid,class,section,roll,head,dues,month,paid,date,remaining,feetype,name from feepaid left join studententry on studentid=id where studentid=? and session=? and paid!=0 order by studentid");
        ps.setString(1,admissionnoPayment.getText());
          ps.setInt(2,sessionValue);
        rs=ps.executeQuery();

        while(rs.next())
            {
                j++;

            }
            rs.first();
            rs.previous();

            System.out.println("rd"+j);

            dm.setRowCount(j);

            while(rs.next())
            {
feetype=rs.getInt(11);
            dm.setValueAt(rs.getString(1), i, 0);
            dm.setValueAt(rs.getString(12), i, 1);
            dm.setValueAt(classmap.get(rs.getInt(2)), i, 2);
            dm.setValueAt(sectionmap.get(rs.getInt(3)), i, 3);
            dm.setValueAt(rs.getInt(4), i, 4);
           if(feetype==0)
            dm.setValueAt(monthlyfeemap.get(rs.getInt(5)), i, 5);
            if(feetype==1)
            dm.setValueAt(admissionfeemap.get(rs.getInt(5)), i, 5);
            if(feetype==2)
            dm.setValueAt(periodicfeemap.get(rs.getInt(5)), i, 5);
            if(feetype==3)
            dm.setValueAt(otherfeemap.get(rs.getInt(5)), i, 5);
            dm.setValueAt(rs.getDouble(6), i, 6);
            dm.setValueAt(month.get(rs.getInt(7)), i, 7);
            dm.setValueAt(rs.getDouble(8), i, 8);
            dm.setValueAt(rs.getString(9), i, 9);

            i++;
        }
for(int k=j;k>1;k--)
{
    if(dm.getValueAt(k-1, 0).toString().equals(dm.getValueAt(k-2, 0).toString()))
    {
        dm.setValueAt("", k-1, 0);
        dm.setValueAt("", k-1, 1);
        dm.setValueAt("", k-1, 2);
        dm.setValueAt("", k-1, 3);
}
}

    }catch(Exception e)
    {
e.printStackTrace();
    }
}
public void showAllDefaultersList()
{
     int i=0,j=0,feetype=0;
   // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
         ps=con.prepareStatement("select studentid,class,section,roll,head,dues,month,date,feetype,name from feedues left join studententry on studentid=id where dues!=0 and session=? order by studentid");
        ps.setInt(1,sessionValue);
        rs=ps.executeQuery();

        while(rs.next())
            {
                j++;

            }
            rs.first();
            rs.previous();
            System.out.println("rd"+j);

            dm.setRowCount(j);
           // System.out.println(rs.getString(2));
            while(rs.next())
            {
            feetype=rs.getInt(9);

            dm.setValueAt(rs.getString(1), i, 0);
            dm.setValueAt(rs.getString(10), i, 1);
            dm.setValueAt(classmap.get(rs.getInt(2)), i, 2);
            dm.setValueAt(sectionmap.get(rs.getInt(3)), i, 3);
            dm.setValueAt(rs.getInt(4), i, 4);
            if(feetype==0)
            dm.setValueAt(monthlyfeemap.get(rs.getInt(5)), i, 5);
            if(feetype==1)
            dm.setValueAt(admissionfeemap.get(rs.getInt(5)), i, 5);
            if(feetype==2)
            dm.setValueAt(periodicfeemap.get(rs.getInt(5)), i, 5);
            if(feetype==3)
            dm.setValueAt(otherfeemap.get(rs.getInt(5)), i, 5);
            dm.setValueAt(rs.getDouble(6), i, 6);
             dm.setValueAt(month.get(rs.getInt(7)), i, 7);
              dm.setValueAt(0, i, 8);
            dm.setValueAt(rs.getString(8), i, 9);

            i++;

        }
   double total=0.0;
   int count=0;

for(int k=j;k>1;k--)
{
    if(dm.getValueAt(k-1, 0).toString().equals(dm.getValueAt(k-2, 0).toString()))
    {
        total+=Double.parseDouble(dm.getValueAt(k-1, 6).toString());
        dm.setValueAt("", k-1, 0);
        dm.setValueAt("", k-1, 1);
        dm.setValueAt("", k-1, 2);
        dm.setValueAt("", k-1, 3);
        dm.setValueAt("", k-1, 4); ///currently added this row
}
    else
    {total+=Double.parseDouble(dm.getValueAt(k-1, 6).toString());
     System.out.println("total"+total);
     total=0.0;
}
    if(k==2)
    {total=total+Double.parseDouble(dm.getValueAt(0, 6).toString());
         System.out.println("total"+total);
    }
}
    }catch(Exception e)
    {
e.printStackTrace();
    }
}
public void studentDetailOnBasisOfClass()
{
    // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


         int i=0,j=0;

     try
     {
       System.out.println("checking here .....");
      ps=con.prepareStatement("select studentid,class,section,roll,head,dues,month,date,feetype,name from feedues left join studententry on studentid=id where class=? and session=? and dues!=0 order by studentid") ;
      ps.setInt(1,Integer.parseInt(classmap1.get(classDuesCombo.getSelectedItem().toString()).toString()));
      ps.setInt(2,sessionValue);
      System.out.println("n9");
      rs=ps.executeQuery();
      studentDetail(rs);

 // con.close();
     }catch(Exception e)
   {
e.printStackTrace();
   }

}

public void studentDetailOnBasisOfClassForPayment()
{
   //  con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


         int i=0,j=0;

     try
     {
       ps=con.prepareStatement("select studentid,class,section,roll,head,dues,month,paid,date,remaining,feetype,name from feepaid left join studententry on studentid=id where class=? and session=? and paid!=0 order by studentid") ;
      ps.setInt(1,Integer.parseInt(classmap1.get(classPaymentCombo.getSelectedItem().toString()).toString()));
          ps.setInt(2,sessionValue);
      System.out.println("n10");
       rs=ps.executeQuery();
      studentDetailForPayment(rs);
 // con.close();
     }catch(Exception e)
   {
e.printStackTrace();
   }

}

public void studentDetailForPayment(ResultSet rs)
{
     int i=0,j=0,feetype=0;
    try{
        if(rs.next())
        {
            rs.first();
            rs.previous();
        while(rs.next())
            {
                j++;

            }
            rs.first();
            rs.previous();
            dm.setRowCount(j);
            while(rs.next())
            {

feetype=rs.getInt(11);
                dm.setValueAt(rs.getString(1), i, 0);
                dm.setValueAt(rs.getString(12), i, 1);
                dm.setValueAt(classmap.get(rs.getInt(2)), i, 2);
                dm.setValueAt(sectionmap.get(rs.getInt(3)), i, 3);
                dm.setValueAt(rs.getInt(4), i, 4);
                 if(feetype==0)
            dm.setValueAt(monthlyfeemap.get(rs.getInt(5)), i, 5);
            if(feetype==1)
            dm.setValueAt(admissionfeemap.get(rs.getInt(5)), i, 5);
            if(feetype==2)
            dm.setValueAt(periodicfeemap.get(rs.getInt(5)), i, 5);
            if(feetype==3)
            dm.setValueAt(otherfeemap.get(rs.getInt(5)), i, 5);
                dm.setValueAt(rs.getDouble(6), i, 6);
                dm.setValueAt(month.get(rs.getInt(7)), i, 7);
                 dm.setValueAt(rs.getDouble(8), i, 8);
                  dm.setValueAt(rs.getString(9), i, 9);
                  i++;
            }
for(int k=j;k>1;k--)
{
    if(dm.getValueAt(k-1, 0).toString().equals(dm.getValueAt(k-2, 0).toString()))
    {
        dm.setValueAt("", k-1, 0);
        dm.setValueAt("", k-1, 1);
        dm.setValueAt("", k-1, 2);
        dm.setValueAt("", k-1, 3);
}
}
        }
        else dm.setRowCount(0);
    }catch(Exception e)
    {
e.printStackTrace();
    }

}
public void studentDetail(ResultSet rs)
{
     int i=0,j=0,feetype=0;
    try{
        if(rs.next())
        {

           rs.first();
           rs.previous();
            while(rs.next())
            {
                j++;

            }
            System.out.println("Row are = "+j);

            rs.first();
            rs.previous();
            dm.setRowCount(j);           
            

            while(rs.next())
            {
               feetype=rs.getInt(9);

                dm.setValueAt(rs.getString(1), i, 0);
                dm.setValueAt(rs.getString(10), i, 1);
                dm.setValueAt(classmap.get(rs.getInt(2)), i, 2);
                dm.setValueAt(sectionmap.get(rs.getInt(3)), i, 3);
                dm.setValueAt(rs.getInt(4), i, 4);

            if(feetype==0)
            dm.setValueAt(monthlyfeemap.get(rs.getInt(5)), i, 5);
            if(feetype==1)
            dm.setValueAt(admissionfeemap.get(rs.getInt(5)), i, 5);
            if(feetype==2)
            dm.setValueAt(periodicfeemap.get(rs.getInt(5)), i, 5);
            if(feetype==3)
            dm.setValueAt(otherfeemap.get(rs.getInt(5)), i, 5);

                dm.setValueAt(rs.getDouble(6), i, 6);
                dm.setValueAt(month.get(rs.getInt(7)), i, 7);
                dm.setValueAt(0, i, 8);
                dm.setValueAt(rs.getString(8), i, 9);
                i++;
            }

    for(int k=j;k>1;k--)
    {
    if(dm.getValueAt(k-1, 0).toString().equals(dm.getValueAt(k-2, 0).toString()))
    {
        dm.setValueAt("", k-1, 0);
        dm.setValueAt("", k-1, 1);
        dm.setValueAt("", k-1, 2);
        dm.setValueAt("", k-1, 3);
}
            }


    } else dm.setRowCount(0);
    }
        catch(Exception e)
    {
e.printStackTrace();
    }

}

public void setAdmissionNoPayment(String id)
{
    admissionnoPayment.setText(id);
    if(!admissionnoPayment.getText().isEmpty()) viewPaymentList();
}

public void setAdmissionNoDues(String id)
{
    admissionnoDues.setText(id);
   if(!admissionnoDues.getText().isEmpty()) viewDefaultersList();
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField admissionnoDues;
    private javax.swing.JTextField admissionnoPayment;
    private javax.swing.JButton allpaymentsButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox classDuesCombo;
    private javax.swing.JComboBox classPaymentCombo;
    private datechooser.beans.DateChooserCombo datefrom;
    private datechooser.beans.DateChooserCombo dateto;
    private javax.swing.JButton exitButton1;
    private javax.swing.JComboBox feeHeadDuesCombo;
    private javax.swing.JComboBox feeHeadPaymentCombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JButton netBalanceButton;
    private javax.swing.JComboBox rollDuesCombo;
    private javax.swing.JComboBox rollPaymentCombo;
    private javax.swing.JComboBox sectionDuesCombo;
    private javax.swing.JComboBox sectionpaymentCombo;
    private javax.swing.JComboBox sessionCombo;
    private javax.swing.JComboBox sessionCombo1;
    private javax.swing.JButton showAllDues;
    private javax.swing.JButton showAllPayment;
    private javax.swing.JButton totalDuesButton;
    private javax.swing.JLabel totaldues;
    private javax.swing.JLabel totalpaid;
    // End of variables declaration//GEN-END:variables
//Connection con;
ResultSet rs,rs1;
PreparedStatement ps;
static int changesection=-1,changeroll=-1;
public Integer sessionValue;
}
