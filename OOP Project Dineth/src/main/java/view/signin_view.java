package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class signin_view extends JFrame{
    private JTextField unamefield;
    private JTextField pfield;
    private JButton submitButton;
    private JPanel panelsignin;
    private JPasswordField passwordField1;


    public static void main(String[] args) {
        signin_view ui = new signin_view();
        ui.setContentPane(ui.panelsignin);
        ui.setTitle("Manage Sales");
        ui.setSize(640, 480);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setVisible(true);

    }

    public signin_view() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String usernamegiven = unamefield.getText();
                String passwordgiven = passwordField1.getText();

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
                    String sql = "select * from users WHERE username = '"+usernamegiven+"' and password = '"+passwordgiven+"' ";
                    //stmt.executeUpdate(sql); <- We don't need this? (Dineth)

                    ResultSet resultSet = stmt.executeQuery(sql);


                    if (resultSet.next())
                    {
                        String[] test = {};
                        home_view.main(test);
                        //ui.dispose();

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Wrong Login Information", "Failure",0);
                    }






                } catch (SQLException f) {
                    f.printStackTrace();


                }



            }
        });
    }


}
