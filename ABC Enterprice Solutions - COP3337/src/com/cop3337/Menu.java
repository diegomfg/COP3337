package com.cop3337;

import javax.swing.*;
import java.text.DateFormat;
import java.util.Date;

public class Menu {
    private static String[] options = new String[]{"Create new Product", "View Product", "Update Product", "Delete Product", "Register Sale", "Update Ordered Products"};
    private static String header = "FIU International Bank";

    static void Initialize(){
        String menu = header + " " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()).toString();
        int index = 0;
        // Loop through the options to type them in the menu
        for(String option: options){
            menu += "\n" + index + ")" + option;
            ++index;
        }
        JOptionPane.showInputDialog(null, menu);
    }
}
