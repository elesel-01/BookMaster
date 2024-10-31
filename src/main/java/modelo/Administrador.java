	package modelo;

import java.util.ArrayList;
//import java.util.List;

public class Administrador {
	//Scanner scanner = new Scanner(System.in);
	ArrayList<String> libro = new ArrayList<>();
	
	public void agregarLibro(String nombreLibro) {
		if(nombreLibro !=null && !nombreLibro.trim().isEmpty()) {
			libro.add(nombreLibro);
		}else {
			System.out.println("No puede estar sin llenar");
		}	
	}
	
	public void eliminarLibro(String libroAModificar) {
		int pos = posicion(libroAModificar);
		if(pos!=-1) {
			libro.remove(pos); 
			System.out.println("libro eliminado con exito");
		}else {
			System.out.println("no encontrado");
		}
	}

	public int posicion (String buscarLibro) {
		
		for(int i = 0;i <libro.size(); i++) {
			if(buscarLibro.equalsIgnoreCase(libro.get(i))) {
			return  i;	
			}
		}
		return -1;
	}
	
	public ArrayList<String> obtenerLibros() {
	    return libro;
	}


}

