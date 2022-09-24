package com.cop3337;

public class Transpose extends Cipher {
    Transpose(String s) {
        super(s);
    }

    public String encode(String word) {
        StringBuffer result = new StringBuffer(word);
        result.reverse();
        return result.toString();
    }

    public String decode(String word) {
        StringBuffer originalWord = new StringBuffer(word);
        return originalWord.reverse().toString();
    }
}
