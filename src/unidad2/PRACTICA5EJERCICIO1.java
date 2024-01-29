package unidad2;

import java.util.Scanner;

public class PRACTICA5EJERCICIO1 {
	public static void main(String[] args) {
		// variables
		int num1 = 0;
		int num2 = 0;
		int resultado = 0;

		// Pedimos los numeros y los almacenamos
		System.out.println("Dados dos números y un resultado se procederá a adivinar la operación realizada");
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el primer número: ");
		num1 = teclado.nextInt();
		System.out.println("Introduce el segundo número: ");
		num2 = teclado.nextInt();
		System.out.println("Introduce el resultado ");
		resultado = teclado.nextInt();

		// Comprobamos las operaciones
		if (resultado == num1 * num1 || resultado == num2 * num2) {
			// Potencia
			System.out.println("La operación es una potencia de 2");
		} else if (resultado == Math.sqrt(num1) || resultado == Math.sqrt(num2)) {
			// Raiz cuadrada
			System.out.println("La operación es una raíz cuadrada");
		} else if (resultado == num1 * num2) {
			// Multiplicacion
			System.out.println("La operación es una multiplicación");
		} else if (resultado == num1 / num2 || resultado == num2 / num1) {
			// division
			System.out.println("La operación es una división");
		} else if (resultado == num1 % num2 || resultado == num2 % num1) {
			// modulo
			System.out.println("La operación es un módulo");
		} else if (resultado == num1 + num2) {
			// suma
			System.out.println("La operación es una suma");
		} else if (resultado == num1 - num2) {
			// resta
			System.out.println("La operación es una resta");
		} else {
			// en caso contrario es indefinido
			System.out.println("La operación es indefinida");
		}
		// cerramos teclado
		teclado.close();

	}
}
