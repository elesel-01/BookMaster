package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RegisterUsuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public RegisterUsuario() {
		setBackground(new Color(255, 255, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("src\\main\\java\\Imagen\\pngegg (2) (1).png"));
		lblNewLabel.setBounds(608, 0, 228, 171);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("<html>Registrar<br>Usuario</html>");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(23, 28, 154, 112);
		add(lblNewLabel_1);

		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(39, 91, 131));
		textArea.setBounds(0, 0, 836, 171);
		add(textArea);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(199, 254, 251));
		panel.setBounds(34, 217, 99, 36);
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
		panel_1.setBounds(34, 280, 99, 36);
		add(panel_1);

		JLabel lblNewLabel_2_1 = new JLabel("Contraseña");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBackground(Color.CYAN);
		lblNewLabel_2_1.setBounds(0, 0, 99, 31);
		panel_1.add(lblNewLabel_2_1);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(199, 254, 251));
		panel_2.setBounds(407, 217, 99, 36);
		add(panel_2);

		JLabel lblNewLabel_2_2 = new JLabel("Nombre");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_2.setBackground(Color.CYAN);
		lblNewLabel_2_2.setBounds(10, 0, 79, 31);
		panel_2.add(lblNewLabel_2_2);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(199, 254, 251));
		panel_3.setBounds(407, 280, 99, 36);
		add(panel_3);

		JLabel lblNewLabel_2_3 = new JLabel("Apellido");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_3.setBackground(Color.CYAN);
		lblNewLabel_2_3.setBounds(10, 0, 89, 31);
		panel_3.add(lblNewLabel_2_3);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(153, 217, 194, 36);
		add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(153, 280, 194, 36);
		add(textField_1);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(531, 217, 194, 36);
		add(textField_2);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(531, 280, 194, 36);
		add(textField_3);

		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(34, 450, 130, 36);
		add(btnNewButton);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(186, 450, 161, 34);
		add(textArea_1);
	}
}
