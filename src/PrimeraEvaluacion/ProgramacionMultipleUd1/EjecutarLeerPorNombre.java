package PrimeraEvaluacion.ProgramacionMultipleUd1;

import java.io.*;

public class EjecutarLeerPorNombre {

            public static void main(String[] args) throws IOException {
                String ruta = "C:\\Users\\fuent\\OneDrive\\Documentos\\GitHub\\psp\\out\\production\\psp";
                ProcessBuilder pb = new ProcessBuilder("java", "-cp", ruta, "PrimeraEvaluacion.ProgramacionMultipleUd1.LeerPorNombre","sergio", "quetal");

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
                } finally{
                    is.close();
                    isErr.close();
                }

            }
    }


