package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import base_de_datos.Coneccion;

public class ControladorReserva {
    
	public void solicitarLibro(int idLibro, int idUsuario) {
	    Coneccion db = new Coneccion();
	    LocalDateTime fechaReserva = LocalDateTime.now();

	    try (Connection connection = db.getConnection()) {
	        // Check if the book is available
	        String checkBookSql = "SELECT disponible FROM libro WHERE idLibro = ?";
	        try (PreparedStatement checkBookStatement = connection.prepareStatement(checkBookSql)) {
	            checkBookStatement.setInt(1, idLibro);
	            try (ResultSet resultSet = checkBookStatement.executeQuery()) {
	                if (resultSet.next() && resultSet.getBoolean("disponible")) {
	                    // Book is available, insert the loan
	                    String insertLoanSql = "INSERT INTO prestamo (idLibro, idUsuario, fechaInicio, fechaEntrega) VALUES (?, ?, ?, ?)";
	                    try (PreparedStatement insertLoanStatement = connection.prepareStatement(insertLoanSql)) {
	                        insertLoanStatement.setInt(1, idLibro);
	                        insertLoanStatement.setInt(2, idUsuario);
	                        insertLoanStatement.setTimestamp(3, java.sql.Timestamp.valueOf(fechaReserva));
	                        insertLoanStatement.setTimestamp(4, java.sql.Timestamp.valueOf(fechaReserva.plusWeeks(2))); // Assuming a 2-week loan period
	                        insertLoanStatement.executeUpdate();
	                        System.out.println("Préstamo realizado con éxito para el libro con ID: " + idLibro);
	                    }

	                    // Update the book's availability
	                    String updateBookSql = "UPDATE libro SET disponible = FALSE WHERE idLibro = ?";
	                    try (PreparedStatement updateBookStatement = connection.prepareStatement(updateBookSql)) {
	                        updateBookStatement.setInt(1, idLibro);
	                        updateBookStatement.executeUpdate();
	                    }
	                } else {
	                    // Book is not available, show message
	                    System.out.println("Libro no disponible actualmente. Por favor, solicite más tarde.");
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("No hay disponibilidad.");
	    }
	}
}

