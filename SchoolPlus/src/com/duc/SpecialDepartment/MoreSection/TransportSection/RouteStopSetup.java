/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RouteStopSetup.java
 *
 * Created on Oct 6, 2009, 2:01:25 AM
 */

package com.duc.SpecialDepartment.MoreSection.TransportSection;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import static com.duc.DatabaseConnection.DatabaseConnection.*;
/**
 *
 * @author Ravi Dangaich
 */
public class RouteStopSetup extends javax.swing.JInternalFrame {
DefaultTableModel dm;
    /** Creates new form RouteStopSetup */
    public RouteStopSetup() {
        initComponents();
        pack();
        //this.setLocationRelativeTo(null);
        fromRouteSetup();
       // setLocation(220,200);
        dm = (DefaultTableModel)jTable1.getModel();
        dm.setRowCount(0);
    }
public void addSubject()
{
     //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
try
{
    // ps = con.prepareStatement("insert into inventorysetup (Inventoryunit,InventoryVendor,Inventorymode,class,unitid,Time) values(?,?,?,?,?,?)");
    ps=con.prepareStatement("insert into transportroutestopsetup values(?,?,?)");
    ps.setString(1,jComboBox1.getSelectedItem().toString());
    ps.setString(2,subjecttitle.getText());
ps.setDouble(3,Double.parseDouble(transportfee.getText()));


         ps.executeUpdate();


        System.out.println("Done");
       
         System.out.println("DataBase Conection Closed");
         oldSubject();
              return;
        }


catch(Exception e)
{
    e.printStackTrace();
    System.out.println("here");
}
    }

    private void oldSubject()
    {
       //  con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
       try
       {
           ps = con.prepareStatement("select * from transportroutestopsetup where routeno=?");
           ps.setString(1,jComboBox1.getSelectedItem().toString());

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
                dm.setValueAt(rs.getString(2), i, 0);
                dm.setValueAt(rs.getDouble(3), i, 1);

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
       // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        int row = jTable1.getSelectedRow();
         System.out.println("row no. selected"+row);
        try
        {
         ps=con.prepareStatement("delete from transportroutestopsetup where stopname=? and routeno=?");

         ps.setString(1,dm.getValueAt(row, 0).toString());
         ps.setString(2,jComboBox1.getSelectedItem().toString());
         ps.executeUpdate();
         dm.removeRow(row);
         // con.close();
         System.out.println("DataBase Conection Closed");
    }
        catch(Exception e)
        {
            System.err.println("Error"+e);
        }

    }
public void fromRouteSetup()
{
   // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
        ps=con.prepareStatement("select * from transportroute");

      rs = ps.executeQuery();
           while (rs.next())
        jComboBox1.addItem(rs.getString(1));
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
        subjecttitle = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        transportfee = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Stop Creator");

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jButton1.setText("Add Stop ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Remove Stop");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextPane3.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane3.setEditable(false);
        jTextPane3.setFont(new java.awt.Font("Tahoma", 0, 18));
        jTextPane3.setText("                      Add Stop Name");
        jScrollPane4.setViewportView(jTextPane3);

        jTextPane4.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane4.setEditable(false);
        jTextPane4.setText("Add Stop Name and transport fee in the way of a particular route no.. If the transport fee don't depend on distance(stopname), then set it by fee setup in Fee Department module..");
        jScrollPane5.setViewportView(jTextPane4);

        jLabel1.setText("Stop Name");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Route No.");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Stop Name", "Transport Fee"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setText("Transport Fee");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(subjecttitle, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(transportfee, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                        .addContainerGap())))
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(subjecttitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(transportfee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        addSubject();        // TODO add your handling code here:
}//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        removeSubject();        // TODO add your handling code here:
}//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        String s=jComboBox1.getSelectedItem().toString();
        oldSubject();
        // TODO add your handling code here:
}//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
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
    private javax.swing.JTextField subjecttitle;
    private javax.swing.JTextField transportfee;
    // End of variables declaration//GEN-END:variables
//Connection con;
ResultSet rs;
PreparedStatement ps;
}
