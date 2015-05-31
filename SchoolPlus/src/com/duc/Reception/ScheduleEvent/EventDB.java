/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.duc.Reception.ScheduleEvent;

import java.sql.*;
import java.util.ArrayList;
import static com.duc.DatabaseConnection.DatabaseConnection.*;

/**
 *
 * @author sush
 */
public class EventDB {

    private PreparedStatement ps;
    private ResultSet rs;
    public boolean saveEvent(Event evt)
    {
       try
       {
          // Connection c = new CommonDB().dataConnection();
           ps = con.prepareStatement("insert into event_master(event_detail,"+
                   "type_id,event_date,event_time,event_priority,event_venue,"+
                   "event_remark,event_host) values(?,?,?,?,?,?,?,?)");
           ps.setString(1, evt.eventDetail);
           ps.setInt(2, evt.typeId);
           ps.setString(3, evt.eventDate);
           ps.setString(4, evt.eventTime);
           ps.setString(5, evt.eventCatagory);
           ps.setString(6,evt.eventVenue);
           ps.setString(7,evt.eventRemark);
           ps.setString(8,evt.eventHost);
           ps.executeUpdate();
           //ps.close();
           //c.close();
           return true;
       }
       catch(Exception e)
       {
           System.err.println(e);
           return false;
       }
    }
    public Event loadEventDetail(int id)
    {
        return new Event();
    }

    public ArrayList<Event> loadEvents(String sql)
    {
        System.out.println(" >> "+sql);
        try
        {
           // Connection c = new CommonDB().dataConnection();
            ps = con.prepareStatement("select * from event_master "+sql);
            rs = ps.executeQuery();
            ArrayList<Event> events = new ArrayList<Event>();
            while(rs.next())
            {
                Event e = new Event();
                e.eventId = rs.getInt(1);
                e.eventDetail = rs.getString(2);
                e.typeId = rs.getInt(3);
                e.eventDate = rs.getString(4);
                e.eventTime = rs.getString(5);
                e.eventCatagory = rs.getString(6);
                e.eventVenue = rs.getString(7);
                e.eventRemark = rs.getString(8);
                e.eventHost = rs.getString(9);
                events.add(e);
            }
           // rs.close();
            //ps.close();
           // c.close();
            return events;
        }
        catch(Exception e)
        {
            System.err.println("Error in loading Details "+e);
            return null;
        }
    }

    public void deleteEvent(String sql)
    {
        
    }

    public ArrayList<EventType> loadEventTypes()
    {
        try
        {
            //Connection c = new CommonDB().dataConnection();
            ps = con.prepareStatement("select * from event_type");
            rs = ps.executeQuery();
            ArrayList<EventType> types = new ArrayList<EventType>();
            while(rs.next())
            {
                EventType et = new EventType();
                et.typename = rs.getString(1);
                et.typeId = rs.getInt(2);
                types.add(et);

            }
            //rs.close();
            //ps.close();
           // c.close();
            return types;

        }
        catch(Exception e)
        {
            System.err.println("Error in loading event types "+e);
            return null;
        }
    }
    public boolean addEventType(EventType et)
    {
     try
        {
            int flag=0;
            //Connection c = new CommonDB().dataConnection();
            ps = con.prepareStatement("select * from event_type where type_name=?");
            ps.setString(1, et.typename);
            rs = ps.executeQuery();
            if (rs.next())
            {
               et.typeId = rs.getInt(2);
               System.out.println("Old Type"+ et.typeId);
               flag=1;
            }
            
            
            ps = con.prepareStatement("delete from event_type WHERE type_name=?");
            ps.setString(1, et.typename);
 	    ps.executeUpdate();
            
            if(flag==0)
            {
            System.out.println("New Type");    
            ps = con.prepareStatement("insert into event_type(type_name) values (?)");
            ps.setString(1, et.typename);
            ps.executeUpdate();
            }
            
            else{
            System.out.println("Old Type");     
            ps = con.prepareStatement("insert into event_type(type_name,type_id) values (?,?)");
            ps.setString(1, et.typename);
            ps.setInt(2, et.typeId);
            ps.executeUpdate(); 
            }
           
            
           //ps.close();
          //  c.close();
            return true;
        }
        catch(Exception e)
        {
            System.err.println("Error in saving EventType "+e);
            return false;
        }
    }
    
    
     public boolean deleteEventType(EventType et)
    {
     try
        {
            //Connection c = new CommonDB().dataConnection();
            ps = con.prepareStatement("delete from event_type WHERE type_name=?");
            ps.setString(1, et.typename);
 	    ps.executeUpdate();
           // ps.close();
            //c.close();
            return true;
        }
        catch(Exception e)
        {
            System.err.println("Error in saving EventType "+e);
            return false;
        }
    }
    
     
     public int getTypeId(String et)
    {
         int i=0;
     try
        {
            
            //Connection c = new CommonDB().dataConnection();
            ps = con.prepareStatement("select * from event_type where type_name=?");
            ps.setString(1,et);
 	    rs=ps.executeQuery();
            while (rs.next())
            {
               i = rs.getInt(2);
               System.out.println(i);
            }
           // ps.close();
           // c.close();
            return i;
        }
        catch(Exception e)
        {
            System.err.println("Error "+e);
            return -1;
        }
    }
    
     
     public String getType(int et)
    {
         String i="";
     try
        {
           // Connection c = new CommonDB().dataConnection();
            ps = con.prepareStatement("select * from event_type WHERE type_id =?");
            ps.setInt(1,et);
 	    rs=ps.executeQuery();
            if (rs.next())
            {
               i = rs.getString(1);
            }
           // ps.close();
           // c.close();
            return i;
        }
        catch(Exception e)
        {
            System.err.println("Error"+e);
            return "";
        }
    }
    
    public boolean checkEventType(EventType et)
    {
     try
        {
            //Connection c = new CommonDB().dataConnection();
            ps = con.prepareStatement("insert into event_type(type_name) values (?)");
            ps.setString(1, et.typename);
            ps.executeUpdate();
           // ps.close();
          //  con.close();
            return true;
        }
        catch(Exception e)
        {
            System.err.println("Error in saving EventType "+e);
            return false;
        }
    }

}
