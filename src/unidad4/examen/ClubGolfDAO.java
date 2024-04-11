package unidad4.examen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClubGolfDAO {
	
	/**
	 * Función que carga los datos de la tabla clubgolf con un id dado
	 * @param con
	 * @param id
	 * @return ClubGolfDO o null
	 */
	public static ClubGolfDO cargar(Connection con, int id) {
		try {
			// Query para cargar el avestruz con el id
			String query = "SELECT * FROM clubgolf WHERE idClubGolf=?";

			// preparamos la query
			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setInt(1, id);

			// Ejecutamos la query
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				// Creamos un AvestruzDO y le añadimos los datos del de la base de datos
				ClubGolfDO clubGolf = new ClubGolfDO();
				clubGolf.setIdClubGolf(rs.getInt("idClubGolf"));
				clubGolf.setNombre(rs.getString("nombre"));
				clubGolf.setLocalidad(rs.getString("localidad"));
				clubGolf.setRecordGolpes(rs.getInt("recordGolpes"));
				clubGolf.setEscuela(rs.getBoolean("Escuela"));

				// Devolvemos el avestruz
				return clubGolf;
			}

			// Si algo sale mal, devolvemos null
			return null;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * Función que modifica un dato concreto de la tabla clubgolf
	 * @param con
	 * @param id
	 * @param campo
	 * @param valor
	 * @return 1 o -1
	 */
	public static int actualizar(Connection con, int id, String campo, String valor) {
		try {
			boolean campoEncontrado = false;
			String[] campos = {"idClubGolf", "nombre", "localidad", "recordGolpes", "Escuela"};
			
			int j = 0;
			
			for(int i=0; i< campos.length; i++) {
				if(campo.equals(campos[i])) {
					campoEncontrado = true;
				}
			}
			
			if(campoEncontrado) {
				String query;
				if(campo.equals("idClubGolf")) {
					query = "UPDATE clubgolf SET idClubGolf = ? WHERE idClubGolf = ?";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setInt(1, Integer.parseInt(valor));
					pstmt.setInt(2,  id);
					pstmt.executeUpdate();
					return 1;
					
				}else if(campo.equals("nombre")) {
					query = "UPDATE clubgolf SET nombre = ? WHERE idClubGolf = ?";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1, valor);
					pstmt.setInt(2,  id);
					pstmt.executeUpdate();
					return 1;
					
				}else if(campo.equals("localidad")) {
					query = "UPDATE clubgolf SET localidad = ? WHERE idClubGolf = ?";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1, valor);
					pstmt.setInt(2,  id);
					pstmt.executeUpdate();
					return 1;
					
				}else if(campo.equals("recordGolpes")){
					query = "UPDATE clubgolf SET recordGolpes = ? WHERE idClubGolf = ?";
					PreparedStatement pstmt = con.prepareStatement(query);
					if(esEntero(valor)== 0) {
						pstmt.setInt(1, Integer.parseInt(valor));						
					}else {
						return -1;
					}
					pstmt.setInt(2,  id);
					pstmt.executeUpdate();
					return 1;
					
				}else if(campo.equals("Escuela")) {
					query = "UPDATE clubgolf SET Escuela = ? WHERE idClubGolf = ?";
					PreparedStatement pstmt = con.prepareStatement(query);
					if(valor.equals("true")) {
						pstmt.setBoolean(1, true);
					}else if(valor.equals("false")) {
						pstmt.setBoolean(1, false);
					}else {
						return -1;
					}
					pstmt.setInt(2,  id);
					pstmt.executeUpdate();
					return 1;
				}
			}
			
			return -1;
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
	
	public static int esEntero(String valor) {
		try {
			Integer.parseInt(valor);
			return 0;
		} catch (NumberFormatException e) {
			return -1;
		}
	}

}
	

