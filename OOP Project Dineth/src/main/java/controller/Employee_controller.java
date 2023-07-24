package controller;

import model.Employees_model;

public class Employee_controller {
 //creating an object of model class to use function to send data to db
 //insert method
 Employees_model empobj=new Employees_model();

 //insert method
    public void insert(int ID,String Fname,String Lname,String mail,int age)
    {
        empobj.insertintoDB(ID,Fname,Lname,mail,age);
    }

//delete method
    public void delete(int ID)
    {
        empobj.deletefromDB(ID);
    }

    public void update(int ID,String newcol,String newval)
    {
        empobj.updateinDB(ID,newcol,newval);
    }

}
