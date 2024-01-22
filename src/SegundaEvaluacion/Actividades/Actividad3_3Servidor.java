package SegundaEvaluacion.Actividades;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Actividad3_3Servidor {
    public static void main(String[] args) {
        int numeroPuerto = 6000;
        try {
            ServerSocket servidor = new ServerSocket(numeroPuerto);
            System.out.println("Esperando al cliente...");

            Socket clienteConectado = servidor.accept();
            System.out.println("Cliente conectado");

            InputStream entrada = clienteConectado.getInputStream();
            DataInputStream flujoEntrada = new DataInputStream(entrada);
            OutputStream salida = clienteConectado.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);

            int numero = flujoEntrada.readInt();
            System.out.println("El numero recibido por el cliente es: " + numero);
            int resultado = numero * numero;
            flujoSalida.writeInt(resultado);

            flujoEntrada.close();
            flujoSalida.close();
            servidor.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
