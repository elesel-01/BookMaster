package modelo;

public class Libro {
	private int id;
	private String titulo;
	private String autor; // cambiando tipo Autor a String
	private int cantidad;
	private int codigolibro;
	private boolean disponible;
	private String editorial;
	private int anioPublicacion;
	private String categoria;

	/*public Libro(int id, String titulo, String autor, String editorial, int anioPublicacion, String categoria) {
		this.titulo = titulo;
		this.autor = autor;
		this.id = id;
		this.disponible = true; // Inicialmente el libro está disponible
		this.editorial = editorial;
		this.anioPublicacion = anioPublicacion;
		this.categoria = categoria;

		// autor.agregarObra(this); no entiendo.
	}*/

	/**************** Getters y Setters *********************/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public int getCodigolibro() {
		return codigolibro;
	}
	
	public void setCodigolibro(int codigolibro) {
        this.codigolibro = codigolibro;
    }
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getAnioPublicacion() {
		return anioPublicacion;
	}

	public void setAnioPublicacion(int anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	/******************************************************/

	// parecido a usar toString
	/*public void mostrarDetalles() {
		System.out.println("Título: " + titulo);
		System.out.println("Autor: " + autor);
		System.out.println("ID: " + id);
		System.out.println("Editorial: " + editorial);
		System.out.println("Año de Publicación: " + anioPublicacion);
		System.out.println("Categoría: " + categoria );
		System.out.println("Disponible: " + (disponible ? "Sí" : "No"));
	}

	public void prestar() {
		if (disponible) {
			disponible = false;
			System.out.println("Libro prestado correctamente.");
		} else {
			System.out.println("El libro no está disponible para prestar.");
		}
	}

	public void devolver() {
		if (!disponible) {
			disponible = true;
			System.out.println("Libro devuelto correctamente.");
		} else {
			System.out.println("El libro ya estaba disponible.");
		}
	}

	public void reserva(Usuario usuario) {
		System.out.println("El libro ha sido reservado por " + usuario.getNombre());
	}*/

}
