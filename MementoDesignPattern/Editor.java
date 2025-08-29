import java.util.Deque;
import java.util.LinkedList;

public class Editor {
    private Deque<TextArea.Memento> stateHistory;
    private TextArea textArea;

    public Editor() {
        stateHistory = new LinkedList<>();
        textArea = new TextArea();
    }

    public void write(String text) {
        // Save current state before making changes
        stateHistory.push(textArea.takeSnapshot());
        textArea.set(text);
    }

    public void undo() {
        if (!stateHistory.isEmpty()) {
            textArea.restore(stateHistory.pop());
        } else {
            System.out.println("Nothing to undo!");
        }
    }

    public void printText() {
        System.out.println("Current Text: " + textArea.getText());
    }
}
