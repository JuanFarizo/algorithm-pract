/**
 * Resizing-array implementation
 * <ul>
 *    <li>Every operation takes constant amortized time</li>
 *    <li>Less wasted space </li>
 * </ul>
 */
public class StackFixedCapacity {
    int N = 0;
    String[] items;

    public StackFixedCapacity() {
        items = new String[1];
    }

    void push(String item) {
        if (N == items.length) {
            resize(N * 2);
        }
        items[N++] = item;
    }

    String pop() {
        String item = items[--N];
        items[N] = null;
        if (N > 0 && N == items.length / 4) resize(N / 4);
        return item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < items.length; i++) {
            copy[i] = items[i];
        }
        items = copy;
    }

}
