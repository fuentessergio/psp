package SegundaEvaluacion.Actividades;

import javax.imageio.IIOException;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Actividad3_4Cliente {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6000;

        try {
            System.out.println("PROGRAMA CLIENTE INICIADO....");
            Socket cliente = new Socket(host, puerto);

            DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
            int numeroCliente = flujoEntrada.readInt();
            System.out.println("Recibido del servidor: Soy el cliente " + numeroCliente);

            flujoEntrada.close();
            cliente.close();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
