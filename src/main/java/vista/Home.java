package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class Home extends JPanel {

    private static final long serialVersionUID = 1L;
    private final JButton button_7 = new JButton("Agregar Libro");

    /**
     * Create the panel.
     */
    public Home() {
    	setPreferredSize(new java.awt.Dimension(1040, 600));
        setBackground(new Color(39, 91, 131));
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);
        button_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
        button_7.setBounds(411, 114, 170, 47);
        add(button_7);

        JButton button_1 = new JButton("New button");
        button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        button_1.setBounds(411, 193, 170, 47);
        add(button_1);

        JButton button_9 = new JButton("Eliminar Usuario");
        button_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
        button_9.setBounds(739, 152, 170, 47);
        add(button_9);
        button_9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Navigate to DeleteUsuario view
                navigateToDeleteUsuario();
            }
        });

        JButton button_10 = new JButton("<html><center>Ver usuario<br>moroso</center></html>");
        button_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
        button_10.setBounds(739, 221, 170, 47);
        add(button_10);

        JButton button_6 = new JButton("Cerrar Seción");
        button_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        button_6.setBounds(112, 212, 145, 38);
        add(button_6);

        JButton button_2 = new JButton("Ver Solicitudes");
        button_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        button_2.setBounds(106, 322, 151, 47);
        add(button_2);

        JButton button_4 = new JButton("Libros Prestados");
        button_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        button_4.setBounds(106, 492, 151, 47);
        add(button_4);
        button_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Navigate to LibroBorrow view
                navigateToLibroBorrow();
            }
        });

        JButton button_3 = new JButton("Lista de Libros");
        button_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        button_3.setBounds(106, 406, 151, 47);
        add(button_3);

        JButton button_8 = new JButton("<html><center>Crear cuenta<br>Usuario</center></html>");
        button_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
        button_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        button_8.setBounds(739, 84, 170, 47);
        add(button_8);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("src\\main\\java\\Imagen\\pngegg.png"));
        lblNewLabel.setBounds(88, 16, 183, 183);
        add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Administración de Libros");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblNewLabel_1.setBounds(381, 29, 253, 31);
        add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Administración de Usuarios");
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblNewLabel_1_1.setBounds(721, 31, 290, 31);
        add(lblNewLabel_1_1);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("src\\main\\java\\Imagen\\linea (1).png"));
        lblNewLabel_2.setBounds(593, 80, 136, 177);
        add(lblNewLabel_2);

        JTextPane textPane = new JTextPane();
        textPane.setBounds(381, 294, 573, 260);
        add(textPane);
    }

    private void navigateToDeleteUsuario() {
        // Implement the logic to navigate to DeleteUsuario view
    }

    private void navigateToLibroBorrow() {
        // Implement the logic to navigate to LibroBorrow view
    }
}

