package HotelReservationSystem;

import javax.swing.*;
import java.awt.*;

public class BookingPanel extends JPanel {

    private JPanel panpan, panpan2, panpan3;
    private JLabel roomTypeLabel;

    public BookingPanel() {
        setBackground(new Color(0xFFE5B4));
        setLayout(null);

        JPanel TopMessagePanel = new JPanel();
        TopMessagePanel.setBounds(0, 0, 1280, 70);
        TopMessagePanel.setBackground(new Color(0x780000));
        TopMessagePanel.setLayout(null);
        add(TopMessagePanel);

        JLabel TopMessage1 = new JLabel("Arrival Date: ");
        TopMessage1.setBounds(50, 5, 120, 15);
        TopMessage1.setForeground(new Color(0xDDA15E));
        TopMessagePanel.add(TopMessage1);

        JLabel TopMessage2 = new JLabel("Departure Date: ");
        TopMessage2.setBounds(50, 25, 120, 15);
        TopMessage2.setForeground(new Color(0xDDA15E));
        TopMessagePanel.add(TopMessage2);

        JLabel TopMessage3 = new JLabel("Number of Guests: ");
        TopMessage3.setBounds(50, 45, 120, 15);
        TopMessage3.setForeground(new Color(0xDDA15E));
        TopMessagePanel.add(TopMessage3);

        roomTypeLabel = new JLabel("Single Rooms");
        roomTypeLabel.setBounds(565, 140, 300, 30);
        roomTypeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        roomTypeLabel.setForeground(new Color(0xDDA15E));
        add(roomTypeLabel);

        // Single Rooms Panel (Floors 3-5, 8 rooms each)
        panpan = createRoomPanel(new int[]{3, 4, 5}, 8, "single");
        JButton nextToDouble = createNavButton("Next →");
        nextToDouble.setBounds(525, 370, 100, 30);
        nextToDouble.addActionListener(e -> switchToPanel("double"));
        panpan.add(nextToDouble);
        add(panpan);

        // Double Rooms Panel (Floors 6-8, 4 rooms each)
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

        // Suite Rooms Panel (Floors 9-10, 2 rooms each)
        panpan3 = createRoomPanel(new int[]{9, 10}, 2, "suite");
        JButton prevToDouble = createNavButton("← Prev");
        prevToDouble.setBounds(415, 370, 100, 30);
        prevToDouble.addActionListener(e -> switchToPanel("double"));
        panpan3.add(prevToDouble);

        panpan3.setVisible(false);
        add(panpan3);
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

        // Adjust the size based on room type
        if (roomType.equals("single")) {
            boxWidth = 110;  // Small size
            boxHeight = 50;
        } else if (roomType.equals("double")) {
            boxWidth = 150;  // Medium size
            boxHeight = 60;  // Reduced height to avoid overlap
        } else if (roomType.equals("suite")) {
            boxWidth = 200;  // Large size
            boxHeight = 90;
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
                JLabel box = new JLabel("Room " + roomNumber, SwingConstants.CENTER);
                box.setBounds(x, y, boxWidth, boxHeight);
                box.setOpaque(true);
                box.setBackground(new Color(0xfff3e0));
                box.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
                panel.add(box);
                x += boxWidth + gap;
            }

            floorY = y + boxHeight + 20;
        }

        return panel;
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
}
