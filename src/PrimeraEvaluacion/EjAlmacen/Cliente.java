package PrimeraEvaluacion.EjAlmacen;

import java.util.concurrent.ThreadLocalRandom;

public class Cliente implements Runnable{

    private int id;
    private Puerta puerta;

    public Cliente(int id, Puerta puerta) {
        this.id = id;
        this.puerta = puerta;

    }

    @Override
    public void run() {
        for (int intento = 1; intento <= 10; intento++) {
            System.out.println("Cliente " + id + " intento #" + intento);
            if (puerta.intentarEntrar()) {
                if (Almacen.cogerProducto()) {
                    System.out.println("Cliente " + id + " ha entrado al almacén y ha tomado un producto.");
                    // Simulación de tiempo dentro del almacén
                    try {
                        Thread.sleep(ThreadLocalRandom.current().nextInt(100, 1000));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    puerta.liberarPuerta();
                    System.out.println("Cliente " + id + " ha salido del almacén.");
                    return; // Terminar el hilo después de entrar y salir
                } else {
                    System.out.println("Cliente " + id + " no hay productos disponibles.");
                    puerta.liberarPuerta(); // Liberar la puerta si no hay productos
                }
            } else {
                System.out.println("Cliente " + id + " no ha podido entrar al almacén. Esperando un momento.");
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(100, 1000));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        System.out.println("Cliente " + id + " se ha marchado sin conseguir el producto.");
    }

}
