package com.cop3337;

import javax.swing.*;

/**
 * @author Diego Matheus. Volha Schultz
 */
public class Main {

    public static void main(String[] args) {
        Menu.Initialize();

        int option = Menu.getMenuOption();
        while (option != 7){
            switch (option){
                case 1:
                    JOptionPane.showMessageDialog(null, "Something happening here");
                    break;
            }
            option = Menu.getMenuOption();
        }
    }
}
