/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LibraryAccount.java
 *
 * Created on Sep 30, 2009, 3:49:22 PM
 */

package com.duc.SpecialDepartment.AccountSection;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import com.duc.ImportSection.MapForIndex;
import java.text.MessageFormat;
import java.util.HashMap;
import javax.swing.JTable.PrintMode;
import static com.duc.DatabaseConnection.DatabaseConnection.*;
/**
 *
 * @author Ravi Dangaich
 */
public class LibraryAccount extends javax.swing.JInternalFrame {
//DateFormat df;
DefaultTableModel dm;
//MapForIndex mp=new MapForIndex();
HashMap classmap=mp.getClassIndexName();
HashMap classmap1=mp.getClassIndexFromName();
HashMap sectionmap=mp.getSectionIndexName();
HashMap month=mp.mapMonth();

    /** Creates new form LibraryAccount */
    public LibraryAccount() {
        initComponents();
        pack();
        //this.setLocationRelativeTo(null);
       // df=new SimpleDateFormat("yyyy-MM-dd");
         startdate.setDateFormat(df);
         enddate.setDateFormat(df);
         dm = (DefaultTableModel) jTable1.getModel();
        dm.setRowCount(0);
        fromClass();

        dayBookOfLibrary();
        todayPaymentsCollection();
        todayDuesCollection();
    }
 public void fromClass()
    {
         try
    {

 //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


         ps = con.prepareStatement("select * from classsetup");

             rs = ps.executeQuery();


            while (rs.next())
            {
        classcombo.addItem(rs.getString(1));



            }
 // con.close();
         }
    catch(Exception e)
    {
        System.err.println("Error is"+e);
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

        jPanel1 = new javax.swing.JPanel();
        closeButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        viewButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        startdate = new datechooser.beans.DateChooserCombo();
        enddate = new datechooser.beans.DateChooserCombo();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        invpaid = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        classcombo = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        viewButton1 = new javax.swing.JButton();
        viewButton2 = new javax.swing.JButton();
        viewButton3 = new javax.swing.JButton();
        invDues = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Library Account Display");

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        closeButton.setText("Close");
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
                "Admission No.", "Branch", "Semester", "Roll", "Head", "Dues", "Month", "Paid", "Balance", "Date"
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

        viewButton.setText("Class Dues");
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });

        jTextPane2.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane2.setEditable(false);
        jTextPane2.setFont(new java.awt.Font("Tahoma", 0, 24));
        jTextPane2.setText("                               Library Account");
        jScrollPane3.setViewportView(jTextPane2);

        jTextPane3.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane3.setEditable(false);
        jTextPane3.setFont(new java.awt.Font("Tahoma", 0, 12));
        jTextPane3.setText("Mange your Library Payments and Dues..");
        jScrollPane4.setViewportView(jTextPane3);

        jLabel2.setText("Date from");

        jLabel3.setText("Date to");

        jLabel4.setText("Total");

        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        classcombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));

        jLabel1.setText("Class");

        jButton2.setText("View");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        viewButton1.setText("Class Payments");
        viewButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButton1ActionPerformed(evt);
            }
        });

        viewButton2.setText("All Dues");
        viewButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButton2ActionPerformed(evt);
            }
        });

        viewButton3.setText("All Payments");
        viewButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButton3ActionPerformed(evt);
            }
        });

        jLabel5.setText("Total");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 973, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(startdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(enddate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(365, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(classcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(777, Short.MAX_VALUE))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 973, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(invDues, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(invpaid, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 826, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(viewButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(viewButton, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                        .addComponent(viewButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                        .addComponent(viewButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(closeButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(startdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enddate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(classcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(invDues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(invpaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(viewButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        this.dispose();        // TODO add your handling code here:
}//GEN-LAST:event_closeButtonActionPerformed

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
        //  dayBook();
        //  todayCollection();
        libraryDues();
        todayPaymentsCollection();
        todayDuesCollection();
        // TODO add your handling code here:
}//GEN-LAST:event_viewButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 try
        {
        String s="Student Library Account Result";
        MessageFormat header=new MessageFormat(s);
        jTable1.print(PrintMode.FIT_WIDTH, header, null);
        }

        catch(Exception e)
        {
         System.err.println("Error in printing library Account");
        }
}//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dayBookOfLibrary();
        todayPaymentsCollection();
        todayDuesCollection();// TODO add your handling code here:
}//GEN-LAST:event_jButton2ActionPerformed

    private void viewButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButton1ActionPerformed
        libraryPayments();
        todayPaymentsCollection();
        todayDuesCollection();// TODO add your handling code here:
}//GEN-LAST:event_viewButton1ActionPerformed

    private void viewButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButton2ActionPerformed
        libraryAllDues();
        todayPaymentsCollection();
        todayDuesCollection();// TODO add your handling code here:
}//GEN-LAST:event_viewButton2ActionPerformed

    private void viewButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButton3ActionPerformed
        libraryAllPayments();
        todayPaymentsCollection();
        todayDuesCollection();// TODO add your handling code here:
}//GEN-LAST:event_viewButton3ActionPerformed
 public void todayDuesCollection()
{
     Double totaldues=0.0;
    int rowcount=dm.getRowCount();
    for(int i=0;i<rowcount;i++)
    {
        System.out.println("rd");
        totaldues+=Double.parseDouble(dm.getValueAt(i,5).toString());

    }   invDues.setText(String.valueOf(totaldues));
}

    public void todayPaymentsCollection()
{
     Double totaldues=0.0;
    int rowcount=dm.getRowCount();
    for(int i=0;i<rowcount;i++)
    {
        System.out.println("rd");
        totaldues+=Double.parseDouble(dm.getValueAt(i,7).toString());

    }   invpaid.setText(String.valueOf(totaldues));
}
    public void dayBookOfLibrary()
{
    int i=0,j=0;
    int feeid=0;
  //  con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
        ps=con.prepareStatement("select feeid from ledgerotherfeeheadcode where feehead='Library Fine'");
        rs=ps.executeQuery();
        if(rs.next())
        {
            feeid=rs.getInt(1);
        ps=con.prepareStatement("select studentid,class,section,roll,head,dues,month,paid,date,remaining from feepaid left join studententry on studentid=id where date>=? and date<=? and head=? and feetype=3 and dues!=0 order by studentid");
        ps.setString(1,startdate.getText());
        ps.setString(2,enddate.getText());
        ps.setInt(3,feeid);
         //System.out.println(daybookdatechooser.getText());
        rs=ps.executeQuery();
       // System.out.println("value"+rs.next());
     populatePaymentTable(rs);
    }
    }catch(Exception e)
    {
e.printStackTrace();
    }
}
    public void libraryDues()
{
    int i=0,j=0;
    int feeid=0;
  //  con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
        ps=con.prepareStatement("select feeid from ledgerotherfeeheadcode where feehead='Library Fine'");
        rs=ps.executeQuery();
        if(rs.next())
        {
            feeid=rs.getInt(1);

            ps=con.prepareStatement("select studentid,class,section,roll,head,dues,month,paid,date,remaining from feepaid left join studententry on studentid=id  where head=? and class=? and feetype=3 and dues!=0 order by studentid");

        ps.setInt(1,feeid);

           // ps.setString(2,jComboBox1.getSelectedItem().toString());
         ps.setString(2,classmap1.get(classcombo.getSelectedItem()).toString());

         rs=ps.executeQuery();

      populateDuesTable(rs);
        }
    }catch(Exception e)
    {
e.printStackTrace();
    }
}
public void libraryAllDues()
{
  int i=0,j=0;
  int feeid=0;
   // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
        ps=con.prepareStatement("select feeid from ledgerotherfeeheadcode where feehead='Library Fine'");
        rs=ps.executeQuery();
        if(rs.next())
        {
            feeid=rs.getInt(1);


            ps=con.prepareStatement("select studentid,class,section,roll,head,dues,month,date from feedues left join studententry on studentid=id   where head=? and feetype=3 and dues!=0 order by studentid");

        ps.setInt(1,feeid);
         rs=ps.executeQuery();

       populateDuesTable(rs);
        }
    }catch(Exception e)
    {
e.printStackTrace();
    }
}

public void libraryPayments()
{
     int i=0,j=0;
     int feeid=0;
    //con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
        ps=con.prepareStatement("select feeid from ledgerotherfeeheadcode where feehead='Library Fine'");
        rs=ps.executeQuery();
        if(rs.next())
        {
            feeid=rs.getInt(1);

         ps=con.prepareStatement("select studentid,class,section,roll,head,dues,month,paid,date,remaining from feepaid left join studententry on studentid=id   where head=? and feetype=3 and class=? and paid!=0 order by studentid");
       // ps=con.prepareStatement("select studentid,class,section,roll,head,dues,month,paid,date,remaining from feepaid left join studententry on studentid=id  where head=? and feetype=3  and paid!=0 order by studentid");

            ps.setInt(1,feeid);

           // ps.setString(2,jComboBox1.getSelectedItem().toString());
         ps.setInt(2,Integer.parseInt(classmap1.get(classcombo.getSelectedItem()).toString()));
        rs=ps.executeQuery();

        while(rs.next())
            {
                j++;

            }
            rs.first();
            rs.previous();
            System.out.println("rd"+j);

            dm.setRowCount(j);

           populatePaymentTable(rs);
        }
    }catch(Exception e)
    {
e.printStackTrace();
    }
}


public void libraryAllPayments()
{

     int feeid=0;
   // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
        ps=con.prepareStatement("select feeid from ledgerotherfeeheadcode where feehead='Library Fine'");
        rs=ps.executeQuery();
        if(rs.next())
        {
            feeid=rs.getInt(1);

         ps=con.prepareStatement("select studentid,class,section,roll,head,dues,month,paid,date,remaining from feepaid left join studententry on studentid=id  where head=? and feetype=3  and paid!=0 order by studentid");
         ps.setInt(1,feeid);


        rs=ps.executeQuery();
populatePaymentTable(rs);
       
        }
    }catch(Exception e)
    {
e.printStackTrace();
    }
}

public void populateDuesTable(ResultSet rs)
{
    int i=0,j=0;
    try
    {
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
             System.out.println("rd"+j);

            dm.setRowCount(j);

            while(rs.next())
            {

             dm.setValueAt(rs.getString(1), i, 0);
                dm.setValueAt(classmap.get(rs.getInt(2)), i, 1);
                 dm.setValueAt(sectionmap.get(rs.getInt(3)), i, 2);
                 dm.setValueAt(rs.getInt(4), i, 3);
                dm.setValueAt("Library Fine", i, 4);
                 dm.setValueAt(rs.getDouble(6), i, 5);
                  dm.setValueAt(month.get(rs.getInt(7)), i, 6);
                 dm.setValueAt(0, i, 7);
                        dm.setValueAt(rs.getDouble(6), i, 8);
                 dm.setValueAt(rs.getString(8), i, 9);

            i++;
        }
        }

    }catch(Exception e)
    {
        e.printStackTrace();
    }
}

public void populatePaymentTable(ResultSet rs)
{
    int i=0,j=0;
    try
    {
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
            System.out.println("rd"+j);

            dm.setRowCount(j);

            while(rs.next())
            {

            dm.setValueAt(rs.getString(1), i, 0);
                dm.setValueAt(classmap.get(rs.getInt(2)), i, 1);
                 dm.setValueAt(sectionmap.get(rs.getInt(3)), i, 2);
                 dm.setValueAt(rs.getInt(4), i, 3);
                dm.setValueAt("Library Fine", i, 4);
                 dm.setValueAt(rs.getDouble(6), i, 5);
                  dm.setValueAt(month.get(rs.getInt(7)), i, 6);
                 dm.setValueAt(rs.getDouble(8), i, 7);
                         dm.setValueAt(rs.getDouble(10), i, 8);
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
    }catch(Exception e)
    {
        e.printStackTrace();
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox classcombo;
    private javax.swing.JButton closeButton;
    private datechooser.beans.DateChooserCombo enddate;
    private javax.swing.JTextField invDues;
    private javax.swing.JTextField invpaid;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane3;
    private datechooser.beans.DateChooserCombo startdate;
    private javax.swing.JButton viewButton;
    private javax.swing.JButton viewButton1;
    private javax.swing.JButton viewButton2;
    private javax.swing.JButton viewButton3;
    // End of variables declaration//GEN-END:variables
//Connection con;
ResultSet rs;
PreparedStatement ps;
}
