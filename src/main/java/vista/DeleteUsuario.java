
package vista;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import base_de_datos.Coneccion; 

import java.awt.Component;

public class DeleteUsuario extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JTable table;
    private CardLayout cardLayout;
    private JPanel contentPane;

    /**
     * Create the panel.
     */
    public DeleteUsuario(CardLayout cardLayout, JPanel contentPane) {
    	this.cardLayout = cardLayout;
        this.contentPane = contentPane;
    	setPreferredSize(new java.awt.Dimension(1040, 600));
    	setBackground(new Color(255, 255, 255));
        setBorder(new EmptyBorder(0, 0, 0, 0));
        setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("src\\main\\java\\Imagen\\pngegg.png"));
        lblNewLabel.setBounds(793, 0, 247, 202);
        add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("<html>Eliminar<br>Usuario</html>");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 33));
        lblNewLabel_1.setBounds(23, 28, 181, 142);
        add(lblNewLabel_1);

        JTextArea textArea = new JTextArea();
        textArea.setBackground(new Color(39, 91, 131));
        textArea.setBounds(0, 0, 1040, 202);
        add(textArea);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(199, 254, 251));
        panel.setBounds(34, 220, 114, 55);
        add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("DNI");
        lblNewLabel_2.setBounds(36, 0, 68, 55);
        panel.add(lblNewLabel_2);
        lblNewLabel_2.setBackground(new Color(0, 255, 255));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 24));
        textField.setBounds(186, 220, 268, 55);
        add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("Eliminar");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
        btnNewButton.setBounds(34, 531, 194, 46);
        btnNewButton.addActionListener(e -> eliminarUsuario()); 
        add(btnNewButton);

        JTextArea textArea_1 = new JTextArea();
        textArea_1.setBounds(258, 513, 181, 46);
        add(textArea_1);

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("src\\main\\java\\Imagen\\pngegg (3).png"));
        lblNewLabel_3.setBounds(793, 359, 228, 231);
        add(lblNewLabel_3);
        
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 24));
        btnBuscar.setBounds(484, 220, 181, 55);
        btnBuscar.addActionListener(e -> buscarUsuario()); 
        add(btnBuscar);
        
        JButton volverButton = new JButton("Volver");
        volverButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        volverButton.setBounds(839, 229, 142, 46);
        add(volverButton);
        volverButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cardLayout.show(contentPane, "Home");
            }
        });
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] { "ID", "Nombre", "Apellido", "DNI", "password", "email", "rol" }
        ));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(34, 316, 688, 150);
        add(scrollPane);
    }
    
    private void buscarUsuario() {
        String dni = textField.getText().trim();
        
        if (dni.isEmpty()) {
            return;
        }
        
        Coneccion db = new Coneccion();
        Connection connection = db.getConnection();
        
        if (connection != null) {
            try {
                String query = "SELECT * FROM usuario WHERE dni = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, Integer.parseInt(dni));
                
                ResultSet resultSet = statement.executeQuery();
                
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);
                
                if (resultSet.next()) {
                    // Agregar los datos del libro a la tabla
                    model.addRow(new Object[] {
                        resultSet.getInt("idUsuario"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido"),
                        resultSet.getInt("dni"),
                        resultSet.getString("passw"),
                        resultSet.getString("email"),
                        resultSet.getString("rol"),
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
    
    private void eliminarUsuario() {
        String dni = textField.getText().trim();
        
        if (dni.isEmpty()) {
            return;
        }
        
        Coneccion db = new Coneccion();
        Connection connection = db.getConnection();
        
        if (connection != null) {
            try {
                String query = "DELETE FROM usuario WHERE dni = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, Integer.parseInt(dni));
                
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
    
    private void clearTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);  // Eliminar todas las filas
    }
}

