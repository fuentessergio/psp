package PrimeraEvaluacion.EjParking;

public class Plaza {
    int numero;
    boolean libre;

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
        libre = true;
        return libre;
    }

    public boolean ocupar() {
        libre = false;
        return libre;
    }

}
