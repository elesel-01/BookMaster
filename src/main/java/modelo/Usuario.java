package modelo;


public class Usuario {
	
	private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String passw;
    private int dni;
    private String rol;

    // Constructor
    public Usuario(String nombre, String apellido, String email, int dni, String rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.dni = dni;
        this.rol = rol;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email= email;
	}
	
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
	public int getDni() {
		return dni;
	}
	
	public void setDni(int dni) {
		this.dni= dni;
	}
	
	public String getPassw() {
		return passw;
	}
	
	public void setPassw(String passw) {
		this.passw= passw;
	}
	
	public String getRol() {
		return rol;
	}
	
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	@Override
	public String toString() {
	    return "\tid = " + id + "\n" +
	           "\tnombre = " + nombre + "\n" +
	           "\tapellido = " + apellido + "\n" +
	           "\temail = " + email + "\n" +
	           "\tpassw = " + passw + "\n" +
	           "\tdni = " + dni + "\n" +
	           "\trol = " + rol;
	}
}
