package com.cop3337;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

import javax.sound.sampled.Line;

public class Validation {

    private FileInputStream fis;
    private BufferedReader stringBuffer;
    private Stack<Character> stack;
    private String expression = null;
    private int length = -1;
    private LinkedList<String> fileLines = null;
    private boolean isBalanced = false;
    private String[] rt_list = { "void", "boolean", "int", "double", "String", "Integer" };

    public Validation() {
        stack = new Stack<Character>();
        fileLines = new LinkedList<String>();
    }

    public void parseFile(File file) {

        System.out.println("parsingFile...");

        try {
            stringBuffer = new BufferedReader(new FileReader(file));
            String line;

            // Loop through the lines and push to lines linked list
            while ((line = stringBuffer.readLine()) != null) {

                fileLines.push(line);

                // 1) Pass each line to the delimitersValidation
                // 2) Check for 'Public' 'class' 'classname' '{' -> push to stack (check for the
                // closing brace and state if file is valid or not given {})
                isBalanced = isBalanced(line);
            }

        } catch (Exception e) {
            System.out.println("Validator exception (parseFile): " + e);
        }

    }

    private boolean isBalanced(String s) {
        // refactor this
        s = s.trim();
        char[] chars = s.toCharArray();

        for (int index = 0; index < chars.length; index++) {

            char c = chars[index];

            switch (c) {
                // If character is an opening character, push to stack
                case Constants.LEFT_PAR:
                    System.out.println("Found opening parenthesis");
                    stack.push('(');
                    break;
                // Opening brace
                case Constants.LEFT_BRACE:
                    System.out.println("Found opening brace");
                    stack.push('{');
                    break;
                // Opening bracket
                case Constants.LEFT_BRACKET:
                    System.out.println("Found opening bracket");
                    stack.push('[');
                    break;
                // If closing character, pop from stack
                case Constants.RIGHT_PAR:
                    System.out.println("Found closing parenthesis");
                    if (stack.size() > 0)
                        stack.pop();
                    break;
                // Closing brace
                case Constants.RIGHT_BRACE:
                    System.out.println("Found closing brace");
                    if (stack.size() > 0)
                        stack.pop();
                    break;
                // Closing bracket
                case Constants.RIGHT_BRACKET:
                    System.out.println("Found closing bracket");
                    if (stack.size() > 0)
                        stack.pop();
                    break;

                default:
                    break;
            }

        }
        System.out.println("Stack size: " + stack.size());
        return stack.isEmpty();

    }

    public boolean isFileBalanced() {
        return isBalanced;
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
                switch (current) {
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

    public boolean isValidStatement(String line) {
        try {
            if (!isBalanced(line))
                return false;
            String result = convert2Postfix(line);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean isValidMethod(String line) {
        return false;
    }

    public void setExpression(String expression) {
        this.expression = expression;
        this.length = expression.length();
    }
}
