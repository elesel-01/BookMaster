package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import base_de_datos.Coneccion;
import modelo.Libro;
import modelo.Usuario;
import modelo.Prestamos;

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
			String sql = "DELETE FROM libro WHERE idLibro=?";
			try (PreparedStatement ps = connection.prepareStatement(sql)) {
				ps.setInt(1, idLibro);
				ps.executeUpdate();
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
                System.out.println("ID Libro: "+listarLibros[0]+" ID Estanteria: "+listarLibros[1]+" Titulo: "+listarLibros[2]+" Autor: "+listarLibros[3]+" Editorial: "+listarLibros[4]+" Año de Publicacion: "+listarLibros[5]+" Categoria: "+
                listarLibros[6]+" Disponible: "+listarLibros[7]);
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
	
	public void librosPrestados() {
	    String[] librosPrestados = new String[3];

	    try {
	        Connection connection = db.getConnection();
	        String sql = "SELECT prestamo.idPrestamo, libro.titulo, usuario.dni " +
	                     "FROM prestamo " +
	                     "JOIN libro ON prestamo.idLibro = libro.idLibro " +
	                     "JOIN usuario ON prestamo.idUsuario = usuario.idUsuario";
	        PreparedStatement ps = connection.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();

	        // Procesar los resultados
	        while (rs.next()) {
	            librosPrestados[0] = rs.getString("idPrestamo");
	            librosPrestados[1] = rs.getString("titulo");
	            librosPrestados[2] = rs.getString("dni");

	            System.out.println("ID Prestamo: " + librosPrestados[0] + 
	                               " Titulo: " + librosPrestados[1] + 
	                               " DNI: " + librosPrestados[2]);
	        }

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void eliminarUsuario(int idUsuario) {
		Iterator<Usuario> iterator = usuarios.iterator(); // Iterator se usa porque se necesita eliminar un objeto de la lista
		while (iterator.hasNext()) { // La condicion sinifica que si el iterador tiene un siguiente elemento
			Usuario usuario = iterator.next(); // Va a la siguiente posicion
			if (usuario.getId() == idUsuario) {
				iterator.remove(); // Elimina el objeto de la lista
				break; // Termina el ciclo cuando se elimina el objeto
			}
		}
		
		//Eliminar el usuario de la base de datos
		try (Connection connection = db.getConnection()){
			String sql = "DELETE FROM usuario WHERE idUsuario=?";
			try (PreparedStatement ps = connection.prepareStatement(sql)) {
				ps.setInt(1, idUsuario);
				int filasAfectada = ps.executeUpdate();
				if (filasAfectada <= 0) {
					System.out.println("No se encontro el usuario con el id: " + idUsuario);
				} else {
					System.out.println("Usuario eliminado con éxito.");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void verMorosos() {
	    try {
	        Connection connection = db.getConnection();
	        
	        String sql = "SELECT prestamo.idPrestamo, libro.titulo, usuario.dni, prestamo.fechaEntrega " +
	                     "FROM prestamo " +
	                     "JOIN libro ON prestamo.idLibro = libro.idLibro " +
	                     "JOIN usuario ON prestamo.idUsuario = usuario.idUsuario " +
	                     "WHERE prestamo.fechaEntrega < NOW()";  // Trae solo los registros con fecha de entrega vencida
	        
	        PreparedStatement ps = connection.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        
	        boolean hayMorosos = false;
	        
	        while (rs.next()) {
	            hayMorosos = true;
	            String idPrestamo = rs.getString("idPrestamo");
	            String titulo = rs.getString("titulo");
	            String dni = rs.getString("dni");
	            String fechaEntrega = rs.getString("fechaEntrega");
	            
	            System.out.println("ID Prestamo: " + idPrestamo + " Titulo: " + titulo + " DNI: " 
	                               + dni + " Fecha de Entrega: " + fechaEntrega);
	        }
	        
	        if (!hayMorosos) {
	            System.out.println("No hay morosos");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}
