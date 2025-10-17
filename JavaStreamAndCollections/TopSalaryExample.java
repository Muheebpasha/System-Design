import java.util.*;
import static java.util.stream.Collectors.*;

class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return name + " (" + salary + ")";
    }
}

public class TopSalaryExample {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("Muheeb Pasha", "Software Developer", 57000),
            new Employee("Mohammed Yaseer", "Software Developer", 62000),
            new Employee("Shafiq Pasha", "Software Developer", 44000),
            new Employee("Mohammed Maaz", "Business Developer", 45000),
            new Employee("Mohammed Shahid", "Business Developer", 55000),
            new Employee("Mukram Muneer", "Operation Head", 35000),
            new Employee("Mufeez Muneer", "Sales Lead", 32000),
            new Employee("Mohammed Affan", "HR Head", 30000),
            new Employee("Ameer Suhail", "Software Developer", 65000),
            new Employee("Riyaan Ahmed", "Data Engineer", 65000),
            new Employee("Syed Zeeshan", "Data Engineer", 58000),
            new Employee("Mohammed Arham", "Data Engineer", 20000),
            new Employee("Mohammed Hanzalah", "Business Developer", 18000),
            new Employee("Mahnoor Aiza", "HR Head", 15000)
        );

        Map<String, List<Employee>> topThreeByDept = employees.stream()
            .collect(
                groupingBy(
                    Employee::getDepartment,
                    collectingAndThen(
                        toList(),
                        list -> list.stream()
                                    .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                    .limit(3)
                                    .toList()
                    )
                )
            );

        topThreeByDept.forEach((dept, empList) -> {
            System.out.println(dept + ": " + empList);
        });
    }
}

