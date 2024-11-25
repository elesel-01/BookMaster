package modelo;

public class Libro {
	private int idLibro;
	private int idEstanteria;
	private String titulo;
	private String autor; // cambiando tipo Autor a String
	private String editorial;
	private int anioPublicacion;
	private String categoria;
	private boolean disponible;
	
	public Libro(int idEstanteria, String titulo, String autor, String editorial, int anioPublicacion, String categoria, boolean disponible) {
		this.idEstanteria = idEstanteria;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.anioPublicacion = anioPublicacion;
		this.categoria = categoria;
		this.disponible = disponible;
		
		
	}

	/**************** Getters y Setters *********************/
	
	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	
	public int getIdEstanteria() {
		return idEstanteria;
	}

	public void setIdEstanteria(int idEstanteria) {
		this.idEstanteria = idEstanteria;
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
	
	@Override
	public String toString() {
	    return "Libro{idLibro=" + idLibro +
	           ", idEstanteria=" + idEstanteria +
	           ", titulo='" + titulo + '\'' +
	           ", autor='" + autor + '\'' +
	           ", editorial='" + editorial + '\'' +
	           ", anioPublicacion=" + anioPublicacion +
	           ", categoria='" + categoria + '\'' +
	           ", disponible=" + disponible +
	           '}';
	}

}
