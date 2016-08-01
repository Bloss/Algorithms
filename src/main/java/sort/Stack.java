package sort;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * created by stickmy on 2016/7/18 10:02
 *
 * 链表实现下压堆栈
 */
public class Stack<T> implements Iterable<T> {
    private Node<T> first;
    private int n;

    public static class Node<T> {
        private T item;
        private Node<T> next;
    }

    public Stack() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void push(T item) {
        Node<T> old = first;
        first = new Node<T>();
        first.item = item;
        first.next = old;
        n++;
    }

    public T pop() {
        if(isEmpty()){
            throw new NoSuchElementException("Stack underflow");
        }
        T item = first.item;
        first = first.next;
        n--;
        return item;
    }

    public Iterator<T> iterator() {
        return new ListIterator<T>(first);
    }

    private class ListIterator<T> implements Iterator<T> {
        private Node<T> current;

        public ListIterator(Node<T> first) {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            T item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
