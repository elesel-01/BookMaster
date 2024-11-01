package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base_de_datos.Coneccion;
import modelo.Usuario;

public class ControladorUsuario {
    private List<Usuario> usuarios = new ArrayList<>();

    public Usuario autenticarUsuario(String correo, String contrasena) {
        Coneccion db = new Coneccion();
        try (Connection connection = db.getConnection()) {
            String sql = "SELECT * FROM usuario WHERE email = ? AND passw = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, correo);
                statement.setString(2, contrasena);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String nombre = resultSet.getString("nombre");
                        String apellido = resultSet.getString("apellido");
                        int dni = resultSet.getInt("dni");
                        String rol = resultSet.getString("rol");
                        Usuario usuario = new Usuario(nombre, apellido, correo, dni, rol);
                        usuario.setPassw(contrasena);
                        return usuario;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void registrarUsuario(String nombre, String apellido, String correo, int dni, String contrasena, String rol) {
        Usuario nuevoUsuario = new Usuario(nombre, apellido, correo, dni, rol);
        nuevoUsuario.setPassw(contrasena);
        usuarios.add(nuevoUsuario);
        
        // Insertar el usuario a la base de datos
        Coneccion db = new Coneccion();
        try (Connection connection = db.getConnection()){
        	String sql = "INSERT INTO usuario (nombre, apellido, email, dni, passw, rol) VALUES (?, ?, ?, ?, ?, ?)";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setString(1, nombre);
				statement.setString(2, apellido);
				statement.setString(3, correo);
				statement.setInt(4, dni);
				statement.setString(5, contrasena);
				statement.setString(6, rol);
				statement.executeUpdate();
			}
        } catch (SQLException e) {
        	e.printStackTrace();
        }
    }
    
}


