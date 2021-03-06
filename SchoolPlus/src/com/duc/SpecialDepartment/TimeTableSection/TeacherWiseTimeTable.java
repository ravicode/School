/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TeacherWiseTimeTable.java
 *
 * Created on Oct 7, 2009, 5:41:24 PM
 */

package com.duc.SpecialDepartment.TimeTableSection;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.decorator.HighlighterFactory;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable.PrintMode;
import java.text.MessageFormat;
import java.util.HashMap;
import com.duc.ImportSection.MapForIndex;
import static com.duc.DatabaseConnection.DatabaseConnection.*;

/**
 *
 * @author sourabh
 */
public class TeacherWiseTimeTable extends javax.swing.JInternalFrame {
 private DefaultTableModel model;
 private ArrayList<String> codes = new ArrayList<String> ();
 
 // MapForIndex mp=new MapForIndex();
  HashMap classmap=mp.getClassIndexName();
  HashMap subjectmap=mp.getSubjectIndexToName();
  HashMap sectionmap=mp.getSectionIndexName();

    /** Creates new form TeacherWiseTimeTable */
    public TeacherWiseTimeTable() {
        initComponents();
        jTable1.setHorizontalScrollEnabled(true);
        jTable1.setHighlighters(HighlighterFactory.createAlternateStriping());
        model = new TimeTableModel(0).createDefaultModel();
        jTable1.setModel(model);
        loadDays();
        loadTeachers();
    }

       public void loadDays()
    {
      model.setRowCount(6);
      model.setValueAt("MON", 0,0);
      model.setValueAt("TUE", 1,0);
      model.setValueAt("WED", 2,0);
      model.setValueAt("THU", 3,0);
      model.setValueAt("FRI", 4,0);
      model.setValueAt("SAT", 5,0);

    }


    public void loadTeachers()
    {
        try
       {
       // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        ps=con.prepareStatement("select distinct teachercode,name from periodallotment,staffentry where teachercode=code and status=1");
        rs=ps.executeQuery();
        
        while(rs.next())
        {
         codes.add(rs.getString(1));
         cmbTeacher.addItem(rs.getString(1)+" [ "+rs.getString(2)+" ]");
        }          
       // con.close();
        }
        catch(Exception e)
        {
         System.err.println("Error in loading teachers ..."+e);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbTeacher = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new org.jdesktop.swingx.JXTable();
        jLabel2 = new javax.swing.JLabel();
        maxPeriods = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 204, 204));
        setClosable(true);
        setIconifiable(true);
        setTitle("Teacher Time Table");

        jTextPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jTextPane1.setText("                                                                                        Teacher's Time Table");
        jScrollPane1.setViewportView(jTextPane1);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setText("Select Teacher");

        cmbTeacher.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choose" }));
        cmbTeacher.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTeacherItemStateChanged(evt);
            }
        });

        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jTable1.setColumnControlVisible(true);
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13));
        jTable1.setRowHeight(90);
        jTable1.setSortable(false);
        jScrollPane3.setViewportView(jTable1);

        jLabel2.setForeground(new java.awt.Color(204, 0, 204));
        jLabel2.setText("Total No. of Periods in a week :");

        maxPeriods.setText("0");

        jButton2.setText("+");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("-");
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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(maxPeriods, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel2)
                    .addComponent(maxPeriods)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTeacherItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTeacherItemStateChanged
        // TODO add your handling code here:
        if(cmbTeacher.getSelectedIndex()<=0)
        {
         System.out.println("filling empty table");
         fillEmptyTimeTable();
         return;
        }
        maxPeriods.setText("");
        String code=codes.get(cmbTeacher.getSelectedIndex()-1);
        loadTeacherTimeTable(code);
    }//GEN-LAST:event_cmbTeacherItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here
        try
        {
        String s="Time Table For ( ";
        s+=cmbTeacher.getSelectedItem().toString()+" )";
        MessageFormat header=new MessageFormat(s);

        String t="Total No. of periods in a week: "+maxPeriods.getText();
        MessageFormat footer=new MessageFormat(t);
        jTable1.print(PrintMode.FIT_WIDTH, header, footer);
        }
        catch(Exception e)
        {
         System.err.println("Error in table printing"+e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int i=jTable1.getRowHeight();
        jTable1.setRowHeight(i+5);
}//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int i=jTable1.getRowHeight();
        if(i>30)
            jTable1.setRowHeight(i-5);
}//GEN-LAST:event_jButton3ActionPerformed

    public void loadTeacherTimeTable(String code)
    {
       try
       {
          // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
           ps=con.prepareStatement("select subject,class,section,row,`periodallotment`.`column` from periodallotment where teachercode=?");
           ps.setString(1, code);
           rs=ps.executeQuery();

           fillEmptyTimeTable();

           int i=0;
           while(rs.next())
           {
           String s="<html><font color='blue'>"+String.valueOf(subjectmap.get(rs.getInt(1)))+"</font><br /><font color='green'> [ "+String.valueOf(classmap.get(rs.getInt(2)))+" - "+String.valueOf(sectionmap.get(rs.getInt(3)))+" ]</font></html>";
           model.setValueAt(s, rs.getInt(4),rs.getInt(5));
           i++;
           }
           maxPeriods.setText(String.valueOf(i));
         //  con.close();
       }
       catch(Exception e)
       {
        System.err.println("Error in teacher time table..."+e);
       }
    }


       public void fillEmptyTimeTable()
    {
      int j=model.getColumnCount();

      for(int column=1;column<j;column++)
      {
         for (int row=0;row<=5;row++)
         {
          model.setValueAt("", row, column);
         }
      }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbTeacher;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private org.jdesktop.swingx.JXTable jTable1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel maxPeriods;
    // End of variables declaration//GEN-END:variables
 //  Connection con;
   PreparedStatement ps;
   ResultSet rs;
}
