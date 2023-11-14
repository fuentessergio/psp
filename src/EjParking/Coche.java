package EjParking;

public class Coche extends Thread {
    private int id;
    private Parking parking;

    private static final long TIEMPO_ESPERA = 5000;

    public Coche (int id, Parking parking){
        this.id = id;
        this.parking = parking;
    }

    @Override
    public void run() {
        while(true){
            try{
                Plaza plaza = parking.entrar(id);
                Thread.sleep(TIEMPO_ESPERA);
                parking.salir(id,plaza);
                Thread.sleep(TIEMPO_ESPERA);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
