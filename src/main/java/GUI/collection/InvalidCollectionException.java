package GUI.collection;

public class InvalidCollectionException extends Throwable {
    public InvalidCollectionException() {
        this.printStackTrace();
    }

    public InvalidCollectionException(String message) {
        super(message);
        this.printStackTrace();
    }
}
