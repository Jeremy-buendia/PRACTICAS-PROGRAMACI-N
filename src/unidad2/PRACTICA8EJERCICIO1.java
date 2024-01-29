package unidad2;

public class PRACTICA8EJERCICIO1 {
	public static void main(String[] args) {
		// variables
		int tirada1jug1 = 0;
		int tirada2jug1 = 0;
		int tirada3jug1 = 0;
		int tirada1jug2 = 0;
		int tirada2jug2 = 0;
		int tirada3jug2 = 0;
		int puntuacionJugador1 = 0;
		int puntuacionJugador2 = 0;
		boolean parejajug1 = false;
		boolean parejajug2 = false;
		boolean trioJug1 = false;
		boolean trioJug2 = false;

		// Hacemos la tirada del jugador1.
		tirada1jug1 = (int) (Math.random() * 6) + 1;
		tirada2jug1 = (int) (Math.random() * 6) + 1;
		tirada3jug1 = (int) (Math.random() * 6) + 1;

		// Comprobamos si ha sacado trío
		if (tirada1jug1 == tirada2jug1 && tirada1jug1 == tirada3jug1) {
			trioJug1 = true;
		} else if (tirada1jug1 == tirada2jug1 || tirada1jug1 == tirada3jug1 || tirada2jug1 == tirada3jug1) {
			// Comprobamos si ha sacado pareja
			parejajug1 = true;
		} else {
			// Sumamos las tiradas
			puntuacionJugador1 = tirada1jug1 + tirada2jug1 + tirada3jug1;
		}

		// Hacemos la tirada del jugador2.
		tirada1jug2 = (int) (Math.random() * 6) + 1;
		tirada2jug2 = (int) (Math.random() * 6) + 1;
		tirada3jug2 = (int) (Math.random() * 6) + 1;

		// Comprobamos si ha sacado trío
		if (tirada1jug2 == tirada2jug2 && tirada1jug2 == tirada3jug2) {
			trioJug2 = true;
		} else if (tirada1jug2 == tirada2jug2 || tirada1jug2 == tirada3jug2 || tirada2jug2 == tirada3jug2) {
			// Comprobamos si ha sacado pareja
			parejajug2 = true;
		} else {
			// Sumamos las tiradas
			puntuacionJugador2 = tirada1jug2 + tirada2jug2 + tirada3jug2;
		}

		// Comprobamos si los dos han sacado trio, si no, si alguno ha sacado trio, si
		// no, si los dos han sacado pareja, si no, si alguno ha sacado pareja, y si no,
		// vemos quien suma mas

		if (trioJug1 && trioJug2) {
			// Comprobamos el caso de doble trio
			if (tirada1jug1 > tirada1jug2) {
				System.out.println("Los dos han sacado trio, pero el trio del jugador 1 es mayor");
			} else if (tirada1jug1 < tirada1jug2) {
				System.out.println("Los dos han sacado trio, pero el trio del jugador 2 es mayor");
			} else {
				System.out.println("Los dos jugadores han sacado el mismo trío quedando empate");
			}
		} else if (trioJug1) {
			System.out.println("El jugador 1 ha ganado sacando trío");
		} else if (trioJug2) {
			System.out.println("El jugador 2 ha ganado sacando trío");
		} else if (parejajug1 && parejajug2) {
			// Comprobamos el caso de doble pareja, ganará quien tenga la pareja mayor
			if (tirada1jug1 > tirada1jug2 && tirada2jug1 > tirada2jug2
					|| tirada2jug1 > tirada2jug2 && tirada3jug1 > tirada3jug2
					|| tirada1jug1 > tirada1jug2 && tirada3jug1 > tirada3jug2) {
				System.out.println("Los dos han sacado pareja, pero la pareja del jugador 1 es mayor");
			} else if (tirada1jug1 < tirada1jug2 && tirada2jug1 < tirada2jug2
					|| tirada2jug1 < tirada2jug2 && tirada3jug1 < tirada3jug2
					|| tirada1jug1 < tirada1jug2 && tirada3jug1 < tirada3jug2) {
				System.out.println("Los dos han sacado pareja, pero la pareja del jugador 2 es mayor");
			} else {
				// En caso de que los dos tengan la misma pareja ganará quien tenga mayor el
				// otro numero
				if (tirada1jug1 > tirada1jug2 || tirada1jug1 > tirada2jug2 || tirada1jug1 > tirada3jug2
						|| tirada2jug1 > tirada1jug2 || tirada2jug1 > tirada2jug2 || tirada2jug1 > tirada3jug2
						|| tirada3jug1 > tirada1jug2 || tirada3jug1 > tirada2jug2 || tirada3jug1 > tirada3jug2) {
					System.out.println("Los dos han sacado la misma pareja, pero la puntuación del jugador 1 es mayor");
				} else if (tirada1jug1 < tirada1jug2 || tirada1jug1 < tirada2jug2 || tirada1jug1 < tirada3jug2
						|| tirada2jug1 < tirada1jug2 || tirada2jug1 < tirada2jug2 || tirada2jug1 < tirada3jug2
						|| tirada3jug1 < tirada1jug2 || tirada3jug1 < tirada2jug2 || tirada3jug1 < tirada3jug2) {
					System.out.println("Los dos han sacado la misma pareja, pero la puntuación del jugador 2 es mayor");
				} else {
					// Los dos tienen exactamente los mismos números teniendo pareja
					System.out.println(
							"Los dos jugadores han sacado las mismas parejas y el mismo número quedando empate");
				}
			}

		} else if (parejajug1) {
			System.out.println("El jugador 1 ha ganado sacando pareja");
		} else if (parejajug2) {
			System.out.println("El jugador 2 ha ganado sacando pareja");
		} else {
			// En caso de que no haya ni trio ni pareja
			if (puntuacionJugador1 > puntuacionJugador2) {
				System.out.println("La tirada del jugador 1 suma " + puntuacionJugador1 + " y la del jugador 2 suma "
						+ puntuacionJugador2 + ". Ha ganado el jugador 1");
			} else if (puntuacionJugador1 < puntuacionJugador2) {
				System.out.println("La tirada del jugador 1 suma " + puntuacionJugador1 + " y la del jugador 2 suma "
						+ puntuacionJugador2 + ". Ha ganado el jugador 2");
			} else {
				// En caso de empate sin trio ni pareja
				System.out.println("Los dos jugadores han quedado empate sin sacar trio ni pareja");
			}
		}

	}
}
