package modelo;

import com.password4j.Hash;
import com.password4j.Password;

public class EncriptarPassw {
	
	public static String encriptar(String password) {
	    if (password == null || password.isEmpty()) {
	        throw new IllegalArgumentException("La contraseña no puede estar vacía o nula.");
	    }
	    Hash hash = Password.hash(password).withPBKDF2();
	    return hash.getResult();
	}

}
