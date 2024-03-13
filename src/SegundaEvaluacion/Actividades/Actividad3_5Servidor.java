package SegundaEvaluacion.Actividades;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * El servidor devolverá la cadena que le envíe el cliente en mayúsculas, tantas veces
 * como el cliente le envíe mensajes. El servidor terminará su ejecución cuando la
 * cadena de caracteres que reciba del cliente sea un asterisco.
 * El cliente, en un bucle infinito, pedirá al usuario final que introduzca una cadena de
 * caracteres que posteriormente enviará al servidor y mostrará por pantalla la
 * respuesta del servidor. Cuando el usuario final introduzca un asterisco, el cliente se
 * lo enviará al servidor y finalizará su ejecución.
 * Después de los dos primeros puntos, añade en el servidor un tiempo de espera de
 * 50000 milisegundos para hacer que el método receive() no esté esperando
 * eternamente. Controla la excepción y cierra la conexión correctamente. Pruébalo.
 * Prueba también a ejecutar varios programas clientes a la vez.
 */
public class Actividad3_5Servidor {
    public static void main(String[] args) {
        int port = 5051;

        try{
            DatagramSocket datagramSocket = new DatagramSocket(port);
            System.out.println("Esperando Datagrama .......... ");

            while(true) {
                // Crear un paquete para recibir datos del cliente
                byte[] bufer = new byte[1024];
                DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);

                // Esperar a recibir datos del cliente
                datagramSocket.receive(recibo);
                String mensaje = new String(recibo.getData(), 0 , recibo.getLength());
                System.out.println("Mensaje recibido del cliente: " + mensaje);
                String mensajeM = mensaje.toUpperCase();



                // obtener direccion IP y puerto del cliente
                InetAddress clientAddress = recibo.getAddress();
                int clientPort = recibo.getPort();

                // enviar mensaje en mayusculas
                byte[] salida = mensajeM.getBytes();
                DatagramPacket envio = new DatagramPacket(salida, salida.length, clientAddress, clientPort);

                datagramSocket.send(envio);
            }
        }catch (Exception e){
            throw new RuntimeException("ERROR " + e.getMessage());
        }
    }
}
