package provas.exceptions;

public class RoupaInexistenteException extends Exception {

    public RoupaInexistenteException (String msg) {
        super(msg);
    }
    public RoupaInexistenteException () {
        super("Roupa não cadastrada no sistema.");
    }
}
