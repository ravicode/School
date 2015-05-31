/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EnterCharityData.java
 *
 * Created on Oct 7, 2009, 2:41:59 AM
 */

package com.duc.SpecialDepartment.MoreSection.Charity;
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
public class EnterCharityData extends javax.swing.JInternalFrame {
DefaultTableModel dm;
    /** Creates new form EnterCharityData */
    public EnterCharityData() {
        initComponents();
         pack();
        //this.setLocationRelativeTo(null);
        //setLocation(150,50);
        dm = (DefaultTableModel)jTable1.getModel();
        dm.setRowCount(0);

         showAddedDonar();
    }
public void updateDonarRecord()
    {
      itemname.setEditable(false);
//con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
try
{
    ps=con.prepareStatement("update charityobtained  set usedfor=?,amount=?,otheritem=?,remarks=?,date=? where charityobtainedfrom=? and serial=?");


    ps.setString(1,receivedby.getText());

    ps.setDouble(2,Double.parseDouble(amountgiven.getText()));
 ps.setString(3,otheritem.getText());

    ps.setString(4, remarks.getText());
     ps.setString(5,datum);
    ps.setString(6,itemname.getText());
    ps.setInt(7,Integer.parseInt(donarid.getText()));
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
int id=Integer.parseInt(jTable1.getValueAt(currentrow,1).toString());
//con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
try
{
    ps=con.prepareStatement("Select * from charityobtained where charityobtainedfrom=? and serial=?");
  ps.setString(1,productname);
  ps.setInt(2, id);
   rs= ps.executeQuery();
   rs.next();
    System.out.println("Now set the data to each field");
    itemname.setText(rs.getString(1));


    receivedby.setText(rs.getString(2));

    amountgiven.setText(String.valueOf(rs.getDouble(3)));
 otheritem.setText(rs.getString(4));
    remarks.setText(rs.getString(5));
    issuedon.setText(rs.getString(6));
donarid.setText(String.valueOf(rs.getInt(8)));

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
         ps=con.prepareStatement("delete from charityobtained where charityobtainedfrom=? and serial=?");

         ps.setString(1,dm.getValueAt(row, 0).toString());
         ps.setInt(2,Integer.parseInt(dm.getValueAt(row, 1).toString()));
         ps.executeUpdate();
         dm.removeRow(row);
         // con.close();
         System.out.println("DataBase Conection Closed");
    }
        catch(Exception e)
        {
            System.err.println("Error"+e);
        }

    }

    public void addDonar()
    {
        if(itemname.getText().isEmpty())
            JOptionPane.showConfirmDialog(null,"No Donar Filled","Donar Blank Alarm",JOptionPane.OK_CANCEL_OPTION);
    else
{
       // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
 try
 {
     ps=con.prepareStatement("insert into charityobtained (charityobtainedfrom,usedfor,amount,otheritem,remarks,date,ledgercode) values(?,?,?,?,?,?,?)");
 ps.setString(1,itemname.getText());

  ps.setString(2,receivedby.getText());

 ps.setDouble(3,Double.parseDouble(amountgiven.getText()));
 ps.setString(4,otheritem.getText());
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
           ps = con.prepareStatement("select * from charityobtained");
System.out.println("done2");
           rs = ps.executeQuery();
           System.out.println("done3");
            int i = 0,j=0;
          while(rs.next() )
            {
                j++;

            }
            rs.first();
            System.out.println("done6");
            rs.previous();
            System.out.println("done7");
            dm.setRowCount(j);
            while(rs.next())
            {
                dm.setValueAt(rs.getString(1), i, 0);
                //System.out.println("done6");
                dm.setValueAt(rs.getInt(8), i, 1);

                i++;
            }
           // donarid.setText(String.valueOf(rs.getInt(8)));
         //   con.close();
            System.out.println("Database closed");

       }
       catch(Exception e)
       {
          e.printStackTrace();
       }
    }
public void addToRespectiveLedger()
{
int ledcode=0;
    double netbalance=0.0;
    //con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
      ps=con.prepareStatement("Select * from ledgerotherfeeheadcode where feehead=?");
         ps.setString(1,"Charity Obtained");
         rs=ps.executeQuery();
        // System.out.println("FFFFFFFFFFFFFFFFFF");
         if(rs.next())
         ledcode=rs.getInt(2);

         ps=con.prepareStatement("select * from ledgeraccount where ledgercode=?");
             ps.setInt(1,ledcode);
             rs=ps.executeQuery();
             while(rs.next())
             {
                 netbalance=rs.getDouble(3)+Double.parseDouble(amountgiven.getText());

                 ps=con.prepareStatement("update ledgeraccount set paid=? where ledgercode=?");
                 ps.setDouble(1, netbalance);
                 ps.setInt(2,ledcode);
                 ps.executeUpdate();
             }
                  ps=con.prepareStatement("insert into ledgercreditdebitrecord (ledgercode,transactiontype,head,subhead,amount,date) values(?,?,?,?,?,?)");
    ps.setInt(1,ledcode);
    ps.setString(2,"Deb.");
    ps.setString(3,"Charity Obtained");
    ps.setString(4,"Donar="+itemname.getText());
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
        itemname = new javax.swing.JTextField();
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
        jLabel5 = new javax.swing.JLabel();
        otheritem = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        amountgiven = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        issuedon = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        donarid = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        admissionfeecheckbox2 = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jTextPane2.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane2.setEditable(false);
        jTextPane2.setFont(new java.awt.Font("Tahoma", 0, 24));
        jTextPane2.setText("                                   Charity Obtained Record         "); // NOI18N
        jTextPane2.setAutoscrolls(false);
        jScrollPane2.setViewportView(jTextPane2);

        jLabel1.setText("Donar"); // NOI18N

        jLabel2.setText("Date"); // NOI18N

        jLabel4.setText("Received By"); // NOI18N

        jLabel10.setText("List of Donars"); // NOI18N

        itemname.setBackground(new java.awt.Color(204, 204, 204));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel12.setText("Remarks"); // NOI18N

        remarks.setColumns(20);
        remarks.setRows(5);
        jScrollPane5.setViewportView(remarks);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "            Donar  List", "Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
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

        jButton3.setText("Show Donar"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Delete Donar"); // NOI18N
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

        jLabel5.setText("Other"); // NOI18N

        jLabel6.setText("Amount Given"); // NOI18N

        amountgiven.setText("0");

        jTextPane3.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane3.setEditable(false);
        jTextPane3.setText("Maintain the record of charity obtained"); // NOI18N
        jScrollPane3.setViewportView(jTextPane3);

        issuedon.setBackground(new java.awt.Color(153, 153, 153));
        issuedon.setEditable(false);

        jLabel3.setText("Donar Id"); // NOI18N

        donarid.setBackground(new java.awt.Color(204, 204, 204));
        donarid.setEditable(false);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(555, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(369, 369, 369))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(admissionfeecheckbox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 443, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(235, 235, 235))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(donarid, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(receivedby)
                                        .addComponent(amountgiven, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                        .addComponent(otheritem, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
                                    .addComponent(issuedon, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(itemname, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(194, 194, 194)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(67, 67, 67)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(266, 266, 266))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap())))))))
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
                            .addComponent(itemname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(receivedby, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton4))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(amountgiven, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(otheritem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(issuedon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(donarid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(admissionfeecheckbox2)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
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
        showDonarDetail();
        // TODO add your handling code here:
}//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try
        {
        ps=con.prepareStatement("select * from ledgerotherfeeheadcode where feehead=?");
            ps.setString(1,"Charity Obtained");
            rs=ps.executeQuery();
            if(!rs.next())
            {
                 ps=con.prepareStatement("insert into ledgerotherfeeheadcode (feehead) values(?)");
                ps.setString(1,"Charity Obtained");
                ps.executeUpdate();
            }
      //  else
        {
        addDonar();
        addToRespectiveLedger();
        }
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }// TODO add your handling code here:
}//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(itemname.getText().isEmpty())
            JOptionPane.showConfirmDialog(null,"No Product for Update","Product Blanck Alarm",JOptionPane.OK_CANCEL_OPTION);
        else
            updateDonarRecord();        // TODO add your handling code here:
}//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        deleteDonar();        // TODO add your handling code here:
}//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.dispose();        // TODO add your handling code here:
}//GEN-LAST:event_jButton6ActionPerformed

    private void admissionfeecheckbox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admissionfeecheckbox2ActionPerformed

        com.duc.FeeDepartment.LedgerSection.Setup.LedgerOtherFeeHeadSetup r=new com.duc.FeeDepartment.LedgerSection.Setup.LedgerOtherFeeHeadSetup();

        r.setVisible(true);
        this.add(r,0);
}//GEN-LAST:event_admissionfeecheckbox2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        showAddedDonar();
}//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox admissionfeecheckbox2;
    private javax.swing.JTextField amountgiven;
    private javax.swing.JTextField donarid;
    private javax.swing.JTextField issuedon;
    private javax.swing.JTextField itemname;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JTextField otheritem;
    private javax.swing.JTextField receivedby;
    private javax.swing.JTextArea remarks;
    // End of variables declaration//GEN-END:variables
//Connection con;
ResultSet rs;
 PreparedStatement ps;
 int currentrow=0;
}
