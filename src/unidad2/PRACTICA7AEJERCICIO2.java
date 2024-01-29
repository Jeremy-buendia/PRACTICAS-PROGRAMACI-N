package unidad2;

import java.util.Scanner;

public class PRACTICA7AEJERCICIO2 {

	public static void main(String[] args) {
		// variables
		String palabra = "";
		boolean esIsograma = true;
		int posicionBusqueda = 0;
		int vecesLetra = 0;
		char letra = ' ';
		int i = 0;

		// inicializamos escaner
		Scanner teclado = new Scanner(System.in);

		// pedimos la palabra
		System.out.println("Introduce una palabra y se determinará si es o no un isograma: ");
		palabra = teclado.nextLine();

		// Pasamos a minúscula
		palabra = palabra.toLowerCase();

		// El bucle se ejecuta mientras i sea menor que la longitud de la palabra
		while (i < palabra.length()) {
			// Guardamos la letra de la posición i
			letra = palabra.charAt(i);
			while (posicionBusqueda != -1) {
				// Comprobamos que la letra no se repita
				posicionBusqueda = palabra.indexOf(letra, posicionBusqueda);
				if (posicionBusqueda != -1) {
					// Si indexOf me devuleve algo distinto a -1 significa que ha encontrado la
					// letra
					// incrementamos las veces que ha aparecido la letra
					vecesLetra++;
					// Si la letra ha salido 2 o más veces no es un isograma
					if (vecesLetra >= 2) {
						esIsograma = false;
					}
					// Aumentamos la posición de búsqueda
					posicionBusqueda++;
				}
			}
			// reiniciamos las variables
			vecesLetra = 0;
			posicionBusqueda = 0;
			// Incrementamos i
			i++;
		}

		// Mostramos si es o no un isograma
		if (esIsograma) {
			System.out.println("La palabra es un isograma");
		} else {
			System.out.println("La palabra no es un isograma");
		}

		// Cerramos teclado
		teclado.close();
	}

}
