/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * WriteDown.java
 *
 * Created on Sep 18, 2009, 7:40:02 PM
 */

package com.duc.SpecialDepartment.MoreSection.Library;
import java.sql.*;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import static com.duc.DatabaseConnection.DatabaseConnection.*;


/**
 *
 * @author Ravi Dangaich
 */
public class ISBNEntry extends javax.swing.JInternalFrame
{

    /** Creates new form WriteDown */
    public ISBNEntry() {
        initComponents();
       addBookTypes();
       addBookCategories();
       addBookPublishers();
       addClasses();
    }

public void addBookTypes()
{
 try
    {

         //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
         ps = con.prepareStatement("select * from booktype");
         rs = ps.executeQuery();

            while (rs.next())
            {
              cmbType.addItem(rs.getString(1));
            }

            //  con.close();
         }
    catch(Exception e)
    {
        System.err.println("Error is "+e);
    }
}

public void addBookCategories()
{
 try
    {

         //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
         ps = con.prepareStatement("select * from bookcategory");
         rs = ps.executeQuery();

            while (rs.next())
            {
              cmbCategory.addItem(rs.getString(1));
            }

          //    con.close();
         }
    catch(Exception e)
    {
        System.err.println("Error is "+e);
    }
}

public void addBookPublishers()
{
      try
    {

        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
         ps = con.prepareStatement("select * from bookpublisher");
         rs = ps.executeQuery();

            while (rs.next())
            {
              cmbPublisher.addItem(rs.getString(1));
            }

            //  con.close();
         }
    catch(Exception e)
    {
        System.err.println("Error is "+e);
    }

}



public void addClasses()
{
     try
    {

        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
         ps = con.prepareStatement("select * from classsetup");
         rs = ps.executeQuery();

            while (rs.next())
            {
              cmbClass.addItem(rs.getString(1));
            }

            //  con.close();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtISBN = new javax.swing.JTextField();
        cmbClass = new javax.swing.JComboBox();
        txtEdition = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbPublisher = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cmbType = new javax.swing.JComboBox();
        cmbCategory = new javax.swing.JComboBox();
        txtTitle = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        txtAuthor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();

        setBackground(new java.awt.Color(0, 204, 204));
        setClosable(true);
        setIconifiable(true);
        setTitle(" ISBN Number Entry");

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel12.setText("Author");

        txtISBN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtISBNKeyPressed(evt);
            }
        });

        cmbClass.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "General" }));
        cmbClass.setToolTipText("Choose specific class for this book");

        jLabel5.setText("Book Type");

        jLabel13.setText("Book Title");

        jLabel16.setText("Class ");

        jLabel4.setText("Publisher");

        cmbPublisher.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----" }));
        cmbPublisher.setToolTipText("Choose Book Publication");

        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel11.setText("ISBN Number");

        cmbType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----" }));
        cmbType.setToolTipText("Choose Book Type");

        cmbCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----" }));
        cmbCategory.setToolTipText("Choose Book Category");

        jLabel14.setText("Edition");

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Book Category");

        jButton4.setText("Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("*");

        jButton3.setText("Reset");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setText("*");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(301, 301, 301))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEdition, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(cmbPublisher, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cmbCategory, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cmbClass, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cmbType, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                            .addComponent(txtISBN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                            .addComponent(txtAuthor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtEdition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton2))
                .addGap(26, 26, 26))
        );

        jTextPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane1.setEditable(false);
        jTextPane1.setText("Enter ISBN Number and press Enter to view /update existing details.");
        jScrollPane1.setViewportView(jTextPane1);

        jTextPane2.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane2.setEditable(false);
        jTextPane2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextPane2.setText("                                         Add a new ISBN number imformation.");
        jScrollPane2.setViewportView(jTextPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();        // TODO add your handling code here:
}//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(txtISBN.getText().isEmpty())
        {
           JOptionPane.showMessageDialog(null, "ISBN number can not be left blank.","Message",JOptionPane.ERROR_MESSAGE);
            return;
        }
        saveData();
}//GEN-LAST:event_jButton1ActionPerformed

    public void saveData()
    {
       try
    {


      //   con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

         ps=con.prepareStatement("select * from bookisbnentry where isbnnumber=?");
         ps.setString(1, txtISBN.getText());
         rs=ps.executeQuery();
         if(rs.next())
         {
             JOptionPane.showMessageDialog(null, "This ISBN number already exists.To update the data press update.","Message",JOptionPane.WARNING_MESSAGE);
             return;
         }


         ps = con.prepareStatement("insert into bookisbnentry (isbnnumber,booktitle,author,edition,type,category,publisher,class) values (?,?,?,?,?,?,?,?)");
         ps.setString(1, txtISBN.getText());
         ps.setString(2, txtTitle.getText());
         ps.setString(3, txtAuthor.getText());
         ps.setString(4, txtEdition.getText());
         ps.setString(5, cmbType.getSelectedItem().toString());
         ps.setString(6, cmbCategory.getSelectedItem().toString());
         ps.setString(7, cmbPublisher.getSelectedItem().toString());
         ps.setString(8, cmbClass.getSelectedItem().toString());

         ps.executeUpdate();
         JOptionPane.showMessageDialog(null, "Data Saved Sucessfully.","Message",JOptionPane.PLAIN_MESSAGE);
        // con.close();
       }
       catch(Exception e)
       {
           System.err.println("Error is "+ e);
       }
    }


    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
updateData();
}//GEN-LAST:event_jButton4ActionPerformed

    public void updateData()
    {

           try
    {


        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

         ps = con.prepareStatement("update bookisbnentry set booktitle=? ,author=?,edition=?,type=?,category=?,publisher=?, class=? where isbnnumber=? ");

         ps.setString(1, txtTitle.getText());
         ps.setString(2, txtAuthor.getText());
         ps.setString(3, txtEdition.getText());
         ps.setString(4, cmbType.getSelectedItem().toString());
         ps.setString(5, cmbCategory.getSelectedItem().toString());
         ps.setString(6, cmbPublisher.getSelectedItem().toString());
         ps.setString(7, cmbClass.getSelectedItem().toString());
         ps.setString(8, txtISBN.getText());
         ps.executeUpdate();
         JOptionPane.showMessageDialog(null, "Data Updated Sucessfully.","Message",JOptionPane.PLAIN_MESSAGE);
        // con.close();
       }
       catch(Exception e)
       {
           System.err.println("Error is "+ e);
       }
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
       resetData();
    }//GEN-LAST:event_jButton3ActionPerformed


    private void txtISBNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtISBNKeyPressed
        // TODO add your handling code here:
        int keycode=evt.getKeyCode();
        if(keycode==KeyEvent.VK_ENTER)
        {
          loadSavedData();
        }
    }//GEN-LAST:event_txtISBNKeyPressed


public void resetData(){
        txtISBN.setText("");
        txtAuthor.setText("");
        txtTitle.setText("");
        txtEdition.setText("");

        cmbType.removeAllItems();
        cmbType.addItem("----");
        addBookTypes();


        cmbCategory.removeAllItems();
        cmbCategory.addItem("----");
        addBookCategories();

        cmbPublisher.removeAllItems();
        cmbPublisher.addItem("----");
        addBookPublishers();

        cmbClass.removeAllItems();
        cmbClass.addItem("General");
        addClasses();

}


    public void loadSavedData()
    {
        try
    {

       //  con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
         ps = con.prepareStatement("select * from bookisbnentry where isbnnumber=?");
         ps.setString(1, txtISBN.getText());
         rs = ps.executeQuery();

         if(!rs.next())
         {
            resetData();
            return;
         }
         

         rs.previous();

            while (rs.next())
            {
              txtTitle.setText(rs.getString(2));
              txtAuthor.setText(rs.getString(3));
              txtEdition.setText(rs.getString(4));
              cmbType.setSelectedItem(rs.getString(5));
              cmbCategory.setSelectedItem(rs.getString(6));
              cmbPublisher.setSelectedItem(rs.getString(7));
              cmbClass.setSelectedItem(rs.getString(8));
            }

          //    con.close();
         }
    catch(Exception e)
    {
        System.err.println("Error is"+e);
    }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbCategory;
    private javax.swing.JComboBox cmbClass;
    private javax.swing.JComboBox cmbPublisher;
    private javax.swing.JComboBox cmbType;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtEdition;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
//Connection con;
ResultSet rs;
PreparedStatement ps;
}
