package SegundaEvaluacion.Actividades;

import javax.imageio.IIOException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Crea un programa servidor que pueda atender hasta 3 clientes. Debe enviar a cada cliente un
 * mensaje indicando el número de cliente que es. Este número será 1, 2 ó 3. Crea también el
 * programa cliente que muestre el mensaje recibido.
 * Cambia el programa para que lo haga para N clientes, siendo N un parámetro que tendrás que
 * definir.
 */

public class Actividad3_4Servidor {
    public static void main(String[] args) {
        int numeroPuerto = 6000;
        int maxCLientes = 3;
        try {
            ServerSocket servidor = new ServerSocket(numeroPuerto);
            System.out.println("Esperando a los clientes...");

            for (int clienteNumero = 1; clienteNumero <= maxCLientes ; clienteNumero++) {
                Socket clienteConectado = servidor.accept();
                System.out.println("Cliente " + clienteNumero + " conectado");

                DataOutputStream flujoSalida = new DataOutputStream(clienteConectado.getOutputStream());

                flujoSalida.writeInt(clienteNumero);

                flujoSalida.close();
                clienteConectado.close();
            }
            servidor.close();
        } catch (IOException e){
            throw new RuntimeException();
        }
    }
}
