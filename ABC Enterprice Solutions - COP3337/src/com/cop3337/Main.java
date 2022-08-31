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
      
        while (option != 7){
            switch (option){
                case 1:
                    // Write logic to validate input
                    Manufacturer mfg = new Manufacturer("Stihl", "1495 NW 24th Avenue");

                    String name = UI.getString("Enter the name of the new product: ");
                    int units = UI.getInt("How many units? ");
                    Double price = UI.getDouble("Enter the Price per unit: ");

                    Product p = new Product(mfg, name, units, price);
                    JOptionPane.showMessageDialog(null, "This is the product created: " + p.toString());
                    break;
                case 2:
                // View Product
                UI.showMessage("View Product");
                break;
                case 3:
                // Edit product
                    UI.showMessage("View all products");
                break;
                case 4:
                // Delete product
                int index = UI.getId("Enter id of the Product to delete: ");
                if(db.deleteProduct(index)){
                    UI.showMessage("Product successfully deleted");
                };     
                break;
                case 5:
                // Register Sale
                    JOptionPane.showMessageDialog(null, "You have pressed option: " + option);
                break;
                case 6:
                // Update Ordered Products
                    JOptionPane.showMessageDialog(null, "You have pressed option: " + option);
                break;
                case 7:
                // Create manufacturer
                String mfName = UI.getString("Type the name of the Manufacturer: ");
                String mfAddress = UI.getString("Type the address of the Manufacturer: ");
                Manufacturer mf = new Manufacturer(mfName, mfAddress);
                db.insertManufacturer(mf);
                break;
                default:
                UI.showMessage("Invalid option");
                break;    
            }
            option = UI.getOption();
        }
    }
}
