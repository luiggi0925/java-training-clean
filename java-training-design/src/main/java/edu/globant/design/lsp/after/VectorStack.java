package edu.globant.design.lsp.after;

import org.apache.commons.lang3.Validate;

import java.util.Vector;

public class VectorStack<E> implements Stack<E> {

    private int current = 0;
    private Vector<E> items = new Vector<E>();

    @Override
    public E push(E item) {
        Validate.notNull(item, "The item cannot be null");
        items.add(item);
        current++;
        return item;
    }

    @Override
    public E pop() {
        if (items.isEmpty()) {
            return null;
        }
        current--;
        return items.remove(current);
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

}
