package com.cop3337;

public class Reverser extends Transpose {
    public Reverser(String s) {
        super(s);
    }

    public String reverseText(String text) {
        StringBuffer result = new StringBuffer();
        /**
         * Split the string into words array using non-alphabetic characters as delimiters
         * @link {https://stackoverflow.com/questions/4674850/converting-a-sentence-string-to-a-string-array-of-words-in-java}
         */
        String[] words = text.split("\\W+");
        for(int i = words.length - 1; i >= 0; i--){
            // System.out.println(words[i]);
            result.append(words[i] + " ");
        }
        return result.toString();
    }

    public String decode(String word) {
        // Complete this method so that it reverses the reversed string
        StringBuilder sb = new StringBuilder(word);
        return sb.reverse().toString();

    }
    
}
