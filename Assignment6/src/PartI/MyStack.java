package PartI;

import java.util.ArrayList;
import java.util.EmptyStackException;


public class MyStack<E> {

    private ArrayList<E> ar;

    public MyStack() {
        ar = new ArrayList<E>();
    }

    public boolean empty() {
        return ar.size() == 0;
    }

    public E peek() {
        if (empty()) {
            throw new EmptyStackException();
        } else
            return ar.get(ar.size() - 1);
    }

    public E pop() {
        if (empty()) {
            throw new EmptyStackException();
        } else {
            return ar.remove(ar.size() - 1);
        }
    }

    public E push(E item) {
        ar.add(item);
        return item;
    }

    public int search(Object o) {
        E obj;
        try {
            obj = (E) o;
        } catch (Exception e) {
            return -1;
        }
        for (int i = 0; i < ar.size(); i++) {
            if (ar.get(i) == obj) {
                return i;
            }
        }
        return -1;
    }

}
