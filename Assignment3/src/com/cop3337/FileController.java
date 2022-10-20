package com.cop3337;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FileChooserUI;

class FileController {
  private JFileChooser chooser;
  private FileNameExtensionFilter filter;
  private FileInputStream fis;
  private FileOutputStream fos;
  private File file;
  private StringTokenizer tokenizer;

  public FileController(){
    this.chooser = new JFileChooser();
    this.filter = new FileNameExtensionFilter(
                "JPG & Text Images", "jpg", "txt");

    chooser.setFileFilter(filter);
    this.fis = null;
    this.fos = null;
    this.tokenizer = null;
  }

  public int chooseFile(){

    int result = this.chooser.showOpenDialog(null);
    
    try {
      // StringTokenizer tokenizer = new StringTokenizer(null)
      this.file = this.chooser.getSelectedFile();
      this.fis = new FileInputStream(this.file);

    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Couldn't find file");
      e.printStackTrace();
    }
    return result;
  }

  public JFileChooser getChooser() {
    return chooser;
  }

  public void makeFileCopy(){
      JOptionPane.showMessageDialog(null,"Making file copy of " + this.chooser.getSelectedFile());
      String filename = "filecopy";
      String extension = this.file.getName().contains(".jpeg") ? ".jpeg" : ".txt";
      
      try {
        this.fos = new FileOutputStream(this.file.getParent() + "/" + filename + extension);
        byte[] buffer = new byte[1024];
      
        int length;

        while ((length = fis.read(buffer)) > 0) {
            System.out.println(buffer);
            fos.write(buffer, 0, length);
        }
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Error creating file copy");
      }
  }

  public void writeToFile() {
    int option = Integer.parseInt(JOptionPane.showInputDialog("Write to file\n1)Ovewrite File\n2)Append to file"));

    switch(option){
      case 1:
      String line = JOptionPane.showInputDialog(null, "Enter the text to overwrite file with");
      
      break;
      case 2:
      String line2 = JOptionPane.showInputDialog(null, "Enter the text to append to file");
      break;
      default:
      JOptionPane.showMessageDialog(null,"You have selected an invalid option");
      break;
    }
  }

  public void displayFileInfo() {
  }

  public void readFileContents() {
    
    try {
      BufferedReader br = new BufferedReader(new FileReader(this.file));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        String everything = sb.toString();
        JOptionPane.showMessageDialog(null, everything);
    } catch (Exception e){
      System.out.println("Error");
    }

  }

  public void searchInFile() {
    String search = JOptionPane.showInputDialog("Type word to search for ");
  }
  
}