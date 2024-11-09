package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SelectLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;
	private JLabel lblNewLabel_4;
	private JButton btnIniciarSecin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectLogin frame = new SelectLogin();
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

	public SelectLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 549);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(39, 91, 131));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnIniciarSecin = new JButton("Iniciar sesión como Administrador");
		btnIniciarSecin.setForeground(Color.BLACK);
		btnIniciarSecin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnIniciarSecin.setBackground(new Color(192, 192, 192));
		btnIniciarSecin.setBounds(144, 213, 287, 39);
		contentPane.add(btnIniciarSecin);

		btnIniciarSecin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login loginFrame = new Login();
				loginFrame.setVisible(true);
				dispose(); // Cierra la ventana actual
			}
		});

		lblNewLabel_4 = new JLabel("BOOKMASTER");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel_4.setBounds(158, 93, 239, 29);
		contentPane.add(lblNewLabel_4);

		btnNewButton = new JButton("Iniciar sesión como Usuario");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setBounds(144, 280, 287, 39);
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
	}

}