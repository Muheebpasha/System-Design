package Editor;

public class BoldCommand implements Command {
    private Document document;

    public BoldCommand(Document document) {
        this.document = document;
    }

    @Override
    public void execute() {
        document.boldText();
    }

    @Override
    public void undo() {
        document.unboldText();
    }

}
