package controlador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Libro;
import modelo.Usuario;

class ControladorReservaTest {

    private ControladorReserva controladorReserva;
    private ControladorLibro controladorLibro;
    private ControladorUsuario controladorUsuario;

    @BeforeEach
    void setUp() {
        controladorReserva = new ControladorReserva();
        controladorLibro = new ControladorLibro();
        controladorUsuario = new ControladorUsuario();

        // Cargar los datos iniciales desde la base de datos
        controladorLibro.cargarLibrosDesdeBaseDeDatos();
        controladorUsuario.cargarUsuariosDesdeBaseDeDatos();
    }

    @Test
    void testSolicitarLibroDisponible() {
        // Escenario: Libro disponible
        Libro libroDisponible = controladorLibro.buscarLibroPorNombre("Harry Potter").stream()
                .filter(Libro::isDisponible) // Buscar un libro que esté disponible
                .findFirst()
                .orElse(null);

        assertNotNull(libroDisponible, "No se encontró un libro disponible para la prueba.");

        Usuario usuario = controladorUsuario.autenticarUsuario("correo@ejemplo.com", "contraseña123");
        assertNotNull(usuario, "El usuario debería autenticarse correctamente antes de solicitar un libro.");

        // Solicitar el libro
        controladorReserva.solicitarLibro(libroDisponible.getIdLibro(), usuario.getId());

        // Verificar que el libro ya no está disponible
        Libro libroActualizado = controladorLibro.buscarLibroPorNombre(libroDisponible.getTitulo()).get(0);
        assertFalse(libroActualizado.isDisponible(), "El libro debería estar marcado como no disponible.");
    }

    @Test
    void testSolicitarLibroNoDisponible() {
        // Escenario: Libro no disponible
        Libro libroNoDisponible = controladorLibro.buscarLibroPorNombre("Harry Potter").stream()
                .filter(libro -> !libro.isDisponible()) // Buscar un libro que no esté disponible
                .findFirst()
                .orElse(null);

        if (libroNoDisponible == null) {
            System.out.println("No hay libros no disponibles para esta prueba. Ignorando el caso.");
            return;
        }

        Usuario usuario = controladorUsuario.autenticarUsuario("correo@ejemplo.com", "contraseña123");
        assertNotNull(usuario, "El usuario debería autenticarse correctamente antes de solicitar un libro.");

        // Solicitar el libro no disponible
        controladorReserva.solicitarLibro(libroNoDisponible.getIdLibro(), usuario.getId());

        // Verificar que el libro sigue no disponible
        Libro libroActualizado = controladorLibro.buscarLibroPorNombre(libroNoDisponible.getTitulo()).get(0);
        assertFalse(libroActualizado.isDisponible(), "El libro debería seguir marcado como no disponible.");
    }
}
