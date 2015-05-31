/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Launcher.java
 *
 * Created on Aug 20, 2009, by Ravi 2:31:01 PM
 */

package SchoolPlus;

import com.duc.ExaminationDepartment.ResultSection.TestFrame1;
import com.duc.ExaminationDepartment.StudentPromotion;
import com.duc.SpecialDepartment.MoreSection.Attendence.AttendanceMain1;
import com.duc.SpecialDepartment.MoreSection.Library.LibraryMain1;
import com.duc.SpecialDepartment.TeacherSection.StaffManagerGUI1;
import com.duc.SpecialDepartment.TimeTableSection.TimeTableGUI1;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.*;
import static com.duc.DatabaseConnection.DatabaseConnection.*;
import com.duc.DatabaseConnection.*;
import com.duc.SetUpDepartment.CategorySlab;
import com.duc.SetUpDepartment.CategoryWiseSlab;
//import javax.swing.*;

/**
 *
 * @author ravi
 */
public class Launcher extends javax.swing.JFrame {
Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension screensize=kit.getScreenSize();
       // DateFormat df;

    /** Creates new form Launcher */
    public Launcher() {
        initComponents();
         //df=new SimpleDateFormat("dd-MM-yy");
         //con= com.duc.DatabaseConnection.DatabaseConnection.con;
      System.out.println("con of launcher="+con);
        setScreenSize();
       setExtendedState(JFrame.MAXIMIZED_BOTH);
     //jLabel3.setSize(screensize.width,screensize.height);
       checkSession();
       setDateNTime();
       setSession();
       setSchoolNameFromInstituteregistration();
       setUserAccess();
//setUserAccessByCode();
       //jMenuItem64.setVisible(false);
       jButton11.setVisible(false);
       count();
          }

    public void count()
{

    try
    {
         String newDir = "C:\\system\\sys32";
    String dirname=newDir+"\\dsys.properties";
        File f1=new File(dirname);
        if(f1.exists())
        {
           // jMenuItem64.setVisible(true);
            jButton11.setVisible(true);
            Properties props=new Properties();
            FileInputStream in=new FileInputStream(dirname);
            props.load(in);
            in.close();
             int count=Integer.parseInt(props.getProperty("seq"));
            jLabel5.setText("Demo Trial Left="+count);
        }
    }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

public void setDateNTime()
{
  Calendar cal=Calendar.getInstance();
  String time= new Formatter().format("%tl:%tM",cal,cal).toString();
  String dat=datum;
  jLabel4.setText("Date:"+dat);
}
    public void setUserAccess()
    {
       //con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
       {
           try
           {
               ps=con.prepareStatement("select * from logdepartmentsetup");
               rs=ps.executeQuery();
               while(rs.next())
               {
                   if(rs.getInt(1)==1)
                   {
                     jMenu1.setEnabled(false);
                     jButton1.setEnabled(false);
                     //jButton2.setEnabled(false);
                     //jButton5.setEnabled(false);
                   }
                   if(rs.getInt(1)==2)
                   {
                     jMenu2.setEnabled(false);
                     jButton6.setEnabled(false);
                     jButton3.setEnabled(false);
                   }
                   if(rs.getInt(1)==13)
                   {
                     jMenu13.setEnabled(false);
                     jButton8.setEnabled(false);
                   }
                   if(rs.getInt(1)==6)
                     jMenu6.setEnabled(false);
                   if(rs.getInt(1)==5)
                     jMenu5.setEnabled(false);
                   if(rs.getInt(1)==23)
                   {
                     jMenuItem23.setEnabled(false);
                     jButton7.setEnabled(false);
                   }
                   if(rs.getInt(1)==28)
                     jMenuItem28.setEnabled(false);
                   if(rs.getInt(1)==31)
                   {
                     jMenuItem31.setEnabled(false);
                     jButton4.setEnabled(false);
                   }
                   if(rs.getInt(1)==33)
                     jMenuItem33.setEnabled(false);
                   if(rs.getInt(1)==47)
                     jMenuItem47.setEnabled(false);


                   if(rs.getInt(1)==45)
                     jMenuItem45.setEnabled(false);
                   if(rs.getInt(1)==32)
                   {
                     jMenuItem32.setEnabled(false);
                     jButton10.setEnabled(false);
                   }
                   if(rs.getInt(1)==59)
                     jMenuItem59.setEnabled(false);
                   if(rs.getInt(1)==29)
                     jMenuItem29.setEnabled(false);
                   if(rs.getInt(1)==74)
                     jMenuItem74.setEnabled(false);
                   if(rs.getInt(1)==24)
                     jMenuItem24.setEnabled(false);


               }
           }catch(Exception e)
           {
e.printStackTrace();
           }

       }

    }

    public void setUserAccessByCode()
    {
       //con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
       {
           try
           {
               //ps=con.prepareStatement("select * from logdepartmentsetup");
               //rs=ps.executeQuery();
               //while(rs.next())
               {
                   jMenu3.setEnabled(false);
                  // if(rs.getInt(1)==1)
                   {
                     jMenu1.setEnabled(false);
                     jButton1.setEnabled(false);
                     //jButton2.setEnabled(false);
                    // jButton5.setEnabled(false);
                   }
                   //if(rs.getInt(1)==2)
                   {
                     jMenu2.setEnabled(false);
                     jButton6.setEnabled(false);
                     jButton3.setEnabled(false);
                   }
                   //if(rs.getInt(1)==13)
                   {
                     jMenu13.setEnabled(false);
                     jButton8.setEnabled(false);
                   }
                   //if(rs.getInt(1)==6)
                     jMenu6.setEnabled(false);
                   //if(rs.getInt(1)==5)
                     jMenu5.setEnabled(false);
                  // if(rs.getInt(1)==23)
                   {
                    // jMenuItem23.setEnabled(false);//of inventory
                    // jButton7.setEnabled(false);//of inventory
                   }
                   //if(rs.getInt(1)==28)
                     jMenuItem28.setEnabled(false);
                   //if(rs.getInt(1)==31)
                   {
                     jMenuItem31.setEnabled(false);//* of library
                     jButton4.setEnabled(false);
                   }
                   //if(rs.getInt(1)==33)
                     jMenuItem33.setEnabled(false);
                   //if(rs.getInt(1)==47)
                     jMenuItem47.setEnabled(false);


                   //if(rs.getInt(1)==45)
                     jMenuItem45.setEnabled(false);
                   //if(rs.getInt(1)==32)
                   {
                    jMenuItem32.setEnabled(false);// * of time table
                    jButton10.setEnabled(false);
                   }
                   //if(rs.getInt(1)==59)
                     jMenuItem59.setEnabled(false);
                   //if(rs.getInt(1)==29)
                     jMenuItem29.setEnabled(false);
                   //if(rs.getInt(1)==74)
                     jMenuItem74.setEnabled(false);
                   //if(rs.getInt(1)==24)
                     jMenuItem24.setEnabled(false);


               }
           }catch(Exception e)
           {
e.printStackTrace();
           }

       }

    }

     public void setScreenSize()
    {
        

         screenwidth=screensize.width;
        screenheight=screensize.height;
        
        System.out.println("screenwidth="+screenwidth);
        System.out.println("screenheight="+screenheight);
        if(screenwidth<1024)
        {
            int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Set Your Screen Resolution Minimum to 1024*768", "Set Resolution", JOptionPane.OK_OPTION);
System.exit(0);
        }
        if(screenheight<720)
        {   JOptionPane.showConfirmDialog(null, "Set Your Screen Resolution Minimum to 1024*768","Set Resolution",JOptionPane.OK_OPTION);
         System.exit(0);
        }
//setSize(screenwidth,screenheight-30);
System.out.println(""+screenwidth);
// jDesktopPane1.setSize(screenwidth, screenheight);
    }

     public void checkSession()
     {
         int k=0;
         rd=this;
         try
         {
              ps = con.prepareStatement("select * from sessionsetup");

           rs = ps.executeQuery();
           if(!rs.next())
           {
               //jMenuBar1.setEnabled(false);
               jMenu1.setEnabled(false);
                jMenu2.setEnabled(false);
                 jMenu3.setEnabled(false);
                  jMenu4.setEnabled(false);
                  jMenu5.setEnabled(false);
                jMenu6.setEnabled(false);
                jMenu7.setEnabled(false);
                jMenu8.setEnabled(false);
               
                 jMenu13.setEnabled(false);
                
               com.duc.SetUpDepartment.SessionSectionGUI1 aa= new com.duc.SetUpDepartment.SessionSectionGUI1();
        jDesktopPane1.add(aa,0);
        aa.setVisible(true);
      
           }
         }catch(Exception e)
         {
             e.printStackTrace();
         }
     }
public void setSession()
{
   //con= com.duc.DatabaseConnection.DatabaseConnection.con;
       try
       {
           ps = con.prepareStatement("select * from sessionsetup where status=1");

           rs = ps.executeQuery();
           rs.next();
           String sessiontitle= rs.getString(1);
         
           jLabel1.setText(sessiontitle);
           

}
       catch(Exception e)
       {
e.printStackTrace();
       }
}

public void setSchoolNameFromInstituteregistration()
{
   // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    System.out.println("con in SchoolNameFromInstituteregistration="+con);
       try
       {
           ps = con.prepareStatement("select * from instituteregistration");

           rs = ps.executeQuery();
           rs.next();
           String name= rs.getString(1);
           String address=rs.getString(3);
           //con.close();
           System.out.println("ravi2");
           jLabel2.setText(name);

             
}
       catch(Exception e)
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

        jDialog1 = new javax.swing.JDialog();
        jTextField1 = new javax.swing.JTextField();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jButton6 = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        jButton7 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jButton4 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jButton3 = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        jButton8 = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        jButton10 = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        jButton9 = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JToolBar.Separator();
        jLabel4 = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JToolBar.Separator();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator15 = new javax.swing.JToolBar.Separator();
        jLabel5 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem63 = new javax.swing.JMenuItem();
        jMenuItem34 = new javax.swing.JMenuItem();
        jMenuItem66 = new javax.swing.JMenuItem();
        jMenuItem35 = new javax.swing.JMenuItem();
        jMenuItem36 = new javax.swing.JMenuItem();
        jMenuItem37 = new javax.swing.JMenuItem();
        jMenuItem38 = new javax.swing.JMenuItem();
        jMenuItem49 = new javax.swing.JMenuItem();
        jMenuItem48 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem53 = new javax.swing.JMenuItem();
        jMenuItem54 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem56 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem46 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem40 = new javax.swing.JMenuItem();
        jMenuItem51 = new javax.swing.JMenuItem();
        jMenu15 = new javax.swing.JMenu();
        jMenuItem67 = new javax.swing.JMenuItem();
        jMenuItem68 = new javax.swing.JMenuItem();
        jMenuItem69 = new javax.swing.JMenuItem();
        jMenuItem70 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenuItem71 = new javax.swing.JMenuItem();
        jMenu13 = new javax.swing.JMenu();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem30 = new javax.swing.JMenuItem();
        jMenuItem39 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenuItem32 = new javax.swing.JMenuItem();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenuItem31 = new javax.swing.JMenuItem();
        jMenuItem33 = new javax.swing.JMenuItem();
        jMenuItem45 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem41 = new javax.swing.JMenuItem();
        jMenuItem42 = new javax.swing.JMenuItem();
        jMenuItem43 = new javax.swing.JMenuItem();
        jMenuItem52 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem57 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem73 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem44 = new javax.swing.JMenuItem();
        jMenuItem72 = new javax.swing.JMenuItem();
        jMenuItem75 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        jMenuItem59 = new javax.swing.JMenuItem();
        jMenuItem29 = new javax.swing.JMenuItem();
        jMenuItem62 = new javax.swing.JMenuItem();
        jMenuItem64 = new javax.swing.JMenuItem();
        jMenuItem65 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem47 = new javax.swing.JMenuItem();
        jMenuItem50 = new javax.swing.JMenuItem();
        jMenuItem76 = new javax.swing.JMenuItem();
        jMenuItem77 = new javax.swing.JMenuItem();
        jMenuItem74 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem55 = new javax.swing.JMenuItem();
        jMenuItem58 = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem60 = new javax.swing.JMenuItem();
        jMenuItem61 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SchoolPlus   A Complete School Administration Software by DUCC Systems...");

        jDesktopPane1.setBackground(new java.awt.Color(153, 0, 153));
        jDesktopPane1.setForeground(new java.awt.Color(102, 102, 255));

        jTextPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jTextPane1.setForeground(new java.awt.Color(0, 51, 204));
        jTextPane1.setText("                                                                                          SchoolPlus 3.0"); // NOI18N
        jScrollPane1.setViewportView(jTextPane1);

        jToolBar1.setRollover(true);
        jToolBar1.setPreferredSize(new java.awt.Dimension(548, 40));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/payment.gif"))); // NOI18N
        jButton1.setToolTipText("Fee Deposit Section F4"); // NOI18N
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);
        jToolBar1.add(jSeparator3);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/add-student.gif"))); // NOI18N
        jButton6.setToolTipText("Add Student Ctrl+A"); // NOI18N
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);
        jToolBar1.add(jSeparator6);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/inventory.gif"))); // NOI18N
        jButton7.setToolTipText("Inventory F8"); // NOI18N
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton7);
        jToolBar1.add(jSeparator5);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/library.jpg"))); // NOI18N
        jButton4.setToolTipText("Library F9"); // NOI18N
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);
        jToolBar1.add(jSeparator4);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/search.jpg"))); // NOI18N
        jButton3.setToolTipText("Search F3"); // NOI18N
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);
        jToolBar1.add(jSeparator7);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/results-icon.gif"))); // NOI18N
        jButton8.setToolTipText("Result Ctrl+R"); // NOI18N
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton8);
        jToolBar1.add(jSeparator11);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/time-table.gif"))); // NOI18N
        jButton10.setToolTipText("Time-Table Ctrl+T"); // NOI18N
        jButton10.setFocusable(false);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton10);
        jToolBar1.add(jSeparator9);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/abuse.gif"))); // NOI18N
        jButton9.setToolTipText("Exit"); // NOI18N
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton9);
        jToolBar1.add(jSeparator10);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setForeground(new java.awt.Color(0, 102, 153));
        jToolBar1.add(jLabel2);
        jToolBar1.add(jSeparator14);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 9));
        jToolBar1.add(jLabel4);
        jToolBar1.add(jSeparator16);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 9));
        jLabel3.setText("Session:");
        jToolBar1.add(jLabel3);

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 9));
        jToolBar1.add(jLabel1);
        jToolBar1.add(jSeparator15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 9));
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jToolBar1.add(jLabel5);

        jButton11.setForeground(new java.awt.Color(0, 0, 204));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reg1.jpg"))); // NOI18N
        jButton11.setToolTipText("Exit"); // NOI18N
        jButton11.setFocusable(false);
        jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton11);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/graphs button.jpg"))); // NOI18N
        jButton2.setText("jButton2");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(852, 21));

        jMenu5.setBorder(null);
        jMenu5.setForeground(new java.awt.Color(255, 0, 153));
        jMenu5.setText("Reception");
        jMenu5.setFont(new java.awt.Font("Tahoma", 1, 14));
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });

        jMenuItem63.setText("School Desk"); // NOI18N
        jMenuItem63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem63ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem63);

        jMenuItem34.setText("Admission Enquiry"); // NOI18N
        jMenuItem34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem34ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem34);

        jMenuItem66.setText("Prospectus & Registration"); // NOI18N
        jMenuItem66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem66ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem66);

        jMenuItem35.setText("Couriers"); // NOI18N
        jMenuItem35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem35ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem35);

        jMenuItem36.setText("Schedule Events"); // NOI18N
        jMenuItem36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem36ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem36);

        jMenuItem37.setText("Class Works"); // NOI18N
        jMenuItem37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem37ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem37);

        jMenuItem38.setText("Holiday List"); // NOI18N
        jMenuItem38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem38ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem38);

        jMenuItem49.setText("Issue Certificates"); // NOI18N
        jMenuItem49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem49ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem49);

        jMenuItem48.setText("View Notice"); // NOI18N
        jMenuItem48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem48ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem48);

        jMenuBar1.add(jMenu5);

        jMenu2.setForeground(new java.awt.Color(0, 0, 255));
        jMenu2.setText("Student Department");
        jMenu2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItem12.setText("Add Student"); // NOI18N
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem12);

        jMenuItem14.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        jMenuItem14.setText("Search Student"); // NOI18N
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem14);

        jMenuItem15.setText("Student Group"); // NOI18N
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem15);

        jMenuItem16.setText("Awards,Honours and  ECA"); // NOI18N
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem16);

        jMenuItem53.setText("Class Strength List"); // NOI18N
        jMenuItem53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem53ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem53);

        jMenuItem54.setText("Transport Boarders List"); // NOI18N
        jMenuItem54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem54ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem54);

        jMenuBar1.add(jMenu2);

        jMenu1.setForeground(new java.awt.Color(0, 153, 3));
        jMenu1.setText("Fee Department");
        jMenu1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jMenuItem1.setText("Fee Deposit Section"); // NOI18N
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem2.setText("Payments and Dues"); // NOI18N
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem7.setText("Daily Total Collection Register"); // NOI18N
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem56.setText("Cheque/Draft Payments"); // NOI18N
        jMenuItem56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem56ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem56);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        jMenuItem3.setText("Defaulters List"); // NOI18N
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem13.setText("Payment Tracker"); // NOI18N
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem13);

        jMenuItem4.setText("Advance Payments"); // NOI18N
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenu8.setText("Print Fee Reports");

        jMenuItem46.setText("Day's Fees Collection Report");
        jMenuItem46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem46ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem46);

        jMenuItem8.setText("Month's Fees Colletion Report");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem8);

        jMenuItem40.setText("Monthly Unpaid Fee Report");
        jMenuItem40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem40ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem40);

        jMenuItem51.setText("Class Wise Fee Collection Report");
        jMenuItem51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem51ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem51);

        jMenu1.add(jMenu8);

        jMenu15.setText("More Fee Reports");

        jMenuItem67.setText("Fine Payers List");
        jMenuItem67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem67ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem67);

        jMenuItem68.setText("Waiver Obtainers List");
        jMenuItem68.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem68ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem68);

        jMenuItem69.setText("Security Refund");
        jMenuItem69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem69ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem69);

        jMenuItem70.setText("Removed Fee List");
        jMenuItem70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem70ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem70);

        jMenu1.add(jMenu15);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Ledger Section"); // NOI18N
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("Custom Fees Obtainers"); // NOI18N
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem25.setText("Fee Receipt No. Setup"); // NOI18N
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem25);

        jMenuItem71.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem71.setText("Fee Setup"); // NOI18N
        jMenuItem71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem71ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem71);

        jMenuBar1.add(jMenu1);

        jMenu13.setForeground(new java.awt.Color(51, 0, 51));
        jMenu13.setText("Examination Department");
        jMenu13.setFont(new java.awt.Font("Tahoma", 1, 14));
        jMenu13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu13MouseClicked(evt);
            }
        });
        jMenu13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu13ActionPerformed(evt);
            }
        });

        jMenuItem26.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem26.setText("Result section"); // NOI18N
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem26);

        jMenuItem30.setText("Promote Students"); // NOI18N
        jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem30ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem30);

        jMenuItem39.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem39.setText("Attendance section"); // NOI18N
        jMenuItem39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem39ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem39);

        jMenuBar1.add(jMenu13);

        jMenu4.setForeground(new java.awt.Color(255, 0, 0));
        jMenu4.setText("Special Departments");
        jMenu4.setFont(new java.awt.Font("Tahoma", 1, 14));

        jMenuItem23.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        jMenuItem23.setText("Inventory Department"); // NOI18N
        jMenuItem23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem23MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem23MousePressed(evt);
            }
        });
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem23);

        jMenuItem24.setText("Staff Department"); // NOI18N
        jMenuItem24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem24MouseClicked(evt);
            }
        });
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem24);

        jMenuItem32.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem32.setText("Time Table Generator"); // NOI18N
        jMenuItem32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem32MouseClicked(evt);
            }
        });
        jMenuItem32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem32ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem32);

        jMenuItem28.setText("Account Department"); // NOI18N
        jMenuItem28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem28MousePressed(evt);
            }
        });
        jMenuItem28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem28ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem28);

        jMenuItem31.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        jMenuItem31.setText("Library Department"); // NOI18N
        jMenuItem31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem31MousePressed(evt);
            }
        });
        jMenuItem31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem31ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem31);

        jMenuItem33.setText("Transport Department"); // NOI18N
        jMenuItem33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem33MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem33MousePressed(evt);
            }
        });
        jMenuItem33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem33ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem33);

        jMenuItem45.setText("Charity Section"); // NOI18N
        jMenuItem45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem45MouseClicked(evt);
            }
        });
        jMenuItem45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem45ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem45);

        jMenuBar1.add(jMenu4);

        jMenu6.setText("Security");
        jMenu6.setFont(new java.awt.Font("Tahoma", 1, 14));
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu6MouseClicked(evt);
            }
        });

        jMenuItem41.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F11, 0));
        jMenuItem41.setText("Log Viewer"); // NOI18N
        jMenuItem41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem41ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem41);

        jMenuItem42.setText("User Access"); // NOI18N
        jMenuItem42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem42ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem42);

        jMenuItem43.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem43.setText("User Accounts"); // NOI18N
        jMenuItem43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem43ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem43);

        jMenuItem52.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_PAUSE, 0));
        jMenuItem52.setText("Department Access Log"); // NOI18N
        jMenuItem52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem52ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem52);

        jMenuBar1.add(jMenu6);

        jMenu3.setForeground(new java.awt.Color(0, 0, 204));
        jMenu3.setText("Setup");
        jMenu3.setFont(new java.awt.Font("Tahoma", 1, 14));

        jMenuItem17.setText("Class Setup"); // NOI18N
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem17);

        jMenuItem57.setText("Section Setup"); // NOI18N
        jMenuItem57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem57ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem57);

        jMenuItem18.setText("Class-Section Setup"); // NOI18N
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem18);

        jMenuItem19.setText("Subject Setup"); // NOI18N
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem19);

        jMenuItem73.setText("Class-Subject Setup"); // NOI18N
        jMenuItem73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem73ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem73);

        jMenuItem22.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem22.setText("InstituteLogo Setup"); // NOI18N
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem22);

        jMenuItem44.setText("Session Setup"); // NOI18N
        jMenuItem44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem44ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem44);

        jMenuItem72.setText("Parent Declaration"); // NOI18N
        jMenuItem72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem72ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem72);

        jMenuItem75.setText("Designation Setup"); // NOI18N
        jMenuItem75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem75ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem75);

        jMenuItem27.setText("Add Student Setup"); // NOI18N
        jMenuItem27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem27ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem27);

        jMenuItem59.setText("Auto Adm. No.-Roll Generator"); // NOI18N
        jMenuItem59.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem59MouseClicked(evt);
            }
        });
        jMenuItem59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem59ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem59);

        jMenuItem29.setText("Adm. No. Formatter(Class-School Wise)"); // NOI18N
        jMenuItem29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem29MouseClicked(evt);
            }
        });
        jMenuItem29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem29ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem29);

        jMenuItem62.setText("Restrict Fee Load Month Wise"); // NOI18N
        jMenuItem62.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem62MouseClicked(evt);
            }
        });
        jMenuItem62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem62ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem62);

        jMenuItem64.setText("Sub Category Setup"); // NOI18N
        jMenuItem64.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem64MouseClicked(evt);
            }
        });
        jMenuItem64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem64ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem64);

        jMenuItem65.setText("Category-SubCategory Setup"); // NOI18N
        jMenuItem65.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem65MouseClicked(evt);
            }
        });
        jMenuItem65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem65ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem65);

        jMenuBar1.add(jMenu3);

        jMenu7.setForeground(new java.awt.Color(0, 153, 153));
        jMenu7.setText("Accessories");
        jMenu7.setFont(new java.awt.Font("Tahoma", 1, 14));

        jMenuItem47.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        jMenuItem47.setText("Backup and Recovery"); // NOI18N
        jMenuItem47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem47MousePressed(evt);
            }
        });
        jMenuItem47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem47ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem47);

        jMenuItem50.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem50.setText("Calculator"); // NOI18N
        jMenuItem50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem50ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem50);

        jMenuItem76.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem76.setText("SMS"); // NOI18N
        jMenuItem76.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem76MouseClicked(evt);
            }
        });
        jMenuItem76.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem76ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem76);

        jMenuItem77.setText("SMS Sent Record"); // NOI18N
        jMenuItem77.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem77MouseClicked(evt);
            }
        });
        jMenuItem77.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem77ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem77);

        jMenuItem74.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem74.setText("RollBack Section"); // NOI18N
        jMenuItem74.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem74MouseClicked(evt);
            }
        });
        jMenuItem74.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem74ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem74);

        jMenuBar1.add(jMenu7);

        jMenu9.setForeground(new java.awt.Color(102, 102, 0));
        jMenu9.setText("Help");
        jMenu9.setFont(new java.awt.Font("Tahoma", 1, 14));

        jMenuItem55.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem55.setText("Help Contents"); // NOI18N
        jMenuItem55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem55ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem55);

        jMenuItem58.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem58.setText("About Us"); // NOI18N
        jMenuItem58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem58ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem58);

        jMenuBar1.add(jMenu9);

        jMenu11.setForeground(new java.awt.Color(255, 0, 0));
        jMenu11.setText("Exit");
        jMenu11.setFont(new java.awt.Font("Tahoma", 1, 14));

        jMenuItem60.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem60.setText("Startup Window"); // NOI18N
        jMenuItem60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem60ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem60);

        jMenuItem61.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem61.setText("Exit"); // NOI18N
        jMenuItem61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem61ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem61);

        jMenuBar1.add(jMenu11);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1005, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1005, Short.MAX_VALUE)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1005, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        //com.duc.FeeDepartment.FeeCounter.man();
        com.duc.FeeDepartment.FeeCounter1 aa=new com.duc.FeeDepartment.FeeCounter1();
jDesktopPane1.add(aa,0);
aa.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       com.duc.ExaminationDepartment.ResultSection.TestFrame1 aa =new TestFrame1();
   jDesktopPane1.add(aa,0);
   aa.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       com.duc.FeeDepartment.FeeCounter1 aa=new com.duc.FeeDepartment.FeeCounter1();
jDesktopPane1.add(aa,0);
aa.setVisible(true);      // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
JOptionPane jp=new JOptionPane();
int selection=JOptionPane.showConfirmDialog(null,"Exit Window","Shutdown the Window",JOptionPane.OK_CANCEL_OPTION );
if(selection == JOptionPane.OK_OPTION)
{deleteLoginStatus();
    this.dispose();
}// TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       com.duc.SpecialDepartment.InventorySection.InventoryLauncher1 aa=new com.duc.SpecialDepartment.InventorySection.InventoryLauncher1();
jDesktopPane1.add(aa,0);
aa.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
   // com.duc.StudentDepartment.SearchStudent.SearchStudentGUI.man();
        com.duc.StudentDepartment.SearchStudent.SearchStudent aa=new com.duc.StudentDepartment.SearchStudent.SearchStudent();
jDesktopPane1.add(aa,0);
aa.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
//    com.duc.StudentDepartment.AddStudent.AddStudentGUI.man();
        // TODO add your handling code here:
         com.duc.StudentDepartment.AddStudent.AddStudent aa=new com.duc.StudentDepartment.AddStudent.AddStudent();
jDesktopPane1.add(aa,0);
aa.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
// com.duc.FeeDepartment.PaymentDuesGUI.man();
        com.duc.FeeDepartment.PaymentDuesGUI1 aa=new com.duc.FeeDepartment.PaymentDuesGUI1();
jDesktopPane1.add(aa,0);
aa.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
   // com.duc.StudentDepartment.AddStudent.AddStudentGUI.man();   // TODO add your handling code here:
         com.duc.StudentDepartment.AddStudent.AddStudent aa=new com.duc.StudentDepartment.AddStudent.AddStudent();
jDesktopPane1.add(aa,0);
aa.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
//com.duc.SetUpDepartment.ClassGUI.man();
        com.duc.SetUpDepartment.ClassGUI1 aa= new com.duc.SetUpDepartment.ClassGUI1();
        jDesktopPane1.add(aa,0);
        aa.setVisible(true); // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
//com.duc.SetUpDepartment.SectionGUI.man();
         com.duc.SetUpDepartment.SectionGUI1 aa= new com.duc.SetUpDepartment.SectionGUI1();
        jDesktopPane1.add(aa,0);
        aa.setVisible(true); // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
com.duc.SetUpDepartment.SubjectList aa= new com.duc.SetUpDepartment.SubjectList();
        jDesktopPane1.add(aa,0);
        aa.setVisible(true);          // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
//   com.duc.StudentDepartment.SearchStudent.SearchStudentGUI.man();
        com.duc.StudentDepartment.SearchStudent.SearchStudent aa=new com.duc.StudentDepartment.SearchStudent.SearchStudent();
jDesktopPane1.add(aa,0);
aa.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem41ActionPerformed
com.duc.SecurityDepartment.LogSection.LogSection.man();        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem41ActionPerformed

    private void jMenuItem61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem61ActionPerformed
//ProgressBarTest.man1();
deleteLoginStatus();
        try {
            //con=null;
            System.out.println("Con at Exit="+con);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
this.dispose(); 
// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem61ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
//com.duc.SpecialDepartment.InventorySection.InventoryLauncher.man();
        com.duc.SpecialDepartment.InventorySection.InventoryLauncher1 aa= new com.duc.SpecialDepartment.InventorySection.InventoryLauncher1 ();
        jDesktopPane1.add(aa,0);
        aa.setVisible(true); 
      //  com.duc.SpecialDepartment.InventorySection.InventoryLauncher.man();// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem44ActionPerformed
//com.duc.SecurityDepartment.SessionSetup.man();
        // TODO add your handling code here:
          com.duc.SetUpDepartment.SessionSectionGUI1 aa= new com.duc.SetUpDepartment.SessionSectionGUI1();
        jDesktopPane1.add(aa,0);
        aa.setVisible(true); 

    }//GEN-LAST:event_jMenuItem44ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
//com.duc.FeeDepartment.FeePendingGUI.man();
        com.duc.FeeDepartment.FeePendingGUI1 aa=new com.duc.FeeDepartment.FeePendingGUI1();
jDesktopPane1.add(aa,0);
aa.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
//com.duc.FeeDepartment.AdvancePaymentGUI.man();
         com.duc.FeeDepartment.AdvancePaymentGUI1 aa=new com.duc.FeeDepartment.AdvancePaymentGUI1();
jDesktopPane1.add(aa,0);
aa.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
    com.duc.FeeDepartment.LedgerSection.Ledger r=new  com.duc.FeeDepartment.LedgerSection.Ledger();
jDesktopPane1.add(r,0);
r.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
//com.duc.FeeDepartment.FeeRelaxation.man();
        com.duc.FeeDepartment.FeeCustomization1 aa=new com.duc.FeeDepartment.FeeCustomization1();
jDesktopPane1.add(aa,0);
aa.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
//com.duc.FeeDepartment.DayBookGUI.man();
        com.duc.FeeDepartment.DayBookGUI1 aa=new com.duc.FeeDepartment.DayBookGUI1();
jDesktopPane1.add(aa,0);
aa.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
   com.duc.ExaminationDepartment.ResultSection.TestFrame1 aa =new TestFrame1();
   jDesktopPane1.add(aa,0);
   aa.setVisible(true);
   // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void jMenu13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu13ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         com.duc.SpecialDepartment.MoreSection.Library.LibraryMain1 aa =new LibraryMain1();
        jDesktopPane1.add(aa,0);
        aa.setVisible(true);      // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem36ActionPerformed
        // TODO add your handling code here:
       // com.duc.Reception.ScheduleEvent.TestFrame.man();
        com.duc.Reception.ScheduleEvent.TestFrame1 aa=new com.duc.Reception.ScheduleEvent.TestFrame1();
jDesktopPane1.add(aa,0);
aa.setVisible(true);
    }//GEN-LAST:event_jMenuItem36ActionPerformed

    private void jMenuItem67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem67ActionPerformed
//com.duc.FeeDepartment.FinePayment.man();
com.duc.FeeDepartment.FinePayment1 aa=new com.duc.FeeDepartment.FinePayment1();
jDesktopPane1.add(aa,0);
aa.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem67ActionPerformed

    private void jMenuItem68ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem68ActionPerformed
//com.duc.FeeDepartment.WaiverList.man();
        com.duc.FeeDepartment.WaiverList1 aa=new com.duc.FeeDepartment.WaiverList1();
jDesktopPane1.add(aa,0);
aa.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem68ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
//com.duc.FeeDepartment.PaymentTracker.man();
     com.duc.FeeDepartment.PaymentTracker1 aa=new com.duc.FeeDepartment.PaymentTracker1();
jDesktopPane1.add(aa,0);
aa.setVisible(true); // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem34ActionPerformed
com.duc.Reception.AdmissionEnquiry aa=new com.duc.Reception.AdmissionEnquiry();
jDesktopPane1.add(aa,0);
aa.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem34ActionPerformed

    private void jMenuItem35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem35ActionPerformed
       com.duc.Reception.Courier aa=new com.duc.Reception.Courier();
jDesktopPane1.add(aa,0);
aa.setVisible(true);
    }//GEN-LAST:event_jMenuItem35ActionPerformed

    private void jMenuItem37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem37ActionPerformed
com.duc.Reception.ClassWork.ClassWork aa=new com.duc.Reception.ClassWork.ClassWork();
jDesktopPane1.add(aa,0);
aa.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem37ActionPerformed

    private void jMenuItem38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem38ActionPerformed
     com.duc.Reception.HolidayList aa=new com.duc.Reception.HolidayList();
jDesktopPane1.add(aa,0);
aa.setVisible(true);
    }//GEN-LAST:event_jMenuItem38ActionPerformed

    private void jMenuItem49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem49ActionPerformed
  com.duc.Reception.CertificatesToStudents aa=new com.duc.Reception.CertificatesToStudents();
jDesktopPane1.add(aa,0);
aa.setVisible(true);      // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem49ActionPerformed

    private void jMenuItem48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem48ActionPerformed
       com.duc.Reception.ViewIssuedLetter aa=new com.duc.Reception.ViewIssuedLetter();
jDesktopPane1.add(aa,0);
aa.setVisible(true);
    }//GEN-LAST:event_jMenuItem48ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
    com.duc.StudentDepartment.StudentGroup aa=new com.duc.StudentDepartment.StudentGroup();
jDesktopPane1.add(aa,0);
aa.setVisible(true);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
       com.duc.StudentDepartment.Awards.StudentAwards aa=new com.duc.StudentDepartment.Awards.StudentAwards();
jDesktopPane1.add(aa,0);
aa.setVisible(true);
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem28ActionPerformed
       com.duc.SpecialDepartment.AccountSection.AccountSection aa=new com.duc.SpecialDepartment.AccountSection.AccountSection();
jDesktopPane1.add(aa,0);
aa.setVisible(true);
    }//GEN-LAST:event_jMenuItem28ActionPerformed

    private void jMenuItem31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem31ActionPerformed
        com.duc.SpecialDepartment.MoreSection.Library.LibraryMain1 aa =new LibraryMain1();
        jDesktopPane1.add(aa,0);
        aa.setVisible(true);
    }//GEN-LAST:event_jMenuItem31ActionPerformed

    private void jMenuItem43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem43ActionPerformed
com.duc.SecurityDepartment.UserAccountsGUI.man();        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem43ActionPerformed

    private void jMenuItem69ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem69ActionPerformed
//com.duc.FeeDepartment.SecurityRefund.man();
        com.duc.FeeDepartment.SecurityRefund1 aa=new com.duc.FeeDepartment.SecurityRefund1();
jDesktopPane1.add(aa,0);
aa.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem69ActionPerformed

    private void jMenuItem47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem47ActionPerformed
//com.duc.Accessories.DatabaseBackup2.man();
         com.duc.Accessories.DatabaseBackup aa=new com.duc.Accessories.DatabaseBackup();
jDesktopPane1.add(aa,0);
aa.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem47ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
//com.duc.SetUpDepartment.LogoGUI.man();
        // TODO add your handling code here:
         com.duc.SetUpDepartment.LogoGUI1 aa= new com.duc.SetUpDepartment.LogoGUI1();
        jDesktopPane1.add(aa,0);
        aa.setVisible(true);
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem58ActionPerformed
com.duc.Help.AboutDUCC.man();        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem58ActionPerformed

    private void jMenuItem60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem60ActionPerformed
// TODO add your handling code here:
closeLauncher();
    }//GEN-LAST:event_jMenuItem60ActionPerformed

    private void jMenuItem55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem55ActionPerformed
       getHelpFile();
    }//GEN-LAST:event_jMenuItem55ActionPerformed

    private void jMenuItem50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem50ActionPerformed
        com.duc.Accessories.Calculator.man();
    }//GEN-LAST:event_jMenuItem50ActionPerformed

    private void jMenuItem45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem45ActionPerformed
       com.duc.SpecialDepartment.MoreSection.Charity.Charity aa=new  com.duc.SpecialDepartment.MoreSection.Charity.Charity();
jDesktopPane1.add(aa,0);
aa.setVisible(true);
    }//GEN-LAST:event_jMenuItem45ActionPerformed

    private void jMenuItem70ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem70ActionPerformed
       com.duc.FeeDepartment.RemovedFeeRecord aa=new com.duc.FeeDepartment.RemovedFeeRecord();
jDesktopPane1.add(aa,0);
aa.setVisible(true);
    }//GEN-LAST:event_jMenuItem70ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
         com.duc.FeeDepartment.FeeSlipNo aa=new com.duc.FeeDepartment.FeeSlipNo();
jDesktopPane1.add(aa,0);
aa.setVisible(true);
    }//GEN-LAST:event_jMenuItem25ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        // TODO add your handling code here:
        com.duc.SpecialDepartment.TeacherSection.StaffManagerGUI1 aa=new StaffManagerGUI1();
        jDesktopPane1.add(aa,0);
        aa.setVisible(true);
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void jMenuItem32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem32ActionPerformed
        // TODO add your handling code here:
        com.duc.SpecialDepartment.TimeTableSection.TimeTableGUI1 aa =new TimeTableGUI1();
        jDesktopPane1.add(aa,0);
        aa.setVisible(true);
    }//GEN-LAST:event_jMenuItem32ActionPerformed

    private void jMenuItem39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem39ActionPerformed
        // TODO add your handling code here:
        com.duc.SpecialDepartment.MoreSection.Attendence.AttendanceMain1 aa=new AttendanceMain1();
        jDesktopPane1.add(aa,0);
        aa.setVisible(true);
    }//GEN-LAST:event_jMenuItem39ActionPerformed

    private void jMenuItem40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem40ActionPerformed
        // TODO add your handling code here:
        com.duc.FeeDepartment.MonthlyFeeDuesReport aa= new com.duc.FeeDepartment.MonthlyFeeDuesReport();
        jDesktopPane1.add(aa,0);
        aa.setVisible(true);
    }//GEN-LAST:event_jMenuItem40ActionPerformed

    private void jMenuItem46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem46ActionPerformed
        // TODO add your handling code here:
         com.duc.FeeDepartment.FeeCollectionReport1 aa= new com.duc.FeeDepartment.FeeCollectionReport1();
        jDesktopPane1.add(aa,0);
        aa.setVisible(true);
       
    }//GEN-LAST:event_jMenuItem46ActionPerformed

    private void jMenuItem51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem51ActionPerformed
        // TODO add your handling code here:
         com.duc.FeeDepartment.FeeCollectionClassWiseReport aa= new com.duc.FeeDepartment.FeeCollectionClassWiseReport();
        jDesktopPane1.add(aa,0);
        aa.setVisible(true);
    }//GEN-LAST:event_jMenuItem51ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        //JOptionPane.showConfirmDialog(null,"ravi");
        activateDepartment(1);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
       activateDepartment(2);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu13MouseClicked
        activateDepartment(13);
    }//GEN-LAST:event_jMenu13MouseClicked

    private void jMenuItem23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem23MouseClicked
      // String departmentpassword=JOptionPane.showInputDialog("PASSWORD");
      // activateDepartment(23);
    }//GEN-LAST:event_jMenuItem23MouseClicked

    private void jMenuItem23MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem23MousePressed
          activateDepartment(23);
    }//GEN-LAST:event_jMenuItem23MousePressed

    private void jMenuItem28MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem28MousePressed
         activateDepartment(28);
    }//GEN-LAST:event_jMenuItem28MousePressed

    private void jMenuItem31MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem31MousePressed
        activateDepartment(31);
    }//GEN-LAST:event_jMenuItem31MousePressed

    private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
       activateDepartment(6);
    }//GEN-LAST:event_jMenu6MouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        activateDepartment(5);
    }//GEN-LAST:event_jMenu5MouseClicked

    private void jMenuItem47MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem47MousePressed
         activateDepartment(47);
    }//GEN-LAST:event_jMenuItem47MousePressed

    private void jMenuItem42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem42ActionPerformed
       com.duc.SecurityDepartment.UserAccess aa= new com.duc.SecurityDepartment.UserAccess();
        jDesktopPane1.add(aa,0);
        aa.setVisible(true);
    }//GEN-LAST:event_jMenuItem42ActionPerformed

    private void jMenuItem52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem52ActionPerformed
        com.duc.SecurityDepartment.LogSection.DepartmentLogSection aa= new com.duc.SecurityDepartment.LogSection.DepartmentLogSection();
        jDesktopPane1.add(aa,0);
        aa.setVisible(true);
    }//GEN-LAST:event_jMenuItem52ActionPerformed

    private void jMenuItem53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem53ActionPerformed
               com.duc.StudentDepartment.AddStudent.ClassStrength aa= new com.duc.StudentDepartment.AddStudent.ClassStrength();
        jDesktopPane1.add(aa,0);
        aa.setVisible(true);
    }//GEN-LAST:event_jMenuItem53ActionPerformed

    private void jMenuItem54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem54ActionPerformed
          com.duc.SpecialDepartment.MoreSection.TransportSection.TransportBoardersList aa= new com.duc.SpecialDepartment.MoreSection.TransportSection.TransportBoardersList();
        jDesktopPane1.add(aa,0);
        aa.setVisible(true);
    }//GEN-LAST:event_jMenuItem54ActionPerformed

    private void jMenuItem56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem56ActionPerformed
       com.duc.FeeDepartment.ChequeDraftPayments aa= new com.duc.FeeDepartment.ChequeDraftPayments();
        jDesktopPane1.add(aa,0);
        aa.setVisible(true);
}//GEN-LAST:event_jMenuItem56ActionPerformed

    private void jMenuItem57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem57ActionPerformed
         com.duc.SetUpDepartment.SectionList aa= new com.duc.SetUpDepartment.SectionList();
        jDesktopPane1.add(aa,0);
        aa.setVisible(true);
    }//GEN-LAST:event_jMenuItem57ActionPerformed

    private void jMenuItem71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem71ActionPerformed
       com.duc.FeeDepartment.FeeHeadSetup aa= new com.duc.FeeDepartment.FeeHeadSetup();
        jDesktopPane1.add(aa,0);
        aa.setVisible(true);
    }//GEN-LAST:event_jMenuItem71ActionPerformed

    private void jMenuItem72ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem72ActionPerformed
       com.duc.StudentDepartment.AddStudent.Declaration aa= new com.duc.StudentDepartment.AddStudent.Declaration();
        jDesktopPane1.add(aa,0);
        aa.setVisible(true);
    }//GEN-LAST:event_jMenuItem72ActionPerformed

    private void jMenuItem73ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem73ActionPerformed
     //  new com.duc.SetUpDepartment.SubjectGUI().man();
               //= new com.duc.SetUpDepartment.SubjectGUI();
        //jDesktopPane1.add(aa,0);
       // aa.setVisible(true);
         com.duc.SetUpDepartment.SubjectGUI1 aa= new com.duc.SetUpDepartment.SubjectGUI1();
        jDesktopPane1.add(aa,0);
        aa.setVisible(true);
    }//GEN-LAST:event_jMenuItem73ActionPerformed

    private void jMenuItem74ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem74ActionPerformed
       com.duc.Accessories.RollBack1 aa= new com.duc.Accessories.RollBack1();
        jDesktopPane1.add(aa,0);
        aa.setVisible(true);
    }//GEN-LAST:event_jMenuItem74ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
      com.duc.SpecialDepartment.TimeTableSection.TimeTableGUI1 aa =new TimeTableGUI1();
        jDesktopPane1.add(aa,0);
        aa.setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jMenuItem75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem75ActionPerformed
         com.duc.SetUpDepartment.DesignationSetup r=new  com.duc.SetUpDepartment.DesignationSetup();
         jDesktopPane1.add(r,0);
         r.setVisible(true);
    }//GEN-LAST:event_jMenuItem75ActionPerformed

    private void jMenuItem27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem27ActionPerformed
         com.duc.SetUpDepartment.StudentRecordsNDetailsSetup r=new  com.duc.SetUpDepartment.StudentRecordsNDetailsSetup();
jDesktopPane1.add(r,0);
r.setVisible(true);
    }//GEN-LAST:event_jMenuItem27ActionPerformed

    private void jMenuItem29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem29ActionPerformed
         com.duc.SetUpDepartment.AppendToAdmissionNo r=new  com.duc.SetUpDepartment.AppendToAdmissionNo();
jDesktopPane1.add(r,0);
r.setVisible(true);
    }//GEN-LAST:event_jMenuItem29ActionPerformed

    private void jMenuItem59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem59ActionPerformed
       com.duc.SetUpDepartment.AutoGeneration r=new  com.duc.SetUpDepartment.AutoGeneration();
jDesktopPane1.add(r,0);
r.setVisible(true);
    }//GEN-LAST:event_jMenuItem59ActionPerformed

    private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem30ActionPerformed
        // TODO add your handling code here:
        com.duc.ExaminationDepartment.StudentPromotion aa=new StudentPromotion();
        jDesktopPane1.add(aa,0);
        aa.setVisible(true);
    }//GEN-LAST:event_jMenuItem30ActionPerformed

    private void jMenuItem24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem24MouseClicked
        activateDepartment(24);
    }//GEN-LAST:event_jMenuItem24MouseClicked

    private void jMenuItem32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem32MouseClicked
        activateDepartment(32);
    }//GEN-LAST:event_jMenuItem32MouseClicked

    private void jMenuItem45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem45MouseClicked
        activateDepartment(45);
    }//GEN-LAST:event_jMenuItem45MouseClicked

    private void jMenuItem74MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem74MouseClicked
        activateDepartment(74);// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem74MouseClicked

    private void jMenuItem59MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem59MouseClicked
        activateDepartment(59);// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem59MouseClicked

    private void jMenuItem29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem29MouseClicked
        activateDepartment(29);
    }//GEN-LAST:event_jMenuItem29MouseClicked

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        System.out.println("month wise fee collection report");
        com.duc.FeeDepartment.MonthFeeCollectionReport aa=new com.duc.FeeDepartment.MonthFeeCollectionReport();
        jDesktopPane1.add(aa,0);
        aa.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem62MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem62MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem62MouseClicked

    private void jMenuItem62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem62ActionPerformed
       com.duc.SetUpDepartment.RestrictFeeMonthWise r=new  com.duc.SetUpDepartment.RestrictFeeMonthWise();
jDesktopPane1.add(r,0);
r.setVisible(true);
    }//GEN-LAST:event_jMenuItem62ActionPerformed

    private void jMenuItem76MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem76MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem76MouseClicked

    private void jMenuItem76ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem76ActionPerformed
        com.duc.Accessories.SmsAccess r=new  com.duc.Accessories.SmsAccess();
jDesktopPane1.add(r,0);
r.setVisible(true);
    }//GEN-LAST:event_jMenuItem76ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
       duccAdmin();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jMenuItem33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem33ActionPerformed
        com.duc.SpecialDepartment.MoreSection.TransportSection.Transport aa=new  com.duc.SpecialDepartment.MoreSection.TransportSection.Transport();
        jDesktopPane1.add(aa,0);
        aa.setVisible(true);
}//GEN-LAST:event_jMenuItem33ActionPerformed

    private void jMenuItem33MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem33MousePressed
        activateDepartment(33);
}//GEN-LAST:event_jMenuItem33MousePressed

    private void jMenuItem33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem33MouseClicked
        activateDepartment(33); // TODO add your handling code here:
}//GEN-LAST:event_jMenuItem33MouseClicked

    private void jMenuItem77MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem77MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem77MouseClicked

    private void jMenuItem77ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem77ActionPerformed
        // TODO add your handling code here:
        com.duc.Accessories.SentSMS aa= new com.duc.Accessories.SentSMS();
        jDesktopPane1.add(aa,0);
        aa.setVisible(true);
    }//GEN-LAST:event_jMenuItem77ActionPerformed

    private void jMenuItem64MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem64MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem64MouseClicked

    private void jMenuItem64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem64ActionPerformed
        // TODO add your handling code here:


         com.duc.SetUpDepartment.CategorySlab aa= new CategorySlab();
        jDesktopPane1.add(aa,0);
        aa.setVisible(true);
    }//GEN-LAST:event_jMenuItem64ActionPerformed

    private void jMenuItem65MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem65MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem65MouseClicked

    private void jMenuItem65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem65ActionPerformed
        // TODO add your handling code here:
        com.duc.SetUpDepartment.CategoryWiseSlab aa= new CategoryWiseSlab();
        jDesktopPane1.add(aa,0);
        aa.setVisible(true);
    }//GEN-LAST:event_jMenuItem65ActionPerformed

    private void jMenuItem63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem63ActionPerformed
        // TODO add your handling code here:
        com.duc.Reception.ReceptionTalk aa=new com.duc.Reception.ReceptionTalk();
jDesktopPane1.add(aa,0);
aa.setVisible(true);
    }//GEN-LAST:event_jMenuItem63ActionPerformed

    private void jMenuItem66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem66ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem66ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        com.duc.Accessories.Graphs aa=new com.duc.Accessories.Graphs();
jDesktopPane1.add(aa,0);
aa.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed
public void duccAdmin()
{
    JPasswordField pField = new JPasswordField(10);
      JPanel pPanel = new JPanel();
      pPanel.add(new JLabel("Please Enter Registration Password: "));
      pPanel.add(pField);
     
     // jDesktopPane1.add(pPanel,0);
      // pPanel.setVisible(true);

       int result = JOptionPane.showConfirmDialog(null, pPanel,"Enter Registration Password",JOptionPane.PLAIN_MESSAGE);
      if (result == JOptionPane.OK_OPTION) {
         System.out.println(String.valueOf(pField.getPassword()));
         if((String.valueOf(pField.getPassword())).equals("ducc123"))
         {
              try
    {
         String newDir = "C:\\system\\sys32";
    String dirname=newDir+"\\dsys.properties";
        File f1=new File(dirname);
        if(f1.exists())
        {
            f1.delete();
        }

              }catch(Exception e)
              {
                  e.printStackTrace();
              }
      }
}
}
    public void  closeLauncher()
{
    this.dispose();
    //rd=this;
LoginScreen.man();
}
    public void activateDepartment(int departmentid)
    {
        String username;
        System.out.println("1111111111111111");
        //JPasswordField departmentpassword=null;
        String departmentpassword=null;
         String time=null;
       // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        try
        {
           InetAddress thisIp =InetAddress.getLocalHost();
         String ip=thisIp.getHostAddress();
             System.out.println("IP:"+thisIp.getHostAddress());
             ps=con.prepareStatement("select * from useraccounts where ipaddress=?");//if u want to lock the menus on a computer widout network, just write a wrong ip in useraccounts ...suppose
             ps.setString(1,ip);//u want to enter lock for admin and localhost ip on this orphan computer 192.168.1.2 don't write this ,write 192.168.1.4/// and if on LAN then do things correctly...
             rs=ps.executeQuery();
             if(rs.next())
             {
                 username=rs.getString(1);
                 ps=con.prepareStatement("select decode(?,'bluegene')");
                 ps.setString(1,username);
                         rs=ps.executeQuery();
                         rs.next();
             if(rs.getString(1).equals("Admin"))
             {
                // if(departmentid==1)
                     jMenu1.setEnabled(true);
               // if(departmentid==2)
                    jMenu2.setEnabled(true);
               // if(departmentid==13)
                    jMenu13.setEnabled(true);
                // if(departmentid==6)
                     jMenu6.setEnabled(true);
               // if(departmentid==5)
                    jMenu5.setEnabled(true);
               // if(departmentid==23)
                    jMenuItem23.setEnabled(true);
                // if(departmentid==28)
                     jMenuItem28.setEnabled(true);
               // if(departmentid==31)
                    jMenuItem31.setEnabled(true);
                // if(departmentid==33)
                     jMenuItem33.setEnabled(true);
                //if(departmentid==47)
                    jMenuItem47.setEnabled(true);



                    //if(rs.getInt(1)==45)
                     jMenuItem45.setEnabled(true);
                   //if(rs.getInt(1)==32)
                   {
                     jMenuItem32.setEnabled(true);
                     jButton10.setEnabled(true);
                   }
                   //if(rs.getInt(1)==59)
                     jMenuItem59.setEnabled(true);
                   //if(rs.getInt(1)==29)
                     jMenuItem29.setEnabled(true);
                   //if(rs.getInt(1)==74)
                     jMenuItem74.setEnabled(true);
                   //if(rs.getInt(1)==24)
                     jMenuItem24.setEnabled(true);


                     jButton1.setEnabled(true);
                     //jButton2.setEnabled(true);
////                    // jButton5.setEnabled(true);

                     jButton6.setEnabled(true);
                     jButton3.setEnabled(true);

                     jButton8.setEnabled(true);
                     jButton7.setEnabled(true);
                     jButton4.setEnabled(true);

                
             }
             else
             {
             ps=con.prepareStatement("select * from logdepartmentsetup where departmentid=?");
             ps.setInt(1,departmentid);
             rs=ps.executeQuery();
             if(rs.next())
             {
                  if(departmentid==1)jMenu1.setEnabled(false);
                if(departmentid==2)jMenu2.setEnabled(false);
                if(departmentid==13)jMenu13.setEnabled(false);
                 if(departmentid==6)jMenu6.setEnabled(false);
                if(departmentid==5)jMenu5.setEnabled(false);
                if(departmentid==23)jMenuItem23.setEnabled(false);
                 if(departmentid==28)jMenuItem28.setEnabled(false);
                if(departmentid==31)jMenuItem31.setEnabled(false);
                 if(departmentid==33)jMenuItem33.setEnabled(false);
                if(departmentid==47)jMenuItem47.setEnabled(false);

                  if(departmentid==45)jMenuItem45.setEnabled(false);
                 if(departmentid==32)jMenuItem32.setEnabled(false);
                if(departmentid==29)jMenuItem29.setEnabled(false);
                 if(departmentid==59)jMenuItem59.setEnabled(false);
                if(departmentid==74)jMenuItem74.setEnabled(false);
                  if(departmentid==24)jMenuItem24.setEnabled(false);
            ps=con.prepareStatement("select * from loginstatus where ipaddress=? and departmentid=?");
            ps.setString(1,ip);
            ps.setInt(2,departmentid);
            rs=ps.executeQuery();
            if(rs.next())
            {
                if(departmentid==1)jMenu1.setEnabled(true);
                if(departmentid==2)jMenu2.setEnabled(true);
                if(departmentid==13)jMenu13.setEnabled(true);
                 if(departmentid==6)jMenu6.setEnabled(true);
                if(departmentid==5)jMenu5.setEnabled(true);
                if(departmentid==23)jMenuItem23.setEnabled(true);
                 if(departmentid==28)jMenuItem28.setEnabled(true);
                if(departmentid==31)jMenuItem31.setEnabled(true);
                 if(departmentid==33)jMenuItem33.setEnabled(true);
                if(departmentid==47)jMenuItem47.setEnabled(true);

                if(departmentid==45)jMenuItem45.setEnabled(true);
                 if(departmentid==32)jMenuItem32.setEnabled(true);
                if(departmentid==29)jMenuItem29.setEnabled(true);
                 if(departmentid==59)jMenuItem59.setEnabled(true);
                if(departmentid==74)jMenuItem74.setEnabled(true);
                  if(departmentid==24)jMenuItem24.setEnabled(true);

            }else
            {
             
                JPasswordField pField = new JPasswordField(10);
      JPanel pPanel = new JPanel();
      pPanel.add(new JLabel("Please Enter Password: "));
      pPanel.add(pField);

      int result = JOptionPane.showConfirmDialog(null, pPanel,"Enter Password",JOptionPane.PLAIN_MESSAGE);
      if (result == JOptionPane.OK_OPTION) {
         System.out.println(String.valueOf(pField.getPassword()));
      }
          departmentpassword= String.valueOf(pField.getPassword()).trim();   // departmentpassword=
               //if(departmentpassword!=null)
              // {
                   //System.out.println("rrrrrrr+++"+departmentpassword);
                ps=con.prepareStatement("select * from logdepartmentsetup where departmentid=? and password=encode(?,'bluegene')");
                ps.setInt(1,departmentid);
                ps.setString(2,departmentpassword);
                rs=ps.executeQuery();
                if(rs.next())
                {
                     if(departmentid==1)jMenu1.setEnabled(true);
                if(departmentid==2)jMenu2.setEnabled(true);
                      if(departmentid==13)jMenu13.setEnabled(true);
                     if(departmentid==6)jMenu6.setEnabled(true);
                     if(departmentid==5)jMenu5.setEnabled(true);
                      if(departmentid==23)jMenuItem23.setEnabled(true);
                      if(departmentid==28)jMenuItem28.setEnabled(true);
                     if(departmentid==31)jMenuItem23.setEnabled(true);
                      if(departmentid==33)jMenuItem28.setEnabled(true);
                     if(departmentid==47)jMenuItem47.setEnabled(true);

                     if(departmentid==45)jMenuItem45.setEnabled(true);
                 if(departmentid==32)jMenuItem32.setEnabled(true);
                if(departmentid==29)jMenuItem29.setEnabled(true);
                 if(departmentid==59)jMenuItem59.setEnabled(true);
                if(departmentid==74)jMenuItem74.setEnabled(true);
                  if(departmentid==24)jMenuItem24.setEnabled(true);

                    ps=con.prepareStatement("insert into loginstatus values(?,?,?)");
                    ps.setString(1,ip);
                    ps.setInt(2,departmentid);
                    ps.setInt(3,1);
                    ps.executeUpdate();

                    ps=con.prepareStatement("insert into logdepartmentiprecord values(?,?,?,?,?)");
                    ps.setInt(1,departmentid);
                    ps.setString(2,ip);
                    ps.setString(3,datum);
                    //ps.setString(4, new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));
                    Calendar cal=Calendar.getInstance();
                    time= new Formatter().format("%tl:%tM",cal,cal).toString();
                    ps.setString(4,time);
                    ps.setString(5,"******");
                    System.out.println(time);
                    ps.executeUpdate();


                }

                else
                {
                     ps=con.prepareStatement("insert into logdepartmentiprecord values(?,?,?,?,?)");
                    ps.setInt(1,departmentid);
                    ps.setString(2,ip);
                    ps.setString(3,datum);
                    Calendar cal=Calendar.getInstance();
                    time= new Formatter().format("%tl:%tM",cal,cal).toString();
                    ps.setString(4,time);
                     ps.setString(5,departmentpassword);
                    System.out.println(time);
                    ps.executeUpdate();
                }
            //} else JOptionPane.showConfirmDialog(null,"password empty","Password Empty",JOptionPane.OK_OPTION);
            }
        }
            /* else
             {
                  if(departmentid==1)jMenu1.setEnabled(true);
                if(departmentid==2)jMenu2.setEnabled(true);
                if(departmentid==13)jMenu13.setEnabled(true);
                 if(departmentid==6)jMenu6.setEnabled(true);
                if(departmentid==5)jMenu5.setEnabled(true);
                if(departmentid==23)jMenuItem23.setEnabled(true);
                 if(departmentid==28)jMenuItem28.setEnabled(true);
                if(departmentid==31)jMenuItem31.setEnabled(true);
                 if(departmentid==33)jMenuItem33.setEnabled(true);
                if(departmentid==47)jMenuItem47.setEnabled(true);

                  if(departmentid==45)jMenuItem45.setEnabled(true);
                 if(departmentid==32)jMenuItem32.setEnabled(true);
                if(departmentid==29)jMenuItem29.setEnabled(true);
                 if(departmentid==59)jMenuItem59.setEnabled(true);
                if(departmentid==74)jMenuItem74.setEnabled(true);
                  if(departmentid==24)jMenuItem24.setEnabled(true);

             }*/
        }
        }
        }catch(Exception e)
        {
e.printStackTrace();
        }
    }
    public  void backGroundColor(Color c)
    {
      jDesktopPane1.setBackground(c);
    }

    public void deleteLoginStatus()
    {
        // con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
        try
        {
           InetAddress thisIp =InetAddress.getLocalHost();
         String ip=thisIp.getHostAddress();
             System.out.println("IP:"+thisIp.getHostAddress());
            ps=con.prepareStatement("delete from loginstatus where ipaddress=?");
            ps.setString(1,ip);
           ps.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void getHelpFile()
{
     try {
            Runtime rt = Runtime.getRuntime();
           // rt.exec("SchoolPlus+_Help_File");
            Process pp=rt.exec(" rundll32 url.dll,FileProtocolHandler help.chm" );

        } catch (Exception ex) {
            ex.printStackTrace();
        }
}
    

    
    /**
    * @param args the command line arguments
    */
    public static void man() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Launcher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem31;
    private javax.swing.JMenuItem jMenuItem32;
    private javax.swing.JMenuItem jMenuItem33;
    private javax.swing.JMenuItem jMenuItem34;
    private javax.swing.JMenuItem jMenuItem35;
    private javax.swing.JMenuItem jMenuItem36;
    private javax.swing.JMenuItem jMenuItem37;
    private javax.swing.JMenuItem jMenuItem38;
    private javax.swing.JMenuItem jMenuItem39;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem40;
    private javax.swing.JMenuItem jMenuItem41;
    private javax.swing.JMenuItem jMenuItem42;
    private javax.swing.JMenuItem jMenuItem43;
    private javax.swing.JMenuItem jMenuItem44;
    private javax.swing.JMenuItem jMenuItem45;
    private javax.swing.JMenuItem jMenuItem46;
    private javax.swing.JMenuItem jMenuItem47;
    private javax.swing.JMenuItem jMenuItem48;
    private javax.swing.JMenuItem jMenuItem49;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem50;
    private javax.swing.JMenuItem jMenuItem51;
    private javax.swing.JMenuItem jMenuItem52;
    private javax.swing.JMenuItem jMenuItem53;
    private javax.swing.JMenuItem jMenuItem54;
    private javax.swing.JMenuItem jMenuItem55;
    private javax.swing.JMenuItem jMenuItem56;
    private javax.swing.JMenuItem jMenuItem57;
    private javax.swing.JMenuItem jMenuItem58;
    private javax.swing.JMenuItem jMenuItem59;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem60;
    private javax.swing.JMenuItem jMenuItem61;
    private javax.swing.JMenuItem jMenuItem62;
    private javax.swing.JMenuItem jMenuItem63;
    private javax.swing.JMenuItem jMenuItem64;
    private javax.swing.JMenuItem jMenuItem65;
    private javax.swing.JMenuItem jMenuItem66;
    private javax.swing.JMenuItem jMenuItem67;
    private javax.swing.JMenuItem jMenuItem68;
    private javax.swing.JMenuItem jMenuItem69;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem70;
    private javax.swing.JMenuItem jMenuItem71;
    private javax.swing.JMenuItem jMenuItem72;
    private javax.swing.JMenuItem jMenuItem73;
    private javax.swing.JMenuItem jMenuItem74;
    private javax.swing.JMenuItem jMenuItem75;
    private javax.swing.JMenuItem jMenuItem76;
    private javax.swing.JMenuItem jMenuItem77;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator14;
    private javax.swing.JToolBar.Separator jSeparator15;
    private javax.swing.JToolBar.Separator jSeparator16;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
//Connection con;
PreparedStatement ps;
ResultSet rs;
public int screenheight,screenwidth;
public static Launcher rd;
}
