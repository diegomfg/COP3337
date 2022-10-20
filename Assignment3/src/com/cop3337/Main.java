package com.cop3337;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Main {

    public static void main(String[] args) {

        final String menuOptions = "What do you want to do with this file?" +
                "\n1)Copy file" +
                "\n2)Write to file" +
                "\n3)Display file info" +
                "\n4)Read file" +
                "\n5)Search in file" +
                "\n6)Exit";
        int option = -1;
        FileController fc = new FileController();

        int returnVal = fc.chooseFile();

        if(returnVal == JFileChooser.APPROVE_OPTION) {

            option = Integer.parseInt(JOptionPane.showInputDialog(null, menuOptions));

            // Get option from menu
            while(option != 6){
            
               switch (option){
                   case 1:
                        // Make a copy
                       JOptionPane.showMessageDialog(null,"You selected #1");
                       break;
                   case 2:
                        // Write to file (Overwrite or append)    
                       JOptionPane.showMessageDialog(null,"You selected #2");
                       break;
                   case 3:
                        // Display file info
                       JOptionPane.showMessageDialog(null,"You selected #3");
                       break;
                   case 4:
                        // Read file contents
                       JOptionPane.showMessageDialog(null,"You selected #4");
                       break;
                   case 5:
                        // Search string in file
                       JOptionPane.showMessageDialog(null,"You selected #5");
                       break;

                   default:
                       option = Integer.parseInt(JOptionPane.showInputDialog("Wrong Option\n" + menuOptions));
                       break;
                }
            }
        }
    }
}
