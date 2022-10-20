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

        JFileChooser chooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & Text Images", "jpg", "txt");

        chooser.setFileFilter(filter);

        int returnVal = chooser.showOpenDialog(null);

        if(returnVal == JFileChooser.APPROVE_OPTION) {

            System.out.println("You chose to open this file: " +
                    chooser.getSelectedFile().getAbsolutePath());

            // Get option from menu
            String option = JOptionPane.showInputDialog(null,menuOptions);

               switch (option){
                   case "1":
                       JOptionPane.showMessageDialog(null,"You selected #1");
                       break;
                   case "2":
                       JOptionPane.showMessageDialog(null,"You selected #2");
                       break;
                   case "3":
                       JOptionPane.showMessageDialog(null,"You selected #3");
                       break;
                   case "4":
                       JOptionPane.showMessageDialog(null,"You selected #4");
                       break;
                   case "5":
                       JOptionPane.showMessageDialog(null,"You selected #5");
                       break;

                   default:
                       option = JOptionPane.showInputDialog("Wrong Option\n"+menuOptions);
                       break;
           }
        }
    }
}
