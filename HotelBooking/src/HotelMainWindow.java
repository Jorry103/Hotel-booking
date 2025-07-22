
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelMainWindow extends JFrame implements ActionListener {
    JButton bookButton, viewBookingsButton;

    public HotelMainWindow() {
        setTitle("Welcome to BlueSky Hotel");
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        
        ImageIcon hotelIcon = new ImageIcon("hotel8.jpg"); 
        Image img = hotelIcon.getImage().getScaledInstance(
            Toolkit.getDefaultToolkit().getScreenSize().width,
            Toolkit.getDefaultToolkit().getScreenSize().height,
            Image.SCALE_SMOOTH
        );

        JLabel backgroundLabel = new JLabel(new ImageIcon(img));
        backgroundLabel.setLayout(null); 
        setContentPane(backgroundLabel);

        
        bookButton = new JButton("Book Now");
        bookButton.setBounds(100, 600, 200, 50);
        styleButton(bookButton);
        bookButton.addActionListener(this);

       
        viewBookingsButton = new JButton("View Bookings");
        viewBookingsButton.setBounds(350, 600, 200, 50);
        styleButton(viewBookingsButton);
        viewBookingsButton.addActionListener(this);

        
        backgroundLabel.add(bookButton);
        backgroundLabel.add(viewBookingsButton);

        setVisible(true);
    }

    private void styleButton(final JButton button) {
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(0, 123, 255));
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 200), 2, true));

        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(new Color(0, 150, 255));
            }

            public void mouseExited(MouseEvent evt) {
                button.setBackground(new Color(0, 123, 255));
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bookButton) {
            new BookingWindow();
        } else if (e.getSource() == viewBookingsButton) {
            new BookingsListWindow();
        }
    }

    public static void main(String[] args) {
        new HotelMainWindow();
    }
}