/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DepositInventory1.java
 *
 * Created on Sep 30, 2009, 9:34:12 AM
 */

package com.duc.SpecialDepartment.InventorySection.InventoryDepartment;
import java.sql.*;
import java.util.HashMap;
//import javax.swing.JOptionPane
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
        import static com.duc.DatabaseConnection.DatabaseConnection.*;

/**
 *
 * @author Ravi Dangaich
 */
public class DepositInventory1 extends javax.swing.JInternalFrame {
//MapForInventoryIndex mpi=new MapForInventoryIndex();
    HashMap schoolpurchaser1=mpi.getSchoolPurchaserIndexFromName();
     HashMap schoolpurchaser=mpi.getSchoolPurchaserIndexToName();
    HashMap invname1=mpi.getInventoryNameToIndex();
    DefaultTableModel dm;
    /** Creates new form DepositInventory1 */
    public DepositInventory1() {
        initComponents();
        pack();
     dm = (DefaultTableModel) jTable1.getModel();
        dm.setRowCount(0);

        fromSchoolAuthorizedPurchaser();
        fromInventoryName();
    }
public void  fromSchoolAuthorizedPurchaser()
   {
        try{

//con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

         ps = con.prepareStatement("select * from schoolpurchasersetup");

             rs = ps.executeQuery();


            while (rs.next())
        currentPurchaserCombo.addItem(rs.getString(1));



    }
    catch(Exception e)
    {
        System.err.println("Error is"+e);
    }
   }

   public void fromInventoryName()
   {
        try{

//con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
         ps = con.prepareStatement("select * from inventorydeposit");

             rs = ps.executeQuery();

//inventoryName.removeAllItems();
            while (rs.next())
        inventoryName.addItem(rs.getString(3));



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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        inventoryName = new javax.swing.JComboBox();
        lastPurchaseBy = new javax.swing.JTextField();
        lastPurchaseDate = new javax.swing.JTextField();
        availableQuantity = new javax.swing.JTextField();
        depositQuantity = new javax.swing.JTextField();
        newUpdatedQuantity = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane4 = new javax.swing.JTextPane();
        currentPurchaserCombo = new javax.swing.JComboBox();
        updateButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        sellingprice = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Inventory Deposit");

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel2.setText("Inventory Name");

        jLabel3.setText("Last Purchase By");

        jLabel4.setText("Last Purchase Date");

        jLabel5.setText("Current Purchaser");

        jLabel6.setText(" Available Quantity");

        jLabel7.setText("Deposit Quantity");

        jLabel8.setText("New Updated Quantity");

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

        depositQuantity.setText("0");

        newUpdatedQuantity.setBackground(new java.awt.Color(255, 204, 204));
        newUpdatedQuantity.setEditable(false);

        jTextPane3.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane3.setEditable(false);
        jTextPane3.setFont(new java.awt.Font("Tahoma", 0, 18));
        jTextPane3.setText("                          Deposit Existing Inventory");
        jScrollPane3.setViewportView(jTextPane3);

        jTextPane4.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane4.setEditable(false);
        jTextPane4.setText("Deposit existing inventories. Rememeber if any of the entries except purchaser chaser like new C.P, New S.P,New Mode, New Vendor then you must treat this inventory as the fresh one and add that by Add Fresh Inventory menuitem.");
        jScrollPane4.setViewportView(jTextPane4);

        currentPurchaserCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        currentPurchaserCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentPurchaserComboActionPerformed(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Purchaser", "Av. Quantity", "De. Quantity", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable1);

        jLabel9.setText("Selling Price");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                        .addGap(29, 29, 29))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                        .addGap(29, 29, 29))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                        .addGap(29, 29, 29)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(sellingprice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(currentPurchaserCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lastPurchaseDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addComponent(lastPurchaseBy)
                    .addComponent(availableQuantity)
                    .addComponent(inventoryName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(depositQuantity)
                    .addComponent(newUpdatedQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(inventoryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lastPurchaseBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lastPurchaseDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(currentPurchaserCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(sellingprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(availableQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(depositQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newUpdatedQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(exitButton)
                    .addComponent(updateButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void inventoryNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventoryNameMouseClicked
      /* updateButton.setEnabled(true);
        inventoryNameFilter4Deposit();
        viewDepositByName();*/
}//GEN-LAST:event_inventoryNameMouseClicked

    private void inventoryNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_inventoryNameItemStateChanged
        // inventoryNameFilter4Deposit();
}//GEN-LAST:event_inventoryNameItemStateChanged

    private void inventoryNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventoryNameActionPerformed
 updateButton.setEnabled(true);
        inventoryNameFilter4Deposit();
        viewDepositByName();
}//GEN-LAST:event_inventoryNameActionPerformed

    private void currentPurchaserComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentPurchaserComboActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_currentPurchaserComboActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed

        if(depositQuantity.getText().equals(""))
            JOptionPane.showConfirmDialog(null,"Deposit Field Blank", " No deposit Alarm",JOptionPane.OK_CANCEL_OPTION);
        else
        {
            if(Double.parseDouble(depositQuantity.getText().toString())<0.0 || depositQuantity.getText().equals("0") || depositQuantity.getText().isEmpty())
            {
                 JOptionPane.showConfirmDialog(null,"Deposit Field Invalid", " No deposit Alarm",JOptionPane.OK_CANCEL_OPTION);
            }
                else
                {
                    if(currentPurchaserCombo.getSelectedItem().toString().equals("choose"))
            {
                JOptionPane.showConfirmDialog(null,"Current Purchaser??", "Set Current Purchaser",JOptionPane.OK_CANCEL_OPTION);

            }
            else
            {
                if(inventoryName.getSelectedItem().toString().equals("choose"))
            {
                JOptionPane.showConfirmDialog(null,"Inventory Selected??", "Set Inventory Name",JOptionPane.OK_CANCEL_OPTION);

            }
                else
                {
            updateButton.setEnabled(false);
            depositOldInventory();
            depositOldHistory();
            }
        }
        }
            }

}//GEN-LAST:event_updateButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        this.dispose();        // TODO add your handling code here:
}//GEN-LAST:event_exitButtonActionPerformed


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
            while(rs.next())
            {
                j++;
            }
            rs.first();
            rs.previous();

            dm.setRowCount(j);
            System.out.println(j);
            //rs.next();
            while(rs.next())
            {
           // dm.setValueAt(invname.get(rs.getInt(1)), i, 0);
                dm.setValueAt(schoolpurchaser.get(rs.getInt(2)), i, 0);
                 dm.setValueAt(rs.getDouble(3), i, 1);
                  dm.setValueAt(rs.getDouble(4), i, 2);
            dm.setValueAt(rs.getString(5), i, 3);


                 i++;
        }
    }catch(Exception e)
    {
e.printStackTrace();
    }
}
    public void depositOldHistory()
    {
        try
        {
            ps=con.prepareStatement("insert into involddeposit values(?,?,?,?,?)");
            ps.setInt(1, Integer.parseInt(invname1.get(inventoryName.getSelectedItem()).toString()));
            ps.setInt(2,Integer.parseInt(schoolpurchaser1.get(currentPurchaserCombo.getSelectedItem()).toString()));


             ps.setDouble(3, Double.parseDouble(availableQuantity.getText()));
             ps.setDouble(4, Double.parseDouble(depositQuantity.getText()));
             ps.setString(5,datum);
             ps.executeUpdate();

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

public void depositOldInventory()
{
    Double newquantity= Double.parseDouble(availableQuantity.getText())+Double.parseDouble(depositQuantity.getText());
    newUpdatedQuantity.setText(newquantity.toString());
   //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
        ps=con.prepareStatement("update inventorydeposit set purchaserepresentative=?,sellingprice=?,invdeposit=?,time=? where InventoryId=?");

        ps.setInt(1,Integer.parseInt(schoolpurchaser1.get(currentPurchaserCombo.getSelectedItem().toString()).toString()));
        ps.setDouble(2,Double.parseDouble(sellingprice.getText()));
        ps.setDouble(3, newquantity);
        ps.setString(4,datum);
        ps.setInt(5,Integer.parseInt(invname1.get(inventoryName.getSelectedItem().toString()).toString()));
        ps.executeUpdate();
        //con.close();
        System.out.println("Database closed");

    }catch(Exception e)
    {
        e.printStackTrace();
    }

}
    public void inventoryNameFilter4Deposit()
    {
    //  con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        try
        {
            ps = con.prepareStatement("select * from inventorydeposit where InventoryId=?");
            ps.setInt(1, Integer.parseInt(invname1.get(inventoryName.getSelectedItem().toString()).toString()));
             rs = ps.executeQuery();
            int i = 0,j=0;

 if(rs.next())
 {



               lastPurchaseBy.setText(schoolpurchaser.get(rs.getInt(11)).toString());

                lastPurchaseDate.setText(rs.getString(15));
                currentPurchaserCombo.setSelectedIndex(0);

                sellingprice.setText(String.valueOf(rs.getDouble(8)));
                availableQuantity.setText(String.valueOf(rs.getDouble(5)));

depositQuantity.setText(" ");
newUpdatedQuantity.setText(" ");
//currentPurchaserCombo.setSelectedIndex(0);

 }

        }  catch(Exception e)
        {
            e.printStackTrace();
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField availableQuantity;
    private javax.swing.JComboBox currentPurchaserCombo;
    private javax.swing.JTextField depositQuantity;
    private javax.swing.JButton exitButton;
    private javax.swing.JComboBox inventoryName;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextPane jTextPane4;
    private javax.swing.JTextField lastPurchaseBy;
    private javax.swing.JTextField lastPurchaseDate;
    private javax.swing.JTextField newUpdatedQuantity;
    private javax.swing.JTextField sellingprice;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
//private Connection con;
    private  PreparedStatement ps;
    ResultSet rs;
    public int screenheight,screenwidth;
}