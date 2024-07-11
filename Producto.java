package m8ex6_frank_pulido;

public class Producto {
	
	// Atributos de la SUPER Clase
	
	private int id;
	//static int count = 0;
	private String nombreProducto;
	private float precio;
	private int stock;
	
	// Constructor
	
	Producto (int id, String nombreProducto, float precio, int stock) {
		this.id = id;
		//this.count++;
		this.nombreProducto = nombreProducto;
		this.precio = precio;
		this.stock = 0;
	}
	
	
	// Métodos get o getters
	
	
	public int getId() {
		return this.id;
	}
	
	/*
	public int getCount() {
		return this.count;
	}
	*/
	
	public String getNombreProducto() {
		return this.nombreProducto;
	}
	
	public float getPrecio() {
		return this.precio;
	}
	
	public int getStock() {
		return this.stock;
	}
	
	
	// Métodos set o setters
	
	/*
	public void setId(int id) {
		this.id = id;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	*/
	
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	// Métodos generales
	
	public String toString() {
		return "ID producto (EAN) : " + this.id + ", Nombre producto : " + this.nombreProducto + ", Precio : " + this.precio + ", Stock : " + this.stock;
	}
	

}
