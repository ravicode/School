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
import com.duc.ImportSection.MapForIndex;
import static com.duc.DatabaseConnection.DatabaseConnection.*;

/**
 *
 * @author sourabh
 */
public class ClassAllotment extends javax.swing.JInternalFrame {
           //MapForIndex mp=new MapForIndex();

           HashMap classmap1=mp.getClassIndexFromName();
           HashMap subjectmap1=mp.getSubjectIndexFromName();
           HashMap classmap=mp.getClassIndexName();
           HashMap subjectmap=mp.getSubjectIndexToName();
           

           private DefaultTableModel model;
           ArrayList<String> codes= new ArrayList<String>();
           ArrayList<String> tlist=new ArrayList<String>();
    /** Creates new form ClassAllotment */
        public ClassAllotment() {
        initComponents();
        model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        jTable1.setHighlighters(HighlighterFactory.createAlternateStriping());
        loadTeachers();
        loadClasses();
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

    public void loadClasses()
    {
       try
      {
       // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        ps=con.prepareStatement("select classtitle from classsetup order by classid ");
        rs=ps.executeQuery();

        int i=0,j=0;
        while(rs.next())
        {
         cmbClass.addItem(rs.getString(1));
        }
        //con.close();
      }
      catch(Exception e)
      {
         System.err.println("Error in loading classes..."+e);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbClass = new javax.swing.JComboBox();
        cmbSubject = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jXTitledSeparator1 = new org.jdesktop.swingx.JXTitledSeparator();
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
        setTitle("Class & Subject Allotment Configuration");

        jTextPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jTextPane1.setText("                                              Manage Class & Subject allotment to teachers.");
        jScrollPane1.setViewportView(jTextPane1);

        jTextPane2.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane2.setEditable(false);
        jTextPane2.setText("Select a teacher and add information of all subjects he/she teaches in different classes.");
        jScrollPane2.setViewportView(jTextPane2);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setText("Select Teacher");

        cmbTeacher.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<--Select-->" }));
        cmbTeacher.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTeacherItemStateChanged(evt);
            }
        });

        jLabel2.setText("Select Class");

        jLabel3.setText("Select Subject");

        cmbClass.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<--Select-->" }));
        cmbClass.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbClassItemStateChanged(evt);
            }
        });

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jXTitledSeparator1.setTitle("");

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
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(cmbClass, 0, 158, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(cmbSubject, 0, 161, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jXTitledSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jXTitledSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(178, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Staff  Detail", "Subject "
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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbClassItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbClassItemStateChanged
        // TODO add your handling code here:
      if(cmbClass.getSelectedIndex()<=0)
      {
        model.setRowCount(0);
        return;
      }
     

      String cls=cmbClass.getSelectedItem().toString();
      loadSubjects(cls);
      loadTable(cls);
    }//GEN-LAST:event_cmbClassItemStateChanged

    private void cmbTeacherItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTeacherItemStateChanged
        // TODO add your handling code here:
}//GEN-LAST:event_cmbTeacherItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (cmbClass.getSelectedIndex()<=0)
        return;

        if(cmbTeacher.getSelectedIndex()<=0)
        return;

        int j=cmbTeacher.getSelectedIndex();
        String code=codes.get(j-1);
        System.out.println(code);

        saveAllotment(code);
        loadTable(cmbClass.getSelectedItem().toString());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveActionPerformed
        // TODO add your handling code here:
        removeAllotment();
        
    }//GEN-LAST:event_RemoveActionPerformed
public void removeAllotment()
{
  int i= jTable1.getSelectedRow();
  String code=tlist.get(i);
  String subject=(String)jTable1.getValueAt(i, 1);

   try
        {
          //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
          ps=con.prepareStatement("delete from subjectallotment where teachercode=? and subject=? and class=?");
          ps.setString(1, code);
          ps.setInt(2,Integer.parseInt(String.valueOf(subjectmap1.get(subject))) );
          ps.setInt(3,Integer.parseInt(String.valueOf(classmap1.get(cmbClass.getSelectedItem().toString()))));
          ps.executeUpdate();
         // con.close();
         }
   catch(Exception e)
   {
    System.err.println("Error in teacher allotment deletion");
   }

 loadTable(cmbClass.getSelectedItem().toString());
}
    public void loadTable(String cls)
    {
        try
        {
        //  con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
          ps=con.prepareStatement("select teachercode,name,subject from subjectallotment,staffentry where teachercode=code and class=?");
          ps.setInt(1,Integer.parseInt(String.valueOf(classmap1.get(cls))));
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
          model.setValueAt(subjectmap.get(rs.getInt(3)), i,1);
          i++;
          }
         // con.close();
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

       ps=con.prepareStatement("select teachercode from subjectallotment where teachercode=? and class=? and subject=?");
       ps.setString(1, code);
       ps.setInt(2,Integer.parseInt(String.valueOf(classmap1.get(cmbClass.getSelectedItem().toString()))));
       ps.setInt(3,Integer.parseInt(String.valueOf(subjectmap1.get(cmbSubject.getSelectedItem().toString()))));
       rs=ps.executeQuery();
       if(rs.next())
       {
           JOptionPane.showMessageDialog(null,"Already Added this subject", "Report", JOptionPane.WARNING_MESSAGE);
        //   con.close();
           return;
       }

       ps=con.prepareStatement("insert into subjectallotment(teachercode,class,subject) values(?,?,?)");
       ps.setString(1, code);
       ps.setInt(2,Integer.parseInt(String.valueOf(classmap1.get(cmbClass.getSelectedItem().toString()))));
       ps.setInt(3,Integer.parseInt(String.valueOf(subjectmap1.get(cmbSubject.getSelectedItem().toString()))));
       ps.executeUpdate();
       JOptionPane.showMessageDialog(null, "Configuration Saved", "Message", JOptionPane.INFORMATION_MESSAGE);
       //con.close();

     }
     catch(Exception e)
     {
      System.err.println("Error is saving allotment"+e);
     }
    }

    public void loadSubjects( String cls)
    {
        try
        {
          System.out.println("Loading subjects...");
         // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
          ps=con.prepareStatement("select subjecttitle from subjectsetup where classtitle=?");
          ps.setInt(1,Integer.parseInt(String.valueOf(classmap1.get(cls))));
          rs=ps.executeQuery();

          cmbSubject.removeAllItems();
          while(rs.next())
          {
           cmbSubject.addItem(String.valueOf(subjectmap.get(rs.getInt(1))));
          }
         // con.close();
        }
        catch(Exception e)
        {
            System.err.println("Error is ..."+e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Remove;
    private javax.swing.JComboBox cmbClass;
    private javax.swing.JComboBox cmbSubject;
    private javax.swing.JComboBox cmbTeacher;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private org.jdesktop.swingx.JXTable jTable1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private org.jdesktop.swingx.JXTitledSeparator jXTitledSeparator1;
    // End of variables declaration//GEN-END:variables
   //Connection con;
   PreparedStatement ps;
   ResultSet rs;
}
