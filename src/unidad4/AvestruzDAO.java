package unidad4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AvestruzDAO {

	/**
	 * Función que elimina un Avestruz de la base de datos
	 * 
	 * @param id
	 * @param con
	 * @return 0 si sale bien, -1 si sale mal
	 */
	public static int eliminar(int id, Connection con) {
		try {
			// Creamos una query
			String query = "DELETE FROM avestruz WHERE idAvestruz=?";

			// Creamos el preparedStatement
			PreparedStatement pstmt = con.prepareStatement(query);
			// Asignamos el valor a la ?
			pstmt.setInt(1, id);

			pstmt.executeUpdate();

			// Si sale bien devolvemos 0
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * Inserta en la base de datos los datos de un avestruz
	 * 
	 * @param avestruz
	 * @param con
	 * @return 1 si sale bien o 0 si sale mal
	 */
	public static int insertar(AvestruzDO avestruz, Connection con) {
		int id = 0;
		try {
			// Comprobamos si nos ha pasado un número negativo como id para autogenerarle el
			// id
			if (avestruz.getIdAvestruz() < 0) {
				// Creamos la query para insertar el avestruz
				String query = "INSERT INTO avestruz (nombre, nickguerra, edad, altura, nivelMalaLeche, numHuevos) VALUES(?, ?, ?, ?, ?, ?)";

				// Creamos un PreparedStatement
				PreparedStatement pstmt = con.prepareStatement(query);
				// Asignamos los valores a los ?
				pstmt.setString(1, avestruz.getNombre());
				pstmt.setString(2, avestruz.getNickguerra());
				pstmt.setInt(3, avestruz.getEdad());
				pstmt.setDouble(4, avestruz.getAltura());
				pstmt.setInt(5, avestruz.getNivelMalaLeche());
				pstmt.setInt(6, avestruz.getNumHuevos());

				pstmt.executeUpdate();

				// Si todo sale bien devolvemos 1
				return 1;
			} else {
				// Si nos ha metido un id mayor de 0
				// Creamos la sentencia a ejecutar
				String querySelect = "SELECT * FROM avestruz WHERE idAvestruz=?";
				// 1º - Creamos un Prepared Statement
				PreparedStatement pstmtSelect = con.prepareStatement(querySelect);
				// 2º - Seleccionamos el valor a la ?
				pstmtSelect.setInt(1, avestruz.getIdAvestruz());
				// 3º - Ejecutamos la query y los resultados quedan en el resultSet
				ResultSet rs = pstmtSelect.executeQuery();
				if (rs.next()) {
					id = rs.getInt("idAvestruz");
				}

				if (id != avestruz.getIdAvestruz()) {
					// Si el id pasado no existe, lo insertamos con el id dado
					String query = "INSERT INTO avestruz (idAvestruz, nombre, nickguerra, edad, altura, nivelMalaLeche, numHuevos) VALUES(?, ?, ?, ?, ?, ?, ?)";

					// Creamos un PreparedStatement
					PreparedStatement pstmt = con.prepareStatement(query);
					// Asignamos los valores a los ?
					pstmt.setInt(1, avestruz.getIdAvestruz());
					pstmt.setString(2, avestruz.getNombre());
					pstmt.setString(3, avestruz.getNickguerra());
					pstmt.setInt(4, avestruz.getEdad());
					pstmt.setDouble(5, avestruz.getAltura());
					pstmt.setInt(6, avestruz.getNivelMalaLeche());
					pstmt.setInt(7, avestruz.getNumHuevos());

					pstmt.executeUpdate();

					// Si sale bien devolvemos 1
					return 1;
				} else {
					// Si ya existía el id dado, lo introducimos con un id autogenerado
					String query = "INSERT INTO avestruz (nombre, nickguerra, edad, altura, nivelMalaLeche, numHuevos) VALUES(?, ?, ?, ?, ?, ?)";

					// Creamos un PreparedStatement
					PreparedStatement pstmt = con.prepareStatement(query);
					// Asignamos los valores a los ?
					pstmt.setString(1, avestruz.getNombre());
					pstmt.setString(2, avestruz.getNickguerra());
					pstmt.setInt(3, avestruz.getEdad());
					pstmt.setDouble(4, avestruz.getAltura());
					pstmt.setInt(5, avestruz.getNivelMalaLeche());
					pstmt.setInt(6, avestruz.getNumHuevos());

					pstmt.executeUpdate();

					// si sale bien devolvemos 1
					return 1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Devolvemos el error
			return 0;
		}
	}

	/**
	 * Actualiza en la base de datos los datos del Avestruz proporcionado
	 * 
	 * @param avestruz
	 * @param con
	 * @return 1 si sale bien o 0 si sale mal
	 */
	public static int actualizar(AvestruzDO avestruz, Connection con) {
		try {
			boolean campoPrevio = false;
			String query = "UPDATE avestruz SET ";

			// Si el nombre no es null, lo agregamos a la query
			if (avestruz.getNombre() != null) {
				query += "nombre = ?";
				campoPrevio = true;
			}

			// Si el nick no es null, lo agregamos a la query
			if (avestruz.getNickguerra() != null) {
				if (campoPrevio) {
					query += ", ";
				}
				query += "nickguerra = ?";
				campoPrevio = true;
			}

			// Si la edad no es -1, lo agregamos a la query
			if (avestruz.getEdad() != -1) {
				if (campoPrevio) {
					query += ", ";
				}
				query += "edad = ?";
				campoPrevio = true;
			}

			// Si la altura no es -1, lo agregamos a la query
			if (avestruz.getAltura() != -1) {
				if (campoPrevio) {
					query += ", ";
				}
				query += "altura = ?";
				campoPrevio = true;
			}

			// Si el nivel de mala leche no es -1, lo agregamos a la query
			if (avestruz.getNivelMalaLeche() != -1) {
				if (campoPrevio) {
					query += ", ";
				}
				query += "nivelMalaLeche = ?";
				campoPrevio = true;
			}

			// Si el numero de huevos no es -1, lo agregamos a la query
			if (avestruz.getNumHuevos() != -1) {
				if (campoPrevio) {
					query += ", ";
				}
				query += "numHuevos = ?";
				campoPrevio = true;
			}

			// Agregamos el id del avestruz
			query += " WHERE idAvestruz = ?";

			// preparamos la query
			PreparedStatement pstmt = con.prepareStatement(query);

			// Enlazamos los datos a las ? del preparedStatement
			int posInterrogacion = 1;

			if (avestruz.getNombre() != null) {
				pstmt.setString(posInterrogacion, avestruz.getNombre());
				posInterrogacion++;
			}

			if (avestruz.getNickguerra() != null) {
				pstmt.setString(posInterrogacion, avestruz.getNickguerra());
				posInterrogacion++;
			}

			if (avestruz.getEdad() != -1) {
				pstmt.setInt(posInterrogacion, avestruz.getEdad());
				posInterrogacion++;
			}

			if (avestruz.getAltura() != -1) {
				pstmt.setDouble(posInterrogacion, avestruz.getAltura());
				posInterrogacion++;
			}

			if (avestruz.getNivelMalaLeche() != -1) {
				pstmt.setInt(posInterrogacion, avestruz.getNivelMalaLeche());
				posInterrogacion++;
			}

			if (avestruz.getNumHuevos() != -1) {
				pstmt.setInt(posInterrogacion, avestruz.getNumHuevos());
				posInterrogacion++;
			}

			pstmt.setInt(posInterrogacion, avestruz.getIdAvestruz());

			if (campoPrevio) {
				// Ejecutamos la query
				pstmt.executeUpdate();
			}

			// Si sale bien devolvemos 1
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			// Devolvemos el error
			return 0;
		}
	}

	/**
	 * Carga el avestruz que tiene el id proporcionado
	 * 
	 * @param con
	 * @param id
	 * @return el objeto Avestruz si sale bien o null si sale mal
	 */
	public static AvestruzDO cargar(Connection con, int id) {
		try {
			// Query para cargar el avestruz con el id
			String query = "SELECT * FROM avestruz WHERE idAvestruz=?";

			// preparamos la query
			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setInt(1, id);

			// Ejecutamos la query
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				// Creamos un AvestruzDO y le añadimos los datos del de la base de datos
				AvestruzDO avestruz = new AvestruzDO();
				avestruz.setIdAvestruz(rs.getInt("idAvestruz"));
				avestruz.setNombre(rs.getString("nombre"));
				avestruz.setNickguerra(rs.getString("nickguerra"));
				avestruz.setEdad(rs.getInt("edad"));
				avestruz.setAltura(rs.getDouble("altura"));
				avestruz.setNivelMalaLeche(rs.getInt("nivelMalaLeche"));
				avestruz.setNumHuevos(rs.getInt("numHuevos"));

				// Devolvemos el avestruz
				return avestruz;
			}

			// Si algo sale mal, devolvemos null
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que devuelve un array de koalas que están asociados a un avestruz
	 * 
	 * @param idAvestruz
	 * @param con
	 * @return Un ArrayList de koalas o null
	 */
	public static ArrayList<KoalaDO> cargarLacayos(int idAvestruz, Connection con) {
		try {
			// Creamos un ArrayList de Koalas
			ArrayList<KoalaDO> koalasAsociadosAvestruz = new ArrayList<>();
			// Query para cargar los koalas asociados a un Avestruz
			String query = "SELECT * FROM koala WHERE Avestruz_idAvestruz = ?";

			// Preparamos la query
			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setInt(1, idAvestruz);

			// Ejecutamos la query
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				// Creamos un nuevo koala y le agregamos los datos
				KoalaDO koala = new KoalaDO();
				koala.setIdKoala(rs.getInt("idKoala"));
				koala.setNombre(rs.getString("nombre"));
				koala.setNickguerra(rs.getString("nickguerra"));
				koala.setEdad(rs.getInt("edad"));
				koala.setColor(rs.getString("color"));
				koala.setFuerza(rs.getInt("fuerza"));
				koala.setInteligencia(rs.getInt("inteligencia"));
				koala.setHorasSueno(rs.getInt("horasSueno"));
				koala.setTiempoBerserk(rs.getInt("tiempoBerserk"));
				koala.setCarritoGolf_idCarritoGolf(rs.getInt("CarritoGolf_idCarritoGolf"));
				koala.setAvestruz_idAvestruz(rs.getInt("Avestruz_idAvestruz"));
				// Lo agregamos al ArrayList
				koalasAsociadosAvestruz.add(koala);
			}

			// Devolvemos el arrayList
			return koalasAsociadosAvestruz;

		} catch (Exception e) {
			e.printStackTrace();
			// si hay error devolvemos null
			return null;
		}
	}

	/**
	 * Función que cuenta la cantidad de frutas que tienen los koalas asociados a un
	 * avestruz
	 * 
	 * @param idAvestruz
	 * @param con
	 * @return el numero de frutas o 0
	 */
	public static int cantidadFrutas(int idAvestruz, Connection con) {
		try {
			// Query para conseguir la cantidad de fruta de los koalas de un avestruz
			String query = "SELECT SUM(koala_has_fruta.cantidad) as SumaFrutas FROM Koala_has_fruta JOIN koala ON Koala.idKoala = koala_has_fruta.Koala_idKoala WHERE koala.Avestruz_idAvestruz = ?";

			// preparamos la query
			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setInt(1, idAvestruz);

			// Ejecutamos la query
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				// Devolvemos el numero de frutas
				return rs.getInt("SumaFrutas");
			}

			// Si la consulta no consigue nada devolvemos 0
			return 0;

		} catch (Exception e) {
			e.printStackTrace();
			// si hay un error devolvemos 0
			return 0;
		}
	}

	/**
	 * Función que carga los koalas asociados a un avestruz con una condición dada
	 * 
	 * @param con
	 * @param idAvestruz
	 * @param parametros
	 * @return ArrayList de koalas o null
	 */
	public static ArrayList<KoalaDO> cargarLacayosFiltrado(Connection con, int idAvestruz, String[] parametros) {
		boolean esValido = false;
		try {
			// Creamos un ArrayList de Koalas
			ArrayList<KoalaDO> koalasAsociadosAvestruz = new ArrayList<>();
			// Array con los campos de los koalas
			String[] campos = { "idKoala", "nombre", "nickguerra", "edad", "color", "fuerza", "inteligencia",
					"horasSueno", "tiempoBerserk", "CarritoGolf_idCarritoGolf", "Avestruz_idAvestruz" };

			// Bucle que recorre el array campos para ver si coincide con el parametro
			// pasado
			for (int i = 0; i < campos.length; i++) {
				if (parametros[0].equals(campos[i]) && (parametros[1].equals(">") || parametros[1].equals("<")
						|| parametros[1].equals("=") || parametros[1].equals("like"))) {
					// Si el parametro coincide y el operador es valido creamos la query
					String query = "SELECT * FROM koala WHERE Avestruz_idAvestruz = ? AND " + parametros[0]
							+ parametros[1] + "?";

					// Preparamos la query
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setInt(1, idAvestruz);

					// Comprobamos que el valor y el tipo de dato sean correctos
					if (parametros[3].equals("entero")) {
						if (esEntero(parametros[2]) == 0) {
							esValido = true;
							pstmt.setInt(2, Integer.parseInt(parametros[2]));
						}
					} else {
						if (esEntero(parametros[2]) != 0) {
							esValido = true;
							pstmt.setString(2, parametros[2]);
						}
					}

					// Si ha conseguido introducir el valor en la consulta ejecutamos la query
					if (esValido) {
						ResultSet rs = pstmt.executeQuery();

						while (rs.next()) {
							// Creamos un koala y le introducimos los datos de la base de datos
							KoalaDO koala = new KoalaDO();
							koala.setIdKoala(rs.getInt("idKoala"));
							koala.setNombre(rs.getString("nombre"));
							koala.setNickguerra(rs.getString("nickguerra"));
							koala.setEdad(rs.getInt("edad"));
							koala.setColor(rs.getString("color"));
							koala.setFuerza(rs.getInt("fuerza"));
							koala.setInteligencia(rs.getInt("inteligencia"));
							koala.setHorasSueno(rs.getInt("horasSueno"));
							koala.setTiempoBerserk(rs.getInt("tiempoBerserk"));
							koala.setCarritoGolf_idCarritoGolf(rs.getInt("CarritoGolf_idCarritoGolf"));
							koala.setAvestruz_idAvestruz(rs.getInt("Avestruz_idAvestruz"));
							// Los agregamos al ArrayList
							koalasAsociadosAvestruz.add(koala);
						}
					}

				}
			}

			if (!esValido) {
				// Si no ha conseguido meter el valor en la query devolvemos null
				return null;
			}

			// si sale todo bien devolvemos el ArrayList
			return koalasAsociadosAvestruz;

		} catch (

		Exception e) {
			e.printStackTrace();
			// Devolvemos null si hay un error
			return null;
		}
	}

	/**
	 * Función que carga un número determinado de koalas asociados a un avestruz a
	 * partir de otro
	 * 
	 * @param con
	 * @param idAvestruz
	 * @param numElem
	 * @param numPag
	 * @return un ArrayList de koalas o null
	 */
	public static ArrayList<KoalaDO> cargarLacayosPaginados(Connection con, int idAvestruz, int numElem, int numPag) {
		try {
			// Creamos un ArrayList de Koalas
			ArrayList<KoalaDO> koalasAsociadosAvestruz = new ArrayList<>();
			// Creamos la query que limita la busqueda
			String query = "SELECT * FROM koala WHERE Avestruz_idAvestruz = ? LIMIT ? OFFSET ?";

			// Preparamos la query
			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setInt(1, idAvestruz);

			pstmt.setInt(2, numElem);
			// Operacion para que nos deje en el punto que se pide
			pstmt.setInt(3, numElem * numPag - numElem);

			// Ejecutamos la query
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				// Creamos un koala y le introducimos los datos de la base de datos
				KoalaDO koala = new KoalaDO();
				koala.setIdKoala(rs.getInt("idKoala"));
				koala.setNombre(rs.getString("nombre"));
				koala.setNickguerra(rs.getString("nickguerra"));
				koala.setEdad(rs.getInt("edad"));
				koala.setColor(rs.getString("color"));
				koala.setFuerza(rs.getInt("fuerza"));
				koala.setInteligencia(rs.getInt("inteligencia"));
				koala.setHorasSueno(rs.getInt("horasSueno"));
				koala.setTiempoBerserk(rs.getInt("tiempoBerserk"));
				koala.setCarritoGolf_idCarritoGolf(rs.getInt("CarritoGolf_idCarritoGolf"));
				koala.setAvestruz_idAvestruz(rs.getInt("Avestruz_idAvestruz"));
				// Los agregamos al ArrayList
				koalasAsociadosAvestruz.add(koala);
			}

			// Devolvemos el ArrayList
			return koalasAsociadosAvestruz;
		} catch (Exception e) {
			e.printStackTrace();
			// Si sale error devolvemos null
			return null;
		}

	}

	/**
	 * Método para comprobar que un valor es un entero
	 * 
	 * @param valor
	 * @return 0 si lo es o -1 si no lo es
	 */
	public static int esEntero(String valor) {
		try {
			Integer.parseInt(valor);
			return 0;
		} catch (NumberFormatException e) {
			return -1;
		}
	}

}
