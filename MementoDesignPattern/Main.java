public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();

        editor.write("First version");
        editor.write("Second version");
        editor.write("Third version");

        editor.printText(); // Third version

        editor.undo();
        editor.printText(); // Second version

        editor.undo();
        editor.printText(); // First version

        editor.undo();
        editor.printText(); // Nothing left to undo
    }
}
