package consola_consola;

import modelo.Administrador;
import modelo.Libro;
import java.util.Scanner;

public class Consola2 {
	Scanner scanner = new Scanner(System.in);
	public static void mostrarMenuAdministrador() {
		System.out.println("Menu de Administrador");
        System.out.println("1. Registrar un nuevo libro");
        System.out.println("2. Eliminar un libro");
        System.out.println("2. Registrar un nuevo usuario");
        System.out.println("3. Eliminar un usuario");
        System.out.println("4. Ver usuarios morosos");
        System.out.println("5. Ver solicitudes");
        System.out.println("6. Lista de libros");
        System.out.println("7. Libros prestados");
        System.out.println("9. Cerrar sección");
        System.out.print("Ingrese la opción deseada: ");
	}
	
	/*public static void mostrarAdministrador(Scanner scanner) {
		int opcionAdmin;
		do {
			mostrarMenuAdministrador();
			opcionAdmin = scanner.nextInt();
			scanner.nextLine();
			switch(opcionAdmin){
				case 1:
					agregarLibro(scanner);
					break;
				case 2:
					eliminarLibro(scanner);
					break;
				case 3:
					crearCuenta(scanner);
					break;
				case 4:
					eliminarCuenta(scanner);
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
					listaLibros(scanner);
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
	
	public static void agregarLibro(Scanner scanner) {
        Administrador admin = new Administrador();
        Libro libro = new Libro();

        System.out.print("Ingrese el título del libro: ");
        libro.setTitulo(scanner.nextLine());

        System.out.print("Ingrese el autor del libro: ");
        libro.setAutor(scanner.nextLine());

        /*System.out.print("Ingrese el ID del libro: ");
        libro.setId(scanner.nextInt());
        scanner.nextLine(); // consume newline*/

        System.out.print("Ingrese la editorial del libro: ");
        libro.setEditorial(scanner.nextLine());

        System.out.print("Ingrese el año de publicación del libro: ");
        libro.setAnioPublicacion(scanner.nextInt());
        scanner.nextLine(); // consume newline

        System.out.print("Ingrese la categoría del libro: ");
        libro.setCategoria(scanner.nextLine());

       /* System.out.print("¿Está disponible el libro? (true/false): ");
        libro.setDisponible(scanner.nextBoolean());
        scanner.nextLine();*/ // consume newline

        if (admin.agregarLibro(libro)) {
            System.out.println("Libro agregado exitosamente.");
        } else {
            System.out.println("Error al agregar el libro.");
        }
    }
*/
}
