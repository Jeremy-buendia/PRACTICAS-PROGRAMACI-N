package unidad4;

public class CarritoDO {
	private int idCarritoGolf;
	private String numSerie;
	private String marca;
	private int VelocidadMax;
	private String armamento;
	private int municion;

	public int getIdCarritoGolf() {
		return idCarritoGolf;
	}

	public void setIdCarritoGolf(int idCarritoGolf) {
		this.idCarritoGolf = idCarritoGolf;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getVelocidadMax() {
		return VelocidadMax;
	}

	public void setVelocidadMax(int velocidadMax) {
		VelocidadMax = velocidadMax;
	}

	public String getArmamento() {
		return armamento;
	}

	public void setArmamento(String armamento) {
		this.armamento = armamento;
	}

	public int getMunicion() {
		return municion;
	}

	public void setMunicion(int municion) {
		this.municion = municion;
	}

	public CarritoDO(int idCarritoGolf, String numSerie, String marca, int velocidadMax, String armamento,
			int municion) {
		super();
		this.idCarritoGolf = idCarritoGolf;
		this.numSerie = numSerie;
		this.marca = marca;
		VelocidadMax = velocidadMax;
		this.armamento = armamento;
		this.municion = municion;
	}

	public CarritoDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "carritoDO [idCarritoGolf=" + idCarritoGolf + ", numSerie=" + numSerie + ", marca=" + marca
				+ ", VelocidadMax=" + VelocidadMax + ", armamento=" + armamento + ", municion=" + municion + "]";
	}

}
