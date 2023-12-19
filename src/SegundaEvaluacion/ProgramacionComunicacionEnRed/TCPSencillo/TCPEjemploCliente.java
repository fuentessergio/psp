package SegundaEvaluacion.ProgramacionComunicacionEnRed.TCPSencillo;

/**
*
* @author ricardo
*/
import java.io.*;
import java.net.*;

public class TCPEjemploCliente  {
 public static void main(String[] args) throws Exception {
	String host = "localhost";
	int puerto = 6000;//puerto remoto
	
	System.out.println("PROGRAMA CLIENTE INICIADO....");
	Socket cliente = new Socket(host, puerto);

	// CREO FLUJO DE SALIDA AL SERVIDOR	
	DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());

	// ENVIO UN SALUDO AL SERVIDOR
	flujoSalida.writeUTF("Saludos al SERVIDOR DESDE EL CLIENTE");

	// CREO FLUJO DE ENTRADA AL SERVIDOR	
	DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());

	// EL SERVIDOR ME ENVIA UN MENSAJE
	System.out.println("Recibiendo del SERVIDOR: \n\t" + flujoEntrada.readUTF());

	// CERRAR STREAMS Y SOCKETS	
	flujoEntrada.close();	
	flujoSalida.close();	
	cliente.close();
 }// main
}// 
