import java.util.LinkedList;

class LinkedInNotificationApp {

    public static void main(String[] args) {

        // Create a LinkedList to store notifications
        LinkedList<String> notifications = new LinkedList<>();

        // Add notifications
        notifications.add("You have a new connection request from Shahid.");
        notifications.add("New job recommendation: Java Developer at Infosys.");
        notifications.addLast("Reminder: Complete your LinkedIn Skill Assessment.");
        notifications.addFirst("Your post reached 1,000 views!");

        // Print all notifications
        System.out.println("🔔 All Notifications:");
        for (String note : notifications) {
            System.out.println("- " + note);
        }

        // Peek at the first notification (without removing)
        System.out.println("\n👀 Peek first notification:");
        System.out.println(notifications.peek());

        // Poll the first notification (view and remove)
        System.out.println("\n🗑️ Poll (remove) first notification:");
        String removed = notifications.poll();
        System.out.println("Removed: " + removed);

        // Replace a notification
        notifications.set(1, "Updated job match: Senior Java Developer at TCS.");
        System.out.println("\n🛠️ Updated a job suggestion:");

        // Check if a specific notification exists
        System.out.println("\n🔍 Checking for a skill reminder:");
        boolean hasSkillReminder = notifications.contains("Reminder: Complete your LinkedIn Skill Assessment.");
        System.out.println("Contains skill reminder? " + hasSkillReminder);

        // Final list
        System.out.println("\n📋 Final Notifications:");
        notifications.forEach(n -> System.out.println("- " + n));

        // Clear all
        System.out.println("\n🧹 Clearing all notifications...");
        notifications.clear();

        System.out.println("Empty? " + notifications.isEmpty());
    }
}

