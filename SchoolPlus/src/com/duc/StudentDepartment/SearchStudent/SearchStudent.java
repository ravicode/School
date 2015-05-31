/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SearchStudent.java
 *
 * Created on Dec 20, 2009, 2:14:07 PM
 */

package com.duc.StudentDepartment.SearchStudent;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.DefaultFontMapper;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JTable.PrintMode;
import java.text.MessageFormat;
import static com.duc.DatabaseConnection.DatabaseConnection.*;
import java.util.Vector;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.jdesktop.swingx.decorator.HighlighterFactory;
import java.io.*;
import java.net.InetAddress;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;
/**
 *
 * @author Ravi
 */
public class SearchStudent extends javax.swing.JInternalFrame {
DefaultTableModel dm;

HashMap classmap=new HashMap();
    HashMap sectionmap=new HashMap();

    HashMap classmap1=new HashMap();
    HashMap sectionmap1=new HashMap();
    HashMap category1=mp.getCategoryIndexFromName();
    HashMap category=mp.getCategoryNameFromIndex();
    //DateFormat df;
HashMap categorysubmap=mp.getCategorySlabNameFromIndex();

 HashMap sessionmap1=mp.getSessionIndexFromName();
    HashMap sessionmap=mp.getSessionIndexToName();
    /** Creates new form SearchStudent */
    public SearchStudent() {
        initComponents();
         pack();
       // this.setLocationRelativeTo(null);
        //setLocation(0,50);
        getClassIndexName();
       getSectionIndexName();

        getClassIndexFromName();
       getSectionIndexFromName();
        fromClass();
        fromCategory();
fromReligion();
        jTable1.setHighlighters(HighlighterFactory.createAlternateStriping());
        jTable1.setHorizontalScrollEnabled(true);
        dm = (DefaultTableModel) jTable1.getModel();
        dm.setRowCount(0);
         jTextField2.setVisible(false);
        // df=new SimpleDateFormat("yyyy-MM-dd");
         admissionDate.setDateFormat(df);
         
birthDate.setDateFormat(df);

fromSession();
garbageCollection();

//showAllnExStudentDetail();
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
              sessionCombo.addItem(rs.getString(1));

             // if(rs.getInt(3)==1)
               //   sessionValue=rs.getInt(2);

            }



         }
         catch(Exception e)
         {
             e.printStackTrace();
    }



    }

    public void garbageCollection()
    {
        int SIZE = 200;
        StringBuffer s;
    for (int i = 0; i < SIZE; i++) {
    }
    System.out.println("Garbage Collection started explicitly.");
    long time = System.currentTimeMillis();
    System.gc();
    System.out.println("It took " + (System.currentTimeMillis()-time) + " ms");

    }
    public void fromReligion()
    {
        try
    {

// con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


         ps = con.prepareStatement("select * from religionsetup");

             rs = ps.executeQuery();


            while (rs.next())
            {
        religionCombo.addItem(rs.getString(1));


            }



    }
    catch(Exception e)
    {
        System.err.println("Error is"+e);
    }

    }
 public void getClassIndexName()
    {
        try
        {
            //con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select classid,classtitle from classsetup");
            rs=ps.executeQuery();
            while(rs.next())
            {
                classmap.put(rs.getInt(1),rs.getString(2));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }

     public void getSectionIndexName()
    {
         try
        {
             // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select sectionid,sectiontitle from sectionsetuplist");
            rs=ps.executeQuery();
            while(rs.next())
            {
                sectionmap.put(rs.getInt(1),rs.getString(2));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

     public void getClassIndexFromName()
    {
        try
        {
           // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select classid,classtitle from classsetup");
            rs=ps.executeQuery();
            while(rs.next())
            {
                classmap1.put(rs.getString(2),rs.getInt(1));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }

     public void getSectionIndexFromName()
    {
         try
        {
            //  con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
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
    }


 public void fromClass()
    {
         try
    {

// con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


         ps = con.prepareStatement("select * from classsetup");

             rs = ps.executeQuery();


            while (rs.next())
            {
        searchClassCombo.addItem(rs.getString(1));


            }



    }
    catch(Exception e)
    {
        System.err.println("Error is"+e);
    }

    }
public void fromCategory()
    {
         try
    {

 //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


         ps = con.prepareStatement("select * from categorysetup");

             rs = ps.executeQuery();


            while (rs.next())
            {
        studentCategory.addItem(rs.getString(1));


            }
//jTable1.getColumnModel().getColumn(2).setWidth(WIDTH);


    }
    catch(Exception e)
    {
        System.err.println("Error is"+e);
    }

    }
    public void fromSection()
    {
        try
    {

 // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


         ps = con.prepareStatement("select  * from sectionsetuplist");

             rs = ps.executeQuery();


            while (rs.next())
            {
        searchSectionCombo.addItem(rs.getString(1));


            }



    }
    catch(Exception e)
    {
        System.err.println("Error is"+e);
    }


    }


public void classFilter()
    {
         //  con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        try
        {
            ps = con.prepareStatement("select * from sectionsetup where classtitle=?");
            ps.setInt(1, Integer.parseInt(classmap1.get(searchClassCombo.getSelectedItem().toString()).toString()));
             rs = ps.executeQuery();
            int i = 0,j=0;

searchSectionCombo.removeAllItems();

            while(rs.next())
            {

                searchSectionCombo.addItem(sectionmap.get(rs.getInt(2)));

            }


//con.close();
           // System.out.print("Database connection closed");


        }  catch(Exception e)
        {
            e.printStackTrace();
        }


    }
public void sectionFilter()
    {
         int i = 0,j=0;
         //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        try
        {
            ps = con.prepareStatement("select * from studententry where class =? and section=?");
            ps.setInt(1, Integer.parseInt(classmap1.get(searchClassCombo.getSelectedItem().toString()).toString()));
            ps.setInt(2, Integer.parseInt(sectionmap1.get(searchSectionCombo.getSelectedItem().toString()).toString()));
             rs = ps.executeQuery();


             searchRollCombo.removeAllItems();

            while(rs.next())
            {

                searchRollCombo.addItem(rs.getInt(11));
                i++;

            }


//con.close();
           // System.out.print("Database connection closed");


        }  catch(Exception e)
        {
            e.printStackTrace();
        }
jLabel12.setText(String.valueOf(i));

    }
public void classStudentFilter()
{
    //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        try
        {
            ps = con.prepareStatement("select *from studententry where class =?");
            ps.setInt(1, Integer.parseInt(classmap1.get(searchClassCombo.getSelectedItem().toString()).toString()));
           // ps.setString(2, jComboBox2.getSelectedItem().toString());
             rs = ps.executeQuery();
            int i = 0,j=0;

searchRollCombo.removeAllItems();

            while(rs.next())
            {

                searchRollCombo.addItem(rs.getInt(11));

            }


//con.close();
           // System.out.print("Database connection closed");


        }  catch(Exception e)
        {
            e.printStackTrace();
        }


}

public void studentDetailOnBasisOfSection()
{
   // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


     try
     {
       ps=con.prepareStatement("select * from studententry left join studentdetail on studententry.id=studentdetail.id  where class= ? and section=? and status!=0") ;
      ps.setInt(1,Integer.parseInt(classmap1.get(searchClassCombo.getSelectedItem()).toString()));
      ps.setInt(2,Integer.parseInt(sectionmap1.get(searchSectionCombo.getSelectedItem()).toString()));
      System.out.println("n");
       rs=ps.executeQuery();
     // System.out.println("gender"+rs);

studentDetail(rs);
   }catch(Exception e)
   {
e.printStackTrace();
   }

}
public void studentDetail(ResultSet rs)
{
     int i=0,j=0;

    try{
        if(rs.next())
        {
        rs.first();
        rs.previous();

              while(rs.next())
            {
                j++;
             
            }
            rs.first();
            rs.previous();
            dm.setRowCount(j);
            while(rs.next())
            {
if(rs.getInt(14)==0)
{


               dm.setValueAt(sectionmap.get(rs.getInt(10))+ " / Ex.Std.", i, 4);

            }
else
{
   dm.setValueAt(sectionmap.get(rs.getInt(10)), i, 4);

}
 dm.setValueAt(rs.getString(1), i, 0);
dm.setValueAt(rs.getString(2), i, 1);
                dm.setValueAt(rs.getInt(11), i, 2); // changed here recently 
                dm.setValueAt(classmap.get(rs.getInt(9)), i, 3);
                //dm.setValueAt(rs.getString(10), i, 4);
                dm.setValueAt(rs.getString(8), i, 5);
                dm.setValueAt(rs.getString(3), i, 6);
                dm.setValueAt(rs.getString(4), i, 7);
                dm.setValueAt(rs.getString(5), i, 8);
                dm.setValueAt(rs.getString(6), i, 9);

                dm.setValueAt(category.get(rs.getString(21)), i, 10);
                dm.setValueAt(categorysubmap.get(rs.getInt(30)), i, 11);
                dm.setValueAt(rs.getString(31), i, 12);
                dm.setValueAt(rs.getString(32), i, 13);
                dm.setValueAt(rs.getString(33), i, 14);
                dm.setValueAt(rs.getString(34), i, 15);
                //if(!rs.getString(21).isEmpty())
                //dm.setValueAt(category1.get(rs.getString(21)), i, 9);
                i++;

         /*   if(rs.getString(8).equals(datum))
                {
                   dm.setValueAt(rs.getString(8), i, 5);
                  
                }*/

            }
        }
        else dm.setRowCount(0);
    }catch(Exception e)
    {
        e.printStackTrace();
    }
    jLabel12.setText(String.valueOf(i));
}


public void studentDetail1(ResultSet rs)
{
     int i=0,j=0;

    try{
        if(rs.next())
        {
        rs.first();
        rs.previous();

              while(rs.next())
            {
                j++;

            }
            rs.first();
            rs.previous();
            dm.setRowCount(j);
            while(rs.next())
            {
if(rs.getInt(20)==0)
{


               dm.setValueAt(sectionmap.get(rs.getInt(16))+ " / Ex.Std.", i, 4);

            }
else
{
   dm.setValueAt(sectionmap.get(rs.getInt(16)), i, 4);

}
 dm.setValueAt(rs.getString(1), i, 0);
dm.setValueAt(rs.getString(8), i, 1);
                dm.setValueAt(rs.getString(17), i, 2);
                dm.setValueAt(classmap.get(rs.getInt(15)), i, 3);
                //dm.setValueAt(rs.getString(10), i, 4);
                dm.setValueAt(rs.getString(14), i, 5);
                dm.setValueAt(rs.getString(9), i, 6);
                dm.setValueAt(rs.getString(10), i, 7);
                dm.setValueAt(rs.getString(11), i, 8);
                dm.setValueAt(rs.getString(12), i, 9);
               //if(!rs.getString(21).isEmpty())
               // dm.setValueAt(category.get(rs.getString(21)), i, 10);
                i++;

         //  if(rs.getString(8).equals(datum))
           //     {
             //      dm.setValueAt(rs.getString(8), i, 5);

               // }

            }
        }
        else dm.setRowCount(0);
    }catch(Exception e)
    {
        e.printStackTrace();
    }
    jLabel12.setText(String.valueOf(i));
}

public void studentDetailOnBasisOfClass()
{
  try
     {
       ps=con.prepareStatement("select * from studententry left join studentdetail on studententry.id=studentdetail.id  where class= ? and status!=0") ;
      ps.setInt(1,Integer.parseInt(classmap1.get(searchClassCombo.getSelectedItem().toString()).toString()));
         //ps.setInt(2,id);
      System.out.println("n");
       rs=ps.executeQuery();
      studentDetail(rs);

   }catch(Exception e)
   {
e.printStackTrace();
   }

}

   public void ReAdmissionStudent()
    {
         int crow=jTable1.convertRowIndexToModel(jTable1.getSelectedRow());
        String id=dm.getValueAt(crow,0).toString();
   //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
     {
    

        ps=con.prepareStatement("update studententry set status=? where id=?") ;
       ps.setInt(1,1);
        ps.setString(2,id);
      ps.executeUpdate();
    }
     catch(Exception e)
     {
         e.printStackTrace();
     }
    }
    public void doAgeCalculation()
    {
        try
        {
            String id,ageapril,agesep,agefirst;
            int d1,m1,y1;
            int d2=1,m2=4,y2;
            int m22, y22, d22;
            int day,month,year;
            int day_s,month_s,year_s,firstid,classid;


          //  con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

            ps=con.prepareStatement("delete from agecalculation");
            ps.executeUpdate();

          System.out.println("PPPPPPPPPPPP");

            ps=con.prepareStatement("select classid from classsetup where classtitle='1st'");
            rs=ps.executeQuery();
            rs.next();
            firstid=rs.getInt(1);

            ps=con.prepareStatement("select date_format(current_date(),'%Y') as y2");
            rs=ps.executeQuery();
            rs.next();
            y2=rs.getInt(1);
            System.out.println("current year"+y2);

           //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
           ps=con.prepareStatement("select id,date_format(dob,'%d') as d1,date_format(dob,'%m') as m1,date_format(dob,'%Y') as y1 , class from studententry ");
           rs=ps.executeQuery();

           while(rs.next())
           {
               d1=0; m1=0; y1=0;
               d22=d2; m22=m2; y22=y2;

               try
               {
                d1=rs.getInt(2);
                m1=rs.getInt(3);
                y1=rs.getInt(4);
               // System.out.println("\n Values "+d1+"-"+m1+"-"+y1+" , "+rs.getString(5));
               }

               catch(Exception e)
               {
                 System.err.println("Error data fetch "+e);
               }

               if(d1>d22)
               {
                //System.out.print(" , d1>d2 and m2="+m22);
                day=(d22+30)-d1;
                m22=m22-1;
                //System.out.print(" now m2 is="+m22);
               }
               else
               day=0;

               if(m1>m22)
               {
               // System.out.print(" , m1>m2");
               // System.out.print(" ,m2="+m22 +" and  m1="+m1);
                month=(m22+12)-m1;
                y22=y22-1;
               }
               else
               month=m22-m1;
               year=y22-y1;

               if(year>0)
               ageapril=year+" Year, "+month+" Month, "+day+" Day";
               else
               ageapril="";

               System.out.println("Age in april "+ageapril);
             //System.out.print(",  Year:"+year+" Month:"+month+" Day:"+day);
              if(day>0)
              day_s=day-1;
              else
              day_s=day;

              month_s=month+6;
              year_s=year;

              if(month_s>12)
              {
              month_s=month_s-12;
              year_s=year+1;
              }

              if(year_s>0)
              agesep=year_s+" Year, "+month_s+" Month, "+day_s+" Day";
              else
              agesep="";

              System.out.println("Age in sep "+agesep);

              ps=con.prepareStatement("select classid from classsetup where classtitle=?");
              ps.setString(1,rs.getString(5));
              rs1=ps.executeQuery();
              rs1.next();
              classid=rs1.getInt(1);
              System.out.println(classid);

              if(classid>=firstid)
              {
               int diff=year-(classid-firstid);
               agefirst=diff+" Year, "+month+" Month, "+day+" Day";
               if(diff<=0)
               agefirst="";
              }
              else
             agefirst="";

            System.out.println("Age in first class "+agefirst);

            ps=con.prepareStatement("insert into agecalculation (sid,ageinapril,ageinsep,ageinfirst) values(?,?,?,?)");
            ps.setString(1,rs.getString(1));
            ps.setString(2, ageapril);
            ps.setString(3, agesep);
            ps.setString(4, agefirst);
            ps.executeUpdate();

            System.out.println(rs.getString(1));
           }
          // con.close();
        }
        catch(Exception e)
        {
           System.err.println("Error in age calculation "+e);
        }
    }

    public void completeStudentBioDataReport()
    {
        HashMap map = new HashMap();
        try
        {

          ps=con.prepareStatement("select institutename, instituteaddress from instituteregistration" );
          rs = ps.executeQuery();
          rs.next();
          map.put("schoolname",rs.getString(1));
          map.put("schooladdress",rs.getString(2));

           BufferedImage bimg = null;
           bimg = ImageIO.read(new File("images/logo.jpg"));
           map.put("logo",bimg);

          ps=con.prepareStatement("select id,name,fathername,mothername,classtitle,sectiontitle,roll,phone,address,date_format(dob,'%d.%m.%Y') as dob,ageinapril,ageinsep,ageinfirst from studententry left join agecalculation on id=sid,classsetup,sectionsetuplist where studententry.class=classid and section=sectionid order by studententry.class,section,roll");
          rs=ps.executeQuery();

                JRResultSetDataSource src = new JRResultSetDataSource(rs);
                JasperReport js = JasperCompileManager.compileReport("reports/student/biodata.jrxml");
                JasperPrint pr = JasperFillManager.fillReport(js,map,src);
                JasperViewer jv = new JasperViewer(pr, false);
                jv.setTitle("Students' Bio Data Report ");
                jv.setVisible(true);
        //  con.close();
        }
        catch(Exception e)
        {
          System.out.println("Error in BioData Report"+ e );
        }
    }

     public void printIDCards()
    {
       int j=dm.getRowCount();
       if(j<=0)
       return;

       System.out.println("printing bulk ID Cards");

       String id="";
       String father="";
       String dob="";
       String name="";
       String cls="";
       String section="";
       String phone="";

       Vector collection=new Vector();

       try
       {
        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
         HashMap map = new HashMap();

          ps=con.prepareStatement("select institutename, instituteaddress, chiefmobile from instituteregistration" );
          rs = ps.executeQuery();
          rs.next();
          map.put("schoolname",rs.getString(1));
          map.put("schooladdress",rs.getString(2)+ ", Ph. No. - "+rs.getString(3));

           BufferedImage bimg = null;
           bimg = ImageIO.read(new File("images/logo.jpg"));
           map.put("logo",bimg);

         for(int i=0;i<j;i++)
         {
          bimg=null;
          dob=null;

          id=(String)dm.getValueAt(i, 0);
          name=(String)dm.getValueAt(i, 1);
          father=(String)dm.getValueAt(i, 6);
          cls=(String)dm.getValueAt(i,3);
          section=(String)dm.getValueAt(i,4);
          phone=(String)dm.getValueAt(i,8);

            ps=con.prepareStatement("select * from studentpicture where admissionno=?");
            ps.setString(1,id);
            rs=ps.executeQuery();

            while(rs.next())
              {
                /*if(rs.getBinaryStream(2)!=null)
                 {
                   bimg =ImageIO.read(rs.getBinaryStream(2));
                   System.out.println("reading image for studdent "+id);
                 }*/
                if(rs.getString(2)!=null)
                 {
                   bimg =ImageIO.read(new File(rs.getString(2)));
                   System.out.println("reading image for studdent "+id);
                 }
               }

         ps=con.prepareStatement(" select date_format(dob,'%M %d , %Y') from studententry where id=?");
         ps.setString(1,id);
         rs=ps.executeQuery();

          if(rs.next())
          dob=rs.getString(1);

         System.out.println("Adding student "+ i +" Admission number "+id);
         collection.add(new StudentId(name, id, father, dob, bimg,cls,section,phone));
         }
                JRBeanCollectionDataSource src = new JRBeanCollectionDataSource(collection);
                JasperReport js = JasperCompileManager.compileReport("reports/student/bulk_idcards.jrxml");
                JasperPrint pr = JasperFillManager.fillReport(js,map,src);
                JasperViewer jv = new JasperViewer(pr, false);
                jv.setTitle("Students' ID Card Print ");
                jv.setVisible(true);
              //  con.close();
         }
       catch(Exception e)
       {
          System.err.println("Error is "+ e);
       }

    }

     public void deletePermanent()
     {
         int choose=JOptionPane.showConfirmDialog(null,"Do you Delete this student permanently?","Delete Student",JOptionPane.OK_OPTION);
         if(choose==JOptionPane.OK_OPTION)
         {
         int crow=jTable1.convertRowIndexToModel(jTable1.getSelectedRow());
        String id=dm.getValueAt(crow,0).toString();
  // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
     {
      ps=con.prepareStatement("delete from studententry where id=?") ;
      ps.setString(1,id);
      ps.executeUpdate();
      com.duc.StudentDepartment.SearchStudent.PermanentDeleteOffRecords rr=new com.duc.StudentDepartment.SearchStudent.PermanentDeleteOffRecords();
      jDesktopPane1.add(rr);
      rr.setVisible(true);
      rr.id=id;
      rr.setFlag(1);
     }catch(Exception e)
     {
         e.printStackTrace();
     }
     }
     }

    public void deleteStudent()
{

     int crow=jTable1.convertRowIndexToModel(jTable1.getSelectedRow());

        String id=dm.getValueAt(crow,0).toString();
        int choose=JOptionPane.showConfirmDialog(null,"Do u want to make this Ex-Student"+dm.getValueAt(crow,0).toString(),"Ex-confirmation",JOptionPane.OK_OPTION);
        if(choose==JOptionPane.OK_OPTION)
        {
 //  con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
     {
     
ps=con.prepareStatement("select * from feedues where studentid=? and dues!=0");
ps.setString(1,id);
rs=ps.executeQuery();
if(rs.next())
{
      JOptionPane.showConfirmDialog(null,"Clear The Dues First","Dues Pending",JOptionPane.OK_OPTION);
    com.duc.FeeDepartment.FeeCounter1 r=   new com.duc.FeeDepartment.FeeCounter1();
       jDesktopPane1.add(r);
      r.setVisible(true);
         r.setAdmissionNo(id);

         ps=con.prepareStatement("select * from studentsurplus where studentid=? and surplus!=0");
ps.setString(1,id);
rs=ps.executeQuery();
if(rs.next())
{
      JOptionPane.showConfirmDialog(null,"Clear The Advance Payment after Dues payment","Advance Payment Pending",JOptionPane.OK_OPTION);
    com.duc.FeeDepartment.AdvancePaymentGUI1 r2=   new com.duc.FeeDepartment.AdvancePaymentGUI1();
       jDesktopPane1.add(r2);
      r2.setVisible(true);
         r2.setAdmissionNoPayment(id);
}
}
else
{
ps=con.prepareStatement("select * from studentsurplus where studentid=? and surplus!=0");
ps.setString(1,id);
rs=ps.executeQuery();
if(rs.next())
{
      JOptionPane.showConfirmDialog(null,"Clear The Advance Payment","Advance Payment Pending",JOptionPane.OK_OPTION);
    com.duc.FeeDepartment.AdvancePaymentGUI1 r2=   new com.duc.FeeDepartment.AdvancePaymentGUI1();
       jDesktopPane1.add(r2);
      r2.setVisible(true);
         r2.setAdmissionNoPayment(id);
}
else
{
    ps=con.prepareStatement("update studententry set status=? where id=?") ;

       ps.setInt(1,0);
        ps.setString(2,id);
      ps.executeUpdate();
      com.duc.StudentDepartment.SearchStudent.PermanentDeleteOffRecords rr=new com.duc.StudentDepartment.SearchStudent.PermanentDeleteOffRecords();
      jDesktopPane1.add(rr);
      rr.setVisible(true);
      rr.id=id;
}
}   }
     catch(Exception e)
     {
         e.printStackTrace();
     }
    }
}
   public void showAllStudentDetail()
   {
    //   con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


         int i=0,j=0;

     try
     {
       ps=con.prepareStatement("select * from studententry left join studentdetail on studententry.id=studentdetail.id   where status!=0") ;

       rs=ps.executeQuery();
      studentDetail(rs);

   }catch(Exception e)
   {
e.printStackTrace();
   }
   }

   public void religionFilter()
   {
        int i=0,j=0;
    // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
     try
     {
         ps=con.prepareStatement("select * from studententry left join studentdetail on studententry.id=studentdetail.id where religion=?") ;
      ps.setString(1,religionCombo.getSelectedItem().toString());

      System.out.println("n");
       rs=ps.executeQuery();
      
       studentDetail(rs);
     }catch(Exception e)
     {
e.printStackTrace();
     }
   }
   public void showAllnExStudentDetail()
   {
       //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


         int i=0,j=0;

     try
     {
       ps=con.prepareStatement("select * from studententry left join studentdetail on studententry.id=studentdetail.id  ") ;

       rs=ps.executeQuery();
       if(rs.next())
       {
           rs.first();
           rs.previous();

      studentDetail(rs);
       }

   }catch(Exception e)
   {
e.printStackTrace();
   }
   }

    public void showExStudentDetail()
   {
     //  con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


         int i=0,j=0;

     try
     {
       ps=con.prepareStatement("select * from studententry left join studentdetail on studententry.id=studentdetail.id  where status=0") ;

       rs=ps.executeQuery();
      studentDetail(rs);

   }catch(Exception e)
   {
e.printStackTrace();
   }
   }
    public void categoryFilter()
{
    int i=0,j=0;
    // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
     try
     {
         if(jCheckBox4.isSelected())
         {
         ps=con.prepareStatement("select * from studententry left join studentdetail on studententry.id=studentdetail.id where category=? and class=?") ;
      ps.setString(1,category1.get(studentCategory.getSelectedItem().toString()).toString());
      ps.setString(2,classmap1.get(searchClassCombo.getSelectedItem()).toString());
         }
         else
         {
            ps=con.prepareStatement("select * from studententry left join studentdetail on studententry.id=studentdetail.id where category=?") ;
      ps.setString(1,category1.get(studentCategory.getSelectedItem().toString()).toString());

         }
      System.out.println("n");
       rs=ps.executeQuery();
      studentDetail(rs);

     }catch(Exception e)
     {
e.printStackTrace();
     }
}


    public void studentDetailOnBasisOfId()
{
   //  con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


         int i=0,j=0;

     try
     {
       ps=con.prepareStatement("select * from studententry left join studentdetail on studententry.id=studentdetail.id   where studententry.id like ?") ;
      ps.setString(1,admissionNo.getText()+"%");
         //ps.setInt(2,id);
      System.out.println("n");
       rs=ps.executeQuery();
      studentDetail(rs);

   }catch(Exception e)
   {
e.printStackTrace();
   }
}

public void studentDetailOnBasisOfName()
{
    // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


         int i=0,j=0;

     try
     {
       ps=con.prepareStatement("select * from studententry left join studentdetail on studententry.id=studentdetail.id   where name like ?") ;
      ps.setString(1,studentName.getText()+"%");
         //ps.setInt(2,id);
      System.out.println("n");
       rs=ps.executeQuery();
      studentDetail(rs);

   }catch(Exception e)
   {
e.printStackTrace();
   }
}
public void studentDetailOnBasisOfFatherName()
{
    // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


         int i=0,j=0;

     try
     {
       ps=con.prepareStatement("select * from studententry left join studentdetail on studententry.id=studentdetail.id  where fathername like ?") ;
      ps.setString(1,fatherName.getText()+"%");
         
      System.out.println("n");
       rs=ps.executeQuery();
      studentDetail(rs);

   }catch(Exception e)
   {
e.printStackTrace();
   }
}
public void studentDetailOnBasisOfDoa(String t)
{
    // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


         int i=0,j=0;

     try
     {
       ps=con.prepareStatement("select * from studententry left join studentdetail on studententry.id=studentdetail.id   where doa=?") ;
     ps.setString(1, t);
         //ps.setInt(2,id);
      System.out.println("n");
       rs=ps.executeQuery();
      studentDetail(rs);

   }catch(Exception e)
   {
e.printStackTrace();
   }
}
public void studentDetailOnBasisOfBirthDate(String t)
{
    // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


         int i=0,j=0;

     try
     {
       ps=con.prepareStatement("select * from studententry left join studentdetail on studententry.id=studentdetail.id   where dob=?") ;
      ps.setString(1, t);
         //ps.setInt(2,id);
      System.out.println("n");
       rs=ps.executeQuery();
      studentDetail(rs);

   }catch(Exception e)
   {
e.printStackTrace();
   }
}

public void genderFilter()
{
    String sex=null;
    if(genderCombo.getSelectedItem().equals("Male"))
        sex="M";
    else
        sex="F";
         int i=0,j=0;

     try
     {
       ps=con.prepareStatement("select * from studententry left join studentdetail on studententry.id=studentdetail.id  where sex=?") ;
      ps.setString(1, sex);
         //ps.setInt(2,id);
      System.out.println("n");
       rs=ps.executeQuery();
      studentDetail(rs);

   }catch(Exception e)
   {
e.printStackTrace();
   }
}

public void sessionFilter()
{
    String sex=null;

         int i=0,j=0;
         Date startdate = null,enddate = null;

     try
     {
         ps=con.prepareStatement("select * from sessionsetup   where sessionid=?") ;
      ps.setInt(1,Integer.parseInt(sessionmap1.get(sessionCombo.getSelectedItem()).toString()));
         rs1=ps.executeQuery();
         if(rs1.next())
         {
             startdate=rs1.getDate(5);
             enddate=rs1.getDate(6);
         
       ps=con.prepareStatement("select * from studententry left join studentdetail on studententry.id=studentdetail.id where doa >= ? and doa <= ?") ;
      ps.setDate(1, startdate);
      ps.setDate(2, enddate);
      //ps.setInt(2,id);
      System.out.println("n");
       rs=ps.executeQuery();
      studentDetail(rs);
         }

   }catch(Exception e)
   {
e.printStackTrace();
   }
}

public void studentDetailOnBasisOfAddressOrBoard()
{
    // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


         int i=0,j=0;

     try
     {
       ps=con.prepareStatement("select * from studententry left join studentdetail on studententry.id=studentdetail.id  where address like ?") ;
      ps.setString(1,boardingStop.getText()+"%");
         //ps.setInt(2,id);
      System.out.println("n");
       rs=ps.executeQuery();
      studentDetail(rs);

   }catch(Exception e)
   {
e.printStackTrace();
   }
}
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JSeparator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JSeparator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JSeparator();
        jMenuItem13 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JSeparator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JSeparator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JSeparator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JSeparator();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JSeparator();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        jMenuItem8 = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JSeparator();
        jMenuItem9 = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JSeparator();
        jMenuItem10 = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JSeparator();
        jMenuItem11 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuItem12 = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JSeparator();
        jMenuItem14 = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JSeparator();
        jMenuItem15 = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        searchClassCombo = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        searchSectionCombo = new javax.swing.JComboBox();
        searchRollCombo = new javax.swing.JComboBox();
        studentCategory = new javax.swing.JComboBox();
        admissionDate = new datechooser.beans.DateChooserCombo();
        birthDate = new datechooser.beans.DateChooserCombo();
        studentName = new javax.swing.JTextField();
        admissionNo = new javax.swing.JTextField();
        fatherName = new javax.swing.JTextField();
        boardingStop = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        genderCombo = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        religionCombo = new javax.swing.JComboBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        sessionCombo = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new org.jdesktop.swingx.JXTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jCheckBox5 = new javax.swing.JCheckBox();

        jPopupMenu1.setBorder(null);

        jMenuItem16.setText("Send SMS");
        jMenuItem16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem16MouseClicked(evt);
            }
        });
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem16);
        jPopupMenu1.add(jSeparator15);

        jMenuItem1.setText("Student Information");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);
        jPopupMenu1.add(jSeparator4);

        jMenuItem2.setText(" Dues Details");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);
        jPopupMenu1.add(jSeparator12);

        jMenuItem13.setText("Payment Details");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem13);
        jPopupMenu1.add(jSeparator3);

        jMenuItem3.setText("Pay Fee");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem3);
        jPopupMenu1.add(jSeparator5);

        jMenuItem4.setText("Show Account Statement");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem4);
        jPopupMenu1.add(jSeparator10);

        jMenuItem5.setText("Print Identity Card");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem5);
        jPopupMenu1.add(jSeparator11);

        jMenuItem6.setText("Examination Record");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem6);
        jPopupMenu1.add(jSeparator6);

        jMenuItem7.setText("Inventory History");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem7);
        jPopupMenu1.add(jSeparator2);

        jMenuItem8.setText("Inventory Purchase");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem8);
        jPopupMenu1.add(jSeparator7);

        jMenuItem9.setText("Show Issued Notices");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem9);
        jPopupMenu1.add(jSeparator8);

        jMenuItem10.setText("Issue Notice");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem10);
        jPopupMenu1.add(jSeparator9);

        jMenuItem11.setText("Awards and Honours");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem11);
        jPopupMenu1.add(jSeparator1);

        jMenuItem12.setText("Delete Student");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem12);
        jPopupMenu1.add(jSeparator13);

        jMenuItem14.setText("Re-Admission");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem14);
        jPopupMenu1.add(jSeparator14);

        jMenuItem15.setText("Permanent Delete");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem15);

        setClosable(true);
        setIconifiable(true);
        setTitle("Student Quest");

        jDesktopPane1.setBackground(new java.awt.Color(0, 153, 153));
        jDesktopPane1.setForeground(new java.awt.Color(0, 0, 255));

        jPanel2.setBackground(new java.awt.Color(51, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        searchClassCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        searchClassCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchClassComboActionPerformed(evt);
            }
        });

        jLabel1.setText("Class");

        jLabel2.setText("Roll No");

        jLabel3.setText("Name");

        jLabel4.setText("Admission No.");

        jLabel5.setText("Father's Name");

        jLabel8.setText("Boarding Stop");

        jLabel10.setText("Section");

        searchSectionCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        searchSectionCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchSectionComboMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchSectionComboMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                searchSectionComboMousePressed(evt);
            }
        });
        searchSectionCombo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                searchSectionComboMouseDragged(evt);
            }
        });
        searchSectionCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                searchSectionComboItemStateChanged(evt);
            }
        });
        searchSectionCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchSectionComboActionPerformed(evt);
            }
        });

        searchRollCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        searchRollCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchRollComboMouseEntered(evt);
            }
        });
        searchRollCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                searchRollComboItemStateChanged(evt);
            }
        });

        studentCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        studentCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentCategoryActionPerformed(evt);
            }
        });

        admissionDate.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
            public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
                admissionDateOnSelectionChange(evt);
            }
        });

        birthDate.addCursorMoveListener(new datechooser.events.CursorMoveListener() {
            public void onCursorMove(datechooser.events.CursorMoveEvent evt) {
                birthDateOnCursorMove(evt);
            }
        });

        studentName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                studentNameKeyTyped(evt);
            }
        });

        admissionNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                admissionNoKeyTyped(evt);
            }
        });

        fatherName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fatherNameKeyTyped(evt);
            }
        });

        boardingStop.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                boardingStopKeyTyped(evt);
            }
        });

        jLabel16.setText("Gender");

        genderCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose", "Female", "Male" }));
        genderCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderComboActionPerformed(evt);
            }
        });

        jLabel17.setText("Religion");

        religionCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        religionCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                religionComboActionPerformed(evt);
            }
        });

        jCheckBox2.setBackground(new java.awt.Color(51, 204, 255));
        jCheckBox2.setText("Adm. Date");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setBackground(new java.awt.Color(51, 204, 255));
        jCheckBox3.setText("Birth Date");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jCheckBox4.setBackground(new java.awt.Color(51, 204, 255));
        jCheckBox4.setText("Category");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jCheckBox6.setText("Show Transport Boarders Class Wise");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        jLabel18.setText("Session");

        sessionCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        sessionCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sessionComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jCheckBox6)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                                            .addComponent(jLabel16))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                                        .addGap(32, 32, 32))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jCheckBox3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jCheckBox2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jCheckBox4, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(religionCombo, 0, 108, Short.MAX_VALUE)
                                    .addComponent(studentCategory, javax.swing.GroupLayout.Alignment.TRAILING, 0, 108, Short.MAX_VALUE)
                                    .addComponent(boardingStop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                    .addComponent(birthDate, 0, 0, Short.MAX_VALUE)
                                    .addComponent(searchSectionCombo, 0, 108, Short.MAX_VALUE)
                                    .addComponent(searchRollCombo, 0, 108, Short.MAX_VALUE)
                                    .addComponent(studentName, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                    .addComponent(admissionNo, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                    .addComponent(admissionDate, 0, 0, Short.MAX_VALUE)
                                    .addComponent(genderCombo, javax.swing.GroupLayout.Alignment.TRAILING, 0, 108, Short.MAX_VALUE)
                                    .addComponent(fatherName, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                    .addComponent(searchClassCombo, 0, 108, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                                .addGap(32, 32, 32)
                                .addComponent(sessionCombo, 0, 125, Short.MAX_VALUE)))
                        .addGap(29, 29, 29))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(searchClassCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(searchSectionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(searchRollCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(studentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(admissionNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(fatherName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(admissionDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox2))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(birthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jCheckBox3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boardingStop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genderCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(religionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sessionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox6)
                .addGap(13, 13, 13))
        );

        jPanel2.setBounds(0, 50, 250, 420);
        jDesktopPane1.add(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Adm.", "Name", "Roll", "Class", "Section", "DOB", "Father's name", "Mother's Name", "Phone", "Address", "Category", "Sub-Category", "A/c NO.", "Bank", "Branch", "Area"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnControlVisible(true);
        jTable1.setComponentPopupMenu(jPopupMenu1);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jScrollPane1.setBounds(260, 50, 710, 460);
        jDesktopPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 0, 24));
        jTextPane1.setText("                                         Student Search");
        jScrollPane2.setViewportView(jTextPane1);

        jScrollPane2.setBounds(0, 0, 970, 40);
        jDesktopPane1.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 255));
        jButton4.setText("Show All Students");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton4.setBounds(460, 530, 133, 23);
        jDesktopPane1.add(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 0, 255));
        jButton5.setText("Show Ex-Students");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jButton5.setBounds(600, 530, 135, 23);
        jDesktopPane1.add(jButton5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 0, 255));
        jButton6.setText("Print Search Result");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jButton6.setBounds(760, 530, 140, 23);
        jDesktopPane1.add(jButton6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 0, 255));
        jButton7.setText("Show Current Students");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jButton7.setBounds(280, 530, 170, 23);
        jDesktopPane1.add(jButton7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton8.setForeground(new java.awt.Color(0, 0, 255));
        jButton8.setText("Refresh Age");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jButton8.setBounds(280, 560, 170, 23);
        jDesktopPane1.add(jButton8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton9.setForeground(new java.awt.Color(0, 0, 255));
        jButton9.setText("Print Id Cards");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jButton9.setBounds(460, 560, 130, 23);
        jDesktopPane1.add(jButton9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton10.setForeground(new java.awt.Color(0, 0, 255));
        jButton10.setText("Detailed Report");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jButton10.setBounds(600, 560, 140, 23);
        jDesktopPane1.add(jButton10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel12.setText("No. of Students");
        jLabel12.setBounds(410, 510, 120, 14);
        jDesktopPane1.add(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel13.setText("No. of Students");
        jLabel13.setBounds(280, 510, 120, 14);
        jDesktopPane1.add(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextPane3.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane3.setEditable(false);
        jTextPane3.setText("Search the students on selection of checkbox criterion. Here Also , Print the reports  *date=yyyy/mm/dd");
        jScrollPane4.setViewportView(jTextPane3);

        jScrollPane4.setBounds(0, 590, 970, 30);
        jDesktopPane1.add(jScrollPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 255));
        jButton1.setText("Reset No.");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(160, 560, 90, 23);
        jDesktopPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 255));
        jButton2.setText("Send SMS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(53, 560, 87, 23);
        jDesktopPane1.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jCheckBox1.setBackground(new java.awt.Color(0, 153, 153));
        jCheckBox1.setText("Custom");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jCheckBox1.setBounds(0, 490, 61, 23);
        jDesktopPane1.add(jCheckBox1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField2.setText("Your Mob. No.");
        jTextField2.setBounds(70, 530, 160, 20);
        jDesktopPane1.add(jTextField2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jScrollPane3.setBounds(66, 480, 190, 40);
        jDesktopPane1.add(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel11.setText("Mobile No.");
        jLabel11.setBounds(10, 530, 50, 14);
        jDesktopPane1.add(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jCheckBox5.setBackground(new java.awt.Color(0, 153, 153));
        jCheckBox5.setText("Class");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });
        jCheckBox5.setBounds(0, 560, 51, 23);
        jDesktopPane1.add(jCheckBox5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 973, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchClassComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchClassComboActionPerformed
        change=0;
        classFilter();
        classStudentFilter();
        studentDetailOnBasisOfClass();// TODO add your handling code here:
}//GEN-LAST:event_searchClassComboActionPerformed

    private void searchSectionComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchSectionComboMouseClicked
        // TODO add your handling code here:
        sectionFilter();
        studentDetailOnBasisOfSection();
}//GEN-LAST:event_searchSectionComboMouseClicked

    private void searchSectionComboMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchSectionComboMouseEntered
      
}//GEN-LAST:event_searchSectionComboMouseEntered

    private void searchSectionComboMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchSectionComboMousePressed
        // TODO add your handling code here:
}//GEN-LAST:event_searchSectionComboMousePressed

    private void searchSectionComboMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchSectionComboMouseDragged
        // TODO add your handling code here:
}//GEN-LAST:event_searchSectionComboMouseDragged

    private void searchSectionComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_searchSectionComboItemStateChanged
        // TODO add your handling code here:
}//GEN-LAST:event_searchSectionComboItemStateChanged

    private void searchSectionComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchSectionComboActionPerformed

        // TODO add your handling code here:
}//GEN-LAST:event_searchSectionComboActionPerformed

    private void searchRollComboMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchRollComboMouseEntered
     
}//GEN-LAST:event_searchRollComboMouseEntered

    private void searchRollComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_searchRollComboItemStateChanged
        // TODO add your handling code here:
}//GEN-LAST:event_searchRollComboItemStateChanged

    private void studentCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentCategoryActionPerformed
       // categoryFilter();        // TODO add your handling code here:
}//GEN-LAST:event_studentCategoryActionPerformed

    private void admissionDateOnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_admissionDateOnSelectionChange
        // TODO add your handling code here:
}//GEN-LAST:event_admissionDateOnSelectionChange

    private void birthDateOnCursorMove(datechooser.events.CursorMoveEvent evt) {//GEN-FIRST:event_birthDateOnCursorMove
            // TODO add your handling code here:
}//GEN-LAST:event_birthDateOnCursorMove

    private void studentNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_studentNameKeyTyped
        int keycode=evt.getID();
        // int id;
        if(keycode==KeyEvent.KEY_TYPED) {
            studentDetailOnBasisOfName();
        }                 // TODO add your handling code here:
}//GEN-LAST:event_studentNameKeyTyped

    private void admissionNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_admissionNoKeyTyped
        int keycode=evt.getID();
        // int id;
        if(keycode==KeyEvent.KEY_TYPED) {

            studentDetailOnBasisOfId();

        }       // TODO add your handling code here:
}//GEN-LAST:event_admissionNoKeyTyped

    private void fatherNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fatherNameKeyTyped
        int keycode=evt.getID();
        // int id;
        if(keycode==KeyEvent.KEY_TYPED) {

            studentDetailOnBasisOfFatherName();

        }
}//GEN-LAST:event_fatherNameKeyTyped

    private void boardingStopKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boardingStopKeyTyped
        int keycode=evt.getID();
        //  int id;
        if(keycode==KeyEvent.KEY_TYPED) {

            studentDetailOnBasisOfAddressOrBoard();

        }   // TODO add your handling code here:
}//GEN-LAST:event_boardingStopKeyTyped

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
}//GEN-LAST:event_jTable1MouseClicked

    private void genderComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderComboActionPerformed
       genderFilter();
}//GEN-LAST:event_genderComboActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        showAllStudentDetail();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       showAllnExStudentDetail();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         showExStudentDetail();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
     String s=null;
        try
        {
         if(searchClassCombo.getSelectedItem().toString().equals("choose"))
         s="Student Search Result";
         else
              s="Student Search Result "+searchClassCombo.getSelectedItem().toString()+searchSectionCombo.getSelectedItem().toString();
        MessageFormat header=new MessageFormat(s);
        jTable1.print(PrintMode.FIT_WIDTH, header, null);
        }

        catch(Exception e)
        {
         System.err.println("Error in printing student search");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       // doAgeCalculation();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
         printIDCards();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        //completeStudentBioDataReport();

        rdx r1=new rdx();
        r1.completeStudentBioDataReport();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void religionComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_religionComboActionPerformed
      religionFilter();
}//GEN-LAST:event_religionComboActionPerformed

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
        //int crow=jTable1.getSelectedRow();
        //String id=dm.getValueAt(crow,0).toString();
        //com.duc.StudentDepartment.AddStudent.AddStudentGUI.man();
}//GEN-LAST:event_jMenuItem1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int crow=jTable1.convertRowIndexToModel(jTable1.getSelectedRow()); //this has been added recently
        String id=dm.getValueAt(crow,0).toString();
        System.out.println("id for student search is "+id);
        com.duc.StudentDepartment.AddStudent.AddStudent r=   new com.duc.StudentDepartment.AddStudent.AddStudent();
        jDesktopPane1.add(r);
        r.setVisible(true);
        r.setAdmissionNoText(id);

        // TODO add your handling code here:
}//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        int crow=jTable1.convertRowIndexToModel(jTable1.getSelectedRow());
        String id=dm.getValueAt(crow,0).toString();
        System.out.println(id);
        com.duc.FeeDepartment.PaymentDuesGUI1 r=   new com.duc.FeeDepartment.PaymentDuesGUI1();
        jDesktopPane1.add(r);
        r.setVisible(true);
        r.setAdmissionNoDues(id);
}//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        int crow=jTable1.convertRowIndexToModel(jTable1.getSelectedRow());
        String id=dm.getValueAt(crow,0).toString();
        System.out.println(id);
        com.duc.FeeDepartment.PaymentDuesGUI1 r=   new com.duc.FeeDepartment.PaymentDuesGUI1();
        jDesktopPane1.add(r);
        r.setVisible(true);
        r.setAdmissionNoPayment(id);
}//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        int crow=jTable1.convertRowIndexToModel(jTable1.getSelectedRow());
        String id=dm.getValueAt(crow,0).toString();
        System.out.println(id);
        com.duc.FeeDepartment.FeeCounter1 r=   new com.duc.FeeDepartment.FeeCounter1();
        jDesktopPane1.add(r);
        r.setVisible(true);
        r.setAdmissionNo(id);
}//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        int crow=jTable1.convertRowIndexToModel(jTable1.getSelectedRow());
        String id=dm.getValueAt(crow,0).toString();
        System.out.println(id);
        com.duc.FeeDepartment.FeeCounter1 r=   new com.duc.FeeDepartment.FeeCounter1();
        // r.setVisible(true);
        r.setAdmissionNoForStatement(id);
}//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        int j=jTable1.convertRowIndexToModel(jTable1.getSelectedRow());
        String id= dm.getValueAt(j, 0).toString();
        //   System.out.println("sdsdsd"+id);
        new com.duc.StudentDepartment.SearchStudent.IDCardPrint().printStudentidCard(id);
}//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        int crow=jTable1.convertRowIndexToModel(jTable1.getSelectedRow());
        String id=dm.getValueAt(crow,0).toString();
        System.out.println(id);
        com.duc.SpecialDepartment.InventorySection.InventoryDepartment.WithDrawalHistory1 r=   new com.duc.SpecialDepartment.InventorySection.InventoryDepartment.WithDrawalHistory1();
        jDesktopPane1.add(r, 0);
        r.setVisible(true);
        r.setAdmissionNo(id);
}//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        int crow=jTable1.convertRowIndexToModel(jTable1.getSelectedRow());
        String id=dm.getValueAt(crow,0).toString();
        System.out.println(id);
        com.duc.SpecialDepartment.InventorySection.InventoryDepartment.WithDrawal1 r=   new com.duc.SpecialDepartment.InventorySection.InventoryDepartment.WithDrawal1();
        jDesktopPane1.add(r, 0);
        r.setVisible(true);
        r.setAdmissionNo(id);
}//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        int crow=jTable1.convertRowIndexToModel(jTable1.getSelectedRow());
        String id=dm.getValueAt(crow,0).toString();
        System.out.println(id);
        com.duc.Reception.ViewIssuedLetter r=   new com.duc.Reception.ViewIssuedLetter();
        this.add(r,0);

        r.setVisible(true);
        r.setAdmissionNo(id);
}//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        int crow=jTable1.convertRowIndexToModel(jTable1.getSelectedRow());
        String id=dm.getValueAt(crow,0).toString();
        System.out.println(id);
        com.duc.Reception.IssueLetterHead r=   new com.duc.Reception.IssueLetterHead();
        this.add(r,0);
        r.setVisible(true);
        r.setAdmissionNo(id);
}//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        int crow=jTable1.convertRowIndexToModel(jTable1.getSelectedRow());
        String id=dm.getValueAt(crow,0).toString();
        System.out.println(id);
        com.duc.StudentDepartment.Awards.ShowAwards r=   new com.duc.StudentDepartment.Awards.ShowAwards();
        this.add(r,0);
        r.setVisible(true);
        r.setAdmissionNo(id);
}//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
       // int selection=JOptionPane.showConfirmDialog(null,"DO you really Want to Delete Student","Delete Student",JOptionPane.OK_CANCEL_OPTION);
        //if(selection==JOptionPane.OK_OPTION)
            deleteStudent();
        // TODO add your handling code here:
}//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        int selection=JOptionPane.showConfirmDialog(null,"Do you really Want to Re-Admit Student","Re-Admission",JOptionPane.OK_CANCEL_OPTION);

        if(selection==JOptionPane.OK_OPTION)
            ReAdmissionStudent();

}//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        deletePermanent();
}//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem16MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem16MouseClicked

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
 try
 {
    ps=con.prepareStatement("select access from smsaccess where module=? ");
    ps.setString(1,"Search Student");
    rs=ps.executeQuery();
    if(rs.next())
    {
    if(rs.getInt(1)==1)
        SmsFile();
      else JOptionPane.showConfirmDialog(null,"Add SMS package access from Accessories","Contact Administrator",JOptionPane.OK_OPTION);
       // jCheckBox1.setSelected(false);

    }else JOptionPane.showConfirmDialog(null,"Add SMS package access from Accessories","Contact Administrator",JOptionPane.OK_OPTION);
      }catch(Exception e)
{
    e.printStackTrace();
}

    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
try
{
  /*  if(jCheckBox5.isSelected())
    {
smsClass();
    }else*/
    {
    ps=con.prepareStatement("select access from smsaccess where module=? ");
    ps.setString(1,"Search Student");
    rs=ps.executeQuery();
     if(rs.next())
    {
    if(rs.getInt(1)==1)
        SmsFile();
    else JOptionPane.showConfirmDialog(null,"Add SMS package access from Accessories","Contact Administrator",JOptionPane.OK_OPTION);
        jCheckBox1.setSelected(false);
     }else JOptionPane.showConfirmDialog(null,"Add SMS package access from Accessories","Contact Administrator",JOptionPane.OK_OPTION);

    }
}catch(Exception e)
{
    e.printStackTrace();
}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
       if(jCheckBox1.isSelected())
           jTextField2.setVisible(true);
       if(!jCheckBox1.isSelected())
           jTextField2.setVisible(false);
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      jTextField2.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        String t=admissionDate.getText();
        studentDetailOnBasisOfDoa(t);
        jCheckBox2.setSelected(false);

    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        String t=birthDate.getText();
        studentDetailOnBasisOfBirthDate(t);
        jCheckBox3.setSelected(false);// TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        // TODO add your handling code here:
        if(jCheckBox4.isSelected())
            categoryFilter();
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        // TODO add your handling code here:
        if(jCheckBox6.isSelected())
        {

            showBoarders();
        }else
        {

        }
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void sessionComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sessionComboActionPerformed
        // TODO add your handling code here:
        sessionFilter();
    }//GEN-LAST:event_sessionComboActionPerformed

    public void showBoarders()
    {
        try
     {
       ps=con.prepareStatement("select * from transportboarders left join studententry on studententry.id=transportboarders.studentid  where class= ? and status!=0") ;
      ps.setInt(1,Integer.parseInt(classmap1.get(searchClassCombo.getSelectedItem().toString()).toString()));
         //ps.setInt(2,id);
      System.out.println("n");
       rs=ps.executeQuery();
      studentDetail1(rs);

   }catch(Exception e)
   {
e.printStackTrace();
   }
    }
    public void smsClass()
{
    String id = null,rd = null;
     String msg=jTextArea1.getText();
    try
    {
        String newmsg=msg.replace(" ","%20");
    System.out.println("New message"+newmsg);
  //  new com.duc.Accessories.SendSms().SmsCommon(id, newmsg);
    InetAddress thisIp =InetAddress.getLocalHost();
            String ip=thisIp.getHostAddress();
        ps=con.prepareStatement("select * from studententry where class=?");
        ps.setInt(1,Integer.parseInt(classmap1.get(searchClassCombo.getSelectedItem()).toString()));
        rs=ps.executeQuery();
        while(rs.next())
        {
//if(rs.getInt(14).isEmpty())
  //          JOptionPane.showConfirmDialog(null,"Mobile no. Field is empty","Mobile Empty",JOptionPane.OK_OPTION);
    id=rs.getString(5);

        rd=rs.getString(1);
        new com.duc.Accessories.SendSms().SmsCommon(rd,id,newmsg,ip);
    }
    }catch(Exception e)
    {
        e.printStackTrace();
    }

}

    public void SmsFile()
{
        if(jCheckBox5.isSelected())
    {
smsClass();
    }
        else
        {
      //String id;
     // String inputLine;
String rd;
      try
      {
          String id=null;
    int crow=jTable1.convertRowIndexToModel(jTable1.getSelectedRow());
    String msg=jTextArea1.getText();
    System.out.println("message"+msg);
    if(jCheckBox1.isSelected())
    {
        id=jTextField2.getText().trim();
        if(id.isEmpty())
            JOptionPane.showConfirmDialog(null,"Mobile no. Field is empty","Mobile Empty",JOptionPane.OK_OPTION);
rd="0000";
    }
    else
    {
         id=dm.getValueAt(crow,8).toString().trim();
         rd=dm.getValueAt(crow,0).toString();
    }
    String newmsg=msg.replace(" ","%20");
    System.out.println("New message"+newmsg);
  //  new com.duc.Accessories.SendSms().SmsCommon(id, newmsg);
    InetAddress thisIp =InetAddress.getLocalHost();
            String ip=thisIp.getHostAddress();
      new com.duc.Accessories.SendSms().SmsCommon(rd,id,newmsg,ip);
      }
      catch(Exception e)
      {
          JOptionPane.showConfirmDialog(null,"Mobile no. Field is empty","Mobile Empty",JOptionPane.OK_OPTION);

        e.printStackTrace();
      }
  /*String ul="http://abulksms.com/pushsms.php?username=ravis&password=921695&sender=DUCC%20Sys&cdmasender=mycdmasenderid&to="+id+"&message="+newmsg;
    System.out.println("url="+ul);
        try
        {
        URL yahoo = new URL(ul);
        URLConnection yc = yahoo.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                yc.getInputStream()));
       

        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
             JOptionPane.showConfirmDialog(null,"Message sent successfully...","SMS Sender",JOptionPane.PLAIN_MESSAGE);
        in.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }*/
        }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo admissionDate;
    private javax.swing.JTextField admissionNo;
    private datechooser.beans.DateChooserCombo birthDate;
    private javax.swing.JTextField boardingStop;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField fatherName;
    private javax.swing.JComboBox genderCombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private org.jdesktop.swingx.JXTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JComboBox religionCombo;
    private javax.swing.JComboBox searchClassCombo;
    private javax.swing.JComboBox searchRollCombo;
    private javax.swing.JComboBox searchSectionCombo;
    private javax.swing.JComboBox sessionCombo;
    private javax.swing.JComboBox studentCategory;
    private javax.swing.JTextField studentName;
    // End of variables declaration//GEN-END:variables
ResultSet rs,rs1;
PreparedStatement ps;
static int change=-1;
PopupMenu p1=new PopupMenu();
}
