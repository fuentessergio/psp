package PrimeraEvaluacion.ActividadesTema2;

/**
 * Crea un programa que lance 2 hilos. Cada hilo tendrá como parámetros:
 *  Su nombre
 *  El número de veces que tiene que mostrar un mensaje
 *  Cada cuántos milisegundos tiene que mostrar el mensaje
 * El mensaje esperará a que termine sólo uno de los hilos, y en cuanto este
 * haya terminado mostrará un mensaje indicando que también termina.
 */
public class EjercicioAmpliacionCuatro{
    public static void main(String[] args) {
        Thread hilo1 = new EjercicioAmpliacionCuatroHilos("HiloSergio", 2,1000);
        Thread hilo2 = new EjercicioAmpliacionCuatroHilos("HiloJorge", 3,2000);

        hilo1.start();
        hilo2.start();

        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("El programa principal ha terminado");
    }

}
