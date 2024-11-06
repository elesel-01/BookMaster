package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base_de_datos.Coneccion;
import consola_consola.Consola;
import modelo.Usuario;
import modelo.Libro;

public class ControladorUsuario {
	
	private List<Usuario> usuarios = new ArrayList<>();

	public Usuario autenticarUsuario(String correo, String contrasena) {
		Coneccion db = new Coneccion();
		try (Connection connection = db.getConnection()) {
			String sql = "SELECT * FROM usuario WHERE email = ? AND passw = ?";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setString(1, correo);
				statement.setString(2, contrasena);
				try (ResultSet resultSet = statement.executeQuery()) {
					if (resultSet.next()) {
						String nombre = resultSet.getString("nombre");
						String apellido = resultSet.getString("apellido");
						int dni = resultSet.getInt("dni");
						String rol = resultSet.getString("rol");
						Usuario usuario = new Usuario(nombre, apellido, correo, dni, rol);
						usuario.setPassw(contrasena);
						return usuario;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void registrarUsuario(String nombre, String apellido, String correo, int dni, String contrasena,
			String rol) {
		Usuario nuevoUsuario = new Usuario(nombre, apellido, correo, dni, rol);
		nuevoUsuario.setPassw(contrasena);
		usuarios.add(nuevoUsuario);

		// Insertar el usuario a la base de datos
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Libro> buscarLibroPorNombre(String nombre) {
	    List<Libro> libros = new ArrayList<>();
	    Coneccion db = new Coneccion();
	    try (Connection connection = db.getConnection()) {
	        String sql = "SELECT * FROM libro WHERE titulo LIKE ?";
	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setString(1, "%" + nombre + "%");
	            try (ResultSet resultSet = statement.executeQuery()) {
	                while (resultSet.next()) {
	                    Libro libro = new Libro(
	                        resultSet.getInt("idEstanteria"),
	                        resultSet.getString("titulo"),
	                        resultSet.getString("autor"),
	                        resultSet.getString("editorial"),
	                        resultSet.getInt("anioPublicacion"),
	                        resultSet.getString("categoria"),
	                        resultSet.getBoolean("disponible")
	                    );
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
	                    Libro libro = new Libro(
	                        resultSet.getInt("idEstanteria"),
	                        resultSet.getString("titulo"),
	                        resultSet.getString("autor"),
	                        resultSet.getString("editorial"),
	                        resultSet.getInt("anioPublicacion"),
	                        resultSet.getString("categoria"),
	                        resultSet.getBoolean("disponible")
	                    );
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
	                    Libro libro = new Libro(
	                        resultSet.getInt("idEstanteria"),
	                        resultSet.getString("titulo"),
	                        resultSet.getString("autor"),
	                        resultSet.getString("editorial"),
	                        resultSet.getInt("anioPublicacion"),
	                        resultSet.getString("categoria"),
	                        resultSet.getBoolean("disponible")
	                    );
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
	}
	
	public void verMisDatos(Usuario usuarioLogueado) {
		if(usuarioLogueado != null) {
			System.out.println("Nombre: " + usuarioLogueado.getNombre());
			System.out.println("Apellido: " + usuarioLogueado.getApellido());
			System.out.println("Correo: " + usuarioLogueado.getEmail());
			System.out.println("DNI: " + usuarioLogueado.getDni());
			System.out.println("Contraseña: " + usuarioLogueado.getPassw());
		}
	}
	
	public void salir(boolean salir) {
		System.out.println("Ha salido de la aplicación.");
		salir = true;
	}
}