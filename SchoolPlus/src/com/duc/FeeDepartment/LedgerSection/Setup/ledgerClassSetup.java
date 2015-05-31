/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ledgerClassSetup.java
 *
 * Created on Jan 9, 2009, 6:01:59 PM
 */

package com.duc.FeeDepartment.LedgerSection.Setup;
import com.duc.ImportSection.MapForIndex;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.duc.ImportSection.MapForIndex.*;
import java.util.HashMap;
import static com.duc.DatabaseConnection.DatabaseConnection.*;
/**
 *
 * @author Ravi Dangaich
 */
public class ledgerClassSetup extends javax.swing.JInternalFrame {
DefaultTableModel dm;
//MapForIndex mp=new MapForIndex();
HashMap classmap1=mp.getClassIndexFromName();
HashMap studentidFromClassIndex=mp.getstudentidFromClassIndex();
    /** Creates new form ledgerClassSetup */
    public ledgerClassSetup() {
        initComponents();
        pack();
        //this.setLocationRelativeTo(null);
        //setLocation(220,200);
        dm = (DefaultTableModel)jTable1.getModel();
        dm.setRowCount(0);
        fromClassSetup();
        fromLedgerHeadSetup();
         oldLedgerClass();
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
        jButton4 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPane4 = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ledgercode = new javax.swing.JTextField();
        classcombo = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        ledgerTitleCombo = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Ledger Class Setup");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Class", "Ledger Title", "Ledger Code"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton4.setText("UpdateClass");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextPane3.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane3.setEditable(false);
        jTextPane3.setFont(new java.awt.Font("Tahoma", 0, 18));
        jTextPane3.setText("                     LedgerClass Setup");
        jScrollPane4.setViewportView(jTextPane3);

        jTextPane4.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane4.setEditable(false);
        jTextPane4.setText("Choose class and Ledger ..you will see the ledger code automatically..");
        jScrollPane5.setViewportView(jTextPane4);

        jLabel1.setText("Class");

        jLabel2.setText("Code");

        classcombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));

        jLabel3.setText("ledger");

        ledgerTitleCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        ledgerTitleCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ledgerTitleComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(classcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ledgerTitleCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(ledgercode, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton4))))
                .addContainerGap())
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(378, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ledgercode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(ledgerTitleCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(classcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        updateLedgerClass();
        updateAdmissionFeeLedgerCode();
         updateMonthlyFeeLedgerCode();
         updatePeriodicFeeLedgerCode();
          int select=JOptionPane.showInternalConfirmDialog(this,"Do You want to update this class current dues","Class Dues Alarm",JOptionPane.OK_CANCEL_OPTION);
        if(select==JOptionPane.OK_OPTION)
         updateFeeHeadInDues();// TODO add your handling code here:
}//GEN-LAST:event_jButton4ActionPerformed

    private void ledgerTitleComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ledgerTitleComboActionPerformed
        forLedgerHeadSetup();
    }//GEN-LAST:event_ledgerTitleComboActionPerformed

    public void forLedgerHeadSetup()
    {
         try
    {

         ps = con.prepareStatement("select * from ledgerheadsetup where ledgertitle=?");
         ps.setString(1,ledgerTitleCombo.getSelectedItem().toString());

             rs = ps.executeQuery();
             rs.next();
             
ledgercode.setText(String.valueOf(rs.getInt(2)));
 // con.close();
         }
    catch(Exception e)
    {
        System.err.println("Error is"+e);
    }
    }
    public void fromClassSetup()
    {
          try
    {

// con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


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

    public void fromLedgerHeadSetup()
    {
          try
    {

// con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


         ps = con.prepareStatement("select * from ledgerheadsetup");

             rs = ps.executeQuery();


            while (rs.next())
            {
        ledgerTitleCombo.addItem(rs.getString(1));


            }

 // con.close();
         }
    catch(Exception e)
    {
        System.err.println("Error is"+e);
    }

    }


    private void oldLedgerClass()
    {
        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
       try
       {
           ps = con.prepareStatement("select * from classsetup");

           rs = ps.executeQuery();
            int i = 0,j=0;
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
                dm.setValueAt(rs.getInt(3), i, 2);
ps = con.prepareStatement("select * from ledgerheadsetup where ledgercode=?");
ps.setInt(1,rs.getInt(3));
rs1 = ps.executeQuery();
rs1.next();
 dm.setValueAt(rs1.getString(1), i, 1);
                i++;
            }
          //  con.close();
            System.out.println("Database closed");

       }
       catch(Exception e)
       {
           System.err.println("Error"+e);
       }
    }






    public void updateLedgerClass()
    {
       
        try
        {
         ps=con.prepareStatement("update classsetup set ledgercode=? where classtitle=?");

         ps.setInt(1,Integer.parseInt(ledgercode.getText()));
         ps.setString(2,classcombo.getSelectedItem().toString());
         ps.executeUpdate();
         //dm.removeRow(row);
         // con.close();
         System.out.println("DataBase Conection Closed");
    }
        catch(Exception e)
        {
            System.err.println("Error"+e);
        }

    }


     public void updateAdmissionFeeLedgerCode()
    {
      
        try
        {
         ps=con.prepareStatement("update admissionfeeamounthead set ledgercode=? where class=?");

         ps.setInt(1,Integer.parseInt(ledgercode.getText()));
         ps.setInt(2,Integer.parseInt(classmap1.get(classcombo.getSelectedItem().toString()).toString()));
         ps.executeUpdate();
         //dm.removeRow(row);
        //  con.close();
         System.out.println("DataBase Conection Closed");
    }
        catch(Exception e)
        {
            System.err.println("Error"+e);
        }

    }

        public void updatePeriodicFeeLedgerCode()
    {
     
        try
        {
         ps=con.prepareStatement("update periodicfeeamounthead set ledgercode=? where class=?");

         ps.setInt(1,Integer.parseInt(ledgercode.getText()));
         ps.setInt(2,Integer.parseInt(classmap1.get(classcombo.getSelectedItem().toString()).toString()));
         ps.executeUpdate();
         //dm.removeRow(row);
         // con.close();
         System.out.println("DataBase Conection Closed");
    }
        catch(Exception e)
        {
            System.err.println("Error"+e);
        }

    }

     public void updateFeeHeadInDues()
     {
       
        try
        {
          
             ps=con.prepareStatement("update feedues,studententry set ledgercode=? where studentid=id and class=?");
             ps.setInt(1,Integer.parseInt(ledgercode.getText()));
             //ps.setInt(2,rs.getInt(1));
             ps.setInt(2,Integer.parseInt(classmap1.get(classcombo.getSelectedItem()).toString()));
         ps.executeUpdate();
            }catch(Exception e)
        {
            e.printStackTrace();
        }
     }
      public void updateMonthlyFeeLedgerCode()
    {
      
        try
        {
         ps=con.prepareStatement("update monthlyfeeamounthead set ledgercode=? where class=?");

         ps.setInt(1,Integer.parseInt(ledgercode.getText()));
         ps.setInt(2,Integer.parseInt(classmap1.get(classcombo.getSelectedItem().toString()).toString()));
         ps.executeUpdate();
       
         System.out.println("DataBase Conection Closed");
    }
        catch(Exception e)
        {
            System.err.println("Error"+e);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox classcombo;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextPane jTextPane4;
    private javax.swing.JComboBox ledgerTitleCombo;
    private javax.swing.JTextField ledgercode;
    // End of variables declaration//GEN-END:variables
//Connection con;
ResultSet rs,rs1;
PreparedStatement ps;
}
