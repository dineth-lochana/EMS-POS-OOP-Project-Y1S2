package model;

import view.Inventory_view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class Inventory_model {

    //insert into database
    public void insertItemintoDB(int ItemID,String ItemName,double UnitPrice,int TotalQty,int UsedQty,int RemainingQty)
    {
        String DB_URL = "jdbc:mysql://localhost:3306/oopfinal";
        String USER = "root";
        String PASS = "";

        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            // Execute a query
            String sql = "INSERT INTO `inventory_test` values ('"+ItemID+"','"+ItemName	+"','"+UnitPrice+"','"+TotalQty+"','"+UsedQty+"','"+RemainingQty+"')";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
            System.out.println("Connection closed....");

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    //delete from database
    public void deleteitemfromDB(int ItemID)
    {
        String DB_URL = "jdbc:mysql://localhost:3306/oopfinal";
        String USER = "root";
        String PASS = "";

        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            // Execute a query
            String sql = "DELETE FROM inventory_test WHERE `ItemID`='"+ItemID+"' ";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
            System.out.println("Connection closed....");

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    //to update item in database
    public void updateIteminDB(int ItemID,String updtcol,String updtval,int qtyType)
    {
        String DB_URL = "jdbc:mysql://localhost:3306/oopfinal";
        String USER = "root";
        String PASS = "";

        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            //query to be executed when totqty is chosen to be updated
            if(qtyType==3)
            {
                String sqloldUsedvalue="SELECT `UsedQty` FROM inventory_test WHERE `ItemID`='"+ItemID+"' ";
                ResultSet rs= stmt.executeQuery(sqloldUsedvalue);
                rs.next();
                int oldval=rs.getInt("UsedQty");
                String sqlupdatetotqty="UPDATE inventory_test SET`TotalQty`='"+updtval+"'  WHERE ItemID='"+ItemID+"' ";
                stmt.executeUpdate(sqlupdatetotqty);
                String sqlAutoChangeRemaining="UPDATE inventory_test SET`RemainingQty`=TotalQty-"+oldval+"  WHERE ItemID='"+ItemID+"'";
                stmt.executeUpdate(sqlAutoChangeRemaining);


            }
            else if (qtyType==4)
            {
                //query to be executed when usedqty is chosen to be updated
                String sqloldUsedvalue="SELECT `TotalQty` FROM inventory_test WHERE `ItemID`='"+ItemID+"' ";
                ResultSet rs= stmt.executeQuery(sqloldUsedvalue);
                rs.next();
                int oldval=rs.getInt("TotalQty");
                String sqlupdateusedqty="UPDATE inventory_test SET`UsedQty`='"+updtval+"'  WHERE ItemID='"+ItemID+"' ";
                stmt.executeUpdate(sqlupdateusedqty);
                String sqlAutoChangeRemaining="UPDATE inventory_test SET`RemainingQty`='"+oldval+"'-UsedQty  WHERE ItemID='"+ItemID+"'";
                stmt.executeUpdate(sqlAutoChangeRemaining);

            }
            else
            {
                // Execute a query if other is chosen
                 String sql = "UPDATE `inventory_test` SET `"+updtcol+"`='"+updtval+"' WHERE `ItemID`='"+ItemID+"' ";
                 stmt.executeUpdate(sql);
            }
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
        defaultTableModel.addColumn("ItemID ");
        defaultTableModel.addColumn("ItemName");
        defaultTableModel.addColumn("UnitPrice");
        defaultTableModel.addColumn("TotalQty");
        defaultTableModel.addColumn("UsedQty");
        defaultTableModel.addColumn("RemainingQty");



        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oopfinal", "root", "");//Crating connection with database
            statement = connection.createStatement();//crating statement object
            String query = "SELECT * FROM `inventory_test` ORDER BY `ItemID` ASC";//Storing MySQL query in A string variable
            ResultSet resultSet = statement.executeQuery(query);//executing query and storing result in ResultSet

            while (resultSet.next()) {


                //Retrieving details from the database and storing it in the String variables
                int ItemID   = resultSet.getInt("ItemID");
                String ItemName = resultSet.getString("ItemName");
                String UnitPrice = resultSet.getString("UnitPrice");
                String TotalQty = resultSet.getString("TotalQty");
                int UsedQty = resultSet.getInt("UsedQty");
                int RemainingQty = resultSet.getInt("RemainingQty");




                defaultTableModel.addRow(new Object[]{ItemID, ItemName, UnitPrice,TotalQty,UsedQty,RemainingQty});//Adding row in Table
                frame2.setVisible(true);//Setting the visibility of second Frame
                frame2.validate();



            }


            frame2.setVisible(true);//Setting the visibility of First JFrame
            frame2.validate();//Performing relayout of the First JFrame



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    //look for an Item
    public void getone(int ItemID){

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
        defaultTableModel.addColumn("ItemID ");
        defaultTableModel.addColumn("ItemName");
        defaultTableModel.addColumn("UnitPrice");
        defaultTableModel.addColumn("TotalQty");
        defaultTableModel.addColumn("UsedQty");
        defaultTableModel.addColumn("RemainingQty");



        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oopfinal", "root", "");//Crating connection with database
            statement = connection.createStatement();//crating statement object
            String query = "select * from inventory_test WHERE `ItemID`='" + ItemID + "'";//Storing MySQL query in A string variable
            ResultSet resultSet = statement.executeQuery(query);//executing query and storing result in ResultSet
            if (!resultSet.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "item does not exist in the database", "Not Found", 0);
            } else {
                while (resultSet.next()) {


                    //Retrieving details from the database and storing it in the String variables
                    ItemID = resultSet.getInt("ItemID");
                    String ItemName = resultSet.getString("ItemName");
                    String UnitPrice = resultSet.getString("UnitPrice");
                    String TotalQty = resultSet.getString("TotalQty");
                    int UsedQty = resultSet.getInt("UsedQty");
                    int RemainingQty = resultSet.getInt("RemainingQty");


                    defaultTableModel.addRow(new Object[]{ItemID, ItemName, UnitPrice, TotalQty, UsedQty, RemainingQty});//Adding row in Table
                    frame2.setVisible(true);//Setting the visibility of second Frame
                    frame2.validate();


                }

            }
                frame2.setVisible(true);//Setting the visibility of First JFrame
                frame2.validate();//Performing relayout of the First JFrame


            } catch(SQLException throwables){
                throwables.printStackTrace();
            }
        }


}
