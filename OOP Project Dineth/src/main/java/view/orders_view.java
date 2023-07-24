package view;

import controller.orders_controller;
import model.orders_model;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


/**
 * The View in the MVC Model will only do view things, which is
 * displaying the information needed for the user to see. It
 * should not manipulate any data(Controller) nor carry any data(Model).
 * It is just stupid in the matter that when you press a button(action),
 * the view does not do anything.
 */

public class orders_view extends JFrame{
    private JTextField ordersinput1;
    private JTextField ordersinput3;
    private JTextField ordersinput4;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel processconfirm;
    private JTextField ordersinput2;
    private JPanel panel2;
    private JButton showTablesButton;
    private JTextField ordersinput5;




    model.orders_model Orders;
    controller.orders_controller Controller;

    orders_controller orderscontroller=new orders_controller();

    orders_model ordersmodel=new orders_model();


    public static void main(String[] args) {
        orders_view ui = new orders_view();
        ui.setContentPane(ui.panel2);
        ui.setTitle("Manage Sales");
        ui.setSize(900, 600);
        ui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ui.setVisible(true);

    }


    /**
     * The listener will be the event when the button is pressed
     *
     * @params {ActionListener} listener
     */

    public orders_view() {

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
                int id = Integer.parseInt(ordersinput1.getText());
                String item = ordersinput2.getText();
                int amount = Integer.parseInt(ordersinput3.getText());
                String contact = ordersinput4.getText();
                String date = ordersinput5.getText();

                orders_controller.insertorder(id,item, amount,contact,date);
                processconfirm.setText("Added : " + id + " " + item + " " + amount + " " + contact+" " +date);

            }
        });


        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
                int id = Integer.parseInt(ordersinput1.getText());
                String item = ordersinput2.getText();
                int amount = Integer.parseInt(ordersinput3.getText());
                String contact = ordersinput4.getText();
                String date = ordersinput5.getText();

                orders_controller.updateorder(id,item, amount,contact,date);
                processconfirm.setText("Updated : " + id + " " + item + " " + amount + " " + contact+ " " + date);

            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
                int id = Integer.parseInt(ordersinput1.getText());
                String item = ordersinput2.getText();
                int amount = Integer.parseInt(ordersinput3.getText());
                String contact = ordersinput4.getText();
                String date = ordersinput5.getText();

                orders_controller.deleteorder(id,item, amount,contact,date);
                processconfirm.setText("Deleted : " + id + " " + item + " " + amount + " " + contact+ "" +date);

            }
        });


        showTablesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orders_model.showdb();

            }
        });
    }





}
