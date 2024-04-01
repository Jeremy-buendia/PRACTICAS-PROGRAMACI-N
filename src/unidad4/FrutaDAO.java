package unidad4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FrutaDAO {
	/**
	 * Función que elima una fruta de la base de datos
	 * 
	 * @param id
	 * @param con
	 * @return 0 o -1
	 */
	public static int eliminar(int id, Connection con) {
		try {
			// Creamos una query
			String query = "DELETE FROM fruta WHERE idFruta=?";

			// Creamos el preparedStatement
			PreparedStatement pstmt = con.prepareStatement(query);
			// Asignamos el valor a la ?
			pstmt.setInt(1, id);

			pstmt.executeUpdate();

			// Si sale bien devolvemos 0
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			// Si sale mal devolvemos -1
			return -1;
		}
	}

	/**
	 * Función que inserta una fruta en la base de datos
	 * 
	 * @param fruta
	 * @param con
	 * @return 1 o 0
	 */
	public static int insertar(FrutaDO fruta, Connection con) {
		int id = 0;
		try {
			if (fruta.getIdFruta() < 0) {
				// Si nos da un id no mayor de 0 creamos la query para insertar la fruta con un
				// id autogenerado
				String query = "INSERT INTO fruta (nombre, danio, puntosRec, tipo) VALUES(?, ?, ?, ?)";

				// Creamos un PreparedStatement
				PreparedStatement pstmt = con.prepareStatement(query);
				// Asignamos los valores a los ?
				pstmt.setString(1, fruta.getNombre());
				pstmt.setInt(2, fruta.getDanio());
				pstmt.setInt(3, fruta.getPuntosRec());
				pstmt.setString(4, fruta.getTipo());

				pstmt.executeUpdate();

				// Si sale bien devolvemos 1
				return 1;
			} else {
				// Si el id dado es mayor de 0
				// Creamos la sentencia a ejecutar
				String querySelect = "SELECT * FROM fruta WHERE idFruta=?";
				// 1º - Creamos un Prepared Statement
				PreparedStatement pstmtSelect = con.prepareStatement(querySelect);
				// 2º - Seleccionamos el valor a la ?
				pstmtSelect.setInt(1, fruta.getIdFruta());
				// 3º - Ejecutamos la query y los resultados quedan en el resultSet
				ResultSet rs = pstmtSelect.executeQuery();
				if (rs.next()) {
					id = rs.getInt("idFruta");
				}

				if (id != fruta.getIdFruta()) {
					// Si el id dado no existe en la base de datos, lo insertamos con el id dado
					String query = "INSERT INTO fruta (idFruta, nombre, danio, puntosRec, tipo) VALUES(?, ?, ?, ?, ?)";

					// Creamos un PreparedStatement
					PreparedStatement pstmt = con.prepareStatement(query);
					// Asignamos los valores a los ?
					pstmt.setInt(1, fruta.getIdFruta());
					pstmt.setString(2, fruta.getNombre());
					pstmt.setInt(3, fruta.getDanio());
					pstmt.setInt(4, fruta.getPuntosRec());
					pstmt.setString(5, fruta.getTipo());

					pstmt.executeUpdate();

					// Devolvemos 1 si sale bien
					return 1;
				} else {
					// Si el id dado ya existía en la base de datos, asignamos uno autogenerado
					String query = "INSERT INTO fruta (nombre, danio, puntosRec, tipo) VALUES(?, ?, ?, ?)";

					// Creamos un PreparedStatement
					PreparedStatement pstmt = con.prepareStatement(query);
					// Asignamos los valores a los ?
					pstmt.setString(1, fruta.getNombre());
					pstmt.setInt(2, fruta.getDanio());
					pstmt.setInt(3, fruta.getPuntosRec());
					pstmt.setString(4, fruta.getTipo());

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
	 * Función que actualiza los datos de una fruta en la base de datos
	 * 
	 * @param fruta
	 * @param con
	 * @return 1 o 0
	 */
	public static int actualizar(FrutaDO fruta, Connection con) {
		try {
			boolean campoPrevio = false;
			String query = "UPDATE fruta SET ";

			// Si el nombre no es null, lo agregamos a la query
			if (fruta.getNombre() != null) {
				query += "nombre = ?";
				campoPrevio = true;
			}

			// Si el daño no es -1, lo agregamos a la query
			if (fruta.getDanio() != -1) {
				if (campoPrevio) {
					query += ", ";
				}
				query += "danio = ?";
				campoPrevio = true;
			}

			// Si los puntos de recuperacion no es -1, lo agregamos a la query
			if (fruta.getPuntosRec() != -1) {
				if (campoPrevio) {
					query += ", ";
				}
				query += "puntosRec = ?";
				campoPrevio = true;
			}

			// Si el tipo no es null, lo agregamos a la query
			if (fruta.getTipo() != null) {
				if (campoPrevio) {
					query += ", ";
				}
				query += "tipo = ?";
				campoPrevio = true;
			}

			// Agregamos el id del koala
			query += " WHERE idFruta = ?";
			// preparamos la query
			PreparedStatement pstmt = con.prepareStatement(query);

			// Enlazamos los datos a las ? del preparedStatement
			int posInterrogacion = 1;

			if (fruta.getNombre() != null) {
				pstmt.setString(posInterrogacion, fruta.getNombre());
				posInterrogacion++;
			}

			if (fruta.getDanio() != -1) {
				pstmt.setInt(posInterrogacion, fruta.getDanio());
				posInterrogacion++;
			}

			if (fruta.getPuntosRec() != -1) {
				pstmt.setInt(posInterrogacion, fruta.getPuntosRec());
				posInterrogacion++;
			}

			if (fruta.getTipo() != null) {
				pstmt.setString(posInterrogacion, fruta.getTipo());
				posInterrogacion++;
			}

			pstmt.setInt(posInterrogacion, fruta.getIdFruta());

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
	 * Función que devuelve la fruta con el id proporcionado
	 * 
	 * @param con
	 * @param id
	 * @return FrutaDO o null
	 */
	public static FrutaDO cargar(Connection con, int id) {
		try {
			// Query para cargar la fruta con el id
			String query = "SELECT * FROM fruta WHERE idFruta=?";

			// preparamos la query
			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setInt(1, id);

			// Ejecutamos la query
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				// Creamos un FrutaDO y le añadimos los datos del de la base de datos
				FrutaDO fruta = new FrutaDO();
				fruta.setIdFruta(rs.getInt("idFruta"));
				fruta.setNombre(rs.getString("nombre"));
				fruta.setDanio(rs.getInt("danio"));
				fruta.setPuntosRec(rs.getInt("puntosRec"));
				fruta.setTipo(rs.getString("Tipo"));

				// Devolvemos la fruta
				return fruta;
			}

			// Si algo sale mal, devolvemos null
			return null;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
