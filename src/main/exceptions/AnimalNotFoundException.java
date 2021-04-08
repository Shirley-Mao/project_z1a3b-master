package exceptions;

public class AnimalNotFoundException extends Exception {
    public AnimalNotFoundException(String msg) {
        super(msg);
    }
}
