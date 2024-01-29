package unidad2;

import java.util.Scanner;

public class PRACTICA7BEJERCICIO2 {

	public static void main(String[] args) {
		// variables
		String palabra = "";
		char letra = ' ';
		int i = 0;
		boolean esIsograma = true;
		int j = 0;
		int vecesLetra = 0;

		// iniciamos Scanner
		Scanner teclado = new Scanner(System.in);
		// pedimos la palabra
		System.out.println("Introduce una palabra y se determinará si es o no un isograma: ");
		palabra = teclado.nextLine();

		// Lo ponemos todo en minuscula
		palabra = palabra.toLowerCase();

		// Mientras i sea menor que la longitud de la palabra
		while (i < palabra.length()) {
			// almacenamos la letra en la posición i
			letra = palabra.charAt(i);
			while (j < palabra.length()) {
				// Comprobamos que la letra aparezca en repetida en las demás posiciones
				if (letra == palabra.charAt(j)) {
					// aumentamos las veces que aparece la letra
					vecesLetra++;
				}
				// incrementamos j
				j++;
			}
			// Si la letra aparece 2 veces o más, no es un isograma
			if (vecesLetra >= 2) {
				esIsograma = false;
			}
			// reiniciamos las variables
			vecesLetra = 0;
			j = 0;
			// incrementamos i
			i++;
		}

		if (!esIsograma) {
			System.out.println("La palabra no es un isograma");
		} else {
			System.out.println("La palabra es un isograma");
		}

		teclado.close();
	}

}
