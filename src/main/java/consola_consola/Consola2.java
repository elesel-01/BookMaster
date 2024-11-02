package consola_consola;

import modelo.Administrador;
import modelo.Libro;
import modelo.Usuario;
import java.util.Scanner;
import controlador.ControladorAdministrador;

public class Consola2 {
	private Scanner scanner = new Scanner(System.in);
	private ControladorAdministrador controladorAdministrador = new ControladorAdministrador();
	private Usuario usuarioLogueado = null;
	
	public Consola2(Usuario usuarioLogueado) {
		this.usuarioLogueado = usuarioLogueado;
	}
	
	public void mostrarMenuAdministrador() { // Tiene que ser no estático para pasar objetos
        System.out.println("=== MENÚ DE ADMINISTRADOR DE LA BIBLIOTECA ===");
        System.out.println("1. Registrar un nuevo libro"); // VALQUI
        System.out.println("2. Eliminar un libro"); // VALQUI
        System.out.println("3. Registrar un nuevo usuario"); // GERARDO -- ControladorAdministrador (LISTO)
        System.out.println("4. Eliminar un usuario"); // GERARDO -- ControladorAdministrador
        System.out.println("5. Ver usuarios morosos"); //VALQUI
        System.out.println("6. Ver solicitudes"); // LUIS
        System.out.println("7. Lista de libros"); // VALQUI
        System.out.println("8. Libros prestados"); // VALQUI
        System.out.println("9. Cerrar sesión"); // LUIS -- ControladorUsuario
        System.out.print("Ingrese la opción deseada: ");
	}
	
	void mostrarAdministrador() {
		int opcionAdmin;
		do {
			mostrarMenuAdministrador();
			opcionAdmin = scanner.nextInt();
			scanner.nextLine();
			switch(opcionAdmin){
				case 1:
					System.out.println("Opcion selecionada: Registar un nuevo libro ");
					scanner.nextLine();
					System.out.println("ingrese el id de la estanteria: ");
					int idEstanteria = scanner.nextInt();
					scanner.nextLine();
					System.out.println("ingrese el titulo del libro: ");
					String titulo = scanner.nextLine();
					System.out.println("ingrese el autor del libro: ");
					String autor = scanner.nextLine();
					System.out.println("ingrese la editorial del libro: ");
					String editorial = scanner.nextLine();
					System.out.println("ingrese el año de publicacion del libro: ");
					int anioPublicacion = scanner.nextInt();
					scanner.nextLine();
					System.out.println("ingrese la categoria del Libro: ");
					String categoria = scanner.nextLine();
					boolean disponible = true;
					controladorAdministrador.registrarLibro(idEstanteria, titulo, autor, editorial, anioPublicacion, categoria, disponible);
					System.out.println("nuevo libro registrado con exito gaaaaa");
					break;
				case 2:
					System.out.println("por implementar");
					//eliminarLibro(scanner);
					break;
				case 3:
					System.out.println("Opcion selecionada: Registar un nuevo usuario ");
					scanner.nextLine(); // Limpiar el buffer del scanner
	                System.out.print("Ingrese nombres: ");
	                String nombres = scanner.nextLine();
	                System.out.print("Ingrese apellidos: ");
	                String apellidos = scanner.nextLine();
	                System.out.print("Ingrese DNI: ");
	                int dni = scanner.nextInt();
	                scanner.nextLine(); // Limpiar el buffer del scanner
	                System.out.print("Ingrese correo: ");
	                String correo = scanner.next();
	                System.out.print("Ingrese contraseña: ");
	                String contrasena = scanner.next();
	                System.out.print("Ingrese rol (admin/usuario): ");
	                String rol = scanner.next();
	                controladorAdministrador.registrarUsuario(nombres, apellidos, correo, dni, contrasena, rol);
	                System.out.println("Usuario registrado con éxito.");
	                break;
				case 4:
					System.out.println("por implementar");
					//eliminarCuenta(scanner);
					break;
				case 5:
					//verMorosos(scanner);
					System.out.println("por implementar");
					break;
				case 6:
					System.out.println("por implementar");
					//verSolicitudes(scanner);
					break;
				case 7:
					System.out.println("por implementar");
					//listaLibros(scanner);
					break;
				case 8:
					System.out.println("por implementar");
					//librosPrestados(scanner);
					break;
				case 9:
					System.out.println("Sesión cerrada.");
					break;
				default:
					System.out.println("Opción inválida.");	
				
			}
			
		}while(opcionAdmin != 9);
	}
	
	
}