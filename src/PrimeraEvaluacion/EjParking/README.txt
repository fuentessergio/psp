Práctica 2: Parking -- Progrmacion de Servicios y Procesos.

El programa simula un parking con múltiples plazas y coches que intentan entrar y salir del parking,
con el uso de hilos sincronizados y los métodos vistos en clase.

Clase Plaza, representa una plaza de aparcamiento para los coches.
Cuenta con un un int numero y un boolean de si esta libre o no.
Un constructor que inicializa una plaza con un numero unico.
2 métdos boolean en los cuáles uno libera la plaza y el otra la ocupa.

Clase Coche, representa un coche que intenta entrar y/o salir del parking.
Tiene un constructor que inicializa un coche un identificador unico y el parking donde se encuentra.
Y un metodo principal 'void run()' que mediante un bucle infinito simula la entrada y salida de los coches.
Extiende de Thread.

Clase Parking, representa el parking y las plazas que hay en él.
Tiene un constructor que inicializa el total de las plazas del parking y los coches que existen tal y como exige el enunciado.
Un método para saber si hay plazas disponibles, otro para entrar, otro para salir y uno que devuelve la primera plaza libre.

Clase Main, inicializa un Parking con el numero de plazas y los coches que quieren entrar en él
Clase NoPlazasLibresException es una excepcion utilizada en Parking que indica que no quedan plazas libres.

Oracle Open JDK version 19
Sergio Fuentes Orobón -- 2ºDAM