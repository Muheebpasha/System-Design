public class Main {
   public static void main(String[] args) {
        Developer dev1 = new Developer("Mohammed Hanzalah", "Frontend Developer");
        Developer dev2 = new Developer("Mohammed Arham", "Backend Developer");

        Manager manager1 = new Manager("Mohammed Maaz", "Development Manager");
        manager1.add(dev1);
        manager1.add(dev2);

        Manager generalManager = new Manager("Muheeb Pasha", "General Manager");
        generalManager.add(manager1);

        // Convert to nested list/map structure
        Object orgTree = generalManager.toNode();

        // Print structure (uses toString, could use a JSON library later)
        System.out.println(orgTree);
    }
}

