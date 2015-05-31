/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.duc.Reception.ScheduleEvent;

/**
 *
 * @author sush
 */
public class Event {
public String eventDetail;// Details of the event
public int typeId;//
public String eventDate;
public String eventTime;
public String eventCatagory; // Urgent, OK, or AVOID etc
public String eventVenue;
public String eventRemark;
public String eventHost;
public int eventId;

    @Override
public String toString()
{
    return this.eventDetail+"\n ["+this.eventDate+" : "+this.eventTime+"]";
}
}
