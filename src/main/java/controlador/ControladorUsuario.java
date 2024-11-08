package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base_de_datos.Coneccion;
import modelo.Usuario;

public class ControladorUsuario {

	/*
	 * Serviría posteriormente para poner a todos los usuario temporalmente en la
	 * RAM y no estar consultando la base de datos
	 */
	private List<Usuario> usuarios = new ArrayList<>();

	public ControladorUsuario() {
		cargarUsuariosDesdeBaseDeDatos(); // Cargar los usuarios desde la base de datos al momento de instanciar el
											// controlador
	}

	// Cargamos tantos usuarios como administradores
	public void cargarUsuariosDesdeBaseDeDatos() {
		Coneccion db = new Coneccion();
		try (Connection connection = db.getConnection()) {
			String sql = "SELECT * FROM usuario";
			try (PreparedStatement statement = connection.prepareStatement(sql);
					ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					String nombre = resultSet.getString("nombre");
					String apellido = resultSet.getString("apellido");
					String correo = resultSet.getString("email");
					int dni = resultSet.getInt("dni");
					String rol = resultSet.getString("rol");
					String contrasena = resultSet.getString("passw");
					Usuario usuario = new Usuario(nombre, apellido, correo, dni, rol);
					usuario.setPassw(contrasena);
					usuarios.add(usuario); // Agregar cada usuario a la lista
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Funcion para autenticar al usuario
	public Usuario autenticarUsuario(String correo, String contrasena) {
		for (Usuario usuario : usuarios) {
			if (usuario.getEmail().equals(correo) && usuario.getPassw().equals(contrasena)) {
				return usuario;
			}
		}
		return null;
	}
	
	// Funcion para registrar Usuario
	public void registrarUsuario(String nombre, String apellido, String correo, int dni, String contrasena,
			String rol) {
		// Verificar si el usuario ya existe en la lista
		for (Usuario usuario : usuarios) {
			if (usuario.getEmail().equals(correo)) { // Verificar si el correo ya existe en la lista
				System.out.println("El usuario con el correo " + correo + " ya está registrado.");
				return;
			}
			if (usuario.getDni() == dni) { // Verificar si el DNI ya existe en la lista
				System.out.println("El usuario con el DNI " + dni + " ya está registrado.");
				return;
			}
		}

		// Crear el nuevo usuario y agregarlo a la lista
		Usuario nuevoUsuario = new Usuario(nombre, apellido, correo, dni, rol);
		nuevoUsuario.setPassw(contrasena);
		usuarios.add(nuevoUsuario);

		// Insertar el usuario en la base de datos
		Coneccion db = new Coneccion();
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
				System.out.println("Usuario registrado con éxito.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*public List<Libro> buscarLibroPorNombre(String nombre) {
		List<Libro> libros = new ArrayList<>();
		Coneccion db = new Coneccion();
		try (Connection connection = db.getConnection()) {
			String sql = "SELECT * FROM libro WHERE titulo LIKE ?";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setString(1, "%" + nombre + "%");
				try (ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {
						Libro libro = new Libro(resultSet.getInt("idEstanteria"), resultSet.getString("titulo"),
								resultSet.getString("autor"), resultSet.getString("editorial"),
								resultSet.getInt("anioPublicacion"), resultSet.getString("categoria"),
								resultSet.getBoolean("disponible"));
						libro.setIdLibro(resultSet.getInt("idLibro"));
						libros.add(libro);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return libros;
	}

	public List<Libro> buscarLibroPorAutor(String autor) {
		List<Libro> libros = new ArrayList<>();
		Coneccion db = new Coneccion();
		try (Connection connection = db.getConnection()) {
			String sql = "SELECT * FROM libro WHERE autor LIKE ?";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setString(1, "%" + autor + "%");
				try (ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {
						Libro libro = new Libro(resultSet.getInt("idEstanteria"), resultSet.getString("titulo"),
								resultSet.getString("autor"), resultSet.getString("editorial"),
								resultSet.getInt("anioPublicacion"), resultSet.getString("categoria"),
								resultSet.getBoolean("disponible"));
						libro.setIdLibro(resultSet.getInt("idLibro"));
						libros.add(libro);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return libros;
	}

	public List<Libro> buscarLibroPorCategoria(String categoria) {
		List<Libro> libros = new ArrayList<>();
		Coneccion db = new Coneccion();
		try (Connection connection = db.getConnection()) {
			String sql = "SELECT * FROM libro WHERE categoria LIKE ?";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setString(1, "%" + categoria + "%");
				try (ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {
						Libro libro = new Libro(resultSet.getInt("idEstanteria"), resultSet.getString("titulo"),
								resultSet.getString("autor"), resultSet.getString("editorial"),
								resultSet.getInt("anioPublicacion"), resultSet.getString("categoria"),
								resultSet.getBoolean("disponible"));
						libro.setIdLibro(resultSet.getInt("idLibro"));
						libros.add(libro);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return libros;
	}
	
	public static void mostrarLibros(List<Libro> libros) {
		if (libros.isEmpty()) {
			System.out.println("No se encontraron libros.");
		} else {
			for (Libro libro : libros) {
				System.out.println(libro);
			}
		}
	}*/

	public void verMisDatos(Usuario usuarioLogueado) {
		if (usuarioLogueado != null) {
			System.out.println("Nombre: " + usuarioLogueado.getNombre());
			System.out.println("Apellido: " + usuarioLogueado.getApellido());
			System.out.println("Correo: " + usuarioLogueado.getEmail());
			System.out.println("DNI: " + usuarioLogueado.getDni());
			System.out.println("Contraseña: " + usuarioLogueado.getPassw());
		}
	}

	/*
	 * public List<Libros> misLibros(){ List<Libros> libros = new ArrayList<>();
	 * Coneccion db = new Coneccion();
	 * 
	 * }
	 */

	public void salir(boolean salir) {
		System.out.println("Ha salido de la aplicación.");
		salir = true;
	}
}