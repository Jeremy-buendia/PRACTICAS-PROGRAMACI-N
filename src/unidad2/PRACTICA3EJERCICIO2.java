package unidad2;

public class PRACTICA3EJERCICIO2 {

	public static void main(String[] args) {
		// variables
		int x = 0;

		do {
			if (x % 4 == 0) {
				System.out.println(x + " es múltiplo de cuatro.");
			}
			// Si ponemos esto en vez de x++, el código ejecutará cuatro veces menos
			// instrucciones.
			x += 4;
		} while (x <= 100);

	}
}
