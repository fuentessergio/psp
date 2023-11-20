package ProgramacionMultipleUd1;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Ejemplo3_Error {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        //creamos objeto File al directorio donde está Ejemplo2
        File d = new File("C:\\Users\\2DAM\\Documents\\GitHub\\PSP\\out\\production\\psp");
        //proceso a ejecutar es Ejemplo2
        ProcessBuilder pb = new ProcessBuilder("java","LeerPorNombre","SERGIO");
        //ejecutar proceso
        Process p = pb.start();
        pb.redirectErrorStream(true);

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

        // añadimos ErrorStream para capturar el error si el programa java no existe
        try {
            InputStream isError = p.getErrorStream();
            int c;
            while ((c = isError.read())!=-1){
                System.out.print((char) c);
            }
            isError.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

