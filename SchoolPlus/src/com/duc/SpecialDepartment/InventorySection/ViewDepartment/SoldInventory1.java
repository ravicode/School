/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SoldInventory1.java
 *
 * Created on Sep 30, 2009, 9:40:11 AM
 */

package com.duc.SpecialDepartment.InventorySection.ViewDepartment;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.event.*;
import java.text.MessageFormat;
import javax.swing.JTable.PrintMode;
import static com.duc.DatabaseConnection.DatabaseConnection.*;
/**
 *
 * @author Ravi Dangaich
 */
public class SoldInventory1 extends javax.swing.JInternalFrame {
DefaultTableModel dm;
    /** Creates new form SoldInventory1 */
    public SoldInventory1() {
        initComponents();
         pack();
        //this.setLocationRelativeTo(null);
         dm = (DefaultTableModel) jTable1.getModel();
        dm.setRowCount(0);
        fromInventoryName();

         showAllSoldOuts();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        inventoryIdText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        printButton = new javax.swing.JButton();
        showAllSoldInventory = new javax.swing.JButton();
        inventoryNameCombo = new javax.swing.JComboBox();
        showAllSoldInventory1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Sold Inventory History");

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        jLabel1.setText("Inventory Id"); // NOI18N

        jLabel2.setText("Inventory Name"); // NOI18N

        inventoryIdText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventoryIdTextActionPerformed(evt);
            }
        });
        inventoryIdText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inventoryIdTextKeyPressed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(204, 204, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Inventory Id", "Name", "Quantity", "Amount", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setText("                Inventory History"); // NOI18N

        jTextPane2.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane2.setEditable(false);
        jTextPane2.setFont(new java.awt.Font("Tahoma", 0, 18));
        jTextPane2.setText("                               Sold Out Inventory History"); // NOI18N
        jScrollPane3.setViewportView(jTextPane2);

        jTextPane3.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane3.setEditable(false);
        jTextPane3.setFont(new java.awt.Font("Tahoma", 0, 12));
        jTextPane3.setText("Check your Payaccount for all the sold out inventories."); // NOI18N
        jScrollPane4.setViewportView(jTextPane3);

        printButton.setText("Print"); // NOI18N
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        showAllSoldInventory.setText("Show All"); // NOI18N
        showAllSoldInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllSoldInventoryActionPerformed(evt);
            }
        });

        inventoryNameCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        inventoryNameCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inventoryNameComboMouseClicked(evt);
            }
        });
        inventoryNameCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventoryNameComboActionPerformed(evt);
            }
        });

        showAllSoldInventory1.setText("Close"); // NOI18N
        showAllSoldInventory1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllSoldInventory1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(318, Short.MAX_VALUE))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inventoryIdText, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(inventoryNameCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(186, 186, 186)
                            .addComponent(showAllSoldInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(showAllSoldInventory1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(inventoryIdText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inventoryNameCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(45, 45, 45)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(printButton)
                    .addComponent(showAllSoldInventory1)
                    .addComponent(showAllSoldInventory))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void inventoryIdTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventoryIdTextActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_inventoryIdTextActionPerformed

    private void inventoryIdTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inventoryIdTextKeyPressed
        int keycode=evt.getKeyCode();
        if(keycode==KeyEvent.VK_ENTER)
            inventoryIdWiseSellFilter();
        // TODO add your handling code here:
}//GEN-LAST:event_inventoryIdTextKeyPressed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed

         try
        {
        String s="Sold out Inventory Result";
        MessageFormat header=new MessageFormat(s);
        jTable1.print(PrintMode.FIT_WIDTH, header, null);
        }

        catch(Exception e)
        {
         System.err.println("Error in printing sold out inventory");
        }
}//GEN-LAST:event_printButtonActionPerformed

    private void showAllSoldInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAllSoldInventoryActionPerformed
        showAllSoldOuts();        // TODO add your handling code here:
}//GEN-LAST:event_showAllSoldInventoryActionPerformed

    private void inventoryNameComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventoryNameComboMouseClicked
        inventoryNameWiseSellFilter();
}//GEN-LAST:event_inventoryNameComboMouseClicked

    private void inventoryNameComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventoryNameComboActionPerformed
     
}//GEN-LAST:event_inventoryNameComboActionPerformed

    private void showAllSoldInventory1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAllSoldInventory1ActionPerformed
        this.dispose();
}//GEN-LAST:event_showAllSoldInventory1ActionPerformed

public void fromInventoryName()
   {
        try{
       ps = con.prepareStatement("select * from inventorydeposit where type=0");

             rs = ps.executeQuery();
            while (rs.next())
        inventoryNameCombo.addItem(rs.getString(3));
           System.out.println("database closed");

    }
    catch(Exception e)
    {
        System.err.println("Error is"+e);
    }
   }

    public void showAllSoldOuts()
    {
        int i = 0,j=0;
  try
        {
            ps = con.prepareStatement("select * from studentinventorypurchase");
            //ps.setInt(1, Integer.parseInt(jTextField1.getText()));
            rs = ps.executeQuery();
            if(rs.next())
            {
            rs.first();
            rs.previous();
            while(rs.next())

            {
                j++;
            }
            rs.first();
            //jTextField2.setText(rs.getString(4));
            rs.previous();
            dm.setRowCount(j);
            while(rs.next())
            {
                dm.setValueAt(rs.getInt(1), i, 0);//inventoryid
                dm.setValueAt(rs.getString(2), i, 1);//inventoryname
                dm.setValueAt(rs.getDouble(4), i, 2);//inventoryquantity
                dm.setValueAt(rs.getDouble(5), i, 3);//inventoryamount
                dm.setValueAt(rs.getString(6), i, 4);//date



                i++;

            }
          //  con.close();
            System.out.println("database closed");
        }
  }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

     public void findSoldOutInventoryName()
    {
        try
        {
            ps = con.prepareStatement("select * from studentinventorypurchase where inventoryid=?");

            ps.setInt(1, Integer.parseInt(inventoryIdText.getText()));
            rs = ps.executeQuery();
            while(rs.next())
                inventoryNameCombo.setSelectedItem(rs.getString(2).toString());
            System.out.println("assdsdsd");
        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }
    public void inventoryNameWiseSellFilter()
    {
         int i = 0,j=0;
    try
        {
            ps = con.prepareStatement("select * from studentinventorypurchase where inventoryname=?");
            ps.setString(1, inventoryNameCombo.getSelectedItem().toString());
            rs = ps.executeQuery();
            while(rs.next())

            {
                j++; inventoryIdText.setText(String.valueOf(rs.getInt(1)));
            }

            rs.first();
            rs.previous();
            dm.setRowCount(j);
            while(rs.next())
            {
                dm.setValueAt(rs.getInt(1), i, 0);//inventoryid
                dm.setValueAt(rs.getString(2), i, 1);//inventoryname
                dm.setValueAt(rs.getDouble(4), i, 2);//inventoryquantity
                dm.setValueAt(rs.getDouble(5), i, 3);//inventoryamount
                dm.setValueAt(rs.getString(6), i, 4);//date

           i++;

            }
         //   con.close();
            System.out.println("database closed");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

     public void inventoryIdWiseSellFilter()
    {
         int i = 0,j=0;
   try
        {
            ps = con.prepareStatement("select * from studentinventorypurchase where inventoryid=?");
            ps.setInt(1, Integer.parseInt(inventoryIdText.getText()));
            rs = ps.executeQuery();
            while(rs.next())

            {
                j++; inventoryIdText.setText(String.valueOf(rs.getInt(1)));
            }

            rs.first();
            rs.previous();
            dm.setRowCount(j);
            while(rs.next())
            {
                dm.setValueAt(rs.getInt(1), i, 0);//inventoryid
                dm.setValueAt(rs.getString(2), i, 1);//inventoryname
                dm.setValueAt(rs.getDouble(4), i, 2);//inventoryquantity
                dm.setValueAt(rs.getDouble(5), i, 3);//inventoryamount
                dm.setValueAt(rs.getString(6), i, 4);//date




                i++;

            }
         //   con.close();
            System.out.println("database closed");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
 public void setInventoryId(int id)
    {
        inventoryIdText.setText(String.valueOf(id));
        int keycode=KeyEvent.VK_ENTER;
        if(keycode==KeyEvent.VK_ENTER)
           inventoryIdWiseSellFilter();

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField inventoryIdText;
    private javax.swing.JComboBox inventoryNameCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JButton printButton;
    private javax.swing.JButton showAllSoldInventory;
    private javax.swing.JButton showAllSoldInventory1;
    // End of variables declaration//GEN-END:variables
//private Connection con;
    private  PreparedStatement ps;
    ResultSet rs;
}
