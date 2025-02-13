package provas.exceptions;

public class RoupaJaExisteException extends RuntimeException {

    public RoupaJaExisteException (String message) {
        super(message);
    }
    public RoupaJaExisteException () {
        super("Roupa já cadastrada.");
    }
}
