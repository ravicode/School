/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.duc.StudentDepartment.SearchStudent;
import java.sql.*;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import net.sf.jasperreports.engine.JRResultSetDataSource;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import com.duc.DatabaseConnection.DatabaseConnection;
/**
 *
 * @author Ravi Dangaich
 */
public class IDCardPrint
{    
   Connection con=DatabaseConnection.con;
   public void printStudentidCard(String id)
    {
               if(id.isEmpty())
     return;
     
     try
     {
         System.out.println("Inside id card printing function");
        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
         HashMap map = new HashMap();
         map.put("id",id);
         
          ps=con.prepareStatement("select institutename, instituteaddress, chiefmobile from instituteregistration");
          rs = ps.executeQuery();
          rs.next();
          map.put("schoolname",rs.getString(1));
          map.put("schooladdress",rs.getString(2)+", Ph. No. - "+rs.getString(3));

           BufferedImage bimg = null;
           bimg = ImageIO.read(new File("images/logo.jpg"));
           map.put("logo",bimg);

            ps=con.prepareStatement("select * from studentpicture where admissionno=?");
            ps.setString(1,id);
            rs=ps.executeQuery();


           if(rs.next())
           {
            /* if(rs.getBinaryStream(2)!=null)
                {
                   bimg =ImageIO.read(rs.getBinaryStream(2));
                   map.put("pic", bimg);
                }*/

               if(rs.getString(2)!=null)
                {
                   bimg =ImageIO.read(new File(rs.getString(2)));
                   map.put("pic", bimg);
                }
           }
            

         ps=con.prepareStatement("select id,name,fathername,(select(date_format(dob,'%M %d , %Y'))) as dob,phone,classtitle,sectiontitle from studententry,classsetup,sectionsetuplist where id=? and class=classid and section=sectionid");
         ps.setString(1,id);
         rs=ps.executeQuery();
         if(!rs.next())
         {
           JOptionPane.showMessageDialog(null, "Invalid Admission Number!","Message",JOptionPane.ERROR_MESSAGE);
          // con.close();
           return;
         }
         rs.previous();


                JRResultSetDataSource src = new JRResultSetDataSource(rs);
                JasperReport js = JasperCompileManager.compileReport("reports/student/idcard.jrxml");
                JasperPrint pr = JasperFillManager.fillReport(js,map,src);
                JasperViewer jv = new JasperViewer(pr, false);
                jv.setTitle("Student ID Card Print ");
                jv.setVisible(true);
              //  con.close();

     }
     
     catch(Exception e)
     {
      System.err.println("Error is ...."+e);
     
     }

    }

   //public Connection con;
   public  PreparedStatement ps;
   public  ResultSet rs;

}
