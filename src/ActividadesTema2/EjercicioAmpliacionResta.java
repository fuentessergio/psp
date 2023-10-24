package ActividadesTema2;

public class EjercicioAmpliacionResta extends Thread{
    @Override
    public void run() {
        long resta = 0;
        for (long i = 0; i < 20000000; i++) {
            resta -=i;
        }
        System.out.println("La resta es: " + resta);
        System.out.println("Soy HiloResta y he terminado");
    }
}
