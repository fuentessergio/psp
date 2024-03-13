package PrimeraEvaluacion.ActividadesTema2;

public class Actividad2_1Runnable implements Runnable{
    private String nombre;
    public Actividad2_1Runnable(String nombre){
        this.nombre = nombre;
    }
    @Override
    public void run() {
        while(true){
            System.out.println(this.nombre);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Actividad2_1Runnable actividad2_1Runnable = new Actividad2_1Runnable("TIC");
        Actividad2_1Runnable actividad2_1Runnable1 = new Actividad2_1Runnable("TAC");

        new Thread(actividad2_1Runnable).start();
        new Thread(actividad2_1Runnable1).start();

    }
}
