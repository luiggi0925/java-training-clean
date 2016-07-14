package edu.globant.design.lsp.after;

public interface Stack<E> {

    E push(E item);

    E pop();

    int size();

    boolean isEmpty();

}
