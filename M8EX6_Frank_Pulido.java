package m8ex6_frank_pulido;

import java.util.ArrayList;
import java.util.Scanner;

public class M8EX6_Frank_Pulido {
	
	public static void main(String[] args) {

		/*
		 * https://youtu.be/Js0z1LMu_FA
		 * El ejercicio consiste en un control de inventarios y un CRM básico para registrar las compras de los clientes.
		 * Los Métodos han sido creados en la Clase Tienda, las clases Cliente y Producto (y sus hijos) sólo usan toString().
		 * He podido solucionar el ejercicio creando una Clase Venta que el ejercicio no pedía, pero sin darme cuenta me desvié del
		 * enunciado. El problema principal que se me presentó fue mantener un control de stocks que funcionase como un vaso comunicante
		 * con los pedidos de clientes.
		 * 
		 * He dejado comentado el código de mi planteamiento inicial en el que creaba un "Registro de Compras" como un atributo adicional
		 * de la clase Cliente. Lo planteé mal porque no imaginé crear una Clase adicional y en lugar de ello planteé el "Registro de Compras"
		 * como 3er atributo del Cliente consistiendo en un ArrayList<Producto> en el que pretendía almacenar un "stock" que sería distinto
		 * al valor del atributo stock del Objeto Producto en el ArrayList<Producto> de la Tienda. Así, la cantidad asignada por el Cliente al hacer
		 * el pedido modificaría el "stock" en la misma cantidad a la baja...
		 * 
		 * PROBLEMA 1 : cualquier acción sobre atributos (como el stock) del objeto en el ArrayList<Producto> de la Tienda modificaba a su vez
		 * el valor del atributo del Producto almacenado en el ArrayList<Producto> del Cliente y viceversa... Tenía un mismo objeto coexistiendo
		 * en los 2 ArrayList... Yo pensaba que "clonaba" el objeto Producto, pero acababa teniendo el mismo objeto almacenado en 2 arreglos distintos
		 * (uno en la clase Tienda y otro en la clase Cliente).
		 * 
		 * SOLUCIÓN 1 : Ver la nueva Clase Venta y el Método ventaProducto(int indexProducto, int indexCliente, int ventaStock) de la Clase Tienda.
		 * 
		 * PROBLEMA 2 : Lo que quería el enunciado del ejercicio era que crease el atributo adicional en la Clase Cliente.
		 * 
		 * SOLUCIÓN 2 : La Clase Venta funciona perfecta de cara al menu de usuario de la Tienda.
		 * Puedo crear un ArrayList<Venta> "shoppingCart" como atributo de Cliente que funcione exactamente como lo hace ArrayList<Venta> "ventas"
		 * como atributo de Tienda. Diferencia : la agregación de Objetos de la Clase Venta a shoppingCart no afectará el stock de productos hasta usar
		 * el Método Comprar (a construir en Cliente). El Método Comprar vacía el contenido de ArrayList<Venta> "shoppingCart" de Cliente dentro del
		 * ArrayList<Venta> "ventas" de Tienda y entonces si se efectúa la Venta.
		 * 
		 * Por Estudiar :  crear una Clase CISTELLA que sea hija (extends) de la anterior y usarla como Atributo del Cliente de la misma forma que uso Venta
		 * como atributo de la Tienda... Tiene sentido tener un hijo?...
		 * VENTA : es la venta POS (tiendas físicas), ya en funcionamiento. Mantendrá el registro de todas las Ventas (CRM).
		 * CISTELLA : Es efímera, la venta ON LINE. Su información se vacía en VENTA cada vez que se efectúa finalmente la Compra (Venta).
		 * Cuando el Cliente se conecte a la web por su record de compras no estará consultando CISTELLA, estará consultando VENTA filtrada por Cliente. 
		 */
			
		// Declaración e inicialización de variables
		
		byte opcionMenu = -1;
		byte indexCliente = -1;
		byte indexProducto = -1;
		byte opcionAltaBajaProducto = -1;
		//byte opcionAltaBajaCliente = -1;
		
		String nombreCliente = "";
		String dni = "";

		int id = 0;
		String nombreProducto = "";
		float precio = 0f;
		String marca = "";
		char talla = ' ';
		String tipo = "";
		
		int compraStock = 0;
		int ventaStock = 0;
		int stockActual = 0;
		//int nuevoStock = 0;
		
		ProductoElectronico altavoz = new ProductoElectronico (1, "Altavoz portátil", 200, 0, "Bose");
		ProductoAlimentacion tomate = new ProductoAlimentacion (2, "Plátano Canario", 4, 0, "Fruta");
		ProductoRopa banyador = new ProductoRopa (3, "Bikini", 50, 0, "Bella Lola", 'M');
		
		/*
		ArrayList<Producto> compras1 = new ArrayList<Producto>();
		ArrayList<Producto> compras2 = new ArrayList<Producto>();
		ArrayList<Producto> compras3 = new ArrayList<Producto>();
		*/
		
		Cliente cliente1 = new Cliente ("Frank", "47886327M");
		Cliente cliente2 = new Cliente ("Laura", "71275217B");
		Cliente cliente3 = new Cliente ("Oriol", "52325217Z");
		
		// Damos de alta la tienda con los productos y clientes anteriores
		
		Tienda tienda = new Tienda(); //Primero tenía que dar de alta los clientes, luego los productos. De lo contrario no actualizaba ArrayList<Producto) compras
		tienda.altaCliente(cliente1);
		tienda.altaCliente(cliente2);
		tienda.altaCliente(cliente3);
		tienda.altaProducto(altavoz);
		tienda.altaProducto(tomate);
		tienda.altaProducto(banyador);
		
		// Objeto Scanner
			
		Scanner dataentry = new Scanner(System.in);

		
		// Controlador
		
		do {
			//System.out.println(tienda.getClientes().get(0).getCompras().size());
			System.out.println();
			System.out.println("Por favor, seleccione una de las siguientes opciones :");
			System.out.println();
			System.out.println(menuUsuario());
			opcionMenu = dataentry.nextByte();
			
			switch (opcionMenu) {
			
			case 1 :
				System.out.println();
				System.out.println("Ha seleccionado DAR DE ALTA un nuevo PRODUCTO.");
				System.out.println("A continuación indique el número de SKU del producto.");
				id = dataentry.nextInt();
				dataentry.nextLine();
				System.out.println("A continuación indique el NOMBRE del producto.");
				nombreProducto = dataentry.nextLine();
				System.out.println("A continuación indique el PRECIO del producto.");
				precio = dataentry.nextFloat();
				
				do {
					System.out.println();
					System.out.println("A continuación indique la CATEGORÍA del producto :\n"
							+ "1. Producto electrónico.\n"
							+ "2. Producto Alimenticio.\n"
							+ "3. Producto Textil.");
					opcionAltaBajaProducto = dataentry.nextByte();
					if (opcionAltaBajaProducto < 1 || opcionAltaBajaProducto > 3) {System.out.println("Debe seleccionar una opción válida (1 al 3).");}
				} while (opcionAltaBajaProducto < 1 || opcionAltaBajaProducto > 3);
				
				if (opcionAltaBajaProducto == 1) {
					dataentry.nextLine();
					System.out.println("A continuación indique la MARCA del producto electrónico.");
					marca = dataentry.nextLine();
					ProductoElectronico nuevaAlta = new ProductoElectronico(id, nombreProducto, precio, 0, marca);
					tienda.altaProducto(nuevaAlta);
				} else if (opcionAltaBajaProducto == 2) {
					dataentry.nextLine();
					System.out.println("A continuación indique el TIPO de producto alimenticio.");
					tipo = dataentry.nextLine();
					ProductoAlimentacion nuevaAlta = new ProductoAlimentacion(id, nombreProducto, precio, 0, tipo);
					tienda.altaProducto(nuevaAlta);
				} else {
					System.out.println("A continuación indique la MARCA del producto textil.");
					marca = dataentry.nextLine();
					dataentry.nextLine();
					System.out.println("A continuación indique la TALLA del producto textil.");
					talla = dataentry.nextLine().charAt(0);
					ProductoRopa nuevaAlta = new ProductoRopa(id, nombreProducto, precio, 0, marca, talla);
					tienda.altaProducto(nuevaAlta);
				}
				
				System.out.println("El producto se da de alta con STOCK = 0. Recuerde ingresar la primera recepción a través de la opción 2.");
				break;
				
			case 2 :
				System.out.println();
				System.out.println("Ha seleccionado registrar ENTRADA DE STOCK de producto.");
				System.out.println("Productos de alta en el sistema :");
				System.out.println();
				System.out.println(tienda.listarProductos());
				System.out.println("A continuación indique el código \"INDEX PRODUCTO\" de la opción para la que quiere dar entrada a nuevo stock.");
				indexProducto = dataentry.nextByte();
				System.out.println();
				System.out.println("Ha seleccionado dar de alta nuevo stock para el producto :");
				System.out.println(tienda.getProductos().get(indexProducto).toString());
				System.out.println("A continuación indique la cantidad adquirida :");
				compraStock = dataentry.nextInt();
				tienda.adquirirStock(indexProducto, compraStock);
				System.out.println("Nuevo stock : " + tienda.getProductos().get(indexProducto).getStock() + ".");
				break;
				
				
			case 3 :
				System.out.println();
				dataentry.nextLine();
				System.out.println("Ha seleccionado DAR DE ALTA un nuevo CLIENTE.");
				System.out.println("Por favor, indique el NOMBRE del Cliente :");
				nombreCliente = dataentry.nextLine();
				System.out.println("Por favor, indique el DNI del Cliente :");
				dni = dataentry.nextLine();
				Cliente nuevoCliente = new Cliente(nombreCliente, dni);
				tienda.altaCliente(nuevoCliente);
				System.out.println("Nueva alta Cliente" + tienda.getClientes().get(tienda.getClientes().size()-1).toString());
				break;
				
				
			case 4 :
				System.out.println();
				System.out.println("Ha seleccionado registrar VENTA de producto.");
				System.out.println("Productos de alta en el sistema :");
				System.out.println();
				System.out.println(tienda.listarProductos());
				System.out.println("Indique el index que tiene el PRODUCTO a vender :");
				indexProducto = dataentry.nextByte();
				stockActual = tienda.getProductos().get(indexProducto).getStock();
				System.out.println();
				System.out.println("Clientes de alta en el sistema :");
				System.out.println();
				System.out.println(tienda.listarClientes());
				System.out.println("Indique el index que tiene el CLIENTE que efectúa la compra :");
				indexCliente = dataentry.nextByte();
				do {
					System.out.println("Por último indique la CANTIDAD que desea adquirir el CLIENTE :");
					ventaStock = dataentry.nextInt();
					if (ventaStock > stockActual) {System.out.println("El pedido no debe superar el stock actual : " + stockActual + ". Puede pedir"
							+ "como máximo esa cantidad");}
				} while (ventaStock > stockActual);
				tienda.ventaProducto(indexProducto, indexCliente, ventaStock);
				System.out.println(tienda.getVentas().get(tienda.getVentas().size() - 1).toString());
				//nuevoStock = tienda.getProductos().get(indexProducto).getStock();
				System.out.println("Actualizamos inventario. Este es el nuevo stock del producto : " + tienda.getProductos().get(indexProducto).getStock());
				
				/*
				System.out.println("Indique el index que tiene el PRODUCTO en el sistema (si no lo conoce consúltelo en la opción 5) :");
				indexProducto = dataentry.nextByte();
				stockActual = tienda.getProductos().get(indexProducto).getStock();
				System.out.println("Indique el index que tiene el CLIENTE en el sistema (si no lo conoce consúltelo en la opción 6) :");
				indexCliente = dataentry.nextByte();
				do {
					System.out.println("Por último indique la CANTIDAD que desea adquirir el CLIENTE :");
					ventaStock = dataentry.nextInt();
					if (ventaStock > stockActual) {System.out.println("El pedido no debe superar el stock actual : " + stockActual + ". Puede pedir"
							+ "como máximo esa cantidad");}
				} while (ventaStock > stockActual);
				nuevoStock = tienda.getProductos().get(indexProducto).getStock();
				tienda.ventaProducto(indexProducto, indexCliente, ventaStock);
				System.out.println("Actualizamos inventario. Este es el nuevo stock del producto : " + nuevoStock);
				*/
				
				break;
				
				
			case 5 :
				System.out.println();
				System.out.println("Ha seleccionado generar LISTADO de PRODUCTOS en el sistema.");
				System.out.println(tienda.listarProductos());
				break;
				
				
			case 6 :
				System.out.println();
				System.out.println("Ha seleccionado generar LISTADO de CLIENTES en el sistema.");
				System.out.println(tienda.listarClientes());
				break;
				
				
			case 7 :
				System.out.println();
				System.out.println("Ha seleccionado Consultar Historial de Compras del Cliente.");
				System.out.println("Clientes de alta en el sistema :");
				System.out.println();
				System.out.println(tienda.listarClientes());
				System.out.println("Indique el index que tiene el CLIENTE cuyo historial desea consultar :");
				indexCliente = dataentry.nextByte();
				System.out.println(tienda.comprasCliente(indexCliente));
				/*
				if (tienda.getClientes().get(indexCliente).getCompras().size() == 0) {
					System.out.println("El cliente " + tienda.getClientes().get(indexCliente).getNombreCliente() + " aún no ha efectuado ninguna compra.");
				} else {
					System.out.println(tienda.comprasCliente(indexCliente));
				}
				*/
				break;
				
			case 8 :
				System.out.println();
				System.out.println("NO QUEREMOS QUE ELIMINES NINGÚN PRODUCTO, necesitamos mantener el historial de ventas.\n"
						+ "Te diremos en cambio como podría hacerse :\n"
						+ "En la App : tienda.bajaProducto(indexProducto);\n"
						+ "En la clase TIENDA encontrarás este método :\n"
						+ "public void bajaProducto(int indexProducto) {\n"
						+ "this.productos.remove(indexProducto);\n"
						+ "}\n"
						+ "(Tu mism@)");
				break;
				
			case 9 :
				System.out.println();
				System.out.println("NO QUEREMOS QUE ELIMINES NINGÚN CLIENTE, necesitamos mantener el historial de ventas.\n"
						+ "Te diremos en cambio como podría hacerse :\n"
						+ "En la App pones esta instrucción: tienda.bajaCliente(indexCliente);\n"
						+ "En la clase TIENDA encontrarás el método :\n"
						+ "public void bajaCliente(int indexCliente) {\n"
						+ "this.clientes.remove(indexCliente);\n"
						+ "}\n"
						+ "(Tu mism@)");
				break;
				
			case 0 :
				System.out.println();
				System.out.println("Procedemos a cerrar la sesión de usuario");

				break;
				
			default :
				System.out.println();
				System.out.println("Debe seleccionar una opción de la 1 a la 6 (o \"0\" para salir del sistema.");
				break;
			
			}
			
		} while (opcionMenu != 0);
		
		
		dataentry.close();
		
	}
		
		public static String menuUsuario() {
		String menu = "Bienvenido a IT Groceries. Menú del empleado.\n"
				+ "1. Dar de Alta Producto.\n"
				+ "2. Dar de Alta stock de Producto.\n"
				+ "3. Dar de Alta Cliente.\n"
				+ "4. Vender producto\n"
				+ "5. Listado de productos.\n"
				+ "6. Listado de Clientes.\n"
				+ "7. Historial de Compras del Cliente\n"
				+ "8. [Eliminar producto]\n"
				+ "9. [Eliminar cliente]\n"
				+ "0. Salir del sistema.";
		return menu;

		}


}
