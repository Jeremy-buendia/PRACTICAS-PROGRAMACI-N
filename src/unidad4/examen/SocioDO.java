package unidad4.examen;

public class SocioDO {
	private int idSocio;
	private String nombre;
	private int edad;
	private int sexo;
	private int cuota;
	
	public int getIdSocio() {
		return idSocio;
	}
	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
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
	public int getSexo() {
		return sexo;
	}
	public void setSexo(int sexo) {
		this.sexo = sexo;
	}
	public int getCuota() {
		return cuota;
	}
	public void setCuota(int cuota) {
		this.cuota = cuota;
	}
	public SocioDO(int idSocio, String nombre, int edad, int sexo, int cuota) {
		super();
		this.idSocio = idSocio;
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.cuota = cuota;
	}
	public SocioDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SocioDO [idSocio=" + idSocio + ", nombre=" + nombre + ", edad=" + edad + ", sexo=" + sexo + ", cuota="
				+ cuota + "]";
	}
	
}
