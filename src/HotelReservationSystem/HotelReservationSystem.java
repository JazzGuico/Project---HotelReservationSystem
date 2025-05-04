package HotelReservationSystem;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;

public class HotelReservationSystem {
    private JPanel mainPanel;
    private JPanel Home;
    private JFrame frame;
    private JPanel navbar;
    private JPanel container;
    private JPanel signPanel;
    private JPanel roomPanel;
    private JPanel contactPanel;
    private JPanel bookingPanel;
    private JTextField guestnum;
    private CardLayout cardLayout;
    private JDateChooser arrivaldate;
    private JDateChooser departuredate;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HotelReservationSystem().SMCHotel());
    }

    private void SMCHotel() {
        // Frames and Panels
        frame = new JFrame("SMC HOTEL");
        frame.setSize(1280, 720);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBounds(0, 70, 1280, 650);
        frame.add(mainPanel);

        navbar = new JPanel();
        navbar.setBackground(new Color(0x003049));
        navbar.setBounds(0, 0, 1280, 70);
        navbar.setLayout(null);
        frame.add(navbar);

        Home = new JPanel();
        Home.setBackground(new Color(0xFDF0D5));
        Home.setBounds(0, 70, 1280, 650);
        Home.setLayout(null);
        mainPanel.add(Home, "home");

        container = new JPanel();
        container.setBounds(176, 440, 880, 96);
        container.setBackground(new Color(0xCAF0F8));
        container.setLayout(null);
        Home.add(container);

        // Panels
        bookingPanel = new BookingPanel();
        signPanel = new SignUpPanel(cardLayout, mainPanel, bookingPanel);
        mainPanel.add(signPanel, "signup");

        roomPanel = new RoomsPanel();
        mainPanel.add(roomPanel, "Rooms");

        contactPanel = new ContactPanel();
        mainPanel.add(contactPanel, "Contact");

        mainPanel.add(bookingPanel, "Book");

        // Date choosers
        arrivaldate = new JDateChooser();
        arrivaldate.setDateFormatString("yyyy-MM-dd");
        arrivaldate.setBounds(140, 30, 120, 30);
        container.add(arrivaldate);

        departuredate = new JDateChooser();
        departuredate.setDateFormatString("yyyy-MM-dd");
        departuredate.setBounds(426, 30, 120, 30);
        container.add(departuredate);

        // Labels and images
        ImageIcon HotelIcon = new ImageIcon("C:\\Users\\Jazz\\Downloads\\hotel.png");
        ImageIcon Palawan = new ImageIcon("C:\\Users\\Jazz\\Downloads\\kagayanpalawan.jpg");

        JLabel smc = new JLabel("SMC Hotel", HotelIcon, JLabel.CENTER);
        smc.setBounds(40, 10, 180, 50);
        smc.setFont(new Font("Arial", Font.BOLD, 24));
        smc.setForeground(new Color(0xDDA15E));
        navbar.add(smc);

        JLabel palawanlabel = new JLabel(Palawan);
        palawanlabel.setBounds(0, 0, Palawan.getIconWidth(), 400);
        palawanlabel.setText("WELCOME TO SMC HOTEL");
        palawanlabel.setHorizontalTextPosition(JLabel.CENTER);
        palawanlabel.setVerticalTextPosition(JLabel.CENTER);
        palawanlabel.setFont(new Font("Arial", Font.BOLD, 40));
        palawanlabel.setForeground(new Color(0xFDF0D5));
        Home.add(palawanlabel);

        // Container labels
        JLabel containernav1 = new JLabel(" Arrival Date: ");
        containernav1.setBounds(18, 30, 120, 30);
        containernav1.setFont(new Font("Arial", Font.BOLD, 16));
        containernav1.setBackground(new Color(0x003049));
        containernav1.setForeground(new Color(0xFDF0D5));
        containernav1.setOpaque(true);
        container.add(containernav1);

        JLabel containernav2 = new JLabel(" Departure Date: ");
        containernav2.setBounds(274, 30, 150, 30);
        containernav2.setFont(new Font("Arial", Font.BOLD, 16));
        containernav2.setBackground(new Color(0x003049));
        containernav2.setForeground(new Color(0xFDF0D5));
        containernav2.setOpaque(true);
        container.add(containernav2);

        JLabel containernav3 = new JLabel(" Guests: ");
        containernav3.setBounds(558, 30, 80, 30);
        containernav3.setFont(new Font("Arial", Font.BOLD, 16));
        containernav3.setBackground(new Color(0x003049));
        containernav3.setForeground(new Color(0xFDF0D5));
        containernav3.setOpaque(true);
        container.add(containernav3);

        // Guest number text field
        guestnum = new JTextField(20);
        guestnum.setBounds(640, 30, 50, 30);
        container.add(guestnum);

        // Buttons
        JButton homeButton = new JButton("Home");
        homeButton.setBounds(530, 20, 100, 30);
        homeButton.setForeground(new Color(0xDDA15E));
        homeButton.setBackground(new Color(0x780000));
        homeButton.setFont(new Font("Arial", Font.BOLD, 16));
        homeButton.setFocusPainted(false);
        navbar.add(homeButton);

        JButton rooms = new JButton("Rooms");
        rooms.setBounds(650, 20, 100, 30);
        rooms.setForeground(new Color(0xDDA15E));
        rooms.setBackground(new Color(0x780000));
        rooms.setFont(new Font("Arial", Font.BOLD, 16));
        rooms.setFocusPainted(false);
        navbar.add(rooms);

        JButton contact = new JButton("Contact");
        contact.setBounds(770, 20, 100, 30);
        contact.setForeground(new Color(0xDDA15E));
        contact.setBackground(new Color(0x780000));
        contact.setFont(new Font("Arial", Font.BOLD, 16));
        contact.setFocusPainted(false);
        navbar.add(contact);

        JButton signup = new JButton("Sign up / Log in");
        signup.setBounds(890, 20, 160, 30);
        signup.setForeground(new Color(0xDDA15E));
        signup.setBackground(new Color(0x780000));
        signup.setFont(new Font("Arial", Font.BOLD, 16));
        signup.setFocusPainted(false);
        navbar.add(signup);

        JButton myAccount = new JButton("My Account");
        myAccount.setBounds(1070, 20, 140, 30);
        myAccount.setForeground(new Color(0xDDA15E));
        myAccount.setBackground(new Color(0x780000));
        myAccount.setFont(new Font("Arial", Font.BOLD, 16));
        myAccount.setFocusPainted(false);
        navbar.add(myAccount);

        JButton booking = new JButton("Book now");
        booking.setBounds(712, 30, 140, 30);
        booking.setForeground(new Color(0xFDF0D5));
        booking.setBackground(new Color(0x003049));
        booking.setFont(new Font("Arial", Font.BOLD, 20));
        booking.setFocusPainted(false);
        container.add(booking);

        // Button actions
        signup.addActionListener(e -> cardLayout.show(mainPanel, "signup"));
        homeButton.addActionListener(e -> cardLayout.show(mainPanel, "home"));
        rooms.addActionListener(e -> cardLayout.show(mainPanel, "Rooms"));
        contact.addActionListener(e -> cardLayout.show(mainPanel, "Contact"));
        //booking.addActionListener(e -> cardLayout.show(mainPanel, "Book"));

        booking.addActionListener(e -> {
            if (SignUpPanel.isLoggedIn) {
                String arrival = getArrivalDate();
                String departure = getDepartureDate();
                String guests = getGuestNum();
                ((BookingPanel) bookingPanel).setBookingInfo(arrival, departure, guests);
                cardLayout.show(mainPanel, "Book");
            } else {
                JOptionPane.showMessageDialog(frame, "Please log in to make a booking.", "Login Required", JOptionPane.WARNING_MESSAGE);
                cardLayout.show(mainPanel, "signup");
            }
        });

        myAccount.addActionListener(e -> {
            if (SignUpPanel.isLoggedIn) {
                cardLayout.show(mainPanel, "Book");
            } else {
                JOptionPane.showMessageDialog(frame, "Please log in to access your account.", "Login Required", JOptionPane.WARNING_MESSAGE);
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Getters for date and guest input
    public String getArrivalDate() {
        if (arrivaldate.getDate() != null) {
            return new SimpleDateFormat("yyyy-MM-dd").format(arrivaldate.getDate());
        }
        return "";
    }

    public String getDepartureDate() {
        if (departuredate.getDate() != null) {
            return new SimpleDateFormat("yyyy-MM-dd").format(departuredate.getDate());
        }
        return "";
    }

    public String getGuestNum() {
        return guestnum.getText();
    }
}
