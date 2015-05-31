/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ConnectionFrame.java
 *
 * Created on Sep 22, 2009, 6:11:37 PM
 */

package SchoolPlus;

import com.mysql.jdbc.PreparedStatement;
import java.io.FileWriter;
import java.net.InetAddress;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.Timer;

/**
 *
 * @author sourabh
 */
public class ConnectionFrame extends javax.swing.JFrame {
 final static int interval = 1000;
  int i;
  JLabel label;
    JProgressBar pb;
    Timer timer;
    /** Creates new form ConnectionFrame */
    public ConnectionFrame() {
        initComponents();
         pack();
        this.setLocationRelativeTo(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        usertext = new javax.swing.JTextField();
        iptext = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        passtext = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Database Connnection Form");

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jTextPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jTextPane1.setText("                             DataCenter");
        jScrollPane1.setViewportView(jTextPane1);

        jTextPane2.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane2.setEditable(false);
        jTextPane2.setText("Username= Database username, Password=Database password and IP=Database Server IP");
        jScrollPane2.setViewportView(jTextPane2);

        jLabel1.setText("User Name");

        jLabel2.setText("Password");

        jLabel3.setText("IP Address");

        jButton1.setText("Connect");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usertext, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passtext, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(223, 223, 223))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iptext, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addGap(40, 40, 40)
                .addComponent(jButton1)
                .addGap(110, 110, 110))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(usertext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(passtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(iptext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      // getIPAddress();
        int option1;
        getData();
        connectDataCenter();
        try
        {

        InetAddress thisIp =InetAddress.getLocalHost();
       String addr=thisIp.getHostAddress().trim();
       if(addr.equals(ip) || "127.0.0.1".equals(ip) )//if on LAN and will use only single system, u can use 127.0.0.1 but if on LAN and will use terminals , plz use lan ip for Server as well (not 127.0.0.1)
       {
      
        option1= JOptionPane.showConfirmDialog(null,"Install Fresh Copy of Database","Database Confirmation",JOptionPane.OK_OPTION);
         if(option1==JOptionPane.OK_OPTION)
           ProgressBarTest.man1();

       }
        else
             {
                 JOptionPane.showConfirmDialog(null,"Check IP,NO DataBase Installation","Wrong IP or Client System",JOptionPane.OK_OPTION);

             }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
       
   this.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed
public void getData()
{
    ip=iptext.getText();
    pass=String.valueOf(passtext.getPassword());
    user=usertext.getText();
}
    
   

    public static void getIPAddress()
    {
        try
        {
            InetAddress thisIp =InetAddress.getLocalHost();
             System.out.println("IP:"+thisIp.getHostAddress());
             String addr=thisIp.getHostAddress().trim();
             if(addr.equals(ip) ||  "127.0.0.1".equals(ip))
             {
                 Runtime rt = Runtime.getRuntime();
              rt.exec("dbInstaller.bat");

System.out.println("ffffffffffffdddddddddddddgggggggggggg");
         
             }

             }catch(Exception e)
        {

e.printStackTrace();
        }

    }
    public void connectDataCenter()
    {
         try
       {
           FileWriter f1=new FileWriter("database.properties");
           f1.write("jdbc.username="+user+"\r");
          f1.write("jdbc.password="+pass+"\r");
           f1.write("jdbc.url="+ip);
           //f1.write("ravi2");
           f1.close();
    }
       catch(Exception e)
    {
e.printStackTrace();
    }
    }
    /**
    * @param args the command line arguments
    */
    public static void man(LoginScreen r) {
        rd=r;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConnectionFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField iptext;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JPasswordField passtext;
    private javax.swing.JTextField usertext;
    // End of variables declaration//GEN-END:variables
public static String ip;
public static String pass;
public static String user;
ResultSet rs;
PreparedStatement ps;
public static LoginScreen rd;
}


class ProgressBarTest {

    public static void man1()
    {

        JFrame f=new ProgressBarFrame();
         f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
        t1=f;
    }
 public static JFrame t1;
}

class ProgressBarFrame extends JFrame
{

    public ProgressBarFrame()
    {
        this.setLocationRelativeTo(null);
        setTitle("Raw Database Installation");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        textarea=new JTextArea();
        JPanel panel=new JPanel();
        sb=new JButton("start");
        pb=new JProgressBar();
        pb.setStringPainted(true);
        panel.add(sb);
        panel.add(pb);



        add(new JScrollPane(textarea),BorderLayout.CENTER);
        add(panel,BorderLayout.SOUTH);

        sb.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                pb.setMaximum(10);//set the bar
                activity=new SimulatedActivity(10); //set the function
  

                new Thread(activity).start();
                activitymonitor.start();
                sb.setEnabled(false);
            }

        });

        activitymonitor=new Timer(50,new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                int current=activity.getCurrent();
                textarea.append(current+"0% completed..."+"\n");
                //textarea.p

                pb.setStringPainted(pb.isIndeterminate());
                pb.setValue(current);
                if(current==activity.getTarget())
                {
                    activitymonitor.stop();
                    sb.setEnabled(true);
                    ProgressBarTest.t1.dispose();
                }
            }

        });
      //  System.out.println("ffffffffffffffffffff");
    }

    private Timer activitymonitor;
    private JButton sb;
    private JProgressBar pb;
    private JCheckBox checkbox;
    private JTextArea textarea;
    private SimulatedActivity activity;
    public static final int DEFAULT_WIDTH=300;
     public static final int DEFAULT_HEIGHT=100;
}



class SimulatedActivity implements Runnable
{
    public SimulatedActivity(int t)
    {
        current =0;
        target=t;
       

 ConnectionFrame.getIPAddress();

         
         System.out.println("gggggggggggggggg");
    }

    public int getTarget()
    {
        return target;
    }

    public int getCurrent()
    {
        return current;
    }

    public void run()
    {
        try
        {
            while(current<target)
            {
                Thread.sleep(1000);
                current++;
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }

     int reply=JOptionPane.showConfirmDialog(null,"Restart SchoolPlus+","Restart",JOptionPane.PLAIN_MESSAGE);
   if(reply==JOptionPane.OK_OPTION)
   {
    ConnectionFrame.rd.dispose();
    //LoginScreen rd=new LoginScreen();
  //LoginScreen.man();
   }

    }
 
    private volatile int current;
    private int target;
}
