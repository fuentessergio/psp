package SegundaEvaluacion.Actividades;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Actividad3_2Cliente {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6000;
        try {
            System.out.println("PROGRAMA CLIENTE INICIADO....");
            Socket cliente = new Socket(host, puerto);

            // CREO FLUJO DE ENTRADA AL SERVIDOR
            DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
            String mensajeServidor = flujoEntrada.readUTF();

            // EL SERVIDOR ME ENVIA UN MENSAJE
            System.out.println("Recibiendo del SERVIDOR: \n\t" + mensajeServidor);

            DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
            flujoSalida.writeUTF(mensajeServidor.toLowerCase());

            flujoSalida.close();
            flujoEntrada.close();
            cliente.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
