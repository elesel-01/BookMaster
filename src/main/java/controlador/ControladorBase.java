package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import base_de_datos.Coneccion;

public abstract class ControladorBase {

    protected Connection getConnection() {
        Coneccion db = new Coneccion();
        return db.getConnection();
    }

    protected void ejecutarActualizacion(String sql, Object... parametros) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 0; i < parametros.length; i++) {
                statement.setObject(i + 1, parametros[i]);
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected ResultSet ejecutarConsulta(String sql, Object... parametros) {
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            for (int i = 0; i < parametros.length; i++) {
                statement.setObject(i + 1, parametros[i]);
            }
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método abstracto para que las subclases lo implementen
    public abstract void cargarDesdeBaseDeDatos();
}


