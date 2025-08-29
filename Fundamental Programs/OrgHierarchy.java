import java.util.*;

class Employee {
    String name;
    List<Employee> teammates;

    Employee(String name) {
        this.name = name;
        this.teammates = new ArrayList<>();
    }

    void addTeammate(Employee e) {
        teammates.add(e);
    }

    void printHierarchy(String indent) {
        System.out.println(indent + name);
        for (Employee e : teammates) {
            e.printHierarchy(indent + "--");
        }
    }
}

public class OrgHierarchy {
    public static void main(String[] args) {
        Employee ceo = new Employee("CEO - Alice");
        Employee manager1 = new Employee("Manager - Bob");
        Employee manager2 = new Employee("Manager - Carol");
        Employee dev1 = new Employee("Developer - John");
        Employee dev2 = new Employee("Developer - Emma");

        ceo.addTeammate(manager1);
        ceo.addTeammate(manager2);
        manager1.addTeammate(dev1);
        manager2.addTeammate(dev2);

        System.out.println("Organization Hierarchy:");
        ceo.printHierarchy("");
    }
}

