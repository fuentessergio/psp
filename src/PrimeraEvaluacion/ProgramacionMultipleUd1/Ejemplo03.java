package PrimeraEvaluacion.ProgramacionMultipleUd1;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Ejemplo03 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//creamos objeto File al directorio donde est� Ejemplo2
        File d = new File("C:\\Users\\fuent\\OneDrive\\Documentos\\GitHub\\psp\\out\\production\\psp\\PrimeraEvaluacion");
        //proceso a ejecutar es Ejemplo2
        ProcessBuilder pb = new ProcessBuilder("java","Ejemplo02");
        //establecemos el directorio donde est� el ejecutable
        pb.directory(d);
        System.out.print("Directorio de trabajo: ");
        System.out.println(pb.directory());
        //ejecutar proceso
        Process p = pb.start();
        //obtener la salida
        try {
            InputStream is = p.getInputStream();
            int c;
            while ((c = is.read())!=-1){
                System.out.print((char) c);
            }
            is.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }    
	}

}
