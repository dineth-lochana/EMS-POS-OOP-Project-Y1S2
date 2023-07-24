package view;

import model.EmployeeOrderAllocation;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class employeeorderallocationView extends JFrame {
    private JTextField employeeIdField;
    private JTextField orderIdField;
    private JButton allocateButton;
    private JLabel orderIdLabel;
    private JLabel employeeIdLabel;
    JPanel backPanel;
    private JButton deleteAllocationButton;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/oopfinal";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    private EmployeeOrderAllocation EOA;



public employeeorderallocationView(EmployeeOrderAllocation EOA) {
    this.EOA = EOA;
    allocateButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Connect to the database
                Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);



                // Get user input for employee ID and order ID
                int employeeId = Integer.parseInt(employeeIdField.getText());
                int orderId = Integer.parseInt(orderIdField.getText());

                // Check if the employee ID and order ID are valid
                boolean ValidEmployee = EOA.checkEmployeeId(connection, employeeId);
                boolean ValidOrder = EOA.checkOrderId(connection, orderId);

                if (ValidEmployee && ValidOrder) {
                    // Insert the employee ID and order ID into the allocation table
                    EOA.insertAllocation(connection, employeeId, orderId);
                    JOptionPane.showMessageDialog(backPanel, "Employee successfully allocated to the order.");
                } else {
                    JOptionPane.showMessageDialog(backPanel, "Invalid employee ID or order ID.");
                }



            } catch (SQLException ec) {
                ec.printStackTrace();
                JOptionPane.showMessageDialog(backPanel, "An error occurred while processing the allocation.");
            }
            catch (NumberFormatException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(backPanel, "Enter valid number.");
            }

        }
    });

    deleteAllocationButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            EmployeeOrderAllocation employeeOrderAllocation = new EmployeeOrderAllocation();
            allocationupdate_view updtframe = new allocationupdate_view(employeeOrderAllocation);
            updtframe.setContentPane(updtframe.aloupdatepannel);
            updtframe.setTitle("Delete orders");
            updtframe.setSize(400,400);
            updtframe.setVisible(true);
            updtframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        }
    });
}
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                EmployeeOrderAllocation EOA = new EmployeeOrderAllocation();
                employeeorderallocationView ui = new employeeorderallocationView(EOA);
                ui.setContentPane(ui.backPanel);
                ui.setTitle("Employee Order Allocation");
                ui.setSize(500, 500);
                ui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                ui.setVisible(true);
            }
        });
    }
}
