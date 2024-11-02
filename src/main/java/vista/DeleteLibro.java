package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DeleteLibro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteLibro frame = new DeleteLibro();
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
	public DeleteLibro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("<html>Eliminar<br>Libro</html>");
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
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setBounds(21, 0, 68, 31);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setBackground(new Color(0, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(153, 217, 194, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(34, 450, 130, 36);
		contentPane.add(btnNewButton);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(186, 450, 161, 34);
		contentPane.add(textArea_1);
	}
}
