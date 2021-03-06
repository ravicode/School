/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * WeedOutBook.java
 *
 * Created on Dec 22, 2009, 6:47:20 PM
 */

package com.duc.SpecialDepartment.MoreSection.Library;
import org.jdesktop.swingx.decorator.HighlighterFactory;
import javax.swing.JTable.PrintMode;
import java.text.MessageFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import static com.duc.DatabaseConnection.DatabaseConnection.*;

/**
 *
 * @author sourabh
 */
public class LostBook extends javax.swing.JInternalFrame {

    /** Creates new form WeedOutBook */
    public LostBook()
    {
        initComponents();
        jXTable1.setHighlighters(HighlighterFactory.createAlternateStriping());
        jXTable1.setHorizontalScrollEnabled(true);
        dm = (DefaultTableModel) jXTable1.getModel();
        dm.setRowCount(0);
        loadlostBooks();
    }

    public void loadlostBooks()
    {
        try
        {
         //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
         ps=con.prepareStatement("select booklost.accession_no,booktitle,date_format(date,'%d %M, %Y'),reason from booklost,bookinformation where booklost.accession_no=bookinformation.accession_no order by date desc");
         rs=ps.executeQuery();
         int i=0;
         while(rs.next())
         i++;

         dm.setRowCount(i);
         rs.first();
         rs.previous();

         i=0;
         while(rs.next())
         {
             dm.setValueAt(rs.getString(1), i, 0);
             dm.setValueAt(rs.getString(2), i, 1);
             dm.setValueAt(rs.getString(3), i, 2);
             dm.setValueAt(rs.getString(4), i, 3);
             i++;
         }
         //con.close();
        }
        catch(Exception e)
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtAccession = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtRemark = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jXTitledSeparator1 = new org.jdesktop.swingx.JXTitledSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        jXTable1 = new org.jdesktop.swingx.JXTable();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Lost Books' Details");

        jTextPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jTextPane1.setText("                                                                   Add the lost book information.");
        jScrollPane1.setViewportView(jTextPane1);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setText("Enter Book Accession Number");

        jLabel2.setText("Remark (Reason for weeding out)");

        txtRemark.setColumns(20);
        txtRemark.setRows(5);
        jScrollPane2.setViewportView(txtRemark);

        jButton1.setText("Mark as Lost");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jXTitledSeparator1.setTitle("List of already lost  books");

        jXTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Accession Number", "Book Title", "Date", "Reason/Remark"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jXTable1.setCellSelectionEnabled(true);
        jXTable1.setColumnControlVisible(true);
        jXTable1.setHorizontalScrollEnabled(true);
        jScrollPane3.setViewportView(jXTable1);

        jButton2.setText("Print Table");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAccession, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jXTitledSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtAccession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2)
                        .addGap(33, 33, 33)
                        .addComponent(jButton1)))
                .addGap(18, 18, 18)
                .addComponent(jXTitledSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(txtAccession.getText().isEmpty())
        JOptionPane.showMessageDialog(null,"Enter Book Accession Number","Message",JOptionPane.WARNING_MESSAGE);
        boolean b=checklostBook(txtAccession.getText());
        if(b==true)
        LostBook(txtAccession.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String s="";
        String t="";
         try
         {
         // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
          ps=con.prepareStatement("select institutename, instituteaddress from instituteregistration" );
          rs = ps.executeQuery();
          rs.next();

          s=rs.getString(1);
          s+=" , ";
          s+=rs.getString(2);

          t="Lost Books List";
        //  con.close();
         }
         catch(Exception e)
         {
         System.err.println("Error in printing");
         }


        MessageFormat header=new MessageFormat(s);
        MessageFormat footer=new MessageFormat(t);
        try {
            jXTable1.print(PrintMode.FIT_WIDTH, header, footer);
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_jButton2ActionPerformed

 public boolean checklostBook(String accession)
{
 boolean b=false;
 try
 {
    // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
     ps=con.prepareStatement("select available from bookstatus where booknumber=?");
     ps.setString(1, accession);
     rs=ps.executeQuery();
     if(rs.next())
     {
      int j=rs.getInt(1);        

       if(j==3)
       {
       b=false;
       JOptionPane.showMessageDialog(null,"Book is already marked as lost. ","Message",JOptionPane.ERROR_MESSAGE);
       }
      
      else
      {
       b=true;
      }

     }
     else
     {
     JOptionPane.showMessageDialog(null,"Accession Number does not exists. ","Message",JOptionPane.ERROR_MESSAGE);
     b=false;
     }
     //con.close();
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
 return b;
}

 public void LostBook(String accession)
 {
    try
    {
     //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
     ps=con.prepareStatement("insert into booklost (accession_no,date,reason) values(?,current_date(),?) ");
     ps.setString(1, accession);
     ps.setString(2, txtRemark.getText());
     ps.executeUpdate();
     
     ps=con.prepareStatement("update bookstatus set available=3 where booknumber=?");
     ps.setString(1,accession);
     ps.executeUpdate();    
    // con.close();
     JOptionPane.showMessageDialog(null,"Book is marked as lost.","Message",JOptionPane.INFORMATION_MESSAGE);
     loadlostBooks();
    }
    catch(Exception e)
    {
     e.printStackTrace();
    }
 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane jTextPane1;
    private org.jdesktop.swingx.JXTable jXTable1;
    private org.jdesktop.swingx.JXTitledSeparator jXTitledSeparator1;
    private javax.swing.JTextField txtAccession;
    private javax.swing.JTextArea txtRemark;
    // End of variables declaration//GEN-END:variables

  // public Connection con;
   public  PreparedStatement ps;
   public  ResultSet rs;
   DefaultTableModel dm;
}
