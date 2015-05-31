/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.duc.FeeDepartment;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import com.duc.ImportSection.MapForIndex;
import java.util.HashMap;

import static com.duc.DatabaseConnection.DatabaseConnection.*;


/**
 *
 * @author sourabh
 */

public class FeeCollectionTableModel extends DefaultTableModel
{

    //MapForIndex mp=new MapForIndex();
    HashMap classmap=mp.getClassIndexName();
    HashMap sectionmap=mp.getSectionIndexName();
    private String[] colnames = null;
    private Object[][] cellvalues = null;
    boolean[] canEdit  = null;
    int rowcount=0;
    int columncount=0;

  //  int actualcount;
  // Connection con;

   PreparedStatement ps;
   ResultSet rs,rs1;

   ArrayList <String> heads=new ArrayList<String>();
   ArrayList <Integer> receipts=new ArrayList<Integer>();

   public FeeCollectionTableModel(String date)
   {
       columncount=getColumnCount();
       rowcount=getRowCount(date);

        canEdit = new boolean[columncount];
        colnames = new String[columncount];
        cellvalues=new Object[rowcount+1][columncount];

        for(int x=0;x<rowcount;x++)
        {
            for(int y=0;y<columncount;y++)
            {
             cellvalues[x][y]=0.0;
            }
        }
        
        int i=0;
        for (String s : heads)
        {
          colnames[i]=s;
          i++;
        }

       updateCellValues(date);
       setTotal();
   }

   public void setTotal()
   {
    double amount=0.0;
    cellvalues[rowcount][0]="Total";
    System.out.println("Setting the total");
    for(int column=6;column<columncount;column++)
    {
     amount=0.0;
     for(int row=0;row<rowcount;row++)
      {
       try
       {
        amount=amount+ Double.parseDouble(String.valueOf(cellvalues[row][column]));
       }
       catch(Exception e)
       {
        System.err.println("Error occured "+e);
       }
        
      }
     cellvalues[rowcount][column]=amount;
    }
   }

   public void updateCellValues(String date)
   {
      int i=0;
       try
       {
        // con= com.duc.DatabaseConnection.DatabaseConnection.con;
         System.out.println("con of FeecollectionTableModel="+con);
         ps=con.prepareStatement("select studentid,class,name,receipt,month,section,waiver,newsurplus,surplusused from receiptnumber,studententry where id=studentid and date=? order by receipt");
         ps.setString(1,date);         
         rs=ps.executeQuery();

        while(rs.next())
        {
        cellvalues[i][0]=i+1;
        cellvalues[i][1]=rs.getString(1);
        cellvalues[i][2]=String.valueOf(classmap.get(rs.getInt(2)))+" / "+String.valueOf(sectionmap.get(rs.getInt(6)))+"";
        cellvalues[i][3]=rs.getString(3);
        cellvalues[i][4]=rs.getString(4);
        cellvalues[i][5]=rs.getString(5);
      
        cellvalues[i][columncount-2]=rs.getString(7);
        cellvalues[i][columncount-4]=rs.getString(8);
        cellvalues[i][columncount-3]=rs.getString(9);
        receipts.add(rs.getInt(4));
        
        i++;
        }
     
     for (i=0; i<rowcount; i++)
     {
     String head;
     double prev=0.0;
     double amount=0.0;

      ps=con.prepareStatement("select feehead,totaldues,totalpaid,totalremaining,feetype from payreceiptinfo where `payreceiptinfo`.`receiptnumber`=?");
      ps.setInt(1, receipts.get(i));
      rs=ps.executeQuery();

      while(rs.next())
      {
      head=mp.getFeeHeadNameFromFeeTypeAndHeadIndex(rs.getInt(5), rs.getInt(1));
      System.out.println("Head Print : "+head);
      if(heads.contains(head))
      {
      cellvalues[i][heads.indexOf(head)]=rs.getDouble(3);
      }
      else
      {
      prev=(Double)cellvalues[i][columncount-6];
      amount=prev+rs.getDouble(3);
      cellvalues[i][columncount-6]=amount;
      }

      //totaldues
      /*
      prev=(Double)cellvalues[i][columncount-7];
      System.out.println(" prev is "+prev +"+"+rs.getDouble(2));
      amount=prev+rs.getDouble(2);
      cellvalues[i][columncount-7]=amount;
       * */

      //totalpaid
      prev=(Double)cellvalues[i][columncount-5];
      amount=prev+rs.getDouble(3);
      cellvalues[i][columncount-5]=amount;

      //Balance
      /*
      prev=(Double)cellvalues[i][columncount-5];
      amount=prev+rs.getDouble(4);
      cellvalues[i][columncount-5]=amount;
       * */
      }
      cellvalues[i][columncount-1]=Double.parseDouble(cellvalues[i][columncount-5].toString())+Double.parseDouble(cellvalues[i][columncount-4].toString())-Double.parseDouble(cellvalues[i][columncount-3].toString())-Double.parseDouble(cellvalues[i][columncount-2].toString());
     }
      //con.close();     
   }
   catch(Exception e)
  {
   System.err.println("Error in getting cell values in fee collection " +e);
  }
}

  public int getRowCount(String date)
  {
  int rcount=0;
  try
        {
         // con= com.duc.DatabaseConnection.DatabaseConnection.con;
         ps=con.prepareStatement("select count(*) from receiptnumber where date=? ");
         ps.setString(1, date);        
         rs=ps.executeQuery();
         rs.next();
         rcount+=rs.getInt(1);

       //  actualcount=rs.getInt(1);

       /*  ps=con.prepareStatement("select count(*) from `studenttodaysurplus`,`studententry` where `studenttodaysurplus`.`studentid`=id and  `studenttodaysurplus`.`date`=? and `studenttodaysurplus`.`studentid` NOT IN (select `receiptnumber`.`studentid` from `receiptnumber` where `receiptnumber`.date=?)");
         ps.setString(1,date);
         ps.setString(2,date);
         rs=ps.executeQuery();
         rs.next();
         rcount+=rs.getInt(1);
          */
        }
  catch(Exception e)
  {
   System.out.println("Error in getting rowcount in fee collection");
  }
  return rcount;
  }

    @Override
   public int getColumnCount()
   {
     int count=0;
     
     count=count+6;
     heads.add("<html>Sr.<br />No.</html>");
     heads.add("<html>Adm.<br />No.</html>");
     heads.add("<html>Class /<br />Sec.</html>");
     heads.add("Name");
     heads.add("<html>Recpt.<br />No.</html>");
     heads.add("<html>Fee<br />Month</html>");

       try
        {

        //con= com.duc.DatabaseConnection.DatabaseConnection.con;
         ps=con.prepareStatement("select head from periodicfeehead order by feeid ");
         rs=ps.executeQuery();
         while(rs.next())
         {
          count++;
          heads.add(rs.getString(1));
         }
         
        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
         ps=con.prepareStatement("select head from admissionfeehead order by feeid ");
         rs=ps.executeQuery();
         while(rs.next())
         {
          count++;
          heads.add(rs.getString(1));
         }

         ps=con.prepareStatement("select head from monthlyfeehead order by feeid ");
         rs=ps.executeQuery();
         while(rs.next())
         {
          count++;
          heads.add(rs.getString(1));
         }

      count=count+6;
      heads.add("Misc.");
      //heads.add("<html>Total<br />Amt. Payable</html>");
      heads.add("<html>Total Amount<br /> Paid</html>");
      //heads.add("<html>Balance</html>");
      heads.add("<html>Surplus <br />Received Today</html>");
      heads.add("<html>Surplus <br />Used Today</html>");
      heads.add("<html>Waiver <br />/ Relax. Given</html>");
      heads.add("Net Collec.");
      
      //con.close();
       }
       catch(Exception e)
       {
       System.err.println("Error in calculating total fee heads count");
       }

     return count;
   }

    @Override
     public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return canEdit [columnIndex];
    }

    public DefaultTableModel createDefaultModel()
    {
    return new javax.swing.table.DefaultTableModel(cellvalues, colnames )
    {
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
    return canEdit [columnIndex];
    }
    };
    }
}
