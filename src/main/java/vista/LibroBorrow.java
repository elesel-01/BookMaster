package vista;

import base_de_datos.Coneccion;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class LibroBorrow extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField txtId;
    private JTable table;
    private JPanel contentPane;
    private CardLayout cardLayout;

    public LibroBorrow(CardLayout cardLayout, JPanel contentPane) {
        this.cardLayout = cardLayout;
        this.contentPane = contentPane;

        setPreferredSize(new java.awt.Dimension(1040, 600));
        setBackground(new Color(255, 255, 255));
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(55, 221, 731, 355);
        add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        JLabel lblNewLabel_1 = new JLabel("<html>Libros<br>Prestados</html>");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel_1.setBounds(20, 10, 154, 112);
        add(lblNewLabel_1);

        JTextArea textArea = new JTextArea();
        textArea.setBackground(new Color(39, 91, 131));
        textArea.setBounds(0, 0, 249, 153);
        add(textArea);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("src\\main\\java\\Imagen\\Captura de pantalla 2024-11-01 215004.png"));
        lblNewLabel.setBounds(246, 0, 794, 153);
        add(lblNewLabel);

        txtId = new JTextField();
        txtId.setText("ID");
        txtId.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtId.setBounds(55, 163, 194, 36);
        add(txtId);
        txtId.setColumns(10);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnBuscar.setBounds(410, 162, 130, 36);
        add(btnBuscar);

        JButton btnDevolver = new JButton("Devolver");
        btnDevolver.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnDevolver.setBounds(269, 162, 130, 36);
        add(btnDevolver);

        JButton volverButton = new JButton("Volver");
        volverButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        volverButton.setBounds(847, 530, 142, 46);
        add(volverButton);
        volverButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "Home");
            }
        });

        // Acción de buscar préstamo por ID
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarPrestamo();
            }
        });

        // Acción de devolver el libro
        btnDevolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                devolverLibro();
            }
        });
    }

    // Método para buscar préstamo por ID
    private void buscarPrestamo() {
        String idPrestamo = txtId.getText();
        if (!idPrestamo.isEmpty()) {
            try {
                int id = Integer.parseInt(idPrestamo);

                Coneccion db = new Coneccion(); // Crear instancia de Coneccion
                Connection connection = db.getConnection(); // Obtener la conexión

                String query = "SELECT idPrestamo, idLibro, idUsuario, fechaInicio, fechaEntrega " +
                               "FROM prestamo " +
                               "WHERE idPrestamo = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, id);

                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    DefaultTableModel model = new DefaultTableModel();
                    model.addColumn("ID Préstamo");
                    model.addColumn("ID Libro");
                    model.addColumn("ID Usuario");
                    model.addColumn("Fecha Inicio");
                    model.addColumn("Fecha Entrega");

                    Object[] row = new Object[5];
                    row[0] = resultSet.getInt("idPrestamo");
                    row[1] = resultSet.getInt("idLibro");
                    row[2] = resultSet.getInt("idUsuario");
                    row[3] = resultSet.getTimestamp("fechaInicio");
                    row[4] = resultSet.getTimestamp("fechaEntrega");
                    model.addRow(row);

                    table.setModel(model);
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el préstamo con el ID proporcionado.");
                }

                resultSet.close();
                statement.close();
                connection.close();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "El ID de préstamo debe ser un número válido.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un ID de préstamo.");
        }
    }

    // Método para devolver el libro
    private void devolverLibro() {
        String idPrestamo = txtId.getText();
        if (!idPrestamo.isEmpty()) {
            try {
                int id = Integer.parseInt(idPrestamo);

                Coneccion db = new Coneccion(); // Crear instancia de Coneccion
                Connection connection = db.getConnection(); // Obtener la conexión
                connection.setAutoCommit(false); // Iniciar la transacción

                // Primero, obtener el ID del libro asociado al préstamo
                String queryLibro = "SELECT idLibro FROM prestamo WHERE idPrestamo = ?";
                PreparedStatement statementLibro = connection.prepareStatement(queryLibro);
                statementLibro.setInt(1, id);
                ResultSet resultSet = statementLibro.executeQuery();

                if (resultSet.next()) {
                    int idLibro = resultSet.getInt("idLibro");

                    // Eliminar el préstamo
                    String queryDelete = "DELETE FROM prestamo WHERE idPrestamo = ?";
                    PreparedStatement statementDelete = connection.prepareStatement(queryDelete);
                    statementDelete.setInt(1, id);
                    int rowsAffected = statementDelete.executeUpdate();

                    if (rowsAffected > 0) {
                        // Actualizar el estado del libro a disponible
                        String queryUpdate = "UPDATE libro SET disponible = 1 WHERE idLibro = ?";
                        PreparedStatement statementUpdate = connection.prepareStatement(queryUpdate);
                        statementUpdate.setInt(1, idLibro);
                        int updateRows = statementUpdate.executeUpdate();

                        if (updateRows > 0) {
                            JOptionPane.showMessageDialog(null, "Libro devuelto y actualizado con éxito.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al actualizar el estado del libro.");
                        }
                        statementUpdate.close();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el préstamo con el ID proporcionado.");
                    }

                    statementDelete.close();
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el préstamo con el ID proporcionado.");
                }

                resultSet.close();
                statementLibro.close();

                // Confirmar la transacción
                connection.commit();
                connection.close();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "El ID de préstamo debe ser un número válido.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos: " + ex.getMessage());
                try {
                    // Revertir la transacción en caso de error
                    Coneccion db = new Coneccion();
                    db.getConnection().rollback();
                } catch (Exception rollbackEx) {
                    JOptionPane.showMessageDialog(null, "Error al revertir los cambios: " + rollbackEx.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un ID de préstamo.");
        }
    }

}