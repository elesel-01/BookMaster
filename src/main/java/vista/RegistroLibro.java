package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RegistroLibro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroLibro frame = new RegistroLibro();
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
	public RegistroLibro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("<html>Agregar<br>Libro</html>");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(23, 28, 154, 112);
		contentPane.add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(39, 91, 131));
		textArea.setBounds(0, 0, 249, 171);
		contentPane.add(textArea);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Usuario\\Downloads\\Captura de pantalla 2024-11-01 215004 (1).png"));
		lblNewLabel.setBounds(246, 0, 590, 171);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(199, 254, 251));
		panel.setBounds(34, 217, 99, 36);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Titulo");
		lblNewLabel_2.setBounds(21, 0, 68, 31);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setBackground(new Color(0, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(199, 254, 251));
		panel_1.setBounds(34, 280, 99, 36);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Autor");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1.setBackground(Color.CYAN);
		lblNewLabel_2_1.setBounds(21, 0, 68, 31);
		panel_1.add(lblNewLabel_2_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(199, 254, 251));
		panel_2.setBounds(407, 217, 99, 36);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Editorial");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_2.setBackground(Color.CYAN);
		lblNewLabel_2_2.setBounds(10, 0, 79, 31);
		panel_2.add(lblNewLabel_2_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(199, 254, 251));
		panel_3.setBounds(407, 280, 99, 36);
		contentPane.add(panel_3);
		
		JLabel lblNewLabel_2_3 = new JLabel("Categoria");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_3.setBackground(Color.CYAN);
		lblNewLabel_2_3.setBounds(10, 0, 89, 31);
		panel_3.add(lblNewLabel_2_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(153, 217, 194, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(153, 280, 194, 36);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(531, 217, 194, 36);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(531, 280, 194, 36);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(34, 450, 130, 36);
		contentPane.add(btnNewButton);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(186, 450, 161, 34);
		contentPane.add(textArea_1);
	}
}
