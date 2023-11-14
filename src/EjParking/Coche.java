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
            try {
                if (parking.puedeEntrar()) {
                    System.out.println("El Coche: " + id + " quiere aparcar en el Parking");
                    Plaza plaza = parking.entrar(id);
                    Thread.sleep(TIEMPO_ESPERA);
                    parking.salir(id, plaza);
                    Thread.sleep(TIEMPO_ESPERA);
                } else {
                    System.out.println("El Coche: " + id + " no puede entrar al Parking. Esperando...");
                    Thread.sleep(1000);
                }
            } catch (NoPlazasLibresException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
