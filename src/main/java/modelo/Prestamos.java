package modelo;

import java.time.LocalDateTime; //Para obtener fechas gaaaa
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.time.temporal.ChronoUnit;

public class Prestamos {
	private int id;
	private Libro libro;
	private Usuario usuario;
	private LocalDateTime fechaPrestamo; // fecha y hora en la que comienza el préstamo
	private LocalDateTime fechaDevolucion; // fecha límite para la devolución del libro

	public Prestamos(int id, Libro libro, Usuario usuario, LocalDateTime fechaPrestamo, int duracionDias) {
		this.id = id;
		this.libro = libro;
		this.usuario = usuario;
		this.fechaPrestamo = fechaPrestamo;
		// La fecha de devolución se calculará usado duracionDias, que deberá ser
		// proporcionada cuando se cree el objeto
		this.fechaDevolucion = fechaPrestamo.plusDays(duracionDias);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDateTime getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(LocalDateTime fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public LocalDateTime getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(LocalDateTime fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

}
