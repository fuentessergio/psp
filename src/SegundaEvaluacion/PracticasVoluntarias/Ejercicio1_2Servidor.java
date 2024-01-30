package SegundaEvaluacion.PracticasVoluntarias;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Ejercicio1_2Servidor {
    public static void main(String[] args) {
        int puerto = 6000;
        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor creado, esperando conexiones...");
            Socket cliente = serverSocket.accept();

            System.out.println("Conexion aceptada desde " + cliente.getInetAddress());
            System.out.println("Mi dirección: " + cliente.getLocalAddress());
            System.out.println("Mi puerto: " + cliente.getLocalPort());
            System.out.println("Dirección del cliente: " + cliente.getInetAddress());
            System.out.println("Puerto del cliente: " + cliente.getPort());

            InputStream entrada = cliente.getInputStream();
            DataInputStream flujoEntrada = new DataInputStream(entrada);
            OutputStream salida = cliente.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);

            int numero;
            while((numero = flujoEntrada.readInt()) !=0 ) {
                System.out.println("Recibido el numero por el cliente, doblamos y enviamos");
                int resultado = numero * 2;
                flujoSalida.writeInt(resultado);
            }

            System.out.println("Conexión cerrada por el cliente.");
            flujoEntrada.close();
            flujoSalida.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
