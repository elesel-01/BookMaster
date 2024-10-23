package modelo;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nombre;
    private List<Libro> catalogo;
    private List<Usuario> usuarios;
    //private List<Categoria> categorias;
    private static int totalLibros;
    private static int totalUsuarios;


    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.catalogo = new ArrayList<>(); 
        this.usuarios = new ArrayList<>();
       // this.categorias = new ArrayList<>();
        this.totalLibros = 0;
        this.totalUsuarios = 0;
    }

        // Métodos
        public void agregarLibro(Libro libro) {
            catalogo.add(libro);
            totalLibros++;
        }

        public void eliminarLibro(Libro libro) {
            catalogo.remove(libro);
            totalLibros--;
        }

        public Libro buscarLibro(String titulo) {
            for (Libro libro : catalogo) {
                if (libro.getTitulo().equals(titulo)) {
                    return libro;
                }
            }
            return null;
        }

        public void registrarUsuario(Usuario usuario) {
            usuarios.add(usuario);
            totalUsuarios++;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getTotalLibros() {
            return totalLibros;
        }

        public int getTotalUsuarios() {
            return totalUsuarios;
        }
}