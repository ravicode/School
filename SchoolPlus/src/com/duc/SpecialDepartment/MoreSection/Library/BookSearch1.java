/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BookSearch1.java
 *
 * Created on Sep 25, 2009, 2:54:39 PM
 */

package com.duc.SpecialDepartment.MoreSection.Library;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
//import java.util.HashMap;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import org.jdesktop.swingx.decorator.HighlighterFactory;
import javax.swing.JTable.PrintMode;
import java.text.MessageFormat;
import java.util.HashMap;
import static com.duc.DatabaseConnection.DatabaseConnection.*;
/**
 *
 * @author sourabh
 */
public class BookSearch1 extends javax.swing.JInternalFrame {

    MapForLibrary mp=new MapForLibrary();
        HashMap publisher=mp.getBookPublisherFromIndex();
        HashMap category=mp.getBookCategoryFromIndex();
        HashMap vendor=mp.getBookVendorFromIndex();
        HashMap type=mp.getBookTypeFromIndex();
       
        HashMap publisher1=mp.getBookPublisherIndexFromName();
        HashMap category1=mp.getBookCategoryIndexFromName();
        HashMap vendor1=mp.getBookVendorIndexFromName();
        HashMap type1=mp.getBookTypeIndexFromName();
        
    /** Creates new form BookSearch1 */
       public BookSearch1() {
         initComponents();

        jXTable1.setHighlighters(HighlighterFactory.createAlternateStriping());
        jXTable1.setHorizontalScrollEnabled(true);
        dm = (DefaultTableModel) jXTable1.getModel();
        dm.setRowCount(0);

       // DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
        cmbDate.setDateFormat(df);
        
        addAuthor();
        addVendor();
        addBookTypes();
        addBookCategories();
        addBookPublishers();
    }

 public void addAuthor()
 {
      try
    {

         //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
         ps = con.prepareStatement("select distinct author  from bookinformation");
         rs = ps.executeQuery();

            while (rs.next())
            {
              cmbAuthor.addItem(rs.getString(1));
            }

              //con.close();
         }
    catch(Exception e)
    {
        System.err.println("Error is "+e);
    }

 }

 public void addVendor()
    {
       try
    {

         //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
         ps = con.prepareStatement("select * from bookvendor");
         rs = ps.executeQuery();

            while (rs.next())
            {
              cmbVendor.addItem(rs.getString(1));
            }

             // con.close();
         }
    catch(Exception e)
    {
        System.err.println("Error is "+e);
    }

    }

 public void addBookTypes()
{
 try
    {

        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
         ps = con.prepareStatement("select * from booktype");
         rs = ps.executeQuery();

            while (rs.next())
            {
              cmbType.addItem(rs.getString(1));
            }

              //con.close();
         }
    catch(Exception e)
    {
        System.err.println("Error is "+e);
    }
}

public void addBookCategories()
{
 try
    {

        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
         ps = con.prepareStatement("select * from bookcategory");
         rs = ps.executeQuery();

            while (rs.next())
            {
              cmbCategory.addItem(rs.getString(1));
            }

              //con.close();
         }
    catch(Exception e)
    {
        System.err.println("Error is "+e);
    }
}

public void addBookPublishers()
{
      try
    {

        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
         ps = con.prepareStatement("select * from bookpublisher");
         rs = ps.executeQuery();

            while (rs.next())
            {
              cmbPublisher.addItem(rs.getString(1));
            }

             // con.close();
         }
    catch(Exception e)
    {
        System.err.println("Error is "+e);
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
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jXTable1 = new org.jdesktop.swingx.JXTable();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        checkAuthor = new javax.swing.JCheckBox();
        cmbAuthor = new javax.swing.JComboBox();
        checkPublisher = new javax.swing.JCheckBox();
        cmbPublisher = new javax.swing.JComboBox();
        checkTypes = new javax.swing.JCheckBox();
        checkCategory = new javax.swing.JCheckBox();
        checkVendor = new javax.swing.JCheckBox();
        checkDate = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtBookNumber = new javax.swing.JTextField();
        cmbType = new javax.swing.JComboBox();
        cmbCategory = new javax.swing.JComboBox();
        cmbVendor = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        cmbDate = new datechooser.beans.DateChooserCombo();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 204, 204));
        setClosable(true);
        setIconifiable(true);
        setTitle("Extensive Book search");

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Show All");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jXTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ISBN No", "Accession No", "Title", "Author", "Publisher", "Type", "Category", "Vendor", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jXTable1.setColumnControlVisible(true);
        jXTable1.setComponentPopupMenu(jPopupMenu1);
        jScrollPane3.setViewportView(jXTable1);

        jButton4.setText("Print Table");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        checkAuthor.setText("Author");
        checkAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAuthorActionPerformed(evt);
            }
        });

        cmbAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAuthorActionPerformed(evt);
            }
        });

        checkPublisher.setText("Publisher");
        checkPublisher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkPublisherActionPerformed(evt);
            }
        });

        cmbPublisher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPublisherActionPerformed(evt);
            }
        });

        checkTypes.setText("Type");
        checkTypes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkTypesActionPerformed(evt);
            }
        });

        checkCategory.setText("Category");
        checkCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkCategoryActionPerformed(evt);
            }
        });

        checkVendor.setText("Vendor");
        checkVendor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkVendorActionPerformed(evt);
            }
        });

        checkDate.setText("Date");
        checkDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkDateActionPerformed(evt);
            }
        });

        jLabel5.setText("Book Title ");

        txtTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTitleKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTitleKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTitleKeyTyped(evt);
            }
        });

        jLabel6.setText("Accession Number");

        txtBookNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBookNumberKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBookNumberKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBookNumberKeyTyped(evt);
            }
        });

        cmbType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTypeActionPerformed(evt);
            }
        });

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkVendor, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(checkCategory, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(checkPublisher, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(checkTypes, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(checkAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(checkDate, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbVendor, 0, 162, Short.MAX_VALUE)
                            .addComponent(cmbCategory, 0, 162, Short.MAX_VALUE)
                            .addComponent(cmbType, 0, 162, Short.MAX_VALUE)
                            .addComponent(cmbPublisher, 0, 162, Short.MAX_VALUE)
                            .addComponent(cmbAuthor, 0, 162, Short.MAX_VALUE)
                            .addComponent(txtBookNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(txtTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtBookNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkAuthor))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkPublisher))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkTypes)
                    .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkCategory)
                    .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkVendor)
                    .addComponent(cmbVendor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(checkDate)
                    .addComponent(cmbDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap())
        );

        jTextPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jTextPane1.setText("                                              Search books deposited in library by combination of various parametes.");
        jScrollPane2.setViewportView(jTextPane1);

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Total Result Found : ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(410, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            printSearchResult();
        }catch(Exception e) {
            e.printStackTrace();
        }
}//GEN-LAST:event_jButton1ActionPerformed

    public void printSearchResult()
    {
      try
        {
          if(dm.getRowCount()<=0)
          {
          JOptionPane.showMessageDialog(null, "No Search result found !","Message",JOptionPane.INFORMATION_MESSAGE);
          return;
          }

         // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
          HashMap map = new HashMap();

          ps=con.prepareStatement("select institutename, instituteaddress from instituteregistration" );
          rs = ps.executeQuery();
          rs.next();
          map.put("schoolname",rs.getString(1));
          map.put("schooladdress",rs.getString(2));

           BufferedImage bimg = null;         
           bimg = ImageIO.read(new File("images/logo.jpg"));        
           map.put("logo",bimg);

                JRTableModelDataSource src = new JRTableModelDataSource(dm);
                JasperReport js = JasperCompileManager.compileReport("reports/library/book_search.jrxml");
                JasperPrint pr = JasperFillManager.fillReport(js,map,src);
                JasperViewer jv = new JasperViewer(pr, false);
                jv.setTitle("Book Search Result ");
                jv.setVisible(true);
               // con.close();
      }
      catch(Exception e)
      {
          System.out.println("Error is ..."+e);
      }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
          searchForAll();   //   showAllDefaultersList();        // TODO add your handling code here:
}//GEN-LAST:event_jButton3ActionPerformed

    public void searchForAll()
    {
        String command="";
        search(command);
    }

    private void cmbAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAuthorActionPerformed
           // TODO add your handling code here:
}//GEN-LAST:event_cmbAuthorActionPerformed

    private void cmbPublisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPublisherActionPerformed
              // TODO add your handling code here:
}//GEN-LAST:event_cmbPublisherActionPerformed

    private void txtTitleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTitleKeyPressed
        
}//GEN-LAST:event_txtTitleKeyPressed

    public void searchForTitle(String title)
    {
       String command="";
       command+=" booktitle LIKE '"+title+"%' and ";
       search(command);
    }

    public void search(String command)
    {

        try
        {
          // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
           ps=con.prepareStatement(" select isbnnumber,accession_no,booktitle,author,publisher,type,category,vendor,entrydate,available from bookstatus,bookinformation  where " + command + " booknumber=accession_no and available!=2 and available!=3 order by accession_no asc");
           rs=ps.executeQuery();
           int i=0,j=0;

           while(rs.next())
           j++;

           dm.setRowCount(j);
           total.setText(String.valueOf(j));
           rs.first();
           rs.previous();

           while(rs.next())
           {
             dm.setValueAt(rs.getString(1), i, 0);
             dm.setValueAt(rs.getString(2), i, 1);
             dm.setValueAt(rs.getString(3), i, 2);
             dm.setValueAt(rs.getString(4), i, 3);
             dm.setValueAt(publisher.get(rs.getInt(5)), i, 4);
             dm.setValueAt(type.get(rs.getInt(6)), i, 5);
             dm.setValueAt(category.get(rs.getInt(7)), i, 6);
             dm.setValueAt(vendor.get(rs.getInt(8)), i, 7);
             dm.setValueAt(rs.getString(9), i, 8);

             i++;
           }
        // con.close();
        }
        catch(Exception e)
        {
          System.err.println("Error is ...." + e);
        }
        
    }

    private void checkTypesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkTypesActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_checkTypesActionPerformed

    private void checkPublisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkPublisherActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_checkPublisherActionPerformed

    private void checkAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAuthorActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_checkAuthorActionPerformed

    private void checkCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkCategoryActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_checkCategoryActionPerformed

    private void checkVendorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkVendorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkVendorActionPerformed

    private void checkDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkDateActionPerformed

    private void txtBookNumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBookNumberKeyPressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtBookNumberKeyPressed

    public void searchForBookNumber(String booknumber)
    {
       String command="";
       command+=" accession_no LIKE '"+booknumber+"%' and ";
       search(command);
    }


    private void cmbTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTypeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        checkSearch();
    }//GEN-LAST:event_jButton2ActionPerformed

    public void checkSearch()
    {
       String command=" " ;

       if(checkAuthor.isSelected())
       command+=" author= '" + cmbAuthor.getSelectedItem().toString()+"' and ";

       if(checkPublisher.isSelected())
       command+=" publisher= '" + publisher1.get(cmbPublisher.getSelectedItem().toString())+"' and ";

       if(checkTypes.isSelected())
       command+=" type= '" +type1.get( cmbType.getSelectedItem().toString())+"' and ";

       if(checkCategory.isSelected())
       command+=" category= '" + category1.get(cmbCategory.getSelectedItem().toString())+"' and ";

       if(checkVendor.isSelected())
       command+=" vendor= '" + vendor1.get(cmbVendor.getSelectedItem().toString())+"' and ";

       if(checkDate.isSelected())
       command+=" entrydate= "  + "\"" +cmbDate.getText()+ "\"" +" and ";

       System.out.println(cmbDate.getText());
       System.out.println("\"");

       command+=" ";

       System.out.println(command);
       search(command);
    }
    private void txtBookNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBookNumberKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookNumberKeyTyped

    private void txtTitleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTitleKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtTitleKeyTyped

    private void txtTitleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTitleKeyReleased
        // TODO add your handling code here:
        int keycode=evt.getID();
        if(keycode==KeyEvent.KEY_RELEASED)
        {
            searchForTitle(txtTitle.getText());
        }
    }//GEN-LAST:event_txtTitleKeyReleased

    private void txtBookNumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBookNumberKeyReleased
        // TODO add your handling code here:
         int keycode=evt.getID();
        if(keycode==KeyEvent.KEY_RELEASED)
        {
            searchForBookNumber(txtBookNumber.getText());
        }
    }//GEN-LAST:event_txtBookNumberKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String s="";
        String t="";
         try
         {
         // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
          ps=con.prepareStatement("select institutename, instituteaddress from instituteregistration" );
          rs = ps.executeQuery();
          rs.next();

          s=rs.getString(1);
          s+=" , ";
          s+=rs.getString(2);

          t=">>>>>>> Book Search Result >>>>>>>";

          //con.close();
         }
         catch(Exception e)
         {
         System.err.println("Error in printing");
         }


        MessageFormat header=new MessageFormat(s);
        MessageFormat footer=new MessageFormat(t);
        try {
            jXTable1.print(PrintMode.FIT_WIDTH, header, footer);
        } catch (Exception ex) {
            
        }
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkAuthor;
    private javax.swing.JCheckBox checkCategory;
    private javax.swing.JCheckBox checkDate;
    private javax.swing.JCheckBox checkPublisher;
    private javax.swing.JCheckBox checkTypes;
    private javax.swing.JCheckBox checkVendor;
    private javax.swing.JComboBox cmbAuthor;
    private javax.swing.JComboBox cmbCategory;
    private datechooser.beans.DateChooserCombo cmbDate;
    private javax.swing.JComboBox cmbPublisher;
    private javax.swing.JComboBox cmbType;
    private javax.swing.JComboBox cmbVendor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane jTextPane1;
    private org.jdesktop.swingx.JXTable jXTable1;
    private javax.swing.JLabel total;
    private javax.swing.JTextField txtBookNumber;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
   //public Connection con;
   public  PreparedStatement ps;
   public  ResultSet rs;
   DefaultTableModel dm;
}
