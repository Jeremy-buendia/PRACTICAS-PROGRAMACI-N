package unidad2;

import java.util.Scanner;

public class PRACTICA7AEJERCICIO1 {

	// Constantes
	public static final int ENERO = 1;
	public static final int FEBRERO = 2;
	public static final int MARZO = 3;
	public static final int ABRIL = 4;
	public static final int MAYO = 5;
	public static final int JUNIO = 6;
	public static final int JULIO = 7;
	public static final int AGOSTO = 8;
	public static final int SEPTIEMBRE = 9;
	public static final int OCTUBRE = 10;
	public static final int NOVIEMBRE = 11;
	public static final int DICIEMBRE = 12;

	public static void main(String[] args) {
		// variables
		int mes = 0;
		int bisiesto = 0;
		int dias = 0;

		// Explicamos el programa
		System.out.println("Introduce el mes y se dirá el número de días que tiene");
		// Iniciamos el escáner
		Scanner teclado = new Scanner(System.in);
		// pedimos el valor de mes
		System.out.println("Introduce el número del mes: ");
		mes = teclado.nextInt();

		// Dependiendo del valor de mes
		switch (mes) {
		case ENERO:
			dias = 31;
			break;
		case FEBRERO:
			// Si es bisiesto, lo preguntamos
			System.out.println("¿Es bisiesto? (Sí= 1; No= 0): ");
			bisiesto = teclado.nextInt();
			if (bisiesto == 1) {
				dias = 29;
			} else {
				dias = 28;
			}
			break;
		case MARZO:
			dias = 31;
			break;
		case ABRIL:
			dias = 30;
			break;
		case MAYO:
			dias = 31;
			break;
		case JUNIO:
			dias = 30;
			break;
		case JULIO:
			dias = 31;
			break;
		case AGOSTO:
			dias = 31;
			break;
		case SEPTIEMBRE:
			dias = 30;
			break;
		case OCTUBRE:
			dias = 31;
			break;
		case NOVIEMBRE:
			dias = 30;
			break;
		case DICIEMBRE:
			dias = 31;
			break;
		default:
			System.out.println("Ese mes no existe.");
			break;
		}
		System.out.println("Los días del mes " + mes + " son " + dias);
		// cerramos teclado
		teclado.close();
	}
}
