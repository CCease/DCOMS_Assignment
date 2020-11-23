package com.dcoms.client.customer.mainpage;

import com.dcoms.domain.Food;
import com.dcoms.domain.Order;
import com.dcoms.service.IKitchenService;
import com.dcoms.utils.DomainBuilder;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.rmi.Naming;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class CustomerMainPage extends javax.swing.JFrame {

    public CustomerMainPage() {

        initComponents();
    }

    static private JFrame frame;
    static private JButton backButton, orderButton, trackButton;
    static private JTextField textField, textField1, textField2, textField3;
    static private JRadioButton radioButton1, radioButton2;
    static private GridBagConstraints gbc;
    private JTable table;
    DefaultTableModel dtm;
    Double[] price;
    double totalPrice = 0;
    double p1, p2, p3, p4, p5, p6;
    private String customerID = "";

    private JSpinner[] numSpinner;
    static private JLabel[] foodLabel;
    static private JLabel[] foodImage;
    private File[] file;

    private static final int ELEMENTS = 6;

    double total = 0;
    double food1, food2, food3, food4, food5, food6;

    double tax, net;
    double totalForFoods;

    //Set 2 decimal places
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    //Set font
    Font f1 = new Font("Forte", Font.BOLD, 40);
    Font f2 = new Font("Adobe Caslon Pro", Font.PLAIN, 18);
    Font f3 = new Font("Adobe Caslon Pro", Font.BOLD, 18);

    public void createAndShowGUI() throws IOException, SQLException {

        //Design frame
        frame = new JFrame("Main Menu");
        frame.setBounds(100, 100, 1150, 770);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(153, 153, 153));
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);

        //Design labels
        ImageIcon imageIcon = new ImageIcon("src/main/java/com/dcoms/images/mcgLogo.png");
        JLabel lblLogo = new JLabel(imageIcon);
        lblLogo.setBounds(20, 10, 50, 50);
        frame.getContentPane().add(lblLogo);

        ImageIcon icon = new ImageIcon("src/main/java/com/dcoms/images/Profile.png");
        JLabel lblProfile = new JLabel(icon);
        lblProfile.setBounds(1050, 10, 60, 60);
        frame.getContentPane().add(lblProfile);

        JLabel lblTitle = new JLabel("Welcome to McGee !");
        lblTitle.setBounds(90, 10, 390, 55);
        lblTitle.setFont(f1);
        frame.getContentPane().add(lblTitle);

        JLabel lblFoodOrdered = new JLabel("Ordered Food: ");
        lblFoodOrdered.setBounds(700, 80, 150, 30);
        lblFoodOrdered.setFont(f2);
        frame.getContentPane().add(lblFoodOrdered);

        //Create text box for userID
        textField = new JTextField();
        textField.setBounds(970, 20, 80, 35);
        textField.setFont(f2);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        //Design table
        dtm = new DefaultTableModel(0, 0) {
            @Override
            //make jTable non-editable
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        final String header[] = new String[]{"Item", "Qty", "Price", "Spinner"};
        dtm.setColumnIdentifiers(header);
        dtm.addRow(header);
        table = new JTable();
        table.setModel(dtm);
        table.setBounds(700, 120, 1, 1); // int x, int y, int width, int height
        table.setSize(400, 250); // width,height
        table.setFont(f2);
        table.setRowHeight(25);
        table.getColumnModel().getColumn(0).setPreferredWidth(180);
        table.getColumnModel().getColumn(1).setPreferredWidth(50);
        table.getColumnModel().getColumn(2).setPreferredWidth(50);
        table.getColumnModel().getColumn(3).setMinWidth(0); // hide spinner column
        table.getColumnModel().getColumn(3).setMaxWidth(0); // hide spinner column
        table.setShowGrid(false); // remove cell boarder
        frame.getContentPane().add(table);

        //Design label
        JLabel lblOption = new JLabel("Please select an option:");
        lblOption.setBounds(700, 550, 200, 20);
        lblOption.setFont(f2);
        frame.getContentPane().add(lblOption);

        //Sub total
        JLabel lblsubTotal = new JLabel("Sub Total:");
        lblsubTotal.setBounds(700, 395, 100, 20);
        lblsubTotal.setFont(f2);
        frame.getContentPane().add(lblsubTotal);
        textField1 = new JTextField();
        textField1.setBounds(830, 390, 120, 35);
        textField1.setFont(f2);
        frame.getContentPane().add(textField1);
        textField1.setColumns(15);

        //Service tax
        JLabel lblTax = new JLabel("Service Tax 6%:");
        lblTax.setBounds(700, 445, 150, 20);
        lblTax.setFont(f2);
        frame.getContentPane().add(lblTax);
        textField2 = new JTextField();
        textField2.setBounds(830, 440, 120, 35);
        textField2.setFont(f2);
        frame.getContentPane().add(textField2);
        textField2.setColumns(15);

        //Net total
        JLabel lblnetTotal = new JLabel("Net Order:");
        lblnetTotal.setBounds(700, 495, 100, 20);
        lblnetTotal.setFont(f2);
        frame.getContentPane().add(lblnetTotal);
        textField3 = new JTextField();
        textField3.setBounds(830, 490, 120, 35);
        textField3.setFont(f2);
        frame.getContentPane().add(textField3);
        textField3.setColumns(15);

        //Design buttons
        orderButton = new JButton("Order");
        orderButton.setBounds(700, 650, 120, 40);
        orderButton.setFont(f3);
        orderButton.setBackground(Color.yellow);
        frame.getContentPane().add(orderButton);

        backButton = new JButton("Back");
        backButton.setBounds(980, 650, 120, 40);
        backButton.setFont(f3);
        frame.getContentPane().add(backButton);

        trackButton = new JButton("Track Order");
        trackButton.setBounds(800, 20, 150, 40);
        trackButton.setFont(f3);
        trackButton.setBackground(Color.BLACK);
        trackButton.setForeground(Color.WHITE);
        frame.getContentPane().add(trackButton);

        //Design Radio Buttons
        radioButton1 = new JRadioButton("Dine-In", true);
        radioButton1.setFont(f2);
        radioButton2 = new JRadioButton("Take Away");
        radioButton2.setFont(f2);

        ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(radioButton1);
        bgroup.add(radioButton2);

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(1, 2));
        radioPanel.add(radioButton1);
        radioPanel.add(radioButton2);
        radioPanel.setBounds(700, 580, 260, 40);
        radioPanel.setFont(f2);
        frame.getContentPane().add(radioPanel);

        //Design Tabbed Pane
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        addIt(tabbedPane, "Foods");
        tabbedPane.setBounds(18, 80, 650, 630);
        tabbedPane.setFont(f2);
        frame.getContentPane().add(tabbedPane);
        frame.setVisible(true);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                com.dcoms.client.customer.login.Login log = new com.dcoms.client.customer.login.Login();
                log.setLocationRelativeTo(null);
                log.setVisible(true);
                frame.dispose();
            }
        });

        orderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField1.getText().equals("") || textField1.getText().equals("RM 0")) {
                    JOptionPane.showMessageDialog(rootPane, "You have not ordered anything yet !");
                } else {
                    //get radio button value
                    String mealOption = "Dine-in";
                    if (radioButton2.isSelected()) {
                        mealOption = "Take away";
                    }

                    //getTotalPrice
                    String totalPrice = textField3.getText();

                    JOptionPane.showMessageDialog(rootPane, "You order food successfully !!!");
                    DefaultTableModel dtm = (DefaultTableModel) table.getModel();
                    dtm.setRowCount(0);

                    DomainBuilder domainBuilder = new DomainBuilder();

                    List<String> foodListString = new ArrayList();
                    for (int i = 0; i < Integer.parseInt(numSpinner[0].getValue().toString()); i++) {
                        foodListString.add("1");
                    }
                    for (int i = 0; i < Integer.parseInt(numSpinner[1].getValue().toString()); i++) {
                        foodListString.add("2");
                    }
                    for (int i = 0; i < Integer.parseInt(numSpinner[2].getValue().toString()); i++) {
                        foodListString.add("3");
                    }
                    for (int i = 0; i < Integer.parseInt(numSpinner[3].getValue().toString()); i++) {
                        foodListString.add("4");
                    }
                    for (int i = 0; i < Integer.parseInt(numSpinner[4].getValue().toString()); i++) {
                        foodListString.add("5");
                    }
                    for (int i = 0; i < Integer.parseInt(numSpinner[5].getValue().toString()); i++) {
                        foodListString.add("6");
                    }

                    List<Food> foodList = new ArrayList();

                    for (int i = 0; i < foodListString.size(); i++) {
                        foodList.add(domainBuilder.newFood(foodListString.get(i)));
                    }

                    Order order = domainBuilder.newOrder(foodList, customerID);
                    
                    if(radioButton2.isSelected()){
                        order.setTakeAway(true);
                    }else{
                        order.setTakeAway(false);
                    }
                    
                    try {
                        IKitchenService kitchenService = (IKitchenService) Naming.lookup("rmi://localhost:2003" + "/KitchenService");
                        kitchenService.addOrder(order);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        trackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                trackOrder to = new trackOrder();
                to.setLocationRelativeTo(null);
                to.setVisible(true);
                to.setCustomerID(customerID);
                frame.dispose();
            }
        });
    }

    void addIt(JTabbedPane tabbedPane, String text) throws IOException {
        JPanel panel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints(); // getting constraints for the specified component
        gbc.insets = new Insets(10, 0, 0, 0);
        foodImage = new JLabel[ELEMENTS];
        foodLabel = new JLabel[ELEMENTS];
        numSpinner = new JSpinner[ELEMENTS];
        file = new File[ELEMENTS];
        price = new Double[ELEMENTS];

        file[0] = new File("src/main/java/com/dcoms/images/Salad.png");
        file[1] = new File("src/main/java/com/dcoms/images/JapanesePanNoodles.png");
        file[2] = new File("src/main/java/com/dcoms/images/spaghetti.jpg");
        file[3] = new File("src/main/java/com/dcoms/images/Macaroni.png");
        file[4] = new File("src/main/java/com/dcoms/images/RamenNoodles.png");
        file[5] = new File("src/main/java/com/dcoms/images/chickenRice.JPG");
        foodLabel[0] = new JLabel("Salad");
        foodLabel[1] = new JLabel("Japanese Noodles");
        foodLabel[2] = new JLabel("Spaghetti");
        foodLabel[3] = new JLabel("Macaroni");
        foodLabel[4] = new JLabel("Ramen Noodles");
        foodLabel[5] = new JLabel("Chicken Rice");
        price[0] = 13.50;
        price[1] = 14.50;
        price[2] = 13.70;
        price[3] = 14.50;
        price[4] = 15.50;
        price[5] = 14.00;
        for (int i = 0; i < ELEMENTS; i++) {
            Image image = ImageIO.read(file[i]);
            Image imageScaled = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(imageScaled);
            SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 10, 1); // value,minimum,maximum,stepSize
            numSpinner[i] = new JSpinner(spnummodel);
            numSpinner[i].addChangeListener(listener);
            foodImage[i] = new JLabel(imageIcon);
        }
        gbc.gridx = 0; // gridx 0 represent the most left
        for (int i = 0; i < ELEMENTS; i++) {
            if (i % 3 == 0) {
                gbc.gridy += 2;
                gbc.gridx = 0;
            }
            panel.add(foodImage[i], gbc);
            gbc.gridy++; // gridy---> add one row,for foodLabel
            panel.add(foodLabel[i], gbc);
            foodLabel[i].setFont(f2);
            gbc.gridy--; // remove the row
            gbc.gridx++; // move to next column
            panel.add(numSpinner[i], gbc);
            gbc.gridx++; // move to next column
            tabbedPane.addTab(text, panel);
        }
    }

    ChangeListener listener = new ChangeListener() {
        public void stateChanged(ChangeEvent e) {

            final int quantity = (int) ((JSpinner) e.getSource()).getValue();
            final int rows = table.getRowCount();
            for (int row = 0; row < rows; row++) {
                if (dtm.getValueAt(row, 3) == e.getSource()) {
                    if (dtm.getValueAt(row, 0).equals("Salad")) {
                        dtm.setValueAt(quantity, row, 1); // obj, row, column
                        dtm.setValueAt(p1 * quantity, row, 2);
                        food1 = p1 * quantity;

                    } else if (dtm.getValueAt(row, 0).equals("Japanese Noodles")) {
                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(p2 * quantity, row, 2);
                        food2 = p2 * quantity;

                    } else if (dtm.getValueAt(row, 0).equals("Spaghetti")) {
                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(p3 * quantity, row, 2);
                        food3 = p3 * quantity;

                    } else if (dtm.getValueAt(row, 0).equals("Macaroni")) {
                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(p4 * quantity, row, 2);
                        food4 = p4 * quantity;

                    } else if (dtm.getValueAt(row, 0).equals("Ramen Noodles")) {
                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(p5 * quantity, row, 2);
                        food5 = p5 * quantity;

                    } else if (dtm.getValueAt(row, 0).equals("Chicken Rice")) {
                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(p6 * quantity, row, 2);
                        food6 = p6 * quantity;

                    }

                    if (quantity == 0) {
                        dtm.removeRow(row);
                    }
                    totalForFoods = food1 + food2 + food3 + food4 + food5 + food6;
                    total = totalForFoods;
                    textField1.setText("RM " + df2.format(total));
                    tax = total * 0.06;
                    textField2.setText("RM " + df2.format(tax));
                    net = total + tax;
                    textField3.setText("RM " + df2.format(net));
                    return;
                }
            }

            // there was no row with this JSpinner, so we have to add it
            for (int i = 0; i < ELEMENTS; i++) {
                // looking for the "clicked" JSpinner
                if (numSpinner[i] == e.getSource()) {
                    totalPrice = price[i];
                    switch (foodLabel[i].getText()) {
                        case "Salad":
                            p1 = 13.50;
                            food1 = p1;
                            break;
                        case "Japanese Noodles":
                            p2 = 14.50;
                            food2 = p2;
                            break;
                        case "Spaghetti":
                            p3 = 13.70;
                            food3 = p3;
                            break;
                        case "Macaroni":
                            p4 = 14.50;
                            food4 = p4;
                            break;
                        case "Ramen Noodles":
                            p5 = 15.50;
                            food5 = p5;
                            break;
                        case "Chicken Rice":
                            p6 = 14.00;
                            food6 = p6;
                            break;
                    }
                    totalForFoods = food1 + food2 + food3 + food4 + food5 + food6;
                    total = totalForFoods;
                    textField1.setText("RM" + df2.format(total));
                    tax = total * 0.06;
                    textField2.setText("RM" + df2.format(tax));
                    net = total + tax;
                    textField3.setText("RM" + df2.format(net));
                    dtm.addRow(new Object[]{foodLabel[i].getText(), quantity, totalPrice, numSpinner[i]});
                    return;
                }
            }
        }
    };

    public void setVisible(boolean b) {
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 616, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //CustomerMainPage cmp = new CustomerMainPage();
        //cmp.addImage();
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
            java.util.logging.Logger.getLogger(CustomerMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerMainPage().setVisible(true);
            }
        });
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
