/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.duc.DatabaseConnection;
import com.duc.ImportSection.MapForIndex;
import com.duc.ImportSection.MapForInventoryIndex;
import java.io.FileInputStream;
import java.net.InetAddress;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.text.DateFormat;

/**
 *
 * @author ravi
 */


public class DatabaseConnection{

   String username,password;
   public static String url;
    public Connection dataConnection1()
    {
        // String db = null;
        Properties props=new Properties();
      
        try
    {
             FileInputStream in=new FileInputStream("database.properties");
            props.load(in);
            in.close();
             url=props.getProperty("jdbc.url");
             username=props.getProperty("jdbc.username");
             password=props.getProperty("jdbc.password");

              df=new SimpleDateFormat("yyyy-MM-dd");
            datum=new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
            try
            {
                if(con==null)
          db1="duccschooldbnew";
         else db1=SchoolPlus.LoginScreen.rd;

            
        Class.forName("com.mysql.jdbc.Driver");

        System.out.println("Entering Database ");
        con=DriverManager.getConnection("jdbc:mysql://"+url+":3306/"+db1,username,password);
        System.out.println("the databse is connected");
        System.out.println("con on lan="+con);
        // System.out.println("ffffff"+url);

    try
    {
      mp=new MapForIndex();
      mpi=new MapForInventoryIndex();  
    }
    catch(Exception e)
    {
        System.out.println("error in taking maps"+ e);
    }

    }
    catch(Exception e)
    {
        System.out.println("the exception is of LAN setting "+e);

       try
        {
             InetAddress thisIp =InetAddress.getLocalHost();
          url=thisIp.getHostAddress();
         con=DriverManager.getConnection("jdbc:mysql://"+url+":3306/"+db1,username,password);
          System.out.println("now.. you are using the database on your own system...No more Category C IP is used..");
           System.out.println("con on localhost="+con);
           System.out.println("Database of localhost active... ");
         
           // mp=new MapForIndex();
          /// mpi=new MapForInventoryIndex();
        
        }catch(Exception e1)
        {
            System.out.println("error no 1"+e1);
        }
      }
        }
    catch(Exception e2)
    {
       System.out.println("error no 2 "+e2);
    }        
 return con;
    }




     public static void main(String args[])
     {
new DatabaseConnection().dataConnection1();
     }

   public static Connection con;
   ResultSet rs;
PreparedStatement ps;
public static String datum=null;
public static DateFormat df;
public static MapForIndex mp;
public static MapForInventoryIndex mpi;
public static String db1=null;
}


