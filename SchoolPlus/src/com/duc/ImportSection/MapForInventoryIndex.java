/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.duc.ImportSection;
import java.util.HashMap;
import java.sql.*;
import static com.duc.DatabaseConnection.DatabaseConnection.*;
/**
 *
 * @author Ravi
 */
public class MapForInventoryIndex {
 HashMap invname1=new HashMap();
 HashMap invname=new HashMap();
    HashMap category=new HashMap();
    HashMap unit=new HashMap();
    HashMap mode=new HashMap();
    HashMap schoolpurchaser=new HashMap();
    HashMap vendorname=new HashMap();

    HashMap category1=new HashMap();
    HashMap unit1=new HashMap();
    HashMap mode1=new HashMap();
    HashMap schoolpurchaser1=new HashMap();
    HashMap vendorname1=new HashMap();

   public HashMap getCategoryIndexToName()
   {
        try
        {
           // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select invcategory,unitid from invcategorysetup");
            rs=ps.executeQuery();
            while(rs.next())
            {
               category.put(rs.getInt(2),rs.getString(1));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
return category;
   }

   public HashMap getInventoryNameToIndex()
   {
        try
        {
           // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select invname,InventoryId from inventorydeposit");
            rs=ps.executeQuery();
            while(rs.next())
            {
               invname1.put(rs.getString(1),rs.getInt(2));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
return invname1;
   }

    public HashMap getInventoryNameFromIndex()
   {
        try
        {
           // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select invname,InventoryId from inventorydeposit");
            rs=ps.executeQuery();
            while(rs.next())
            {
               invname.put(rs.getInt(2),rs.getString(1));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
return invname;
   }
   public HashMap getUnitIndexToName()
   {
        try
        {
           // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select unit,unitid from inventoryunitsetup");
            rs=ps.executeQuery();
            while(rs.next())
            {
               unit.put(rs.getInt(2),rs.getString(1));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
return unit;
   }

   public HashMap getModeIndexToName()
   {
        try
        {
           // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select mode,unitid from inventorymodesetup");
            rs=ps.executeQuery();
            while(rs.next())
            {
               mode.put(rs.getInt(2),rs.getString(1));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
return mode;
   }

   public HashMap getSchoolPurchaserIndexToName()
   {
        try
        {
           // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select purchaser,unitid from schoolpurchasersetup");
            rs=ps.executeQuery();
            while(rs.next())
            {
               schoolpurchaser.put(rs.getInt(2),rs.getString(1));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
return schoolpurchaser;
   }
   public HashMap getVendorNameIndexToName()
   {
        try
        {
           // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select seller,unitid from inventorysellersetup");
            rs=ps.executeQuery();
            while(rs.next())
            {
               vendorname.put(rs.getInt(2),rs.getString(1));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
return vendorname;
   }


    public HashMap getCategoryIndexFromName()
   {
        try
        {
           // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select invcategory,unitid from invcategorysetup");
            rs=ps.executeQuery();
            while(rs.next())
            {
               category1.put(rs.getString(1),rs.getInt(2));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
return category1;
   }

   public HashMap getUnitIndexFromName()
   {
        try
        {
           // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select unit,unitid from inventoryunitsetup");
            rs=ps.executeQuery();
            while(rs.next())
            {
               unit1.put(rs.getString(1),rs.getInt(2));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
return unit1;
   }

   public HashMap getModeIndexFromName()
   {
        try
        {
           // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select mode,unitid from inventorymodesetup");
            rs=ps.executeQuery();
            while(rs.next())
            {
               mode1.put(rs.getString(1),rs.getInt(2));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
return mode1;
   }

   public HashMap getSchoolPurchaserIndexFromName()
   {
        try
        {
           // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select purchaser,unitid from schoolpurchasersetup");
            rs=ps.executeQuery();
            while(rs.next())
            {
               schoolpurchaser1.put(rs.getString(1),rs.getInt(2));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
return schoolpurchaser1;
   }
   public HashMap getVendorNameIndexFromName()
   {
        try
        {
            //con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select seller,unitid from inventorysellersetup");
            rs=ps.executeQuery();
            while(rs.next())
            {
               vendorname1.put(rs.getString(1),rs.getInt(2));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
return vendorname1;
   }

   // Connection con;
    ResultSet rs;
    PreparedStatement ps;

}
