package SegundaEvaluacion.Actividades;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Actividad3_5Cliente {
    public static void main(String[] args) throws Exception {
        String destino = "localhost";
        System.out.println("Variable destino: "+destino);
        int port = 5051; //puerto al que envio el datagrama

        try{
            DatagramSocket clientSocket = new DatagramSocket();
            Scanner scanner = new Scanner(System.in);

            while(true){
                System.out.println("Introduce una cadena o '*' para salir");
                String mensaje = scanner.nextLine();

                if(mensaje.trim().equals("*")){
                    System.out.println("Cliente cerrado");
                    break;
                }

                byte [] cadenaEnviada = mensaje.getBytes(); // obtener bytes
                DatagramPacket envio = new DatagramPacket(cadenaEnviada, cadenaEnviada.length, InetAddress.getByName(destino),port);
                clientSocket.send(envio);

                byte [] cadenaRecibida = new byte[1024];
                DatagramPacket recibo = new DatagramPacket(cadenaRecibida, cadenaRecibida.length);
                clientSocket.receive(recibo);

                String respuestaServidor = new String(recibo.getData(), 0 , recibo.getLength());
                System.out.println("Respuesta del servidor: " + respuestaServidor);
            }
            clientSocket.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
