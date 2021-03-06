/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PaymentTracker1.java
 *
 * Created on Sep 26, 2009, 5:08:47 PM
 */

package com.duc.FeeDepartment;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import java.util.Vector;
import static com.duc.DatabaseConnection.DatabaseConnection.*;
/**
 *
 * @author Ravi Dangaich
 */
public class PaymentTracker1 extends javax.swing.JInternalFrame {
DefaultTableModel dm,dm1;

//MapForIndex mp=new MapForIndex();
HashMap classmap=mp.getClassIndexName();
HashMap sectionmap=mp.getSectionIndexName();
//HashMap invname1=mpi.getInventoryNameToIndex();
HashMap invname=mpi.getInventoryNameFromIndex();
//DateFormat df;


    /** Creates new form PaymentTracker1 */
    public PaymentTracker1() {
        initComponents();
        pack();
         //con= com.duc.DatabaseConnection.DatabaseConnection.con;
        System.out.println("con of paymentTracker="+con);
        //this.setLocationRelativeTo(null);
        dm = (DefaultTableModel) jTable1.getModel();
        dm.setRowCount(0);
        dm1 = (DefaultTableModel) jTable2.getModel();
        dm1.setRowCount(0);
       //  df=new SimpleDateFormat("yyyy-MM-dd");
        datesearch.setDateFormat(df);
        viewAllreceiptNo();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        closeButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        viewButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        receipt = new javax.swing.JTextField();
        printButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        receiptDues = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        totalpaid = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        totalremaining = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        admissionnosearch = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        monthsearch = new javax.swing.JComboBox();
        datesearch = new datechooser.beans.DateChooserCombo();
        jLabel9 = new javax.swing.JLabel();
        viewButton1 = new javax.swing.JButton();
        checkMini = new javax.swing.JRadioButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Payment Tracker Window");

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        closeButton.setFont(new java.awt.Font("Tahoma", 1, 12));
        closeButton.setForeground(new java.awt.Color(0, 0, 255));
        closeButton.setText("Search");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Admission No.", "Class", "Section", "Roll", "Head", "Dues", "Month", "Paid", "Balance", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        viewButton.setFont(new java.awt.Font("Tahoma", 1, 12));
        viewButton.setForeground(new java.awt.Color(0, 0, 255));
        viewButton.setText("View All Receipt No");
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });

        jTextPane2.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane2.setEditable(false);
        jTextPane2.setFont(new java.awt.Font("Tahoma", 0, 24));
        jTextPane2.setText("                                           Payment Tracker");
        jScrollPane3.setViewportView(jTextPane2);

        jTextPane3.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane3.setEditable(false);
        jTextPane3.setFont(new java.awt.Font("Tahoma", 0, 12));
        jTextPane3.setText("It will generate the duplicate copy of your pay slip..Just click on the desired slip (table row) and click Print...");
        jScrollPane4.setViewportView(jTextPane3);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setText("Receipt Number");

        receipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receiptActionPerformed(evt);
            }
        });
        receipt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                receiptKeyPressed(evt);
            }
        });

        printButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        printButton.setForeground(new java.awt.Color(0, 0, 255));
        printButton.setText("Print");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setText("Total Dues");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel5.setText("Total paid");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel6.setText("Total Remaining");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Receipt No.", "Admission No.", "Dues Month", "Payment Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        admissionnosearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admissionnosearchActionPerformed(evt);
            }
        });
        admissionnosearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                admissionnosearchKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel7.setText("Admission No. Search");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel8.setText("Month Search");

        monthsearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        monthsearch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                monthsearchItemStateChanged(evt);
            }
        });
        monthsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthsearchActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel9.setText("Pay Date Search");

        viewButton1.setFont(new java.awt.Font("Tahoma", 1, 12));
        viewButton1.setForeground(new java.awt.Color(204, 51, 0));
        viewButton1.setText("Delete Slip ");
        viewButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButton1ActionPerformed(evt);
            }
        });

        checkMini.setFont(new java.awt.Font("Tahoma", 1, 12));
        checkMini.setForeground(new java.awt.Color(0, 0, 255));
        checkMini.setSelected(true);
        checkMini.setText("Mini Receipt");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(receipt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 243, Short.MAX_VALUE)
                .addComponent(viewButton)
                .addGap(18, 18, 18)
                .addComponent(viewButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel7)
                .addGap(1, 1, 1)
                .addComponent(admissionnosearch, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(monthsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(datesearch, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(receiptDues, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalpaid, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalremaining, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(checkMini)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(receipt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewButton)
                    .addComponent(viewButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(checkMini)
                    .addComponent(printButton)
                    .addComponent(receiptDues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalpaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalremaining, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(closeButton)
                            .addComponent(admissionnosearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(monthsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(datesearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
    paymentDateWiseReceipts();        // TODO add your handling code here:
}//GEN-LAST:event_closeButtonActionPerformed

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
                      // TODO add your handling code here:
}//GEN-LAST:event_viewButtonActionPerformed

    private void receiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receiptActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_receiptActionPerformed

    private void receiptKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_receiptKeyPressed
        int keycode=evt.getKeyCode();
            if(keycode==KeyEvent.VK_ENTER)
            if(receipt.getText().isEmpty())
            JOptionPane.showConfirmDialog(null,"admission number empty","empty",JOptionPane.OK_OPTION);
            else {
            //paymentTracker();
            loadReceiptInformation(Integer.parseInt(receipt.getText()));
            totalPaymentDues();
            totalPaymentPaid();
            totalPaymentRemaining();
            }
}//GEN-LAST:event_receiptKeyPressed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        try {
            replicateReceipt();
        }catch(Exception e) {
            e.printStackTrace();
        }

        // TODO add your handling code here:
}//GEN-LAST:event_printButtonActionPerformed

    private void admissionnosearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admissionnosearchActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_admissionnosearchActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
         
           int i=0,j=0;
           int currentrow=jTable2.getSelectedRow();
           receipt.setText(dm1.getValueAt(currentrow, 0).toString().trim());

            loadReceiptInformation(Integer.parseInt(receipt.getText()));
            totalPaymentDues();
            totalPaymentPaid();
            totalPaymentRemaining();

    }//GEN-LAST:event_jTable2MouseClicked

    private void admissionnosearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_admissionnosearchKeyPressed
        if(!admissionnosearch.getText().isEmpty())
        {
        int keycode=evt.getKeyCode();
        if(keycode==KeyEvent.VK_ENTER)
        admissionNoRelatedReceipts();
        }
            //else
           // JOptionPane.showConfirmDialog(null,"admission No. empty","Id Empty",JOptionPane.OK_OPTION);
    }//GEN-LAST:event_admissionnosearchKeyPressed

    private void monthsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthsearchActionPerformed
      duesMonthRelatedReceipts();
    }//GEN-LAST:event_monthsearchActionPerformed

    private void viewButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButton1ActionPerformed
        deleteSlip();
    }//GEN-LAST:event_viewButton1ActionPerformed

    private void monthsearchItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_monthsearchItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_monthsearchItemStateChanged
public void deleteSlip()
{
    // con= com.duc.DatabaseConnection.DatabaseConnection.con;
    String waiverdate=null;
    Double waiverused=0.0;
      String stdid;
try
{
    ps=con.prepareStatement("select * from receiptnumber where receipt=?");
    ps.setString(1,receipt.getText());
    rs=ps.executeQuery();
    if(rs.next())
    {
        waiverdate=rs.getString(3);
        waiverused=rs.getDouble(6);
        stdid=rs.getString(2);
System.out.println("Receiptnumber date="+waiverdate);
        ps=con.prepareStatement("delete from feewaiver where studentid=? and waiverused=? and date=?");

    ps.setString(1,stdid);
    ps.setDouble(2,waiverused);
    ps.setString(3,waiverdate);

    ps.executeUpdate();

    }
    ps=con.prepareStatement("delete from receiptnumber where receipt=?");
    ps.setString(1,receipt.getText());
    ps.executeUpdate();

     ps=con.prepareStatement("delete from payreceiptinfo where receiptnumber=?");
    ps.setString(1,receipt.getText());
    ps.executeUpdate();

}catch(Exception e)
{
 e.printStackTrace();
}
}
    public void admissionNoRelatedReceipts()
    {
        int i=0,j=0;
/// con= com.duc.DatabaseConnection.DatabaseConnection.con;
try
{
    ps=con.prepareStatement("select * from receiptnumber,sessionsetup where session=sessionid and status=1 and studentid=?");
    ps.setString(1,admissionnosearch.getText());
    rs=ps.executeQuery();
    if(rs.next())
    {       
     populateReceiptTable(rs);
        
    }
    else
    {
         JOptionPane.showConfirmDialog(null,"No payment recorded for this student in current active session","No Student Receipt",JOptionPane.OK_OPTION);
         dm1.setRowCount(0);
    }

    }catch(Exception e)
    {
      e.printStackTrace();
    }

    }
         public void populateReceiptTable(ResultSet rs)
         {
             int i=0,j=0;
             try
             {
           rs.first();

           rs.previous();
            while(rs.next())
            {
                j++;
            }
            dm1.setRowCount(j);
            rs.first();
            rs.previous();
            while(rs.next())
            {
                 dm1.setValueAt(rs.getInt(1), i, 0);
                 dm1.setValueAt(rs.getString(2), i, 1);
                 dm1.setValueAt(rs.getString(4), i, 2);
                 dm1.setValueAt(rs.getString(3), i, 3);


                 i++;
            }
         }catch(Exception e)
         {
             e.printStackTrace();

         }
         }


public void  duesMonthRelatedReceipts()
    {
 int i=0,j=0;
// con= com.duc.DatabaseConnection.DatabaseConnection.con;
try
{
    ps=con.prepareStatement("select * from receiptnumber,sessionsetup where session=sessionid and status=1 and month=?");
    ps.setString(1,monthsearch.getSelectedItem().toString());
    rs=ps.executeQuery();
    if(rs.next())
    {
        populateReceiptTable(rs);
    }
    else
    { 
       JOptionPane.showMessageDialog(null,"No receipt found for selected month in current active session","No MonthReceipt",JOptionPane.INFORMATION_MESSAGE);
       dm1.setRowCount(0);
    }
    }
    catch(Exception e)
    {
        e.printStackTrace();

    }

    }

public void  paymentDateWiseReceipts()
{
 int i=0,j=0;
// con= com.duc.DatabaseConnection.DatabaseConnection.con;
try
{
    ps=con.prepareStatement("select * from receiptnumber where date=?");
    ps.setString(1,datesearch.getText());
    rs=ps.executeQuery();
    if(rs.next())
    {

        populateReceiptTable(rs);

    }
    else
    { JOptionPane.showConfirmDialog(null,"No payment recorded for this date","No Date Receipt",JOptionPane.OK_OPTION);
dm1.setRowCount(0);
      //loadBlankTable
    }

    }catch(Exception e)
    {e.printStackTrace();

    }

    }

   public void loadReceiptInformation(int rnumber)
    {
         
   // con= com.duc.DatabaseConnection.DatabaseConnection.con;
    try
    {
        ps=con.prepareStatement("select * from receiptnumber,sessionsetup where session=sessionid and status=1 and receipt=?");
        ps.setInt(1,rnumber);
       // System.out.println("dfdfdf");
        rs=ps.executeQuery();
       // System.out.println("dsdsdsd");
        if(rs.next())
        {
          //  System.out.println("sdsdsdsd");
            String stdid=rs.getString(2);
            Date dat=rs.getDate(3);
            String month=rs.getString(4);

        ps=con.prepareStatement("select * from studententry where id=?");
        ps.setString(1,stdid);
        rs=ps.executeQuery();
        rs.next();
        String classroom=String.valueOf(classmap.get(rs.getInt(9)));
        String section=String.valueOf(sectionmap.get(rs.getInt(10)));
        int rollno=rs.getInt(11);


            ps=con.prepareStatement("select * from payreceiptinfo,sessionsetup where session=sessionid and status=1 and receiptnumber=?");
            ps.setInt(1,rnumber );
            rs=ps.executeQuery();

            int i=0,j=0;
            while(rs.next())
            {
                j++;
            }
            dm.setRowCount(j);
            rs.first();
            rs.previous();
            while(rs.next())
            {
                 dm.setValueAt(stdid, i, 0);
                dm.setValueAt(classroom, i, 1);
                 dm.setValueAt(section, i, 2);
                 dm.setValueAt(rollno, i, 3);
               if(rs.getInt(8)>0)
                {
                 dm.setValueAt(invname.get(rs.getInt(8)), i, 4);
                }
                else
                dm.setValueAt(mp.getFeeHeadNameFromFeeTypeAndHeadIndex(rs.getInt(2), rs.getInt(3)), i, 4);
                 dm.setValueAt(rs.getDouble(4), i, 5);
                  dm.setValueAt(month, i, 6);
                 dm.setValueAt(rs.getDouble(5), i, 7);
                 dm.setValueAt(rs.getDouble(6), i, 8);
                 dm.setValueAt(dat, i, 9);
                 i++;
            }

        }else
        {
            JOptionPane.showMessageDialog(null,"Invalid receipt number for the current active session","Invalid Receipt Number",JOptionPane.INFORMATION_MESSAGE);
        }

    }catch(Exception e)
    {
        System.out.println("dfdfdf");
    e.printStackTrace();
    }
    }

    public void viewAllreceiptNo()
    {
         int i=0,j=0;
   //con= com.duc.DatabaseConnection.DatabaseConnection.con;
    try
    {

        ps=con.prepareStatement("select * from receiptnumber,sessionsetup where session=sessionid and status=1");
        rs=ps.executeQuery();
        if(rs.next())
        {
          populateReceiptTable(rs);
        }else
        {
            JOptionPane.showMessageDialog(null,"No receipt found for the current active session.","No Result",JOptionPane.INFORMATION_MESSAGE);
        }


    }catch(Exception e)
    {
e.printStackTrace();
    }

    }


       public void replicateReceipt()
    {
        if(dm.getRowCount()<=0)
        return;

        try
        {
         HashMap map = new HashMap();

          ps=con.prepareStatement("select name,fathername from studententry where id=?" );
          ps.setString(1, String.valueOf(dm.getValueAt(0,0)));
          rs = ps.executeQuery();
          rs.next();
          map.put("id",String.valueOf(dm.getValueAt(0,0)));
          map.put("name",rs.getString(1));
          map.put("class",String.valueOf(dm.getValueAt(0,1)));
          map.put("section",String.valueOf(dm.getValueAt(0,2)));
          map.put("roll",String.valueOf(dm.getValueAt(0,3)));
          map.put("father",rs.getString(2));
          map.put("receipt",Integer.parseInt(receipt.getText()));

          ps=con.prepareStatement("select institutename, instituteaddress from instituteregistration" );
          rs = ps.executeQuery();
          rs.next();
          map.put("schoolname",rs.getString(1));
          map.put("schooladdress",rs.getString(2));

          ps=con.prepareStatement("select sessiontitle from sessionsetup where status=1");
          rs=ps.executeQuery();
          if(rs.next())
          map.put("session",rs.getString(1));
          else
          map.put("session","");

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

          ps=con.prepareStatement("select date,month,surplus,waiver,surplusused,waiverreason from receiptnumber where receipt=?");
          ps.setInt(1, Integer.parseInt(receipt.getText()));
          rs = ps.executeQuery();
          rs.next();
          map.put("date",rs.getString(1));
          map.put("month",rs.getString(2));
          map.put("surplus",Double.parseDouble(rs.getString(3)));
          map.put("waiver",Double.parseDouble(rs.getString(4)));
          map.put("presurplus",rs.getDouble(5));
          map.put("reason", rs.getString(6));
         // System.out.println("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
          ps=con.prepareStatement("select feehead,totaldues,totalpaid,totalremaining,feetype,groupid from payreceiptinfo where receiptnumber=? ");
          ps.setInt(1, Integer.parseInt(receipt.getText()));
          rs = ps.executeQuery();

          String temp="";
          Vector collection=new Vector();
        while(rs.next())
         {
         temp="";
         if(rs.getInt(6)>0)
         {
             System.out.println("Id is "+rs.getInt(6));
             temp=invname.get(rs.getInt(6)).toString();
         }
         else
         temp=mp.getFeeHeadNameFromFeeTypeAndHeadIndex(rs.getInt(5), rs.getInt(1));
         collection.add(new PaymentTrackReport(temp,rs.getDouble(2),rs.getDouble(3),rs.getDouble(4)));

         }
          //System.out.println("ppppppppppppppppppppppppppppppppppppp");

                JRBeanCollectionDataSource src = new JRBeanCollectionDataSource(collection);
                JasperReport js;
                if(checkMini.isSelected()==true)
                {
                js = JasperCompileManager.compileReport("reports/fee/mini_pay_receipt_replica.jrxml");
                }
                else
                js = JasperCompileManager.compileReport("reports/fee/receipt_replica.jrxml");
                //System.out.println("gggggggggggggggggggggggggggggggggggggggggg");
                JasperPrint pr = JasperFillManager.fillReport(js, map,src);
                //System.out.println("ooooooooooooooooooooooooooooooooo");
                JasperViewer jv = new JasperViewer(pr, false);
                jv.setTitle("Student Payment Receipt...Second Copy");
                jv.setVisible(true);
                //System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
                //con.close();
        }
        catch(Exception e)
        {
          System.err.println("Error occured" + e);
        }
    }


  public void totalPaymentDues()
  {

    Double totaldues=0.0;
    int rowcount=dm.getRowCount();

   if(rowcount<=0)
     {
         totalpaid.setText(String.valueOf(totaldues));
         return;
     }
    
    for(int i=0;i<rowcount;i++)
    {
        System.out.println("rd");
        totaldues+=Double.parseDouble(dm.getValueAt(i,5).toString());

    }   receiptDues.setText(String.valueOf(totaldues));
  }

  public void totalPaymentPaid()
  {
    Double totaldues=0.0;
    int rowcount=dm.getRowCount();
    
     if(rowcount<=0)
     {
         totalpaid.setText(String.valueOf(totaldues));
         return;
     }
     

    for(int i=0;i<rowcount;i++)
    {
        System.out.println("rd");
        totaldues+=Double.parseDouble(dm.getValueAt(i,7).toString());

    }
    totalpaid.setText(String.valueOf(totaldues));
  }

  public void totalPaymentRemaining()
  {
    Double totaldues=0.0;
    int rowcount=dm.getRowCount();

    if(rowcount<=0)
     {
         totalpaid.setText(String.valueOf(totaldues));
         return;
     }
    
    for(int i=0;i<rowcount;i++)
    {
        System.out.println("rd");
        totaldues+=Double.parseDouble(dm.getValueAt(i,8).toString());

    }   totalremaining.setText(String.valueOf(totaldues));
  }

    public void paymentTracker()
{
    int i=0,j=0;
   // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
        ps=con.prepareStatement("select * from receiptnumber where receipt=?");
        ps.setInt(1,Integer.parseInt(receipt.getText()));
        rs=ps.executeQuery();
        if(rs.next())
        {
            String stdid=rs.getString(2);
            Date dat=rs.getDate(3);
            String month=rs.getString(4);
             ps=con.prepareStatement("select * from studententry where id=?");
        ps.setString(1,stdid);
        rs=ps.executeQuery();
        rs.next();
        String classroom=rs.getString(9);
        String section=rs.getString(10);
        int rollno=rs.getInt(11);


            ps=con.prepareStatement("select * from payreceiptinfo where receiptnumber=?");
            ps.setInt(1,Integer.parseInt(receipt.getText()) );
            rs=ps.executeQuery();
            while(rs.next())
            {
                j++;
            }
            dm.setRowCount(j);
            rs.first();
            rs.previous();
            while(rs.next())
            {
                 dm.setValueAt(stdid, i, 0);
                dm.setValueAt(classroom, i, 1);
                 dm.setValueAt(section, i, 2);
                 dm.setValueAt(rollno, i, 3);
                dm.setValueAt(rs.getString(2), i, 4);
                 dm.setValueAt(rs.getDouble(3), i, 5);
                  dm.setValueAt(month, i, 6);
                 dm.setValueAt(rs.getDouble(4), i, 7);
                 dm.setValueAt(rs.getDouble(5), i, 8);
                 dm.setValueAt(dat, i, 9);
                 i++;
            }
        }else
        {
            JOptionPane.showConfirmDialog(null,"Invalid Receipt Number","Invalid Receipt",JOptionPane.OK_OPTION);
        }


    }catch(Exception e)
    {
e.printStackTrace();
    }

}

  /*  public void populateTable(ResultSet rs)
    {
        try
        {
            while(rs.next())
            {
                 dm.setValueAt(stdid, i, 0);
                dm.setValueAt(classroom, i, 1);
                 dm.setValueAt(section, i, 2);
                 dm.setValueAt(rollno, i, 3);
                dm.setValueAt(rs.getString(2), i, 4);
                 dm.setValueAt(rs.getDouble(3), i, 5);
                  dm.setValueAt(month, i, 6);
                 dm.setValueAt(rs.getDouble(4), i, 7);
                 dm.setValueAt(rs.getDouble(5), i, 8);
                 dm.setValueAt(dat, i, 9);
                 i++;
            }
    }catch(Exception e)
    {

    }
    }   */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField admissionnosearch;
    private javax.swing.JRadioButton checkMini;
    private javax.swing.JButton closeButton;
    private datechooser.beans.DateChooserCombo datesearch;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JComboBox monthsearch;
    private javax.swing.JButton printButton;
    private javax.swing.JTextField receipt;
    private javax.swing.JTextField receiptDues;
    private javax.swing.JTextField totalpaid;
    private javax.swing.JTextField totalremaining;
    private javax.swing.JButton viewButton;
    private javax.swing.JButton viewButton1;
    // End of variables declaration//GEN-END:variables
//Connection con;
ResultSet rs;
PreparedStatement ps;
}
