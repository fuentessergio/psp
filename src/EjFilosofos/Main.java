package EjFilosofos;

public class Main {
    public static void main(String[] args) {
        int numFilosofos = 5;
        Palillos [] palillos = new Palillos[numFilosofos];
        Filosofo [] filosofos = new Filosofo[numFilosofos];

        for (int i = 0; i < numFilosofos; i++) {
            palillos[i] = new Palillos();
        }

        for (int i = 0; i < numFilosofos; i++) {
            filosofos[i] = new Filosofo(palillos[i], palillos[(i+1) % numFilosofos]);
            filosofos[i].setNombre(i);
            filosofos[i].start();// palillos[i] palilloIzq y palillos[...] palilloDcha
        }
        try{
            Thread.sleep(1000); // que dure 10 seg
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
