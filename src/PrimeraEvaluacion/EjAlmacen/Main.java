package PrimeraEvaluacion.EjAlmacen;

public class Main {
    private final static int MAX_CLIENTES = 10;
    public static void main(String[] args) {
        Puerta puerta = new Puerta();
        for(int i = 0; i < MAX_CLIENTES; i++) {
            Thread threadCliente = new Thread(new Cliente(i, puerta));
            threadCliente.start();
        }
    }
}
