package modelo;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	private String nombre;
	private List<Libro> catalogo;
	private List<Usuario> usuariosRegistrados;
	// private List<Categoria> categorias; es que ya está dentro de catálogos debido
	// a que se agregan libros
	// private static int totalLibros; podemos usar catalogoLibros.size();
	// private static int totalUsuarios; podemos usar usuariosRegistrados.size()

	public Biblioteca(String nombre) {
		this.nombre = nombre;
		this.catalogo = new ArrayList<>();
		this.usuariosRegistrados = new ArrayList<>();
		// this.categorias = new ArrayList<>();
		// this.totalLibros = 0;
		// this.totalUsuarios = 0;
	}

	// Métodos
	public void agregarLibro(Libro libro) {
		if (libro != null) {
			catalogo.add(libro);
			System.out.println("Libro " + libro.getTitulo() + "añadido al catálgo.");
			// totalLibros++;
		} else {
			System.out.println("No se puede añadir un libro nulo");
		}
	}

	public void eliminarLibro(Libro libro) {
		if (catalogo.remove(libro)) {
			System.out.println("El libro " + libro.getTitulo() + " ha sido eliminado del catálogo.");
		} else {
			System.out.println("El libro no se encontró en el catálogo.");
		}
		// totalLibros--;
	}

	public Libro buscarLibroPorTitulo(String titulo) {
		for (Libro libro : catalogo) {
			if (libro.getTitulo().equalsIgnoreCase(titulo)) { // se puso equalsIgnoreCase
				return libro;
			}
		}
		System.out.println("Libro con título " + titulo + " no encontrado en el catálogo.");
		return null;
	}

	public void registrarUsuario(Usuario usuario) {
		if (usuario != null) {
			usuariosRegistrados.add(usuario);
			System.out.println("Usuario " + usuario.getNombre() + " registrado exitosamente.");
		} else {
			System.out.println("No se puede registrar un usuario nulo.");
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	// Método para obtener el catálogo (devuelve una copia de la lista)
	public List<Libro> getCatalogo() {
		return catalogo;
	}
	
	//Método para listar libros (devuelve una copia de la lista)
	public List<Libro> listarLibros() {
		return new ArrayList<>(catalogo);
	}
	
	// Método para listar usuarios (devuelve una copia de la lista)
	public List<Usuario> listarUsuario() {
		return new ArrayList<>(usuariosRegistrados);
	}

}