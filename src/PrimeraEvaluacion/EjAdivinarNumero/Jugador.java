package PrimeraEvaluacion.EjAdivinarNumero;

import java.util.Random;

public class Jugador extends Thread {
    private int idJugador;
    private Arbitro arbitro;

    public Jugador (int idJugador, Arbitro arbitro){
        this.idJugador = idJugador;
        this.arbitro = arbitro;
    }

    @Override
    public void run() {
        while (!arbitro.isFin()){ // hasta que no termine
            synchronized (arbitro){ // para evitar problemas de concurrencia

                //comprobar el turno del jugador y que no haya terminado el juego
                if(arbitro.getTurno() == idJugador && !arbitro.isFin()) {
                    //generar numero aleatorio
                    int num = new Random().nextInt(10) + 1;
                    arbitro.realizarJugada(idJugador, num);
                    arbitro.notifyAll(); // al estar dentro de synchronized puede llamar a notifyAll
                    } else {
                    try{ // si no es el turno del jugador el juego ha terminado se mantiene en espera
                        arbitro.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                }
            }
        }
    }

