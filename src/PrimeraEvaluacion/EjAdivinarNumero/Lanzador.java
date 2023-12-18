package PrimeraEvaluacion.EjAdivinarNumero;

public class Lanzador {
    public static void main(String[] args) {
        int numJugadores = 3;
        Arbitro arbitro = new Arbitro(numJugadores);
        for (int i = 0; i <= numJugadores; i++) {
            Jugador jugador = new Jugador(i,arbitro);
            jugador.start();
        }
    }


}
