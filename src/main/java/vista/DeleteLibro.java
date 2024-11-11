
package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import base_de_datos.Coneccion; 
import java.awt.CardLayout;

public class DeleteLibro extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JTable table;
    private JPanel contentPane;  // Sin inicializar aquí
    private CardLayout cardLayout;

    /**
     * Create the panel.
     */
    public DeleteLibro(CardLayout cardLayout, JPanel contentPane) {
    	this.cardLayout = cardLayout;
        this.contentPane = contentPane;
    	setPreferredSize(new java.awt.Dimension(1040, 600));
        setBackground(new Color(255, 255, 255));
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("<html>Eliminar<br>Libro</html>");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 35));
        lblNewLabel_1.setBounds(23, 28, 154, 112);
        add(lblNewLabel_1);

        JTextArea textArea = new JTextArea();
        textArea.setBackground(new Color(39, 91, 131));
        textArea.setBounds(0, 0, 262, 193);
        add(textArea);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("src\\main\\java\\Imagen\\Captura de pantalla 2024-11-01 215004.png"));
        lblNewLabel.setBounds(260, 0, 780, 193);
        add(lblNewLabel);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(199, 254, 251));
        panel.setBounds(35, 203, 109, 46);
        add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("ID");
        lblNewLabel_2.setBounds(41, 0, 68, 46);
        panel.add(lblNewLabel_2);
        lblNewLabel_2.setBackground(new Color(0, 255, 255));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textField.setBounds(167, 203, 215, 46);
        add(textField);
        textField.setColumns(10);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] { "ID", "Título", "Autor", "Editorial", "Año", "Categoría", "Disponible" }
        ));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(23, 259, 750, 221);
        add(scrollPane);

        JTextArea textArea_1 = new JTextArea();
        textArea_1.setBounds(201, 545, 161, 34);
        add(textArea_1);
        
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnBuscar.setBounds(406, 207, 141, 42);
        btnBuscar.addActionListener(e -> buscarLibro()); 
        add(btnBuscar);
        
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnEliminar.setBounds(35, 530, 142, 46);
        btnEliminar.addActionListener(e -> eliminarLibro());  
        add(btnEliminar);
        
        JButton volverButton = new JButton("Volver");
        volverButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        volverButton.setBounds(847, 530, 142, 46);
        add(volverButton);
        volverButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cardLayout.show(contentPane, "Home");
            }
        });
    }
    
    private void buscarLibro() {
        String id = textField.getText().trim();
        
        if (id.isEmpty()) {
            return;
        }
        
        Coneccion db = new Coneccion();
        Connection connection = db.getConnection();
        
        if (connection != null) {
            try {
                String query = "SELECT * FROM libro WHERE idLibro = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, Integer.parseInt(id));
                
                ResultSet resultSet = statement.executeQuery();
                
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);
                
                if (resultSet.next()) {
                    // Agregar los datos del libro a la tabla
                    model.addRow(new Object[] {
                        resultSet.getInt("idLibro"),
                        resultSet.getString("titulo"),
                        resultSet.getString("autor"),
                        resultSet.getString("editorial"),
                        resultSet.getString("anioPublicacion"),
                        resultSet.getString("categoria"),
                        resultSet.getInt("disponible"),
                    });
                } else {
                    clearTable();
                }
                
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void eliminarLibro() {
        String id = textField.getText().trim();
        
        if (id.isEmpty()) {
            return;
        }
        
        Coneccion db = new Coneccion();
        Connection connection = db.getConnection();
        
        if (connection != null) {
            try {
                String query = "DELETE FROM libro WHERE idLibro = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, Integer.parseInt(id));
                
                int rowsAffected = statement.executeUpdate();
                
                if (rowsAffected > 0) {
                    clearTable();
                    textField.setText("");
                }
                
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Limpiar los datos de la tabla
    private void clearTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);  // Eliminar todas las filas
    }
}

