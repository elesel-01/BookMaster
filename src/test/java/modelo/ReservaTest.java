package modelo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

public class ReservaTest {
    private Reserva reserva;
    private Usuario usuario;
    private Libro libro;

    @BeforeEach
    public void setUp() {
    	usuario = new Usuario("Juan", "Perez", "correo@gmail.com", 12345678);
        libro = new Libro(1, "El Quijote", "Miguel de Cervantes", "Editorial X", 1605, "Novela");
        reserva = new Reserva(usuario, libro, EstadoReserva.COMPLETADA);
    }

    @Test
    public void testGetUsuario() {
        assertEquals(usuario, reserva.getUsuario());
    }

    @Test
    public void testGetLibro() {
        assertEquals(libro, reserva.getLibro());
    }

    @Test
    public void testGetFechaReserva() {
        LocalDateTime now = LocalDateTime.now();
        assertTrue(reserva.getFechaReserva().isBefore(now) || reserva.getFechaReserva().isEqual(now));
    }

    @Test
    public void testGetEstado() {
        assertEquals(EstadoReserva.COMPLETADA, reserva.getEstado());
    }

    @Test
    public void testSetEstado() {
        reserva.setEstado(EstadoReserva.CANCELADA);
        assertEquals(EstadoReserva.CANCELADA, reserva.getEstado());
    }

    @Test
    public void testGetFechaFormateada() {
        String fechaFormateada = reserva.getFechaFormateada();
        assertNotNull(fechaFormateada);
        assertFalse(fechaFormateada.isEmpty());
    }

    @Test
    public void testToString() {
        String reservaString = reserva.toString();
        assertNotNull(reservaString);
        assertTrue(reservaString.contains("Reserva:"));
        assertTrue(reservaString.contains("El Quijote"));
        assertTrue(reservaString.contains("Juan"));
    }
}

