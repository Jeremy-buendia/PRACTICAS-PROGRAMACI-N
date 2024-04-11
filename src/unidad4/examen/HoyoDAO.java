package unidad4.examen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HoyoDAO {
	//Función que elimina un hoyo con el id dado
	public static int eliminar(int id, Connection con) {
		try {
			// Creamos una query
			String query = "DELETE FROM hoyo WHERE idHoyo=?";

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
}
