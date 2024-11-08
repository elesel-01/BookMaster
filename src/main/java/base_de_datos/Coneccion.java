package base_de_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Coneccion {
	// Driver actualizado al más reciente
		
		private static String driver = "com.mysql.cj.jdbc.Driver";
		private static String usuario = "root";
		private static String password = "75435768";
		// URL de la base de datos con ajuste para evitar advertencias de zona horaria y SSL
		private static String url = "jdbc:mysql://localhost:3306/bookmaster?useSSL=false&serverTimezone=UTC";

		Connection con = null;

		// Método para obtener la conexión
		public Connection getConnection() {
			try {
				Class.forName(driver);
				// Intentamos conectar a la base de datos usando DriverManager
				con = DriverManager.getConnection(url, usuario, password);
				// System.out.println("Conectado a MySQL");
			} catch (ClassNotFoundException e) {
				// Capturamos e imprimimos cualquier error que ocurra al intentar cargar el driver
				e.printStackTrace();
				System.out.println("Error de driver");
			} catch (SQLException e) {
				// Capturamos e imprimimos cualquier error que ocurra al intentar conectarse
				e.printStackTrace();
				System.out.println("Error de conexión");
			}
			return con;
		}
		
		public static void main(String[] args) {
			Coneccion db = new Coneccion();
			Connection connection = db.getConnection();
			// Si la conexión fue exitosa, imprime un mensaje
			if (connection != null) {
				System.out.println("La conexión se realizó correctamente.");
			} else {
				System.out.println("Hubo un problema con la conexión.");
			}
		}

}
