/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddStudent.java
 *
 * Created on Dec 20, 2009, 12:59:00 PM
 */

package com.duc.StudentDepartment.AddStudent;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.imageio.ImageIO;
import java.util.Properties;
import java.io.FileWriter;
import javax.swing.table.DefaultTableModel;
//import com.duc.SpecialDepartment.MoreSection.TransportSection.*;
import com.duc.ImportSection.*;
import java.net.InetAddress;
import static com.duc.DatabaseConnection.DatabaseConnection.*;

/**
 *
 * @author Ravi
 */
public class AddStudent extends javax.swing.JInternalFrame {
DefaultTableModel dm,dm1,dm2;
//DateFormat df,df1;
//MapForIndex mp=new MapForIndex();
HashMap classmap=mp.getClassIndexName();
 HashMap classmap1=mp.getClassIndexFromName();
 HashMap sectionmap=mp.getSectionIndexName();
 HashMap sectionmap1=mp.getSectionIndexFromName();

    HashMap month=mp.mapMonth();
    HashMap month1=mp.mapMonth1();
    HashMap category1=mp.getCategoryIndexFromName();
HashMap category=mp.getCategoryNameFromIndex();
HashMap categorysubmap=mp.getCategorySlabNameFromIndex();
HashMap categorysubmap1=mp.getCategorySlabIndexFromName();
     HashMap monthlyfeemap1=mp.getMonthlyFeeIndexFromName();

      HashMap religion1=mp.getReligionIndexFromName();
HashMap religionn=mp.getReligionNameFromIndex();
    /** Creates new form AddStudent */
    public AddStudent() {
        initComponents();
         pack();
        //this.setLocationRelativeTo(null);
        buttonGroup1.add(malebutton);
         buttonGroup1.add(femalebutton);
          buttonGroup2.add(jRadioButton3);
         buttonGroup2.add(jRadioButton4);
         buttonGroup3.add(jRadioButton5);
         buttonGroup3.add(jRadioButton6);
          buttonGroup4.add(jRadioButton1);
         buttonGroup4.add(jRadioButton2);
    
     fromClass();
     fromSection();
     fromAuto();
     fromCategory();
     fromBloodGroup();
     fromDisability();
     fromSchoolHouse();
     fromMedium();
     fromAdmissionChannel();
     fromReligion();
fromSubCategory();
     fromTransportRouteBusSetup();
       fromTransportRouteStopSetup();

      dm = (DefaultTableModel) jXTable1.getModel();
        dm.setRowCount(0);

        dm1 = (DefaultTableModel) jXTable2.getModel();
        dm1.setRowCount(0);
         //df=new SimpleDateFormat("yyyy-MM-dd");
         birthdate.setDateFormat(df);
         doa.setDateFormat(df);
         birth1.setDateFormat(df);
         wed1.setDateFormat(df);
         birth2.setDateFormat(df);
         sdob1.setDateFormat(df);
          sdob2.setDateFormat(df);

      Format formatter = new SimpleDateFormat("MMMM");
    monthofadmission = formatter.format(new java.util.Date());

      dm2 = (DefaultTableModel)jXTable3.getModel();
        dm2.setRowCount(0);
         jPanel22.setVisible(false);
    }

    public void fromAuto()
    {
        try
        {
            ps=con.prepareStatement("select * from autogeneration");
            rs=ps.executeQuery();
            if(rs.next())
            {
                adm=rs.getInt(1);
                rol=rs.getInt(2);
               //studentadmissionno.setEditable(false);
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
public void fromBloodGroup()
{
     try
    {

// con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


         ps = con.prepareStatement("select * from bloodgroupsetup");

             rs = ps.executeQuery();


            while (rs.next())
            {
        bloodGroupCombo.addItem(rs.getString(1));


            }



    }
    catch(Exception e)
    {
        System.err.println("Error is"+e);
    }

}
public void fromDisability()
{
     try
    {

       ps = con.prepareStatement("select * from disabilitysetup");

             rs = ps.executeQuery();


            while (rs.next())
            {
        disabilityCombo.addItem(rs.getString(1));


            }



    }
    catch(Exception e)
    {
        System.err.println("Error is"+e);
    }

}
public void fromSchoolHouse()
{
     try
    {

 //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


         ps = con.prepareStatement("select * from schoolhousesetup");

             rs = ps.executeQuery();


            while (rs.next())
            {
        houseCombo.addItem(rs.getString(1));


            }



    }
    catch(Exception e)
    {
        System.err.println("Error is"+e);
    }

}
public void fromMedium()
{
     try
    {

 //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


         ps = con.prepareStatement("select * from mediumofinstructionsetup");

             rs = ps.executeQuery();


            while (rs.next())
            {
        instructionCombo.addItem(rs.getString(1));


            }



    }
    catch(Exception e)
    {
        System.err.println("Error is"+e);
    }

}
public void fromAdmissionChannel()
{ try
    {

 //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


         ps = con.prepareStatement("select * from admissionchannelsetup");

             rs = ps.executeQuery();


            while (rs.next())
            {
        admissionChannelCombo.addItem(rs.getString(1));


            }

    }
    catch(Exception e)
    {
        System.err.println("Error is"+e);
    }


}
public void fromReligion()
{ try
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
    public void fromClass()
    {
         try
    {

 //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


         ps = con.prepareStatement("select * from classsetup");

             rs = ps.executeQuery();


            while (rs.next())
            {
        classcombo.addItem(rs.getString(1));


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
        categoryCombo.addItem(rs.getString(1));


            }



    }
    catch(Exception e)
    {
        System.err.println("Error is"+e);
    }

    }

     public void fromSubCategory()
    {
         try
    {

 //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


         ps = con.prepareStatement("select * from categorysub");

             rs = ps.executeQuery();


            while (rs.next())
            {
        categoryCombo1.addItem(rs.getString(1));


            }



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


         ps = con.prepareStatement("select  sectiontitle from sectionsetuplist");

             rs = ps.executeQuery();


            while (rs.next())
            {
        sectioncombo.addItem(rs.getString(1));


            }



    }
    catch(Exception e)
    {
        System.err.println("Error is"+e);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        malebutton = new javax.swing.JRadioButton();
        femalebutton = new javax.swing.JRadioButton();
        mothername = new javax.swing.JTextField();
        phoneno = new javax.swing.JTextField();
        studentpresentaddress = new javax.swing.JTextField();
        studentname = new javax.swing.JTextField();
        fathername = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        birthdate = new datechooser.beans.DateChooserCombo();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        classcombo = new javax.swing.JComboBox();
        sectioncombo = new javax.swing.JComboBox();
        rollno = new javax.swing.JTextField();
        studentadmissionno = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        doa = new datechooser.beans.DateChooserCombo();
        jLabel29 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        admissionfeecheckbox = new javax.swing.JCheckBox();
        jLabel25 = new javax.swing.JLabel();
        admissionfeecheckbox1 = new javax.swing.JCheckBox();
        jLabel30 = new javax.swing.JLabel();
        admissionfeecheckbox2 = new javax.swing.JCheckBox();
        jLabel31 = new javax.swing.JLabel();
        admissionfeecheckbox3 = new javax.swing.JCheckBox();
        jLabel47 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        smscheck = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        jXImagePanel1 = new org.jdesktop.swingx.JXImagePanel();
        browsepicturepath = new javax.swing.JTextField();
        exitbutton = new javax.swing.JButton();
        resetbutton = new javax.swing.JButton();
        savebutton = new javax.swing.JButton();
        browsepicturebutton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPane4 = new javax.swing.JTextPane();
        updatebutton = new javax.swing.JButton();
        loadmsg = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jXTable1 = new javax.swing.JTable();
        jScrollPane16 = new javax.swing.JScrollPane();
        jXTable2 = new javax.swing.JTable();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        documentDetailArea = new javax.swing.JTextArea();
        admissionChannelCombo = new javax.swing.JComboBox();
        lastSchool = new javax.swing.JTextField();
        lastPercentage = new javax.swing.JTextField();
        disabilityCombo = new javax.swing.JComboBox();
        instructionCombo = new javax.swing.JComboBox();
        religionCombo = new javax.swing.JComboBox();
        categoryCombo = new javax.swing.JComboBox();
        bloodGroupCombo = new javax.swing.JComboBox();
        houseCombo = new javax.swing.JComboBox();
        detailSaveButton = new javax.swing.JButton();
        detailUpdateButton = new javax.swing.JButton();
        detailExitButton = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        behaviourcombo = new javax.swing.JComboBox();
        jLabel33 = new javax.swing.JLabel();
        interestcombo = new javax.swing.JComboBox();
        jLabel34 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jPanel22 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        categoryCombo1 = new javax.swing.JComboBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel85 = new javax.swing.JLabel();
        disabilityCombo1 = new javax.swing.JComboBox();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        qualification1 = new javax.swing.JTextField();
        fathername1 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        birth1 = new datechooser.beans.DateChooserCombo();
        jLabel39 = new javax.swing.JLabel();
        occupation1 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        wed1 = new datechooser.beans.DateChooserCombo();
        jLabel36 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        phone1 = new javax.swing.JTextField();
        officeaddress1 = new javax.swing.JTextField();
        designation1 = new javax.swing.JTextField();
        resetbutton2 = new javax.swing.JButton();
        updatebutton2 = new javax.swing.JButton();
        exitbutton2 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jXImagePanel3 = new org.jdesktop.swingx.JXImagePanel();
        savebutton2 = new javax.swing.JButton();
        browsepicturepath2 = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        qualification2 = new javax.swing.JTextField();
        mothername1 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        birth2 = new datechooser.beans.DateChooserCombo();
        jLabel46 = new javax.swing.JLabel();
        occupation2 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        phone2 = new javax.swing.JTextField();
        officeaddress2 = new javax.swing.JTextField();
        designation2 = new javax.swing.JTextField();
        browsepicturebutton2 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jXImagePanel4 = new org.jdesktop.swingx.JXImagePanel();
        browsepicturepath3 = new javax.swing.JTextField();
        browsepicturebutton3 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextPane5 = new javax.swing.JTextPane();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextPane6 = new javax.swing.JTextPane();
        jPanel9 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        squalification1 = new javax.swing.JTextField();
        siblingname1 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        sdob1 = new datechooser.beans.DateChooserCombo();
        jLabel54 = new javax.swing.JLabel();
        sschool1 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        stel1 = new javax.swing.JTextField();
        sofficeaddress1 = new javax.swing.JTextField();
        soccupation1 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel68 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        sibling1studentid = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        resetbutton3 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jXImagePanel5 = new org.jdesktop.swingx.JXImagePanel();
        update = new javax.swing.JButton();
        browsepicturepath4 = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        squalification5 = new javax.swing.JTextField();
        siblingname2 = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        sdob2 = new datechooser.beans.DateChooserCombo();
        jLabel62 = new javax.swing.JLabel();
        sschool2 = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        stel2 = new javax.swing.JTextField();
        sofficeaddress2 = new javax.swing.JTextField();
        soccupation2 = new javax.swing.JTextField();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel69 = new javax.swing.JLabel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        sibling2studentid = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        browsepicturebutton4 = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jXImagePanel6 = new org.jdesktop.swingx.JXImagePanel();
        browsepicturepath5 = new javax.swing.JTextField();
        browsepicturebutton5 = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTextPane7 = new javax.swing.JTextPane();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTextPane8 = new javax.swing.JTextPane();
        jLabel67 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTextPane9 = new javax.swing.JTextPane();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTextPane10 = new javax.swing.JTextPane();
        jLabel27 = new javax.swing.JLabel();
        admissionno = new javax.swing.JTextField();
        stopname = new javax.swing.JComboBox();
        jLabel55 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        routeno = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        busno = new javax.swing.JComboBox();
        jLabel71 = new javax.swing.JLabel();
        strengthtext = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        picktext = new javax.swing.JTextField();
        jScrollPane14 = new javax.swing.JScrollPane();
        jXTable3 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel73 = new javax.swing.JLabel();
        transportfee = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextPane11 = new javax.swing.JTextPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextPane12 = new javax.swing.JTextPane();
        jPanel25 = new javax.swing.JPanel();
        jXImagePanel2 = new org.jdesktop.swingx.JXImagePanel();
        browsepicturepath1 = new javax.swing.JTextField();
        browsepicturebutton1 = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel();
        jXImagePanel8 = new org.jdesktop.swingx.JXImagePanel();
        browsepicturepath6 = new javax.swing.JTextField();
        browsepicturebutton6 = new javax.swing.JButton();
        browsepicturepath7 = new javax.swing.JTextField();
        browsepicturebutton7 = new javax.swing.JButton();
        jPanel28 = new javax.swing.JPanel();
        jXImagePanel9 = new org.jdesktop.swingx.JXImagePanel();
        jPanel29 = new javax.swing.JPanel();
        jXImagePanel10 = new org.jdesktop.swingx.JXImagePanel();
        browsepicturepath8 = new javax.swing.JTextField();
        browsepicturebutton8 = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        jXImagePanel11 = new org.jdesktop.swingx.JXImagePanel();
        browsepicturepath9 = new javax.swing.JTextField();
        browsepicturebutton9 = new javax.swing.JButton();
        jPanel31 = new javax.swing.JPanel();
        jXImagePanel12 = new org.jdesktop.swingx.JXImagePanel();
        browsepicturepath10 = new javax.swing.JTextField();
        browsepicturebutton10 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Student Creator");
        setPreferredSize(new java.awt.Dimension(801, 650));

        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 153));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 102)));
        jPanel3.setNextFocusableComponent(studentadmissionno);

        jLabel1.setText("Name"); // NOI18N

        jLabel2.setText("Father's Name"); // NOI18N

        jLabel3.setText("Mother's Name"); // NOI18N

        jLabel4.setText("Phone"); // NOI18N

        jLabel5.setText("Address"); // NOI18N

        jLabel10.setText("Gender"); // NOI18N

        malebutton.setBackground(new java.awt.Color(153, 204, 255));
        malebutton.setText("Male"); // NOI18N
        malebutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                malebuttonMouseClicked(evt);
            }
        });
        malebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                malebuttonActionPerformed(evt);
            }
        });

        femalebutton.setBackground(new java.awt.Color(153, 204, 255));
        femalebutton.setText("Female"); // NOI18N
        femalebutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                femalebuttonMouseClicked(evt);
            }
        });

        phoneno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phonenoActionPerformed(evt);
            }
        });

        studentpresentaddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                studentpresentaddressKeyTyped(evt);
            }
        });

        studentname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentnameActionPerformed(evt);
            }
        });
        studentname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                studentnameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                studentnameKeyTyped(evt);
            }
        });

        fathername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fathernameActionPerformed(evt);
            }
        });

        jLabel13.setText("Date Of Birth"); // NOI18N

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel23.setForeground(new java.awt.Color(255, 0, 51));
        jLabel23.setText("*"); // NOI18N

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel24.setForeground(new java.awt.Color(255, 0, 51));
        jLabel24.setText("*"); // NOI18N

        birthdate.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_SINGLE);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(mothername)
                                    .addComponent(studentname, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                    .addComponent(fathername, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel23)))
                            .addComponent(phoneno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(studentpresentaddress, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                .addGap(189, 189, 189))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(malebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(femalebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(231, 231, 231))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(26, 26, 26)
                        .addComponent(birthdate, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(231, 231, 231))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(studentname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(fathername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mothername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(phoneno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(studentpresentaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(malebutton)
                        .addComponent(femalebutton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(birthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 0)));

        jLabel7.setText("Admission Number"); // NOI18N

        jLabel8.setText("Roll Number"); // NOI18N

        jLabel9.setText("DOA"); // NOI18N

        jLabel11.setText("Class"); // NOI18N

        jLabel12.setText("Section"); // NOI18N

        classcombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        classcombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                classcomboMouseClicked(evt);
            }
        });
        classcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classcomboActionPerformed(evt);
            }
        });

        sectioncombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        sectioncombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sectioncomboMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sectioncomboMouseEntered(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                sectioncomboMouseReleased(evt);
            }
        });
        sectioncombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sectioncomboActionPerformed(evt);
            }
        });
        sectioncombo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                sectioncomboFocusLost(evt);
            }
        });

        studentadmissionno.setBackground(new java.awt.Color(204, 204, 255));
        studentadmissionno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentadmissionnoActionPerformed(evt);
            }
        });
        studentadmissionno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                studentadmissionnoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                studentadmissionnoKeyTyped(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel26.setForeground(new java.awt.Color(255, 0, 102));
        jLabel26.setText("*"); // NOI18N

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel28.setForeground(new java.awt.Color(255, 0, 0));
        jLabel28.setText("*"); // NOI18N

        doa.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_SINGLE);
        doa.addCursorMoveListener(new datechooser.events.CursorMoveListener() {
            public void onCursorMove(datechooser.events.CursorMoveEvent evt) {
                doaOnCursorMove(evt);
            }
        });
        doa.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                doaOnCommit(evt);
            }
        });
        doa.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
            public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
                doaOnSelectionChange(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel29.setForeground(new java.awt.Color(255, 0, 102));
        jLabel29.setText("*"); // NOI18N

        jLabel78.setForeground(new java.awt.Color(0, 0, 153));
        jLabel78.setText("Unique key");

        jLabel79.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel79.setForeground(new java.awt.Color(255, 0, 102));
        jLabel79.setText("*"); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(studentadmissionno, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                                .addGap(56, 56, 56))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(classcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(doa, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(224, 224, 224))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel79))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rollno, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(sectioncombo, 0, 124, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel29)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel26)))
                                .addGap(205, 205, 205)
                                .addComponent(jLabel28))))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentadmissionno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel78)
                    .addComponent(jLabel79))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(classcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sectioncombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rollno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(77, 77, 77)
                        .addComponent(jLabel28))
                    .addComponent(doa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 255, 51)));

        admissionfeecheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admissionfeecheckboxActionPerformed(evt);
            }
        });

        jLabel25.setText("Load Admission Fee"); // NOI18N

        admissionfeecheckbox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admissionfeecheckbox1ActionPerformed(evt);
            }
        });

        jLabel30.setText("Print Identity Card"); // NOI18N

        admissionfeecheckbox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admissionfeecheckbox2ActionPerformed(evt);
            }
        });

        jLabel31.setText("Transport "); // NOI18N

        admissionfeecheckbox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admissionfeecheckbox3ActionPerformed(evt);
            }
        });

        jLabel47.setText("Declaration"); // NOI18N

        jLabel80.setText("SMS"); // NOI18N

        smscheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smscheckActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(admissionfeecheckbox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(admissionfeecheckbox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(admissionfeecheckbox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(admissionfeecheckbox3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(smscheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25)
                    .addComponent(admissionfeecheckbox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel30)
                    .addComponent(admissionfeecheckbox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(admissionfeecheckbox2)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel47)
                    .addComponent(admissionfeecheckbox3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel80)
                    .addComponent(smscheck)))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 204)));

        jXImagePanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));

        javax.swing.GroupLayout jXImagePanel1Layout = new javax.swing.GroupLayout(jXImagePanel1);
        jXImagePanel1.setLayout(jXImagePanel1Layout);
        jXImagePanel1Layout.setHorizontalGroup(
            jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jXImagePanel1Layout.setVerticalGroup(
            jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 114, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXImagePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXImagePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        browsepicturepath.setNextFocusableComponent(studentadmissionno);

        exitbutton.setFont(new java.awt.Font("Tahoma", 1, 12));
        exitbutton.setForeground(new java.awt.Color(0, 0, 255));
        exitbutton.setText("Exit"); // NOI18N
        exitbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbuttonActionPerformed(evt);
            }
        });

        resetbutton.setFont(new java.awt.Font("Tahoma", 1, 12));
        resetbutton.setForeground(new java.awt.Color(0, 0, 255));
        resetbutton.setText("Reset"); // NOI18N
        resetbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbuttonActionPerformed(evt);
            }
        });

        savebutton.setFont(new java.awt.Font("Tahoma", 1, 12));
        savebutton.setForeground(new java.awt.Color(0, 0, 255));
        savebutton.setText("Save"); // NOI18N
        savebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebuttonActionPerformed(evt);
            }
        });

        browsepicturebutton.setFont(new java.awt.Font("Tahoma", 1, 12));
        browsepicturebutton.setForeground(new java.awt.Color(0, 0, 255));
        browsepicturebutton.setText("Browse picture"); // NOI18N
        browsepicturebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browsepicturebuttonActionPerformed(evt);
            }
        });

        jTextPane3.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane3.setEditable(false);
        jTextPane3.setFont(new java.awt.Font("Tahoma", 0, 24));
        jTextPane3.setText("                                         Add Student"); // NOI18N
        jScrollPane4.setViewportView(jTextPane3);

        jTextPane4.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane4.setEditable(false);
        jTextPane4.setText("     ADD the student on admission time with admission no., class, roll no.,father's name and his/her name .....* mandatory Fields"); // NOI18N
        jScrollPane5.setViewportView(jTextPane4);

        updatebutton.setFont(new java.awt.Font("Tahoma", 1, 12));
        updatebutton.setForeground(new java.awt.Color(0, 0, 255));
        updatebutton.setText("Update"); // NOI18N
        updatebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebuttonActionPerformed(evt);
            }
        });

        loadmsg.setForeground(new java.awt.Color(102, 0, 102));
        loadmsg.setText("--------------------------Confirmation-----------------------");

        jXTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jXTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXTable1MouseClicked(evt);
            }
        });
        jXTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jXTable1KeyTyped(evt);
            }
        });
        jScrollPane15.setViewportView(jXTable1);

        jXTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Roll", "Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jXTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXTable2MouseClicked(evt);
            }
        });
        jXTable2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jXTable2KeyTyped(evt);
            }
        });
        jScrollPane16.setViewportView(jXTable2);

        jLabel76.setText("Name Wise Student List,Click for Bio-Data");

        jLabel77.setText("Adm. No. Wise Student List,Click for Bio-Data");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(browsepicturepath, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(browsepicturebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(103, 103, 103))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(loadmsg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(updatebutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(savebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(93, 93, 93)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(resetbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, Short.MAX_VALUE))
                            .addComponent(exitbutton, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)))
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(80, 80, 80))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(browsepicturepath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(browsepicturebutton))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(savebutton)
                            .addComponent(resetbutton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updatebutton)
                            .addComponent(exitbutton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loadmsg)
                        .addGap(34, 34, 34))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel76)
                            .addComponent(jLabel77))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane15, 0, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                        .addGap(15, 15, 15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("  Official Information     ", jPanel1);

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jTextPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 0, 24));
        jTextPane1.setText("                                      More Information      "); // NOI18N
        jScrollPane2.setViewportView(jTextPane1);

        jPanel7.setBackground(new java.awt.Color(0, 204, 204));

        jLabel6.setText("Documents Detail"); // NOI18N

        jLabel14.setText("Admission Channel"); // NOI18N

        jLabel15.setText("Last School Attended"); // NOI18N

        jLabel16.setText("Last Grade/percentage"); // NOI18N

        jLabel17.setText("Religion"); // NOI18N

        jLabel18.setText("Category"); // NOI18N

        jLabel19.setText("Blood Group"); // NOI18N

        jLabel20.setText("School Houses"); // NOI18N

        jLabel21.setText("Medium Of Instruction"); // NOI18N

        jLabel22.setText("Disability"); // NOI18N

        documentDetailArea.setColumns(20);
        documentDetailArea.setRows(5);
        jScrollPane1.setViewportView(documentDetailArea);

        admissionChannelCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));

        lastSchool.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastSchoolActionPerformed(evt);
            }
        });

        disabilityCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));

        instructionCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));

        religionCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));

        categoryCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                categoryComboMouseClicked(evt);
            }
        });
        categoryCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryComboActionPerformed(evt);
            }
        });

        bloodGroupCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));

        houseCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));

        detailSaveButton.setFont(new java.awt.Font("Tahoma", 1, 12));
        detailSaveButton.setForeground(new java.awt.Color(0, 0, 255));
        detailSaveButton.setText("Save"); // NOI18N
        detailSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailSaveButtonActionPerformed(evt);
            }
        });

        detailUpdateButton.setFont(new java.awt.Font("Tahoma", 1, 12));
        detailUpdateButton.setForeground(new java.awt.Color(0, 0, 255));
        detailUpdateButton.setText("Update"); // NOI18N
        detailUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailUpdateButtonActionPerformed(evt);
            }
        });

        detailExitButton.setFont(new java.awt.Font("Tahoma", 1, 12));
        detailExitButton.setForeground(new java.awt.Color(0, 0, 255));
        detailExitButton.setText("Exit"); // NOI18N
        detailExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailExitButtonActionPerformed(evt);
            }
        });

        jLabel32.setText("Behaviour"); // NOI18N

        behaviourcombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose", "Sucks Thumb", "Bites Nails", "Gets Frightened", "Stutters/Stammers", "Introvert", "Prefers Group", "Prefers Peer Group", "Toilet Trained", "Thinker", "Ambitious", "Extrovert", "Other" }));

        jLabel33.setText("Special Interest"); // NOI18N

        interestcombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose", "Music", "Drawing/Coloring", "Swimming", "Dance", "Craft", "Skating", "Other" }));

        jLabel34.setText("Email"); // NOI18N

        jTextPane2.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane2.setEditable(false);
        jTextPane2.setText("Set the minute information about your student like last schools documents at the time of admission as CLC,Character certificate etc."); // NOI18N
        jScrollPane3.setViewportView(jTextPane2);

        jLabel82.setText("A/C No.");

        jLabel83.setText("Bank");

        jLabel84.setText("Branch");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel83)
                    .addComponent(jLabel82)
                    .addComponent(jLabel84))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel82)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel83)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel84)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jLabel81.setText("Sub Category");

        jCheckBox3.setText("Bank Details");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jLabel85.setText("Student Resi.Environment"); // NOI18N

        disabilityCombo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose", "Rural", "Urban" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(detailSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(detailUpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(detailExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                        .addGap(510, 510, 510))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addGap(563, 563, 563))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(80, 80, 80)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(admissionChannelCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE))
                                    .addComponent(lastSchool, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(63, 63, 63))
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(categoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(religionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(behaviourcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(interestcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bloodGroupCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(houseCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(instructionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(disabilityCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                                .addGap(80, 80, 80)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lastPercentage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(email, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(categoryCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)))))
                .addGap(193, 193, 193))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(disabilityCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(547, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(41, 41, 41))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(admissionChannelCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(lastSchool, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lastPercentage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jCheckBox3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(religionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(categoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(categoryCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel81))
                        .addGap(14, 14, 14)
                        .addComponent(behaviourcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel32)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(interestcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bloodGroupCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(houseCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(instructionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(disabilityCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(3, 3, 3)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(disabilityCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel85))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(detailExitButton)
                        .addComponent(detailUpdateButton))
                    .addComponent(detailSaveButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(531, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("    Records and Details ", jPanel2);

        jPanel8.setBackground(new java.awt.Color(0, 204, 204));

        jPanel10.setBackground(new java.awt.Color(153, 204, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 102)));

        jLabel35.setText("Father's Name"); // NOI18N

        jLabel38.setText("Qualification"); // NOI18N

        qualification1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                qualification1KeyTyped(evt);
            }
        });

        fathername1.setEditable(false);
        fathername1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fathername1ActionPerformed(evt);
            }
        });

        jLabel40.setText("Date Of Birth"); // NOI18N

        birth1.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_SINGLE);

        jLabel39.setText("Occupation"); // NOI18N

        occupation1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                occupation1KeyTyped(evt);
            }
        });

        jLabel41.setText("Date OfWed. Anni."); // NOI18N

        wed1.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_SINGLE);

        jLabel36.setText("Designation"); // NOI18N

        jLabel42.setText("Office Address"); // NOI18N

        jLabel43.setText("Tel. No."); // NOI18N

        phone1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phone1KeyTyped(evt);
            }
        });

        officeaddress1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                officeaddress1KeyTyped(evt);
            }
        });

        designation1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                designation1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phone1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel10Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(fathername1)
                                        .addComponent(occupation1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                        .addComponent(qualification1)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(officeaddress1)
                                    .addComponent(designation1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(birth1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(wed1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(149, 149, 149))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(fathername1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(qualification1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(occupation1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(designation1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(officeaddress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addGap(11, 11, 11)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41)
                    .addComponent(wed1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(birth1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        resetbutton2.setFont(new java.awt.Font("Tahoma", 1, 12));
        resetbutton2.setForeground(new java.awt.Color(0, 0, 255));
        resetbutton2.setText("Reset"); // NOI18N
        resetbutton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbutton2ActionPerformed(evt);
            }
        });

        updatebutton2.setFont(new java.awt.Font("Tahoma", 1, 12));
        updatebutton2.setForeground(new java.awt.Color(0, 0, 255));
        updatebutton2.setText("Update"); // NOI18N
        updatebutton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebutton2ActionPerformed(evt);
            }
        });

        exitbutton2.setFont(new java.awt.Font("Tahoma", 1, 12));
        exitbutton2.setForeground(new java.awt.Color(0, 0, 255));
        exitbutton2.setText("Exit"); // NOI18N
        exitbutton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbutton2ActionPerformed(evt);
            }
        });

        jPanel12.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 204)));

        jXImagePanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));

        javax.swing.GroupLayout jXImagePanel3Layout = new javax.swing.GroupLayout(jXImagePanel3);
        jXImagePanel3.setLayout(jXImagePanel3Layout);
        jXImagePanel3Layout.setHorizontalGroup(
            jXImagePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jXImagePanel3Layout.setVerticalGroup(
            jXImagePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 114, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXImagePanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXImagePanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        savebutton2.setFont(new java.awt.Font("Tahoma", 1, 12));
        savebutton2.setForeground(new java.awt.Color(0, 0, 255));
        savebutton2.setText("Save"); // NOI18N
        savebutton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebutton2ActionPerformed(evt);
            }
        });

        jPanel11.setBackground(new java.awt.Color(153, 204, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 102)));

        jLabel37.setText("Mother's Name"); // NOI18N

        jLabel44.setText("Qualification"); // NOI18N

        qualification2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                qualification2KeyTyped(evt);
            }
        });

        mothername1.setEditable(false);
        mothername1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mothername1ActionPerformed(evt);
            }
        });

        jLabel45.setText("Date Of Birth"); // NOI18N

        birth2.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_SINGLE);

        jLabel46.setText("Occupation"); // NOI18N

        occupation2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                occupation2KeyTyped(evt);
            }
        });

        jLabel48.setText("Designation"); // NOI18N

        jLabel49.setText("Office Address"); // NOI18N

        jLabel50.setText("Tel. No."); // NOI18N

        phone2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phone2KeyTyped(evt);
            }
        });

        officeaddress2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                officeaddress2KeyTyped(evt);
            }
        });

        designation2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                designation2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addGap(51, 51, 51)))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phone2, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                            .addComponent(designation2, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                            .addComponent(officeaddress2, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(qualification2)
                                .addComponent(mothername1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                                .addComponent(occupation2)))
                        .addGap(125, 125, 125))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(birth2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(mothername1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(qualification2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel44)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(occupation2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(designation2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(officeaddress2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45)
                    .addComponent(birth2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        browsepicturebutton2.setFont(new java.awt.Font("Tahoma", 1, 12));
        browsepicturebutton2.setForeground(new java.awt.Color(0, 0, 255));
        browsepicturebutton2.setText("Browse picture"); // NOI18N
        browsepicturebutton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browsepicturebutton2ActionPerformed(evt);
            }
        });

        jPanel13.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 204)));

        jXImagePanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));

        javax.swing.GroupLayout jXImagePanel4Layout = new javax.swing.GroupLayout(jXImagePanel4);
        jXImagePanel4.setLayout(jXImagePanel4Layout);
        jXImagePanel4Layout.setHorizontalGroup(
            jXImagePanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jXImagePanel4Layout.setVerticalGroup(
            jXImagePanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 114, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXImagePanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXImagePanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        browsepicturebutton3.setFont(new java.awt.Font("Tahoma", 1, 12));
        browsepicturebutton3.setForeground(new java.awt.Color(0, 0, 255));
        browsepicturebutton3.setText("Browse picture"); // NOI18N
        browsepicturebutton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browsepicturebutton3ActionPerformed(evt);
            }
        });

        jTextPane5.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane5.setEditable(false);
        jTextPane5.setText("Add the parentage information of your school student..."); // NOI18N
        jScrollPane8.setViewportView(jTextPane5);

        jTextPane6.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane6.setEditable(false);
        jTextPane6.setFont(new java.awt.Font("Tahoma", 0, 18));
        jTextPane6.setText("                                             Parentage Information"); // NOI18N
        jScrollPane9.setViewportView(jTextPane6);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(updatebutton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(savebutton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                                .addGap(93, 93, 93)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(exitbutton2, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                    .addComponent(resetbutton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(browsepicturebutton2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(browsepicturepath2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(browsepicturepath3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(browsepicturebutton3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(browsepicturepath3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(browsepicturebutton3))
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(browsepicturepath2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(browsepicturebutton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(savebutton2)
                            .addComponent(resetbutton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updatebutton2)
                            .addComponent(exitbutton2)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jTabbedPane1.addTab("   Parentage Information ", jPanel8);

        jPanel14.setBackground(new java.awt.Color(0, 204, 204));

        jPanel15.setBackground(new java.awt.Color(153, 204, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 102)));

        jLabel51.setText("Sibling's  Name"); // NOI18N

        jLabel52.setText("Qualification/Class"); // NOI18N

        squalification1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                squalification1KeyTyped(evt);
            }
        });

        siblingname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siblingname1ActionPerformed(evt);
            }
        });

        jLabel53.setText("Date Of Birth"); // NOI18N

        sdob1.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_SINGLE);

        jLabel54.setText("School/College Name"); // NOI18N

        sschool1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                sschool1KeyTyped(evt);
            }
        });

        jLabel56.setText("Occupation"); // NOI18N

        jLabel57.setText("Office Address"); // NOI18N

        jLabel58.setText("Tel. No."); // NOI18N

        stel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stel1KeyTyped(evt);
            }
        });

        sofficeaddress1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                sofficeaddress1KeyTyped(evt);
            }
        });

        soccupation1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soccupation1ActionPerformed(evt);
            }
        });

        jCheckBox1.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox1.setText("Same School");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel68.setText("Gender"); // NOI18N

        jRadioButton3.setBackground(new java.awt.Color(153, 204, 255));
        jRadioButton3.setText("Male");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton4.setBackground(new java.awt.Color(153, 204, 255));
        jRadioButton4.setText("Female");

        sibling1studentid.setEditable(false);

        jLabel74.setText("Id");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel15Layout.createSequentialGroup()
                                        .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addComponent(jLabel58, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                    .addComponent(jLabel57, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                    .addComponent(jLabel56, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                    .addComponent(jLabel54, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(siblingname1)
                                            .addComponent(sschool1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                            .addComponent(squalification1)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(sofficeaddress1)
                                        .addComponent(soccupation1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addGap(75, 75, 75))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel15Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sibling1studentid, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(sdob1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(267, 267, 267))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(175, Short.MAX_VALUE))))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(siblingname1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(squalification1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel74)
                    .addComponent(sibling1studentid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(sschool1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(soccupation1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sofficeaddress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sdob1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        resetbutton3.setFont(new java.awt.Font("Tahoma", 1, 12));
        resetbutton3.setForeground(new java.awt.Color(0, 0, 255));
        resetbutton3.setText("Reset"); // NOI18N
        resetbutton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbutton3ActionPerformed(evt);
            }
        });

        jPanel16.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 204)));

        jXImagePanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));

        javax.swing.GroupLayout jXImagePanel5Layout = new javax.swing.GroupLayout(jXImagePanel5);
        jXImagePanel5.setLayout(jXImagePanel5Layout);
        jXImagePanel5Layout.setHorizontalGroup(
            jXImagePanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jXImagePanel5Layout.setVerticalGroup(
            jXImagePanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 114, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXImagePanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXImagePanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        update.setFont(new java.awt.Font("Tahoma", 1, 12));
        update.setForeground(new java.awt.Color(0, 0, 255));
        update.setText("Update"); // NOI18N
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        jPanel17.setBackground(new java.awt.Color(153, 204, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 102)));

        jLabel59.setText("Sibling's Name"); // NOI18N

        jLabel60.setText("Qualification/Class"); // NOI18N

        squalification5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                squalification5KeyTyped(evt);
            }
        });

        siblingname2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siblingname2ActionPerformed(evt);
            }
        });

        jLabel61.setText("Date Of Birth"); // NOI18N

        sdob2.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_SINGLE);

        jLabel62.setText("School/College Name"); // NOI18N

        sschool2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                sschool2KeyTyped(evt);
            }
        });

        jLabel64.setText("Occupation"); // NOI18N

        jLabel65.setText("Office Address"); // NOI18N

        jLabel66.setText("Tel. No."); // NOI18N

        stel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stel2KeyTyped(evt);
            }
        });

        sofficeaddress2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                sofficeaddress2KeyTyped(evt);
            }
        });

        soccupation2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soccupation2ActionPerformed(evt);
            }
        });

        jCheckBox2.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox2.setText("Same School");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jLabel69.setText("Gender"); // NOI18N

        jRadioButton5.setBackground(new java.awt.Color(153, 204, 255));
        jRadioButton5.setText("Male");

        jRadioButton6.setBackground(new java.awt.Color(153, 204, 255));
        jRadioButton6.setText("Female");

        sibling2studentid.setEditable(false);

        jLabel75.setText("Id");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(jLabel62, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(squalification5)
                            .addComponent(siblingname2, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                            .addComponent(sschool2))
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jCheckBox2))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sibling2studentid, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(71, 71, 71))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel61)
                        .addGap(53, 53, 53)
                        .addComponent(sdob2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(286, Short.MAX_VALUE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addComponent(jRadioButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                    .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                    .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(stel2)
                                    .addComponent(sofficeaddress2)
                                    .addComponent(soccupation2, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))))
                        .addContainerGap(187, Short.MAX_VALUE))))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(siblingname2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(squalification5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel75)
                            .addComponent(sibling2studentid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel59)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel60)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sschool2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62)
                    .addComponent(jCheckBox2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64)
                    .addComponent(soccupation2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sofficeaddress2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel66))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel61)
                    .addComponent(sdob2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel69)
                        .addComponent(jRadioButton5))
                    .addComponent(jRadioButton6)))
        );

        browsepicturebutton4.setFont(new java.awt.Font("Tahoma", 1, 12));
        browsepicturebutton4.setForeground(new java.awt.Color(0, 0, 255));
        browsepicturebutton4.setText("Browse picture"); // NOI18N
        browsepicturebutton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browsepicturebutton4ActionPerformed(evt);
            }
        });

        jPanel18.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 204)));

        jXImagePanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));

        javax.swing.GroupLayout jXImagePanel6Layout = new javax.swing.GroupLayout(jXImagePanel6);
        jXImagePanel6.setLayout(jXImagePanel6Layout);
        jXImagePanel6Layout.setHorizontalGroup(
            jXImagePanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jXImagePanel6Layout.setVerticalGroup(
            jXImagePanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 114, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXImagePanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXImagePanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        browsepicturebutton5.setFont(new java.awt.Font("Tahoma", 1, 12));
        browsepicturebutton5.setForeground(new java.awt.Color(0, 0, 255));
        browsepicturebutton5.setText("Browse picture"); // NOI18N
        browsepicturebutton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browsepicturebutton5ActionPerformed(evt);
            }
        });

        jTextPane7.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane7.setEditable(false);
        jTextPane7.setText("Add information about the siblings of your school student.."); // NOI18N
        jScrollPane10.setViewportView(jTextPane7);

        jTextPane8.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane8.setEditable(false);
        jTextPane8.setFont(new java.awt.Font("Tahoma", 0, 18));
        jTextPane8.setText("                                             Siblings Information"); // NOI18N
        jScrollPane11.setViewportView(jTextPane8);

        jLabel67.setText("Family Type"); // NOI18N

        jRadioButton1.setBackground(new java.awt.Color(0, 204, 204));
        jRadioButton1.setText("Joint Family");

        jRadioButton2.setBackground(new java.awt.Color(0, 204, 204));
        jRadioButton2.setText("Nuclear Family");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(browsepicturepath4, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(resetbutton3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(browsepicturebutton4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(browsepicturepath5, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(browsepicturebutton5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
            .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(413, Short.MAX_VALUE))
            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(browsepicturepath5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(browsepicturebutton5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(browsepicturepath4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(browsepicturebutton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(update)
                            .addComponent(resetbutton3))))
                .addGap(3, 3, 3)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 786, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 607, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("   Siblings Details     ", jPanel9);

        jPanel20.setBackground(new java.awt.Color(0, 153, 153));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton1.setForeground(new java.awt.Color(0, 0, 255));
        jButton1.setText("Update  Form");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton3.setForeground(new java.awt.Color(0, 0, 255));
        jButton3.setText("Cancel Entry");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextPane9.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane9.setEditable(false);
        jTextPane9.setFont(new java.awt.Font("Tahoma", 0, 18));
        jTextPane9.setText("                                                     Transport Form");
        jScrollPane12.setViewportView(jTextPane9);

        jTextPane10.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane10.setEditable(false);
        jTextPane10.setText("Admit student,who avails School transport..if You want to give concession/waiver on Transport fee, do it by customize in fee deposit section..");
        jScrollPane13.setViewportView(jTextPane10);

        jLabel27.setText("Student Id");

        admissionno.setForeground(new java.awt.Color(0, 0, 255));
        admissionno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                admissionnoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                admissionnoKeyTyped(evt);
            }
        });

        stopname.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        stopname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stopnameMouseClicked(evt);
            }
        });
        stopname.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                stopnameItemStateChanged(evt);
            }
        });
        stopname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopnameActionPerformed(evt);
            }
        });

        jLabel55.setText("Stop Name");

        jLabel63.setText("Route No.");

        routeno.setEnabled(false);

        jLabel70.setText("Bus No.");

        busno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "choose" }));
        busno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                busnoMouseClicked(evt);
            }
        });
        busno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                busnoItemStateChanged(evt);
            }
        });
        busno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busnoActionPerformed(evt);
            }
        });

        jLabel71.setText("Strength");

        strengthtext.setEnabled(false);

        jLabel72.setText("Pick & Drop Point");

        jXTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jXTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXTable3MouseClicked(evt);
            }
        });
        jXTable3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jXTable3KeyTyped(evt);
            }
        });
        jScrollPane14.setViewportView(jXTable3);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton2.setForeground(new java.awt.Color(0, 0, 255));
        jButton2.setText("Submit Form");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel73.setText("Transport Fee");

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton5.setForeground(new java.awt.Color(0, 0, 255));
        jButton5.setText("Transport Boarders");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
            .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel70, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel73, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel71, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel72, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(3, 3, 3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jButton5)
                        .addGap(52, 52, 52)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(admissionno)
                            .addComponent(stopname, 0, 195, Short.MAX_VALUE)
                            .addComponent(routeno))
                        .addGap(158, 158, 158)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(transportfee, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                            .addComponent(busno, 0, 164, Short.MAX_VALUE)
                            .addComponent(strengthtext)
                            .addComponent(picktext))
                        .addGap(424, 424, 424))))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(admissionno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel55)
                            .addComponent(stopname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel63)
                            .addComponent(routeno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel70)
                            .addComponent(busno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel71)
                            .addComponent(strengthtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(picktext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel72))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel73)
                            .addComponent(transportfee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton5)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Transport Facility", jPanel19);

        jPanel24.setBackground(new java.awt.Color(51, 204, 255));

        jScrollPane6.setViewportView(jTextPane11);

        jScrollPane7.setViewportView(jTextPane12);

        jPanel25.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 204)));

        jXImagePanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));

        javax.swing.GroupLayout jXImagePanel2Layout = new javax.swing.GroupLayout(jXImagePanel2);
        jXImagePanel2.setLayout(jXImagePanel2Layout);
        jXImagePanel2Layout.setHorizontalGroup(
            jXImagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jXImagePanel2Layout.setVerticalGroup(
            jXImagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 114, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXImagePanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXImagePanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        browsepicturebutton1.setFont(new java.awt.Font("Tahoma", 1, 12));
        browsepicturebutton1.setForeground(new java.awt.Color(0, 0, 255));
        browsepicturebutton1.setText("Browse picture"); // NOI18N
        browsepicturebutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browsepicturebutton1ActionPerformed(evt);
            }
        });

        jPanel27.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 204)));

        jXImagePanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));

        javax.swing.GroupLayout jXImagePanel8Layout = new javax.swing.GroupLayout(jXImagePanel8);
        jXImagePanel8.setLayout(jXImagePanel8Layout);
        jXImagePanel8Layout.setHorizontalGroup(
            jXImagePanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jXImagePanel8Layout.setVerticalGroup(
            jXImagePanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 114, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXImagePanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXImagePanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        browsepicturebutton6.setFont(new java.awt.Font("Tahoma", 1, 12));
        browsepicturebutton6.setForeground(new java.awt.Color(0, 0, 255));
        browsepicturebutton6.setText("Browse picture"); // NOI18N
        browsepicturebutton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browsepicturebutton6ActionPerformed(evt);
            }
        });

        browsepicturebutton7.setFont(new java.awt.Font("Tahoma", 1, 12));
        browsepicturebutton7.setForeground(new java.awt.Color(0, 0, 255));
        browsepicturebutton7.setText("Browse picture"); // NOI18N
        browsepicturebutton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browsepicturebutton7ActionPerformed(evt);
            }
        });

        jPanel28.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 204)));

        jXImagePanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));

        javax.swing.GroupLayout jXImagePanel9Layout = new javax.swing.GroupLayout(jXImagePanel9);
        jXImagePanel9.setLayout(jXImagePanel9Layout);
        jXImagePanel9Layout.setHorizontalGroup(
            jXImagePanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jXImagePanel9Layout.setVerticalGroup(
            jXImagePanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 114, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXImagePanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXImagePanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel29.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 204)));

        jXImagePanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));

        javax.swing.GroupLayout jXImagePanel10Layout = new javax.swing.GroupLayout(jXImagePanel10);
        jXImagePanel10.setLayout(jXImagePanel10Layout);
        jXImagePanel10Layout.setHorizontalGroup(
            jXImagePanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jXImagePanel10Layout.setVerticalGroup(
            jXImagePanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 114, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXImagePanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXImagePanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        browsepicturebutton8.setFont(new java.awt.Font("Tahoma", 1, 12));
        browsepicturebutton8.setForeground(new java.awt.Color(0, 0, 255));
        browsepicturebutton8.setText("Browse picture"); // NOI18N
        browsepicturebutton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browsepicturebutton8ActionPerformed(evt);
            }
        });

        jPanel30.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 204)));

        jXImagePanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));

        javax.swing.GroupLayout jXImagePanel11Layout = new javax.swing.GroupLayout(jXImagePanel11);
        jXImagePanel11.setLayout(jXImagePanel11Layout);
        jXImagePanel11Layout.setHorizontalGroup(
            jXImagePanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jXImagePanel11Layout.setVerticalGroup(
            jXImagePanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 114, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXImagePanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXImagePanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        browsepicturebutton9.setFont(new java.awt.Font("Tahoma", 1, 12));
        browsepicturebutton9.setForeground(new java.awt.Color(0, 0, 255));
        browsepicturebutton9.setText("Browse picture"); // NOI18N
        browsepicturebutton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browsepicturebutton9ActionPerformed(evt);
            }
        });

        jPanel31.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 204)));

        jXImagePanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));

        javax.swing.GroupLayout jXImagePanel12Layout = new javax.swing.GroupLayout(jXImagePanel12);
        jXImagePanel12.setLayout(jXImagePanel12Layout);
        jXImagePanel12Layout.setHorizontalGroup(
            jXImagePanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jXImagePanel12Layout.setVerticalGroup(
            jXImagePanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 114, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXImagePanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXImagePanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        browsepicturebutton10.setFont(new java.awt.Font("Tahoma", 1, 12));
        browsepicturebutton10.setForeground(new java.awt.Color(0, 0, 255));
        browsepicturebutton10.setText("Browse picture"); // NOI18N
        browsepicturebutton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browsepicturebutton10ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton6.setForeground(new java.awt.Color(0, 0, 255));
        jButton6.setText("Save");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton7.setForeground(new java.awt.Color(0, 0, 255));
        jButton7.setText("Update");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton8.setText("Print");

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton9.setText("Print");

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton10.setText("Print");

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton11.setText("Print");

        jButton12.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton12.setText("Print");

        jButton13.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton13.setText("Print");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(browsepicturepath1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(browsepicturebutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(browsepicturebutton8, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browsepicturepath8, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(browsepicturepath6, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(browsepicturebutton6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(browsepicturebutton9, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(browsepicturepath9, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(103, 103, 103)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(browsepicturepath10, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(browsepicturebutton10, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(browsepicturepath7, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(browsepicturebutton7, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jButton8)
                .addGap(218, 218, 218)
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 237, Short.MAX_VALUE)
                .addComponent(jButton13)
                .addGap(93, 93, 93))
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jButton10)
                .addGap(211, 211, 211)
                .addComponent(jButton12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 241, Short.MAX_VALUE)
                .addComponent(jButton11)
                .addGap(93, 93, 93))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(browsepicturepath1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(browsepicturebutton1))
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(browsepicturepath7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(browsepicturebutton7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton8)
                            .addComponent(jButton13))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(browsepicturepath8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(browsepicturebutton8))
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(browsepicturepath10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(browsepicturebutton10))))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(browsepicturepath6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(browsepicturebutton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9)
                        .addGap(20, 20, 20)
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(browsepicturepath9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(browsepicturebutton9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jButton12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton7)
                            .addComponent(jButton6)))
                    .addComponent(jButton10)
                    .addComponent(jButton11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 786, Short.MAX_VALUE)
            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel21Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 603, Short.MAX_VALUE)
            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel21Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("    Student Documents   ", jPanel21);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void malebuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_malebuttonMouseClicked
        int keycode=evt.getID();
        if(keycode==MouseEvent.MOUSE_CLICKED)
            loadStudentOnGenderBasis();// TODO add your handling code here:
}//GEN-LAST:event_malebuttonMouseClicked

    private void malebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_malebuttonActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_malebuttonActionPerformed

    private void femalebuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_femalebuttonMouseClicked
        int keycode=evt.getID();
        if(keycode==MouseEvent.MOUSE_CLICKED)
            loadStudentOnGenderBasis();    // TODO add your handling code here:
}//GEN-LAST:event_femalebuttonMouseClicked

    private void phonenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phonenoActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_phonenoActionPerformed

    private void studentpresentaddressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_studentpresentaddressKeyTyped
        int keycode=evt.getID();
        if(keycode==KeyEvent.KEY_TYPED)
            loadStudentOnAddressBasis();      // TODO add your handling code here:
}//GEN-LAST:event_studentpresentaddressKeyTyped

    private void studentnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentnameActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_studentnameActionPerformed

    private void studentnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_studentnameKeyPressed
        //int keycode=evt.getID();        // TODO add your handling code here:
}//GEN-LAST:event_studentnameKeyPressed

    private void studentnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_studentnameKeyTyped
        int keycode=evt.getID();
        if(keycode==KeyEvent.KEY_TYPED)
            if(!studentname.getText().isEmpty())
                loadStudentNameTable();

        // TODO add your handling code here:
}//GEN-LAST:event_studentnameKeyTyped

    private void fathernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fathernameActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_fathernameActionPerformed

    private void classcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classcomboActionPerformed
        //if(jCheckBox1.isSelected())
        //jCheckBox1.setSelected(false);
        if(!classcombo.getSelectedItem().equals("choose")) {
            sectionFilter();
            loadRollNo();
        }      //  loadStudentOnClassBasis();// TODO add your handling code here:
}//GEN-LAST:event_classcomboActionPerformed

    private void sectioncomboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sectioncomboMouseClicked
        if(!sectioncombo.getSelectedItem().equals(" "))
            loadRollNoOnBasisOfSection();
      if(adm==1)
        generateAdmissionNoOnBasisofClass();
         //  if(rol==1)
             generateRollNoOnBasisofSection();
               
        // TODO add your handling code here:
}//GEN-LAST:event_sectioncomboMouseClicked

    private void sectioncomboMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sectioncomboMouseEntered

}//GEN-LAST:event_sectioncomboMouseEntered

    private void sectioncomboMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sectioncomboMouseReleased
        // TODO add your handling code here:
}//GEN-LAST:event_sectioncomboMouseReleased

    private void sectioncomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sectioncomboActionPerformed
//generateRollNoOnBasisofSection();

        // TODO add your handling code here:
}//GEN-LAST:event_sectioncomboActionPerformed

    private void sectioncomboFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sectioncomboFocusLost
        // TODO add your handling code here:
}//GEN-LAST:event_sectioncomboFocusLost

    private void studentadmissionnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentadmissionnoActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_studentadmissionnoActionPerformed

    private void studentadmissionnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_studentadmissionnoKeyPressed
        int keycode=evt.getKeyCode();
        if(keycode==KeyEvent.VK_ENTER) {
            if(!studentadmissionno.getText().isEmpty()) {
                jXImagePanel1.setImage(null);
                loadStudent();
                loadPicture();
                //jTextField10.setEditable(false);
                loadStudentDetail();

                loadStudentParentage();
                loadPictureParentage();

                loadStudentSibling();
                loadPictureSibling();
loadDocs1();

            }
        }
        // TODO add your handling code here:
}//GEN-LAST:event_studentadmissionnoKeyPressed

    private void studentadmissionnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_studentadmissionnoKeyTyped
        int keycode=evt.getID();
        String id;
        if(keycode==KeyEvent.KEY_TYPED) {
            if(!studentadmissionno.getText().isEmpty()) {
                id=studentadmissionno.getText();
                loadAdmissionNoTable(id);
            }
        }             // TODO add your handling code here:
}//GEN-LAST:event_studentadmissionnoKeyTyped

    private void doaOnCursorMove(datechooser.events.CursorMoveEvent evt) {//GEN-FIRST:event_doaOnCursorMove
        // TODO add your handling code here:
}//GEN-LAST:event_doaOnCursorMove

    private void doaOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_doaOnCommit
        // TODO add your handling code here:
}//GEN-LAST:event_doaOnCommit

    private void doaOnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_doaOnSelectionChange
        // TODO add your handling code here:
}//GEN-LAST:event_doaOnSelectionChange

    private void admissionfeecheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admissionfeecheckboxActionPerformed
        //new com.duc.FeeDepartment.FeeCounter.FeeCounter().loadParticularStudentAdmissionStructureFromAddStudent(Integer.parseInt(jTextField10.getText()),jComboBox1.getSelectedItem().toString(),doa.getText());
       if(admissionfeecheckbox.isSelected())
        {
        new com.duc.FeeDepartment.FeeCounter1().loadParticularStudentAdmissionStructureFromAddStudent(studentadmissionno.getText(),classcombo.getSelectedItem().toString(),monthofadmission);
       }// TODO add your handling code here:
}//GEN-LAST:event_admissionfeecheckboxActionPerformed

    private void admissionfeecheckbox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admissionfeecheckbox1ActionPerformed
        // TODO add your handling code here:
        String id=null;
        if(admissionfeecheckbox1.isSelected())
        {
        if(!studentadmissionno.getText().isEmpty())
            id=studentadmissionno.getText();
        new com.duc.StudentDepartment.SearchStudent.IDCardPrint().printStudentidCard(id);
        }
}//GEN-LAST:event_admissionfeecheckbox1ActionPerformed

    private void admissionfeecheckbox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admissionfeecheckbox2ActionPerformed
        String id=null;
        if(admissionfeecheckbox2.isSelected())
        {
        if(!studentadmissionno.getText().isEmpty())
            id=studentadmissionno.getText();
        com.duc.SpecialDepartment.MoreSection.TransportSection.BusBoarders r=new com.duc.SpecialDepartment.MoreSection.TransportSection.BusBoarders();
        r.setAdmissionNo(id);
        r.setVisible(true);
        this.add(r,0);
        }
}//GEN-LAST:event_admissionfeecheckbox2ActionPerformed

    private void admissionfeecheckbox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admissionfeecheckbox3ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_admissionfeecheckbox3ActionPerformed

    private void exitbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbuttonActionPerformed
this.dispose();
     
}//GEN-LAST:event_exitbuttonActionPerformed

    private void resetbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbuttonActionPerformed
        reset();
        // TODO add your handling code here:
}//GEN-LAST:event_resetbuttonActionPerformed

    private void savebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebuttonActionPerformed
        if(!studentadmissionno.getText().isEmpty()) {//change for autoincrement
           
            try {
                ps=con.prepareStatement("select TO_DAYS(?) - TO_DAYS(?) ");
                ps.setString(1,birthdate.getText());
                ps.setString(2,doa.getText());

                rs=ps.executeQuery();
                System.out.println(doa.getText());
                rs.next();
                int comp=rs.getInt(1);
                if(comp<0) {
                    ps=con.prepareStatement("select * from studententry where class=? and section=? and roll=?");
                    ps.setInt(1,Integer.parseInt(classmap1.get(classcombo.getSelectedItem()).toString()));
                    ps.setInt(2,Integer.parseInt(sectionmap1.get(sectioncombo.getSelectedItem()).toString()));
                    ps.setString(3,rollno.getText());

                    rs=ps.executeQuery();
                    if(!rs.next())

                        saveStudent();
                    else JOptionPane.showMessageDialog(null,"Roll No. Exist in this Class","Roll No Alarm",JOptionPane.PLAIN_MESSAGE);

                } else JOptionPane.showMessageDialog(null,"Birth date is equal or greater","Birth Date Alarm",JOptionPane.PLAIN_MESSAGE);

            }catch(Exception e) {
                e.printStackTrace();
            }//

            // getAdmissionNo();

        }else if(studentadmissionno.getText().isEmpty()) {
            //JOptionPane.showMessageDialog(null,"press Update for upgrade the student data.","report",JOptionPane.PLAIN_MESSAGE);
            JOptionPane.showMessageDialog(null,"Fill Admission Number","Admission Number Empty",JOptionPane.PLAIN_MESSAGE);
        }
}//GEN-LAST:event_savebuttonActionPerformed

    private void browsepicturebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browsepicturebuttonActionPerformed
        browsePicture();        // TODO add your handling code here:
}//GEN-LAST:event_browsepicturebuttonActionPerformed

    private void updatebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebuttonActionPerformed
        if(studentname.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Atleast Fill name,father's name ,class and  roll no.","report",JOptionPane.PLAIN_MESSAGE);
        } else {
            // jTextField10.setEditable(false);
            updateStudent();
        }// TODO add your handling code here:
}//GEN-LAST:event_updatebuttonActionPerformed

        private void lastSchoolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastSchoolActionPerformed
            // TODO add your handling code here:
}//GEN-LAST:event_lastSchoolActionPerformed

        private void detailSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailSaveButtonActionPerformed

            saveStudentDetail();
           
}//GEN-LAST:event_detailSaveButtonActionPerformed

        private void detailUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailUpdateButtonActionPerformed
            if (studentadmissionno.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"fill the general information for this student","report",JOptionPane.PLAIN_MESSAGE);
                System.out.println("1");
            }else {
               
                System.out.println("Done2");
                 updateStudentDetail();
               
                
            }
            // TODO add your handling code here:
}//GEN-LAST:event_detailUpdateButtonActionPerformed

        private void detailExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailExitButtonActionPerformed
            this.dispose();        // TODO add your handling code here:
}//GEN-LAST:event_detailExitButtonActionPerformed

        private void qualification1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qualification1KeyTyped
            // TODO add your handling code here:
}//GEN-LAST:event_qualification1KeyTyped

        private void fathername1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fathername1ActionPerformed
            // TODO add your handling code here:
}//GEN-LAST:event_fathername1ActionPerformed

        private void occupation1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_occupation1KeyTyped
            // TODO add your handling code here:
}//GEN-LAST:event_occupation1KeyTyped

        private void phone1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phone1KeyTyped
            // TODO add your handling code here:
}//GEN-LAST:event_phone1KeyTyped

        private void officeaddress1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_officeaddress1KeyTyped
            // TODO add your handling code here:
}//GEN-LAST:event_officeaddress1KeyTyped

        private void designation1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_designation1ActionPerformed
            // TODO add your handling code here:
}//GEN-LAST:event_designation1ActionPerformed

        private void resetbutton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbutton2ActionPerformed
            resetParentage();
}//GEN-LAST:event_resetbutton2ActionPerformed

        private void updatebutton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebutton2ActionPerformed
            if(studentname.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Atleast Fill Student Admission Number in Add Student form","report",JOptionPane.PLAIN_MESSAGE);
            } else {
                // jTextField10.setEditable(false);
                updateStudentParentage();
                updateParentagePicture();// TODO add your handling code here:
            }


        }//GEN-LAST:event_updatebutton2ActionPerformed

        private void exitbutton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbutton2ActionPerformed
            // TODO add your handling code here:
            this.dispose();
}//GEN-LAST:event_exitbutton2ActionPerformed

        private void savebutton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebutton2ActionPerformed
            if(!studentadmissionno.getText().isEmpty()) {
                //  con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
                try {
                    ps=con.prepareStatement("select * from studentfamily where studentid=?");
                    ps.setString(1,admissionno.getText());

                    rs=ps.executeQuery();
                    System.out.println("case1");
                    if(rs.next()) {
                        JOptionPane.showMessageDialog(null,"Press Update Button for update","report",JOptionPane.PLAIN_MESSAGE);
                    }else

                        saveParentage();
                }catch(Exception e) {
                    e.printStackTrace();
                }
            } else  JOptionPane.showMessageDialog(null,"Fill Admission no. in Official information form","Admission no. Blank",JOptionPane.PLAIN_MESSAGE);
            // TODO add your handling code here:
}//GEN-LAST:event_savebutton2ActionPerformed

        private void qualification2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qualification2KeyTyped
            // TODO add your handling code here:
}//GEN-LAST:event_qualification2KeyTyped

        private void mothername1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mothername1ActionPerformed
            // TODO add your handling code here:
}//GEN-LAST:event_mothername1ActionPerformed

        private void occupation2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_occupation2KeyTyped
            // TODO add your handling code here:
}//GEN-LAST:event_occupation2KeyTyped

        private void phone2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phone2KeyTyped
            // TODO add your handling code here:
}//GEN-LAST:event_phone2KeyTyped

        private void officeaddress2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_officeaddress2KeyTyped
            // TODO add your handling code here:
}//GEN-LAST:event_officeaddress2KeyTyped

        private void designation2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_designation2ActionPerformed
            // TODO add your handling code here:
}//GEN-LAST:event_designation2ActionPerformed

        private void browsepicturebutton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browsepicturebutton2ActionPerformed
            browsePictureMother(); // TODO add your handling code here:
}//GEN-LAST:event_browsepicturebutton2ActionPerformed

        private void browsepicturebutton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browsepicturebutton3ActionPerformed
            browsePictureFather();// TODO add your handling code here:
}//GEN-LAST:event_browsepicturebutton3ActionPerformed

        private void squalification1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_squalification1KeyTyped
            // TODO add your handling code here:
}//GEN-LAST:event_squalification1KeyTyped

        private void siblingname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siblingname1ActionPerformed
            // TODO add your handling code here:
}//GEN-LAST:event_siblingname1ActionPerformed

        private void sschool1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sschool1KeyTyped
            // TODO add your handling code here:
}//GEN-LAST:event_sschool1KeyTyped

        private void stel1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stel1KeyTyped
            // TODO add your handling code here:
}//GEN-LAST:event_stel1KeyTyped

        private void sofficeaddress1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sofficeaddress1KeyTyped
            // TODO add your handling code here:
}//GEN-LAST:event_sofficeaddress1KeyTyped

        private void soccupation1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soccupation1ActionPerformed
            // TODO add your handling code here:
}//GEN-LAST:event_soccupation1ActionPerformed

        private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
            if(jCheckBox1.isSelected())
                sibling1studentid.setEditable(true);
            else
                sibling1studentid.setEditable(false);

        }//GEN-LAST:event_jCheckBox1ActionPerformed

        private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
            // TODO add your handling code here:
}//GEN-LAST:event_jRadioButton3ActionPerformed

        private void resetbutton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbutton3ActionPerformed
            resetSibling();
}//GEN-LAST:event_resetbutton3ActionPerformed

        private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
            if(!studentadmissionno.getText().isEmpty()) {
                saveSibling();
                updateSiblingPicture();
            } else  JOptionPane.showMessageDialog(null,"Fill Admission no. in Official information form","Admission no. Blank",JOptionPane.PLAIN_MESSAGE);
            // TODO add your handling code here:
}//GEN-LAST:event_updateActionPerformed

        private void squalification5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_squalification5KeyTyped
            // TODO add your handling code here:
}//GEN-LAST:event_squalification5KeyTyped

        private void siblingname2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siblingname2ActionPerformed
            // TODO add your handling code here:
}//GEN-LAST:event_siblingname2ActionPerformed

        private void sschool2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sschool2KeyTyped
            // TODO add your handling code here:
}//GEN-LAST:event_sschool2KeyTyped

        private void stel2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stel2KeyTyped
            // TODO add your handling code here:
}//GEN-LAST:event_stel2KeyTyped

        private void sofficeaddress2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sofficeaddress2KeyTyped
            // TODO add your handling code here:
}//GEN-LAST:event_sofficeaddress2KeyTyped

        private void soccupation2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soccupation2ActionPerformed
            // TODO add your handling code here:
}//GEN-LAST:event_soccupation2ActionPerformed

        private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
            if(jCheckBox2.isSelected())
                sibling2studentid.setEditable(true);
            else
                sibling2studentid.setEditable(false);
        }//GEN-LAST:event_jCheckBox2ActionPerformed

        private void browsepicturebutton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browsepicturebutton4ActionPerformed
            browsePictureSibling2();
}//GEN-LAST:event_browsepicturebutton4ActionPerformed

        private void browsepicturebutton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browsepicturebutton5ActionPerformed
            browsePictureSibling1();
}//GEN-LAST:event_browsepicturebutton5ActionPerformed

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            updateAuthority();       // TODO add your handling code here:
}//GEN-LAST:event_jButton1ActionPerformed

        private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            removeSubject();        // TODO add your handling code here:
}//GEN-LAST:event_jButton3ActionPerformed

        private void admissionnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_admissionnoKeyPressed
            int keycode=evt.getKeyCode();
            if(keycode==KeyEvent.VK_ENTER) {
                if(!admissionno.getText().isEmpty()) {

                    new com.duc.SpecialDepartment.MoreSection.TransportSection.BusBoarders().loadStudentTransportData();

                }
            }
}//GEN-LAST:event_admissionnoKeyPressed

        private void admissionnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_admissionnoKeyTyped
            int keycode=evt.getID();
            String id;
            if(keycode==KeyEvent.KEY_TYPED) {
                if(!admissionno.getText().isEmpty()) {
                    id=admissionno.getText();
                    loadAdmissionNoTableOfTransport(id);
                }
            }
}//GEN-LAST:event_admissionnoKeyTyped

        private void stopnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopnameMouseClicked
            setStopName();
}//GEN-LAST:event_stopnameMouseClicked

        private void stopnameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_stopnameItemStateChanged


        }//GEN-LAST:event_stopnameItemStateChanged

        private void stopnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopnameActionPerformed

}//GEN-LAST:event_stopnameActionPerformed

        private void busnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_busnoMouseClicked
            int count=0;
            // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
            try {
                ps=con.prepareStatement("select * from transportboarders where busno=?");
                ps.setString(1,busno.getSelectedItem().toString());
                rs=ps.executeQuery();
                while(rs.next())
                    count++;
                strengthtext.setText(String.valueOf(count));
            }catch(Exception e) {
                e.printStackTrace();
            }
}//GEN-LAST:event_busnoMouseClicked

        private void busnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_busnoItemStateChanged

}//GEN-LAST:event_busnoItemStateChanged

        private void busnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busnoActionPerformed

}//GEN-LAST:event_busnoActionPerformed

        private void jXTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTable3MouseClicked


            new com.duc.SpecialDepartment.MoreSection.TransportSection.BusBoarders().loadStudentTransportData();
}//GEN-LAST:event_jXTable3MouseClicked

        private void jXTable3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jXTable3KeyTyped
            // TODO add your handling code here:
}//GEN-LAST:event_jXTable3KeyTyped

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            addSubject();
            addTransportFeeIntofeecustomization();// TODO add your handling code here:
}//GEN-LAST:event_jButton2ActionPerformed

        private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
            com.duc.SpecialDepartment.MoreSection.TransportSection.TransportBoardersList r=   new com.duc.SpecialDepartment.MoreSection.TransportSection.TransportBoardersList();
            this.add(r,0);

            r.setVisible(true);
}//GEN-LAST:event_jButton5ActionPerformed

        private void jXTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTable1MouseClicked
         int currentrow=jXTable1.getSelectedRow();

String id=(jXTable1.getValueAt(currentrow,1).toString());

studentadmissionno.setText(id.trim());
 jXImagePanel1.setImage(null);
loadStudent();
loadPicture();
loadStudentDetail();
}//GEN-LAST:event_jXTable1MouseClicked

        private void jXTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jXTable1KeyTyped
            // TODO add your handling code here:
}//GEN-LAST:event_jXTable1KeyTyped

        private void jXTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTable2MouseClicked
             int currentrow=jXTable2.getSelectedRow();

String id=(jXTable2.getValueAt(currentrow,1).toString());

studentadmissionno.setText(id.trim());
 jXImagePanel1.setImage(null);
loadStudent();
loadPicture();
loadStudentDetail();

}//GEN-LAST:event_jXTable2MouseClicked

        private void jXTable2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jXTable2KeyTyped
            // TODO add your handling code here:
}//GEN-LAST:event_jXTable2KeyTyped

        private void classcomboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classcomboMouseClicked
            if(!classcombo.getSelectedItem().equals("choose"))
            {

 generateAdmissionNoOnBasisofClass();
             if(rol==1)
              generateRollNoOnBasisofSection();
            }
        }//GEN-LAST:event_classcomboMouseClicked

        private void smscheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smscheckActionPerformed
            if(smscheck.isSelected())
            {
                try
 {
        ps=con.prepareStatement("select access from smsaccess where module=? ");
    ps.setString(1,"Admission Confirmation");
    rs=ps.executeQuery();
    if(rs.next())
    {
    if(rs.getInt(1)==1)
        smsAddStudent();
      else JOptionPane.showConfirmDialog(null,"Add SMS package access from Accessories","Contact Administrator",JOptionPane.OK_OPTION);
       // jCheckBox1.setSelected(false);

    }else JOptionPane.showConfirmDialog(null,"Add SMS package access from Accessories","Contact Administrator",JOptionPane.OK_OPTION);
      }catch(Exception e)
{
    e.printStackTrace();
}

               // smsAddStudent();
            }
        }//GEN-LAST:event_smscheckActionPerformed

        private void browsepicturebutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browsepicturebutton1ActionPerformed
            browseDoc1();            // TODO add your handling code here:
}//GEN-LAST:event_browsepicturebutton1ActionPerformed

        private void browsepicturebutton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browsepicturebutton6ActionPerformed
            browseDoc2();      // TODO add your handling code here:
}//GEN-LAST:event_browsepicturebutton6ActionPerformed

        private void browsepicturebutton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browsepicturebutton7ActionPerformed
            browseDoc3();               // TODO add your handling code here:
}//GEN-LAST:event_browsepicturebutton7ActionPerformed

        private void browsepicturebutton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browsepicturebutton8ActionPerformed
            browseDoc4();               // TODO add your handling code here:
}//GEN-LAST:event_browsepicturebutton8ActionPerformed

        private void browsepicturebutton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browsepicturebutton9ActionPerformed
            browseDoc5();               // TODO add your handling code here:
}//GEN-LAST:event_browsepicturebutton9ActionPerformed

        private void browsepicturebutton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browsepicturebutton10ActionPerformed
            browseDoc6();               // TODO add your handling code here:
}//GEN-LAST:event_browsepicturebutton10ActionPerformed

        private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
            saveDocs1();
}//GEN-LAST:event_jButton6ActionPerformed

        private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
            updateDocs1();
}//GEN-LAST:event_jButton7ActionPerformed

        private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
if(jCheckBox3.isSelected()==true)
{
    jPanel22.setVisible(true);
}
else  jPanel22.setVisible(false);// TODO add your handling code here:
        }//GEN-LAST:event_jCheckBox3ActionPerformed

        private void categoryComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryComboActionPerformed
            // TODO add your handling code here:
            //loadSlabCategoryWise();
        }//GEN-LAST:event_categoryComboActionPerformed

        private void categoryComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categoryComboMouseClicked
loadSlabCategoryWise();            // TODO add your handling code here:
        }//GEN-LAST:event_categoryComboMouseClicked

        public void loadSlabCategoryWise()
 {
     try
     {
         ps=con.prepareStatement("select slabid from categorysublist where categoryid=?");
         ps.setInt(1,Integer.parseInt(category1.get(categoryCombo.getSelectedItem().toString()).toString()));
         rs=ps.executeQuery();
         if(rs.next())
         {
          categoryCombo1.removeAllItems();
          rs.first();
          rs.previous();
          while(rs.next())
          {
              categoryCombo1.addItem(categorysubmap.get(rs.getInt(1)));
          }
         }

     }catch(Exception e)
     {
        e.printStackTrace();

     }
 }
     
        public void saveDocs1()
    {
      // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

       try
        {
         ps=con.prepareStatement("insert into studentdocs(id,doc1,doc2,doc3,doc4,doc5,doc6) values(?,?,?,?,?,?,?)");
            ps.setString(1,studentadmissionno.getText());
          if(filepath2.equals("r"))
          {
              ps.setString(2, null);
              filename2=null;
          }
          else
          {
               //  FileInputStream fin1 = new FileInputStream(filepath2);
               System.out.println(filepath2);
            ps.setString(2, filename2);
            filepath2="r";
          }
           if(filepath3.equals("r"))
           {
              ps.setString(3, null);
              filename3=null;
           }
          else
          {
                //System.out.println("dsdsdsdsdsd"+filepath3);
               // FileInputStream fin2 = new FileInputStream(filepath3);
            ps.setString(3, filename3);
            filepath3="r";
          }
             if(filepath4.equals("r"))
             {
              ps.setString(4, null);
              filename4=null;
             }
         else
          { //FileInputStream fin3 = new FileInputStream(filepath4);
            ps.setString(4,filename4);
            filepath4="r";
          }
            if(filepath5.equals("r"))
            {
              ps.setString(5, null);
              filename5=null;
            }
          else
          { //FileInputStream fin4 = new FileInputStream(filepath5);
            ps.setString(5, filename5);
            filepath5="r";
          }
             if(filepath6.equals("r"))
             {
              ps.setString(6, null);
              filename6=null;
             }
         else
          {  //FileInputStream fin5 = new FileInputStream(filepath6);
            ps.setString(6, filename6);
            filepath6="r";
          }
             if(filepath7.equals("r"))
             {
              ps.setString(7,null);
              filename7=null;
             }
          else
          { // FileInputStream fin6 = new FileInputStream(filepath7);
           ps.setString(7,filename7);
           filepath7="r";
          }
           /* ps.setBinaryStream(3, null);
            ps.setBinaryStream(4,null);
            ps.setBinaryStream(5,null);
            ps.setBinaryStream(6,null);
           ps.setBinaryStream(7, null);*/
        ps.executeUpdate();
        System.out.println("picture saved");
JOptionPane.showConfirmDialog(null,"Picture Saved","Picture Saved",JOptionPane.PLAIN_MESSAGE);


        }catch(Exception e)
        {
           e.printStackTrace();
           try
           {
               ps=con.prepareStatement("insert into studentdocs(id) values(?)");
            ps.setString(1,studentadmissionno.getText());

            ps.executeUpdate();
            System.out.println("no picture saved");
        }catch(Exception e2)
        {
            e2.printStackTrace();
            System.out.println("in second cacth");
        }
 }}


public void updateDocs1()
    {
     //  con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

        try
        {
            ps=con.prepareStatement("select * from studentdocs where id=?");
            ps.setString(1,studentadmissionno.getText());
            rs=ps.executeQuery();
            if(rs.next())
            {

            ps=con.prepareStatement("update studentdocs set doc1=?,doc2=?,doc3=?,doc4=?,doc5=?,doc6=? where id=?");

            //  FileInputStream fin1 = new FileInputStream(filepath2);
               System.out.println(filepath2);
            ps.setString(1, filename2);
            ps.setString(2, filename3);
            ps.setString(3,filename4);
            ps.setString(4, filename5);
            ps.setString(5, filename6);
           ps.setString(6,filename7);

            ps.setString(7,studentadmissionno.getText());
        ps.executeUpdate();
        System.out.println("picture updated");
        JOptionPane.showConfirmDialog(null,"Picture Updated","Picture Updated",JOptionPane.PLAIN_MESSAGE);
            }
   else
            {

                saveDocs1();
        System.out.println("picture saved");
            }
        }
            catch(Exception e)
            {
      e.printStackTrace();

        }
        }



public void browseDoc1()
{
    chooser=new JFileChooser();
    chooser.setCurrentDirectory(new File("./pics/documents"));
    int select=chooser.showOpenDialog(null);
    if(select==JFileChooser.APPROVE_OPTION)
    {
         filepath2 = chooser.getSelectedFile().getAbsolutePath();
         filename2="pics/documents/"+chooser.getSelectedFile().getName();
        try

        {
            //File f= new File(filepath2).

               imgpic = ImageIO.read(new File(filepath2));
              jXImagePanel2.setImage(imgpic.getScaledInstance(156, 112, Image.SCALE_SMOOTH));
                browsepicturepath1.setText(chooser.getSelectedFile().getName());

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Invalid Image",
                "ImageIO Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error "+e);

        }

        //jLabel1.setIcon(new ImageIcon(path));
       // savePicture(filepath);
    }
}

            public void browseDoc2()
{
    chooser=new JFileChooser();
    chooser.setCurrentDirectory(new File("./pics/documents"));
    int select=chooser.showOpenDialog(null);
    if(select==JFileChooser.APPROVE_OPTION)
    {
         filepath3 = chooser.getSelectedFile().getAbsolutePath();
             filename3="pics/documents/"+chooser.getSelectedFile().getName();
        try
        {
                imgpic = ImageIO.read(new File(filepath3));
               jXImagePanel8.setImage(imgpic.getScaledInstance(156, 112, Image.SCALE_SMOOTH));
                browsepicturepath6.setText(chooser.getSelectedFile().getName());

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Invalid Image",
                "ImageIO Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error "+e);

        }

        //jLabel1.setIcon(new ImageIcon(path));
       // savePicture(filepath);
    }
}

               public void browseDoc3()
{
    chooser=new JFileChooser();
    chooser.setCurrentDirectory(new File("./pics/documents"));
    int select=chooser.showOpenDialog(null);
    if(select==JFileChooser.APPROVE_OPTION)
    {
         filepath4 = chooser.getSelectedFile().getAbsolutePath();
             filename4="pics/documents/"+chooser.getSelectedFile().getName();
        try
        {
                imgpic = ImageIO.read(new File(filepath4));
               jXImagePanel9.setImage(imgpic.getScaledInstance(156, 112, Image.SCALE_SMOOTH));
                browsepicturepath7.setText(chooser.getSelectedFile().getName());

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Invalid Image",
                "ImageIO Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error "+e);

        }

        //jLabel1.setIcon(new ImageIcon(path));
       // savePicture(filepath);
    }
}

                  public void browseDoc4()
{
    chooser=new JFileChooser();
    chooser.setCurrentDirectory(new File("./pics/documents"));
    int select=chooser.showOpenDialog(null);
    if(select==JFileChooser.APPROVE_OPTION)
    {
         filepath5 = chooser.getSelectedFile().getAbsolutePath();
             filename5="pics/documents/"+chooser.getSelectedFile().getName();
        try
        {
                imgpic = ImageIO.read(new File(filepath5));
               jXImagePanel10.setImage(imgpic.getScaledInstance(156, 112, Image.SCALE_SMOOTH));
                browsepicturepath8.setText(chooser.getSelectedFile().getName());

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Invalid Image",
                "ImageIO Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error "+e);

        }

        //jLabel1.setIcon(new ImageIcon(path));
       // savePicture(filepath);
    }
}
                     public void browseDoc5()
{
    chooser=new JFileChooser();
    chooser.setCurrentDirectory(new File("./pics/documents"));
    int select=chooser.showOpenDialog(null);
    if(select==JFileChooser.APPROVE_OPTION)
    {
         filepath6 = chooser.getSelectedFile().getAbsolutePath();
             filename6="pics/documents/"+chooser.getSelectedFile().getName();
        try
        {
                imgpic = ImageIO.read(new File(filepath6));
               jXImagePanel11.setImage(imgpic.getScaledInstance(156, 112, Image.SCALE_SMOOTH));
                browsepicturepath9.setText(chooser.getSelectedFile().getName());

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Invalid Image",
                "ImageIO Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error "+e);

        }

        //jLabel1.setIcon(new ImageIcon(path));
       // savePicture(filepath);
    }
}
                        public void browseDoc6()
{
    chooser=new JFileChooser();
    chooser.setCurrentDirectory(new File("./pics/documents"));
    int select=chooser.showOpenDialog(null);
    if(select==JFileChooser.APPROVE_OPTION)
    {
         filepath7 = chooser.getSelectedFile().getAbsolutePath();
             filename7="pics/documents/"+chooser.getSelectedFile().getName();
        try
        {
                imgpic = ImageIO.read(new File(filepath7));
               jXImagePanel12.setImage(imgpic.getScaledInstance(156, 112, Image.SCALE_SMOOTH));
                browsepicturepath10.setText(chooser.getSelectedFile().getName());

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Invalid Image",
                "ImageIO Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error "+e);

        }

        //jLabel1.setIcon(new ImageIcon(path));
       // savePicture(filepath);
    }
}
        public void smsAddStudent()
        {
             String id;
         
    //  String inputLine;

   String msg="Thanks For Admission!Your admission no="+studentadmissionno.getText();
    System.out.println("message"+msg);

    //if(jCheckBox1.isSelected())
     //   id=jTextField2.getText().trim();
    //else
       // System.out.println("ravi"+dm.getValueAt(crow,9));
    String newmsg=msg.replace(" ","%20");
    System.out.println("New message"+newmsg);
    try
    {
 /*  if(dm.getValueAt(crow,9).equals("null"))
      {
          JOptionPane.showConfirmDialog(null,"Mobile no. Field is empty","Mobile Empty",JOptionPane.OK_OPTION);
      }
      else
      {*/
         id=phoneno.getText().trim();
       //   System.out.println("number"+id);
          if(phoneno.getText().isEmpty())
          {
          JOptionPane.showConfirmDialog(null,"Mobile no. is Empty","Mobile No. Empty",JOptionPane.OK_OPTION);
      }
      else
      {
          InetAddress thisIp =InetAddress.getLocalHost();
            String ip=thisIp.getHostAddress();
      new com.duc.Accessories.SendSms().SmsCommon(studentadmissionno.getText(),id,newmsg,ip);
      }
     // }
    }catch(Exception e)
    {
        JOptionPane.showConfirmDialog(null,"Mobile no. Field is empty","Mobile Empty",JOptionPane.OK_OPTION);

        e.printStackTrace();
                    
        }
        }
        public void saveStudent()
    {
      String selection;
        if (malebutton.isSelected())
            selection="M";
        else selection="F";

if(studentname.getText().isEmpty() )
{
JOptionPane.showMessageDialog(null,"Fill Name","report",JOptionPane.PLAIN_MESSAGE);
}else
{

if(fathername.getText().isEmpty() )
{
JOptionPane.showMessageDialog(null," Fill father's name .","report",JOptionPane.PLAIN_MESSAGE);
}
else {
      if(classcombo.getSelectedItem().toString().equals("choose") )
{
JOptionPane.showMessageDialog(null,"Fill class","report",JOptionPane.PLAIN_MESSAGE);
}
      else {
      if(sectioncombo.getSelectedItem().toString().equals("choose"))
{
JOptionPane.showMessageDialog(null," Fill section","report",JOptionPane.PLAIN_MESSAGE);
}
      else  {
      if(rollno.getText().isEmpty())
{
JOptionPane.showMessageDialog(null," Fill Roll Number","report",JOptionPane.PLAIN_MESSAGE);
}
else
{

       //  con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
try
{
    ps=con.prepareStatement("select * from studententry where id=?");
    ps.setString(1,studentadmissionno.getText());
     rs=ps.executeQuery();
    System.out.println("case1");
    if(rs.next())
    {
        JOptionPane.showMessageDialog(null,"Press Update Button for update","report",JOptionPane.PLAIN_MESSAGE);
    }else
    {
        System.out.println("case 2");

        ps=con.prepareStatement("select * from sectionsetuplist where sectiontitle=?");
            ps.setString(1,sectioncombo.getSelectedItem().toString());
            rs=ps.executeQuery();
            rs.next();
            int sectionindex=rs.getInt(2);

             ps=con.prepareStatement("select classid from classsetup where classtitle=?");
            ps.setString(1,classcombo.getSelectedItem().toString());
            rs=ps.executeQuery();
            rs.next();
            int classindex=rs.getInt(1);

    ps=con.prepareStatement("insert into studententry (name,fathername,mothername,phone,address,sex,dob,class,section,roll,doa,todaydate,id) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
    ps.setString(1,studentname.getText());
    ps.setString(2,fathername.getText());
    ps.setString(3,mothername.getText());
    ps.setString(4,phoneno.getText());
    ps.setString(5,studentpresentaddress.getText());
    ps.setString(6,selection);
    System.out.println(selection);
    //ps.setString(7,birthdate.toString());
    ps.setString(7,birthdate.getText());

   // ps.setString(8,classcombo.getSelectedItem().toString());
    ps.setInt(8,classindex);
    if(sectioncombo.getSelectedItem()!=null)
    //ps.setString(9,sectioncombo.getSelectedItem().toString());
        ps.setInt(9,sectionindex);
    else ps.setString(9,"x");
    ps.setInt(10,Integer.parseInt(rollno.getText()));
    ps.setString(11,doa.getText());
    ps.setString(12,datum);
    ps.setString(13,studentadmissionno.getText().trim());//change for auto increment
             ps.executeUpdate();//for first fresh entry, there should be data in both the tables for same id studententry and studentdetail
         //since id of studententry is foreign key of studentdetail..so executeupdate() method requires sth to b executed in both the tables..
  //savePicture();
             printLargest();
      System.out.println("Done");
        JOptionPane.showMessageDialog(null,"data stored successfully","report",JOptionPane.PLAIN_MESSAGE);

         System.out.println("DataBase Conection Closed");
       
          getAdmissionNo();
        //  printLargest();
    }

}
catch(Exception e)
{
    e.printStackTrace();
   // System.out.println("gggg"+jComboBox2.getSelectedItem());
}
}  }}}} }
         public void getAdmissionNo()
         {
           
             try{

         ps = con.prepareStatement("select * from studententry where name=? and class=? and roll=?");
           ps.setString(1,studentname.getText());
            ps.setInt(2,Integer.parseInt(classmap1.get(classcombo.getSelectedItem()).toString()));
           ps.setInt(3,Integer.parseInt(rollno.getText()));

             rs = ps.executeQuery();



            while (rs.next())
        studentadmissionno.setText(rs.getString("id"));
            // con.close();
            System.out.println("DataBase Conection Closeddddddddddddd");
savePicture();

    }
    catch(Exception e)
    {
        System.err.println("Error is"+e);
    }

         }
public void loadStudentDetail()
{
    //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
String category2=null;
        try{
         ps = con.prepareStatement("select * from studentdetail where id=?");
         ps.setString(1,studentadmissionno.getText());

             rs = ps.executeQuery();

//Boolean flag=rs.next();
if(rs.next())
{
                     documentDetailArea.setText(rs.getString(2));
                     //jComboBox3.setText(rs.getString(3));
                     String channel=rs.getString(3);
                     String lastschool=rs.getString(4);
                     String lastgrade=rs.getString(5);
                     String religion=religionn.get(rs.getString(6)).toString();

                     System.out.println("sdsssssssssssssssssssssdddddjjjhhhhhhhhhhh");
                     if(!rs.getString(7).equals("General"))
                     category2=category.get(rs.getString(7)).toString();
else category2="General";
                     System.out.println("sdsssssssssssssssssssssdddddjjj");
                    
                     String bg=rs.getString(8);
                     String schoolhouse=rs.getString(9);
                     String medium=rs.getString(10);
                     String disability=rs.getString(11);
                     String email1=rs.getString(13);
                     String behaviour1=rs.getString(14);
                     String interest1=rs.getString(15);

                      String subcategory=categorysubmap.get(rs.getInt(16)).toString();

                      System.out.println("sdsssssssssssssssssssssdddddjjjkkkkkkkkk");
                     String ac=rs.getString(17);
                     String bank=rs.getString(18);
                     String branch=rs.getString(19);
                     String area=rs.getString(20);
                     int count,ind=0;
                     count=admissionChannelCombo.getItemCount();

                     System.out.println("count="+count);
                    for(int i=0;i<=count-1;i++)
                    {
                        if(admissionChannelCombo.getItemAt(i).equals(channel))
                             ind = i;
                    }
                     admissionChannelCombo.setSelectedIndex(ind);
                     lastSchool.setText(lastschool);
                     lastPercentage.setText(lastgrade);
email.setText(email1);
behaviourcombo.setSelectedItem(behaviour1);
interestcombo.setSelectedItem(interest1);

jTextField1.setText(ac);
jTextField2.setText(bank);
jTextField3.setText(branch);
                      count=religionCombo.getItemCount();

                     System.out.println("count="+count);
                    for(int i=0;i<=count-1;i++)
                    {
                        if(religionCombo.getItemAt(i).equals(religion))
                             ind = i;
                        System.out.println("dsssssssssssssssssssssssssssssssssssssssssssssss");
                    }

                     System.out.println("dsssssssssssssssssssssssssssssssssssssssssssssss1111");

                     religionCombo.setSelectedIndex(ind);
                      count=categoryCombo.getItemCount();

                     System.out.println("count="+count);
                    for(int i=0;i<=count-1;i++)
                    {
                        if(categoryCombo.getItemAt(i).equals(category2))
                             ind = i;
                    }
                     categoryCombo.setSelectedIndex(ind);
                      count=bloodGroupCombo.getItemCount();

                     System.out.println("count="+count);
                    for(int i=0;i<=count-1;i++)
                    {
                        if(bloodGroupCombo.getItemAt(i).equals(bg))
                             ind = i;
                    }
                     bloodGroupCombo.setSelectedIndex(ind);
                      count=houseCombo.getItemCount();

                     System.out.println("count="+count);
                    for(int i=0;i<=count-1;i++)
                    {
                        if(houseCombo.getItemAt(i).equals(schoolhouse))
                             ind = i;
                    }
                     houseCombo.setSelectedIndex(ind);

                     count=instructionCombo.getItemCount();

                     System.out.println("count="+count);
                    for(int i=0;i<=count-1;i++)
                    {
                        if(instructionCombo.getItemAt(i).equals(medium))
                             ind = i;
                    }
                     instructionCombo.setSelectedIndex(ind);
                     count=disabilityCombo.getItemCount();

                     System.out.println("count="+count);
                    for(int i=0;i<=count-1;i++)
                    {
                        if(disabilityCombo.getItemAt(i).equals(disability))
                             ind = i;
                    }
                     disabilityCombo.setSelectedIndex(ind);
count=categoryCombo1.getItemCount();
System.out.println("countszx="+count);
                     for(int i=0;i<=count-1;i++)
                    {
                        if(categoryCombo1.getItemAt(i).equals(subcategory))
                             ind = i;
                    }
categoryCombo1.setSelectedIndex(ind);
count=disabilityCombo1.getItemCount();
        System.out.println("countggg="+count);
                     for(int i=0;i<=count-1;i++)
                    {
                        if(disabilityCombo1.getItemAt(i).equals(area))
                             ind = i;
                    }
disabilityCombo1.setSelectedIndex(ind);

//disabilityCombo1.setSelectedItem(area);
                    // con.close();
                     //JOptionPane.showMessageDialog(null,"More Information also loaded successfully","report",JOptionPane.PLAIN_MESSAGE);
                    loadmsg.setText("More Info. also loaded");
                     System.out.println("DataBase Connection Closed");
}
else
 //JOptionPane.showMessageDialog(null," No More Information","report",JOptionPane.PLAIN_MESSAGE);
     loadmsg.setText(" No More Information");
        }
    catch(Exception e)
    {
        e.printStackTrace();
    }

}

    public void loadStudent()
    {
       // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
String selection=null;
        try{
         ps = con.prepareStatement("select * from studententry where id=?");
         ps.setString(1,studentadmissionno.getText());

             rs = ps.executeQuery();

if(rs.next())
{
    //admissionno.setText("");
    admissionno.setText(studentadmissionno.getText());
    if(rs.getString(12)!=null)
    {
     //doa.setText("");
      doa.setText(rs.getString(12));
    }
    if(rs.getString(8)!=null)
    {
      // birthdate.setText("");
       birthdate.setText(rs.getString(8));
    }
    if(rs.getString(7)!=null)
    {
     selection=rs.getString(7);
    }
            System.out.println("test cate3");
            if(rs.getString(2)!=null)
    {
// studentname.setText("");
           studentname.setText(rs.getString(2));
            }
            if(rs.getString(3)!=null)
    {
           // fathername.setText("");
                     fathername.setText(rs.getString(3).trim());
            }
            if(rs.getString(3)!=null)
    {
                    // fathername1.setText("");
                     fathername1.setText(rs.getString(3).trim());
            }
            if(rs.getString(4)!=null)
    {
           // mothername.setText("");
                     mothername.setText(rs.getString(4).trim());
            }
            if(rs.getString(4)!=null)
    {
                    // mothername1.setText("");
                      mothername1.setText(rs.getString(4).trim());
            }

            if(rs.getString(5)!=null)
    {
           // phoneno.setText("");
                    phoneno.setText(rs.getString(5));
            }
            if(rs.getString(6)!=null)
    {
                     //studentpresentaddress.setText("");
                     studentpresentaddress.setText(rs.getString(6).trim());
            }
            if(rs.getString(11)!=null)
    {
                     // rollno.setText("");
                     rollno.setText(rs.getString(11).trim());
            }
                      // studentadmissionno.setText("");
                     studentadmissionno.setText(rs.getString(1));
int classroomid=rs.getInt(9);
                      int sectionid=rs.getInt(10);

                      classcombo.setSelectedItem(classmap.get(classroomid));
                       sectioncombo.setSelectedItem(sectionmap.get(sectionid));
                 

                   if(selection.equals("M"))
                         malebutton.setSelected(true);
                     if(selection.equals("F"))
                             femalebutton.setSelected(true);

loadmsg.setText("Data Loaded successfully");
            System.out.println("DataBase Connection Closed");
}
else reset();
    }
    catch(Exception e)
    {
       // System.err.println("Error is"+e);
        e.printStackTrace();
    }
    }


     public void loadStudentParentage()
    {
       // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

        try{
         ps = con.prepareStatement("select * from studentfamily where studentid=?");
         ps.setString(1,studentadmissionno.getText());

             rs = ps.executeQuery();

if(rs.next())
{
    //admissionno.setText(studentadmissionno.getText());
    occupation1.setText(rs.getString(4));
    designation1.setText(rs.getString(5));
     officeaddress1.setText(rs.getString(6));
        phone1.setText(rs.getString(7));
        wed1.setText(rs.getString(8));
     qualification1.setText(rs.getString(3));
       birth1.setText(rs.getString(2));



       qualification2.setText(rs.getString(10));
    occupation2.setText(rs.getString(11));
    designation2.setText(rs.getString(12));
     officeaddress2.setText(rs.getString(13));
        phone2.setText(rs.getString(14));

       birth2.setText(rs.getString(9));







loadmsg.setText("Data Loaded successfully");
            System.out.println("DataBase Connection Closed");
}
else resetParentage();
    }
    catch(Exception e)
    {
       // System.err.println("Error is"+e);
        e.printStackTrace();
    }
    }

      public void loadStudentSibling()
    {
          String selection,selection1;
                  int selection2;
        //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

        try{
         ps = con.prepareStatement("select * from studentfamily where studentid=?");
         ps.setString(1,studentadmissionno.getText());

             rs = ps.executeQuery();

if(rs.next())
{
    selection=rs.getString(22);
      selection1=rs.getString(23);
      selection2=rs.getInt(27);

   // admissionno.setText(studentadmissionno.getText());
    siblingname1.setText(rs.getString(15));
    siblingname2.setText(rs.getString(16));
    squalification1.setText(rs.getString(21));
     squalification5.setText(rs.getString(22));
      sschool1.setText(rs.getString(19));
     sschool2.setText(rs.getString(20));
    soccupation1.setText(rs.getString(32));
    soccupation2.setText(rs.getString(33));

     sofficeaddress1.setText(rs.getString(34));
      sofficeaddress2.setText(rs.getString(35));

      stel1.setText(rs.getString(36));
      stel2.setText(rs.getString(37));
        sdob1.setText(rs.getString(17));
        sdob2.setText(rs.getString(18));
        sibling1studentid.setText(rs.getString(30));
        sibling2studentid.setText(rs.getString(31));

        if(selection.equals("F"))
            jRadioButton4.setSelected(true);
        else
            jRadioButton3.setSelected(true);

         if(selection1.equals("F"))
            jRadioButton6.setSelected(true);
        else
            jRadioButton5.setSelected(true);

        if(selection2==1)
            jRadioButton1.setSelected(true);
        else
            jRadioButton2.setSelected(true);








loadmsg.setText("Data Loaded successfully");
            System.out.println("DataBase Connection Closed");
}
else resetSibling();
    }
    catch(Exception e)
    {
       // System.err.println("Error is"+e);
        e.printStackTrace();
    }
    }

      public void reset()
{
   // k=0;
     jXImagePanel1.setImage(null);
    studentname.setText("");
    fathername.setText("");
    mothername.setText("");
   phoneno.setText("");
    studentpresentaddress.setText("");
    if(malebutton.isSelected())
    malebutton.setSelected(false);
    if(femalebutton.isSelected())
    femalebutton.setSelected(false);
    studentadmissionno.setText("");
   
    rollno.setText("");

     documentDetailArea.setText("");
    browsepicturepath.setText("");
    lastSchool.setText("");
  


}
public void resetSibling()
{
   // k=0;
     jXImagePanel6.setImage(null);
      jXImagePanel5.setImage(null);
  siblingname1.setText("");
    siblingname2.setText("");
    squalification1.setText("");
     squalification5.setText("");
      sschool1.setText("");
     sschool2.setText("");
    soccupation1.setText("");
    soccupation2.setText("");

     sofficeaddress1.setText("");
      sofficeaddress2.setText("");

      stel1.setText("");
      stel2.setText("");
        sdob1.setText("");
        sdob2.setText("");
        sibling1studentid.setText("");
        sibling2studentid.setText("");
    // documentDetailArea.setText("");
    browsepicturepath5.setText("");
     browsepicturepath4.setText("");



}

public void resetParentage()
{
   // k=0;
     jXImagePanel4.setImage(null);
      jXImagePanel3.setImage(null);
  occupation1.setText("");
    designation1.setText("");
     officeaddress1.setText("");
        phone1.setText("");
        wed1.setText("");
     qualification1.setText("");
       birth1.setText("");



       qualification2.setText("");
    occupation2.setText("");
    designation2.setText("");
     officeaddress2.setText("");
        phone2.setText("");

       birth2.setText("");
    browsepicturepath3.setText("");
     browsepicturepath2.setText("");



}


public void loadRollNo()
{
    int i=0,j=0;
      // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

       {
   try
   {
        System.out.println("FDF");
       ps=con.prepareStatement("select * from studententry where class=?");
       ps.setInt(1,Integer.parseInt(classmap1.get(classcombo.getSelectedItem().toString()).toString()));

       rs=ps.executeQuery();
      // System.out.println("rd1");
        while(rs.next())
            {
                j++;
              //  System.out.println("rd2");
            }
            rs.first();
            rs.previous();
            dm1.setRowCount(j);
            while(rs.next())
            {


                dm1.setValueAt(rs.getString(1), i, 1);
                dm1.setValueAt(rs.getInt(11), i, 0);
                jXTable2.removeAll();

              //  System.out.println("rd3");


                i++;
            }


   }catch(Exception e)
   {
e.printStackTrace();
   }
        }
}
 public void loadStudentOnClassBasis()
 {
      int i=0,j=0;
    // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
     System.out.println("class");
     try
     {
       ps=con.prepareStatement("select * from studententry where class=?") ;
      ps.setInt(1,Integer.parseInt(classmap1.get(classcombo.getSelectedItem()).toString()));
         //ps.setInt(2,id);
      System.out.println("class");
       rs=ps.executeQuery();
      System.out.println("class");
        while(rs.next())
            {
                j++;

            }
            rs.first();
            rs.previous();
            dm.setRowCount(j);
            while(rs.next())
            {


                dm.setValueAt(rs.getString(1), i, 0);
                dm.setValueAt(rs.getString(2), i, 1);
                jXTable1.removeAll();

              //  System.out.println("rd3");


                i++;
            }


   }catch(Exception e)
   {
e.printStackTrace();
   }

 }

    public void sectionFilter()
{
    // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        try
        {
            ps = con.prepareStatement("select * from sectionsetup where classtitle=?");
            ps.setInt(1, Integer.parseInt(classmap1.get(classcombo.getSelectedItem().toString()).toString()));
             rs = ps.executeQuery();
            int i = 0,j=0;

sectioncombo.removeAllItems();

            while(rs.next())
            {

                sectioncombo.addItem(sectionmap.get(rs.getInt(2)));
              
            }



        }  catch(Exception e)
        {
            e.printStackTrace();
        }


}

    public void generateRollNoOnBasisofSection()
    {
        try
        {
             ps=con.prepareStatement("select max(roll) from studententry where class=? and section=?");
             ps.setInt(1,Integer.parseInt(classmap1.get(classcombo.getSelectedItem()).toString()));
        ps.setInt(2,Integer.parseInt(sectionmap1.get(sectioncombo.getSelectedItem()).toString()));

       rs=ps.executeQuery();
       if(rs.next())
       rollno.setText(String.valueOf(rs.getInt(1)+1));
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void readLargest()
    {
        try
    {

           /* Properties props=new Properties();
            FileInputStream in=new FileInputStream("adm.properties");
            props.load(in);
            in.close();
             admNo=Integer.parseInt(props.getProperty("adm.no"));*/

            ps=con.prepareStatement("select * from autoassignclass left join appendstring on seriesid=id where classid=?");
             ps.setInt(1,Integer.parseInt(classmap1.get(classcombo.getSelectedItem()).toString()));
             rs=ps.executeQuery();
             if(rs.next())
                 admNo=rs.getInt(6);
            // if(admNo==0)
               //  admNo++;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
public void printLargest()
{
    int serid=0;
    try
       {
        /*
           FileWriter f1=new FileWriter("adm.properties");
           f1.write("adm.no="+admNo);

           //f1.write("ravi2");
           f1.close();*/
        System.out.println("tavififififf"+con);
         ps=con.prepareStatement("select * from autoassignclass left join appendstring on seriesid=id where classid=?");
             ps.setInt(1,Integer.parseInt(classmap1.get(classcombo.getSelectedItem()).toString()));
      rs=ps.executeQuery();
      if(rs.next())
      {
       serid=rs.getInt(2);
 System.out.println("ggggggggggggggggggggggggggggggg"+classmap1.get(classcombo.getSelectedItem()).toString());
     // System.out.println("ggggggggggggggggggggggggggggggg"+rs.getString(2));
System.out.println("fffffffffffffffffffffffffffffffhhhhhhhhhhllllllllllll"+serid);
     ps=con.prepareStatement("update appendstring set admno=? where id=?");
        ps.setInt(1, admNo);
        ps.setInt(2, serid);
        ps.executeUpdate();
System.out.println("fffffffffffffffffffffffffffffffhhhhhhhhhh");
    }
    }
       catch(Exception e)
    {
           System.out.println("fffffffffffffffffffffffffffffffhhhhhhhhhhkkkkkkkkkkkkkkkkk");
e.printStackTrace();
    }
}
    public void generateAdmissionNoOnBasisofClass()
    {
        int i=0;
        String pre=null,post=null;
        //String newpre=null,newpost=null,integerOfString = null;
        //int largest=0,largest1=0;
        try
        {
           // printLargest();
            ps=con.prepareStatement("select * from autoassignclass left join appendstring on seriesid=id where classid=?");
             ps.setInt(1,Integer.parseInt(classmap1.get(classcombo.getSelectedItem()).toString()));
      rs=ps.executeQuery();
       if(rs.next())
       {
           pre=rs.getString(4);
           System.out.println("tttt"+pre);
           post=rs.getString(5);
       

         readLargest();
         admNo++;
          studentadmissionno.setText((pre+String.valueOf(admNo)+post).trim());
        // printLargest();
      }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

     public void loadRollNoOnBasisOfSection()
    {
  int i=0,j=0;
       {
   try
   {
        System.out.println("FDF");
       ps=con.prepareStatement("select id,roll from studententry where class=? and section=?");
       ps.setInt(1,Integer.parseInt(classmap1.get(classcombo.getSelectedItem()).toString()));
        ps.setInt(2,Integer.parseInt(sectionmap1.get(sectioncombo.getSelectedItem()).toString()));

       rs=ps.executeQuery();
     
        while(rs.next())
            {
                j++;
             
            }
            rs.first();
            rs.previous();
            dm1.setRowCount(j);
            while(rs.next())
            {


                dm1.setValueAt(rs.getString(1), i, 1);
                dm1.setValueAt(rs.getInt(2), i, 0);
                jXTable2.removeAll();

                i++;
            }

     }catch(Exception e)
   {
e.printStackTrace();
   }
        }
}


    public void saveParentage()
    {
        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
try
{
     ps=con.prepareStatement("insert into studentfamily (fdob,fqualification,foccupation,fdesignation,fofficeaddress,fphone,weddinganniversary,mdob,mqualification,moccupation,mdesignation,mofficeaddress,mphone,studentid) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    ps.setString(1,birth1.getText());
    ps.setString(2,qualification1.getText());
    ps.setString(3,occupation1.getText());
    ps.setString(4,designation1.getText());
    ps.setString(5,officeaddress1.getText());
    ps.setString(6,phone1.getText());
   ps.setString(7,wed1.getText());
     ps.setString(8,birth2.getText());
    ps.setString(9,qualification2.getText());
    ps.setString(10,occupation2.getText());
    ps.setString(11,designation2.getText());
    ps.setString(12,officeaddress2.getText());
    ps.setString(13,phone2.getText());
    ps.setString(14,studentadmissionno.getText());

             ps.executeUpdate();
              System.out.println("Done");
        JOptionPane.showMessageDialog(null,"data stored successfully","report",JOptionPane.PLAIN_MESSAGE);

//con.close();
         System.out.println("DataBase Conection Closed");
         saveParentagePicture();

}catch(Exception e)
{
    e.printStackTrace();
}
    }

     public void saveSibling()
    {
         String selection,selection1;
         int familytype=0;
        if (jRadioButton3.isSelected())
            selection="M";
        else selection="F";

          if (jRadioButton4.isSelected())
            selection1="M";
        else selection1="F";

         if(jRadioButton1.isSelected())
             familytype=1;

        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
try
{

     ps=con.prepareStatement("update studentfamily set sibling1name=?,sibling1class=?,sibling1school=?,sibling1occupation=?,sibling1offaddress=?,sibling1phone=?,sibling1dob=?,sibling1gender=?,sibling1studentid=?,sibling2name=?,sibling2class=?,sibling2school=?,sibling2occupation=?,sibling2offaddress=?,sibling2phone=?,sibling2dob=?,sibling2gender=?,sibling2studentid=?,familytype=? where studentid=?");
    ps.setString(1,siblingname1.getText());
    ps.setString(2,squalification1.getText());
    ps.setString(3,sschool1.getText());
     ps.setString(4,soccupation1.getText());
    ps.setString(5,sofficeaddress1.getText());
    ps.setString(6,stel1.getText());
    ps.setString(7,sdob1.getText());
    ps.setString(8,selection);
    ps.setString(9,sibling1studentid.getText());
  ps.setString(10,siblingname1.getText());
    ps.setString(11,squalification5.getText());
    ps.setString(12,sschool2.getText());
     ps.setString(13,soccupation2.getText());
    ps.setString(14,sofficeaddress2.getText());
    ps.setString(15,stel2.getText());
    ps.setString(16,sdob2.getText());
    ps.setString(17,selection1);
    ps.setString(18,sibling2studentid.getText());
    ps.setInt(19,familytype);

    ps.setString(20,studentadmissionno.getText());

             ps.executeUpdate();
              System.out.println("Done");
        JOptionPane.showMessageDialog(null,"data stored successfully","report",JOptionPane.PLAIN_MESSAGE);

//con.close();
         System.out.println("DataBase Conection Closed");
     //    saveParentagePicture();

}catch(Exception e)
{
    e.printStackTrace();
}
    }


     public void updateSiblingPicture()
    {

     //  con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

        try
        {

            ps=con.prepareStatement("select * from studentfamily where studentid=?");
            ps.setString(1,studentadmissionno.getText());
            rs=ps.executeQuery();
            if(rs.next())
            {

            ps=con.prepareStatement("update studentfamily set sibling1picture=?,sibling2picture=? where studentid=?");
/*   FileInputStream fin = new FileInputStream(filepath);
        ps.setBinaryStream(1, fin,fin.available());
         FileInputStream fin1 = new FileInputStream(filepath1);
        ps.setBinaryStream(2, fin1,fin1.available());*/
            if(filepath.equals("r"))
          {
              ps.setString(1, null);
              filename=null;
          }
          else
          {
               //  FileInputStream fin1 = new FileInputStream(filepath2);
               System.out.println(filepath);
            ps.setString(1, filename);
            filepath="r";
        //   filename=null;
          }

            if(filepath1.equals("r"))
          {
              ps.setString(2, null);
              filename1=null;
          }
          else
          {
               //  FileInputStream fin1 = new FileInputStream(filepath2);
               System.out.println(filepath1);
            ps.setString(2, filename1);
            filepath1="r";
          // filename1=null;
          }


         ps.setString(3,studentadmissionno.getText());
        ps.executeUpdate();
        System.out.println("picture updated");


        }
            else
            {

                ps=con.prepareStatement("insert into studentfamily (sibling1picture,sibling2picture) values(?,?) where studentid=?");
  // FileInputStream fin = new FileInputStream(filepath);
              ps.setString(1,filepath);
        ps.setString(2, filepath1);
        ps.setString(3,studentadmissionno.getText());
        // ps.setInt(3,Integer.parseInt(jTextField10.getText()));

        ps.executeUpdate();
        System.out.println("picture saved");
            }
        }
            catch(Exception e)
        {


      e.printStackTrace();

        }


    }
     public void fromTransportRouteStopSetup()
   {
      // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
        ps=con.prepareStatement("select * from transportroutestopsetup");

      rs = ps.executeQuery();
           while (rs.next())
        stopname.addItem(rs.getString(2));
}
    catch(SQLException e)
    {
        e.printStackTrace();
    }
   }

    public void  fromTransportRouteBusSetup()
   {
      // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
        ps=con.prepareStatement("select * from transportroutebussetup");

      rs = ps.executeQuery();
           while (rs.next())
        busno.addItem(rs.getString(2));
}
    catch(SQLException e)
    {
        e.printStackTrace();
    }
   }

 public void addSubject()
{
    // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
try
{


    ps=con.prepareStatement("select * from transportboarders where studentid=?");
    ps.setString(1, admissionno.getText());
    rs=ps.executeQuery();
    if(!rs.next())
    {

    ps=con.prepareStatement("insert into transportboarders values(?,?,?,?,?,?)");
    ps.setString(1,admissionno.getText());
    ps.setString(2,stopname.getSelectedItem().toString());
 ps.setString(3,routeno.getText());
    ps.setString(4,busno.getSelectedItem().toString());
 //ps.setString(5,strengthtext.getText());
ps.setString(5,picktext.getText());
ps.setString(6,datum);
         ps.executeUpdate();


        System.out.println("Done");
        //JOptionPane.showMessageDialog(null,"data stored successfully","report",JOptionPane.PLAIN_MESSAGE);
    }
    //else
        //JOptionPane.showMessageDialog(null,"Transport set, Press Update for Change","report",JOptionPane.PLAIN_MESSAGE);

//con.close();
         System.out.println("DataBase Conection Closed");
        // oldSubject();
              return;
        }


catch(Exception e)
{
    e.printStackTrace();
    System.out.println("here");
}
    }

    public void updateAuthority()
    {
        int studentclass=0;
        int ledcode=0;
      //   con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
       try
       {
           ps = con.prepareStatement("update transportboarders set stop=?,routeno=?,busno=?,pickpoint=?,date=? where studentid=?");
    ps.setString(1,stopname.getSelectedItem().toString());
 ps.setString(2,routeno.getText());
    ps.setString(3,busno.getSelectedItem().toString());
 //ps.setString(5,strengthtext.getText());
ps.setString(4,picktext.getText());
ps.setString(5,datum);
ps.setString(6,admissionno.getText());
           ps.executeUpdate();

          
            ps=con.prepareStatement("select class from studententry where id=?");
             ps.setString(1,admissionno.getText());
             rs=ps.executeQuery();
             if(rs.next())
                 studentclass=rs.getInt(1);

             ps=con.prepareStatement("select ledgercode from monthlyfeeamounthead where head=? and class=?");
             ps.setInt(1,Integer.parseInt(monthlyfeemap1.get("Transport Fee").toString()));
             ps.setInt(2,studentclass);
             rs=ps.executeQuery();
             if(rs.next())
                 ledcode=rs.getInt(1);

            ps=con.prepareStatement("update feecustomization set amount=?,ledgercode=?,customizationdate=? where studentid=? and head=? and feeheadtype=0");

    //ps.setString(2,"Transport Fee");
    ps.setDouble(1,Double.parseDouble(transportfee.getText()));
   // ps.setString(2,studentclass);
    ps.setInt(2, ledcode);
     ps.setString(3,datum);
    ps.setString(4,admissionno.getText());
    ps.setInt(5,Integer.parseInt(monthlyfeemap1.get("Transport Fee").toString()));

    ps.executeUpdate();
           JOptionPane.showMessageDialog(null,"Student transport Updated successfully","report",JOptionPane.PLAIN_MESSAGE);
       }catch(Exception e)
       {
           e.printStackTrace();
       }
    }





    public void removeSubject()
    {
       // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

        try
        {
         ps=con.prepareStatement("delete from transportboarders where studentid=?");

ps.setString(1,admissionno.getText());
         ps.executeUpdate();

          ps=con.prepareStatement("delete from feecustomization where studentid=? and head=? and feeheadtype=0");

ps.setString(1,admissionno.getText());
ps.setInt(2,Integer.parseInt(monthlyfeemap1.get("Transport Fee").toString()));
   ps.executeUpdate();
         JOptionPane.showMessageDialog(null,"Student Transport Fee removed","report",JOptionPane.PLAIN_MESSAGE);
         // con.close();
         System.out.println("DataBase Conection Closed");
    }
        catch(Exception e)
        {
            System.err.println("Error"+e);
        }

    }

     public void loadAdmissionNoTable(String id)
 {
     int i=0,j=0;
     //  con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

       {
   try
   {
        System.out.println("FDF");
       ps=con.prepareStatement("select * from studententry where id like ? or id=?");
       ps.setString(1,id+"%");
         ps.setString(2,id);
       rs=ps.executeQuery();
      // System.out.println("rd1");
        while(rs.next())
            {
                j++;
              //  System.out.println("rd2");
            }
            rs.first();
            rs.previous();
            dm.setRowCount(j);
            while(rs.next())
            {


                dm.setValueAt(rs.getString(2), i, 0);
                dm.setValueAt(rs.getString(1), i, 1);
                jXTable2.removeAll();

              //  System.out.println("rd3");


                i++;
            }


   }catch(Exception e)
   {
e.printStackTrace();
   }
        }
}

     public void setStopName()
     {
        if(stopname.getSelectedIndex()==0)
          return;

     // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
       try
       {
           ps=con.prepareStatement("select * from transportroutestopsetup where stopname=?");
           ps.setString(1,stopname.getSelectedItem().toString());
           rs=ps.executeQuery();
           if(rs.next())
               routeno.setText(rs.getString(1));
           transportfee.setText(String.valueOf(rs.getDouble(3)));


            ps=con.prepareStatement("select busno from transportroutebussetup where routeno=?");
           ps.setString(1,rs.getString(1));
           rs=ps.executeQuery();

           busno.removeAllItems();

          //busno.addItem("choose");

          int i=0;
          while(rs.next())
           {

               busno.addItem(rs.getString(1));

           }
       }catch(Exception e)
       {
           e.printStackTrace();
       }

     }

     public void addTransportFeeIntofeecustomization()
     {
         int studentclass=0;
         int ledcode=0;
       //  con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
         try
         {
             //ps=con.prepareStatement("select * from");
              ps=con.prepareStatement("select * from feecustomization where studentid=? and head=? and feeheadtype=0");
    ps.setString(1, admissionno.getText());
    ps.setInt(2,Integer.parseInt(monthlyfeemap1.get("Transport Fee").toString()));
    rs=ps.executeQuery();
    if(!rs.next())
    {

             ps=con.prepareStatement("select class from studententry where id=?");
             ps.setString(1,admissionno.getText());
             rs=ps.executeQuery();
             if(rs.next())
                 studentclass=rs.getInt(1);

             ps=con.prepareStatement("select ledgercode from monthlyfeeamounthead where head=? and class=?");
             ps.setInt(1,Integer.parseInt(monthlyfeemap1.get("Transport Fee").toString()));
             ps.setInt(2,studentclass);
             rs=ps.executeQuery();
             if(rs.next())
                 ledcode=rs.getInt(1);

         ps=con.prepareStatement("insert into feecustomization values(?,?,?,?,?,?)");
   ps.setString(1,admissionno.getText());
    ps.setInt(2,Integer.parseInt(monthlyfeemap1.get("Transport Fee").toString()));
    ps.setDouble(3,Double.parseDouble(transportfee.getText()));
    //ps.setString(4,studentclass);
    ps.setInt(4, ledcode);
    ps.setInt(5,0);
     ps.setString(6,datum);
    ps.executeUpdate();

     JOptionPane.showMessageDialog(null,"Student Transport Set","report",JOptionPane.PLAIN_MESSAGE);
    }
    else
        JOptionPane.showMessageDialog(null,"Transport Already Set, Press Update for Change","report",JOptionPane.PLAIN_MESSAGE);
         }catch(Exception e)
     {
      e.printStackTrace();
     }
     }

      public void loadStudentTransportData()
    {
      int count=0;
       // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

        try{


         ps = con.prepareStatement("select * from transportboarders where studentid=?");
         ps.setString(1,admissionno.getText());

             rs = ps.executeQuery();

if(rs.next())
{
    picktext.setText(rs.getString(5).trim());

    stopname.setSelectedItem(rs.getString(2).trim());
        routeno.setText(rs.getString(3).trim());

        busno.setSelectedItem(rs.getString(4).trim());

          ps=con.prepareStatement("select * from transportboarders where busno=?");
           ps.setString(1,busno.getSelectedItem().toString());
           rs=ps.executeQuery();
           while(rs.next())
               count++;
           strengthtext.setText(String.valueOf(count));

}

       // con.close();
             JOptionPane.showMessageDialog(null,"data loaded successfully","report",JOptionPane.PLAIN_MESSAGE);

            System.out.println("DataBase Connection Closed");
}
        catch(Exception e)
        {
            e.printStackTrace();
        }
  }
         public void setAdmissionNo(String id)
{
    admissionno.setText(id);
}
/*
    /*public void browsePicture()
{
    chooser=new JFileChooser();
    chooser.setCurrentDirectory(new File("."));
    int select=chooser.showOpenDialog(null);
    if(select==JFileChooser.APPROVE_OPTION)
    {
         filepath = chooser.getSelectedFile().getAbsolutePath();
        try
        {
                imgpic = ImageIO.read(new File(filepath));
               jXImagePanel1.setImage(imgpic.getScaledInstance(156, 112, Image.SCALE_SMOOTH));
                browsepicturepath.setText(filepath);

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Invalid Image",
                "ImageIO Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error "+e);

        }

        //jLabel1.setIcon(new ImageIcon(path));
       // savePicture(filepath);
    }
}

 public void savePicture()
    {
      // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

       try
        {
           // ps=con.prepareStatement("")
            ps=con.prepareStatement("insert into studentpicture(admissionno,studentpic) values(?,?)");
            ps.setString(1,studentadmissionno.getText());
           // ps.setBlob(2,jLabel1.getIcon().);
              FileInputStream fin = new FileInputStream(filepath);
        ps.setBinaryStream(2, fin,fin.available());
        ps.executeUpdate();
        System.out.println("picture saved");


        }catch(Exception e)
        {
          //  e.printStackTrace();
           try
           {
               ps=con.prepareStatement("insert into studentpicture(admissionno) values(?)");
            ps.setString(1,studentadmissionno.getText());
             
            ps.executeUpdate();
            System.out.println("no picture saved");
        }catch(Exception e2)
        {
            e2.printStackTrace();
            System.out.println("in second cacth");
        }
 }}

public void updatePicture()
    {
     //  con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

        try
        {

            ps=con.prepareStatement("select * from studentpicture where admissionno=?");
            ps.setString(1,studentadmissionno.getText());
            rs=ps.executeQuery();
            if(rs.next())
            {

            ps=con.prepareStatement("update studentpicture set studentpic=? where admissionno=?");
   FileInputStream fin = new FileInputStream(filepath);
        ps.setBinaryStream(1, fin,fin.available());
         ps.setString(2,studentadmissionno.getText());
        ps.executeUpdate();
        System.out.println("picture updated");


        }
            else
            {

                ps=con.prepareStatement("insert into studentpicture values(?,?)");
   FileInputStream fin = new FileInputStream(filepath);
              ps.setString(1,studentadmissionno.getText());
        ps.setBinaryStream(2, fin,fin.available());
        // ps.setInt(3,Integer.parseInt(jTextField10.getText()));

        ps.executeUpdate();
        System.out.println("picture saved");
            }
        }
            catch(Exception e)
        {


      e.printStackTrace();

        }
        }

*/
         //----ravi

          public void browsePicture()
{
    chooser=new JFileChooser();
    chooser.setCurrentDirectory(new File("./pics/students"));
    int select=chooser.showOpenDialog(null);
    if(select==JFileChooser.APPROVE_OPTION)
    {
      /*   filepath = chooser.getSelectedFile().getAbsolutePath();
        try
        {
                imgpic = ImageIO.read(new File(filepath));
               jXImagePanel1.setImage(imgpic.getScaledInstance(156, 112, Image.SCALE_SMOOTH));
                browsepicturepath.setText(filepath);

        }*/
        filepath = chooser.getSelectedFile().getAbsolutePath();
         filename="pics/students/"+chooser.getSelectedFile().getName();
        try

        {
            //File f= new File(filepath2).

               imgpic = ImageIO.read(new File(filepath));
              jXImagePanel1.setImage(imgpic.getScaledInstance(156, 112, Image.SCALE_SMOOTH));
                browsepicturepath.setText(chooser.getSelectedFile().getName());

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Invalid Image",
                "ImageIO Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error "+e);

        }

        //jLabel1.setIcon(new ImageIcon(path));
       // savePicture(filepath);
    }
}

     public void browsePictureFather()
{
    chooser=new JFileChooser();
    chooser.setCurrentDirectory(new File("./pics/family"));
    int select=chooser.showOpenDialog(null);
    if(select==JFileChooser.APPROVE_OPTION)
    {
            filepath = chooser.getSelectedFile().getAbsolutePath();
         filename="pics/family/"+chooser.getSelectedFile().getName();
        try

        {
            //File f= new File(filepath2).

               imgpic = ImageIO.read(new File(filepath));
              jXImagePanel4.setImage(imgpic.getScaledInstance(156, 112, Image.SCALE_SMOOTH));
                browsepicturepath3.setText(chooser.getSelectedFile().getName());

        }

        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Invalid Image",
                "ImageIO Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error "+e);

        }


    }
}


     public void browsePictureMother()
{
    chooser1=new JFileChooser();
    chooser1.setCurrentDirectory(new File("./pics/family"));
    int select=chooser1.showOpenDialog(null);
    if(select==JFileChooser.APPROVE_OPTION)
    {
         filepath1 = chooser1.getSelectedFile().getAbsolutePath();
         filename1="pics/family/"+chooser1.getSelectedFile().getName();
        try

        {
            //File f= new File(filepath2).

               imgpic1 = ImageIO.read(new File(filepath1));
              jXImagePanel3.setImage(imgpic1.getScaledInstance(156, 112, Image.SCALE_SMOOTH));
                browsepicturepath2.setText(chooser1.getSelectedFile().getName());

        }

        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Invalid Image",
                "ImageIO Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error "+e);

        }


    }
}

       public void browsePictureSibling1()
{
    chooser=new JFileChooser();
    chooser.setCurrentDirectory(new File("./pics/family"));
    int select=chooser.showOpenDialog(null);
    if(select==JFileChooser.APPROVE_OPTION)
    {
         filepath = chooser.getSelectedFile().getAbsolutePath();
         filename="pics/family/"+chooser.getSelectedFile().getName();
        try

        {
            //File f= new File(filepath2).

               imgpic = ImageIO.read(new File(filepath));
              jXImagePanel6.setImage(imgpic.getScaledInstance(156, 112, Image.SCALE_SMOOTH));
                browsepicturepath5.setText(chooser.getSelectedFile().getName());

        }

        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Invalid Image",
                "ImageIO Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error "+e);

        }


    }
}


     public void browsePictureSibling2()
{
    chooser1=new JFileChooser();
    chooser1.setCurrentDirectory(new File("./pics/family"));
    int select=chooser1.showOpenDialog(null);
    if(select==JFileChooser.APPROVE_OPTION)
    {
         filepath1 = chooser1.getSelectedFile().getAbsolutePath();
         filename1="pics/family/"+chooser1.getSelectedFile().getName();
        try

        {
            //File f= new File(filepath2).

               imgpic1 = ImageIO.read(new File(filepath1));
              jXImagePanel5.setImage(imgpic1.getScaledInstance(156, 112, Image.SCALE_SMOOTH));
                browsepicturepath4.setText(chooser1.getSelectedFile().getName());

        }

        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Invalid Image",
                "ImageIO Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error "+e);

        }

    }
}
 public void savePicture()
    {
      // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

       try
        {
           // ps=con.prepareStatement("")
            ps=con.prepareStatement("insert into studentpicture(admissionno,studentpic) values(?,?)");
            ps.setString(1,studentadmissionno.getText());
           // ps.setBlob(2,jLabel1.getIcon().);
           /*   FileInputStream fin = new FileInputStream(filepath);
        ps.setBinaryStream(2, fin,fin.available());
        ps.executeUpdate();
        System.out.println("picture saved");*/
             if(filepath.equals("r"))
          {
              ps.setString(2, null);
              filename=null;
          }
          else
          {
               //  FileInputStream fin1 = new FileInputStream(filepath2);
               System.out.println(filepath);
            ps.setString(2, filename);
            filepath="r";
            filename=null;
          }


ps.executeUpdate();
        }catch(Exception e)
        {
          e.printStackTrace();
        /*   try
           {
               ps=con.prepareStatement("insert into studentpicture(admissionno) values(?)");
            ps.setString(1,studentadmissionno.getText());

            ps.executeUpdate();
            System.out.println("no picture saved");
        }catch(Exception e2)
        {
            e2.printStackTrace();
            System.out.println("in second cacth");
        }*/
 }}

public void updatePicture()
    {
     //  con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

        try
        {

            ps=con.prepareStatement("select * from studentpicture where admissionno=?");
            ps.setString(1,studentadmissionno.getText());
            rs=ps.executeQuery();
            if(rs.next())
            {

            ps=con.prepareStatement("update studentpicture set studentpic=? where admissionno=?");
//   FileInputStream fin = new FileInputStream(filepath);
  //      ps.setBinaryStream(1, fin,fin.available());
            ps.setString(1,filename);
         ps.setString(2,studentadmissionno.getText());
        ps.executeUpdate();
        System.out.println("picture updated");
filename=null;

        }
            else
            {

                ps=con.prepareStatement("insert into studentpicture values(?,?)");
   //FileInputStream fin = new FileInputStream(filepath);
              ps.setString(1,studentadmissionno.getText());
      //  ps.setBinaryStream(2, fin,fin.available());
               ps.setString(2,filename);
        // ps.setInt(3,Integer.parseInt(jTextField10.getText()));

        ps.executeUpdate();
        System.out.println("picture saved");
            }
        }
            catch(Exception e)
        {


      e.printStackTrace();

        }
        }


 public void saveParentagePicture()
    {

       try
        {
           // ps=con.prepareStatement("")
            ps=con.prepareStatement("update studentfamily set fpicture=?,mpicture=? where studentid=?");
  if(filepath.equals("r"))
          {
              ps.setString(1, null);
              filename=null;
          }
          else
          {
               //  FileInputStream fin1 = new FileInputStream(filepath2);
               System.out.println(filepath);
            ps.setString(1, filename);
            filepath="r";
           filename=null;
          }

            if(filepath1.equals("r"))
          {
              ps.setString(2, null);
              filename1=null;
          }
          else
          {
               //  FileInputStream fin1 = new FileInputStream(filepath2);
               System.out.println(filepath1);
            ps.setString(2, filename1);
            filepath1="r";
           filename1=null;
          }

            ps.setString(3,studentadmissionno.getText());
           // ps.setBlob(2,jLabel1.getIcon().);

        ps.executeUpdate();
        System.out.println("picture saved");


        }catch(Exception e)
        {
          //  e.printStackTrace();*/
           try
           {
               ps=con.prepareStatement("insert into studentfamily(studentid) values(?)");
            ps.setString(1,studentadmissionno.getText());

            ps.executeUpdate();
            System.out.println("no picture saved");
        }catch(Exception e2)
        {
            e2.printStackTrace();
            System.out.println("in second cacth");
        }
 }}

public void updateParentagePicture()
    {
       //con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

        try
        {

            ps=con.prepareStatement("select * from studentfamily where studentid=?");
            ps.setString(1,studentadmissionno.getText());
            rs=ps.executeQuery();
            if(rs.next())
            {

            ps=con.prepareStatement("update studentfamily set fpicture=?,mpicture=? where studentid=?");
   FileInputStream fin = new FileInputStream(filepath);
        ps.setBinaryStream(1, fin,fin.available());
         FileInputStream fin1 = new FileInputStream(filepath1);
        ps.setBinaryStream(2, fin1,fin1.available());

         ps.setString(3,studentadmissionno.getText());
        ps.executeUpdate();
        System.out.println("picture updated");


        }
            else
            {

                ps=con.prepareStatement("insert into studentfamily (fpicture,mpicture) values(?,?) where studentid=?");
   FileInputStream fin = new FileInputStream(filepath);
              ps.setString(1,studentadmissionno.getText());
        ps.setBinaryStream(2, fin,fin.available());
        ps.setString(3,studentadmissionno.getText());
        // ps.setInt(3,Integer.parseInt(jTextField10.getText()));

        ps.executeUpdate();
        System.out.println("picture saved");
            }
        }
            catch(Exception e)
        {


      e.printStackTrace();

        }
        }

public void loadPicture()
    {
        //con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


        try
        {
            ps=con.prepareStatement("select * from studentpicture where admissionno=?");
            ps.setString(1,studentadmissionno.getText());
            rs=ps.executeQuery();
            if(rs.next())
            {
           System.out.println("r1");
                if(rs.getString(2)==null)
                {
                     browsepicturepath.setText("");
                    jXImagePanel1.setImage(null);
                    filename=null;
                }
                else
                {
                 //imgpic =ImageIO.read(rs.getBinaryStream(2));
imgpic = ImageIO.read(new File(rs.getString(2)));
                System.out.println("r5");
browsepicturepath.setText(rs.getString(2).substring(14));
filename="pics/students/"+rs.getString(2).substring(14);
System.out.println("xzcxcxzc"+filename);
System.out.println("xzcxcxzc"+rs.getString(2));
                 jXImagePanel1.setImage(imgpic.getScaledInstance(156, 112, Image.SCALE_SMOOTH));

                }


            }
        }catch(Exception e)
        {
           e.printStackTrace();
            System.out.println("r55555555555555555555555");
browsepicturepath.setText("");
        }
    }

public void loadDocs1()
    {

        try
        {
            ps=con.prepareStatement("select * from studentdocs where id=?");
            ps.setString(1,studentadmissionno.getText());
            rs=ps.executeQuery();
           System.out.println("r1");
           if(rs.next())
            {
                if(rs.getString(2)==null)
                {
                     browsepicturepath1.setText("");
                    jXImagePanel2.setImage(null);
                    filename2=null;
                }
                else
                {
                 //imgpic =ImageIO.read(rs.getBinaryStream(2));
imgpic = ImageIO.read(new File(rs.getString(2)));
                System.out.println("r5");
browsepicturepath1.setText(rs.getString(2).substring(5));
filename2="pics/"+rs.getString(2).substring(5);
                 jXImagePanel2.setImage(imgpic.getScaledInstance(156, 112, Image.SCALE_SMOOTH));

                }

                 if(rs.getString(3)==null)
                 {
                      browsepicturepath6.setText("");
                     jXImagePanel8.setImage(null);
                     filename3=null;
                 }
                else
                {
                 //imgpic =ImageIO.read(rs.getBinaryStream(3));
imgpic = ImageIO.read(new File(rs.getString(3)));
                System.out.println("r5");
browsepicturepath6.setText(rs.getString(3).substring(5));
filename3="pics/"+rs.getString(3).substring(5);

                 jXImagePanel8.setImage(imgpic.getScaledInstance(156, 112, Image.SCALE_SMOOTH));

                }

                 if(rs.getString(4)==null)
                 {
                      browsepicturepath7.setText("");
                     jXImagePanel9.setImage(null);
                     filename4=null;
                 }
                else
                {
                // imgpic =ImageIO.read(rs.getBinaryStream(4));
imgpic = ImageIO.read(new File(rs.getString(4)));
                System.out.println("r5");
browsepicturepath7.setText(rs.getString(4).substring(5));
filename4="pics/"+rs.getString(4).substring(5);

                 jXImagePanel9.setImage(imgpic.getScaledInstance(156, 112, Image.SCALE_SMOOTH));

                }

                 if(rs.getString(5)==null)
                 {
                      browsepicturepath8.setText("");
                     jXImagePanel10.setImage(null);
                     filename5=null;
                 }
                else
                {
               //  imgpic =ImageIO.read(rs.getBinaryStream(5));
imgpic = ImageIO.read(new File(rs.getString(5)));
                System.out.println("r5");
browsepicturepath8.setText(rs.getString(5).substring(5));
filename5="pics/"+rs.getString(5).substring(5);

                 jXImagePanel10.setImage(imgpic.getScaledInstance(156, 112, Image.SCALE_SMOOTH));

                }

                 if(rs.getString(6)==null)
                 {
                      browsepicturepath9.setText("");
                     jXImagePanel11.setImage(null);
                     filename6=null;
                 }
                else
                {
                 //imgpic =ImageIO.read(rs.getBinaryStream(6));
imgpic = ImageIO.read(new File(rs.getString(6)));
                System.out.println("r5");
browsepicturepath9.setText(rs.getString(6).substring(5));
filename6="pics/"+rs.getString(6).substring(5);

                 jXImagePanel11.setImage(imgpic.getScaledInstance(156, 112, Image.SCALE_SMOOTH));

                }

                 if(rs.getString(7)==null)
                 {
                      browsepicturepath10.setText("");
                     jXImagePanel12.setImage(null);
                     filename7=null;
                 }
                else
                {
                // imgpic =ImageIO.read(rs.getBinaryStream(7));
imgpic = ImageIO.read(new File(rs.getString(7)));
                System.out.println("r5");
browsepicturepath10.setText(rs.getString(7).substring(5));
filename7="pics/"+rs.getString(7).substring(5);

                 jXImagePanel12.setImage(imgpic.getScaledInstance(156, 112, Image.SCALE_SMOOTH));

                }
            }
                     else
           {
               System.out.println("dddddddddddddddddddddddddddddddddddddddddddddddd");
               jXImagePanel2.setImage(null);
               jXImagePanel8.setImage(null);
               jXImagePanel9.setImage(null);
               jXImagePanel10.setImage(null);
               jXImagePanel11.setImage(null);
               jXImagePanel12.setImage(null);
               browsepicturepath1.setText("");
               browsepicturepath6.setText("");
               browsepicturepath7.setText("");
               browsepicturepath8.setText("");
               browsepicturepath9.setText("");
               browsepicturepath10.setText("");
           }

        }catch(Exception e)
        {
           e.printStackTrace();
            System.out.println("r55555555555555555555555");

        }
    }

public void loadPictureParentage()
    {
       // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


        try
        {
            ps=con.prepareStatement("select * from studentfamily where studentid=?");
            ps.setString(1,studentadmissionno.getText());
            rs=ps.executeQuery();
           System.out.println("r1");
           if(rs.next())
            {
                               if(rs.getString(23)==null)
                {
                     browsepicturepath3.setText("");
                    jXImagePanel4.setImage(null);
                    filename=null;
                }
                else
                {
                 //imgpic =ImageIO.read(rs.getBinaryStream(2));
imgpic = ImageIO.read(new File(rs.getString(23)));
                System.out.println("r5");
browsepicturepath3.setText(rs.getString(23).substring(12));
filename="pics/family/"+rs.getString(23).substring(12);
System.out.println("xzcxcxzc"+filename);
System.out.println("xzcxcxzc"+rs.getString(23));
                 jXImagePanel4.setImage(imgpic.getScaledInstance(156, 112, Image.SCALE_SMOOTH));

                                 if(rs.getString(24)==null)
                {
                     browsepicturepath2.setText("");
                    jXImagePanel3.setImage(null);
                    filename1=null;
                }
                else
                {
                 //imgpic =ImageIO.read(rs.getBinaryStream(2));
imgpic = ImageIO.read(new File(rs.getString(24)));
                System.out.println("r5");
browsepicturepath2.setText(rs.getString(24).substring(12));
filename1="pics/family/"+rs.getString(24).substring(12);
System.out.println("xzcxcxzc"+filename1);
System.out.println("xzcxcxzc"+rs.getString(24));
                 jXImagePanel3.setImage(imgpic.getScaledInstance(156, 112, Image.SCALE_SMOOTH));

                }

                }

            }
        }catch(Exception e)
        {
           e.printStackTrace();
            System.out.println("r55555555555555555555555");

        }
    }

public void loadPictureSibling()
    {
        //con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();


        try
        {
            ps=con.prepareStatement("select * from studentfamily where studentid=?");
            ps.setString(1,studentadmissionno.getText());
            rs=ps.executeQuery();
           System.out.println("r1");
           if(rs.next())
            {
               if(rs.getString(25)==null)
                {
                     browsepicturepath5.setText("");
                    jXImagePanel6.setImage(null);
                    filename=null;
                }
                else
                {
                 //imgpic =ImageIO.read(rs.getBinaryStream(2));
imgpic = ImageIO.read(new File(rs.getString(25)));
                System.out.println("r5");
browsepicturepath5.setText(rs.getString(25).substring(12));
filename="pics/family/"+rs.getString(25).substring(12);
System.out.println("xzcxcxzc"+filename);
System.out.println("xzcxcxzc"+rs.getString(25));
                 jXImagePanel6.setImage(imgpic.getScaledInstance(156, 112, Image.SCALE_SMOOTH));
                }

                                 if(rs.getString(26)==null)
                {
                     browsepicturepath4.setText("");
                    jXImagePanel5.setImage(null);
                    filename1=null;
                }
                else
                {
                 //imgpic =ImageIO.read(rs.getBinaryStream(2));
imgpic1 = ImageIO.read(new File(rs.getString(26)));
                System.out.println("r5");
browsepicturepath4.setText(rs.getString(26).substring(12));
filename1="pics/family/"+rs.getString(26).substring(12);
System.out.println("xzcxcxzc"+filename1);
System.out.println("xzcxcxzc"+rs.getString(26));
                 jXImagePanel5.setImage(imgpic1.getScaledInstance(156, 112, Image.SCALE_SMOOTH));

                }

                }
        }catch(Exception e)
        {
           e.printStackTrace();
            System.out.println("r55555555555555555555555");

        }
    }

    public void loadStudentOnAddressBasis()
{
    int i=0,j=0;
    // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
     System.out.println("rd3");
     try
     {
       ps=con.prepareStatement("select * from studententry where address like ?") ;
      ps.setString(1,"%"+studentpresentaddress.getText()+"%");
         //ps.setInt(2,id);

       rs=ps.executeQuery();
      System.out.println("add");
        while(rs.next())
            {
                j++;

            }
            rs.first();
            rs.previous();
            dm.setRowCount(j);
            while(rs.next())
            {


                dm.setValueAt(rs.getString(2), i, 0);
                dm.setValueAt(rs.getString(1), i, 1);
                jXTable1.removeAll();

              //  System.out.println("rd3");


                i++;
            }


   }catch(Exception e)
   {
e.printStackTrace();
   }

}

    public void loadStudentOnGenderBasis()
{
    String selection = null;
    if (malebutton.isSelected())
            selection="m";

        if (femalebutton.isSelected()) selection="f";
    int i=0,j=0;
    // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
     System.out.println("rd3");
     try
     {
       ps=con.prepareStatement("select * from studententry where sex=?") ;
      ps.setString(1,selection);
         //ps.setInt(2,id);
      System.out.println(selection);
       rs=ps.executeQuery();
      System.out.println("rd1");
        while(rs.next())
            {
                j++;
              //  System.out.println("rd2");
            }
            rs.first();
            rs.previous();
            dm.setRowCount(j);
            while(rs.next())
            {


                dm.setValueAt(rs.getString(2), i, 0);
                dm.setValueAt(rs.getString(1), i, 1);
                jXTable1.removeAll();

              //  System.out.println("rd3");


                i++;
            }


   }catch(Exception e)
   {
e.printStackTrace();
   }

}
    public void loadStudentNameTable()
{
    int i=0,j=0;
     //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
     System.out.println("rd3");
     try
     {
       ps=con.prepareStatement("select * from studententry where name like ?") ;
      ps.setString(1,studentname.getText()+"%");
         //ps.setInt(2,id);
      System.out.println("n");
       rs=ps.executeQuery();
      System.out.println("gender");
        while(rs.next())
            {
                j++;
              //  System.out.println("rd2");
            }
            rs.first();
            rs.previous();
            dm.setRowCount(j);
            while(rs.next())
            {


                dm.setValueAt(rs.getString(2), i, 0);
                dm.setValueAt(rs.getString(1), i, 1);
                jXTable1.removeAll();

              //  System.out.println("rd3");


                i++;
            }


   }catch(Exception e)
   {
e.printStackTrace();
   }


}


    public void loadAdmissionNoTableOfTransport(String id)
 {
     int i=0,j=0;
      // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();

       {
   try
   {
        System.out.println("FDF");
       ps=con.prepareStatement("select * from studententry where id like ? or id=?");
       ps.setString(1,id+"%");
         ps.setString(2,id);
       rs=ps.executeQuery();
      // System.out.println("rd1");
        while(rs.next())
            {
                j++;
              //  System.out.println("rd2");
            }
            rs.first();
            rs.previous();
            dm2.setRowCount(j);
            while(rs.next())
            {


                dm2.setValueAt(rs.getString(2), i, 0);
                dm2.setValueAt(rs.getString(1), i, 1);
                jXTable3.removeAll();

              //  System.out.println("rd3");


                i++;
            }


   }catch(Exception e)
   {
e.printStackTrace();
   }
        }
}
    public void updateStudentDetail()
    {

        if(documentDetailArea.getText().isEmpty() )
        {
JOptionPane.showMessageDialog(null,"Atleast Fill Documents Detail and Press Save","report",JOptionPane.PLAIN_MESSAGE);

        } else
        {
     //  con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
try
{System.out.println("Done3");
    ps=con.prepareStatement("select * from studentdetail where id=?");
    ps.setString(1, studentadmissionno.getText());
    rs=ps.executeQuery();
    if(rs.next() || rs.isLast() )
    {System.out.println("Done4");
    // ps = con.prepareStatement("insert into inventorysetup (Inventoryunit,InventoryVendor,Inventorymode,class,unitid,Time) values(?,?,?,?,?,?)");
    ps=con.prepareStatement("update studentdetail set docdetail=?,channel=?,lastschool=?,lastgrade=?,religion=?,category=?,bloodgroup=?,schoolhouse=?,medium=?,disability=?,time=?,email=?,behaviour=?,interest=?,categoryslab=?,ac=?,bank=?,branch=?,area=? where id=? ");

    ps.setString(1,documentDetailArea.getText());
    ps.setString(2,admissionChannelCombo.getSelectedItem().toString());
    ps.setString(3,lastSchool.getText());
    ps.setString(4,lastPercentage.getText());

    ps.setString(5,religion1.get(religionCombo.getSelectedItem().toString()).toString());
    //if(categoryCombo.getSelectedItem().toString().equals("General"))
    //ps.setString(6,categoryCombo.getSelectedItem().toString());
    //else
        ps.setString(6,category1.get(categoryCombo.getSelectedItem().toString()).toString());

    ps.setString(7,bloodGroupCombo.getSelectedItem().toString());
    ps.setString(8,houseCombo.getSelectedItem().toString());
    ps.setString(9,instructionCombo.getSelectedItem().toString());
    ps.setString(10,disabilityCombo.getSelectedItem().toString());

     ps.setString(11,datum);

     ps.setString(12,email.getText());
    ps.setString(13,behaviourcombo.getSelectedItem().toString());
    ps.setString(14,interestcombo.getSelectedItem().toString());
    //if(categoryCombo1.getSelectedItem().equals("choose"))
    //ps.setInt(15,0);
    //else
ps.setInt(15,Integer.parseInt(categorysubmap1.get(categoryCombo1.getSelectedItem()).toString()));
    ps.setString(16,jTextField1.getText());
    ps.setString(17,jTextField2.getText());
    ps.setString(18,jTextField3.getText());
    ps.setString(19,disabilityCombo1.getSelectedItem().toString());
    ps.setString(20,studentadmissionno.getText());


         ps.executeUpdate();
            System.out.println("Done");
        JOptionPane.showMessageDialog(null,"data stored successfully","report",JOptionPane.PLAIN_MESSAGE);

//con.close();
         System.out.println("DataBase Conection Closed");
       // getAdmissionNo();
              return;
        }else JOptionPane.showMessageDialog(null,"Press Save button because no data for update","report",JOptionPane.PLAIN_MESSAGE);
}

catch(Exception e)
{
    e.printStackTrace();
    System.out.println("here");
}

        }
    }
    public void updateStudent()
    {
         String selection;
        if (malebutton.isSelected())
            selection="M";
        else selection="F";

        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
try
{
    ps=con.prepareStatement("select * from studententry where id=?");
                ps.setString(1,studentadmissionno.getText());
       
        System.out.println("tst1");
                rs=ps.executeQuery();
                if(!rs.next())
                    JOptionPane.showMessageDialog(null,"Fresh entry, Press Save Button","report",JOptionPane.PLAIN_MESSAGE);
                else
                {
             rs.first();
                rs.previous();
                //System.out.println("name="+rs.getString(2));
        if(rs.next() || rs.isLast() )
      {
            System.out.println("tst2");
             ps=con.prepareStatement("update studententry set name=?,fathername=?,mothername=?,phone=?,address=?,sex=?,dob=?,class=?,section=?,roll=?,doa=?,TodayDate=? where id=? ");
    ps.setString(1,studentname.getText());
    ps.setString(2,fathername.getText());
    ps.setString(3,mothername.getText());
    ps.setString(4,phoneno.getText());
    ps.setString(5,studentpresentaddress.getText());
    ps.setString(6,selection);
    ps.setString(7,birthdate.getText());
   // ps.setString(8,classcombo.getSelectedItem().toString());
   ps.setInt(8,Integer.parseInt(classmap1.get(classcombo.getSelectedItem()).toString()));
    if(sectioncombo.getSelectedItem()!=null)
    //ps.setString(9,sectioncombo.getSelectedItem().toString());
         ps.setInt(9,Integer.parseInt(sectionmap1.get(sectioncombo.getSelectedItem()).toString()));
    else ps.setString(9,"x");
    ps.setInt(10,Integer.parseInt(rollno.getText()));
    ps.setString(11,doa.getText());
     ps.setString(12,datum);
    ps.setString(13,studentadmissionno.getText());

         ps.executeUpdate();
         System.out.println("Done");
        JOptionPane.showMessageDialog(null,"data updated successfully","report",JOptionPane.PLAIN_MESSAGE);

//con.close();
updatePicture();
         System.out.println("DataBase Conection Closed");
       // getAdmissionNo();
              return;
               }else JOptionPane.showMessageDialog(null,"Fresh entry, Press Save Button","report",JOptionPane.PLAIN_MESSAGE);
}
}


catch(Exception e)
{
    e.printStackTrace();
    System.out.println("here");
}

    }

      public void updateStudentParentage()
    {

        // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
try
{
    ps=con.prepareStatement("select * from studentfamily where studentid=?");
                ps.setString(1,studentadmissionno.getText());

                rs=ps.executeQuery();
                if(!rs.next())
                    JOptionPane.showMessageDialog(null,"Fresh entry, Press Save Button","report",JOptionPane.PLAIN_MESSAGE);
                else
                {
             rs.first();
                rs.previous();
                //System.out.println("name="+rs.getString(2));
        if(rs.next() || rs.isLast() )
      {

            System.out.println("tst2");
             ps=con.prepareStatement("update studentfamily set fdob=?,fqualification=?,foccupation=?,fdesignation=?,fofficeaddress=?,fphone=?,weddinganniversary=?,mdob=?,mqualification=?,moccupation=?,mdesignation=?,mofficeaddress=?,mphone=? where studentid=? ");

              ps.setString(1,birth1.getText());
    ps.setString(2,qualification1.getText());
    ps.setString(3,occupation1.getText());
    ps.setString(4,designation1.getText());
    ps.setString(5,officeaddress1.getText());
    ps.setString(6,phone1.getText());
   ps.setString(7,wed1.getText());
     ps.setString(8,birth2.getText());
    ps.setString(9,qualification2.getText());
    ps.setString(10,occupation2.getText());
    ps.setString(11,designation2.getText());
    ps.setString(12,officeaddress2.getText());
    ps.setString(13,phone2.getText());
    ps.setString(14,studentadmissionno.getText());
    ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"data updated successfully","report",JOptionPane.PLAIN_MESSAGE);

//con.close();
updatePicture();
         System.out.println("DataBase Conection Closed");
       // getAdmissionNo();
              return;
               }else JOptionPane.showMessageDialog(null,"Fresh entry, Press Save Button","report",JOptionPane.PLAIN_MESSAGE);
}
}


catch(Exception e)
{
    e.printStackTrace();
    System.out.println("here");
}

    }
    public void saveStudentDetail()
    {

if (studentadmissionno.getText().isEmpty())
    JOptionPane.showMessageDialog(null,"fill the general information for this student","report",JOptionPane.PLAIN_MESSAGE);
else
{
 if(documentDetailArea.getText().isEmpty())
        {
          JOptionPane.showMessageDialog(null,"Plz fill Documnets Detail and and Save","report",JOptionPane.PLAIN_MESSAGE);

        }
        else{
         //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
try
{
    ps=con.prepareStatement("select * from studentdetail where id=?");
    ps.setString(1,studentadmissionno.getText());
    rs=ps.executeQuery();
    if(rs.next())
    {

JOptionPane.showMessageDialog(null,"press Update button","report",JOptionPane.PLAIN_MESSAGE);
    }
    else
    {
    // ps = con.prepareStatement("insert into inventorysetup (Inventoryunit,InventoryVendor,Inventorymode,class,unitid,Time) values(?,?,?,?,?,?)");
    ps=con.prepareStatement("insert into studentdetail (id,docdetail,channel,lastschool,lastgrade,religion,category,bloodgroup,schoolhouse,medium,disability,time,email,behaviour,interest,categoryslab,ac,bank,branch,area) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    ps.setString(1,studentadmissionno.getText());
    ps.setString(2,documentDetailArea.getText());
    ps.setString(3,admissionChannelCombo.getSelectedItem().toString());
    ps.setString(4,lastSchool.getText());
    ps.setString(5,lastPercentage.getText());
    ps.setString(6,religion1.get(religionCombo.getSelectedItem().toString()).toString());
    //if(categoryCombo.getSelectedItem().toString().equals("General"))
    //ps.setString(7,categoryCombo.getSelectedItem().toString());
    //else
        ps.setString(7,category1.get(categoryCombo.getSelectedItem().toString()).toString());
    ps.setString(8,bloodGroupCombo.getSelectedItem().toString());
    ps.setString(9,houseCombo.getSelectedItem().toString());
    ps.setString(10,instructionCombo.getSelectedItem().toString());
    ps.setString(11,disabilityCombo.getSelectedItem().toString());
    ps.setString(12,datum);
    ps.setString(13,email.getText());
    ps.setString(14,behaviourcombo.getSelectedItem().toString());
    ps.setString(15,interestcombo.getSelectedItem().toString());
    
    ps.setInt(16,Integer.parseInt(categorysubmap1.get(categoryCombo1.getSelectedItem()).toString()));
    ps.setString(17,jTextField1.getText());
    ps.setString(18,jTextField2.getText());
    ps.setString(19,jTextField3.getText());
     ps.setString(20,disabilityCombo1.getSelectedItem().toString());
         ps.executeUpdate();
         //rs.refreshRow();


        System.out.println("Done555");
        JOptionPane.showMessageDialog(null,"data stored successfully","report",JOptionPane.PLAIN_MESSAGE);

//con.close();
         System.out.println("DataBase Conection Closed");
       // getAdmissionNo();
            return;
       }
}

catch(Exception e)
{
    e.printStackTrace();
    System.out.println("here");
}
    }
}
    }

    public void setAdmissionNoText(String id)
    {
        studentadmissionno.setText(id);
        int keycode=KeyEvent.VK_ENTER;
if(keycode==KeyEvent.VK_ENTER)
{
   if(!studentadmissionno.getText().isEmpty())
   {
   jXImagePanel1.setImage(null);
    loadStudent();
    loadPicture();
//jTextField10.setEditable(false);
loadStudentDetail();
   }

}      //System.out.println("rrrrrrfffffffffffff"+id);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox admissionChannelCombo;
    private javax.swing.JCheckBox admissionfeecheckbox;
    private javax.swing.JCheckBox admissionfeecheckbox1;
    private javax.swing.JCheckBox admissionfeecheckbox2;
    private javax.swing.JCheckBox admissionfeecheckbox3;
    private javax.swing.JTextField admissionno;
    private javax.swing.JComboBox behaviourcombo;
    private datechooser.beans.DateChooserCombo birth1;
    private datechooser.beans.DateChooserCombo birth2;
    private datechooser.beans.DateChooserCombo birthdate;
    private javax.swing.JComboBox bloodGroupCombo;
    private javax.swing.JButton browsepicturebutton;
    private javax.swing.JButton browsepicturebutton1;
    private javax.swing.JButton browsepicturebutton10;
    private javax.swing.JButton browsepicturebutton2;
    private javax.swing.JButton browsepicturebutton3;
    private javax.swing.JButton browsepicturebutton4;
    private javax.swing.JButton browsepicturebutton5;
    private javax.swing.JButton browsepicturebutton6;
    private javax.swing.JButton browsepicturebutton7;
    private javax.swing.JButton browsepicturebutton8;
    private javax.swing.JButton browsepicturebutton9;
    private javax.swing.JTextField browsepicturepath;
    private javax.swing.JTextField browsepicturepath1;
    private javax.swing.JTextField browsepicturepath10;
    private javax.swing.JTextField browsepicturepath2;
    private javax.swing.JTextField browsepicturepath3;
    private javax.swing.JTextField browsepicturepath4;
    private javax.swing.JTextField browsepicturepath5;
    private javax.swing.JTextField browsepicturepath6;
    private javax.swing.JTextField browsepicturepath7;
    private javax.swing.JTextField browsepicturepath8;
    private javax.swing.JTextField browsepicturepath9;
    private javax.swing.JComboBox busno;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JComboBox categoryCombo;
    private javax.swing.JComboBox categoryCombo1;
    private javax.swing.JComboBox classcombo;
    private javax.swing.JTextField designation1;
    private javax.swing.JTextField designation2;
    private javax.swing.JButton detailExitButton;
    private javax.swing.JButton detailSaveButton;
    private javax.swing.JButton detailUpdateButton;
    private javax.swing.JComboBox disabilityCombo;
    private javax.swing.JComboBox disabilityCombo1;
    private datechooser.beans.DateChooserCombo doa;
    private javax.swing.JTextArea documentDetailArea;
    private javax.swing.JTextField email;
    private javax.swing.JButton exitbutton;
    private javax.swing.JButton exitbutton2;
    private javax.swing.JTextField fathername;
    private javax.swing.JTextField fathername1;
    private javax.swing.JRadioButton femalebutton;
    private javax.swing.JComboBox houseCombo;
    private javax.swing.JComboBox instructionCombo;
    private javax.swing.JComboBox interestcombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane10;
    private javax.swing.JTextPane jTextPane11;
    private javax.swing.JTextPane jTextPane12;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextPane jTextPane4;
    private javax.swing.JTextPane jTextPane5;
    private javax.swing.JTextPane jTextPane6;
    private javax.swing.JTextPane jTextPane7;
    private javax.swing.JTextPane jTextPane8;
    private javax.swing.JTextPane jTextPane9;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel1;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel10;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel11;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel12;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel2;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel3;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel4;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel5;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel6;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel8;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel9;
    private javax.swing.JTable jXTable1;
    private javax.swing.JTable jXTable2;
    private javax.swing.JTable jXTable3;
    private javax.swing.JTextField lastPercentage;
    private javax.swing.JTextField lastSchool;
    private javax.swing.JLabel loadmsg;
    private javax.swing.JRadioButton malebutton;
    private javax.swing.JTextField mothername;
    private javax.swing.JTextField mothername1;
    private javax.swing.JTextField occupation1;
    private javax.swing.JTextField occupation2;
    private javax.swing.JTextField officeaddress1;
    private javax.swing.JTextField officeaddress2;
    private javax.swing.JTextField phone1;
    private javax.swing.JTextField phone2;
    private javax.swing.JTextField phoneno;
    private javax.swing.JTextField picktext;
    private javax.swing.JTextField qualification1;
    private javax.swing.JTextField qualification2;
    private javax.swing.JComboBox religionCombo;
    private javax.swing.JButton resetbutton;
    private javax.swing.JButton resetbutton2;
    private javax.swing.JButton resetbutton3;
    private javax.swing.JTextField rollno;
    private javax.swing.JTextField routeno;
    private javax.swing.JButton savebutton;
    private javax.swing.JButton savebutton2;
    private datechooser.beans.DateChooserCombo sdob1;
    private datechooser.beans.DateChooserCombo sdob2;
    private javax.swing.JComboBox sectioncombo;
    private javax.swing.JTextField sibling1studentid;
    private javax.swing.JTextField sibling2studentid;
    private javax.swing.JTextField siblingname1;
    private javax.swing.JTextField siblingname2;
    private javax.swing.JCheckBox smscheck;
    private javax.swing.JTextField soccupation1;
    private javax.swing.JTextField soccupation2;
    private javax.swing.JTextField sofficeaddress1;
    private javax.swing.JTextField sofficeaddress2;
    private javax.swing.JTextField squalification1;
    private javax.swing.JTextField squalification5;
    private javax.swing.JTextField sschool1;
    private javax.swing.JTextField sschool2;
    private javax.swing.JTextField stel1;
    private javax.swing.JTextField stel2;
    private javax.swing.JComboBox stopname;
    private javax.swing.JTextField strengthtext;
    private javax.swing.JTextField studentadmissionno;
    private javax.swing.JTextField studentname;
    private javax.swing.JTextField studentpresentaddress;
    private javax.swing.JTextField transportfee;
    private javax.swing.JButton update;
    private javax.swing.JButton updatebutton;
    private javax.swing.JButton updatebutton2;
    private datechooser.beans.DateChooserCombo wed1;
    // End of variables declaration//GEN-END:variables
ResultSet rs,rs1;
PreparedStatement ps,ps1;
BufferedImage imgpic=null,imgpic1=null;
private JFileChooser chooser,chooser1;
String filepath="r",filepath1="r",filepath2="r",filepath3="r",filepath4="r",filepath5="r",filepath6="r",filepath7="r";
String filename=null,filename1=null,filename2=null,filename3=null,filename4=null,filename5=null,filename6=null,filename7=null;

public String monthofadmission;
public Integer admNo=0;
int adm,rol;
}
