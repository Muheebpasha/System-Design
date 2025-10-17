import java.util.*;

class Employee {
    private String name;
    private String department;
    private double salary;
    private List<String> skills;

    public Employee(String name, String department, double salary, List<String> skills) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.skills = skills;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public List<String> getSkills() { return skills; }

    @Override
    public String toString() {
        return name + " (" + salary + ") " + skills;
    }
}

class TopCandidates {
    public static void main(String[] args) {
      List<Employee> employees = List.of(
          new Employee("Muheeb Pasha", "Software Developer", 57000, List.of("Java", "Spring", "SQL")),
          new Employee("Ameer Suhail", "Software Developer", 65000, List.of("Java", "Python", "Docker")),
          new Employee("Riyaan Ahmed", "Data Engineer", 65000, List.of("Python", "SQL", "AWS")),
          new Employee("Mohammed Maaz", "Business Developer", 45000, List.of("Communication", "Excel")),
          new Employee("Mukram Muneer", "Operation Head", 35000, List.of("Management", "Planning")),
          new Employee("Mufeez Muneer", "Sales Lead", 32000, List.of("Sales", "Negotiation")),
          new Employee("Mohammed Affan", "HR Head", 30000, List.of("Recruitment", "Communication"))
      );
      
      // Job Requirements
      List<String> requiredSkills = List.of("Java", "Spring", "SQL");
      String targetDepartment = "Software Developer"; // optional filter
      double minSalary = 50000; // optional filter
      int topN = 5;
      
      //Functional Pipeline
      List<Employee> topCandidates = employees.stream()
      // Step 1: Optional department filter
      .filter(e -> e.getDepartment().equals(targetDepartment))
      
      // Step 2: Optional minimum salary filter
      .filter(e -> e.getSalary() >= minSalary)
      
      // Step 3: Sort by skills match descending, then by salary descending
      .sorted(
          Comparator.comparingInt(
              (Employee e) -> (int) e.getSkills().stream()
                                      .filter(requiredSkills::contains)
                                      .count()
          ).reversed()
          .thenComparing(Comparator.comparingDouble(Employee::getSalary).reversed())
      )
      
      // Step 4: Pick top N
      .limit(topN)
      
      // Step 5: Collect result
      .toList();

      //Print Result
      System.out.println("Top candidates for the job:");
      topCandidates.forEach(System.out::println);
    }
}
