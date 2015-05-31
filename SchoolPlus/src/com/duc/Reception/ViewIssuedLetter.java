/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ViewIssuedLetter.java
 *
 * Created on Sep 19, 2009, 1:10:41 AM
 */

package com.duc.Reception;

import java.awt.event.KeyEvent;
import java.net.InetAddress;
import java.sql.*;
import java.text.MessageFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable.PrintMode;
import javax.swing.table.DefaultTableModel;
import static com.duc.DatabaseConnection.DatabaseConnection.*;
/**
 *
 * @author Ravi Dangaich
 */
public class ViewIssuedLetter extends javax.swing.JInternalFrame {
DefaultTableModel dm;
//DateFormat df;
    /** Creates new form ViewIssuedLetter */
    public ViewIssuedLetter() {
        initComponents();
        pack();
       // this.setLocationRelativeTo(null);
        dm = (DefaultTableModel) jTable1.getModel();

       // df=new SimpleDateFormat("yyyy-MM-dd");
         dateofissue.setDateFormat(df);
         fromSession();

          allIssuedLetters(); 
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
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        printButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        showAllLetterButton = new javax.swing.JButton();
        dateofissue = new datechooser.beans.DateChooserCombo();
        jLabel6 = new javax.swing.JLabel();
        dateWiseSearchButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        admissionNotext = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        sessionCombo = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        closeButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Issued Letters Display");

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Admission No.", "Letter Title", "Letter Subject", "Date", "Phone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setResizable(false);
        jTable1.getColumnModel().getColumn(1).setResizable(false);
        jTable1.getColumnModel().getColumn(2).setResizable(false);
        jTable1.getColumnModel().getColumn(3).setResizable(false);

        jTextPane1.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 0, 24));
        jTextPane1.setText("                                    View Issued Official Letters");
        jScrollPane2.setViewportView(jTextPane1);

        jTextPane2.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane2.setFont(new java.awt.Font("Tahoma", 0, 12));
        jTextPane2.setText("It will help you to view all the letters of a partcular student from his very beginning upto end of the institute session ...");
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

        showAllLetterButton.setText("Show All");
        showAllLetterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllLetterButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Date Wise Search");

        dateWiseSearchButton.setText("Search");
        dateWiseSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateWiseSearchButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Admission no. Wise Search");

        admissionNotext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                admissionNotextKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                admissionNotextKeyTyped(evt);
            }
        });

        jLabel2.setText("Session");

        sessionCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choose" }));
        sessionCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sessionComboActionPerformed(evt);
            }
        });

        jLabel1.setText("Total No. of Issued Letters:");

        closeButton1.setText("SMS");
        closeButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 941, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 941, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(admissionNotext, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sessionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateofissue, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(closeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(dateWiseSearchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(showAllLetterButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(printButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(696, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(admissionNotext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(sessionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dateWiseSearchButton)
                    .addComponent(jLabel6)
                    .addComponent(dateofissue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(showAllLetterButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(printButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        try
        {
        String s="Student Issued Letters Record";
        MessageFormat header=new MessageFormat(s);
        jTable1.print(PrintMode.FIT_WIDTH, header, null);
        }

        catch(Exception e)
        {
         System.err.println("Error in printing issued letters");
        }
}//GEN-LAST:event_printButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        this.dispose();            // TODO add your handling code here:
}//GEN-LAST:event_closeButtonActionPerformed

    private void showAllLetterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAllLetterButtonActionPerformed
        allIssuedLetters();     //   showAllDefaultersList();        // TODO add your handling code here:
}//GEN-LAST:event_showAllLetterButtonActionPerformed

    private void dateWiseSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateWiseSearchButtonActionPerformed
        viewLettersByDate();    // TODO add your handling code here:
}//GEN-LAST:event_dateWiseSearchButtonActionPerformed

    private void admissionNotextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_admissionNotextKeyPressed
       if(!admissionNotext.getText().isEmpty())
       {
           int keycode=evt.getKeyCode();
           if(keycode==KeyEvent.VK_ENTER)
           viewLettersByStudentAdmissionNo();
       }
}//GEN-LAST:event_admissionNotextKeyPressed

    private void admissionNotextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_admissionNotextKeyTyped
       // TODO add your handling code here:
}//GEN-LAST:event_admissionNotextKeyTyped

    private void sessionComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sessionComboActionPerformed
        sessionWiseLetters();
}//GEN-LAST:event_sessionComboActionPerformed

    private void closeButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButton1ActionPerformed
        // TODO add your handling code here:
       // smsIssuedLetter();
        // smsInventorySell();
        try
 {
        ps=con.prepareStatement("select access from smsaccess where module=? ");
    ps.setString(1,"Issue Letter");
    rs=ps.executeQuery();
    if(rs.next())
    {
    if(rs.getInt(1)==1)
        smsIssuedLetter();
      else JOptionPane.showConfirmDialog(null,"Add SMS package access from Accessories","Contact Administrator",JOptionPane.OK_OPTION);
       // jCheckBox1.setSelected(false);

    }else JOptionPane.showConfirmDialog(null,"Add SMS package access from Accessories","Contact Administrator",JOptionPane.OK_OPTION);
      }catch(Exception e)
{
    e.printStackTrace();
}

    }//GEN-LAST:event_closeButton1ActionPerformed

    public void smsIssuedLetter()
    {
       int crow=jTable1.getSelectedRow();

      String id;
    String msg="A letter has been issued to Admission no with title"+dm.getValueAt(crow,1).toString()+"on date"+dm.getValueAt(crow,3).toString();
    System.out.println("message"+msg);

    //if(jCheckBox1.isSelected())
     //   id=jTextField2.getText().trim();
    //else
        System.out.println("ravi"+dm.getValueAt(crow,4));
    String newmsg=msg.replace(" ","%20");
    System.out.println("New message"+newmsg);
    try
    {
 /*  if(dm.getValueAt(crow,9).equals("null"))
      {
          JOptionPane.showConfirmDialog(null,"Mobile no. Field is empty","Mobile Empty",JOptionPane.OK_OPTION);
      }
      else
      {*/
         id=dm.getValueAt(crow,4).toString().trim();
       //   System.out.println("number"+id);
          if(dm.getValueAt(crow,4).toString().equals(""))
          {
          JOptionPane.showConfirmDialog(null,"Mobile no. is Empty","Mobile No. Empty",JOptionPane.OK_OPTION);
      }
     // else*/
          InetAddress thisIp =InetAddress.getLocalHost();
            String ip=thisIp.getHostAddress();
      new com.duc.Accessories.SendSms().SmsCommon(dm.getValueAt(crow,0).toString(),id,newmsg,ip);
     // }
    }
    catch(Exception e)
    {
        JOptionPane.showConfirmDialog(null,"Mobile no. Field is empty","Mobile Empty",JOptionPane.OK_OPTION);

        e.printStackTrace();
    }
    }
    public void sessionWiseLetters()
{
    try
       {
           ps = con.prepareStatement("select issueletterhead.id,printtitle,printsubject,dateofissue,phone from issueletterhead left join sessionsetup on session=sessionid left join studententry on studententry.id=issueletterhead.id  where sessiontitle=?");
ps.setString(1,sessionCombo.getSelectedItem().toString());
           rs = ps.executeQuery();
           loadTable(rs);

       }
       catch(Exception e)
       {
           System.err.println("Error"+e);
       }
}


    public void fromSession()
    {
         try
       {
           ps = con.prepareStatement("select sessiontitle,sessionid,status from sessionsetup ");

           rs = ps.executeQuery();
           // int i = 0,j=0;
          while(rs.next())
            {
                //j++;
              sessionCombo.addItem(rs.getString(1));

              if(rs.getInt(3)==1)
                  sessionValue=rs.getInt(2);

            }



         }
         catch(Exception e)
         {
             e.printStackTrace();
    }



    }

    public void viewLettersByDate()
{
//con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

            try
            {
ps=con.prepareStatement("select issueletterhead.id,printtitle,printsubject,dateofissue,phone from issueletterhead left join studententry on studententry.id=issueletterhead.id where dateofissue=? ");
ps.setString(1,dateofissue.getText());
rs=ps.executeQuery();
loadTable(rs);
            }
            catch(Exception e)
            {
e.printStackTrace();
            }
}
public void viewLettersByStudentAdmissionNo()
{
   //  con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

            try
            {
ps=con.prepareStatement("select issueletterhead.id,printtitle,printsubject,dateofissue,phone from issueletterhead left join studententry on studententry.id=issueletterhead.id where issueletterhead.id  like ? ");
ps.setString(1,admissionNotext.getText()+"%");
rs=ps.executeQuery();
loadTable(rs);
            }
            catch(Exception e)
            {
e.printStackTrace();
            }
}

public void loadTable(ResultSet rs)
{
    int i=0,j=0;
        try
        {
            if(rs.next())
            {
                rs.first();
                rs.previous();
            while(rs.next())
            {
                j++;

            }
            rs.first();
            rs.previous();

            dm.setRowCount(j);
            System.out.println(j);
            //rs.next();
            while(rs.next())
            {
            dm.setValueAt(rs.getString(1), i, 0);
                dm.setValueAt(rs.getString(2), i, 1);
                 dm.setValueAt(rs.getString(3), i, 2);
                 dm.setValueAt(rs.getString(4), i, 3);
                 dm.setValueAt(rs.getString(5), i, 4);
                i++;
            }
            jLabel4.setText(String.valueOf(dm.getRowCount()));
            }
            else
            {
                dm.setRowCount(j);
                jLabel4.setText(String.valueOf(dm.getRowCount()));
           
            }

    }catch(Exception e)
    {
e.printStackTrace();
    }
}


public void allIssuedLetters()
{
//con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

            try
            {
ps=con.prepareStatement("select issueletterhead.id,printtitle,printsubject,dateofissue,phone from issueletterhead left join studententry on studententry.id=issueletterhead.id where session=?");
ps.setInt(1,sessionValue);
rs=ps.executeQuery();
loadTable(rs);
            }
            catch(Exception e)
            {
e.printStackTrace();
            }
}

 public void setAdmissionNo(String id)
    {
        admissionNotext.setText(id);
       int keycode=KeyEvent.VK_ENTER;
           if(keycode==KeyEvent.VK_ENTER)
           viewLettersByStudentAdmissionNo();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField admissionNotext;
    private javax.swing.JButton closeButton;
    private javax.swing.JButton closeButton1;
    private javax.swing.JButton dateWiseSearchButton;
    private datechooser.beans.DateChooserCombo dateofissue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JButton printButton;
    private javax.swing.JComboBox sessionCombo;
    private javax.swing.JButton showAllLetterButton;
    // End of variables declaration//GEN-END:variables
//Connection con;
ResultSet rs;
PreparedStatement ps;
public Integer sessionValue;
}