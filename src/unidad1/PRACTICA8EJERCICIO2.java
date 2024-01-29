package unidad1;

import java.util.Scanner;

public class PRACTICA8EJERCICIO2 {
	public static void main(String[] arg){
		//Declaramos variables
		int a, b, c;
		double resultado1;
		double resultado2;
		
		//Iniciamos el teclado
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Con los valores de A, B y C dados se calculará una ecuación de segundo grado");
		//Pedimos los valores
		System.out.println("Introduce el valor de A: ");
		a = teclado.nextInt();
		System.out.println("Introduce el valor de B: ");
		b = teclado.nextInt();
		System.out.println("Introduce el valor de : ");
		c = teclado.nextInt();
		
		//fórmula
		resultado1 = (-b + Math.sqrt(b*b - 4 * a * c)) / 2 * a;
		resultado2 = (-b - Math.sqrt(b*b - 4 * a * c)) / 2 * a;
		
		//mostramos en pantalla
		System.out.println("El resultado es " + resultado1 + " y " + resultado2);
		
		//cerramos el Scanner
		teclado.close();
	}
}
