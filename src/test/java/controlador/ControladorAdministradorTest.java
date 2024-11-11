package controlador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import base_de_datos.Coneccion;
import controlador.ControladorAdministrador;
import modelo.Libro;
import modelo.Usuario;

class ControladorAdministradorTest {
	
	
	@Mock
	private Coneccion coneccion;
	
	@Mock
	private PreparedStatement ps;
	
	@InjectMocks
	private	 ControladorAdministrador controlador;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		
		when(coneccion.getConnection()).thenReturn(coneccion.getConnection());
		when(coneccion.getConnection().prepareStatement(any(String.class))).thenReturn(ps);
		
	}

	@Test
	void testRegistrarLibro() throws Exception {
		int idEstanteria= 5;
		String titulo = "Harry Potter";
		String autor = "J.K Rowling";
		String editorial = "Salamandra";
		int anioPublicacion = 2021;
		String Categoria = "Fantasia";
		Boolean disponible = true;
		
		controlador.registrarLibro(idEstanteria, titulo, autor, editorial, anioPublicacion, Categoria,
				disponible);
		
		((Connection) verify(coneccion)).prepareStatement("INSERT INTO libro(idEstanteria, titulo, autor, editorial, anioPublicacion, categoria, disponible) VALUES(?,?,?,?,?,?,?)");
		verify(ps).setInt(1, idEstanteria);
		verify(ps).setString(2, titulo);
		verify(ps).setString(3, autor);
		verify(ps).setString(4, editorial);
		verify(ps).setInt(5, anioPublicacion);
		verify(ps).setString(6, Categoria);
		verify(ps).setBoolean(7, disponible);
		verify(ps).execute();
		
		
	}

	@Test
	void testEliminarLibro() {
		fail("Not yet implemented");
	}

	@Test
	void testListarLibros() {
		fail("Not yet implemented");
	}

	@Test
	void testRegistrarUsuario() {
		fail("Not yet implemented");
	}

	@Test
	void testLibrosPrestados() {
		fail("Not yet implemented");
	}

	@Test
	void testEliminarUsuario() {
		fail("Not yet implemented");
	}

}
