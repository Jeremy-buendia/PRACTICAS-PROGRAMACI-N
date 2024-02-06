package unidad3;

public class Organo {
	// constantes
	public final static int SANO = 1;
	public final static int DOLOR = 2;
	public final static int PERJUDICADO = 3;
	public final static int CANCERIGENO = 4;

	public final static int CABEZA = 1;
	public final static int TRONCO_SUPERIOR = 2;
	public final static int TRONCO_INFERIOR = 3;

	public final static int VITAL = 1;
	public final static int BASICA = 2;
	public final static int SECUNDARIA = 3;

	public final static int ACTIVO = 1;
	public final static int NO_ACTIVO = 2;

	public final static int CEREBRO = 1;
	public final static int CORAZON = 2;
	public final static int PULMON_IZQ = 3;
	public final static int PULMON_DER = 4;
	public final static int RIÑON_IZQ = 5;
	public final static int RIÑON_DER = 6;
	public final static int ESTOMAGO = 7;
	public final static int OIDO = 8;

	// variables
	private String nombre;
	private String funcion;
	private int estado;
	private double peso;
	private int posicion;
	private int importancia;
	private String imagen;
	public boolean activo;

	/**
	 * Función que comprueba que el órgano está en la posición adecuada y su
	 * importancia
	 * 
	 * @return true o false
	 */
	public boolean revision() {
		if (nombre.equals("Cerebro") && posicion == CABEZA && importancia == VITAL) {
			return true;
		}
		if (nombre.equals("Corazon") && posicion == TRONCO_SUPERIOR && importancia == VITAL) {
			return true;
		}
		if (nombre.equals("Pulmon derecho") && posicion == TRONCO_SUPERIOR && importancia == VITAL) {
			return true;
		}
		if (nombre.equals("Pulmon izquierdo") && posicion == TRONCO_SUPERIOR && importancia == VITAL) {
			return true;
		}
		if (nombre.equals("Riñon derecho") && posicion == TRONCO_INFERIOR && importancia == BASICA) {
			return true;
		}
		if (nombre.equals("Riñon izquierdo") && posicion == TRONCO_INFERIOR && importancia == BASICA) {
			return true;
		}
		if (nombre.equals("Estomago") && posicion == TRONCO_INFERIOR && importancia == SECUNDARIA) {
			return true;
		}
		if (nombre.equals("Oido") && posicion == CABEZA && importancia == SECUNDARIA) {
			return true;
		}
		return false;
	}

	/**
	 * Función que comprueba si el órgano dado tiene cáncer, está perjudicado, o
	 * esta en los valores correctos de peso
	 * 
	 * @param tipoAnalisis
	 * @return true o false
	 */
	public boolean analisis(int tipoAnalisis) {
		// Análisis para ver si tiene cáncer
		if (tipoAnalisis == 1) {
			if (this.estado == CANCERIGENO) {
				return true;
			}
			return false;
		}
		// Análisis para ver si está perjudicado
		if (tipoAnalisis == 2) {
			if (this.estado == PERJUDICADO) {
				return true;
			}
			return false;
		}
		// Análisis de peso
		if (tipoAnalisis == 3) {
			if (this.peso > 200 && this.peso < 1000) {
				return true;
			}
			return false;
		}
		return false;
	}

	/**
	 * Método constructor vacío que da valores aleatorios de Organo
	 */
	public Organo() {
		switch ((int) ((Math.random() * 8) + 1)) {
		case CEREBRO:
			this.nombre = "Cerebro";
			this.funcion = "Pensamiento, emoción, conducta, movimiento y sensación";
			this.posicion = CABEZA;
			this.importancia = VITAL;
			break;
		case CORAZON:
			this.nombre = "Corazon";
			this.funcion = "Circulación de la sangre";
			this.posicion = TRONCO_SUPERIOR;
			this.importancia = VITAL;
			break;
		case PULMON_IZQ:
			this.nombre = "Pulmon izquierdo";
			this.funcion = "Respiración";
			this.posicion = TRONCO_SUPERIOR;
			this.importancia = VITAL;
			break;
		case PULMON_DER:
			this.nombre = "Pulmon derecho";
			this.funcion = "Respiración";
			this.posicion = TRONCO_SUPERIOR;
			this.importancia = VITAL;
			break;
		case RIÑON_IZQ:
			this.nombre = "Riñon izquierdo";
			this.funcion = "Eliminar desechos";
			this.posicion = TRONCO_INFERIOR;
			this.importancia = BASICA;
			break;
		case RIÑON_DER:
			this.nombre = "Riñon derecho";
			this.funcion = "Eliminar desechos";
			this.posicion = TRONCO_INFERIOR;
			this.importancia = BASICA;
			break;
		case ESTOMAGO:
			this.nombre = "Estomago";
			this.funcion = "Procesar alimentos";
			this.posicion = TRONCO_INFERIOR;
			this.importancia = SECUNDARIA;
			break;
		case OIDO:
			this.nombre = "Oido";
			this.funcion = "Audición";
			this.posicion = CABEZA;
			this.importancia = SECUNDARIA;
			break;
		}

		this.estado = (int) (Math.random() * 4) + 1;
		this.peso = (int) ((Math.random() * 801) + 200);
		this.imagen = "ruta de imagen";
		this.activo = false;
	}

	/**
	 * Método Constructor de Organo
	 * 
	 * @param nombre
	 * @param funcion
	 * @param estado
	 * @param peso
	 * @param posicion
	 * @param importancia
	 * @param imagen
	 * @param activo
	 */
	public Organo(String nombre, String funcion, int estado, double peso, int posicion, int importancia, String imagen,
			boolean activo) {
		super();
		this.nombre = nombre;
		this.funcion = funcion;
		this.estado = estado;
		this.peso = peso;
		this.posicion = posicion;
		this.importancia = importancia;
		this.imagen = imagen;
		this.activo = activo;
	}

	// Métodos get y set de Organo
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFuncion() {
		return funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public int getImportancia() {
		return importancia;
	}

	public void setImportancia(int importancia) {
		this.importancia = importancia;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	// Método toString de la clase Organo
	@Override
	public String toString() {
		return "Organo [nombre=" + nombre + ", funcion=" + funcion + ", estado=" + estado + ", peso=" + peso
				+ ", posicion=" + posicion + ", importancia=" + importancia + ", imagen=" + imagen + ", activo="
				+ activo + "]";
	}

}
