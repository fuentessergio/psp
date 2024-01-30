package SegundaEvaluacion.PracticasVoluntarias;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Ejercicio1_2Cliente {
    public static void main(String[] args) {
        String ipServidor = "localhost";
        int puertoServidor = 6000;

        try (Socket socket = new Socket(ipServidor, puertoServidor)) {
            System.out.println("Conexión establecida con el servidor.");

            System.out.println("Mi dirección: " + socket.getLocalAddress());
            System.out.println("Mi puerto: " + socket.getLocalPort());
            System.out.println("Direccion del servidor: " + socket.getInetAddress());
            System.out.println("Puerto del servidor: " + socket.getPort());

            DataInputStream flujoEntrada = new DataInputStream(socket.getInputStream());
            DataOutputStream flujoSalida = new DataOutputStream(socket.getOutputStream());

            Scanner sc = new Scanner(System.in);


            int numero;

            do{
                System.out.println("Introduce un numero o 0 para terminar: ");
                numero = sc.nextInt();
                flujoSalida.writeInt(numero);

                if(numero != 0){
                    int resultado = flujoEntrada.readInt();
                    System.out.println("El doble de " + numero + " es " + resultado);
                }
            } while(numero != 0);

            System.out.println("Conexión cerrada.");
            flujoEntrada.close();
            flujoSalida.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


