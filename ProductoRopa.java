package m8ex6_frank_pulido;

public class ProductoRopa extends Producto {
	
	// Atributo adicional al de la SUPER Clase
	
	private String marca;
	private char talla;
	
	// Constructor de la subclase
	
	ProductoRopa (int id, String nombreProducto, float precio, int stock, String marca, char talla) {
		super (id, nombreProducto, precio, stock);
		this.marca = marca;
		this.talla = talla;
	}
	
	// Métodos get o getters
	
	public String getMarca() {
		return this.marca;
	}
	
	public char getTalla() {
		return this.talla;
	}
	
	// Métodos set o setters
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public void setTipo(char talla) {
		this.talla = talla;
	}
	
	// Métodos generales
	
	public String toString() {
		return "ID producto : " + super.getId() + ", Nombre producto : " + super.getNombreProducto() + ", Marca : " + this.marca + ", Talla : " + this.talla + ", "
				+ "Precio : " + super.getPrecio() + ",\n"
				+ "Stock : " + super.getStock();
	}

}
