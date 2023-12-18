package PrimeraEvaluacion.EjercicioPython;

import java.io.*;

public class EjecutarPython {
    public static void main(String[] args) throws IOException {
        // String ruta = "C:\\Users\\2DAM\\IdeaProjects\\psp\\out\\production\\psp\\EjercicioPhyton";
        File directorio = new File("C:\\Users\\2DAM\\IdeaProjects\\psp\\out\\production\\psp");
        ProcessBuilder pb = new ProcessBuilder("python", "PrimeraEvaluacion.EjercicioPython.proceso_python.py");

        pb.directory(directorio);
        Process p = pb.start();

        InputStream is = p.getInputStream();
        InputStream isErr = p.getErrorStream();


        BufferedReader bf = new BufferedReader(new InputStreamReader(is));
        BufferedReader bfErr = new BufferedReader(new InputStreamReader(isErr));

        try {
            if (p.waitFor() == 0) {
                System.out.println(bf.readLine());
            } else {
                System.err.println(bfErr.readLine());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

