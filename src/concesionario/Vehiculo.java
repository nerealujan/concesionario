package concesionario;

public class Vehiculo {
	String marca, modelo, bastidor;

	public Vehiculo(String marca, String modelo, String bastidor) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.bastidor = bastidor;
	}
	

	public Vehiculo(String bastidor) {
		super();
		this.bastidor = bastidor;
	}


	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getBastidor() {
		return bastidor;
	}
	

}
