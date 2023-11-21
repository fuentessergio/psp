package EjGlobos;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
    List<Globo> globosList;
    int capacidad;

    public List<Globo> getGlobosList() {
        return globosList;
    }

    public void setGlobosList(List<Globo> globosList) {
        this.globosList = globosList;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) throws NoMasGloboException {
        if(capacidad > 10){
            throw new NoMasGloboException();
        } else this.capacidad = capacidad;
    }

    public Mesa(int capacidad) throws NoMasGloboException {
        this.globosList = new ArrayList<>();
        setCapacidad(capacidad);
    }
}
