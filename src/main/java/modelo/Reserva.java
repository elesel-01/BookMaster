package modelo;

import java.time.LocalDateTime; //Para obtener fechas
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Reserva {
    private Usuario usuario;
    private Libro libro;
    private LocalDateTime fechaReserva;
    private EstadoReserva estado;
    // Constructor
    public Reserva(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaReserva = LocalDateTime.now(); // Fecha actual para la reserva
        this.estado = EstadoReserva.PENDIENTE; // Al crear una reserva, su estado inicial
    }

    // Getters y setters
    public Usuario getUsuario() {
        return usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }

    // Método para formatear la fecha de reserva
    public String getFechaFormateada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm", Locale.of("es", "ES"));
        return fechaReserva.format(formatter);
    }

    @Override
    public String toString() {
        return "Reserva:" +
                "\n\tLibro = " + libro.getTitulo() +
                "\n\tUsuario = " + usuario.getNombre() +
                "\n\tFecha de reserva = " + getFechaFormateada() +
                "\n\tEstado = " + estado;
    }
}