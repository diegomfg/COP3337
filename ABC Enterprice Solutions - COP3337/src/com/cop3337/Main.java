package com.cop3337;

import javax.swing.*;

/**
 * @author Diego Matheus. Volha Schultz
 */
public class Main {

    public static void main(String[] args) {
        Menu.Initialize();

        int option = Menu.getOption();
        while (option != 7){
            switch (option){
                case 1:
                    int units = 0;
                    double price = 0.0;
                    String name;
                    // Write logic to validate input
                    name = JOptionPane.showInputDialog(null, "Enter the name of the new product: ");
                    units = Integer.parseInt(JOptionPane.showInputDialog(null, "How many units? "));
                    price = Double.parseDouble(JOptionPane.showInputDialog(null, "Price per unit: "));
                    Product p = new Product(new Manufacturer("Stihl", "1495 NW 24th Avenue"), name, units, price);
                    JOptionPane.showMessageDialog(null, "This is the product created: " + p.toString());
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "You have pressed option: " + option);
                break;
                case 3:
                    JOptionPane.showMessageDialog(null, "You have pressed option: " + option);
                break;
                case 4:
                    JOptionPane.showMessageDialog(null, "You have pressed option: " + option);
                break;
                case 5:
                    JOptionPane.showMessageDialog(null, "You have pressed option: " + option);
                break;
                case 6:
                    JOptionPane.showMessageDialog(null, "You have pressed option: " + option);
                break;
                default:
                break;    
            }
            option = Menu.getOption();
        }
    }
}
