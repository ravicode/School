/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ClassWiseInventory.java
 *
 * Created on Mar 21, 2010, 1:24:27 PM
 */

package com.duc.SpecialDepartment.InventorySection.InventoryDepartment;

import com.duc.ImportSection.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import static com.duc.DatabaseConnection.DatabaseConnection.*;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ravi
 */
public class ClassWiseInventory extends javax.swing.JInternalFrame {
DefaultTableModel dm;
//DateFormat df;
//MapForIndex mp=new MapForIndex();
//MapForInventoryIndex mpi=new MapForInventoryIndex();
    HashMap classmap1=mp.getClassIndexFromName();
     HashMap classmap=mp.getClassIndexName();

     HashMap inv1=mpi.getInventoryNameToIndex();
     HashMap inv=mpi.getInventoryNameFromIndex();

    /** Creates new form ClassWiseInventory */
    public ClassWiseInventory() {
        initComponents();
        dm = (DefaultTableModel)jTable1.getModel();
        dm.setRowCount(0);
        fromAddClass();
        fromInventoryDeposit();
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
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPane4 = new javax.swing.JTextPane();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        sectiontitle = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jButton1.setText("Add Inventory");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Remove Inventory");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextPane3.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane3.setEditable(false);
        jTextPane3.setFont(new java.awt.Font("Tahoma", 0, 18));
        jTextPane3.setText("                      Add Class Wise Inventory");
        jScrollPane4.setViewportView(jTextPane3);

        jTextPane4.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane4.setEditable(false);
        jTextPane4.setText("Make the sets of inventories for a particular class.");
        jScrollPane5.setViewportView(jTextPane4);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Class Title");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setText("Inventory List");

        jLabel4.setText("Inventory");

        sectiontitle.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        sectiontitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sectiontitleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sectiontitle, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(418, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(sectiontitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(105, 105, 105)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        addInventory();        // TODO add your handling code here:
}//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        removeInventory();        // TODO add your handling code here:
}//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        // String s=jComboBox1.getSelectedItem().toString();
        oldInventory();
        // TODO add your handling code here:
}//GEN-LAST:event_jComboBox1ActionPerformed

    private void sectiontitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sectiontitleActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_sectiontitleActionPerformed

public void addInventory()
{
    // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
try
{
    ps=con.prepareStatement("Select * from invclasswise where classid=? and invid=?");
    ps.setInt(1,Integer.parseInt(classmap1.get(jComboBox1.getSelectedItem().toString()).toString()));
    ps.setInt(2,Integer.parseInt(inv1.get(sectiontitle.getSelectedItem().toString()).toString()));
    rs=ps.executeQuery();
    if(rs.next())
    {
        JOptionPane.showConfirmDialog(null,"Inventory for this class exists","Same Inventory",JOptionPane.OK_OPTION);
    }
    else
    {
// ps = con.prepareStatement("insert into inventorysetup (Inventoryunit,InventoryVendor,Inventorymode,class,unitid,Time) values(?,?,?,?,?,?)");
    ps=con.prepareStatement("insert into invclasswise(classid,invid,date) values(?,?,?)");
    ps.setInt(1,Integer.parseInt(classmap1.get(jComboBox1.getSelectedItem().toString()).toString()));
    ps.setInt(2,Integer.parseInt(inv1.get(sectiontitle.getSelectedItem().toString()).toString()));
 ps.setString(3, datum);



         ps.executeUpdate();


        System.out.println("Done");
        //JOptionPane.showMessageDialog(null,"data stored successfully","report",JOptionPane.PLAIN_MESSAGE);

//con.close();
         System.out.println("DataBase Conection Closed");
         oldInventory();

    return;
    }
        }


catch(Exception e)
{
    e.printStackTrace();
    System.out.println("here");
}
    }

    private void oldInventory()
    {
       //  con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
       try
       {
           ps = con.prepareStatement("select * from invclasswise where classid=?");
           ps.setInt(1,Integer.parseInt(classmap1.get(jComboBox1.getSelectedItem().toString()).toString()));

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
                dm.setValueAt(inv.get(rs.getInt(2)), i, 0);
               // dm.setValueAt(rs.getString(2), i, 1);

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






    public void removeInventory()
    {
       // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        int row = jTable1.getSelectedRow();
         System.out.println("row no. selected"+row);
        try
        {
        /*   ps=con.prepareStatement("select * from studententry where class=? and section=?");
          ps.setInt(1,Integer.parseInt(classmap1.get(jComboBox1.getSelectedItem().toString()).toString()));
        ps.setInt(2,Integer.parseInt(inv1.get(dm.getValueAt(row, 0).toString()).toString()));

          rs=ps.executeQuery();
         if(rs.next())
         {
             JOptionPane.showConfirmDialog(null,"Student Present in this Class-Section,so can't be deleted","Student Present",JOptionPane.PLAIN_MESSAGE);
         }
         else
         {*/
         ps=con.prepareStatement("delete from invclasswise where invid=? and classid=?");

         ps.setInt(1,Integer.parseInt(inv1.get(dm.getValueAt(row, 0).toString()).toString()));
         ps.setInt(2,Integer.parseInt(classmap1.get(jComboBox1.getSelectedItem().toString()).toString()));
         ps.executeUpdate();
         dm.removeRow(row);
         // con.close();
         System.out.println("DataBase Conection Closed");
    //}
        }
        catch(Exception e)
        {
            System.err.println("Error"+e);
        }

    }
public void fromAddClass()
{
   // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
        ps=con.prepareStatement("select * from classsetup");

      rs = ps.executeQuery();
           while (rs.next())
        jComboBox1.addItem(rs.getString(1));
}
    catch(SQLException e)
    {
        e.printStackTrace();
    }
}
public void fromInventoryDeposit()
{
   // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
        ps=con.prepareStatement("select * from inventorydeposit order by invname");

      rs = ps.executeQuery();
           while (rs.next())
        sectiontitle.addItem(rs.getString(3));
}
    catch(SQLException e)
    {
        e.printStackTrace();
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextPane jTextPane4;
    private javax.swing.JComboBox sectiontitle;
    // End of variables declaration//GEN-END:variables
ResultSet rs;
PreparedStatement ps;
}