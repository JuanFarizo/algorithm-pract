public class Queue {
    class Node {
         int value;
         Node next;

        public Node(int value) {
            this.value = value;
        }
    }

     Node first;
     Node last;
     int length;

    public Queue(int value) {
        Node node = new Node(value);
        this.first = node;
        this.last = node;
        length++;
    }

     public void enqueue(int value) {
        Node node = new Node(value);
        if (length == 0) {
            first = node;
        } else {
            last.next = node;
        }
        last = node;

        length++;
    }

    public Node dequeue() {
        if (length == 0) return null;
        Node temp = first;
        if (length == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            temp.next = null;
        }
        length--;
        return temp;
    }

    public void printQueue() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
}
