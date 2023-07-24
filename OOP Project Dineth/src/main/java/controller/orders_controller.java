package controller;

import model.orders_model;

/**
 * This is the Controller in the MVC model. This will act
 * as the communication between the Model(data) and View.
 * This can manipulate, update the values of the Model when
 * an action is performed from the View. Also, this is where
 * you add your listeners to your view in order that it will
 * fire an event, which can update values in your model, or
 * update your view.
 */

public class orders_controller {
    static orders_model ordermodel=new orders_model();

    public static void insertorder(int id, String item, int amount, String contact, String date)
    {
        ordermodel.insertorder(id,item, amount,contact,date);
    }


    public static void deleteorder(int id, String item, int amount, String contact, String date)
    {
        ordermodel.deleteorder(id,item,amount,contact,date);
    }

    public static void updateorder(int id, String item, int amount, String contact, String date)
    {
        ordermodel.updateorder(id,item,amount,contact,date);
    }

}



