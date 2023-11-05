package CajeroMultihiloAct2_5;

public class Cuenta {
    private int saldo;

    Cuenta(int s){
        saldo = s;
    }

    int getSaldo() {
        return saldo;
    }

    void restar(int cantidad) {
        saldo = saldo - cantidad;
    }

    synchronized void RetirarDinero(int cant, String nombre) {
        if (getSaldo()>=cant) {
            System.out.println(nombre + " : va a retirar saldo (el actual es: "+saldo+" )");
            try {
                Thread.sleep(500);
            }catch (InterruptedException e) {}

            saldo-=cant;
            System.out.println("\t"+nombre+" retira => "+cant+" Saldo Actual ( "+getSaldo()+" )");
        }else {
            System.out.println(nombre + " No puede retirar la cantidad "+cant+" porque el saldo es: "+saldo +" ");
        }
        if (getSaldo()<0) {
            System.out.println("SALDO NEGATIVO: "+getSaldo());
        }

    }
    // no es necesario que sean synchronized, no hay problema de concurrencia
    public void consultarSaldo (String nombre){
        System.out.println(nombre + " el saldo de su cuenta es: " + saldo);
    }

    public void aniadirDinero (int cantidad,String nombre){
        saldo += cantidad;
        System.out.println(nombre + " añade " + cantidad + " a su cuenta. El saldo actual es: " + saldo);
    }
}
