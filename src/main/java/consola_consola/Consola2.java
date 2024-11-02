package consola_consola;

import modelo.Administrador;
import modelo.Libro;
import java.util.Scanner;
import controlador.ControladorAdministrador;

public class Consola2 {
	private Scanner scanner = new Scanner(System.in);
	private ControladorAdministrador controladorAministrador = new ControladorAdministrador();
	
	
	public static void mostrarMenuAdministrador() {
		System.out.println("Menu de Administrador");
        System.out.println("1. Registrar un nuevo libro");
        System.out.println("2. Eliminar un libro");
        System.out.println("3. Registrar un nuevo usuario"); // GERARDO -- ControladorAdministrador
        System.out.println("4. Eliminar un usuario"); // GERARDO -- ControladorAdministrador
        System.out.println("5. Ver usuarios morosos");
        System.out.println("6. Ver solicitudes");
        System.out.println("7. Lista de libros");
        System.out.println("8. Libros prestados");
        System.out.println("9. Cerrar sección"); // LUIS -- ControladorUsuario
        System.out.print("Ingrese la opción deseada: ");
	}
	
	void mostrarAdministrador(Scanner scanner) {
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
					controladorAministrador.registrarLibro(idEstanteria, titulo, autor, editorial, anioPublicacion, categoria, disponible);
					System.out.println("nuevo libro registrado con exito gaaaaa");
					break;
				case 2:
					System.out.println("por implementar");
					//eliminarLibro(scanner);
					break;
				case 3:
					System.out.println("por implementar");
					//crearCuenta(scanner);
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
