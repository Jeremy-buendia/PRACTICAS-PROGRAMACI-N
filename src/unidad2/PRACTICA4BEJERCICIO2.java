package unidad2;

import java.util.Scanner;

public class PRACTICA4BEJERCICIO2 {
	public static void main(String[] args) {
		// variables
		String cadenaPalabras = "";
		char letras;
		String letrasStr = "";
		String palabras = "";
		int i = 0;
		int x = 0;
		int palabrasMayor5 = 0;

		// Inicializamos teclado
		Scanner teclado = new Scanner(System.in);

		// Pedimos los valores
		System.out.println(
				"Introduce una cadena de palabras y se devolvera el número de palabras con más de 5 caracteres: ");
		cadenaPalabras = teclado.nextLine();

		// Bucle se ejecuta mientras que i sea menor que la longitud de la entrada por
		// teclado
		while (i < cadenaPalabras.length()) {
			letras = cadenaPalabras.charAt(i);

			// Concateno letras hasta que haya un espacio
			if (letras != ' ') {
				letrasStr = Character.toString(letras);
				palabras = palabras.concat(letrasStr);

			} else {
				// Si hay espacio, compruebo que la palabra formada tenga más de 5 caracteres
				if (palabras.length() > 5) {
					// Cuento cuantas palabras hay mayores de 5
					palabrasMayor5++;
				}
				// formateo la variable palabras
				palabras = "";
			}
			// autoincremento i
			i++;

		}

		// Comprobamos que la ultima palabra sea mayor de 5
		if (palabras.length() > 5) {
			// Cuento cuantas palabras hay mayores de 5
			palabrasMayor5++;
		}

		// Mostramos por pantalla los numeros mayores de 5
		if (i == cadenaPalabras.length()) {
			System.out.println("El número de palabras con más de 5 caracteres es " + palabrasMayor5);
		}

		// Creamos un Array con el tamaño igual al numero de palabras mayores de 5
		// caracteres
		String cadenaAlReves[] = new String[palabrasMayor5];
		char letrasAlReves = ' ';
		// Reiniciamos la variable palabras
		palabras = "";

		// Repetimos el bucle anterior pero ahora inviertiendo las palabras y
		// guardándolas
		for (int z = 0; z < cadenaPalabras.length(); z++) {
			letras = cadenaPalabras.charAt(z);

			// Concateno letras hasta que haya un espacio
			if (letras != ' ') {
				letrasStr = Character.toString(letras);
				palabras = palabras.concat(letrasStr);

			} else {
				// Si hay espacio, compruebo que la palabra formada tenga más de 5 caracteres
				if (palabras.length() > 5) {
					// Inicio la posición del array donde se guardará la palabra
					cadenaAlReves[x] = "";
					// El bucle irá desde atrás hacia delante almacenando las letras en el array
					for (int j = palabras.length() - 1; j >= 0; j--) {
						// Guardo la letra en una variable
						letrasAlReves = palabras.charAt(j);
						// Paso la letra a String
						letrasStr = Character.toString(letrasAlReves);
						// La concateno en la posición del array
						cadenaAlReves[x] = cadenaAlReves[x].concat(letrasStr);
					}
					// Lo muestro por pantalla
					System.out.println("Palabra invertida: " + cadenaAlReves[0]);
					// Sumo uno a la posición del array
					x++;
				}
				// formateo la variable palabras
				palabras = "";
			}

		}

		// En caso de que la última palabra sea mayor de 5 repetimos el proceso
		if (palabras.length() > 5) {
			cadenaAlReves[x] = "";
			for (int j = palabras.length() - 1; j >= 0; j--) {
				letrasAlReves = palabras.charAt(j);
				letrasStr = Character.toString(letrasAlReves);
				cadenaAlReves[x] = cadenaAlReves[x].concat(letrasStr);
			}
			System.out.println("Palabra invertida: " + cadenaAlReves[x]);
			x++;
		}

		// Cerramos teclado
		teclado.close();
	}
}
