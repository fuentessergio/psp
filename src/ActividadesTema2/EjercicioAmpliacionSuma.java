package ActividadesTema2;

public class EjercicioAmpliacionSuma extends Thread{
    @Override
    public void run() {
        long suma = 0;
        for (long i = 0; i < 2000000; i++) {
            suma += i;
        }
        System.out.println("La suma es: " + suma);
        System.out.println("Soy HiloSuma y he terminado");
    }

}
