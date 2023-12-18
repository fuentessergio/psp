package PrimeraEvaluacion.EjParking;

public class Parking {
    private Plaza [] plazas;
    private int totalPlazas;

    private int plazasOcupadas;


    public Parking(int totalPlazas, int cochesExisten){
        this.totalPlazas = totalPlazas;
        this.plazas = new Plaza[totalPlazas];
        for (int i = 0; i < totalPlazas; i++) {
            // recorremos el for para inicializar plazas con un id unico
            plazas[i] = new Plaza(i);
        }
        this.plazasOcupadas = 0;

        for (int i = 0; i < cochesExisten; i++) {
            // recorremos un for para crear un hilo por cada coche con un id unico y el mismo parking
            Thread coches = new Thread(new Coche(i, this));
            coches.start();
        }
    }

    public synchronized boolean puedeEntrar(){
        return plazasOcupadas < totalPlazas;
    }
    public synchronized Plaza entrar(int idCoche) throws NoPlazasLibresException, InterruptedException {
        while(!puedeEntrar()){
            wait(); // no hay plaza disponible, los coches tienen que esperar para entrar
        }

        Plaza plazaAOcupar = plazaLibre();
        plazaAOcupar.ocupar();
        plazasOcupadas++;

        System.out.println("El coche: " + idCoche + " ha entrado al parking. Plaza ocupada " + plazaAOcupar.getNumero());
        return plazaAOcupar;
    }

    public synchronized void salir(int idCoche, Plaza plaza){
        plaza.liberar();
        plazasOcupadas--;

        System.out.println("El coche: " + idCoche + " ha salido del parking. Plaza libre " + plaza.getNumero());
        // cuando una plaza se libera notifica a todos los hilos que intentan entrar al parking
        notifyAll();
    }
    private synchronized Plaza plazaLibre() throws NoPlazasLibresException {
        // recorremos el array de plazas y y la primera que haya libre se devuelve
        for (Plaza plaza : plazas){
            if(plaza.libre){
                return plaza;
            }
        }
        // excepcion creada para cuando no haya ninguna plaza libre
        throw new NoPlazasLibresException();
    }
}
