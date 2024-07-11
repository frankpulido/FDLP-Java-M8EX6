package m8ex6_frank_pulido;

public class ProductoElectronico extends Producto {
	
	// Atributo adicional al de la SUPER Clase
	
	private String marca;
	
	// Constructor de la subclase
	
	ProductoElectronico (int id, String nombreProducto, float precio, int stock, String marca) {
		super (id, nombreProducto, precio, stock);
		this.marca = marca;
	}
	
	// Métodos get o getters
	
	public String getMarca() {
		return this.marca;
	}
	
	// Métodos set o setters
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	// Métodos generales
	
	public String toString() {
		return "ID producto : " + super.getId() + ", Nombre producto : " + super.getNombreProducto() + ", Marca : " + this.marca + ", Precio : " + super.getPrecio() + ",\n"
				+ "Stock : " + super.getStock();
	}

}
