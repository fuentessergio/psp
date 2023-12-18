package PrimeraEvaluacion.CajeroMultihiloAct2_5;

public class CompartirInf {
    public static void main (String[] args) {
        Cuenta c = new Cuenta (80);
        SacarDinero h1 = new SacarDinero("Sergio",c);
        SacarDinero h2 = new SacarDinero ("Julia", c);
        SacarDinero h3 = new SacarDinero ("Gabriel", c);
        h1.start();
        h2.start();
        h3.start();

        c.aniadirDinero(60,"Julia");
        c.consultarSaldo("Sergio");
    }
}
