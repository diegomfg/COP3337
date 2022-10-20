package com.cop3337;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

class FileController {
  private JFileChooser chooser;
  private FileNameExtensionFilter filter;

  public FileController(){
    this.chooser = new JFileChooser();
    this.filter = new FileNameExtensionFilter(
                "JPG & Text Images", "jpg", "txt");

        chooser.setFileFilter(filter);
  }

  public int chooseFile(){
    return this.chooser.showOpenDialog(null);
  }

  public JFileChooser getChooser() {
    return chooser;
  }

  
}