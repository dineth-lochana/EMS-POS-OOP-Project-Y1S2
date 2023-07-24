package model;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
public class Employees_model {



    //insert data into DB
    public void insertintoDB(int EmpID,String FirstName,String LastName,String Email,int Age)
    {
        String DB_URL = "jdbc:mysql://localhost:3306/oopfinal";
        String USER = "root";
        String PASS = "";

        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            // Execute a query
            String sql = "INSERT INTO `employees_test` values ('"+EmpID+"','"+FirstName+"','"+LastName+"','"+Email+"','"+Age+"')";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
            System.out.println("Connection closed....");

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    //delete from database
    public void deletefromDB(int EmpID)
    {
        String DB_URL = "jdbc:mysql://localhost:3306/oopfinal";
        String USER = "root";
        String PASS = "";

        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            // Execute a query
            String sql = "DELETE FROM employees_test WHERE `EmpID`='"+EmpID+"' ";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
            System.out.println("Connection closed....");

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    //update database
    public void updateinDB(int EmpID,String updtcol,String updtval)
    {
        String DB_URL = "jdbc:mysql://localhost:3306/oopfinal";
        String USER = "root";
        String PASS = "";

        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            // Execute a query
            String sql = "UPDATE `employees_test` SET `"+updtcol+"`='"+updtval+"' WHERE `EmpID`='"+EmpID+"' ";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
            System.out.println("Connection closed....");

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }


    //get all from db

    public void getall(){

        JFrame frame2;//creating object of second JFrame
        DefaultTableModel defaultTableModel;//creating object of DefaultTableModel
        JTable table;//Creating object of JTable
        Connection connection;//Creating object of Connection class
        Statement statement;//Creating object of Statement class
        int flag=0;




        //setting the properties of second JFrame
        frame2 = new JFrame("Database Results");
        frame2.setLayout(new FlowLayout());
        frame2.setSize(400, 400);


        //Setting the properties of JTable and DefaultTableModel
        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(300, 100));
        table.setFillsViewportHeight(true);
        frame2.add(new JScrollPane(table));
        defaultTableModel.addColumn("EmpID");
        defaultTableModel.addColumn("FirstName");
        defaultTableModel.addColumn("LastName");
        defaultTableModel.addColumn("Email");
        defaultTableModel.addColumn("Age");


        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oopfinal", "root", "");//Crating connection with database
            statement = connection.createStatement();//crating statement object
            String query = "select * from employees_test ORDER BY `EmpID` ASC";//Storing MySQL query in A string variable
            ResultSet resultSet = statement.executeQuery(query);//executing query and storing result in ResultSet

            while (resultSet.next()) {


                //Retrieving details from the database and storing it in the String variables
                int EmpID  = resultSet.getInt("EmpID");
                String FirstName = resultSet.getString("FirstName");
                String LastName = resultSet.getString("LastName");
                String Email = resultSet.getString("Email");
                int Age = resultSet.getInt("Age");



                defaultTableModel.addRow(new Object[]{EmpID, FirstName, LastName,Email,Age});//Adding row in Table
                frame2.setVisible(true);//Setting the visibility of second Frame
                frame2.validate();



            }


            frame2.setVisible(true);//Setting the visibility of First JFrame
            frame2.validate();//Performing relayout of the First JFrame



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    //look for an employee
    public void getone(int EmpID){

        JFrame frame2;//creating object of second JFrame
        DefaultTableModel defaultTableModel;//creating object of DefaultTableModel
        JTable table;//Creating object of JTable
        Connection connection;//Creating object of Connection class
        Statement statement;//Creating object of Statement class
        int flag=0;




        //setting the properties of second JFrame
        frame2 = new JFrame("Database Results");
        frame2.setLayout(new FlowLayout());
        frame2.setSize(400, 400);


        //Setting the properties of JTable and DefaultTableModel
        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(300, 100));
        table.setFillsViewportHeight(true);
        frame2.add(new JScrollPane(table));
        defaultTableModel.addColumn("EmpID");
        defaultTableModel.addColumn("FirstName");
        defaultTableModel.addColumn("LastName");
        defaultTableModel.addColumn("Email");
        defaultTableModel.addColumn("Age");


        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oopfinal", "root", "");//Crating connection with database
            statement = connection.createStatement();//crating statement object
            String query = "select * from employees_test WHERE `EmpID`='"+EmpID+"'";//Storing MySQL query in A string variable
            ResultSet resultSet = statement.executeQuery(query);//executing query and storing result in ResultSet
            if (!resultSet.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Employee does not exist in the database", "Not Found", 0);
            } else {
                while (resultSet.next()) {


                    //Retrieving details from the database and storing it in the String variables
                    int empID = resultSet.getInt("EmpID");
                    String FirstName = resultSet.getString("FirstName");
                    String LastName = resultSet.getString("LastName");
                    String Email = resultSet.getString("Email");
                    int Age = resultSet.getInt("Age");


                    defaultTableModel.addRow(new Object[]{empID, FirstName, LastName, Email, Age});//Adding row in Table
                    frame2.setVisible(true);//Setting the visibility of second Frame
                    frame2.validate();


                }
            }

            frame2.setVisible(true);//Setting the visibility of First JFrame
            frame2.validate();//Performing relayout of the First JFrame



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

}

