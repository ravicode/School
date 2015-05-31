/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BusBoarders.java
 *
 * Created on Oct 6, 2009, 2:02:24 AM
 */

package com.duc.SpecialDepartment.MoreSection.TransportSection;
import com.duc.ImportSection.MapForIndex;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static com.duc.DatabaseConnection.DatabaseConnection.*;
/**
 *
 * @author Ravi Dangaich
 */
public class BusBoarders extends javax.swing.JInternalFrame {
DefaultTableModel dm1,dm2;
//MapForIndex mp=new MapForIndex();
HashMap monthlyfeemap1=mp.getMonthlyFeeIndexFromName();
    /** Creates new form BusBoarders */
    public BusBoarders() {
        initComponents();
        dm1 = (DefaultTableModel)jXTable1.getModel();
        dm1.setRowCount(0);

      
        fromTransportRouteBusSetup();
        fromTransportRouteStopSetup();
    }
    public void fromTransportRouteStopSetup()
   {
      // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
        ps=con.prepareStatement("select * from transportroutestopsetup");

      rs = ps.executeQuery();
           while (rs.next())
        stopname.addItem(rs.getString(2));
}
    catch(SQLException e)
    {
        e.printStackTrace();
    }
   }

    public void  fromTransportRouteBusSetup()
   {
       //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
        ps=con.prepareStatement("select * from transportroutebussetup");

      rs = ps.executeQuery();
           while (rs.next())
        busno.addItem(rs.getString(2));
}
    catch(SQLException e)
    {
        e.printStackTrace();
    }
   }
    
 public void addSubject()
{
    // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
try
{
   

    ps=con.prepareStatement("select * from transportboarders where studentid=?");
    ps.setString(1, admissionno.getText());
    rs=ps.executeQuery();
    if(!rs.next())
    {

    ps=con.prepareStatement("insert into transportboarders values(?,?,?,?,?,?)");
    ps.setString(1,admissionno.getText());
    ps.setString(2,stopname.getSelectedItem().toString());
 ps.setString(3,routeno.getText());
    ps.setString(4,busno.getSelectedItem().toString());
 //ps.setString(5,strengthtext.getText());
ps.setString(5,picktext.getText());
ps.setString(6,datum);
         ps.executeUpdate();


        System.out.println("Done");
        //JOptionPane.showMessageDialog(null,"data stored successfully","report",JOptionPane.PLAIN_MESSAGE);
    }
   
         System.out.println("DataBase Conection Closed");
        // oldSubject();
              return;
        }


catch(Exception e)
{
    e.printStackTrace();
    System.out.println("here");
}
    }

    public void updateAuthority()
    {
        int studentclass=0;
        int ledcode=0;
        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
       try
       {
           ps = con.prepareStatement("update transportboarders set stop=?,routeno=?,busno=?,pickpoint=?,date=? where studentid=?");
    ps.setString(1,stopname.getSelectedItem().toString());
 ps.setString(2,routeno.getText());
    ps.setString(3,busno.getSelectedItem().toString());
 //ps.setString(5,strengthtext.getText());
ps.setString(4,picktext.getText());
ps.setString(5,datum);
ps.setString(6,admissionno.getText());

           ps.executeUpdate();

          
            ps=con.prepareStatement("select class from studententry where id=?");
             ps.setString(1,admissionno.getText());
             rs=ps.executeQuery();
             if(rs.next())
                 studentclass=rs.getInt(1);

             ps=con.prepareStatement("select ledgercode from monthlyfeeamounthead where head=? and class=?");
             ps.setInt(1,Integer.parseInt(monthlyfeemap1.get("Transport Fee").toString()));
             ps.setInt(2,studentclass);
             rs=ps.executeQuery();
             if(rs.next())
                 ledcode=rs.getInt(1);

            ps=con.prepareStatement("update feecustomization set amount=?,ledgercode=?,customizationdate=? where studentid=? and head=? and feeheadtype=0");

    //ps.setString(2,"Transport Fee");
    ps.setDouble(1,Double.parseDouble(transportfee.getText()));
   // ps.setString(2,studentclass);
    ps.setInt(2, ledcode);
     ps.setString(3,datum);
    ps.setString(4,admissionno.getText());
    ps.setInt(5,Integer.parseInt(monthlyfeemap1.get("Transport Fee").toString()));
    ps.executeUpdate();
           JOptionPane.showMessageDialog(null,"Student transport Updated successfully","report",JOptionPane.PLAIN_MESSAGE);
       }catch(Exception e)
       {
           e.printStackTrace();
       }
    }
    




    public void removeSubject()
    {
       // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        
        try
        {
         ps=con.prepareStatement("delete from transportboarders where studentid=?");

ps.setString(1,admissionno.getText());
         ps.executeUpdate();

           ps=con.prepareStatement("delete from feecustomization where studentid=? and head=? and feeheadtype=0");

ps.setString(1,admissionno.getText());
ps.setInt(2,Integer.parseInt(monthlyfeemap1.get("Transport Fee").toString()));
         ps.executeUpdate();
         JOptionPane.showMessageDialog(null,"Student Transport Fee removed","report",JOptionPane.PLAIN_MESSAGE);
        //  con.close();
         System.out.println("DataBase Conection Closed");
    }
        catch(Exception e)
        {
            System.err.println("Error"+e);
        }

    }

     public void loadAdmissionNoTable(String id)
 {
     int i=0,j=0;
       //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

       {
   try
   {
        System.out.println("FDF");
       ps=con.prepareStatement("select * from studententry where id like ? or id=?");
       ps.setString(1,id+"%");
         ps.setString(2,id);
       rs=ps.executeQuery();
      // System.out.println("rd1");
        while(rs.next())
            {
                j++;
              //  System.out.println("rd2");
            }
            rs.first();
            rs.previous();
            dm1.setRowCount(j);
            while(rs.next())
            {


                dm1.setValueAt(rs.getString(2), i, 0);
                dm1.setValueAt(rs.getString(1), i, 1);
                jXTable1.removeAll();

              //  System.out.println("rd3");


                i++;
            }


   }catch(Exception e)
   {
e.printStackTrace();
   }
        }
}

     public void setStopName()
     {
        if(stopname.getSelectedIndex()==0)
          return;

     // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
       try
       {
           ps=con.prepareStatement("select * from transportroutestopsetup where stopname=?");
           ps.setString(1,stopname.getSelectedItem().toString());
           rs=ps.executeQuery();
           if(rs.next())
               routeno.setText(rs.getString(1));
           transportfee.setText(String.valueOf(rs.getDouble(3)));


            ps=con.prepareStatement("select busno from transportroutebussetup where routeno=?");
           ps.setString(1,rs.getString(1));
           rs=ps.executeQuery();

           busno.removeAllItems();

          //busno.addItem("choose");

          int i=0;
          while(rs.next())
           {

               busno.addItem(rs.getString(1));

           }
       }catch(Exception e)
       {
           e.printStackTrace();
       }

     }

     public void addTransportFeeIntofeecustomization()
     {
         int studentclass=0;
         int ledcode=0;
         //con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
         try
         {
             ps=con.prepareStatement("select * from feecustomization where studentid=? and head=? and feeheadtype=0");
    ps.setString(1, admissionno.getText());
    ps.setInt(2,Integer.parseInt(monthlyfeemap1.get("Transport Fee").toString()));
    rs=ps.executeQuery();
    if(!rs.next())
    {
             
             ps=con.prepareStatement("select class from studententry where id=?");
             ps.setString(1,admissionno.getText());
             rs=ps.executeQuery();
             if(rs.next())
                 studentclass=rs.getInt(1);

             ps=con.prepareStatement("select ledgercode from monthlyfeeamounthead where head=? and class=?");
             ps.setInt(1,Integer.parseInt(monthlyfeemap1.get("Transport Fee").toString()));
             ps.setInt(2,studentclass);
             rs=ps.executeQuery();
             if(rs.next())
                 ledcode=rs.getInt(1);

         ps=con.prepareStatement("insert into feecustomization values(?,?,?,?,?,?)");
   ps.setString(1,admissionno.getText());
    ps.setInt(2,Integer.parseInt(monthlyfeemap1.get("Transport Fee").toString()));
    ps.setDouble(3,Double.parseDouble(transportfee.getText()));
   // ps.setString(4,studentclass);
    ps.setInt(4, ledcode);
     ps.setInt(5,0);
      ps.setString(6,datum);
    ps.executeUpdate();

     JOptionPane.showMessageDialog(null,"Student Transport Set","report",JOptionPane.PLAIN_MESSAGE);
    }
    else
        JOptionPane.showMessageDialog(null,"Transport Already Set, Press Update for Change","report",JOptionPane.PLAIN_MESSAGE);
         }catch(Exception e)
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
        admissionno = new javax.swing.JTextField();
        stopname = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        routeno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        busno = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        strengthtext = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        picktext = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jXTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        transportfee = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Student Transport Form");

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jButton1.setText("Update  Form");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancel Entry");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextPane3.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane3.setEditable(false);
        jTextPane3.setFont(new java.awt.Font("Tahoma", 0, 18));
        jTextPane3.setText("                                   Transport Form");
        jScrollPane4.setViewportView(jTextPane3);

        jTextPane4.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane4.setEditable(false);
        jTextPane4.setText("Admit student,who avails School transport..if You want to give concession/waiver on Transport fee, do it by customize in fee deposit section..");
        jScrollPane5.setViewportView(jTextPane4);

        jLabel1.setText("Student Id");

        admissionno.setForeground(new java.awt.Color(0, 0, 255));
        admissionno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                admissionnoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                admissionnoKeyTyped(evt);
            }
        });

        stopname.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        stopname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stopnameMouseClicked(evt);
            }
        });
        stopname.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                stopnameItemStateChanged(evt);
            }
        });
        stopname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopnameActionPerformed(evt);
            }
        });

        jLabel2.setText("Stop Name");

        jLabel3.setText("Route No.");

        routeno.setEnabled(false);

        jLabel4.setText("Bus No.");

        busno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        busno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                busnoMouseClicked(evt);
            }
        });
        busno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                busnoItemStateChanged(evt);
            }
        });
        busno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busnoActionPerformed(evt);
            }
        });

        jLabel5.setText("Strength");

        strengthtext.setEnabled(false);

        jLabel6.setText("Pick & Drop Point");

        jXTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jXTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXTable1MouseClicked(evt);
            }
        });
        jXTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jXTable1KeyTyped(evt);
            }
        });
        jScrollPane6.setViewportView(jXTable1);

        jButton2.setText("Submit Form");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setText("Transport Fee");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(transportfee, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(strengthtext)
                    .addComponent(admissionno)
                    .addComponent(routeno, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(stopname, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(busno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(picktext, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(admissionno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(stopname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(routeno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(busno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jButton1))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(picktext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(strengthtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(transportfee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        updateAuthority();       // TODO add your handling code here:
}//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       removeSubject();        // TODO add your handling code here:
}//GEN-LAST:event_jButton3ActionPerformed

    private void stopnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopnameActionPerformed

       
}//GEN-LAST:event_stopnameActionPerformed

    private void busnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busnoActionPerformed
       
}//GEN-LAST:event_busnoActionPerformed

    private void jXTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTable1MouseClicked

      
loadStudentTransportData();

}//GEN-LAST:event_jXTable1MouseClicked

    private void jXTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jXTable1KeyTyped
        // TODO add your handling code here:
}//GEN-LAST:event_jXTable1KeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
addSubject();
addTransportFeeIntofeecustomization();// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void stopnameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_stopnameItemStateChanged


       // setStopName();
         

    }//GEN-LAST:event_stopnameItemStateChanged

    private void busnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_busnoItemStateChanged
      
    }//GEN-LAST:event_busnoItemStateChanged

    private void stopnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopnameMouseClicked
         setStopName();
    }//GEN-LAST:event_stopnameMouseClicked

    private void busnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_busnoMouseClicked
         int count=0;
        //con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
       try
       {
           ps=con.prepareStatement("select * from transportboarders where busno=?");
           ps.setString(1,busno.getSelectedItem().toString());
           rs=ps.executeQuery();
           while(rs.next())
               count++;
           strengthtext.setText(String.valueOf(count));
       }catch(Exception e)
       {
           e.printStackTrace();
       }
    }//GEN-LAST:event_busnoMouseClicked

    private void admissionnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_admissionnoKeyTyped
       int keycode=evt.getID();
        String id;
       if(keycode==KeyEvent.KEY_TYPED)
        {
       if(!admissionno.getText().isEmpty())
       {
        id=admissionno.getText();
        loadAdmissionNoTable(id);
       }
       }
    }//GEN-LAST:event_admissionnoKeyTyped

       private void admissionnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_admissionnoKeyPressed
         int keycode=evt.getKeyCode();
if(keycode==KeyEvent.VK_ENTER)
{
   if(!admissionno.getText().isEmpty())
   {
  
    loadStudentTransportData();
  
   }
}
       }//GEN-LAST:event_admissionnoKeyPressed

  public void loadStudentTransportData()
    {
      int count=0;
      //  con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

        try{


         ps = con.prepareStatement("select * from transportboarders where studentid=?");
         ps.setString(1,admissionno.getText());

             rs = ps.executeQuery();

if(rs.next())
{
    picktext.setText(rs.getString(5).trim());
    
    stopname.setSelectedItem(rs.getString(2).trim());
        routeno.setText(rs.getString(3).trim());
        
        busno.setSelectedItem(rs.getString(4).trim());

          ps=con.prepareStatement("select * from transportboarders where busno=?");
           ps.setString(1,busno.getSelectedItem().toString());
           rs=ps.executeQuery();
           while(rs.next())
               count++;
           strengthtext.setText(String.valueOf(count));
        
}

       // con.close();
             JOptionPane.showMessageDialog(null,"data loaded successfully","report",JOptionPane.PLAIN_MESSAGE);

            System.out.println("DataBase Connection Closed");
}
        catch(Exception e)
        {
            e.printStackTrace();
        }
  }
         public void setAdmissionNo(String id)
{
    admissionno.setText(id);
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField admissionno;
    private javax.swing.JComboBox busno;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextPane jTextPane4;
    private javax.swing.JTable jXTable1;
    private javax.swing.JTextField picktext;
    private javax.swing.JTextField routeno;
    private javax.swing.JComboBox stopname;
    private javax.swing.JTextField strengthtext;
    private javax.swing.JTextField transportfee;
    // End of variables declaration//GEN-END:variables
//Connection con;
ResultSet rs,rs1;
PreparedStatement ps;
}
