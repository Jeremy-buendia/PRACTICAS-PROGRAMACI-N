package unidad4.examen;

public class ClubGolfDO {
	private int idClubGolf;
	private String nombre;
	private String localidad;
	private int recordGolpes;
	private boolean Escuela;
	public int getIdClubGolf() {
		return idClubGolf;
	}
	public void setIdClubGolf(int idClubGolf) {
		this.idClubGolf = idClubGolf;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public int getRecordGolpes() {
		return recordGolpes;
	}
	public void setRecordGolpes(int recordGolpes) {
		this.recordGolpes = recordGolpes;
	}
	public boolean isEscuela() {
		return Escuela;
	}
	public void setEscuela(boolean escuela) {
		Escuela = escuela;
	}
	
	public ClubGolfDO(int idClubGolf, String nombre, String localidad, int recordGolpes, boolean escuela) {
		super();
		this.idClubGolf = idClubGolf;
		this.nombre = nombre;
		this.localidad = localidad;
		this.recordGolpes = recordGolpes;
		Escuela = escuela;
	}
	public ClubGolfDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ClubGolfDO [idClubGolf=" + idClubGolf + ", nombre=" + nombre + ", localidad=" + localidad
				+ ", recordGolpes=" + recordGolpes + ", Escuela=" + Escuela + "]";
	}
	
	
}
