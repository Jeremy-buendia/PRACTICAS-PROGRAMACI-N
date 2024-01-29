package unidad2;

import java.util.Scanner;

public class PRACTICA10EJERCICIO1 {
	public static void main(String[] args) {
		// variables
		int edad = 0;
		char casadoChar;
		boolean esCasado = false;
		char sexo;
		String comAutonoma = "";
		int numeroHijos = 0;
		double sueldoAnual = 0.0;
		double ayuda = 0.0;

		System.out.println("Se pedirán una serie de datos y con ellos ");
		// Inicializamos el Scanner
		Scanner teclado = new Scanner(System.in);

		// toma de datos
		System.out.println("Introduce la edad: ");
		edad = teclado.nextInt();
		System.out.println("Introduce si está casado (S/N): ");
		casadoChar = teclado.next().toUpperCase().charAt(0);
		// Si casadoChar es igual a S, formateamos la variable esCasado a true
		esCasado = casadoChar == 'S' ? true : false;

		System.out.println("Introduce el sexo (H -> Hombre, M-> Mujer): ");
		sexo = teclado.next().toUpperCase().charAt(0);

		teclado.nextLine();

		System.out.println("Introduce tu comunidad autónoma: ");
		comAutonoma = teclado.nextLine();
		System.out.println("Introduce el número de hijos: ");
		numeroHijos = teclado.nextInt();
		System.out.println("Introduce tu sueldo anual: ");
		sueldoAnual = teclado.nextDouble();

		// Comprobamos el primer caso
		if (comAutonoma.equals("Pais Vasco") || comAutonoma.equals("Valencia")
				|| sueldoAnual > 60000 && numeroHijos >= 2) {
			ayuda = sueldoAnual * 0.12;
			// Plus1
			if (esCasado && numeroHijos > 3) {
				ayuda += 1200;
			}
			// Plus2
			if (numeroHijos > 5) {
				ayuda += 2000;
			}
		} else if (comAutonoma.equals("Cantabria") || comAutonoma.equals("Andalucia") || comAutonoma.equals("Madrid")) {
			// Segundo Caso
			if (sexo == 'M' && sueldoAnual >= 45000 && sueldoAnual <= 55000) {
				ayuda = sueldoAnual * 0.13;
				// Plus 1
				if (esCasado && numeroHijos > 3) {
					ayuda += 1200;
				}
				// Plus 2
				if (numeroHijos > 5) {
					ayuda += 2000;
				}
			}
		}
		// Lo mostramos en pantalla
		System.out.println("Tu ayuda anual es de " + ayuda + "€.");

		// cerramos teclado
		teclado.close();

	}
}
