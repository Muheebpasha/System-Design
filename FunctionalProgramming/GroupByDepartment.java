import java.util.*;
import java.util.stream.Collectors;

public class GroupByDepartment {
    static class Employee {
        String name;
        String department;
        int salary;
        List<String> skills;
        
        Employee(String name, String department, int salary, List<String> skills) {
            this.name = name;
            this.department = department;
            this.salary = salary;
            this.skills = skills;
        }

        @Override
        public String toString() {
            return name + " (" + department + ", ₹" + salary + " , "+ skills + " )";
        }
    }

    public static void main(String[] args) {
         List<Employee> employees = List.of(
                 new Employee("Muheeb", "IT", 90000, List.of("Java", "Spring", "SQL")),
                  new Employee("Maaz", "IT", 85000, List.of("React", "Kafka", "Java")),
                  new Employee("Ameer", "IT", 95000, List.of("Java", "Microservices", "Docker")),
                  new Employee("Saba", "HR", 55000, List.of("Communication", "Recruitment")),
                  new Employee("Riya", "HR", 70000, List.of("Excel", "People Management")),
                  new Employee("Sameer", "Finance", 90000, List.of("Excel", "MIS", "Tally")),
                  new Employee("Sara", "Finance", 75000, List.of("Tally", "Accounting"))
        );
        
        int totalSalary = employees.stream().mapToInt(emp -> emp.salary).sum();

        System.out.println("Total Salaries :"+totalSalary);

        // Group by department
        Map<String, List<Employee>> grouped = employees.stream()
                .collect(Collectors.groupingBy(emp -> emp.department));

        System.out.println("➡ GROUPED EMPLOYEES");
        System.out.println(grouped);
        
                // TOP 3 employees per department based on salary
        Map<String, List<Employee>> top3PerDept = new HashMap<>();
      // Step 2: Sort and take top 3
      
      for (Map.Entry<String, List<Employee>> entry : grouped.entrySet()) {
          List<Employee> sortedList = entry.getValue().stream()
                  .sorted((e1, e2) -> Integer.compare(e2.salary, e1.salary))
                  .limit(3)
                  .toList();
          
          top3PerDept.put(entry.getKey(), sortedList);
      }

      System.out.println("\nTop 3 Salary Employees Per Dept:");
      top3PerDept.forEach((dept, list) -> System.out.println(dept + " → " + list));



        // Print department -> employee names
        System.out.println("\n➡ FORMATTED OUTPUT");
        grouped.forEach((dept, emps) ->
                System.out.println(dept + " → " + emps.stream().map(e -> e.name).toList())
        );

        // Sum salary by department
        Map<String, Integer> salaryByDept = employees.stream()
                .collect(Collectors.groupingBy(emp -> emp.department,
                        Collectors.summingInt(emp -> emp.salary)));

        System.out.println("\n➡ TOTAL SALARY BY DEPARTMENT");
        System.out.println(salaryByDept);

        // Pretty print salary
        salaryByDept.forEach((dept, total) ->
                System.out.println(dept + " = ₹" + total)
        );
        
        
        // TOP 3 employees per department based on salary
        Map<String, List<Employee>> top3PerDept2 = employees.stream()
                .collect(Collectors.groupingBy(emp -> emp.department,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted((e1, e2) -> Integer.compare(e2.salary, e1.salary)) // Desc order
                                        .limit(3)
                                        .toList()
                        )));

        System.out.println("\n➡ TOP 3 Salary Employees per Department");

        top3PerDept2.forEach((dept, list) ->
                System.out.println(dept + " → " + list)
        );
        
        
        //📌 Now Use flatMap() to Extract All Skills (Across All Employees)
        
        List<String> allSkills = employees.stream()
                        .flatMap(emp -> emp.skills.stream())
                        .distinct()
                        .toList();

        System.out.println(allSkills);

      //📌 Group Employees by Skill (Reverse Mapping)
      Map<String, List<String>> employeesBySkill = employees.stream()
        .flatMap(emp -> emp.skills.stream().map(skill -> Map.entry(skill, emp.name)))
        .collect(Collectors.groupingBy(Map.Entry::getKey,
                Collectors.mapping(Map.Entry::getValue, Collectors.toList())));

      System.out.println(employeesBySkill);
      
      //📌 Count How Many Employees Know Each Skill
      Map<String, Long> skillCount = employees.stream()
        .flatMap(emp -> emp.skills.stream())
        .collect(Collectors.groupingBy(skill -> skill, Collectors.counting()));

      System.out.println(skillCount);
      
      //📌 Filter: Find Employees Who Know Java
      
      List<Employee> javaDevs = employees.stream()
        .filter(emp -> emp.skills.contains("Java"))
        .toList();

      System.out.println("Java Dev (filtered) : "+javaDevs);


      //📌 Combine: Top 3 Salary Employees Who Know Java
      
      List<Employee> topJavaDevs = employees.stream()
        .filter(emp -> emp.skills.contains("Java"))
        .sorted((e1, e2) -> Integer.compare(e2.salary, e1.salary))
        .limit(3)
        .toList();

      System.out.println(topJavaDevs);

      //📌 Multi-Level Grouping (Dept → Skill → Employees)
      Map<String, Map<String, List<Employee>>> deptSkillMap =
        employees.stream()
                .collect(
                        Collectors.groupingBy(emp -> emp.department, // 1st level: department
                                Collectors.flatMapping(
                                        emp -> emp.skills.stream()
                                                .map(skill -> Map.entry(skill, emp)),
                                        Collectors.groupingBy(Map.Entry::getKey,
                                                Collectors.mapping(Map.Entry::getValue, Collectors.toList()))
                                )
                        )
                );

        //📌 Printing Result Nicely
        deptSkillMap.forEach((dept, skillMap) -> {
                  System.out.println("\nDepartment: " + dept);
                  skillMap.forEach((skill, emps) ->
                          System.out.println("  " + skill + " → " + emps.stream().map(e -> e.name).toList()));
              });
              
        //📌 Multi-Level Grouping + Salary Aggregation Per Skill
        //Now let's compute total salary for each skill inside each department:
      
        Map<String, Map<String, Integer>> salaryPerDeptSkill =
        employees.stream()
                .collect(
                        Collectors.groupingBy(emp -> emp.department,
                                Collectors.flatMapping(
                                        emp -> emp.skills.stream()
                                                .map(skill -> Map.entry(skill, emp.salary)),
                                        Collectors.groupingBy(Map.Entry::getKey,
                                                Collectors.summingInt(Map.Entry::getValue))
                                )
                        )
                );


      System.out.println("\nSalary Aggregation Per Skill: " + salaryPerDeptSkill);



    }
}

