package PrimeraEvaluacion.ActividadesTema2;

public class EjercicioAmpliacionCuatroHilos extends Thread{

    private String nombre;
    private int contador;
    private int tiempo;

    public EjercicioAmpliacionCuatroHilos(String nombre, int contador,int tiempo){
        this.nombre = nombre;
        this.contador = contador;
        this.tiempo = tiempo;
    }

    @Override
    public void run() {
        for (int i = 0; i <= contador; i++) {
            System.out.println(nombre + " " + i);
            try {
                Thread.sleep(tiempo);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
