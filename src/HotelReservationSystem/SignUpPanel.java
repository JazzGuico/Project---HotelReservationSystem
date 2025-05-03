package HotelReservationSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SignUpPanel extends JPanel {
    
    private JPanel mysignupPanel;
    private JPanel containerchoose;
    private JPanel hline;
    private JPanel vline;

    private JPanel cardPanel;
    private CardLayout SigninCardLayout;
    private JPanel myloginPanel;

    private JLabel fname;
    private JLabel lname;
    private JLabel signpass;
    private JLabel signuser;

    private JTextField inputfname;
    private JTextField inputlname;
    private JTextField inputsignuser;
    private JPasswordField inputsignpass;

    //variable for  the loggedIn variable and currentUser
    public static boolean isLoggedIn = false;
    public static String currentUser = null;

    public SignUpPanel() {
        setBackground(new Color(0xFDF0D5));
        setLayout(null);

        containerchoose = new JPanel();
        containerchoose.setBounds(330, 80, 580, 40);
        containerchoose.setBackground(new Color(0xedf2f4));
        containerchoose.setLayout(null);
        add(containerchoose);

        hline = new JPanel();
        hline.setBounds(0, 39, 580, 1);
        hline.setBackground(new Color(0x2b2d42));
        containerchoose.add(hline);

        vline = new JPanel();
        vline.setBounds(289, 0, 2, 40);
        vline.setBackground(new Color(0x2b2d42));
        containerchoose.add(vline);

        JButton ChooseSignUpButton = new JButton("Sign Up");
        ChooseSignUpButton.setBounds(0, 0, 289, 39);
        ChooseSignUpButton.setBackground(new Color(0x003049));
        ChooseSignUpButton.setForeground(new Color(0xDDA15E));
        ChooseSignUpButton.setFont(new Font("Arial", Font.BOLD, 20));
        ChooseSignUpButton.setFocusPainted(false);
        containerchoose.add(ChooseSignUpButton);

        JButton ChooseLoginUpButton = new JButton("Log in");
        ChooseLoginUpButton.setBounds(289, 0, 289, 39);
        ChooseLoginUpButton.setBackground(new Color(0x003049));
        ChooseLoginUpButton.setForeground(new Color(0xDDA15E));
        ChooseLoginUpButton.setFont(new Font("Arial", Font.BOLD, 20));
        ChooseLoginUpButton.setFocusPainted(false);
        containerchoose.add(ChooseLoginUpButton);

        SigninCardLayout = new CardLayout();
        cardPanel = new JPanel(SigninCardLayout);
        cardPanel.setBounds(330, 120, 580, 380);
        add(cardPanel);

        // Sign up panel
        mysignupPanel = new JPanel();
        mysignupPanel.setBackground(new Color(0xedf2f4));
        mysignupPanel.setLayout(null);

        JButton SignSubmit = new JButton("Sign up");
        SignSubmit.setBounds(226, 300, 130, 40);
        SignSubmit.setBackground(new Color(0x2b2d42));
        SignSubmit.setForeground(new Color(0xDDA15E));
        SignSubmit.setFont(new Font("Arial", Font.BOLD, 20));
        SignSubmit.setFocusPainted(false);
        mysignupPanel.add(SignSubmit);

        fname = new JLabel("   First Name:");
        fname.setBounds(32, 52, 256, 30);
        fname.setBackground(new Color(0x2b2d42));
        fname.setForeground(new Color(0xDDA15E));
        fname.setOpaque(true);
        mysignupPanel.add(fname);

        lname = new JLabel("   Last Name:");
        lname.setBounds(32, 116, 256, 30);
        lname.setBackground(new Color(0x2b2d42));
        lname.setForeground(new Color(0xDDA15E));
        lname.setOpaque(true);
        mysignupPanel.add(lname);

        signuser = new JLabel("   Email:");
        signuser.setBounds(32, 180, 256, 30);
        signuser.setBackground(new Color(0x2b2d42));
        signuser.setForeground(new Color(0xDDA15E));
        signuser.setOpaque(true);
        mysignupPanel.add(signuser);

        signpass = new JLabel("   Password:");
        signpass.setBounds(32, 244, 256, 30);
        signpass.setBackground(new Color(0x2b2d42));
        signpass.setForeground(new Color(0xDDA15E));
        signpass.setOpaque(true);
        mysignupPanel.add(signpass);

        inputfname = new JTextField(50);
        inputfname.setBounds(290, 52, 256, 30);
        mysignupPanel.add(inputfname);

        inputlname = new JTextField(50);
        inputlname.setBounds(290, 116, 256, 30);
        mysignupPanel.add(inputlname);

        inputsignuser = new JTextField(50);
        inputsignuser.setBounds(290, 180, 256, 30);
        mysignupPanel.add(inputsignuser);

        JPanel passwordContainer = new JPanel(null);
        passwordContainer.setBounds(290, 244, 256, 30);
        passwordContainer.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        mysignupPanel.add(passwordContainer);
 
        inputsignpass = new JPasswordField();
        inputsignpass.setBounds(0, 0, 220, 30);
        inputsignpass.setEchoChar('•');
        inputsignpass.setBorder(null);
        inputsignpass.setOpaque(false);
        passwordContainer.add(inputsignpass);
 
        JButton togglepass = new JButton("👁");
        togglepass.setBounds(220, 0, 36, 30);
        togglepass.setFocusPainted(false);
        togglepass.setBorder(null);
        togglepass.setContentAreaFilled(false);
        passwordContainer.add(togglepass);
 
        togglepass.addActionListener(e -> {
            if (inputsignpass.getEchoChar() == '\u0000') {
                inputsignpass.setEchoChar('•');
            } else {
                inputsignpass.setEchoChar('\u0000');
            }
        });

        // Log in panel
        myloginPanel = new JPanel();
        myloginPanel.setBackground(new Color(0xedf2f4));
        myloginPanel.setLayout(null);

        JLabel loginUser = new JLabel("   Email:");
        loginUser.setBounds(32, 100, 256, 30);
        loginUser.setOpaque(true);
        loginUser.setBackground(new Color(0x2b2d42));
        loginUser.setForeground(new Color(0xDDA15E));
        myloginPanel.add(loginUser);

        JTextField inputLoginUser = new JTextField();
        inputLoginUser.setBounds(290, 100, 256, 30);
        myloginPanel.add(inputLoginUser);

        JLabel loginPass = new JLabel("   Password:");
        loginPass.setBounds(32, 160, 256, 30);
        loginPass.setOpaque(true);
        loginPass.setBackground(new Color(0x2b2d42));
        loginPass.setForeground(new Color(0xDDA15E));
        myloginPanel.add(loginPass);

        JPasswordField inputLoginPass = new JPasswordField();
        inputLoginPass.setBounds(290, 160, 256, 30);
        inputLoginPass.setEchoChar('•');
        myloginPanel.add(inputLoginPass);

        JButton LoginSubmit = new JButton("Log in");
        LoginSubmit.setBounds(226, 300, 130, 40);
        LoginSubmit.setBackground(new Color(0x2b2d42));
        LoginSubmit.setForeground(new Color(0xDDA15E));
        LoginSubmit.setFont(new Font("Arial", Font.BOLD, 20));
        LoginSubmit.setFocusPainted(false);
        myloginPanel.add(LoginSubmit);
        
        // Login function
        LoginSubmit.addActionListener(e -> {
            String email = inputLoginUser.getText().trim();
            String password = new String(inputLoginPass.getPassword());

            if (email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in both fields.", "Missing Input", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Connection conn = DBConnection.getConnection();

            if (conn != null) {
                try {
                    String query = "SELECT * FROM users WHERE email = ? AND signpass = ?";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setString(1, email);
                    stmt.setString(2, password);

                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        String firstName = rs.getString("fname");
                        JOptionPane.showMessageDialog(this, "Welcome back, " + firstName + "!", "Login Successful", JOptionPane.INFORMATION_MESSAGE);
                        isLoggedIn = true;
                        currentUser = email; // Store user info for later use
                        // TODO: Redirect to booking page or dashboard after login
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid email or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                    }

                    rs.close();
                    stmt.close();
                    conn.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Database connection not available.", "Connection Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        cardPanel.add(mysignupPanel, "SignUp");
        cardPanel.add(myloginPanel, "Login");

        SigninCardLayout.show(cardPanel, "SignUp");
        ChooseSignUpButton.addActionListener(e -> SigninCardLayout.show(cardPanel, "SignUp"));
        ChooseLoginUpButton.addActionListener(e -> SigninCardLayout.show(cardPanel, "Login"));

        // Sign up button action
        SignSubmit.addActionListener(e -> signUpUser());
    }

    // SignUp function
    private void signUpUser() {
        String fname = inputfname.getText();
        String lname = inputlname.getText();
        String email = inputsignuser.getText();
        String password = new String(inputsignpass.getPassword());

        Connection conn = DBConnection.getConnection();

        if (conn != null) {
            try {
                String sql = "INSERT INTO users (fname, lname, email, signpass) VALUES (?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, fname);
                stmt.setString(2, lname);
                stmt.setString(3, email);
                stmt.setString(4, password);

                int rowsInserted = stmt.executeUpdate();
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(this, "User registered successfully!");
                } else {
                    JOptionPane.showMessageDialog(this, "Registration failed.");
                }

                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Database connection not available.");
        }
    }
}
