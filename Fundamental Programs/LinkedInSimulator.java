import java.util.LinkedList;
import java.util.Scanner;

class LinkedInSimulator {

    static LinkedList<String> notifications = new LinkedList<>();
    static LinkedList<String> connections = new LinkedList<>();
    static LinkedList<String> jobApplications = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (true) {
            System.out.println("\n=== LinkedIn Console ===");
            System.out.println("1. View Notifications");
            System.out.println("2. Add Connection");
            System.out.println("3. View Connections");
            System.out.println("4. Apply for Job");
            System.out.println("5. View Job Applications");
            System.out.println("6. Clear All Notifications");
            System.out.println("7. Exit");
            System.out.print("Choose an option (1–7): ");

            if (!scanner.hasNextLine()) {
                System.out.println("⚠️ No input received. Exiting safely.");
                break;
            }

            String input = scanner.nextLine().trim();
            if (input.matches("\\d+")) {
                choice = Integer.parseInt(input);
            } else {
                System.out.println("❌ Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1 -> viewNotifications();
                case 2 -> addConnection(scanner);
                case 3 -> viewConnections();
                case 4 -> applyForJob(scanner);
                case 5 -> viewJobApplications();
                case 6 -> clearNotifications();
                case 7 -> {
                    System.out.println("👋 Exiting. Thanks for visiting LinkedIn!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("❌ Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static void viewNotifications() {
        if (notifications.isEmpty()) {
            System.out.println("📭 No notifications.");
        } else {
            System.out.println("🔔 Notifications:");
            notifications.forEach(n -> System.out.println("- " + n));
        }
    }

    private static void addConnection(Scanner scanner) {
        System.out.print("Enter name to connect with: ");
        if (!scanner.hasNextLine()) {
            System.out.println("❌ No input received. Returning to menu.");
            return;
        }
        String name = scanner.nextLine().trim();
        connections.add(name);
        notifications.addFirst("🎉 You connected with " + name);
        System.out.println("✅ Connection request sent to " + name);
    }

    private static void viewConnections() {
        if (connections.isEmpty()) {
            System.out.println("👤 No connections yet.");
        } else {
            System.out.println("👥 Your Connections:");
            for (String conn : connections) {
                System.out.println("- " + conn);
            }
        }
    }

    private static void applyForJob(Scanner scanner) {
        System.out.print("Enter job title to apply: ");
        if (!scanner.hasNextLine()) {
            System.out.println("❌ No input received. Returning to menu.");
            return;
        }
        String job = scanner.nextLine().trim();
        jobApplications.add(job);
        notifications.addFirst("📝 You applied for: " + job);
        System.out.println("✅ Applied for " + job);
    }

    private static void viewJobApplications() {
        if (jobApplications.isEmpty()) {
            System.out.println("💼 No job applications yet.");
        } else {
            System.out.println("📋 Your Job Applications:");
            jobApplications.forEach(j -> System.out.println("- " + j));
        }
    }

    private static void clearNotifications() {
        notifications.clear();
        System.out.println("🧹 Notifications cleared.");
    }
}

