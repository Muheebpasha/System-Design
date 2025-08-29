package Editor;

// Receiver class
public class Document {
    public void boldText() {
        System.out.println("Text is now Bold.");
    }
    
    public void unboldText() {
        System.out.println("Text is no longer Bold.");
    }

    public void italicText() {
        System.out.println("Text is now Italic.");
    }

    public void unitalicText() {
        System.out.println("Text is no longer Italic.");
    }

    public void underlineText() {
        System.out.println("Text is now Underline.");
    }

    public void removeUnderlineText() {
        System.out.println("Underline Removed.");
    }
}