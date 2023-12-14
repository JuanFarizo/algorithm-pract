/**
 * Linked-list implementation.
 * <ul>
 *     <li>Every operation takes constant time in the worst case.     </li>
 *     <li>Uses extra time and space to deal with the links. </li>
 * </ul>
 */
public class T {
    int height = 0;

    Node top;

    public T(String item) {
        top = new Node(item);
        height++;
    }


    T() {

    }

    public Node pop() {
        if (height == 0) return null;
        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;
        return temp;
    }

    public void push(String item) {
        Node node = new Node(item);
        if (height != 0) {
            node.next = top;
        }
        top = node;
        height++;
    }

    public boolean isEmpty() {
        return top == null;
    }

    private class Node {
        String item;
        Node next;

        public Node(String item) {
            this.item = item;
        }
    }
}
