package exception;

public class AnnotationNotPresent extends RuntimeException{

    public AnnotationNotPresent() {
    }

    public AnnotationNotPresent(String message) {
        super(message);
    }

}