package unidad4.examen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SocioDAO {
	/**
	 * Función que inserta un nuevo miembro a la base de datos
	 * @param socio
	 * @param con
	 * @return 1 o 0
	 */
	public static int insertar(SocioDO socio, Connection con) {
		int id = 0;
		try {
			if(socio.getIdSocio() > 0) {
				// Si el id dado es mayor de 0
				// Creamos la sentencia a ejecutar
				String querySelect = "SELECT * FROM socio WHERE idSocio= ?";
				// 1º - Creamos un Prepared Statement
				PreparedStatement pstmtSelect = con.prepareStatement(querySelect);
				// 2º - Seleccionamos el valor a la ?
				pstmtSelect.setInt(1, socio.getIdSocio());
				// 3º - Ejecutamos la query y los resultados quedan en el resultSet
				ResultSet rs = pstmtSelect.executeQuery();
				if (rs.next()) {
					id = rs.getInt("idSocio");
				}
				
				//Si el id coincide con el introducido, ya existe
				if(id == socio.getIdSocio()) {
					//Devolvemos 0
					return 0;
				}
				
				
				String query = "INSERT INTO socio (idSocio, nombre, edad, sexo, cuota) VALUES(?, ?, ?, ?, ?)";

				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setInt(1, socio.getIdSocio());
				pstmt.setString(2, socio.getNombre());
				pstmt.setInt(3, socio.getEdad());
				pstmt.setInt(4, socio.getSexo());
				pstmt.setInt(5, socio.getCuota());
				
				pstmt.executeUpdate();

				return 1;
			}else {
				
				String query = "INSERT INTO socio (nombre, edad, sexo, cuota) VALUES(?, ?, ?, ?)";

				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, socio.getNombre());
				pstmt.setInt(2, socio.getEdad());
				pstmt.setInt(3, socio.getSexo());
				pstmt.setInt(4, socio.getCuota());
				
				pstmt.executeUpdate();

				return 1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			// Devolvemos el error
			return 0;
		}
	}
}
