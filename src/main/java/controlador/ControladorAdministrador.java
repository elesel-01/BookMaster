package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base_de_datos.Coneccion;
import modelo.Libro;
import modelo.Usuario;

public class ControladorAdministrador {
	private List<Libro> libros = new ArrayList<>();

	private List<Usuario> usuarios = new ArrayList<>();

	Coneccion db = new Coneccion();

	public void registrarLibro(int idEstanteria, String titulo, String autor, String editorial, int anioPublicacion,
			String categoria, boolean disponible) {
		Libro nuevoLibro = new Libro(idEstanteria, titulo, autor, editorial, anioPublicacion, categoria, disponible);
		libros.add(nuevoLibro);

		try (Connection connection = db.getConnection()) {
			String sql = "INSERT INTO libro(idEstanteria, titulo, autor, editorial, anioPublicacion, categoria, disponible) VALUES(?,?,?,?,?,?,?)";
			try (PreparedStatement ps = connection.prepareStatement(sql)) {
				ps.setInt(1, idEstanteria);
				ps.setString(2, titulo);
				ps.setString(3, autor);
				ps.setString(4, editorial);
				ps.setInt(5, anioPublicacion);
				ps.setString(6, categoria);
				ps.setBoolean(7, disponible);
				ps.execute();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eliminarLibro(int idLibro) {

		try (Connection connection = db.getConnection()) {
			String sql = "DELETE FORM libro WHERE idLibro=?";
			try (PreparedStatement ps = connection.prepareStatement(sql)) {
				ps.setInt(1, idLibro);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void listarLibros() {
		
		String [] listarLibros = new String[8];
		try {
			Connection connection = db.getConnection();
            String sql = "SELECT * FROM libro";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeQuery();
            while(ps.getResultSet().next()) {
                listarLibros[0] = ps.getResultSet().getString("idLibro");
                listarLibros[1] = ps.getResultSet().getString("idEstanteria");
                listarLibros[2] = ps.getResultSet().getString("titulo");
                listarLibros[3] = ps.getResultSet().getString("autor");
                listarLibros[4] = ps.getResultSet().getString("editorial");
                listarLibros[5] = ps.getResultSet().getString("anioPublicacion");
                listarLibros[6] = ps.getResultSet().getString("categoria");
                listarLibros[7] = ps.getResultSet().getString("disponible");	
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	// Se añade el método registrarUsuario, no aplica buena práctica de POO debido a
	// que podríamos aplicar herencia
	public void registrarUsuario(String nombre, String apellido, String correo, int dni, String contrasena,
			String rol) {
		Usuario nuevoUsuario = new Usuario(nombre, apellido, correo, dni, rol);
		nuevoUsuario.setPassw(contrasena);
		usuarios.add(nuevoUsuario);

		// Insertar el usuario a la base de datos
		
		try (Connection connection = db.getConnection()) {
			String sql = "INSERT INTO usuario (nombre, apellido, email, dni, passw, rol) VALUES (?, ?, ?, ?, ?, ?)";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setString(1, nombre);
				statement.setString(2, apellido);
				statement.setString(3, correo);
				statement.setInt(4, dni);
				statement.setString(5, contrasena);
				statement.setString(6, rol);
				statement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
