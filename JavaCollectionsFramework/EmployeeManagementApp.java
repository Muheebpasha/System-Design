import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String name;
    private String department;

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', dept='" + department + "'}";
    }
}

public class EmployeeManagementApp {

    static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n===== Employee Management =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Display Employees by Department");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addEmployee(sc);
                    break;
                case 2:
                    deleteEmployee(sc);
                    break;
                case 3:
                    displayByDepartment();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Add new employee
    public static void addEmployee(Scanner sc) {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        employees.add(new Employee(id, name, dept));
        System.out.println("Employee Added Successfully!");
    }

    // Delete employee by ID
    public static void deleteEmployee(Scanner sc) {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        boolean removed = employees.removeIf(emp -> emp.getId() == id);
        if (removed)
            System.out.println("Employee Removed!");
        else
            System.out.println("Employee Not Found!");
    }

    // Display employees grouped by department
    public static void displayByDepartment() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
            return;
        }

        Map<String, List<Employee>> grouped =
                employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));

        grouped.forEach((dept, empList) -> {
            System.out.println("\n--- Department: " + dept + " ---");
            empList.forEach(System.out::println);
        });
    }
}

