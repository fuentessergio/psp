package EjGlobos;

import java.awt.*;
import java.util.Random;

public class Hinchador extends Thread{
    private Mesa mesa;

    public Hinchador (Mesa mesa){
        this.mesa = mesa;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public synchronized void agregarGlobo(Globo globo){
        while(mesa.globosList.size() == mesa.capacidad){
            try{
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        mesa.globosList.add(globo);
        System.out.println("Hinchador " + Thread.currentThread().getName() + " en la mesa de globos " + globo.getColor());
        notifyAll();
    }

    @Override
    public void run() {
        Random random = new Random();
        while(true){
            Globo.Color color = Globo.Color.values()[random.nextInt(Globo.Color.values().length)];
            Globo globo = new Globo(color);
            agregarGlobo(globo);
            descansar();
        }
    }

    public void descansar(){
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(1000)+1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
