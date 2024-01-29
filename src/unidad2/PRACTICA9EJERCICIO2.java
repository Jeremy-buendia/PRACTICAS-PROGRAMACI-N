package unidad2;

public class PRACTICA9EJERCICIO2 {

	public static final int TAM_MAPA = 8;
	public static final char TOWN = 'T';
	public static final char ROAD = 'R';
	public static final char MALDITO = 'D';
	public static final char MONSTRUO = 'M';

	public static void main(String[] args) {
		// Variables
		int numCiudades = 0;
		int numMonstruos = 0;
		int posicionX = 0;
		int posicionY = 0;
		boolean estaConectado = false;
		boolean segundaComprobacion = true;
		int posibilidadDesconexion = 0;

		// Mapa del reino
		char mapa[][] = { { MALDITO, MONSTRUO, MALDITO, TOWN, ROAD, TOWN, MALDITO, MALDITO, },
				{ MALDITO, MALDITO, MALDITO, ROAD, MALDITO, MALDITO, MALDITO, MALDITO, },
				{ TOWN, ROAD, TOWN, ROAD, ROAD, TOWN, ROAD, TOWN, },
				{ ROAD, MALDITO, MALDITO, MONSTRUO, MALDITO, MALDITO, MALDITO, ROAD, },
				{ ROAD, MALDITO, MALDITO, ROAD, MALDITO, MALDITO, MALDITO, ROAD, },
				{ TOWN, ROAD, ROAD, ROAD, ROAD, ROAD, ROAD, TOWN, },
				{ MONSTRUO, MALDITO, MALDITO, ROAD, MALDITO, MALDITO, MALDITO, MALDITO, },
				{ MALDITO, MALDITO, MALDITO, TOWN, MALDITO, MALDITO, MALDITO, MALDITO } };

		// Bucle que recorre todo el array
		for (int i = 0; i < TAM_MAPA; i++) {
			for (int j = 0; j < TAM_MAPA; j++) {
				if (mapa[i][j] == TOWN) {
					// Si encuentra una ciudad, aumenta 1 al contador de ciudades
					++numCiudades;
					// Comprobamos si la ciudad tiene algun camino a su lado
					if (i < TAM_MAPA - 1) {
						if (mapa[i + 1][j] == ROAD || mapa[i + 1][j] == MONSTRUO) {
							// Si en esa dirección hay camino guardamos la posicion
							posicionX = i + 1;
							posicionY = j;
						}
					} else {
						// Si no tiene en esta dirección, sumamos 1 al contador
						posibilidadDesconexion++;
					}
					if (i > 0) {
						if (mapa[i - 1][j] == ROAD || mapa[i - 1][j] == MONSTRUO) {
							// Si en esa dirección hay camino guardamos la posicion
							posicionX = i - 1;
							posicionY = j;
						}
					} else {
						// Si no tiene en esta dirección, sumamos 1 al contador
						posibilidadDesconexion++;
					}
					if (j < TAM_MAPA - 1) {
						if (mapa[i][j + 1] == ROAD || mapa[i][j + 1] == MONSTRUO) {
							// Si en esa dirección hay camino guardamos la posicion
							posicionX = i;
							posicionY = j + 1;
						}
					} else {
						// Si no tiene en esta dirección, sumamos 1 al contador
						posibilidadDesconexion++;
					}
					if (j > 0) {
						if (mapa[i][j - 1] == ROAD || mapa[i][j - 1] == MONSTRUO) {
							// Si en esa dirección hay camino guardamos la posicion
							posicionX = i;
							posicionY = j - 1;
						}
					} else {
						// Si no tiene en esta dirección, sumamos 1 al contador
						posibilidadDesconexion++;
					}
				}

				// Si el contador posibilidadDesconexion llega a cuatro, significa que la ciudad
				// no tiene ningun camino conectado
				if (posibilidadDesconexion >= 4) {
					// No pasa la doble comprobación
					segundaComprobacion = false;
				} else {
					// Si pasa la pasa, reiniciamos contador
					posibilidadDesconexion = 0;
				}

				if (mapa[i][j] == ROAD || mapa[i][j] == MONSTRUO) {
					// Comprobamos si un camino está conectado
					if (i < TAM_MAPA - 1) {
						if (mapa[i + 1][j] == ROAD || mapa[i + 1][j] == MONSTRUO) {
							// Si lo está, guardamos su posición
							posicionX = i + 1;
							posicionY = j;
							// Comprobamos que no tenga terreno maldito detrás
							if (i > 0 && mapa[i - 1][j] == MALDITO) {
								segundaComprobacion = false;
							}
						}
					} else if (i < TAM_MAPA - 1 && mapa[i + 1][j] != TOWN) {
						// Si no está conectado a esta dirección, sumamos 1 al contador
						posibilidadDesconexion++;
					}

					if (i > 0) {
						if (mapa[i - 1][j] == ROAD || mapa[i - 1][j] == MONSTRUO) {
							// Si está conectado, guardamos su posición
							posicionX = i - 1;
							posicionY = j;
							if (i < TAM_MAPA - 1 && mapa[i + 1][j] == MALDITO) {
								// Comprobamos que no tenga terreno maldito detrás
								segundaComprobacion = false;
							}
						}
					} else if (i > 0 && mapa[i - 1][j] != TOWN) {
						// Si no está conectado a esta dirección, sumamos 1 al contador
						posibilidadDesconexion++;
					}

					if (j < TAM_MAPA - 1) {
						if (mapa[i][j + 1] == ROAD || mapa[i][j + 1] == MONSTRUO) {
							// Si está conectado, guardamos su posición
							posicionX = i;
							posicionY = j + 1;
							if (j > 0 && mapa[i][j - 1] == MALDITO) {
								// Comprobamos que no tenga terreno maldito detrás
								segundaComprobacion = false;
							}
						}
					} else if (j < TAM_MAPA - 1 && mapa[i][j + 1] != TOWN) {
						// Si no está conectado a esta dirección, sumamos 1 al contador
						posibilidadDesconexion++;
					}

					if (j > 0) {
						if (mapa[i][j - 1] == ROAD || mapa[i][j - 1] == MONSTRUO) {
							// Si está conectado, guardamos su posicion
							posicionX = i;
							posicionY = j - 1;
							if (j > TAM_MAPA && mapa[i][j + 1] == MALDITO) {
								// Si no está conectado a esta dirección, sumamos 1 al contador
								segundaComprobacion = false;
							}
						}
					} else if (j > 0 && mapa[i][j - 1] != TOWN) {
						// Si no está conectado a esta dirección, sumamos 1 al contador
						posibilidadDesconexion++;
					}

					if (mapa[i][j] == ROAD && posibilidadDesconexion == 1 && mapa[i][0] != ROAD && posicionX != 0) {
						// Si el contador de desconexion es 1, puede ser porque esté en una
						// interseccion,
						// pero aún así puede estar desconectado. Si tiene un solo contacto con tierra
						// maldita
						// entonces está desconectado
						if (mapa[i + 1][j] == MALDITO) {
							segundaComprobacion = false;
						} else if (mapa[i - 1][j] == MALDITO) {
							segundaComprobacion = false;
						} else if (j < TAM_MAPA - 1 && mapa[i][j + 1] == MALDITO) {
							segundaComprobacion = false;
						} else if (mapa[i][j - 1] == MALDITO) {
							segundaComprobacion = false;
						}
					}

					// Lo mismo que antes, pero si hay un monstruo en el camino
					if (mapa[i][j] == MONSTRUO && posibilidadDesconexion == 1 && mapa[i][0] != ROAD && posicionX != 0) {
						if (mapa[i + 1][j] == MALDITO) {
							segundaComprobacion = false;
						} else if (mapa[i - 1][j] == MALDITO) {
							segundaComprobacion = false;
						} else if (j < TAM_MAPA - 1 && mapa[i][j + 1] == MALDITO) {
							segundaComprobacion = false;
						} else if (mapa[i][j - 1] == MALDITO) {
							segundaComprobacion = false;
						}
					}

					// Si la posibilidad de Desconexion es 2 puede ser porque esté en un borde
					if (posibilidadDesconexion == 2) {
						posicionX = i;
						posicionY = j;
						if (posicionY == 0 || posicionY == TAM_MAPA - 1) {
							// Comprobamos su posición, si está en un borde y tiene 2 desconexiones,
							// entonces está desconectado
							posibilidadDesconexion++;
						}
					}

					// En caso de que tenga 3 o más desconexiones, está desconectado
					if (posibilidadDesconexion >= 3) {
						// Anulamos cualquier otra conexion
						segundaComprobacion = false;
					} else {
						// Si no, reiniciamos la posibilidad de Desconexion
						posibilidadDesconexion = 0;
					}

				}

				// Comprobamos que la última posicion guardada esté conectada con una ciudad
				if (posicionX == i - 1 && posicionY == j) {
					if (i < TAM_MAPA - 1 && mapa[i + 1][j] == TOWN) {
						estaConectado = true;
					}
				}
				if (posicionX == i && posicionY == j - 1) {
					if (i < TAM_MAPA - 1 && mapa[i + 1][j] == TOWN) {
						estaConectado = true;
					}
				}
				if (posicionX == i && posicionY == j + 1) {
					if (i < TAM_MAPA - 1 && mapa[i + 1][j] == TOWN) {
						estaConectado = true;
					}
				}
				if (posicionX == i + 1 && posicionY == j) {
					if (i < TAM_MAPA - 1 && mapa[i + 1][j] == TOWN) {
						estaConectado = true;
					}
				}
				// Contamos el número de monstruos
				if (mapa[i][j] == MONSTRUO) {
					++numMonstruos;
				}

			}
		}
		// Mostramos por pantalla los resultados del mapa
		if (numCiudades < numMonstruos) {
			System.out.println("No hay esperanzas");
		} else {
			System.out.println("Hay esperanzas");
		}

		if (estaConectado && segundaComprobacion) {
			System.out.println("Las ciudades están conectadas");
		} else {
			System.out.println("Las ciudades no están conectadas");
		}

	}
}
