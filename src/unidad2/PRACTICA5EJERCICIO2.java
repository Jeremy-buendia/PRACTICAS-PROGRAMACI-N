package unidad2;

import java.util.Scanner;

public class PRACTICA5EJERCICIO2 {
	public static void main(String[] args) {
		// variables
		int numeroEntrada = 0;
		int i = 1;

		// Inicializamos Scanner
		Scanner teclado = new Scanner(System.in);

		// Pedimos el numero
		System.out.println("Introduce un número y se mostrarán todos sus divisiores impares: ");
		numeroEntrada = teclado.nextInt();

		// el bucle se ejecutará mientras que i sea menor o igual que numEntrada
		while (i <= numeroEntrada) {
			// Si el numero se puede dividir por i e i no se puede dividir por 0, lo
			// mostramos por pantalla
			if (numeroEntrada % i == 0 && i % 2 != 0) {
				System.out.println("El número " + i + " es divisor de " + numeroEntrada + " y es impar");
			}
			// autoincremental
			i++;
		}
		// Cerrar teclado
		teclado.close();
	}
}
