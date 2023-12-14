import java.util.ArrayList;
import java.util.HashMap;

public class HashTable {
  class Node {
    String key;
    int value;
    Node next;

    public Node(String key, int value) {
      this.value = value;
      this.key = key;
    }
  }

  // Colissions:
  // How to solve the problem:
  // - Separate Chanining: You use a linkedlist for achive multiple items in a
  // particular adress.
  // If have a prime number will have less colissions
  private int size = 7;
  private Node[] dataMap;

  public HashTable() {
    dataMap = new Node[size];
  }

  public int get(String key) {
    int index = hash(key);
    Node node = dataMap[index];
    if (node == null)
      return 0;
    Node temp = node;
    while (temp != null) {
      if (temp.key == key) {
        return temp.value;
      }
      temp = temp.next;
    }
    return 0;
  }

  public ArrayList<String> keys() {
    ArrayList<String> allKeys = new ArrayList<>();
    for (int i = 0; i < dataMap.length; i++) {
      Node node = dataMap[i];
      Node temp = node;
      while (temp != null) {
        allKeys.add(temp.key);
        temp = temp.next;
      }
    }
    return allKeys;
  }

  public void set(String key, int value) {
    Node node = new Node(key, value);
    int index = hash(key);
    if (dataMap[index] == null) {
      dataMap[index] = node;
    } else {
      Node temp = dataMap[index];
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = node;
    }
  }

  // Use a HashMap to solve the problem that creates an O(n) time complexity.
  public boolean itemInCommon(int[] array1, int[] array2) {
    HashMap<Integer, Boolean> hashMap = new HashMap<Integer, Boolean>();
    for (int i : array1) {
      hashMap.put(i, true);
    }
    for (int i : array2) {
      if (hashMap.get(i) != null)
        return true;
    }
    return false;
  }

  private int hash(String key) {
    int hash = 0;
    char[] keyChar = key.toCharArray();
    for (int i = 0; i < keyChar.length; i++) {
      int asciiValue = keyChar[i];
      hash = (hash * asciiValue * 23) % dataMap.length; // 23 is a prime number
    }
    return hash;
  }

  public void printTable() {
    for (int i = 0; i < dataMap.length; i++) {
      System.out.println(i + ": ");
      Node temp = dataMap[i];
      while (temp != null) {
        System.out.println("{" + temp.key + "= " + temp.value + "}");
        temp = temp.next;
      }
    }
  }
}
