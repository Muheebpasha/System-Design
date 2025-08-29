package Editor;

public class UnderlineCommand implements Command {
    private Document document;

    public UnderlineCommand(Document document) {
        this.document = document;
    }
    
    public void execute() {
        document.underlineText();
    }

    public void undo() {
        document.removeUnderlineText();
    }
}
