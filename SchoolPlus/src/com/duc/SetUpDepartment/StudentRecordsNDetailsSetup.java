/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * StudentRecordsNDetailsSetup.java
 *
 * Created on Jan 9, 2010, 4:05:10 PM
 */

package com.duc.SetUpDepartment;
import java.sql.*;
import static com.duc.DatabaseConnection.DatabaseConnection.*;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Ravi
 */

public class StudentRecordsNDetailsSetup extends javax.swing.JInternalFrame {
DefaultTableModel dmBg,dmC,dmR,dmD,dmCh,dmM,dmH;


    /** Creates new form StudentRecordsNDetailsSetup */
    public StudentRecordsNDetailsSetup() {
        initComponents();
        initComponents();
        pack();

        setLocation(220,200);
        dmBg = (DefaultTableModel)jTableBg.getModel();
        dmBg.setRowCount(0);

        dmC = (DefaultTableModel)jTableC.getModel();
        dmC.setRowCount(0);

        dmR = (DefaultTableModel)jTableR.getModel();
        dmR.setRowCount(0);

        dmM = (DefaultTableModel)jTableM.getModel();
        dmM.setRowCount(0);

        dmCh = (DefaultTableModel)jTableCh.getModel();
        dmCh.setRowCount(0);

        dmD = (DefaultTableModel)jTableD.getModel();
        dmD.setRowCount(0);

        dmH = (DefaultTableModel)jTableH.getModel();
        dmH.setRowCount(0);

         oldBg();
         oldCategory();
         oldChannel();
         oldDisability();
         oldHouse();
         oldMedium();
         oldReligion();
         saveCategoryIntoDb();

    }



    public void saveCategoryIntoDb()
    {
        String a[]={"General","OBC","SC","ST","BC","EBC","Others"};
        try
        {
            ps=con.prepareStatement("select * from categorysetup");
            rs=ps.executeQuery();
            if(rs.next())
            {

            }
            else
            {
                for(int i=0;i<7;i++)
                {
                    ps=con.prepareStatement("insert into categorysetup(categorytitle) values(?)");
                    ps.setString(1,a[i]);
                    ps.executeUpdate();
                }
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void addHouse()
{
    // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
try
{
    // ps = con.prepareStatement("insert into inventorysetup (Inventoryunit,InventoryVendor,Inventorymode,class,unitid,Time) values(?,?,?,?,?,?)");
    ps=con.prepareStatement("insert into schoolhousesetup (schoolhousetitle) values(?)");
    ps.setString(1,categorytitle2.getText());


         ps.executeUpdate();


        System.out.println("Done");
        //JOptionPane.showMessageDialog(null,"data stored successfully","report",JOptionPane.PLAIN_MESSAGE);

//con.close();
         System.out.println("DataBase Conection Closed");
         oldHouse();
              return;
        }


catch(Exception e)
{
    e.printStackTrace();
    System.out.println("here");
}
    }

    private void oldHouse()
    {
        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
       try
       {
           ps = con.prepareStatement("select * from schoolhousesetup ");

           rs = ps.executeQuery();
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
            dmH.setRowCount(j);
            while(rs.next())
            {
                dmH.setValueAt(rs.getString(1), i, 0);
               // dm.setValueAt(rs.getString(2), i, 1);

                i++;
            }
           // con.close();
            System.out.println("Database closed");
             }
       }
       catch(Exception e)
       {
           System.err.println("Error"+e);
       }
    }






    public void removeHouse()
    {
       // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        int row = jTableH.getSelectedRow();
         System.out.println("row no. selected"+row);
        try
        {
         ps=con.prepareStatement("delete from schoolhousesetup  where schoolhousetitle=?");

         ps.setString(1,dmH.getValueAt(row, 0).toString());
         ps.executeUpdate();
         dmH.removeRow(row);
         // con.close();
         System.out.println("DataBase Conection Closed");
    }
        catch(Exception e)
        {
            System.err.println("Error"+e);
        }

    }


public void addBg()
{
    // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
try
{
    // ps = con.prepareStatement("insert into inventorysetup (Inventoryunit,InventoryVendor,Inventorymode,class,unitid,Time) values(?,?,?,?,?,?)");
    ps=con.prepareStatement("insert into bloodgroupsetup (bgtitle) values(?)");
    ps.setString(1,categorytitle.getText());


         ps.executeUpdate();


        System.out.println("Done");
       
         System.out.println("DataBase Conection Closed");
         oldBg();
              return;
        }


catch(Exception e)
{
    e.printStackTrace();
    System.out.println("here");
}
    }

    private void oldBg()
    {
        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
       try
       {
           ps = con.prepareStatement("select * from bloodgroupsetup");

           rs = ps.executeQuery();
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
            dmBg.setRowCount(j);
            while(rs.next())
            {
                dmBg.setValueAt(rs.getString(1), i, 0);
               // dm.setValueAt(rs.getString(2), i, 1);

                i++;
            }
             }
           // con.close();
            System.out.println("Database closed");

       }
       catch(Exception e)
       {
           System.err.println("Error"+e);
       }
    }






    public void removeBg()
    {
        //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        int row = jTableBg.getSelectedRow();
         System.out.println("row no. selected"+row);
        try
        {
         ps=con.prepareStatement("delete from bloodgroupsetup where bgtitle=?");

         ps.setString(1,dmBg.getValueAt(row, 0).toString());
         ps.executeUpdate();
         dmBg.removeRow(row);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBg = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPane4 = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        categorytitle = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableC = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextPane5 = new javax.swing.JTextPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextPane6 = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        categorytitle1 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTableCh = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTextPane9 = new javax.swing.JTextPane();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTextPane10 = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        categorytitle3 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTableD = new javax.swing.JTable();
        jButton13 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTextPane11 = new javax.swing.JTextPane();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTextPane12 = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        categorytitle4 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTableM = new javax.swing.JTable();
        jButton16 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jScrollPane17 = new javax.swing.JScrollPane();
        jTextPane13 = new javax.swing.JTextPane();
        jScrollPane18 = new javax.swing.JScrollPane();
        jTextPane14 = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();
        categorytitle5 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane19 = new javax.swing.JScrollPane();
        jTableR = new javax.swing.JTable();
        jButton19 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jScrollPane20 = new javax.swing.JScrollPane();
        jTextPane15 = new javax.swing.JTextPane();
        jScrollPane21 = new javax.swing.JScrollPane();
        jTextPane16 = new javax.swing.JTextPane();
        jLabel7 = new javax.swing.JLabel();
        religiontitle = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableH = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextPane7 = new javax.swing.JTextPane();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextPane8 = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        categorytitle2 = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Add Student Setups");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jTableBg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "                                            BloodGroup Title"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableBg);

        jButton1.setText("Add BloodGroup");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("Delete BloodGroup");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextPane3.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane3.setEditable(false);
        jTextPane3.setFont(new java.awt.Font("Tahoma", 0, 18));
        jTextPane3.setText("                    BloodGroup Title");
        jScrollPane4.setViewportView(jTextPane3);

        jTextPane4.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane4.setEditable(false);
        jTextPane4.setText("Add the bloodgroups of students");
        jScrollPane5.setViewportView(jTextPane4);

        jLabel1.setText("Bloodgroup");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(categorytitle, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(225, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(categorytitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Blood Group Setup", jPanel1);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jTableC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "                                            Category Title"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableC);

        jButton2.setText("Add Category");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton6.setText("Delete category");
        jButton6.setEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTextPane5.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane5.setEditable(false);
        jTextPane5.setFont(new java.awt.Font("Tahoma", 0, 18));
        jTextPane5.setText("                      Add Category");
        jScrollPane6.setViewportView(jTextPane5);

        jTextPane6.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane6.setEditable(false);
        jTextPane6.setText("Add category according to Institute's  as on the basis of cast, governments rules or any other specfic rule.(SC,ST,OBC,EBC,Others,General)");
        jScrollPane7.setViewportView(jTextPane6);

        jLabel2.setText("Category Title");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addContainerGap())
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(categorytitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(211, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(categorytitle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Category Setup", jPanel2);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jTableCh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "                                      Admission Channel Title"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane10.setViewportView(jTableCh);

        jButton10.setText("Add Channel");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton12.setText("Delete Channel");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jTextPane9.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane9.setEditable(false);
        jTextPane9.setFont(new java.awt.Font("Tahoma", 0, 18));
        jTextPane9.setText("                      Add Channel");
        jScrollPane11.setViewportView(jTextPane9);

        jTextPane10.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane10.setEditable(false);
        jTextPane10.setText("Set the way of intake of students in your institute");
        jScrollPane12.setViewportView(jTextPane10);

        jLabel4.setText("Admission Channel Title");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                .addComponent(jButton12)
                .addContainerGap())
            .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
            .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(categorytitle3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(categorytitle3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10)
                    .addComponent(jButton12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Channel Setup", jPanel4);

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jTableD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "                                           Disability Title"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane13.setViewportView(jTableD);

        jButton13.setText("Add Disability");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton15.setText("Delete Disability");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jTextPane11.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane11.setEditable(false);
        jTextPane11.setFont(new java.awt.Font("Tahoma", 0, 18));
        jTextPane11.setText("                      Add Disability");
        jScrollPane14.setViewportView(jTextPane11);

        jTextPane12.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane12.setEditable(false);
        jTextPane12.setText("Add your institute medium of instruction..");
        jScrollPane15.setViewportView(jTextPane12);

        jLabel5.setText("Disability Title");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                .addComponent(jButton15)
                .addContainerGap())
            .addComponent(jScrollPane14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
            .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(categorytitle4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(214, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(categorytitle4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13)
                    .addComponent(jButton15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Disability Setup", jPanel5);

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));

        jTableM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "                                          Medium Title"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane16.setViewportView(jTableM);

        jButton16.setText("Add Medium");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton18.setText("Delete Medium");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jTextPane13.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane13.setEditable(false);
        jTextPane13.setFont(new java.awt.Font("Tahoma", 0, 18));
        jTextPane13.setText("                      Add Medium Of Instruction");
        jScrollPane17.setViewportView(jTextPane13);

        jTextPane14.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane14.setEditable(false);
        jTextPane14.setText("Add your school medium..");
        jScrollPane18.setViewportView(jTextPane14);

        jLabel6.setText("MediumTitle");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
                .addComponent(jButton18)
                .addContainerGap())
            .addComponent(jScrollPane17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
            .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(categorytitle5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(223, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(categorytitle5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton16)
                    .addComponent(jButton18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Medium Setup", jPanel6);

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));

        jTableR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "                                          Religion Title"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane19.setViewportView(jTableR);

        jButton19.setText("Add Religion");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton21.setText("Delete Religion");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jTextPane15.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane15.setEditable(false);
        jTextPane15.setFont(new java.awt.Font("Tahoma", 0, 18));
        jTextPane15.setText("                      Add Religion");
        jScrollPane20.setViewportView(jTextPane15);

        jTextPane16.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane16.setEditable(false);
        jTextPane16.setText("Add Religion..");
        jScrollPane21.setViewportView(jTextPane16);

        jLabel7.setText("Religion Title");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                .addComponent(jButton21)
                .addContainerGap())
            .addComponent(jScrollPane20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(religiontitle, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(219, Short.MAX_VALUE))
            .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(religiontitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton19)
                    .addComponent(jButton21))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Religion Setup", jPanel7);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jTableH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "                                            HouseTitle"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTableH);

        jButton7.setText("Add House");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton9.setText("Delete House");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jTextPane7.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane7.setEditable(false);
        jTextPane7.setFont(new java.awt.Font("Tahoma", 0, 18));
        jTextPane7.setText("                      Add School Houses");
        jScrollPane8.setViewportView(jTextPane7);

        jTextPane8.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane8.setEditable(false);
        jTextPane8.setText("Create Internal Institute Houses for different occassions.");
        jScrollPane9.setViewportView(jTextPane8);

        jLabel3.setText("Category Title");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
                .addComponent(jButton9)
                .addContainerGap())
            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(categorytitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(211, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(categorytitle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("House Setup", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 428, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        removeBg();      // TODO add your handling code here:
}//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        addBg();        // TODO add your handling code here:
}//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        addCategory();        // TODO add your handling code here:
}//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        removeCategory();      // TODO add your handling code here:
}//GEN-LAST:event_jButton6ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        addChannel();        // TODO add your handling code here:
}//GEN-LAST:event_jButton10ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        removeChannel();      // TODO add your handling code here:
}//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        addDisability();        // TODO add your handling code here:
}//GEN-LAST:event_jButton13ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        removeDisability();      // TODO add your handling code here:
}//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        addMedium();        // TODO add your handling code here:
}//GEN-LAST:event_jButton16ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        removeMedium();      // TODO add your handling code here:
}//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        addReligion();        // TODO add your handling code here:
}//GEN-LAST:event_jButton19ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        removeReligion();      // TODO add your handling code here:
}//GEN-LAST:event_jButton21ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        addHouse();        // TODO add your handling code here:
}//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        removeHouse();      // TODO add your handling code here:
}//GEN-LAST:event_jButton9ActionPerformed

    public void addChannel()
{
    // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
try
{
    // ps = con.prepareStatement("insert into inventorysetup (Inventoryunit,InventoryVendor,Inventorymode,class,unitid,Time) values(?,?,?,?,?,?)");
    ps=con.prepareStatement("insert into admissionchannelsetup (channeltitle) values(?)");
    ps.setString(1,categorytitle3.getText());


         ps.executeUpdate();


        System.out.println("Done");
        //JOptionPane.showMessageDialog(null,"data stored successfully","report",JOptionPane.PLAIN_MESSAGE);

//con.close();
         System.out.println("DataBase Conection Closed");
         oldChannel();
              return;
        }


catch(Exception e)
{
    e.printStackTrace();
    System.out.println("here");
}
    }

    private void oldChannel()
    {
        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
       try
       {
           ps = con.prepareStatement("select * from admissionchannelsetup");

           rs = ps.executeQuery();
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
            dmCh.setRowCount(j);
            while(rs.next())
            {
                dmCh.setValueAt(rs.getString(1), i, 0);
               // dm.setValueAt(rs.getString(2), i, 1);

                i++;
            }
           // con.close();
            System.out.println("Database closed");
             }
       }
       catch(Exception e)
       {
           System.err.println("Error"+e);
       }
    }






    public void removeChannel()
    {
       // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        int row = jTableCh.getSelectedRow();
         System.out.println("row no. selected"+row);
        try
        {
         ps=con.prepareStatement("delete from admissionchannelsetup where channeltitle=?");

         ps.setString(1,dmCh.getValueAt(row, 0).toString());
         ps.executeUpdate();
         dmCh.removeRow(row);
         // con.close();
         System.out.println("DataBase Conection Closed");
    }
        catch(Exception e)
        {
            System.err.println("Error"+e);
        }

    }

    public void addReligion()
{
    // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
try
{
    // ps = con.prepareStatement("insert into inventorysetup (Inventoryunit,InventoryVendor,Inventorymode,class,unitid,Time) values(?,?,?,?,?,?)");
    ps=con.prepareStatement("insert into religionsetup (religiontitle) values(?)");
    ps.setString(1,religiontitle.getText());



         ps.executeUpdate();


        System.out.println("Done");
        //JOptionPane.showMessageDialog(null,"data stored successfully","report",JOptionPane.PLAIN_MESSAGE);

//con.close();
         System.out.println("DataBase Conection Closed");
         oldReligion();
              return;
        }


catch(Exception e)
{
    e.printStackTrace();
    System.out.println("here");
}
    }

    private void oldReligion()
    {
        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
       try
       {
           ps = con.prepareStatement("select * from religionsetup");

           rs = ps.executeQuery();
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
            dmR.setRowCount(j);
            while(rs.next())
            {
                dmR.setValueAt(rs.getString(1), i, 0);
                //dm.setValueAt(rs.getString(2), i, 1);

                i++;
            }
             }
           // con.close();
            System.out.println("Database closed");

       }
       catch(Exception e)
       {
           System.err.println("Error"+e);
       }
    }






    public void removeReligion()
    {
       // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        int row = jTableR.getSelectedRow();
         System.out.println("row no. selected"+row);
        try
        {
         ps=con.prepareStatement("delete from religionsetup where religiontitle=?");

         ps.setString(1,dmR.getValueAt(row, 0).toString());
         ps.executeUpdate();
         dmR.removeRow(row);
        //  con.close();
         System.out.println("DataBase Conection Closed");
    }
        catch(Exception e)
        {
            System.err.println("Error"+e);
        }

    }


public void addMedium()
{
    // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
try
{
    // ps = con.prepareStatement("insert into inventorysetup (Inventoryunit,InventoryVendor,Inventorymode,class,unitid,Time) values(?,?,?,?,?,?)");
    ps=con.prepareStatement("insert into mediumofinstructionsetup (instructiontitle) values(?)");
    ps.setString(1,categorytitle5.getText());


         ps.executeUpdate();


        System.out.println("Done");
        //JOptionPane.showMessageDialog(null,"data stored successfully","report",JOptionPane.PLAIN_MESSAGE);

//con.close();
         System.out.println("DataBase Conection Closed");
         oldMedium();
              return;
        }


catch(Exception e)
{
    e.printStackTrace();
    System.out.println("here");
}
    }

    private void oldMedium()
    {
      //   con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
       try
       {
           ps = con.prepareStatement("select * from mediumofinstructionsetup");

           rs = ps.executeQuery();
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
            dmM.setRowCount(j);
            while(rs.next())
            {
                dmM.setValueAt(rs.getString(1), i, 0);
               // dm.setValueAt(rs.getString(2), i, 1);

                i++;
            }
             }
          //  con.close();
            System.out.println("Database closed");

       }
       catch(Exception e)
       {
           System.err.println("Error"+e);
       }
    }






    public void removeMedium()
    {
       // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        int row = jTableM.getSelectedRow();
         System.out.println("row no. selected"+row);
        try
        {
         ps=con.prepareStatement("delete from mediumofinstructionsetup where instructiontitle=?");

         ps.setString(1,dmM.getValueAt(row, 0).toString());
         ps.executeUpdate();
         dmM.removeRow(row);
         // con.close();
         System.out.println("DataBase Conection Closed");
    }
        catch(Exception e)
        {
            System.err.println("Error"+e);
        }

    }




    public void addDisability()
{
    // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
try
{
    // ps = con.prepareStatement("insert into inventorysetup (Inventoryunit,InventoryVendor,Inventorymode,class,unitid,Time) values(?,?,?,?,?,?)");
    ps=con.prepareStatement("insert into disabilitysetup (disabilitytitle) values(?)");
    ps.setString(1,categorytitle4.getText());


         ps.executeUpdate();


        System.out.println("Done");
        //JOptionPane.showMessageDialog(null,"data stored successfully","report",JOptionPane.PLAIN_MESSAGE);

//con.close();
         System.out.println("DataBase Conection Closed");
         oldDisability();
              return;
        }


catch(Exception e)
{
    e.printStackTrace();
    System.out.println("here");
}
    }

    private void oldDisability()
    {
      //   con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
       try
       {
           ps = con.prepareStatement("select * from disabilitysetup");

           rs = ps.executeQuery();
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
            dmD.setRowCount(j);
            while(rs.next())
            {
                dmD.setValueAt(rs.getString(1), i, 0);
               // dm.setValueAt(rs.getString(2), i, 1);

                i++;
            }
             }
         //   con.close();
            System.out.println("Database closed");

       }
       catch(Exception e)
       {
           System.err.println("Error"+e);
       }
    }






    public void removeDisability()
    {
       // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        int row = jTableD.getSelectedRow();
         System.out.println("row no. selected"+row);
        try
        {
         ps=con.prepareStatement("delete from disabilitysetup where disabilitytitle=?");

         ps.setString(1,dmD.getValueAt(row, 0).toString());
         ps.executeUpdate();
         dmD.removeRow(row);
        //  con.close();
         System.out.println("DataBase Conection Closed");
    }
        catch(Exception e)
        {
            System.err.println("Error"+e);
        }

    }



public void addCategory()
{
     //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
try
{
    int id=0;
  /*  ps=con.prepareStatement("select max(categoryid) from categorysetup");
    rs=ps.executeQuery();
    if(rs.next())
    id=Integer.parseInt(rs.getString(1));
    id++;*/
    // ps = con.prepareStatement("insert into inventorysetup (Inventoryunit,InventoryVendor,Inventorymode,class,unitid,Time) values(?,?,?,?,?,?)");
   for(int i=0;i<dmC.getRowCount();i++)
   {
    ps=con.prepareStatement("insert into categorysetup (categorytitle) values(?)");
    ps.setString(1,"tt");

//ps.setString(2,String.valueOf(id));

         ps.executeUpdate();

   }
        System.out.println("Done");
        //JOptionPane.showMessageDialog(null,"data stored successfully","report",JOptionPane.PLAIN_MESSAGE);

//con.close();
         System.out.println("DataBase Conection Closed");
         //oldCategory();
//              return;
        }


catch(Exception e)
{
    e.printStackTrace();
    System.out.println("here");
}
    }

    private void oldCategory()
    {
         //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
       try
       {
           ps = con.prepareStatement("select * from categorysetup");

           rs = ps.executeQuery();
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
            dmC.setRowCount(j);
            while(rs.next())
            {
                dmC.setValueAt(rs.getString(1), i, 0);
               // dm.setValueAt(rs.getString(2), i, 1);

                i++;
            }
            }
          //  con.close();
            System.out.println("Database closed");

       }
       catch(Exception e)
       {
           System.err.println("Error"+e);
       }
    }






    public void removeCategory()
    {
       // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        int row = jTableC.getSelectedRow();
         System.out.println("row no. selected"+row);
        try
        {
         ps=con.prepareStatement("delete from categorysetup where categorytitle=?");

         ps.setString(1,dmC.getValueAt(row, 0).toString());
         ps.executeUpdate();
         dmC.removeRow(row);
        //  con.close();
         System.out.println("DataBase Conection Closed");
    }
        catch(Exception e)
        {
            System.err.println("Error"+e);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField categorytitle;
    private javax.swing.JTextField categorytitle1;
    private javax.swing.JTextField categorytitle2;
    private javax.swing.JTextField categorytitle3;
    private javax.swing.JTextField categorytitle4;
    private javax.swing.JTextField categorytitle5;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableBg;
    private javax.swing.JTable jTableC;
    private javax.swing.JTable jTableCh;
    private javax.swing.JTable jTableD;
    private javax.swing.JTable jTableH;
    private javax.swing.JTable jTableM;
    private javax.swing.JTable jTableR;
    private javax.swing.JTextPane jTextPane10;
    private javax.swing.JTextPane jTextPane11;
    private javax.swing.JTextPane jTextPane12;
    private javax.swing.JTextPane jTextPane13;
    private javax.swing.JTextPane jTextPane14;
    private javax.swing.JTextPane jTextPane15;
    private javax.swing.JTextPane jTextPane16;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextPane jTextPane4;
    private javax.swing.JTextPane jTextPane5;
    private javax.swing.JTextPane jTextPane6;
    private javax.swing.JTextPane jTextPane7;
    private javax.swing.JTextPane jTextPane8;
    private javax.swing.JTextPane jTextPane9;
    private javax.swing.JTextField religiontitle;
    // End of variables declaration//GEN-END:variables
ResultSet rs;
PreparedStatement ps;
}
