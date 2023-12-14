public class DoubleLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public DoubleLinkedList(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
        }
        tail = newNode;
        length++;
    }

    public Node removeLast() {
        if (length == 0) return null;
        Node temp = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }

        length--;
        return temp;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;

        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node actualIndexNode = get(index);
        Node beforeActualIndexNode = actualIndexNode.prev;
        beforeActualIndexNode.next = newNode;
        actualIndexNode.prev = newNode;
        newNode.next = actualIndexNode;
        newNode.prev = beforeActualIndexNode;

        length++;
        return true;
    }


    public boolean set(int index, int value) {
        Node node = get(index);
        if (node == null) return false;
        node.value = value;
        return true;
    }

    public Node get(int index) {
        if (index < 0 || index > length) return null;
        Node temp;
        if (index < length / 2) {
            temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }

        return temp;
    }

    public void swapFirstLast() {
        if (length < 2) return;
        int valHead = head.value;
        head.value = tail.value;
        tail.value = valHead;
    }

    public boolean isPalindrome() {
        int[] forward = new int[length];
        int[] backward = new int[length];
        Node fromHead = head;
        Node fromTail = tail;
        for (int i = 0; i < length; i++) {
            forward[i] = fromHead.value;
            backward[i] = fromTail.value;
            fromHead = fromHead.next;
            fromTail = fromTail.prev;
        }

        boolean check = true;
        for (int i = 0; i < length; i++) {
            if (forward[i] != backward[i]) {
                check = false;
                break;
            }
        }
        return check;
    }

    public void swapPairs() {
        if (length <= 1) return;
        int iterations = length / 2;
        Node puntero = head;
        Node nextAux;
        for (int i = 0; i < iterations; i++) {
            nextAux = puntero.next;
            int prevVal = puntero.value;
            puntero.value = nextAux.value;
            nextAux.value = prevVal;
            puntero = puntero.next.next;
        }
    }

    public void reverse() {
        if (length < 2) return;
        int iterations = length / 2;
        Node fromHead = head;
        Node fromTail = tail;
        int valFromHead = head.value;
        for (int i = 0; i < iterations; i++) {
            fromHead.value = fromTail.value;
            fromTail.value = valFromHead;
            fromHead = fromHead.next;
            fromTail = fromTail.prev;
            valFromHead = fromHead.value;
        }
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();
        Node nodeToRemove = get(index);
        nodeToRemove.next.prev = nodeToRemove.prev;
        nodeToRemove.prev.next = nodeToRemove.next;

        nodeToRemove.next = null;
        nodeToRemove.prev = null;

        length--;
        return nodeToRemove;
    }

    public Node removeFirst() {
        if (length == 0) return null;
        Node temp;
        temp = head;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }

        length--;
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        length++;
    }


    class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead() {
        System.out.println(head.value);
    }

    public void getTail() {
        System.out.println(tail.value);
    }

    public void getLength() {
        System.out.println(length);
    }
}
