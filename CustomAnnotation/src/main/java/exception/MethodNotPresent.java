package exception;

public class MethodNotPresent extends RuntimeException {

    public MethodNotPresent() {
    }

    public MethodNotPresent(String message) {
        super(message);
    }

}