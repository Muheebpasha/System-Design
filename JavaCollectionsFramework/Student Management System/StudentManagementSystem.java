import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentManagementSystem {
    private static final String FILE_NAME = "students.dat";
    private static HashMap<Integer, Student> students = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        loadStudents(); // Load existing students

        int choice;
        do {
            System.out.println("\n=== 🎓 Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewAllStudents();
                case 3 -> searchStudent();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 6 -> System.out.println("👋 Exiting... Goodbye!");
                default -> System.out.println("❌ Invalid choice. Try again!");
            }
        } while (choice != 6);
    }

    // 📥 Load students from file
    @SuppressWarnings("unchecked")
    private static void loadStudents() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (HashMap<Integer, Student>) ois.readObject();
            System.out.println("✅ Loaded " + students.size() + " students from file.");
        } catch (FileNotFoundException e) {
            System.out.println("ℹ️ No existing data found. Starting fresh...");
        } catch (Exception e) {
            System.out.println("❌ Error loading students: " + e.getMessage());
        }
    }

    // 💾 Save students to file
    private static void saveStudents() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
            System.out.println("💾 Data saved successfully.");
        } catch (Exception e) {
            System.out.println("❌ Error saving data: " + e.getMessage());
        }
    }

    private static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (students.containsKey(id)) {
            System.out.println("⚠️ Student with this ID already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        Student s = new Student(id, name, age, course);
        students.put(id, s);

        saveStudents();
        System.out.println("✅ Student added successfully!");
    }

    private static void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("📭 No students found!");
            return;
        }

        System.out.println("\n--- 🧾 Student List ---");
        for (Map.Entry<Integer, Student> entry : students.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    private static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        int id = sc.nextInt();

        if (students.containsKey(id)) {
            System.out.println("✅ Found: " + students.get(id));
        } else {
            System.out.println("❌ Student not found!");
        }
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (!students.containsKey(id)) {
            System.out.println("❌ Student not found!");
            return;
        }

        Student s = students.get(id);

        System.out.print("Enter new name (leave blank to keep '" + s.getName() + "'): ");
        String name = sc.nextLine();
        if (!name.isBlank()) s.setName(name);

        System.out.print("Enter new age (current " + s.getAge() + "): ");
        int age = sc.nextInt();
        sc.nextLine();
        if (age > 0) s.setAge(age);

        System.out.print("Enter new course (leave blank to keep '" + s.getCourse() + "'): ");
        String course = sc.nextLine();
        if (!course.isBlank()) s.setCourse(course);

        students.put(id, s);
        saveStudents();

        System.out.println("✅ Student updated successfully!");
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        if (students.remove(id) != null) {
            saveStudents();
            System.out.println("🗑️ Student deleted successfully!");
        } else {
            System.out.println("❌ Student not found!");
        }
    }
}

