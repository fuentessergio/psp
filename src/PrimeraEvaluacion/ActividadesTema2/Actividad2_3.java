package PrimeraEvaluacion.ActividadesTema2;

/**
 * Partiendo del ejemplo HiloEjemploDead, desarrollar un hilo que pueda ser suspendido
 * temporalmente en el momento que nos convenga, es decir, que sólo cuando haya terminado
 * operaciones que creamos necesarias (que serán ficticias como en dicho ejemplo). También deberá
 * poder ser rearrancado. Para ello, basándonos en el ejemplo dado, nos hará falta alguna variable y
 * deberemos evitar utilizar métodos como suspend().
 */
public class Actividad2_3 extends Thread {
    private boolean parar = false;

    private int num1, resultado;

    public void pararHilo() {
        parar = true;
    }

    @Override
    public void run() {
        while (!parar) {
            System.out.println("Inicio del bucle del hilo y comienza la suma");
            try {
                for (int i = 0; i < 5; i++) {
                    resultado += num1;
                    System.out.println("Resultado parcial: " + resultado);
                }
                sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Fin del bucle del hilo y termina la suma");
        }
    }

    public static void main(String[] args) {
        Actividad2_3 h1 = new Actividad2_3();
        h1.num1 = 3;
        h1.start();
        try {

            Thread.sleep(3000);
            // si hacemos h1.join(); nunca termina la suma
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        h1.pararHilo();
        System.out.println("Resultado total: " + h1.resultado);
    }
}
