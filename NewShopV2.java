import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class NewShopV2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SplashScreen());
    }
}

class SplashScreen extends JFrame {
    public SplashScreen() {
        setTitle("Welcome to NEW SHOP V2");
        setSize(1400, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        ImageIcon ic = new ImageIcon(
                "D:\\Study\\3rd semester fall 2024\\OBJECT ORIENTED PROGRAMMING 1 (JAVA)\\Final\\Java Project\\shopping-in-turkey-spice-bazaar.jpg");
        Image backimage = ic.getImage();

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponents(g);
                g.drawImage(backimage, 0, 0, 1370, 980, this);
            }
        };

        JLabel welcomeLabel = new JLabel("Start Shopping");
        welcomeLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 48));
        welcomeLabel.setForeground(Color.GREEN);
        welcomeLabel.setBounds(700, 500, 200, 50);
        panel.add(welcomeLabel);

        JButton startButton = new JButton("Start Shopping");
        startButton.setFont(new Font("Arial", Font.BOLD, 20));
        startButton.setBackground(Color.ORANGE);
        startButton.setFocusPainted(false);
        startButton.addActionListener(e -> {
            dispose();
            new MainWindow();
        });
        add(startButton, BorderLayout.SOUTH);
        this.add(panel);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class MainWindow extends JFrame implements ActionListener {
    Registration r;
    JButton backButton;

    public MainWindow() {
        setTitle("NEW SHOP V2");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        Color myColor = new Color(250, 220, 135);

        JPanel panel = new JPanel();
        panel.setBackground(myColor);
        panel.setLayout(null);
        panel.setBounds(0, 0, getWidth(), getHeight());
        add(panel);

        JLabel titleLabel = new JLabel("NEW SHOP V2", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 32));
        titleLabel.setBounds(250, 20, 300, 50);
        add(titleLabel);

        JButton groceryButton = createCategoryButton("Grocery Items", 150,
                () -> new CategoryWindow("Grocery Items", getGroceryProducts()));
        JButton electronicButton = createCategoryButton("Electronic Items", 220,
                () -> new CategoryWindow("Electronic Items", getElectronicProducts()));
        JButton sportsButton = createCategoryButton("Sports Items", 290,
                () -> new CategoryWindow("Sports Items", getSportsProducts()));
        JButton medicineButton = createCategoryButton("Medicine", 360,
                () -> new CategoryWindow("Medicine", getMedicineProducts()));

        backButton = new JButton("Back");
        backButton.setBounds(300, 430, 200, 40);
        backButton.setForeground(Color.DARK_GRAY);
        backButton.addActionListener((ActionListener) this);
        panel.add(backButton);

        add(groceryButton);
        add(electronicButton);
        add(sportsButton);
        add(medicineButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == backButton) {
            r = new Registration();
            r.setVisible(true);
            this.setVisible(false);

        }
    }

    private JButton createCategoryButton(String text, int y, Runnable action) {
        JButton button = new JButton(text);
        button.setBounds(300, y, 200, 50);
        button.setBackground(Color.LIGHT_GRAY);
        button.addActionListener(e -> {
            dispose();
            action.run();
        });
        return button;
    }

    private String[] getGroceryProducts() {
        return new String[] { "Rice - 50 BDT/kg", "Oil - 180 BDT/L", "Sugar - 80 BDT/kg", "Flour - 50 BDT/kg",
                "Milk - 70 BDT/L", "Eggs - 12 BDT/each", "Tea - 500 BDT/kg", "Salt - 20 BDT/kg", "Potato - 30 BDT/kg",
                "Tomato - 40 BDT/kg", "Onion - 50 BDT/kg", "Garlic - 120 BDT/kg", "Ginger - 100 BDT/kg",
                "Apple - 150 BDT/kg", "Banana - 10 BDT/ each", "Orange - 120 BDT/kg", "Chicken - 200 BDT/kg",
                "Fish - 300 BDT/kg", "Beef - 600 BDT/kg", "Mutton - 800 BDT/kg", "Bread - 40 BDT/pack",
                "Butter - 300 BDT/kg", "Cheese - 400 BDT/kg", "Juice - 100 BDT/L", "Biscuits - 50 BDT/pack" };
    }

    private String[] getElectronicProducts() {
        return new String[] { "Laptop - 50000 BDT", "Smartphone - 20000 BDT", "Tablet - 15000 BDT",
                "Headphones - 3000 BDT", "Smartwatch - 5000 BDT", "TV - 40000 BDT", "Refrigerator - 60000 BDT",
                "Washing Machine - 35000 BDT", "Microwave - 15000 BDT", "Air Conditioner - 50000 BDT",
                "Vacuum Cleaner - 10000 BDT", "Printer - 8000 BDT", "Camera - 25000 BDT", "Speaker - 7000 BDT",
                "Keyboard - 2000 BDT", "Mouse - 1000 BDT", "Monitor - 15000 BDT", "Hard Drive - 5000 BDT",
                "SSD - 7000 BDT", "Power Bank - 3000 BDT", "Charger - 1000 BDT", "Earbuds - 2000 BDT",
                "Tripod - 1500 BDT", "Projector - 30000 BDT", "Router - 2000 BDT" };
    }

    private String[] getSportsProducts() {
        return new String[] { "Cricket Bat - 3000 BDT", "Football - 1500 BDT", "Badminton Racket - 1000 BDT",
                "Tennis Ball - 500 BDT", "Basketball - 2000 BDT", "Volleyball - 1800 BDT",
                "Table Tennis Set - 2500 BDT", "Dumbbells - 3000 BDT", "Yoga Mat - 1200 BDT", "Skipping Rope - 500 BDT",
                "Hockey Stick - 3500 BDT", "Gloves - 800 BDT", "Running Shoes - 5000 BDT", "Track Suit - 3000 BDT",
                "Sports Bag - 2000 BDT", "Helmet - 1500 BDT", "Shuttlecock - 300 BDT", "Net - 1000 BDT",
                "Wristband - 200 BDT", "Headband - 300 BDT", "Sweatband - 150 BDT", "Cap - 500 BDT",
                "Jersey - 2000 BDT", "Arm Guard - 700 BDT", "Shin Guard - 900 BDT" };
    }

    private String[] getMedicineProducts() {
        return new String[] { "Paracetamol - 20 BDT", "Antacid - 15 BDT", "Cough Syrup - 50 BDT", "Vitamin C - 10 BDT",
                "Pain Relief Gel - 100 BDT", "Bandage - 50 BDT", "Antibiotic - 200 BDT", "Insulin - 500 BDT",
                "Blood Pressure Monitor - 2000 BDT", "Thermometer - 300 BDT", "Glucose - 50 BDT",
                "First Aid Kit - 500 BDT", "Multivitamin - 150 BDT", "Eye Drops - 100 BDT", "Nasal Spray - 120 BDT",
                "Inhaler - 250 BDT", "Ear Drops - 80 BDT", "Skin Cream - 150 BDT", "Sunscreen - 300 BDT",
                "Diabetes Test Kit - 1500 BDT", "Painkiller Tablet - 30 BDT", "Antiseptic Liquid - 70 BDT",
                "Hair Tonic - 200 BDT", "Foot Cream - 250 BDT", "Ointment - 90 BDT" };
    }
}

class CategoryWindow extends JFrame {
    private ArrayList<Object[]> cart;

    public CategoryWindow(String category, String[] products) {
        cart = new ArrayList<>();
        setTitle(category + " - NEW SHOP V2");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBorder(BorderFactory.createTitledBorder(category));

        DefaultListModel<String> productListModel = new DefaultListModel<>();
        for (String product : products) {
            productListModel.addElement(product);
        }

        JList<String> productList = new JList<>(productListModel);
        leftPanel.add(new JScrollPane(productList), BorderLayout.CENTER);
        add(leftPanel, BorderLayout.WEST);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createTitledBorder("Cart"));

        DefaultTableModel tableModel = new DefaultTableModel(new String[] { "Product", "Quantity", "Price", "Total" },
                0);
        JTable cartTable = new JTable(tableModel);
        centerPanel.add(new JScrollPane(cartTable), BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout());

        JButton addToCartButton = new JButton("Add to Cart");
        JButton getBillButton = new JButton("Get Bill");
        JButton backButton = new JButton("Back");

        bottomPanel.add(addToCartButton);
        bottomPanel.add(getBillButton);
        bottomPanel.add(backButton);
        add(bottomPanel, BorderLayout.SOUTH);

        addToCartButton.addActionListener(e -> {
            String selectedProduct = productList.getSelectedValue();
            if (selectedProduct != null) {
                openProductDetails(selectedProduct, tableModel);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a product.");
            }
        });

        getBillButton.addActionListener(e -> {
            new BillWindow(cart);
        });

        backButton.addActionListener(e -> {
            dispose();
            new MainWindow();
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void openProductDetails(String product, DefaultTableModel tableModel) {
        JFrame detailFrame = new JFrame("Product Details");
        detailFrame.setSize(400, 300);
        detailFrame.setLayout(new GridLayout(4, 2));

        JLabel productLabel = new JLabel("Product: ");
        JTextField productField = new JTextField(product);
        productField.setEditable(false);

        JLabel priceLabel = new JLabel("Price: ");
        JTextField priceField = new JTextField(product.split(" - ")[1]);
        priceField.setEditable(false);

        JLabel quantityLabel = new JLabel("Quantity (kg/amount): ");
        JTextField quantityField = new JTextField();
        quantityField.setEditable(true);

        JLabel totalLabel = new JLabel("Total: ");
        JTextField totalField = new JTextField();
        totalField.setEditable(false);

        quantityField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String quantityText = quantityField.getText();
                String priceText = priceField.getText();
                double priceValue;

                if (priceText.contains("/")) {
                    try {
                        priceValue = Double.parseDouble(priceText.split(" ")[0]);

                    } catch (NumberFormatException ex) {
                        totalField.setText("");
                        return;
                    }
                } else {
                    try {
                        priceValue = Double.parseDouble(priceText.replace(" BDT", ""));
                    } catch (NumberFormatException ex) {
                        totalField.setText("");
                        return;
                    }
                }

                if (!quantityText.matches("^[0-9]+(\\.[0-9]+)?$")) {
                    JOptionPane.showMessageDialog(detailFrame, "Please enter a valid quantity (numbers only).");
                    totalField.setText("");
                    return;
                }

                try {
                    double quantityValue = Double.parseDouble(quantityText);
                    totalField.setText((quantityValue * priceValue) + " BDT");
                } catch (NumberFormatException ex) {
                    totalField.setText("");
                }
            }
        });

        JButton addToCartButton = new JButton("Add");
        addToCartButton.addActionListener(e -> {
            String productName = productField.getText();
            String quantity = quantityField.getText();
            String price = priceField.getText();
            String total = totalField.getText();

            if (!quantity.isEmpty() && !total.isEmpty()) {
                Object[] row = new Object[] { productName, quantity, price, total };
                tableModel.addRow(row);
                cart.add(row);
                detailFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(detailFrame, "Please enter a valid quantity.");
            }
        });

        detailFrame.add(productLabel);
        detailFrame.add(productField);
        detailFrame.add(priceLabel);
        detailFrame.add(priceField);
        detailFrame.add(quantityLabel);
        detailFrame.add(quantityField);
        detailFrame.add(totalLabel);
        detailFrame.add(totalField);
        detailFrame.add(addToCartButton);

        detailFrame.setVisible(true);
    }
}

class BillWindow extends JFrame {
    public BillWindow(ArrayList<Object[]> cart) {
        setTitle("Final Bill - NEW SHOP V2");
        setSize(2000, 1200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ImageIcon ic = new ImageIcon(
                "D:\\Study\\3rd semester fall 2024\\OBJECT ORIENTED PROGRAMMING 1 (JAVA)\\Final\\Java Project\\Screenshot 2025-01-23 032526.png");
        Image backimage = ic.getImage();

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponents(g);
                g.drawImage(backimage, 0, 0, 1900, 1110, this);
            }
        };
        panel.setLayout(null);

        JTextArea billArea = new JTextArea();
        billArea.setEditable(false);
        billArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

        double totalAmount = 0;
        for (Object[] row : cart) {
            String productName = (String) row[0];
            String total = (String) row[3];
            billArea.append(productName + " = " + total + "\n");

            String[] parts = total.split(" BDT");
            totalAmount += Double.parseDouble(parts[0]);
        }

        final double finalTotalAmount = totalAmount;
        billArea.append("\nTotal: " + finalTotalAmount + " BDT");

        if (finalTotalAmount > 5000) {
            double discountedAmount = finalTotalAmount * 0.95;
            billArea.append("\nAfter discount.Total amount is: " + discountedAmount + " BDT");

        }

        JButton payButton = new JButton("Pay Button");
        payButton.addActionListener(e -> new PayMathod());

        JButton contactButton = new JButton("Contact Us");
        contactButton.addActionListener(e -> new ContactUsWindow());

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(payButton);
        buttonPanel.add(contactButton);

        add(new JScrollPane(billArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class AboutUsWindow extends JFrame {
    public AboutUsWindow() {
        setTitle("About Us - NEW SHOP V2");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea aboutArea = new JTextArea();
        aboutArea.setEditable(false);
        aboutArea.setFont(new Font("Arial", Font.PLAIN, 14));
        aboutArea.setText(
                "This project is a simple shopping application built using Java Swing. It demonstrates the following concepts:\n\n"
                        +
                        "1. Object-Oriented Programming (OOP): Classes, Objects, Encapsulation\n" +
                        "2. Java Swing: GUI development\n" +
                        "3. Event Handling: ActionListeners\n" +
                        "4. Collections: ArrayList for cart management\n" +
                        "5. Multi-Window Applications: JFrame navigation\n\n" +
                        "Developed as part of a demonstration of software development concepts.");

        add(new JScrollPane(aboutArea));
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class PayMathod extends JFrame {
    public PayMathod() {

        setTitle("Pay the bill by");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        ImageIcon ic = new ImageIcon(
                "D:\\Study\\3rd semester fall 2024\\OBJECT ORIENTED PROGRAMMING 1 (JAVA)\\Final\\Java Project\\download.png");
        Image backimage = ic.getImage();

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponents(g);
                g.drawImage(backimage, 0, 0, 278, 181, this);
            }
        };
        panel.setLayout(null);

        JButton bkashButton = new JButton("Bkash");
        bkashButton.setBounds(400, 160, 200, 30);
        bkashButton.setForeground(Color.PINK);
        bkashButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Payment successful.");
        });
        panel.add(bkashButton);

        JButton nagadButton = new JButton("Nagad");
        nagadButton.setBounds(400, 200, 200, 30);
        nagadButton.setForeground(Color.ORANGE);
        nagadButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Payment successful.");
        });
        panel.add(nagadButton);

        JButton cardButton = new JButton("Card");
        cardButton.setBounds(400, 240, 200, 30);
        cardButton.setForeground(Color.GRAY);
        cardButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Payment successful.");
        });
        panel.add(cardButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(400, 280, 200, 30);
        backButton.addActionListener(e -> {
            dispose();
            new MainWindow();
        });
        panel.add(backButton);

        this.add(panel);
        setLocationRelativeTo(null);
        setVisible(true);

    }
}

class ContactUsWindow extends JFrame {
    public ContactUsWindow() {
        setTitle("Contact Us - NEW SHOP V2");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea contactArea = new JTextArea();
        contactArea.setEditable(false);
        contactArea.setFont(new Font("Arial", Font.PLAIN, 14));
        contactArea.setText("Contact Information:\n\n" +
                "Name: MD SOHANUR RAHMAN SOHAN (23-54611-3)\n" +
                "Name: REDOANUR RAHMAN (24-56984-1)\n" +
                "Name: MOHIMIN SHIKDAR (24-57007-1)\n" +
                "Name: SABBIR HOSSEN TAPADAR (23-54323-3)");

        add(new JScrollPane(contactArea));
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
