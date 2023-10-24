package Practica1;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Suma {
    /** Escribe un programa Java que lea dos números desde la entrada estándar y
     visualice su suma. Controlar que lo introducido por teclado sean dos números. Haz
     otro programa Java para ejecutar el anterior, enviándole los datos necesarios por un
     stream.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        double num1, num2, resultado;
        boolean entradaOk = false;

        while (!entradaOk) {

            try {
                System.out.println("Introduce el primer número: ");
                String numero1 = br.readLine();
                System.out.println("Introduce el segundo número: ");
                String numero2 = br.readLine();

                if (esNumero(numero1) && esNumero(numero2)) {
                    num1 = Double.parseDouble(numero1);
                    num2 = Double.parseDouble(numero2);

                    resultado = num1 + num2;
                    System.out.println("El resultado de " + num1 + " + " + num2 + " = " + resultado);
                    entradaOk = true;
                } else {
                    System.out.println("Error. Introduzca 2 números para realizar la suma ");
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        try {
            in.close(); // Cerrar el flujo de entrada al finalizar, y no dentro del bucle while que lo hace infinito
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean esNumero(String str) {
        //Creamos un metodo que compruebe si el string introducido es un numero y lo convierte a numero.
        try {
            Double.parseDouble(str); // conversion a double
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}


