package main.java.com.dcoms.client.customer.mainpage;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;

public class CustomerMainPage extends javax.swing.JFrame {

    public CustomerMainPage() {
        
        initComponents(); 
        
        //initialize jTable 
        DefaultTableModel dtm;
        dtm = (DefaultTableModel)jTable1.getModel();
        dtm.setColumnIdentifiers(new String[]{"Item", "Quantity", "Price (RM)", "Spinner"});
        
        //hide spinner
        jTable1.getColumnModel().getColumn(3).setMinWidth(0); 															// column
        jTable1.getColumnModel().getColumn(3).setMaxWidth(0);
        
        //inialize food images
        //ImageIcon image01 = new ImageIcon("src/Images/Salad.png");
        ImageIcon image01 = new ImageIcon("src/main/resources/images/Salad.png");
        Image img1 = image01.getImage();
        Image img2 = img1.getScaledInstance(jLabel01.getWidth(), jLabel01.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon a = new ImageIcon(img2);
        jLabel01.setIcon(a);
        
        ImageIcon image02 = new ImageIcon("src/main/resources/images/JapanesePanNoodles.png");
        Image img3 = image02.getImage();
        Image img4 = img3.getScaledInstance(jLabel02.getWidth(), jLabel02.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon b = new ImageIcon(img4);
        jLabel02.setIcon(b);
        
        ImageIcon image03 = new ImageIcon("src/main/resources/images/spaghetti.jpg");
        Image img5 = image03.getImage();
        Image img6 = img5.getScaledInstance(jLabel03.getWidth(), jLabel03.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon c = new ImageIcon(img6);
        jLabel03.setIcon(c);
        
        ImageIcon image04 = new ImageIcon("src/main/resources/images/Macaroni.png");
        Image img7 = image04.getImage();
        Image img8 = img7.getScaledInstance(jLabel04.getWidth(), jLabel04.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon d = new ImageIcon(img8);
        jLabel04.setIcon(d);
        
        ImageIcon image05 = new ImageIcon("src/main/resources/images/RamenNoodles.png");
        Image img9 = image05.getImage();
        Image img10 = img9.getScaledInstance(jLabel05.getWidth(), jLabel05.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon e = new ImageIcon(img10);
        jLabel05.setIcon(e);
        
        ImageIcon image06 = new ImageIcon("src/main/resources/images/kidsSpaghetti.png");
        Image img11 = image06.getImage();
        Image img12 = img11.getScaledInstance(jLabel06.getWidth(), jLabel06.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon f = new ImageIcon(img12);
        jLabel06.setIcon(f);
        
        ImageIcon image07 = new ImageIcon("src/main/resources/images/chickenRice.JPG");
        Image img13 = image07.getImage();
        Image img14 = img13.getScaledInstance(jLabel07.getWidth(), jLabel07.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon g = new ImageIcon(img14);
        jLabel07.setIcon(g);
        
        ImageIcon image08 = new ImageIcon("src/main/resources/images/thaiFood.jpeg");
        Image img15 = image08.getImage();
        Image img16 = img15.getScaledInstance(jLabel08.getWidth(), jLabel08.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon h = new ImageIcon(img16);
        jLabel08.setIcon(h);
        
        ImageIcon image09 = new ImageIcon("src/main/resources/images/vietnamFood.jpg");
        Image img17 = image09.getImage();
        Image img18 = img17.getScaledInstance(jLabel09.getWidth(), jLabel09.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon i = new ImageIcon(img18);
        jLabel09.setIcon(i);
        
        ImageIcon image10 = new ImageIcon("src/main/resources/images/raspberry.jpg");
        Image img19 = image10.getImage();
        Image img20 = img19.getScaledInstance(jLabel10.getWidth(), jLabel10.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon j = new ImageIcon(img20);
        jLabel10.setIcon(j);
        
        ImageIcon image11 = new ImageIcon("src/main/resources/images/chocolatePudding.jpg");
        Image img21 = image11.getImage();
        Image img22 = img21.getScaledInstance(jLabel11.getWidth(), jLabel11.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon k = new ImageIcon(img22);
        jLabel11.setIcon(k);
        
        ImageIcon image12 = new ImageIcon("src/main/resources/images/blueHawailan.jpg");
        Image img23 = image12.getImage();
        Image img24 = img23.getScaledInstance(jLabel12.getWidth(), jLabel12.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon l = new ImageIcon(img24);
        jLabel12.setIcon(l);
        
        ImageIcon image13 = new ImageIcon("src/main/resources/images/Pina.jpg");
        Image img25 = image13.getImage();
        Image img26 = img25.getScaledInstance(jLabel13.getWidth(), jLabel13.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon m = new ImageIcon(img26);
        jLabel13.setIcon(m);
        
        ImageIcon image14 = new ImageIcon("src/main/resources/images/lemonIce.jpg");
        Image img27 = image14.getImage();
        Image img28 = img27.getScaledInstance(jLabel14.getWidth(), jLabel14.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon n = new ImageIcon(img28);
        jLabel14.setIcon(n);
        
        ImageIcon image15 = new ImageIcon("src/main/resources/images/strawberryCake.jpg");
        Image img29 = image15.getImage();
        Image img30 = img29.getScaledInstance(jLabel15.getWidth(), jLabel15.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon o = new ImageIcon(img30);
        jLabel15.setIcon(o);
        
        ImageIcon image16 = new ImageIcon("src/main/resources/images/chocolateCake.jpg");
        Image img31 = image16.getImage();
        Image img32 = img31.getScaledInstance(jLabel16.getWidth(), jLabel16.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon p = new ImageIcon(img32);
        jLabel16.setIcon(p);
        
    }
    
    public void foodSpinner(){
        DefaultTableModel dtm;
        dtm = (DefaultTableModel)jTable1.getModel();
        dtm.setColumnIdentifiers(new String[]{"Item", "Quantity", "Price (RM)", "Spinner"});      
        
        JSpinner[] numSpinner;
        int ELEMENTS = 15;
        double food1, food2, food3, food4, food5, food6, food7, food8, food9;
        
        //set food price
        double[] price = new double[ELEMENTS];
        price[0] = 3.50;
        price[1] = 4.50;
        price[2] = 3.70;
        price[3] = 4.50;
        price[4] = 5.50;
        price[5] = 4.00;
        price[6] = 3.50;
        price[7] = 6.50;
        price[8] = 6.50;
        price[9] = 3.50;
        price[10] = 4.50;
        price[11] = 3.00;
        price[12] = 5.00;
        price[13] = 3.00;
        price[14] = 2.50;
        price[15] = 3.00;
        
        numSpinner = new JSpinner[ELEMENTS];
        
        /*for (int i = 0; i < ELEMENTS; i++) {
            numSpinner[i].addChangeListener(listener);
        }*/
        /*int quantity = (int) ((JSpinner) evt.getSource()).getValue();
        int rows = jTable1.getRowCount();
        for (int row = 0; row < rows; row++) {
            if (dtm.getValueAt(row, 3) == evt.getSource()) {
                if (dtm.getValueAt(row, 0).equals("Salad")) {
                        dtm.setValueAt(quantity, row, 1); // obj, row, column
                        //dtm.setValueAt(p1 * quantity, row, 2);
                        //food1 = p1 * quantity;
                }
            //}*/
    }
          
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabelLTitle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPaneMenu = new javax.swing.JTabbedPane();
        jPanelFoods = new javax.swing.JPanel();
        jLabel01 = new javax.swing.JLabel();
        jLabel001 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel05 = new javax.swing.JLabel();
        jLabel06 = new javax.swing.JLabel();
        jLabel04 = new javax.swing.JLabel();
        jLabel02 = new javax.swing.JLabel();
        jLabel03 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        jLabel002 = new javax.swing.JLabel();
        jLabel003 = new javax.swing.JLabel();
        jSpinner3 = new javax.swing.JSpinner();
        jLabel09 = new javax.swing.JLabel();
        jLabel004 = new javax.swing.JLabel();
        jLabel005 = new javax.swing.JLabel();
        jLabel006 = new javax.swing.JLabel();
        jLabel07 = new javax.swing.JLabel();
        jLabel08 = new javax.swing.JLabel();
        jLabel007 = new javax.swing.JLabel();
        jLabel008 = new javax.swing.JLabel();
        jLabel009 = new javax.swing.JLabel();
        jSpinner4 = new javax.swing.JSpinner();
        jSpinner5 = new javax.swing.JSpinner();
        jSpinner6 = new javax.swing.JSpinner();
        jSpinner7 = new javax.swing.JSpinner();
        jSpinner8 = new javax.swing.JSpinner();
        jSpinner9 = new javax.swing.JSpinner();
        jPanelDrinks = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSpinner10 = new javax.swing.JSpinner();
        jSpinner11 = new javax.swing.JSpinner();
        jSpinner12 = new javax.swing.JSpinner();
        jSpinner13 = new javax.swing.JSpinner();
        jSpinner14 = new javax.swing.JSpinner();
        jLabel010 = new javax.swing.JLabel();
        jLabel011 = new javax.swing.JLabel();
        jLabel012 = new javax.swing.JLabel();
        jLabel014 = new javax.swing.JLabel();
        jLabel013 = new javax.swing.JLabel();
        jPanelDesserts = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel015 = new javax.swing.JLabel();
        jLabel016 = new javax.swing.JLabel();
        jSpinner15 = new javax.swing.JSpinner();
        jSpinner16 = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabelsubTotal = new javax.swing.JLabel();
        jTextFieldsubTotal = new javax.swing.JTextField();
        jButtonOrder = new javax.swing.JButton();
        jLabelsubTotal1 = new javax.swing.JLabel();
        jLabelsubTotal2 = new javax.swing.JLabel();
        jTextFieldsubTotal1 = new javax.swing.JTextField();
        jTextFieldsubTotal2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(154, 154, 154));

        jLabelLTitle.setFont(new java.awt.Font("Forte", 1, 40)); // NOI18N
        jLabelLTitle.setText("Welcome to McGee !");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mcg logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addComponent(jLabelLTitle)
                .addGap(410, 410, 410))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPaneMenu.setFont(new java.awt.Font("Adobe Caslon Pro", 0, 20)); // NOI18N

        jPanelFoods.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFoods.setToolTipText("");

        jLabel01.setOpaque(true);

        jLabel001.setFont(new java.awt.Font("Adobe Caslon Pro", 0, 20)); // NOI18N
        jLabel001.setText("Salad");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jLabel05.setOpaque(true);

        jLabel06.setOpaque(true);

        jLabel04.setOpaque(true);

        jLabel02.setOpaque(true);

        jLabel03.setOpaque(true);

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jLabel002.setFont(new java.awt.Font("Adobe Caslon Pro", 0, 20)); // NOI18N
        jLabel002.setText("Japanese Noodles");

        jLabel003.setFont(new java.awt.Font("Adobe Caslon Pro", 0, 20)); // NOI18N
        jLabel003.setText("Spaghetti");

        jSpinner3.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));
        jSpinner3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                CatchValueFromSpinner(evt);
            }
        });

        jLabel09.setOpaque(true);

        jLabel004.setFont(new java.awt.Font("Adobe Caslon Pro", 0, 20)); // NOI18N
        jLabel004.setText("Macaroni");

        jLabel005.setFont(new java.awt.Font("Adobe Caslon Pro", 0, 20)); // NOI18N
        jLabel005.setText("Noodles");

        jLabel006.setFont(new java.awt.Font("Adobe Caslon Pro", 0, 20)); // NOI18N
        jLabel006.setText("Kids Spaghetti");

        jLabel07.setOpaque(true);

        jLabel08.setOpaque(true);

        jLabel007.setFont(new java.awt.Font("Adobe Caslon Pro", 0, 20)); // NOI18N
        jLabel007.setText("Chicken Rice");

        jLabel008.setFont(new java.awt.Font("Adobe Caslon Pro", 0, 20)); // NOI18N
        jLabel008.setText("Thai Food");

        jLabel009.setFont(new java.awt.Font("Adobe Caslon Pro", 0, 20)); // NOI18N
        jLabel009.setText("Vietnam Food");

        jSpinner4.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jSpinner5.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jSpinner6.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jSpinner7.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jSpinner8.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jSpinner9.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        javax.swing.GroupLayout jPanelFoodsLayout = new javax.swing.GroupLayout(jPanelFoods);
        jPanelFoods.setLayout(jPanelFoodsLayout);
        jPanelFoodsLayout.setHorizontalGroup(
            jPanelFoodsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFoodsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFoodsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFoodsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanelFoodsLayout.createSequentialGroup()
                            .addComponent(jLabel04, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelFoodsLayout.createSequentialGroup()
                            .addComponent(jLabel01, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel001)
                    .addComponent(jLabel004)
                    .addGroup(jPanelFoodsLayout.createSequentialGroup()
                        .addComponent(jLabel07, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinner7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel007))
                .addGap(18, 18, 18)
                .addGroup(jPanelFoodsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel002)
                    .addComponent(jLabel005)
                    .addComponent(jLabel008)
                    .addGroup(jPanelFoodsLayout.createSequentialGroup()
                        .addGroup(jPanelFoodsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel02, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel05, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelFoodsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelFoodsLayout.createSequentialGroup()
                        .addComponent(jLabel08, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinner8, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(jPanelFoodsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel009)
                    .addGroup(jPanelFoodsLayout.createSequentialGroup()
                        .addComponent(jLabel09, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinner9, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel006)
                    .addComponent(jLabel003)
                    .addGroup(jPanelFoodsLayout.createSequentialGroup()
                        .addComponent(jLabel06, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinner6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelFoodsLayout.createSequentialGroup()
                        .addComponent(jLabel03, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanelFoodsLayout.setVerticalGroup(
            jPanelFoodsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFoodsLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanelFoodsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelFoodsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFoodsLayout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jSpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(166, 166, 166)
                        .addComponent(jSpinner8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelFoodsLayout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165)
                        .addComponent(jSpinner7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelFoodsLayout.createSequentialGroup()
                .addGroup(jPanelFoodsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFoodsLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelFoodsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel01, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel02, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel03, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanelFoodsLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanelFoodsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel002)
                    .addComponent(jLabel001)
                    .addComponent(jLabel003))
                .addGroup(jPanelFoodsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFoodsLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanelFoodsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel04, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel05, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel06, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelFoodsLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jSpinner6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFoodsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel004)
                    .addComponent(jLabel005)
                    .addComponent(jLabel006))
                .addGroup(jPanelFoodsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFoodsLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanelFoodsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel09, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel07, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel08, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelFoodsLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jSpinner9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFoodsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel007)
                    .addComponent(jLabel008)
                    .addComponent(jLabel009))
                .addGap(414, 414, 414))
        );

        jTabbedPaneMenu.addTab("   Foods   ", jPanelFoods);

        jPanelDrinks.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setOpaque(true);

        jLabel12.setOpaque(true);

        jLabel14.setOpaque(true);

        jLabel10.setOpaque(true);

        jLabel13.setOpaque(true);

        jSpinner10.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jSpinner11.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jSpinner12.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jSpinner13.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jSpinner14.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jLabel010.setFont(new java.awt.Font("Adobe Caslon Pro", 0, 20)); // NOI18N
        jLabel010.setText("Raspberry");

        jLabel011.setFont(new java.awt.Font("Adobe Caslon Pro", 0, 20)); // NOI18N
        jLabel011.setText("Chocolate Pudding");

        jLabel012.setFont(new java.awt.Font("Adobe Caslon Pro", 0, 20)); // NOI18N
        jLabel012.setText("Blue Hawailan");

        jLabel014.setFont(new java.awt.Font("Adobe Caslon Pro", 0, 20)); // NOI18N
        jLabel014.setText("Lemon Ice");

        jLabel013.setFont(new java.awt.Font("Adobe Caslon Pro", 0, 20)); // NOI18N
        jLabel013.setText("Pina");

        javax.swing.GroupLayout jPanelDrinksLayout = new javax.swing.GroupLayout(jPanelDrinks);
        jPanelDrinks.setLayout(jPanelDrinksLayout);
        jPanelDrinksLayout.setHorizontalGroup(
            jPanelDrinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDrinksLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDrinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDrinksLayout.createSequentialGroup()
                        .addGroup(jPanelDrinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDrinksLayout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSpinner10, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel010))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDrinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDrinksLayout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(jSpinner11, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel011))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelDrinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDrinksLayout.createSequentialGroup()
                                .addComponent(jLabel012)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanelDrinksLayout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSpinner12, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(23, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDrinksLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelDrinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDrinksLayout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSpinner13, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel013))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDrinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel014)
                            .addGroup(jPanelDrinksLayout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSpinner14, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(162, 162, 162))))
        );
        jPanelDrinksLayout.setVerticalGroup(
            jPanelDrinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDrinksLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(jPanelDrinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDrinksLayout.createSequentialGroup()
                        .addComponent(jSpinner10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDrinksLayout.createSequentialGroup()
                        .addComponent(jSpinner11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelDrinksLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jSpinner12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(jPanelDrinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDrinksLayout.createSequentialGroup()
                        .addComponent(jLabel010)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel014)
                        .addGap(101, 101, 101))
                    .addGroup(jPanelDrinksLayout.createSequentialGroup()
                        .addGroup(jPanelDrinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDrinksLayout.createSequentialGroup()
                                .addComponent(jLabel011)
                                .addGroup(jPanelDrinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelDrinksLayout.createSequentialGroup()
                                        .addGap(122, 122, 122)
                                        .addComponent(jSpinner13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelDrinksLayout.createSequentialGroup()
                                        .addGap(57, 57, 57)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanelDrinksLayout.createSequentialGroup()
                                .addComponent(jLabel012)
                                .addGap(121, 121, 121)
                                .addComponent(jSpinner14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel013)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPaneMenu.addTab("   Drinks   ", jPanelDrinks);

        jPanelDesserts.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setOpaque(true);

        jLabel16.setOpaque(true);

        jLabel015.setFont(new java.awt.Font("Adobe Caslon Pro", 0, 20)); // NOI18N
        jLabel015.setText("Strawberry Cake");

        jLabel016.setFont(new java.awt.Font("Adobe Caslon Pro", 0, 20)); // NOI18N
        jLabel016.setText("Chocolate Cake");

        jSpinner15.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jSpinner16.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        javax.swing.GroupLayout jPanelDessertsLayout = new javax.swing.GroupLayout(jPanelDesserts);
        jPanelDesserts.setLayout(jPanelDessertsLayout);
        jPanelDessertsLayout.setHorizontalGroup(
            jPanelDessertsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDessertsLayout.createSequentialGroup()
                .addGroup(jPanelDessertsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDessertsLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel015)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDessertsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jSpinner15, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(jPanelDessertsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel016)
                    .addGroup(jPanelDessertsLayout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinner16, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        jPanelDessertsLayout.setVerticalGroup(
            jPanelDessertsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDessertsLayout.createSequentialGroup()
                .addGroup(jPanelDessertsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDessertsLayout.createSequentialGroup()
                        .addGroup(jPanelDessertsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDessertsLayout.createSequentialGroup()
                                .addGap(207, 207, 207)
                                .addComponent(jSpinner15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelDessertsLayout.createSequentialGroup()
                                .addGap(206, 206, 206)
                                .addComponent(jSpinner16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDessertsLayout.createSequentialGroup()
                        .addGroup(jPanelDessertsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanelDessertsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel016)
                    .addComponent(jLabel015))
                .addContainerGap(278, Short.MAX_VALUE))
        );

        jTabbedPaneMenu.addTab("   Desserts   ", jPanelDesserts);

        jLabel3.setFont(new java.awt.Font("Adobe Caslon Pro", 0, 20)); // NOI18N
        jLabel3.setText("Food Ordered:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Salad", null, null, null},
                {"Japanese Noodles", null, null, null},
                {"Spaghetti", null, null, null},
                {"Macaroni", null, null, null},
                {"Noodles", null, null, null},
                {"Kids Spaghetti", null, null, null},
                {"Chicken Rice", null, null, null},
                {"Thai Food", null, null, null},
                {"Raspberry", null, null, null},
                {"Chocolate Pudding", null, null, null},
                {"Blue Hawailan", null, null, null},
                {"Pina", null, null, null},
                {"Lemon Ice", null, null, null},
                {"Strawberry Cake", null, null, null},
                {"Chocolate Cake", null, null, null}
            },
            new String [] {
                "Item", "Quantity", "Price (RM)", "Spinner"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabelsubTotal.setFont(new java.awt.Font("Adobe Caslon Pro", 0, 20)); // NOI18N
        jLabelsubTotal.setText("Sub Total:");

        jButtonOrder.setFont(new java.awt.Font("Adobe Caslon Pro Bold", 1, 24)); // NOI18N
        jButtonOrder.setText("Order");
        jButtonOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOrderActionPerformed(evt);
            }
        });

        jLabelsubTotal1.setFont(new java.awt.Font("Adobe Caslon Pro", 0, 20)); // NOI18N
        jLabelsubTotal1.setText("Service Tax 6%:");

        jLabelsubTotal2.setFont(new java.awt.Font("Adobe Caslon Pro", 0, 20)); // NOI18N
        jLabelsubTotal2.setText("Net Total:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelsubTotal1)
                            .addComponent(jLabelsubTotal2)
                            .addComponent(jLabelsubTotal))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldsubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldsubTotal2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldsubTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(148, 148, 148))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTabbedPaneMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldsubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelsubTotal))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelsubTotal1)
                            .addComponent(jTextFieldsubTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelsubTotal2)
                            .addComponent(jTextFieldsubTotal2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addComponent(jButtonOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOrderActionPerformed
       
    }//GEN-LAST:event_jButtonOrderActionPerformed

    private void CatchValueFromSpinner(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_CatchValueFromSpinner

    }//GEN-LAST:event_CatchValueFromSpinner

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
    private javax.swing.JButton jButtonOrder;
    private javax.swing.JLabel jLabel001;
    private javax.swing.JLabel jLabel002;
    private javax.swing.JLabel jLabel003;
    private javax.swing.JLabel jLabel004;
    private javax.swing.JLabel jLabel005;
    private javax.swing.JLabel jLabel006;
    private javax.swing.JLabel jLabel007;
    private javax.swing.JLabel jLabel008;
    private javax.swing.JLabel jLabel009;
    private javax.swing.JLabel jLabel01;
    private javax.swing.JLabel jLabel010;
    private javax.swing.JLabel jLabel011;
    private javax.swing.JLabel jLabel012;
    private javax.swing.JLabel jLabel013;
    private javax.swing.JLabel jLabel014;
    private javax.swing.JLabel jLabel015;
    private javax.swing.JLabel jLabel016;
    private javax.swing.JLabel jLabel02;
    private javax.swing.JLabel jLabel03;
    private javax.swing.JLabel jLabel04;
    private javax.swing.JLabel jLabel05;
    private javax.swing.JLabel jLabel06;
    private javax.swing.JLabel jLabel07;
    private javax.swing.JLabel jLabel08;
    private javax.swing.JLabel jLabel09;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelLTitle;
    private javax.swing.JLabel jLabelsubTotal;
    private javax.swing.JLabel jLabelsubTotal1;
    private javax.swing.JLabel jLabelsubTotal2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelDesserts;
    private javax.swing.JPanel jPanelDrinks;
    private javax.swing.JPanel jPanelFoods;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner10;
    private javax.swing.JSpinner jSpinner11;
    private javax.swing.JSpinner jSpinner12;
    private javax.swing.JSpinner jSpinner13;
    private javax.swing.JSpinner jSpinner14;
    private javax.swing.JSpinner jSpinner15;
    private javax.swing.JSpinner jSpinner16;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JSpinner jSpinner5;
    private javax.swing.JSpinner jSpinner6;
    private javax.swing.JSpinner jSpinner7;
    private javax.swing.JSpinner jSpinner8;
    private javax.swing.JSpinner jSpinner9;
    private javax.swing.JTabbedPane jTabbedPaneMenu;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldsubTotal;
    private javax.swing.JTextField jTextFieldsubTotal1;
    private javax.swing.JTextField jTextFieldsubTotal2;
    // End of variables declaration//GEN-END:variables
}
