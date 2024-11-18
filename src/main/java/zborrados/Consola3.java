package zborrados;

import java.util.Scanner;

import controlador.ControladorReserva;
import controlador.ControladorUsuario;
import modelo.Usuario;

public class Consola3 {
	private ControladorUsuario controladorUsuario = new ControladorUsuario();
    private ControladorReserva controladorReserva = new ControladorReserva();
	private Usuario usuarioLogueado = null;
	
	private Consola consola;
	
	 /*Se añade un constructor para pasar el usuario logueado */
	public Consola3(Usuario usuarioLogueado) {
		this.usuarioLogueado = usuarioLogueado;
		this.consola = new Consola(); //Inicializar consola sino no sabe a quien apuntar
	}
	
    public void usuarioMenu() { // Tiene que ser no estático para pasar objetos 
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("=== MENÚ DE USUARIO DE LA BIBLIOTECA ===");
            System.out.println("1. Mis Libros"); // LUIS -- ControladorUsuario 
            System.out.println("2. Solicitar un libro"); // LUIS -- ControladorReserva (Y LISTO)
            System.out.println("3. Ver mis datos"); // GERARDO -- ControladorUsuario (LISTO)
            System.out.println("4. Buscar libro"); // GERARDO -- ControladorUsuario (LISTO)
            System.out.println("5. Cerrar Sesión"); // LUIS -- ControladorUsuario (LISTO)
            System.out.println("0. Salir"); // LUIS -- ControladorUsuario (LISTO)
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.println("Esto son tus libros: ");
                    break;
                case 2:
                	System.out.println("Solicitar un libro");
                    System.out.print("Ingrese el ID del libro: ");
                    int idLibro = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    controladorReserva.solicitarLibro(idLibro, usuarioLogueado.getId());
                    break;
                case 3:
                    System.out.println("Sus datos:");
                    controladorUsuario.verMisDatos(usuarioLogueado);
                    break;
                case 4:
                    consola.menuBuscarLibro(); // Se encuentra en Consola.java
                    break;
                case 5:
                	System.out.println("CerrandoSesión");
                	salir = true; 
                    break;
				case 0:
					controladorUsuario.salir(salir); //ARREGLAR ESTO 
					break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }

        //scanner.close();
    }
}
