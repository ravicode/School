/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ShowWork.java
 *
 * Created on Sep 18, 2009, 7:40:20 PM
 */

package com.duc.Reception.ClassWork;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.sql.*;
import static com.duc.DatabaseConnection.DatabaseConnection.*;
import java.util.HashMap;
import com.duc.ImportSection.MapForIndex;
import java.text.MessageFormat;
import javax.swing.JTable.PrintMode;
/**
 *
 * @author Ravi Dangaich
 */
public class ShowWork extends javax.swing.JInternalFrame
{
    ArrayList<String> ids=new ArrayList<String>();
    private DefaultTableModel model;
      //MapForIndex mp= new MapForIndex();
      HashMap classmap1= mp.getClassIndexFromName();
      HashMap classmap=mp.getClassIndexName();
      HashMap sectiomap1=mp.getSectionIndexFromName();
      HashMap sectionmap=mp.getSectionIndexName();
      HashMap subjectmap1=mp.getSubjectIndexFromName();
      HashMap subjectmap=mp.getSubjectIndexToName();
    /** Creates new form ShowWork */
    public ShowWork()
    {
        initComponents();
         model = (DefaultTableModel) jTable1.getModel();
        //DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
        cmbDate.setDateFormat(df);
        addClass();
         showAll();
    }
    

        public void addClass()
    {
       try
       {
         //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
         ps=con.prepareStatement("select * from classsetup ");
         rs=ps.executeQuery();

         while(rs.next())
         cmbClass.addItem(rs.getString(1));

         //con.close();

       }
       catch(Exception e)
       {
        System.err.println("Exception is..."+e);
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        printButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        showAllWork = new javax.swing.JButton();
        cmbTeacher = new javax.swing.JComboBox();
        cmbDate = new datechooser.beans.DateChooserCombo();
        searchDateButton = new javax.swing.JButton();
        cmbClass = new javax.swing.JComboBox();
        cmbSubject = new javax.swing.JComboBox();
        checkClass = new javax.swing.JCheckBox();
        checkSubject = new javax.swing.JCheckBox();
        checkTeacher = new javax.swing.JCheckBox();
        checkDate = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Show Classwork");

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Class", "Section", "Subject", "Teacher Name", "ClassWork", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTextPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextPane1.setText("                                                                             Show ClassWorks");
        jScrollPane2.setViewportView(jTextPane1);

        jTextPane2.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane2.setEditable(false);
        jTextPane2.setText("It will show all the class works given to a particular class regarding to a particular subject of a teacher.");
        jScrollPane3.setViewportView(jTextPane2);

        printButton.setText("Print");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        showAllWork.setText("Show All");
        showAllWork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllWorkActionPerformed(evt);
            }
        });

        cmbTeacher.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));

        searchDateButton.setText("Search");
        searchDateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDateButtonActionPerformed(evt);
            }
        });

        cmbClass.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        cmbClass.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbClassItemStateChanged(evt);
            }
        });

        cmbSubject.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));

        checkClass.setBackground(new java.awt.Color(0, 204, 204));
        checkClass.setText("Class");

        checkSubject.setBackground(new java.awt.Color(0, 204, 204));
        checkSubject.setText("Subject");

        checkTeacher.setBackground(new java.awt.Color(0, 204, 204));
        checkTeacher.setText("Teacher");

        checkDate.setBackground(new java.awt.Color(0, 204, 204));
        checkDate.setText("Date");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 864, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 864, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkClass, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbSubject, 0, 129, Short.MAX_VALUE)
                    .addComponent(cmbClass, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkDate, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(checkTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbDate, 0, 0, Short.MAX_VALUE)
                            .addComponent(cmbTeacher, 0, 147, Short.MAX_VALUE))))
                .addGap(34, 34, 34)
                .addComponent(searchDateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(221, 221, 221))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(showAllWork, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(515, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(checkClass, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchDateButton))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cmbClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(cmbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkTeacher)
                            .addComponent(cmbTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(checkDate)))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showAllWork)
                    .addComponent(printButton)
                    .addComponent(closeButton))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(checkSubject)
                .addGap(287, 287, 287))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void searchDateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchDateButtonActionPerformed
        //viewCourierByDate();    // TODO add your handling code here:
        
        if(!checkTeacher.isSelected() && !checkSubject.isSelected() && !checkClass.isSelected() && !checkDate.isSelected())
        {
        showAll();
        return;
        }
        buildCommand();

}//GEN-LAST:event_searchDateButtonActionPerformed

    public void buildCommand()
    {
     String command="";

     if(checkClass.isSelected())
     command+=" class = " +classmap1.get(cmbClass.getSelectedItem().toString()).toString()+"  and  " ;

     if(checkSubject.isSelected())
     command+=" subject = " +subjectmap1.get( cmbSubject.getSelectedItem().toString()).toString()+"  and  " ;

     if(checkDate.isSelected())
     command+=" taskdate = " +cmbDate.getText()+"  and  " ;

     if(checkTeacher.isSelected())
     {
         String code= ids.get(cmbTeacher.getSelectedIndex()-1);
         command+=" teachercode= '"+code+"' and ";
     }

     command+=" 1 > 0 ";
     System.out.println(command);
     searchClasswork(command);

    }


    public void showAll()
    {
        String command=" 1>0";
        searchClasswork(command);
    }

    public void searchClasswork(String command)
    {
    try
    {
     // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
      ps=con.prepareStatement("select class,section,subject,name,task,taskdate from subjectallotment,staffentry,classwork where teachercode=code and allotmentid=id and  "+command);
      rs=ps.executeQuery();

      int i=0,j=0;

      while(rs.next())
      j++;

      model.setRowCount(j);

      rs.first();
      rs.previous();

      while(rs.next())
      {
          model.setValueAt(classmap.get(rs.getInt(1)), i, 0);
          model.setValueAt(sectionmap.get(rs.getInt(2)), i, 1);
          model.setValueAt(subjectmap.get(rs.getInt(3)), i, 2);
          model.setValueAt(rs.getString(4), i, 3);
          model.setValueAt(rs.getString(5), i, 4);
          model.setValueAt(rs.getString(6), i, 5);

          i++;
      }
     // con.close();
    }
    catch(Exception e)
    {
     System.err.println("Error in search..."+e);
    }

    }

    private void showAllWorkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAllWorkActionPerformed
       showAll();        // TODO add your handling code here:
}//GEN-LAST:event_showAllWorkActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        this.dispose();            // TODO add your handling code here:
}//GEN-LAST:event_closeButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        try
        {
        String s="Student HomeWork Record";
        MessageFormat header=new MessageFormat(s);
        jTable1.print(PrintMode.FIT_WIDTH, header, null);
        }

        catch(Exception e)
        {
         System.err.println("Error in printing student search");
        }
}//GEN-LAST:event_printButtonActionPerformed

    private void cmbClassItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbClassItemStateChanged
        // TODO add your handling code here:
         if(cmbClass.getSelectedIndex()>0)
         {
           String cls=cmbClass.getSelectedItem().toString();
           loadSubjects(cls);
           loadTeachers();
         }
         else
         {
           cmbSubject.removeAllItems();
           cmbTeacher.removeAllItems();
         }
    }//GEN-LAST:event_cmbClassItemStateChanged

    public void loadSubjects( String cls)
    {

         try
        {
          System.out.println("Loading subjects...");
         // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
          ps=con.prepareStatement("select distinct `subjectlist`.`subjecttitle` from `subjectlist`,`subjectsetup` where `subjectlist`.`subjectid`=`subjectsetup`.`subjecttitle` and classtitle=?");
          ps.setInt(1, Integer.parseInt(classmap1.get(cls).toString()));
          rs=ps.executeQuery();

          cmbSubject.removeAllItems();
          cmbSubject.addItem("Choose");
          while(rs.next())
          {
           cmbSubject.addItem(rs.getString(1));
          }
        }
        catch(Exception e)
        {
            System.err.println("Error is ..."+e);
        }
    }

    public void loadTeachers()
    {
      try
      {
       // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        ps=con.prepareStatement("select teachercode,name from subjectallotment,staffentry where teachercode=code and class=? ");
        ps.setInt(1,Integer.parseInt(classmap1.get(cmbClass.getSelectedItem().toString()).toString()) );
        rs=ps.executeQuery();
        
        ids.clear();
        cmbTeacher.removeAllItems();
        cmbTeacher.addItem("Choose");
        while(rs.next())
        {         
         ids.add(rs.getString(1));
         cmbTeacher.addItem(rs.getString(1)+" [ "+rs.getString(2)+" ]");
        }
       // con.close();
      }
      catch(Exception e)
      {
         System.err.println("Error in loading teachers..."+e);
      }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkClass;
    private javax.swing.JCheckBox checkDate;
    private javax.swing.JCheckBox checkSubject;
    private javax.swing.JCheckBox checkTeacher;
    private javax.swing.JButton closeButton;
    private javax.swing.JComboBox cmbClass;
    private datechooser.beans.DateChooserCombo cmbDate;
    private javax.swing.JComboBox cmbSubject;
    private javax.swing.JComboBox cmbTeacher;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JButton printButton;
    private javax.swing.JButton searchDateButton;
    private javax.swing.JButton showAllWork;
    // End of variables declaration//GEN-END:variables
  // Connection con;
   PreparedStatement ps;
   ResultSet rs;
}
