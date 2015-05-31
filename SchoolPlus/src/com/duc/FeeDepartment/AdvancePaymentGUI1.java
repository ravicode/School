/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AdvancePaymentGUI1.java
 *
 * Created on Sep 26, 2009, 5:15:05 PM
 */

package com.duc.FeeDepartment;
import com.duc.ImportSection.MapForIndex;
import java.sql.*;
import java.text.MessageFormat;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTable.PrintMode;
import javax.swing.table.DefaultTableModel;
import static com.duc.DatabaseConnection.DatabaseConnection.*;
//import com.duc.DatabaseConnection.DatabaseConnection.*;
/**
 *
 * @author Ravi Dangaich
 */
public class AdvancePaymentGUI1 extends javax.swing.JInternalFrame {
DefaultTableModel dm;
//DateFormat df;
//MapForIndex mp=new MapForIndex();
HashMap classmap=mp.getClassIndexName();
HashMap sectionmap=mp.getSectionIndexName();
    /** Creates new form AdvancePaymentGUI1 */
    public AdvancePaymentGUI1()
    {
        initComponents();
         //con=com.duc.DatabaseConnection.DatabaseConnection.con;
        System.out.println("con of Advance Payment="+con);
        pack();
        //this.setLocationRelativeTo(null);
        dm = (DefaultTableModel) jXTable1.getModel();
        dm.setRowCount(0);
       // df=new SimpleDateFormat("yyyy-MM-dd");
         startdate.setDateFormat(df);
         // ViewSurplusAsAdvancePayment();
       // totalAdvance();
          }

  
public void totalAdvance()
{
   Double totaldues=0.0;
    int rowcount=dm.getRowCount();
    for(int i=0;i<rowcount;i++)
    {
        System.out.println("rd");
        totaldues+=Double.parseDouble(dm.getValueAt(i,5).toString());

    }   admissionnoPayment.setText(String.valueOf(totaldues));
}

    public void ViewSurplusAsAdvancePayment()
{
    int i=0,j=0;
   
        try {
            ps=con.prepareStatement("Select * from studentsurplus where surplus!=0");
            //ps.setString(1,jComboBox1.getSelectedItem().toString());
            rs=ps.executeQuery();
         loadTable(rs);
       // con.close();
        }
      catch(Exception e)
        {
            e.printStackTrace();
    }

}


     public void ViewSurplusAsAdvancePaymentDateWise()
{
    int i=0,j=0;

        try {
            ps=con.prepareStatement("Select * from studentsurplus where date=?");
            ps.setString(1,startdate.getText());
            rs=ps.executeQuery();
         loadTable(rs);
       // con.close();
        }
      catch(Exception e)
        {
            e.printStackTrace();
    }

}

     public void ViewUsedSurplusAsAdvancePaymentDateWise()
{
    int i=0,j=0;

        try {
            ps=con.prepareStatement("Select * from studentusedsurplus where date=?");
            ps.setString(1,startdate.getText());
            rs=ps.executeQuery();
         loadTable(rs);
       // con.close();
        }
      catch(Exception e)
        {
            e.printStackTrace();
    }

}

     public void ViewDayWiseSurplusAsAdvancePaymentDateWise()
{
    int i=0,j=0;

        try {
            ps=con.prepareStatement("Select * from studenttodaysurplus where date=?");
            ps.setString(1,startdate.getText());
            rs=ps.executeQuery();
         loadTable(rs);
       // con.close();
        }
      catch(Exception e)
        {
            e.printStackTrace();
    }

}
    public void loadTable(ResultSet rs)
    {
        dm.setRowCount(0);
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
            while(rs.next())
            {


                dm.setValueAt(rs.getString(1), i, 0);
                dm.setValueAt(rs.getDouble(2), i, 5);
                if(jCheckBox4.isSelected())
                    dm.setValueAt(rs.getString(4), i, 6);
                else
                 dm.setValueAt(rs.getString(3), i, 6);

                  i++;
            }

            for(int l=0;l<i;l++)
            {
                ps=con.prepareStatement("select * from studententry where id=?");
            j=0;
                ps.setString(1,dm.getValueAt(l, 0).toString());
                     rs1=ps.executeQuery();

           if(rs1.next())
           {

                     dm.setValueAt(rs1.getString(2), l, 1);
                dm.setValueAt(classmap.get(rs1.getInt(9)), l, 2);
                dm.setValueAt(sectionmap.get(rs1.getInt(10)), l, 3);
                dm.setValueAt(rs1.getInt(11), l, 4);
            }

        }
            }
            else
                dm.setRowCount(0);
        }catch(Exception e)
        {

        }
    }

    public void ViewAllSurplusAsAdvancePayment()
{
    int i=0,j=0;

        try {
            ps=con.prepareStatement("Select * from studentsurplus");
            //ps.setString(1,jComboBox1.getSelectedItem().toString());
            rs=ps.executeQuery();
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
                dm.setValueAt(rs.getDouble(2), i, 5);
                 dm.setValueAt(rs.getString(3), i, 6);

                  i++;
            }

            for(int l=0;l<i;l++)
            {
                ps=con.prepareStatement("select * from studententry where id=?");
            j=0;
                ps.setString(1,dm.getValueAt(l, 0).toString());
                     rs1=ps.executeQuery();

           if(rs1.next())
           {

                     dm.setValueAt(rs1.getString(2), l, 1);
                dm.setValueAt(classmap.get(rs1.getInt(9)), l, 2);
                dm.setValueAt(sectionmap.get(rs1.getInt(10)), l, 3);
                dm.setValueAt(rs1.getInt(11), l, 4);
            }

        }
       // con.close();
        }
            else
                dm.setRowCount(0);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        printButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        admissionnoPayment = new javax.swing.JTextField();
        viewButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        advancepayment2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        startdate = new datechooser.beans.DateChooserCombo();
        viewButton3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jXTable1 = new org.jdesktop.swingx.JXTable();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        printButton1 = new javax.swing.JButton();
        jCheckBox4 = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Advance Payments/Surplus List");

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jTextPane1.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 0, 24));
        jTextPane1.setText("                                            Advance Payments");
        jScrollPane2.setViewportView(jTextPane1);

        jTextPane2.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane2.setEditable(false);
        jTextPane2.setFont(new java.awt.Font("Tahoma", 0, 12));
        jTextPane2.setText("It will show the list of all the advance payments made by the student as on monthly basis..write the admission no. in the box to be refunded..");
        jScrollPane3.setViewportView(jTextPane2);

        printButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        printButton.setForeground(new java.awt.Color(0, 0, 255));
        printButton.setText("Print");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setText("Total Advance payment");

        viewButton1.setFont(new java.awt.Font("Tahoma", 1, 12));
        viewButton1.setForeground(new java.awt.Color(0, 0, 255));
        viewButton1.setText("Refund");
        viewButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel5.setText("Admission Number");

        advancepayment2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                advancepayment2KeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("Date ");

        viewButton3.setFont(new java.awt.Font("Tahoma", 1, 12));
        viewButton3.setForeground(new java.awt.Color(0, 0, 255));
        viewButton3.setText("View");
        viewButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButton3ActionPerformed(evt);
            }
        });

        jXTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "", null, null, null, new Double(0.0), null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Adm. No.", "Name", "Class", "Section", "Roll No.", "Amount", "Last Updated"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jXTable1.setColumnControlVisible(true);
        jXTable1.setHorizontalScrollEnabled(true);
        jXTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXTable1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jXTable1);

        jCheckBox1.setBackground(new java.awt.Color(0, 153, 153));
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jCheckBox1.setText("Used");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setBackground(new java.awt.Color(0, 153, 153));
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jCheckBox2.setText("Day-Wise");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setBackground(new java.awt.Color(0, 153, 153));
        jCheckBox3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jCheckBox3.setText("Total");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        printButton1.setFont(new java.awt.Font("Tahoma", 1, 12));
        printButton1.setForeground(new java.awt.Color(0, 0, 255));
        printButton1.setText("Update");
        printButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButton1ActionPerformed(evt);
            }
        });

        jCheckBox4.setBackground(new java.awt.Color(0, 153, 153));
        jCheckBox4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jCheckBox4.setText("Refunded");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(580, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(admissionnoPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(advancepayment2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jCheckBox3)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox2)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox1)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startdate, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 864, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(printButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(printButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 967, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 967, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(advancepayment2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jCheckBox3)
                        .addComponent(jCheckBox2)
                        .addComponent(jCheckBox1)
                        .addComponent(jCheckBox4))
                    .addComponent(viewButton3)
                    .addComponent(startdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(printButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(printButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(admissionnoPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
         try
        {
        String s="Student Advance Payment Result";
        MessageFormat header=new MessageFormat(s);
        jXTable1.print(PrintMode.FIT_WIDTH, header, null);
        }

        catch(Exception e)
        {
         System.err.println("Error in printing Advance Payment");
        }
}//GEN-LAST:event_printButtonActionPerformed

    private void viewButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButton1ActionPerformed
       refundSurplus();
    }//GEN-LAST:event_viewButton1ActionPerformed

    private void advancepayment2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_advancepayment2KeyPressed
if(jCheckBox1.isSelected() || jCheckBox2.isSelected() || jCheckBox3.isSelected())
{
        viewAdvance();
totalAdvance();
}
else
{
    dm.setRowCount(0);
    JOptionPane.showConfirmDialog(null,"Choose one checkbox","Choose one checkbox",JOptionPane.OK_OPTION);
}
// TODO add your handling code here:
    }//GEN-LAST:event_advancepayment2KeyPressed

    private void viewButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButton3ActionPerformed
       // totalDayBook();
        if(jCheckBox1.isSelected() || jCheckBox2.isSelected() || jCheckBox3.isSelected())
{
        if(jCheckBox3.isSelected())
           ViewSurplusAsAdvancePaymentDateWise();
        if(jCheckBox2.isSelected())
            ViewDayWiseSurplusAsAdvancePaymentDateWise();
        if(jCheckBox1.isSelected())
          ViewUsedSurplusAsAdvancePaymentDateWise();
        }
        else
            JOptionPane.showConfirmDialog(null,"Check to view","Check Options",JOptionPane.OK_OPTION);
//ViewSurplusAsAdvancePaymentDateWise();
//totalAdvance();
        // TODO add your handling code here:
}//GEN-LAST:event_viewButton3ActionPerformed

    private void jXTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTable1MouseClicked

}//GEN-LAST:event_jXTable1MouseClicked

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        if(jCheckBox3.isSelected())
        {
            jCheckBox1.setSelected(false);
            jCheckBox2.setSelected(false);
            jCheckBox4.setSelected(false);
            ViewSurplusAsAdvancePayment();
            totalAdvance();
        }
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
       if(jCheckBox1.isSelected())
        {
           jCheckBox2.setSelected(false);
            jCheckBox3.setSelected(false);
            jCheckBox4.setSelected(false);
        ViewUsedSurplusAsAdvancePayment();
        totalAdvance();
       }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
       if(jCheckBox2.isSelected())
        {
           jCheckBox1.setSelected(false);
            jCheckBox3.setSelected(false);
            jCheckBox4.setSelected(false);
            ViewDayWiseSurplusAsAdvancePayment();
            totalAdvance();
        }
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void printButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButton1ActionPerformed
       updateSurplus();
    }//GEN-LAST:event_printButton1ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        // TODO add your handling code here:
         if(jCheckBox4.isSelected())
        {
              jCheckBox1.setSelected(false);
           jCheckBox2.setSelected(false);
            jCheckBox3.setSelected(false);
        ViewRefundedAdvanceOrScholar();
        totalAdvance();
       }
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    public void updateSurplus()
    {
        if(jCheckBox1.isSelected() || jCheckBox2.isSelected() || jCheckBox3.isSelected())
{
        if(jCheckBox1.isSelected())
            updateUsedSurplusAsAdvancePayment();
        if(jCheckBox2.isSelected())
            updateDayWiseSurplusAsAdvancePayment();
        if(jCheckBox3.isSelected())
            updateSurplusAsAdvancePayment();
        }
        else
            JOptionPane.showConfirmDialog(null,"Check To update","Check",JOptionPane.OK_OPTION);

    }


    public void updateUsedSurplusAsAdvancePayment()
    {
        int currentrow=jXTable1.getSelectedRow();
        try
        {
            ps=con.prepareStatement("update studentusedsurplus set surplus=? where date=? and studentid=?");
            ps.setDouble(1,Double.parseDouble(dm.getValueAt(currentrow,5).toString()));
            ps.setString(2,dm.getValueAt(currentrow,6).toString());
            ps.setString(3,dm.getValueAt(currentrow,0).toString());
            ps.executeUpdate();
            JOptionPane.showConfirmDialog(null,"Updated !! Match this according to (Total=DayWise-used) for a particular student and Day's Fee Collection Report","Match Day's wise Collection report",JOptionPane.OK_OPTION);

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

     public void updateDayWiseSurplusAsAdvancePayment()
    {
        int currentrow=jXTable1.getSelectedRow();
        try
        {
            ps=con.prepareStatement("update studenttodaysurplus set surplus=? where date=? and studentid=?");
            ps.setDouble(1,Double.parseDouble(dm.getValueAt(currentrow,5).toString()));
            ps.setString(2,dm.getValueAt(currentrow,6).toString());
            ps.setString(3,dm.getValueAt(currentrow,0).toString());
            ps.executeUpdate();
            JOptionPane.showConfirmDialog(null,"Updated !! Match this according to (Total=DayWise-used) for a particular student and Day's Fee Collection Report","Match Day's wise Collection report",JOptionPane.OK_OPTION);


        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

      public void updateSurplusAsAdvancePayment()
    {
        int currentrow=jXTable1.getSelectedRow();
        try
        {
            ps=con.prepareStatement("update studentsurplus set surplus=? where date=? and studentid=?");
            ps.setDouble(1,Double.parseDouble(dm.getValueAt(currentrow,5).toString()));
            ps.setString(2,dm.getValueAt(currentrow,6).toString());
            ps.setString(3,dm.getValueAt(currentrow,0).toString());
            ps.executeUpdate();
            JOptionPane.showConfirmDialog(null,"Updated !! Match this according to (Total=DayWise-used) for a particular student and Day's Fee Collection Report","Match Day's wise Collection report",JOptionPane.OK_OPTION);


        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
      public void  ViewUsedSurplusAsAdvancePayment()
    {
        int i=0,j=0;

        try {
            ps=con.prepareStatement("Select * from studentusedsurplus");
            //ps.setString(1,jComboBox1.getSelectedItem().toString());
            rs=ps.executeQuery();
         loadTable(rs);
       // con.close();
        }
      catch(Exception e)
        {
            e.printStackTrace();
    }
    }

     public void  ViewRefundedAdvanceOrScholar()
     {
        int i=0,j=0;

        try {
            ps=con.prepareStatement("Select * from studentrefund where type=0");
            //ps.setString(1,jComboBox1.getSelectedItem().toString());
            rs=ps.executeQuery();
         loadTable(rs);
       // con.close();
        }
      catch(Exception e)
        {
            e.printStackTrace();
    }
     }
    public void  ViewDayWiseSurplusAsAdvancePayment()
    {
        int i=0,j=0;

        try {
            ps=con.prepareStatement("Select * from studenttodaysurplus");
            //ps.setString(1,jComboBox1.getSelectedItem().toString());
            rs=ps.executeQuery();
         loadTable(rs);
       // con.close();
        }
      catch(Exception e)
        {
            e.printStackTrace();
    }
    }
    public void viewAdvance()
    {
        try
        {
            if(jCheckBox3.isSelected())
            {
            ps=con.prepareStatement("select * from studentsurplus where studentid=?");
            ps.setString(1,advancepayment2.getText());
            }
             if(jCheckBox1.isSelected())
            {
            ps=con.prepareStatement("select * from studentusedsurplus where studentid=?");
            ps.setString(1,advancepayment2.getText());
            }
             if(jCheckBox2.isSelected())
            {
            ps=con.prepareStatement("select * from studenttodaysurplus where studentid=?");
            ps.setString(1,advancepayment2.getText());
            }
            rs=ps.executeQuery();

            loadTable(rs);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void setAdmissionNoPayment(String id)
{
    admissionnoPayment.setText(id);
    if(!admissionnoPayment.getText().isEmpty()) viewPaymentList();
}

public void viewPaymentList()
{
    int i=0,j=0;
    //con=com.duc.DatabaseConnection.DatabaseConnection.con;
    try
    {
         ps=con.prepareStatement("select * from studentsurplus where studentid=? and surplus!=0");
        ps.setString(1,admissionnoPayment.getText());
        rs=ps.executeQuery();

        while(rs.next())
            {
                j++;

            }
            rs.first();
            rs.previous();

            System.out.println("rd"+j);

            dm.setRowCount(j);

            while(rs.next())
            {

             dm.setValueAt(rs.getString(1), i, 0);
                dm.setValueAt(rs.getDouble(2), i, 5);
                 dm.setValueAt(rs.getString(3), i, 6);
                
                  i++;
            }

            for(int l=0;l<i;l++)
            {
                ps=con.prepareStatement("select * from studententry where id=?");
            j=0;
                ps.setString(1,admissionnoPayment.getText());
                     rs1=ps.executeQuery();

           if(rs1.next())
           {

                     dm.setValueAt(rs1.getString(2), l, 1);
                dm.setValueAt(classmap.get(rs1.getInt(9)), l, 2);
                dm.setValueAt(sectionmap.get(rs1.getInt(10)), l, 3);
                dm.setValueAt(rs1.getInt(11), l, 4);
            }

        }
        //con.close();
    }
    catch(Exception e)
    {
e.printStackTrace();
    }
}
public void refundSurplus()
    {
    int currentrow=jXTable1.getSelectedRow();
        //con=com.duc.DatabaseConnection.DatabaseConnection.con;
        try
        {

            ps=con.prepareStatement("update studentsurplus set surplus=0 where studentid=?");

            ps.setString(1,dm.getValueAt(currentrow,0).toString());
            ps.executeUpdate();

    ps=con.prepareStatement("insert into studentrefund values(?,?,?,?)");
ps.setString(1,dm.getValueAt(currentrow,0).toString());

ps.setDouble(2,Double.parseDouble(dm.getValueAt(currentrow,5).toString()));
ps.setInt(3,0);
ps.setString(4,datum);

ps.executeUpdate();



            
        }catch(Exception e)
        {
e.printStackTrace();
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField admissionnoPayment;
    private javax.swing.JTextField advancepayment2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private org.jdesktop.swingx.JXTable jXTable1;
    private javax.swing.JButton printButton;
    private javax.swing.JButton printButton1;
    private datechooser.beans.DateChooserCombo startdate;
    private javax.swing.JButton viewButton1;
    private javax.swing.JButton viewButton3;
    // End of variables declaration//GEN-END:variables
ResultSet rs,rs1;
//Connection con;
PreparedStatement ps;
}
