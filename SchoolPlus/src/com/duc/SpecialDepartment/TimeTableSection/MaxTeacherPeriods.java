/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ClassAllotment.java
 *
 * Created on Oct 3, 2009, 5:52:24 PM
 */

package com.duc.SpecialDepartment.TimeTableSection;

import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.decorator.HighlighterFactory;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.HashMap;
import static com.duc.DatabaseConnection.DatabaseConnection.*;
import java.text.MessageFormat;
import javax.swing.JTable.PrintMode;

/**
 *
 * @author sourabh
 */
public class MaxTeacherPeriods extends javax.swing.JInternalFrame {                  
           

           private DefaultTableModel model;
           ArrayList<String> codes= new ArrayList<String>();
           ArrayList<String> tlist=new ArrayList<String>();
    /** Creates new form ClassAllotment */

         public MaxTeacherPeriods() {
        initComponents();
        model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        jTable1.setHighlighters(HighlighterFactory.createAlternateStriping());
        loadTeachers();
        loadTable();
    }

    public void loadTeachers()
    {
      try
      {
       // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        ps=con.prepareStatement("select code,name from staffentry where status=1 ");
        rs=ps.executeQuery();

        int i=0,j=0;
        while(rs.next())
        {
         codes.add(rs.getString(1));
         cmbTeacher.addItem(rs.getString(1)+" [ "+rs.getString(2)+" ]");
        }
       // con.close();
      }
      catch(Exception e)
      {
         System.err.println("Error in loading teachers..."+e);
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        Remove = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbTeacher = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtMaxPeriods = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new org.jdesktop.swingx.JXTable();

        Remove.setText("Remove");
        Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Remove);

        setBackground(new java.awt.Color(0, 204, 204));
        setClosable(true);
        setIconifiable(true);
        setTitle("Max. Periods Configuration for teachers");

        jTextPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jTextPane1.setText("                                              Max. no. of periods for a teacher");
        jScrollPane1.setViewportView(jTextPane1);

        jTextPane2.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane2.setEditable(false);
        jTextPane2.setText("Configure max. no. of periods for a teacher in a weak.");
        jScrollPane2.setViewportView(jTextPane2);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setText("Select Teacher");

        cmbTeacher.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<--Select-->" }));
        cmbTeacher.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTeacherItemStateChanged(evt);
            }
        });

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Max. Periods");

        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("close");
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
                            .addComponent(txtMaxPeriods, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaxPeriods, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(184, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Staff  Detail", "Max. Periods"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
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
        jTable1.setComponentPopupMenu(jPopupMenu1);
        jScrollPane3.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(237, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTeacherItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTeacherItemStateChanged
        // TODO add your handling code here:
}//GEN-LAST:event_cmbTeacherItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(cmbTeacher.getSelectedIndex()<=0)
        return;

        if(txtMaxPeriods.getText().isEmpty())
        {
        JOptionPane.showMessageDialog(null, "Specify Max. No. of periods.", "Error Message", JOptionPane.ERROR_MESSAGE);
        return;
        }

        try
        {
         int k=Integer.parseInt(txtMaxPeriods.getText())   ;
        }
        catch(Exception e)
        {
         JOptionPane.showMessageDialog(null, "Enter Integer value for Max. No. of periods.", "Error Message", JOptionPane.ERROR_MESSAGE);
         return;
        }

        int j=cmbTeacher.getSelectedIndex();
        String code=codes.get(j-1);
        System.out.println(code);

        saveAllotment(code);
        loadTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveActionPerformed
        // TODO add your handling code here:
        removeAllotment();
        
    }//GEN-LAST:event_RemoveActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        super.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         try
        {
        String s=" ";
        s+=" Max. Periods Allotment list for teachers";
        MessageFormat header=new MessageFormat(s);
        jTable1.print(PrintMode.FIT_WIDTH, header, null);
        }
        catch(Exception e)
        {
         System.err.println("Error in printing timetable");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

public void removeAllotment()
 {
   int i= jTable1.getSelectedRow();
   String code=tlist.get(i);

       try
        {
          //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
          ps=con.prepareStatement("delete from teachermaxperiods where teachercode=? ");
          ps.setString(1,code);          
          ps.executeUpdate();
         // con.close();
         }
   catch(Exception e)
   {
    System.err.println("Error in teacher allotment deletion");
   }
 loadTable();
}


    public void loadTable()
    {
        try
        {
        //  con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
          ps=con.prepareStatement("select teachercode,name,maxperiods from teachermaxperiods,staffentry where teachercode=code ");
          rs=ps.executeQuery();

          int i=0,j=0;
          while(rs.next())
          {
           j++;
          }
          model.setRowCount(j);
          rs.first();
          rs.previous();

          tlist.clear();

          while(rs.next())
          {
          tlist.add(rs.getString(1));
          model.setValueAt(rs.getString(1)+" [ "+rs.getString(2)+" ] ", i, 0);
          model.setValueAt(rs.getInt(3), i,1);
          i++;
          }        
        }
        catch(Exception e)
        {
          System.err.println("Error in loading Table"+e);
        }
    }

    public void saveAllotment(String code)
    {
     try
     {
      // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

       ps=con.prepareStatement("select * from teachermaxperiods where teachercode=? ");
       ps.setString(1, code);       
       rs=ps.executeQuery();
       if(rs.next())
       {
           JOptionPane.showMessageDialog(null,"Already configured for this teacher", "Report", JOptionPane.WARNING_MESSAGE);
           return;
       }

       ps=con.prepareStatement("insert into teachermaxperiods(teachercode,maxperiods) values(?,?)");
       ps.setString(1, code);
       ps.setInt(2,Integer.parseInt(txtMaxPeriods.getText()));
       ps.executeUpdate();
       JOptionPane.showMessageDialog(null, "Configuration Saved", "Message", JOptionPane.INFORMATION_MESSAGE);
       //con.close();

     }
     catch(Exception e)
     {
      System.err.println("Error is saving allotment"+e);
     }
    }

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Remove;
    private javax.swing.JComboBox cmbTeacher;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private org.jdesktop.swingx.JXTable jTable1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextField txtMaxPeriods;
    // End of variables declaration//GEN-END:variables
   //Connection con;
   PreparedStatement ps;
   ResultSet rs;
}