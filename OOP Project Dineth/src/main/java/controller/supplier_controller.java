package controller;

import model.supplier_model;

/**
 * This is the Controller in the MVC model. This will act
 * as the communication between the Model(data) and View.
 * This can manipulate, update the values of the Model when
 * an action is performed from the View. Also, this is where
 * you add your listeners to your view in order that it will
 * fire an event, which can update values in your model, or
 * update your view.
 */

public class supplier_controller {


    static supplier_model suppliermodel=new supplier_model();

    public static void insertsupplier(int SupplierID, String SupplierName, String Item, int Quantity)
    {
        suppliermodel.insertsupplier(SupplierID,SupplierName,Item,Quantity);
    }


    public static void deletesupplier(int SupplierID, String SupplierName, String Item, int Quantity)
    {
        suppliermodel.deletesupplier(SupplierID,SupplierName,Item,Quantity);
    }

    public static void updatesupplier(int SupplierID, String SupplierName, String Item, int Quantity)
    {
        suppliermodel.updatesupplier(SupplierID,SupplierName,Item,Quantity);
    }



    }



