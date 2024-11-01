package modelo;

public class Libro {
	private int idEstanteria;
	private String titulo;
	private String autor; // cambiando tipo Autor a String
	private int cantidad;
	private int codigolibro;
	private boolean disponible;
	private String editorial;
	private int anioPublicacion;
	private String categoria;
	
	public Libro(int codigoLibro, int idEstanteria, String titulo, String autor, String editorial, int anioPublicacion, String categoria, boolean disponible) {
		this.idEstanteria = idEstanteria;
		this.titulo = titulo;
		this.autor = autor;
		this.disponible = disponible;
		this.editorial = editorial;
		this.anioPublicacion = anioPublicacion;
		this.categoria = categoria;
		this.codigolibro = codigoLibro;
		// autor.agregarObra(this); no entiendo.
	}

	/**************** Getters y Setters *********************/

	public int getIdEstanteria() {
		return idEstanteria;
	}

	public void setIdEstanteria(int idEstanteria) {
		this.idEstanteria = idEstanteria;
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
	
	@Override
	public String toString() {
	    return "Libro{" +
	    		"códigoLibro=" + codigolibro +
	            ", idEstanteria=" + idEstanteria +
	            ", titulo='" + titulo + '\'' +
	            ", autor='" + autor + '\'' +
	            ", cantidad=" + cantidad +
	            ", codigolibro=" + codigolibro +
	            ", disponible=" + (disponible ? "Sí" : "No") +
	            ", editorial='" + editorial + '\'' +
	            ", anioPublicacion=" + anioPublicacion +
	            ", categoria='" + categoria + '\'' +
	            '}';
	}
	/*
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
