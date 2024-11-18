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

        setPreferredSize(new java.awt.Dimension(1040, 600));
        setBackground(new Color(39, 91, 131));
        setBorder(new EmptyBorder(0, 0, 0, 0));
        setLayout(null);

        passwordField = new JPasswordField();
        passwordField.setForeground(new Color(113, 113, 113));
        passwordField.setBackground(new Color(192, 192, 192));
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        passwordField.setBounds(239, 304, 227, 58);
        add(passwordField);

        JLabel lblNewLabel_5 = new JLabel("ADMINISTRADOR");
        lblNewLabel_5.setBackground(new Color(255, 255, 255));
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 21));
        lblNewLabel_5.setBounds(256, 149, 196, 48);
        add(lblNewLabel_5);

        JLabel lblNewLabel_4 = new JLabel("LOGIN");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 44));
        lblNewLabel_4.setBounds(271, 91, 181, 48);
        add(lblNewLabel_4);

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("src\\main\\java\\Imagen\\Captura de pantalla 2024-11-01 212904.png"));
        lblNewLabel_3.setBounds(185, 304, 54, 58);
        add(lblNewLabel_3);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("src\\main\\java\\Imagen\\Captura de pantalla 2024-11-01 212704.png"));
        lblNewLabel_2.setBounds(185, 227, 54, 58);
        add(lblNewLabel_2);
        
                JButton btnNewButton = new JButton("Log In");
                btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
                btnNewButton.setForeground(new Color(0, 0, 0));
                btnNewButton.setBackground(new Color(192, 192, 192));
                btnNewButton.setBounds(246, 403, 202, 58);
                add(btnNewButton);
                
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

        txtUsername = new JTextField();
        txtUsername.setForeground(new Color(104, 105, 106));
        txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtUsername.setText("Username");
        txtUsername.setBackground(new Color(192, 192, 192));
        txtUsername.setBounds(239, 227, 227, 58);
        add(txtUsername);
        txtUsername.setColumns(10);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("src\\main\\java\\Imagen\\Captura de pantalla 2024-11-01 211115.png"));
        lblNewLabel.setBounds(730, 78, 310, 471);
        add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setForeground(new Color(104, 105, 106));
        lblNewLabel_1.setIcon(new ImageIcon("src\\main\\java\\Imagen\\Captura de pantalla 2024-11-01 211334.png"));
        lblNewLabel_1.setBounds(0, 0, 731, 640);
        add(lblNewLabel_1);
    }
}

