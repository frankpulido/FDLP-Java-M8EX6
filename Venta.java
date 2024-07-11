package m8ex6_frank_pulido;

public class Venta {
	
	private int eanProducto;
	private String dniCliente;
	private int cantidadCompra;
	
	
	public Venta (int eanProducto, String dniCliente, int cantidadCompra) {
		this.eanProducto = eanProducto;
		this.dniCliente = dniCliente;
		this.cantidadCompra = cantidadCompra;
	}
	
	
	// Métodos get o Getters
	
	public int getEanProducto() {
		return this.eanProducto;
	}
	
	public String getDniCliente() {
		return this.dniCliente;
	}
	
	public int getCantidadCompra() {
		return this.cantidadCompra;
	}
	
	
	// Métodos set o setters
	
	public void setEanProducto(int eanProducto) {
		this.eanProducto = eanProducto;
	}
	
	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}
	
	public void setCantidadCompra(int cantidadCompra) {
		this.cantidadCompra = cantidadCompra;
	}
	
	
	// Método general
	
	public String toString() {
		return "El cliente " + this.dniCliente + " adquiere cantidad = " + this.cantidadCompra + " del producto con EAN : " + this.eanProducto;
	}
	
	
}
