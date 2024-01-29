package unidad2;

import java.util.Scanner;

public class PRACTICA6EJERCICIO1 {
	// constantes
	public static final int LUNES = 1;
	public static final int MARTES = 2;
	public static final int MIERCOLES = 3;
	public static final int JUEVES = 4;
	public static final int VIERNES = 5;
	public static final int SABADO = 6;
	public static final int DOMINGO = 7;

	public static void main(String[] args) {
		// variables
		int numDia = 0;
		String dia = "";

		// pedimos el número del día y lo guardamos
		System.out.println("Introduce el número (1-7) y se mostrará el día: ");
		Scanner teclado = new Scanner(System.in);
		numDia = teclado.nextInt();

		// Con el switch dependiendo del numero del dia almacenado se dirá si es un dia
		// u otro
		switch (numDia) {
		case LUNES:
			dia = "Lunes";
			System.out.println("El día es " + dia);
			break;
		case MARTES:
			dia = "Martes";
			System.out.println("El día es " + dia);
			break;
		case MIERCOLES:
			dia = "Miércoles";
			System.out.println("El día es " + dia);
			break;
		case JUEVES:
			dia = "Jueves";
			System.out.println("El día es " + dia);
			break;
		case VIERNES:
			dia = "Viernes";
			System.out.println("El día es " + dia);
			break;
		case SABADO:
			dia = "Sábado";
			System.out.println("El día es " + dia);
			break;
		case DOMINGO:
			dia = "Domingo";
			System.out.println("El día es " + dia);
			break;
		default:
			System.out.println("introduce un dia valido");
			break;
		}

		// cerramos teclado
		teclado.close();
	}

}
