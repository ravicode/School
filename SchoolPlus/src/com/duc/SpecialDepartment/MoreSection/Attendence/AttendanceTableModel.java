/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.duc.SpecialDepartment.MoreSection.Attendence;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import static com.duc.DatabaseConnection.DatabaseConnection.*;


/**
 *
 * @author sourabh
 */

public class AttendanceTableModel extends DefaultTableModel
{
    private String[] colnames = null;
    private Object[][] cellvalues = null;
    boolean[] canEdit  = null;
    private int daysCount;

   //Connection con;
   PreparedStatement ps;
   ResultSet rs;

    public AttendanceTableModel(int month,int year,int option)
    {
        daysCount = getLastDay(month, year);
        System.out.println("Days Count "+daysCount);
        init(option);
    }

    public int getLastDay(int month, int year)
    {
        int i=0;
        try
        {
        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
         ps=con.prepareStatement("select day(last_day(?))" );
         ps.setString(1,year+"-"+month+"-"+"1");
         rs=ps.executeQuery();
         rs.next();
         i=rs.getInt(1);
         //con.close();
        }
        catch(Exception e)
        {
          System.err.println("Error in getLastDay()..."+e);
        }
        return i;
    }

    private void init(int option)
    {

        canEdit = new boolean[daysCount+3];
        colnames = new String[daysCount+3];

        if(option==0)
        {
        colnames[0] = "Admission No.";
        colnames[1] = "Roll No.";
        colnames[2] = "Name";
        }

        if(option==1)
        {
        colnames[0] = "Staff Code";
        colnames[1] = "Name";
        colnames[2] = "Phone";
        }

        

        for(int i=0;i<daysCount;i++)
        {
            colnames[i+3] = String.valueOf(i+1);
            System.out.println("Column Title "+colnames[i+3]);
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
