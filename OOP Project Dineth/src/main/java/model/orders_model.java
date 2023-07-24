package model;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

/**
 * The Model in the MVC model is the simpliest to implement.
 * All the data should be stored in the Model and any changes
 * will be updated in the Model class. That's why if you need
 * an int or a String that needs to be stored, you just have
 * to declare it in the Model as private and use getters and
 * setters to fetch or update the data, just like what you
 * would do in a query in a database.
 */

public class orders_model {

    private String txt;
    private int number;

    public String getTxt() {
        return txt;
    }

    public void setText(String txt) {
        this.txt = txt;
    }

    public void insertorder(int id, String item, int amount,String contact, String date)
    {
        /**
         * Trying to add some Database Stuff
         */
        String DB_URL = "jdbc:mysql://localhost:3306/oopfinal";
        String USER = "root";
        String PASS = "";

        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            // Execute a query
            String sql = "INSERT INTO `orders` values ('"+id+"','"+item+"','"+amount+"','"+contact+"','"+date+"')";
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();


        }
    }

    public void updateorder(int id, String item, int amount,String contact, String date)
    {
        /**
         * Trying to add some Database Stuff
         */
        String DB_URL = "jdbc:mysql://localhost:3306/oopfinal";
        String USER = "root";
        String PASS = "";

        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            // Execute a query
            String sql = "UPDATE orders SET item = '"+item+"' ,Amount = '"+amount+"', contact = '"+contact+"', date = '"+date+"' WHERE orderID = '"+id+"' ";
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();


        }
    }

    public void deleteorder(int id, String item, int amount,String contact, String date)
    {

        /**
         * Trying to add some Database Stuff
         */
        String DB_URL = "jdbc:mysql://localhost:3306/oopfinal";
        String USER = "root";
        String PASS = "";

        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            // Execute a query
            String sql = "delete from orders WHERE orderID = '"+id+"' ";
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();


        }
    }

    public static void showdb()
    {

        JFrame frame2;//creating object of second JFrame
        DefaultTableModel defaultTableModel;//creating object of DefaultTableModel
        JTable table;//Creating object of JTable
        Connection connection;//Creating object of Connection class
        Statement statement;//Creating object of Statement class
        int flag=0;




        //setting the properties of second JFrame
        frame2 = new JFrame("Database Results");
        frame2.setLayout(new FlowLayout());
        frame2.setSize(600, 400);


        //Setting the properties of JTable and DefaultTableModel
        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(500, 100));
        table.setFillsViewportHeight(true);
        frame2.add(new JScrollPane(table));
        defaultTableModel.addColumn("orderid");
        defaultTableModel.addColumn("item");
        defaultTableModel.addColumn("amount");
        defaultTableModel.addColumn("contact");
        defaultTableModel.addColumn("date");

        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oopfinal", "root", "");//Crating connection with database
            statement = connection.createStatement();//crating statement object
            String query = "select * from orders";//Storing MySQL query in A string variable
            ResultSet resultSet = statement.executeQuery(query);//executing query and storing result in ResultSet


            while(resultSet.next()) {

                //Retrieving details from the database and storing it in the String variables
                String orderid = resultSet.getString("orderid");
                String item = resultSet.getString("item");
                String amount = resultSet.getString("amount");
                String contact = resultSet.getString("contact");
                String date = resultSet.getString("date");

                flag = 1;
                defaultTableModel.addRow(new Object[]{orderid, item, amount, contact,date});//Adding row in Table
                frame2.setVisible(true);//Setting the visibility of second Frame
                frame2.validate();


            }


            frame2.setVisible(true);//Setting the visibility of First JFrame
            frame2.validate();//Performing relayout of the First JFrame



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }




}
