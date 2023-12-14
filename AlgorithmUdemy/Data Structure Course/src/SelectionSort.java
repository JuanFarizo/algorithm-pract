public class SelectionSort {

    public static void sort(int[] arr) {
        // {20, -15, 7, 35, 1, -22, 55}
        int maxPos;
        for (int i = 0; i < arr.length - i - 1; i++) {
            maxPos = 0;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[maxPos] < arr[j + 1]) maxPos = j + 1;
            }
            swap(arr, maxPos, arr.length - i - 1);
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        if (index2 == index2) return;
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
