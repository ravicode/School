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
public class MapForIndex {

    HashMap month=new HashMap();
    HashMap month1=new HashMap();

    HashMap classmap=new HashMap();
    HashMap sectionmap=new HashMap();

    HashMap subjectmap=new HashMap();
    HashMap subjectmap1=new HashMap();

    HashMap sessionmap=new HashMap();
    HashMap sessionmap1=new HashMap();

    HashMap classmap1=new HashMap();
    HashMap sectionmap1=new HashMap();

    HashMap admissionfeemap=new HashMap();
    HashMap periodicfeemap=new HashMap();

    HashMap monthlyfeemap=new HashMap();
    HashMap otherfeemap=new HashMap();

    HashMap headfeetypemap=new HashMap();

    HashMap admissionfeemap1=new HashMap();
    HashMap periodicfeemap1=new HashMap();

    HashMap monthlyfeemap1=new HashMap();

    HashMap otherfeemap1=new HashMap();


    HashMap studentidFromClassIndex=new HashMap();

    HashMap exams=new HashMap();
    HashMap exams1=new HashMap();

   

    HashMap studentcategory1=new HashMap();
    HashMap studentcategory=new HashMap();

     HashMap studentreligion1=new HashMap();
    HashMap studentreligion=new HashMap();


     HashMap subcategory1=new HashMap();
    HashMap subcategory=new HashMap();

    public HashMap getCategorySlabIndexFromName()
    {
        try
        {
           // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select slab,slabid from categorysub");
            rs=ps.executeQuery();
            while(rs.next())
            {
                subcategory1.put(rs.getString(1),rs.getInt(2));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return subcategory1;
    }

     public HashMap getCategorySlabNameFromIndex()
    {
        try
        {
           // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select slab,slabid from categorysub");
            rs=ps.executeQuery();
            while(rs.next())
            {
                subcategory.put(rs.getInt(2),rs.getString(1));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return subcategory;
    }

    public HashMap getExamIndexFromName()
    {
        try
        {
           // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select examid,examname from examsetup");
            rs=ps.executeQuery();
            while(rs.next())
            {
                exams1.put(rs.getString(2),rs.getInt(1));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return exams1;
    }

    
     public HashMap getCategoryIndexFromName()
    {
        try
        {
           // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select categoryid,categorytitle from categorysetup");
            rs=ps.executeQuery();
            while(rs.next())
            {
                studentcategory1.put(rs.getString(2),rs.getString(1));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return studentcategory1;
    }

      public HashMap getCategoryNameFromIndex()
    {
        try
        {
           // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select categoryid,categorytitle from categorysetup");
            rs=ps.executeQuery();
            while(rs.next())
            {
                studentcategory.put(rs.getString(1),rs.getString(2));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return studentcategory;
    }

      public HashMap getReligionIndexFromName()
    {
        try
        {
           // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select religionid,religiontitle from religionsetup");
            rs=ps.executeQuery();
            while(rs.next())
            {
                studentreligion1.put(rs.getString(2),rs.getString(1));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return studentreligion1;
    }

      public HashMap getReligionNameFromIndex()
    {
        try
        {
           // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select religionid,religiontitle from religionsetup");
            rs=ps.executeQuery();
            while(rs.next())
            {
                studentreligion.put(rs.getString(1),rs.getString(2));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return studentreligion;
    }

    public HashMap getExamIndexToName()
    {
        try
        {
            //con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select id,grade from examgrades");
            rs=ps.executeQuery();
            while(rs.next())
            {
                exams.put(rs.getInt(1),rs.getString(2));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return exams;
    }



     public HashMap getSubjectIndexFromName()
    {
        try
        {
           // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select subjectid,subjecttitle from subjectlist");
            rs=ps.executeQuery();
            while(rs.next())
            {
                subjectmap1.put(rs.getString(2),rs.getInt(1));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return subjectmap1;
    }



 public HashMap getSubjectIndexToName()
    {
        try
        {
            //con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select subjectid,subjecttitle from subjectlist");
            rs=ps.executeQuery();
            while(rs.next())
            {
                subjectmap.put(rs.getInt(1),rs.getString(2));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return subjectmap;
    }

    public HashMap getSessionIndexFromName()
    {
        try
        {
           // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select sessionid,sessiontitle from sessionsetup");
            rs=ps.executeQuery();
            while(rs.next())
            {
                sessionmap1.put(rs.getString(2),rs.getInt(1));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return sessionmap1;
    }

     public HashMap getSessionIndexToName()
    {
        try
        {
          //  con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select sessionid,sessiontitle from sessionsetup");
            rs=ps.executeQuery();
            while(rs.next())
            {
                sessionmap.put(rs.getInt(1),rs.getString(2));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return sessionmap;
    }

     
     public HashMap getstudentidFromClassIndex()
    {
        try
        {
            //con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select id,class from studententry");
            rs=ps.executeQuery();
            while(rs.next())
            {
                studentidFromClassIndex.put(rs.getInt(2),rs.getInt(1));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
return studentidFromClassIndex;
    }


    public HashMap mapMonth()
{

     month.put(1,"January");
     month.put(2,"February");
     month.put(3,"March");
     month.put(4,"April");
     month.put(5,"May");
     month.put(6,"June");
      month.put(7,"July");
     month.put(8,"August");
     month.put(9,"September");
     month.put(10,"October");
     month.put(11,"November");
     month.put(12,"December");
return month;
}

   public HashMap mapMonth1()
{

     month1.put("January",1);
     month1.put("February",2);
     month1.put("March",3);
     month1.put("April",4);
     month1.put("May",5);
     month1.put("June",6);
      month1.put("July",7);
     month1.put("August",8);
     month1.put("September",9);
     month1.put("October",10);
     month1.put("November",11);
     month1.put("December",12);
return month1;
}

 public HashMap getMonthlyFeeIndexToName()
    {
        try
        {
          //  con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select feeid,head from monthlyfeehead");
            rs=ps.executeQuery();
            while(rs.next())
            {
                monthlyfeemap.put(rs.getInt(1),rs.getString(2));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
return monthlyfeemap;
    }
 public HashMap getFeeHeadIndexFromFeeTypeInFeeDues()
    {
      try
        {
            //con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select feetype,head from feedues");
            rs=ps.executeQuery();
            while(rs.next())
            {
                headfeetypemap.put(rs.getInt(1),rs.getString(2));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
  return headfeetypemap;
    }

    public HashMap getAdmissionFeeIndexToName()
    {
        try
        {
           // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select feeid,head from admissionfeehead");
            rs=ps.executeQuery();
            while(rs.next())
            {
                admissionfeemap.put(rs.getInt(1),rs.getString(2));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
return admissionfeemap;
    }

    public HashMap getPeriodicFeeIndexToName()
    {
        try
        {
          //  con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select feeid,head from periodicfeehead");
            rs=ps.executeQuery();
            while(rs.next())
            {
                periodicfeemap.put(rs.getInt(1),rs.getString(2));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
return periodicfeemap;
    }

   


      public HashMap getAdmissionFeeIndexFromName()
    {
        try
        {
            System.out.println("Now inside admission feemap");
            //con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select feeid,head from admissionfeehead");
            rs=ps.executeQuery();
            while(rs.next())
            {
                admissionfeemap1.put(rs.getString(2),rs.getInt(1));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
return admissionfeemap1;
    }


      public HashMap getLedgerOtherFeeIndexToName()
    {
        try
        {
           // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select feeid,feehead from ledgerotherfeeheadcode");
            rs=ps.executeQuery();
            while(rs.next())
            {
                otherfeemap.put(rs.getInt(1),rs.getString(2));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
return otherfeemap;
    }


      public HashMap getLedgerOtherFeeIndexFromName()
    {
        try
        {
            //con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select feeid,feehead from ledgerotherfeeheadcode");
            rs=ps.executeQuery();
            while(rs.next())
            {
                otherfeemap1.put(rs.getString(2),rs.getInt(1));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
return otherfeemap1;
    }

    public HashMap getPeriodicFeeIndexFromName()
    {
        try
        {
           // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select feeid,head from periodicfeehead");
            rs=ps.executeQuery();
            while(rs.next())
            {
                periodicfeemap1.put(rs.getString(2),rs.getInt(1));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
return periodicfeemap1;
    }

    public HashMap getMonthlyFeeIndexFromName()
    {
        try
        {
           // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            ps=con.prepareStatement("select feeid,head from monthlyfeehead");
            rs=ps.executeQuery();
            while(rs.next())
            {
                monthlyfeemap1.put(rs.getString(2),rs.getInt(1));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
return monthlyfeemap1;
    }
    
    public HashMap getClassIndexName()
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
return classmap;
    }

     public HashMap getSectionIndexName()
    {
         try
        {
            //  con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
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
         return sectionmap;
    }
 public HashMap getClassIndexFromName()
    {
        try
        {
            //con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
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
return classmap1;
    }

     public HashMap getSectionIndexFromName()
    {
         try
        {
             // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
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

 public int getFeeTypeFromHead(String head)
        {
            int ft1=-1,fid=0;
            ResultSet r=null;
            System.out.println("For FeeHead "+head);
            try
            {

           //    con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
               if(ft1<0)
               {
                 ps=con.prepareStatement("select * from monthlyfeehead where head=?");
                                   ps.setString(1,head);
                                   r=ps.executeQuery();
                                   if(r.next())
                                   {
                                       System.out.println("<<<< getFeeType Monthly Fee Type >>>>>");
                                       fid=r.getInt(1);
                                       ft1=0;
                                    }
               }

               if(ft1<0)
               {
                 ps=con.prepareStatement("select * from admissionfeehead where head=?");
                                   ps.setString(1,head);
                                   r=ps.executeQuery();
                                   if(r.next())
                                   {
                                       System.out.println("<<<< getFeeType Admission Fee Type >>>>>");
                                       fid=r.getInt(1);
                                       ft1=1;

                                   }
               }

               if(ft1<0)
               {
               ps=con.prepareStatement("select * from periodicfeehead where head=?");
                                   ps.setString(1,head);
                                   r=ps.executeQuery();
                                   if(r.next())
                                   {
                                       System.out.println("<<<< getFeeType Periodic Fee Type >>>>>");
                                       fid=r.getInt(1);
                                       ft1=2;

                                   }
               }

               if(ft1<0)
               {
                 ps=con.prepareStatement("select * from ledgerotherfeeheadcode where feehead=?");
                                   ps.setString(1,head);
                                   r=ps.executeQuery();
                                   if(r.next())
                                   {
                                       System.out.println("<<<< getFeeType Other Fee Type >>>>>");
                                       fid=r.getInt(3);
                                       ft1=3;
                                   }
               }

            }
            catch(Exception e)
            {
                System.out.println("Error is .... "+e);
                e.printStackTrace();
            }
            System.out.println("Returning fee type: "+ft1);
            return ft1;
        }

 public int getFeeHeadIndexFromFeeTypeAndFeeHead(int feetype,String feehead)
{
  System.out.println("Now inside getFeeHeadIndexFromFeeTypeAndFeeHead, feetype: "+feetype +" and feehead:"+feehead);
   int feeheadindex=-1;
   monthlyfeemap1=getMonthlyFeeIndexFromName();
   admissionfeemap1=getAdmissionFeeIndexFromName();
   periodicfeemap1=getPeriodicFeeIndexFromName();
   otherfeemap1=getLedgerOtherFeeIndexFromName();
   try
   {
      if(feetype==0)
      {
        feeheadindex=Integer.parseInt(String.valueOf(monthlyfeemap1.get(feehead)));
        System.out.println("Fee Head: "+feehead+" , Index: "+feeheadindex);
      }
      if(feetype==1)
      {
        feeheadindex=Integer.parseInt(String.valueOf(admissionfeemap1.get(feehead)));
        System.out.println("Fee Head: "+feehead+" , Index: "+feeheadindex);
      }
      if(feetype==2)
      {

        feeheadindex=Integer.parseInt(String.valueOf(periodicfeemap1.get(feehead)));
        System.out.println("Fee Head: "+feehead+" , Index: "+feeheadindex);

      }
      if(feetype==3)
      {
        feeheadindex=Integer.parseInt(String.valueOf(otherfeemap1.get(feehead)));
        System.out.println("Fee Head: "+feehead+" , Index: "+feeheadindex);

      }
   }
   catch(Exception e)
   {
       System.err.println("Error occured while searching for fee index ....."+e);
   }
   //System.out.println("Head: "+"NO"+" , Index: "+"NO");
   return feeheadindex;

}

 public String getFeeHeadNameFromFeeTypeAndHeadIndex(int feetype,int feeheadindex)
 {
    String feeheadname="" ;
    System.out.println("inside getFeeHeadNameFromFeeTypeAndHeadIndex");
    if(feetype==0)
    {
    monthlyfeemap=getMonthlyFeeIndexToName();
    feeheadname=String.valueOf(monthlyfeemap.get(feeheadindex));
    }
    else if(feetype==1)
    {
    admissionfeemap=getAdmissionFeeIndexToName();
    feeheadname=String.valueOf(admissionfeemap.get(feeheadindex));
    }
    else if(feetype==2)
    {
    periodicfeemap=getPeriodicFeeIndexToName();
    feeheadname=String.valueOf(periodicfeemap.get(feeheadindex));
    }
    else if(feetype==3)
    {
    otherfeemap=getLedgerOtherFeeIndexToName();
    feeheadname=String.valueOf(otherfeemap.get(feeheadindex));
    }
    return feeheadname;
 }



 ResultSet rs;
 PreparedStatement ps;
 //Connection con;

}

 

