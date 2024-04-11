package unidad4.examen;

import java.util.Scanner;

import unidad4.utils.UtilsBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Función que ejecuta un menú
 */
public class MenuGolf {
	public static int opcion = 0;

	public static void menu() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("**** Bienvenido a GolfistaPlusUltra ****");
		System.out.println("**** Administración *******");
		System.out.println("1. Alta de socios");
		System.out.println("2. Modificar Club Golf");
		System.out.println("3. Cálculos");
		System.out.println("4. Eliminar Hoyo");
		System.out.println("5. Salir");
		System.out.println("Opción (1-5): ");
		opcion = teclado.nextInt();
		if (opcion == 1) {
			opcion1();
		} else if (opcion == 2) {
			opcion2();
		} else if (opcion == 3) {
			opcion3();
		} else if (opcion == 4) {
			opcion4();
		} else if (opcion == 5) {
			opcion5();
		} else {
			System.out.println("Introduce un número válido");
			menu();
		}
		teclado.close();
	}

	/**
	 * Función que ejecuta la opción 1 del menú. Introduce un socio en la base de datos.
	 */
	public static void opcion1() {
		//Conexión
		Connection con = UtilsBD.conectarBD();
		//variables
		int idSocio = Integer.MIN_VALUE;
		String nombre = "";
		int edad = 0;
		char sexoChar = ' ';
		int sexoInt = -1;
		int cuota = 0;

		Scanner teclado = new Scanner(System.in);
		System.out.println();
		try {
			//Petición de datos
			System.out.println("Introduce los datos del Socio: ");
			System.out.println("Introduce el sexo (M/F): ");
			sexoChar = teclado.nextLine().charAt(0);
			System.out.println("Introduce el id del Socio  (Si no quiere introducir id escriba -1): ");
			idSocio = teclado.nextInt();

			teclado.nextLine();

			System.out.println("Introduce el nombre: ");
			nombre = teclado.nextLine();
			System.out.println("Introduce la edad: ");
			edad = teclado.nextInt();
			System.out.println("Introduce la cuota: ");
			cuota = teclado.nextInt();

			if (sexoChar == 'M') {
				sexoInt = 0;
			} else if (sexoChar == 'F') {
				sexoInt = 1;
			} else {
				System.out.println("El sexo introducido no es válido");
				menu();
			}

			SocioDO socio = new SocioDO(idSocio, nombre, edad, sexoInt, cuota);

			//ejecutamos la función
			int resultado = SocioDAO.insertar(socio, con);

			if (resultado == 1) {
				System.out.println("Introducido con éxito");
			} else {
				System.out.println("Se ha producido un error");
				menu();
			}

		} catch (Exception e) {
			System.out.println("Se ha producido un error");
			menu();
		}
	}

	/**
	 * Función que ejecuta la opción 2 del menú. Cambia un campo de la base de datos de club de golf.
	 */
	public static void opcion2() {
		System.out.println();
		Connection con = UtilsBD.conectarBD();
		int resultado = Integer.MIN_VALUE;
		try {
			//variables
			Scanner teclado = new Scanner(System.in);
			int idClubGolf = -1;
			String campoModificar = "";
			String nuevoValor = "";
			//Pedimos datos
			System.out.println("Introduzca el id del club de golf: ");
			idClubGolf = teclado.nextInt();
			System.out.println(ClubGolfDAO.cargar(con, idClubGolf));

			teclado.nextLine();

			System.out.println("Introduce el nombre del campo a modificar: ");
			campoModificar = teclado.nextLine();
			System.out.println("Introduce el nuevo valor: ");
			nuevoValor = teclado.nextLine();
			//ejecutamos la funcion
			resultado = ClubGolfDAO.actualizar(con, idClubGolf, campoModificar, nuevoValor);
			if (resultado == 1) {
				System.out.println("Cambio realizado con éxito");
			} else if (resultado == -1) {
				System.out.println("Se ha producido un fallo");
				menu();
			}
			teclado.close();
		} catch (Exception e) {
			System.out.println("Se ha producido un error");
			menu();
		}
	}

	/**
	 * Funcion que ejecuta la opcion3 del menú. Ejecuta otro submenú.
	 */
	public static void opcion3() {
		System.out.println();
		//variables
		int resultado = 0;
		Connection con = UtilsBD.conectarBD();
		Scanner teclado = new Scanner(System.in);
		
		//pedimos datos
		System.out.println("1. Mostrar suma longitudes de los hoyos de intervalo");
		System.out.println("2. Nombre del Socio con Récord de golpes");
		System.out.println("3. Volver");
		System.out.println("Introduce el número: ");
		opcion = teclado.nextInt();

		//submenú
		if (opcion == 1) {
			int id1 = 0;
			int id2 = 0;
			System.out.println("Introduce un identificador de club de golf: ");
			id1 = teclado.nextInt();
			System.out.println("Introduce otro identificador de club de golf: ");
			id2 = teclado.nextInt();
			
			//Ejecutamos funcion
			resultado = opcion3_1(con, id1, id2);

			if (resultado != -1) {
				System.out.println("Suma de longitudes:" + resultado);
			} else {
				System.out.println("Se ha producido un error");
				opcion3();
			}
		} else if (opcion == 2) {
			//ejecutamos funcion
			resultado = opcion3_2(con);

			if (resultado != -1) {
				System.out.println("Record:" + resultado);
			} else {
				System.out.println("Se ha producido un error");
				opcion3();
			}

		} else if (opcion == 3) {
			//vamos a menú
			menu();
		} else {
			System.out.println("Introduce un valor válido.");
			menu();
		}

		teclado.close();
	}

	/**
	 * Función que ejecuta una funcion del submenú. Suma el total de longitudes en un rango dado.
	 * @param con
	 * @param id1
	 * @param id2
	 * @return El total de longitudes o -1
	 */
	public static int opcion3_1(Connection con, int id1, int id2) {
		System.out.println();
		//query
		String query = "SELECT SUM(longitud) AS total_Longitud FROM hoyo WHERE idClubGolf BETWEEN ? AND ?";
		try {
			//preparamos la query
			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setInt(1, id1);
			pstmt.setInt(2, id2);

			//ejecutamos query
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				//Devolvemos datos
				return rs.getInt("total_Longitud");
			} else {
				return -1;
			}
		} catch (Exception e) {
			return -1;
		}
	}

	/**
	 * Función que ejecuta la opcion2 del submenú. Busca el record de golpes de la tabla intermedia 
	 * @param con
	 * @return
	 */
	public static int opcion3_2(Connection con) {
		System.out.println();
		try {
			//Query 
			String query = "SELECT MIN(recordGolpes) AS minimo FROM clubgolf_has_socio";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				//Devolvemos el valor
				return rs.getInt("minimo");
			}

			return -1;
		} catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}

	/**
	 * Función que ejecuta la opción 4 del menú. Elimina un hoyo con el identificador dado.
	 */
	public static void opcion4() {
		System.out.println();
		Connection con = UtilsBD.conectarBD();
		try {
			//variables
			int idHoyo = -1;
			int resultado = Integer.MIN_VALUE;
			Scanner teclado = new Scanner(System.in);
			System.out.println("Introduce el identificador del hoyo a eliminar: ");
			idHoyo = teclado.nextInt();
			//Ejecutamos la funcion
			resultado = HoyoDAO.eliminar(idHoyo, con);
			if (resultado == 0) {
				System.out.println("El hoyo se eliminó con éxito");
			}
			teclado.close();
		} catch (Exception e) {
			System.out.println("Se ha producido un error");
		}
	}

	public static void opcion5() {
		System.out.println();
		System.out.println("Saliendo...");
	}

	public static void main(String[] args) {
		menu();
	}

}
