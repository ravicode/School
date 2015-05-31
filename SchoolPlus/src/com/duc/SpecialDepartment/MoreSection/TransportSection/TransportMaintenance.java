/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TransportMaintenance.java
 *
 * Created on Oct 6, 2009, 2:02:47 AM
 */

package com.duc.SpecialDepartment.MoreSection.TransportSection;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import static com.duc.DatabaseConnection.DatabaseConnection.*;
/**
 *
 * @author Ravi Dangaich
 */
public class TransportMaintenance extends javax.swing.JInternalFrame {
DefaultTableModel dm;
    /** Creates new form TransportMaintenance */
    public TransportMaintenance() {
        initComponents();
        pack();
        
        dm = (DefaultTableModel)jTable1.getModel();
        dm.setRowCount(0);
         fromRouteBusSetup();
    }

     public void fromRouteBusSetup()
{
   // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
        ps=con.prepareStatement("select * from transportroutebussetup");

      rs = ps.executeQuery();
           while (rs.next())
        busCombo.addItem(rs.getString(2));
}
    catch(SQLException e)
    {
        e.printStackTrace();
    }
}
public void updateDonarRecord()
    {

//con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
try
{
    ps=con.prepareStatement("update transportmaintenance  set receivedby=?,particulars=?,cost=?,maintenanceremarks=?,date=? where busno=?");


    ps.setString(1,receivedby.getText());
    ps.setString(2,litres.getText());
    ps.setDouble(3,Double.parseDouble(amountgiven.getText()));
    ps.setString(4, remarks.getText());
     ps.setString(5,datum);
    ps.setString(6,busCombo.getSelectedItem().toString());
    ps.executeUpdate();
    System.out.println("data updated");

}catch(Exception e)
{
e.printStackTrace();
}

    }
 public void showDonarDetail()
    {
        currentrow=jTable1.getSelectedRow();

String productname=jTable1.getValueAt(currentrow,0).toString();
//con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
try
{
    ps=con.prepareStatement("Select * from transportmaintenance where busno=?");
  ps.setString(1,productname);
   rs= ps.executeQuery();
   rs.next();
    System.out.println("Now set the data to each field");
   busCombo.setSelectedItem(rs.getString(1));


    receivedby.setText(rs.getString(2));
litres.setText(rs.getString(3));
    amountgiven.setText(String.valueOf(rs.getDouble(4)));

    remarks.setText(rs.getString(5));
    issuedon.setText(rs.getString(6));


}catch(Exception e)
{
e.printStackTrace();
}

    }
    public void deleteDonar()
    {
        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        int row = jTable1.getSelectedRow();
         System.out.println("row no. selected"+row);
        try
        {
         ps=con.prepareStatement("delete from transportmaintenance where busno=?");

         ps.setString(1,dm.getValueAt(row, 0).toString());
         ps.executeUpdate();
         dm.removeRow(row);
          //con.close();
         System.out.println("DataBase Conection Closed");
    }
        catch(Exception e)
        {
            System.err.println("Error"+e);
        }

    }

    public void addDonar()
    {
        if(busCombo.getSelectedItem().toString().equals("choose"))
            JOptionPane.showConfirmDialog(null,"No Bus Selected","Donar Blank Alarm",JOptionPane.OK_CANCEL_OPTION);
    else
{
       // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
 try
 {
     ps=con.prepareStatement("insert into transportmaintenance values(?,?,?,?,?,?,?)");
 ps.setString(1,busCombo.getSelectedItem().toString());

  ps.setString(2,receivedby.getText());
ps.setString(3,litres.getText());
 ps.setDouble(4,Double.parseDouble(amountgiven.getText()));

  ps.setString(5,remarks.getText());
  ps.setString(6,datum);
  ps.setInt(7,0);//ledgercode

  System.out.println("ff3");
            ps.executeUpdate();

  System.out.println("the product is entered into the database");
   //model.addElement(String.valueOf(jTextField1.getText()));

 }catch(Exception e)
 {
     e.printStackTrace();
 }

    }

   showAddedDonar();
    }

    public void showAddedDonar()
    {


    // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
       try
       {
           ps = con.prepareStatement("select * from transportmaintenance");
System.out.println("done2");
           rs = ps.executeQuery();
           System.out.println("done3");
            int i = 0,j=0;
            if(rs.next())
            {
                rs.first();

            rs.previous();
          while(rs.next() )
            {
                j++;System.out.println("done5");
            }
            rs.first();
            System.out.println("done6");
            rs.previous();
            System.out.println("done7");
            dm.setRowCount(j);
            while(rs.next())
            {
                dm.setValueAt(rs.getString(1), i, 0);
               
                i++;
            }
           // con.close();
            System.out.println("Database closed");

       }
       }
       catch(Exception e)
       {
          e.printStackTrace();
       }
    }
public void deductFromRespectiveLedger()
{
    int ledcode=0;
    double netbalance=0.0;
   // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
      ps=con.prepareStatement("Select * from ledgerotherfeeheadcode where feehead=?");
         ps.setString(1,"Transport Maintenance");
         rs=ps.executeQuery();
        // System.out.println("FFFFFFFFFFFFFFFFFF");
         if(rs.next())
         ledcode=rs.getInt(2);

         ps=con.prepareStatement("select * from ledgeraccount where ledgercode=?");
             ps.setInt(1,ledcode);
             rs=ps.executeQuery();
             while(rs.next())
             {
                 netbalance=rs.getDouble(3)-Double.parseDouble(amountgiven.getText());

                 ps=con.prepareStatement("update ledgeraccount set paid=? where ledgercode=?");
                 ps.setDouble(1, netbalance);
                 ps.setInt(2,ledcode);
                 ps.executeUpdate();
             }
             ps=con.prepareStatement("insert into ledgercreditdebitrecord (ledgercode,transactiontype,head,subhead,amount,date) values(?,?,?,?,?,?)");
 
                 ps.setInt(1,ledcode);
    ps.setString(2,"Cr.");
    ps.setString(3,"Transport Maintenance");
    ps.setString(4,"Bus No"+busCombo.getSelectedItem().toString());
    ps.setDouble(5, Double.parseDouble(amountgiven.getText()));
    ps.setString(6,datum);
    ps.executeUpdate();

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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        remarks = new javax.swing.JTextArea();
        receivedby = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        amountgiven = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        issuedon = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        litres = new javax.swing.JTextField();
        busCombo = new javax.swing.JComboBox();
        jLabel31 = new javax.swing.JLabel();
        admissionfeecheckbox2 = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Transport Care Unit");

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jTextPane2.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane2.setEditable(false);
        jTextPane2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextPane2.setText("                                  Transport Maintenance Record         "); // NOI18N
        jTextPane2.setAutoscrolls(false);
        jScrollPane2.setViewportView(jTextPane2);

        jLabel1.setText("Bus Number"); // NOI18N

        jLabel2.setText("Date"); // NOI18N

        jLabel4.setText("Received By"); // NOI18N

        jLabel10.setText("Maintenance List"); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel12.setText("Remarks"); // NOI18N

        remarks.setColumns(20);
        remarks.setRows(5);
        jScrollPane5.setViewportView(remarks);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "            Maintenance  List"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable1);

        jButton1.setText("ADD"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Show Record"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Delete Record"); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setText("Exit"); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel6.setText("Amount Given"); // NOI18N

        amountgiven.setText("0");

        jTextPane3.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane3.setEditable(false);
        jTextPane3.setText("Maintain the record of transport maintenance ..."); // NOI18N
        jScrollPane3.setViewportView(jTextPane3);

        issuedon.setBackground(new java.awt.Color(153, 153, 153));
        issuedon.setEditable(false);

        jLabel5.setText("Particulars"); // NOI18N

        busCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        busCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busComboActionPerformed(evt);
            }
        });

        jLabel31.setText("Set Ledger"); // NOI18N

        admissionfeecheckbox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admissionfeecheckbox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(1, 1, 1))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(amountgiven, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(receivedby, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(busCombo, javax.swing.GroupLayout.Alignment.TRAILING, 0, 123, Short.MAX_VALUE)
                                        .addComponent(litres, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                                    .addComponent(issuedon, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(admissionfeecheckbox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(194, 194, 194)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(67, 67, 67)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton4)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGap(256, 256, 256))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addComponent(jLabel12)))
                .addGap(256, 256, 256))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(busCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(receivedby, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton3)
                                    .addComponent(jButton4)
                                    .addComponent(jLabel5)
                                    .addComponent(litres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton1)
                                    .addComponent(jButton2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(amountgiven, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(issuedon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                        .addComponent(jLabel12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(admissionfeecheckbox2)
                    .addComponent(jLabel31))
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addGap(59, 59, 59)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 847, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        showDonarDetail();        // TODO add your handling code here:
}//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try
        {
        ps=con.prepareStatement("select * from ledgerotherfeeheadcode where feehead=?");
            ps.setString(1,"Transport Maintenance");
            rs=ps.executeQuery();
            if(!rs.next())
            {
                 ps=con.prepareStatement("insert into ledgerotherfeeheadcode (feehead) values(?)");
                ps.setString(1,"Transport Maintenance");
                ps.executeUpdate();
            }
      //  else
        {
        addDonar();
        deductFromRespectiveLedger();
        }
       }catch(Exception e)
       {
           e.printStackTrace();
       }// TODO add your handling code here:
}//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       if(busCombo.getSelectedItem().toString().equals("choose"))
            JOptionPane.showConfirmDialog(null,"No Bus choosen ","Bus Blanck Alarm",JOptionPane.OK_CANCEL_OPTION);
        else
            updateDonarRecord();          // TODO add your handling code here:
}//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        showAddedDonar();        // TODO add your handling code here:
}//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        deleteDonar();        // TODO add your handling code here:
}//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.dispose();        // TODO add your handling code here:
}//GEN-LAST:event_jButton6ActionPerformed

    private void busComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busComboActionPerformed

       
}//GEN-LAST:event_busComboActionPerformed

    private void admissionfeecheckbox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admissionfeecheckbox2ActionPerformed

        com.duc.FeeDepartment.LedgerSection.Setup.LedgerOtherFeeHeadSetup r=new com.duc.FeeDepartment.LedgerSection.Setup.LedgerOtherFeeHeadSetup();

        r.setVisible(true);
        this.add(r,0);
}//GEN-LAST:event_admissionfeecheckbox2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox admissionfeecheckbox2;
    private javax.swing.JTextField amountgiven;
    private javax.swing.JComboBox busCombo;
    private javax.swing.JTextField issuedon;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextField litres;
    private javax.swing.JTextField receivedby;
    private javax.swing.JTextArea remarks;
    // End of variables declaration//GEN-END:variables
//Connection con;
ResultSet rs;
 PreparedStatement ps;
 int currentrow=0;
}
