/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.duc.SpecialDepartment.MoreSection.Library;
import java.util.HashMap;
import java.sql.*;
import static com.duc.DatabaseConnection.DatabaseConnection.*;

/**
 *
 * @author sourabh
 */
public class MapForLibrary
{
ResultSet rs;
//Connection con;
PreparedStatement ps;

public HashMap getBookCategoryFromIndex()
{
    HashMap category=new HashMap();
    try
    {
    //con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    ps=con.prepareStatement("select categoryid,categoryname from bookcategory");
    rs=ps.executeQuery();
    while(rs.next())
    {
    category.put(rs.getInt(1),rs.getString(2));
    }
   // con.close();
    }
    catch(Exception e)
    {
    e.printStackTrace();
    }
    return category;
}

public HashMap getBookCategoryIndexFromName()
{
  HashMap category1=new HashMap();
    try
    {
    //con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    ps=con.prepareStatement("select categoryid,categoryname from bookcategory");
    rs=ps.executeQuery();
    while(rs.next())
    {
    category1.put(rs.getString(2),rs.getInt(1));
    }
   // con.close();
    }
    catch(Exception e)
    {
    e.printStackTrace();
    }
    return category1;
}

public HashMap getBookTypeFromIndex()
{
 HashMap type=new HashMap();
    try
    {
    //con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    ps=con.prepareStatement("select typeid,typename from booktype");
    rs=ps.executeQuery();
    while(rs.next())
    {
    type.put(rs.getInt(1),rs.getString(2));
    }
   // con.close();
    }
    catch(Exception e)
    {
    e.printStackTrace();
    }
    return type;
}

public HashMap getBookTypeIndexFromName()
{
 HashMap type1=new HashMap();
    try
    {
    //con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    ps=con.prepareStatement("select typeid,typename from booktype");
    rs=ps.executeQuery();
    while(rs.next())
    {
    type1.put(rs.getString(2),rs.getInt(1));
    }
    //con.close();
    }
    catch(Exception e)
    {
    e.printStackTrace();
    }
    return type1;
}

public HashMap getBookPublisherFromIndex()
{
    HashMap publisher=new HashMap();
    try
    {
    //con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    ps=con.prepareStatement("select publisherid,publishername from bookpublisher");
    rs=ps.executeQuery();
    while(rs.next())
    {
    publisher.put(rs.getInt(1),rs.getString(2));
    }
   // con.close();
    }
    catch(Exception e)
    {
    e.printStackTrace();
    }
    return publisher;
}

public HashMap getBookPublisherIndexFromName()
{
   HashMap publisher1=new HashMap();
    try
    {
   // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    ps=con.prepareStatement("select publisherid,publishername from bookpublisher");
    rs=ps.executeQuery();
    while(rs.next())
    {
    publisher1.put(rs.getString(2),rs.getInt(1));
    }
   // con.close();
    }
    catch(Exception e)
    {
    e.printStackTrace();
    }
    return publisher1;
}

public HashMap getBookVendorFromIndex()
{
  HashMap vendor=new HashMap();
    try
    {
    //con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    ps=con.prepareStatement("select vendorid,vendorname from bookvendor");
    rs=ps.executeQuery();
    while(rs.next())
    {
    vendor.put(rs.getInt(1),rs.getString(2));
    }
   // con.close();
    }
    catch(Exception e)
    {
    e.printStackTrace();
    }
    return vendor;
}

public HashMap getBookVendorIndexFromName()
{
  HashMap vendor1=new HashMap();
    try
    {
   // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    ps=con.prepareStatement("select vendorid,vendorname from bookvendor");
    rs=ps.executeQuery();
    while(rs.next())
    {
    vendor1.put(rs.getString(2),rs.getInt(1));
    }
   // con.close();
    }
    catch(Exception e)
    {
    e.printStackTrace();
    }
    return vendor1;
}

public HashMap getPurchaseAuthorityFromIndex()
{
  HashMap authority=new HashMap();
    try
    {
   // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    ps=con.prepareStatement("select authorityid,authorityname from bookpurchaseauthority");
    rs=ps.executeQuery();
    while(rs.next())
    {
    authority.put(rs.getInt(1),rs.getString(2));
    }
  //  con.close();
    }
    catch(Exception e)
    {
    e.printStackTrace();
    }
    return authority;
}

public HashMap getPurchaseAuthorityIndexFromName()
{
  HashMap authority1=new HashMap();
    try
    {
   // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    ps=con.prepareStatement("select authorityid,authorityname from bookpurchaseauthority");
    rs=ps.executeQuery();
    while(rs.next())
    {
    authority1.put(rs.getString(2),rs.getInt(1));
    }
    //con.close();
    }
    catch(Exception e)
    {
    e.printStackTrace();
    }
    return authority1;
}

 public HashMap getClassIndexName()
    {
        HashMap classmap=new HashMap();
        try
        {
         //   con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select classid,classtitle from classsetup");
            rs=ps.executeQuery();
            while(rs.next())
            {
                classmap.put(rs.getInt(1),rs.getString(2));
            }
//con.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
return classmap;
    }

     public HashMap getSectionIndexName()
    {
         HashMap sectionmap=new HashMap();
         try
        {
          // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select sectionid,sectiontitle from sectionsetuplist");
            rs=ps.executeQuery();
            while(rs.next())
            {
                sectionmap.put(rs.getInt(1),rs.getString(2));
            }
          // con.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
         return sectionmap;
    }

 public HashMap getClassIndexFromName()
    {
     HashMap classmap1=new HashMap();
        try
        {
          // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select classid,classtitle from classsetup");
            rs=ps.executeQuery();
            while(rs.next())
            {
                classmap1.put(rs.getString(2),rs.getInt(1));
            }
//con.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
return classmap1;
    }

   public HashMap getSectionIndexFromName()
    {
          HashMap sectionmap1=new HashMap();
         try
          {
            //con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select sectionid,sectiontitle from sectionsetuplist");
            rs=ps.executeQuery();
            while(rs.next())
            {
                sectionmap1.put(rs.getString(2),rs.getInt(1));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
         return sectionmap1;
    }


}
