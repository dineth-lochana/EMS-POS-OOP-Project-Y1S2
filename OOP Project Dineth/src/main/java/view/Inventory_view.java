package view;

import controller.Inventory_controller;
import model.Inventory_model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Inventory_view extends JFrame {
    private JTextField txtitemID;
    private JTextField txtunitPrice;
    private JTextField txtTotalQty;
    private JTextField txtUsedqty;
    private JButton removeItemButton;
    private JButton additembtn;
    private JButton updateAnItemButton;
    private JButton searchAnItemButton;
    private JTextField txtitemName;
    private JLabel lblITemID;
    private JLabel lblitemName;
    private JLabel lblunitprice;
    private JLabel lbltotalqty;
    private JLabel lblusedqty;
    private JLabel lblReminingqty;
    public  JPanel Inventorypanel;
    private JButton showAllItemsButton;
    private JButton clearAllButton;

    //create an object of inventory controller to pass data
    Inventory_controller inventoryc=new Inventory_controller() ;
    Inventory_model inventorymod =new Inventory_model();

//to add
public Inventory_view() {
    additembtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int itemID=Integer.parseInt(txtitemID.getText());
            String itemname=txtitemName.getText();
            double unitprice=Double.parseDouble(txtunitPrice.getText());
            int totqty=Integer.parseInt(txtTotalQty.getText());
            int usedqty=Integer.parseInt(txtUsedqty.getText());

            lblReminingqty.setText("Remaining qty: "+(totqty-usedqty));
            int remaining=totqty-usedqty;

            //passing to controller
            inventoryc.iteminsert(itemID,itemname,unitprice,totqty,usedqty,remaining);
            JOptionPane.showMessageDialog(Inventorypanel,"successfully added item to database");
        }
    });

    //to delete
    removeItemButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int delete_id=Integer.parseInt(JOptionPane.showInputDialog(Inventorypanel,"Enter Item ID to delete","delete",1));
            int selectedopt=JOptionPane.showConfirmDialog(Inventorypanel,"CONFIRM DELETION","CONFIRM",JOptionPane.YES_NO_OPTION);
            if(selectedopt==0)
            {

                inventoryc.delete(delete_id);
                JOptionPane.showMessageDialog(Inventorypanel, "Item with ID: " + delete_id + " has been deleted");
            }
            else
            {
                JOptionPane.showMessageDialog(Inventorypanel, "deletion is cancelled..!!", "aborted",2);

            }
        }
    });

    //to update


    updateAnItemButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Inventory_update_view updtframe=new Inventory_update_view();
            updtframe.setContentPane(updtframe.InventoryUpdatePanel);
            updtframe.setTitle("update manager");
            updtframe.setSize(400,400);
            updtframe.setVisible(true);
            updtframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    });
    searchAnItemButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int findID=Integer.parseInt(JOptionPane.showInputDialog(Inventorypanel,"Enter Item ID to find","search",1));
            inventorymod.getone(findID);
        }
    });


    showAllItemsButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            inventorymod.getall();
        }
    });
    clearAllButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            txtitemID.setText(null);
            txtitemName.setText(null);
            txtunitPrice.setText(null);
            txtTotalQty.setText(null);
            txtUsedqty.setText(null);
        }
    });
}



public static void main(String[] args)
{
    Inventory_view Inventory_ui=new Inventory_view();

    Inventory_ui.setContentPane(Inventory_ui.Inventorypanel);
    Inventory_ui.setTitle("Inventory manager");
    Inventory_ui.setSize(600,600);
    Inventory_ui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    Inventory_ui.setVisible(true);
}
}
