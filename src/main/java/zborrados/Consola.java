package zborrados;

import java.util.InputMismatchException;
//import java.io.IOException;
import java.util.Scanner;
import java.util.List;

import modelo.Libro;
import modelo.Usuario;
import controlador.ControladorUsuario;
import controlador.ControladorLibro;

public class Consola {
	
	private Scanner scanner = new Scanner(System.in);
	private ControladorUsuario controladorUsuario = new ControladorUsuario(); // De paso cargamos a todos los usuarios desde BD
	private ControladorLibro controladorLibro = new ControladorLibro(); // De paso cargamos a todos los libros desde BD
	private Usuario usuarioLogueado = null;
	
    public static void main(String[] args) {
        Consola c = new Consola();
        int opcion;
        do {
            c.menu();
            opcion = c.leerOpcion();
            //c.limpiarConsola();
            c.procesarOpcion(opcion);
        } while (opcion != 0);
        c.scanner.close();
    }

    public void menu() {
    	System.out.println("=== MENÚ PRINCIPAL DE LA BIBLIOTECA ===");
        System.out.println("Menu de opciones (No logeados)");
        System.out.println("1. Login");
        System.out.println("2. Registrarse");
        System.out.println("3. Buscar Libro");
        System.out.println("0. Salir");
    }

    public int leerOpcion() {
        int opcion = -1;  // Valor inválido para la opción
        while (opcion == -1) {
            System.out.print("Ingrese una opcion: ");
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer del scanner
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next(); // Limpiar el buffer del scanner
            }
        }
        return opcion;
    }

    public void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                System.out.println("Opción seleccionada: Login");
                System.out.print("Ingrese correo: ");
                String correo = scanner.next();
                System.out.print("Ingrese contraseña: ");
                String contrasena = scanner.next();
                usuarioLogueado = controladorUsuario.autenticarUsuario(correo, contrasena);
                if (usuarioLogueado != null) {
                	if ("admin".equals(usuarioLogueado.getRol())) {
                		Consola2 consolaAdmin = new Consola2(usuarioLogueado);
                		consolaAdmin.mostrarAdministrador(); // Mostrar el menú del administrador
                	} else {
                		Consola3 consolaUsuario = new Consola3(usuarioLogueado);
                		consolaUsuario.usuarioMenu(); // Mostrar el menú del usuario
                		usuarioLogueado=null;
                	}
				} else {
					System.out.println("Usuario o contraseña incorrectos.");
				}
                break;
                
            case 2:
                System.out.println("Opción seleccionada: Registrarse");
                //scanner.nextLine(); // Limpiar el buffer del scanner
                System.out.print("Ingrese nombres: ");
                String nombres = scanner.nextLine();
                System.out.print("Ingrese apellidos: ");
                String apellidos = scanner.nextLine();
                System.out.print("Ingrese DNI: ");
                int dni = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer del scanner
                System.out.print("Ingrese correo: ");
                correo = scanner.next();
                System.out.print("Ingrese contraseña: ");
                contrasena = scanner.next();
                String rol = "usuario";
                controladorUsuario.registrarUsuario(nombres, apellidos, correo, dni, contrasena, rol);           
                break;
                
            case 3:
                System.out.println("Opción seleccionada: Buscar Libro");
				menuBuscarLibro();
                break;
            case 0:
            	System.out.println("Saliendo de la aplicación...");
				break;
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
        }
    }
    
    void menuBuscarLibro() {
    	int opcion;
        do {
            System.out.println("Menu de búsqueda de libros");
            System.out.println("1. Buscar por nombre");
            System.out.println("2. Buscar por categoría");
            System.out.println("3. Buscar por autor");
            System.out.println("0. Volver");
            opcion = leerOpcion();
            //scanner.nextLine(); // lo comente porque para que no genere otro salto de liena
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del libro: ");
                    String nombre = scanner.nextLine();
                    // Lógica para buscar por nombre
                    System.out.println("Buscando libro por nombre: " + nombre);
                    List<Libro> libros = controladorLibro.buscarLibroPorNombre(nombre);
                    controladorLibro.mostrarLibros(libros);
                    break;
                case 2:
                    System.out.print("Ingrese la categoría del libro: ");
                    String categoria = scanner.nextLine();
                    System.out.println("Buscando libro por categoría: " + categoria);
                    List<Libro> librosPorCategoria = controladorLibro.buscarLibroPorCategoria(categoria);
                    controladorLibro.mostrarLibros(librosPorCategoria);
                    break;
                case 3:
                    System.out.print("Ingrese el autor del libro: ");
                    String autor = scanner.nextLine();
                    System.out.println("Buscando libro por autor: " + autor);
                    List<Libro> librosPorAutor = controladorLibro.buscarLibroPorAutor(autor);
                    controladorLibro.mostrarLibros(librosPorAutor);
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }
    
}