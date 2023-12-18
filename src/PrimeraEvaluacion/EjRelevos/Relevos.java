package PrimeraEvaluacion.EjRelevos;

public class Relevos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Testigo testigo = new Testigo();
		
		Corredor[] corredores =new Corredor[4];
		for (int i = 0; i < 4; i++) {
			corredores[i]=new Corredor(i+1,testigo);
			corredores[i].start();
		}
		
		System.out.println("Todos los hilos creados.");
		
		testigo.next(1);
		System.out.println("Doy la salida");
		
		try {
		
			for (int i = 0; i < 4; i++) {
			
				corredores[i].join();
			}
		} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Hilo principal interrrumpido.");
		}
		System.out.println("Todos los hilos terminaron.");
	}

}


