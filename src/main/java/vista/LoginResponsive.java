package vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import controlador.ControladorUsuario;
import modelo.Usuario;

public class LoginResponsive extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel Fondo;
    private JPanel Cuerpo;

    public JButton btnRegistrar;
    public JButton btnIngresar;
    public JTextField txtUser;
    public JPasswordField txtPassword;
    public JLabel lblFondo;
    public JLabel logoApp;
    public JLabel lblTitulo;
    public JLabel lblUsuario;
    public JLabel lblContrasea;
    public JLabel lblAnNoTienes;
    public JLabel lblIconoUsuario;
    public JLabel lblIconoPassword;
    public JLabel lblEspacioVacio;
    private GridBagConstraints gbc_1;
    private GridBagConstraints gbc_2;
    private GridBagConstraints gbc_3;
    private GridBagConstraints gbc_4;
    private GridBagConstraints gbc_5;
    private GridBagConstraints gbc_6;

    private ControladorUsuario controladorUsuario;
    private JPanel contentPane;
    private CardLayout cardLayout;

    public LoginResponsive() {
        controladorUsuario = new ControladorUsuario(); // Instancia de ControladorUsuario

        setTitle("Login Responsive");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1040, 640);
        setLocationRelativeTo(null);
        setBackground(new Color(66, 72, 93));

        cardLayout = new CardLayout();
        contentPane = new JPanel(cardLayout);
        setContentPane(contentPane);

        // Añadir paneles Home y BusquedaAutor

        // Añadir panel de login
        JPanel loginPanel = new JPanel(new BorderLayout());
        contentPane.add(loginPanel, "Login");

        Fondo = new JPanel();
        Fondo.setLayout(new BorderLayout());
        loginPanel.add(Fondo, BorderLayout.WEST);

        lblFondo = new JLabel();
        lblFondo.setHorizontalAlignment(JLabel.CENTER);
        Fondo.add(lblFondo, BorderLayout.CENTER);
        lblFondo.setIcon(new ImageIcon(LoginResponsive.class.getResource("/media/721825d43ae12e59579c8a693c42ceb0.png")));
        lblFondo.setPreferredSize(new Dimension(400, lblFondo.getHeight()));

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int anchoVentana = getWidth();
                int anchoMinimoVentana = 1100;
                int anchoMaximoVentana = 1600;
                int anchoMinimoFondo = 400;
                int anchoMaximoFondo = 640;

                if (anchoVentana <= anchoMinimoVentana) {
                    lblFondo.setPreferredSize(new Dimension(anchoMinimoFondo, lblFondo.getHeight()));
                } else if (anchoVentana >= anchoMaximoVentana) {
                    lblFondo.setPreferredSize(new Dimension(anchoMaximoFondo, lblFondo.getHeight()));
                } else {
                    int nuevoAncho = anchoMinimoFondo + (anchoVentana - anchoMinimoVentana) * (anchoMaximoFondo - anchoMinimoFondo) / (anchoMaximoVentana - anchoMinimoVentana);
                    lblFondo.setPreferredSize(new Dimension(nuevoAncho, lblFondo.getHeight()));
                }

                Fondo.revalidate();
                Fondo.repaint();
            }
        });

        initStyles();

        Cuerpo = new JPanel();
        Cuerpo.setBackground(Color.decode("#1F4E61"));
        Cuerpo.setLayout(new GridBagLayout());
        loginPanel.add(Cuerpo, BorderLayout.CENTER);

        Cuerpo.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Dimension size = Cuerpo.getSize();
                double scaleFactor = Math.min(size.getWidth() / 840, size.getHeight() / 540);

                logoApp.setFont(logoApp.getFont().deriveFont((float) (30 * scaleFactor)));
                lblTitulo.setFont(lblTitulo.getFont().deriveFont((float) (27 * scaleFactor)));
                lblAnNoTienes.setFont(lblAnNoTienes.getFont().deriveFont((float) (25 * scaleFactor)));
                btnIngresar.setFont(btnIngresar.getFont().deriveFont((float) (14 * scaleFactor)));
                btnRegistrar.setFont(btnRegistrar.getFont().deriveFont((float) (14 * scaleFactor)));

                Cuerpo.revalidate();
                Cuerpo.repaint();
            }
        });

        GridBagConstraints gbc;

        // Logo de la aplicación
        logoApp = DefaultComponentFactory.getInstance().createLabel("");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        Cuerpo.add(logoApp, gbc);

        // Título
        lblTitulo = new JLabel("LOGIN");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Konkhmer Sleokchher", Font.BOLD, 40));
        gbc_6 = new GridBagConstraints();
        gbc_6.gridwidth = 3;
        gbc_6.insets = new Insets(10, 10, 10, 10);
        gbc_6.gridx = 1;
        gbc_6.gridy = 1;
        Cuerpo.add(lblTitulo, gbc_6);

        // Etiqueta "¿Aún no tienes cuenta?"
        lblAnNoTienes = new JLabel("  BOOKMASTER");
        lblAnNoTienes.setHorizontalAlignment(SwingConstants.CENTER);
        lblAnNoTienes.setForeground(Color.WHITE);
        lblAnNoTienes.setFont(new Font("Konkhmer Sleokchher", Font.BOLD, 20));
        gbc_5 = new GridBagConstraints();
        gbc_5.insets = new Insets(20, 20, 10, 10);
        gbc_5.gridx = 1;
        gbc_5.gridy = 2;
        gbc_5.gridwidth = 3;
        gbc_5.anchor = GridBagConstraints.NORTHWEST;
        Cuerpo.add(lblAnNoTienes, gbc_5);

        // Icono de usuario
        lblIconoUsuario = DefaultComponentFactory.getInstance().createTitle("");
        lblIconoUsuario.setIcon(new ImageIcon(LoginResponsive.class.getResource("/media/agregar-usuario (1).png")));
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        Cuerpo.add(lblIconoUsuario, gbc);

        lblEspacioVacio = DefaultComponentFactory.getInstance().createTitle("");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        Cuerpo.add(lblEspacioVacio, gbc);

        // Campo de usuario
        txtUser = new JTextField("Ingresar usuario");
        txtUser.setForeground(Color.GRAY);
        txtUser.setColumns(20);
        gbc_3 = new GridBagConstraints();
        gbc_3.gridwidth = 3;
        gbc_3.insets = new Insets(10, 10, 10, 10);
        gbc_3.gridx = 1;
        gbc_3.gridy = 4;
        gbc_3.fill = GridBagConstraints.BOTH;
        Cuerpo.add(txtUser, gbc_3);

        // Icono de contraseña
        lblIconoPassword = DefaultComponentFactory.getInstance().createTitle("");
        lblIconoPassword.setIcon(new ImageIcon(LoginResponsive.class.getResource("/media/lockicon.png")));
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        Cuerpo.add(lblIconoPassword, gbc);

        // Campo de contraseña
        txtPassword = new JPasswordField("**********");
        txtPassword.setForeground(Color.GRAY);
        txtPassword.setColumns(20);
        gbc_4 = new GridBagConstraints();
        gbc_4.gridwidth = 3;
        gbc_4.insets = new Insets(10, 10, 10, 10);
        gbc_4.gridx = 1;
        gbc_4.gridy = 5;
        gbc_4.fill = GridBagConstraints.BOTH;
        Cuerpo.add(txtPassword, gbc_4);

        // Botón "Ingresar"
        btnIngresar = new JButton(" INGRESAR ");
        btnIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUser.getText();
                String contrasena = new String(txtPassword.getPassword());
                Usuario autenticado = controladorUsuario.autenticarUsuario(usuario, contrasena);
                if (autenticado != null) {
                    if (autenticado.getRol().equals("admin")) {
                        JOptionPane.showMessageDialog(null, "Login successful!");
                        cardLayout.show(contentPane, "Home");
                    } else {
                        JOptionPane.showMessageDialog(null, "Login successful!");
                        cardLayout.show(contentPane, "BusquedaAutor");
                    }
                } else {
                    // Acción si la autenticación falla
                }
            }
        });
        btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnIngresar.setBackground(new Color(255, 128, 0));
        btnIngresar.setForeground(Color.WHITE);
        gbc_1 = new GridBagConstraints();
        gbc_1.fill = GridBagConstraints.BOTH;
        gbc_1.insets = new Insets(10, 10, 10, 10);
        gbc_1.gridx = 2;
        gbc_1.gridy = 6;
        Cuerpo.add(btnIngresar, gbc_1);

        // Botón "Registrar"
        btnRegistrar = new JButton(" REGISTRARSE ");
        btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnRegistrar.setBackground(new Color(255, 128, 0));
        btnRegistrar.setForeground(Color.WHITE);
        gbc_2 = new GridBagConstraints();
        gbc_2.fill = GridBagConstraints.BOTH;
        gbc_2.insets = new Insets(10, 10, 10, 10);
        gbc_2.gridx = 2;
        gbc_2.gridy = 7;
        Cuerpo.add(btnRegistrar, gbc_2);

        initStyles(); // Inicializa los listeners para placeholders

        // Mostrar el panel de login inicialmente
        cardLayout.show(contentPane, "LoginResponsive");
        
        RegistroLibro registroLibroPanel = new RegistroLibro(cardLayout, contentPane);
        contentPane.add(registroLibroPanel, "RegistroLibro");
        
        DeleteLibro deleteLibroPanel = new DeleteLibro(cardLayout, contentPane);
        contentPane.add(deleteLibroPanel, "DeleteLibro");
        
        RegisterUsuario registerUsuarioPanel = new RegisterUsuario(cardLayout, contentPane);
        contentPane.add(registerUsuarioPanel, "RegisterUsuario");
        
        ListMorosos listMorososPanel = new ListMorosos(cardLayout, contentPane);
        contentPane.add(listMorososPanel, "ListMorosos");
        
        DeleteUsuario deleteUsuarioPanel = new DeleteUsuario(cardLayout, contentPane);
        contentPane.add(deleteUsuarioPanel, "DeleteUsuario");
        
        LibroList libroListPanel = new LibroList(cardLayout, contentPane);
        contentPane.add(libroListPanel, "LibroList");
        
        LibroBorrow libroBorrowPanel = new LibroBorrow(cardLayout, contentPane);
        contentPane.add(libroBorrowPanel, "LibroBorrow");
        
        BusquedaGenero busquedaGeneroPanel = new BusquedaGenero(contentPane, cardLayout);
        contentPane.add(busquedaGeneroPanel, "BusquedaGenero");
        BusquedaNombre busquedaNombrePanel = new BusquedaNombre(contentPane, cardLayout);
        contentPane.add(busquedaNombrePanel, "BusquedaNombre");
        
        Home homePanel = new Home(contentPane, cardLayout);
        contentPane.add(homePanel, "Home");
        
        BusquedaAutor busquedaAutorPanel = new BusquedaAutor(contentPane, cardLayout);
        contentPane.add(busquedaAutorPanel, "BusquedaAutor");
    }
    
    public JPanel getCuerpo() {
        return Cuerpo;
    }

    // MÉTODO PARA INICIALIZAR LOS LISTENERS Y EL COMPORTAMIENTO DE LOS PLACEHOLDERS
    private void initStyles() {
        // Agrega comportamiento específico aquí si es necesario
    }

    public static void main(String[] args) {
        LoginResponsive frame = new LoginResponsive();
        frame.setVisible(true);
    }
}