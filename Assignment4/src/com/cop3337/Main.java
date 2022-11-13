package com.cop3337;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Author: Diego Matheus, David Ulloa
 * 
 * This program loads a java or txt file, and checks for these delimiters
 * '()','[]', '{}'
 * 
 * If a pair is missing its closing delimiter, the program will throw an error.
 * Also the program recognizes if the file is a java class.
 */
class Main {
  public static void main(String[] args) {
    JFileChooser fileChooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Java and txt files", "java", "txt");
    fileChooser.setFileFilter(filter);
    File file = null;

    int result = fileChooser.showOpenDialog(null);

    try {

      file = fileChooser.getSelectedFile();

    } catch (Exception e) {

      JOptionPane.showMessageDialog(null, "Couldn't find file");
      e.printStackTrace();

    }

    if (result == JFileChooser.APPROVE_OPTION) {

      System.out.println("Successfully loaded file");

      Preprocessor preprocessor = new Preprocessor();
      preprocessor.loadFile(file);

    }

  }
}