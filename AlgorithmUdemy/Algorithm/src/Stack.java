public class Stack {


    Node top;
    int height;

    public Stack(int value) {
        Node node = new Node(value);
        top = node;
        height = 1;
    }

    public void push(int value) {
        Node node = new Node(value);
        if (height != 0) {
            node.next = top;
        }
        top = node;

        height++;
    }

    public Node pop() {
        if (height == 0) return null;

        Node aux = top;
        top = top.next;
        aux.next = null;

        height--;

        return aux;
    }


    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
