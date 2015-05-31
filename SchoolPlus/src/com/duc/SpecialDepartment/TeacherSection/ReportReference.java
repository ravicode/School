/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ReportReference.java
 *
 * Created on Oct 8, 2009, 4:06:29 PM
 */

package com.duc.SpecialDepartment.TeacherSection;
import javax.swing.JTable.PrintMode;
import java.text.MessageFormat;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.decorator.HighlighterFactory;
//import static com.duc.DatabaseConnection.DatabaseConnection.*;

/**
 *
 * @author sourabh
 */
public class ReportReference extends javax.swing.JInternalFrame {
private DefaultTableModel model;
    /** Creates new form ReportReference */
    public ReportReference() {
        initComponents();
        jTable1.setHorizontalScrollEnabled(true);
        jTable1.setHighlighters(HighlighterFactory.createAlternateStriping());
        model = (DefaultTableModel) jTable1.getModel();
        
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
        jTable1 = new org.jdesktop.swingx.JXTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setBackground(new java.awt.Color(0, 204, 204));
        setClosable(true);
        setIconifiable(true);
        setTitle("Staff Report Reference");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"General (1)", "Head Teacher (1)", "All (1)", "Pre Primary (1)", "Below Sec. (1)", "CC in Edu. (1)", "Below Sec. (1)", "Below Sec. (1)"},
                {"SC (2)", "Acting Head Teacher (2)", "Language (2)", "Primary (2)", "Sec. (2)", "B. Ed. (2)", "Sec. (2)", "Sec. (2)"},
                {"ST (3)", "Teacher (3)", "Math (3)", "Middle (3)", "Hr. Sec. (3)", "LT (3)", "Hr. Sec. (3)", "Hr. Sec. (3)"},
                {"OBC (4)", "ParaTeacher (4)", "Env. Studies (4)", "High School (4)", "Grad. (4)", "BT (4)", "Grad. (4)", "Grad. (4)"},
                {"Others (5)", "Part Time Teacher (5)", "Sports (5)", "Senior Secondary (5)", "P.G. (5)", "M. Ed. (5)", "P.G. (5)", "P.G. (5)"},
                {null, "Community Teacher (6)", "Music (6)", null, "M. Phil. (6)", "B.P. Ed.(6)", "M.Phil Or Phd (6)", "M.Phil Or Phd (6)"},
                {null, "Language Teacher (7)", "Science (7)", null, "Other (7)", "B. Lib.(7)", "Others (7)", "Others (7)"},
                {null, "Others (8)", "Arts/Craft (8)", null, null, "M. Lib.(8)", null, null},
                {null, "Master (9)", "Computer (9)", null, null, "Other (9)", null, null},
                {null, "Principal (10)", "Commerce(10)", null, null, "None (10)", null, null},
                {null, "Lecturer  (11)", "Economics(11)", null, null, null, null, null},
                {null, "VP(12)", "Accounts(12)", null, null, null, null, null},
                {null, "PGT(13)", "Humanities(13)", null, null, null, null, null},
                {null, "TGT(14)", null, null, null, null, null, null},
                {null, "Assistant Teacher(15)", null, null, null, null, null, null},
                {null, "Music Teacher(16)", null, null, null, null, null, null},
                {null, "PET(17)", null, null, null, null, null, null},
                {null, "Lab. Assistant(18)", null, null, null, null, null, null}
            },
            new String [] {
                "Caste", "Category", "Main Subject Taught", "Class Taught", "HQ Acd.", "HQ Prof.", "Maths Studied upto", "English Studied upto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnControlVisible(true);
        jTable1.setHorizontalScrollEnabled(true);
        jTable1.setRowHeight(25);
        jTable1.setSortable(false);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Print Chart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jTextPane1.setText("                                                                                                      Staff Report Refernces");
        jScrollPane2.setViewportView(jTextPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(706, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         try
        {
        String s="Staff Report References";
        MessageFormat header=new MessageFormat(s);
        jTable1.print(PrintMode.FIT_WIDTH, header, null);
        }

        catch(Exception e)
        {
         System.err.println("Error in printing staff report refernce");
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXTable jTable1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables

}