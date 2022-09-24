package com.cop3337;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        String code, output = "";
        String text = JOptionPane.showInputDialog("Enter message");
        output += "The original message is \n" + text + "\n";

        // Caeser Cipher
        // Cipher c = new Caeser(text);
        // c.encrypt();
        // code = c.getEncodedMessage();
        // output += "\nCeasar Cipher\nThe encrypted message is \n" + code + "\n";
        // c.decrypt(code);
        // code = c.getDecodedMessage();
        // output += "The decrypted message is \n" + code + "\n";
        // Transpose Cipher
        Cipher c;
        c = new Transpose(text);
        c.encrypt();
        code = c.getEncodedMessage();
        output += "\nTranspose\nThe encrypted Transpose message is \n" + code + "\n";
        c.decrypt(code);
        code = c.getDecodedMessage();
        output += "The decripted Transpose message is \n" + code + "\n";
        // Reverser Cipher
        // c = new Reverser(text);
        // c.encrypt();
        // code = c.getEncodedMessage();
        // code = c.reverseText(code);
        // output += "\nReverser\nThe encrypted Reverse message is \n" + code + "\n";
        // code = c.decode(code);
        // output += "The decrypted Reverse message is \n" + code;

        display(output);
    }

    static void display(String s) {
        JOptionPane.showMessageDialog(null, s, "Encrypt/decrypt",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
