package view;

import controller.Inventory_controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inventory_update_view extends JFrame{
    private JTextField txtupdatingID;
    private JComboBox comboBox1;
    private JTextField txtupdatingvalue;
    private JButton updatebtn;
    private JLabel lblupdatingvalue;
    private JLabel lblupdatingcol;
    public JPanel InventoryUpdatePanel;
    private JLabel lblupdatingID;
    private JButton clearAllButton;

    Inventory_controller updatec;

public Inventory_update_view() {
    updatebtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int itemID=Integer.parseInt(txtupdatingID.getText());
            String col=(String) comboBox1.getItemAt(comboBox1.getSelectedIndex());
            String value=txtupdatingvalue.getText();
            int qtyType;
            if(comboBox1.getSelectedIndex()==3)
            {
                qtyType=3;
            }
            else if (comboBox1.getSelectedIndex()==4)
            {
                qtyType=4;
            }
            else
            {
                qtyType=0;
            }

            updatec=new Inventory_controller();
            updatec.update(itemID,col,value,qtyType);
            JOptionPane.showMessageDialog(InventoryUpdatePanel,"successfully updated","update",1);
        }
    });
    clearAllButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            txtupdatingID.setText(null);
            txtupdatingvalue.setText(null);
        }
    });
}
}
