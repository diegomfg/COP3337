package com.cop3337;

import com.cop3337.*;
/**
 * @author Diego Matheus. Volha Schultz
 */
public class Main {

    public static void main(String[] args) {
        try {
            UI.Initialize();
            int option = UI.getOption();
            Database db = new Database();
        
            while (option != 7){
                switch (option){
                    case 1:
                        // Create new product
                        String mfName = UI.getString("Type the manufacturer's name: ");
                        String mfAddress = UI.getString("Type the manufacturer's address: ");
                        Manufacturer mf = new Manufacturer(mfName, new Address(mfAddress));

                        String name = UI.getString("Enter the name of the new product: ");
                        int units = UI.getInt("Enter the amount of new units: ");
                        Double price = UI.getDouble("Enter the Price per unit: ");
                        Product p = new Product(mf, name, units, price);
                        db.insertProduct(p);
                        break;
                    case 2:
                        // View Product
                        int id = UI.getId("Enter the ID of the product to view: ");
                        UI.showSingleProduct(db.findProduct(id));
                    break;
                    case 3:
                    // View all products
                        UI.showAllProducts(db.findAllProducts());
                    break;
                    case 4:
                        int _id = UI.getId("Enter the ID of the product to edit: ");
                        Product productToEdit = db.findProduct(_id);
                        System.out.println("Product to edit: " + productToEdit);
                        String newName = UI.getString("Enter the name of the new product: ");
                        int newUnits = UI.getInt("Enter the amount of new units: ");
                        Double newPrice = UI.getDouble("Enter the Price per unit: ");
                        
                        db.editProduct(_id, newName, newUnits, newPrice);
                        UI.showMessage("Update Product");    
                    break;
                    case 5:
                        // Delete product
                        int index = UI.getId("Enter id of the Product to delete: ");
                        if(db.deleteProduct(index)){
                            UI.showMessage("Product successfully deleted");
                            break;
                        };

                        UI.showMessage("Coudln't find the specified product");
                    break;
                    case 6:
                        // List deleted (inactive) products
                        UI.showAllProducts(db.findInactiveProducts());
                    break;
                    default:
                        UI.showMessage("Invalid option");
                    break;    
                }
                option = UI.getOption();
            }
        } catch (Exception e) {
            UI.showMessage("Unable to find the requested resource");
        }
    }
}
