package SegundaEvaluacion.GeneracionDeServiciosEnRed;


import java.util.ArrayList;
import java.util.List;

public class Vacia {
    public static void main(String[] args) {
        int a=5;
        for (int i = 1; i < a; i++) {
            for (int j = 1; j < a-i; j++) {
            }
            for (int k = 1; k <= 2*i-1 ; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}



