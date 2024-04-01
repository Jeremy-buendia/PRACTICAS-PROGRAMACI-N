package unidad4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class KoalaDAO {
	/**
	 * Función que elimina un koala de la base de datos
	 * 
	 * @param id
	 * @param con
	 * @return 0 o -1
	 */
	public static int eliminar(int id, Connection con) {
		try {
			// Creamos una query
			String query = "DELETE FROM koala WHERE idKoala=?";

			// Creamos el preparedStatement
			PreparedStatement pstmt = con.prepareStatement(query);
			// Asignamos el valor a la ?
			pstmt.setInt(1, id);

			pstmt.executeUpdate();

			// Devolvemos 0 si sale bien
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			// Devolvemos -1 si sale mal
			return -1;
		}
	}

	/**
	 * Función que inserta un Koala en la base de datos
	 * 
	 * @param koala
	 * @param con
	 * @return 1 o 0
	 */
	public static int insertar(KoalaDO koala, Connection con) {
		int id = 0;
		try {
			if (koala.getIdKoala() < 0) {
				// Si nos da un id no mayor de 0 creamos la query para insertar el koala con un
				// id autogenerado
				String query = "INSERT INTO koala (nombre, nickguerra, edad, color, fuerza, inteligencia, horasSueno, tiempoBerserk, CarritoGolf_idCarritoGolf, Avestruz_idAvestruz) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

				// Creamos un PreparedStatement
				PreparedStatement pstmt = con.prepareStatement(query);
				// Asignamos los valores a los ?
				pstmt.setString(1, koala.getNombre());
				pstmt.setString(2, koala.getNickguerra());
				pstmt.setInt(3, koala.getEdad());
				pstmt.setString(4, koala.getColor());
				pstmt.setInt(5, koala.getFuerza());
				pstmt.setInt(6, koala.getInteligencia());
				pstmt.setInt(7, koala.getHorasSueno());
				pstmt.setInt(8, koala.getTiempoBerserk());
				pstmt.setInt(9, koala.getCarritoGolf_idCarritoGolf());
				pstmt.setInt(10, koala.getAvestruz_idAvestruz());

				pstmt.executeUpdate();

				// Si sale bien devolvemos 1
				return 1;
			} else {
				// Si el id dado es mayor de 0
				// Creamos la sentencia a ejecutar
				String querySelect = "SELECT * FROM koala WHERE idKoala=?";
				// 1º - Creamos un Prepared Statement
				PreparedStatement pstmtSelect = con.prepareStatement(querySelect);
				// 2º - Seleccionamos el valor a la ?
				pstmtSelect.setInt(1, koala.getIdKoala());
				// 3º - Ejecutamos la query y los resultados quedan en el resultSet
				ResultSet rs = pstmtSelect.executeQuery();
				if (rs.next()) {
					id = rs.getInt("idKoala");
				}

				if (id != koala.getIdKoala()) {
					// Si el id dado no existe en la base de datos, lo insertamos con el id dado
					String query = "INSERT INTO koala (idKoala, nombre, nickguerra, edad, color, fuerza, inteligencia, horasSueno, tiempoBerserk, CarritoGolf_idCarritoGolf, Avestruz_idAvestruz) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

					// Creamos un PreparedStatement
					PreparedStatement pstmt = con.prepareStatement(query);
					// Asignamos los valores a los ?
					pstmt.setInt(1, koala.getIdKoala());
					pstmt.setString(2, koala.getNombre());
					pstmt.setString(3, koala.getNickguerra());
					pstmt.setInt(4, koala.getEdad());
					pstmt.setString(5, koala.getColor());
					pstmt.setInt(6, koala.getFuerza());
					pstmt.setInt(7, koala.getInteligencia());
					pstmt.setInt(8, koala.getHorasSueno());
					pstmt.setInt(9, koala.getTiempoBerserk());
					pstmt.setInt(10, koala.getCarritoGolf_idCarritoGolf());
					pstmt.setInt(11, koala.getAvestruz_idAvestruz());

					pstmt.executeUpdate();

					// Devolvemos 1 si sale bien
					return 1;
				} else {
					// Si el id dado ya existía en la base de datos, asignamos uno autogenerado
					String query = "INSERT INTO koala (nombre, nickguerra, edad, color, fuerza, inteligencia, horasSueno, tiempoBerserk, CarritoGolf_idCarritoGolf, Avestruz_idAvestruz) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

					// Creamos un PreparedStatement
					PreparedStatement pstmt = con.prepareStatement(query);
					// Asignamos los valores a los ?
					pstmt.setString(1, koala.getNombre());
					pstmt.setString(2, koala.getNickguerra());
					pstmt.setInt(3, koala.getEdad());
					pstmt.setString(4, koala.getColor());
					pstmt.setInt(5, koala.getFuerza());
					pstmt.setInt(6, koala.getInteligencia());
					pstmt.setInt(7, koala.getHorasSueno());
					pstmt.setInt(8, koala.getTiempoBerserk());
					pstmt.setInt(9, koala.getCarritoGolf_idCarritoGolf());
					pstmt.setInt(10, koala.getAvestruz_idAvestruz());

					pstmt.executeUpdate();

					// Devolvemos 1 si sale bien
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
	 * Función que actualiza los datos de un koala en la base de datos
	 * 
	 * @param koala
	 * @param con
	 * @return 1 o 0
	 */
	public static int actualizar(KoalaDO koala, Connection con) {
		try {
			boolean campoPrevio = false;
			String query = "UPDATE koala SET ";

			// Si el nombre no es null, lo agregamos a la query
			if (koala.getNombre() != null) {
				query += "nombre = ?";
				campoPrevio = true;
			}

			// Si el nick no es null, lo agregamos a la query
			if (koala.getNickguerra() != null) {
				if (campoPrevio) {
					query += ", ";
				}
				query += "nickguerra = ?";
				campoPrevio = true;
			}

			// Si la edad no es -1, lo agregamos a la query
			if (koala.getEdad() != -1) {
				if (campoPrevio) {
					query += ", ";
				}
				query += "edad = ?";
				campoPrevio = true;
			}

			// Si el color no es null, lo agregamos a la query
			if (koala.getColor() != null) {
				if (campoPrevio) {
					query += ", ";
				}
				query += "color = ?";
				campoPrevio = true;
			}

			// Si la fuerza no es -1, lo agregamos a la query
			if (koala.getFuerza() != -1) {
				if (campoPrevio) {
					query += ", ";
				}
				query += "fuerza = ?";
				campoPrevio = true;
			}

			// Si la inteligencia no es -1, lo agregamos a la query
			if (koala.getInteligencia() != -1) {
				if (campoPrevio) {
					query += ", ";
				}
				query += "inteligencia = ?";
				campoPrevio = true;
			}

			// Si las horas de sueño no es -1, lo agregamos a la query
			if (koala.getHorasSueno() != -1) {
				if (campoPrevio) {
					query += ", ";
				}
				query += "horasSueno = ?";
				campoPrevio = true;
			}

			// Si el tiempor de bersek no es -1, lo agregamos a la query
			if (koala.getTiempoBerserk() != -1) {
				if (campoPrevio) {
					query += ", ";
				}
				query += "tiempoBerserk = ?";
				campoPrevio = true;
			}

			// Si el CarritoGolf_idCarritoGolf no es -1, lo agregamos a la query
			if (koala.getCarritoGolf_idCarritoGolf() != -1) {
				if (campoPrevio) {
					query += ", ";
				}
				query += "CarritoGolf_idCarritoGolf = ?";
				campoPrevio = true;
			}

			// Si el Avestruz_idAvestruz no es -1, lo agregamos a la query
			if (koala.getAvestruz_idAvestruz() != -1) {
				if (campoPrevio) {
					query += ", ";
				}
				query += "Avestruz_idAvestruz = ?";
				campoPrevio = true;
			}
			// Agregamos el id del koala
			query += " WHERE idKoala = ?";
			// preparamos la query
			PreparedStatement pstmt = con.prepareStatement(query);

			// Enlazamos los datos a las ? del preparedStatement
			int posInterrogacion = 1;

			if (koala.getNombre() != null) {
				pstmt.setString(posInterrogacion, koala.getNombre());
				posInterrogacion++;
			}

			if (koala.getNickguerra() != null) {
				pstmt.setString(posInterrogacion, koala.getNickguerra());
				posInterrogacion++;
			}

			if (koala.getEdad() != -1) {
				pstmt.setInt(posInterrogacion, koala.getEdad());
				posInterrogacion++;
			}

			if (koala.getColor() != null) {
				pstmt.setString(posInterrogacion, koala.getColor());
				posInterrogacion++;
			}

			if (koala.getFuerza() != -1) {
				pstmt.setInt(posInterrogacion, koala.getFuerza());
				posInterrogacion++;
			}

			if (koala.getInteligencia() != -1) {
				pstmt.setInt(posInterrogacion, koala.getInteligencia());
				posInterrogacion++;
			}

			if (koala.getHorasSueno() != -1) {
				pstmt.setInt(posInterrogacion, koala.getHorasSueno());
				posInterrogacion++;
			}

			if (koala.getTiempoBerserk() != -1) {
				pstmt.setInt(posInterrogacion, koala.getTiempoBerserk());
				posInterrogacion++;
			}

			if (koala.getCarritoGolf_idCarritoGolf() != -1) {
				pstmt.setInt(posInterrogacion, koala.getCarritoGolf_idCarritoGolf());
				posInterrogacion++;
			}

			if (koala.getAvestruz_idAvestruz() != -1) {
				pstmt.setInt(posInterrogacion, koala.getAvestruz_idAvestruz());
				posInterrogacion++;
			}

			pstmt.setInt(posInterrogacion, koala.getIdKoala());

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
	 * Función que devuelve el koala con el id proporcionado
	 * 
	 * @param con
	 * @param id
	 * @return KoalaDO o null
	 */
	public static KoalaDO cargar(Connection con, int id) {
		try {
			// Query para cargar el koala con el id
			String query = "SELECT * FROM koala WHERE idKoala=?";

			// preparamos la query
			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setInt(1, id);

			// Ejecutamos la query
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				// Creamos un KoalaDO y le añadimos los datos del de la base de datos
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

				// Devolvemos el koala
				return koala;
			}

			// Si algo sale mal, devolvemos null
			return null;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Función que devuelve los tipos de frutas asociados a un Koala
	 * 
	 * @param id
	 * @param con
	 * @return ArrayList de FrutaDO o null
	 */
	public static ArrayList<FrutaDO> cargarFrutas(int id, Connection con) {
		try {
			// Creamos un ArrayList de FrutaDO
			ArrayList<FrutaDO> frutasAsociadasKoala = new ArrayList<>();
			// Creamos la query para acceder a las frutas asociadas a un koala
			String query = "SELECT * FROM fruta JOIN koala_has_fruta ON koala_has_fruta.Fruta_idFruta = fruta.idFruta WHERE koala_has_fruta.Koala_idKoala = ?";

			// preparamos la query
			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setInt(1, id);

			// Ejecutamos la query
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				// Creamos un nuevo objeto FrutaDO
				FrutaDO fruta = new FrutaDO();
				fruta.setIdFruta(rs.getInt("idFruta"));
				fruta.setNombre(rs.getString("nombre"));
				fruta.setDanio(rs.getInt("danio"));
				fruta.setPuntosRec(rs.getInt("puntosRec"));
				fruta.setTipo(rs.getString("tipo"));
				// lo agregamos al ArrayList
				frutasAsociadasKoala.add(fruta);
			}

			// Si hay frutas devolvemos el ArrayList
			if (frutasAsociadasKoala.size() > 0) {
				return frutasAsociadasKoala;
			}

			// si no devolvemos null
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			// si algo sale mal devolvemos null
			return null;
		}
	}
}
