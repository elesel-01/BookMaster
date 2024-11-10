package vista;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import controlador.ControladorUsuario;
import modelo.Usuario;

public class Login extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField txtUsername;
    private JPasswordField passwordField;
    private ControladorUsuario controladorUsuario;
    private CardLayout cardLayout;
    private JPanel contentPane;

    /**
     * Create the panel.
     */
    public Login(CardLayout cardLayout, JPanel contentPane) {
        this.cardLayout = cardLayout;
        this.contentPane = contentPane;
        controladorUsuario = new ControladorUsuario();

        setBackground(new Color(39, 91, 131));
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        passwordField = new JPasswordField();
        passwordField.setForeground(new Color(113, 113, 113));
        passwordField.setBackground(new Color(192, 192, 192));
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        passwordField.setBounds(192, 244, 216, 48);
        add(passwordField);

        JLabel lblNewLabel_5 = new JLabel("ADMINISTRADOR");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_5.setBounds(192, 117, 178, 29);
        add(lblNewLabel_5);

        JLabel lblNewLabel_4 = new JLabel("LOGIN");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 35));
        lblNewLabel_4.setBounds(211, 78, 159, 29);
        add(lblNewLabel_4);

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("src\\main\\java\\Imagen\\Captura de pantalla 2024-11-01 212904 (1).png"));
        lblNewLabel_3.setBounds(145, 244, 48, 48);
        add(lblNewLabel_3);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("src\\main\\java\\Imagen\\Captura de pantalla 2024-11-01 212704 (1).png"));
        lblNewLabel_2.setBounds(145, 180, 48, 48);
        add(lblNewLabel_2);

        txtUsername = new JTextField();
        txtUsername.setForeground(new Color(104, 105, 106));
        txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtUsername.setText("    Username");
        txtUsername.setBackground(new Color(192, 192, 192));
        txtUsername.setBounds(192, 180, 216, 48);
        add(txtUsername);
        txtUsername.setColumns(10);

        JButton btnNewButton = new JButton("Log In");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(new Color(39, 91, 131));
        btnNewButton.setBounds(203, 340, 183, 48);
        add(btnNewButton);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("src\\main\\java\\Imagen\\Captura de pantalla 2024-11-01 211115 (1).png"));
        lblNewLabel.setBounds(576, 78, 260, 352);
        add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setForeground(new Color(104, 105, 106));
        lblNewLabel_1.setIcon(new ImageIcon("src\\main\\java\\Imagen\\Captura de pantalla 2024-11-01 211334 (1).png"));
        lblNewLabel_1.setBounds(0, 0, 576, 512);
        add(lblNewLabel_1);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String correo = txtUsername.getText();
                String contrasena = new String(passwordField.getPassword());
                Usuario usuarioLogueado = controladorUsuario.autenticarUsuario(correo, contrasena);
                if (usuarioLogueado != null) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    cardLayout.show(contentPane, "Home");
                } else {
                    JOptionPane.showMessageDialog(null, "Login failed!");
                }
            }
        });
    }
}

