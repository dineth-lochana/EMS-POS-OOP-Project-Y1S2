package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class home_view extends JFrame{
    private JButton salesControlButton;
    private JButton ordersControlButton;
    private JButton inventoryControlButton;
    private JButton salesControlButton1;
    private JPanel panelhome;
    private JButton monthlyReportButton;
    private JButton employeeOrderAllocationButton;
    private JButton sendEmailToCustomerButton;
    private JButton sendEmailToEmployeeButton;


    public static void main(String[] args) {
        home_view ui = new home_view();
        ui.setContentPane(ui.panelhome);
        ui.setTitle("Manage Sales");
        ui.setSize(900, 600);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setVisible(true);

    }


    public home_view() {
        salesControlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] test = {};
                supplier_view.main(test);

            }
        });
        ordersControlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] test = {};
                orders_view.main(test);
            }
        });


        inventoryControlButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String[] test = {};
                    Inventory_view.main(test);
                }

        });







        salesControlButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] test = {};
                Employees_view.main(test);
            }
        });



        monthlyReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] test = {};
                MonthlyReportsView.main(test);
            }
        });

        employeeOrderAllocationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] test = {};
                employeeorderallocationView.main(test);
            }
        });


        sendEmailToEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] test = {};
                employeemailnotification.main(test);
            }
        });
        sendEmailToCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] test = {};
                customeremailnotification.main(test);
            }
        });
    }

}
