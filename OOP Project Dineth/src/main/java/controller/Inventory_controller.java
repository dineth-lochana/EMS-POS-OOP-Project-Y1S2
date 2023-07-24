package controller;


import model.Inventory_model;

public class Inventory_controller {

    Inventory_model itemobj=new Inventory_model();

    public void iteminsert(int itemID,String itemname,double uprice,int total,int used,int remaining)
    {
       itemobj.insertItemintoDB(itemID,itemname,uprice,total,used,remaining);
    }

    //delete method
    public void delete(int ID)
    {
        itemobj.deleteitemfromDB(ID);
    }

    //to update
    public void update(int ID,String newcol,String newval,int qtyType)
    {
        itemobj.updateIteminDB(ID,newcol,newval,qtyType);
    }
}
