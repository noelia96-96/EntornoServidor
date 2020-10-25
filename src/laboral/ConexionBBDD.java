package laboral;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Noelia
 * @version 1.1
 * @since 1.8
 *
 */
public class ConexionBBDD {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver cargado");

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/empleado", "root", "");
			System.out.println("Conexion a empleado realizada con éxito");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

	}
}