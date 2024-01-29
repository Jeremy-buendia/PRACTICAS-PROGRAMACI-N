package unidad2;

import java.util.Scanner;

public class PRACTICA4MODIFICIADOEJERCICIO2 {
	public static void main(String[] args) {
		// variables
		String cadenaPalabras = "";
		char letras;
		String letrasStr = "";
		String palabras = "";
		int i = 0;

		// Inicializamos teclado
		Scanner teclado = new Scanner(System.in);

		// Pedimos los valores
		System.out.println("Introduce una cadena de palabras y se devolveran las que su longitud sea mayor a 5: ");
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
					System.out.println("La palabra " + palabras + " es mayor de 5.");
				}
				// formateo la variable palabras
				palabras = "";
			}
			// autoincremento i
			i++;

		}
		// En caso de que la ultima palabra guardada sea mayor de 5 lo muestro en
		// pantalla
		if (palabras.length() > 5) {
			System.out.println("La palabra " + palabras + " es mayor de 5.");
		}

		// Cerramos teclado
		teclado.close();
	}
}
