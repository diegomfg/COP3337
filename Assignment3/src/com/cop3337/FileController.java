package com.cop3337;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

class FileController {
  private JFileChooser chooser;
  private FileNameExtensionFilter filter;
  private FileInputStream fis;
  private FileOutputStream fos;
  private File file;
  private BufferedReader stringBuffer;

  public FileController(){
    this.chooser = new JFileChooser();
    this.filter = new FileNameExtensionFilter(
                "JPG & Text Images", "jpg", "txt");

    chooser.setFileFilter(filter);
    this.fis = null;
    this.fos = null;
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
      
      // create file copy filename and extension
      String filename = "filecopy";
      String extension = this.file.getName().contains(".jpeg") || this.file.getName().contains(".jpg") ? ".jpeg" : ".txt";
      
      try {
        // Writing the URI for output
        this.fos = new FileOutputStream(this.file.getParent() + "/" + filename + extension);
        byte[] buffer = new byte[1024];
      
        int length;
        // Copies the bytes line by line onto the new FileOutputStream
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
        try(FileWriter fw = new FileWriter(this.file.getAbsolutePath(), false);

            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(line);
            //more code
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error writing to file");
            System.out.println(e.getMessage());
        }

      break;

      case 2:


          String line2 = JOptionPane.showInputDialog(null, "Enter the text to append to file");
          try(FileWriter fw = new FileWriter(this.file.getAbsolutePath(), true);
        
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(line2);
            //more code
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error writing to file");
            System.out.println(e.getMessage());
        }


      break;

      default:
        JOptionPane.showMessageDialog(null,"You have selected an invalid option");
      break;
    }
  }

  public void displayFileInfo() {
    StringBuilder info = new StringBuilder();

    // load the file in the buffered reader
    try {
      this.stringBuffer = new BufferedReader(new FileReader(this.file));
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Unable to find file");
    }
    // create string info
    info.append("\tFile Info")
        .append("\nFilename: " + this.file.getName())
        .append("\nAbsolute Path: " + this.file.getAbsolutePath())
        .append("\nParent Directory: " + this.file.getParent())
        .append("\nFile Size: " + (long)(this.file.getTotalSpace() / 1024) + "Kb.");
    
    // display info as String
    JOptionPane.showMessageDialog(null, info.toString());
  }

  /**
   * Reads all the file lines, one by one, using BufferedReader
   */
  public void readFileContents() {
    try {
        this.stringBuffer = new BufferedReader(new FileReader(this.file));
        StringBuilder sb = new StringBuilder();
        String line = stringBuffer.readLine();

        // Reads file line by line and stores it into a StringBuilder
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = stringBuffer.readLine();
        }
        String everything = sb.toString();
        // Convert all the info to String
        JOptionPane.showMessageDialog(null, everything);
    } catch (Exception e){
      JOptionPane.showMessageDialog(null,"Error trying to open file");
      System.out.println("Error");
    }

  }

  public void searchInFile() {
    String search = JOptionPane.showInputDialog("Type keyword to search for: ");
    int index = 0;

    try {

      this.stringBuffer = new BufferedReader(new FileReader(this.file));
      StringBuilder sb = new StringBuilder();
      String line = stringBuffer.readLine();
      

        while (line != null) {
          
            if(line.toLowerCase().contains(search.toLowerCase())){
              sb.append("On line: (" + index + "):\t" + line + "\n");
            }

            index++;
            line = stringBuffer.readLine();

        }
        
        if(sb.length() > 0){
          JOptionPane.showMessageDialog(null, sb.toString());
        } else {
          JOptionPane.showMessageDialog(null,"Coudln't find the keyword in file");
        }
    } catch (Exception e){
      System.out.println("Error reading contents");
    }
  }
  
}