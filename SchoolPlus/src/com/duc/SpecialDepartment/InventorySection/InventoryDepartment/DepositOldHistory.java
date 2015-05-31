/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DepositOldHistory.java
 *
 * Created on Jan 15, 2010, 2:06:38 AM
 */

package com.duc.SpecialDepartment.InventorySection.InventoryDepartment;


import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
 import static com.duc.DatabaseConnection.DatabaseConnection.*;
 import com.duc.ImportSection.MapForInventoryIndex;
import java.text.MessageFormat;
import java.util.HashMap;
import javax.swing.JTable.PrintMode;

/**
 *
 * @author Ravi
 */
public class DepositOldHistory extends javax.swing.JInternalFrame {
    DefaultTableModel dm;
//DateFormat df;
//MapForInventoryIndex mpi;
HashMap invname=mpi.getInventoryNameFromIndex();
HashMap invname1=mpi.getInventoryNameToIndex();
HashMap schoolpurchaser=mpi.getSchoolPurchaserIndexToName();
    /** Creates new form DepositOldHistory */
    public DepositOldHistory() {
        initComponents();
       
         dm = (DefaultTableModel) jTable1.getModel();
        dm.setRowCount(0);
       // df=new SimpleDateFormat("yyyy-MM-dd");
        dateofenquiry.setDateFormat(df);
       dateofenquiry1.setDateFormat(df);
    fromInventoryName();
    }
public void fromInventoryName()
{
    try{

//con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
         ps = con.prepareStatement("select distinct invname from involddeposit");

             rs = ps.executeQuery();

//inventoryName.removeAllItems();
           while (rs.next())
        inventoryName.addItem(invname.get(rs.getInt(1)).toString());



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
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        dateofenquiry = new datechooser.beans.DateChooserCombo();
        jLabel7 = new javax.swing.JLabel();
        dateofenquiry1 = new datechooser.beans.DateChooserCombo();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        inventoryName = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setForeground(java.awt.Color.white);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Inv. Name", "Pur. Representative", "Available Quantity", "Deposit Quantty", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable1);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel6.setText("Date From");

        jLabel7.setText("Date To");

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(dateofenquiry1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                        .addGap(2, 2, 2)
                        .addComponent(dateofenquiry, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateofenquiry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(dateofenquiry1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)))
        );

        jLabel2.setText("Inventory Name");

        inventoryName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        inventoryName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inventoryNameMouseClicked(evt);
            }
        });
        inventoryName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                inventoryNameItemStateChanged(evt);
            }
        });
        inventoryName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventoryNameActionPerformed(evt);
            }
        });

        jButton3.setText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inventoryName, 0, 221, Short.MAX_VALUE)
                        .addGap(142, 142, 142)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(inventoryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inventoryNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventoryNameMouseClicked
// viewDepositByName();
}//GEN-LAST:event_inventoryNameMouseClicked

    private void inventoryNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_inventoryNameItemStateChanged
        // inventoryNameFilter4Deposit();
}//GEN-LAST:event_inventoryNameItemStateChanged

    private void inventoryNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventoryNameActionPerformed
     if(!inventoryName.getSelectedItem().toString().equals("choose"))
        viewDepositByName();
     else dm.setRowCount(0);
}//GEN-LAST:event_inventoryNameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
viewDepositByDate();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try
        {
        String s="Inventory Deposit Detail";
        MessageFormat header=new MessageFormat(s);
        jTable1.print(PrintMode.FIT_WIDTH, header, null);
        }

        catch(Exception e)
        {
         System.err.println("Error in printing student search");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

public void viewDepositByDate()
{
     int i=0,j=0;
   // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
        ps=con.prepareStatement("select * from involddeposit where date>=? and date<=?");
        ps.setString(1,dateofenquiry.getText());
ps.setString(2,dateofenquiry1.getText());
        rs=ps.executeQuery();
       // System.out.println("value"+rs.next());
        populateTable(rs);
 //System.out.println(rs.getString(9));
   // con.close();
    }catch(Exception e)
    {
e.printStackTrace();
    }
}


public void viewDepositByName()
{
     int i=0,j=0;
   // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
        ps=con.prepareStatement("select * from involddeposit where invname=?");
     ps.setInt(1,Integer.parseInt(invname1.get(inventoryName.getSelectedItem()).toString()));

        rs=ps.executeQuery();
       // System.out.println("value"+rs.next());
        populateTable(rs);
 //System.out.println(rs.getString(9));
   // con.close();
    }catch(Exception e)
    {
e.printStackTrace();
    }
}
public void populateTable(ResultSet rs)
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
            System.out.println(dateofenquiry.getText());
            dm.setRowCount(j);
            System.out.println(j);
            //rs.next();
            while(rs.next())
            {
            dm.setValueAt(invname.get(rs.getInt(1)), i, 0);
                dm.setValueAt(schoolpurchaser.get(rs.getInt(2)), i, 1);
                 dm.setValueAt(rs.getDouble(3), i, 2);
                  dm.setValueAt(rs.getDouble(4), i, 3);
            dm.setValueAt(rs.getString(5), i, 4);


                 i++;
        }
            }
            else dm.setRowCount(0);
    }catch(Exception e)
    {
e.printStackTrace();
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo dateofenquiry;
    private datechooser.beans.DateChooserCombo dateofenquiry1;
    private javax.swing.JComboBox inventoryName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
PreparedStatement ps;
ResultSet rs;
}