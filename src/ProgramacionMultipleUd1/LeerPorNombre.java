package ProgramacionMultipleUd1;

public class LeerPorNombre {
    public static void main(String[] args) {
        if(args.length == 1) {
            System.out.println("Nombre introducido: " + args[0]);
            System.exit(0);
        } else {
            System.err.println("Error: Debe proporcionar un nombre como argumento.");
            System.exit(-1); // Finalización con error
        }
    }
}

