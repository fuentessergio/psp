package ActividadesTema2;

/**
 * Crea un programa que lance 2 hilos y se espere a que terminen, utiliza join()
 * para esperar a los dos hilos.
 *  El primer hilo debe sumar los 2000000000 primeros números.
 * Visualizará el resultado.
 *  El segundo hilo debe restar los 2000000000 primeros números.
 * Visualizará el resultado.
 * Indicará que han terminado los 2 hilos y cuánto tiempo han tardado.
 */

public class EjercicioAmpliacionMain {

    public static void main(String[] args) {
        Thread hilo1 = new EjercicioAmpliacionSuma();
        Thread hilo2 = new EjercicioAmpliacionResta();


        long inicio = System.currentTimeMillis(); //guardar el tiempo de inicio
        hilo1.start();
        hilo2.start();

        /*try{
            hilo1.join(); // sirve para qu eel hilo que hace la llamada espere la finalizacion de otros
            hilo2.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }*/
        //Para ejercicio ampliacion 3
        while(hilo1.isAlive() || hilo2.isAlive()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
        long fin = System.currentTimeMillis(); // para ver el tiempo que han tardado


        System.out.println("Los 2 hilos han terminado");
        System.out.println("Tiempo total: " + (fin-inicio));

    }
}
