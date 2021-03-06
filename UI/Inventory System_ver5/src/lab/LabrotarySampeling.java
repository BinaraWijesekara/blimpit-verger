/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

import com.toedter.calendar.JDateChooser;
import gui.VergerMain;
import java.time.LocalDate;
import javax.swing.ImageIcon;
import javax.swing.JTable;

import java.util.Vector;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tharusha
 */
public class LabrotarySampeling extends javax.swing.JFrame {

    static String lf = "com.jtattoo.plaf.mcwin.McWinLookAndFeel";

    JComboBox<String> customer = new JComboBox<String>();

    /**
     * Creates new form Inventory
     */
    public LabrotarySampeling() {
        lookandfeels();
        initComponents();
        ImageIcon icon = new ImageIcon("Image/icon2.png");
        setIconImage(icon.getImage());
        shipDate.setDateFormatString("yyyy/MM/dd");

    }

    JDateChooser shipDate = new JDateChooser();

    public void getData(String customer, String product, String type, String sampleSize, String ifLot, String lotNumber, String sampnumber, String formuref,
            String status, String comment, String shipmentdate, String documents) {

        DefaultTableModel model = (DefaultTableModel) tabLab.getModel();
        Vector row = new Vector();

        LocalDate date = LocalDate.now();

        //System.out.println(dt1.format(date));
        row.add(0, false);
        row.add(1, date.toString());
        row.add(2, customer);
        row.add(3, product);
        row.add(4, type);
        row.add(5, sampleSize);
        row.add(6, ifLot);
        row.add(7, lotNumber);
        row.add(8, sampleSize);
        row.add(9, formuref);
        row.add(10, status);
        row.add(11, comment);
        row.add(12, shipmentdate);
        row.add(13, documents);

        model.addRow(row);

    }

    /**
     *
     */
    private static void lookandfeels() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
                javax.swing.UIManager.setLookAndFeel(lf);
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VergerMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VergerMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VergerMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VergerMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabLab = new javax.swing.JTable();
        btnadd = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnprint = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Laboratory Sampling Platform ");

        tabLab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "2017/12/20", "Customer A", "Oilment", "A", "200", "IfLot-1", "1701OILP001", "OIL1701001", "Sap-Oil-1712", "Pending", "Good", "2018/01/02", "Attached"},
                {null, "2017/12/30", "Custermer B", "Cream", "C", "100", "IfLot-2", "1705CERP003", "CER1704005", "Sap-Cer-1701", "Pending", "Bad", "2018/02/10", "Attached"},
                {null, "2018/01/20", "Customer C", "Natural Oil", "D", "50", "If-Lot-3", "1706NATP004", "NAT1702007", "Sap-Nat-1705", "Complete", "Excelent", "2018/02/11", "Attached"},
                {null, "2018/02/30", "Customer D", "Purfume", "E", "250", "If-Lot-4", "1712PURP005", "PUR171040", "Sap-Pur-1706", "Complete", "Medium", "2018/03/10", "Attached"}
            },
            new String [] {
                "", "Date", "Customer ", "Product ", "Type", "Sample size ", "If Lot", "Lot Number", "Sample Number", "Formulation Ref", "Status", "Comment", "Shipment Date", "Documents"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabLab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabLabMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabLab);
        if (tabLab.getColumnModel().getColumnCount() > 0) {
            tabLab.getColumnModel().getColumn(0).setMinWidth(1);
            tabLab.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        btnadd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnadd.setText("Add New Entry");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Powerd By");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Blimp_50x.png"))); // NOI18N
        jLabel13.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addGap(0, 0, 0)
                .addComponent(jLabel13))
        );

        btnprint.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnprint.setText("Print");
        btnprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprintActionPerformed(evt);
            }
        });

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lab/Left_20px.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1187, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnadd)
                        .addGap(60, 60, 60)
                        .addComponent(btnprint, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnprint, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1223, 593));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed

        //JOptionPane.showMessageDialog(null, "hi");
        ///ADD the required Code here
        AddLabSamples addSapmle = new AddLabSamples();

        addSapmle.setVisible(true);
        this.dispose();


    }//GEN-LAST:event_btnaddActionPerformed

    private void tabLabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabLabMouseClicked

        DefaultTableModel model = (DefaultTableModel) tabLab.getModel();
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        int colum = source.columnAtPoint(evt.getPoint());

        if (colum == 8) {
            JPasswordField pswField = new JPasswordField(15);
            JTextField valueField = new JTextField(15);

            JPanel myPanel = new JPanel();
            myPanel.add(new JLabel("Username"));
            myPanel.add(valueField);
            myPanel.add(Box.createVerticalStrut(20));
            myPanel.add(new JLabel("Password :"));
            myPanel.add(pswField);

            int result = JOptionPane.showConfirmDialog(null, myPanel,
                    "Please Confirm with Username and Password", JOptionPane.OK_CANCEL_OPTION);

            if (pswField.getText().equals("admin")) {
                //Opense the folder    TODO
            }

        } else if (model.isCellEditable(row, colum) && (colum != 0)) {
            //JTextField valueField = new JTextField(25);
            JPasswordField pswField = new JPasswordField(15);
            JDateChooser shipDate = new JDateChooser();
            shipDate.setDateFormatString("yyyy/MM/dd");

            JPanel myPanel = new JPanel();
            myPanel.add(new JLabel("Change the Shipment Date :"));
            myPanel.add(shipDate);
            myPanel.add(Box.createVerticalStrut(20));
            myPanel.add(new JLabel("Password :"));
            myPanel.add(pswField);

            int result = JOptionPane.showConfirmDialog(null, myPanel,
                    "Pls confrim your edit with Password", JOptionPane.OK_CANCEL_OPTION);
            if (result == 0) {
                if (pswField.getText().equals("admin")) {

                    model.setValueAt(shipDate.getDate(), row, colum);

                } else {
                    JOptionPane.showMessageDialog(null, result);
                }

            }
        }

    }//GEN-LAST:event_tabLabMouseClicked


    private void btnprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprintActionPerformed

        JOptionPane.showMessageDialog(null, "Data Sen to the printing");

    }//GEN-LAST:event_btnprintActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        VergerMain vm = new VergerMain("admin");
        vm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        lookandfeels();
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LabrotarySampeling().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnprint;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabLab;
    // End of variables declaration//GEN-END:variables

    private void fireTableCellUpdated(int row, int col) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
