import java.util.Arrays;

public class SortAlgorithm {

    static int[] unsorted = new int[] { 4, 6, 1, 7, 3, 2, 5 };

    public static void main(String[] args) {
        mergeSort(unsorted);
        System.out.println(Arrays.toString(unsorted));
    }

    public static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    public static void quickSortHelper(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = pivot(array, left, right);
            quickSortHelper(array, left, pivotIndex - 1);
            quickSortHelper(array, pivotIndex + 1, right);
        }
    }

    /**
     * Helper function for QuickSort.
     * Sort one half of the array using a Pivot
     * And before finish, swap places with the greatest of the all less elements
     */
    public static int pivot(int[] array, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if (array[pivotIndex] > array[i]) {
                swapIndex++;
                swap(array, swapIndex, i);
            }
        }
        swap(array, pivotIndex, swapIndex);

        return swapIndex;
    }

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    public static int[] mergeSort(int[] array) {
        // Base case array.length = 1
        if (array.length == 1)
            return array;
        // Break array in half
        int oneHalf = array.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, oneHalf));
        int[] right = mergeSort(Arrays.copyOfRange(array, oneHalf, array.length));

        // Use merge() to put arrays together
        return merge(left, right);
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                merged[index] = arr1[j];
                index++;
                i++;
            } else {
                merged[index] = arr2[j];
                index++;
                j++;
            }
        }
        while (i < arr1.length) {
            merged[index] = arr1[i];
            index++;
            i++;
        }
        while (j < arr2.length) {
            merged[index] = arr2[j];
            index++;
            j++;
        }
        return merged;
    }

    public static void shellSort(int[] unsorted) {
        int N = unsorted.length;
        int h = 1;

        while (h < N / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) { // h-sort the array
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && unsorted[j] < unsorted[j - h]; j -= h) {
                    int temp = unsorted[j];
                    unsorted[j] = unsorted[j - h];
                    unsorted[j - h] = temp;
                }
            }

            h = h / 3;
        }
    }

    // {10, 5, 8, 2, 3, 1}
    public static void bubbleSort(int[] unsorted) {
        int temp;
        for (int i = 0; i < unsorted.length - 1; i++) {
            for (int j = 1 + i; j < unsorted.length; j++) {
                if (unsorted[i] > unsorted[j]) {
                    temp = unsorted[i];
                    unsorted[i] = unsorted[j];
                    unsorted[j] = temp;
                }
            }
        }
    }

    // {10, 5, 8, 2, 3, 1}
    // minIndex = 0;
    public static void selectionSort(int[] unsorted) {
        int minIndex;
        for (int i = 0; i < unsorted.length - 1; i++) {
            minIndex = i;
            int numI = unsorted[i];
            for (int j = i + 1; j < unsorted.length; j++) {
                if (numI > unsorted[j]) {
                    minIndex = j;
                    numI = unsorted[j];
                }
            }
            if (minIndex != i) {
                int temp = unsorted[i];
                unsorted[i] = unsorted[minIndex];
                unsorted[minIndex] = temp;
            }
        }
    }

    // {10, 5, 8, 2, 3, 1}
    // {5, 10, 8, 2, 3, 1}
    // {5, 8, 10, 2, 3, 1}
    public static void insertionSort(int[] unsorted) {
        for (int i = 1; i < unsorted.length; i++) {
            int num = unsorted[i];
            for (int j = i - 1; j >= 0; j--) {
                if (num < unsorted[j]) {
                    unsorted[j + 1] = unsorted[j];
                    unsorted[j] = num;
                }
            }
        }
    }
}
