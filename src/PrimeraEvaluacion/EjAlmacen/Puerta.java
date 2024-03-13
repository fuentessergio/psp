package PrimeraEvaluacion.EjAlmacen;

public class Puerta {
    private boolean libre = true;

    public synchronized boolean intentarEntrar(){
        if(libre){
            libre = false;
            return true;
        } else {
            return false;
        }
    }
    public synchronized void liberarPuerta(){
        libre =true;
    }
}
