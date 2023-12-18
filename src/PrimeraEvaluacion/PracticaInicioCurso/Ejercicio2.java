package PrimeraEvaluacion.PracticaInicioCurso;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tabla1[] = new int[3];
        int tabla2[] = new int[3];
        int tabla3[][] = new int[3][3];
        int cont = 0;

        for (int i = 0; i < tabla1.length; i++) {
            System.out.println("Introduzca un numero");
            tabla1[i] = Integer.parseInt(sc.nextLine());
        }
        for (int i = 0; i < tabla2.length; i++) {
            System.out.println("Introduzca un numero");
            tabla2[i] = Integer.parseInt(sc.nextLine());
        }

        for (int i = 0; i < tabla3.length; i++) {
            tabla3[i][i] = tabla3[tabla1[i]][tabla2[i]];
        }

        for (int i = 0; i < tabla3.length; i++) {
            System.out.println(tabla3[i][i]);
        }
    }
}
