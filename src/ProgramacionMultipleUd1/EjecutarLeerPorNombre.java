package ProgramacionMultipleUd1;

import java.io.*;

public class EjecutarLeerPorNombre {

            public static void main(String[] args) throws IOException {
                String ruta = "C:\\Users\\2DAM\\IdeaProjects\\psp\\out\\production\\";
                ProcessBuilder pb = new ProcessBuilder("java", "-cp", ruta, "LeerPorNombre","SERG");
                // -cp para la classpath, no sale en este proyecto pero si en el de actividad 1
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


