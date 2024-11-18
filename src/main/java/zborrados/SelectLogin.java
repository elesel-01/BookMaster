
/*package zborrados;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import vista.RegistroLibro;


public class SelectLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private CardLayout cardLayout;

    /**
     * Create the frame.
     
    public SelectLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1040, 640);
        setLocationRelativeTo(null);
        cardLayout = new CardLayout();
        contentPane = new JPanel(cardLayout);
        contentPane.setBackground(new Color(39, 91, 131));
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);

        JPanel selectLoginPanel = new JPanel();
        selectLoginPanel.setBackground(new Color(39, 91, 131));
        selectLoginPanel.setLayout(null);
        contentPane.add(selectLoginPanel, "SelectLogin");

        JButton btnIniciarSecin = new JButton("Iniciar sesión como Administrador");
        btnIniciarSecin.setForeground(Color.BLACK);
        btnIniciarSecin.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnIniciarSecin.setBackground(new Color(192, 192, 192));
        btnIniciarSecin.setBounds(158, 243, 320, 48);
        selectLoginPanel.add(btnIniciarSecin);

        btnIniciarSecin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "Login");
            }
        });

        JLabel lblNewLabel_4 = new JLabel("BOOKMASTER");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 38));
        lblNewLabel_4.setBounds(175, 123, 303, 56);
        selectLoginPanel.add(lblNewLabel_4);

        JButton btnNewButton = new JButton("Iniciar sesión como Usuario");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(new Color(192, 192, 192));
        btnNewButton.setBounds(158, 337, 320, 48);
        selectLoginPanel.add(btnNewButton);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setForeground(new Color(104, 105, 106));
        lblNewLabel_1.setIcon(new ImageIcon("src\\main\\java\\Imagen\\Captura de pantalla 2024-11-01 211334.png"));
        lblNewLabel_1.setBounds(0, 0, 716, 603);
        selectLoginPanel.add(lblNewLabel_1);
        
                JLabel lblNewLabel = new JLabel("");
                lblNewLabel.setIcon(new ImageIcon("src\\main\\java\\Imagen\\Captura de pantalla 2024-11-01 211115.png"));
                lblNewLabel.setBounds(716, 99, 310, 423);
                selectLoginPanel.add(lblNewLabel);

        Login loginPanel = new Login(cardLayout, contentPane);
        contentPane.add(loginPanel, "Login");

        //Home homePanel = new Home(contentPane, cardLayout);
        //contentPane.add(homePanel, "Home");
        
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
        
    }

    public static void main(String[] args) {
        SelectLogin frame = new SelectLogin();
        frame.setVisible(true);
    }
}*/