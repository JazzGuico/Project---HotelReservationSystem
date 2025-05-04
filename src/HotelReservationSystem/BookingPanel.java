package HotelReservationSystem;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class BookingPanel extends JPanel {
    private final JLabel TopMessage1;
    private final JLabel TopMessage2;
    private final JLabel TopMessage3;
    private JLabel roomTypeLabel;
    private JPanel panpan, panpan2, panpan3;
    private Connection conn;

    public BookingPanel() {
        connectToDatabase(); // 🔧 Establish connection first!

        setBackground(new Color(0xFFE5B4));
        setLayout(null);

        // Top message panel
        JPanel TopMessagePanel = new JPanel();
        TopMessagePanel.setBounds(0, 0, 1280, 70);
        TopMessagePanel.setBackground(new Color(0x780000));
        TopMessagePanel.setLayout(null);
        add(TopMessagePanel);

        TopMessage1 = new JLabel("Arrival Date: ");
        TopMessage1.setBounds(50, 5, 300, 15);
        TopMessage1.setForeground(new Color(0xDDA15E));
        TopMessagePanel.add(TopMessage1);

        TopMessage2 = new JLabel("Departure Date: ");
        TopMessage2.setBounds(50, 25, 300, 15);
        TopMessage2.setForeground(new Color(0xDDA15E));
        TopMessagePanel.add(TopMessage2);

        TopMessage3 = new JLabel("Number of Guests: ");
        TopMessage3.setBounds(50, 45, 300, 15);
        TopMessage3.setForeground(new Color(0xDDA15E));
        TopMessagePanel.add(TopMessage3);

        // Log out button
        JButton logoutButton = new JButton("Log Out");
        logoutButton.setBounds(1120, 20, 100, 30);
        logoutButton.setBackground(new Color(0x003049));
        logoutButton.setForeground(new Color(0xFDF0D5));
        logoutButton.setFont(new Font("Arial", Font.BOLD, 14));
        logoutButton.setFocusPainted(false);
        TopMessagePanel.add(logoutButton);

        logoutButton.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Log Out", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                SignUpPanel.isLoggedIn = false;
                JOptionPane.showMessageDialog(this, "You have been logged out.");
                Container parent = getParent();
                if (parent instanceof JPanel) {
                    CardLayout cl = (CardLayout) parent.getLayout();
                    cl.show(parent, "home");
                }
            }
        });

        roomTypeLabel = new JLabel("Single Rooms");
        roomTypeLabel.setBounds(565, 140, 300, 30);
        roomTypeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        roomTypeLabel.setForeground(new Color(0xDDA15E));
        add(roomTypeLabel);

        // Single Rooms Panel
        panpan = createRoomPanel(new int[]{3, 4, 5}, 8, "single");
        JButton nextToDouble = createNavButton("Next →");
        nextToDouble.setBounds(525, 370, 100, 30);
        nextToDouble.addActionListener(e -> switchToPanel("double"));
        panpan.add(nextToDouble);
        add(panpan);

        // Double Rooms Panel
        panpan2 = createRoomPanel(new int[]{6, 7, 8}, 4, "double");
        JButton prevToSingle = createNavButton("← Prev");
        prevToSingle.setBounds(415, 370, 100, 30);
        prevToSingle.addActionListener(e -> switchToPanel("single"));
        panpan2.add(prevToSingle);

        JButton nextToSuite = createNavButton("Next →");
        nextToSuite.setBounds(525, 370, 100, 30);
        nextToSuite.addActionListener(e -> switchToPanel("suite"));
        panpan2.add(nextToSuite);
        panpan2.setVisible(false);
        add(panpan2);

        // Suite Rooms Panel
        panpan3 = createRoomPanel(new int[]{9, 10}, 2, "suite");
        JButton prevToDouble = createNavButton("← Prev");
        prevToDouble.setBounds(415, 370, 100, 30);
        prevToDouble.addActionListener(e -> switchToPanel("double"));
        panpan3.add(prevToDouble);
        panpan3.setVisible(false);
        add(panpan3);
    }

    private void connectToDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/user_management";
            String user = "root";
            String password = "Zyture#15"; // Use your MySQL password
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database connection failed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private JPanel createRoomPanel(int[] floorNumbers, int roomsPerFloor, String roomType) {
        JPanel panel = new JPanel();
        panel.setBounds(120, 120, 1040, 430);
        panel.setBackground(new Color(0xfaedcd));
        panel.setLayout(null);

        int boxWidth = 110;
        int boxHeight = 50;
        int gap = 10;
        int floorY = 60;

        // Adjust box size based on room type
        switch (roomType) {
            case "double":
                boxWidth = 150;
                boxHeight = 60;
                break;
            case "suite":
                boxWidth = 200;
                boxHeight = 90;
                break;
        }

        for (int floor : floorNumbers) {
            JLabel floorLabel = new JLabel("Floor " + floor);
            floorLabel.setBounds(45, floorY, 100, 20);
            floorLabel.setFont(new Font("Arial", Font.BOLD, 14));
            panel.add(floorLabel);

            int x = 45;
            int y = floorY + 25;

            for (int j = 1; j <= roomsPerFloor; j++) {
                int roomNumber = floor * 100 + j;
                boolean available = isRoomAvailable(roomNumber, roomType);

                JLabel box = new JLabel("Room " + roomNumber, SwingConstants.CENTER);
                box.setBounds(x, y, boxWidth, boxHeight);
                box.setOpaque(true);
                box.setBackground(available ? new Color(0xfff3e0) : new Color(0xffcccc));
                box.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
                panel.add(box);

                x += boxWidth + gap;
            }

            floorY = y + boxHeight + 20;
        }

        return panel;
    }

    private boolean isRoomAvailable(int roomNumber, String roomType) {
        String query = "SELECT available FROM rooms WHERE room_number = ? AND room_type = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, roomNumber);
            stmt.setString(2, roomType);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getBoolean("available");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private JButton createNavButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(0xfff3e0));
        button.setForeground(new Color(0xDDA15E));
        return button;
    }

    private void switchToPanel(String panelName) {
        panpan.setVisible(false);
        panpan2.setVisible(false);
        panpan3.setVisible(false);

        switch (panelName) {
            case "double":
                panpan2.setVisible(true);
                roomTypeLabel.setText("Double Rooms");
                break;
            case "suite":
                panpan3.setVisible(true);
                roomTypeLabel.setText("Suite Rooms");
                break;
            default:
                panpan.setVisible(true);
                roomTypeLabel.setText("Single Rooms");
                break;
        }
    }

    public void setBookingInfo(String arrival, String departure, String guests) {
        TopMessage1.setText("Arrival Date: " + arrival);
        TopMessage2.setText("Departure Date: " + departure);
        TopMessage3.setText("Number of Guests: " + guests);
    }
}
