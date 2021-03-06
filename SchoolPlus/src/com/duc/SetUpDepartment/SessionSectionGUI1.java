/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SessionSectionGUI1.java
 *
 * Created on Dec 20, 2009, 3:40:57 PM
 */

package com.duc.SetUpDepartment;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static com.duc.DatabaseConnection.DatabaseConnection.*;
/**
 *
 * @author Ravi
 */
public class SessionSectionGUI1 extends javax.swing.JInternalFrame {
 DefaultTableModel dm;
    /** Creates new form SessionSectionGUI1 */
    public SessionSectionGUI1() {
        initComponents();
         pack();
        //this.setLocationRelativeTo(null);
       // setLocation(220,200);
        dm = (DefaultTableModel)jTable1.getModel();
        dm.setRowCount(0);

         oldSession();

            birth1.setDateFormat(df);
         birth2.setDateFormat(df);

   birth1.setText("2010-04-01");
         birth2.setText("2011-03-31");

    }
public void addSession()
{
    // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
try
{
    ps=con.prepareStatement("select * from sessionsetup where enddate >=? and startdate<=? ");
    ps.setString(1,birth1.getText());
    ps.setString(2,birth1.getText());
    rs=ps.executeQuery();
    if(!rs.next())
    {

       

    ps=con.prepareStatement("select * from sessionsetup where enddate >=? and startdate<=? ");
    ps.setString(1,birth2.getText());
    ps.setString(2,birth2.getText());
    rs=ps.executeQuery();
    if(!rs.next())
    {

    // ps = con.prepareStatement("insert into inventorysetup (Inventoryunit,InventoryVendor,Inventorymode,class,unitid,Time) values(?,?,?,?,?,?)");
    ps=con.prepareStatement("insert into sessionsetup (sessiontitle,time,startdate,enddate) values(?,?,?,?)");
    ps.setString(1,sessiontitle.getText());  
    ps.setString(2,datum);
    ps.setString(3,birth1.getText());
    ps.setString(4,birth2.getText());
         ps.executeUpdate();


        System.out.println("Done");
        //JOptionPane.showMessageDialog(null,"data stored successfully","report",JOptionPane.PLAIN_MESSAGE);

//con.close();
         System.out.println("DataBase Conection Closed");
         oldSession();
              return;
    }
    }
    
    

    JOptionPane.showMessageDialog(null,"This Date is already used");
}

catch(Exception e)
{
    e.printStackTrace();
    System.out.println("here");
}

    }

    private void oldSession()
    {
       //  con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
       try
       {
           ps = con.prepareStatement("select * from sessionsetup");

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
                dm.setValueAt(rs.getString(1), i, 0);
                dm.setValueAt(rs.getString(2), i, 1);
 dm.setValueAt(rs.getInt(4), i, 2);

 dm.setValueAt(rs.getString(5), i, 3);
                dm.setValueAt(rs.getString(6), i, 4);
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






    public void removeSession()
    {
       // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        int row = jTable1.getSelectedRow();
         System.out.println("row no. selected"+row);
        try
        {
         ps=con.prepareStatement("delete from sessionsetup where sessiontitle=?");

         ps.setString(1,dm.getValueAt(row, 0).toString());
         ps.executeUpdate();
         dm.removeRow(row);
          //con.close();
         System.out.println("DataBase Conection Closed");
    }
        catch(Exception e)
        {
            System.err.println("Error"+e);
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
        jSeparator1 = new javax.swing.JSeparator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPane4 = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        sessiontitle = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        birth1 = new datechooser.beans.DateChooserCombo();
        jLabel41 = new javax.swing.JLabel();
        birth2 = new datechooser.beans.DateChooserCombo();

        jMenuItem1.setText("Active");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);
        jPopupMenu1.add(jSeparator1);

        jMenuItem2.setText("De-Active");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setClosable(true);
        setIconifiable(true);
        setTitle("Session Creator");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Session Title", "Index", "Status", "Start-Date", "End-Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Add Session");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("Delete Session");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextPane3.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane3.setEditable(false);
        jTextPane3.setFont(new java.awt.Font("Tahoma", 0, 18));
        jTextPane3.setText("                       Session Manager");
        jScrollPane4.setViewportView(jTextPane3);

        jTextPane4.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane4.setEditable(false);
        jTextPane4.setText("                       Add Session. Provide the title and Session start & end date.");
        jScrollPane5.setViewportView(jTextPane4);

        jLabel1.setText("Title");

        jLabel40.setText("Start Date"); // NOI18N

        birth1.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_SINGLE);

        jLabel41.setText("End Date"); // NOI18N

        birth2.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_SINGLE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(12, 12, 12)))
                .addContainerGap())
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(51, 51, 51)
                        .addComponent(sessiontitle, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                        .addGap(146, 146, 146))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(birth1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(birth2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jButton4)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(sessiontitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addComponent(birth1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addComponent(birth2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        addSession();        // TODO add your handling code here:
}//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        removeSession();      // TODO add your handling code here:
}//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
         deActiveSession();
         oldSession();
         
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       activeSession();
      
       oldSession();
     
      SchoolPlus.Launcher.rd.dispose();
SchoolPlus.LoginScreen.man();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

   
    public void activeSession()
    {
         int crow=jTable1.getSelectedRow();
        String id=dm.getValueAt(crow,1).toString();
  
    try
     {
     

        ps=con.prepareStatement("update sessionsetup set status=? where sessionid=?") ;
       ps.setInt(1,1);
        ps.setString(2,id);
      ps.executeUpdate();

      ps=con.prepareStatement("update sessionsetup set status=? where sessionid!=?") ;
       ps.setInt(1,0);
        ps.setString(2,id);
      ps.executeUpdate();
    }
     catch(Exception e)
     {
         e.printStackTrace();
     }
    }
    public void deActiveSession()
    {
         int crow=jTable1.getSelectedRow();
        String id=dm.getValueAt(crow,1).toString();
 
    try
     {
     
        ps=con.prepareStatement("update sessionsetup set status=? where sessionid=?") ;
       ps.setInt(1,0);
        ps.setString(2,id);
      ps.executeUpdate();
    }
     catch(Exception e)
     {
         e.printStackTrace();
     }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo birth1;
    private datechooser.beans.DateChooserCombo birth2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextPane jTextPane4;
    private javax.swing.JTextField sessiontitle;
    // End of variables declaration//GEN-END:variables
ResultSet rs;
PreparedStatement ps;
}
