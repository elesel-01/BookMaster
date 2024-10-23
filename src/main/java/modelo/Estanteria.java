package modelo;

import java.util.ArrayList;
import java.util.List;

public class Estanteria {
    private int numero;
    private int capacidad;
    private List<Libro> librosAlmacenados;

    public Estanteria(int numero, int capacidad) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.librosAlmacenados = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        if (librosAlmacenados.size() < capacidad) {
            librosAlmacenados.add(libro);
            System.out.println("El libro ha sido agregado a la estantería " + numero);
        } else {
            System.out.println("No hay espacio en la estantería " + numero);
        }
    }

    public void removerLibro(Libro libro) {
        if (librosAlmacenados.remove(libro)) {
            System.out.println("El libro ha sido removido de la estantería " + numero);
        } else {
            System.out.println("El libro no se encuentra en la estantería " + numero);
        }
    }

    public int obtenerEspacioDisponible() {
        return capacidad - librosAlmacenados.size();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public List<Libro> getLibrosAlmacenados() {
        return librosAlmacenados;
    }

    public void setLibrosAlmacenados(List<Libro> librosAlmacenados) {
        this.librosAlmacenados = librosAlmacenados;
    }
}
