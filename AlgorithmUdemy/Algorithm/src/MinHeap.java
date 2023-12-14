import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    private List<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
    }

    public void insert(int value) {
        heap.add(value);
        int current = heap.size() - 1;
        while (heap.get(current) < heap.get(parent(current)) && current > 0) {
            swap(current, parent(current));
            current = parent(current);
        }
    }


    private void sinkDown(int i) {
        int minIndex = i;
        while (true) {
            int leftIndex = leftChild(i);
            int rightIndex = rightChild(i);
            if (leftIndex < heap.size() && heap.get(leftIndex) < heap.get(minIndex)) {
                minIndex = leftIndex;
            }
            if (rightIndex < heap.size() && heap.get(rightIndex) < heap.get(minIndex)) {
                minIndex = rightIndex;
            }
            if (minIndex != i) {
                swap(i, minIndex);
                i = minIndex;
            } else return;
        }
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

}
