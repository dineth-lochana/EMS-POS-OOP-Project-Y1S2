package view;

import controller.Employee_controller;
import model.Employees_model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Employees_view extends JFrame{
    public JPanel empPanel;
    private JTextField textEmpID;
    private JTextField textEmail;
    private JTextField textFname;
    private JTextField textAge;
    private JTextField textLname;
    private JButton addbtn;
    private JButton updatebtn;
    private JButton deletebtn;
    private JLabel lblempID;
    private JLabel lblfname;
    private JLabel lbllname;
    private JLabel lblemail;
    private JLabel lblage;
    private JButton showallbtn;
    private JButton searchAnEmployeeButton;
    private JButton clearAllButton;

    Employee_controller Empc=new Employee_controller();

    Employees_model Empmod=new Employees_model();

    public Employees_view() {
     //add button
    addbtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //receiving values from view
            int view_EmpID= Integer.parseInt(textEmpID.getText());
            String view_Fname=textFname.getText();
            String view_Lname=textLname.getText();
            String view_email=textEmail.getText();
            int view_age=Integer.parseInt(textAge.getText());

            //creating an object of controller to pass values to model to make enp obj
            Empc.insert(view_EmpID,view_Fname,view_Lname,view_email,view_age);
            JOptionPane.showMessageDialog(empPanel,"data has been added to database","inserted",1);
        }
    });

     //update button
    updatebtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e)
        {
           update_view updtframe=new update_view();
           updtframe.setContentPane(updtframe.updatepanel);
           updtframe.setTitle("update manager");
           updtframe.setSize(400,400);
           updtframe.setVisible(true);
           updtframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        }
    });

    //delete button
    deletebtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int delete_id=Integer.parseInt(JOptionPane.showInputDialog(empPanel,"Enter employee ID to delete","delete",1));
            int selectedopt=JOptionPane.showConfirmDialog(empPanel,"CONFIRM DELETION","CONFIRM",JOptionPane.YES_NO_OPTION);
            if(selectedopt==0)
            {
                Empc.delete(delete_id);
                JOptionPane.showMessageDialog(empPanel, "Employee with ID: " + delete_id + " has been deleted");
            }
            else
            {
                JOptionPane.showMessageDialog(empPanel, "deletion is cancelled..!!", "aborted",2);

            }
        }
    });

    //show all button
        showallbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //creating the frame to show results

                Empmod.getall();

            }
        });

    //look for a specific employee
        searchAnEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int findID=Integer.parseInt(JOptionPane.showInputDialog(empPanel,"Enter employee ID to find","search",1));
                Empmod.getone(findID);
            }
        });
        clearAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textEmpID.setText(null);
                textFname.setText(null);
                textLname.setText(null);
                textEmail.setText(null);
                textAge.setText(null);
            }
        });
    }

//main method
    public static void main(String args[]) {
        Employees_view Employee_ui = new Employees_view();

        Employee_ui.setContentPane(Employee_ui.empPanel);
        Employee_ui.setTitle("Employee manager");
        Employee_ui.setSize(600,600);
        Employee_ui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Employee_ui.setVisible(true);

    }



}
