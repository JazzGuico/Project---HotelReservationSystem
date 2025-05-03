package HotelReservationSystem;
 

import javax.swing.*;

import java.awt.*;
 
public class ContactPanel extends JPanel {

    private CardLayout cardLayout = new CardLayout();

    private JPanel cardPanel = new JPanel(cardLayout);
 
    public ContactPanel() {

        setLayout(new BorderLayout());
 
        cardPanel.add(createMainContactPage(), "main");

        cardPanel.add(createRefundOptionsPage(), "refund");

        cardPanel.add(createRefundDetailPage("facebook"), "facebook");

        cardPanel.add(createRefundDetailPage("gmail"), "gmail");

        cardPanel.add(createCustomerServicePage(), "customer_service");
 
        add(cardPanel, BorderLayout.CENTER);

    }
 
    private JPanel createMainContactPage() {

        JPanel panel = createPanel();
 
        panel.add(createButton("REFUND", 20, 20, e -> cardLayout.show(cardPanel, "refund")));

        panel.add(createLabel("Contacts", 540, 150, 24, Font.BOLD));

        panel.add(createLabel("To request a refund, please click the REFUND button and click your preferred contact to see the instruction.", 180, 220, 16, Font.PLAIN));

        panel.add(createLabel("FACEBOOK: SMCHotel", 500, 550, 16, Font.PLAIN));

        panel.add(createLabel("GMAIL: SMCHotel@gmail.com", 500, 580, 16, Font.PLAIN));

        panel.add(createLabel("CONTACT NUMBER: 09123456789", 500, 610, 16, Font.PLAIN));
 
        return panel;

    }
 
    private JPanel createRefundOptionsPage() {

        JPanel panel = createPanel();
 
        panel.add(createLabel("Click your preferred contact to see the instruction:", 370, 180, 20, Font.BOLD));

        panel.add(createButton("Contact via Facebook", 500, 220, e -> cardLayout.show(cardPanel, "facebook")));

        panel.add(createButton("Contact via Gmail", 500, 270, e -> cardLayout.show(cardPanel, "gmail")));
 
        // Removed the refund note here as per your request
 
        panel.add(createButton("Customer Service", 500, 350, e -> cardLayout.show(cardPanel, "customer_service")));

        panel.add(createLabel("Customer Service is available 24/7.", 480, 400, 16, Font.ITALIC));

        panel.add(createButton("Back", 20, 20, e -> cardLayout.show(cardPanel, "main")));
 
        return panel;

    }
 
    private JPanel createRefundDetailPage(String method) {

        JPanel panel = createPanel();
 
        if (method.equals("facebook")) {

            panel.add(createLabel("Please message our official Facebook page: SMCHotel.", 360, 180, 18, Font.PLAIN));

            panel.add(createLabel("Include your booking reference and full name in the message.", 370, 220, 16, Font.PLAIN));

        } else {

            panel.add(createLabel("Send an email to SMCHotel@gmail.com with the following:", 350, 180, 18, Font.PLAIN));

            panel.add(createLabel("- Booking reference number", 420, 220, 16, Font.PLAIN));

            panel.add(createLabel("- Full name used during booking", 420, 250, 16, Font.PLAIN));

            panel.add(createLabel("- Reason for refund", 420, 280, 16, Font.PLAIN));

        }
 
        // Removed the note from here as well
 
        panel.add(createButton("Back", 20, 20, e -> cardLayout.show(cardPanel, "refund")));
 
        return panel;

    }
 
    private JPanel createCustomerServicePage() {

        JPanel panel = createPanel();
 
        panel.add(createLabel("Customer Service - Refund Request", 350, 180, 20, Font.BOLD));
 
        // Username Input

        panel.add(createLabel("Username:", 370, 220, 16, Font.PLAIN));

        JTextField usernameField = new JTextField();

        usernameField.setBounds(500, 220, 250, 30);

        panel.add(usernameField);
 
        // Password Input

        panel.add(createLabel("Password:", 370, 260, 16, Font.PLAIN));

        JPasswordField passwordField = new JPasswordField();

        passwordField.setBounds(500, 260, 250, 30);

        panel.add(passwordField);
 
        // Referral Number Input

        panel.add(createLabel("Referral Number:", 370, 300, 16, Font.PLAIN));

        JTextField referralField = new JTextField();

        referralField.setBounds(500, 300, 250, 30);

        panel.add(referralField);
 
        // Refund Note about deduction (Only here now)

        panel.add(createLabel("Note: 15% will be deducted from the total refund amount due to inconvenience.", 370, 420, 14, Font.ITALIC));
 
        // Submit Button for Refund

        panel.add(createButton("Submit Refund Request", 500, 480, e -> {

            String username = usernameField.getText();

            String password = new String(passwordField.getPassword());

            String referral = referralField.getText();
 
            // Handle the refund request (e.g., print, send to a server, etc.)

            System.out.println("Refund Request Submitted:");

            System.out.println("Username: " + username);

            System.out.println("Referral Number: " + referral);

            // Add any further actions as required

        }));
 
        panel.add(createButton("Back", 20, 20, e -> cardLayout.show(cardPanel, "refund")));
 
        return panel;

    }
 
    private JPanel createPanel() {

        JPanel panel = new JPanel(null);

        panel.setBackground(new Color(0xFFE5B4));

        return panel;

    }
 
    private JLabel createLabel(String text, int x, int y, int size, int style) {

        JLabel label = new JLabel(text);

        label.setFont(new Font("Arial", style, size));

        label.setBounds(x, y, 800, 30);

        return label;

    }
 
    private JButton createButton(String text, int x, int y, java.awt.event.ActionListener action) {

        JButton button = new JButton(text);

        button.setBounds(x, y, 200, 30);

        button.addActionListener(action);

        return button;

    }
 
    public static void main(String[] args) {

        JFrame frame = new JFrame("Contact Page");

        frame.add(new ContactPanel());

        frame.setSize(1280, 720);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

    }

}

 