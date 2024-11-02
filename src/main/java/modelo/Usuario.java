package modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String passw;
    private int dni;
    private String rol;
    //private List<Prestamo> historialPrestamos;
    //private List<Reserva> reservasActivas;

    // Constructor
    public Usuario(String nombre, String apellido, String email, int dni, String rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.dni = dni;
        this.rol = rol;
        //this.historialPrestamos = new ArrayList<>();
        //this.reservasActivas = new ArrayList<>();
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email= email;
	}
	
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
	public int getDni() {
		return dni;
	}
	
	public void setDni(int dni) {
		this.dni= dni;
	}
	
	public String getPassw() {
		return passw;
	}
	
	public void setPassw(String passw) {
		this.passw= passw;
	}
	
	public String getRol() {
		return rol;
	}
	
	public void setRol(String rol) {
		this.rol = rol;
	}
	
}

    /*public List<Prestamo> getHistorialPrestamos() {
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
    }*/