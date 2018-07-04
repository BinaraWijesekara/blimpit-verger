/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package production;

import controller.ApiConnector;
import controller.Client;
import gui.VergerMain;
import java.awt.TextArea;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Tharusha
 */
public class Production extends javax.swing.JFrame {

    static String lf = "com.jtattoo.plaf.mcwin.McWinLookAndFeel";
    String day1="",day2="",day3="",day4="",day5="",day6="",day7="",day8="",day9="",day10="",day11="",day12="",day13="",day14="",day15="",day16="",day17="",day18="",day19="",day20="",day21="",day22="",day23="",day24="",day25="",day26="",day27="",day28="",day29="",day30="",day31="";
    int numDays;
    
    public Production() {
        lookandfeels();
        initComponents();
        ImageIcon icon = new ImageIcon("Image/icon2.png");
        setIconImage(icon.getImage());
        loadTextArea();
        loadData();
        

    }

    public void loadTextArea(){
        
        int year = YearChooser.getYear();
        int month = MonthChooser.getMonth();
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        numDays = calendar.getActualMaximum(Calendar.DATE);
        
        if(numDays==30){
            TextArea31.setVisible(false);
        }
        else if(numDays==28){
            TextArea29.setVisible(false);
            TextArea30.setVisible(false);
            TextArea31.setVisible(false);
        }
        else if(numDays==29){
            TextArea30.setVisible(false);
            TextArea31.setVisible(false);
        }
        else{
            TextArea29.setVisible(true);
            TextArea30.setVisible(true);
            TextArea31.setVisible(true);
        }
    }
    
    public void loadData(){
        int year = YearChooser.getYear();
        int month = MonthChooser.getMonth();
        
        ApiConnector apiConnector = new ApiConnector();
        String get =apiConnector.get("http://localhost:8080/api/production/getProductionActivities/"+year+"/"+month);
        
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = null;
        
        
        int arrayLength = 0;
        JTextArea[] TextArea = {TextArea1,TextArea2,TextArea3,TextArea4,TextArea5,TextArea6,TextArea7,TextArea8,TextArea9,TextArea10,TextArea11,TextArea12,TextArea13,TextArea14,TextArea15,TextArea16,TextArea17,TextArea18,TextArea19,TextArea20,TextArea21,TextArea22,TextArea23,TextArea24,TextArea25,TextArea26,TextArea27,TextArea28,TextArea29,TextArea30,TextArea31};
        
        try {
            jsonArray = (JSONArray) parser.parse(get);
            arrayLength = jsonArray.size();
            JSONObject jsonobj = new JSONObject();
            
            for (int i = 0; i < arrayLength; i++) {
                jsonobj = (JSONObject) jsonArray.get(i);
                                                
                int Year = Integer.parseInt(jsonobj.get("year").toString());
                int Month = Integer.parseInt(jsonobj.get("month").toString());
                int Day = Integer.parseInt(jsonobj.get("day").toString());
                String val = jsonobj.get("activity").toString();
                TextArea[Day-1].setText(val);
             }
           

        } catch (ParseException ex) {
            Logger.getLogger(Production.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        MonthChooser = new com.toedter.calendar.JMonthChooser();
        YearChooser = new com.toedter.calendar.JYearChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextArea4 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        TextArea1 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        TextArea2 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        TextArea3 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        TextArea8 = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        TextArea5 = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        TextArea6 = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        TextArea7 = new javax.swing.JTextArea();
        jScrollPane10 = new javax.swing.JScrollPane();
        TextArea10 = new javax.swing.JTextArea();
        jScrollPane11 = new javax.swing.JScrollPane();
        TextArea12 = new javax.swing.JTextArea();
        jScrollPane12 = new javax.swing.JScrollPane();
        TextArea9 = new javax.swing.JTextArea();
        jScrollPane13 = new javax.swing.JScrollPane();
        TextArea11 = new javax.swing.JTextArea();
        jScrollPane14 = new javax.swing.JScrollPane();
        TextArea16 = new javax.swing.JTextArea();
        jScrollPane15 = new javax.swing.JScrollPane();
        TextArea15 = new javax.swing.JTextArea();
        jScrollPane16 = new javax.swing.JScrollPane();
        TextArea13 = new javax.swing.JTextArea();
        jScrollPane17 = new javax.swing.JScrollPane();
        TextArea14 = new javax.swing.JTextArea();
        jScrollPane18 = new javax.swing.JScrollPane();
        TextArea19 = new javax.swing.JTextArea();
        jScrollPane19 = new javax.swing.JScrollPane();
        TextArea17 = new javax.swing.JTextArea();
        jScrollPane20 = new javax.swing.JScrollPane();
        TextArea18 = new javax.swing.JTextArea();
        jScrollPane21 = new javax.swing.JScrollPane();
        TextArea20 = new javax.swing.JTextArea();
        jScrollPane22 = new javax.swing.JScrollPane();
        TextArea23 = new javax.swing.JTextArea();
        jScrollPane23 = new javax.swing.JScrollPane();
        TextArea21 = new javax.swing.JTextArea();
        jScrollPane24 = new javax.swing.JScrollPane();
        TextArea22 = new javax.swing.JTextArea();
        jScrollPane25 = new javax.swing.JScrollPane();
        TextArea24 = new javax.swing.JTextArea();
        jScrollPane26 = new javax.swing.JScrollPane();
        TextArea27 = new javax.swing.JTextArea();
        jScrollPane27 = new javax.swing.JScrollPane();
        TextArea25 = new javax.swing.JTextArea();
        jScrollPane28 = new javax.swing.JScrollPane();
        TextArea26 = new javax.swing.JTextArea();
        jScrollPane29 = new javax.swing.JScrollPane();
        TextArea28 = new javax.swing.JTextArea();
        jScrollPane30 = new javax.swing.JScrollPane();
        TextArea31 = new javax.swing.JTextArea();
        jScrollPane31 = new javax.swing.JScrollPane();
        TextArea29 = new javax.swing.JTextArea();
        jScrollPane32 = new javax.swing.JScrollPane();
        TextArea30 = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Production");
        setPreferredSize(new java.awt.Dimension(1000, 500));

        jLabel1.setFont(new java.awt.Font("Manjari Regular", 1, 18)); // NOI18N
        jLabel1.setText("Production");

        MonthChooser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        MonthChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                MonthChooserPropertyChange(evt);
            }
        });

        YearChooser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        TextArea4.setColumns(20);
        TextArea4.setRows(5);
        TextArea4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "4", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jScrollPane2.setViewportView(TextArea4);

        TextArea1.setColumns(20);
        TextArea1.setRows(5);
        TextArea1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        TextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextArea1KeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(TextArea1);

        TextArea2.setColumns(20);
        TextArea2.setRows(5);
        TextArea2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        TextArea2.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                TextArea2ComponentAdded(evt);
            }
        });
        jScrollPane4.setViewportView(TextArea2);

        TextArea3.setColumns(20);
        TextArea3.setRows(5);
        TextArea3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "3", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jScrollPane5.setViewportView(TextArea3);

        TextArea8.setColumns(20);
        TextArea8.setRows(5);
        TextArea8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "8", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jScrollPane6.setViewportView(TextArea8);

        TextArea5.setColumns(20);
        TextArea5.setRows(5);
        TextArea5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "5", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jScrollPane7.setViewportView(TextArea5);

        TextArea6.setColumns(20);
        TextArea6.setRows(5);
        TextArea6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "6", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jScrollPane8.setViewportView(TextArea6);

        TextArea7.setColumns(20);
        TextArea7.setRows(5);
        TextArea7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "7", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jScrollPane9.setViewportView(TextArea7);

        TextArea10.setColumns(20);
        TextArea10.setRows(5);
        TextArea10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "10", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jScrollPane10.setViewportView(TextArea10);

        TextArea12.setColumns(20);
        TextArea12.setRows(5);
        TextArea12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "12", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jScrollPane11.setViewportView(TextArea12);

        TextArea9.setColumns(20);
        TextArea9.setRows(5);
        TextArea9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "9", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jScrollPane12.setViewportView(TextArea9);

        TextArea11.setColumns(20);
        TextArea11.setRows(5);
        TextArea11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "11", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jScrollPane13.setViewportView(TextArea11);

        TextArea16.setColumns(20);
        TextArea16.setRows(5);
        TextArea16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "16", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jScrollPane14.setViewportView(TextArea16);

        TextArea15.setColumns(20);
        TextArea15.setRows(5);
        TextArea15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "15", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jScrollPane15.setViewportView(TextArea15);

        TextArea13.setColumns(20);
        TextArea13.setRows(5);
        TextArea13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "13", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jScrollPane16.setViewportView(TextArea13);

        TextArea14.setColumns(20);
        TextArea14.setRows(5);
        TextArea14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "14", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jScrollPane17.setViewportView(TextArea14);

        TextArea19.setColumns(20);
        TextArea19.setRows(5);
        TextArea19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "19", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jScrollPane18.setViewportView(TextArea19);

        TextArea17.setColumns(20);
        TextArea17.setRows(5);
        TextArea17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "17", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jScrollPane19.setViewportView(TextArea17);

        TextArea18.setColumns(20);
        TextArea18.setRows(5);
        TextArea18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "18", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jScrollPane20.setViewportView(TextArea18);

        TextArea20.setColumns(20);
        TextArea20.setRows(5);
        TextArea20.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "20", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jScrollPane21.setViewportView(TextArea20);

        TextArea23.setColumns(20);
        TextArea23.setRows(5);
        TextArea23.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "23", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jScrollPane22.setViewportView(TextArea23);

        TextArea21.setColumns(20);
        TextArea21.setRows(5);
        TextArea21.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "21", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jScrollPane23.setViewportView(TextArea21);

        TextArea22.setColumns(20);
        TextArea22.setRows(5);
        TextArea22.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "22", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jScrollPane24.setViewportView(TextArea22);

        TextArea24.setColumns(20);
        TextArea24.setRows(5);
        TextArea24.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "24", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jScrollPane25.setViewportView(TextArea24);

        TextArea27.setColumns(20);
        TextArea27.setRows(5);
        TextArea27.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "27", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jScrollPane26.setViewportView(TextArea27);

        TextArea25.setColumns(20);
        TextArea25.setRows(5);
        TextArea25.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "25", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jScrollPane27.setViewportView(TextArea25);

        TextArea26.setColumns(20);
        TextArea26.setRows(5);
        TextArea26.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "26", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jScrollPane28.setViewportView(TextArea26);

        TextArea28.setColumns(20);
        TextArea28.setRows(5);
        TextArea28.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "28", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jScrollPane29.setViewportView(TextArea28);

        TextArea31.setColumns(20);
        TextArea31.setRows(5);
        TextArea31.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "31", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jScrollPane30.setViewportView(TextArea31);

        TextArea29.setColumns(20);
        TextArea29.setRows(5);
        TextArea29.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "29", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jScrollPane31.setViewportView(TextArea29);

        TextArea30.setColumns(20);
        TextArea30.setRows(5);
        TextArea30.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "30", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jScrollPane32.setViewportView(TextArea30);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(314, 314, 314))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Powerd By");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Blimp_50x.png"))); // NOI18N
        jLabel13.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(25, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(YearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(MonthChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(303, 303, 303)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(164, 164, 164)
                                .addComponent(jButton1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(YearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MonthChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel13))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(16, 16, 16))
        );

        setSize(new java.awt.Dimension(1328, 755));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TextArea1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextArea1KeyReleased
       
    }//GEN-LAST:event_TextArea1KeyReleased

    private void MonthChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_MonthChooserPropertyChange

        loadData();
        int year = YearChooser.getYear();
        int month = MonthChooser.getMonth();
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        int numDays = calendar.getActualMaximum(Calendar.DATE);
        
        if(numDays==30){
            TextArea31.setVisible(false);
        }
        else if(numDays==28){
            TextArea29.setVisible(false);
            TextArea30.setVisible(false);
            TextArea31.setVisible(false);
        }
        else if(numDays==29){
            TextArea30.setVisible(false);
            TextArea31.setVisible(false);
        }
        else{
            TextArea29.setVisible(true);
            TextArea30.setVisible(true);
            TextArea31.setVisible(true);
        }
        
    }//GEN-LAST:event_MonthChooserPropertyChange

    private void TextArea2ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_TextArea2ComponentAdded
 
    }//GEN-LAST:event_TextArea2ComponentAdded

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         int year = YearChooser.getYear();
        int month = MonthChooser.getMonth();
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        Client client = new Client();
        
        JTextArea[] TextArea = {TextArea1,TextArea2,TextArea3,TextArea4,TextArea5,TextArea6,TextArea7,TextArea8,TextArea9,TextArea10,TextArea11,TextArea12,TextArea13,TextArea14,TextArea15,TextArea16,TextArea17,TextArea18,TextArea19,TextArea20,TextArea21,TextArea22,TextArea23,TextArea24,TextArea25,TextArea26,TextArea27,TextArea28,TextArea29,TextArea30,TextArea31};
        String[] day = {day1,day2,day3,day4,day5,day6,day7,day8,day9,day10,day11,day12,day13,day14,day15,day16,day17,day18,day19,day20,day21,day22,day23,day24,day25,day26,day27,day28,day29,day30,day31};
        System.out.println("numDays = "+numDays);
        for ( int i = 0 ; i < 31 ; i++){
            if(TextArea[i].getText().isEmpty()){
                //Do Noyhing
            }else{
            day[i] = TextArea[i].getText();
            jsonObject.put("day",i+1);
            jsonObject.put("year", year);
            jsonObject.put("month",month);
            jsonObject.put("activity",day[i]);
            
            System.out.println("jObject is "+jsonObject);
            
            client.sendData("http://localhost:8080/api/production/addProductionActivity", jsonObject);
            
            }
        }
       
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
                new Production().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JMonthChooser MonthChooser;
    private javax.swing.JTextArea TextArea1;
    private javax.swing.JTextArea TextArea10;
    private javax.swing.JTextArea TextArea11;
    private javax.swing.JTextArea TextArea12;
    private javax.swing.JTextArea TextArea13;
    private javax.swing.JTextArea TextArea14;
    private javax.swing.JTextArea TextArea15;
    private javax.swing.JTextArea TextArea16;
    private javax.swing.JTextArea TextArea17;
    private javax.swing.JTextArea TextArea18;
    private javax.swing.JTextArea TextArea19;
    private javax.swing.JTextArea TextArea2;
    private javax.swing.JTextArea TextArea20;
    private javax.swing.JTextArea TextArea21;
    private javax.swing.JTextArea TextArea22;
    private javax.swing.JTextArea TextArea23;
    private javax.swing.JTextArea TextArea24;
    private javax.swing.JTextArea TextArea25;
    private javax.swing.JTextArea TextArea26;
    private javax.swing.JTextArea TextArea27;
    private javax.swing.JTextArea TextArea28;
    private javax.swing.JTextArea TextArea29;
    private javax.swing.JTextArea TextArea3;
    private javax.swing.JTextArea TextArea30;
    private javax.swing.JTextArea TextArea31;
    private javax.swing.JTextArea TextArea4;
    private javax.swing.JTextArea TextArea5;
    private javax.swing.JTextArea TextArea6;
    private javax.swing.JTextArea TextArea7;
    private javax.swing.JTextArea TextArea8;
    private javax.swing.JTextArea TextArea9;
    private com.toedter.calendar.JYearChooser YearChooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JScrollPane jScrollPane31;
    private javax.swing.JScrollPane jScrollPane32;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    // End of variables declaration//GEN-END:variables
}
