package unidad2;

import java.util.Scanner;

public class PRACTICA9EJERCICIO1 {
	public static void main(String[] args) {
		// variables
		String entradaSistInter = "";
		String valorSistInterStr = "";
		double valorSistInterDouble = 0.0;
		char unidadSistInter;
		String unidadSistImp = "";
		double valorSistImper = 0.0;

		System.out.println(
				"Introduce el valor de la distancia seguido de la unidad y se hará la conversión al sistema imperial: ");

		// Pedimos la distancia y la unidad y las almacenamos
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce la distancia en metros (m), hectómetro (h) o kilómetro (k): ");
		entradaSistInter = teclado.nextLine();

		// pasamos a minuscula
		entradaSistInter = entradaSistInter.toLowerCase();
		// Cogemos la unidad de entrada
		unidadSistInter = entradaSistInter.charAt(entradaSistInter.length() - 1);
		// Cogemos la cantidad de entrada
		valorSistInterStr = entradaSistInter.substring(0, (entradaSistInter.length() - 1));
		// Lo pasamos a Double
		valorSistInterDouble = Double.parseDouble(valorSistInterStr);

		// Pedimos a que unidad del Sistema Imperial lo quiere pasar
		System.out.println(
				"Introduce a que medida del Sistema Imperial quiere pasar dicha distancia(millas, yardas, pies, pulgadas): ");
		unidadSistImp = teclado.nextLine();
		// Lo pasamos a minuscula
		unidadSistImp = unidadSistImp.toLowerCase();

		// Si lo quiere a millas
		if (unidadSistImp.equals("millas")) {
			if (unidadSistInter == 'm') {
				// y lo tenía en metros
				valorSistImper = valorSistInterDouble / 1609;
			} else if (unidadSistInter == 'h') {
				// y lo tenía en hectometros
				valorSistImper = valorSistInterDouble / 16.093;
			} else if (unidadSistInter == 'k') {
				// y lo tenía en kilometros
				valorSistImper = valorSistInterDouble / 1.609;
			}
			System.out.println(entradaSistInter + " son " + valorSistImper + " millas");
		} else if (unidadSistImp.equals("yardas")) {
			// Si lo quería en yardas
			if (unidadSistInter == 'm') {
				// y lo tenía en metros
				valorSistImper = valorSistInterDouble * 1.094;
			} else if (unidadSistInter == 'h') {
				// y lo tenía en hectometros
				valorSistImper = valorSistInterDouble / 109.4;
			} else if (unidadSistInter == 'k') {
				// y lo tenía en kilometros
				valorSistImper = valorSistInterDouble * 1094;
			}
			System.out.println(entradaSistInter + " son " + valorSistImper + " yardas");
		} else if (unidadSistImp.equals("pies")) {
			// Si lo quería en pies
			if (unidadSistInter == 'm') {
				// y lo tenía en metros
				valorSistImper = valorSistInterDouble * 3.281;
			} else if (unidadSistInter == 'h') {
				// y lo tenía en hectometros
				valorSistImper = valorSistInterDouble / 328.1;
			} else if (unidadSistInter == 'k') {
				// y lo tenía en kilometros
				valorSistImper = valorSistInterDouble * 3281;
			}
			System.out.println(entradaSistInter + " son " + valorSistImper + " pies");
		} else if (unidadSistImp.equals("pulgadas")) {
			// Si lo quería en pulgadas
			if (unidadSistInter == 'm') {
				// y lo tenía en metros
				valorSistImper = valorSistInterDouble * 39.37;
			} else if (unidadSistInter == 'h') {
				// y lo tenía en hectometros
				valorSistImper = valorSistInterDouble / 3927;
			} else if (unidadSistInter == 'k') {
				// y lo tenía en kilometros
				valorSistImper = valorSistInterDouble * 39370;
			}
			// Lo mostramos en pantalla
			System.out.println(entradaSistInter + " son " + valorSistImper + " pulgadas");
		}
		// Cerramos teclado
		teclado.close();

	}
}
