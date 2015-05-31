/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SubjectGUI1.java
 *
 * Created on Dec 20, 2009, 3:51:15 PM
 */

package com.duc.SetUpDepartment;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import com.duc.ImportSection.MapForIndex;
import java.util.HashMap;
import javax.swing.JOptionPane;
import static com.duc.DatabaseConnection.DatabaseConnection.*;
/**
 *
 * @author Ravi
 */
public class SubjectGUI1 extends javax.swing.JInternalFrame {
 //MapForIndex mp=new MapForIndex();
   // HashMap classmap=mp.getClassIndexName();
     HashMap classmap1=mp.getClassIndexFromName();
     //HashMap classmap =mp.getClassIndexName();

     //HashMap sectionmap=mp.getSectionIndexName();
     HashMap sectionmap1=mp.getSectionIndexFromName();

     HashMap subjectmap1=mp.getSubjectIndexFromName();
     HashMap subjectmap=mp.getSubjectIndexToName();

        DefaultTableModel dm;
    /** Creates new form SubjectGUI1 */
    public SubjectGUI1() {
        initComponents();
         pack();
        //this.setLocationRelativeTo(null);
        fromAddClass();
        AddSubjects();
        //setLocation(220,200);
        dm = (DefaultTableModel)jTable1.getModel();
        dm.setRowCount(0);
    }
public void addSubject()
{
//con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
try
{
     ps=con.prepareStatement("select * from subjectsetup where classtitle=? and subjecttitle=?");
     ps.setInt(1,Integer.parseInt(String.valueOf(classmap1.get(cmbClass.getSelectedItem().toString()))));
    ps.setInt(2,Integer.parseInt(String.valueOf(subjectmap1.get(cmbSubject.getSelectedItem().toString()))));
 rs=ps.executeQuery();
     if(rs.next())
         JOptionPane.showConfirmDialog(null,"Class-Subject with same name already exists","Class-Subject Exists",JOptionPane.OK_OPTION);

     else
     {
    // ps = con.prepareStatement("insert into inventorysetup (Inventoryunit,InventoryVendor,Inventorymode,class,unitid,Time) values(?,?,?,?,?,?)");
    ps=con.prepareStatement("insert into subjectsetup(classtitle,subjecttitle) values(?,?)");
    ps.setInt(1,Integer.parseInt(String.valueOf(classmap1.get(cmbClass.getSelectedItem().toString()))));
    ps.setInt(2,Integer.parseInt(String.valueOf(subjectmap1.get(cmbSubject.getSelectedItem().toString()))));

         ps.executeUpdate();
//       System.out.println("Done");
        //JOptionPane.showMessageDialog(null,"data stored successfully","report",JOptionPane.PLAIN_MESSAGE);
         //con.close();
         System.out.println("DataBase Conection Closed");
         oldSubject();
         return;
  }
}

catch(Exception e)
{
    e.printStackTrace();
    System.out.println("here");
}
    }

    private void oldSubject()
    {
      //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
       try
       {
           ps = con.prepareStatement("select subjecttitle from subjectsetup where classtitle=?");
           ps.setInt(1,Integer.parseInt(classmap1.get(cmbClass.getSelectedItem()).toString()));
           rs = ps.executeQuery();
          int i = 0,j=0;
          while(rs.next())
            {
                j++;
            }
            rs.first();
            rs.previous();
            dm.setRowCount(j);
            while(rs.next())
            {
                dm.setValueAt(subjectmap.get(rs.getInt(1)), i, 0);
               // dm.setValueAt(rs.getString(2), i, 1);
                i++;
            }
           // con.close();
            System.out.println("Database closed");
       }
       catch(Exception e)
       {
           System.err.println("Error"+e);
       }
    }



    public void removeSubject()
    {
      //  con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        int row = jTable1.getSelectedRow();
        System.out.println("row no. selected"+row);

        try
        {
         ps=con.prepareStatement("delete from subjectsetup where subjecttitle=? and classtitle=?");
         ps.setInt(1,Integer.parseInt(String.valueOf(subjectmap1.get(dm.getValueAt(row, 0).toString()))));
         ps.setInt(2,Integer.parseInt(String.valueOf(classmap1.get(cmbClass.getSelectedItem().toString()))));
         ps.executeUpdate();
         dm.removeRow(row);
       //  con.close();
         System.out.println("DataBase Conection Closed");
         }
        catch(Exception e)
        {
            System.err.println("Error"+e);
        }

    }


public void fromAddClass()
{
    //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
        ps=con.prepareStatement("select * from classsetup");

      rs = ps.executeQuery();
           while (rs.next())
        cmbClass.addItem(rs.getString(1));
}
    catch(SQLException e)
    {
        e.printStackTrace();
    }
}

public void AddSubjects()
{
   // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
        ps=con.prepareStatement("select subjecttitle from subjectlist");
        rs = ps.executeQuery();
        while (rs.next())
        cmbSubject.addItem(rs.getString(1));
       // con.close();
}
    catch(SQLException e)
    {
        e.printStackTrace();
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
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPane4 = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        cmbClass = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        cmbSubject = new javax.swing.JComboBox();

        setClosable(true);
        setForeground(java.awt.Color.white);
        setIconifiable(true);
        setTitle("Class-Subject Setup");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jButton1.setText("Add subject");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Remove Subject");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextPane3.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane3.setEditable(false);
        jTextPane3.setFont(new java.awt.Font("Tahoma", 0, 18));
        jTextPane3.setText("                      Add Subject");
        jScrollPane4.setViewportView(jTextPane3);

        jTextPane4.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane4.setEditable(false);
        jTextPane4.setText("Add Subjects for a particular class.. ");
        jScrollPane5.setViewportView(jTextPane4);

        jLabel1.setText("Subject");

        cmbClass.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        cmbClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClassActionPerformed(evt);
            }
        });

        jLabel2.setText("Class Title");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Subjects"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setText("Subject List");

        cmbSubject.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choose" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbSubject, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbClass, 0, 104, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(27, 27, 27)
                        .addComponent(jButton3)))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(cmbClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cmbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        addSubject();        // TODO add your handling code here:
}//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        removeSubject();        // TODO add your handling code here:
}//GEN-LAST:event_jButton3ActionPerformed

    private void cmbClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClassActionPerformed

        // String s=jComboBox1.getSelectedItem().toString();
        oldSubject();
        // TODO add your handling code here:
}//GEN-LAST:event_cmbClassActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbClass;
    private javax.swing.JComboBox cmbSubject;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextPane jTextPane4;
    // End of variables declaration//GEN-END:variables
ResultSet rs;
PreparedStatement ps;
}
