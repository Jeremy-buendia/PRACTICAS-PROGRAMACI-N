package unidad4.examen;

public class HoyoDO {
	private int idHoyo;
	private String nombre;
	private int numero;
	private int longitud;
	private boolean lago;
	private int numCurvas;
	private int par;
	private int numBunkers;
	private int idClubGolf;
	
	public int getIdHoyo() {
		return idHoyo;
	}
	
	public void setIdHoyo(int idHoyo) {
		this.idHoyo = idHoyo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public int getLongitud() {
		return longitud;
	}
	
	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	
	public boolean isLago() {
		return lago;
	}
	
	public void setLago(boolean lago) {
		this.lago = lago;
	}
	
	public int getNumCurvas() {
		return numCurvas;
	}
	
	public void setNumCurvas(int numCurvas) {
		this.numCurvas = numCurvas;
	}
	
	public int getPar() {
		return par;
	}
	
	public void setPar(int par) {
		this.par = par;
	}
	
	public int getNumBunkers() {
		return numBunkers;
	}
	
	public void setNumBunkers(int numBunkers) {
		this.numBunkers = numBunkers;
	}
	
	public int getIdClubGolf() {
		return idClubGolf;
	}
	
	public void setIdClubGolf(int idClubGolf) {
		this.idClubGolf = idClubGolf;
	}
	
	public HoyoDO(int idHoyo, String nombre, int numero, int longitud, boolean lago, int numCurvas, int par,
			int numBunkers, int idClubGolf) {
		super();
		this.idHoyo = idHoyo;
		this.nombre = nombre;
		this.numero = numero;
		this.longitud = longitud;
		this.lago = lago;
		this.numCurvas = numCurvas;
		this.par = par;
		this.numBunkers = numBunkers;
		this.idClubGolf = idClubGolf;
	}
	
	public HoyoDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "HoyoDO [idHoyo=" + idHoyo + ", nombre=" + nombre + ", numero=" + numero + ", longitud=" + longitud
				+ ", lago=" + lago + ", numCurvas=" + numCurvas + ", par=" + par + ", numBunkers=" + numBunkers
				+ ", idClubGolf=" + idClubGolf + "]";
	}
	
	
}
