package EjParking;

public class Plaza {
    int numero;
    boolean libre = true;

    public Plaza(int numero) {
        this.numero = numero;
        libre = true;
    }


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean liberar() {
        return libre;
    }

    public boolean ocupar() {
        return libre = false;
    }

}
