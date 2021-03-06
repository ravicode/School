/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PeriodConfig.java
 *
 * Created on Oct 4, 2009, 2:26:39 PM
 */

package com.duc.SpecialDepartment.TimeTableSection;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static com.duc.DatabaseConnection.DatabaseConnection.*;

/**
 *
 * @author sourabh
 */

public class PeriodConfig extends javax.swing.JInternalFrame
{
    private DefaultTableModel model;

    /** Creates new form PeriodConfig */
    public PeriodConfig() {
        initComponents();
        model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        loadPeriods();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtStartHour = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtStartMin = new javax.swing.JTextField();
        txtEndMin = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEndHour = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new org.jdesktop.swingx.JXTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jXTitledSeparator1 = new org.jdesktop.swingx.JXTitledSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        checkRecess = new javax.swing.JCheckBox();
        txtDescription = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();

        jMenuItem1.setText("Remove");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setClosable(true);
        setIconifiable(true);
        setTitle("Period Configuration");

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setText(" Description");

        jLabel2.setText("Period Start Time");

        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Hour");

        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("Min");

        jLabel7.setForeground(new java.awt.Color(0, 0, 255));
        jLabel7.setText("Min");

        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("Hour");

        jLabel5.setText("Period End Time");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Period Description", "Timing"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(jTable1);

        jTextPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jTextPane1.setText("                                                  Configure School Periods and Timing");
        jScrollPane2.setViewportView(jTextPane1);

        jXTitledSeparator1.setTitle("Period Details");

        checkRecess.setBackground(new java.awt.Color(0, 204, 204));
        checkRecess.setText("Recess/Break/Prayer");

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextPane2.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextPane2.setForeground(new java.awt.Color(204, 0, 0));
        jTextPane2.setText("Configure Periods and Timing serially as they are held in school to avoid any conflict.");
        jScrollPane3.setViewportView(jTextPane2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtEndHour, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtEndMin, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtStartHour, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtStartMin, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkRecess, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(130, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jXTitledSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE))
                        .addGap(68, 68, 68)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(301, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jXTitledSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(checkRecess))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStartHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txtStartMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEndHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtEndMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        super.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(txtDescription.getText().isEmpty() || txtStartHour.getText().isEmpty() || txtEndHour.getText().isEmpty() || txtStartMin.getText().isEmpty() || txtEndMin.getText().isEmpty())
        {
        JOptionPane.showMessageDialog(null,"Ensure you have filled all the fields.", "Error Report", JOptionPane.ERROR_MESSAGE);
        return;
        }
        savePeriod();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        int id =Integer.parseInt( String.valueOf(model.getValueAt(jTable1.getSelectedRow(),0)) );
        deletePeriod(id);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public void deletePeriod(int id)
    {
        try
        {
          // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
           ps=con.prepareStatement("delete from timetableperiods where id=?");
           int i= jTable1.getSelectedRow();
           System.out.println("i= "+i);
           ps.setInt(1,Integer.parseInt(String.valueOf(model.getValueAt(i,0))));
           ps.executeUpdate();
           JOptionPane.showMessageDialog(null,"Period Deleted successfully.", "Message", JOptionPane.INFORMATION_MESSAGE);
           loadPeriods();
          // con.close();
        }
        catch(Exception e)
        {
        System.err.println("Error in deleting periods..."+e);
        }
    }

    public void savePeriod()
    {
        try
        {
         int i=0;
         if(checkRecess.isSelected())
         i=1;

        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
         ps=con.prepareStatement("insert into timetableperiods (periodcode,starthour,startminute,endhour,endminute,recess) values(?,?,?,?,?,?)");
         ps.setString(1,txtDescription.getText());
         ps.setString(2,txtStartHour.getText());
         ps.setString(3,txtStartMin.getText());
         ps.setString(4,txtEndHour.getText());
         ps.setString(5,txtEndMin.getText());
         ps.setInt(6,i);
         ps.executeUpdate();
         JOptionPane.showMessageDialog(null,"Period Saved successfully.", "Message", JOptionPane.INFORMATION_MESSAGE);
         refreshData();
         loadPeriods();
        // con.close();
        }
        catch(Exception e)
        {
            System.err.println("Error is saving periods"+e);
        }
    }

    public void loadPeriods()
    {

        try
        {
       //  con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
         ps=con.prepareStatement("select id,periodcode,starthour,startminute,endhour,endminute from timetableperiods order by id");
         rs=ps.executeQuery();

         int i=0,j=0;
         while(rs.next())
         j++;

         model.setRowCount(0);
         model.setRowCount(j);

         rs.first();
         rs.previous();

         while(rs.next())
         {
          model.setValueAt(rs.getInt(1), i, 0);
          model.setValueAt(rs.getString(2), i, 1);
          String timing="<html> <font color='blue'>"+rs.getString(3)+"<b> : </b>"+rs.getString(4)+"<b><font color='red'> - </font></b>"+rs.getString(5)+"<b> : </b>"+rs.getString(6)+"</font></html>";
          model.setValueAt(timing, i, 2);

          i++;
         }
        // con.close();

        }
        catch(Exception e)
        {
         System.err.println("Error in loading periods"+e);
        }
    }

    public void refreshData()
    {
      txtDescription.setText("");
      txtStartHour.setText("");
      txtEndHour.setText("");
      txtStartMin.setText("");
      txtEndMin.setText("");
      checkRecess.setSelected(false);
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkRecess;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private org.jdesktop.swingx.JXTable jTable1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private org.jdesktop.swingx.JXTitledSeparator jXTitledSeparator1;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtEndHour;
    private javax.swing.JTextField txtEndMin;
    private javax.swing.JTextField txtStartHour;
    private javax.swing.JTextField txtStartMin;
    // End of variables declaration//GEN-END:variables
   //Connection con;
   PreparedStatement ps;
   ResultSet rs;
}
