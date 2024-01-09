import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("John", 10);
        Student student2 = new Student("pepe trueno", 1);
        Student[] arr = new Student[] { student1, student2 };
        Arrays.sort(arr, Student.BY_CALIFICATION);
        System.err.println(Arrays.toString(arr));
    }
}