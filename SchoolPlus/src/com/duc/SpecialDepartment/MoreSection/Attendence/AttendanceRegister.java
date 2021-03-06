/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AttendanceRegister.java
 *
 * Created on Oct 2, 2009, 4:58:07 PM
 */

package com.duc.SpecialDepartment.MoreSection.Attendence;
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
public class AttendanceRegister extends javax.swing.JInternalFrame
{
   // MapForIndex mp=new MapForIndex();
    HashMap classmap1=mp.getClassIndexFromName();
    HashMap sectionmap=mp.getSectionIndexName();
    HashMap sectionmap1=mp.getSectionIndexFromName();
    
    private DefaultTableModel model;
    private ArrayList<String> urns = new ArrayList<String>();
    private ArrayList<String> abs = new ArrayList<String>();
    private ArrayList<Integer> holidays=new ArrayList<Integer>();
    private ArrayList<Integer> sundays=new ArrayList<Integer>();


    private static final String present = "<html><font color='green'><b><center>P</center></b></font></html>";
    private static final String abscent = "<html><font color='red'><b><center>A</center></b></font></html>";
    private static final String holiday = "<html><font color='blue'><b><center>H</center></b></font></html>";
    private static final String sunday = "<html><font color='purple'><b><center>S</center></b></font></html>";
    private static final String noclass = "<html><font color='gray'><b><center>N</center></b></font></html>";


    /** Creates new form AttendanceRegister */
    public AttendanceRegister()
    {
        initComponents();
        addClass();
        jTable1.setHighlighters(HighlighterFactory.createAlternateStriping());
        jTable1.setHorizontalScrollEnabled(true);

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

       //  con.close();

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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbYear = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cmbMonth = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cmbClass = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new org.jdesktop.swingx.JXTable();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cmbSection = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        studentCheck = new javax.swing.JRadioButton();
        staffCheck = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setBackground(new java.awt.Color(0, 204, 204));
        setClosable(true);
        setIconifiable(true);
        setTitle("Month Wise Attendance Register");

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setText("Year");

        cmbYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2009", "2010", "2011", "2012" }));

        jLabel2.setText("Month");

        cmbMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jan", "Feb", "March", "April", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec" }));

        jLabel3.setText("Class");

        cmbClass.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<--Select-->" }));
        cmbClass.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbClassItemStateChanged(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setColumnControlVisible(true);
        jTable1.setSortable(false);
        jScrollPane3.setViewportView(jTable1);

        jButton1.setText("view");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Section");

        jButton2.setText("Print Chart");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        studentCheck.setBackground(new java.awt.Color(0, 204, 204));
        buttonGroup1.add(studentCheck);
        studentCheck.setText("Student");
        studentCheck.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                studentCheckItemStateChanged(evt);
            }
        });

        staffCheck.setBackground(new java.awt.Color(0, 204, 204));
        buttonGroup1.add(staffCheck);
        staffCheck.setText("Staff");
        staffCheck.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                staffCheckItemStateChanged(evt);
            }
        });

        jTextPane2.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane2.setEditable(false);
        jTextPane2.setText("In Chart P=Present, A=Absent, H=Holiday, S=Sunday, N=No data or Class");
        jScrollPane2.setViewportView(jTextPane2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(54, 54, 54)
                            .addComponent(studentCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(staffCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(559, 559, 559))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbClass, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbSection, 0, 103, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentCheck)
                    .addComponent(staffCheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cmbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(cmbClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
        );

        jTextPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jTextPane1.setText("                                                       View Students'  and Staffs' Attendances");
        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        if(!studentCheck.isSelected() && !staffCheck.isSelected())
        {
         javax.swing.JOptionPane.showMessageDialog(null, "Select Student or Staff", "Error Report", JOptionPane.ERROR_MESSAGE);
         return;
        }
        
        int month = cmbMonth.getSelectedIndex()+1;
        int year =Integer.parseInt(cmbYear.getSelectedItem().toString());
        int option=0;

        if(staffCheck.isSelected())
        option=1;

        model = new AttendanceTableModel(month, year,option).createDefaultModel();
        jTable1.setModel(model);

        if(cmbClass.getSelectedIndex()<=0 && !staffCheck.isSelected())
        {
        javax.swing.JOptionPane.showMessageDialog(null, "Select Class First!", "Error Report", JOptionPane.ERROR_MESSAGE);
        return;
        }
        loadBasicData(option);
        defaultNo();
        updatePresent(option);
        updateHolidays();
        updateSundays();
        updateAbsent(option);
        jTable1.packAll();        
    }//GEN-LAST:event_jButton1ActionPerformed

    public void updateHolidays()
    {

        try
        {
          //  con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select day(Date) from holiday where Year(Date)=? and month(Date)=?");
            ps.setString(1, cmbYear.getSelectedItem().toString());
            ps.setInt(2, cmbMonth.getSelectedIndex()+1);
            rs=ps.executeQuery();

           System.out.println(" searching for holidays........");
           holidays.clear();
            while(rs.next())
            {
              System.out.println("holiday........"+rs.getInt(1));
              holidays.add(rs.getInt(1));
            }

            if(!holidays.isEmpty())
            {
              for(int x : holidays)
        {
          for(int i=0;i<model.getRowCount();i++)
          {
              model.setValueAt(holiday, i, x+2);
          }
        }
            }

          //  con.close();
        }
        catch(Exception e)
        {
         System.err.println("Error in updating holidays ..."+e);
        }
    }


    public void updateSundays()
    {
        String year,month,day;
        int m;
        year=cmbYear.getSelectedItem().toString();
        m=cmbMonth.getSelectedIndex()+1;
        month=String.valueOf(m);

          try
        {
           // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            System.out.println(" searching for sundays........");

            int days=model.getColumnCount()-3;
            System.out.println(" column count ........"+days);
            sundays.clear();
            for (int i=1;i<=days;i++)
            {
            System.out.println(" i= "+i);
            ps=con.prepareStatement("select dayname(?)");
            day=String.valueOf(i);
            ps.setString(1, year+"-"+month+"-"+day);

            rs=ps.executeQuery();
            if(rs.next())
            {
               if(rs.getString(1).equals("Sunday"))
               sundays.add(i);
            }
            
            }


            if(!sundays.isEmpty())
            {
              for(int x : sundays)
        {
          for(int i=0;i<model.getRowCount();i++)
          {
              System.out.println("Row= "+i+"  and Column= "+(x+2));
              model.setValueAt(sunday, i, x+2);
          }
        }
            }

           // con.close();
        }
        catch(Exception e)
        {
         System.err.println("Error in updating sundays ..."+e);
        }
    }


    public void updateAbsent(int option)
    {
        abs.clear();
        
        try
        {
          // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
           if(option==0)
           ps=con.prepareStatement("select id_no, day(date) from studentattendance where Year(date)=? and month(date)=?");
           else if(option==1)
           ps=con.prepareStatement("select staffcode, day(date) from staffattendance where Year(date)=? and month(date)=?");

           ps.setString(1, cmbYear.getSelectedItem().toString());
           ps.setInt(2, cmbMonth.getSelectedIndex()+1);
           rs=ps.executeQuery();

           while(rs.next())
           {
               abs.add(rs.getString(1)+"-"+rs.getString(2));
           }

           String data[]=null;

           for(String s : abs)
        {
           System.out.println("updateAbsent..... "+s);
            data = s.split("-");
            if(urns.contains(data[0]))
            {
            model.setValueAt(abscent, urns.indexOf(data[0]), Integer.parseInt(data[1])+2);
            }
            
        }
         //  con.close();
        }
        catch(Exception e)
        {
         System.err.println("Error is ..."+e);
        }
    }



    public void updatePresent(int option)
    {
      try
      {
     // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

      if(option==0)
      {
        ps=con.prepareStatement("select day(Max(lastdate)),month(Max(lastdate)) from classlastattendance where class=? ");
        ps.setInt(1,Integer.parseInt(String.valueOf(classmap1.get(cmbClass.getSelectedItem().toString()))));
      }
      else
      {
         ps=con.prepareStatement("select day(Max(date)),month(Max(date)) from staffattendance");
      }
     
      rs=ps.executeQuery();

      if(rs.next())
      {
          if(rs.getInt(2)==cmbMonth.getSelectedIndex()+1)
          {
            for(int i=0;i<model.getRowCount();i++)
        {
            for(int j=3;j<rs.getInt(1)+3;j++)
            {
                System.out.println("row is " +i+ " Column is"+j);
                model.setValueAt(present, i, j);
            }
        }
          }
        
      }

     // con.close();
      }
      catch(Exception e)
      {
       System.err.println("Error in present..."+e);
      }

    }

    public void defaultNo()
    {
        for(int i=0;i<model.getRowCount();i++)
        {
            for(int j=3;j<model.getColumnCount();j++)
            {
                model.setValueAt(noclass, i, j);
            }
        }
    }



    public void loadBasicData(int option)
    {
     try
     {
     // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
      if(option==0)
      {
      ps=con.prepareStatement("select id,roll,name from studententry where class=? and section=?");
      ps.setInt(1,Integer.parseInt(String.valueOf(classmap1.get(cmbClass.getSelectedItem().toString()))));
      ps.setInt(2,Integer.parseInt(String.valueOf(sectionmap1.get(cmbSection.getSelectedItem().toString() ))));
      }

      else if(option==1)
      {
       ps=con.prepareStatement("select code,name,phone from staffentry");
      }
      
      rs=ps.executeQuery();

      int j=0;

      while(rs.next())
       j++;

      model.setRowCount(j);

      rs.first();
      rs.previous();

      int i=0;
      urns.clear();
      while(rs.next())
      {
       urns.add(rs.getString(1));
       model.setValueAt(rs.getString(1), i, 0);

       if(option==0)
       model.setValueAt(rs.getInt(2), i, 1);
       else
       model.setValueAt(rs.getString(2), i, 1);

       model.setValueAt(rs.getString(3), i, 2);
       i++;
      }
     //  con.close();
     }
     catch(Exception e)
     {
         System.err.println("Error is ..."+e);
     }
    }


    private void cmbClassItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbClassItemStateChanged
        // TODO add your handling code here:
        loadSection();
    }//GEN-LAST:event_cmbClassItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         try
        {
        String s="Attendance Chart For";
        String t="";

        if(staffCheck.isSelected())
        s+=" Staffs(";
        else if(studentCheck.isSelected())
        s+=" Students(";

        s+= "Year:"+cmbYear.getSelectedItem().toString()+",Month:"+cmbMonth.getSelectedItem().toString();
        s+=")";

        if(studentCheck.isSelected())
        t+="( Class:"+cmbClass.getSelectedItem().toString()+", Section:"+cmbSection.getSelectedItem().toString()+" )";

        MessageFormat header=new MessageFormat(s);
        MessageFormat footer=new MessageFormat(t);

        jTable1.print(PrintMode.FIT_WIDTH, header, footer);
        }

        catch(Exception e)
        {
         System.err.println("Error in printing timetable");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void staffCheckItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_staffCheckItemStateChanged
        // TODO add your handling code here:
        if(staffCheck.isSelected())
        {
          jLabel3.setVisible(false);
          jLabel4.setVisible(false);
          cmbClass.setVisible(false);
          cmbSection.setVisible(false);
        }
        
    }//GEN-LAST:event_staffCheckItemStateChanged

    private void studentCheckItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_studentCheckItemStateChanged
        // TODO add your handling code here:
        if(studentCheck.isSelected())
        {
          jLabel3.setVisible(true);
          jLabel4.setVisible(true);
          cmbClass.setVisible(true);
          cmbSection.setVisible(true);
        }
    }//GEN-LAST:event_studentCheckItemStateChanged


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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmbClass;
    private javax.swing.JComboBox cmbMonth;
    private javax.swing.JComboBox cmbSection;
    private javax.swing.JComboBox cmbYear;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private org.jdesktop.swingx.JXTable jTable1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JRadioButton staffCheck;
    private javax.swing.JRadioButton studentCheck;
    // End of variables declaration//GEN-END:variables
   //Connection con;
   PreparedStatement ps;
   ResultSet rs;
}

