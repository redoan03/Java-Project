import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import javax.swing.event.*;

public class Registration extends JFrame implements ActionListener, MouseInputListener {

    JLabel label, passJLabel, sLabel, spLabel, nlabel, phonelabel;
    JTextField text, firstname, lastname, email, phone;
    JPanel panel;
    JPasswordField passwordField, newpPasswordField, cPasswordField;
    JButton lnButton, suButton, submitBt, exButton;
    Color color;
    Font font;

    public Registration() {
        super("Welcome to our shop.Please Sing-in first");
        this.setSize(1000, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon ic = new ImageIcon(
                "D:\\Study\\3rd semester fall 2024\\OBJECT ORIENTED PROGRAMMING 1 (JAVA)\\Final\\Java Project\\Untitled design (1).png");
        Image backimage = ic.getImage();

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponents(g);
                g.drawImage(backimage, 0, 0, 1280, 980, this);
            }
        };

        panel.setLayout(null);

        color = new Color(200, 200, 200);
        font = new Font("Arial", Font.BOLD, 16);

        label = new JLabel("Sing in");
        label.setBounds(500, 120, 200, 40);
        label.setBackground(Color.BLUE);
        label.setForeground(Color.WHITE);
        label.setFont(font);
        panel.add(label);

        label = new JLabel("Email");
        label.setBounds(450, 140, 200, 40);
        label.setBackground(Color.RED);
        label.setForeground(Color.WHITE);
        label.setFont(font);
        panel.add(label);

        text = new JTextField();
        text.setBounds(450, 170, 150, 30);
        panel.add(text);

        passJLabel = new JLabel("Password");
        passJLabel.setBounds(450, 190, 200, 40);
        passJLabel.setForeground(Color.GREEN);
        passJLabel.setFont(font);
        panel.add(passJLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(450, 220, 150, 30);
        panel.add(passwordField);

        lnButton = new JButton("Login");
        lnButton.setBounds(450, 260, 100, 30);
        lnButton.addMouseListener(this);
        lnButton.addActionListener(this);
        panel.add(lnButton);

        suButton = new JButton("sign up");
        suButton.setBounds(560, 260, 100, 30);
        suButton.addMouseListener(this);
        suButton.addActionListener(this);
        panel.add(suButton);

        this.add(panel);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == lnButton) {
            lnButton.setBackground(Color.BLUE);
            lnButton.setForeground(Color.WHITE);
        } else if (e.getSource() == suButton) {
            suButton.setBackground(Color.GREEN);
            suButton.setForeground(Color.WHITE);
        } else {

        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == lnButton) {
            String mail = text.getText();
            String password = String.valueOf(passwordField.getPassword());
            String userType = validateLogin(mail, password);

            if (userType != null) {
                this.dispose();

                if (userType.equalsIgnoreCase("Customer")) {
                    SwingUtilities.invokeLater(() -> NewShopV2.main(new String[] {}));
                }

                else {

                    Management m = new Management();
                    m.setVisible(true);
                    this.setVisible(false);

                }
            }

            else {
                JOptionPane.showMessageDialog(this, "Invalid email or password!");
            }
        } else if (a.getSource() == suButton) {
            panel.removeAll();
            signup();
            panel.revalidate();
            panel.repaint();
        }
    }

    public void signup() {

        nlabel = new JLabel("Sign up");
        nlabel.setBounds(550, 70, 200, 40);
        nlabel.setBackground(Color.GREEN);
        nlabel.setForeground(Color.BLUE);
        nlabel.setFont(font);
        panel.add(nlabel);

        sLabel = new JLabel("First Name: ");
        sLabel.setBounds(500, 120, 200, 30);
        sLabel.setForeground(Color.CYAN);
        sLabel.setFont(font);
        panel.add(sLabel);

        firstname = new JTextField();
        firstname.setBounds(500, 150, 200, 30);
        panel.add(firstname);

        sLabel = new JLabel("Last Name: ");
        sLabel.setBounds(500, 190, 200, 30);
        sLabel.setForeground(Color.YELLOW);
        sLabel.setFont(font);
        panel.add(sLabel);

        lastname = new JTextField();
        lastname.setBounds(500, 220, 200, 30);
        panel.add(lastname);

        spLabel = new JLabel("Email: ");
        spLabel.setBounds(500, 250, 200, 30);
        spLabel.setForeground(Color.RED);
        spLabel.setFont(font);
        panel.add(spLabel);

        email = new JTextField();
        email.setBounds(500, 280, 200, 30);
        panel.add(email);

        spLabel = new JLabel("Password: ");
        spLabel.setBounds(500, 320, 200, 30);
        spLabel.setForeground(Color.GREEN);
        spLabel.setFont(font);
        panel.add(spLabel);

        newpPasswordField = new JPasswordField();
        newpPasswordField.setBounds(500, 350, 200, 30);
        panel.add(newpPasswordField);

        spLabel = new JLabel("Confirm");
        spLabel.setBounds(500, 380, 200, 30);
        spLabel.setForeground(Color.GRAY);
        spLabel.setFont(font);
        panel.add(spLabel);

        cPasswordField = new JPasswordField();
        cPasswordField.setBounds(500, 410, 200, 30);
        panel.add(cPasswordField);

        phonelabel = new JLabel("Phone Number: ");
        phonelabel.setBounds(500, 440, 200, 30);
        phonelabel.setForeground(Color.ORANGE);
        phonelabel.setFont(font);
        panel.add(phonelabel);

        phone = new JTextField();
        phone.setBounds(500, 470, 200, 30);
        panel.add(phone);

        submitBt = new JButton("Submit");
        submitBt.setBounds(500, 510, 100, 30);

        submitBt.addActionListener(e -> {
            if (validateSignupFields()) {
                saveUserDetails();
                this.dispose();
                SwingUtilities.invokeLater(() -> NewShopV2.main(new String[] {}));
            }
        });
        panel.add(submitBt);

        exButton = new JButton("Back");
        exButton.setBounds(650, 510, 100, 30);
        exButton.addActionListener(e -> {
            panel.removeAll();
            initializeLoginPanel();
            panel.revalidate();
            panel.repaint();
        });
        panel.add(exButton);

    }

    private boolean validateSignupFields() {
        String emailId = email.getText();
        String firstName = firstname.getText();
        String lastName = lastname.getText();
        String password = new String(newpPasswordField.getPassword());
        String confirmPassword = new String(cPasswordField.getPassword());
        String phoneNumber = phone.getText();

        if (emailId.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || password.isEmpty()
                || confirmPassword.isEmpty() || phoneNumber.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all information!");
            return false;
        }

        if (!isValidEmail(emailId)) {
            JOptionPane.showMessageDialog(this, "Invalid email format! Please try again.");
            return false;
        }

        if (isEmailExists(emailId)) {
            JOptionPane.showMessageDialog(this, "User with this email already exists!");
            return false;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match!");
            return false;
        }

        return true;
    }

    private void saveUserDetails() {
        String email = this.email.getText();
        String firstName = firstname.getText();
        String lastName = lastname.getText();
        String password = new String(newpPasswordField.getPassword());
        String confirmPassword = new String(cPasswordField.getPassword());
        String phoneNumber = phone.getText();

        if (email.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || password.isEmpty()
                || confirmPassword.isEmpty() || phoneNumber.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all information.");
            return;
        }

        if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(this, "Invalid email format! Please try again.");
            return;
        }

        if (isEmailExists(email)) {
            JOptionPane.showMessageDialog(this, "User with this email already exists!");
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match!");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("user.txt", true))) {
            writer.write(
                    String.format("Email: %s , Type: %s ,  First Name: %s , Last Name: %s , Password: %s , Phone: %s%n",
                            email, " Customer ", firstName, lastName, password, phoneNumber));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving user details!.Missing information.");
        }
    }

    private boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".com");
    }

    private boolean isEmailExists(String email) {
        return false;
    }

    private String validateLogin(String email, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("user.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] info = line.split("\\,");

                if (info.length >= 6) {
                    String fileEmail = info[0].split(":")[1].trim();
                    String filePassword = info[4].split(":")[1].trim();
                    String fileType = info[1].split(":")[1].trim();

                    if (fileEmail.equals(email) && filePassword.equals(password)) {
                        return fileType;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading user file!");
        }
        return null;
    }

    private void initializeLoginPanel() {
        label = new JLabel("Sing in");
        label.setBounds(500, 120, 200, 40);
        label.setForeground(Color.white);
        label.setFont(font);
        panel.add(label);

        label = new JLabel("Email");
        label.setBounds(450, 140, 200, 40);
        label.setForeground(Color.white);
        label.setFont(font);
        panel.add(label);

        text = new JTextField();
        text.setBounds(450, 170, 150, 30);
        panel.add(text);

        passJLabel = new JLabel("Password");
        passJLabel.setBounds(450, 190, 200, 40);
        passJLabel.setForeground(Color.white);
        passJLabel.setFont(font);
        panel.add(passJLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(450, 220, 150, 30);
        panel.add(passwordField);

        lnButton = new JButton("Login");
        lnButton.setBounds(450, 260, 100, 30);
        lnButton.addMouseListener(this);
        lnButton.addActionListener(this);
        panel.add(lnButton);

        suButton = new JButton("sign up");
        suButton.setBounds(560, 260, 100, 30);
        suButton.addMouseListener(this);
        suButton.addActionListener(this);
        panel.add(suButton);
    }

}
