/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * WriteDown.java
 *
 * Created on Sep 18, 2009, 7:40:02 PM
 */

package com.duc.StudentDepartment.Awards;
import com.duc.ImportSection.MapForIndex;
import java.sql.*;
import java.util.HashMap;
import static com.duc.DatabaseConnection.DatabaseConnection.*;
/**
 *
 * @author Ravi Dangaich
 */
public class AwardsEntry extends javax.swing.JInternalFrame {
//DateFormat df;

//MapForIndex mp=new MapForIndex();
         HashMap classmap=mp.getClassIndexName();
         HashMap sectionmap=mp.getSectionIndexName();

         HashMap classmap1=mp.getClassIndexFromName();
         HashMap sectionmap1=mp.getSectionIndexFromName();

    /** Creates new form WriteDown */
    public AwardsEntry() {
        initComponents();
        
        fromClass();
        fromAwardCategory();
        //df=new SimpleDateFormat("yyyy-MM-dd");
         dateofevent.setDateFormat(df);
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
        classcombo.addItem(rs.getString(1));


            }

 // con.close();
         }
    catch(Exception e)
    {
        System.err.println("Error is"+e);
    }
}

public void fromAwardCategory()
{
     try
    {

 //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


         ps = con.prepareStatement("select * from awardcategorysetup");

             rs = ps.executeQuery();


            while (rs.next())
            {
        categorycombo.addItem(rs.getString(1));


            }

 // con.close();
         }
    catch(Exception e)
    {
        System.err.println("Error is"+e);
    }
}

 public void admissionNoFilter()
    {
         //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        try
        {
            ps = con.prepareStatement("select * from studententry where class=?");
            ps.setInt(1, Integer.parseInt(classmap1.get(classcombo.getSelectedItem().toString()).toString()));
             rs = ps.executeQuery();

admissionno.removeAllItems();

            while(rs.next())
            {

                admissionno.addItem(rs.getString(1));

            }

//con.close();

        }  catch(Exception e)
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        categorycombo = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        positioncombo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        detailtext = new javax.swing.JTextArea();
        dateofevent = new datechooser.beans.DateChooserCombo();
        jLabel6 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        classcombo = new javax.swing.JComboBox();
        admissionno = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        awardtext = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        levelcombo = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Awards Creator");

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jTextPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 0, 18));
        jTextPane1.setText("                                                   Enter Your Awards");
        jScrollPane1.setViewportView(jTextPane1);

        jTextPane2.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane2.setEditable(false);
        jTextPane2.setText("It will help you to count the number of prizes won by your students.");
        jScrollPane2.setViewportView(jTextPane2);

        categorycombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));

        jLabel3.setText("Award Category");

        jLabel4.setText("Position");

        positioncombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose", "1st", "2nd", "3rd" }));

        jLabel5.setText("Award Detail");

        detailtext.setColumns(20);
        detailtext.setRows(5);
        jScrollPane3.setViewportView(detailtext);

        jLabel6.setText("Date");

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Class");

        classcombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        classcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classcomboActionPerformed(evt);
            }
        });

        admissionno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));

        jLabel8.setText("Admission No.");

        jLabel9.setText("Prize/award");

        jLabel10.setText("Level");

        levelcombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose", "School Level", "InterSchool", "Social", "Others" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 932, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateofevent, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(701, 701, 701))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(levelcombo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(positioncombo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(categorycombo, javax.swing.GroupLayout.Alignment.LEADING, 0, 125, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(admissionno, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(classcombo, javax.swing.GroupLayout.Alignment.LEADING, 0, 126, Short.MAX_VALUE))
                            .addComponent(awardtext, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(147, 147, 147)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(326, 326, 326))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 932, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admissionno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categorycombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(positioncombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(levelcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(awardtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(saveButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(closeButton)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(dateofevent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(107, 107, 107)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
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

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
this.dispose();        // TODO add your handling code here:
}//GEN-LAST:event_closeButtonActionPerformed

    private void classcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classcomboActionPerformed
        admissionNoFilter();        // TODO add your handling code here:
}//GEN-LAST:event_classcomboActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        saveAwardsEntry();
}//GEN-LAST:event_saveButtonActionPerformed

public void saveAwardsEntry()
{
   // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
   rs = ps.executeQuery();
        ps=con.prepareStatement("insert into awardsentry values(?,?,?,?,?,?,?,?)");
        ps.setString(1,admissionno.getSelectedItem().toString());
        //ps.setString(2,classcombo.getSelectedItem().toString());
        ps.setString(2,categorycombo.getSelectedItem().toString());
        ps.setString(3,positioncombo.getSelectedItem().toString());
        ps.setString(4,levelcombo.getSelectedItem().toString());
        ps.setString(5,awardtext.getText());
        ps.setString(6,detailtext.getText());
        ps.setString(7,dateofevent.getText());
        ps.setString(8,datum);

ps.executeUpdate();

    }catch(Exception e)
    {
e.printStackTrace();
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox admissionno;
    private javax.swing.JTextField awardtext;
    private javax.swing.JComboBox categorycombo;
    private javax.swing.JComboBox classcombo;
    private javax.swing.JButton closeButton;
    private datechooser.beans.DateChooserCombo dateofevent;
    private javax.swing.JTextArea detailtext;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JComboBox levelcombo;
    private javax.swing.JComboBox positioncombo;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
//Connection con;
ResultSet rs;
 PreparedStatement ps;
}
