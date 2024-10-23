package modelo;

import java.util.ArrayList;
import java.util.List;
public class Usuario {
    private String nombre;
    private String id;
    private List<Prestamo> historialPrestamos;
    private List<Reserva> reservasActivas;

    // Constructor
    public Usuario(String nombre) {
        this.nombre = nombre;
        this.id = id;
        this.historialPrestamos = new ArrayList<>();
        this.reservasActivas = new ArrayList<>();
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Prestamo> getHistorialPrestamos() {
        return historialPrestamos;
    }

    public List<Reserva> getReservasActivas() {
        return reservasActivas;
    }

    public void verHistorialPrestamos() {
        System.out.println("Historial de préstamos de " + nombre + ":");
        for (Prestamo prestamo : historialPrestamos) {
            System.out.println(prestamo);
        }
    }
  
    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

}