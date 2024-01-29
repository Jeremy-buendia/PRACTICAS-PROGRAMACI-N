package unidad3;

public class Raza {
	// Variables de raza
	private String nombre;
	private String descripcion;
	private int altura;
	private String pelo;
	private String piel;
	private String zona;

	/**
	 * Constructor vacío que da valores aleatorios de Raza
	 */
	public Raza() {
		super();
		this.nombre = "raza " + (int) Math.random() * 10;
		this.descripcion = "descripción de " + this.nombre;
		this.altura = (int) (Math.random() * 81) + 100;
		this.pelo = "pelo " + (int) (Math.random() * 10);
		this.piel = "piel " + (int) (Math.random() * 4);
		this.zona = "continente " + (int) (Math.random() * 6);
	}

	/**
	 * Constructor de Raza
	 * 
	 * @param nombre
	 * @param descripcion
	 * @param altura
	 * @param pelo
	 * @param piel
	 * @param zona
	 */
	public Raza(String nombre, String descripcion, int altura, String pelo, String piel, String zona) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.altura = altura;
		this.pelo = pelo;
		this.piel = piel;
		this.zona = zona;
	}

	// Métodos get y set
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public String getPelo() {
		return pelo;
	}

	public void setPelo(String pelo) {
		this.pelo = pelo;
	}

	public String getPiel() {
		return piel;
	}

	public void setPiel(String piel) {
		this.piel = piel;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	// Método ToString
	@Override
	public String toString() {
		return "Raza [nombre=" + nombre + ", descripcion=" + descripcion + ", altura=" + altura + ", pelo=" + pelo
				+ ", piel=" + piel + ", zona=" + zona + "]";
	}

}
