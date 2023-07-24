package view;

import model.MonthlyReports;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;

import java.util.List;
public class MonthlyReportsView extends JFrame{

    private JLabel monthlbl;
    private JTextField monthtxt;
    private JButton submit;
    private JPanel backPanel;
    private JTextField yeartxt;
    private JLabel enterYearLabel;
    private JComboBox comboBox1;
    private JTextArea ordersTextArea;


    private MonthlyReports monthlyReports;
public MonthlyReportsView(MonthlyReports monthlyReports) {
    this.monthlyReports = monthlyReports;
    submit.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            String year = yeartxt.getText();
            String month = (String) comboBox1.getSelectedItem();
            try {
                List<String> ordersList = monthlyReports.getOrdersForMonth(month,year);
                if (ordersList.isEmpty()) {

                    JOptionPane.showMessageDialog(backPanel, "No orders found for the given  month and year.");
                } else {
                    StringBuilder sb = new StringBuilder();
                    for (String orderDetails : ordersList) {
                        sb.append(orderDetails).append("\n");
                    }

                    ordersTextArea.setText(sb.toString());

                }
            } catch (SQLException ex) {

                ex.printStackTrace();
                JOptionPane.showMessageDialog(backPanel, "An error occurred while fetching the data from the database.\n"+ ex.getMessage());
            }

        }
    });

}
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MonthlyReports  EOA = new MonthlyReports ();
                MonthlyReportsView ui = new MonthlyReportsView(EOA);
                ui.setContentPane(ui.backPanel);
                ui.setTitle("Monthly Reports sales Reports");
                ui.setSize(500, 200);
                ui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                ui.setVisible(true);
            }
        });
    }


}

