package edu.globant.design.lsp.after;

public class Application {

    public static void main(final String[] args) {

        Stack<String> stack = new VectorStack<String>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        //stack.insertElementAt("squeeze me in!", 1); we cannot insert an element in a specified position in a stack.
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        // prints "3", "2", "1"
    }

}
