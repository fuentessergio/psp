package EjGlobos;

public class NoMasGloboException extends Exception {
    public NoMasGloboException(){
        super("No entran mas globos en la mesa");
    }
}
