package EjParking;

public class Parking {
    private Plaza [] plazas;
    private int totalPlazas;


    public Parking(int totalPlazas, int cochesExisten){ // te pide el ejercicio que lo recibas
        this.totalPlazas = totalPlazas;
        this.plazas = new Plaza[totalPlazas];
        for (int i = 0; i < totalPlazas; i++) {
            // recorremos el for para inicializar plazas con un id unico
            plazas[i] = new Plaza(i);
        }
        for (int i = 0; i < cochesExisten; i++) {
            // recorremos un for para crear un hilo por cada coche con un id unico y el mismo parking
            Thread coches = new Thread(new Coche(i, this));
            coches.start();
        }
    }
    public synchronized Plaza entrar(int idCoche) throws InterruptedException {
        while(plazasOcupadas() == totalPlazas){
            wait(); // no hay plaza disponible, los coches tienen que esperar para entrar
        }
        Plaza plazaAOcupar = plazaLibre();
        if (plazaAOcupar != null) { // este if por si las moscas diera null en algún caso
            plazaAOcupar.ocupar();
        }
        System.out.println("El coche " + idCoche + " ha entrado al parking. Plaza ocupada " + plazaAOcupar.getNumero());
        return plazaAOcupar;
    }

    public synchronized void salir(int idCoche, Plaza plaza){
        plaza.liberar();
        System.out.println("El coche " + idCoche + " ha salido del parking. Plaza libre " + plaza.getNumero());
        notifyAll();
    }



    private int plazasOcupadas(){
        int contador = 0;
        for(Plaza plaza : plazas){
            if(!plaza.libre){
                contador++;
            }
        }
        return contador;
    }

    private Plaza plazaLibre(){
        for (Plaza plaza : plazas){
            if(plaza.libre){
                return plaza;
            }
        }
        return null; // Esto no ocurre porque verifico que haya plaza libre
    }

}
