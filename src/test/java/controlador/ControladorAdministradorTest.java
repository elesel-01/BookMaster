
package controlador;

import static org.mockito.ArgumentMatchers.anyString;
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

class ControladorAdministradorTest {

	@Mock
	private Coneccion coneccion;

	@Mock
	private Connection connection;

	@Mock
	private PreparedStatement ps;

	@InjectMocks
	private ControladorAdministrador controlador;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);

		when(coneccion.getConnection()).thenReturn(connection);
		when(connection.prepareStatement(anyString())).thenReturn(ps);
	}

	@Test
	void testRegistrarLibro() throws Exception {
		int idEstanteria = 5;
		String titulo = "Harry Potter";
		String autor = "J.K Rowling";
		String editorial = "Salamandra";
		int anioPublicacion = 2021;
		String categoria = "Fantasia";
		Boolean disponible = true;

		controlador.registrarLibro(idEstanteria, titulo, autor, editorial, anioPublicacion, categoria, disponible);

		verify(connection).prepareStatement(
				"INSERT INTO libro(idEstanteria, titulo, autor, editorial, anioPublicacion, categoria, disponible) VALUES(?,?,?,?,?,?,?)");
		verify(ps).setInt(1, idEstanteria);
		verify(ps).setString(2, titulo);
		verify(ps).setString(3, autor);
		verify(ps).setString(4, editorial);
		verify(ps).setInt(5, anioPublicacion);
		verify(ps).setString(6, categoria);
		verify(ps).setBoolean(7, disponible);
		verify(ps).execute();
	}

	@Test
	void testRegistrarUsuario() throws Exception {
		String nombre = "jerson";
		String apellido = "valqui";
		String correo = "valqui@gmail.com";
		int dni = 87654321;
		String contrasena = "12345";
		String rol = "usuario";

		controlador.registrarUsuario(nombre, apellido, correo, dni, contrasena, rol);

		verify(connection).prepareStatement(
				"INSERT INTO usuario (nombre, apellido, email, dni, passw, rol) VALUES (?, ?, ?, ?, ?, ?)");
		verify(ps).setString(1, nombre);
		verify(ps).setString(2, apellido);
		verify(ps).setString(3, correo);
		verify(ps).setInt(4, dni);
		verify(ps).setString(5, contrasena);
		verify(ps).setString(6, rol);
		verify(ps).executeUpdate();
	}


}
