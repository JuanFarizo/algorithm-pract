import java.util.Comparator;

public class Student {
    private final String name;
    private final int calification;
    static final Comparator<Student> BY_NAME = new ByName();
    static final Comparator<Student> BY_CALIFICATION = new ByCalification();

    public Student(String name, int calification) {
        this.name = name;
        this.calification = calification;
    }

    public String getName() {
        return name;
    }

    public int getCalification() {
        return calification;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", calification=" + calification + "]";
    }

    static class ByName implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getName().compareTo(o1.getName());
        }
    }

    static class ByCalification implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getCalification() - o2.getCalification();
        }
    }
}
