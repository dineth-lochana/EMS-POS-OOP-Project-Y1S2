package view;

import java.awt.*;
import java.sql.*;

import javax.swing.*;

import controller.supplier_controller;
import model.supplier_model;

import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The View in the MVC Model will only do view things, which is
 * displaying the information needed for the user to see. It
 * should not manipulate any data(Controller) nor carry any data(Model).
 * It is just stupid in the matter that when you press a button(action),
 * the view does not do anything.
 */

public class supplier_view extends JFrame {
    private JTextField salesinput2;
    private JTextField salesinput1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JTextField salesinput3;
    private JPanel panel;
    private JLabel sales_label1;
    private JLabel sales_label2;
    private JLabel processconfirm;
    private JButton showTablesButton;
    private JTextField salesinput4;

    supplier_model Orders;
    supplier_controller Controller;

    PreparedStatement ps;


    public static void main(String[] args) {
        supplier_view ui = new supplier_view();
        ui.setContentPane(ui.panel);
        ui.setTitle("Manage Sales");
        ui.setSize(800, 600);
        ui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ui.setVisible(true);

    }


    /**
     * The listener will be the event when the button is pressed
     *
     * @params {ActionListener} listener
     */

    public supplier_view() {

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
                int SupplierID = Integer.parseInt(salesinput1.getText());
                String SupplierName = salesinput4.getText();
                String Item = salesinput2.getText();
                int Quantity = Integer.parseInt(salesinput3.getText());

                supplier_controller.insertsupplier(SupplierID,SupplierName,Item,Quantity);
                processconfirm.setText("Added : " + SupplierID + " " + SupplierName + " " + Item + "" +Quantity);

            }
        });


        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
                int SupplierID = Integer.parseInt(salesinput1.getText());
                String SupplierName = salesinput4.getText();
                String Item = salesinput2.getText();
                int Quantity = Integer.parseInt(salesinput3.getText());

                processconfirm.setText("Updated : " + SupplierID + " " + SupplierName +" "+ Item +" "+ Quantity);
                supplier_controller.updatesupplier(SupplierID,SupplierName,Item,Quantity);
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
                int SupplierID = Integer.parseInt(salesinput1.getText());
                String SupplierName = salesinput4.getText();
                String Item = salesinput2.getText();
                int Quantity = Integer.parseInt(salesinput3.getText());

                processconfirm.setText("Deleted Row Belonging to : " + SupplierID);
                supplier_controller.deletesupplier(SupplierID,SupplierName,Item,Quantity);

            }
        });


        showTablesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                supplier_model.showsupplierdb();


            }
        });
    }


}

