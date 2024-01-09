package SegundaEvaluacion.ProgramacionComunicacionEnRed.HilosTCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HilosTCPServidor {
	/*Se ejecuta primero, MEJOR POR CONSOLA.
	comando javac para compilar, comando java HilosTCPServidor para ejecutar y
	 despues abrir cmds para cada cliente.
	CUIDADO CON LOS PAQUETES!!*/
	
	public static void main (String[] arg) throws IOException{
		ServerSocket servidor;
		servidor = new ServerSocket(60000);
		System.out.println("Servidor iniciado...");
		
		while (true) {
			Socket cliente = new Socket();
			cliente = servidor.accept();//esperando al cliente
			HilosTCPHiloServidor hilo = new HilosTCPHiloServidor(cliente);
			hilo.start();//se atiende al cliente
		}
	}


}
