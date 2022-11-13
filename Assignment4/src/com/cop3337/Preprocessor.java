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
    private File file;
    private JFileChooser fileChooser;
    private Validation validator;

    public Preprocessor() {
        this.fileChooser = new JFileChooser();
        this.filter = new FileNameExtensionFilter("Java and txt files", "java", "txt");
        this.fileChooser.setFileFilter(filter);
        this.validator = new Validation();
    }

    public void chooseFile() {

        int result = fileChooser.showOpenDialog(null);

        try {

            this.file = fileChooser.getSelectedFile();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Couldn't find file");
            e.printStackTrace();
        }
        if (result == JFileChooser.APPROVE_OPTION) {
            System.out.println("Successfully loaded file");

            validator.parseFile(file);

            if (validator.isFileBalanced()) {
                System.out.println("File is balanced with respect to {, ( or [");
            } else {
                System.out.println("Error: File is not balanced witrh respect to (),{}, or []");
            }
        }

    }

    public File getFile() {
        return file;
    }
}
