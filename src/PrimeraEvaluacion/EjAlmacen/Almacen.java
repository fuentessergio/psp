package PrimeraEvaluacion.EjAlmacen;

/**
 * En unos grandes almacenes hay 300 clientes agolpados en la puerta para intentar conseguir
 * un producto del cual sólo hay 100 unidades.
 * Por la puerta sólo cabe una persona, pero la paciencia de los clientes es limitada por lo que sólo se harán un máximo de 10
 * intentos para entrar por la puerta. Si después de 10 intentos la puerta no se ha encontrado libre ni una sola vez,
 * el cliente desiste y se marcha. Cuando se consigue entrar por la puerta, el cliente puede encontrarse con dos situaciones:
 * Quedan productos: el cliente cogerá uno y se marchará.
 * No quedan productos: el cliente simplemente se marchará.
 */
public class Almacen {
    private static int unidades = 100;

    public static synchronized boolean cogerProducto(){
        if(unidades>0){
            unidades--;
            return true;
        } else {
            return false;
        }
    }
}
