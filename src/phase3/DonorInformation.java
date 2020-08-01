/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phase3;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author user
 */
public class DonorInformation extends javax.swing.JFrame {
    Connection myConn;
    Statement myStat;
    //int countDonor = 0;
    //Donor[] donor = new Donor[20];
    int cmpID;
    /**
     * Creates new form SummaryReport
     */
    public DonorInformation() {
        initComponents();
    }
    
    public DonorInformation(int id) {
        initComponents();
        Toolkit toolkit = getToolkit(); //center jFrame
        Dimension size = toolkit.getScreenSize(); //center jFrame
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2); //center jFrame
        this.cmpID = id;
        txtDonorGuestCampaignID.setText(String.valueOf(cmpID));
        txtDonorGuestCampaignID.setEditable(false);
        displayTable();
    }

    
    public void displayTable(){ //display all donor info based on campaign id
        ArrayList<Donor> donorlist = new ArrayList<>();
        String id = txtDonorGuestCampaignID.getText();
        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/phase3", "root", "");
            myStat = myConn.createStatement();
            String sql = "SELECT * FROM donor WHERE CampaignID = " + id;
            ResultSet rs = myStat.executeQuery(sql);
            Donor donor;
            while(rs.next()){
                donor = new Donor(rs.getString("DonIC"), rs.getString("DonName"), rs.getString("DonGender"), rs.getString("DonBType"), rs.getInt("DonAge"), rs.getInt("DonBAMount"));
                donorlist.add(donor);
            }
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }

        DefaultTableModel model = (DefaultTableModel)jTable_DonorTable.getModel();
        Object[] row = new Object[6];
        for(int i=0; i<donorlist.size();i++){
            row[0] = donorlist.get(i).getDonorIC();
            row[1] = donorlist.get(i).getDonorName();
            row[2] = donorlist.get(i).getDonorGender();
            row[3] = donorlist.get(i).getDonorAge();
            row[4] = donorlist.get(i).getDonorBloodType();
            row[5] = donorlist.get(i).getDonorDonatedAmount();
            model.addRow(row);
        }
        int count = donorlist.size();
        lblDonorTotalView.setText(String.valueOf(count));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_DonorTable = new javax.swing.JTable();
        lblDonorHeader = new javax.swing.JLabel();
        lblDonorGuestName = new javax.swing.JLabel();
        txtDonorGuestGender = new javax.swing.JLabel();
        lblDonorGuestAge = new javax.swing.JLabel();
        lblDonorGuestBloodType = new javax.swing.JLabel();
        lblDonorGuestDonateAmount = new javax.swing.JLabel();
        txtDonorGuestName = new javax.swing.JTextField();
        cmbDonorGuestGender = new javax.swing.JComboBox<>();
        txtDoorGuestAge = new javax.swing.JTextField();
        txtDonorGuestDonateAmount = new javax.swing.JTextField();
        btnDonorGuestSubmitButton = new javax.swing.JButton();
        jLabelDonorGuestIC = new javax.swing.JLabel();
        txtDonorGuestIC = new javax.swing.JTextField();
        checkBoxDonorGuestDelete = new javax.swing.JCheckBox();
        btnDonorGuestResetButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtDonorGuestCampaignID = new javax.swing.JTextField();
        checkBoxDonorGuestUpdate1 = new javax.swing.JCheckBox();
        btnDonorGuestBackButton1 = new javax.swing.JButton();
        lblDonorTotalNum = new javax.swing.JLabel();
        lblDonorTotalView = new javax.swing.JLabel();
        cmbDonorGuestBloodType = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_DonorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IC Num", "Name", "Gender", "Age", "Blood Type", "Donated Amount"
            }
        ));
        jTable_DonorTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_DonorTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_DonorTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 400, 640, 178));

        lblDonorHeader.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblDonorHeader.setText("Donor Information");
        getContentPane().add(lblDonorHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 11, -1, -1));

        lblDonorGuestName.setText("Donor Name :");
        getContentPane().add(lblDonorGuestName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        txtDonorGuestGender.setText("Donor Gender :");
        getContentPane().add(txtDonorGuestGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        lblDonorGuestAge.setText("Donor Age :");
        getContentPane().add(lblDonorGuestAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        lblDonorGuestBloodType.setText("Donor Blood Type:");
        getContentPane().add(lblDonorGuestBloodType, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        lblDonorGuestDonateAmount.setText("Donate Blood Amount :");
        getContentPane().add(lblDonorGuestDonateAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        txtDonorGuestName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDonorGuestNameKeyTyped(evt);
            }
        });
        getContentPane().add(txtDonorGuestName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 240, -1));

        cmbDonorGuestGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        cmbDonorGuestGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDonorGuestGenderActionPerformed(evt);
            }
        });
        getContentPane().add(cmbDonorGuestGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, -1, -1));

        txtDoorGuestAge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDoorGuestAgeKeyTyped(evt);
            }
        });
        getContentPane().add(txtDoorGuestAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 240, -1));

        txtDonorGuestDonateAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDonorGuestDonateAmountKeyTyped(evt);
            }
        });
        getContentPane().add(txtDonorGuestDonateAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 240, -1));

        btnDonorGuestSubmitButton.setText("Submit");
        btnDonorGuestSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDonorGuestSubmitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(btnDonorGuestSubmitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, -1, -1));

        jLabelDonorGuestIC.setText("Donor IC:");
        getContentPane().add(jLabelDonorGuestIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        txtDonorGuestIC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDonorGuestICActionPerformed(evt);
            }
        });
        txtDonorGuestIC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDonorGuestICKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDonorGuestICKeyTyped(evt);
            }
        });
        getContentPane().add(txtDonorGuestIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 240, -1));

        checkBoxDonorGuestDelete.setText("Delete?");
        checkBoxDonorGuestDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxDonorGuestDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(checkBoxDonorGuestDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, -1, -1));

        btnDonorGuestResetButton.setText("Reset");
        btnDonorGuestResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDonorGuestResetButtonActionPerformed(evt);
            }
        });
        getContentPane().add(btnDonorGuestResetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, -1, -1));

        jLabel1.setText("Campaign ID:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        txtDonorGuestCampaignID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDonorGuestCampaignIDActionPerformed(evt);
            }
        });
        getContentPane().add(txtDonorGuestCampaignID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 30, -1));

        checkBoxDonorGuestUpdate1.setText("Update?");
        checkBoxDonorGuestUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxDonorGuestUpdate1ActionPerformed(evt);
            }
        });
        getContentPane().add(checkBoxDonorGuestUpdate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        btnDonorGuestBackButton1.setText("Back");
        btnDonorGuestBackButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDonorGuestBackButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnDonorGuestBackButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, -1, -1));

        lblDonorTotalNum.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblDonorTotalNum.setText("Total Number of Donor: ");
        getContentPane().add(lblDonorTotalNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        lblDonorTotalView.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblDonorTotalView.setText("jLabel3");
        getContentPane().add(lblDonorTotalView, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, -1, -1));

        cmbDonorGuestBloodType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "AB", "O" }));
        getContentPane().add(cmbDonorGuestBloodType, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDonorGuestSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDonorGuestSubmitButtonActionPerformed
        String[] genderArray = {"Male", "Female"};
        String gender = "none";
        if (cmbDonorGuestGender.getSelectedIndex() == 0) {
            gender = genderArray[0];
        } else {
            gender = genderArray[1];
        }
        
        String[] bloodtypeArray = {"A", "B", "AB", "O"};
        String bloodtype = "none";
        if (cmbDonorGuestBloodType.getSelectedIndex() == 0) {
            bloodtype = bloodtypeArray[0];
        } 
        else if (cmbDonorGuestBloodType.getSelectedIndex() == 1) {
            bloodtype = bloodtypeArray[1];
        }
        else if (cmbDonorGuestBloodType.getSelectedIndex() == 2) {
            bloodtype = bloodtypeArray[2];
        }
        else {
            bloodtype = bloodtypeArray[3];
        }
        
        if (checkBoxDonorGuestUpdate1.isSelected()) { //update info
            try {
                myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/phase3", "root", "");
                myStat = myConn.createStatement();
                int row = jTable_DonorTable.getSelectedRow();
                String value = (jTable_DonorTable.getModel().getValueAt(row,0).toString());
                String sql = "UPDATE donor SET DonIC=?, DonName=?, DonGender=?, DonAge=?, DonBType=?, DonBAmount=? where DonIC=" + value;
                PreparedStatement pst = myConn.prepareStatement(sql);
                pst.setString(1, txtDonorGuestIC.getText());
                pst.setString(2, txtDonorGuestName.getText());
                pst.setString(3, gender);
                pst.setString(4, txtDoorGuestAge.getText());
                pst.setString(5, bloodtype);
                pst.setString(6, txtDonorGuestDonateAmount.getText());
                pst.executeUpdate();
            
                DefaultTableModel model = (DefaultTableModel)jTable_DonorTable.getModel();
                model.setRowCount(0); //refresh table
                displayTable();
                txtDonorGuestIC.setText(""); //reset all textfield
                txtDonorGuestName.setText("");
                cmbDonorGuestGender.setSelectedIndex(0);
                txtDoorGuestAge.setText("");
                cmbDonorGuestBloodType.setSelectedIndex(0);
                txtDonorGuestDonateAmount.setText("");
                JOptionPane.showMessageDialog(null,"Update Successful");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e);
            }
        }
        else if (checkBoxDonorGuestDelete.isSelected()) { //delete info
            try {
                myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/phase3", "root", "");
                myStat = myConn.createStatement();
                int row = jTable_DonorTable.getSelectedRow();
                String value = (jTable_DonorTable.getModel().getValueAt(row,0).toString());
                String sql = "DELETE FROM donor WHERE DonIC = " + value;
                PreparedStatement pst = myConn.prepareStatement(sql);
                pst.executeUpdate();
            
                DefaultTableModel model = (DefaultTableModel)jTable_DonorTable.getModel();
                model.setRowCount(0); //refresh table
                displayTable();
                txtDonorGuestIC.setText(""); //reset all textfield
                txtDonorGuestName.setText("");
                cmbDonorGuestGender.setSelectedIndex(0);
                txtDoorGuestAge.setText("");
                cmbDonorGuestBloodType.setSelectedIndex(0);
                txtDonorGuestDonateAmount.setText("");
                JOptionPane.showMessageDialog(null,"Delete Successful");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e);
            }
        }
        else{ // insert info
            try {
                myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/phase3", "root", "");
                myStat = myConn.createStatement();
                myStat.execute("CREATE TABLE IF NOT EXISTS `phase3`.`donor` ( `DonIC` TEXT NOT NULL , `DonName` TEXT NOT NULL , `DonGender` TEXT NOT NULL , `DonAge` INT NOT NULL , `DonBType` TEXT NOT NULL, `DonBAmount` INT NOT NULL ,`CampaignID` TEXT NOT NULL , PRIMARY KEY (`DonIC`)) ENGINE = InnoDB;");
                String sql = "INSERT INTO donor (DonIC, DonName, DonGender, DonAge, DonBType, DonBAMount, CampaignID) values (?,?,?,?,?,?,?)"; 
                PreparedStatement pst = myConn.prepareStatement(sql);
                pst.setString(1, txtDonorGuestIC.getText());
                pst.setString(2, txtDonorGuestName.getText());
                pst.setString(3, gender);
                pst.setString(4, txtDoorGuestAge.getText());
                pst.setString(5, bloodtype);
                pst.setString(6, txtDonorGuestDonateAmount.getText());
                pst.setString(7, txtDonorGuestCampaignID.getText()); //campaign id
                pst.execute();
            
                DefaultTableModel model = (DefaultTableModel)jTable_DonorTable.getModel();
                model.setRowCount(0); //refresh table
                displayTable();
                txtDonorGuestIC.setText(""); //reset all textfield
                txtDonorGuestName.setText("");
                cmbDonorGuestGender.setSelectedIndex(0);
                txtDoorGuestAge.setText("");
                cmbDonorGuestBloodType.setSelectedIndex(0);
                txtDonorGuestDonateAmount.setText("");
                JOptionPane.showMessageDialog(null,"Save Successful");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }//GEN-LAST:event_btnDonorGuestSubmitButtonActionPerformed

    private void txtDonorGuestICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDonorGuestICActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDonorGuestICActionPerformed

    private void cmbDonorGuestGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDonorGuestGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDonorGuestGenderActionPerformed

    private void checkBoxDonorGuestDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxDonorGuestDeleteActionPerformed
        if (checkBoxDonorGuestDelete.isSelected()) {
            txtDonorGuestIC.setEditable(false); //textfield cannot modified
            txtDonorGuestName.setEditable(false);
            cmbDonorGuestGender.setEnabled(false);
            txtDoorGuestAge.setEditable(false);
            cmbDonorGuestBloodType.setEnabled(false);
            txtDonorGuestDonateAmount.setEditable(false);
        }
        else {
            txtDonorGuestIC.setEditable(true);
            txtDonorGuestName.setEditable(true);
            cmbDonorGuestGender.setEnabled(true);
            txtDoorGuestAge.setEditable(true);
            cmbDonorGuestBloodType.setEnabled(true);
            txtDonorGuestDonateAmount.setEditable(true);
        }
    }//GEN-LAST:event_checkBoxDonorGuestDeleteActionPerformed

    private void jTable_DonorTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_DonorTableMouseClicked
       int i = jTable_DonorTable.getSelectedRow(); //display clicked table row in textfield
       TableModel model = jTable_DonorTable.getModel();
       txtDonorGuestName.setText(model.getValueAt(i,1).toString());
       txtDonorGuestIC.setText(model.getValueAt(i,0).toString());
       String gender = model.getValueAt(i,2).toString();
       switch(gender){
           case "Male": cmbDonorGuestGender.setSelectedIndex(0);
                        break;
           case "Female": cmbDonorGuestGender.setSelectedIndex(1);
                        break;
       }
       txtDoorGuestAge.setText(model.getValueAt(i,3).toString());
       String bloodtype = model.getValueAt(i,4).toString();
       switch(bloodtype){
           case "A": cmbDonorGuestBloodType.setSelectedIndex(0);
                        break;
           case "B": cmbDonorGuestBloodType.setSelectedIndex(1);
                        break;
           case "AB": cmbDonorGuestBloodType.setSelectedIndex(2);
                        break;
           case "O": cmbDonorGuestBloodType.setSelectedIndex(3);
                        break;
       }
       txtDonorGuestDonateAmount.setText(model.getValueAt(i,5).toString());
       //txtDonorGuestCampaignID.setText(model.getValueAt(i,7).toString());
    }//GEN-LAST:event_jTable_DonorTableMouseClicked

    private void btnDonorGuestResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDonorGuestResetButtonActionPerformed
        txtDonorGuestIC.setText(""); //reset all textfield
        txtDonorGuestName.setText("");
        cmbDonorGuestGender.setSelectedIndex(0);
        txtDoorGuestAge.setText("");
        cmbDonorGuestBloodType.setSelectedIndex(0);
        txtDonorGuestDonateAmount.setText("");
    }//GEN-LAST:event_btnDonorGuestResetButtonActionPerformed

    private void txtDonorGuestCampaignIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDonorGuestCampaignIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDonorGuestCampaignIDActionPerformed

    private void checkBoxDonorGuestUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxDonorGuestUpdate1ActionPerformed
        if (checkBoxDonorGuestUpdate1.isSelected()) {
            txtDonorGuestIC.setEditable(false); //textfield cannot modified
        }
        else {
            txtDonorGuestIC.setEditable(true);
        }
    }//GEN-LAST:event_checkBoxDonorGuestUpdate1ActionPerformed

    private void btnDonorGuestBackButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDonorGuestBackButton1ActionPerformed
        this.toBack();
        Cmp leaveInfo = new Cmp();
        leaveInfo.setVisible(false);
        leaveInfo.toFront(); //go to campaign interface
    }//GEN-LAST:event_btnDonorGuestBackButton1ActionPerformed

    private void txtDonorGuestICKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDonorGuestICKeyPressed
        String ic = txtDonorGuestIC.getText();
        int length = ic.length();
        char c = evt.getKeyChar();
        if(length >= 0 && length <= 11){ //limit num to 12 digit
            if(length < 12){
                txtDonorGuestIC.setEditable(true);
            }
            else{
                txtDonorGuestIC.setEditable(false);
            }
        }
        else{
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE){
                txtDonorGuestIC.setEditable(true);
            }
            else{
                txtDonorGuestIC.setEditable(false);
            }
        }
    }//GEN-LAST:event_txtDonorGuestICKeyPressed

    private void txtDonorGuestICKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDonorGuestICKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c))){
            evt.consume();
        }
    }//GEN-LAST:event_txtDonorGuestICKeyTyped

    private void txtDonorGuestNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDonorGuestNameKeyTyped
        char c = evt.getKeyChar();
        if(Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtDonorGuestNameKeyTyped

    private void txtDoorGuestAgeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDoorGuestAgeKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c))){
            evt.consume();
        }
    }//GEN-LAST:event_txtDoorGuestAgeKeyTyped

    private void txtDonorGuestDonateAmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDonorGuestDonateAmountKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c))){
            evt.consume();
        }
    }//GEN-LAST:event_txtDonorGuestDonateAmountKeyTyped

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
            java.util.logging.Logger.getLogger(DonorInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DonorInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DonorInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DonorInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DonorInformation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDonorGuestBackButton1;
    private javax.swing.JButton btnDonorGuestResetButton;
    private javax.swing.JButton btnDonorGuestSubmitButton;
    private javax.swing.JCheckBox checkBoxDonorGuestDelete;
    private javax.swing.JCheckBox checkBoxDonorGuestUpdate1;
    private javax.swing.JComboBox<String> cmbDonorGuestBloodType;
    private javax.swing.JComboBox<String> cmbDonorGuestGender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelDonorGuestIC;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_DonorTable;
    private javax.swing.JLabel lblDonorGuestAge;
    javax.swing.JLabel lblDonorGuestBloodType;
    javax.swing.JLabel lblDonorGuestDonateAmount;
    private javax.swing.JLabel lblDonorGuestName;
    private javax.swing.JLabel lblDonorHeader;
    private javax.swing.JLabel lblDonorTotalNum;
    private javax.swing.JLabel lblDonorTotalView;
    private javax.swing.JTextField txtDonorGuestCampaignID;
    private javax.swing.JTextField txtDonorGuestDonateAmount;
    private javax.swing.JLabel txtDonorGuestGender;
    private javax.swing.JTextField txtDonorGuestIC;
    private javax.swing.JTextField txtDonorGuestName;
    private javax.swing.JTextField txtDoorGuestAge;
    // End of variables declaration//GEN-END:variables
}