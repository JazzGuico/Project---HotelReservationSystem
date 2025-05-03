package HotelReservationSystem;
 
import javax.swing.*;
import java.awt.*;
 
public class RoomsPanel extends JPanel {
    private CardLayout cardLayout3;
    private JPanel cardPanel2;
 
    public RoomsPanel() {
        setLayout(new BorderLayout());

        cardLayout3 = new CardLayout();
        cardPanel2 = new JPanel(cardLayout3);
 
        //individual pages for each floor (including separate Gym and Café pages)
        JPanel page1 = createPage("1st Floor", "Lobby", "C:\\Users\\Jazz\\Downloads\\lobby.jpg", 920, 480, "0", true, false, false);  
        JPanel page2 = createPage("2nd Floor - Gym", "Gym", "C:\\Users\\Jazz\\Downloads\\gym.jpg", 920, 480, "0", false, false, false);  
        JPanel page3 = createPage("2nd Floor - Café", "Café", "C:\\Users\\Jazz\\Downloads\\cafe.jpg", 920, 480, "0", false, false, false);  
        JPanel page4 = createPage("3-5th Floor", "8 Single Rooms (per floor)", "C:\\Users\\Jazz\\Downloads\\single room.png", 920, 480, "750 per 12 hours", false, false, true);  
        JPanel page5 = createPage("6-8th Floor", "4 Double Rooms (per floor)", "C:\\Users\\Jazz\\Downloads\\double room.jpg", 920, 480, "1400 per 12 hours", false, false, true);  
        JPanel page6 = createPage("9-10th Floor", "2 Suite Rooms (per floor)", "C:\\Users\\Jazz\\Downloads\\suite room.jpg", 920, 480, "3500 per 12 hours", false, true, true); 
        
        cardPanel2.add(page1, "page1");
        cardPanel2.add(page2, "page2");
        cardPanel2.add(page3, "page3");
        cardPanel2.add(page4, "page4");
        cardPanel2.add(page5, "page5");
        cardPanel2.add(page6, "page6");
 
        add(cardPanel2, BorderLayout.CENTER);
    }
 
        //Helper function to create each page with individual image sizes and prices
        private JPanel createPage(String floorName, String roomDescription, String imagePath, int imgWidth, int imgHeight, String price, boolean isFirstPage, boolean isLastPage, boolean showPrice) {
        JPanel page = new JPanel();
        page.setBackground(new Color(0xFDF0D5));
        page.setLayout(null);

        JLabel floorLabel = new JLabel(floorName, SwingConstants.CENTER);
        floorLabel.setFont(new Font("Serif", Font.BOLD, 28));
        floorLabel.setBounds(0, 50, 1280, 40);
        floorLabel.setForeground(new Color(0x6A040F));
        page.add(floorLabel);
 
        JLabel roomLabel = new JLabel("Rooms: " + roomDescription);
        roomLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        roomLabel.setBounds(60, 20, 400, 40);
        roomLabel.setForeground(new Color(0x003049));
        page.add(roomLabel);
 
        //Price label
        if (showPrice) {
            JLabel priceLabel = new JLabel("Price: ₱" + price);
            priceLabel.setFont(new Font("Serif", Font.PLAIN, 20));
            priceLabel.setBounds(60, 55, 350, 40);
            priceLabel.setForeground(new Color(0x003049));
            page.add(priceLabel);
        }
 
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(imgWidth, imgHeight, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setBounds((1280 - imgWidth) / 2, 100, imgWidth, imgHeight);
        page.add(imageLabel);
 
        //Previous button 
        if (!isFirstPage) {
            JButton prevButton = new JButton("Previous");
            prevButton.setBounds(50, 320, 100, 30);
            prevButton.setBackground(new Color(0x003049));
            prevButton.setForeground(new Color(0xFDF0D5));
            prevButton.setFont(new Font("Serif", Font.BOLD, 12));
            prevButton.addActionListener(e -> cardLayout3.previous(cardPanel2));
            page.add(prevButton);
        }
 
        //Next button
        if (!isLastPage) {
            JButton nextButton = new JButton("Next");
            nextButton.setBounds(1130, 320, 100, 30);
            nextButton.setBackground(new Color(0x003049));
            nextButton.setForeground(new Color(0xFDF0D5));
            nextButton.setFont(new Font("Serif", Font.BOLD, 12));
            nextButton.addActionListener(e -> cardLayout3.next(cardPanel2));
            page.add(nextButton);
        }
 
        return page;
    }
 
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Hotel Reservations");
        RoomsPanel roomsPanel = new RoomsPanel();
        frame.add(roomsPanel);
        frame.setSize(1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}