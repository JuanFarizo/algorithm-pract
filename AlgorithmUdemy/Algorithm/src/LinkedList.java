public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        Node node = new Node(value);
        this.head = node;
        this.tail = node;
        length = 1;
    }

    public void merge(LinkedList otherList) {
        Node otherHead = otherList.head;
        Node dummy = new Node(0); // Head of the merged linked list
        Node current = dummy;
        while (otherHead != null && head != null) {
            if (otherHead.value <= head.value) {
                current.next = otherHead;
                otherHead = otherHead.next;
                length++;
            } else {
                current.next = head;
                head = head.next;
            }
            current = current.next;
        }
        while (otherHead != null) {
            current.next = otherHead;
            otherHead = otherHead.next;
            current = current.next;
            length++;
        }

        while (head != null) {
            current.next = head;
            head = head.next;
            current = current.next;
        }

        head = dummy.next;
        tail = current;
    }

    // {5, 10, 8, 2, 3, 1}
    public void insertionSort() {
        if (length < 2) return;
        Node sortedListHead = head;
        Node unsortedListHead = head.next;
        sortedListHead.next = null;
        while (unsortedListHead != null) {
            Node current = unsortedListHead;
            unsortedListHead = unsortedListHead.next;
            if (current.value < sortedListHead.value) {
                current.next = sortedListHead;
                sortedListHead = current;
            } else {
                Node searchPointer = sortedListHead;
                while (searchPointer.next != null && current.value > searchPointer.next.value) {
                    searchPointer = searchPointer.next;
                }
                current.next = searchPointer.next;
                searchPointer.next = current;
            }
        }
        head = sortedListHead;
        Node temp = sortedListHead;
        while (temp.next != null) {
            temp = temp.next;
        }
        tail = temp;
    }

    public void selectionSort() {
        if (length < 2) return;
        // {10, 5, 8, 2, 3, 1}
        Node pointer = head;
        while (pointer.next != null) {
            Node smallest = pointer;
            Node innerCurrent = pointer.next;
            while (innerCurrent != null) {
                if (innerCurrent.value < smallest.value) smallest = innerCurrent;
                innerCurrent = innerCurrent.next;
            }
            if (smallest != pointer) {
                int temp = smallest.value;
                smallest.value = pointer.value;
                pointer.value = temp;
            }

            pointer = pointer.next;
        }
        tail = pointer;
    }


    public void bubbleSort() {
        if (length < 2) return;
        Node pointer = head;
        while (pointer != null) {
            Node nextPointer = pointer.next;
            while (nextPointer != null) {
                if (pointer.value > nextPointer.value) {
                    int temp = pointer.value;
                    pointer.value = nextPointer.value;
                    nextPointer.value = temp;
                }
                nextPointer = nextPointer.next;
            }
            pointer = pointer.next;
        }
    }


    public Node getHead() {
        if (head == null) {
            System.out.println("Head: null");
            return null;
        } else {
            System.out.println("Head: " + head.value);
            return head;
        }
    }

    public void getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
    }

    public int getLength() {
        return this.length;
    }

    public void append(int value) {
        Node node = new Node(value);
        if (length == 0) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        length++;
    }

    public void prepend(int value) {
        Node node = new Node(value);
        if (length == 0) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
        length++;
    }

    public Node removeLast() {
        Node removedNode;
        if (length == 0) {
            return null;
        } else if (length == 1) {
            removedNode = tail;
            head = null;
            tail = null;
        } else {
            Node temp = head;
            while (!temp.next.equals(tail)) {
                temp = temp.next;
            }
            removedNode = tail;
            temp.next = null;
            tail = temp;
        }
        length--;
        return removedNode;
    }

    public boolean insert(int index, int value) {
        if (index > length || index < 0) return false;
        if (index == 0) {
            prepend(value);
            return true;
        }

        if (index == length) {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node previosNode = get(index - 1);
        newNode.next = previosNode.next;
        previosNode.next = newNode;
        length++;

        return true;
    }

    public void makeEmpty() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public Node removeFirst() {
        Node temp;
        if (length == 0) return null;
        else {
            temp = head;
            head = head.next;
            temp.next = null;
        }
        length--;
        if (length == 0) tail = null;
        return temp;
    }

    public Node get(int index) {
        if (index >= length || index < 0) return null;
        Node temp = head;
        int i = 0;
        while (index > i) {
            temp = temp.next;
            i++;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        boolean inserted = false;

        Node actualNode = this.get(index);
        if (actualNode != null) {
            actualNode.value = value;
        }

        return inserted;
    }

    public Node remove(int index) {
        Node temp;
        if (index == 0) {
            return removeFirst();
        }
        if (index == length - 1) {
            return removeLast();
        }

        Node previosNode = get(index - 1);
        temp = previosNode.next;

        previosNode.next = temp.next;
        temp.next = null;
        length--;
        return temp;


    }

    public void reverse() {
        if (length <= 0) return;
        if (length == 1) {
            Node temp = head;
            head = tail;
            tail = temp;
            return;
        }
        Node temp = head;
        head = tail;
        tail = temp;

        Node after;
        Node before = null;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public void reverseBetween(int startIndex, int endIndex) {
        if (head == null) return;

        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node previousNode = dummyNode;

        for (int i = 0; i < startIndex; i++) {
            previousNode = previousNode.next;
        }

        Node currentNode = previousNode.next;

        for (int i = 0; i < endIndex - startIndex; i++) {
            Node nodeToMove = currentNode.next;
            currentNode.next = nodeToMove.next;
            nodeToMove.next = previousNode.next;
            previousNode.next = nodeToMove;

        }
        head = dummyNode.next;
    }


    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    //2 Solution Runner
    public Node findKthFromEnd(int k) {
        Node slow = head, fast = head;
        for (int i = 1; i < k; i++) {
            if (fast.next == null) return null;
            fast = fast.next;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public void removeDuplicates() {
        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.value == current.value) {
                    runner.next = runner.next.next;
                    length--;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public void partitionList(int x) {
        if (head == null) return;

        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);
        Node prev1 = dummy1;
        Node prev2 = dummy2;
        Node current = head;

        while (current != null) {
            if (current.value < x) {
                prev1.next = current;
                prev1 = current;
            } else {
                prev2.next = current;
                prev2 = current;
            }
            current = current.next;
        }

        prev2.next = null;
        prev1.next = dummy2.next;

        head = dummy1.next;
    }


    public Node findMiddleNode() {
        if (head == null) return null;
        if (head == tail) return head;
        Node slow = head;
        Node fast = slow.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast == null) return slow;

        return slow.next;
    }

    public boolean hasLoop() {
        if (head == null) return false;
        if (head == tail) return false;
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

    }
}
