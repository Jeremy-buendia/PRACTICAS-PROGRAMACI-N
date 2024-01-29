package unidad3;

import java.util.Arrays;

public class Cuerpo {
	// Variables
	public static int numC = 0;
	private Organo[] organos = new Organo[8];
	private String nombre;
	private int edad;
	private double peso;
	private Raza raza;
	private String estado;

	/**
	 * Función que realiza un análisis oncológico a todos los órganos de un cuerpo
	 * 
	 * @return true o false
	 */
	public boolean oncologia() {
		// Bucle que recorre todos los órganos de la lista
		for (int i = 0; i < organos.length; i++) {
			// recurre a la función análisis con el índice uno para pasar la prueba de
			// cáncer a todos los órganos
			if (organos[i].analisis(1) == true) {
				// Si algún órgano tiene cáncer devuelve true
				return true;
			}
		}
		// Si ninguno tiene cancer devuelve false
		return false;
	}

	/**
	 * Función que realiza una cura a un órgano.
	 * 
	 * @param O
	 * @return El órgano introducido en estado sano o null
	 */
	public Organo cura(Organo O) {
		// Se le pasa la revisión
		if (O.revision() == true) {
			// Se le hace un análisis de cáncer
			if (O.analisis(1)) {
				// Se mira si está en el peso indicado
				if (O.analisis(3) == true) {
					// Si todo se cumple, tiene un 65% de probabilidades de curarse
					if ((int) (Math.random() * 100) <= 65) {
						// Cambia a sano el estado del órgano
						O.setEstado(Organo.SANO);
						// Devuelve el órgano
						return O;
					} else {
						// Si la probabilidad de curarse no sale devuelve null
						if (O.getImportancia() == Organo.VITAL) {
							// Si era un órgano vital el cuerpo muere
							this.estado = "MUERTO";
						}
						return null;
					}
				} else {
					// Si el órgano no está en peso devuelve null
					if (O.getImportancia() == Organo.VITAL) {
						// Si era un órgano vital el cuerpo muere
						this.estado = "MUERTO";
					}
					return null;
				}
			}
			// Se mira si el órgano está perjudicado
			if (O.analisis(2) == true) {
				// Si el órgano es Corazón o Cerebro devuelve null
				if (O.getNombre() == "Cerebro" || O.getNombre() == "Corazon") {
					// Al ser vital el cuerpo muere
					this.estado = "MUERTO";
					return null;
				} else {
					// Si el órgano es cualquier otro, tiene un 90% de probabilidades de curarse
					if ((int) (Math.random() * 100) <= 90) {
						// Si se cura, se cambia el estado a SANO y se devuelve el órgano
						O.setEstado(Organo.SANO);
						return O;
					} else {
						// si no se cura, se devuelve null
						if (O.getImportancia() == Organo.VITAL) {
							// Si era un órgano vital el cuerpo muere
							this.estado = "MUERTO";
						}
						return null;
					}
				}
			}
		}
		// Si la revisión no es true devuelve null
		return null;
	}

	/**
	 * Función que comprueba la viabilidad del transplante y si el resultado es
	 * favorable hará el transplante
	 * 
	 * @param O
	 * @return
	 */
	int transplante(Organo O) {
		// Boolean que determina si hemos encontrado un órgano al que hacerle el
		// transplante
		boolean organoEncontrado = false;
		// Bucle que recorre todos los organos
		for (int i = 0; i < organos.length; i++) {
			// Busca que el cuerpo tenga el mismo órgano para el transplante
			if (organos[i].getNombre() == O.getNombre()) {
				// Si lo encuentra, cambia a true la variable
				organoEncontrado = true;
				// Hace una revisión de los dos órganos
				if (organos[i].revision() == true && O.revision() == true) {
					// Si está correcto, comprueba si los dos órganos tienen cáncer
					if (O.analisis(1) == true && organos[i].analisis(1) == true) {
						// si lo tienen, el cuerpo muere
						this.estado = "MUERTO";
					}
					// Se comprueba si los dos órganos están perjudicados
					if (O.analisis(2) == true && organos[i].analisis(2) == true) {
						// si lo están, el cuerpo muere
						this.estado = "MUERTO";
					}
					// Comprueba que el órgano al que se le va a hacer el transplante tenga cáncer o
					// esté perjudicado
					if (organos[i].analisis(1) == true || organos[i].analisis(2) == true) {
					} else {
						// Si no se cumple devuelve -1
						return -1;
					}
					// Comprueba que el órgano a introducir no tenga cáncer, no esté perjudicado y
					// esté en peso
					if (O.analisis(1) == true || O.analisis(2) == true || O.analisis(3) == false) {
						// Si alguna falla en alguna devuelve -1
						return -1;
					}
					// Si todo está correcto, quita el órgano
					organos[i] = null;
					// Pone el órgano nuevo en la posición del antiguo
					organos[i] = O;
				} else {
					// Si la revisión no se cumple devuelve -1
					return -1;
				}
			}
		}
		// Si no se encuentra el órgano devuelve -1
		if (organoEncontrado == false) {
			return -1;
		}
		// Si todo ha salido bien delvuelve 0
		return 0;
	}

	/**
	 * Función que realiza una revisión general del cuerpo para ver que enfermedades
	 * tiene
	 * 
	 * @return Un array con las diferentes enfermedades
	 */
	int[] revisionGeneral() {
		// Variable para contar el número de enfermedades para saber cuanto médira el
		// array
		int numEnfermedades = 0;
		// Variables para guardar el estado de los órganos
		int estadoCerebro = 0;
		int estadoRiñonIzq = 0;
		int estadoOido = 0;
		int estadoRiñonDer = 0;
		int estadoPulmonIzq = 0;
		int estadoPulmonDer = 0;
		int estadoEstomago = 0;
		// Array con los códigos
		int[] codigos;
		// Bucle que recorre todos los órganos y va almacenando el estado de los mismos
		for (int i = 0; i < organos.length; i++) {
			if (organos[i].getNombre() == "Cerebro") {
				estadoCerebro = organos[i].getEstado();
			} else if (organos[i].getNombre() == "Riñon izquierdo") {
				estadoRiñonIzq = organos[i].getEstado();
			} else if (organos[i].getNombre() == "Riñon derecho") {
				estadoRiñonDer = organos[i].getEstado();
			} else if (organos[i].getNombre() == "Oido") {
				estadoOido = organos[i].getEstado();
			} else if (organos[i].getNombre() == "Pulmon derecho") {
				estadoPulmonDer = organos[i].getEstado();
			} else if (organos[i].getNombre() == "Pulmon izquierdo") {
				estadoPulmonIzq = organos[i].getEstado();
			} else if (organos[i].getNombre() == "Estomago") {
				estadoEstomago = organos[i].getEstado();
			}
		}

		// Condiciones que comprueban si el cuerpo tiene alguna enfermedad, si tiene
		// alguna, suma en uno la variable numEnfermedades
		if (estadoCerebro == Organo.DOLOR && estadoRiñonIzq == Organo.PERJUDICADO
				&& estadoRiñonDer == Organo.PERJUDICADO) {
			numEnfermedades++;
		}
		if (estadoOido == Organo.PERJUDICADO && estadoCerebro == Organo.PERJUDICADO) {
			numEnfermedades++;
		}
		if (estadoCerebro == Organo.DOLOR && estadoPulmonIzq == Organo.PERJUDICADO
				&& estadoPulmonDer == Organo.PERJUDICADO) {
			numEnfermedades++;
		}
		if (estadoCerebro == Organo.DOLOR && estadoEstomago == Organo.DOLOR && estadoPulmonDer == Organo.DOLOR
				&& estadoPulmonIzq == Organo.DOLOR) {
			numEnfermedades++;
		}
		if (oncologia()) {
			numEnfermedades++;
		}

		if (numEnfermedades != 0) {
			// Si tiene enfermedades, formateamos el array con numEnfermedades
			codigos = new int[numEnfermedades];
			// Creamos un contador para introducir los códigos dentro del array
			int contador = 0;

			if (estadoCerebro == Organo.DOLOR && estadoRiñonIzq == Organo.PERJUDICADO
					&& estadoRiñonDer == Organo.PERJUDICADO) {
				// Si tiene Malaria guardamos su código en el array y aumentamos en 1 el
				// contador
				codigos[contador] = 1;
				contador++;
			}
			if (estadoOido == Organo.PERJUDICADO && estadoCerebro == Organo.PERJUDICADO) {
				// Si tiene Parkinson guardamos su código en el array y aumentamos en 1 el
				// contador
				codigos[contador] = 2;
				contador++;
			}
			if (estadoCerebro == Organo.DOLOR && estadoPulmonIzq == Organo.PERJUDICADO
					&& estadoPulmonDer == Organo.PERJUDICADO) {
				// Si tiene Bronquitis guardamos su código en el array y aumentamos en 1 el
				// contador
				codigos[contador] = 3;
				contador++;
			}
			if (estadoCerebro == Organo.DOLOR && estadoEstomago == Organo.DOLOR && estadoPulmonDer == Organo.DOLOR
					&& estadoPulmonIzq == Organo.DOLOR) {
				// Si tiene Gripe guardamos su código en el array y aumentamos en 1 el
				// contador
				codigos[contador] = 4;
				contador++;
			}
			if (oncologia()) {
				// Si tiene Cáncer guardamos su código en el array y aumentamos en 1 el
				// contador
				codigos[contador] = 5;
				contador++;
			}
		} else {
			// Si no tiene ninuna enfermedad, hacemos que el array solo tenga una posición
			// que tendrá el código de Sano
			codigos = new int[1];
			codigos[0] = 6;
		}
		// Devolvemos la lista de códigos
		return codigos;
	}

	/**
	 * Constructor vacío de Cuerpo que da valores aleatorios
	 */
	public Cuerpo() {
		super();
		numC++;
		this.nombre = "cuerpo " + numC;
		this.edad = (int) (Math.random() * 100);
		this.peso = (Math.random() * 90) + 50;
		this.raza = new Raza();

		int valorAleatorio = (int) (Math.random() * 10);
		if (valorAleatorio > 0.2) {
			this.estado = "VIVO";
		} else if (valorAleatorio > 0.1) {
			this.estado = "COMA";
		} else {
			this.estado = "MUERTO";
		}

		for (int i = 0; i < organos.length; i++) {
			Organo organo = new Organo();
			organos[i] = organo;
		}
	}

	/**
	 * Constructor de Cuerpo
	 * 
	 * @param organos
	 * @param nombre
	 * @param edad
	 * @param peso
	 * @param raza
	 * @param estado
	 */
	public Cuerpo(Organo[] organos, String nombre, int edad, int peso, Raza raza, String estado) {
		super();
		this.numC++;
		this.organos = organos;
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.raza = raza;
		this.estado = estado;
	}

	// Métodos get y set de Cuerpo
	public Organo[] getOrganos() {
		return organos;
	}

	public void setOrganos(Organo[] organos) {
		this.organos = organos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public Raza getRaza() {
		return raza;
	}

	public void setRaza(Raza raza) {
		this.raza = raza;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	// Método toString de Cuerpo
	@Override
	public String toString() {
		return "Cuerpo [organos=" + Arrays.toString(organos) + ", nombre=" + nombre + ", edad=" + edad + ", peso="
				+ peso + ", raza=" + raza + ", estado=" + estado + "]";
	}

}
