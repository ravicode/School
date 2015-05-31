/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * StudentExamReport.java
 *
 * Created on Dec 20, 2009, 12:31:01 AM
 */

package com.duc.ExaminationDepartment.ResultSection;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.duc.DatabaseConnection.DatabaseConnection;
import com.duc.ImportSection.MapForIndex;
//import java.util.ArrayList;
//import java.util.Vector;
//import net.sf.jasperreports.view.JasperViewer;
//import net.sf.jasperreports.engine.*;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import javax.imageio.ImageIO;
//import java.util.HashMap;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import java.util.*;
import java.text.*;
import javax.swing.JTable.PrintMode;
import java.util.ArrayList;
import static com.duc.DatabaseConnection.DatabaseConnection.*;


/**
 *
 * @author sourabh
 */
public class SubjectWiseReport extends javax.swing.JInternalFrame
{
      ArrayList<Integer> subjectcodes=new ArrayList<Integer>();
     // Connection con=DatabaseConnection.con;
     // MapForIndex mp= new MapForIndex();
      HashMap classmap1= mp.getClassIndexFromName();
      HashMap sectiomap1=mp.getSectionIndexFromName();
      HashMap subjectmap1=mp.getSubjectIndexFromName();
      HashMap sessionmap1=mp.getSessionIndexFromName();
      ArrayList<String> admnumbers= new ArrayList<String>();
      ArrayList<String> tempadnumbers=new ArrayList<String>();
      int sessionValue=0;
    /** Creates new form StudentExamReport */
    public SubjectWiseReport()
    {
        initComponents();
        addClass();             
        addSession();
        fromSession();
        dm = (DefaultTableModel)jXTable1.getModel();
        dm.setRowCount(1);    
    
    }

           public void fromSession()
    {
         try
       {
           ps = con.prepareStatement("select sessiontitle,sessionid,status from sessionsetup ");
           rs = ps.executeQuery();
           while(rs.next())
            {
              if(rs.getInt(3)==1)
              sessionValue=rs.getInt(2);
            }
         }
          catch(Exception e)
          {
             e.printStackTrace();
          }
    }


    public void setMaxMarks()
    {
        try
       {
         ps=con.prepareStatement("Select exam_max_marks from examsetup order by examid");
         rs=ps.executeQuery();
         for(int i=5; i<=10;i++)
         {
         rs.next();
         dm.setValueAt(rs.getInt(1), 0, i);
         }
       }
        catch(Exception e)
        {
         e.printStackTrace();
        }
    }

    public void addClass()
{
        try
        {
        ps = con.prepareStatement("select * from classsetup");
        rs = ps.executeQuery();
        while (rs.next())
        cmbClass.addItem(rs.getString(1));
       }
        catch(Exception e)
        {
          System.err.println("Error "+e);
        }
}

   public void addSection()
 {
     try
      {
        ps = con.prepareStatement("SELECT `sectionsetuplist`.`sectiontitle` from `sectionsetuplist`,`sectionsetup` where sectionid=`sectionsetup`.`sectiontitle` and classtitle=?");
        ps.setInt(1, Integer.parseInt(String.valueOf(classmap1.get(cmbClass.getSelectedItem().toString()))));
        rs = ps.executeQuery();
        cmbSection.removeAllItems();
        cmbSection.addItem("Select");
        while (rs.next())
         {
          cmbSection.addItem(rs.getString(1));
         }
       }
        catch(Exception e)
        {
          System.err.println("Error "+e);
        }
 }


   public void addSession()
    {
        try
        {
         ps=con.prepareStatement("select sessiontitle from sessionsetup order by sessionid desc");
         rs=ps.executeQuery();
         while(rs.next())
         cmbSession.addItem(rs.getString(1));
        }
        catch(Exception e)
        {
         System.err.println("Error "+e);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jXTable1 = new org.jdesktop.swingx.JXTable();
        jLabel2 = new javax.swing.JLabel();
        cmbClass = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cmbSection = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cmbSession = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        checku2 = new javax.swing.JCheckBox();
        checku3 = new javax.swing.JCheckBox();
        checku4 = new javax.swing.JCheckBox();
        checkt1 = new javax.swing.JCheckBox();
        checkt2 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        cmbSubject = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        NameButton = new javax.swing.JRadioButton();
        MarksButton = new javax.swing.JRadioButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Class & Subject Wise  Result Report / General Pattern");

        jTextPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jTextPane1.setText("                                                                          View Class & Subject Wise Result");
        jScrollPane1.setViewportView(jTextPane1);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jButton1.setText("Show Result");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jXTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Adm. No.", "Roll No.", "Name", "Father's Name", "DOB", "U1", "U2", "T1", "U3", "U4", "T2", "F1=U1+U2+T1", "F2=U3+U4+T2", "F=F1+F2"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jXTable1.setColumnControlVisible(true);
        jXTable1.setFont(new java.awt.Font("Tahoma", 0, 12));
        jXTable1.setHorizontalScrollEnabled(true);
        jXTable1.setSortable(false);
        jScrollPane2.setViewportView(jXTable1);

        jLabel2.setText("Class");

        cmbClass.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        cmbClass.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbClassItemStateChanged(evt);
            }
        });

        jLabel3.setText("Section");

        cmbSection.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        cmbSection.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSectionItemStateChanged(evt);
            }
        });

        jLabel5.setText("Session");

        cmbSession.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));

        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel10.setText("Exclude This Exam");

        checku2.setText("U2");
        checku2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checku2ItemStateChanged(evt);
            }
        });

        checku3.setText("U3");
        checku3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checku3ItemStateChanged(evt);
            }
        });

        checku4.setText("U4");
        checku4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checku4ItemStateChanged(evt);
            }
        });

        checkt1.setText("T1");
        checkt1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkt1ItemStateChanged(evt);
            }
        });

        checkt2.setText("T2");
        checkt2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkt2ItemStateChanged(evt);
            }
        });
        checkt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkt2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Subject");

        cmbSubject.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));

        jButton3.setText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(NameButton);
        NameButton.setText("Name");

        buttonGroup1.add(MarksButton);
        MarksButton.setText("Marks");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbSubject, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbClass, 0, 95, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checku2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbSection, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(cmbSession, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(checkt1)
                        .addGap(18, 18, 18)
                        .addComponent(checku3)
                        .addGap(17, 17, 17)
                        .addComponent(checku4)
                        .addGap(18, 18, 18)
                        .addComponent(checkt2)))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(NameButton)
                        .addGap(10, 10, 10)
                        .addComponent(MarksButton)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 865, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(cmbSection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cmbSession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(checku2)
                    .addComponent(checkt1)
                    .addComponent(checku3)
                    .addComponent(checku4)
                    .addComponent(checkt2)
                    .addComponent(NameButton)
                    .addComponent(MarksButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 897, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dm.setRowCount(0);
        
        boolean c=checkForSaving();
        
        if(c==true)
      {
          loadBasicData();
          loadResultData();
          loadRowSum();
          checkExamNotIncluded();
          if(checku2.isSelected() || checkt1.isSelected() || checku3.isSelected() || checku4.isSelected() || checkt2.isSelected() )
          {
           int column=0;           
           column=13;
           setColumn(column);           
           return;
          }          
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void checkExamNotIncluded()
    {
      int column=0;

      if(checku2.isSelected())
      {
      column=6;
      setColumn(column);
      }

      if(checku3.isSelected())
      {
       column=8;
       setColumn(column);
      }

      if(checku4.isSelected())
      {
       column=9;
       setColumn(column);
      }

      if(checkt1.isSelected())
      {
        column=7;
        setColumn(column);
      }

      if(checkt2.isSelected())
      {
        column=10;
        setColumn(column);
      }

      if(checku2.isSelected() || checkt1.isSelected())
      {
       column=11;
       setColumn(column);
      }

      if(checku3.isSelected() ||  checku4.isSelected() || checkt2.isSelected())
      {
       column=12;
       setColumn(column);
      }     
   }

    public void setColumn(int column)
    {
        for(int i=0; i<dm.getRowCount();i++)
        {
        dm.setValueAt("-", i, column);
        }
    }

      public boolean checkForSaving()
    {
       if(cmbClass.getSelectedIndex()<=0)
       {
       JOptionPane.showMessageDialog(null, "Select Class First", "Error Message", JOptionPane.ERROR_MESSAGE);
       return false;
       }

       if(cmbSection.getSelectedIndex()<=0)
       {
       JOptionPane.showMessageDialog(null, "Select Section First", "Error Message", JOptionPane.ERROR_MESSAGE);
       return false;
       }

       if(cmbSubject.getSelectedIndex()<=0)
       {
       JOptionPane.showMessageDialog(null, "Select Subject First", "Error Message", JOptionPane.ERROR_MESSAGE);
       return false;
       }
           
       return true;
    }  
     
    public void loadRowSum()
    {
      int t1=0,t2=0,u1=0,u2=0,u3=0,u4=0,f1=0,f2=0,f=0;
      DecimalFormat format1=new DecimalFormat("###.##");
      
      try
      {  
        for(int row=0; row<dm.getRowCount();row++)
       {
         t1=0;t2=0;u1=0;u2=0;u3=0;u4=0;f1=0;f2=0;f=0;

         if(!dm.getValueAt(row,5).toString().equals("Ab."))
         u1=Integer.parseInt(dm.getValueAt(row, 5).toString());

         if(!dm.getValueAt(row,6).toString().equals("Ab."))
         u2=Integer.parseInt(dm.getValueAt(row, 6).toString());

         if(!dm.getValueAt(row,7).toString().equals("Ab."))
         t1=Integer.parseInt(dm.getValueAt(row, 7).toString());

         if(!dm.getValueAt(row,8).toString().equals("Ab."))
         u3=Integer.parseInt(dm.getValueAt(row,8).toString());

         if(!dm.getValueAt(row,9).toString().equals("Ab."))
         u4=Integer.parseInt(dm.getValueAt(row, 9).toString());

         if(!dm.getValueAt(row,10).toString().equals("Ab."))
         t2=Integer.parseInt(dm.getValueAt(row, 10).toString());

         f1=u1+u2+t1;
         f2=u3+u4+t2;
         f=f1+f2;
         
         dm.setValueAt(f1, row, 11);
         dm.setValueAt(f2, row, 12);
         dm.setValueAt(f1+f2,row,13);
       }
      }
      catch(Exception e)
      {
       System.err.println("Error in setting row sums "+ e);
       e.printStackTrace();
      }
    }
    
    
    public void loadResultData()
    {
      try
   {
      int exam_status=1;
      ps=con.prepareStatement("select examname,studentid,examstatus,marks from `examtemplate`,`studentmarksentry` where id=examtemplateid and  class=? and section=? and  subject=? and sessionid=? order by studentid, examname");
      ps.setInt(1, Integer.parseInt(String.valueOf(classmap1.get(cmbClass.getSelectedItem().toString()))));
      ps.setInt(2, Integer.parseInt(String.valueOf(sectiomap1.get(cmbSection.getSelectedItem().toString()))));
      ps.setInt(3, Integer.parseInt(String.valueOf(subjectmap1.get(cmbSubject.getSelectedItem().toString()))));
      ps.setInt(4,sessionValue);
      System.out.println(sessionValue);
      rs=ps.executeQuery();
      int row=0,column=0;
      tempadnumbers.clear();

      while(rs.next())
     {
       if(!tempadnumbers.contains(rs.getString(2)))
       {
        tempadnumbers.add(rs.getString(2));
        row=admnumbers.indexOf(rs.getString(2))+1;
        System.out.println("Row: "+row+" Index: "+admnumbers.indexOf(rs.getString(2)));
        column=5;
       }
       if(rs.getInt(3)==1)
       {
        dm.setValueAt(rs.getString(4), row, column);
       }
       else
       {
        dm.setValueAt("Ab.", row, column);
       }
       System.out.println("Column: "+column);
       column++;
     }
   }
      catch(Exception e)
      {
         e.printStackTrace();
      }
    }

    private void cmbClassItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbClassItemStateChanged
        // TODO add your handling code here:
        if(cmbClass.getSelectedIndex()>0)
        {
            loadSubjects();
            addSection();
        }
    }//GEN-LAST:event_cmbClassItemStateChanged

      public void loadSubjects()
    {
        try
        {
        ps=con.prepareStatement("select `subjectlist`.`subjecttitle` from `subjectsetup`,`subjectlist` where classtitle=? and `subjectlist`.`subjectid`=`subjectsetup`.`subjecttitle`and applicable_for_result=1");
        ps.setInt(1, Integer.parseInt(String.valueOf(classmap1.get(cmbClass.getSelectedItem().toString()))));
        rs=ps.executeQuery();


        cmbSubject.removeAllItems();
        cmbSubject.addItem("Select");

         while(rs.next())
         {
         cmbSubject.addItem(rs.getString(1));
         }
        }
        catch(Exception e)
        {
         e.printStackTrace();
        }
    }

    private void cmbSectionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSectionItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmbSectionItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         try
        {
        String s=" ",t="";
        if(MarksButton.isSelected())
        s="Achievement in subject: "+cmbSubject.getSelectedItem().toString();
        else if(NameButton.isSelected())
        s="Result Statement: Class-"+cmbClass.getSelectedItem().toString()+" ,Sec.-"+cmbSection.getSelectedItem().toString();
        if(NameButton.isSelected())
        t="Session: "+cmbSession.getSelectedItem().toString();
        MessageFormat header=new MessageFormat(s);
        MessageFormat footer=new MessageFormat(t);
        jXTable1.print(PrintMode.FIT_WIDTH, header, footer);
        }
        catch(Exception e)
        {
         System.err.println("Error in printing timetable");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void checkt1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkt1ItemStateChanged
        // TODO add your handling code here:
        if(checkt1.isSelected())
        {
         checku4.setSelected(true);
         checkt2.setSelected(true);
         checku3.setSelected(true);         
        }
    }//GEN-LAST:event_checkt1ItemStateChanged

    private void checku3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checku3ItemStateChanged
        // TODO add your handling code here:
        if(checku3.isSelected())
        {
        checku4.setSelected(true);
        checkt2.setSelected(true);
        }
    }//GEN-LAST:event_checku3ItemStateChanged

    private void checku4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checku4ItemStateChanged
        // TODO add your handling code here:
        if(checku4.isSelected())
        {         
         checkt2.setSelected(true);
        }
    }//GEN-LAST:event_checku4ItemStateChanged

    private void checkt2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkt2ItemStateChanged
        // TODO add your handling code here:
        if(checkt2.isSelected())
        {
            
        }
    }//GEN-LAST:event_checkt2ItemStateChanged

    private void checkt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkt2ActionPerformed

    private void checku2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checku2ItemStateChanged
        // TODO add your handling code here:
         if(checku2.isSelected())
        {
         checkt2.setSelected(true);
         checkt1.setSelected(true);
         checku3.setSelected(true);
         checku4.setSelected(true);
        }
    }//GEN-LAST:event_checku2ItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        super.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed
   
 public void loadBasicData()
 {
  try
 {
 ps=con.prepareStatement("select id,roll,name,fathername,date_format(dob,'%d-%m-%Y') from studententry where class=? and section=? order by id");
 ps.setInt(1,Integer.parseInt(String.valueOf(classmap1.get(cmbClass.getSelectedItem().toString()))));
 ps.setInt(2,Integer.parseInt(String.valueOf(sectiomap1.get(cmbSection.getSelectedItem().toString()))));

 rs=ps.executeQuery();
 int i=0;
 while(rs.next())
 i++;

 rs.first();
 rs.previous();
 dm.setRowCount(i+1); 
 admnumbers.clear();
 i=1;
 while(rs.next())
 {
  dm.setValueAt(rs.getString(1), i, 0) ;
  dm.setValueAt(rs.getInt(2), i, 1) ;
  dm.setValueAt(rs.getString(3), i,2) ;
  dm.setValueAt(rs.getString(4), i, 3) ;
  dm.setValueAt(rs.getString(5), i, 4) ;
  admnumbers.add(rs.getString(1));
  i++;
 }
   for(int r=1;r<dm.getRowCount();r++)
   {
      for(int c=5;c<dm.getColumnCount();c++)
      {
       dm.setValueAt("0", r, c);
      }
   }
 setMaxMarks();
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton MarksButton;
    private javax.swing.JRadioButton NameButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox checkt1;
    private javax.swing.JCheckBox checkt2;
    private javax.swing.JCheckBox checku2;
    private javax.swing.JCheckBox checku3;
    private javax.swing.JCheckBox checku4;
    private javax.swing.JComboBox cmbClass;
    private javax.swing.JComboBox cmbSection;
    private javax.swing.JComboBox cmbSession;
    private javax.swing.JComboBox cmbSubject;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private org.jdesktop.swingx.JXTable jXTable1;
    // End of variables declaration//GEN-END:variables
public  PreparedStatement ps,p;
public  ResultSet rs;
DefaultTableModel dm, dm1;
int min_pass_per=0;
}