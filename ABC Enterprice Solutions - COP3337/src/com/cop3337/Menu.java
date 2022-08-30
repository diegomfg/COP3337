package com.cop3337;

import javax.swing.*;
import java.text.DateFormat;
import java.util.Date;

public class Menu {
    private static String[] options = new String[]{"Create new Product", "View Product", "Update Product", "Delete Product", "Register Sale", "Update Ordered Products", "Exit"};
    private static String header = "FIU International Bank";
    private static StringBuilder menu = new StringBuilder();

    static void Initialize(){
        if(menu.length() < 1){
            menu.append(header).append(" ").append(DateFormat.getDateInstance(DateFormat.LONG).format(new Date()).toString());
            int index = 0;
            // Loop through the options to type them in the menu
            for(String option: options) {
                menu.append("\n").append(index).append(")").append(option);
                ++index;
            }
        }
    }

    static int getMenuOption(){
        return Integer.parseInt(JOptionPane.showInputDialog(menu));
    }
}
