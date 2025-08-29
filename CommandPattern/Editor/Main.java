package Editor;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Document document = new Document();
        EditorInvoker editor = new EditorInvoker();
        // Pre-created command instances (you could improve this later)
        Map<String, Command> commandMap = new HashMap<>();
        commandMap.put("bold", new BoldCommand(document));
        commandMap.put("italic", new ItalicCommand(document));
        commandMap.put("underline", new UnderlineCommand(document));
        
        System.out.println("Welcome to the Text Editor!");
        System.out.println("Available commands: bold, italic, underline, undo, exit");

        while (true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("exit")) {
                System.out.println("Exiting editor...");
                break;
            } else if (input.equals("undo")) {
                editor.undoLast();
            } else if (commandMap.containsKey(input)) {
                editor.executeCommand(commandMap.get(input));
            } else {
                System.out.println("Unknown command. Try again.");
            }
        }
        scanner.close();

    }
}
