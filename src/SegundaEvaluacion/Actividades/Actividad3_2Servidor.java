package SegundaEvaluacion.Actividades;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Actividad3_2Servidor {
    public static void main(String[] args) {
        int numeroPuerto = 6000;
        try {
            ServerSocket servidor = new ServerSocket(numeroPuerto);
            System.out.println("Esperando al cliente...");

            Socket clienteConectado = servidor.accept();
            System.out.println("cliente conectado");
            // CREO FLUJO DE SALIDA AL CLIENTE
            OutputStream salida = clienteConectado.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);

            // ENVIO UN SALUDO AL CLIENTE
            flujoSalida.writeUTF("HOLA QUE TENGAS BUEN DÍA");
            InputStream entrada = clienteConectado.getInputStream();
            DataInputStream flujoEntrada = new DataInputStream(entrada);

            // EL CLIENTE ME ENVIA UN MENSAJE
            System.out.println("Recibiendo del CLIENTE: \n\t" + flujoEntrada.readUTF());



            flujoEntrada.close();
            flujoSalida.close();
            servidor.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
