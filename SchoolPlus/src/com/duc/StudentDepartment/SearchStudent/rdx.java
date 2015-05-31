/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.duc.StudentDepartment.SearchStudent;




import java.sql.*;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import static com.duc.DatabaseConnection.DatabaseConnection.*;

/**
 *
 * @author ravi
 */
public class rdx {


    public void completeStudentBioDataReport()
    {
        HashMap map = new HashMap();
        try
        {


          ps=con.prepareStatement("select id,name from studententry");
          rs=ps.executeQuery();

                JRResultSetDataSource src = new JRResultSetDataSource(rs);
                JasperReport js = JasperCompileManager.compileReport("reports/student/biodata1.jrxml");
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

PreparedStatement ps;
//Connection con;
ResultSet rs;
}


 class c1
{
    public static void main(String args[])
    {
        rdx rt=new rdx();
        rt.completeStudentBioDataReport();
    }
}