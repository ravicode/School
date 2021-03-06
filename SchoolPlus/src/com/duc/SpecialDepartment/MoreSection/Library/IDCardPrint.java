/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IDCardPrint.java
 *
 * Created on Sep 30, 2009, 10:57:58 AM
 */

package com.duc.SpecialDepartment.MoreSection.Library;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import static com.duc.DatabaseConnection.DatabaseConnection.*;

/**
 *
 * @author sourabh
 */
public class IDCardPrint extends javax.swing.JInternalFrame {

    /** Creates new form IDCardPrint */
    public IDCardPrint() {
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        txtAdmission = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setText("Admission Number");

        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAdmission, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(190, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtAdmission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(249, Short.MAX_VALUE))
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
        // TODO add your handling code here:
       String id=txtAdmission.getText();
        printStudentidCard(id);
    }//GEN-LAST:event_jButton1ActionPerformed

    public void printStudentidCard(String id)
    {
     if(id.isEmpty())
     return;
     
     try
     {
         //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
         HashMap map = new HashMap();
         map.put("id",id);
         
          ps=con.prepareStatement("select institutename, instituteaddress from instituteregistration" );
          rs = ps.executeQuery();
          rs.next();
          map.put("schoolname",rs.getString(1));
          map.put("schooladdress",rs.getString(2));

           BufferedImage bimg = null;
           bimg = ImageIO.read(new File("images/logo.jpg"));
           map.put("logo",bimg);

            ps=con.prepareStatement("select * from studentpicture where admissionno=?");
            ps.setString(1,id);
            rs=ps.executeQuery();

            rs.next();
            {
                if(rs.getBinaryStream(2)!=null)
                {
                   bimg =ImageIO.read(rs.getBinaryStream(2));
                   map.put("pic", bimg);
                }
             }

         ps=con.prepareStatement("select id,name,fathername,(select(date_format(dob,'%M %d , %Y'))) as dob from studententry where id=?");
         ps.setString(1,id);
         rs=ps.executeQuery();
         if(!rs.next())
         {
           JOptionPane.showMessageDialog(null, "Invalid Admission Number!","Message",JOptionPane.ERROR_MESSAGE);
           //con.close();
           return;
         }
         rs.previous();


                JRResultSetDataSource src = new JRResultSetDataSource(rs);
                JasperReport js = JasperCompileManager.compileReport("reports/student/idcard.jrxml");
                JasperPrint pr = JasperFillManager.fillReport(js,map,src);
                JasperViewer jv = new JasperViewer(pr, false);
                jv.setTitle("Student ID Card Print ");
                jv.setVisible(true);
              //  con.close();

     }
     
     catch(Exception e)
     {
      System.err.println("Error is ...."+e);
     
     }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAdmission;
    // End of variables declaration//GEN-END:variables
   //public Connection con;
   public  PreparedStatement ps;
   public  ResultSet rs;
}
