package com.cop3337;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.Buffer;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Preprocessor {
    private FileNameExtensionFilter filter;
    private FileInputStream fis;
    private FileOutputStream fos;
    private File file;
    private BufferedReader stringBuffer;
    private JFileChooser fileChooser;

    public Preprocessor() {
        this.fileChooser = new JFileChooser();
        this.filter = new FileNameExtensionFilter("Java and txt files", "java", "txt");
        this.fileChooser.setFileFilter(filter);
        this.fis = null;
        this.fos = null;
    }

    public void chooseFile() {

        int result = fileChooser.showOpenDialog(null);

        try {

            this.file = fileChooser.getSelectedFile();
            this.fis = new FileInputStream(this.file);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Couldn't find file");
            e.printStackTrace();
        }
        if (result == JFileChooser.APPROVE_OPTION) {
            System.out.println("Successfully loaded file");
        }
    }

}
