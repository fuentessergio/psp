package PrimeraEvaluacion.EjGlobos;

import java.util.Random;

public class Pinchador extends Thread{
    private Mesa mesa;

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Pinchador(Mesa mesa){
        this.mesa = mesa;
    }

    public synchronized Globo quitarGlobo(){
        while(mesa.globosList.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Globo globo = mesa.globosList.remove(0);
        System.out.println("El pinchador " + Thread.currentThread().getName() + " ha pinchado un globo de la mesa " + globo.getColor());
        notifyAll();
        return globo;
    }

    @Override
    public void run() {
        while(true){
            quitarGlobo();
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
