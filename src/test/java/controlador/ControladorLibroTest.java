package controlador;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import modelo.Libro;
import controlador.ControladorLibro;

public class ControladorLibroTest {

	private ControladorLibro controladorLibro;


@Before
public void setUp() {
    controladorLibro = new ControladorLibro();
    controladorLibro.cargarLibrosDesdeBaseDeDatos();
    // Verificar que los libros se cargaron correctamente
}


	
	@Test
	public void testBuscarLibroPorNombre() {
		List<Libro> libros = controladorLibro.buscarLibroPorNombre("Harry Potter");
		assertTrue("La lista de libros no debería estar vacía", libros.size() > 0);
		for (Libro libro : libros) {
			assertTrue("El título del libro debería contener 'Harry Potter'",
					libro.getTitulo().toLowerCase().contains("harry potter"));
		}

		libros = controladorLibro.buscarLibroPorNombre("NombreInexistente");
		assertTrue("La lista de libros debería estar vacía", libros.isEmpty());

		libros = controladorLibro.buscarLibroPorNombre("Harry");
		assertTrue("La lista de libros no debería estar vacía", libros.size() > 0);
		for (Libro libro : libros) {
			assertTrue("El título del libro debería contener 'Harry'",
					libro.getTitulo().toLowerCase().contains("harry"));
		}

		libros = controladorLibro.buscarLibroPorNombre("HARRY POTTER");
		assertTrue("La lista de libros no debería estar vacía", libros.size() > 0);
		for (Libro libro : libros) {
			assertTrue("El título del libro debería contener 'harry potter'",
					libro.getTitulo().toLowerCase().contains("harry potter"));
		}
	}

	@Test
	public void testBuscarLibroPorAutor() {
		List<Libro> libros = controladorLibro.buscarLibroPorAutor("valve");
		assertTrue("La lista de libros no debería estar vacía", libros.size() > 0);
		for (Libro libro : libros) {
			assertTrue("El autor del libro debería contener 'valve'", libro.getAutor().toLowerCase().contains("valve"));
		}

		libros = controladorLibro.buscarLibroPorAutor("AutorInexistente");
		assertTrue("La lista de libros debería estar vacía", libros.isEmpty());

		libros = controladorLibro.buscarLibroPorAutor("val");
		assertTrue("La lista de libros no debería estar vacía", libros.size() > 0);
		for (Libro libro : libros) {
			assertTrue("El autor del libro debería contener 'val'", libro.getAutor().toLowerCase().contains("val"));
		}

		libros = controladorLibro.buscarLibroPorAutor("VALVE");
		assertTrue("La lista de libros no debería estar vacía", libros.size() > 0);
		for (Libro libro : libros) {
			assertTrue("El autor del libro debería contener 'valve'", libro.getAutor().toLowerCase().contains("valve"));
		}
	}

	@Test
	public void testBuscarLibroPorCategoria() {
		List<Libro> libros = controladorLibro.buscarLibroPorCategoria("moba");
		assertTrue("La lista de libros no debería estar vacía", libros.size() > 0);
		for (Libro libro : libros) {
			assertTrue("La categoría del libro debería contener 'moba'",
					libro.getCategoria().toLowerCase().contains("moba"));
		}

		libros = controladorLibro.buscarLibroPorCategoria("CategoriaInexistente");
		assertTrue("La lista de libros debería estar vacía", libros.isEmpty());

		libros = controladorLibro.buscarLibroPorCategoria("mob");
		assertTrue("La lista de libros no debería estar vacía", libros.size() > 0);
		for (Libro libro : libros) {
			assertTrue("La categoría del libro debería contener 'mob'",
					libro.getCategoria().toLowerCase().contains("mob"));
		}

		libros = controladorLibro.buscarLibroPorCategoria("MOBA");
		assertTrue("La lista de libros no debería estar vacía", libros.size() > 0);
		for (Libro libro : libros) {
			assertTrue("La categoría del libro debería contener 'moba'",
					libro.getCategoria().toLowerCase().contains("moba"));
		}
	}

}
