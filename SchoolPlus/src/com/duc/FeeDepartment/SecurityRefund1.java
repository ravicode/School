/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SecurityRefund1.java
 *
 * Created on Sep 26, 2009, 5:11:29 PM
 */

package com.duc.FeeDepartment;
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
public class SecurityRefund1 extends javax.swing.JInternalFrame {
DefaultTableModel dm;
//DateFormat df;
//MapForIndex mp=new MapForIndex();
 HashMap classmap=mp.getClassIndexName();
  HashMap sectionmap=mp.getSectionIndexName();
  HashMap month=mp.mapMonth();
    /** Creates new form SecurityRefund1 */
    public SecurityRefund1() {
        initComponents();
        pack();
        System.out.println("con of securityRefund="+con);
        //this.setLocationRelativeTo(null);
       // df=new SimpleDateFormat("yyyy-MM-dd");
         dayFrom.setDateFormat(df);
         dayTo.setDateFormat(df);
        dm = (DefaultTableModel) jTable1.getModel();
        dm.setRowCount(0);
        
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
        dayFrom = new datechooser.beans.DateChooserCombo();
        dayTo = new datechooser.beans.DateChooserCombo();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        todaycollection = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        admissionnumber = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Security Refind Register");

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        closeButton.setFont(new java.awt.Font("Tahoma", 1, 12));
        closeButton.setForeground(new java.awt.Color(255, 0, 0));
        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Admission No.", "Class", "Section", "Roll", "Head", "Returned", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        viewButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        viewButton.setForeground(new java.awt.Color(0, 0, 255));
        viewButton.setText("View");
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });

        jTextPane2.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane2.setEditable(false);
        jTextPane2.setFont(new java.awt.Font("Tahoma", 0, 24));
        jTextPane2.setText("                                   Security Refund Register");
        jScrollPane3.setViewportView(jTextPane2);

        jTextPane3.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane3.setEditable(false);
        jTextPane3.setFont(new java.awt.Font("Tahoma", 0, 12));
        jTextPane3.setText("It will Show the Security Fee deposited by students..");
        jScrollPane4.setViewportView(jTextPane3);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("from");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setText("to");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setText("Today's Collection");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton1.setForeground(new java.awt.Color(0, 0, 255));
        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel5.setText("Adm. No.");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 255));
        jButton2.setText("Refund");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 909, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(admissionnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dayFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dayTo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(viewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 909, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(todaycollection, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 542, Short.MAX_VALUE)
                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(viewButton))
                    .addComponent(dayTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(admissionnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dayFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(closeButton)
                    .addComponent(todaycollection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        showFeeRefund();
        totalRefund();
        // TODO add your handling code here:
}//GEN-LAST:event_viewButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try
        {
        String s="Student Security Refund Result";
        MessageFormat header=new MessageFormat(s);
        jTable1.print(PrintMode.FIT_WIDTH, header, null);
        }

        catch(Exception e)
        {
         System.err.println("Error in printing student search");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        refundStudent();
    }//GEN-LAST:event_jButton2ActionPerformed

    public void refundStudent()
 {
     int feeid=0;
     //con=com.duc.DatabaseConnection.DatabaseConnection.con;
     Double refundstudent=0.0;
     int choose=JOptionPane.showConfirmDialog(null,"Do you want to refund the student","Refund Student",JOptionPane.OK_CANCEL_OPTION);
     if(choose==JOptionPane.OK_OPTION){
     refundstudent=Double.parseDouble(JOptionPane.showInputDialog("Refunded amount?"));

     try
     {
         ps=con.prepareStatement("select * from admissionfeehead where head='Security Fee'");
         rs=ps.executeQuery();
         if(rs.next())
             feeid=rs.getInt(1);

ps=con.prepareStatement("select * from feepaid where studentid=? and head=? and feetype=1");
ps.setString(1,admissionnumber.getText());

ps.setInt(2,feeid);

rs=ps.executeQuery();
if(rs.next())
{

Double deposit=rs.getDouble(5);
Double actualsecurity=rs.getDouble(3);
Double returnedvalue=rs.getDouble(7);
Double dep=0.0;
ps=con.prepareStatement("select * from studentrefund where studentid=? and type=1");
ps.setString(1,admissionnumber.getText());
rs=ps.executeQuery();
if(rs.next())
{
   dep=rs.getDouble(2);
   System.out.println("Dep="+dep);
}
deposit=deposit-dep;
if(deposit!=0.0)

{

if(deposit>=refundstudent)
{
   /* deposit=deposit-refundstudent;

    returnedvalue=returnedvalue+refundstudent;
    actualsecurity=actualsecurity- returnedvalue;
    ps=con.prepareStatement("update feepaid set paid=?,date=?,remaining=? where studentid=? and head=?");
    ps.setDouble(1, deposit);
    System.out.println("sdfdsssssssssssss");
   ps.setString(2, datum);
    ps.setDouble(3,returnedvalue);
      ps.setString(4,admissionnumber.getText());
    ps.setInt(5,feeid);
    ps.executeUpdate();*/
    Double localrefund=0.0;
ps=con.prepareStatement("select * from studentrefund where studentid=? and type=1");
ps.setString(1,admissionnumber.getText());
rs=ps.executeQuery();
if(rs.next())
{
    ps=con.prepareStatement("update studentrefund set refund=?,date=? where studentid=? and type=1");
ps.setDouble(1, (dep+refundstudent));
System.out.println("Dep+rs="+(dep+refundstudent));
ps.setString(2,datum);
    ps.setString(3,admissionnumber.getText());
    ps.executeUpdate();
}else
{
    ps=con.prepareStatement("insert into studentrefund values(?,?,?,?)");
ps.setString(1,admissionnumber.getText());

ps.setDouble(2,refundstudent);
ps.setInt(3,1);
ps.setString(4,datum);

ps.executeUpdate();


}

    //confirmmsg.setForeground(Color.GREEN);
      //                           confirmmsg.setText("Security Fee Refunded!");
                                 JOptionPane.showConfirmDialog(null,"Security Fee Refunded","Refund Student",JOptionPane.OK_CANCEL_OPTION);
                                 //confirmmsg.setForeground(Color.GREEN);
        //                         confirmmsg.setText("--------------------------Confirmation----------------------");
}else
{
    //confirmmsg.setForeground(Color.RED);
      //                           confirmmsg.setText("Entered amount>Security Fee");
    JOptionPane.showConfirmDialog(null,"Entered amount is greater than security","Refund Student",JOptionPane.OK_CANCEL_OPTION);
    // confirmmsg.setForeground(Color.GREEN);
      //                           confirmmsg.setText("--------------------------Confirmation----------------------");
}
     }

     else
     {
    //confirmmsg.setForeground(Color.RED);
      //                           confirmmsg.setText("Security Fee already Refunded!");
    JOptionPane.showConfirmDialog(null,"Security Fee already Refunded","Refund Student",JOptionPane.OK_CANCEL_OPTION);
     //confirmmsg.setForeground(Color.GREEN);
       //                          confirmmsg.setText("--------------------------Confirmation----------------------");
     }
     }
else
{
   //confirmmsg.setForeground(Color.RED);
       //                          confirmmsg.setText("No Security Fee paid by this student!");
    JOptionPane.showConfirmDialog(null,"No Security Fee paid by this student","No Refund Student",JOptionPane.OK_CANCEL_OPTION);
   // confirmmsg.setForeground(Color.GREEN);
     //                            confirmmsg.setText("--------------------------Confirmation----------------------");
}
     }catch(Exception e)
     {
e.printStackTrace();
//JOptionPane.showConfirmDialog(null,"Invalid Admission Number","Invalid Student",JOptionPane.OK_CANCEL_OPTION);
     }
     }else
     {

     }
 }

public void totalRefund()
{
   Double totaldues=0.0;
    int rowcount=dm.getRowCount();
    for(int i=0;i<rowcount;i++)
    {
        System.out.println("rd");
        totaldues+=Double.parseDouble(dm.getValueAt(i,5).toString());

    }   todaycollection.setText(String.valueOf(totaldues));
}


public void showFeeRefund()
{
    int i=0,j=0;
    int feeid=0;
    //con= com.duc.DatabaseConnection.DatabaseConnection.con;
    try
    {
        
        ps=con.prepareStatement("select studentid,class,section,roll,refund,type,date from studententry left join studentrefund on id=studentid where date>=? and date<=? and type=1 order by studentid");
        ps.setString(1,dayFrom.getText());
        ps.setString(2,dayTo.getText());
        
         //System.out.println(daybookdatechooser.getText());
        rs=ps.executeQuery();
       // System.out.println("value"+rs.next());
        while(rs.next())
            {
                j++;
            
            }
            rs.first();
            rs.previous();
            System.out.println(dayFrom.getText());
            dm.setRowCount(j);
            System.out.println(j);
            //rs.next();
            while(rs.next())
            {
            dm.setValueAt(rs.getString(1), i, 0);
                dm.setValueAt(classmap.get(rs.getInt(2)), i, 1);
                 dm.setValueAt(sectionmap.get(rs.getInt(3)), i, 2);
                 dm.setValueAt(rs.getInt(4), i, 3);
          //       if(rs.getInt(6)==1)
                dm.setValueAt("Security Fee", i, 4);
        //         else dm.setValueAt("Surplus Refund", i, 4);
                 dm.setValueAt(rs.getDouble(5), i, 5);
                 
                 dm.setValueAt(rs.getString(7), i, 6);
                 i++;
        }
 //System.out.println(rs.getString(9));
    }catch(Exception e)
    {
e.printStackTrace();
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField admissionnumber;
    private javax.swing.JButton closeButton;
    private datechooser.beans.DateChooserCombo dayFrom;
    private datechooser.beans.DateChooserCombo dayTo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JTextField todaycollection;
    private javax.swing.JButton viewButton;
    // End of variables declaration//GEN-END:variables
//Connection con;
ResultSet rs;
PreparedStatement ps;
}
