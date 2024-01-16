package SegundaEvaluacion.Actividades;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Actividad3_1Cliente {
    public static void main(String[] args) {
        String host = "localhost";
        int numeroPuerto = 6000;
        try {
            System.out.println("PROGRAMA CLIENTE INICIADO....");
            Socket socketCliente = new Socket(host,numeroPuerto);

            System.out.println("Cliente conectado:");
            System.out.println("Puerto local: " + socketCliente.getLocalPort());
            System.out.println("Puerto remoto: " + socketCliente.getPort());
            System.out.println("Dirección IP remota: " + socketCliente.getInetAddress().getHostAddress());

            socketCliente.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
