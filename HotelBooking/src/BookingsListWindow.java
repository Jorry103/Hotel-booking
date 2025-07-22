

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Map;

public class BookingsListWindow extends JFrame {

    private JTable bookingsTable;
    private DefaultTableModel tableModel;

    public BookingsListWindow() {
        setTitle("Current Bookings");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        String[] columns = {"Room Number", "Customer Name", "ID Number", "Room Type", "Days"};
        tableModel = new DefaultTableModel(columns, 0) {
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };

        bookingsTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(bookingsTable);
        add(scrollPane, BorderLayout.CENTER);

        loadBookings();

        setVisible(true);
    }

    private void loadBookings() {
        tableModel.setRowCount(0); 

        for (Map.Entry<Integer, BookingsManager.Booking> entry : BookingsManager.getAllBookings().entrySet()) {
            Integer roomNumber = entry.getKey();
            BookingsManager.Booking booking = entry.getValue();

            Object[] rowData = {
                roomNumber,
                booking.getCustomerName(),
                booking.getIdNumber(),
                booking.getRoomType(),
                booking.getDays()
            };

            tableModel.addRow(rowData);
        }
    }
}