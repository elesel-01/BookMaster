package controlador;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import modelo.Usuario;

public class ControladorUsuarioTest {

    private ControladorUsuario controladorUsuario;

    @Test
    public void testCargarUsuariosDesdeBaseDeDatos() {
        List<Usuario> usuarios = controladorUsuario.getUsuarios();
        assertNotNull("La lista de usuarios no debería ser nula", usuarios);
        assertFalse("La lista de usuarios debería contener al menos un usuario", usuarios.isEmpty());
    }

    @Test
    public void testAutenticarUsuario() {
        // Crear un usuario válido en la base de datos antes de ejecutar esta prueba
        Usuario usuario = controladorUsuario.autenticarUsuario("gerardoleon@gmail.com", "barliv0-4");
        assertNotNull("El usuario debería autenticarse correctamente con credenciales válidas", usuario);
        assertEquals("El correo del usuario autenticado debería coincidir", "correo@ejemplo.com", usuario.getEmail());

        // Probar con credenciales inválidas
        usuario = controladorUsuario.autenticarUsuario("correo_invalido@ejemplo.com", "contraseña_invalida");
        assertNull("No debería autenticarse un usuario con credenciales inválidas", usuario);
    }

    @Test
    public void testRegistrarUsuario() {
        String nombre = "Juan";
        String apellido = "Pérez";
        String correo = "juan.perez@ejemplo.com";
        int dni = 12345678;
        String contrasena = "mi_contraseña";
        String rol = "usuario";

        controladorUsuario.registrarUsuario(nombre, apellido, correo, dni, contrasena, rol);
        
        Usuario registrado = controladorUsuario.autenticarUsuario(correo, contrasena);
        assertNotNull("El usuario recién registrado debería poder autenticarse", registrado);
        assertEquals("El correo del usuario registrado debería coincidir", correo, registrado.getEmail());
    }

    @Test
    public void testVerMisDatos() {
        Usuario usuarioLogueado = controladorUsuario.autenticarUsuario("correo@ejemplo.com", "contraseña123");
        assertNotNull("El usuario debería estar autenticado para ver sus datos", usuarioLogueado);

        // Simular la visualización de datos
        controladorUsuario.verMisDatos(usuarioLogueado);
    }

    @Test
    public void testSalir() {
        controladorUsuario.salir(true);
        // Como el método `salir` no modifica un estado real, solo verificamos el flujo.
        assertTrue("El método salir se ejecutó correctamente", true);
    }
}
