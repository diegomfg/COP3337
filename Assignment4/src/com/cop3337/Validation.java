package com.company;

import java.io.File;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Validation {
    // Index of delimiter, hasClose
    private HashMap<Integer, Boolean> symbols;
    // lineIndex, delimiterFound
    private HashMap<Integer, String> lineDelimiters;

    String[] rt_list = {"void", "boolean", "int", "double", "String", "Integer"};

    private Stack<Object> stk;
    private String expression;
    private int length;

    public Validation(String expression) {
        stk = new Stack<Object>();
        this.expression = expression;
        this.length = expression.length();
    }

    public static void parseFile(File file) {
        // final var lines = Files.readAllLines(Path.of("myfile.txt" || file?));
        // FileWriter writer = new FileWriter( "output.txt");
        // String data = " ";

        // for (int i = 0; i < lines.size(); i++) {
        // data = lines.get(i);
        // StringTokenizer token = new StringTokenizer(data);
        // while (token.hasMoreElements()) {
        // writer.write(token.nextToken() + "\n");
        // }
        // }
        // writer.close();
        // }
        System.out.println("parsingFile...");
    }

    public boolean isValidStatement(String line) {
        try {
            if (!isBalance(line)) return false;
            String result = convert2Postfix(line);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean isValidMethod(String line) {
        return false;
    }

    public boolean isBalance(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public String convert2Postfix(String expression) {
        Stack<Object> stk = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        Scanner scan = new Scanner(expression);
        char current;
        boolean fail = false;

        while (scan.hasNext() && !fail) {
            String token = scan.next();
            if (isNumber(token))
                postfix.append(token).append(Constants.A_SPACE);
            else {
                current = token.charAt(0);
                if (current == Constants.LEFT_NORMAL)
                    stk.push(current);
                else if (current == Constants.RIGHT_NORMAL) {
                    try {
                        char top = (Character) stk.pop();

                        while (top != Constants.LEFT_NORMAL) {
                            postfix.append(top).append(Constants.A_SPACE);
                            top = (Character) stk.pop();
                        }
                    } catch (EmptyStackException e) {
                        fail = true;
                    }
                } else if (isOperator(current)) {
                    try {
                        char top = (Character) stk.peek();
                        boolean higher = hasHigherPrecedence(top, current);
                        while (top != Constants.LEFT_NORMAL && higher) {
                            postfix.append(stk.pop()).append(Constants.A_SPACE);
                            top = (Character) stk.peek();
                        }
                        stk.push(current);
                    } catch (EmptyStackException e) {
                        stk.push(current);
                    }
                }
            }
        }

        try {
            while (!stk.empty())
                postfix.append(stk.pop()).append(Constants.A_SPACE);
        } catch (EmptyStackException e) {
            e.printStackTrace();
        }

        return postfix.toString();
    }

    private boolean hasHigherPrecedence(char top, char current) {
        boolean higher;
        switch (top) {
            case Constants.MULTIPLICATION:
            case Constants.DIVISION:
                switch(current) {
                    case Constants.ADDITION:
                    case Constants.SUBTRACTION:
                        higher = true;
                        break;
                    default:
                        higher = false;
                        break;
                }
                break;
            default:
                higher = false;
                break;
        }
        return higher;
    }

    private boolean isOperator(char ch) {
        boolean operator;
        switch (ch) {
            case Constants.MULTIPLICATION:
            case Constants.DIVISION:
            case Constants.ADDITION:
            case Constants.SUBTRACTION:
                operator = true;
                break;
            default:
                operator = false;
                break;
        }

        return operator;
    }

    private boolean isNumber(String token) {
        boolean number = true;
        try {
            Integer.parseInt(token);
        } catch (NumberFormatException e) {
            number = false;
        }

        return number;
    }
}
