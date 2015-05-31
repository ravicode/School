/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.duc.Accessories;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Calendar;
import java.util.Formatter;
import static com.duc.DatabaseConnection.DatabaseConnection.*;

/**
 *
 * @author ravi
 */
public class SendSms {

   /* SendSms()
    {
        fromSession();
    }*/

    public void SmsCommon(String studentid,String number,String message,String ip)
    {
       // id=dm.getValueAt(crow,9).toString().trim();
         // System.out.println("number"+id);
        String k ="Response";
        if(1==1)
        {
          if(number.trim().length()!=10)
          {
          JOptionPane.showConfirmDialog(null,"Mobile no. is not valid","Mobile No. Invalid",JOptionPane.OK_OPTION);
      }
      else
      {
        String inputLine;
        System.out.println("Number="+number);
        System.out.println("Message="+message);
         String ul="http://abulksms.com/pushsms.php?username=ravis&password=921695&sender=StCRISPN&cdmasender=mycdmasenderid&to="+number+"&message="+message;
    System.out.println("url="+ul);
        try
        {
        URL yahoo = new URL(ul);
        URLConnection yc = yahoo.openConnection();
        BufferedReader in = new BufferedReader( new InputStreamReader(
                                yc.getInputStream()));


        while ((inputLine = in.readLine()) != null)
        {
            System.out.println(inputLine);
            k=k.concat(inputLine);
        }
        if(k.equals("ResponsePlease add more credits to your account."))
             JOptionPane.showConfirmDialog(null,k,"SMS Sender",JOptionPane.PLAIN_MESSAGE);
        else
            JOptionPane.showConfirmDialog(null,"Message sent successfully","SMS Sender",JOptionPane.PLAIN_MESSAGE);in.close();
in.close();
        store(studentid,number,message,ip);
        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    }
    else
    {
        JOptionPane.showConfirmDialog(null,"Subscribe For SMS package with DUCC Systems..Call 9711496932","No Subscription",JOptionPane.OK_OPTION);
// store(studentid,number,message,ip);
}
    }


    public void store(String studentid,String number,String message,String ip)
    {
        String time=null;
        fromSession();
        try
        {
            ps=con.prepareStatement("insert into smsreport(studentid,phone,message,ip,time,date,session) values(?,?,?,?,?,?,?)");
                    ps.setString(1,studentid);
                    ps.setString(2,number);
            ps.setString(3,message.replace("%20"," "));
            ps.setString(4,ip);
           
         Calendar cal=Calendar.getInstance();
                    time= new Formatter().format("%tl:%tM",cal,cal).toString();
                    ps.setString(5,time);
                     ps.setString(6, datum);
                     ps.setInt(7, sessionValue);
                     ps.executeUpdate();

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void fromSession()
    {
         try
       {
           ps = con.prepareStatement("select sessiontitle,sessionid,status from sessionsetup ");

           rs = ps.executeQuery();
           // int i = 0,j=0;
          while(rs.next())
            {
                //j++;
            //  sessionCombo.addItem(rs.getString(1));

              if(rs.getInt(3)==1)
                 sessionValue=rs.getInt(2);

            }

         }
         catch(Exception e)
         {
             e.printStackTrace();
    }
   }
    ResultSet rs;
PreparedStatement ps;
public Integer sessionValue;
}