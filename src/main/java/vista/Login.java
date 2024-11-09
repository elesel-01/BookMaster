
package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import controlador.ControladorUsuario;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;
	private JTextField txtUsername;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JPasswordField passwordField;
	private ControladorUsuario controladorUsuario; // Declara la instancia de ControladorUsuario

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		controladorUsuario = new ControladorUsuario();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 551);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(39, 91, 131));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(113, 113, 113));
		passwordField.setBackground(new Color(192, 192, 192));
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBounds(192, 244, 216, 48);
		contentPane.add(passwordField);

		lblNewLabel_5 = new JLabel("ADMINISTRADOR");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(192, 117, 178, 29);
		contentPane.add(lblNewLabel_5);

		lblNewLabel_4 = new JLabel("LOGIN");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_4.setBounds(211, 78, 159, 29);
		contentPane.add(lblNewLabel_4);

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3
				.setIcon(new ImageIcon("C:\\Users\\Usuario\\Downloads\\Captura de pantalla 2024-11-01 212904 (1).png"));
		lblNewLabel_3.setBounds(145, 244, 48, 48);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2
				.setIcon(new ImageIcon("C:\\Users\\Usuario\\Downloads\\Captura de pantalla 2024-11-01 212704 (1).png"));
		lblNewLabel_2.setBounds(145, 180, 48, 48);
		contentPane.add(lblNewLabel_2);

		txtUsername = new JTextField();
		txtUsername.setForeground(new Color(104, 105, 106));
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtUsername.setText("    Username");
		txtUsername.setBackground(new Color(192, 192, 192));
		txtUsername.setBounds(192, 180, 216, 48);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);

		btnNewButton = new JButton("Log In");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(39, 91, 131));
		btnNewButton.setBounds(203, 340, 183, 48);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel
				.setIcon(new ImageIcon("C:\\Users\\Usuario\\Downloads\\Captura de pantalla 2024-11-01 211115 (1).png"));
		lblNewLabel.setBounds(576, 78, 260, 352);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(new Color(104, 105, 106));
		lblNewLabel_1
				.setIcon(new ImageIcon("C:\\Users\\Usuario\\Downloads\\Captura de pantalla 2024-11-01 211334 (1).png"));
		lblNewLabel_1.setBounds(0, 0, 576, 512);
		contentPane.add(lblNewLabel_1);

		// Agrega el ActionListener al botón de loguearse

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String correo = txtUsername.getText();
				String contrasena = new String(passwordField.getPassword());
				modelo.Usuario usuarioLogueado = controladorUsuario.autenticarUsuario(correo, contrasena);
				if (usuarioLogueado != null) {
					// Lógica para cuando la autenticación es exitosa
					JOptionPane.showMessageDialog(null, "Login successful!");
				} else {
					// Lógica para cuando la autenticación falla
					JOptionPane.showMessageDialog(null, "Login failed!");
				}
			}
		});

	}
}
