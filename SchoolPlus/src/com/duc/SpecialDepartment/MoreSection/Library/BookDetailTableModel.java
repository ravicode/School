/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.duc.SpecialDepartment.MoreSection.Library;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sourabh
 */
public class BookDetailTableModel extends DefaultTableModel
{
    private String[] colnames = null;
    private Object[][] cellvalues = null;
    boolean[] canEdit  = null;

    public BookDetailTableModel()
    {
        init();
    }

    public void init()
    {
        try
        {
        canEdit = new boolean[20];
        colnames = new String[20];
        colnames[0]="<html><font size=2><b>Accession<br />Number</font></b></html>";
        colnames[1]="<html><font size=2><b>Book<br />Title</font></b></html>";
        colnames[2]="<html><font size=2><b>Author</font></b></html>";
        colnames[3]="<html><font size=2><b>Edition</font></b></html>";
        colnames[4]="<html><font size=2><b>Publisher</font></b></html>";
        colnames[5]="<html><font size=2><b>Place of <br />Publication</font></b></html>";
        colnames[6]="<html><font size=2><b>Year of<br />Publication</font></b></html>";
        colnames[7]="<html><font size=2><b>Volume</font></b></html>";
        colnames[8]="<html><font size=2><b>ISBN <br />Number</font></b></html>";
        colnames[9]="<html><font size=2><b>Book<br />Number</font></b></html>";
        colnames[10]="<html><font size=2><b>Classi.<br />Number</font></b></html>";
        colnames[11]="<html><font size=2><b>Book<br />Type</font></b></html>";
        colnames[12]="<html><font size=2><b>Book<br />Category</font></b></html>";
        colnames[13]="<html><font size=2><b>Pages</font></b></html>";
        colnames[14]="<html><font size=2><b>Cost</font></b></html>";
        colnames[15]="<html><font size=2><b>Bill<br />Number</font></b></html>";
        colnames[16]="<html><font size=2><b>Bill<br />Date</font></b></html>";
        colnames[17]="<html><font size=2><b>Vendor</font></b></html>";
        colnames[18]="<html><font size=2><b>Note</font></b></html>";
        colnames[19]="<html><font size=2><b>Entry<br />Date</font></b></html>";
        }
        catch(Exception e)
        {
         System.err.println("Error in table model for book "+e)   ;
        }
    }

     @Override
     public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return canEdit [columnIndex];
    }

    public DefaultTableModel createDefaultModel()
    {
    return new javax.swing.table.DefaultTableModel(cellvalues, colnames )
    {
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
    return canEdit [columnIndex];
    }
    };
    }
}
