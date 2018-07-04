/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

import controller.ApiConnector;
import gui.Login;
import gui.VergerMain;
import javax.swing.ImageIcon;

import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import user.UserManager;

/**
 *
 * @author Tharusha
 */
public class QCPlatform extends javax.swing.JFrame {

    static String lf = "com.jtattoo.plaf.mcwin.McWinLookAndFeel";
    String username;

    /**
     * Creates new form Inventory
     */
    public QCPlatform(String name) {
        lookandfeels();
        initComponents();
        loadQC_Data();
        loadProductID();
        ImageIcon icon = new ImageIcon("Image/icon2.png");
        setIconImage(icon.getImage());
        username = name;
        
    }
    
    private  void loadQC_Data(){
        ApiConnector apiConnector = new ApiConnector();
        String get =apiConnector.get("http://localhost:8080/api/qcplatform/getqcdata/");
        
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = null;
        
        int arrayLength = 0;
        Vector row;

        try {
            jsonArray = (JSONArray) parser.parse(get);
            arrayLength = jsonArray.size();
            JSONObject jsonobj = new JSONObject();
            DefaultTableModel model = (DefaultTableModel) tabqc.getModel();

            for (int i = 0; i < arrayLength; i++) {
                row = new Vector();
                jsonobj = (JSONObject) jsonArray.get(i);
                                                
                row.add(0, jsonobj.get("name").toString());
  //              row.add(1, jsonobj.get("product_id").toString());
                row.add(1, jsonobj.get("supplier_id").toString());
                row.add(2, jsonobj.get("type").toString());
                row.add(3, jsonobj.get("details").toString());
                row.add(4, jsonobj.get("or_ri").toString());
                row.add(5, jsonobj.get("gc_1").toString());
                row.add(6, jsonobj.get("gc_2").toString());
                row.add(7, jsonobj.get("status").toString());
                row.add(8, jsonobj.get("comment").toString());
                row.add(9,jsonobj.get("usedfor").toString());
                row.add(10,"ABC");
                row.add(11,jsonobj.get("id").toString());

                model.addRow(row);

            }

        } catch (ParseException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadProductID(){
        ApiConnector apiConnector = new ApiConnector();
        String get = apiConnector.get("http://localhost:8080/api/qcplatform/proid");
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = null;
        int arrayLength = 0;
        
        try{
            jsonArray = (JSONArray) parser.parse(get);
            arrayLength = jsonArray.size();
            JSONObject jsonObject = new JSONObject();
            
            for( int i = 0 ; i < arrayLength ; i++){
                jsonObject = (JSONObject) jsonArray.get(i);
                jComboBox1.addItem(jsonObject.get("name").toString());
                
            }
            
        }catch(ParseException ex){
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    
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
        tabqc = new javax.swing.JTable();
        btnaddProd = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnprint = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("QC Platform");

        tabqc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Supplier", "Type", "Details", "OR/RI OGLPT", "GC-1", "GC-2", "Status", "Comment", "Used for", "Documents", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabqc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabqcMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabqc);
        if (tabqc.getColumnModel().getColumnCount() > 0) {
            tabqc.getColumnModel().getColumn(0).setMinWidth(1);
            tabqc.getColumnModel().getColumn(0).setPreferredWidth(1);
        }

        btnaddProd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnaddProd.setText("Add New Entry");
        btnaddProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddProdActionPerformed(evt);
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

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select All" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lab/Left_20px.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1153, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(286, 286, 286)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(jButton1)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 674, Short.MAX_VALUE)
                        .addComponent(btnaddProd)
                        .addGap(255, 255, 255)
                        .addComponent(btnprint, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnaddProd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnprint, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
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

    private void btnaddProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddProdActionPerformed
        
        String productID= jComboBox1.getSelectedItem().toString();
        AddProductsQC addpro = new AddProductsQC();
        addpro.getProductID(productID);
        addpro.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnaddProdActionPerformed

    private void tabqcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabqcMouseClicked

        
        ApiConnector apiconnector = new ApiConnector();
        String get = apiconnector.get("http://localhost:8080/api/usrmgtservice/getpassword/"+username);
        
        JSONParser parser = new JSONParser();
        String Password="";
       
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject = (JSONObject) parser.parse(get);
            Password = jsonObject.get("password").toString();
            System.out.println("Password of JSONObject is "+Password);
                
        } catch (ParseException ex) {
            Logger.getLogger(AddProductsQC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DefaultTableModel model = (DefaultTableModel) tabqc.getModel();
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        int colum = source.columnAtPoint(evt.getPoint());
        String key = model.getValueAt(row,11).toString();

        if (model.isCellEditable(row, colum)&&(colum!=0)) {
            JTextField valueField = new JTextField(25);
            JPasswordField pswField = new JPasswordField(25);

            JPanel myPanel = new JPanel();
            myPanel.add(new JLabel("Value to be Edited :"));
            myPanel.add(valueField);
            myPanel.add(Box.createVerticalStrut(20));
            myPanel.add(new JLabel("Password :"));
            myPanel.add(pswField);

            int result = JOptionPane.showConfirmDialog(null, myPanel,
                    "Pls confrim your edit with Password", JOptionPane.OK_CANCEL_OPTION);
            if (result == 0) {
                if (pswField.getText().equals(Password)) {
                    
                    model.setValueAt(valueField.getText(), row, colum);
                    
                }else{
                    JOptionPane.showMessageDialog(null, result);
                }

            }
        }


    }//GEN-LAST:event_tabqcMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        VergerMain vm = new VergerMain("admin");
        vm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprintActionPerformed

        JOptionPane.showMessageDialog(null, "Send to printing ");
        
//        ViewProductsQC viewQC = new ViewProductsQC();
//        viewQC.setVisible(true);
//        this.dispose();

    }//GEN-LAST:event_btnprintActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        
        
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        String selectedItem = jComboBox1.getSelectedItem().toString();
        System.out.println("Selected Item = "+selectedItem);
        
        if(selectedItem.equals("Select All")){
            DefaultTableModel model = new DefaultTableModel();
            model.setNumRows(0);
            loadQC_Data();
        }
        else{
        ApiConnector apiConnector = new ApiConnector();
        String get =apiConnector.get("http://localhost:8080/api/qcplatform/searchbyid/"+selectedItem);
        
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = null;
        
        int arrayLength = 0;
        Vector row;

        try {
            jsonArray = (JSONArray) parser.parse(get);
            System.out.println("jsonAyya = "+jsonArray);
            arrayLength = jsonArray.size();
            JSONObject jsonobj = new JSONObject();
            DefaultTableModel model = (DefaultTableModel) tabqc.getModel();
            model.setRowCount(0);

            for (int i = 0; i < arrayLength; i++) {
                row = new Vector();
                jsonobj = (JSONObject) jsonArray.get(i);
                                                
                row.add(0, jsonobj.get("name").toString());
  //              row.add(1, jsonobj.get("product_id").toString());
                row.add(1, jsonobj.get("supplier_id").toString());
                row.add(2, jsonobj.get("type").toString());
                row.add(3, jsonobj.get("details").toString());
                row.add(4, jsonobj.get("or_ri").toString());
                row.add(5, jsonobj.get("gc_1").toString());
                row.add(6, jsonobj.get("gc_2").toString());
                row.add(7, jsonobj.get("status").toString());
                row.add(8, jsonobj.get("comment").toString());
                row.add(9,jsonobj.get("usedfor").toString());
                row.add(10,"ABC");
                row.add(11,jsonobj.get("id").toString());

                model.addRow(row);

            }

        } catch (ParseException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.println("nnnnnnnn "+username);
    }//GEN-LAST:event_jButton1ActionPerformed

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
                new QCPlatform("User").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnaddProd;
    private javax.swing.JButton btnprint;
    private javax.swing.JButton jButton1;
    public javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabqc;
    // End of variables declaration//GEN-END:variables
}
