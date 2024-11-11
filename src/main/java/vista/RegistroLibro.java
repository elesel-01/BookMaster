
package vista;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.Usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class RegistroLibro extends JPanel {
	
    private static final long serialVersionUID = 1L;
    private JTextField titulo;
    private JTextField autor;
    private JTextField editorial;
    private JTextField categoria;
    private JTextField codigo_Estanteria;
    private JTextField anio_publicacion;
    private JTextField numero_libro;
    private JPanel contentPane;  // Sin inicializar aquí
    private CardLayout cardLayout;

    /**
     * Create the panel.
     */
    public RegistroLibro(CardLayout cardLayout, JPanel contentPane) {
    	this.cardLayout = cardLayout;
        this.contentPane = contentPane;
    	setPreferredSize(new java.awt.Dimension(1040, 600));
        setBackground(new Color(255, 255, 255));
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("<html>Agregar<br>Libro</html>");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 35));
        lblNewLabel_1.setBounds(23, 28, 174, 132);
        add(lblNewLabel_1);

        JTextArea textArea = new JTextArea();
        textArea.setBackground(new Color(39, 91, 131));
        textArea.setBounds(0, 0, 259, 203);
        add(textArea);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("src\\main\\java\\Imagen\\Captura de pantalla 2024-11-01 215004.png"));
        lblNewLabel.setBounds(251, 0, 789, 203);
        add(lblNewLabel);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(199, 254, 251));
        panel.setBounds(34, 217, 99, 36);
        add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("Titulo");
        lblNewLabel_2.setBounds(21, 0, 68, 36);
        panel.add(lblNewLabel_2);
        lblNewLabel_2.setBackground(new Color(0, 255, 255));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBackground(new Color(199, 254, 251));
        panel_1.setBounds(34, 293, 99, 36);
        add(panel_1);

        JLabel lblNewLabel_2_1 = new JLabel("Autor");
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_2_1.setBackground(Color.CYAN);
        lblNewLabel_2_1.setBounds(21, 0, 68, 31);
        panel_1.add(lblNewLabel_2_1);

        JPanel panel_2 = new JPanel();
        panel_2.setLayout(null);
        panel_2.setBackground(new Color(199, 254, 251));
        panel_2.setBounds(546, 213, 99, 36);
        add(panel_2);

        JLabel lblNewLabel_2_2 = new JLabel("Editorial");
        lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_2_2.setBackground(Color.CYAN);
        lblNewLabel_2_2.setBounds(10, 0, 79, 31);
        panel_2.add(lblNewLabel_2_2);

        JPanel panel_3 = new JPanel();
        panel_3.setLayout(null);
        panel_3.setBackground(new Color(199, 254, 251));
        panel_3.setBounds(546, 280, 99, 36);
        add(panel_3);

        JLabel lblNewLabel_2_3 = new JLabel("Categoria");
        lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_2_3.setBackground(Color.CYAN);
        lblNewLabel_2_3.setBounds(10, 0, 89, 36);
        panel_3.add(lblNewLabel_2_3);

        titulo = new JTextField();
        titulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        titulo.setBounds(153, 217, 194, 36);
        add(titulo);
        titulo.setColumns(10);

        autor = new JTextField();
        autor.setFont(new Font("Tahoma", Font.PLAIN, 20));
        autor.setColumns(10);
        autor.setBounds(153, 293, 194, 36);
        add(autor);

        editorial = new JTextField();
        editorial.setFont(new Font("Tahoma", Font.PLAIN, 20));
        editorial.setColumns(10);
        editorial.setBounds(729, 213, 194, 36);
        add(editorial);

        categoria = new JTextField();
        categoria.setFont(new Font("Tahoma", Font.PLAIN, 20));
        categoria.setColumns(10);
        categoria.setBounds(729, 280, 194, 36);
        add(categoria);

        JButton btnNewButton = new JButton("Registrar");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 23));
        btnNewButton.setBounds(34, 505, 163, 47);
        add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarLibro();
            }
        });

        JTextArea textArea_1 = new JTextArea();
        textArea_1.setBounds(220, 505, 212, 47);
        add(textArea_1);
        
        JPanel panel_4 = new JPanel();
        panel_4.setLayout(null);
        panel_4.setBackground(new Color(199, 254, 251));
        panel_4.setBounds(34, 358, 99, 47);
        add(panel_4);
        
        JLabel lblNewLabel_2_4 = new JLabel("<html>Codigo<br>Estanteria</html>");
        lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_4.setBackground(Color.CYAN);
        lblNewLabel_2_4.setBounds(10, 0, 79, 47);
        panel_4.add(lblNewLabel_2_4);
        
        codigo_Estanteria = new JTextField();
        codigo_Estanteria.setFont(new Font("Tahoma", Font.PLAIN, 20));
        codigo_Estanteria.setColumns(10);
        codigo_Estanteria.setBounds(153, 358, 194, 47);
        add(codigo_Estanteria);
        
        JPanel panel_4_1 = new JPanel();
        panel_4_1.setLayout(null);
        panel_4_1.setBackground(new Color(199, 254, 251));
        panel_4_1.setBounds(546, 358, 99, 47);
        add(panel_4_1);
        
        JLabel lblNewLabel_2_4_1 = new JLabel("<html>Año<br>Publicación</html>");
        lblNewLabel_2_4_1.setBounds(10, 0, 79, 47);
        panel_4_1.add(lblNewLabel_2_4_1);
        lblNewLabel_2_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_4_1.setBackground(Color.CYAN);
        
        anio_publicacion = new JTextField();
        anio_publicacion.setFont(new Font("Tahoma", Font.PLAIN, 20));
        anio_publicacion.setColumns(10);
        anio_publicacion.setBounds(729, 358, 194, 47);
        add(anio_publicacion);
        
        JPanel panel_4_2 = new JPanel();
        panel_4_2.setLayout(null);
        panel_4_2.setBackground(new Color(199, 254, 251));
        panel_4_2.setBounds(603, 505, 107, 47);
        add(panel_4_2);
        
        JLabel lblNewLabel_2_4_2 = new JLabel("<html>Numero<br>de libros</html>");
        lblNewLabel_2_4_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_2_4_2.setBackground(Color.CYAN);
        lblNewLabel_2_4_2.setBounds(10, 0, 97, 47);
        panel_4_2.add(lblNewLabel_2_4_2);
        
        numero_libro = new JTextField();
        numero_libro.setFont(new Font("Tahoma", Font.PLAIN, 20));
        numero_libro.setColumns(10);
        numero_libro.setBounds(742, 505, 86, 47);
        add(numero_libro);
        
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
    private void registrarLibro() {
        String tituloText = titulo.getText();
        String autorText = autor.getText();
        String editorialText = editorial.getText();
        String categoriaText = categoria.getText();
        String codigoEstanteria = codigo_Estanteria.getText();
        String anioPublicacion = anio_publicacion.getText();
        int numLibros = Integer.parseInt(numero_libro.getText());

        // Conectar a la base de datos y registrar el libro
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://junction.proxy.rlwy.net:38689/railway?useSSL=false&serverTimezone=UTC", "root", "mjNGynPcLMflxpMOuYiSWvIagExuMwVJ")) {
            String sql = "INSERT INTO libro (titulo, autor, editorial, categoria, idEstanteria, anioPublicacion, idLibro,disponible) VALUES (?, ?, ?, ?, ?, ?, ?,1)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            for (int i = 0; i < numLibros; i++) {
                preparedStatement.setString(1, tituloText);
                preparedStatement.setString(2, autorText);
                preparedStatement.setString(3, editorialText);
                preparedStatement.setString(4, categoriaText);
                preparedStatement.setString(5, codigoEstanteria);
                preparedStatement.setString(6, anioPublicacion);
                preparedStatement.setInt(7, obtenerSiguienteID(connection)); // Generar ID en orden ascendente
                
                preparedStatement.executeUpdate();
            }

            JOptionPane.showMessageDialog(this, "Libro(s) registrado(s) exitosamente.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al registrar el libro.");
        }
    }
    private int obtenerSiguienteID(Connection connection) throws SQLException {
        // Aquí iría la consulta para obtener el ID actual más alto en la base de datos y sumar uno
        String sql = "SELECT MAX(idLibro) FROM libro";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        return rs.getInt(1) + 1;  // Retorna el siguiente ID
    }
}

