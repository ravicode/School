/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ClassStrength.java
 *
 * Created on Nov 15, 2009, 10:59:26 PM
 */

package com.duc.StudentDepartment.AddStudent;
import org.jdesktop.swingx.decorator.HighlighterFactory;
import java.sql.*;
import java.text.MessageFormat;
import java.util.HashMap;
import javax.swing.JTable.PrintMode;
import javax.swing.table.DefaultTableModel;
import com.duc.ImportSection.*;
import static com.duc.DatabaseConnection.DatabaseConnection.*;
/**
 *
 * @author Ravi
 */
public class ClassStrength extends javax.swing.JInternalFrame {
DefaultTableModel dm;
//MapForIndex mp=new MapForIndex();
HashMap classmap=new HashMap();
    HashMap sectionmap=new HashMap();

    HashMap classmap1=new HashMap();
    HashMap sectionmap1=new HashMap();
    HashMap category=mp.getCategoryNameFromIndex();

    /** Creates new form ClassStrength */
    public ClassStrength() {
        initComponents();
        pack();
         jTable1.setHighlighters(HighlighterFactory.createAlternateStriping());
        jTable1.setHorizontalScrollEnabled(true);
        dm = (DefaultTableModel) jTable1.getModel();
        dm.setRowCount(0);
         getClassIndexName();
       getSectionIndexName();

        getClassIndexFromName();
       getSectionIndexFromName();
        fromStudententry();
       totalStrength();
    }
 public void getClassIndexName()
    {
        try
        {
           // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select classid,classtitle from classsetup");
            rs=ps.executeQuery();
            while(rs.next())
            {
                classmap.put(rs.getInt(1),rs.getString(2));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }

     public void getSectionIndexName()
    {
         try
        {
              //con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select sectionid,sectiontitle from sectionsetuplist");
            rs=ps.executeQuery();
            while(rs.next())
            {
                sectionmap.put(rs.getInt(1),rs.getString(2));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

     public void getClassIndexFromName()
    {
        try
        {
           // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select classid,classtitle from classsetup");
            rs=ps.executeQuery();
            while(rs.next())
            {
                classmap1.put(rs.getString(2),rs.getInt(1));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }

     public void getSectionIndexFromName()
    {
         try
        {
              //con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select sectionid,sectiontitle from sectionsetuplist");
            rs=ps.executeQuery();
            while(rs.next())
            {
                sectionmap1.put(rs.getString(2),rs.getInt(1));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void fromStudententry()
    {

       
int stdclass=0;
int section=0;
int i=0,l=0,j;
int classboys=0,classgirls=0;
int bc=0,sc=0,st=0,obc=0,ebc=0,others=0,general=0;
 //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

  try
    {

       ps = con.prepareStatement("select * from sectionsetup");

             rs = ps.executeQuery();


            while (rs.next())
                l++;
             dm.setRowCount(l);

System.out.println("111111111112222222");

         ps = con.prepareStatement("select * from classsetup order by classid");

             rs = ps.executeQuery();


            while (rs.next())
            {
        stdclass=rs.getInt(2);
System.out.println("1111111111133333333");
 ps = con.prepareStatement("select * from sectionsetup where classtitle=?");
ps.setInt(1,stdclass);
             rs1 = ps.executeQuery();


            while (rs1.next())
            {
classboys=0;
classgirls=0;
sc=0;
st=0;
obc=0;
ebc=0;
others=0;
general=0;
bc=0;
System.out.println("1111111111144444444");
 section=rs1.getInt(2);
         j=0;
 ps = con.prepareStatement("select * from studententry where class=? and section=? and status!=0");
ps.setInt(1,stdclass);
ps.setInt(2,section);
             rs2 = ps.executeQuery();
System.out.println("1111111111155555555");


            while (rs2.next())
            {

        j++;
        ps=con.prepareStatement("select sex from studententry where sex IS NULL and id=?");
        ps.setString(1,rs2.getString(1));
        rs4=ps.executeQuery();
       // ps.setString(1,rs2.getString(1));
      if(!rs4.next())
        {
        if(rs2.getString(7).equals("M"))
classboys++;
         if(rs2.getString(7).equals("F"))
classgirls++;
        }

        ps=con.prepareStatement("select category from studentdetail where id=?");
        ps.setString(1,rs2.getString(1));
        rs5=ps.executeQuery();
       // ps.setString(1,rs2.getString(1));
      if(rs5.next())
        {
          if(!rs5.getString(1).equals("General"))
          {
        if(category.get(rs5.getString(1)).equals("OBC"))
obc++;
           if(category.get(rs5.getString(1)).equals("BC"))
bc++;
        if(category.get(rs5.getString(1)).equals("EBC"))
ebc++;
         if(category.get(rs5.getString(1)).equals("SC"))
sc++;
         if(category.get(rs5.getString(1)).equals("ST"))
st++;
         if(category.get(rs5.getString(1)).equals("Others"))
others++;
          } else general++;

        }else general++;
            }
             
             dm.setValueAt(classmap.get(stdclass),i, 0);
             dm.setValueAt(sectionmap.get(section),i, 1);
              dm.setValueAt(j,i, 2);
              dm.setValueAt(classboys,i, 3);
               dm.setValueAt(classgirls,i, 4);

               dm.setValueAt(sc,i, 5);
               dm.setValueAt(st,i, 6);
               dm.setValueAt(obc,i, 7);
               dm.setValueAt(bc,i, 8);
               dm.setValueAt(ebc,i, 9);
               dm.setValueAt(others,i,10);
               dm.setValueAt(general,i,11);
              System.out.println("111111111115666666665555555");
         i++;
            }
           // }


            }

System.out.println("111111111115666666665555555777777777");

    }
    catch(Exception e)
    {
        System.err.println("Error is"+e);
    }

    }

    public void totalStrength()
    {
        int total=0;
        int totalgirl=0,totalboys=0;
        for(int i=0;i<dm.getRowCount();i++)
        {
            total+=Integer.parseInt(dm.getValueAt(i,2).toString());
            totalgirl+=Integer.parseInt(dm.getValueAt(i,4).toString());
            totalboys+=Integer.parseInt(dm.getValueAt(i,3).toString());
        }
        totalstrength.setText(String.valueOf(total));

        int rowcount=dm.getRowCount();
     System.out.println("row"+rowcount);
    dm.setRowCount(rowcount+1);

   dm.setValueAt("Total", rowcount, 0);
    dm.setValueAt(totalstrength.getText(), rowcount, 2);
     dm.setValueAt(totalboys, rowcount, 3);
      dm.setValueAt(totalgirl, rowcount, 4);
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
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new org.jdesktop.swingx.JXTable();
        jLabel1 = new javax.swing.JLabel();
        totalstrength = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Class Strength List");

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jTextPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 0, 18));
        jTextPane1.setText("                                           Class Strength List");
        jScrollPane1.setViewportView(jTextPane1);

        jTextPane2.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane2.setEditable(false);
        jTextPane2.setText("Total no. of students present in a particular section of a class...");
        jScrollPane2.setViewportView(jTextPane2);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Class", "Section", "Strength", "Boy Students", "Girl Students", "SC", "ST", "OBC", "BC", "EBC", "Others", "General"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnControlVisible(true);
        jScrollPane3.setViewportView(jTable1);

        jLabel1.setText("Total strength");

        totalstrength.setText("jLabel2");

        jButton1.setText("Print");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127)
                        .addComponent(totalstrength, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalstrength)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try
       {
           String s="Class Strength List";
        MessageFormat header=new MessageFormat(s);
        jTable1.print(PrintMode.FIT_WIDTH, header, null);
       }catch(Exception e)
       {
           e.printStackTrace();
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private org.jdesktop.swingx.JXTable jTable1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JLabel totalstrength;
    // End of variables declaration//GEN-END:variables
ResultSet rs,rs1,rs2,rs4,rs5;
//Connection con;
PreparedStatement ps;
}
