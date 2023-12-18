package PrimeraEvaluacion.EjRelevos;

public class Corredor extends Thread{
	
	private static final int MAX_DELAY=1000;
	private int id;
	private Testigo testigo;
	
	Corredor (int id, Testigo t){
		this.id=id;
		this.testigo=t;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			testigo.check(id);
		
			System.out.println("Soy el thread "+id+" corriendo...");
		
			Thread.sleep((int)Math.random()*MAX_DELAY);
		
			if (id!=4) {
				int receptor=id+1;
				System.out.println("Termin�. Paso el testigo al hilo "+receptor);
				testigo.next(receptor);
			} else {
				System.out.println("Termin�!!!");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
