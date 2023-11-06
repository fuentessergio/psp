package EjFilosofos;

public class Cena extends Thread{
    private Filosofo filosofo;
    private String nombre;

    public Cena (Filosofo filosofo, String nombre){
        this.filosofo=filosofo;
        this.nombre= nombre;
    }

    @Override
    public void run() {
        super.run();
    }
}
