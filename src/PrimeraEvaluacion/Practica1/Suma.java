package PrimeraEvaluacion.Practica1;

import java.io.*;

public class Suma {
    /**
     * Escribe un programa Java que lea dos números desde la entrada estándar y
     * visualice su suma. Controlar que lo introducido por teclado sean dos números. Haz
     * otro programa Java para ejecutar el anterior, enviándole los datos necesarios por un
     * stream.
     */
    public static void main(String[] args) throws IOException {

        if (args.length != 2) {
            System.err.println("Error: Debe proporcionar exactamente dos números como argumentos.");
            System.exit(-1); // Finalización con error
        }

        try {
            int numero1 = Integer.parseInt(args[0]);
            int numero2 = Integer.parseInt(args[1]);

            int suma = sumar(numero1, numero2);

            System.out.println("La suma de " + numero1 + " y " + numero2 + " es: " + suma);
            System.exit(0);
        } catch (NumberFormatException e) {
            System.err.println("Error: Los argumentos deben ser números enteros.");
            System.exit(-1); // Finalización con error
        }
    }

    public static int sumar(int a, int b) {
        return a + b;
    }
}








