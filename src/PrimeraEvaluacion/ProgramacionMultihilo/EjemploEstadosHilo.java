package PrimeraEvaluacion.ProgramacionMultihilo;

import java.util.List;

public class EjemploEstadosHilo {
    public static void main(String[] args) {
        EstadosHilo miHilo = new EstadosHilo();
        Thread thread = new Thread(miHilo);


        System.out.println("Estado antes de iniciar el hilo: " + thread.getState());
        thread.start(); // Inicia el hilo

        while(thread.isAlive()){
            System.out.println("Estado durante la ejecucion: " + thread.getState());
        }
        System.out.println("Estado después de que el hilo ha terminado: " + thread.getState());

        // Muestra los estados por los que pasó el hilo
        List<String> estados = miHilo.getEstados();
        System.out.println("\nEstados del hilo:");
        for (String estado : estados) {
            System.out.println(estado);
        }
    }
}

