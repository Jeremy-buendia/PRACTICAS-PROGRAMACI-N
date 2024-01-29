package unidad1;

import java.util.Scanner;

public class PRACTICA7EJERCICIO2 {
	public static void main(String[] arg){
		//Inicializamos las variables
		double sueldoBruto = 0.0;
		double impuesto = 0.0;
		double resultado = 0.0;
		
		//Añadimos el Scanner para leer el teclado
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce tu sueldo bruto: ");
		sueldoBruto = teclado.nextDouble();
		System.out.println("Introduce el porcentaje de impuestos: ");
		impuesto = teclado.nextDouble();
		//Al porcentaje lo dividimos entre 100 para posteriormente aplicarlo en la formula
		impuesto /= 100;
		
		//formula
		resultado = sueldoBruto - (sueldoBruto * impuesto);
		//mostramos en pantalla
		System.out.println("Tu sueldo neto es " + resultado + "€");
		//cerramos el teclado
		teclado.close();
	}
}
