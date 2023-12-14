import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
    Node root;

    BinarySearchTree(int value) {
        this.root = new Node(value);
    }

    BinarySearchTree() {
    }

    public Integer kthSmallest(int k) {
        Stack<Node> stack = new Stack<>();
        Node node = this.root;

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            k -= 1;
            if (k == 0) {
                return node.value;
            }
            node = node.right;
        }
        return null;
    }

    public void insert(int value) {
//        Node newNode = new Node(value);
        if (root == null) {
            root = new Node(value);
            return;
        }
        rInsert(root, value);
//        if (root == null) {
//            root = newNode;
//            return true;
//        }
//        Node temp = root;
//        while (true) {
//            if (newNode.value == temp.value)
//                return false;
//            if (newNode.value < temp.value) {
//                if (temp.left == null) {
//                    temp.left = newNode;
//                    return true;
//                }
//                temp = temp.left;
//            } else {
//                if (temp.right == null) {
//                    temp.right = newNode;
//                    return true;
//                }
//                temp = temp.right;
//            }
//        }
    }

    //Breath First Search
    //performs a breadth-first search traversal of
    // the tree and returns an ArrayList of the visited nodes'
    // values in the order they were visited.
    public ArrayList<Integer> BFS() {
        ArrayList<Integer> results = new ArrayList<>();
        Node currentNode = root;

        Queue<Node> queue = new LinkedList<>();
        queue.add(currentNode);
        while (queue.size() > 0) {
            currentNode = queue.remove();
            results.add(currentNode.value);
            if (currentNode.left != null) queue.add(currentNode.left);
            if (currentNode.right != null) queue.add(currentNode.right);
        }
        return results;
    }

    //Depth First Search.- PreOrder
    //          47
    //      21      76
    //    18  27  52  82
    // Result:
    // 47 21 18 27 76 52 82
    public ArrayList<Integer> DFSPreOrder() {
        ArrayList<Integer> results = new ArrayList<>();
        class Traverse {
            Traverse(Node currentNode) {
                results.add(currentNode.value);
                if (currentNode.left != null) new Traverse(currentNode.left);
                if (currentNode.right != null) new Traverse(currentNode.right);
            }
        }
        new Traverse(root);
        return results;
    }

    public ArrayList<Integer> DFSPreOrderAlternative() {
        ArrayList<Integer> results = new ArrayList<>();
        DFSPreOrderHelper(root, results);
        return results;
    }

    private void DFSPreOrderHelper(Node currentNode, ArrayList<Integer> results) {
        if (currentNode == null) return;

        results.add(currentNode.value);
        DFSPreOrderHelper(currentNode.left, results);
        DFSPreOrderHelper(currentNode.right, results);
    }


    //Depth First Search.- PostOrder
    public ArrayList<Integer> DFSPostOrder() {
        ArrayList<Integer> results = new ArrayList<>();
        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode.left != null) new Traverse(currentNode.left);
                if (currentNode.right != null) new Traverse(currentNode.right);
                results.add(currentNode.value);
            }
        }
        new Traverse(root);
        return results;
    }

    public ArrayList<Integer> DFSPostOrderAlternative() {
        ArrayList<Integer> results = new ArrayList<>();
        DFSPostOrderHelper(root, results);
        return results;
    }

    private void DFSPostOrderHelper(Node currentNode, ArrayList<Integer> results) {
        if (currentNode == null) return;

        DFSPostOrderHelper(currentNode.left, results);
        DFSPostOrderHelper(currentNode.right, results);
        results.add(currentNode.value);
    }

    public ArrayList<Integer> DFSInOrder() {
        ArrayList<Integer> results = new ArrayList<>();
        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode.left != null) new Traverse(currentNode.left);
                results.add(currentNode.value);
                if (currentNode.right != null) new Traverse(currentNode.right);
            }
        }
        new Traverse(root);
        return results;
    }

    public ArrayList<Integer> DFSInOrderAlternative() {
        ArrayList<Integer> results = new ArrayList<>();
        DFSInOrderHelper(root, results);
        return results;
    }

    private void DFSInOrderHelper(Node currentNode, ArrayList<Integer> results) {
        if (currentNode == null) return;

        DFSInOrderHelper(currentNode.left, results);
        results.add(currentNode.value);
        DFSInOrderHelper(currentNode.right, results);
    }

    private Node deleteNode(Node currentNode, int value) {
        if (currentNode == null) return null;

        if (value < currentNode.value) {
            currentNode.left = deleteNode(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = deleteNode(currentNode.right, value);
        } else {
            if (currentNode.left == null && currentNode.right == null) {
                return null;
            } else if (currentNode.left == null) {
                currentNode = currentNode.right;
            } else if (currentNode.right == null) {
                currentNode = currentNode.left;
            } else {
                int minVal = minValue(currentNode.right);
                currentNode.value = minVal;
                currentNode.right = deleteNode(currentNode.right, minVal);
            }
        }
        return currentNode;
    }

    private int minValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    public void deleteNode(int value) {
        deleteNode(root, value);
    }

    private Node rInsert(Node currentNode, int value) {
        if (currentNode == null) return new Node(value);

        if (value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }

    public boolean rContains(int value) {
        // Re-Write recursively the contains method in rContains(Node, int);
        return rContains(root, value);
//        Node temp = root;
//        while (temp != null) {
//            if (value < temp.value) {
//                temp = temp.left;
//            } else if (value > temp.value) {
//                temp = temp.right;
//            } else {
//                return true;
//            }
//        }
//        return false;
    }

    private boolean rContains(Node currentNode, int value) {
        if (currentNode == null) return false;
        if (currentNode.value == value) return true;
        return value > currentNode.value ?
                rContains(currentNode.right, value) :
                rContains(currentNode.left, value);
    }

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

}
