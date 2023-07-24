package model;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class MonthlyReports {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/oopfinal";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public List<String> getOrdersForMonth(String month ,String year) throws SQLException {
        List<String> ordersList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT *, SUM(o.amount) AS totalAmount, i.UnitPrice, SUM(o.amount * i.UnitPrice) AS totalPrice FROM orders o, inventory_test i WHERE o.item = i.ItemName AND MONTHNAME(date) = ? AND YEAR(date) = ? GROUP BY o.item";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, month);
            statement.setString(2, year);
            ResultSet resultSet = statement.executeQuery();

            JFrame frame2;
            DefaultTableModel defaultTableModel;
            JTable table1;




            //setting the properties of second JFrame
            frame2 = new JFrame("Monthly Reports sales Reports");
            frame2.setLayout(new FlowLayout());
            frame2.setSize(600, 400);

            defaultTableModel = new DefaultTableModel();
            table1 = new JTable(defaultTableModel);
            table1.setPreferredScrollableViewportSize(new Dimension(500, 100));
            table1.setFillsViewportHeight(true);
            frame2.add(new JScrollPane(table1));

            defaultTableModel.addColumn("item");
            defaultTableModel.addColumn("Total units");
            defaultTableModel.addColumn("Total Price(Rs)");


            double finalTotal = 0.0;



            while (resultSet.next()) {

                String item = resultSet.getString("item");
                int amount = resultSet.getInt("totalAmount");

                double totalPrice = resultSet.getDouble("totalPrice");

                finalTotal += totalPrice;



                defaultTableModel.addRow(new Object[]{ item, amount, totalPrice });//Adding row in Table
                frame2.setVisible(true);
                frame2.validate();


                ordersList.add(item);
            }
            defaultTableModel.addRow(new Object[]{"", "Total sales ",finalTotal});

            frame2.setVisible(true);
            frame2.validate();
        }
        return ordersList;
    }

}
