/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FeeHeadSetup.java
 *
 * Created on Dec 1, 2009, 3:01:48 PM
 */

package com.duc.FeeDepartment;
import javax.swing.table.DefaultTableModel;
import java.sql.*;


import java.util.HashMap;
import javax.swing.JOptionPane;
import static com.duc.DatabaseConnection.DatabaseConnection.*;
/**
 *
 * @author Ravi
 */
public class FeeHeadSetup extends javax.swing.JInternalFrame {
DefaultTableModel dm1,dm2,dm3;
DefaultTableModel dmA1,dmA2,dmA3;
//MapForIndex mp=new MapForIndex();

HashMap classmap=mp.getClassIndexName();
 HashMap classmap1=mp.getClassIndexFromName();
  HashMap Aheadmap1=mp.getAdmissionFeeIndexFromName();
   HashMap Aheadmap=mp.getAdmissionFeeIndexToName();
   HashMap Mheadmap1=mp.getMonthlyFeeIndexFromName();
   HashMap Mheadmap=mp.getMonthlyFeeIndexToName();
   HashMap Pheadmap1=mp.getPeriodicFeeIndexFromName();
   HashMap Pheadmap=mp.getPeriodicFeeIndexToName();
    /** Creates new form FeeHeadSetup */
    public FeeHeadSetup() {
        initComponents();
        // con= com.duc.DatabaseConnection.DatabaseConnection.con;
        System.out.println("con of feeheadsetup="+con);
        pack();
        //this.setLocationRelativeTo(null);
          dm1 = (DefaultTableModel)jTable1.getModel();
        dm1.setRowCount(0);

         dm2 = (DefaultTableModel)jTable3.getModel();
        dm2.setRowCount(0);

        dm3 = (DefaultTableModel)jTable5.getModel();
        dm3.setRowCount(0);

         dmA1 = (DefaultTableModel)jTable2.getModel();
        dmA1.setRowCount(0);
        fromClass();
       // fromAdmissionFeeHead(); fee heads loaded for feeamout

        dmA2 = (DefaultTableModel)jTable4.getModel();
        dmA2.setRowCount(0);
       // fromMClass();
        //fromMonthlyFeeHead();

        dmA3 = (DefaultTableModel)jTable6.getModel();
        dmA3.setRowCount(0);
       // fromPClass();
       // fromPAdmissionFeeHead();

       oldMFeeHead();
       oldAFeeHead();
       oldPFeeHead();
    }

    public int admissonFeeHeadDelete(String head)
    {
        
        try
        {
            ps=con.prepareStatement("select * from admissionfeeamounthead left join admissionfeehead on `admissionfeeamounthead`.head=feeid where admissionfeehead.head=?");
            ps.setString(1, head);
            rs=ps.executeQuery();
            if(!rs.next())
            {
                 ps=con.prepareStatement("select * from feedues left join admissionfeehead on `feedues`.head=feeid where admissionfeehead.head=? and feetype=1");
            ps.setString(1, head);
            rs=ps.executeQuery();
            if(!rs.next())
            {
                ps=con.prepareStatement("select * from feeremoved left join admissionfeehead on `feeremoved`.head=feeid where admissionfeehead.head=? and feetype=1");
            ps.setString(1, head);
            rs=ps.executeQuery();
            if(!rs.next())
            {
                ps=con.prepareStatement("select * from feecustomization left join admissionfeehead on `feecustomization`.head=feeid where admissionfeehead.head=? and feeheadtype=1");
            ps.setString(1, head);
            rs=ps.executeQuery();
            if(!rs.next())
            {
                ps=con.prepareStatement("select * from feepaid left join admissionfeehead on `feepaid`.head=feeid where admissionfeehead.head=? and feetype=1");
            ps.setString(1, head);
            rs=ps.executeQuery();
            if(!rs.next())

            {
                ps=con.prepareStatement("select * from payreceiptinfo left join admissionfeehead on `payreceiptinfo`.feehead=feeid where admissionfeehead.head=? and feetype=1");
            ps.setString(1, head);
            rs=ps.executeQuery();
            if(!rs.next())
            {
                return 1;
            }
            else
                JOptionPane.showConfirmDialog(null,"Fee is present in Payreceiptinfo","Payment Receipt Present",JOptionPane.OK_OPTION);

            }
            else
                JOptionPane.showConfirmDialog(null,"Fee is present in Fee Paid","Fee paid",JOptionPane.OK_OPTION);

            }
            else
                JOptionPane.showConfirmDialog(null,"Fee is present in Fee Customization","Fee Customization",JOptionPane.OK_OPTION);

            }
            else
                JOptionPane.showConfirmDialog(null,"Fee is present in Fee removed","Fee removed",JOptionPane.OK_OPTION);


            }
            else
            {
               int choose= JOptionPane.showConfirmDialog(null,"In Fee Dues","In Fee Dues",JOptionPane.OK_OPTION);
            }


            }
            else
            {
                int choose=JOptionPane.showConfirmDialog(null,"Amount is set","Amount Set",JOptionPane.OK_OPTION);
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return 0;
    }

    public int monthlyFeeHeadDelete(String head)
    {
 
        try
        {
            ps=con.prepareStatement("select * from monthlyfeeamounthead left join monthlyfeehead on `monthlyfeeamounthead`.head=feeid where monthlyfeehead.head=?");
            ps.setString(1,head);

            rs=ps.executeQuery();
            if(!rs.next())
            {
            ps=con.prepareStatement("select * from feedues left join monthlyfeehead on `feedues`.head=feeid where monthlyfeehead.head=? and feetype=0");
            ps.setString(1,head);
            rs=ps.executeQuery();

            if(!rs.next())
            {
            ps=con.prepareStatement("select * from feeremoved left join monthlyfeehead on `feeremoved`.head=feeid where monthlyfeehead.head=? and feetype=0");
            ps.setString(1,head);
            rs=ps.executeQuery();
            if(!rs.next())
            {
                ps=con.prepareStatement("select * from feecustomization left join monthlyfeehead on `feecustomization`.head=feeid where monthlyfeehead.head=? and feeheadtype=0");
            ps.setString(1, head);
            rs=ps.executeQuery();
            if(!rs.next())
            {
                ps=con.prepareStatement("select * from feepaid left join monthlyfeehead on `feepaid`.head=feeid where monthlyfeehead.head=? and feetype=0");
            ps.setString(1, head);
            rs=ps.executeQuery();
            if(!rs.next())

            {
                ps=con.prepareStatement("select * from payreceiptinfo left join monthlyfeehead on `payreceiptinfo`.feehead=feeid where monthlyfeehead.head=? and feetype=0");
            ps.setString(1, head);
            rs=ps.executeQuery();
            if(!rs.next())
            {
                return 1;
            }
            else
                JOptionPane.showConfirmDialog(null,"Fee is present in Payreceiptinfo","Payment Receipt Present",JOptionPane.OK_OPTION);

            }
            else
                JOptionPane.showConfirmDialog(null,"Fee is present in Fee Paid","Fee paid",JOptionPane.OK_OPTION);

            }
            else
                JOptionPane.showConfirmDialog(null,"Fee is present in Fee Customization","Fee Customization",JOptionPane.OK_OPTION);

            }
            else
                JOptionPane.showConfirmDialog(null,"Fee is present Fee removed","Fee removed",JOptionPane.OK_OPTION);


            }
            else JOptionPane.showConfirmDialog(null,"In Fee Dues","In Fee Dues",JOptionPane.OK_OPTION);


            }
            else
                JOptionPane.showConfirmDialog(null,"Amount is set","Amount Set",JOptionPane.OK_OPTION);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return 0;
    }

     public int periodicFeeHeadDelete(String head)
     {
 
        try
        {
            ps=con.prepareStatement("select * from periodicfeeamounthead left join periodicfeehead on `periodicfeeamounthead`.head=feeid where periodicfeehead.head=?");
            ps.setString(1, head);
            rs=ps.executeQuery();
            if(!rs.next())
            {
                 ps=con.prepareStatement("select * from feedues left join periodicfeehead on `feedues`.head=feeid where periodicfeehead.head=? and feetype=2");
            ps.setString(1, head);
            rs=ps.executeQuery();
            if(!rs.next())
            {
                ps=con.prepareStatement("select * from feeremoved left join periodicfeehead on `feeremoved`.head=feeid where periodicfeehead.head=? and feetype=2");
            ps.setString(1, head);
            rs=ps.executeQuery();
            if(!rs.next())
            {
                ps=con.prepareStatement("select * from feecustomization left join periodicfeehead on `feecustomization`.head=feeid where periodicfeehead.head=? and feeheadtype=2");
            ps.setString(1, head);
            rs=ps.executeQuery();
            if(!rs.next())
            {
                ps=con.prepareStatement("select * from feepaid left join periodicfeehead on `feepaid`.head=feeid where periodicfeehead.head=? and feetype=2");
            ps.setString(1, head);
            rs=ps.executeQuery();
            if(!rs.next())

            {
                ps=con.prepareStatement("select * from payreceiptinfo left join periodicfeehead on `payreceiptinfo`.feehead=feeid where periodicfeehead.head=? and feetype=2");
            ps.setString(1, head);
            rs=ps.executeQuery();
            if(!rs.next())
            {
                return 1;
            }
            else
                JOptionPane.showConfirmDialog(null,"Fee is present in Payreceiptinfo","Payment Receipt Present",JOptionPane.OK_OPTION);

            }
            else
                JOptionPane.showConfirmDialog(null,"Fee is present in Fee Paid","Fee paid",JOptionPane.OK_OPTION);

            }
            else
                JOptionPane.showConfirmDialog(null,"Fee is present in Fee Customization","Fee Customization",JOptionPane.OK_OPTION);

            }
            else
                JOptionPane.showConfirmDialog(null,"Fee is present Fee removed","Fee removed",JOptionPane.OK_OPTION);


            }
            else JOptionPane.showConfirmDialog(null,"In Fee Dues","In Fee Dues",JOptionPane.OK_OPTION);


            }
            else
                JOptionPane.showConfirmDialog(null,"Amount is set","Amount Set",JOptionPane.OK_OPTION);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return 0;
     }
public void addAFeeHead()
{
   //  con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
try
{
    // ps = con.prepareStatement("in sert into inventorysetup (Inventoryunit,InventoryVendor,Inventorymode,class,unitid,Time) values(?,?,?,?,?,?)");
    ps=con.prepareStatement("select * from admissionfeehead where head=?");
     ps.setString(1,classtitle.getText());
     rs=ps.executeQuery();
     if(rs.next())
         JOptionPane.showConfirmDialog(null,"Fee-Head with same name already exists","Fee-Head Exists",JOptionPane.OK_OPTION);
   
     else
     {
         if(classtitle.getText().isEmpty())
          JOptionPane.showConfirmDialog(null,"Fee-Head Empty","Fee-Head Empty",JOptionPane.OK_OPTION);
         else
         {
         ps=con.prepareStatement("insert into admissionfeehead(head) values(?)");

    ps.setString(1,classtitle.getText());



         ps.executeUpdate();


        System.out.println("Done");
         }
     }
        //JOptionPane.showMessageDialog(null,"data stored successfully","report",JOptionPane.PLAIN_MESSAGE);

//
         System.out.println("DataBase Conection Closed");
         oldAFeeHead();
              return;
        }


catch(Exception e)
{
    e.printStackTrace();
    System.out.println("here");
}
    }

    private void oldAFeeHead()
    {
      //   con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
       try
       {
           ps = con.prepareStatement("select * from admissionfeehead");

           rs = ps.executeQuery();
            int i = 0,j=0;
          while(rs.next())
            {
                j++;
            }
            rs.first();
            rs.previous();
            dm1.setRowCount(j);
            while(rs.next())
            {
                dm1.setValueAt(rs.getString(2), i, 0);
               dm1.setValueAt(rs.getInt(1), i, 1);
dm1.setValueAt(rs.getInt(3), i, 2);
                i++;
            }
            //
            System.out.println("Database open");

       }
       catch(Exception e)
       {
           System.err.println("Error"+e);
       }
    }






    public void removeAFeeHead()
    {
       // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        int row = jTable1.getSelectedRow();
         System.out.println("row no. selected"+row);
        try
        {
            if(Integer.parseInt(dm1.getValueAt(row,2).toString())!=0)
            {
            int i=admissonFeeHeadDelete(dm1.getValueAt(row, 0).toString());
            if(i==1)
            {
                int select=JOptionPane.showConfirmDialog(null,"No record for this fee head is found inside the software, so you can safely remove this","Safe remove",JOptionPane.OK_OPTION);
           if(select==JOptionPane.OK_OPTION)
           {
                ps=con.prepareStatement("delete from admissionfeehead where head=?");

         ps.setString(1,dm1.getValueAt(row, 0).toString());
         ps.executeUpdate();
         //dm1.removeRow(row);
         oldAFeeHead();
           }
            }else{
                    int choose=JOptionPane.showConfirmDialog(null,"Its record is present,Do you really want to delete this","Fee Head Delete",JOptionPane.OK_OPTION);
         if(choose==JOptionPane.OK_OPTION)
         {
                ps=con.prepareStatement("update admissionfeehead set status=0 where head=?");

         ps.setString(1,dm1.getValueAt(row, 0).toString());
         ps.executeUpdate();
        // dm1.removeRow(row);
         oldAFeeHead();
         System.out.println("no safe delete");
            }
        }
         //
         System.out.println("DataBase Conection Closed");

            }
            else
            {
                 ps=con.prepareStatement("update admissionfeehead set status=1 where head=?");

         ps.setString(1,dm1.getValueAt(row, 0).toString());
         ps.executeUpdate();
         oldAFeeHead();
            }

        }
        catch(Exception e)
        {
            System.err.println("Error"+e);
        }

    }

    public void addMFeeHead()
{
    // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
try
{
    // ps = con.prepareStatement("insert into inventorysetup (Inventoryunit,InventoryVendor,Inventorymode,class,unitid,Time) values(?,?,?,?,?,?)");
    ps=con.prepareStatement("select * from monthlyfeehead where head=?");
     ps.setString(1,classtitle2.getText());
     rs=ps.executeQuery();
     if(rs.next())
         JOptionPane.showConfirmDialog(null,"Fee-Head with same name already exists","Fee-Head Exists",JOptionPane.OK_OPTION);
   
     else
     {
         if(classtitle2.getText().isEmpty())
          JOptionPane.showConfirmDialog(null,"Fee-Head Empty","Fee-Head Empty",JOptionPane.OK_OPTION);
         else
         {
    ps=con.prepareStatement("insert into monthlyfeehead(head) values(?)");
    ps.setString(1,classtitle2.getText());



         ps.executeUpdate();


        System.out.println("Done");
        //JOptionPane.showMessageDialog(null,"data stored successfully","report",JOptionPane.PLAIN_MESSAGE);
         }
     }
//
         System.out.println("DataBase ");
         oldMFeeHead();
              return;
        }


catch(Exception e)
{
    e.printStackTrace();
    System.out.println("here");
}
    }

    private void oldMFeeHead()
    {
        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
       try
       {
           ps = con.prepareStatement("select * from monthlyfeehead");

           rs = ps.executeQuery();
            int i = 0,j=0;
          while(rs.next())
            {
                j++;
            }
            rs.first();
            rs.previous();
            dm2.setRowCount(j);
            while(rs.next())
            {
                dm2.setValueAt(rs.getString(2), i, 0);
                dm2.setValueAt(rs.getInt(1), i, 1);
dm2.setValueAt(rs.getInt(3), i, 2);
                i++;
            }
            //
            System.out.println("Database open");

       }
       catch(Exception e)
       {
           System.err.println("Error"+e);
       }
    }






    public void removeMFeeHead()
    {
       // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        int row = jTable3.getSelectedRow();
         System.out.println("row no. selected"+row);
        try
        {
            if(Integer.parseInt(dm2.getValueAt(row,2).toString())!=0)
            {
            int i=monthlyFeeHeadDelete(dm2.getValueAt(row, 0).toString());
             if(i==1)
            {
                int select=JOptionPane.showConfirmDialog(null,"No record for this fee head is found inside the software, so you can safely remove this","Safe remove",JOptionPane.OK_OPTION);
           if(select==JOptionPane.OK_OPTION)
           {
                ps=con.prepareStatement("delete from monthlyfeehead where head=?");

         ps.setString(1,dm2.getValueAt(row, 0).toString());
         ps.executeUpdate();
        // dm2.removeRow(row);
         oldMFeeHead();
           }
            }else{
                    int choose=JOptionPane.showConfirmDialog(null,"Its record is present,Do you really want to delete this","Fee Head Delete",JOptionPane.OK_OPTION);
         if(choose==JOptionPane.OK_OPTION)
         {
                ps=con.prepareStatement("update monthlyfeehead set status=0 where head=?");

         ps.setString(1,dm2.getValueAt(row, 0).toString());
         ps.executeUpdate();
         //dm2.removeRow(row);
         oldMFeeHead();
         System.out.println("no safe delete");
            }
        }
         //
         System.out.println("DataBase Conection Closed");

            }
            else
            {
                ps=con.prepareStatement("update monthlyfeehead set status=1 where head=?");


         ps.setString(1,dm2.getValueAt(row, 0).toString());
         ps.executeUpdate();
         oldMFeeHead();
        }
        }catch(Exception e)
        {
            System.err.println("Error"+e);
        }

    }

    public void addPFeeHead()
{
    // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
try
{
    // ps = con.prepareStatement("insert into inventorysetup (Inventoryunit,InventoryVendor,Inventorymode,class,unitid,Time) values(?,?,?,?,?,?)");
  ps=con.prepareStatement("select * from periodicfeehead where head=?");
     ps.setString(1,classtitle4.getText());
     rs=ps.executeQuery();
     if(rs.next())
         JOptionPane.showConfirmDialog(null,"Fee-Head with same name already exists","Fee-Head Exists",JOptionPane.OK_OPTION);
   
     else
     {
         if(classtitle4.getText().isEmpty())
          JOptionPane.showConfirmDialog(null,"Fee-Head Empty","Fee-Head Empty",JOptionPane.OK_OPTION);
         else
         {
    ps=con.prepareStatement("insert into periodicfeehead(head,annualstatus) values(?,?)");
    ps.setString(1,classtitle4.getText());
if(jCheckBox1.isSelected())
    ps.setInt(2,1);
else
    ps.setInt(2,0);


         ps.executeUpdate();


        System.out.println("Done");
        //JOptionPane.showMessageDialog(null,"data stored successfully","report",JOptionPane.PLAIN_MESSAGE);


         }
     }
         oldPFeeHead();
         jCheckBox1.setSelected(false);
              return;
        }


catch(Exception e)
{
    e.printStackTrace();
    System.out.println("here");
}
    }

    private void oldPFeeHead()
    {
        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
       try
       {
           ps = con.prepareStatement("select * from periodicfeehead");

           rs = ps.executeQuery();
            int i = 0,j=0;
          while(rs.next())
            {
                j++;
            }
            rs.first();
            rs.previous();
            dm3.setRowCount(j);
            while(rs.next())
            {
                dm3.setValueAt(rs.getString(2), i, 0);
               dm3.setValueAt(rs.getInt(1), i, 1);
dm3.setValueAt(rs.getInt(4), i, 2);
                i++;
            }
            
            System.out.println("Database open");

       }
       catch(Exception e)
       {
           System.err.println("Error"+e);
       }
    }






    public void removePFeeHead()
    {
       // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        int row = jTable5.getSelectedRow();
         System.out.println("row no. selected"+row);
        try
        {
            if(Integer.parseInt(dm3.getValueAt(row,2).toString())!=0)
            {
            int i=periodicFeeHeadDelete(dm3.getValueAt(row, 0).toString());
            if(i==1)
            {
                int select=JOptionPane.showConfirmDialog(null,"No record for this fee head is found inside the software, so you can safely remove this","Safe remove",JOptionPane.OK_OPTION);
           if(select==JOptionPane.OK_OPTION)
           {
                ps=con.prepareStatement("delete from periodicfeehead where head=?");

         ps.setString(1,dm3.getValueAt(row, 0).toString());
         ps.executeUpdate();
       //  dm3.removeRow(row);
         oldPFeeHead();
           }
            }else{
                    int choose=JOptionPane.showConfirmDialog(null,"Its record is present,Do you really want to delete this","Fee Head Delete",JOptionPane.OK_OPTION);
         if(choose==JOptionPane.OK_OPTION)
         {
                ps=con.prepareStatement("update periodicfeehead set status=0 where head=?");

         ps.setString(1,dm3.getValueAt(row, 0).toString());
         ps.executeUpdate();
        // dm3.removeRow(row);
         oldPFeeHead();
         System.out.println("no safe delete");
            }
        }
         //
         System.out.println("DataBase Conection Closed");
    }

        else
        {
             ps=con.prepareStatement("update periodicfeehead set status=1 where head=?");

         ps.setString(1,dm3.getValueAt(row, 0).toString());
         ps.executeUpdate();
         oldPFeeHead();
        }
    }
        catch(Exception e)
        {
            System.err.println("Error"+e);
        }

    }

    public void fromClass()
{
   // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


         ps = con.prepareStatement("select * from classsetup");

             rs = ps.executeQuery();


            while (rs.next())
            {
        jComboBox2.addItem(rs.getString(1));
jComboBox4.addItem(rs.getString(1));
jComboBox6.addItem(rs.getString(1));
            }



    }catch(Exception e)
    {
        e.printStackTrace();
    }

}
public void fromAdmissionFeeHead()
{
    //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
         //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


         ps = con.prepareStatement("select * from admissionfeehead where status=1");

             rs = ps.executeQuery();

jComboBox1.removeAllItems();
jComboBox1.addItem("choose");
            while (rs.next())
            {
        jComboBox1.addItem(rs.getString(2));


            }



    }catch(Exception e)
    {
        e.printStackTrace();
    }

}
public void addAFeeHeadAmount()
{
    // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    int id=0;
try
{
    // ps = con.prepareStatement("insert into inventorysetup (Inventoryunit,InventoryVendor,Inventorymode,class,unitid,Time) values(?,?,?,?,?,?)");

    ps=con.prepareStatement("insert into admissionfeeamounthead(head,amount,class) values(?,?,?)");
  // ps.setInt(1,id);
    ps.setString(1,Aheadmap1.get(jComboBox1.getSelectedItem().toString()).toString());
    ps.setDouble(2,Double.parseDouble(classtitle1.getText()));
    ps.setString(3,classmap1.get(jComboBox2.getSelectedItem().toString()).toString());


         ps.executeUpdate();


        System.out.println("Done");
        //JOptionPane.showMessageDialog(null,"data stored successfully","report",JOptionPane.PLAIN_MESSAGE);


         System.out.println("DataBase ");
         oldAFeeHeadAmount();
              return;
        }


catch(Exception e)
{
    e.printStackTrace();
    System.out.println("here");
}
    }

    private void oldAFeeHeadAmount()
    {
        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
       try
       {
           ps = con.prepareStatement("select * from admissionfeeamounthead left join admissionfeehead on admissionfeeamounthead.head=feeid where class=? and status=1");
ps.setString(1,classmap1.get(jComboBox2.getSelectedItem().toString()).toString());
           rs = ps.executeQuery();
            int i = 0,j=0;
          while(rs.next())
            {
                j++;
            }
            rs.first();
            rs.previous();
            dmA1.setRowCount(j);
            while(rs.next())
            {
                dmA1.setValueAt(Aheadmap.get(rs.getInt(1)), i, 0);
               dmA1.setValueAt(rs.getDouble(2), i, 1);

                i++;
            }
            
            System.out.println("Database open");

       }
       catch(Exception e)
       {
           System.err.println("Error"+e);
       }
    }






    public void removeAFeeHeadAmount()
    {
        //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        int row = jTable2.getSelectedRow();
         System.out.println("row no. selected"+row);
        try
        {
         ps=con.prepareStatement("delete from admissionfeeamounthead where head=? and class=?");

         ps.setInt(1,Integer.parseInt(Aheadmap1.get(dmA1.getValueAt(row, 0)).toString()));
         ps.setString(2,classmap1.get(jComboBox2.getSelectedItem().toString()).toString());
         ps.executeUpdate();
         dmA1.removeRow(row);
          
         System.out.println("DataBase Conection Closed");
    }
        catch(Exception e)
        {
            System.err.println("Error"+e);
        }

    }

    public void fromMClass()
{
    //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


         ps = con.prepareStatement("select * from classsetup");

             rs = ps.executeQuery();


            while (rs.next())
            {
        jComboBox4.addItem(rs.getString(1));


            }



    }catch(Exception e)
    {
        e.printStackTrace();
    }

}
public void fromMonthlyFeeHead()
{
    //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
        
         ps = con.prepareStatement("select * from monthlyfeehead where status=1");

             rs = ps.executeQuery();
jComboBox3.removeAllItems();
jComboBox3.addItem("choose");

            while (rs.next())
            {
        jComboBox3.addItem(rs.getString(2));


            }



    }catch(Exception e)
    {
        e.printStackTrace();
    }

}

public void addMFeeHeadAmount()
{
     //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

try
{
    // ps = con.prepareStatement("insert into inventorysetup (Inventoryunit,InventoryVendor,Inventorymode,class,unitid,Time) values(?,?,?,?,?,?)");

    ps=con.prepareStatement("insert into monthlyfeeamounthead(head,amount,class) values(?,?,?)");
   // ps.setInt(1,id);
    ps.setString(1,Mheadmap1.get(jComboBox3.getSelectedItem().toString()).toString());
    ps.setDouble(2,Double.parseDouble(classtitle3.getText()));
    ps.setString(3,classmap1.get(jComboBox4.getSelectedItem().toString()).toString());



         ps.executeUpdate();


        System.out.println("Done");
        //JOptionPane.showMessageDialog(null,"data stored successfully","report",JOptionPane.PLAIN_MESSAGE);


         System.out.println("DataBase ");
         oldMFeeHeadAmount();
              return;
        }


catch(Exception e)
{
    e.printStackTrace();
    System.out.println("here");
}
    }

    private void oldMFeeHeadAmount()
    {
       //  con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
       try
       {
           ps = con.prepareStatement("select * from monthlyfeeamounthead left join monthlyfeehead on monthlyfeeamounthead.head=feeid where class=? and status=1");
ps.setString(1,classmap1.get(jComboBox4.getSelectedItem().toString()).toString());
           rs = ps.executeQuery();
            int i = 0,j=0;
          while(rs.next())
            {
                j++;
            }
            rs.first();
            rs.previous();
            dmA2.setRowCount(j);
            while(rs.next())
            {
                dmA2.setValueAt(Mheadmap.get(rs.getInt(1)), i, 0);
               dmA2.setValueAt(rs.getDouble(2), i, 1);

                i++;
            }
            
            System.out.println("Database open");

       }
       catch(Exception e)
       {
           System.err.println("Error"+e);
       }
    }






    public void removeMFeeHeadAmount()
    {
        //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        int row = jTable4.getSelectedRow();
         System.out.println("row no. selected"+row);
        try
        {
         ps=con.prepareStatement("delete from monthlyfeeamounthead where head=? and class=?");

         ps.setInt(1,Integer.parseInt(Mheadmap1.get(dmA2.getValueAt(row, 0).toString()).toString()));
         ps.setString(2,classmap1.get(jComboBox4.getSelectedItem().toString()).toString());
         ps.executeUpdate();
         dmA2.removeRow(row);
          
         System.out.println("DataBase Conection Closed");
    }
        catch(Exception e)
        {
            System.err.println("Error"+e);
        }

    }

    public void selectStudentPeriodicAmount()
{
     int crow=jTable6.getSelectedRow();
       int ledgercode=0,annualstatus=0;
        int feehead=Integer.parseInt(Pheadmap1.get(dmA3.getValueAt(crow,0)).toString());
        Double feeamount=Double.parseDouble(dmA3.getValueAt(crow,1).toString());
        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
       try
       {
           ps = con.prepareStatement("select * from periodicfeeamounthead where head=? and class=?");
ps.setInt(1,feehead);
ps.setInt(2,Integer.parseInt(classmap1.get(jComboBox6.getSelectedItem().toString()).toString()));
           rs = ps.executeQuery();
           while(rs.next())
                ledgercode=rs.getInt(4);

          ps = con.prepareStatement("select * from periodicfeehead where feeid=?");
ps.setInt(1,feehead);
//ps.setString(2,jComboBox2.getSelectedItem().toString());

         rs = ps.executeQuery();
         while(rs.next())
             annualstatus=rs.getInt(3);

       }catch(Exception e)
       {
           e.printStackTrace();
       }


       // System.out.println(id);
      com.duc.FeeDepartment.FeeCounter1 r1=   new com.duc.FeeDepartment.FeeCounter1();
      //r1.setVisible(true);
        // r1.getPeriodicFeeStructure(feehead,feeamount,ledgercode);
      if(annualstatus==0)
      {
         r1.insertParticularStudentCustomizedPeriodicStructure(stdid,month,feehead,feeamount,ledgercode);
      r1.insertParticularStudentPeriodicStructure(stdid,month,feehead,feeamount,ledgercode);
      JOptionPane.showConfirmDialog(null,"Loaded for Student on month Selection basis","Periodic Fee",JOptionPane.OK_CANCEL_OPTION);
      }else
      {
r1.insertParticularStudentCustomizedAnnualPeriodicStructure(stdid,month,feehead,feeamount,ledgercode);
          r1.insertParticularStudentAnnualStructure(stdid,month,feehead,feeamount,ledgercode);
         JOptionPane.showConfirmDialog(null,"Loaded for Studenr on Annual basis","Yearly Fee",JOptionPane.OK_CANCEL_OPTION);

      }System.out.println("sdsdsd"+feehead);
}
    public void selectPeriodicAmount()
    {
        int crow=jTable6.getSelectedRow();
       int ledgercode=0,annualstatus=0;
        int feehead=Integer.parseInt(Pheadmap1.get(dmA3.getValueAt(crow,0)).toString());
        Double feeamount=Double.parseDouble(dmA3.getValueAt(crow,1).toString());
        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
       try
       {
           ps = con.prepareStatement("select * from periodicfeeamounthead where head=? and class=?");
ps.setInt(1,feehead);
ps.setInt(2,Integer.parseInt(classmap1.get(jComboBox6.getSelectedItem().toString()).toString()));
           rs = ps.executeQuery();
           while(rs.next())
                ledgercode=rs.getInt(4);

          ps = con.prepareStatement("select * from periodicfeehead where feeid=?");
ps.setInt(1,feehead);
//ps.setString(2,jComboBox2.getSelectedItem().toString());

         rs = ps.executeQuery();
         while(rs.next())
             annualstatus=rs.getInt(3);

       }catch(Exception e)
       {
           e.printStackTrace();
       }


       // System.out.println(id);
      com.duc.FeeDepartment.FeeCounter1 r1=   new com.duc.FeeDepartment.FeeCounter1();
      //r1.setVisible(true);
        // r1.getPeriodicFeeStructure(feehead,feeamount,ledgercode);
      if(annualstatus==0)
      {
          r1.loadAllPeriodicCustomizedStudentOfClass(stdclass,month,feehead,feeamount,ledgercode);
      r1.insertPeriodicStudentStructure(stdclass,month,feehead,feeamount,ledgercode);
      JOptionPane.showConfirmDialog(null,"Loaded for Class on month Selection basis","Periodic Fee",JOptionPane.OK_CANCEL_OPTION);
      }else
      {
          r1.loadAllAnnualPeriodicCustomizedStudentOfClass(stdclass,month,feehead,feeamount,ledgercode);
          r1.insertPeriodicAnnualDues(stdclass,month,feehead,feeamount,ledgercode);
      JOptionPane.showConfirmDialog(null,"Loaded for Class on Annual basis","Annual Fee",JOptionPane.OK_CANCEL_OPTION);
      }
       System.out.println("sdsdsd"+feehead);
       System.out.println("11111111111"+stdid);
    }


public void fromPClass()
{
    //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


         ps = con.prepareStatement("select * from classsetup");

             rs = ps.executeQuery();


            while (rs.next())
            {
        jComboBox6.addItem(rs.getString(1));


            }



    }catch(Exception e)
    {
        e.printStackTrace();
    }

}
public void fromPAdmissionFeeHead()
{
   // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
         //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


         ps = con.prepareStatement("select * from periodicfeehead where status=1");

             rs = ps.executeQuery();

jComboBox5.removeAllItems();
jComboBox5.addItem("choose");
            while (rs.next())
            {
        jComboBox5.addItem(rs.getString(2));


            }



    }catch(Exception e)
    {
        e.printStackTrace();
    }

}

public void addPFeeHeadAmount()
{
    // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    int id=0;
try
{
    // ps = con.prepareStatement("insert into inventorysetup (Inventoryunit,InventoryVendor,Inventorymode,class,unitid,Time) values(?,?,?,?,?,?)");
//ps=con.prepareStatement("select * from periodicfeehead where head=? and class=?");
//ps.setString(1,jComboBox1.getSelectedItem().toString());

    //ps.setString(2,jComboBox2.getSelectedItem().toString());
    //rs=ps.executeQuery();
    ps=con.prepareStatement("insert into periodicfeeamounthead(head,amount,class) values(?,?,?)");
  // ps.setInt(1,id);
    ps.setString(1,Pheadmap1.get(jComboBox5.getSelectedItem().toString()).toString());
    ps.setDouble(2,Double.parseDouble(classtitle5.getText()));
    ps.setInt(3,Integer.parseInt(classmap1.get(jComboBox6.getSelectedItem().toString()).toString()));


         ps.executeUpdate();


        System.out.println("Done");
        //JOptionPane.showMessageDialog(null,"data stored successfully","report",JOptionPane.PLAIN_MESSAGE);


         System.out.println("DataBase ");
         oldPFeeHeadAmount();
              return;
        }


catch(Exception e)
{
    e.printStackTrace();
    System.out.println("here");
}
    }

    public void oldPFeeHeadAmount()
    {
         if(stdclass!=null)
    jComboBox6.setSelectedItem(stdclass);
        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
       try
       {
           ps = con.prepareStatement("select * from periodicfeeamounthead left join periodicfeehead on periodicfeeamounthead.head=feeid where class=? and status=1");
ps.setInt(1,Integer.parseInt(classmap1.get(jComboBox6.getSelectedItem().toString()).toString()));
           rs = ps.executeQuery();
            int i = 0,j=0;
          while(rs.next())
            {
                j++;
            }
            rs.first();
            rs.previous();
            dmA3.setRowCount(j);
            while(rs.next())
            {
                dmA3.setValueAt(Pheadmap.get(rs.getInt(1)), i, 0);
               dmA3.setValueAt(rs.getDouble(2), i, 1);

                i++;
            }
            
            System.out.println("Database open");

       }
       catch(Exception e)
       {
           System.err.println("Error"+e);
       }
    }



public void oldFeeHeadAmountShowFromFeeCounter(String stdclass)
    {
   // if(stdclass!=null)
    //jComboBox2.setSelectedItem(stdclass);
   // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
       try
       {
           ps = con.prepareStatement("select * from periodicfeeamounthead where class=?");
ps.setString(1,stdclass);
           rs = ps.executeQuery();
            int i = 0,j=0;
          while(rs.next())
            {
                j++;
            }
            rs.first();
            rs.previous();
            dmA3.setRowCount(j);
            while(rs.next())
            {
                dmA3.setValueAt(Pheadmap.get(rs.getInt(1)), i, 0);
               dmA3.setValueAt(rs.getDouble(2), i, 1);

                i++;
            }
            
            System.out.println("Database open");

       }
       catch(Exception e)
       {
           System.err.println("Error"+e);
       }
    }






    public void removePFeeHeadAmount()
    {
       // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        int row = jTable6.getSelectedRow();
         System.out.println("row no. selected"+row);
        try
        {
         ps=con.prepareStatement("delete from periodicfeeamounthead where head=? and class=?");

         ps.setInt(1,Integer.parseInt(Pheadmap1.get(dmA3.getValueAt(row, 0)).toString()));
         ps.setInt(2,Integer.parseInt(classmap1.get(jComboBox6.getSelectedItem().toString()).toString()));
         ps.executeUpdate();
         dmA3.removeRow(row);
          
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
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPane4 = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        classtitle = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextPane7 = new javax.swing.JTextPane();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextPane8 = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        classtitle2 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jButton13 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTextPane11 = new javax.swing.JTextPane();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTextPane12 = new javax.swing.JTextPane();
        jLabel9 = new javax.swing.JLabel();
        classtitle4 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton17 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextPane5 = new javax.swing.JTextPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextPane6 = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        classtitle1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTextPane9 = new javax.swing.JTextPane();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTextPane10 = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();
        classtitle3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jButton16 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jScrollPane17 = new javax.swing.JScrollPane();
        jTextPane13 = new javax.swing.JTextPane();
        jScrollPane18 = new javax.swing.JScrollPane();
        jTextPane14 = new javax.swing.JTextPane();
        jLabel10 = new javax.swing.JLabel();
        classtitle5 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox();
        jComboBox6 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Institute Fee Heads Setup");

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Fee Head Title", "Id", "status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton1.setForeground(new java.awt.Color(0, 0, 255));
        jButton1.setText("Add Head");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton4.setForeground(new java.awt.Color(0, 0, 255));
        jButton4.setText("Use/Not-use Head");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextPane3.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane3.setEditable(false);
        jTextPane3.setFont(new java.awt.Font("Tahoma", 0, 18));
        jTextPane3.setText("                        Admission Fee Head");
        jScrollPane4.setViewportView(jTextPane3);

        jTextPane4.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane4.setEditable(false);
        jTextPane4.setText("Set the no. of admission fee heads...");
        jScrollPane5.setViewportView(jTextPane4);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setText("Head Title");

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 0, 255));
        jButton5.setText("Update Head Name");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(classtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addGap(121, 121, 121))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(classtitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(51, 51, 51))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addGap(281, 281, 281)))
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Admission Fee Head", jPanel1);

        jPanel5.setBackground(new java.awt.Color(204, 0, 255));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                " Fee Head Title", "Id", "status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jButton7.setText("Add Head");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton9.setText("Use/Not-use Head");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jTextPane7.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane7.setEditable(false);
        jTextPane7.setFont(new java.awt.Font("Tahoma", 0, 18));
        jTextPane7.setText("                        Monthly Fee Head");
        jScrollPane8.setViewportView(jTextPane7);

        jTextPane8.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane8.setEditable(false);
        jTextPane8.setText("Add  Monthly Fee heads...");
        jScrollPane9.setViewportView(jTextPane8);

        jLabel5.setText("Head Title");

        jButton11.setText("Update Head Name");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(classtitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addGap(137, 137, 137))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(classtitle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7))
                        .addGap(41, 41, 41))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Monthly Fee Head", jPanel4);

        jPanel10.setBackground(new java.awt.Color(153, 102, 255));

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Fee Head Title", "Id", "status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane13.setViewportView(jTable5);

        jButton13.setText("Add Fee Head");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton15.setText("Use/Not-use Head");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jTextPane11.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane11.setEditable(false);
        jTextPane11.setFont(new java.awt.Font("Tahoma", 0, 18));
        jTextPane11.setText("                        Periodic Fee Head");
        jScrollPane14.setViewportView(jTextPane11);

        jTextPane12.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane12.setEditable(false);
        jTextPane12.setText("Set the no. of periodic fee heads...");
        jScrollPane15.setViewportView(jTextPane12);

        jLabel9.setText("Head Title");

        jCheckBox1.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBox1.setText("Annual head");

        jButton17.setText("Update Head name");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
            .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(classtitle4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(jCheckBox1))
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jButton13)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jButton15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton17)))
                .addGap(26, 26, 26)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(classtitle4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1)
                    .addComponent(jButton13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Periodic Fee Head", jPanel7);

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Fee Head ", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jButton2.setText("Add Amount");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton6.setText("Delete Amount");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTextPane5.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane5.setEditable(false);
        jTextPane5.setFont(new java.awt.Font("Tahoma", 0, 18));
        jTextPane5.setText("                   Admission Fee Amount Head");
        jScrollPane6.setViewportView(jTextPane5);

        jTextPane6.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane6.setEditable(false);
        jTextPane6.setText("Add  admission fee amount heads...");
        jScrollPane7.setViewportView(jTextPane6);

        jLabel2.setText("Amount");

        jLabel3.setText("Head");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Class");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, 0, 104, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox2, 0, 105, Short.MAX_VALUE)
                .addGap(72, 72, 72))
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(classtitle1, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addGap(248, 248, 248))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classtitle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Admission Fee Amount", jPanel2);

        jPanel9.setBackground(new java.awt.Color(204, 0, 255));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Fee Head ", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane10.setViewportView(jTable4);

        jButton10.setText("Add Amount");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton12.setText("Delete Amount");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jTextPane9.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane9.setEditable(false);
        jTextPane9.setFont(new java.awt.Font("Tahoma", 0, 18));
        jTextPane9.setText("                   Monthly Fee Amount Head");
        jScrollPane11.setViewportView(jTextPane9);

        jTextPane10.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane10.setEditable(false);
        jTextPane10.setText("Add  Monthly fee head amounts for different classes..select head and the class...");
        jScrollPane12.setViewportView(jTextPane10);

        jLabel6.setText("Amount");

        jLabel7.setText("Head");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jLabel8.setText("Class");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
            .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(classtitle3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox4, 0, 125, Short.MAX_VALUE)
                .addGap(64, 64, 64))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12)))
                .addGap(26, 26, 26)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(classtitle3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Monthly Fee Amount", jPanel6);

        jPanel11.setBackground(new java.awt.Color(153, 102, 255));

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Fee Head ", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane16.setViewportView(jTable6);

        jButton16.setText("Add Amount");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton18.setText("Delete Amount");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jTextPane13.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane13.setEditable(false);
        jTextPane13.setFont(new java.awt.Font("Tahoma", 0, 18));
        jTextPane13.setText("                   Periodic Fee Amount Head");
        jScrollPane17.setViewportView(jTextPane13);

        jTextPane14.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane14.setEditable(false);
        jTextPane14.setText("Add  periodic fee amount heads...");
        jScrollPane18.setViewportView(jTextPane14);

        jLabel10.setText("Amount");

        jLabel11.setText("Head");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6ActionPerformed(evt);
            }
        });

        jLabel12.setText("Class");

        jButton19.setText("Select  Amount");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
            .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jButton19)
                .addContainerGap(217, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox5, 0, 118, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(classtitle5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(256, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jButton16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton19)
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classtitle5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Periodic Fee Amount", jPanel8);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 463, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        addAFeeHead();        // TODO add your handling code here:
}//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        removeAFeeHead();      // TODO add your handling code here:
}//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        addAFeeHeadAmount();        // TODO add your handling code here:
}//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        removeAFeeHeadAmount();      // TODO add your handling code here:
}//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        addMFeeHead();        // TODO add your handling code here:
}//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        removeMFeeHead();      // TODO add your handling code here:
}//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        addMFeeHeadAmount();        // TODO add your handling code here:
}//GEN-LAST:event_jButton10ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        removeMFeeHeadAmount();      // TODO add your handling code here:
}//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        addPFeeHead();        // TODO add your handling code here:
}//GEN-LAST:event_jButton13ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        removePFeeHead();      // TODO add your handling code here:
}//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        addPFeeHeadAmount();        // TODO add your handling code here:
}//GEN-LAST:event_jButton16ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        removePFeeHeadAmount();      // TODO add your handling code here:
}//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        if(stdid==null)selectPeriodicAmount();
        else
            selectStudentPeriodicAmount();
}//GEN-LAST:event_jButton19ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
      oldAFeeHeadAmount();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
         oldMFeeHeadAmount();
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6ActionPerformed
        oldPFeeHeadAmount();
    }//GEN-LAST:event_jComboBox6ActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        fromAdmissionFeeHead();
        fromMonthlyFeeHead();
        fromPAdmissionFeeHead();
         Aheadmap1=mp.getAdmissionFeeIndexFromName();
   Aheadmap=mp.getAdmissionFeeIndexToName();

 Mheadmap1=mp.getMonthlyFeeIndexFromName();
   Mheadmap=mp.getMonthlyFeeIndexToName();

    Pheadmap1=mp.getPeriodicFeeIndexFromName();
    Pheadmap=mp.getPeriodicFeeIndexToName();
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        updateAHeadName();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        updateMHeadName();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
       updatePHeadName();
    }//GEN-LAST:event_jButton17ActionPerformed

public void updateAHeadName()
{
    int row=jTable1.getSelectedRow();
    try
    {
     ps=con.prepareStatement("update admissionfeehead set head=? where feeid=?");
     ps.setString(1,dm1.getValueAt(row,0).toString());
     ps.setInt(2,Integer.parseInt(dm1.getValueAt(row,1).toString()));
     ps.executeUpdate();
    }catch(Exception e)
    {
        e.printStackTrace();
    }
}

public void updateMHeadName()
{
    int row=jTable1.getSelectedRow();
    try
    {
     ps=con.prepareStatement("update monthlyfeehead set head=? where feeid=?");
     ps.setString(1,dm2.getValueAt(row,0).toString());
     ps.setInt(2,Integer.parseInt(dm2.getValueAt(row,1).toString()));
     ps.executeUpdate();
    }catch(Exception e)
    {
        e.printStackTrace();
    }
}

public void updatePHeadName()
{
    int row=jTable1.getSelectedRow();
    try
    {
     ps=con.prepareStatement("update periodicfeehead set head=? where feeid=?");
     ps.setString(1,dm3.getValueAt(row,0).toString());
     ps.setInt(2,Integer.parseInt(dm3.getValueAt(row,1).toString()));
     ps.executeUpdate();
    }catch(Exception e)
    {
        e.printStackTrace();
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField classtitle;
    private javax.swing.JTextField classtitle1;
    private javax.swing.JTextField classtitle2;
    private javax.swing.JTextField classtitle3;
    private javax.swing.JTextField classtitle4;
    private javax.swing.JTextField classtitle5;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextPane jTextPane10;
    private javax.swing.JTextPane jTextPane11;
    private javax.swing.JTextPane jTextPane12;
    private javax.swing.JTextPane jTextPane13;
    private javax.swing.JTextPane jTextPane14;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextPane jTextPane4;
    private javax.swing.JTextPane jTextPane5;
    private javax.swing.JTextPane jTextPane6;
    private javax.swing.JTextPane jTextPane7;
    private javax.swing.JTextPane jTextPane8;
    private javax.swing.JTextPane jTextPane9;
    // End of variables declaration//GEN-END:variables
//Connection con;
ResultSet rs;
PreparedStatement ps;
public String stdclass=null,month=null,stdid=null;
}
