package com.dcoms.client.customer.mainpage;

import com.dcoms.client.admin.mainpage.AdminMainPage;
import com.dcoms.client.customer.login.My_CNX;
import com.dcoms.domain.Food;
import com.dcoms.domain.Order;
import com.dcoms.service.IKitchenService;
import com.dcoms.service.IOrderService;
import com.dcoms.utils.DomainBuilder;
import java.io.IOException;
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

public class trackOrder extends javax.swing.JFrame {

    private String customerID;

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String UserID) {
        this.customerID = UserID;
    }

    public trackOrder() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButtonRefresh = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jButtonBack = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTrack = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabelLTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(154, 154, 154));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 400));
        jPanel1.setRequestFocusEnabled(false);

        jButtonRefresh.setFont(new java.awt.Font("Adobe Caslon Pro Bold", 1, 24)); // NOI18N
        jButtonRefresh.setText("Refresh");
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
            }
        });

        jButtonBack.setFont(new java.awt.Font("Adobe Caslon Pro Bold", 1, 24)); // NOI18N
        jButtonBack.setText("Back");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        jButtonCancel.setFont(new java.awt.Font("Adobe Caslon Pro Bold", 1, 24)); // NOI18N
        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jTableTrack.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableTrack.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Order ID", "Food", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTableTrack);

        jLabelLTitle.setFont(new java.awt.Font("Forte", 1, 40)); // NOI18N
        jLabelLTitle.setText("Track Order");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(jLabelLTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(jButtonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshActionPerformed
        PreparedStatement st;
        ResultSet rs;
        DefaultTableModel dtm = (DefaultTableModel) jTableTrack.getModel();
        dtm.setRowCount(0);

        String sql = "SELECT * FROM `order` WHERE `userID`=" + customerID;
        System.out.println("Customer id + " + customerID);
        try {
            st = My_CNX.getConnection().prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                String orderID = String.valueOf(rs.getString("orderID"));
                String food = foodDataToString(rs.getString("food"));
                String status = "";

                if (rs.getString("isSuccess").equals("true")) {
                    status = "Completed";
                } else {
                    status = "Cancelled";
                }

                //string array for store data into jtable
                String dataArray[] = {orderID, food, status};

                //add string array data into jtable
                dtm.addRow(dataArray);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminMainPage.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Order> onGoingOrder = new ArrayList();

        try {
//            IKitchenService kitchenService = (IKitchenService) Naming.lookup("rmi://localhost:2003" + "/KitchenService");
            onGoingOrder = getUserOngoingOrder(customerID);

            for (int i = 0; i < onGoingOrder.size(); i++) {
                String orderID = onGoingOrder.get(i).getId();
                String userID = onGoingOrder.get(i).getCustomerID();

                String Food = foodListToString(onGoingOrder.get(i).getFoods());

                //String Price = CALCULATE 
                String isTakeAway = "";
                if (onGoingOrder.get(i).isTakeAway()) {
                    isTakeAway = " Take Away";
                } else {
                    isTakeAway = " Dine In";
                }

                String status = "Preparing";

                //string array for store data into jtable
                String dataArray[] = {orderID, Food, status};

                //add string array data into jtable
                dtm.addRow(dataArray);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonRefreshActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed

        CustomerMainPage menu = new CustomerMainPage();
        try {
            menu.createAndShowGUI();
        } catch (IOException ex) {
            Logger.getLogger(trackOrder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(trackOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        menu.setVisible(true);
        menu.pack();
        menu.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        try {
            IKitchenService kitchenService = (IKitchenService) Naming.lookup("rmi://localhost:2003" + "/KitchenService");

            String OrderID = "";
            DefaultTableModel dtm = (DefaultTableModel) jTableTrack.getModel();
            if (jTableTrack.getSelectedRowCount() == 1) {
                OrderID = dtm.getValueAt(jTableTrack.getSelectedRow(), 0).toString();
                System.out.println(dtm.getValueAt(jTableTrack.getSelectedRow(), 0).toString());
                System.out.println(OrderID);
                
            } else if (jTableTrack.getRowCount() == 0) {
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
    }//GEN-LAST:event_jButtonCancelActionPerformed

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

    private List<Order> getUserOrderInDatabase(String customerID) {
        try {
            IOrderService orderService = (IOrderService) Naming.lookup("rmi://localhost:2003" + "/KitchenService");
            return orderService.findOrderByCustomerId(customerID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
            if (String.valueOf(c).equals("1") || String.valueOf(c).equals("2") || String.valueOf(c).equals("3")
                    || String.valueOf(c).equals("4") || String.valueOf(c).equals("5") || String.valueOf(c).equals("6")) {
                DomainBuilder domainBuilder = new DomainBuilder();
                result = result + domainBuilder.newFood(String.valueOf(c)).getName() + "  |  ";
            }
        }
        return result;
    }

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
            java.util.logging.Logger.getLogger(trackOrder.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(trackOrder.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(trackOrder.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(trackOrder.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new trackOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JLabel jLabelLTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableTrack;
    // End of variables declaration//GEN-END:variables
}
