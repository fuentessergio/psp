package PrimeraEvaluacion.ActividadesTema2;

public class Actividad2_2 implements Runnable{
    /**
     * Transforma el Ejercicio 1 usando la interfaz Runnable para declarar el hilo. Después realiza el
     * programa Java que pide el enunciado del ejercicio.
     */
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Actividad2_2 hilo = new Actividad2_2();
            new Thread(hilo).start();
        }
    }

    @Override
    public void run() {
        System.out.println("Identificador de hilo " + Thread.currentThread().getId() + " " + "Hola Mundo");
    }


}
