package unidad2;

import java.util.Scanner;

public class PRACTICA7BEJERCICIO1 {

	// constantes
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

		// Explicamos el programa
		System.out.println("Introduce el mes y se dirá el número de días que tiene");
		// Iniciamos el escáner
		Scanner teclado = new Scanner(System.in);
		// pedimos el valor de mes
		System.out.println("Introduce el número del mes: ");
		mes = teclado.nextInt();

		// Los mes que tienen 31
		if (mes == ENERO || mes == MARZO || mes == MAYO || mes == JULIO || mes == AGOSTO || mes == OCTUBRE
				|| mes == DICIEMBRE) {
			System.out.println("Los días del mes " + mes + " son 31");
		} else if (mes == ABRIL || mes == JUNIO || mes == SEPTIEMBRE || mes == NOVIEMBRE) {
			// Meses que tienen 30
			System.out.println("Los días del mes " + mes + " son 30");
		} else if (mes == FEBRERO) {
			// preguntamos si es bisiesto
			System.out.println("¿Es bisiesto? (Sí= 1; No= 0): ");
			bisiesto = teclado.nextInt();
			// Si lo es
			if (bisiesto == 1) {
				System.out.println("Los días del mes " + mes + " son 29");
			} else {
				// si no lo es
				System.out.println("Los días del mes " + mes + " son 28");
			}
		} else {
			// En caso de numero invalido
			System.out.println("Ese mes no existe");
		}
		// cerramos teclado
		teclado.close();
	}

}
