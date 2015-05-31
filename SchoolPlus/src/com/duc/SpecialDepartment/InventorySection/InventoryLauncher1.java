/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InventoryLauncher1.java
 *
 * Created on Jan 15, 2010, 1:05:01 AM
 */

package com.duc.SpecialDepartment.InventorySection;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import static com.duc.DatabaseConnection.DatabaseConnection.*;
/**
 *
 * @author Ravi
 */
public class InventoryLauncher1 extends javax.swing.JInternalFrame {

    /** Creates new form InventoryLauncher1 */
    public InventoryLauncher1() {
        initComponents();
        setSession();
    }
public void setScreenSize()
    {
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension screensize=kit.getScreenSize();

         screenwidth=screensize.width;
        screenheight=screensize.height;

        System.out.println("screenwidth="+screenwidth);
        System.out.println("screenheight="+screenheight);
        if(screenwidth<1024)
        {
            JOptionPane.showConfirmDialog(null, "Set Your Screen Resolution to 1024*768","Set Resolution",JOptionPane.OK_OPTION);
System.exit(0);
        }
        if(screenheight<720)
        {   JOptionPane.showConfirmDialog(null, "Set Your Screen Resolution to 1024*768","Set Resolution",JOptionPane.OK_OPTION);
         System.exit(0);
        }
//setSize(screenwidth,screenheight-30);
System.out.println(""+screenwidth);

    }

    public void setSession()
{
    //con= new com.duc.DatabaseConnection.DatabaseConnection().dataConnection();
       try
       {
           ps = con.prepareStatement("select * from sessionsetup where status=1");

           rs = ps.executeQuery();
           rs.next();
           String sessiontitle= rs.getString(1);
          // con.close();
           System.out.println("database closed");
           jLabel1.setText(sessiontitle);
           //

           //String sessiontitle=rs.getString(2);
}
       catch(Exception e)
       {

       }
}
    public void getHelpFile()
{
     try {
            Runtime rt = Runtime.getRuntime();

            Process pp=rt.exec(" rundll32 url.dll,FileProtocolHandler help.chm" );

        } catch (Exception ex) {
            ex.printStackTrace();
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

        jToolBar1 = new javax.swing.JToolBar();
        jButton6 = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        jButton3 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jButton2 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jButton7 = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        jButton9 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jLabel1 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenuItem29 = new javax.swing.JMenuItem();
        jMenuItem30 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();

        setClosable(true);
        setIconifiable(true);

        jToolBar1.setRollover(true);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.gif"))); // NOI18N
        jButton6.setToolTipText("Add Fresh Inventory"); // NOI18N
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);
        jToolBar1.add(jSeparator9);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.gif"))); // NOI18N
        jButton3.setToolTipText("Search"); // NOI18N
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);
        jToolBar1.add(jSeparator5);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ColorChooser.png"))); // NOI18N
        jButton2.setToolTipText("Deposit Existing Inventory"); // NOI18N
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);
        jToolBar1.add(jSeparator4);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_purchase.gif"))); // NOI18N
        jButton7.setToolTipText("WithDraw Inventory"); // NOI18N
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton7);
        jToolBar1.add(jSeparator10);

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
        jToolBar1.add(jSeparator2);

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jToolBar1.add(jLabel1);

        jDesktopPane1.setBackground(new java.awt.Color(0, 153, 153));

        jTextPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 0, 24));
        jTextPane1.setForeground(new java.awt.Color(0, 51, 51));
        jTextPane1.setText("                                                       InventoryPlus+"); // NOI18N
        jTextPane1.setAutoscrolls(false);
        jScrollPane1.setViewportView(jTextPane1);

        jMenu1.setText("Inventory"); // NOI18N
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Add  Fresh Inventory"); // NOI18N
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
        jMenu1.add(jMenuItem1);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Make Class Wise-General  Inventory Set"); // NOI18N
        jMenuItem4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem4MouseClicked(evt);
            }
        });
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Search Inventory"); // NOI18N
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem2MouseClicked(evt);
            }
        });
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem20.setText("Update Inventory Stock"); // NOI18N
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem20);

        jMenuItem21.setText("Sell Inventory"); // NOI18N
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem21);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setText("Exit"); // NOI18N
        jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem3MouseClicked(evt);
            }
        });
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Services"); // NOI18N

        jMenuItem6.setText("Return and Exchange"); // NOI18N
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuItem7.setText("School Used Products"); // NOI18N
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuItem25.setText("Make Zero Utility"); // NOI18N
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem25);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("View"); // NOI18N
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem24.setText("Inventory Opening balance"); // NOI18N
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem24);

        jMenuItem28.setText("Sold Inventory History"); // NOI18N
        jMenuItem28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem28ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem28);

        jMenuItem29.setText("Student Inventory Purchase Record"); // NOI18N
        jMenuItem29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem29ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem29);

        jMenuItem30.setText("Inventory Stock Update Record"); // NOI18N
        jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem30ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem30);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("Setup"); // NOI18N

        jMenuItem12.setText("Add Unit"); // NOI18N
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem12);

        jMenuItem13.setText("Add Mode"); // NOI18N
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem13);

        jMenuItem19.setText("Add Vendor/Publisher"); // NOI18N
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem19);

        jMenuItem17.setText("Add Purchasing Representatives"); // NOI18N
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem17);

        jMenuItem18.setText("Add Selling Representatives"); // NOI18N
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem18);

        jMenuItem23.setText("Inventory Categories"); // NOI18N
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem23);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 993, Short.MAX_VALUE)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 993, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 993, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
        // TODO add your handling code here:
}//GEN-LAST:event_jMenuItem1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // com.duc.SpecialDepartment.InventorySection.InventoryDepartment.AddFreshInventory.man();
        com.duc.SpecialDepartment.InventorySection.InventoryDepartment.AddFreshInventory1 r= new   com.duc.SpecialDepartment.InventorySection.InventoryDepartment.AddFreshInventory1();
        jDesktopPane1.add(r,0);
        r.setVisible(true);
}//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseClicked
        // TODO add your handling code here:
}//GEN-LAST:event_jMenuItem2MouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        //com.duc.SpecialDepartment.InventorySection.InventoryDepartment.search.InventorySearch.man();
        com.duc.SpecialDepartment.InventorySection.InventoryDepartment.search.InventorySearch1 r= new   com.duc.SpecialDepartment.InventorySection.InventoryDepartment.search.InventorySearch1();
        jDesktopPane1.add(r,0);
        r.setVisible(true);
        // TODO add your handling code here:
}//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        // com.duc.SpecialDepartment.InventorySection.InventoryDepartment.DepositInventory.man();
        com.duc.SpecialDepartment.InventorySection.InventoryDepartment.DepositInventory1 r= new   com.duc.SpecialDepartment.InventorySection.InventoryDepartment.DepositInventory1();
        jDesktopPane1.add(r,0);
        r.setVisible(true);
}//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        //com.duc.SpecialDepartment.InventorySection.InventoryDepartment.WithDrawal.man();
        com.duc.SpecialDepartment.InventorySection.InventoryDepartment.WithDrawal1 r= new   com.duc.SpecialDepartment.InventorySection.InventoryDepartment.WithDrawal1();
        jDesktopPane1.add(r,0);
        r.setVisible(true);
}//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem3MouseClicked
        // TODO add your handling code here:
}//GEN-LAST:event_jMenuItem3MouseClicked

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        System.exit(0);        // TODO add your handling code here:
}//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        //com.duc.SpecialDepartment.InventorySection.InventoryDepartment.WithDrawalHistory.man();
        com.duc.SpecialDepartment.InventorySection.InventoryDepartment.WithDrawalHistory1 r= new   com.duc.SpecialDepartment.InventorySection.InventoryDepartment.WithDrawalHistory1();
        jDesktopPane1.add(r,0);
        r.setVisible(true);
}//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        //com.duc.SpecialDepartment.InventorySection.ServiceDepartment.SchoolProductsMaintenance.man();
        com.duc.SpecialDepartment.InventorySection.ServiceDepartment.SchoolProductsMaintenance1 r= new   com.duc.SpecialDepartment.InventorySection.ServiceDepartment.SchoolProductsMaintenance1();
        jDesktopPane1.add(r,0);
        r.setVisible(true);
}//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
        //com.duc.SpecialDepartment.InventorySection.ServiceDepartment.MakeZeroInventory.man();
        com.duc.SpecialDepartment.InventorySection.ServiceDepartment.MakeZeroInventory1 r= new   com.duc.SpecialDepartment.InventorySection.ServiceDepartment.MakeZeroInventory1();
        jDesktopPane1.add(r,0);
        r.setVisible(true);
        // TODO add your handling code here:
}//GEN-LAST:event_jMenuItem25ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        //com.duc.SpecialDepartment.InventorySection.ViewDepartment.OpeningBalanceView.man();
        com.duc.SpecialDepartment.InventorySection.ViewDepartment.OpeningBalanceView1 r= new   com.duc.SpecialDepartment.InventorySection.ViewDepartment.OpeningBalanceView1();
        jDesktopPane1.add(r,0);
        r.setVisible(true);
}//GEN-LAST:event_jMenuItem24ActionPerformed

    private void jMenuItem28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem28ActionPerformed
        //com.duc.SpecialDepartment.InventorySection.ViewDepartment.SoldInventory.man();
        com.duc.SpecialDepartment.InventorySection.ViewDepartment.SoldInventory1 r= new   com.duc.SpecialDepartment.InventorySection.ViewDepartment.SoldInventory1();
        jDesktopPane1.add(r,0);
        r.setVisible(true);
}//GEN-LAST:event_jMenuItem28ActionPerformed

    private void jMenuItem29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem29ActionPerformed
        //com.duc.SpecialDepartment.InventorySection.InventoryDepartment.WithDrawalHistory.man();
        com.duc.SpecialDepartment.InventorySection.InventoryDepartment.WithDrawalHistory1 r= new   com.duc.SpecialDepartment.InventorySection.InventoryDepartment.WithDrawalHistory1();
        jDesktopPane1.add(r,0);
        r.setVisible(true); // TODO add your handling code here:
}//GEN-LAST:event_jMenuItem29ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        com.duc.SpecialDepartment.InventorySection.InventorySetupDepartment.UnitSetUp.man();        // TODO add your handling code here:
}//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        com.duc.SpecialDepartment.InventorySection.InventorySetupDepartment.ModeSetup.man();        // TODO add your handling code here:
}//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        com.duc.SpecialDepartment.InventorySection.InventorySetupDepartment.SellerSetup.man();   // TODO add your handling code here:
}//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        com.duc.SpecialDepartment.InventorySection.InventorySetupDepartment.AuthorizedPurchaser.man();        // TODO add your handling code here:
}//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        com.duc.SpecialDepartment.InventorySection.InventorySetupDepartment.AuthorizedSchoolSeller.man();    // TODO add your handling code here:
}//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        com.duc.SpecialDepartment.InventorySection.InventorySetupDepartment.InventoryCategorySetup.man();        // TODO add your handling code here:
}//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        //  com.duc.SpecialDepartment.InventorySection.InventoryDepartment.AddFreshInventory1.man();
        com.duc.SpecialDepartment.InventorySection.InventoryDepartment.AddFreshInventory1 r= new   com.duc.SpecialDepartment.InventorySection.InventoryDepartment.AddFreshInventory1();
        jDesktopPane1.add(r,0);
        r.setVisible(true);
}//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // com.duc.SpecialDepartment.InventorySection.InventoryDepartment.search.InventorySearch1.man();
        com.duc.SpecialDepartment.InventorySection.InventoryDepartment.search.InventorySearch1 r= new   com.duc.SpecialDepartment.InventorySection.InventoryDepartment.search.InventorySearch1();
        jDesktopPane1.add(r,0);
        r.setVisible(true);// TODO add your handling code here:
}//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // com.duc.SpecialDepartment.InventorySection.InventoryDepartment.DepositInventory1.man();
        com.duc.SpecialDepartment.InventorySection.InventoryDepartment.DepositInventory1 r= new   com.duc.SpecialDepartment.InventorySection.InventoryDepartment.DepositInventory1();
        jDesktopPane1.add(r,0);
        r.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        //com.duc.SpecialDepartment.InventorySection.InventoryDepartment.WithDrawal1.man();
        com.duc.SpecialDepartment.InventorySection.InventoryDepartment.WithDrawal1 r= new   com.duc.SpecialDepartment.InventorySection.InventoryDepartment.WithDrawal1();
        jDesktopPane1.add(r,0);
        r.setVisible(true);// TODO add your handling code here:
}//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        JOptionPane jp=new JOptionPane();
        int selection=JOptionPane.showConfirmDialog(null,"Exit Window","Shutdown the Window",JOptionPane.OK_CANCEL_OPTION );
        if(selection == JOptionPane.OK_OPTION)
            this.dispose();        // TODO add your handling code here:
}//GEN-LAST:event_jButton9ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
     
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuItem4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4MouseClicked

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        com.duc.SpecialDepartment.InventorySection.InventoryDepartment.ClassWiseInventory r= new   com.duc.SpecialDepartment.InventorySection.InventoryDepartment.ClassWiseInventory();
        jDesktopPane1.add(r,0);
        r.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem30ActionPerformed
        // TODO add your handling code here:
         com.duc.SpecialDepartment.InventorySection.InventoryDepartment.DepositOldHistory r= new   com.duc.SpecialDepartment.InventorySection.InventoryDepartment.DepositOldHistory();
        jDesktopPane1.add(r,0);
        r.setVisible(true);
    }//GEN-LAST:event_jMenuItem30ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
PreparedStatement ps;
ResultSet rs;
    public int screenheight,screenwidth;
}
