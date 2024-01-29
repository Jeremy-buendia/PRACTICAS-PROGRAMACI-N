package unidad2;

import java.util.Scanner;

public class PRACTICA4EJERCICIO2 {
	public static void main(String[] args) {
		// variables
		String cadenaPalabras = "";
		char letras;
		String letrasStr = "";
		String palabras = "";
		int i = 0;
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
			palabrasMayor5++;
		}

		// Mostramos por pantalla los numeros mayores de 5
		if (i == cadenaPalabras.length()) {
			System.out.println("El número de palabras con más de 5 caracteres es " + palabrasMayor5);
		}

		// Cerramos teclado
		teclado.close();
	}
}
