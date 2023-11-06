package EjFilosofos;

public class Filosofo  extends Thread{

    private String nombre;

    public Filosofo(String nombre){
        this.nombre = nombre;
    }

    public synchronized void pensando(){
        System.out.println("Filosofo " + nombre + " esta pensando");
    }

}
