package model;


import java.sql.*;

public class EmployeeOrderAllocation {

    int employeeId;

    int orderId;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/oop";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public void Allocation(int employeeId, int orderId) {
        this.employeeId = employeeId;
        this.orderId = orderId;
    }

    public boolean checkEmployeeId(Connection connection, int employeeId) throws SQLException {
        String query = "SELECT * FROM employees_test WHERE EmpID = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, employeeId);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next();
    }

    public boolean checkOrderId(Connection connection, int orderId) throws SQLException {
        String query = "SELECT * FROM orders WHERE orderid = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, orderId);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next();
    }

    public void insertAllocation(Connection connection, int employeeId, int orderId) throws SQLException {
        String query = "INSERT INTO employeeorderallocation (employeeId, orderId) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, employeeId);
        statement.setInt(2, orderId);
        statement.executeUpdate();
    }
    public void Delete(Connection connection,int employeeId,int orderId)throws SQLException
    {

        String query = "DELETE FROM employeeorderallocation WHERE employeeId = ? AND orderId = ?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setInt(1, employeeId);
        statement.setInt(2, orderId);

        int rowsAffected = statement.executeUpdate();

        statement.close();

    }

}
