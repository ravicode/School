/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * StaffViewer.java
 *
 * Created on Oct 8, 2009, 3:01:26 PM
 */

package com.duc.SpecialDepartment.TeacherSection;
import javax.swing.JTable.PrintMode;
import java.text.MessageFormat;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.decorator.HighlighterFactory;
import java.sql.*;
import javax.swing.JOptionPane;
import static com.duc.DatabaseConnection.DatabaseConnection.*;
/**
 *
 * @author sourabh
 */
public class StaffViewer extends javax.swing.JInternalFrame {
 private DefaultTableModel model;
    /** Creates new form StaffViewer */
    public StaffViewer() {
        initComponents();
        jTable1.setHorizontalScrollEnabled(true);
        jTable1.setHighlighters(HighlighterFactory.createAlternateStriping());
        model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        loadStaffs();
    }

    public void loadStaffs()
    {
        try
        {
          //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
          ps=con.prepareStatement("select code,name,fname,sex,date_format(dob,'%M %d, %Y '),date_format(doj,'%M %d, %Y '),phone,caste,category,hqa,hqp,classtaught,mainsubject,maths,english from staffentry left join `staffmoreinformation` on code=staffcode");
          rs=ps.executeQuery();

          int i=0,j=0;
          while(rs.next())
          {
           j++;
          }
          model.setRowCount(j);
          
          rs.first();
          rs.previous();

          while(rs.next())
          {
          model.setValueAt(i+1, i, 0);
          model.setValueAt(rs.getString(1), i, 1);
          model.setValueAt(rs.getString(2), i, 2);
          model.setValueAt(rs.getString(3), i, 3);
          model.setValueAt(rs.getString(4), i, 4);
          model.setValueAt(rs.getString(5), i, 5);
          model.setValueAt(rs.getString(6), i, 6);
          model.setValueAt(rs.getString(7), i, 7);
          model.setValueAt(rs.getString(8), i, 8);
          model.setValueAt(rs.getString(9), i, 9);
          model.setValueAt(rs.getString(10), i, 10);
          model.setValueAt(rs.getString(11), i, 11);
          model.setValueAt(rs.getString(12), i, 12);
          model.setValueAt(rs.getString(13), i, 13);
          model.setValueAt(rs.getString(14), i, 14);
          model.setValueAt(rs.getString(15), i, 15);
          i++;
          }
         // con.close();
        }
        catch(Exception e)
        {
            System.err.println("Error in loading staffs..."+e);
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
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new org.jdesktop.swingx.JXTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jMenuItem1.setText("Ex-Teacher");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);
        jPopupMenu1.add(jSeparator1);

        jMenuItem2.setText("Current Teacher");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);
        jPopupMenu1.add(jSeparator2);

        jMenuItem3.setText("Delete Teacher");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem3);

        setBackground(new java.awt.Color(0, 204, 204));
        setClosable(true);
        setIconifiable(true);
        setTitle("Staff Report");

        jTextPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextPane1.setText("                                                                                                          Staff Report  ");
        jScrollPane1.setViewportView(jTextPane1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Sr. No.", "Staff Code", "Staff Name", "Father Name", "Sex", "DOB", "DOJ", "Phone", "Caste", "Category", "HQA", "HQP", "Class Taught", "Main Subject Taught", "Mathematics Studied upto", "English Studied upto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnControlVisible(true);
        jTable1.setComponentPopupMenu(jPopupMenu1);
        jScrollPane2.setViewportView(jTable1);

        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextPane2.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane2.setEditable(false);
        jTextPane2.setText("View and print staffs' detailed report.");
        jScrollPane3.setViewportView(jTextPane2);

        jButton2.setText("View Ex-Teacher");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("View Teacher");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("View All");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149)
                .addComponent(jButton2)
                .addGap(64, 64, 64)
                .addComponent(jButton3)
                .addGap(67, 67, 67)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try
        {
        String s="Staff Report";
        MessageFormat header=new MessageFormat(s);
        jTable1.print(PrintMode.FIT_WIDTH, header, null);
        }

        catch(Exception e)
        {
         System.err.println("Error in printing staff report");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       int selection=JOptionPane.showConfirmDialog(null,"Do you really Want to Re-Admit Teacher","Re-Admit",JOptionPane.OK_CANCEL_OPTION);
if(selection==JOptionPane.OK_OPTION)
    ReAdmissionStudent();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       int selection=JOptionPane.showConfirmDialog(null,"DO you really Want to Delete/Ex Teacher","Delete Teacher",JOptionPane.OK_CANCEL_OPTION);
if(selection==JOptionPane.OK_OPTION)
    deleteStudent();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
         deletePermanent();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       viewTeacher(0);
}//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        viewTeacher(1);
}//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       loadStaffs();
    }//GEN-LAST:event_jButton4ActionPerformed

    public void viewTeacher(int status)
    {
         try
        {
          //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
          ps=con.prepareStatement("select code,name,fname,sex,date_format(dob,'%M %d, %Y '),date_format(doj,'%M %d, %Y '),phone,caste,category,hqa,hqp,classtaught,mainsubject,maths,english from staffentry left join `staffmoreinformation` on code=staffcode where status=?");
          ps.setInt(1,status);
          rs=ps.executeQuery();

          int i=0,j=0;
          while(rs.next())
          {
           j++;
          }
          model.setRowCount(j);

          rs.first();
          rs.previous();

          while(rs.next())
          {
          model.setValueAt(i+1, i, 0);
          model.setValueAt(rs.getString(1), i, 1);
          model.setValueAt(rs.getString(2), i, 2);
          model.setValueAt(rs.getString(3), i, 3);
          model.setValueAt(rs.getString(4), i, 4);
          model.setValueAt(rs.getString(5), i, 5);
          model.setValueAt(rs.getString(6), i, 6);
          model.setValueAt(rs.getString(7), i, 7);
          model.setValueAt(rs.getString(8), i, 8);
          model.setValueAt(rs.getString(9), i, 9);
          model.setValueAt(rs.getString(10), i, 10);
          model.setValueAt(rs.getString(11), i, 11);
          model.setValueAt(rs.getString(12), i, 12);
          model.setValueAt(rs.getString(13), i, 13);
          model.setValueAt(rs.getString(14), i, 14);
          model.setValueAt(rs.getString(15), i, 15);
          i++;
          }
         // con.close();
        }
        catch(Exception e)
        {
            System.err.println("Error in loading staffs..."+e);
        }
    }
public void ReAdmissionStudent()
    {
         int crow=jTable1.getSelectedRow();
        String id=model.getValueAt(crow,1).toString();
   //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
     {

        ps=con.prepareStatement("update staffentry set status=? where code=?") ;
       ps.setInt(1,1);
        ps.setString(2,id);
      ps.executeUpdate();
    }
     catch(Exception e)
     {
         e.printStackTrace();
     }
    }

public void deleteStudent()
{

     int crow=jTable1.getSelectedRow();
        String id=model.getValueAt(crow,1).toString();
  // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
     {
         ps=con.prepareStatement("update staffentry set status=? where code=?") ;

       ps.setInt(1,0);
        ps.setString(2,id);
      ps.executeUpdate();
    }catch(Exception e)
    {
        e.printStackTrace();
    }
}
public void deletePermanent()
     {
         int choose=JOptionPane.showConfirmDialog(null,"Do you Delete this student permanently?","Delete Student",JOptionPane.OK_OPTION);
         if(choose==JOptionPane.OK_OPTION)
         {
         int crow=jTable1.getSelectedRow();
        String id=model.getValueAt(crow,1).toString();
   //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
     {
      ps=con.prepareStatement("delete from staffentry where code=?") ;
      ps.setString(1,id);
      ps.executeUpdate();
      //com.duc.StudentDepartment.SearchStudent.PermanentDeleteOffRecords rr=new com.duc.StudentDepartment.SearchStudent.PermanentDeleteOffRecords();
     //jDesktopPane1.add(rr,0);
      //rr.setVisible(true);
      //rr.id=id;
      //rr.setFlag(1);
     }catch(Exception e)
     {
         e.printStackTrace();
     }
     }
     }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private org.jdesktop.swingx.JXTable jTable1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    // End of variables declaration//GEN-END:variables
  // Connection con;
   PreparedStatement ps;
   ResultSet rs;
}