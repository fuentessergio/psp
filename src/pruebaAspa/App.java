package pruebaAspa;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class App {

    private void invertirCadena(String texto){

        StringBuilder stringBuilder = new StringBuilder();
        /*stringBuilder.append(texto);
        stringBuilder.reverse();
        System.out.println(stringBuilder);*/

        String [] array = texto.split("");
        for (int i = array.length; i > 0; i--) {
            stringBuilder.append(array[i-1]);
        }
        System.out.println(stringBuilder);
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
    public void esBisiesto(int year){
        boolean esBisiesto = LocalDate.of(year,1,1).isLeapYear();
        System.out.println(esBisiesto);
    }
    public void desordenarCadena (String texto){
        String [] array = texto.split("");
        List<String> lista = Arrays.asList(array);
        Collections.shuffle(lista);
        lista.forEach(System.out::println);
    }

    public void noDuplicados(List<Integer> list){
        // Evalua el contenido y no permite duplicados
        Set<Integer> set = new HashSet<>(list);
        set.forEach(System.out::println);
    }
    public void duplicados(List<String> list){
        Set<String> vistos = new HashSet<>();
        Set<String> duplicados = new HashSet<>();

        for (String elemento: list) {
            if(!vistos.add(elemento)){
                duplicados.add(elemento);
            }
        }
        duplicados.forEach(System.out::println);
    }
    public boolean tieneVocal(String texto){
        String[] array = texto.split("");
        boolean encontrado = false;
        for(String s : array){
            if(s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u")){
                encontrado = true;
                break;
            }
        }
        System.out.println(encontrado);
        return encontrado;
    }
    public boolean esPalindromo(String texto) throws MiExcepcion {
        // Se lee igual de ambos sentidos, ejemplo 'oro'
        String textoFormateado = texto.replaceAll("\\s","").toLowerCase();
        boolean result = true;
        int length = textoFormateado.length();

        for (int i = 0; i < length/2; i++) {
            if(textoFormateado.charAt(i) != textoFormateado.charAt(length-i-1)){
                result = false;
                throw new MiExcepcion("Palíndromo incorrecto, prueba con otro");
            }
        }
        return result;
    }

    //EJERCICIO CON FILTER
    //Dada una lista de números, filtra los números pares y devuelve una nueva lista con esos números.
    public void numerosPares (List<Integer> numeros){
        List<Integer> pares = numeros.stream().
                filter(numero -> numero % 2 ==0).
                collect(Collectors.toList());
        System.out.println("Numeros pares: " + pares);
        System.out.println("Numeros originales: " + numeros);

    }

    //EJERCICIO CON ITERATOR
    // Dada una lista de nombres, utiliza un iterador para recorrer la lista e imprimir cada nombre.
    public void iterator(){
        List<String> nombres = new ArrayList<>();
        nombres.add("Ana");
        nombres.add("Ano");
        nombres.add("Ane");
        nombres.add("Anu");

        if(nombres != null) {
            Iterator<String> stringIterator = nombres.iterator();
            while (stringIterator.hasNext()) {
                System.out.println(stringIterator.next());
            }
        }
    }
    public User findByUserName(List<User> users, String name) throws MiExcepcion {
        if(users != null && name != null){
            for (User user : users){
                    if(user != null && user.getName().equalsIgnoreCase(name)){
                        return user;
                    }
            }
            throw new MiExcepcion("");
        }
        throw new MiExcepcion("");
    }
    public static void main(String[] args) {
        App miApp = new App();
        //miApp.invertirCadena("pruebaAspa");
        //miApp.isCapicua(255);
        //miApp.contarCaracteres("mitocode");
        //miApp.caracteresRepetidos("sssseeerrr");
        //miApp.esMultiplo2(5);
        //miApp.esBisiesto(2021);
        //miApp.desordenarCadena("hola");
        //miApp.noDuplicados(Arrays.asList(5,5,5,5,1,2));
        //miApp.duplicados(Arrays.asList("h","h","o","l","l","a"));
        //miApp.tieneVocal("hl mdrd");
        /*try {
            System.out.println(miApp.esPalindromo("Anito lava la tina"));
        } catch (MiExcepcion e) {
            throw new RuntimeException(e);
        }*/
        //miApp.numerosPares(Arrays.asList(1,2,3,4,5,6,7,8,9,2));
        //miApp.iterator();

    }
}
