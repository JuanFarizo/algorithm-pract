import java.util.ArrayList;
import java.util.List;

/**
 * Un heap mínimo es una estructura de datos tipo árbol binario completo que
 * mantiene la propiedad de que:
 * El valor de cada nodo es menor o igual que el de sus hijos.
 * El elemento más pequeño siempre está en la raíz (índice 0).
 * Normalmente se implementa con un array o lista, porque un árbol binario
 * completo encaja muy bien en un array (sin punteros).
 */
public class MinHeap {
    private List<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
    }

    // Insertar un valor en el heap
    public void insert(int value) {
        heap.add(value); // agrega al final
        int current = heap.size() - 1;

        // sift up (burbujeo hacia arriba)
        while (current > 0 && heap.get(current) < heap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Extraer el mínimo (la raíz del heap)
    public int extractMin() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap vacío");
        }

        int min = heap.get(0); // la raíz siempre es el mínimo
        int last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last); // mover el último a la raíz
            sinkDown(0); // reordenar hacia abajo
        }

        return min;
    }

    // Reordenar hacia abajo (sift down)
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
            } else {
                return;
            }
        }
    }

    // Para debug o inspección
    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    // Utilidades
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

    // Prueba rápida
    public static void main(String[] args) {
        MinHeap heap = new MinHeap();

        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        heap.insert(6);

        System.out.println("Estado del heap: " + heap.getHeap());

        System.out.println("Extract min: " + heap.extractMin()); // 1
        System.out.println("Extract min: " + heap.extractMin()); // 3
        System.out.println("Extract min: " + heap.extractMin()); // 5

        System.out.println("Heap final: " + heap.getHeap());
    }
}
