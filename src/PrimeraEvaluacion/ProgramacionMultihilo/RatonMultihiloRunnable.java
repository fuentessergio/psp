package PrimeraEvaluacion.ProgramacionMultihilo;

public class RatonMultihiloRunnable implements Runnable {

    private String nombre;
    private int tiempoAlimentacion;


    public RatonMultihiloRunnable(String nombre, int tiempoAlimentacion) {
        super();
        this.nombre = nombre;
        this.tiempoAlimentacion = tiempoAlimentacion;
    }

    public void comer() {

        try {

            System.out.println("El ratón " + nombre + " ha comenzado a alimentarse");
            Thread.sleep(tiempoAlimentacion * 1000);
            System.out.println("El ratón " + nombre + " ha terminado de alimentarse");

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        Thread.State estado = Thread.currentThread().getState();
        System.out.println("Estado del hilo " + nombre +  " al inicio: " + estado);

        for (int i = 0; i < 3; i++) {
            comer();
        }

    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub

        RatonMultihiloRunnable fievel = new RatonMultihiloRunnable("Fievel", 4);
        /*RatonMultihiloRunnable jerry = new RatonMultihiloRunnable("Jerry", 5);
        RatonMultihiloRunnable pinky = new RatonMultihiloRunnable("Pinky", 3);
        RatonMultihiloRunnable mickey = new RatonMultihiloRunnable("Mickey", 6);*/

        Thread hilo = new Thread(fievel);
        Thread.State estado = hilo.getState();
        System.out.println("Estado del hilo " + fievel.nombre + " antes de iniciar: " + estado);

        hilo.start();

        try {
            hilo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        estado = hilo.getState();
        System.out.println("Estado del hilo " + fievel.nombre + " después de finalizar: " + estado);

    }
}