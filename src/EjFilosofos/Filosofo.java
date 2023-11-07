package EjFilosofos;

public class Filosofo  extends Thread{
    private int nombre;
    private Palillos izquierdo;
    private Palillos derecho;

    public Filosofo(Palillos izquierdo, Palillos derecho){
        this.izquierdo=izquierdo;
        this.derecho = derecho;
    }
    public void setNombre(int n) {
        this.nombre = n;
    }

    @Override
    public void run() {
        while (true){
            try{
                pensando();
                System.out.println("Filosofo " + nombre + " quiere comer ");
                izquierdo.cogerPalillo();
                derecho.cogerPalillo();
                comiendo();
                izquierdo.dejarPalillo();
                derecho.dejarPalillo();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public synchronized void pensando(){
        try {
            System.out.println("Filosofo "+ nombre + " esta pensando");
            Thread.sleep( (long) (Math.random()*1000+2000));
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    public synchronized void comiendo (){
        try{
            System.out.println("Filosofo " + nombre + " esta comiendo");
            Thread.sleep( (long) (Math.random()*1000+2000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
