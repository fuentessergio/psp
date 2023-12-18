package PrimeraEvaluacion.ActividadesTema2;

/**
 * Ejercicio 1
 * Crea una clase que extienda de Thread cuya única funcionalidad sea visualizar el mensaje “Hola
 * mundo”. Crea un programa Java que visualice el mensaje anterior 5 veces creando para ello 5
 * hilos diferentes usando la clase creada anteriormente. Modifica el mensaje “Hola mundo” en el
 * hilo para incluir el identificador del hilo. Prueba de nuevo el programa Java creado
 * anteriormente.
 */
public class Ejercicio1 extends Thread{
    public Ejercicio1(String nombre){
        super(nombre);
    }

    @Override
    public void run() {
        System.out.println("Identificador de hilo " + Thread.currentThread().getId() + " " + "Hola Mundo");
        }


    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Ejercicio1 hilo = new Ejercicio1("");
            hilo.start();
        }
    }
}
