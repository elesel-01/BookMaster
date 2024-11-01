package consola_consola;


import java.util.Scanner;

public class Consola3 {

    public static void usuarioMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("=== MENÚ DE LA BIBLIOTECA ===");
            System.out.println("1. Mis Libros");
            System.out.println("2. Solicitudes");
            System.out.println("3. Cerrar Sesión");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.println("Esto son tus libros: ");
                    break;
                case 2:
                    
                    System.out.println("Estas son tus solicitudes: ");
                    break;
                case 3:
                    System.out.println("Ha cerrado sesión.");
                    break;
                case 4:
                    System.out.println("Ha salido de esta ventana.");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }

        scanner.close();
    }

   /* // Método para limpiar la pantalla
    public static void limpiarPantalla() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("No se pudo limpiar la pantalla.");
        }
    }*/

    // Método para pausar la ejecución
    
    }
