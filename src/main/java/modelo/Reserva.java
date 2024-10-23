package modelo;

import java.time.LocalDateTime; //Para obtener fechas
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Reserva {
	private Usuario usuario;
	private Libro libro;
	private LocalDateTime fechaReserva;
	private EstadoReserva estado;
}