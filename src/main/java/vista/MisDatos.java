package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import modelo.Session;
import modelo.Usuario;

public class MisDatos extends JPanel {

	private static final long serialVersionUID = 1L;
	private Usuario usuario = Session.getUsuarioActual();
	
	String nombre = usuario.getNombre();
	String apellido = usuario.getApellido();
	String email = usuario.getEmail();
	String pass = usuario.getPassw();
	int dni = usuario.getDni();
	String rol = usuario.getRol();
	int id = usuario.getId();
	/**
	 * Create the panel.
	 */
	public MisDatos() {
		setBackground(Color.decode("#1F4E61"));
		setBounds(0, 0, 1040, 640);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 696, 640);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBounds(169, 551, 263, 42);
		panel.add(panel_8);
		
		JLabel lblId = new JLabel(String.valueOf(id));
		lblId.setBounds(10, 11, 223, 20);
		panel_8.add(lblId);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBounds(169, 488, 263, 42);
		panel.add(panel_7);
		
		JLabel lblRol = new JLabel(rol);
		lblRol.setBounds(10, 11, 223, 20);
		panel_7.add(lblRol);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(169, 425, 263, 42);
		panel.add(panel_6);
		
		JLabel lblDni = new JLabel(String.valueOf(dni));
		lblDni.setBounds(10, 11, 223, 20);
		panel_6.add(lblDni);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(169, 360, 263, 42);
		panel.add(panel_5);
		
		JLabel lblPass = new JLabel(pass);
		lblPass.setBounds(10, 11, 223, 20);
		panel_5.add(lblPass);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(169, 294, 263, 42);
		panel.add(panel_4);
		
		JLabel lblEmail = new JLabel(email);
		lblEmail.setBounds(10, 11, 223, 20);
		panel_4.add(lblEmail);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(169, 228, 263, 42);
		panel.add(panel_3);
		
		JLabel lblApellido = new JLabel(apellido);
		lblApellido.setBounds(10, 11, 223, 20);
		panel_3.add(lblApellido);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(169, 157, 263, 42);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNombre = new JLabel(nombre);
		lblNombre.setBounds(10, 11, 223, 20);
		panel_2.add(lblNombre);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(MisDatos.class.getResource("/media/lockicon.png")));
		lblNewLabel_5.setBounds(108, 358, 41, 46);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(MisDatos.class.getResource("/media/agregar-usuario (1).png")));
		lblNewLabel_4.setBounds(108, 153, 41, 46);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("BOOKMASTER");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Konkhmer Sleokchher", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(41, 80, 212, 46);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("MIS DATOS");
		lblNewLabel_2.setFont(new Font("Konkhmer Sleokchher", Font.PLAIN, 40));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(20, 32, 254, 81);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MisDatos.class.getResource("/media/fondobibliologinsecodresize.png")));
		lblNewLabel.setBounds(0, 0, 696, 640);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(695, 68, 345, 518);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MisDatos.class.getResource("/media/s2ndresizekid.jpg")));
		lblNewLabel_1.setBounds(0, 0, 345, 518);
		panel_1.add(lblNewLabel_1);

	}
}