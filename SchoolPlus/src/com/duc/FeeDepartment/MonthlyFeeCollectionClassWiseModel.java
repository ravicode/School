/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.duc.FeeDepartment;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import static com.duc.DatabaseConnection.DatabaseConnection.*;
/**
 *
 * @author sourabh
 */

public class MonthlyFeeCollectionClassWiseModel extends DefaultTableModel
{
    //MapForIndex mp=new MapForIndex();
    HashMap classmap=mp.getClassIndexName();
    HashMap sectionmap=mp.getSectionIndexName();
    HashMap classmap1=mp.getClassIndexFromName();
    HashMap sectionmap1=mp.getSectionIndexFromName();
    
    HashMap month1= mp.mapMonth1();
    
    private String[] colnames = null;
    private Object[][] cellvalues = null;
    boolean[] canEdit  = null;
    
    int rowcount=0;
    int columncount=0;

   // Connection con;
    PreparedStatement ps;
    ResultSet rs,rs1;

  ArrayList <String> heads=new ArrayList<String>();

  public MonthlyFeeCollectionClassWiseModel(String month)
  {
       columncount=getColumnCount();
       rowcount=getRowCount(month);

        canEdit = new boolean[columncount];
        colnames = new String[columncount];
        cellvalues=new Object[rowcount+1][columncount];

        System.out.println("Initializing with 0 values");

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

        System.out.println("Calling updateCellValues()");
        updateCellValues(month);
        setTotal();
  }

  public void setTotal()
   {
    double amount=0.0;
    cellvalues[rowcount][0]="Total";

    System.out.println("Setting the total");

    for(int column=3;column<columncount;column++)
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


  public void updateCellValues(String month)
   {
      int i=0,sessionValue=0;

       try
       {
        ps=con.prepareStatement("select sessionid from sessionsetup where status=1");
        rs=ps.executeQuery();
        rs.next();

        sessionValue=rs.getInt(1);
        
        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
         ps=con.prepareStatement("select classtitle,sectiontitle from sectionsetup order by classtitle ");
         rs=ps.executeQuery();

        while(rs.next())
        {
        cellvalues[i][0]=i+1;
        cellvalues[i][1]=String.valueOf(classmap.get(rs.getInt(1)));
        cellvalues[i][2]=String.valueOf(sectionmap.get(rs.getInt(2)));
        
       // System.out.println("inserting class and section at row "+i+" test value "+classmap.get(rs.getInt(1)));
        ps=con.prepareStatement("select SUM(newsurplus),SUM(surplusused),SUM(waiver) from receiptnumber,studententry where studentid=studententry.id and class=? and section=? and date_format(date,'%M')=? and session=?");
        ps.setInt(1,Integer.parseInt(String.valueOf(rs.getInt(1))));
        ps.setInt(2,Integer.parseInt(String.valueOf(rs.getInt(2))));
        ps.setString(3,month);
        ps.setInt(4, sessionValue);
        rs1=ps.executeQuery();

        if(rs1.next())
        {
         cellvalues[i][columncount-4]=rs1.getDouble(1);
         cellvalues[i][columncount-3]=rs1.getDouble(2);
         cellvalues[i][columncount-2]=rs1.getDouble(3);
        }  
        
        ps=con.prepareStatement("select feehead,SUM(totaldues),SUM(totalpaid),SUM(totalremaining),feetype from payreceiptinfo left join receiptnumber on payreceiptinfo.receiptnumber=receipt,studententry where studentid=studententry.id and class=? and section=? and date_format(date,'%M')=? and payreceiptinfo.session=? group by feetype,feehead");
        ps.setInt(1,Integer.parseInt(String.valueOf(rs.getInt(1))));
        ps.setInt(2,Integer.parseInt(String.valueOf(rs.getInt(2))));
        ps.setString(3,month);
        ps.setInt(4, sessionValue);
        rs1=ps.executeQuery();

      String head;
      double prev=0.0;
      double amount=0.0;

      while(rs1.next())
      {
      head=mp.getFeeHeadNameFromFeeTypeAndHeadIndex(rs1.getInt(5), rs1.getInt(1));
     /// System.out.println("Head Print : "+head);
      if(heads.contains(head))
      {
      cellvalues[i][heads.indexOf(head)]=rs1.getDouble(3);
      }
      else
      {
      prev=(Double)cellvalues[i][columncount-6];
      amount=prev+rs1.getDouble(3);
      cellvalues[i][columncount-6]=amount;
      }

      //totaldues
      /*
      prev=(Double)cellvalues[i][columncount-7];
      System.out.println(" prev is "+prev +"+"+rs1.getDouble(2));
      amount=prev+rs1.getDouble(2);
      cellvalues[i][columncount-7]=amount;
       * */

      //totalpaid
      prev=(Double)cellvalues[i][columncount-5];
      amount=prev+rs1.getDouble(3);
      cellvalues[i][columncount-5]=amount;

      //Balance
      /*
      prev=(Double)cellvalues[i][columncount-5];
      amount=prev+rs1.getDouble(4);
      cellvalues[i][columncount-5]=amount;
       * */

     }

      /*
      ps=con.prepareStatement("select SUM(waiver) from receiptnumber,studententry where studentid=id and  class=? and section=? and date_format(date,'%M')=?");
      ps.setInt(1,Integer.parseInt(String.valueOf(rs.getInt(1))));
      ps.setInt(2,Integer.parseInt(String.valueOf(rs.getInt(2))));
      ps.setString(3,month);
      rs1=ps.executeQuery();
      rs1.next();
      cellvalues[i][columncount-2]=rs1.getDouble(1);
       * */

      cellvalues[i][columncount-1]=Double.parseDouble(cellvalues[i][columncount-5].toString())+Double.parseDouble(cellvalues[i][columncount-4].toString())-Double.parseDouble(cellvalues[i][columncount-3].toString())-Double.parseDouble(cellvalues[i][columncount-2].toString());

      i++;
   }       

       //System.out.println("ddddddddd");
     
       // con.close();
     }
   catch(Exception e)
  {
   System.err.println("Error occured " +e);
  }

   }

   public int getRowCount(String month)
  {
      int rcount=0;
      try
        {
       //  con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
         ps=con.prepareStatement("select count(*) as total from sectionsetup");
         rs=ps.executeQuery();
         rs.next();
         rcount+=rs.getInt(1);
        // con.close();
         
        }
   catch(Exception e)
  {
   System.err.println("Error in getting rowcount in class wise fee collection "+e);
  }
  
  return rcount;
  }

 @Override
   public int getColumnCount()
   {
     int count=0;

     count=count+3;
     heads.add("<html>Sr.<br />No.</html>");
     heads.add("<html>Class</html>");
     heads.add("<html>Sec.</html>");

       try
        {

         //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
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
      heads.add("<html>Total Amount<br /> Paid</html>");
     // heads.add("<html>Balance</html>");
      heads.add("<html>Surplus <br />Received</html>");
      heads.add("<html>Surplus <br />Used</html>");
      heads.add("<html>Waiver <br />/Relax. given</html>");
      heads.add("Net Collec.");

     // con.close();
       }
       catch(Exception e)
       {
       System.err.println("Error in calculating total fee heads count");
       }
     System.out.println("Column count ="+count) ;
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
