package Practica1;
import java.io.*;

public class EjecutarSuma {
    /**
     * Escribe un programa Java que lea dos números desde la entrada estándar y
     * visualice su suma. Controlar que lo introducido por teclado sean dos números. Haz
     * otro programa Java para ejecutar el anterior, enviándole los datos necesarios por un
     * stream.
     */
    public static void main(String[] args) throws IOException {
        File directorio = new File("C:\\Users\\fuent\\OneDrive\\Documentos\\GitHub\\psp\\out\\production\\psp");
        // String ruta = "C:\\Users\\fuent\\Desktop\\2ºDAM\\PSP\\out\\production\\PSP\\Practica1";

        ProcessBuilder pb = new ProcessBuilder("java", "Practica1.Suma", "5","100");
        pb.directory(directorio);
        System.out.println(directorio);
        Process p = pb.start();

        OutputStream os = p.getOutputStream();
        //os.write("5\n3\n".getBytes()); // para elegir los numeros que quieres sumar
        //os.flush();// vacia el Buffer de salida
        os.close();

        InputStream is = p.getInputStream();
        BufferedReader bf = new BufferedReader(new InputStreamReader(is));

        String linea; // para capturar la salida de la suma

        while ((linea = bf.readLine()) != null) {
            System.out.println(linea);
        }
        is.close();

        int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("El programa Suma ha terminado con la salida " + exitVal);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        try {
            InputStream error = p.getErrorStream();
            BufferedReader brerror = new BufferedReader(new InputStreamReader(error));
            String lineaerror = null;
            while ((lineaerror = brerror.readLine()) != null)
                System.out.println("ERROR >" + lineaerror);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }
}


