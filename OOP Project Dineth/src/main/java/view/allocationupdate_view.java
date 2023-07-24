package view;


import model.EmployeeOrderAllocation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class allocationupdate_view extends JFrame{
    private JTextField emptxt;
    private JTextField oidtxt;
    private JButton deleteButton;
    private JLabel orderIDLabel;
    private JLabel employeeIDLabel;
    public JPanel aloupdatepannel;

    private EmployeeOrderAllocation deleteallo;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/oopfinal";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public allocationupdate_view(EmployeeOrderAllocation deleteallo) {
        this.deleteallo = deleteallo;

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);


                    int employeeId = Integer.parseInt(emptxt.getText());
                    int orderId = Integer.parseInt(oidtxt.getText());


                    boolean ValidEmployee = deleteallo.checkEmployeeId(connection, employeeId);
                    boolean ValidOrder = deleteallo.checkOrderId(connection, orderId);

                    if (ValidEmployee && ValidOrder) {

                        deleteallo.Delete(connection, employeeId, orderId);
                        JOptionPane.showMessageDialog(aloupdatepannel, "Employee allocation successfully updated.");
                    } else {
                        JOptionPane.showMessageDialog(aloupdatepannel, "Invalid employee ID or order ID.");
                    }
                } catch (SQLException ec) {
                    ec.printStackTrace();
                    JOptionPane.showMessageDialog(aloupdatepannel, "An error occurred while processing the allocation.");
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(aloupdatepannel, "Enter a valid number.");
                }
            }
        });
    }
}
