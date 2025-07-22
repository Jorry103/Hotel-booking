

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BookingWindow extends JFrame implements ActionListener {
    private JTextField nameField, idField, daysField;
    private JComboBox<String> roomTypeBox;
    private JButton submitBtn;

    public BookingWindow() {
        setTitle("New Booking");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        add(new JLabel("Customer Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("ID/Phone Number:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("Number of Days:"));
        daysField = new JTextField();
        add(daysField);

        add(new JLabel("Room Type:"));
        roomTypeBox = new JComboBox(new String[]{"Single", "Double", "Suite"});
        add(roomTypeBox);

        submitBtn = new JButton("Confirm Booking");
        submitBtn.addActionListener(this);
        add(new JLabel());
        add(submitBtn);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText().trim();
        String id = idField.getText().trim();
        String daysStr = daysField.getText().trim();
        String roomType = (String) roomTypeBox.getSelectedItem();

        if (name.isEmpty() || id.isEmpty() || daysStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.");
            return;
        }

        int days;
        try {
            days = Integer.parseInt(daysStr);
            if (days <= 0) throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter a valid positive number of days.");
            return;
        }

        int roomNumber = BookingsManager.bookRoom(roomType,
                new BookingsManager.Booking(name, id, days, roomType));

        if (roomNumber == -1) {
            JOptionPane.showMessageDialog(this, "Sorry, no available rooms for the selected type.");
            return;
        }

        JOptionPane.showMessageDialog(this,
                "Booking confirmed!\nRoom Number: " + roomNumber +
                        "\nCustomer: " + name +
                        "\nDays: " + days);

        
        new BookingsListWindow();

       
        dispose();
    }
}