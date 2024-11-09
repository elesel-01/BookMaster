package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JButton button_7 = new JButton("Agregar Libro");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 553);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(39, 91, 131));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_7.setBounds(332, 117, 151, 31);
		contentPane.add(button_7);
		
		JButton button_1 = new JButton("New button");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_1.setBounds(332, 158, 151, 31);
		contentPane.add(button_1);
		
		JButton button_9 = new JButton("Eliminar Usuario");
		button_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_9.setBounds(577, 147, 130, 31);
		contentPane.add(button_9);
		
		JButton button_10 = new JButton("<html><center>Ver usuario<br>moroso</center></html>");
		button_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_10.setBounds(577, 199, 130, 39);
		contentPane.add(button_10);
		
		JButton button_6 = new JButton("Cerrar Seción");
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_6.setBounds(62, 171, 130, 31);
		contentPane.add(button_6);
		
		JButton button_2 = new JButton("Ver Solicitudes");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setBounds(106, 294, 130, 31);
		contentPane.add(button_2);
		
		JButton button_4 = new JButton("Libros Prestados");
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_4.setBounds(106, 426, 130, 31);
		contentPane.add(button_4);
		
		JButton button_3 = new JButton("Lista de Libros");
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_3.setBounds(106, 360, 130, 31);
		contentPane.add(button_3);
		
		JButton button_8 = new JButton("<html><center>Crear cuenta<br>Usuario</center></html>");
		button_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_8.setBounds(577, 91, 130, 39);
		contentPane.add(button_8);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Usuario\\Downloads\\pngegg (1).png"));
		lblNewLabel.setBounds(62, 31, 130, 130);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Administración de Libros");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(318, 31, 184, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Administración de Usuarios");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(552, 31, 211, 31);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Usuario\\Downloads\\linea (1).png"));
		lblNewLabel_2.setBounds(445, 72, 136, 177);
		contentPane.add(lblNewLabel_2);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(318, 294, 382, 177);
		contentPane.add(textPane);
	}
}
