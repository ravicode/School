/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AppendToAdmissionNo.java
 *
 * Created on Jan 8, 2010, 3:23:09 PM
 */

package com.duc.SetUpDepartment;

import java.sql.*;
import com.duc.ImportSection.*;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static com.duc.DatabaseConnection.DatabaseConnection.*;

/**
 *
 * @author Ravi
 */
public class AppendToAdmissionNo extends javax.swing.JInternalFrame {
DefaultTableModel dm,dm1;
  //  MapForIndex mp=new MapForIndex();
HashMap classmap=mp.getClassIndexName();
 HashMap classmap1=mp.getClassIndexFromName();
 HashMap sectionmap=mp.getSectionIndexName();
 HashMap sectionmap1=mp.getSectionIndexFromName();
    /** Creates new form AppendToAdmissionNo */
    public AppendToAdmissionNo() {
        initComponents();
         fromClass();
         fromSeriesId();
    
      dm = (DefaultTableModel) formatTable.getModel();
        dm.setRowCount(0);

        dm1 = (DefaultTableModel) formatTable1.getModel();
        dm1.setRowCount(0);

         loadTable();
         loadTableClassSeries();
    }

 public void fromClass()
    {
         try
    {

 //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


         ps = con.prepareStatement("select * from classsetup");

             rs = ps.executeQuery();


            while (rs.next())
            {
        classCombo.addItem(rs.getString(1));


            }



    }
    catch(Exception e)
    {
        System.err.println("Error is"+e);
    }

    }


  public void fromSeriesId()
    {
         try
    {

 //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


         ps = con.prepareStatement("select * from appendstring");

             rs = ps.executeQuery();


            while (rs.next())
            {
        seriesCombo.addItem(rs.getInt(1));


            }



    }
    catch(Exception e)
    {
        System.err.println("Error is"+e);
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
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pre = new javax.swing.JTextField();
        post = new javax.swing.JTextField();
        classCombo = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jScrollPane15 = new javax.swing.JScrollPane();
        formatTable = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        integer1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        seriesCombo = new javax.swing.JComboBox();
        jScrollPane16 = new javax.swing.JScrollPane();
        formatTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        jMenuItem1.setText("Remove Series");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Remove Class");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItem2);

        setClosable(true);
        setIconifiable(true);
        setTitle("Adm. No. Formatter");

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jTextPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jTextPane1.setText("                        Admission No Formatter");
        jScrollPane1.setViewportView(jTextPane1);

        jTextPane2.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane2.setEditable(false);
        jTextPane2.setText("Append strings at pre and post position of your Institute Admission Nos..");
        jScrollPane2.setViewportView(jTextPane2);

        jLabel1.setText("Class");

        jLabel3.setText("Pre-String");

        jLabel4.setText("Post-String");

        classCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        classCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classComboActionPerformed(evt);
            }
        });

        jButton1.setText("Make Series");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        formatTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Series Id", "Pre-String", "Post-String", "Last Integer"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        formatTable.setComponentPopupMenu(jPopupMenu1);
        formatTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formatTableMouseClicked(evt);
            }
        });
        formatTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formatTableKeyTyped(evt);
            }
        });
        jScrollPane15.setViewportView(formatTable);

        jButton4.setText("Remove");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel5.setText("Last Integer");

        integer1.setText("0");

        jLabel2.setText("Series Id");

        seriesCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        seriesCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seriesComboActionPerformed(evt);
            }
        });

        formatTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Class", "Series Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        formatTable1.setComponentPopupMenu(jPopupMenu2);
        formatTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formatTable1MouseClicked(evt);
            }
        });
        formatTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formatTable1KeyTyped(evt);
            }
        });
        jScrollPane16.setViewportView(formatTable1);

        jButton2.setText("Add To Series");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pre))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(post, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(integer1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(243, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(classCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(seriesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(33, 33, 33)
                        .addComponent(jButton4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(pre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(post, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(integer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(classCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(seriesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void classComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classComboActionPerformed
      
}//GEN-LAST:event_classComboActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       makeSeries();
        //appendToAdmissionNo();
        loadTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formatTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formatTableMouseClicked

}//GEN-LAST:event_formatTableMouseClicked

    private void formatTableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formatTableKeyTyped
        // TODO add your handling code here:
}//GEN-LAST:event_formatTableKeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       // removeAppend();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void seriesComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seriesComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seriesComboActionPerformed

    private void formatTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formatTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formatTable1MouseClicked

    private void formatTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formatTable1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_formatTable1KeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       addClassToSeries();
       loadTableClassSeries();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       removeAppend();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
removeClass();        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public void addClassToSeries()
    {
        try
        {

         ps=con.prepareStatement("select * from autoassignclass where classid=?");
            ps.setInt(1, Integer.parseInt(classmap1.get(classCombo.getSelectedItem()).toString()));
           rs=ps.executeQuery();
           if(!rs.next())
           {

            ps=con.prepareStatement("insert into autoassignclass values(?,?)");
             ps.setInt(1, Integer.parseInt(classmap1.get(classCombo.getSelectedItem()).toString()));
             ps.setInt(2, Integer.parseInt(seriesCombo.getSelectedItem().toString()));
             ps.executeUpdate();
           }
           else
               JOptionPane.showConfirmDialog(null,"Class is already assigned in Series Id"+rs.getInt(2),"Format set",JOptionPane.PLAIN_MESSAGE);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


    }

    public void removeAppend()
    {
        int currentrow=0;
        currentrow=formatTable.getSelectedRow();
        try
        {
            ps=con.prepareStatement("select * from autoassignclass where seriesid=?");
            ps.setInt(1, Integer.parseInt(dm.getValueAt(currentrow,0).toString()));
            rs=ps.executeQuery();
            if(rs.next())
                JOptionPane.showConfirmDialog(null," Classes are assigned for this Series, So cannot be deleted","Series Delete",JOptionPane.OK_OPTION);

            else
            {
                ps=con.prepareStatement("delete from appendstring where id=?");

             ps.setInt(1, Integer.parseInt(dm.getValueAt(currentrow,0).toString()));
       ps.executeUpdate();
       loadTable();
            }
 
        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }
    
     public void removeClass()
    {
        int currentrow=0;
        currentrow=formatTable1.getSelectedRow();
        try
        {

                int i=JOptionPane.showConfirmDialog(null," Do you want to delete the class-series set","Class Delete",JOptionPane.OK_OPTION);

            if(i==JOptionPane.OK_OPTION)
            {
                ps=con.prepareStatement("delete from autoassignclass where classid=?");
            ps.setInt(1,Integer.parseInt(classmap1.get(dm1.getValueAt(currentrow,0)).toString()));

       ps.executeUpdate();
       loadTableClassSeries();
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }
public void showValues()
{
    try
    {
         ps=con.prepareStatement("select * from appendstring where class=?");
          ps.setInt(1, Integer.parseInt(classmap1.get(classCombo.getSelectedItem()).toString()));
           
            rs=ps.executeQuery();
            if(rs.next())
            {
                pre.setText(rs.getString(2));
                post.setText(rs.getString(3));
            }
            else
            {
                pre.setText("");
                post.setText("");
            }
    }catch(Exception e)
    {
        e.printStackTrace();
    }

}
    public void loadTable()
    {
        int i=0,j=0;
        try
        {
            ps=con.prepareStatement("select * from appendstring");
            rs=ps.executeQuery();
            while(rs.next())
                j++;
            dm.setRowCount(j);
            rs.first();
            rs.previous();
            while(rs.next())
            {
               // dm.setValueAt(classmap.get(rs.getInt(1)),i,0);
               dm.setValueAt(rs.getInt(1),i,0);
                dm.setValueAt(rs.getString(2),i,1);
                 dm.setValueAt(rs.getString(3),i,2);
                 dm.setValueAt(rs.getInt(4),i,3);
                 i++;
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    public void loadTableClassSeries()
    {
        int i=0,j=0;
        try
        {
            ps=con.prepareStatement("select * from autoassignclass");
            rs=ps.executeQuery();
            while(rs.next())
                j++;
            dm1.setRowCount(j);
            rs.first();
            rs.previous();
            while(rs.next())
            {
               // dm.setValueAt(classmap.get(rs.getInt(1)),i,0);
               dm1.setValueAt(classmap.get(rs.getInt(1)),i,0);

                 dm1.setValueAt(rs.getInt(2),i,1);
                 i++;
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void makeSeries()
    {
        int i=0;
        try
        {
             ps=con.prepareStatement("select * from appendstring where pre=? and post=?");
            //ps.setInt(1, Integer.parseInt(classmap1.get(classCombo.getSelectedItem()).toString()));
              ps.setString(1,pre.getText());
             ps.setString(2,post.getText());
           rs=ps.executeQuery();
           if(!rs.next())
           {
                if(pre.getText().isEmpty())
            pre.setText(" ");
                if(post.getText().isEmpty())
            post.setText(" ");

                 ps=con.prepareStatement("insert into appendstring(pre,post,admno) values(?,?,?)");
            ps.setString(1,pre.getText());
             ps.setString(2,post.getText());
              ps.setInt(3, Integer.parseInt(integer1.getText()));
             ps.executeUpdate();
           }
           else
               i=JOptionPane.showConfirmDialog(null,"This Series Format Set is already set","Format set",JOptionPane.PLAIN_MESSAGE);
           if(i==JOptionPane.OK_OPTION)
           {
                pre.setText("");
                 post.setText("");
           }



        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void appendToAdmissionNo()
    {
int i=0;
        try
        {
            ps=con.prepareStatement("select * from appendstring where class=?");
            ps.setInt(1, Integer.parseInt(classmap1.get(classCombo.getSelectedItem()).toString()));
           rs=ps.executeQuery();
           if(!rs.next())
           {
                if(pre.getText().isEmpty())
            pre.setText(" ");

        if(post.getText().isEmpty())
            post.setText(" ");
            ps=con.prepareStatement("insert into appendstring values(?,?,?)");
             ps.setInt(1, Integer.parseInt(classmap1.get(classCombo.getSelectedItem()).toString()));
           
            ps.setString(2,pre.getText());
             ps.setString(3,post.getText());
             ps.executeUpdate();
           }
           else
               i=JOptionPane.showConfirmDialog(null,"Format for this class is already set","Format set",JOptionPane.PLAIN_MESSAGE);
           if(i==JOptionPane.OK_OPTION)
           {
                pre.setText("");
                 post.setText("");
           }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
                
                
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox classCombo;
    private javax.swing.JTable formatTable;
    private javax.swing.JTable formatTable1;
    private javax.swing.JTextField integer1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextField post;
    private javax.swing.JTextField pre;
    private javax.swing.JComboBox seriesCombo;
    // End of variables declaration//GEN-END:variables
ResultSet rs;
PreparedStatement ps;
}