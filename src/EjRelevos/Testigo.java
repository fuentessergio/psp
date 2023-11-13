package EjRelevos;

public class Testigo {
	
	private int siguiente;
	
	Testigo(){
		this.siguiente=0;
	}
	
	synchronized public void next(int id) {
		this.siguiente=id;
		/*Despierto a todos los threads ya que no sabe
		 * cu�l de ellos espec�ficamente recibe el notify*/
		notifyAll();
	}
	
	synchronized public void check(int id) throws InterruptedException {
		while (siguiente!=id) {
			//Me bloqueo hasta que sea mi turno
			wait();
		}
	}

}
