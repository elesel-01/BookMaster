package controlador;

import modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

public class ControladorUsuario {
    private List<Usuario> usuarios = new ArrayList<>();

    public Usuario autenticarUsuario(String correo, String contrasena) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(correo) && usuario.getPassw().equals(contrasena)) {
                return usuario;
            }
        }
        return null;
    }

    public void registrarUsuario(String nombre, String apellido, String correo, int dni, String contrasena, String rol) {
        Usuario nuevoUsuario = new Usuario(nombre, apellido, correo, dni, rol);
        nuevoUsuario.setPassw(contrasena);
        usuarios.add(nuevoUsuario);
    }
    
}


