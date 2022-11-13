package com.cop3337;

import java.io.File;

import javax.swing.JOptionPane;

public class Preprocessor {

    private File file;
    private Validation validator;

    public Preprocessor() {
        this.validator = new Validation();
    }

    public void loadFile(File file) {
        this.file = file;

        validator.parseFile(file);

        if (validator.isFileBalanced()) {

            System.out.println("File is balanced with respect to {, ( or [");

        } else {

            JOptionPane.showMessageDialog(null, "Error, file is unbalanced with respect to delimiters.");

        }
    }

    public File getFile() {
        return file;
    }
}
