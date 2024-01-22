package SegundaEvaluacion.Actividades;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Crea un programa cliente que introduzca por teclado un número entero y se lo envíe al
 * servidor. Crea también el programa servidor que devuelva el cuadrado del número.
 */

public class Actividad3_3Cliente {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6000;
        try {
            System.out.println("PROGRAMA CLIENTE INICIADO....");
            Socket cliente = new Socket(host, puerto);

            // CREO FLUJOS AL SERVIDOR
            DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
            DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());

            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce un numero: ");
            int numero = sc.nextInt();

            flujoSalida.writeInt(numero);

            int resultado = flujoEntrada.readInt();
            System.out.println("El resultado de su cuadrado es: " + resultado);

            sc.close();
            flujoSalida.close();
            flujoEntrada.close();
            cliente.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

