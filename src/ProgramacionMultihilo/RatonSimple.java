package ProgramacionMultihilo;


public class RatonSimple implements Runnable {

        private String nombre;
        private int tiempoAlimentacion;
        private int alimentoConsumido;



        public RatonSimple(String nombre, int tiempoAlimentacion) {
            super();
            this.nombre = nombre;
            this.tiempoAlimentacion = tiempoAlimentacion;
        }

        public void comer() {

            try {

                System.out.println("El ratón "+ nombre +" ha comenzado a alimentarse");
                Thread.sleep(tiempoAlimentacion*1000);
                alimentoConsumido++;
                System.out.println("El ratón "+nombre+" ha terminado de alimentarse");
                System.out.println("Alimento consumido:"+alimentoConsumido);

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        @Override
        public void run() {
            this.comer();
        }


	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

		RatonSimple fievel=new RatonSimple("Fievel",4);
		new Thread(fievel).start();
		new Thread(fievel).start();
		new Thread(fievel).start(); // los hilos se jecutan simultaneamente, problemas de concurrencia
	}*/

        //main para varios Threads

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

		RatonSimple fievel=new RatonSimple("Fievel",4);
		for (int i=0;i<1000;i++){
			new Thread(fievel).start(); // valor por debajo de las iteraciones, error de concurrencia
            // cuanto mas hilos mayor problema de concurrencia tendrá
		}
	}*/
    public static void main(String[] args) { // 2,4,10, 100 y 1000
        int numHilos = 1000;
        RatonSimple fievel = new RatonSimple("Fievel", 4);
        for (int i = 0; i < numHilos; i++) {
            new Thread(fievel).start();
        }
    }
    /**
     * En general, cuanto más hilos tengas, más evidentes serán los problemas de concurrencia y menos confiable
     * será la ejecución del proceso. La confiabilidad de un proceso programado de esta manera depende
     * en gran medida de cómo se maneje la concurrencia mediante la sincronización y la gestión de hilos.
     * Para hacer que el proceso sea más confiable, puedes utilizar técnicas de sincronización como locks o semáforos
     * para garantizar que los hilos accedan a las variables compartidas de manera segura.
     */
}
