	package modelo;

import java.util.ArrayList;
//import java.util.List;

public class Administrador {
	//Scanner scanner = new Scanner(System.in);
	ArrayList<Libro> libros = new ArrayList<>();
	
	public void agregarLibro(Libro libro) {
		if(libro !=null ) {
			libro.add(libro);
		}else {
			System.out.println("No puede estar sin llenar");
		}	
	}
	
	public void eliminarLibro(Libro libro) {
		int pos = posicion(libroAModificar);
		if(pos!=-1) {
			libro.remove(pos); 
			System.out.println("libro eliminado con exito");
		}else {
			System.out.println("no encontrado");
		}
	}

	public int posicion (Libro libro) {
		
		for(int i = 0;i <libro.size(); i++) {
			if(libro.equalsIgnoreCase(libro.get(i))) {
			return  i;	
			}
		}
		return -1;
	}
	
	public ArrayList<Libro> obtenerLibros() {
	    return libro;
	}


}

