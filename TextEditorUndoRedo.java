
import java.util.Stack;

public class TextEditorUndoRedo {
    private StringBuilder text;
    private Stack<String> undoStack;
    private Stack<String> redoStack;

    public TextEditorUndoRedo() {
        text = new StringBuilder();
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public void addText(String newText) {
        undoStack.push(text.toString());
        text.append(newText);
        redoStack.clear();
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(text.toString());
            text = new StringBuilder(undoStack.pop());
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(text.toString());
            text = new StringBuilder(redoStack.pop());
        }
    }

    public String getText() {
        return text.toString();
    }

    public static void main(String[] args) {
        TextEditorUndoRedo editor = new TextEditorUndoRedo();
        editor.addText("Hello");
        System.out.println("Text: " + editor.getText());
        editor.addText(" From Team Four");
        System.out.println("Text: " + editor.getText());
        editor.undo();
        System.out.println("Text setelah undo: " + editor.getText());
        editor.redo();
        System.out.println("Text setelah redo: " + editor.getText());
    }
}
