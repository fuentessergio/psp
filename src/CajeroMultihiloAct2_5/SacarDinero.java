package CajeroMultihiloAct2_5;

public class SacarDinero extends Thread{
        private Cuenta cuenta;
        String nombre;

        public SacarDinero(String nombre, Cuenta cuenta) {
            super(nombre);
            this.cuenta =cuenta;
        }

        public void run() {
            for (int x=1; x<=2;x++) {
                cuenta.RetirarDinero(10, getName());
            }
        }
}
