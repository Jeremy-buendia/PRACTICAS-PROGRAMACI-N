package unidad2;

import java.util.Scanner;

public class PRACTICA6EJERCICIO2 {

	public static void main(String[] args) {
		// variables
		int n = 0;
		int d = 0;
		long resultado = 1;

		// Inicializamos el scanner
		Scanner teclado = new Scanner(System.in);

		// Pedimos los números
		System.out.println(
				"Se pedirán un número para saber hasta donde hacer la multiplicación y otro para hacer saltos de posiciones.");
		System.out.println("Número hasta el que se hará la multiplicación: ");
		n = teclado.nextInt();

		System.out.println("Introduce el número que realizará saltos de posiciones: ");
		d = teclado.nextInt();

		// El bucle se ejecutará siempre que i sea menor o igual que n. Incrementamos i
		// con d.
		for (int i = 1; i <= n; i += d) {
			// Multiplicamos el resultado por el valor de i
			resultado = resultado * i;
		}

		// Mostramos en pantalla
		System.out.println("El resultado de multiplicar el número dando los saltos es " + resultado);

		teclado.close();
	}

}
