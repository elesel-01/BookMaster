package controlador;

import java.util.ArrayList;

public class ControladorAdministrador {
	private List<Libro> libros = new ArrayList<>();
	
	public void registrarLibro(String titulo, String autor, String editorial, int anioPublicacion, String categoria,
			int cantidad, boolean disponible) {
		Libro nuevoLibro = new Libro(titulo, autor, editorial, anioPublicacion, categoria, cantidad, disponible);
		libros.add(nuevoLibro);
	}
}
