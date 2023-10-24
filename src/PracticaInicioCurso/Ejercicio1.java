package PracticaInicioCurso;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int numeros[] = new int[5];

        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Introduzca un número");
            numeros[i] = Integer.parseInt(sc.nextLine());

        }
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }
    }
}
