package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;



public class customeremailnotification extends JFrame{


    private JPanel panel1;
    private JTextField input1;
    private JButton sendEmailButton;
    private JLabel confirm;

    public customeremailnotification() {
        sendEmailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Empemail = input1.getText();
                int index = Integer.parseInt(input1.getText());



                //----------------------------------------
                //Starting Database
                String DB_URL = "jdbc:mysql://localhost:3306/oopfinal";
                String USER = "root";
                String PASS = "";

                // Open a connection

                String myemail = null;

                try {
                    Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                    Statement stmt = conn.createStatement();

                    String query = "select contact from orders where orderid in (Select orderid from employeeorderallocation where `index` = '"+index+"');";
                    ResultSet resultSet = stmt.executeQuery(query);
                    //select contact from orders where orderid in (Select orderid from employeeorderallocation where index = 1);


                    String name = null;
                    if (resultSet.next()) {
                        myemail = resultSet.getString( "contact");

                    } else {
                        System.out.println("No data found for the given query.");
                    }


                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


                //----------------------------------------




                //------Sending Mail

                String host = "sandbox.smtp.mailtrap.io";
                int port = 587;
                String username = "0a8abc7dd41dc6";
                String password = "f4d002cb134b87";

                // Recipient's email address
                String recipientEmail = myemail;

                // Email content
                String emailSubject = "Order";
                String emailBody = "Hello, You have been allocated an order.";

                // Set up email properties
                Properties properties = new Properties();
                properties.put("mail.smtp.host", host);
                properties.put("mail.smtp.port", port);
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.starttls.enable", "true");

                // Create a session with email authentication
                Session session = Session.getInstance(properties, new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

                try {
                    // Create a new message
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(username));
                    message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
                    message.setSubject(emailSubject);
                    message.setText(emailBody);

                    // Send the message
                    Transport.send(message);

                    System.out.println("Email sent successfully.");

                } catch (Throwable g) {
                    JOptionPane.showMessageDialog(null, "Customer is not allocated an Order in the database", "Not Found", 0);

                    System.out.println("Failed to send email.");
                    confirm.setText("No order allocated to Index '"+Empemail+"' ");
                }




                confirm.setText("Sending Email to Index '"+Empemail+"' ");
            }
        });


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                customeremailnotification ui = new customeremailnotification();
                ui.setContentPane(ui.panel1);
                ui.setTitle("Employee Mail Notifications");
                ui.setSize(500, 500);
                ui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                ui.setVisible(true);
            }
        });
    }



}
