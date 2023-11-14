package EjParking;

public class NoPlazasLibresException extends Exception{
    public NoPlazasLibresException(){
        super("El parking está lleno, no hay ninguna plaza libre.");
    }
}
