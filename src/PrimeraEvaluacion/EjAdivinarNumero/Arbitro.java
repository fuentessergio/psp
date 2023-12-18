package PrimeraEvaluacion.EjAdivinarNumero;

import java.util.Random;

public class Arbitro {
    private int totalJugadores;
    private int turno;
    private int numeroAdivinar;
    private boolean fin;

    public Arbitro(int totalJugadores){
        this.totalJugadores = totalJugadores;
        this.turno = 1;
        this.numeroAdivinar = new Random().nextInt(10)+1; //numero entre 1 y 10
        fin = false;
    }
    public int getTurno(){
        return  turno;
    }

    public synchronized boolean isFin() {
        return fin;
    }
    public synchronized void realizarJugada(int idJugador, int numero){
        while (turno != idJugador || fin) {
            try {
                // Esperar hasta que sea el turno del jugador actual
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
            if(numero == numeroAdivinar){
                fin = true;
                System.out.println("¡Jugador " + idJugador + " ha ganado con el numero: " + numero + "!");
            }else {
                System.out.println("Jugador " + idJugador + " ha jugado el numero: " + numero);
                turno = (turno % totalJugadores)+1;
            }
        notifyAll();
    }
}

