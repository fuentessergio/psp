package PrimeraEvaluacion.EjFilosofosRicardo;



public class CenaFilosofos {
	
	public static MesaCircular mesa;
	
	public static void main(String[] args) throws InterruptedException{
		
		int filosofos= 4; // lo corre por consola
		mesa=new MesaCircular(filosofos);
		System.out.println("Sentados "+filosofos+" filósofos");
		
		for (int i = 0; i < filosofos; i++) {
			Filosofo f=new Filosofo(i);
			f.start();
			
		}
	}

}