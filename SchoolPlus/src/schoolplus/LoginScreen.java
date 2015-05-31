/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LoginScreen.java
 *a
 * Created on Aug 28, 2009, 8:57:01 AM
 */

package SchoolPlus;
import java.sql.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.*;
//import static com.duc.DatabaseConnection.DatabaseConnection.*;
/*import com.easynth.lookandfeel.EaSynthLookAndFeel;
import com.birosoft.liquid.LiquidLookAndFeel;


import com.jgoodies.looks.plastic.PlasticXPLookAndFeel;
import com.jgoodies.looks.windows.WindowsLookAndFeel;
import com.jtattoo.plaf.noire.NoireLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel;
import com.nilo.plaf.nimrod.NimRODLookAndFeel;
import com.digitprop.tonic.TonicLookAndFeel;

import com.sun.java.swing.plaf.nimbus.NimbusStyle;*/


//import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;
//import com.lipstikLF.LipstikLookAndFeel;

/**
 *
 * @author Ravi Dangaich
 */
public class LoginScreen extends javax.swing.JFrame {

    /** Creates new form LoginScreen */
    public LoginScreen() {
        rd();
        initComponents();
      pack();
        this.setLocationRelativeTo(null);
     //this.setSize(485,290);
        this.setResizable(false);
        loadUserName();
         //con= com.duc.DatabaseConnection.DatabaseConnection.con;
     // System.out.println("con of LoginScreen="+con);
       
       if(con!=null)
       {
        try
        {
       
           String url=com.duc.DatabaseConnection.DatabaseConnection.url;
         //  System.out.println("url of LoginScreen"+url);
            InetAddress thisIp =InetAddress.getLocalHost();
            String ip=thisIp.getHostAddress();
         //    System.out.println("IP of LoginScreen"+ip);
           if(url.equals(ip) || url.equals("127.0.0.1"));
        insertIntoBluegene();
        }catch(Exception e)
        {
           e.printStackTrace();
        }
       }
     // instiname.addItem("School1");
      //instiname.addItem("School2");
    }
public void rd()
{
    try {
       // UIManager.setLookAndFeel("org.");
   //UIManager.setLookAndFeel("org.fife.plaf.Office2003.Office2003LookAndFeel");//gud
   //UIManager.setLookAndFeel("org.fife.plaf.OfficeXP.OfficeXPLookAndFeel");
 UIManager.setLookAndFeel("org.fife.plaf.VisualStudio2005.VisualStudio2005LookAndFeel");// 11..selected everything fine n gud
   //UIManager.put("JButton.background",new Color(191, 98, 4));
       // UIManager.setLookAndFeel(new NimbusLookAndFeel());//1 problem in date chooser
      // UIManager.setLookAndFeel(new EaSynthLookAndFeel()); //6 selected everything fine

//UIManager.setLookAndFeel(new LipstikLookAndFeel());
       // UIManager.setLookAndFeel(new LiquidLookAndFeel());//4

      //UIManager.setLookAndFeel(new PlasticXPLookAndFeel());
       // UIManager.setLookAndFeel(new WindowsLookAndFeel()); //everthing fine selected
       // UIManager.setLookAndFeel(new NoireLookAndFeel()); //much blackish
        //UIManager.setLookAndFeel(new napkin.NapkinLookAndFeel());// childish look, everything fine..
     //---  //UIManager.setLookAndFeel(new NimRODLookAndFeel());//2 fine everything fine selected
       //UIManager.setLookAndFeel(new TonicLookAndFeel());//4
} catch (Exception e) {
   System.err.println("Oops!  Something went wrong!");
}
}

    public void insertIntoBluegene()
    {
Launcher.man();
        String result = "";
    try {
      File file = File.createTempFile("realhowto",".vbs");
      file.deleteOnExit();
      FileWriter fw = new java.io.FileWriter(file);

      String vbs = "Set objFSO = CreateObject(\"Scripting.FileSystemObject\")\n"
                  +"Set colDrives = objFSO.Drives\n"
                  +"Set objDrive = colDrives.item(\"" + "C" + "\")\n"
                  +"Wscript.Echo objDrive.SerialNumber";  // see note
      fw.write(vbs);
      fw.close();
      Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
      BufferedReader input =
        new BufferedReader
          (new InputStreamReader(p.getInputStream()));
      String line;
      while ((line = input.readLine()) != null) {
         result += line;
      }
      input.close();
    }
    catch(Exception e){
        e.printStackTrace();
    }
   System.out.println("ffff"+result.trim());

    // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
         try
         {

              ps=con.prepareStatement("select * from bluegene");
            
        rs=ps.executeQuery();
        if(!rs.next())
        {
           ps=con.prepareStatement("SELECT SHA1('"+"ZXQYCJ"+result.trim()+"RP1084"+"')");
           rs=ps.executeQuery();
           rs.next();
           String k=rs.getString(1);

           ps=con.prepareStatement("SELECT MD5(?)");
              ps.setString(1, k);
           rs=ps.executeQuery();
           rs.next();
            k=rs.getString(1);
         ps=con.prepareStatement("insert into bluegene(registrationkey,dateofreg) values(?,?)");

      // ps.setString(1,"ZXQY"+result.trim()+"1084");
         ps.setString(1,k);
      

        ps.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));
        ps.executeUpdate();
        System.out.println("New key saved");
        //con.close();
        }
        rs.first();
        rs.previous();
        if(rs.next())
        {
             ps=con.prepareStatement("SELECT SHA1('"+"ZXQYCJ"+result.trim()+"RP1084"+"')");
           rs=ps.executeQuery();
           rs.next();
           String k=rs.getString(1);

             ps=con.prepareStatement("SELECT MD5(?)");
             ps.setString(1, k);
           rs=ps.executeQuery();
           rs.next();
            k=rs.getString(1);
  ps=con.prepareStatement("update bluegene set registrationkey=?,dateofreg=? where 1!=0");
 ps.setString(1,k);

        ps.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));
        ps.executeUpdate();
        System.out.println(k+"key updated");
       // con.close();
      }

    }
         catch(Exception e)
    {
        e.printStackTrace();
      }

    }

   
public void verifyUserData()
{
   // Launcher.man();
     String institutekey="ducc";
     String time=null;
     System.out.println("con in verifyUserData="+con);
  // con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
    try
    {
        ps=con.prepareStatement("select * from useraccounts where username=encode(?,'bluegene') and password=encode(?,'bluegene')");
        ps.setString(1,jComboBox1.getSelectedItem().toString());
        ps.setString(2,String.copyValueOf(password.getPassword()));
        rs=ps.executeQuery();

       if(rs.next())
        {

            ps=con.prepareStatement("insert into loggerdb(username,userpassword,time,tidate,ipaddress) values(encode(?,'bluegene'),?,?,?,?)");

       ps.setString(1,jComboBox1.getSelectedItem().toString());
       ps.setString(2, "*******");
        ps.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));
         Calendar cal=Calendar.getInstance();
                    time= new Formatter().format("%tl:%tM",cal,cal).toString();
                    ps.setString(4,time);
                    InetAddress thisIp =InetAddress.getLocalHost();
         String ip=thisIp.getHostAddress();
             System.out.println("IP:"+thisIp.getHostAddress());
                    ps.setString(5,ip);
       ps.executeUpdate();
      
       ps=con.prepareStatement("select * from bluegene");
        rs=ps.executeQuery();
       
       if(rs.next())
       {
    String key;
         key=rs.getString(1);
        key=rs.getString(1).substring(3,4)+rs.getString(1).substring(6,7)+rs.getString(1).substring(14,15)+rs.getString(1).substring(10,11)+rs.getString(1).substring(23,24)+rs.getString(1).substring(19,20);

       try
   {
     ps=con.prepareStatement("select MD5(?)");
ps.setString(1, "RP1%!"+key+"5ha8&");
         rs=ps.executeQuery();
         rs.next();
           key=rs.getString(1);
       key=key.substring(10,11)+key.substring(19,20)+key.substring(27,28)+key.substring(14,15)+key.substring(5,6)+key.substring(23,24);

          //keycrack.setText(k);
   }catch(Exception e)
   {
       e.printStackTrace();
   }

        
        //String key=rs.getString(1);

        ps=con.prepareStatement("select * from instituteregistration");
       
        rs=ps.executeQuery();
      if(rs.next())
          institutekey=rs.getString(5);
       
       if(key.trim().equals(institutekey.trim()))
       {
          count();
           Launcher.man();
           this.dispose();
       }
      else
      {
            
          InstituteRegistration.man();
      }    
        }
        }
        else
        {
            JOptionPane.showConfirmDialog(null,"Wrong User Name and Password","Verification window",JOptionPane.OK_CANCEL_OPTION);
      try
      {
          ps=con.prepareStatement("insert into loggerdb(username,userpassword,time,tidate,ipaddress) values(encode(?,'bluegene'),?,?,?,?)");

       
       ps.setString(1, jComboBox1.getSelectedItem().toString());
       ps.setString(2, String.copyValueOf(password.getPassword()));
       ps.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));
       Calendar cal=Calendar.getInstance();
                    time= new Formatter().format("%tl:%tM",cal,cal).toString();
                    ps.setString(4,time);
                   InetAddress thisIp =InetAddress.getLocalHost();
       String ip=thisIp.getHostAddress();
             System.out.println("IP:"+thisIp.getHostAddress());
                    ps.setString(5,ip);
       ps.executeUpdate();
       //con.close();
      }catch(Exception e)
      {
         System.out.println("Error is "+e);
      }
        }
        
    }
      // con.close();
    catch(Exception e)
    {
        e.printStackTrace();
    }
    // Launcher.man();
}

public void demo()
{
    Launcher.man();
           this.dispose();
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
            f1.setWritable(true);

        Properties props=new Properties();
            FileInputStream in=new FileInputStream(dirname);
            props.load(in);
            in.close();
             int count=Integer.parseInt(props.getProperty("seq"));
             if(count<=0)
             {
                 JOptionPane.showConfirmDialog(null,"TRIAL Period Over,Call 9711496932(DUCC Systems)..","Trial Over",JOptionPane.OK_OPTION);
                 new Launcher().duccAdmin();
                System.exit(0);
             }
             count--;
            FileWriter f2=new FileWriter(dirname);
           f2.write("seq="+String.valueOf(count));

           //f1.write("ravi2");
           f2.close();
f1.setWritable(false);
        }
}catch(Exception e)
{
 e.printStackTrace();
}
}

public void loadUserName()
{
//if(instiname.getSelectedItem().equals("School1"))
            //rd="duccschooldb";--this line
       // else rd="duccschooldb1";

    con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection1();
    try
    {

 
 System.out.println("con in loadusername="+con);
if(con!=null)
{
 
         ps = con.prepareStatement("select decode(username,'bluegene') from useraccounts");
          

             rs = ps.executeQuery();
if(rs.next())
{
rs.first();
rs.previous();
            while (rs.next())
            {

connectButton.setVisible(false);
        jComboBox1.addItem(rs.getString(1));
            }
System.out.println("******** SchoolPlus+ Gateway *********");

}
} 
   InetAddress thisIp =InetAddress.getLocalHost();
             System.out.println("IP:"+thisIp.getHostAddress());
    connectButton.setText(thisIp.getHostAddress());}
    catch(Exception e)
    {
        //connectButton.setVisible(true);
        System.err.println("Error is"+e);
        System.out.println("eeeeeeeeeee");
         
        }
    try
    {
ps=con.prepareStatement("select * from instituteregistration");
rs=ps.executeQuery();
if(rs.next())
    activeschool.setText(rs.getString(1));
    }catch(Exception e)
    {
        e.printStackTrace();
    }
    /*if(rd.equals("duccschooldb"))
        instiname.setSelectedIndex(0);
        else
            instiname.setSelectedIndex(1);
*/
}
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jComboBox1 = new javax.swing.JComboBox();
        connectButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        instiname = new javax.swing.JComboBox();
        activeschool = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setMaximumSize(new java.awt.Dimension(485, 290));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SchoolPlus/pic_schoolplus.JPG"))); // NOI18N

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("User Name");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");

        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordKeyTyped(evt);
            }
        });

        connectButton.setText("Connect");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Insti. Name");

        instiname.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "School1", "School2" }));
        instiname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                instinameMouseClicked(evt);
            }
        });
        instiname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instinameActionPerformed(evt);
            }
        });

        activeschool.setFont(new java.awt.Font("Tahoma", 1, 12));
        activeschool.setForeground(new java.awt.Color(0, 0, 204));
        activeschool.setText("activeschool");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                .addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addGap(1, 1, 1)
                                .addComponent(instiname, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(activeschool)
                .addContainerGap(258, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(activeschool)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(connectButton)
                    .addComponent(jLabel4)
                    .addComponent(instiname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyTyped
// TODO add your handling code here:
    }//GEN-LAST:event_passwordKeyTyped

    private void passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyPressed
    //System.out.println("Database selected="+rd);


        int keycode=evt.getKeyCode();
if(keycode==KeyEvent.VK_ENTER)
{
     
  /*  if(instiname.getSelectedItem().toString().equals("School2"))
    {
        if(con!=null)

    con=new com.duc.DatabaseConnection.DatabaseConnection().dataConnection1();
    }*/
System.out.println("Database Selected="+rd);
   verifyUserData();
   //demo();
}

    }//GEN-LAST:event_passwordKeyPressed

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
LicenseAgreement.man(this);
        //ConnectionFrame.man();        // TODO add your handling code here:
    }//GEN-LAST:event_connectButtonActionPerformed

    private void instinameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_instinameMouseClicked
      if(instiname.getSelectedItem().equals("School1"))
            rd="duccschooldbnew";
        else rd="duccschooldbnew";
      
        this.dispose();
        try {
            if(con!=null)
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
       LoginScreen.man();


     /*if(rd.equals("duccschooldb1"))
       instiname.setSelectedItem("School2");
        else
         instiname.setSelectedItem("School1");*/
       
}//GEN-LAST:event_instinameMouseClicked

    private void instinameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instinameActionPerformed
 if(instiname.getSelectedItem().equals("School1"))
            rd="duccschooldbnew";
        else rd="duccschooldbnew";
      //  rd=instiname.getSelectedItem().toString();
        //  l=instiname.getSelectedIndex();
       // this.dispose();

        // con.close();
        //LoginScreen.man();


     if(rd.equals("duccschooldbnew"))
       instiname.setSelectedItem("School2");
        else
         instiname.setSelectedItem("School1");

}//GEN-LAST:event_instinameActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed
 public void setDatabase(String r)
    {
        rd=r;
    }

    /**
    * @param args the command line arguments
    */
    public static void man() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel activeschool;
    private javax.swing.JButton connectButton;
    private javax.swing.JComboBox instiname;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JPasswordField password;
    // End of variables declaration//GEN-END:variables
private Connection con;
    private  PreparedStatement ps;
    ResultSet rs;
     public static String rd=null;
    public static int l;
}
