package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base_de_datos.Coneccion;
import modelo.Libro;

public class ControladorLibro {
	
	// Lista para guardar los libros en memoria
    private List<Libro> libros = new ArrayList<>();
    private Connection connection;
    
    public ControladorLibro() {
        cargarLibrosDesdeBaseDeDatos();
    }

    public void cargarLibrosDesdeBaseDeDatos() {
        Coneccion db = new Coneccion();
        try (Connection connection = db.getConnection()) {
            String sql = "SELECT * FROM libro";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Libro libro = new Libro(
                        resultSet.getInt("idEstanteria"),
                        resultSet.getString("titulo"),
                        resultSet.getString("autor"),
                        resultSet.getString("editorial"),
                        resultSet.getInt("anioPublicacion"),
                        resultSet.getString("categoria"),
                        resultSet.getBoolean("disponible")
                    );
                    libro.setIdLibro(resultSet.getInt("idLibro"));
                    libros.add(libro);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Libro> buscarLibroPorNombre(String nombre) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getTitulo().toLowerCase().contains(nombre.toLowerCase())) {
                resultado.add(libro);
            }
        }
        return resultado;
    }

    public List<Libro> buscarLibroPorAutor(String autor) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getAutor().toLowerCase().contains(autor.toLowerCase())) {
                resultado.add(libro);
            }
        }
        return resultado;
    }

	public List<Libro> buscarLibroPorCategoria(String categoria) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getCategoria().toLowerCase().contains(categoria.toLowerCase())) {
                resultado.add(libro);
            }
        }
        return resultado;
    }

    public void mostrarLibros(List<Libro> libros) {
        if (libros.isEmpty()) {
            System.out.println("No se encontraron libros.");
        } else {
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        }
    }
    
    public void cerrarConexionBaseDeDatos() {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}

