import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Management extends JFrame implements ActionListener {

    JPanel panel;
    JButton adminButton, managerButton, productManagementButton, reportButton, backButton;
    Registration r1;

    public Management() {
        super("Shop Management and Details.");
        this.setSize(1510, 1150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon ic = new ImageIcon(
                "D:\\Study\\3rd semester fall 2024\\OBJECT ORIENTED PROGRAMMING 1 (JAVA)\\Final\\Java Project\\stock-vector-concept-of-teamwork.jpg");
        Image backimage = ic.getImage();

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponents(g);
                g.drawImage(backimage, 0, 0, 1501, 1110, this);
            }
        };

        panel.setLayout(null);

        adminButton = new JButton("Admin");
        adminButton.setBounds(400, 160, 200, 40);
        adminButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Hello,Admin");
        });
        panel.add(adminButton);

        managerButton = new JButton("Manager");
        managerButton.setBounds(400, 220, 200, 40);
        managerButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Hello,Manager");
        });
        panel.add(managerButton);

        productManagementButton = new JButton("Product Management");
        productManagementButton.setBounds(400, 280, 200, 40);
        productManagementButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Product Management Section Under Development!");
        });
        panel.add(productManagementButton);

        reportButton = new JButton("View Reports");
        reportButton.setBounds(400, 340, 200, 40);
        reportButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Reports Section Under Development!");
        });
        panel.add(reportButton);

        backButton = new JButton("Back");
        backButton.setBounds(400, 400, 200, 40);
        backButton.addActionListener(this);
        panel.add(backButton);

        this.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == backButton) {
            r1 = new Registration();
            r1.setVisible(true);
            this.setVisible(false);

        }
    }

}
