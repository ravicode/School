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

public class MonthlyFeeDuesModel extends DefaultTableModel
{
    //MapForIndex mp=new MapForIndex();
    HashMap classmap=mp.getClassIndexName();
    HashMap sectionmap=mp.getSectionIndexName();
    HashMap month1= mp.mapMonth1();
    int sessionValue=0;

    private String[] colnames = null;
    private Object[][] cellvalues = null;
    boolean[] canEdit  = null;
    int rowcount=0;
    int columncount=0;

   // Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    ArrayList <String> heads=new ArrayList<String>();
    ArrayList <String> admission=new ArrayList<String>();

    public MonthlyFeeDuesModel(String month)
    {
        try
        {
        ps=con.prepareStatement("select sessionid from sessionsetup where status=1");
        rs=ps.executeQuery();
        rs.next();
        sessionValue=rs.getInt(1);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

       columncount=getColumnCount();
       rowcount=getRowCount(month);

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

        updateCellValues(month);
        setTotal();
    }

 public int getRowCount(String month)
  {
    int rcount=0;
    try
        {
         //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
         ps=con.prepareStatement("select distinct studentid  from feedues where month=? and dues>0 and session=?");
         ps.setInt(1,Integer.parseInt(String.valueOf(month1.get(month))));
         ps.setInt(2, sessionValue);
         System.out.println("Query for calculating rows is ...   "+ps );
         rs=ps.executeQuery();

         while(rs.next())
         rcount++;         
         //con.close();
        }
  catch(Exception e)
  {
   System.out.println("Error in getting rowcount in fee dues");
  }
  System.out.println(" row count= "+rcount);
  return rcount;
  }

   public void setTotal()
   {
    double amount=0.0;
    cellvalues[rowcount][0]="Total";
    System.out.println("Setting the total");
    for(int column=4;column<columncount;column++)
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
      int i=0;
       try
       {
        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
         ps=con.prepareStatement("select distinct studentid,class,section,name,roll from feedues,studententry where id=studentid and month=? and dues>0 and session=? order by  class asc,section asc,roll asc");
         ps.setInt(1,Integer.parseInt(String.valueOf(month1.get(month))));
         ps.setInt(2,sessionValue);
         
        rs=ps.executeQuery();
        while(rs.next())
        {
        cellvalues[i][0]=i+1;
        cellvalues[i][1]=rs.getString(1);
        cellvalues[i][2]=String.valueOf(classmap.get(rs.getInt(2)))+" / "+String.valueOf(sectionmap.get(rs.getInt(3)))+"";
        cellvalues[i][3]=rs.getString(4);
        admission.add(rs.getString(1));
        i++;
        System.out.println("updating row"+i);
        }
        
  for (i=0; i<rowcount; i++)
  {
     String head;
     double prev;
     double amount;

      ps=con.prepareStatement("select head,dues,feetype from feedues where month=? and dues>0 and studentid=?  and session=?");
      ps.setInt(1, Integer.parseInt(String.valueOf(month1.get(month))));
      ps.setString(2, admission.get(i));
      ps.setInt(3, sessionValue);
      rs=ps.executeQuery();
      System.out.println("another query is "+ps);
      while(rs.next())
      {
      head=mp.getFeeHeadNameFromFeeTypeAndHeadIndex(rs.getInt(3), rs.getInt(1));
      if(heads.contains(head))
      {
      cellvalues[i][heads.indexOf(head)]=rs.getDouble(2);
      }
      else
      {
      prev=(Double)cellvalues[i][columncount-2];
      amount=prev+rs.getDouble(2);
      cellvalues[i][columncount-2]=amount;
      }

      //totaldues
      prev=(Double)cellvalues[i][columncount-1];
      amount=prev+rs.getDouble(2);
      cellvalues[i][columncount-1]=amount;
    }
     }
       // con.close();
       }
        catch(Exception e)
  {
   System.err.println("Error in getting cell values in fee dues " +e);
  }

   }

   @Override
   public int getColumnCount()
   {
     int count=0;

     count=count+4;
     heads.add("<html>Sr.<br />No.</html>");
     heads.add("<html>Adm.<br />No.</html>");
     heads.add("<html>Class /<br />Sec.</html>");
     heads.add("Name");
     

       try
        {

        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
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

      count=count+2;
      heads.add("Misc.");
      heads.add("<html>Total<br />Amt.</html>");

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
