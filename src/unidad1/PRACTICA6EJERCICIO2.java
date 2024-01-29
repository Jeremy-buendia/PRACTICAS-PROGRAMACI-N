package unidad1;

import java.util.Scanner;

public class PRACTICA6EJERCICIO2 {

	public static void main(String[] args) {
		//Incializamos las variables
		int base = 0;
		int altura = 0;
		int area = 0;
		
		System.out.println("Dada la base y altura de un triángulo se calculará su área");
		
		//Creamos un objeto Scanner que lea el teclado
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce la base del triángulo: ");
		
		base = teclado.nextInt();
		
		System.out.println("Introduce la altura del triángulo: ");
		
		altura = teclado.nextInt();
		
		//Cerramos el Scanner
		teclado.close();
		
		//Calculamos el area
		area = base * altura / 2;
		
		//mostramos por pantalla
		System.out.println("El área del triángulo es " + area);
	}

}
