package com.dcoms.client.customer.mainpage;

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
import java.text.DecimalFormat;
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
    static private JButton backButton, orderButton, profileButton;
    static private JTextField textField1, textField2, textField3;
    static private JRadioButton radioButton1, radioButton2;
    static private GridBagConstraints gbc;
    private JTable table;
    DefaultTableModel dtm;
    Double[] price;
    Double[] priceDrinks;
    Double[] priceDesserts;
    double totalPrice = 0;
    double p1, p2, p3, p4, p5, p6, p7, p8, p9;
    double d1, d2, d3, d4, d5;
    double de1, de2;

    private JSpinner[] numSpinner;
    static private JLabel[] foodLabel;
    static private JLabel[] foodImage;
    private File[] file;

    private JSpinner[] numSpinnerDrinks;
    static private JLabel[] drinkLabel;
    static private JLabel[] drinkImage;
    private File[] fileDrinks;

    private JSpinner[] numSpinnerDesserts;
    static private JLabel[] dessertLabel;
    static private JLabel[] dessertImage;
    private File[] fileDesserts;

    private static final int ELEMENTS = 9;
    private static final int DRINK_ELEMENTS = 5;
    private static final int DESSERT_ELEMENTS = 2;

    double total = 0;
    double food1, food2, food3, food4, food5, food6, food7, food8, food9;
    double drink1, drink2, drink3, drink4, drink5;
    double pr, pr1;

    double tax, net;
    double totalForFoods;
    double totalForDrinks;
    double totalForDesserts;
    
    //Set 2 decimal places
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    
    //Set font
    Font f1 = new Font("Forte",Font.BOLD,40);
    Font f2 = new Font("Adobe Caslon Pro",Font.PLAIN,18);
    Font f3 = new Font("Adobe Caslon Pro",Font.BOLD,18);

    public void createAndShowGUI() throws IOException {
        
        //Design frame
        frame = new JFrame("Main Menu");
        frame.setBounds(100, 100, 1150, 770);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(153,153,153));
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
        
        //Design table
        dtm = new DefaultTableModel(0, 0) {
            @Override
            //make jTable non-editable
            public boolean isCellEditable(int row, int column) {
             //all cells false
            return false;
            }
        };
        final String header[] = new String[] { "Item", "Qty", "Price", "Spinner" };
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
        
        profileButton = new JButton("Update Profile");
        profileButton.setBounds(880, 20, 150, 40);
        profileButton.setFont(f3);
        profileButton.setBackground(Color.BLACK);
        profileButton.setForeground(Color.WHITE);
        frame.getContentPane().add(profileButton);
        
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
        addIt1(tabbedPane, "Drinks");
        addIt2(tabbedPane, "Desserts");
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
                } 
                else {
                    //type your code here:
                }
            }
        });
        
        profileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateProfile up = new updateProfile();
                up.setLocationRelativeTo(null);
                up.setVisible(true);
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
            file[5] = new File("src/main/java/com/dcoms/images/kidsSpaghetti.png");
            file[6] = new File("src/main/java/com/dcoms/images/chickenRice.JPG");
            file[7] = new File("src/main/java/com/dcoms/images/thaiFood.jpeg");
            file[8] = new File("src/main/java/com/dcoms/images/vietnamFood.jpg");
            foodLabel[0] = new JLabel("Salad");
            foodLabel[1] = new JLabel("Japanese Noodles");
            foodLabel[2] = new JLabel("Spaghetti");
            foodLabel[3] = new JLabel("Macaroni");
            foodLabel[4] = new JLabel("Ramen Noodles");
            foodLabel[5] = new JLabel("Kids Spaghetti");
            foodLabel[6] = new JLabel("Chicken Rice");
            foodLabel[7] = new JLabel("Thai Food");
            foodLabel[8] = new JLabel("Vietnam Food");
            price[0] = 13.50;
            price[1] = 14.50;
            price[2] = 13.70;
            price[3] = 14.50;
            price[4] = 15.50;
            price[5] = 14.00;
            price[6] = 13.50;
            price[7] = 16.50;
            price[8] = 16.50;
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

    void addIt2(JTabbedPane tabbedPane, String text) throws IOException {
            JPanel panel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            dessertImage = new JLabel[DESSERT_ELEMENTS];
            dessertLabel = new JLabel[DESSERT_ELEMENTS];
            numSpinnerDesserts = new JSpinner[DESSERT_ELEMENTS];
            priceDesserts = new Double[DESSERT_ELEMENTS];

            fileDesserts = new File[DESSERT_ELEMENTS];
            fileDesserts[0] = new File("src/main/java/com/dcoms/images/strawberryCake.jpg");
            fileDesserts[1] = new File("src/main/java/com/dcoms/images/chocolateCake.jpg");

            dessertLabel[0] = new JLabel("Strawberry Cake");
            dessertLabel[1] = new JLabel("Chocolate Cake");

            priceDesserts[0] = 12.50;
            priceDesserts[1] = 13.00;

            for (int i = 0; i < DESSERT_ELEMENTS; i++) {
                    Image image = ImageIO.read(fileDesserts[i]);
                    Image imageScaled = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                    ImageIcon imageIcon = new ImageIcon(imageScaled);
                    SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 10, 1); // value,minimum,maximum,stepSize
                    numSpinnerDesserts[i] = new JSpinner(spnummodel);
                    numSpinnerDesserts[i].addChangeListener(listenerForDesserts);
                    dessertImage[i] = new JLabel(imageIcon);
            }
            gbc.gridx = 0; // gridx 0 represent the most left
            gbc.insets = new Insets(10, 5, 0, 0); // top,left,bottom,right
            for (int i = 0; i < DESSERT_ELEMENTS; i++) {
                    if (i % 3 == 0) {
                            gbc.gridx = 0;
                            gbc.gridy += 2;
                    }
                    panel.add(dessertImage[i], gbc);
                    gbc.gridy++; // gridy---> add one row,for foodLabel
                    panel.add(dessertLabel[i], gbc);
                    dessertLabel[i].setFont(f2);
                    gbc.gridy--; // remove the row
                    gbc.gridx++; // move to next column
                    panel.add(numSpinnerDesserts[i], gbc);
                    gbc.gridx++; // move to next column
                    tabbedPane.addTab(text, panel);
            }

    }

    void addIt1(JTabbedPane tabbedPane, String text) throws IOException {
            JPanel panel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            drinkImage = new JLabel[DRINK_ELEMENTS];
            drinkLabel = new JLabel[DRINK_ELEMENTS];
            numSpinnerDrinks = new JSpinner[DRINK_ELEMENTS];
            priceDrinks = new Double[DRINK_ELEMENTS];

            fileDrinks = new File[DRINK_ELEMENTS];
            fileDrinks[0] = new File("src/main/java/com/dcoms/images/raspberry.jpg");
            fileDrinks[1] = new File("src/main/java/com/dcoms/images/chocolatePudding.jpg");
            fileDrinks[2] = new File("src/main/java/com/dcoms/images/blueHawailan.jpg");
            fileDrinks[3] = new File("src/main/java/com/dcoms/images/Pina.jpg");
            fileDrinks[4] = new File("src/main/java/com/dcoms/images/lemonIce.jpg");

            drinkLabel[0] = new JLabel("Raspberry");
            drinkLabel[1] = new JLabel("Chocolate Pudding");
            drinkLabel[2] = new JLabel("Blue Hawailan");
            drinkLabel[3] = new JLabel("Pina");
            drinkLabel[4] = new JLabel("Lemon Ice");

            priceDrinks[0] = 13.50;
            priceDrinks[1] = 14.50;
            priceDrinks[2] = 13.00;
            priceDrinks[3] = 15.00;
            priceDrinks[4] = 13.00;

            for (int i = 0; i < DRINK_ELEMENTS; i++) {
                    Image image = ImageIO.read(fileDrinks[i]);
                    Image imageScaled = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                    ImageIcon imageIcon = new ImageIcon(imageScaled);
                    SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 10, 1); // value,minimum,maximum,stepSize
                    numSpinnerDrinks[i] = new JSpinner(spnummodel);
                    numSpinnerDrinks[i].addChangeListener(listenerForDrinks);
                    drinkImage[i] = new JLabel(imageIcon);
            }
            gbc.gridx = 0; // gridx 0 represent the most left
            gbc.insets = new Insets(10, 5, 0, 0); // top,left,bottom,right
            for (int i = 0; i < DRINK_ELEMENTS; i++) {
                    if (i % 3 == 0) {
                            gbc.gridx = 0;
                            gbc.gridy += 2;
                    }
                    panel.add(drinkImage[i], gbc);
                    gbc.gridy++; // gridy---> add one row,for foodLabel
                    panel.add(drinkLabel[i], gbc);
                    drinkLabel[i].setFont(f2);
                    gbc.gridy--; // remove the row
                    gbc.gridx++; // move to next column
                    panel.add(numSpinnerDrinks[i], gbc);
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
                                            
                                    } else if (dtm.getValueAt(row, 0).equals("Kids Spaghetti")) {
                                            dtm.setValueAt(quantity, row, 1);
                                            dtm.setValueAt(p6 * quantity, row, 2);
                                            food6 = p6 * quantity;
                                            
                                    } else if (dtm.getValueAt(row, 0).equals("Chicken Rice")) {
                                            dtm.setValueAt(quantity, row, 1); 
                                            dtm.setValueAt(p7 * quantity, row, 2);
                                            food7 = p7 * quantity;
                                            
                                    } else if (dtm.getValueAt(row, 0).equals("Thai Food")) {
                                            dtm.setValueAt(quantity, row, 1); 
                                            dtm.setValueAt(p8 * quantity, row, 2);
                                            food8 = p8 * quantity;
                                            
                                    } else if (dtm.getValueAt(row, 0).equals("Vietnam Food")) {
                                            dtm.setValueAt(quantity, row, 1); 
                                            dtm.setValueAt(p9 * quantity, row, 2);
                                            food9 = p9 * quantity;
                                    }

                                    if (quantity == 0) {
                                            dtm.removeRow(row);
                                    }
                                    totalForFoods = food1 + food2 + food3 + food4 + food5 + food6 + food7 + food8 + food9;
                                    total = totalForFoods + totalForDrinks + totalForDesserts;
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
                                    case "Kids Spaghetti":
                                            p6 = 14.00;
                                            food6 = p6;
                                            break;
                                    case "Chicken Rice":
                                            p7 = 13.50;
                                            food7 = p7;
                                            break;
                                    case "Thai Food":
                                            p8 = 16.50;
                                            food8 = p8;
                                            break;
                                    case "Vietnam Food":
                                            p9 = 16.50;
                                            food9 = p9;
                                            break;
                                    }
                                    totalForFoods = food1 + food2 + food3 + food4 + food5 + food6 + food7 + food8 + food9;
                                    total = totalForFoods + totalForDrinks + totalForDesserts;
                                    textField1.setText("RM" + df2.format(total));
                                    tax = total * 0.06;
                                    textField2.setText("RM" + df2.format(tax));
                                    net = total + tax;
                                    textField3.setText("RM" + df2.format(net));
                                    dtm.addRow(new Object[] { foodLabel[i].getText(), quantity, totalPrice, numSpinner[i] });
                                    return;
                            }

                    }
            }
    };

    ChangeListener listenerForDesserts = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {

                    final int quantity = (int) ((JSpinner) e.getSource()).getValue();
                    final int rows = table.getRowCount();

                    for (int row = 0; row < rows; row++) {
                            if (dtm.getValueAt(row, 3) == e.getSource()) {
                                    if (dtm.getValueAt(row, 0).equals("Strawberry Cake")) {
                                            dtm.setValueAt(quantity, row, 1); // obj, row,
                                            pr = de1 * quantity; // column
                                            dtm.setValueAt(de1 * quantity, row, 2);
                                    } else if (dtm.getValueAt(row, 0).equals("Chocolate Cake")) {
                                            dtm.setValueAt(quantity, row, 1); // obj, row, // column
                                            dtm.setValueAt(de2 * quantity, row, 2);
                                            pr1 = de2 * quantity;
                                    }
                                    if (quantity == 0) {
                                            dtm.removeRow(row);
                                    }
                                    totalForDesserts = pr + pr1;
                                    total = totalForFoods + totalForDrinks + totalForDesserts;
                                    textField1.setText("RM " + df2.format(total));
                                    tax = total * 0.06;
                                    textField2.setText("RM " + df2.format(tax));
                                    net = total + tax;
                                    textField3.setText("RM " + df2.format(net));
                                    return;
                            }
                    }

                    // there was no row with this JSpinner, so we have to add it
                    for (int i = 0; i < DESSERT_ELEMENTS; i++) {
                            // looking for the "clicked" JSpinner
                            if (numSpinnerDesserts[i] == e.getSource()) {
                                    totalPrice = priceDesserts[i];
                                    switch (dessertLabel[i].getText()) {
                                    case "Strawberry Cake":
                                            de1 = 12.50;
                                            pr = de1;
                                            break;
                                    case "Chocolate Cake":
                                            de2 = 13.00;
                                            pr1 = de2;
                                            break;
                                    }
                                    totalForDesserts = pr + pr1;
                                    total = totalForFoods + totalForDrinks + totalForDesserts;
                                    textField1.setText("RM " + df2.format(total));
                                    tax = total * 0.06;
                                    textField2.setText("RM " + df2.format(tax));
                                    net = total + tax;
                                    textField3.setText("RM " + df2.format(net));
                                    dtm.addRow(new Object[] { dessertLabel[i].getText(), quantity, totalPrice, numSpinnerDesserts[i] });
                                    return;
                            }

                    }
            }

    };

    ChangeListener listenerForDrinks = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {

                    final int quantity = (int) ((JSpinner) e.getSource()).getValue();
                    final int rows = table.getRowCount();
                    for (int row = 0; row < rows; row++) {
                            if (dtm.getValueAt(row, 3) == e.getSource()) {
                                    if (dtm.getValueAt(row, 0).equals("Raspberry")) {
                                            dtm.setValueAt(quantity, row, 1);
                                            dtm.setValueAt(d1 * quantity, row, 2);
                                            drink1 = d1 * quantity;

                                    } else if (dtm.getValueAt(row, 0).equals("Chocolate Pudding")) {
                                            dtm.setValueAt(quantity, row, 1); // obj, row, // column
                                            dtm.setValueAt(d2 * quantity, row, 2);
                                            drink2 = d2 * quantity;

                                    } else if (dtm.getValueAt(row, 0).equals("Blue Hawailan")) {
                                            dtm.setValueAt(quantity, row, 1);
                                            dtm.setValueAt(d3 * quantity, row, 2);
                                            drink3 = d3 * quantity;

                                    } else if (dtm.getValueAt(row, 0).equals("Pina")) {
                                            dtm.setValueAt(quantity, row, 1);
                                            dtm.setValueAt(d4 * quantity, row, 2);
                                            drink4 = d4 * quantity;

                                    } else if (dtm.getValueAt(row, 0).equals("Lemon Ice")) {
                                            dtm.setValueAt(quantity, row, 1); 
                                            dtm.setValueAt(d5 * quantity, row, 2);
                                            drink5 = d5 * quantity;
                                    }
                                    if (quantity == 0) {
                                            dtm.removeRow(row);
                                    }
                                    totalForDrinks = drink1 + drink2 + drink3 + drink4 + drink5;
                                    total = totalForFoods + totalForDrinks + totalForDesserts;
                                    textField1.setText("RM " + df2.format(total));
                                    tax = total * 0.06;
                                    textField2.setText("RM " + df2.format(tax));
                                    net = total + tax;
                                    textField3.setText("RM " + df2.format(net));
                                    return;
                            }
                    }

                    // there was no row with this JSpinner, so we have to add it
                    for (int i = 0; i < DRINK_ELEMENTS; i++) {
                            // looking for the "clicked" JSpinner
                            if (numSpinnerDrinks[i] == e.getSource()) {
                                    totalPrice = priceDrinks[i];
                                    switch (drinkLabel[i].getText()) {
                                    case "Raspberry":
                                            d1 = 13.50;
                                            drink1 = d1;
                                            break;
                                    case "Chocolate Pudding":
                                            d2 = 14.50;
                                            drink2 = d2;
                                            break;
                                    case "Blue Hawailan":
                                            d3 = 13.00;
                                            drink3 = d3;
                                            break;
                                    case "Pina":
                                            d4 = 15.00;
                                            drink4 = d4;
                                            break;
                                    case "Lemon Ice":
                                            d5 = 13.00;
                                            drink5 = d5;
                                            break;
                                    }
                                    totalForDrinks = drink1 + drink2 + drink3 + drink4 + drink5;
                                    total = totalForFoods + totalForDrinks + totalForDesserts;
                                    textField1.setText("RM " + df2.format(total));
                                    tax = total * 0.06;
                                    textField2.setText("RM " + df2.format(tax));
                                    net = total + tax;
                                    textField3.setText("RM " + df2.format(net));
                                    dtm.addRow(new Object[] { drinkLabel[i].getText(), quantity, totalPrice, numSpinnerDrinks[i] });
                                    return;
                            }
                    }
            }
    };

    public void setVisible(boolean b) {}
    
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
            .addGap(0, 455, Short.MAX_VALUE)
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
