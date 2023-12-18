package PrimeraEvaluacion.ActividadesTema2;

public class Ejercicio2 implements Runnable{

    private String mensaje;
    /**
     * Ejercicio 2
     * Crea una clase que implemente la interfaz Runnable cuya única funcionalidad sea visualizar el
     * mensaje “Hola mundo” seguido de una cadena que se recibirá en el constructor (es decir, al
     * crear un objeto de este tipo se enviará una cadena) y seguido del identificador del hilo. Crea un
     * programa Java que visualice el mensaje anterior 5 veces creando para ello 5 hilos diferentes
     * usando la clase creada anteriormente. Luego haz que antes de visualizar el mensaje el hilo
     * espere un tiempo proporcional a su identificador.
     * ¿qué diferencias observas al ejecutar el programa haciendo o no que el hilo espere antes de
     * visualizar el mensaje?
     */

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Ejercicio2 hilo = new Ejercicio2("Hola mundo: ");
            new Thread(hilo).start();
        }
    }

    public Ejercicio2(String mensaje){
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(Thread.currentThread().getId()*1000);
            for (int i = 0; i < 5; i++) {
                System.out.println(mensaje + Thread.currentThread().getId());
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
