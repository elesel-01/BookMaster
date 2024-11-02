package modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import base_de_datos.Coneccion;
import java.sql.PreparedStatement;

public class Administrador {
	
	 private Connection getConnection() {
	        Coneccion con = new Coneccion();
	        return con.getConnection(); // Asegúrate de que Coneccion tenga un método getConnection que devuelva un Connection
	 }
	
	public boolean agregarLibro(Libro libro) {
		PreparedStatement ps= null;
		Connection con = getConnection();
	
		String sql= "INSERT INTO libro(titulo, autor, editorial,anioPublicacion,categoria) VALUES(?,?,?,?,?)";
		 try {
			 ps= con.prepareStatement(sql);
			 ps.setString(1, libro.getTitulo());
			 ps.setString(2, libro.getAutor());
			 
			 ps.setString(3, libro.getEditorial());
			 ps.setInt(4, libro.getAnioPublicacion());
			 ps.setString(5, libro.getCategoria());
			 ps.execute();
		 }catch(SQLException e) {
			 System.err.println(e);
			 return false;
		} finally {
			try {
				if(ps!= null) ps.close();
				if(con!= null) con.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
		return true;
		 
	}
	
	public boolean eliminarLibro(Libro libro) {
		PreparedStatement ps= null;
		Connection con = getConnection();
	
		String sql= "DELETE FROM libro WHERE id=?";
		 try {
			 ps= con.prepareStatement(sql);
			 ps.setInt(1, libro.getIdEstanteria());
			 ps.execute();
			 return true;
		 }catch(SQLException e) {
			 System.err.println(e);
			 return false;
		} finally {
			try {
				if(ps!= null) ps.close();
				if(con!= null) con.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
		 
	}
	
	public boolean crearCuenta(Usuario usuario) {
		PreparedStatement ps= null;
		Connection con = getConnection();
	
		String sql= "INSERT INTO usuario(nombre, apellido,dni, passw, email) VALUES(?,?,?,?,?)";
		 try {
			 ps= con.prepareStatement(sql);
			 ps.setString(1, usuario.getNombre());
			 ps.setString(2, usuario.getApellido());
			 ps.setInt(3, usuario.getDni());
			 ps.setString(4, usuario.getPassw());
			 ps.setString(5, usuario.getEmail());
			 ps.execute();
		 }catch(SQLException e) {
			 System.err.println(e);
			 return false;
		} finally {
			try {
				if(ps!= null) ps.close();
				if(con!= null) con.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
		return true;
		 
	}
	
	public boolean eliminarCuenta(Usuario usuario) {
		PreparedStatement ps= null;
		Connection con = getConnection();
	
		String sql= "DELETE FROM usuario WHERE id=?";
		 try {
			 ps= con.prepareStatement(sql);
			 ps.setInt(1, usuario.getId());
			 ps.execute();
			 return true;
		 }catch(SQLException e) {
			 System.err.println(e);
			 return false;
		} finally {
			try {
				if(ps!= null) ps.close();
				if(con!= null) con.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
		 
	}
	

}
