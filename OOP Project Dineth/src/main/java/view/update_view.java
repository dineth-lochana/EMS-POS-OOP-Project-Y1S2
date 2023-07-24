package view;

import controller.Employee_controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class update_view extends JFrame{
    private JTextField txtupdateID;
    private JComboBox comboBox1;
    private JTextField txtnewvalue;
    private JLabel lblupdatingID;
    private JLabel lblupdatingcolumn;
    private JLabel lblupdatingvalue;
    public JPanel updatepanel;
    private JButton updatebtn;
    private JButton clearAllButton;

    Employee_controller updatec;
public update_view() {
    updatebtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int eID=Integer.parseInt(txtupdateID.getText());
            String col=(String) comboBox1.getItemAt(comboBox1.getSelectedIndex());
            String value=txtnewvalue.getText();

            updatec=new Employee_controller();
            updatec.update(eID,col,value);
            JOptionPane.showMessageDialog(updatepanel,"successfully updated","update",1);
        }
    });
    clearAllButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            txtupdateID.setText(null);
            txtnewvalue.setText(null);


        }
    });
}
}
