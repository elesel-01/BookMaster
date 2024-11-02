package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import base_de_datos.Coneccion;
import modelo.Libro;

public class ControladorAdministrador {
	private List<Libro> libros = new ArrayList<>();
	
	public void registrarLibro(int idEstanteria,String titulo, String autor, String editorial, int anioPublicacion, String categoria, boolean disponible) {
		Libro nuevoLibro = new Libro(idEstanteria,titulo, autor, editorial, anioPublicacion, categoria, disponible);
		libros.add(nuevoLibro);
		
		Coneccion db = new Coneccion();
		
		try(Connection connection = db.getConnection()){
			String sql= "INSERT INTO libro(idEstanteria, titulo, autor, editorial, anioPublicacion, categoria, disponible) VALUES(?,?,?,?,?,?,?)";
			try(PreparedStatement ps =connection.prepareStatement(sql)){
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
}
