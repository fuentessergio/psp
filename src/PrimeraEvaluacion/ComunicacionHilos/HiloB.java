package PrimeraEvaluacion.ComunicacionHilos;

class HiloB extends Thread {
    private Contador contador;
    
    public HiloB(String n, Contador c) {
        setName(n);
	    contador = c;
    }
	
    public synchronized void  run() {
        synchronized (contador) {
            for (int j = 0; j < 300; j++) {
                contador.decrementa();
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                }
            }
            System.out.println(getName() + " contador vale " + contador.getValor());
        }
    }
}// FIN HILOB
