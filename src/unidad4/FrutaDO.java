package unidad4;

public class FrutaDO {
	private int idFruta;
	private String nombre;
	private int danio;
	private int puntosRec;
	private String tipo;

	public int getIdFruta() {
		return idFruta;
	}

	public void setIdFruta(int idFruta) {
		this.idFruta = idFruta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDanio() {
		return danio;
	}

	public void setDanio(int danio) {
		this.danio = danio;
	}

	public int getPuntosRec() {
		return puntosRec;
	}

	public void setPuntosRec(int puntosRec) {
		this.puntosRec = puntosRec;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public FrutaDO(int idFruta, String nombre, int danio, int puntosRec, String tipo) {
		super();
		this.idFruta = idFruta;
		this.nombre = nombre;
		this.danio = danio;
		this.puntosRec = puntosRec;
		this.tipo = tipo;
	}

	public FrutaDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "frutaDO [idFruta=" + idFruta + ", nombre=" + nombre + ", danio=" + danio + ", puntosRec=" + puntosRec
				+ ", tipo=" + tipo + "]";
	}

}
