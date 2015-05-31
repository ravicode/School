/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.duc.FeeDepartment;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import com.duc.ImportSection.MapForIndex;
//import java.util.HashMap;

import static com.duc.DatabaseConnection.DatabaseConnection.*;


/**
 *
 * @author sourabh
 */

public class MonthFeeCollectionTableModel extends DefaultTableModel
{

   //MapForIndex mp=new MapForIndex();
    
    private String[] colnames = null;
    private Object[][] cellvalues = null;
    boolean[] canEdit  = null;
    int rowcount=0;
    int columncount=0;

  // Connection con;
   PreparedStatement ps;
   ResultSet rs,rs1;

   ArrayList <String> heads=new ArrayList<String>();
   

   public MonthFeeCollectionTableModel(String date)
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
    for(int column=2;column<columncount;column++)
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
      String year,month;
       try
       {
        
         System.out.println("con of MonthFeecollectionTableModel="+con);
         ps=con.prepareStatement("select date_format(?,'%Y'),date_format(?,'%m') ");
         ps.setString(1,date);
         ps.setString(2,date);
         rs=ps.executeQuery();

         rs.next();
         year=rs.getString(1);
         month=rs.getString(2);


         String d;
         String head;
         double prev=0.0;
         double amount=0.0;

         for(int x=1;x<=rowcount;x++)
         {
           i=x-1;
           d=year+"-"+month+"-"+String.valueOf(x);
           System.out.println("date="+d);
           cellvalues[i][0]=x;
           cellvalues[i][1]=x+"-"+month+"-"+year;
           
           
        ps=con.prepareStatement("select SUM(newsurplus),SUM(surplusused) from receiptnumber where date=?");
        ps.setString(1,d);
        rs1=ps.executeQuery();
        if(rs1.next())
        cellvalues[i][columncount-4]=rs1.getDouble(1);
        
        cellvalues[i][columncount-3]=rs1.getDouble(2);

      ps=con.prepareStatement("select feehead,SUM(totaldues),SUM(totalpaid),SUM(totalremaining),feetype from payreceiptinfo,receiptnumber where receiptnumber=receipt and date=? group by feetype,feehead");
      ps.setString(1,d);
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
      cellvalues[i][columncount-7]=amount; */

      //totalpaid
      prev=(Double)cellvalues[i][columncount-5];
      amount=prev+rs.getDouble(3);
      cellvalues[i][columncount-5]=amount;

      //Balance
      /*
      prev=(Double)cellvalues[i][columncount-5];
      amount=prev+rs.getDouble(4);
      cellvalues[i][columncount-5]=amount; */
     
     }
      
      ps=con.prepareStatement("select SUM(waiver) from receiptnumber where date=?");
      ps.setString(1, d);
      rs1=ps.executeQuery();
      rs1.next();
      cellvalues[i][columncount-2]=rs1.getDouble(1);

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
         
         ps=con.prepareStatement("select DATE_FORMAT(LAST_DAY(?),'%d') ");
         ps.setString(1, date);
         rs=ps.executeQuery();
         rs.next();
         rcount+=rs.getInt(1);
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

     count=count+2;
     heads.add("<html>Sr.<br />No.</html>");  
     heads.add("Date");

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

         //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
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
     // heads.add("<html>Total<br />Amt. Payable</html>");
      heads.add("<html> Total Amount<br /> Paid</html>");
      //heads.add("<html>Balance</html>");
      heads.add("<html>Surplus <br />Received</html>");
      heads.add("<html>Surplus <br />Used</html>");
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
