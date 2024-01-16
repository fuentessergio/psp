package SegundaEvaluacion.Actividades;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Actividad3_1Servidor {
    public static void main(String[] args) {
        int numeroPuerto = 6000;
        try {
            ServerSocket servidor = new ServerSocket(numeroPuerto);
            System.out.println("Esperando al cliente...");

            Socket clienteConectado1 = servidor.accept();
            mostrarInfo(clienteConectado1,1);
            clienteConectado1.close();

            Socket clienteConectado2 = servidor.accept();;
            mostrarInfo(clienteConectado2,2);
            clienteConectado2.close();

            servidor.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void mostrarInfo(Socket socket, int numCliente){
        System.out.println("Cliente " + numCliente + " conectado:");
        System.out.println("Puerto local: " + socket.getLocalPort());
        System.out.println("Puerto remoto: " + socket.getPort());
        System.out.println("Dirección IP remota: " + socket.getInetAddress().getHostAddress());
        System.out.println();
    }
}
