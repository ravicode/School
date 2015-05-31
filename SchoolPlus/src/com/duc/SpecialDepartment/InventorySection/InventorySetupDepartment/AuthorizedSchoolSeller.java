/*
 * AuthorizedSchoolSeller.java
 *
 * Created on August 16, 2009, 1:05 PM
 */

package com.duc.SpecialDepartment.InventorySection.InventorySetupDepartment;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import static com.duc.DatabaseConnection.DatabaseConnection.*;


/**
 *
 * @author  ravi
 */
public class AuthorizedSchoolSeller extends javax.swing.JFrame {
     DefaultTableModel dm;
    /** Creates new form AuthorizedSchoolSeller */
    public AuthorizedSchoolSeller() {
        initComponents();
        //setLocation(220,200);
        pack();
        this.setLocationRelativeTo(null);
        dm = (DefaultTableModel) jXTable3.getModel();
        dm.setRowCount(0);

         oldSchoolSeller();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        schseller = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jXTable3 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Institute Rep. Creator");

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));

        jLabel3.setText("School Selling Representative"); // NOI18N

        schseller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schsellerActionPerformed(evt);
            }
        });

        jButton11.setText("Add"); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Close"); // NOI18N
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Reset"); // NOI18N
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton15.setText("Remove"); // NOI18N
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jXTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "School Selling Representative"
            }
        ));
        jScrollPane1.setViewportView(jXTable3);

        jTextPane2.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane2.setEditable(false);
        jTextPane2.setText("Set the name and post of the persons who has the authority to sell inventory."); // NOI18N
        jScrollPane4.setViewportView(jTextPane2);

        jTextPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 0, 18));
        jTextPane1.setText("                 InstituteSelling Representative"); // NOI18N
        jScrollPane3.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(schseller, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(schseller, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton15))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void schsellerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schsellerActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_schsellerActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        addSchoolSeller();
    }//GEN-LAST:event_jButton11ActionPerformed

    public void addSchoolSeller()
    {
       //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        
try
{
    // ps = con.prepareStatement("insert into inventorysetup (Inventoryunit,InventoryVendor,Inventorymode,class,unitid,Time) values(?,?,?,?,?,?)");
    ps=con.prepareStatement("insert into schoolsellersetup (seller,time) values(?,?)");    
    ps.setString(1,schseller.getText());
         ps.setString(2,datum);

         ps.executeUpdate();
        
            
        System.out.println("Done");
        //JOptionPane.showMessageDialog(null,"data stored successfully","report",JOptionPane.PLAIN_MESSAGE);

//con.close();
         System.out.println("DataBase Conection Closed");
         oldSchoolSeller();
              return;
        }
    

catch(Exception e)
{
    System.err.println("Error"+e);
}
    }
    
    private void oldSchoolSeller()
    {
       // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
       try
       {
           p = con.prepareStatement("select * from schoolsellersetup");
       
           rs = p.executeQuery();
            int i = 0,j=0;
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
            while(rs.next())
            {
                dm.setValueAt(rs.getString(1), i, 0);
                
                i++;
            }
          //  con.close();
            System.out.println("Database closed");
        
       }
       }
       catch(Exception e)
       {
           System.err.println("Error"+e);
       }
    }
    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        schseller.setText(" ");        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        removeSchoolSeller();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed
    
    public void removeSchoolSeller()
    {
      // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        int row = jXTable3.getSelectedRow();
         System.out.println("row no. selected"+row);
        try
        {
         ps=con.prepareStatement("delete from schoolsellersetup where seller=?");
        
         ps.setString(1,dm.getValueAt(row, 0).toString());
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
    public void editUnit()
    {
        
    }   
    /**
     * @param args the command line arguments
     */
    public static void man() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AuthorizedSchoolSeller().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTable jXTable3;
    private javax.swing.JTextField schseller;
    // End of variables declaration//GEN-END:variables
    //Connection con;
   PreparedStatement ps,p,ps1;
   ResultSet rs;
}
