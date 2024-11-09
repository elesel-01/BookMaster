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
	private EstadoPrestamo estado; // Estado del préstamo (ACTIVO, DEVUELTO, ATRASADO, FINALIZADO)

	public Prestamos(int id, Libro libro, Usuario usuario, LocalDateTime fechaPrestamo, int duracionDias) {
		this.id = id;
		this.libro = libro;
		this.usuario = usuario;
		this.fechaPrestamo = fechaPrestamo;
		// La fecha de devolución se calculará usado duracionDias, que deberá ser
		// proporcionada cuando se cree el objeto
		this.fechaDevolucion = fechaPrestamo.plusDays(duracionDias);
		this.estado = EstadoPrestamo.ACTIVO; // Al crear un préstamo, su estado inicial es ACTIVO
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

	public EstadoPrestamo getEstado() {
		return estado;
	}

	public void setEstado(EstadoPrestamo estado) {
		this.estado = estado;
	}

	/*public void finalizarPrestamo() {
		if (estado == EstadoPrestamo.ACTIVO) {
			this.estado = EstadoPrestamo.FINALIZADO; // Cambiar el estado a FINALIZADO
			libro.setDisponible(true); // Marcar el libro como disponible nuevamente
		}
	}*/

	public double calcularMulta() {
		if (estado == EstadoPrestamo.ACTIVO) {
			// Calcular los días de retraso si la fecha límite ya pasó
			long diasRetraso = ChronoUnit.DAYS.between(fechaDevolucion, LocalDateTime.now());
			if (diasRetraso > 0) {
				return diasRetraso * 2.0; // Multa por 2 solsitos por día de retraso
			}
		}
		return 0.0; // Si no hay retraso, la multa es cero
	}

	// Método para verificar si el préstamo está vencido
	public boolean estaVencido() {
		// Un préstamo está vencido si la fecha límite ya pasó y el estado sigue siendo
		// ACTIVO
		return LocalDateTime.now().isAfter(fechaDevolucion) && estado == EstadoPrestamo.ACTIVO;
	}

	// Método para obtener las fechas formateadas en un string
	public String getFechasFormateadas() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm", Locale.of("es", "ES"));

		return String.format("\n\tFecha de préstamo: %s\n\tFecha de devolución: %s", fechaPrestamo.format(formatter),
				fechaDevolucion.format(formatter));
	}

	public void extenderPlazo(int dias) {
		if (estado == EstadoPrestamo.ACTIVO || estado == EstadoPrestamo.ATRASADO) {
			this.fechaDevolucion = this.fechaDevolucion.plusDays(dias);
			System.out.println("El plazo del préstamo ha sido extendido en " + dias + " días.");
		} else {
			System.out.println("No se puede extender el plazo de un préstamo que no está activo.");
		}
	}

	@Override
	public String toString() {
		return "Prestamo:" + "\n\tLibro = " + libro.getTitulo() + "\n\tUsuario = " + usuario.getNombre()
				+ getFechasFormateadas() + "\n\tEstado = " + estado + "\nMulta = " + calcularMulta();
	}

}
