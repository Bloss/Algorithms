package algorithms;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * created by stickmy on 2016/7/18 10:54
 *
 * 链表实现Queue
 */
public class Queue<T> implements Iterable<T> {
    private Node<T> first;
    private Node<T> last;
    private int n;

    public static class Node<T> {
        private T item;
        private Node<T> next;
    }

    public Queue() {
        first = null;
        last = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void enqueue(T item) {
        Node<T> old = last;
        last = new Node<T>();
        last.item = item;
        last.next = null;
        if(isEmpty())
            first = last;
        else
            old.next = last;
        n++;
    }

    public T dequeue() {
        if(isEmpty()){
            throw new NoSuchElementException("Queue underflow");
        }
        T item = first.item;
        first = first.next;
        if(isEmpty())
            last = null;
        return item;
    }

    public Iterator<T> iterator() {
        return new ListIterator<T>(first);
    }

    public class ListIterator<T> implements Iterator<T> {
        private Node<T> current;

        public ListIterator(Node<T> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            T item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {

        }
    }
}
