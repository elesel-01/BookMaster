package modelo;

import java.util.Scanner;

public class Libro {
 private String titulo;
 private Autor autor;  
 private String ISBN;
 private boolean disponible;
 private String editorial;
 private int anioPublicacion;
 private Categoria categoria;  

 public Libro(String titulo, Autor autor, String ISBN, boolean disponible, String editorial, int anioPublicacion, Categoria categoria) {
     this.titulo = titulo;
     this.autor = autor;
     this.ISBN = ISBN;
     this.disponible = disponible;
     this.editorial = editorial;
     this.anioPublicacion = anioPublicacion;
     this.categoria = categoria;

     autor.agregarObra(this);
 }

 public static Libro pedirDatos() {
     Scanner scanner = new Scanner(System.in);

     System.out.println("Introduce el título del libro:");
     String titulo = scanner.nextLine();
     System.out.println("Introduce el ISBN del libro:");
     String ISBN = scanner.nextLine();
     System.out.println("Introduce la editorial del libro:");
     String editorial = scanner.nextLine();
     System.out.println("Introduce el año de publicación del libro:");
     int anioPublicacion = scanner.nextInt();
     scanner.nextLine();  
 
     Autor autor = Autor.pedirDatos();
     Categoria categoria = Categoria.pedirDatos();

     return new Libro(titulo, autor, ISBN, true, editorial, anioPublicacion, categoria);
 }

 public void mostrarDetalles() {
     System.out.println("Título: " + titulo);
     System.out.println("Autor: " + autor.getNombre());
     System.out.println("ISBN: " + ISBN);
     System.out.println("Editorial: " + editorial);
     System.out.println("Año de Publicación: " + anioPublicacion);
     System.out.println("Categoría: " + categoria.getNombre() + " - " + categoria.getDescripcion());
     System.out.println("Disponible: " + (disponible ? "Sí" : "No"));
 }

 public void prestar() {
     if (disponible) {
         disponible = false;
         System.out.println("Libro prestado correctamente.");
     } else {
         System.out.println("El libro no está disponible para prestar.");
     }
 }

 public void devolver() {
     if (!disponible) {
         disponible = true;
         System.out.println("Libro devuelto correctamente.");
     } else {
         System.out.println("El libro ya estaba disponible.");
     }
 }

 public void reserva(Usuario usuario) {
     System.out.println("El libro ha sido reservado por " + usuario.getNombre());
 }

 public static void main(String[] args) {
     
     Libro libro = Libro.pedirDatos();

     libro.mostrarDetalles();

     libro.prestar();

     libro.devolver();
 }
}

class Usuario {
 private String nombre;

 public Usuario(String nombre) {
     this.nombre = nombre;
 }

 public String getNombre() {
     return nombre;
 }
}
