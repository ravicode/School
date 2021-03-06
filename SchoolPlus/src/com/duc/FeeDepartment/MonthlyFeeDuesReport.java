/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MonthlyFeeDuesReport.java
 *
 * Created on Nov 9, 2009, 6:04:19 PM
 */

package com.duc.FeeDepartment;

import org.jdesktop.swingx.decorator.HighlighterFactory;
import javax.swing.JTable.PrintMode;
import java.text.MessageFormat;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import static com.duc.DatabaseConnection.DatabaseConnection.*;

/**
 *
 * @author sourabh
 */
public class MonthlyFeeDuesReport extends javax.swing.JInternalFrame {

    private DefaultTableModel model;
   // public Connection con;
    public  PreparedStatement ps;
    public  ResultSet rs;
    
    /** Creates new form MonthlyFeeDuesReport */
    public MonthlyFeeDuesReport() {
        initComponents();

        jXTable1.setHighlighters(HighlighterFactory.createAlternateStriping());
        jXTable1.setHorizontalScrollEnabled(true);


        
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
        cmbMonth = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jXTable1 = new org.jdesktop.swingx.JXTable();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jTextPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jTextPane1.setText("                                                                                Month Wise Unpaid Fee");
        jScrollPane1.setViewportView(jTextPane1);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        cmbMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choose", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        jLabel1.setText("Select Month");

        jButton1.setText("Show");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jXTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jXTable1.setColumnControlVisible(true);
        jXTable1.setHorizontalScrollEnabled(true);
        jXTable1.setSortable(false);
        jScrollPane2.setViewportView(jXTable1);

        jButton2.setText("Print");
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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 921, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(cmbMonth.getSelectedIndex()<=0)
        {
         model.setRowCount(0);
         return;
        }

        model = new MonthlyFeeDuesModel(cmbMonth.getSelectedItem().toString()).createDefaultModel();
       jXTable1.setModel(model);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String s=" Month Wise Unpaid Fee";
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

          t=">>>>>> Monthly Unpaid Fee Report For Month:  "+cmbMonth.getSelectedItem().toString() +" >>>>>>>";

          //con.close();
         }
         catch(Exception e)
         {
         System.err.println("Error in printing");
         }


        MessageFormat header=new MessageFormat(s);
        MessageFormat footer=new MessageFormat(t);
        try {
            jXTable1.print(PrintMode.FIT_WIDTH, header, footer);
        }
        catch (Exception ex)
        {
        System.err.println("Error in printing ... "+ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbMonth;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private org.jdesktop.swingx.JXTable jXTable1;
    // End of variables declaration//GEN-END:variables

}
