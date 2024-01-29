package unidad2;

import java.util.Scanner;

public class PRACTICA8EJERCICIO2 {

	public static void main(String[] args) {
		// variables
		int numero = 0;
		int numPrimos = 0;
		int cantidadNumeros = 0;
		int posiblePrimo = 0;
		int j = 1;

		// Iniciamos el Scanner
		Scanner teclado = new Scanner(System.in);

		// Preguntamos cuantos números va a introducir
		System.out.print("¿Cuántos números vas a meter? ");
		cantidadNumeros = teclado.nextInt();

		// Bucle para hacer la petición de los números
		for (int i = 1; i <= cantidadNumeros; i++) {
			// Pedimos números
			System.out.print("Introduce el " + i + "º número: ");
			numero = teclado.nextInt();
			// Bucle para calcular las divisiones que tienen resto 0
			while (j <= numero) {
				if (numero % j == 0) {
					// Si tiene resto 0 aumentamos uno en la variable
					posiblePrimo++;
				}
				// incrementamos para calcular el módulo del siguiente numero
				j++;
			}
			// Fuera del bucle anidado, vemos si la cantidad de divisiones en las que el
			// resto ha sido 0 es 2
			if (posiblePrimo == 2) {
				// aumentamos la cantidad de numeros primos
				numPrimos++;
			}
			// Reiniciamos las variables
			j = 1;
			posiblePrimo = 0;
		}
		// Mostramos en pantalla
		System.out.println("Hay " + numPrimos + " numeros primos");

		teclado.close();
	}

}
