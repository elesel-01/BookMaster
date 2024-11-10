package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SelectLogin extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnNewButton;
	private JLabel lblNewLabel_4;
	private JButton btnIniciarSecin;

	/**
	 * Create the panel.
	 */
	public SelectLogin() {
		setBackground(new Color(39, 91, 131));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);

		btnIniciarSecin = new JButton("Iniciar sesión como Administrador");
		btnIniciarSecin.setForeground(Color.BLACK);
		btnIniciarSecin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnIniciarSecin.setBackground(new Color(192, 192, 192));
		btnIniciarSecin.setBounds(144, 213, 287, 39);
		add(btnIniciarSecin);

		btnIniciarSecin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login loginPanel = new Login();
				// Add logic to switch to the login panel
			}
		});

		lblNewLabel_4 = new JLabel("BOOKMASTER");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel_4.setBounds(158, 93, 239, 29);
		add(lblNewLabel_4);

		btnNewButton = new JButton("Iniciar sesión como Usuario");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setBounds(144, 280, 287, 39);
		add(btnNewButton);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel
				.setIcon(new ImageIcon("C:\\Users\\Usuario\\Downloads\\Captura de pantalla 2024-11-01 211115 (1).png"));
		lblNewLabel.setBounds(576, 78, 260, 352);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(new Color(104, 105, 106));
		lblNewLabel_1
				.setIcon(new ImageIcon("C:\\Users\\Usuario\\Downloads\\Captura de pantalla 2024-11-01 211334 (1).png"));
		lblNewLabel_1.setBounds(0, 0, 576, 512);
		add(lblNewLabel_1);
	}
}
