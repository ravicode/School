/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.duc.Accessories;

import java.io.File;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author ravi
 */
public class NewClass1 {


/*
    public void barGraph(ArrayList r,ArrayList r1,String graphHead,String yaxis,String xaxis,String chartname)
{
    try
            {
        DefaultCategoryDataset pieDataset = new DefaultCategoryDataset();
        for(int i=0;i<r.size();i++)
        {
                   pieDataset.setValue(Integer.parseInt(r1.get(i).toString()),yaxis,r.get(i).toString());
        }

              JFreeChart chart =ChartFactory.createBarChart(graphHead,xaxis,yaxis,pieDataset, PlotOrientation.VERTICAL, true, true, true);

              final CategoryPlot plot = chart.getCategoryPlot();
 //       plot.setForegroundAlpha(0.5f);

              final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
     // domainAxis.setLowerMargin(0.0);
       // domainAxis.setUpperMargin(0.0);

               ChartUtilities.saveChartAsJPEG(new File("C:/Graphs/"+chartname+".jpg"),
                chart,1000, 500);
               //writeChartToPDF(chart, 500, 400, "C://chart.pdf");
               } catch (Exception e) {
               System.out.println("Problem in creating chart.");
               }
               try {
            Runtime rt = Runtime.getRuntime();
           // rt.exec("SchoolPlus+_Help_File");
            Process pp=rt.exec(" rundll32 url.dll,FileProtocolHandler C:/Graphs/"+chartname+".jpg" );
           // pp=rt.exec(" rundll32 url.dll,FileProtocolHandler C:/chart.pdf" );


        } catch (Exception ex) {
            ex.printStackTrace();
        }
}
*/

    public static void main(String args[])
    {
        //public void barGraph(ArrayList r,ArrayList r1,String graphHead,String yaxis,String xaxis,String chartname)

    try
            {
        DefaultCategoryDataset pieDataset = new DefaultCategoryDataset();
        //for(int i=0;i<r.size();i++)
        {
                  // pieDataset.setValue(Integer.parseInt(r1.get(i).toString()),yaxis,r.get(i).toString());
            pieDataset.setValue(1,"raviy","value");
        }
//JFreeChart chart=ChartFactory.
              JFreeChart chart =ChartFactory.createBarChart("ravi","ravix","raviy",pieDataset, PlotOrientation.VERTICAL, true, true, true);

              final CategoryPlot plot = chart.getCategoryPlot();
 //       plot.setForegroundAlpha(0.5f);

              final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
     // domainAxis.setLowerMargin(0.0);
       // domainAxis.setUpperMargin(0.0);

               ChartUtilities.saveChartAsJPEG(new File("C:/Graphs/"+"r1"+".jpg"),
                chart,1000, 500);
               //writeChartToPDF(chart, 500, 400, "C://chart.pdf");
               } catch (Exception e) {
               System.out.println("Problem in creating chart.");
               }
               try {
            Runtime rt = Runtime.getRuntime();
           // rt.exec("SchoolPlus+_Help_File");
            Process pp=rt.exec(" rundll32 url.dll,FileProtocolHandler C:/Graphs/"+"r1"+".jpg" );
           // pp=rt.exec(" rundll32 url.dll,FileProtocolHandler C:/chart.pdf" );


        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

}
