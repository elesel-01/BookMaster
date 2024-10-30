package modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String apellido;
    private String email;
    private int dni;
    private List<Prestamo> historialPrestamos;
    private List<Reserva> reservasActivas;

    // Constructor
    public Usuario(String nombre, String apellido, String email, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.dni = dni;
        this.historialPrestamos = new ArrayList<>();
        this.reservasActivas = new ArrayList<>();
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return dni;
    }

    public void setId(int id) {
        this.dni = id;
    }

    public List<Prestamo> getHistorialPrestamos() {
        return historialPrestamos;
    }

    public List<Reserva> getReservasActivas() {
        return reservasActivas;
    }

    // Métodos para realizar acciones

    public void solicitarPrestamo(Libro libro) {
        if (libro != null) {
            Prestamo nuevoPrestamo = new Prestamo(dni, libro, this, fechaPrestamo, duracionDias);
            historialPrestamos.add(nuevoPrestamo);
            System.out.println(nombre + " ha realizado un préstamo del libro: " + libro.getTitulo());
        } else {
            System.out.println("No se puede realizar el préstamo. Libro inválido.");
        }
    }

    public void devolverLibro(Libro libro) {
        Prestamo prestamoActivo = null;
        for (Prestamo prestamo : historialPrestamos) {
            if (prestamo.getLibro().equals(libro) && prestamo.getEstado() == EstadoPrestamo.ACTIVO) {
                prestamoActivo = prestamo;
                break;
            }
        }
        if (prestamoActivo != null) {
            prestamoActivo.setEstado(EstadoPrestamo.DEVUELTO);
            System.out.println("El libro " + libro.getTitulo() + " ha sido devuelto por " + nombre);
        } else {
            System.out.println("No se encontró ningún préstamo activo para el libro: " + libro.getTitulo());
        }
    }

    public void verHistorialPrestamos() {
        System.out.println("Historial de préstamos de " + nombre + ":");
        for (Prestamo prestamo : historialPrestamos) {
            System.out.println(prestamo);
        }
    }

    public void realizarReserva(Libro libro) {
        if (libro != null) {
            Reserva nuevaReserva = new Reserva(this, libro, EstadoReserva.PENDIENTE);
            reservasActivas.add(nuevaReserva);
            System.out.println(nombre + " ha realizado una reserva para el libro: " + libro.getTitulo());
        } else {
            System.out.println("No se puede realizar la reserva. Libro inválido.");
        }
    }

    public void cancelarReserva(Libro libro) {
        Reserva reservaActiva = null;
        for (Reserva reserva : reservasActivas) {
            if (reserva.getLibro().equals(libro) && reserva.getEstado() == EstadoReserva.PENDIENTE) {
                reservaActiva = reserva;
                break;
            }
        }
        if (reservaActiva != null) {
            reservaActiva.setEstado(EstadoReserva.CANCELADA);
            System.out.println("La reserva del libro " + libro.getTitulo() + " ha sido cancelada por " + nombre);
        } else {
            System.out.println("No se encontró ninguna reserva pendiente para el libro: " + libro.getTitulo());
        }
    }
}