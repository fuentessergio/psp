package PrimeraEvaluacion.ProgramacionMultihilo;

import java.util.ArrayList;
import java.util.List;

public class EstadosHilo implements Runnable{
    private List<String> estados;

    public EstadosHilo() {
        this.estados = new ArrayList<>();
    }
    public synchronized void agregarEstado(Thread.State state){
        estados.add(state.toString());
    }

    @Override
    public void run() {
        try {
            // Estado 1
            agregarEstado(Thread.State.NEW);
            System.out.println("Estado 1: Iniciando el hilo");
            Thread.sleep(1000); // Simulando alguna operación

            // Estado 2
            agregarEstado(Thread.State.RUNNABLE);
            System.out.println("Estado 2: Realizando alguna tarea");
            Thread.sleep(2000); // Simulando alguna operación

            // Estado 3
            agregarEstado(Thread.State.TERMINATED);
            System.out.println("Estado 3: Finalizando el hilo");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<String> getEstados() {
        return estados;
    }
}

