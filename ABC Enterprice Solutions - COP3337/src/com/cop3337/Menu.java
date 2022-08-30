package com.cop3337;

import javax.swing.*;
import java.text.DateFormat;
import java.util.Date;

public class Menu {
    private static String[] options = new String[] { "Create new Product",
            "View Product",
            "Update Product",
            "Delete Product",
            "Register Sale",
            "Update Ordered Products",
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

    /**
     * Parses the input received from the main menu and returns the numeric value of
     * the option.
     * 
     * @return Integer
     */
    static int getOption() {
        return Integer.parseInt(JOptionPane.showInputDialog(menu));
    }
}
