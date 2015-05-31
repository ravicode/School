/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RollBack1.java
 *
 * Created on Jan 12, 2010, 12:13:56 AM
 */

package com.duc.Accessories;
import com.duc.ImportSection.MapForIndex;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static com.duc.DatabaseConnection.DatabaseConnection.*;
/**
 *
 * @author Ravi
 */
public class RollBack1 extends javax.swing.JInternalFrame {
DefaultTableModel dm1;
//MapForIndex mp=new MapForIndex();
HashMap classmap1=mp.getClassIndexFromName();
HashMap classmap=mp.getClassIndexName();

 HashMap admissionfeemap=mp.getAdmissionFeeIndexToName();
    HashMap periodicfeemap=mp.getPeriodicFeeIndexToName();

    HashMap monthlyfeemap=mp.getMonthlyFeeIndexToName();
    HashMap otherfeemap=mp.getLedgerOtherFeeIndexToName();

    HashMap headfeetypemap=mp.getFeeHeadIndexFromFeeTypeInFeeDues();

     HashMap admissionfeemap1=mp.getAdmissionFeeIndexFromName();
    HashMap periodicfeemap1=mp.getPeriodicFeeIndexFromName();

    HashMap monthlyfeemap1=mp.getMonthlyFeeIndexFromName();
    HashMap otherfeemap1=mp.getLedgerOtherFeeIndexFromName();
     HashMap month=mp.mapMonth();
    HashMap month1=mp.mapMonth1();
    /** Creates new form RollBack1 */
    public RollBack1() {
        initComponents();
         System.out.println("con of Rollback="+con);
       /*  dm1 = (DefaultTableModel)jTable1.getModel();
        dm1.setRowCount(0);
       

        buttonGroup1.add(jRadioButton1);
         buttonGroup1.add(jRadioButton2);
          buttonGroup1.add(jRadioButton3);*/
          fromClass();

fromSession();
    }
 public void fromMonthlyFee()
    {
 int i = 0,j=0;
        //con=com.duc.DatabaseConnection.DatabaseConnection.con;
       try
       {
           ps = con.prepareStatement("select * from monthlyfeeamounthead where class=?");
           ps.setInt(1,Integer.parseInt(classmap1.get(classCombo.getSelectedItem()).toString()));

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
            rs.previous();
            dm1.setRowCount(j);
            while(rs.next())
            {
                dm1.setValueAt(monthlyfeemap.get(rs.getInt(1)), i, 0);
                dm1.setValueAt(rs.getDouble(2), i, 1);

                i++;
            }
           // con.close();
            System.out.println("Database closed");
            }
       }
       catch(Exception e)
       {
           System.err.println("Error"+e);
       }
    }
    public void fromAdmissonFee()
    {
        int i = 0,j=0;
       //con=com.duc.DatabaseConnection.DatabaseConnection.con;
       try
       {
           ps = con.prepareStatement("select * from admissionfeeamounthead where class=?");
           ps.setInt(1,Integer.parseInt(classmap1.get(classCombo.getSelectedItem()).toString()));

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
            rs.previous();
            dm1.setRowCount(j);
            while(rs.next())
            {
                dm1.setValueAt(admissionfeemap.get(rs.getInt(1)), i, 0);
                dm1.setValueAt(rs.getDouble(2), i, 1);

                i++;
            }

            //con.close();
            System.out.println("Database closed");
            }
       }
       catch(Exception e)
       {
           System.err.println("Error"+e);
       }
    }
    public void fromPeriodicFee()
    {
 int i = 0,j=0;
       //con=com.duc.DatabaseConnection.DatabaseConnection.con;
       try
       {
           ps = con.prepareStatement("select * from periodicfeeamounthead where class=?");
           ps.setInt(1,Integer.parseInt(classmap1.get(classCombo.getSelectedItem()).toString()));

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
            rs.previous();
            dm1.setRowCount(j);
            while(rs.next())
            {
                dm1.setValueAt(periodicfeemap.get(rs.getInt(1)), i, 0);
                dm1.setValueAt(rs.getDouble(2), i, 1);

                i++;
            }
           // con.close();
            System.out.println("Database closed");
            }
       }
       catch(Exception e)
       {
           System.err.println("Error"+e);
       }
    }
 public void fromClass()
    {
         try
    {

 //con=com.duc.DatabaseConnection.DatabaseConnection.con;
//con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

         ps = con.prepareStatement("select * from classsetup");

             rs = ps.executeQuery();


            while (rs.next())
            {
        classCombo.addItem(rs.getString(1));


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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        admissionnumber = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        classCombo = new javax.swing.JComboBox();
        monthCombo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        confirmmsg = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Roll-Back Section");

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setText("Std. Id");

        admissionnumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                admissionnumberKeyPressed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton5.setForeground(new java.awt.Color(0, 0, 255));
        jButton5.setText("Roll-Back Student");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setText("Name");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(admissionnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton5)
                    .addComponent(admissionnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton1.setForeground(new java.awt.Color(0, 0, 255));
        jButton1.setText("Roll-Back Class");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        classCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));

        monthCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("Class");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setText("Month");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(classCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(monthCombo, 0, 135, Short.MAX_VALUE)
                .addGap(154, 154, 154))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(monthCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 1, 16));
        jTextPane1.setText("                                             Roll-Back Data");
        jScrollPane1.setViewportView(jTextPane1);

        jTextPane2.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane2.setEditable(false);
        jTextPane2.setText("Roll-Back Student-> Write StudentId and Enter and then selected the month and respective fee and Click \"Roll-Back Student Button\"...Simillarly for Roll-Back Class...");
        jScrollPane2.setViewportView(jTextPane2);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel5.setText("          Roll-Back Student");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel6.setText("                 Roll-Back Class");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21)
                .addComponent(confirmmsg, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addGap(79, 79, 79))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(292, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(confirmmsg)
                        .addGap(29, 29, 29)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void admissionnumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_admissionnumberKeyPressed

        int keycode=evt.getKeyCode();
        if(keycode==KeyEvent.VK_ENTER) {
            if(!admissionnumber.getText().isEmpty()) {
                confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
                getStudentName();


            }else {confirmmsg.setForeground(Color.RED);
            confirmmsg.setText("Admission No. Empty");
            JOptionPane.showConfirmDialog(null,"Admission No. Empty","Admission No. empty",JOptionPane.OK_CANCEL_OPTION);
            }
        }
}//GEN-LAST:event_admissionnumberKeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       int select=JOptionPane.showConfirmDialog(null,"Student Roll-Back","Student Roll-Back",JOptionPane.OK_OPTION);
        if(select==JOptionPane.OK_OPTION)
        {
        removeIndividualDues();
        removeIndividualPaid();
        }
}//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int select=JOptionPane.showConfirmDialog(null,"Class Roll-Back","Class Roll-Back",JOptionPane.OK_OPTION);
        if(select==JOptionPane.OK_OPTION)
        {
        removeFeeDues();
        removeFeePaid();
        }

}//GEN-LAST:event_jButton1ActionPerformed
public void fromSession()
    {
         try
       {
           ps = con.prepareStatement("select sessiontitle,sessionid,status from sessionsetup ");

           rs = ps.executeQuery();
           // int i = 0,j=0;
          while(rs.next())
            {
                //j++;
             // sessionCombo.addItem(rs.getString(1));

              if(rs.getInt(3)==1)
                  sessionVal=rs.getInt(2);

            }
      }
         catch(Exception e)
         {
             e.printStackTrace();
    }



    }
    public void removeIndividualDues()
    {
        //int currentrow=jTable1.getSelectedRow();
        try
        {

             ps=con.prepareStatement("select ledgercode,dues from feedues where  studentid=? and month=? and session=?");

      ps.setString(1,admissionnumber.getText());
       ps.setInt(2,Integer.parseInt(month1.get(monthCombo.getSelectedItem()).toString()));


 /*      if(jRadioButton1.isSelected())
       ps.setInt(3, Integer.parseInt(monthlyfeemap1.get(jTable1.getValueAt(currentrow,0)).toString()));
       if(jRadioButton2.isSelected())
       ps.setInt(3, Integer.parseInt(admissionfeemap1.get(jTable1.getValueAt(currentrow,0)).toString()));
       if(jRadioButton3.isSelected())
       ps.setInt(3, Integer.parseInt(periodicfeemap1.get(jTable1.getValueAt(currentrow,0)).toString()));*/
       ps.setInt(3,sessionVal);
rs3=ps.executeQuery();
while(rs3.next())
{
          ps=con.prepareStatement("select dues from ledgeraccount where ledgercode=?");
       ps.setInt(1,rs3.getInt(1));
       rs4=ps.executeQuery();
       if(rs4.next())
       {
           ps=con.prepareStatement("update ledgeraccount set dues=? where ledgercode=?");
           ps.setDouble(1, rs4.getDouble(1)-rs3.getDouble(2));
            //ps.setDouble(2, rs4.getDouble(2)-rs3.getDouble(2));
            ps.setInt(2,rs3.getInt(1));

           ps.executeUpdate();
       }


           ps=con.prepareStatement("delete from feedues where studentid=? and month=? and session=?");
       ps.setString(1,admissionnumber.getText());
       ps.setInt(2,Integer.parseInt(month1.get(monthCombo.getSelectedItem()).toString()));


     /*  if(jRadioButton1.isSelected())
       ps.setInt(3, Integer.parseInt(monthlyfeemap1.get(jTable1.getValueAt(currentrow,0)).toString()));
       if(jRadioButton2.isSelected())
       ps.setInt(3, Integer.parseInt(admissionfeemap1.get(jTable1.getValueAt(currentrow,0)).toString()));
       if(jRadioButton3.isSelected())
       ps.setInt(3, Integer.parseInt(periodicfeemap1.get(jTable1.getValueAt(currentrow,0)).toString()));*/
 ps.setInt(3,sessionVal);
       ps.executeUpdate();
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

     public void removeIndividualPaid()
    {
        // int currentrow=jTable1.getSelectedRow();
        String paiddate=null;
    try
    {

        ps=con.prepareStatement("select ledgercode,paid from feepaid where  studentid=? and month=? and session=?");

      ps.setString(1,admissionnumber.getText());
       ps.setInt(2,Integer.parseInt(month1.get(monthCombo.getSelectedItem()).toString()));


     /*  if(jRadioButton1.isSelected())
       ps.setInt(3, Integer.parseInt(monthlyfeemap1.get(jTable1.getValueAt(currentrow,0)).toString()));
       if(jRadioButton2.isSelected())
       ps.setInt(3, Integer.parseInt(admissionfeemap1.get(jTable1.getValueAt(currentrow,0)).toString()));
       if(jRadioButton3.isSelected())
       ps.setInt(3, Integer.parseInt(periodicfeemap1.get(jTable1.getValueAt(currentrow,0)).toString()));*/

        ps.setInt(3,sessionVal);
rs3=ps.executeQuery();
while(rs3.next())
{
          ps=con.prepareStatement("select paid,currentbalance  from ledgeraccount where ledgercode=?");
       ps.setInt(1,rs3.getInt(1));
       rs4=ps.executeQuery();
       if(rs4.next())
       {
           ps=con.prepareStatement("update ledgeraccount set paid=?,currentbalance=? where ledgercode=?");
           ps.setDouble(1, rs4.getDouble(1)-rs3.getDouble(2));
           ps.setDouble(2, rs4.getDouble(2)-rs3.getDouble(2));
            ps.setInt(3,rs3.getInt(1));
           ps.executeUpdate();
       }

}

           //String id=rs.getString(1);
 ps=con.prepareStatement("select date from feepaid where studentid=? and month=? and session=?");
       ps.setString(1,admissionnumber.getText());
        ps.setInt(2,Integer.parseInt(month1.get(monthCombo.getSelectedItem()).toString()));

/*
       if(jRadioButton1.isSelected())
       ps.setInt(3, Integer.parseInt(monthlyfeemap1.get(jTable1.getValueAt(currentrow,0)).toString()));
       if(jRadioButton2.isSelected())
       ps.setInt(3, Integer.parseInt(admissionfeemap1.get(jTable1.getValueAt(currentrow,0)).toString()));
       if(jRadioButton3.isSelected())
       ps.setInt(3, Integer.parseInt(periodicfeemap1.get(jTable1.getValueAt(currentrow,0)).toString()));*/
 ps.setInt(3,sessionVal);

      rs1=ps.executeQuery();
if(rs1.next())
{
     rs1.first();
      rs1.previous();
           ps=con.prepareStatement("delete from feepaid where studentid=? and month=? and session=?");
       ps.setString(1,admissionnumber.getText());
       ps.setInt(2,Integer.parseInt(month1.get(monthCombo.getSelectedItem()).toString()));


    /*   if(jRadioButton1.isSelected())
       ps.setInt(3, Integer.parseInt(monthlyfeemap1.get(jTable1.getValueAt(currentrow,0)).toString()));
       if(jRadioButton2.isSelected())
       ps.setInt(3, Integer.parseInt(admissionfeemap1.get(jTable1.getValueAt(currentrow,0)).toString()));
       if(jRadioButton3.isSelected())
       ps.setInt(3, Integer.parseInt(periodicfeemap1.get(jTable1.getValueAt(currentrow,0)).toString()));*/
 ps.setInt(3,sessionVal);
       ps.executeUpdate();

      while(rs1.next())
      {
          paiddate=rs1.getString(1);
           ps=con.prepareStatement("select studentusedsurplus.date,studentusedsurplus.surplus,studentsurplus.surplus from studentusedsurplus left join studentsurplus on studentusedsurplus.studentid=studentsurplus.studentid where studentusedsurplus.studentid=?");
       ps.setString(1,admissionnumber.getText());
       rs2=ps.executeQuery();
       if(rs2.next())
       {
       if(rs2.getString(1).equals(paiddate))
       {
           ps=con.prepareStatement("update studentsurplus set surplus=? where studentid=?");
       ps.setDouble(1,rs2.getDouble(2)+rs2.getDouble(3));
        ps.setString(2,admissionnumber.getText());
     ps.executeUpdate();

      ps=con.prepareStatement("update studentusedsurplus set surplus=0 where studentid=? and date=?");
       //ps.setDouble(1,rs2.getDouble(2)+rs2.getDouble(3));
        ps.setString(1,admissionnumber.getText());
        ps.setString(2,paiddate);
     ps.executeUpdate();

       }
       }
       else
       {
           Double todaysurplus=0.0;
           ps=con.prepareStatement("select * from studenttodaysurplus where date=? and studentid=?");
           ps.setString(1,paiddate);
            ps.setString(2,admissionnumber.getText());
           rs5=ps.executeQuery();
           if(rs5.next())
           {
               todaysurplus=rs5.getDouble(2);
                ps=con.prepareStatement("delete from studenttodaysurplus where date=? and studentid=?");
           ps.setString(1,paiddate);
           ps.setString(2,admissionnumber.getText());
           ps.executeUpdate();

           ps=con.prepareStatement("select * from studentsurplus where studentid=?");
           ps.setString(1,admissionnumber.getText());
           rs5=ps.executeQuery();
           rs5.next();
           Double totalsurplus=0.0;
           totalsurplus=rs5.getDouble(2);

           ps=con.prepareStatement("update studentsurplus set surplus=? where studentid=?");
       ps.setDouble(1,totalsurplus-todaysurplus);
        ps.setString(2,admissionnumber.getText());
     ps.executeUpdate();

           }
       }

      }
}

    }catch(Exception e)
    {
        e.printStackTrace();
    }
    }
    public void getStudentName()
{
    int counts,ind=0;
    try
    {

         ps = con.prepareStatement("select * from studententry where id=?");
ps.setString(1,admissionnumber.getText());
             rs = ps.executeQuery();
if(rs.next()==false)
{
    confirmmsg.setForeground(Color.RED);
                                 confirmmsg.setText("Invalid Student");
             JOptionPane.showConfirmDialog(null,"Invalid Student","Invalid Student",JOptionPane.OK_CANCEL_OPTION);
 //confirmmsg.setForeground(Color.GREEN);
                confirmmsg.setText("--------------------------Confirmation----------------------");
}//rs.next();
else
{

name.setText(rs.getString(2));
classCombo.setSelectedItem(classmap.get(rs.getInt(9)));

}

  //con.close();
      }
    catch(Exception e)
    {
        System.err.println("Error is"+e);
    }

}

public void removeFeeDues()
{
    //int currentrow=jTable1.getSelectedRow();
    try
    {
       //con=com.duc.DatabaseConnection.DatabaseConnection.con;
       ps=con.prepareStatement("select id from studententry where class=?");
       ps.setInt(1,Integer.parseInt(classmap1.get(classCombo.getSelectedItem()).toString()));
       rs=ps.executeQuery();

       while(rs.next())
       {
            ps=con.prepareStatement("select ledgercode,dues from feedues where  studentid=? and month=? and session=?");

      ps.setString(1,rs.getString(1));
       ps.setInt(2,Integer.parseInt(month1.get(monthCombo.getSelectedItem()).toString()));

/*
       if(jRadioButton1.isSelected())
       ps.setInt(3, Integer.parseInt(monthlyfeemap1.get(jTable1.getValueAt(currentrow,0)).toString()));
       if(jRadioButton2.isSelected())
       ps.setInt(3, Integer.parseInt(admissionfeemap1.get(jTable1.getValueAt(currentrow,0)).toString()));
       if(jRadioButton3.isSelected())
       ps.setInt(3, Integer.parseInt(periodicfeemap1.get(jTable1.getValueAt(currentrow,0)).toString()));*/
 ps.setInt(3,sessionVal);
       rs3=ps.executeQuery();
if(rs3.next())
{
          ps=con.prepareStatement("select dues from ledgeraccount where ledgercode=?");
       ps.setInt(1,rs3.getInt(1));
       rs4=ps.executeQuery();
       if(rs4.next())
       {
           ps=con.prepareStatement("update ledgeraccount set dues=? where ledgercode=?");
           ps.setDouble(1, rs4.getDouble(1)-rs3.getDouble(2));
            //ps.setDouble(2, rs4.getDouble(2)-rs3.getDouble(2));
            ps.setInt(2,rs3.getInt(1));

           ps.executeUpdate();
       }


           ps=con.prepareStatement("delete from feedues where studentid=? and month=? and session=?");
       ps.setString(1,rs.getString(1));
       ps.setInt(2,Integer.parseInt(month1.get(monthCombo.getSelectedItem()).toString()));

/*
       if(jRadioButton1.isSelected())
       ps.setInt(3, Integer.parseInt(monthlyfeemap1.get(jTable1.getValueAt(currentrow,0)).toString()));
       if(jRadioButton2.isSelected())
       ps.setInt(3, Integer.parseInt(admissionfeemap1.get(jTable1.getValueAt(currentrow,0)).toString()));
       if(jRadioButton3.isSelected())
       ps.setInt(3, Integer.parseInt(periodicfeemap1.get(jTable1.getValueAt(currentrow,0)).toString()));*/
 ps.setInt(3,sessionVal);
       ps.executeUpdate();
       }
       }   }catch(Exception e)
    {
        e.printStackTrace();
    }
}

public void removeFeePaid()
{
//int currentrow=jTable1.getSelectedRow();
        String paiddate=null;
    try
    {
       //con=com.duc.DatabaseConnection.DatabaseConnection.con;
       ps=con.prepareStatement("select id from studententry where class=?");
       ps.setInt(1,Integer.parseInt(classmap1.get(classCombo.getSelectedItem()).toString()));
       rs=ps.executeQuery();

       while(rs.next())
       {
            ps=con.prepareStatement("select ledgercode,paid from feepaid where  studentid=? and month=? and session=?");

      ps.setString(1,rs.getString(1));
       ps.setInt(2,Integer.parseInt(month1.get(monthCombo.getSelectedItem()).toString()));

/*
       if(jRadioButton1.isSelected())
       ps.setInt(3, Integer.parseInt(monthlyfeemap1.get(jTable1.getValueAt(currentrow,0)).toString()));
       if(jRadioButton2.isSelected())
       ps.setInt(3, Integer.parseInt(admissionfeemap1.get(jTable1.getValueAt(currentrow,0)).toString()));
       if(jRadioButton3.isSelected())
       ps.setInt(3, Integer.parseInt(periodicfeemap1.get(jTable1.getValueAt(currentrow,0)).toString()));*/
 ps.setInt(3,sessionVal);
       rs3=ps.executeQuery();
if(rs3.next())
{
          ps=con.prepareStatement("select paid,currentbalance  from ledgeraccount where ledgercode=?");
       ps.setInt(1,rs3.getInt(1));
       rs4=ps.executeQuery();
       if(rs4.next())
       {
           ps=con.prepareStatement("update ledgeraccount set paid=?,currentbalance=? where ledgercode=?");
           ps.setDouble(1, rs4.getDouble(1)-rs3.getDouble(2));
           ps.setDouble(2, rs4.getDouble(2)-rs3.getDouble(2));
            ps.setInt(3,rs3.getInt(1));
           ps.executeUpdate();
       }

}
           String id=rs.getString(1);
 ps=con.prepareStatement("select date from feepaid where studentid=? and month=? and session=?");
       ps.setString(1,id);
        ps.setInt(2,Integer.parseInt(month1.get(monthCombo.getSelectedItem()).toString()));

/*
       if(jRadioButton1.isSelected())
       ps.setInt(3, Integer.parseInt(monthlyfeemap1.get(jTable1.getValueAt(currentrow,0)).toString()));
       if(jRadioButton2.isSelected())
       ps.setInt(3, Integer.parseInt(admissionfeemap1.get(jTable1.getValueAt(currentrow,0)).toString()));
       if(jRadioButton3.isSelected())
       ps.setInt(3, Integer.parseInt(periodicfeemap1.get(jTable1.getValueAt(currentrow,0)).toString()));
*/
 ps.setInt(3,sessionVal);
      rs1=ps.executeQuery();
      if(rs1.next())
      {

      rs1.first();
      rs1.previous();

           ps=con.prepareStatement("delete from feepaid where studentid=? and month=? and session=?");
       ps.setString(1,id);
       ps.setInt(2,Integer.parseInt(month1.get(monthCombo.getSelectedItem()).toString()));

/*
       if(jRadioButton1.isSelected())
       ps.setInt(3, Integer.parseInt(monthlyfeemap1.get(jTable1.getValueAt(currentrow,0)).toString()));
       if(jRadioButton2.isSelected())
       ps.setInt(3, Integer.parseInt(admissionfeemap1.get(jTable1.getValueAt(currentrow,0)).toString()));
       if(jRadioButton3.isSelected())
       ps.setInt(3, Integer.parseInt(periodicfeemap1.get(jTable1.getValueAt(currentrow,0)).toString()));*/
 ps.setInt(3,sessionVal);
       ps.executeUpdate();


      while(rs1.next())
      {
          paiddate=rs1.getString(1);
           ps=con.prepareStatement("select studentusedsurplus.date,studentusedsurplus.surplus,studentsurplus.surplus from studentusedsurplus left join studentsurplus on studentusedsurplus.studentid=studentsurplus.studentid where studentusedsurplus.studentid=?");
       ps.setString(1,id);
       rs2=ps.executeQuery();
       if(rs2.next())
       {
       if(rs2.getString(1).equals(paiddate))
       {
           ps=con.prepareStatement("update studentsurplus set surplus=? where studentid=?");
       ps.setDouble(1,rs2.getDouble(2)+rs2.getDouble(3));
        ps.setString(2,id);
     ps.executeUpdate();

      ps=con.prepareStatement("update studentusedsurplus set surplus=0 where studentid=?");
       //ps.setDouble(1,rs2.getDouble(2)+rs2.getDouble(3));
        ps.setString(1,id);
     ps.executeUpdate();

       }
       }    }

      }

       }
    }catch(Exception e)
    {
        e.printStackTrace();
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField admissionnumber;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox classCombo;
    private javax.swing.JLabel confirmmsg;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JComboBox monthCombo;
    private javax.swing.JTextField name;
    // End of variables declaration//GEN-END:variables
ResultSet rs,rs1,rs2,rs3,rs4,rs5;
PreparedStatement ps;
public Integer sessionVal;
}
