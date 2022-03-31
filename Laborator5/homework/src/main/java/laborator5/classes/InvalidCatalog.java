package laborator5.classes;

public class InvalidCatalog extends Exception {
    public InvalidCatalog(Exception exception) {
        super("Invalid catalog file.", exception);
    }
}
