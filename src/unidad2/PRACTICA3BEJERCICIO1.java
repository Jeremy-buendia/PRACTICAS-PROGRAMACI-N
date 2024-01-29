package unidad2;

import java.util.Scanner;

public class PRACTICA3BEJERCICIO1 {

	public static void main(String[] args) {
		// variables
		int n1 = 0;
		int n2 = 0;
		int n3 = 0;
		int n4 = 0;
		int min1 = 0;
		int min2 = 0;
		int paridad1 = 0;
		int paridad2 = 0;

		// mostramos en pantalla la explicación
		System.out.println("Introduce cuatro números y se dirá cuál es mayor");
		// Creamos el Escáner
		Scanner teclado = new Scanner(System.in);

		// Solicitamos los valores y los registramos en las variables
		System.out.println("Introduce el número 1: ");
		n1 = teclado.nextInt();
		System.out.println("Introduce el número 2: ");
		n2 = teclado.nextInt();
		System.out.println("Introduce el número 3: ");
		n3 = teclado.nextInt();
		System.out.println("Introduce el número 4: ");
		n4 = teclado.nextInt();

		if (n1 <= n2 && n1 <= n3 && n1 <= n4) {
			// Si n1 es el más pequeño, lo almacenamos en min1 y buscamos quien es el
			// segundo más
			// pequeño para almacenarlo en min2
			min1 = n1;
			if (n2 <= n3 && n2 <= n4) {
				min2 = n2;
			} else if (n3 <= n4) {
				min2 = n3;
			} else {
				min2 = n4;
			}
		} else if (n2 <= n3 && n2 <= n4) {
			// Si n2 es el más pequeño, lo almacenamos en min1 y buscamos quien es el
			// segundo más
			// pequeño para almacenarlo en min2
			min1 = n2;
			if (n3 <= n1 && n3 <= n4) {
				min2 = n3;
			} else if (n1 <= n4) {
				min2 = n1;
			} else {
				min2 = n4;
			}
		} else if (n3 <= n4) {
			// Si n3 es el más pequeño, lo almacenamos en min1 y buscamos quien es el
			// segundo más
			// pequeño para almacenarlo en min2
			min1 = n3;
			if (n4 <= n1 && n4 <= n2) {
				min2 = n4;
			} else if (n1 <= n2) {
				min2 = n1;
			} else {
				min2 = n2;
			}
		} else {
			// Si n4 es el más pequeño, lo almacenamos en min1 y buscamos quien es el
			// segundo más
			// pequeño para almacenarlo en min2
			min1 = n4;
			if (n1 <= n2 && n1 <= n3) {
				min2 = n1;
			} else if (n2 <= n3) {
				min2 = n2;
			} else {
				min2 = n3;
			}
		}

		// Vemos si es par o impar calculando el módulo de dos y lo almacenamos en
		// variables
		paridad1 = min1 % 2;
		paridad2 = min2 % 2;

		if (paridad1 == 0 && paridad2 == 0) {
			// Si los dos son pares, lo mostramos
			System.out.println("Los números " + min1 + " y " + min2 + " son los más pequeños y son pares");
		} else if (paridad1 != 0 && paridad2 == 0) {
			// Si n1 es impar lo mostramos
			System.out.println("Los números " + min1 + " y " + min2 + " son los más pequeños y " + min1 + " es impar");
		} else if (paridad1 == 0 && paridad2 != 0) {
			// Si n2 es impar lo mostramos
			System.out.println("Los números " + min1 + " y " + min2 + " son los más pequeños y " + min2 + " es impar");
		} else {
			// Si los dos son impares, lo mostramos
			System.out.println("Los números " + min1 + " y " + min2 + " son los más pequeños y son impares");
		}

		// Cerramos teclado
		teclado.close();
	}

}
