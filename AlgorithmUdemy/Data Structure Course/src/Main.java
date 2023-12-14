import java.util.Arrays;

//Sort Stable - Unstable
/*When the array has duplicated items and it's sorted:
Unstable: When the duplicated items do not preserve the relative orders
Stable: When the duplicated items preserver the relative orders
*/
public class Main {
    public static void main(String[] args) {
        int[] unsorted = new int[]{20, -15, 7, 35, 1, -22, 55};
        SelectionSort.sort(unsorted);
        System.out.println(Arrays.toString(unsorted));
    }
}