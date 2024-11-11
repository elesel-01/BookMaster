package vista;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import base_de_datos.Coneccion;
import modelo.Usuario;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import javax.swing.*;
import java.sql.SQLException;

public class RegisterUsuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPanel contentPane;  // Sin inicializar aquí
    private CardLayout cardLayout;

	/**
	 * Create the panel.
	 */
	public RegisterUsuario(CardLayout cardLayout, JPanel contentPane) {
		this.cardLayout = cardLayout;
        this.contentPane = contentPane;
		setPreferredSize(new java.awt.Dimension(1040, 600));
		setBackground(new Color(255, 255, 255));
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("src\\main\\java\\Imagen\\usuarios.png"));
		lblNewLabel.setBounds(534, 0, 261, 228);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("<html>Registrar<br>Usuario</html>");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_1.setBounds(23, 28, 186, 143);
		add(lblNewLabel_1);

		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(39, 91, 131));
		textArea.setBounds(0, 0, 1040, 228);
		add(textArea);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(199, 254, 251));
		panel.setBounds(34, 270, 99, 36);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("DNI");
		lblNewLabel_2.setBounds(21, 0, 68, 31);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setBackground(new Color(0, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(199, 254, 251));
		panel_1.setBounds(34, 331, 99, 36);
		add(panel_1);

		JLabel lblNewLabel_2_1 = new JLabel(" Contraseña");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBackground(Color.CYAN);
		lblNewLabel_2_1.setBounds(0, 0, 99, 31);
		panel_1.add(lblNewLabel_2_1);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(199, 254, 251));
		panel_2.setBounds(508, 270, 99, 36);
		add(panel_2);

		JLabel lblNewLabel_2_2 = new JLabel("Nombre");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_2.setBackground(Color.CYAN);
		lblNewLabel_2_2.setBounds(10, 0, 79, 31);
		panel_2.add(lblNewLabel_2_2);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(199, 254, 251));
		panel_3.setBounds(508, 331, 99, 36);
		add(panel_3);

		JLabel lblNewLabel_2_3 = new JLabel("Apellido");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_3.setBackground(Color.CYAN);
		lblNewLabel_2_3.setBounds(10, 0, 89, 31);
		panel_3.add(lblNewLabel_2_3);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(153, 270, 194, 36);
		add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(153, 331, 194, 36);
		add(textField_1);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(642, 270, 194, 36);
		add(textField_2);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(642, 331, 194, 36);
		add(textField_3);

		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(34, 512, 130, 36);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarUsuarioEstandar();
            }
        });

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(186, 450, 161, 34);
		add(textArea_1);
		
		JButton btnRegistrarComoAdministrador = new JButton("Registrar como Administrador");
		btnRegistrarComoAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegistrarComoAdministrador.setBounds(250, 512, 311, 36);
		add(btnRegistrarComoAdministrador);
		btnRegistrarComoAdministrador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarUsuarioAdmin();
            }
        });
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_4.setColumns(10);
		textField_4.setBounds(153, 392, 322, 36);
		add(textField_4);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(199, 254, 251));
		panel_2_1.setBounds(34, 392, 99, 36);
		add(panel_2_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Correo");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_2_1.setBackground(Color.CYAN);
		lblNewLabel_2_2_1.setBounds(10, 0, 79, 31);
		panel_2_1.add(lblNewLabel_2_2_1);
		
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
	
	// Funcion para registrar Usuario
	public void registrarUsuarioEstandar() {
		String nombreText = textField_2.getText();
		String apellidoText = textField_3.getText();
		int dniText = Integer.parseInt(textField.getText());
		String passText = textField_1.getText();
		String emailText = textField_4.getText();
		
		    try (Connection connection = DriverManager.getConnection("jdbc:mysql://junction.proxy.rlwy.net:38689/railway?useSSL=false&serverTimezone=UTC", "root", "mjNGynPcLMflxpMOuYiSWvIagExuMwVJ")) {
		        
		        // Verificar si el correo o el DNI ya existen
		        String checkSql = "SELECT COUNT(*) FROM usuario WHERE dni = ? OR email = ?";
		        PreparedStatement checkStatement = connection.prepareStatement(checkSql);
		        checkStatement.setInt(1, dniText);
		        checkStatement.setString(2, emailText);
		        ResultSet checkResult = checkStatement.executeQuery();
		        checkResult.next();
	
		        if (checkResult.getInt(1) > 0) {
		            JOptionPane.showMessageDialog(this, "El correo o el DNI ya están registrados.");
		            return; // Detener el proceso si ya existe
		        }
	
		        // Si el correo y DNI no existen, procedemos con la inserción
		        String sql = "INSERT INTO usuario (idUsuario, nombre, apellido, dni, passw, email, rol) VALUES (?, ?, ?, ?, ?, ?, 'usuario')";
		        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	
		        preparedStatement.setInt(1, obtenerSiguienteID(connection));
		        preparedStatement.setString(2, nombreText);
		        preparedStatement.setString(3, apellidoText);
		        preparedStatement.setInt(4, dniText);
		        preparedStatement.setString(5, passText);
		        preparedStatement.setString(6, emailText);
	
		        preparedStatement.executeUpdate();
		        JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente.");
	
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		        JOptionPane.showMessageDialog(this, "Error al registrar el usuario.");
		    }
		}
	
	public void registrarUsuarioAdmin() {
		String nombreText = textField_2.getText();
		String apellidoText = textField_3.getText();
		int dniText = Integer.parseInt(textField.getText());
		String passText = textField_1.getText();
		String emailText = textField_4.getText();
		
		    try (Connection connection = DriverManager.getConnection("jdbc:mysql://junction.proxy.rlwy.net:38689/railway?useSSL=false&serverTimezone=UTC", "root", "mjNGynPcLMflxpMOuYiSWvIagExuMwVJ")) {
		        
		        // Verificar si el correo o el DNI ya existen
		        String checkSql = "SELECT COUNT(*) FROM usuario WHERE dni = ? OR email = ?";
		        PreparedStatement checkStatement = connection.prepareStatement(checkSql);
		        checkStatement.setInt(1, dniText);
		        checkStatement.setString(2, emailText);
		        ResultSet checkResult = checkStatement.executeQuery();
		        checkResult.next();
	
		        if (checkResult.getInt(1) > 0) {
		            JOptionPane.showMessageDialog(this, "El correo o el DNI ya están registrados.");
		            return; // Detener el proceso si ya existe
		        }
	
		        // Si el correo y DNI no existen, procedemos con la inserción
		        String sql = "INSERT INTO usuario (idUsuario, nombre, apellido, dni, passw, email, rol) VALUES (?, ?, ?, ?, ?, ?, 'admin')";
		        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	
		        preparedStatement.setInt(1, obtenerSiguienteID(connection));
		        preparedStatement.setString(2, nombreText);
		        preparedStatement.setString(3, apellidoText);
		        preparedStatement.setInt(4, dniText);
		        preparedStatement.setString(5, passText);
		        preparedStatement.setString(6, emailText);
	
		        preparedStatement.executeUpdate();
		        JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente.");
	
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		        JOptionPane.showMessageDialog(this, "Error al registrar el usuario.");
		    }
		}
	
	private int obtenerSiguienteID(Connection connection) throws SQLException {
        // Aquí iría la consulta para obtener el ID actual más alto en la base de datos y sumar uno
        String sql = "SELECT MAX(idUsuario) FROM usuario";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        return rs.getInt(1) + 1;  // Retorna el siguiente ID
    }
}
