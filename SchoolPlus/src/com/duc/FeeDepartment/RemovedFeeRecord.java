/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RemovedFeeRecord.java
 *
 * Created on Oct 6, 2009, 4:56:24 AM
 */

package com.duc.FeeDepartment;
import java.sql.*;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import com.duc.ImportSection.*;
import java.text.MessageFormat;
import javax.swing.JTable.PrintMode;
import static com.duc.DatabaseConnection.DatabaseConnection.*;
/**
 *
 * @author Ravi Dangaich
 */
public class RemovedFeeRecord extends javax.swing.JInternalFrame {
DefaultTableModel dm;
//MapForIndex mp=new MapForIndex();
HashMap classmap=mp.getClassIndexName();
HashMap sessionmap1=mp.getSessionIndexFromName();
    HashMap sectionmap=mp.getSectionIndexName();
     HashMap month=mp.mapMonth();
    HashMap admissionfeemap=mp.getAdmissionFeeIndexToName();
    HashMap periodicfeemap=mp.getPeriodicFeeIndexToName();

    HashMap monthlyfeemap=mp.getMonthlyFeeIndexToName();
    HashMap otherfeemap=mp.getLedgerOtherFeeIndexToName();
    /** Creates new form RemovedFeeRecord */
    public RemovedFeeRecord() {
        initComponents();
        pack();
        System.out.println("con of RemovedFeeRecord="+con);
        //this.setLocationRelativeTo(null);
        dm = (DefaultTableModel) jTable1.getModel();
        dm.setRowCount(0);
       fromSession();
        viewRemoved();
        totalRemoved();
    }

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
              sessionCombo.addItem(rs.getString(1));

              if(rs.getInt(3)==1)
                  sessionValue=rs.getInt(2);

            }

         }
         catch(Exception e)
         {
             e.printStackTrace();
    }
   }
public void totalRemoved()
{
   Double totaldues=0.0;
    int rowcount=dm.getRowCount();
    for(int i=0;i<rowcount;i++)
    {
        System.out.println("rd");
        totaldues+=Double.parseDouble(dm.getValueAt(i,6).toString());

    }   todaycollection.setText(String.valueOf(totaldues));
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
        viewButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        todaycollection = new javax.swing.JTextField();
        sessionCombo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Removed Fee Record List");

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Class", "Section", "Roll", "Fee Head", "Amt.", "Month", "Date", "Fee type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTextPane1.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 0, 24));
        jTextPane1.setText("                                     Removed Fee Record");
        jScrollPane2.setViewportView(jTextPane1);

        jTextPane2.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane2.setEditable(false);
        jTextPane2.setFont(new java.awt.Font("Tahoma", 0, 12));
        jTextPane2.setText("It will show the list of all the advance payments made by the student as on monthly basis");
        jScrollPane3.setViewportView(jTextPane2);

        printButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        printButton.setForeground(new java.awt.Color(0, 0, 255));
        printButton.setText("Print");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        closeButton.setFont(new java.awt.Font("Tahoma", 1, 12));
        closeButton.setForeground(new java.awt.Color(255, 0, 0));
        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        viewButton.setFont(new java.awt.Font("Tahoma", 1, 12));
        viewButton.setForeground(new java.awt.Color(0, 0, 255));
        viewButton.setText("View");
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setText("Total Removed Dues");

        todaycollection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todaycollectionActionPerformed(evt);
            }
        });

        sessionCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choose" }));
        sessionCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sessionComboActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel5.setText("Session");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(todaycollection, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 292, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sessionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(printButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewButton, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(closeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(sessionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(todaycollection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(viewButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(printButton)
                        .addGap(11, 11, 11)
                        .addComponent(closeButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        String s="Student Removed Fee Record";
        MessageFormat header=new MessageFormat(s);
        jTable1.print(PrintMode.FIT_WIDTH, header, null);
        }

        catch(Exception e)
        {
         System.err.println("Error in printing student search");
        }
}//GEN-LAST:event_printButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        this.dispose();        // TODO add your handling code here:
}//GEN-LAST:event_closeButtonActionPerformed

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
       // TODO add your handling code here:
}//GEN-LAST:event_viewButtonActionPerformed

    private void sessionComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sessionComboActionPerformed
        sessionWiseFeeRemoved();
}//GEN-LAST:event_sessionComboActionPerformed

    private void todaycollectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todaycollectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_todaycollectionActionPerformed

   public void sessionWiseFeeRemoved()
   {
       try
       {

    int i=0,j=0,feetype=0;
    con= com.duc.DatabaseConnection.DatabaseConnection.con;

        try {
            ps=con.prepareStatement("Select * from feeremoved where session=?");
            ps.setInt(1,Integer.parseInt(sessionmap1.get(sessionCombo.getSelectedItem()).toString()));

            rs=ps.executeQuery();
            while(rs.next())
            {
                j++;
               // System.out.println("gender"+rs);
              //  System.out.println("rd2");
            }
            rs.first();
            rs.previous();
            dm.setRowCount(j);
            while(rs.next())
            {
feetype=rs.getInt(6);

                dm.setValueAt(rs.getString(1), i, 0);

                if(feetype==0)
                {
                dm.setValueAt(monthlyfeemap.get(rs.getInt(2)), i, 5);
                 dm.setValueAt("Monthly Fee", i, 9);
                }if(feetype==1)
                {
                dm.setValueAt(admissionfeemap.get(rs.getInt(2)), i, 5);
                 dm.setValueAt("Admission Fee", i, 9);
                }
                 if(feetype==2)
                 {
                dm.setValueAt(periodicfeemap.get(rs.getInt(2)), i, 5);
                 dm.setValueAt("Periodic Fee", i, 9);
                 }
                 if(feetype==3)
                 {
                dm.setValueAt(otherfeemap.get(rs.getInt(2)), i, 5);
                 dm.setValueAt("Other Fee", i, 9);
                 }
                 dm.setValueAt(rs.getDouble(3), i, 6);
                  dm.setValueAt(month.get(rs.getInt(4)), i, 7);
                   dm.setValueAt(rs.getString(5), i, 8);

                  i++;
            }

            for(int l=0;l<i;l++)
            {
                ps=con.prepareStatement("select * from studententry where id=?");
            j=0;
                ps.setString(1,dm.getValueAt(l, 0).toString());
                     rs1=ps.executeQuery();

           if(rs1.next())
           {

                     dm.setValueAt(rs1.getString(2), l, 1);
                //dm.setValueAt(rs1.getString(9), l, 2);
                     dm.setValueAt(classmap.get(rs1.getInt(9)), l, 2);
                dm.setValueAt(sectionmap.get(rs1.getInt(10)), l, 3);
                dm.setValueAt(rs1.getInt(11), l, 4);
            }

        }
       // con.close();
        }
      catch(Exception e)
        {
            e.printStackTrace();
    }


       }catch(Exception e)
       {
           e.printStackTrace();
       }
   }

    public void viewRemoved()
{



    int i=0,j=0,feetype=0,groupid1=0;
   // con= com.duc.DatabaseConnection.DatabaseConnection.con;

        try {
            ps=con.prepareStatement("Select * from feeremoved where session=?");
            ps.setInt(1,sessionValue);
            rs=ps.executeQuery();
            while(rs.next())
            {
                j++;
              
            }
            rs.first();
            rs.previous();
            dm.setRowCount(j);
            while(rs.next())
            {
feetype=rs.getInt(6);
groupid1=rs.getInt(8);
                dm.setValueAt(rs.getString(1), i, 0);

                if(feetype==0)
                {
                dm.setValueAt(monthlyfeemap.get(rs.getInt(2)), i, 5);
                 dm.setValueAt("Monthly Fee", i, 9);
                }if(feetype==1)
                {
                dm.setValueAt(admissionfeemap.get(rs.getInt(2)), i, 5);
                 dm.setValueAt("Admission Fee", i, 9);
                }
                 if(feetype==2)
                 {
                dm.setValueAt(periodicfeemap.get(rs.getInt(2)), i, 5);
                dm.setValueAt("Periodic Fee", i, 9);
                 }
                 if(feetype==3)
                 {
                     if(groupid1==0)
                 {
                dm.setValueAt(otherfeemap.get(rs.getInt(2)), i, 5);
                dm.setValueAt("Other Fee", i, 9);
                 }
                     else 
                     {
                         ps=con.prepareStatement("select invname from inventorydeposit where InventoryId=?");
                         ps.setInt(1,groupid1);
                         rs2=ps.executeQuery();
                         if(rs2.next())
                         {
                             dm.setValueAt(rs2.getString(1), i, 5);
                dm.setValueAt("Other Fee", i, 9);
                         }
                     }
                 }
                 dm.setValueAt(rs.getDouble(3), i, 6);
                  dm.setValueAt(month.get(rs.getInt(4)), i, 7);
                   dm.setValueAt(rs.getString(5), i, 8);
               
                  i++;
            }

            for(int l=0;l<i;l++)
            {
                ps=con.prepareStatement("select * from studententry where id=?");
            j=0;
                ps.setString(1,dm.getValueAt(l, 0).toString());
                     rs1=ps.executeQuery();

           if(rs1.next())
           {

                     dm.setValueAt(rs1.getString(2), l, 1);
                //dm.setValueAt(rs1.getString(9), l, 2);
                     dm.setValueAt(classmap.get(rs1.getInt(9)), l, 2);
                dm.setValueAt(sectionmap.get(rs1.getInt(10)), l, 3);
                dm.setValueAt(rs1.getInt(11), l, 4);
            }

        }
       // con.close();
        }
      catch(Exception e)
        {
            e.printStackTrace();
    }

}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JButton printButton;
    private javax.swing.JComboBox sessionCombo;
    private javax.swing.JTextField todaycollection;
    private javax.swing.JButton viewButton;
    // End of variables declaration//GEN-END:variables
ResultSet rs,rs1,rs2;
//Connection con;
PreparedStatement ps;
public Integer sessionValue;
}