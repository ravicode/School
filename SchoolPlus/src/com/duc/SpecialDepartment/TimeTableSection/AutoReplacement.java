/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TimeTableSetUp.java
 *
 * Created on Oct 5, 2009, 6:01:57 PM
 */

package com.duc.SpecialDepartment.TimeTableSection;

import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.decorator.HighlighterFactory;
import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable.PrintMode;
import java.util.*;
import com.duc.ImportSection.MapForIndex;
import static com.duc.DatabaseConnection.DatabaseConnection.*;

/**
 *
 * @author sourabh
 */


public class AutoReplacement extends javax.swing.JInternalFrame
{
          // MapForIndex mp=new MapForIndex();
           HashMap classmap1=mp.getClassIndexFromName();
           HashMap subjectmap1=mp.getSubjectIndexFromName();
           HashMap classmap=mp.getClassIndexName();
           HashMap subjectmap=mp.getSubjectIndexToName();
           HashMap sectionmap=mp.getSectionIndexName();
           HashMap sectionmap1=mp.getSectionIndexFromName();
           HashMap allTeachers=new HashMap();
           int dayofweek=0;

     private DefaultTableModel model;
     private DefaultTableModel dm;

     private ArrayList<String> absents=new ArrayList<String>();
     private ArrayList<Integer> recess = new ArrayList<Integer> ();       
     private ArrayList<String> temptcodes= new ArrayList<String>();
     private ArrayList<String> classtcodes= new ArrayList<String>();
     private ArrayList<ReplacedPeriods> rperiods=new ArrayList<ReplacedPeriods>();

    /** Creates new form TimeTableSetUp */
    public AutoReplacement()
    {
        initComponents();

        jTable1.setHorizontalScrollEnabled(true);
        jTable1.setHighlighters(HighlighterFactory.createAlternateStriping());       

        model = new TimeTableModel(0).createDefaultModel();
        jTable1.setModel(model);       
       

         absents.clear();
         recess.clear();
         rperiods.clear();
        
         addTeachers();
         loadDays();
         addClass();
         loadRecessColumns();
         loadAbsents();
         loadDayOfWeek();
    }

public void loadDayOfWeek()
{
  try
  {
   ps=con.prepareStatement("select DAYOFWEEK(CURRENT_DATE())");
  rs=ps.executeQuery();
  rs.next();
  dayofweek=rs.getInt(1)-2;
  System.out.println("Day of Week"+dayofweek);
  }
  catch(Exception e)
  {
  e.printStackTrace();
  }
}

    public void addTeachers()
    {
       allTeachers.clear();
       try
       {
         ps=con.prepareStatement("select distinct teachercode,name from subjectallotment,staffentry where teachercode=code ");
         rs=ps.executeQuery();
         while(rs.next())
         {
         allTeachers.put(rs.getString(1), rs.getString(2));
         }
       }
       catch(Exception e)
       {
        e.printStackTrace();
       }
    }

    public void loadAbsents()
    {

          try
       {
        //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        ps=con.prepareStatement("select staffcode from staffattendance where date=current_date()");
        rs=ps.executeQuery();

        while(rs.next())
        {
          absents.add(rs.getString(1));
        }        
       }
        catch(Exception e)
        {
        System.err.println("Error in loading absents"+e);
        }
    }


    public void loadRecessColumns()
    {
        recess.add(0);

        try
       {
       // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        ps=con.prepareStatement("select recess,id from timetableperiods order by id");
        rs=ps.executeQuery();

        int i=1;
        while(rs.next())
        {
         if(rs.getInt(1)==1)
         recess.add(i);         
         i++;
        }
        //   con.close();
        }
        catch(Exception e)
        {
         System.err.println("Error is ..."+e);
        }

    }

      public void addClass()
    {
       try
       {
        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
         ps=con.prepareStatement("select * from classsetup ");
         rs=ps.executeQuery();

         while(rs.next())
         cmbClass.addItem(rs.getString(1));

       //  con.close();

       }
       catch(Exception e)
       {
        System.err.println("Exception is..."+e);
       }
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

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jDialog1 = new javax.swing.JDialog();
        cmbTeacher = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        cmbClass = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cmbSection = new javax.swing.JComboBox();
        jButton5 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new org.jdesktop.swingx.JXTable();
        sectionLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jScrollPane2.setViewportView(jTextPane2);

        jDialog1.setTitle("Choose Teacher and subject");
        jDialog1.setAlwaysOnTop(true);
        jDialog1.setBackground(new java.awt.Color(0, 204, 204));
        jDialog1.setBounds(new java.awt.Rectangle(150, 150, 350, 200));

        cmbTeacher.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choose" }));
        cmbTeacher.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTeacherItemStateChanged(evt);
            }
        });

        jLabel3.setText("Teacher");

        jButton3.setText("OK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton6.setText("Close");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDialog1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDialog1Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton6))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(0, 204, 204));
        setClosable(true);
        setIconifiable(true);
        setTitle("Time Table Setup");

        jTextPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jTextPane1.setText("                                                          Class Time Table with Replacement");
        jScrollPane1.setViewportView(jTextPane1);

        jLabel1.setText("Class");

        cmbClass.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choose" }));
        cmbClass.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbClassItemStateChanged(evt);
            }
        });

        jLabel2.setText("Section");

        cmbSection.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbSectionMouseClicked(evt);
            }
        });
        cmbSection.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSectionItemStateChanged(evt);
            }
        });

        jButton5.setText("Print");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
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
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jTable1.setRowHeight(90);
        jTable1.setSortable(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable1);

        sectionLabel.setText("        ");

        jButton1.setText("Save Replacement");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Delete Replacements");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Close");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbClass, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbSection, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sectionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(cmbSection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton5)
                    .addComponent(jButton4)
                    .addComponent(jButton2)
                    .addComponent(sectionLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(cmbTeacher.getSelectedIndex()<=0)
        return;
                 
        if(cmbTeacher.getSelectedItem().toString().contains("--"))
        return;

        setBlock();
        jDialog1.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    public void setBlock()
    { 
    int row=jTable1.getSelectedRow();
    int column=jTable1.getSelectedColumn();

    String rtcode="",atcode="";
    int cls=Integer.parseInt(String.valueOf(classmap1.get(cmbClass.getSelectedItem().toString())));
    int section=Integer.parseInt(String.valueOf(sectionmap1.get(cmbSection.getSelectedItem().toString())));

    for(Iterator i=allTeachers.entrySet().iterator(); i.hasNext(); )
    {
    Map.Entry e = (Map.Entry) i.next();
    System.out.println(e.getKey() + ": " + e.getValue());
    if(e.getValue().toString().equals(cmbTeacher.getSelectedItem().toString()))
    {
      rtcode=e.getKey().toString();
      System.out.println("rtname: "+rtcode);
      break;
    }
   }

   try
   {
    ps=con.prepareStatement("select teachercode from periodallotment where class=? and section=? and row=? and periodallotment.column=? ");
    ps.setInt(1, cls);
    ps.setInt(2, section);
    ps.setInt(3, row);
    ps.setInt(4, column);
    rs=ps.executeQuery();
    if(rs.next())
    atcode=rs.getString(1);
    System.out.println("atcode: "+atcode);
   }
   catch(Exception e)
   {
    e.printStackTrace();
   }

   ReplacedPeriods rp=new ReplacedPeriods();
   rp.absentcode=atcode;
   rp.replacecode=rtcode;
   rp.row=row;
   rp.column=column;   

   rperiods.add(rp);
   
   title="<html><font color='black' size=3>"+cmbTeacher.getSelectedItem().toString()+"</font></html>";
   model.setValueAt(title, row, column);
    }
    
    private void cmbTeacherItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTeacherItemStateChanged
        // TODO add your handling code here:
       
    }//GEN-LAST:event_cmbTeacherItemStateChanged

 
    private void cmbClassItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbClassItemStateChanged
        // TODO add your handling code here:
        if(cmbClass.getSelectedIndex()<=0)
        {
        fillEmptyTimeTable();
        sectionLabel.setText("");
        return;
        }
        loadSection();
       
        if(!cmbSection.getSelectedItem().toString().isEmpty())
        {
        loadClassTimeTable();
        rperiods.clear();
        sectionLabel.setText(cmbSection.getSelectedItem().toString());
        }
        
    }//GEN-LAST:event_cmbClassItemStateChanged

  
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try
        {
        String s="Temp. Time Table For (";
        s+=" Class : "+cmbClass.getSelectedItem().toString()+" , Section : "+cmbSection.getSelectedItem().toString()+" )";
        MessageFormat header=new MessageFormat(s);
        jTable1.print(PrintMode.FIT_WIDTH, header, null);
        }
        catch(Exception e)
        {
         System.err.println("Error in printing timetable");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        jDialog1.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        System.out.println("row is .."+jTable1.getSelectedRow()+" Column is..."+jTable1.getSelectedColumn());

        if(jTable1.getSelectedRow()!=dayofweek)
        return;
        
        int j=jTable1.getSelectedColumn();
        if(recess.contains(j))
         ;
        else {
            loadTeachers();
            jDialog1.setVisible(true);            
           }
    }//GEN-LAST:event_jTable1MouseClicked

    private void cmbSectionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSectionItemStateChanged
        // TODO add your handling code here:
      /* */
    }//GEN-LAST:event_cmbSectionItemStateChanged

    private void cmbSectionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbSectionMouseClicked
        // TODO add your handling code here:
          if(cmbClass.getSelectedIndex()<=0)
        {
         fillEmptyTimeTable();
         sectionLabel.setText("");
         return;
        }
        sectionLabel.setText(cmbSection.getSelectedItem().toString());
        rperiods.clear();
        loadClassTimeTable();
    }//GEN-LAST:event_cmbSectionMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        saveReplacements();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void saveReplacements()
    {
    ReplacedPeriods rp= new ReplacedPeriods();
    int cls=Integer.parseInt(String.valueOf(classmap1.get(cmbClass.getSelectedItem().toString())));
    int section=Integer.parseInt(String.valueOf(sectionmap1.get(cmbSection.getSelectedItem().toString())));

    try
    {
       ps=con.prepareStatement("delete from teacher_replacement where class=? and section=? and date=current_date()");
       ps.setInt(1, cls);
       ps.setInt(2,section);
       ps.executeUpdate();

      for(int i=0;i<rperiods.size();i++)
      {
       rp=rperiods.get(i);
       ps=con.prepareStatement("insert into teacher_replacement(t_absent,t_replace,class,section,row,col,date) values(?,?,?,?,?,?,(select current_date()))");
       ps.setString(1, rp.absentcode);
       ps.setString(2, rp.replacecode);
       ps.setInt(3, cls);
       ps.setInt(4, section);
       ps.setInt(5, rp.row);
       ps.setInt(6, rp.column);
       ps.executeUpdate();
      }
       JOptionPane.showMessageDialog(null, "Replacement Saved successfully.", "Message", JOptionPane.INFORMATION_MESSAGE);
    }
    catch(Exception e)
    {
    e.printStackTrace();
    }
  }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        super.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        deleteReplacement();
    }//GEN-LAST:event_jButton2ActionPerformed

    public void deleteReplacement()
    {
         try
         {
           ps=con.prepareStatement("delete from teacher_replacment where class=? and section=? and date=(select current_date())");
           ps.setInt(1,Integer.parseInt(classmap1.get(cmbClass.getSelectedItem().toString()).toString()));
           ps.setInt(2,Integer.parseInt(sectionmap1.get(cmbSection.getSelectedItem().toString()).toString()));
           ps.executeUpdate();
           JOptionPane.showMessageDialog(null, "Replacement Deleted Successfully.", "Message", JOptionPane.INFORMATION_MESSAGE);
         }
         catch(Exception e)
         {
           e.printStackTrace();
         }
    }


    public void fillEmptyTimeTable()
    {
      int row=0;
      int column=0;
      System.out.println("Filling Empty Table:");
      int j=model.getColumnCount();

      for(column=1;column<j;column++)
      {
         for (row=0;row<=5;row++)
         {
          model.setValueAt("", row, column);  
         }
      }

    }
    
    public void loadClassTimeTable()
    {
      int row=0,column=0,subject;
      String code,name,period="";
      try
      {
      // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
       ps=con.prepareStatement("select row,`periodallotment`.`column`,teachercode,name,subject from periodallotment, staffentry where teachercode=code and  class=? and section=?");
       ps.setInt(1,Integer.parseInt(String.valueOf(classmap1.get(cmbClass.getSelectedItem().toString()))));
       ps.setInt(2,Integer.parseInt(String.valueOf(sectionmap1.get(cmbSection.getSelectedItem().toString()))));
       rs=ps.executeQuery();     

       fillEmptyTimeTable();     

       while(rs.next())
       {
       row=rs.getInt(1);
       column=rs.getInt(2);
       code=rs.getString(3);
       name=rs.getString(4);
       subject=rs.getInt(5);     

       System.out.println("Row: "+row+" Column: "+column+" Name: "+name +" Subject: "+subject);
       
       if(!absents.contains(code))
       period="<html><font color='blue'>"+code+" [ "+name+" ]"+"</font><br /><font color='green'>"+String.valueOf(subjectmap.get(subject)) +"</font><br /></html>";

       else
     {
       if(row==dayofweek )
      {
       System.out.println("Inside dayofweek check");
       period="<html><font color='blue'>"+code+" </font> <font color=red>[ <s>"+name+"</s> ]"+"</font><br /><font color='green'>"+String.valueOf(subjectmap.get(subject)) +"</font><br /></html>";
      }
        else
       period="<html><font color='blue'>"+code+" [ "+name+" ]"+"</font><br /><font color='green'>"+String.valueOf(subjectmap.get(subject)) +"</font><br /></html>";
    }

       model.setValueAt(period, row, column);
     }
       ps=con.prepareStatement("select t_replace,row,teacher_replacement.col from teacher_replacement where class=? and section=? and date=(select current_date())");
       ps.setInt(1,Integer.parseInt(String.valueOf(classmap1.get(cmbClass.getSelectedItem().toString()))));
       ps.setInt(2,Integer.parseInt(String.valueOf(sectionmap1.get(cmbSection.getSelectedItem().toString()))));
       rs=ps.executeQuery();
       String t="";
       while(rs.next())
       {
         t="<html><font color='black' size=3>" +allTeachers.get(rs.getString(1)).toString() +"</font></html>" ;
         model.setValueAt(t, rs.getInt(2), rs.getInt(3));
       }
      }
      catch(Exception e)
      {
       System.err.println("Error in loading class time table..."+e);
      }
    }

      
  public void loadTeachers()
    {
        if(cmbClass.getSelectedIndex()<=0)
        return;

        int row=jTable1.getSelectedRow();
        int column=jTable1.getSelectedColumn();
        int cls=Integer.parseInt(String.valueOf(classmap1.get(cmbClass.getSelectedItem().toString())));
        int section=Integer.parseInt(String.valueOf(sectionmap1.get(cmbSection.getSelectedItem().toString())));

        cmbTeacher.removeAllItems();
        cmbTeacher.addItem("<--Choose-->");
        try
      {
        ps=con.prepareStatement("select teachercode from periodallotment where class=? and section=? and row=? and periodallotment.column=?");
        ps.setInt(1, cls);
        ps.setInt(2, section);
        ps.setInt(3, row);
        ps.setInt(4, column);
        rs=ps.executeQuery();
        rs.next();
        if(!absents.contains(rs.getString(1)))
        return;
        
        System.out.println("ABBBBCCCCCCC");

        ps=con.prepareStatement("select distinct t_replace from teacher_replacement where row=? and teacher_replacement.col=? and  date= current_date()");
        ps.setInt(1, row);
        ps.setInt(2, column);
        rs=ps.executeQuery();
        
        temptcodes.clear();
        classtcodes.clear();
        while(rs.next())
        {
         temptcodes.add(rs.getString(1));
        }

        ps=con.prepareStatement("select distinct teachercode from periodallotment where class=? and teachercode NOT IN (select teachercode from periodallotment where row=? and `periodallotment`.column=?)");
        ps.setInt(1,Integer.parseInt(String.valueOf(classmap1.get(cmbClass.getSelectedItem().toString()))));
        ps.setInt(2, row);
        ps.setInt(3, column);
        rs=ps.executeQuery();

       String s="" ;
       while(rs.next())
     {
         s=rs.getString(1);
         if(!absents.contains(s))
       {
         if(!temptcodes.contains(s))
         {
          cmbTeacher.addItem(allTeachers.get(s));
          classtcodes.add(s);
          System.out.println("Match Found");
         }
       }
     }
        cmbTeacher.addItem("---------------------");

        ps=con.prepareStatement("select distinct teachercode from periodallotment where teachercode NOT IN (select distinct teachercode from `periodallotment` where row=? and `periodallotment`.column=?)");
        ps.setInt(1, row);
        ps.setInt(2, column);
        rs=ps.executeQuery();
        s="";
     while(rs.next())
     {
         s=rs.getString(1);
         if(!absents.contains(s))
       {
         if(!temptcodes.contains(s))
         {
           if(!classtcodes.contains(s))
           {
            cmbTeacher.addItem(allTeachers.get(s));
            System.out.println("Match Found1");
           }
         }
       }
     }       
    }
      catch(Exception e)
      {
         System.err.println("Error in loading teachers..."+e);
      }
    }

    
    public void loadSection()
{

        if(cmbClass.getSelectedIndex()<=0)
        return;
      try
       {
       //  con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
         ps=con.prepareStatement("select sectiontitle from sectionsetup where classtitle=?");
         ps.setInt(1,Integer.parseInt(String.valueOf(classmap1.get(cmbClass.getSelectedItem().toString()))));
         rs=ps.executeQuery();

         cmbSection.removeAllItems();

         while(rs.next())
         {
         cmbSection.addItem(String.valueOf(sectionmap.get(rs.getInt(1))));
         }
        //  con.close();
       }
       catch(Exception e)
       {
        System.err.println("Error is..."+e);
       }
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbClass;
    private javax.swing.JComboBox cmbSection;
    private javax.swing.JComboBox cmbTeacher;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private org.jdesktop.swingx.JXTable jTable1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JLabel sectionLabel;
    // End of variables declaration//GEN-END:variables

   //Connection con;
   PreparedStatement ps;
   ResultSet rs;
}
