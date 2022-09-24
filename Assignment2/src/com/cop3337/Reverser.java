package com.cop3337;

public class Reverser extends Transpose {
    public Reverser(String s) {
        super(s);
    }

    public String reverseText(String word) {
        // Complete this method so that it reverses the original string
        StringBuilder sb = new StringBuilder(word);
        return sb.reverse().toString();
    }

    public String decode(String word) {
        // Complete this method so that it reverses the reversed string
        StringBuilder sb = new StringBuilder(word);
        return sb.reverse().toString();

    }
}
