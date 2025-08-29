package Editor;

public class ItalicCommand implements Command {

    private Document document;

    public ItalicCommand(Document document) {
        this.document = document;
    }
    
    public void execute() {
        document.italicText();
    }

    public void undo() {
        document.unitalicText();
    }
}
