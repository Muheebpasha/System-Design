import java.util.List;

class Employee {
    private String name;
    private List<String> skills;

    Employee(String name, List<String> skills) {
        this.name = name;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    
}

class Order {
    private int id;
    private List<String> items;
    
    Order(int id, List<String> items) {
        this.id = id; this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
    
}


class flatMapExample {
     public static void main(String[] args) {
          // Convert List of Employees → List of Skills
          List<Employee> employees = List.of(
               new Employee("Muheeb Pasha", List.of("Java", "Spring Boot")),
               new Employee("Ameer Suhail", List.of("React-js","Node")),
               new Employee("Maaz", List.of("Laravel","PHP","Java"))
          );


          List<String> allSkills = employees.stream().flatMap(emp -> emp.getSkills().stream()).toList();
          
          allSkills.forEach(System.out::println);

          //✅ 2. Get employees who have the given skillName list

            List<String> requiredSkills = List.of("Java", "Spring Boot");

            List<String> matchingEmployeeNames = employees.stream()
                    .filter(emp -> emp.getSkills().containsAll(requiredSkills))
                    .map(Employee::getName)
                    .toList();

            System.out.println(matchingEmployeeNames);

            //✅ 1. Case-Sensitive Java Skill Match
            List<Employee> javaEmployees = employees.stream()
                                .filter(emp -> emp.getSkills().contains("Java")).toList();
                            
            javaEmployees.forEach(e-> System.out.println(e.getName()));


        //✅ 2. Case-Insensitive Java Skill Match -> Useful if skill may be "java", "JAVA", etc.
            List<Employee> javaEmployees2 = employees.stream()
                                .filter(emp -> emp.getSkills().stream()
                                .anyMatch(skill -> skill.equalsIgnoreCase("java"))).toList(); 
                                
            javaEmployees2.forEach(e-> System.out.println(e.getName()));

        // ✅ 3. Partial Match (skill contains “Java”) -> Useful for skills like Java 8, Java Developer, etc.

        List<Employee> javaEmployees3 = employees.stream()
                                    .filter(emp -> emp.getSkills().stream()
                                                .anyMatch(skill -> skill.toLowerCase().contains("java"))).toList();

            javaEmployees3.forEach(e -> System.out.println(e.getName()));

          List<Order> orders = List.of(
               new Order(1, List.of("Shirt", "Cap")),
               new Order(2, List.of("Shoes")),
               new Order(3, List.of("Watch", "Belt"))
          );

          List<String> allItems = orders.stream().flatMap(order->order.getItems().stream()).toList();

          System.out.println(allItems);

          
          

          //Goal : Convert to uppercase → Flatten characters → Count frequency

     }
}
