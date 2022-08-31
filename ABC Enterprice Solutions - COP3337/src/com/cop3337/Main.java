package com.cop3337;

import javax.swing.*;

/**
 * @author Diego Matheus. Volha Schultz
 */
public class Main {

    public static void main(String[] args) {
        UI.Initialize();
        int option = UI.getOption();
        Database db = new Database();
      
        while (option != 6){
            switch (option){
                case 1:
                    // Create new product
                    String mfName = UI.getString("Type the manufacturer's name: ");
                    String mfAddress = UI.getString("Type the manufacturer's address: ");
                    Manufacturer mf = new Manufacturer(mfName, mfAddress);

                    String name = UI.getString("Enter the name of the new product: ");
                    int units = UI.getInt("Enter the amount of new units: ");
                    Double price = UI.getDouble("Enter the Price per unit: ");
                    Product p = new Product(mf, name, units, price);
                    db.insertProduct(p);
                    break;
                case 2:
                    // View Product
                    int id = UI.getId("Enter the ID of the product to view: ");
                    System.out.println(db.findProduct(id));
                    UI.showMessage(db.findProduct(id));
                break;
                case 3:
                // View all products
                    UI.showMessage(db.findAllProducts());
                break;
                case 4:
                    UI.showMessage("Update Product");    
                break;
                case 5:
                    // Delete product
                    int index = UI.getId("Enter id of the Product to delete: ");
                    if(db.deleteProduct(index)){
                        UI.showMessage("Product successfully deleted");
                    };
                break;
                default:
                UI.showMessage("Invalid option");
                break;    
            }
            option = UI.getOption();
        }
    }
}
