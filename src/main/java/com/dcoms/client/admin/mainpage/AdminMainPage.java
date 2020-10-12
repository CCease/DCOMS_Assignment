package com.dcoms.client.admin.mainpage;

import com.dcoms.client.customer.login.My_CNX;
import com.dcoms.domain.Account;
import com.dcoms.domain.Food;
import com.dcoms.domain.Order;
import com.dcoms.service.IAccountService;
import com.dcoms.service.IKitchenService;
import com.dcoms.utils.DomainBuilder;
import java.rmi.Naming;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdminMainPage extends javax.swing.JFrame {

    private String customerID = "";

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public AdminMainPage() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButtonRefreshUser = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabelLTitle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonUpdateUser = new javax.swing.JButton();
        jButtonDeleteUser = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUser = new javax.swing.JTable();
        jLabelUser = new javax.swing.JLabel();
        jButtonCancelOrder = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableOrder = new javax.swing.JTable();
        jButtonRefreshOrder = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabelOrder = new javax.swing.JLabel();
        jButtonBack = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(154, 154, 154));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 400));
        jPanel1.setRequestFocusEnabled(false);

        jButtonRefreshUser.setFont(new java.awt.Font("Adobe Caslon Pro Bold", 1, 24)); // NOI18N
        jButtonRefreshUser.setText("Refresh");
        jButtonRefreshUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshUserActionPerformed(evt);
            }
        });

        jLabelLTitle.setFont(new java.awt.Font("Forte", 1, 40)); // NOI18N
        jLabelLTitle.setText("Admin Main Site");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(327, 327, 327)
                        .addComponent(jLabelLTitle)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(78, 78, 78))
        );

        jButtonUpdateUser.setFont(new java.awt.Font("Adobe Caslon Pro Bold", 1, 24)); // NOI18N
        jButtonUpdateUser.setText("Update");
        jButtonUpdateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateUserActionPerformed(evt);
            }
        });

        jButtonDeleteUser.setFont(new java.awt.Font("Adobe Caslon Pro Bold", 1, 24)); // NOI18N
        jButtonDeleteUser.setText("Delete");
        jButtonDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteUserActionPerformed(evt);
            }
        });

        jTableUser.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "First Name", "Last Name", "IC Number", "Username", "Password"
            }
        ));
        jScrollPane1.setViewportView(jTableUser);

        jLabelUser.setFont(new java.awt.Font("Adobe Caslon Pro", 0, 24)); // NOI18N
        jLabelUser.setText("User:");

        jButtonCancelOrder.setFont(new java.awt.Font("Adobe Caslon Pro Bold", 1, 24)); // NOI18N
        jButtonCancelOrder.setText("Cancel");
        jButtonCancelOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelOrderActionPerformed(evt);
            }
        });

        jTableOrder.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "User ID", "Food", "Price", "TakeAway/DineIn", "Status"
            }
        ));
        jScrollPane2.setViewportView(jTableOrder);

        jButtonRefreshOrder.setFont(new java.awt.Font("Adobe Caslon Pro Bold", 1, 24)); // NOI18N
        jButtonRefreshOrder.setText("Refresh");
        jButtonRefreshOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshOrderActionPerformed(evt);
            }
        });

        jLabelOrder.setFont(new java.awt.Font("Adobe Caslon Pro", 0, 24)); // NOI18N
        jLabelOrder.setText("Order:");

        jButtonBack.setFont(new java.awt.Font("Adobe Caslon Pro Bold", 1, 24)); // NOI18N
        jButtonBack.setText("Back");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        jButtonExit.setFont(new java.awt.Font("Adobe Caslon Pro Bold", 1, 24)); // NOI18N
        jButtonExit.setText("Exit");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonUpdateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(253, 253, 253)
                        .addComponent(jButtonDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonRefreshUser, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelUser)
                            .addComponent(jLabelOrder)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(221, 221, 221)
                                .addComponent(jButtonCancelOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(193, 193, 193)
                                .addComponent(jButtonRefreshOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 265, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelUser)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonUpdateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRefreshUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLabelOrder)
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRefreshOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 983, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 827, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRefreshUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshUserActionPerformed

        PreparedStatement st;
        ResultSet rs;
        DefaultTableModel dtm = (DefaultTableModel) jTableUser.getModel();
        dtm.setRowCount(0);
        String sql = "SELECT * FROM `users`";
        try {
            st = My_CNX.getConnection().prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                String userID = String.valueOf(rs.getInt("userID"));
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String ic = String.valueOf(rs.getInt("ic"));
                String username = rs.getString("username");
                String password = rs.getString("password");

                //string array for store data into jtable
                String dataArray[] = {userID, firstName, lastName, ic, username, password};

                //add string array data into jtable
                dtm.addRow(dataArray);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonRefreshUserActionPerformed

    private void jButtonUpdateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateUserActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) jTableUser.getModel();
        if (jTableUser.getSelectedRowCount() == 1) {
            List<Object> selectedEntry = new ArrayList();
            for (int i = 0; i < 6; i++) {
                selectedEntry.add(dtm.getValueAt(jTableUser.getSelectedRow(), i));
            }
            for (int i = 0; i < selectedEntry.size(); i++) {
                System.out.println(selectedEntry.get(i).getClass().toString() + " | " + selectedEntry.get(i));
            }

            //row, column
            try {
                IAccountService accountService;
                accountService = (IAccountService) Naming.lookup("rmi://localhost:2000" + "/AccountService");
                DomainBuilder domainBuilder = new DomainBuilder();
                Account account = domainBuilder.newAccount(//String id, String firstname, String lastname, String ic, String password, String username
                    selectedEntry.get(0).toString(),
                    selectedEntry.get(1).toString(),
                    selectedEntry.get(2).toString(),
                    selectedEntry.get(3).toString(),
                    selectedEntry.get(5).toString(),
                    selectedEntry.get(4).toString()
                );
                accountService.updateAccount(account);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            if (jTableUser.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Table is empty.");
            } else {
                JOptionPane.showMessageDialog(this, "Please select single row for update.");
            }
        }
    }//GEN-LAST:event_jButtonUpdateUserActionPerformed

    private void jButtonDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteUserActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) jTableUser.getModel();
        if (jTableUser.getSelectedRowCount() == 1) {

            List<Object> selectedEntry = new ArrayList();
            for (int i = 0; i < 6; i++) {
                selectedEntry.add(dtm.getValueAt(jTableUser.getSelectedRow(), i));
            }
            for (int i = 0; i < selectedEntry.size(); i++) {
                System.out.println(selectedEntry.get(i).getClass().toString() + " | " + selectedEntry.get(i));
            }

            dtm.removeRow(jTableUser.getSelectedRow());

            //row, column
            try {
                IAccountService accountService;
                accountService = (IAccountService) Naming.lookup("rmi://localhost:2000" + "/AccountService");
                DomainBuilder domainBuilder = new DomainBuilder();
                Account account = domainBuilder.newAccount(
                        selectedEntry.get(0).toString(),
                        selectedEntry.get(1).toString(),
                        selectedEntry.get(2).toString(),
                        selectedEntry.get(3).toString(),
                        selectedEntry.get(4).toString(),
                        selectedEntry.get(5).toString()
                );
                accountService.deleteAccount(account);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            if (jTableUser.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Table is empty.");
            } else {
                JOptionPane.showMessageDialog(this, "Please select single row for delete.");
            }
        }
    }//GEN-LAST:event_jButtonDeleteUserActionPerformed

    private void jButtonCancelOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelOrderActionPerformed
        try {
            IKitchenService kitchenService = (IKitchenService) Naming.lookup("rmi://localhost:2003" + "/KitchenService");

            String OrderID = "";
            DefaultTableModel dtm = (DefaultTableModel) jTableOrder.getModel();
            if (jTableOrder.getSelectedRowCount() == 1) {
                OrderID = dtm.getValueAt(jTableOrder.getSelectedRow(), 0).toString();
                System.out.println(dtm.getValueAt(jTableOrder.getSelectedRow(), 0).toString());
                System.out.println(OrderID);
                
            } else if (jTableOrder.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Table is empty.");
            } else {
                JOptionPane.showMessageDialog(this, "Please select single row for cancel.");
            }

            List<Order> onGoingOrderList = kitchenService.getOnGoingOrder();
            for (int i = 0; i < onGoingOrderList.size(); i++) {
                System.out.println("OrderID = " + OrderID+ " || " + onGoingOrderList.get(i).getId());
                if(onGoingOrderList.get(i).getId().equals(OrderID)){
                    kitchenService.cancelOrder(onGoingOrderList.get(i));
                    break;
                };
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonCancelOrderActionPerformed

    private void jButtonRefreshOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshOrderActionPerformed
        PreparedStatement st;
        ResultSet rs;
        DefaultTableModel dtm = (DefaultTableModel) jTableOrder.getModel();
        dtm.setRowCount(0);
        
        String sql = "SELECT * FROM `order`";
        try {
            st = My_CNX.getConnection().prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                String orderID = String.valueOf(rs.getString("orderID"));
                String userID = String.valueOf(rs.getString("userID"));
                String food = foodDataToString(rs.getString("food"));
                String price = rs.getString("price");
                String taordi = rs.getString("isTakeAway");
                String status = "";
                
                if(rs.getString("isSuccess").equals("true")){
                    status = "Completed";
                }else{
                    status = "Cancelled";
                }

                //string array for store data into jtable
                String dataArray[] = {orderID, userID, food, price, taordi, status};

                //add string array data into jtable
                dtm.addRow(dataArray);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<Order> onGoingOrder = new ArrayList();
        
        try {
            IKitchenService kitchenService = (IKitchenService) Naming.lookup("rmi://localhost:2003" + "/KitchenService");
            onGoingOrder = kitchenService.getOnGoingOrder();
            
            for (int i = 0; i < onGoingOrder.size(); i++) {
                String orderID = onGoingOrder.get(i).getId();
                String userID = onGoingOrder.get(i).getCustomerID();

                String Food = foodListToString(onGoingOrder.get(i).getFoods());
                
                //String Price = CALCULATE 
                
                String isTakeAway = "";
                if(onGoingOrder.get(i).isTakeAway()){
                    isTakeAway = " Take Away";
                }else{
                    isTakeAway = " Dine In";
                }
                
                String status = "Preparing";
                
                //string array for store data into jtable
                String dataArray[] = {orderID, userID, Food, "", "", status};

                //add string array data into jtable
                dtm.addRow(dataArray);
            }            
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonRefreshOrderActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        com.dcoms.client.customer.login.Login log = new com.dcoms.client.customer.login.Login();
        log.setLocationRelativeTo(null);
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonExitActionPerformed

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
            java.util.logging.Logger.getLogger(AdminMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminMainPage().setVisible(true);
            }
        });
        
        
    }

    private List<Order> getUserOngoingOrder(String customerID) {
        List<Order> customerOnGoingOrder = new ArrayList();
        try {
            IKitchenService kitchenService = (IKitchenService) Naming.lookup("rmi://localhost:2003" + "/KitchenService");
            List<Order> onGoingOrder = kitchenService.getOnGoingOrder();

            for (int i = 0; i < onGoingOrder.size(); i++) {
                if (onGoingOrder.get(i).getCustomerID().equals(customerID)) {
                    customerOnGoingOrder.add(onGoingOrder.get(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerOnGoingOrder;
    }
    
     private String foodListToString(List<Food> foodList) {
        String result = "";
        for (int i = 0; i < foodList.size(); i++) {
            result = result + foodList.get(i).getName() + "  |  ";
        }
        return result;
    }

    private String foodDataToString(String foodData) {
        String result = "";
        for (int i = 0; i < foodData.length(); i++) {
            char c = foodData.charAt(i);
            //Process char
            if(String.valueOf(c).equals("1") || String.valueOf(c).equals("2") || String.valueOf(c).equals("3")
                    || String.valueOf(c).equals("4") || String.valueOf(c).equals("5") || String.valueOf(c).equals("6")){
                DomainBuilder domainBuilder = new DomainBuilder();
                System.out.println(domainBuilder.newFood(String.valueOf(c)));
                result = result + domainBuilder.newFood(String.valueOf(c)).getName() + "  |  ";
            }
        }
        return result;
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonCancelOrder;
    private javax.swing.JButton jButtonDeleteUser;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonRefreshOrder;
    private javax.swing.JButton jButtonRefreshUser;
    private javax.swing.JButton jButtonUpdateUser;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelLTitle;
    private javax.swing.JLabel jLabelOrder;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTableOrder;
    private javax.swing.JTable jTableUser;
    // End of variables declaration//GEN-END:variables
}
