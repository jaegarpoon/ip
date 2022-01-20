public class EmptyDescriptionException extends RonException {
    public static final String message = "Please add a description for ";
    public static final String message2 = " task.";

    public String type;

    EmptyDescriptionException(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + message + type + message2;
    }
}
