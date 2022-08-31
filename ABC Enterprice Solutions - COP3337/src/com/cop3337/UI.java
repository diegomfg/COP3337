package com.cop3337;

import javax.swing.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class UI {
    private static String[] options = new String[] { "Create new Product",
            "View Product",
            "View all Products",
            "Update Product",
            "Delete Product",
            "Exit" };
    private static String header = "FIU International Bank "
            + DateFormat.getDateInstance(DateFormat.LONG).format(new Date());
    private static StringBuilder menu = new StringBuilder();

    /**
     * {@summary} Joins the options array and the header into a full string to be
     * passed to the JOptionPane component.
     */
    static void Initialize() {
        if (menu.length() < 1) {
            menu.append(header);
            int index = 0;

            for (String option : options) {
                ++index;
                menu
                        .append("\n")
                        .append(index)
                        .append(")")
                        .append(option);

            }
        }
    }

    static int getOption() {
        return Integer.parseInt(JOptionPane.showInputDialog(menu));
    }

    static double getDouble(String message){
        return Double.parseDouble(JOptionPane.showInputDialog(null, message));
    }

    static String getString(String message){
        return JOptionPane.showInputDialog(null, message);
    }

    static int getInt(String message){
        return Integer.parseInt(JOptionPane.showInputDialog(null, message));
    }
    
    static int getId(String message){
        return Integer.parseInt(JOptionPane.showInputDialog(null, message, "View Title"));
    }

    static void ViewSingleProduct(Product product){
        JOptionPane.showMessageDialog(null, "View Single Product");
    }

    static void showMessage(String message){
        JOptionPane.showMessageDialog(null, message);
    }
}
