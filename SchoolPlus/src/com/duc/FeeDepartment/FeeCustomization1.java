/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FeeRelaxation1.java
 *
 * Created on Sep 26, 2009, 5:20:13 PM
 */

package com.duc.FeeDepartment;
import com.duc.ImportSection.MapForIndex;
import java.sql.*;
import java.text.MessageFormat;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTable.PrintMode;
import javax.swing.table.DefaultTableModel;
import static com.duc.DatabaseConnection.DatabaseConnection.*;
/**
 *
 * @author Ravi Dangaich
 */
public class FeeCustomization1 extends javax.swing.JInternalFrame {
DefaultTableModel dm;
//MapForIndex mp=new MapForIndex();
HashMap classmap=mp.getClassIndexName();
HashMap classmap1=mp.getClassIndexFromName();
HashMap monthlyfeemap1=mp.getMonthlyFeeIndexFromName();
HashMap admissionfeemap1=mp.getAdmissionFeeIndexFromName();
HashMap periodicfeemap1=mp.getPeriodicFeeIndexFromName();

   // HashMap sectionmap=new HashMap
    /** Creates new form FeeRelaxation1 */
    public FeeCustomization1() {
        initComponents();
         //con= com.duc.DatabaseConnection.DatabaseConnection.con;
         System.out.println("con of Feecustomization="+con);

        pack();
        //this.setLocationRelativeTo(null);
          dm = (DefaultTableModel) jTable1.getModel();
        dm.setRowCount(0);
        fromClass();
       showAllSpecialFeeStudentList();
    }



    public void fromClass()
    {
         try
    {

System.out.println("con of Fee Customization Section="+con);
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

    public void populateTable(ResultSet rs)
    {
        int i=0,j=0;
        try
        {
            if(rs.next())
            {
                System.out.println("dfdfdfdfdfdfdf...........");
                rs.first();
                rs.previous();


             while(rs.next())
            j++;
        dm.setRowCount(j);
        rs.first();
        rs.previous();
        while(rs.next())
        {
            dm.setValueAt(rs.getString(1), i,0);
            dm.setValueAt(classmap.get(rs.getInt(4)), i,1);
            //dm.setValueAt(rs.getInt(2), i,2);
            dm.setValueAt(rs.getDouble(3), i,3);
             dm.setValueAt(rs.getString(7), i,6);

        i++;
        }
rs.first();
        rs.previous();
       //
        i=0;
        while(rs.next())
        {
            if(rs.getInt(6)==0)

            {


            ps=con.prepareStatement("select * from monthlyfeeamounthead where head=? and class=?");
            ps.setInt(1,rs.getInt(2));
            ps.setInt(2,rs.getInt(4));
            rs1=ps.executeQuery();
            if(rs1.next())
            dm.setValueAt(rs1.getDouble(2), i, 4);
            dm.setValueAt("Monthly Fee", i, 5);
 ps=con.prepareStatement("select * from monthlyfeehead where feeid=?");
                ps.setInt(1,rs.getInt(2));
rs1=ps.executeQuery();
if(rs1.next())
dm.setValueAt(rs1.getString(2), i,2);
        }

             if(rs.getInt(6)==1)

            {

            ps=con.prepareStatement("select * from admissionfeeamounthead where head=? and class=?");
            ps.setInt(1,rs.getInt(2));
            ps.setInt(2,rs.getInt(4));
            rs1=ps.executeQuery();
            if(rs1.next())
            dm.setValueAt(rs1.getDouble(2), i, 4);
            dm.setValueAt("Admission Fee", i, 5);

            ps=con.prepareStatement("select * from admissionfeehead where feeid=?");
                ps.setInt(1,rs.getInt(2));
rs1=ps.executeQuery();
if(rs1.next())
dm.setValueAt(rs1.getString(2), i,2);


        }

             if(rs.getInt(6)==2)

            {
            ps=con.prepareStatement("select * from periodicfeeamounthead where head=? and class=?");
            ps.setInt(1,rs.getInt(2));
            ps.setInt(2,rs.getInt(4));
            rs1=ps.executeQuery();
            if(rs1.next())
            dm.setValueAt(rs1.getDouble(2), i, 4);
            dm.setValueAt("Periodic Fee", i, 5);

            ps=con.prepareStatement("select * from periodicfeehead where feeid=?");
                ps.setInt(1,rs.getInt(2));
rs1=ps.executeQuery();
if(rs1.next())
dm.setValueAt(rs1.getString(2), i,2);


        }

            if(rs.getInt(6)==3)

            {
            ps=con.prepareStatement("select * from ledgerotherfeeheadcode where feeid=?");
             ps.setInt(1,rs.getInt(2));
           // ps.setInt(2,rs.getInt(4));
            rs1=ps.executeQuery();
            if(rs1.next())
            //dm.setValueAt(0, i, 4);
            dm.setValueAt("Other Fee", i, 5);

            ps=con.prepareStatement("select * from ledgerotherfeeheadcode where feeid=?");
                ps.setInt(1,rs.getInt(2));
rs1=ps.executeQuery();
if(rs1.next())
dm.setValueAt(rs1.getString(1), i,2);
            }
     i++;    }
        }
            else
            { System.out.println("rdx...........");
                dm.setRowCount(0);}
        }
        catch(Exception e)
        {
e.printStackTrace();
        }
    }
public void showAllSpecialFeeStudentList()
{
  
   //con= com.duc.DatabaseConnection.DatabaseConnection.con;
  //  int i=0,j=0;
    try
    {
        ps=con.prepareStatement("select studentid,head,amount,class,ledgercode,feeheadtype,customizationdate from feecustomization left join studententry on studentid=id");
        rs=ps.executeQuery();

        populateTable(rs);
       
    }catch(Exception e)
    {
e.printStackTrace();
    }




}


public void removeTransportFromTable()
                {
                    int r=0;
                    int count=dm.getRowCount();
                    try
                    {
                        for(r=0;r<count;r++)
                        {
                            while((dm.getValueAt(r, 2).toString()).equals("Transport Fee"))
                            {
                                dm.removeRow(r);
                                System.out.println("Removed row="+r);
                               // r++;
                            }

                        }

                    }catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }


public void showAllSpecialFeeStudentListByClass()
{

   //con= com.duc.DatabaseConnection.DatabaseConnection.con;
  //  int i=0,j=0;
    try
    {
        if(!((jComboBox1.getSelectedItem().toString().equals("choose")) || (jComboBox1.getSelectedItem().toString().equals("All"))) )
        {
        ps=con.prepareStatement("select studentid,head,amount,class,ledgercode,feeheadtype,customizationdate from feecustomization left join studententry on studentid=id where class=?");
       ps.setInt(1,Integer.parseInt(classmap1.get(jComboBox1.getSelectedItem().toString()).toString()));
        rs=ps.executeQuery();
System.out.println("Class="+Integer.parseInt(classmap1.get(jComboBox1.getSelectedItem().toString()).toString()));
        populateTable(rs);
        }

    }catch(Exception e)
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        printButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        showAllButton = new javax.swing.JButton();
        admissionno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        closeButton1 = new javax.swing.JButton();
        closeButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jCheckBox2 = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Custom/Relaxed/Special Fee Students List");

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Admission No.", "Class", "Head", "Payable Fee", "Actual Fee", "Fee Type", "Cust. Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTextPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 0, 24));
        jTextPane1.setText("                            List of Custom Fees Students");
        jScrollPane2.setViewportView(jTextPane1);

        jTextPane2.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane2.setEditable(false);
        jTextPane2.setFont(new java.awt.Font("Tahoma", 0, 12));
        jTextPane2.setText("It will show the list of students who are getting benefit of Institute Fee Exemption rule..");
        jScrollPane3.setViewportView(jTextPane2);

        printButton.setFont(new java.awt.Font("Tahoma", 1, 12));
        printButton.setForeground(new java.awt.Color(0, 0, 255));
        printButton.setText("Print");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        closeButton.setFont(new java.awt.Font("Tahoma", 1, 12));
        closeButton.setForeground(new java.awt.Color(255, 51, 0));
        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        showAllButton.setFont(new java.awt.Font("Tahoma", 1, 12));
        showAllButton.setForeground(new java.awt.Color(0, 0, 255));
        showAllButton.setText("Show All");
        showAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllButtonActionPerformed(evt);
            }
        });

        admissionno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                admissionnoKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setText("Admission No.");

        closeButton1.setFont(new java.awt.Font("Tahoma", 1, 12));
        closeButton1.setForeground(new java.awt.Color(0, 0, 255));
        closeButton1.setText("Update");
        closeButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButton1ActionPerformed(evt);
            }
        });

        closeButton2.setFont(new java.awt.Font("Tahoma", 1, 12));
        closeButton2.setForeground(new java.awt.Color(153, 51, 0));
        closeButton2.setText("Remove");
        closeButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("Class");

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

        jCheckBox2.setBackground(new java.awt.Color(0, 153, 153));
        jCheckBox2.setText("Remove Transport");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(admissionno, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 400, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(printButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(closeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(closeButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(closeButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(showAllButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(admissionno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(showAllButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(printButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeButton)
                        .addGap(11, 11, 11)
                        .addComponent(jCheckBox2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        try
        {
        String s="Student Fee Customization List";
        MessageFormat header=new MessageFormat(s);
        jTable1.print(PrintMode.FIT_WIDTH, header, null);
        }

        catch(Exception e)
        {
         System.err.println("Error in printing student search");
        }
        // TODO add your handling code here:
}//GEN-LAST:event_printButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        this.dispose();        // TODO add your handling code here:
}//GEN-LAST:event_closeButtonActionPerformed

    private void showAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAllButtonActionPerformed
        showAllSpecialFeeStudentList();        // TODO add your handling code here:
}//GEN-LAST:event_showAllButtonActionPerformed

    private void admissionnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_admissionnoKeyPressed
        if(!admissionno.getText().isEmpty())viewSpecialFeeStudentList();     // TODO add your handling code here:
}//GEN-LAST:event_admissionnoKeyPressed

    private void closeButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButton1ActionPerformed
        // TODO add your handling code here:
        updateCustomizeFee();
    }//GEN-LAST:event_closeButton1ActionPerformed

    private void closeButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButton2ActionPerformed
      removeCustomizeFee();
       showAllSpecialFeeStudentList();
    }//GEN-LAST:event_closeButton2ActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked

}//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        //change=0;
         showAllSpecialFeeStudentListByClass();
        // TODO add your handling code here:
}//GEN-LAST:event_jComboBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
        if(jCheckBox2.isSelected())
            removeTransportFromTable();
}//GEN-LAST:event_jCheckBox2ActionPerformed

    public void updateCustomizeFee()
    {
        int row=jTable1.getSelectedRow();
        int feetype=0;
        try
        {
            if(dm.getValueAt(row,5).equals("Admission Fee"))
                feetype=1;
            if(dm.getValueAt(row,5).equals("Monthly Fee"))
                feetype=0;
            if(dm.getValueAt(row,5).equals("periodic Fee"))
                feetype=2;
            //ps=con.prepareStatement("select * from feecustomization");
            ps=con.prepareStatement("update feecustomization set amount=?,customizationdate=? where studentid=? and head=? and feeheadtype=?");
            ps.setDouble(1,Double.parseDouble(dm.getValueAt(row, 3).toString()));
           ps.setString(2, datum);

            ps.setString(3,dm.getValueAt(row,0).toString());
            if(feetype==0)
                ps.setInt(4,Integer.parseInt(monthlyfeemap1.get(dm.getValueAt(row, 2)).toString()));
            if(feetype==1)
                ps.setInt(4,Integer.parseInt(admissionfeemap1.get(dm.getValueAt(row, 2)).toString()));
            if(feetype==2)
                ps.setInt(4,Integer.parseInt(periodicfeemap1.get(dm.getValueAt(row, 2)).toString()));
            ps.setInt(5,feetype);
            ps.executeUpdate();

            JOptionPane.showConfirmDialog(null,"Fee is customized","Fee Customized",JOptionPane.OK_OPTION);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

     public void removeCustomizeFee()
    {
        int row=jTable1.getSelectedRow();
        int feetype=0;
        try
        {
            if(dm.getValueAt(row,5).equals("Admission Fee"))
                feetype=1;
            if(dm.getValueAt(row,5).equals("Monthly Fee"))
                feetype=0;
            if(dm.getValueAt(row,5).equals("periodic Fee"))
                feetype=2;
            //ps=con.prepareStatement("select * from feecustomization");
            ps=con.prepareStatement("delete from feecustomization where studentid=? and head=? and feeheadtype=?");
          //  ps.setDouble(1,Double.parseDouble(dm.getValueAt(row, 3).toString()));
         //  ps.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));

            ps.setString(1,dm.getValueAt(row,0).toString());
            if(feetype==0)
                ps.setInt(2,Integer.parseInt(monthlyfeemap1.get(dm.getValueAt(row, 2)).toString()));
            if(feetype==1)
                ps.setInt(2,Integer.parseInt(admissionfeemap1.get(dm.getValueAt(row, 2)).toString()));
            if(feetype==2)
                ps.setInt(2,Integer.parseInt(periodicfeemap1.get(dm.getValueAt(row, 2)).toString()));
            ps.setInt(3,feetype);
            ps.executeUpdate();

            JOptionPane.showConfirmDialog(null,"Customized Fee is Deleted,Normal Fee will be applied","Customize fee deleted",JOptionPane.OK_OPTION);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
public void viewSpecialFeeStudentList()
   {
      //con= com.duc.DatabaseConnection.DatabaseConnection.con;
    int i=0,j=0;
    try
    {
        ps=con.prepareStatement("select studentid,head,amount,class,ledgercode,feeheadtype,customizationdate from feecustomization left join studententry on studentid=id where studentid=?");
        ps.setString(1, admissionno.getText());
        rs=ps.executeQuery();
       populateTable(rs);
    }catch(Exception e)
    {
e.printStackTrace();
    }



   }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField admissionno;
    private javax.swing.JButton closeButton;
    private javax.swing.JButton closeButton1;
    private javax.swing.JButton closeButton2;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JButton printButton;
    private javax.swing.JButton showAllButton;
    // End of variables declaration//GEN-END:variables
//Connection con;
PreparedStatement ps;
ResultSet rs,rs1;
}
