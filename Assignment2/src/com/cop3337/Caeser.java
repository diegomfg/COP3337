package com.cop3337;

public class Caeser extends Cipher {
    public Caeser(String s) {
        super(s);
    }

    public String encode(String word) {
        return code(word, Constants.ENCODE_SHIFT);
    }

    public String decode(String word) {
        StringBuffer result = new StringBuffer();
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
             // Wrap around to decode the character
             if (Character.isUpperCase(ch)) {
                ch = (char) ('A' + (ch - 'A' + Constants.DECODE_SHIFT) % Constants.WRAP_AROUND);
            } else {
                ch = (char) ('a' + (ch - 'a' + Constants.DECODE_SHIFT) % Constants.WRAP_AROUND);
            }

            result.append(ch);
        }
        return result.toString();
    }

    String code(String word, int SHIFT) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            ch = determineCharacter(ch, SHIFT);
            result.append(ch);
        }
        return result.toString();
    }

    public char determineCharacter(char ch, final int shift) {
        if (Character.isUpperCase(ch)) {
            ch = (char) ('A' + (ch - 'A' + shift) % Constants.WRAP_AROUND);
        } else {
            ch = (char) ('a' + (ch - 'a' + shift) % Constants.WRAP_AROUND);
        }
        return ch;
    }
}
