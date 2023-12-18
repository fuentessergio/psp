package PrimeraEvaluacion.EjGlobos;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws NoMasGloboException {
        Mesa mesa = new Mesa(10);

        List<Hinchador> hinchadorList = new ArrayList<>();
        List<Pinchador> pinchadorList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Hinchador hinchador = new Hinchador(mesa);
            hinchadorList.add(hinchador);
            hinchador.start();
        }

        for (int i = 0; i < 2; i++) {
            Pinchador pinchador = new Pinchador(mesa);
            pinchadorList.add(pinchador);
            pinchador.start();
        }
    }
}
