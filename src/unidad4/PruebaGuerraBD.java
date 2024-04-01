package unidad4;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import unidad4.utils.UtilsBD;

public class PruebaGuerraBD {

	public static void main(String[] args) {
		int resultado = Integer.MIN_VALUE;
		// Ejecutamos la conexión
		Connection con = UtilsBD.conectarBD();
		// 2º - Ejecutamos la query y los resultados quedan en el resultSet

		try {
			Statement stmt = con.createStatement();
			/******* ELIMINACIÓN DE UN AVESTRUZ *******/
			resultado = AvestruzDAO.eliminar(3, con);
			System.out.println("Eliminación avestruz: " + resultado);
			System.out.println();

			/******* ELIMINACIÓN DE UN KOALA *******/
//			resultado = KoalaDAO.eliminar(3, con);
//			System.out.println("Eliminación koala: " + resultado);
//			System.out.println();

			/******* ELIMINACIÓN DE UN CARRITO *******/
//			resultado = CarritoDAO.eliminar(3, con);
//			System.out.println("Eliminacion carrito: " + resultado);
//			System.out.println();

			/******* ELIMINACIÓN DE UNA FRUTA *******/
//			resultado = FrutaDAO.eliminar(3, con);
//			System.out.println("Eliminación fruta: " + resultado);
//			System.out.println();

			/******* CREACIÓN DE UN AVESTRUZ E INTRODUCCIÓN EN LA BASE DE DATOS *******/
			AvestruzDO avestruz = new AvestruzDO(500, "Pablito", "Killer", 22, 2.3, 4, 10);
//			resultado = AvestruzDAO.insertar(avestruz, con);
//			System.out.println("Insertar avestruz: " + resultado);
//			System.out.println();

			/******* CREACIÓN DE UN KOALA E INTRODUCCIÓN EN LA BASE DE DATOS *******/
			KoalaDO koala = new KoalaDO(500, "José", "Beast", 4, "marron", 8, 45, 20, 2, 15, 2);
			resultado = KoalaDAO.insertar(koala, con);
			System.out.println("Insertar koala: " + resultado);
			System.out.println();

			/******* CREACIÓN DE UN CARRITO E INTRODUCCIÓN EN LA BASE DE DATOS *******/
			CarritoDO carrito = new CarritoDO(500, "T7Z2CGDS7Z3574373", "Melex", 37, "granadas", 5);
//			resultado = CarritoDAO.insertar(carrito, con);
//			System.out.println("Insertar carrito: " + resultado);
//			System.out.println();

			/******* CREACIÓN DE UNA FRUTA E INTRODUCCIÓN EN LA BASE DE DATOS *******/
			FrutaDO fruta = new FrutaDO(500, "Durian", 27, 5, "neutra");
//			resultado = FrutaDAO.insertar(fruta, con);
//			System.out.println("Insertar fruta: " + resultado);
//			System.out.println();

			/******* ACTUALIZACIÓN DE DATOS DE UNA FRUTA *******/
			fruta.setNombre("Almendra");
			fruta.setDanio(4);
			fruta.setPuntosRec(10);
			fruta.setTipo("semiacidas");
//			resultado = FrutaDAO.actualizar(fruta, con);
//			System.out.println("Actualizar fruta: " + resultado);
//			System.out.println();

			/******* ACTUALIZACIÓN DE DATOS DE UN CARRITO *******/
			carrito.setNumSerie("O5D8LIWW2B9817312");
			carrito.setMarca("Club Car");
			carrito.setVelocidadMax(30);
			carrito.setArmamento("tomahawk");
			carrito.setMunicion(8);
//			resultado = CarritoDAO.actualizar(carrito, con);
//			System.out.println("Actualizar carrito: " + resultado);
//			System.out.println();

			/******* ACTUALIZACIÓN DE DATOS DE UN KOALA *******/
			koala.setNombre("Pablo");
			koala.setNickguerra("Big Poppa");
			koala.setEdad(9);
			koala.setColor("gris");
			koala.setFuerza(1);
			koala.setInteligencia(1);
			koala.setHorasSueno(0);
			koala.setTiempoBerserk(0);
			koala.setCarritoGolf_idCarritoGolf(7);
			koala.setAvestruz_idAvestruz(9);
			resultado = KoalaDAO.actualizar(koala, con);
			System.out.println("Actualizar koala: " + resultado);
			System.out.println();

			/******* ACTUALIZACIÓN DE DATOS DE UN AVESTRUZ *******/
			avestruz.setNombre("Pepe");
			avestruz.setNickguerra("Maquina");
			avestruz.setEdad(18);
			avestruz.setAltura(2.1);
			avestruz.setNivelMalaLeche(6);
			avestruz.setNumHuevos(7);
//			resultado = AvestruzDAO.actualizar(avestruz, con);
//			System.out.println("Actualizar avestruz: " + resultado);
//			System.out.println();

			/******* CARGADO DE DATOS DE UNA FRUTA *******/
			FrutaDO fruta2 = new FrutaDO();
			fruta2 = FrutaDAO.cargar(con, 1);
			System.out.println("Cargar fruta: " + fruta2);
			System.out.println();

			/******* CARGADO DE DATOS DE UN CARRITO *******/
			CarritoDO carrito2 = new CarritoDO();
			carrito2 = CarritoDAO.cargar(con, 1);
			System.out.println("Cargar carrito: " + carrito2);
			System.out.println();

			/******* CARGADO DE DATOS DE UN KOALA *******/
			KoalaDO koala2 = new KoalaDO();
			koala2 = KoalaDAO.cargar(con, 5);
			System.out.println("Cargar koala: " + koala2);
			System.out.println();

			/******* CARGADO DE DATOS DE UN AVESTRUZ *******/
			AvestruzDO avestruz2 = new AvestruzDO();
			avestruz2 = AvestruzDAO.cargar(con, 5);
			System.out.println("Cargar avestruz: " + avestruz2);
			System.out.println();

			/******* PRUEBA CARGAR LACAYOS *******/
			System.out.println("Cargar Lacayos: " + AvestruzDAO.cargarLacayos(1, con));
			System.out.println();

			/******* PRUEBA CANTIDAD DE FRUTAS *******/
			System.out.println("Cantidad de frutas: " + AvestruzDAO.cantidadFrutas(1, con));
			System.out.println();

			/******* PRUEBA CARGAR LACAYOS FILTRADOS *******/
			String[] parametros = { "edad", ">", "4", "string" };
			System.out.println("Cargar lacayos filtrados: " + AvestruzDAO.cargarLacayosFiltrado(con, 1, parametros));
			System.out.println();

			/******* PRUEBA CARGAR LACAYOS PAGINADOS *******/
			System.out.println("Cargar lacayos paginados: " + AvestruzDAO.cargarLacayosPaginados(con, 1, 2, 3));
			System.out.println();

			/******* PRUEBA CARGAR FRUTAS CON KOALA *******/
			System.out.println("Cargar frutas con koala: " + KoalaDAO.cargarFrutas(5, con));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
