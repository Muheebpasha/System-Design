import java.util.HashSet;
import java.util.Objects;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;
        return id == s.id && Objects.equals(name, s.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}

public class CustomObjectHashSet {
    public static void main(String[] args) {
        HashSet<Student> students = new HashSet<>();

        students.add(new Student(1, "Saba Sultana"));
        students.add(new Student(2, "Muheeb Pasha"));
        students.add(new Student(1, "Saba Sultana")); // duplicate (same id & name)

        System.out.println(students);
    }
}

