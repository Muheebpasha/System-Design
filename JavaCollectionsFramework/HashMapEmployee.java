import java.util.HashMap;
import java.util.Map;

class Employee {
    private String name;
    private double salary;
    private String dob;
    private String department;
    private String address;

    // Constructor
    public Employee(String name, double salary, String dob, String department, String address) {
        this.name = name;
        this.salary = salary;
        this.dob = dob;
        this.department = department;
        this.address = address;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDob() {
        return dob;
    }

    public String getDepartment() {
        return department;
    }

    public String getAddress() {
        return address;
    }

    // For displaying employee details
    @Override
    public String toString() {
        return "Name: " + name + 
               ", Salary: " + salary + 
               ", DOB: " + dob + 
               ", Department: " + department + 
               ", Address: " + address;
    }
}




public class HashMapEmployee {
    public static void main(String[] args) {

        // Create HashMap (key = ID, value = Employee object)
        Map<Integer, Employee> employees = new HashMap<>();

        // 1️⃣ put() → Add key-value pairs
        employees.put(101, new Employee("Muheeb Pasha", 50000, "1992-04-15", "IT", "Bangalore"));
        employees.put(102, new Employee("Maaz", 40000, "1998-06-20", "Finance", "Hyderabad"));
        employees.put(103, new Employee("Mukram", 45000, "1998-11-10", "Marketing", "Chennai"));

        // 2️⃣ size()
        System.out.println("Total Employees: " + employees.size());

        // 3️⃣ get(key)
        System.out.println("\nEmployee with ID 101:");
        System.out.println(employees.get(101));

        // 4️⃣ containsKey()
        System.out.println("\nContains key 102? " + employees.containsKey(102));

        // 5️⃣ containsValue()
        // (This works but compares full object equality, rarely used for custom objects)
        System.out.println("Contains value Maaz object? " + employees.containsValue(new Employee("Maaz", 40000, "1998-06-20", "Finance", "Hyderabad")));

        // 6️⃣ keySet() → all keys
        System.out.println("\nAll Employee IDs:");
        for (Integer id : employees.keySet()) {
            System.out.println(id);
        }

        // 7️⃣ values() → all values
        System.out.println("\nAll Employee details:");
        for (Employee emp : employees.values()) {
            System.out.println(emp);
        }

        // 8️⃣ entrySet() → both keys and values
        System.out.println("\nAll Entries (ID + Employee):");
        for (Map.Entry<Integer, Employee> entry : employees.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " => " + entry.getValue());
        }

        // 9️⃣ replace(key, value)
        employees.replace(102, new Employee("Maaz", 42000, "1998-06-20", "Finance", "Hyderabad"));
        System.out.println("\nAfter updating Maaz's salary:");
        System.out.println(employees.get(102));

        // 🔟 remove(key)
        employees.remove(103);
        System.out.println("\nAfter removing employee with ID 103:");
        System.out.println(employees);

        // 1️⃣1️⃣ isEmpty()
        System.out.println("\nIs map empty? " + employees.isEmpty());

        // 1️⃣2️⃣ clear()
        employees.clear();
        System.out.println("\nAfter clearing all employees:");
        System.out.println("Is map empty now? " + employees.isEmpty());
        
        //HashMap<String, String> capitalCities = new HashMap<String, String>();
        //capitalCities.put("England", "London");
        //capitalCities.put("India", "New Dehli");
        //capitalCities.put("Austria", "Wien");
        //capitalCities.put("Norway", "Oslo");
        //capitalCities.put("USA", "Washington DC");
        
        //System.out.println(capitalCities.get("India"));
    }
}

