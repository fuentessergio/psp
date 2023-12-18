package PrimeraEvaluacion.ActividadesTema2;

/**
 * Crea dos clases (hilos) que extiendan la clase Thread. Uno de los hilos debe visualizar en pantalla
 * en un bucle infinito la palabra TIC y el otro hilo la palabra TAC. Dentro del bucle utiliza el método
 * sleep() para que nos de tiempo a ver las palabras que se visualizan cuando lo ejecutemos.
 * Tendrás que añadir un bloque try-catch (para capturar la excepción InterruptedException). Crea
 * después la función main() que haga uso de los hilos anteriores. ¿Se visualizan los textos TIC y
 * TAC de forma ordenada? No, hay en algún momento que el orden se pierde y sale TAC-TAC o TIC-TIC
 */

public class Actividad2_1 extends Thread{

    public Actividad2_1(String nombre){
        super(nombre);
        System.out.println(getName());
    }

    @Override
    public void run() {
        while(true){
            System.out.println(super.getName());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Actividad2_1 hilo = new Actividad2_1("TIC");
        Actividad2_1 hilo2 = new Actividad2_1("TAC");

        hilo.start();
        hilo2.start();
    }
}
