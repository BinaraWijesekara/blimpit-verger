/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

import com.toedter.calendar.JDateChooser;
import controller.ApiConnector;
import controller.Client;
import java.awt.Container;
import java.awt.GridLayout;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;
import org.json.simple.JSONObject;

/**
 *
 * @author binara
 */
public class UpdateLabSampling extends javax.swing.JFrame {

    String UserName;
    int Column;
    int Row;
    String LotNumber;
    String SampleNUmber;
    
    public UpdateLabSampling(String head,String name) {
        initComponents();
        
        this.UserName=name;
        LabelTitle.setText("Update "+head);
        TextField.setVisible(false);
        jDateChooser1.setVisible(false);
        if(head.equals("status") || head.equals("comment") || head.equals("Status") || head.equals("Comment"))
        {
            jDateChooser1.setVisible(false);
            TextField.setVisible(true);
        }
        else{
            jDateChooser1.setVisible(true);
            TextField.setVisible(false);
        }
    }
    
    
    public void getdata(String name, int column,int row, String lotnum, String samplenum) {
        
        this.Column = column;
        this.Row = row;
        this.LotNumber = lotnum;
        this.SampleNUmber = samplenum;
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelTitle = new javax.swing.JLabel();
        LabelPassword = new javax.swing.JLabel();
        LabelValue1 = new javax.swing.JLabel();
        Label_Verification = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        ButtonSubmit = new javax.swing.JButton();
        ButtonCancel = new javax.swing.JButton();
        TextField = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        LabelTitle.setFont(new java.awt.Font("Manjari Bold", 0, 14)); // NOI18N

        LabelPassword.setText("Password");

        LabelValue1.setText(" Value to be Edited :");

        Label_Verification.setFont(new java.awt.Font("Manjari Regular", 0, 8)); // NOI18N
        Label_Verification.setForeground(new java.awt.Color(204, 0, 0));

        ButtonSubmit.setText("Submit");
        ButtonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSubmitActionPerformed(evt);
            }
        });

        ButtonCancel.setText("Cancel");
        ButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelActionPerformed(evt);
            }
        });

        jDateChooser1.setDateFormatString("yyyy/MM/dd");
        jDateChooser1.setPreferredSize(new java.awt.Dimension(14, 23));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(168, 168, 168)
                                .addComponent(LabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(LabelValue1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(LabelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(89, 89, 89)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addComponent(ButtonSubmit)
                                .addGap(87, 87, 87)
                                .addComponent(ButtonCancel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Label_Verification, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)))
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(LabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(Label_Verification, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelValue1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButtonSubmit)
                            .addComponent(ButtonCancel)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSubmitActionPerformed

                   
                JSONObject jsonObject = new JSONObject();
                Client client = new Client();
                try {
               jsonObject.put("username",UserName);
               jsonObject.put("password",client.encrypt(jPasswordField1.getText()));

//                jsonObject.put("username","admin");
//                jsonObject.put("password",client.encrypt("admin"));
               
          } catch (UnsupportedEncodingException ex) {
             Logger.getLogger(LabrotarySampeling.class.getName()).log(Level.SEVERE, null, ex);

          }
          ApiConnector apiConnector = new ApiConnector();
        String getLogin =  apiConnector.post("http://localhost:8080/api/usrmgtservice/login",jsonObject);
        
                if(getLogin.equals("Login Success\r")){
                    int dialogResult = JOptionPane.showConfirmDialog (null, "Please confrim your edit with Password","Warning",JOptionPane.YES_NO_OPTION);
                    if(dialogResult == JOptionPane.YES_OPTION){
                    if(Column==9){
                        LabelTitle.setText("Update Status");
                        String value = TextField.getText().toString();                        
                        JSONObject jObject = new JSONObject();
                        jObject.put("lotNumber",LotNumber);
                        jObject.put("status",value);
                        
                        System.out.println("Lot Number = "+LotNumber);
                        System.out.println("Status = "+value);

                        apiConnector.put("http://localhost:8080/api/LabSampling/updateLabSample/",jObject);
                        System.out.println(jObject);
                        LabrotarySampeling labSample =  new LabrotarySampeling(UserName);
                        labSample.setVisible(true);
                        this.dispose();
                    }
                    else if(Column==10){
                        LabelTitle.setText("Update Comment");
                        String value = TextField.getText().toString();                        
                        JSONObject jObject = new JSONObject();
                        jObject.put("lotNumber",LotNumber);
                        jObject.put("comment",value);
                        
                        System.out.println("Lot Number = "+LotNumber);
                        System.out.println("Comment = "+value);

                        apiConnector.put("http://localhost:8080/api/LabSampling/updateLabSample/",jObject);
                        System.out.println(jObject);
                        LabrotarySampeling labSample =  new LabrotarySampeling(UserName);
                        labSample.setVisible(true);
                        this.dispose();
                    }else if(Column == 11){
                        Date x = jDateChooser1.getDate();
                        String ShipmentDate = String.format("%1$ty/%1$tm/%1$td", x);                       
                        JSONObject jObject = new JSONObject();
                        jObject.put("lotNumber",LotNumber);
                        jObject.put("shipmentDate",ShipmentDate);
                        
                        System.out.println("Lot Number = "+LotNumber);
                        System.out.println("Comment = "+ShipmentDate);

                        apiConnector.put("http://localhost:8080/api/LabSampling/updateLabSample/",jObject);
                        System.out.println(jObject);
                        LabrotarySampeling labSample =  new LabrotarySampeling(UserName);
                        labSample.setVisible(true);
                        this.dispose();
                    }
                    
                    }
                }
                else{
                    Label_Verification.setText(getLogin);
                    TextField.setText("");
                    jPasswordField1.setText("");
                }
            
    }//GEN-LAST:event_ButtonSubmitActionPerformed

    private void ButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelActionPerformed
        LabrotarySampeling labSample = new LabrotarySampeling("");
        labSample.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ButtonCancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdateLabSampling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateLabSampling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateLabSampling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateLabSampling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateLabSampling("","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCancel;
    private javax.swing.JButton ButtonSubmit;
    private javax.swing.JLabel LabelPassword;
    private javax.swing.JLabel LabelTitle;
    private javax.swing.JLabel LabelValue1;
    private javax.swing.JLabel Label_Verification;
    private javax.swing.JTextField TextField;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jPasswordField1;
    // End of variables declaration//GEN-END:variables
}