public class QueueString {
    int N = 0;
    Node first;
    Node last;

    public QueueString(String item) {
        first = new Node(item);
    }

    public void enqueue(String item) {
        Node node = new Node(item);
        if (isEmpty()) {
            first = node;
        } else {
            last.next = node;
        }
        last = node;
        N++;
    }

    public Node dequeue() {
        Node temp = first;
        first = first.next;
        N--;
        if (isEmpty()) last = null;
        return temp;
    }

    public boolean isEmpty() {
        return N == 0;
    }


    class Node {    
        String item;
        Node next;

        public Node(String item) {
            this.item = item;
        }
    }
}
