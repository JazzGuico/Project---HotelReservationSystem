package HotelReservationSystem;

import javax.swing.*;
import java.awt.*;

public class BookingPanel extends JPanel {

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
        
        JPanel panpan = new JPanel();
        panpan.setBounds(120, 120, 1040, 430);
        panpan.setBackground(new Color(0xfaedcd));
        panpan.setLayout(null);
        add(panpan);
    }
}