package unidad4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarritoDAO {
	/**
	 * Función que elimina un carrito de la base de datos
	 * 
	 * @param id
	 * @param con
	 * @return 0 o -1
	 */
	public static int eliminar(int id, Connection con) {
		try {
			// Creamos una query
			String query = "DELETE FROM carritogolf WHERE idCarritoGolf=?";

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
	 * Función que inserta un carrito en la base de datos
	 * 
	 * @param carrito
	 * @param con
	 * @return 1 o 0
	 */
	public static int insertar(CarritoDO carrito, Connection con) {
		int id = 0;
		try {
			if (carrito.getIdCarritoGolf() < 0) {
				// Si nos da un id no mayor de 0 creamos la query para insertar el carrito con
				// un id autogenerado
				String query = "INSERT INTO carritogolf (numSerie, marca, velocidadMax, armamento, municion) VALUES(?, ?, ?, ?, ?)";

				// Creamos un PreparedStatement
				PreparedStatement pstmt = con.prepareStatement(query);
				// Asignamos los valores a los ?
				pstmt.setString(1, carrito.getNumSerie());
				pstmt.setString(2, carrito.getMarca());
				pstmt.setInt(3, carrito.getVelocidadMax());
				pstmt.setString(4, carrito.getArmamento());
				pstmt.setInt(5, carrito.getMunicion());

				pstmt.executeUpdate();

				// Si sale bien devolvemos 1
				return 1;
			} else {
				// Si el id dado es mayor de 0
				// Creamos la sentencia a ejecutar
				String querySelect = "SELECT * FROM carritogolf WHERE idCarritoGolf=?";
				// 1º - Creamos un Prepared Statement
				PreparedStatement pstmtSelect = con.prepareStatement(querySelect);
				// 2º - Seleccionamos el valor a la ?
				pstmtSelect.setInt(1, carrito.getIdCarritoGolf());
				// 3º - Ejecutamos la query y los resultados quedan en el resultSet
				ResultSet rs = pstmtSelect.executeQuery();
				if (rs.next()) {
					id = rs.getInt("idCarritoGolf");
				}

				if (id != carrito.getIdCarritoGolf()) {
					// Si el id dado no existe en la base de datos, lo insertamos con el id dado
					String query = "INSERT INTO carritogolf (idCarritoGolf, numSerie, marca, velocidadMax, armamento, municion) VALUES(?, ?, ?, ?, ?, ?)";

					// Creamos un PreparedStatement
					PreparedStatement pstmt = con.prepareStatement(query);
					// Asignamos los valores a los ?
					pstmt.setInt(1, carrito.getIdCarritoGolf());
					pstmt.setString(2, carrito.getNumSerie());
					pstmt.setString(3, carrito.getMarca());
					pstmt.setInt(4, carrito.getVelocidadMax());
					pstmt.setString(5, carrito.getArmamento());
					pstmt.setInt(6, carrito.getMunicion());

					pstmt.executeUpdate();

					// Si sale bien devolvemos 1
					return 1;
				} else {
					// Si el id dado ya existía en la base de datos, asignamos uno autogenerado
					String query = "INSERT INTO carritogolf (numSerie, marca, velocidadMax, armamento, municion) VALUES(?, ?, ?, ?, ?)";

					// Creamos un PreparedStatement
					PreparedStatement pstmt = con.prepareStatement(query);
					// Asignamos los valores a los ?
					pstmt.setString(1, carrito.getNumSerie());
					pstmt.setString(2, carrito.getMarca());
					pstmt.setInt(3, carrito.getVelocidadMax());
					pstmt.setString(4, carrito.getArmamento());
					pstmt.setInt(5, carrito.getMunicion());

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
	 * Funcion que actualiza los datos de un carrito en la base de datos
	 * 
	 * @param carrito
	 * @param con
	 * @return 1 o 0
	 */
	public static int actualizar(CarritoDO carrito, Connection con) {
		try {
			boolean campoPrevio = false;
			String query = "UPDATE carritogolf SET ";

			// Si el numero de serie no es null, lo agregamos a la query
			if (carrito.getNumSerie() != null) {
				query += "numSerie = ?";
				campoPrevio = true;
			}

			// Si la marca no es null, lo agregamos a la query
			if (carrito.getMarca() != null) {
				if (campoPrevio) {
					query += ", ";
				}
				query += "marca = ?";
				campoPrevio = true;
			}

			// Si la velocidad maxima no es -1, lo agregamos a la query
			if (carrito.getVelocidadMax() != -1) {
				if (campoPrevio) {
					query += ", ";
				}
				query += "velocidadMax = ?";
				campoPrevio = true;
			}

			// Si el armamento no es null, lo agregamos a la query
			if (carrito.getArmamento() != null) {
				if (campoPrevio) {
					query += ", ";
				}
				query += "armamento = ?";
				campoPrevio = true;
			}

			// Si la municion no es -1, lo agregamos a la query
			if (carrito.getMunicion() != -1) {
				if (campoPrevio) {
					query += ", ";
				}
				query += "municion = ?";
				campoPrevio = true;
			}

			// Agregamos el id del carrito
			query += " WHERE idCarritoGolf = ?";

			// preparamos la query
			PreparedStatement pstmt = con.prepareStatement(query);

			// Enlazamos los datos a las ? del preparedStatement
			int posInterrogacion = 1;

			if (carrito.getNumSerie() != null) {
				pstmt.setString(posInterrogacion, carrito.getNumSerie());
				posInterrogacion++;
			}

			if (carrito.getMarca() != null) {
				pstmt.setString(posInterrogacion, carrito.getMarca());
				posInterrogacion++;
			}

			if (carrito.getVelocidadMax() != -1) {
				pstmt.setInt(posInterrogacion, carrito.getVelocidadMax());
				posInterrogacion++;
			}

			if (carrito.getArmamento() != null) {
				pstmt.setString(posInterrogacion, carrito.getArmamento());
				posInterrogacion++;
			}
			if (carrito.getMunicion() != -1) {
				pstmt.setInt(posInterrogacion, carrito.getMunicion());
				posInterrogacion++;
			}

			pstmt.setInt(posInterrogacion, carrito.getIdCarritoGolf());

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
	 * Devuelve un carrito cuyo id sea el proporcionado
	 * 
	 * @param con
	 * @param id
	 * @return CarritoDO o null
	 */
	public static CarritoDO cargar(Connection con, int id) {
		try {
			// Query para cargar el carrito con el id
			String query = "SELECT * FROM carritogolf WHERE idCarritoGolf=?";

			// preparamos la query
			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setInt(1, id);

			// Ejecutamos la query
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				// Creamos un CarritoDO y le añadimos los datos del de la base de datos
				CarritoDO carrito = new CarritoDO();
				carrito.setIdCarritoGolf(rs.getInt("idCarritoGolf"));
				carrito.setNumSerie(rs.getString("numSerie"));
				carrito.setMarca(rs.getString("marca"));
				carrito.setVelocidadMax(rs.getInt("velocidadMax"));
				carrito.setArmamento(rs.getString("armamento"));
				carrito.setMunicion(rs.getInt("municion"));
				// Devolvemos el carrito
				return carrito;
			}

			// Si algo sale mal, devolvemos null
			return null;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
