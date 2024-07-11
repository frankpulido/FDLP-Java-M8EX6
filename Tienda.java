package m8ex6_frank_pulido;

import java.util.ArrayList;

public class Tienda {
	
	// Atributos
	
	private ArrayList<Producto> productos;
	private ArrayList<Cliente> clientes;
	private ArrayList<Venta> ventas;
	
	
	// Constructor
	
	Tienda () {
		this.productos = new ArrayList<Producto>() ;
		this.clientes = new ArrayList<Cliente>() ;
		this.ventas = new ArrayList<Venta>();
	}
	
	
	// Métodos get o getters
	
	public ArrayList<Producto> getProductos() {
		return this.productos;
	}
	
	public ArrayList<Cliente> getClientes() {
		return this.clientes;
	}
	
	public ArrayList<Venta> getVentas() {
		return this.ventas;
	}
	
	
	// Métodos set o setters
	
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public void setVentas(ArrayList<Venta> ventas) {
		this.ventas = ventas;
	}
	
	
	// Métodos propios
	
	public void altaProducto(Producto producto) {
		this.productos.add(producto);
		/*
		for (int i = 0; i < this.clientes.size(); i++) {
			this.clientes.get(i).getCompras().add(producto);
		}
		*/
	}
	
	public void altaCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}
	
	public void bajaProducto(int index) {
		this.productos.remove(index);
	}
	
	public void bajaCliente(int index) {
		this.clientes.remove(index);
	}
	
	public void adquirirStock(int index, int compraStock) {
		int nuevoStock = this.productos.get(index).getStock() + compraStock;
		this.productos.get(index).setStock(nuevoStock);
	}
	
	public void ventaProducto(int indexProducto, int indexCliente, int ventaStock) {
		int nuevoStock = this.productos.get(indexProducto).getStock() - ventaStock;
		this.productos.get(indexProducto).setStock(nuevoStock);
		// int comprasCliente = this.clientes.get(indexCliente).getCompras().get(indexProducto).getStock() + ventaStock;
		// this.clientes.get(indexCliente).getCompras().get(indexProducto).setStock(comprasCliente);
		Venta newVenta = new Venta(this.productos.get(indexProducto).getId(), clientes.get(indexCliente).getDni(), ventaStock);
		this.ventas.add(newVenta);
	}
	
	public String listarProductos() {
		String listadoProductos = "";
		byte index = 0;
		for (Producto producto : this.productos) {
			listadoProductos = listadoProductos + "Index Producto : " + index + ". " + producto.toString() + "\n";
			index++;
		}
		return listadoProductos;
	}
	
	public String listarClientes() {
		String listadoClientes = "";
		byte index = 0;
		for (Cliente cliente : this.clientes) {
			listadoClientes = listadoClientes + "Index Cliente : " + index + ". " + cliente.toString() + "\n";
			index++;
		}
		return listadoClientes;
	}
	
	public String comprasCliente(int indexCliente) {
		String comprasCliente = "";
		for (int i = 0; i < this.ventas.size(); i++) {
			if(this.ventas.get(i).getDniCliente().equalsIgnoreCase(this.clientes.get(indexCliente).getDni())) {
				comprasCliente = comprasCliente + this.ventas.get(i).toString() + "\n";
			}
		}
		comprasCliente = (comprasCliente.equals(""))? "No existe historial de compras para este cliente." : comprasCliente;
		return comprasCliente;
	}

	
	/*
	public String comprasCliente(int indexCliente) {
		String comprasCliente = "";
		for (int i = 0; i < clientes.get(indexCliente).getCompras().size(); i++) {
			comprasCliente = comprasCliente + clientes.get(indexCliente).getCompras().get(i).toString() + "\n";
		}
		return comprasCliente;
	}
	*/
	

}
