package Editor;

import java.util.Stack;

public class EditorInvoker {
    private Stack<Command> history = new Stack<>();

    public void executeCommand(Command command){
        command.execute();
        history.push(command);
    }
    
    public void undoLast() {
        if(!history.empty()) {
            history.pop().undo();
        }
    }
}
