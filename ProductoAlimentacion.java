package m8ex6_frank_pulido;

public class ProductoAlimentacion extends Producto {
	
	// Atributo adicional al de la SUPER Clase
	
	private String tipo;
	
	// Constructor de la subclase
	
	ProductoAlimentacion (int id, String nombreProducto, float precio, int stock, String tipo) {
		super (id, nombreProducto, precio, stock);
		this.tipo = tipo;
	}
	
	// Métodos get o getters
	
	public String getTipo() {
		return this.tipo;
	}
	
	// Métodos set o setters
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	// Métodos generales
	
	public String toString() {
		return "ID producto : " + super.getId() + ", Nombre producto : " + super.getNombreProducto() + ", Tipo : " + this.tipo + ", Precio : " + super.getPrecio() + ",\n"
				+ "Stock : " + super.getStock();
	}

}
