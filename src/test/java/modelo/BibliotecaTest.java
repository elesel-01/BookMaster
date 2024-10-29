package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

class BibliotecaTest {

    private Biblioteca biblioteca;
    private Usuario usuario1;
    private Usuario usuario2;
    private Libro libro1;
    private Libro libro2;

	@BeforeEach
    public void setUp() {
        biblioteca = new Biblioteca("Biblioteca Central");

        // Crear usuarios con nombres válidos
        usuario1 = new Usuario("Pablo de los backyardigans", 0);
        usuario2 = new Usuario("Tasha de los backyardigans", 1);

        // Crear autores y categorías
        Categoria categoria1 = new Categoria("Novela", "Novela literaria de ficción");
        Categoria categoria2 = new Categoria("Clásico", "Literatura clásica");
        
        
        // Crear libros con todos los parámetros necesarios
        libro1 = new Libro(1, "Cien años de soledad", "Gabriel Marquez", "Editorial Sudamericana", 2023, categoria1);
        libro2 = new Libro(2, "Don Quijote de la Mancha", "Miguel Cervantes", "Editorial Juan de la Cuesta", 2023 , categoria2);
		
        /*
        // Agregar libros a la biblioteca para pruebas
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        */
    }

    @Test
    void testAgregarLibro() {
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);

        assertEquals(libro1, biblioteca.getCatalogo().get(0));
        assertEquals(libro2, biblioteca.getCatalogo().get(1));
    }

    @Test
    void testEliminarLibro() {
    	
        biblioteca.eliminarLibro(libro1);
        biblioteca.eliminarLibro(libro1);

        assertNull(biblioteca.buscarLibro("Cien años de soledad"));
        assertEquals(libro2, biblioteca.buscarLibro("Don Quijote de la Mancha"));
    }

    @Test
    void testBuscarLibro() {
    	biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        assertEquals(libro1, biblioteca.buscarLibro("Cien años de soledad"));
        assertEquals(libro2, biblioteca.buscarLibro("Don Quijote de la Mancha"));
        assertNull(biblioteca.buscarLibro("Moby Dick"));
    }

    @Test
    void testRegistrarUsuario() {
        biblioteca.registrarUsuario(usuario1);
        biblioteca.registrarUsuario(usuario2);

        assertEquals(usuario1, biblioteca.getUsuarios().get(0));
        assertEquals(usuario2, biblioteca.getUsuarios().get(1));
    }
}
