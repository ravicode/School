/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.duc.ExaminationDepartment;
import com.duc.DatabaseConnection.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import com.duc.DatabaseConnection.DatabaseConnection;
/**
 *
 * @author ravi
 */
public class test
{
    public  PreparedStatement ps;
    public  ResultSet rs,rs1,rs2;
    Connection con;

    public test()
    {
        
    }
    
    public void updateFeeTypes()
    {
        int cls=0,feehead=0;
        int totaldues=0;
        DecimalFormat format1=new DecimalFormat("###");

          try
  {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("AAAAAAAA");
        con=DriverManager.getConnection("jdbc:mysql://localhost"+":3306/duccschooldb","root","admin");
        ps = con.prepareStatement("select receiptnumber,totaldues,totalpaid from payreceiptinfo where feetype=2 and feehead=-1");
        rs = ps.executeQuery();
        System.out.println("BBBBBBBB");
        while (rs.next())
      {
         if(Integer.parseInt(format1.format(rs.getDouble(2)))>1)
         {
             ps=con.prepareStatement("select studentid from receiptnumber where receipt=?");
        ps.setInt(1, rs.getInt(1));
        rs1=ps.executeQuery();

        rs1.next();
        ps=con.prepareStatement("select class from studententry where id=?");
        ps.setString(1, rs1.getString(1));
        rs2=ps.executeQuery();

        rs2.next();
        cls=rs2.getInt(1);
        totaldues=Integer.parseInt(format1.format(rs.getDouble(2)));

        if(cls<=44)
        {
        if(totaldues==600 || totaldues==700 || totaldues==800)
        feehead=2;

        else if(totaldues==1500)
        feehead=1;

        else if(totaldues==500)
        feehead=3;
        }

        else
        {
        if(totaldues==1500)
        feehead=2;

        else if(totaldues==2000)
        feehead=1;

        else if(totaldues==1200)
        feehead=3;
        }

        ps=con.prepareStatement("update payreceiptinfo set feehead=? where feetype=2 and receiptnumber=? and totaldues=?");

        ps.setInt(1, feehead);
        ps.setInt(2, rs.getInt(1));
        ps.setDouble(3, rs.getDouble(2));
       
        ps.executeUpdate();
        System.out.println("executing.....");
         }
      }        
   }
        catch(Exception e)
        {
          System.err.println("Error in updating"+ e);
          e.printStackTrace();
        }
    }

    public static void main(String args[])
    {
     test t=new test();
     t.updateFeeTypes();
    }
}
