package pruebaAspa;

public class App {

    private void invertirCadena(String texto){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(texto);
        stringBuilder.reverse();
        System.out.println(stringBuilder);

        /*String [] array = texto.split("");
        for (int i = array.length; i > 0; i--) {
            stringBuilder.append(array[i-1]);
        }
        System.out.println(stringBuilder);*/
    }

    private void isCapicua (int number){
        String numero = String.valueOf(number);
        String numeroInvertido = new StringBuilder(numero).reverse().toString();

        if(numero.equals(numeroInvertido)){
            System.out.println("Es capicua");
        } else {
            System.out.println("No lo es");
        }
    }
    private void contarCaracteres(String texto){
        int i,length,contador[] = new int[256];

        length = texto.length();

        for (i = 0; i < length; i++) {
            contador[texto.charAt(i)]++;
        }
        for (i = 0; i < 256; i++) {
            if(contador[i] != 0){
                System.out.println((char)i + ": " + contador[i]);
            }
        }
    }
    private void caracteresRepetidos(String texto){
        int i,length,contador[] = new int[256];

        length = texto.length();

        for (i = 0; i < length; i++) {
            contador[texto.charAt(i)]++;
        }
        for (i = 0; i < 256; i++) {
            if(contador[i] > 1){
                System.out.println((char)i + ": " + contador[i]);
            }
        }
    }
    private void esMultiplo2 (int numero){
        if(numero%2 == 0){
            System.out.println("es multiplo");
        }else {
            System.out.println("no lo es");
        }
    }

    public static void main(String[] args) {
        App miApp = new App();
        //miApp.invertirCadena("pruebaAspa");
        //miApp.isCapicua(255);
        //miApp.contarCaracteres("mitocode");
        //miApp.caracteresRepetidos("sssseeerrr");
        miApp.esMultiplo2(5);
    }
}
