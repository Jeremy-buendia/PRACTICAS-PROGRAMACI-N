package unidad2;

import java.util.Scanner;

public class PRACTICA3AEJERCICIO1 {
	public static void main(String[] args) {
		// variables
		int n1 = 0;
		int n2 = 0;
		int n3 = 0;
		int n4 = 0;

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

		// Condicional
		if (n1 > n2 && n1 > 3 && n1 > n4) {
			// Si el n1 es mayor que todos, lo mostrará en pantalla
			System.out.println("El número " + n1 + " es el mayor");
		} else if (n2 > n3 && n2 > n4) {
			// Si el n2 es mayor que todos, lo mostrará en pantalla
			System.out.println("El número " + n2 + " es el mayor");
		} else if (n3 > n4) {
			// Si el n3 es mayor que todos, lo mostrará en pantalla
			System.out.println("El número " + n3 + " es el mayor");
		} else {
			// En caso contrario, el n4 es mayor que todos, lo mostrará en pantalla
			System.out.println("El número " + n4 + " es el mayor");
		}
		// cerramos teclado
		teclado.close();
	}
}
