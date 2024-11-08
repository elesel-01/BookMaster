package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import base_de_datos.Coneccion;

public class ControladorReserva {
    
    public void solicitarLibro(int idLibro, String nombreUsuario) {
        Coneccion db = new Coneccion();
        LocalDate fechaReserva = LocalDate.now();
        
        try (Connection connection = db.getConnection()) {
            String sql = "INSERT INTO reserva (idLibro, nombreUsuario, fechaReserva) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idLibro);
                statement.setString(2, nombreUsuario);
                statement.setDate(3, java.sql.Date.valueOf(fechaReserva));
                statement.executeUpdate();
                System.out.println("Reserva realizada con éxito para el libro con ID: " + idLibro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No hay disponibilidad.");
        }
    }
}

