/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.duc.SpecialDepartment.TimeTableSection;
import static com.duc.DatabaseConnection.DatabaseConnection.*;
/**
 *
 * @author sourabh
 */

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class TimeTableModel extends DefaultTableModel
{
    private String[] colnames = null;
    private Object[][] cellvalues = null;
    boolean[] canEdit  = null;

  // Connection con;
   PreparedStatement ps;
   ResultSet rs;

   public TimeTableModel( int option)
   {
    System.out.println("calling init");
    init(option);
   }

   public void init(int option)
   {
       System.out.println("Inside Table Model for timetable.");
       try
       {  
        ps=con.prepareStatement("select recess,periodcode,starthour,startminute,endhour,endminute,id from timetableperiods order by id");
        rs=ps.executeQuery();

        int i=0,j=0,count=0;
        String s="";
        while(rs.next())
        {
         count++;
        }
        rs.first();
        rs.previous();

        canEdit = new boolean[count+1];
        colnames = new String[count+1];
        if(option==1)
        colnames[0]="Absent Teacher";
        else if(option==0)
        colnames[0]="Days";
        else if(option==2)
        colnames[0]="Teacher";
        else if(option==3)
        colnames[0]="Class-Section";

         for(i=1;i<=count;i++)
        {
            rs.next();            
            s=rs.getString(2);
            String timing= "[ "+rs.getString(3)+":"+rs.getString(4)+" - "+rs.getString(5)+":"+rs.getString(6)+" ]";
            colnames[i] ="<html><font color='blue' size=3>"+s+"</font> <br /><font color='red' size=3>"+timing+"</font></html>";
           
        }     
       }
       catch(Exception e)
       {
         System.err.println("Error in loading table model.");
       }
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
