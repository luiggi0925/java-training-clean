package edu.globant.design.lsp.before;

import java.util.Stack;

public class Application {

    public static void main(final String[] args) {

        Stack<String> stack = new Stack<String>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.insertElementAt("squeeze me in!", 1);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        // prints "3", "2", "squeeze me in!", "1"

    }

}
