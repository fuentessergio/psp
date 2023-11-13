package EjFilosofos;

public class Palillos{
    private boolean estaLibre=true;

    public synchronized void cogerPalillo () throws InterruptedException {
        while(!estaLibre){
            wait();
        }
        estaLibre = false;
    }

    public synchronized void dejarPalillo () throws InterruptedException{
        estaLibre=true;
        notifyAll();
        }
    }

