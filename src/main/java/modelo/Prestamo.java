package modelo;

import java.time.LocalDateTime; //Para obtener fechas gaaaa
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Prestamo{
	private Libro libro;
	private Usuario usuario;
	private LocalDateTime fechaPrestamo;
	private LocalDateTime fechaDevolucion;
	private EstadoPrestamo estado;
	
	public Prestamo(Libro libro, Usuario usuario) {
		this.libro = libro;
		this.usuario = usuario;
		this.fechaPrestamo = LocalDateTime.now(); //fecha actual
		this.fechaDevolucion = fechaPrestamo.plusDays(15); //como max 15 dias
		this.estado = EstadoPrestamo.ACTIVO;
	}

	public Libro getLibro() {
		return libro;
	}

	public Usuario getUsuario() {
		return usuario;
	}


	public LocalDateTime getFechaPrestamo() {
		return fechaPrestamo;
	}

	public LocalDateTime getFechaDevolucion() {
		return fechaDevolucion;
	}

	public EstadoPrestamo getEstado() {
		return estado;
	}

	public void setEstado(EstadoPrestamo estado) {
		this.estado = estado;
	}
	
	public String getFechasFormateadas() {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm", new Locale("es", "ES"));
	    
	    return String.format("\n\tFecha de préstamo: %s\n\tFecha de devolución: %s", 
	                         fechaPrestamo.format(formatter), 
	                         fechaDevolucion.format(formatter));
	}
	
	@Override
	public String toString() {
		return "Prestamo:" +
				"\n\tLibro = " + libro.getTitulo() +
				"\n\tUsuario = " + usuario.getNombre() +
				getFechasFormateadas() +
				"\n\tEstado = " + estado;
	}
}

