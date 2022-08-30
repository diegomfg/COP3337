package com.cop3337;

import javax.swing.*;

/**
 * @author Diego Matheus. Volha Schultz
 */
public class Main {

    public static void main(String[] args) {
        Menu.Initialize();

        int option = Menu.getMenuOption();
        while (option != 6){
            JOptionPane.showMessageDialog(null, "SHow something happenig here");
            option = Menu.getMenuOption();
        }
    }
}
