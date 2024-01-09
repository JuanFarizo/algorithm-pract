import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack implements Iterable<T> {
    Node<T> top;
    int height;

    public Stack(T value) {
        top = new Node<>(value);
        height = 1;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node<T> current = top;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            Node<T> item = current;
            current = item.next;
            return item.value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public void push(T value) {
        var node = new Node<T>(value);
        if (height != 0) {
            node.next = top;
        }
        top = node;

        height++;
    }

    public Node<T> pop() {
        if (height == 0) return null;

        Node<T> aux = top;
        top = top.next;
        aux.next = null;

        height--;

        return aux;
    }


    public void printStack() {
        Node<T> temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }


    class Node<B> {
        B value;
        Node<B> next;

        public Node(B value) {
            this.value = value;
        }
    }
}
