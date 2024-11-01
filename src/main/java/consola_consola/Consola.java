package consola_consola;

import java.util.InputMismatchException;
//import java.io.IOException;
import java.util.Scanner;

import modelo.Usuario;
import controlador.ControladorUsuario;

public class Consola {
	
	private Scanner scanner = new Scanner(System.in);
	private ControladorUsuario controladorUsuario = new ControladorUsuario();
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

    void menu() {
        System.out.println("Menu de opciones (No logeados)");
        System.out.println("1. Login");
        System.out.println("2. Registrarse");
        System.out.println("3. Buscar Libro");
        System.out.println("0. Salir");
    }

    int leerOpcion() {
        int opcion = -1;  // Valor inválido para la opción
        while (opcion == -1) {
            System.out.print("Ingrese una opcion: ");
            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next(); // Limpiar el buffer del scanner
            }
        }
        return opcion;
    }

    void procesarOpcion(int opcion) {
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
                		menuAdmin();
                	} else {
                		menuUsuario();
                	}
				} else {
					System.out.println("Usuario o contraseña incorrectos.");
				}
                break;
            case 2:
                System.out.println("Opción seleccionada: Registrarse");
                scanner.nextLine(); // Limpiar el buffer del scanner
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
                System.out.println("Usuario registrado con éxito.");
                break;
            case 3:
                System.out.println("Opción seleccionada: Buscar Libro");
				menuBuscarLibro();
                break;
            case 0:
                System.out.println("Saliendo del programa...");
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
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del libro: ");
                    String nombre = scanner.next();
                    // Lógica para buscar por nombre
                    System.out.println("Buscando libro por nombre: " + nombre);
                    break;
                case 2:
                    System.out.print("Ingrese la categoría del libro: ");
                    String categoria = scanner.next();
                    // Lógica para buscar por categoría
                    System.out.println("Buscando libro por categoría: " + categoria);
                    break;
                case 3:
                    System.out.print("Ingrese el autor del libro: ");
                    String autor = scanner.next();
                    // Lógica para buscar por autor
                    System.out.println("Buscando libro por autor: " + autor);
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }
    
    void menuAdmin() {
    	System.out.println("Menú de Administrador");
    	// Lógica para el menú de administrador
    }

    void menuUsuario() {
    	int opcion;
        do {
            System.out.println("Menú de Usuario");
            System.out.println("1. Ver mis datos");
            System.out.println("0. Volver");
            opcion = leerOpcion();
            switch (opcion) {
                case 1:
                    verMisDatos();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }
    
    void verMisDatos() {
        if (usuarioLogueado != null) {
            System.out.println("Nombre: " + usuarioLogueado.getNombre());
            System.out.println("Apellido: " + usuarioLogueado.getApellido());
            System.out.println("Correo: " + usuarioLogueado.getEmail());
            System.out.println("DNI: " + usuarioLogueado.getDni());
            System.out.println("Rol: " + usuarioLogueado.getRol());
        } else {
            System.out.println("No hay usuario logueado.");
        }
    }
    
    /*void limpiarConsola() {
    	try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error al limpiar la consola.");
        }
    }*/
    
}

