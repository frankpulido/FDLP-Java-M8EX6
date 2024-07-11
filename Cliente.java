package m8ex6_frank_pulido;

import java.util.ArrayList;

public class Cliente {
	
	// Atributos de la Clase
	
	private String nombreCliente;
	private String dni;
	// private ArrayList<Producto> compras;
	
	
	// Constructor
	
	Cliente (String nombreCliente, String dni) {
		
		this.nombreCliente = nombreCliente;
		this.dni = dni;
		// this.compras = new ArrayList<Producto>();
	}
	
	
	// Métodos get o getters
	
	public String getNombreCliente() {
		return this.nombreCliente;
	}
	
	public String getDni() {
		return this.dni;
	}
	
	/*
	public ArrayList<Producto> getCompras() {
		return this.compras;
	}
	*/
	
	// Métodos set o setters
	
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	/*
	public void setCompras(ArrayList<Producto> compras) {
		this.compras = compras;
	}
	*/
	
	
	// Método comprar
	
	/*
	public void comprar(Producto producto) {
		compras.add(producto);
	}
	*/
	
	// Método String toString;
	
	public String toString() {
		return "Nombre Cliente : " + this.nombreCliente + ", DNI : " + this.dni;
	}
	

}
