
package vista;

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

public class SelectLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private CardLayout cardLayout;

    /**
     * Create the frame.
     */
    public SelectLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 850, 600);
        cardLayout = new CardLayout();
        contentPane = new JPanel(cardLayout);
        contentPane.setBackground(new Color(39, 91, 131));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JPanel selectLoginPanel = new JPanel();
        selectLoginPanel.setBackground(new Color(39, 91, 131));
        selectLoginPanel.setLayout(null);
        contentPane.add(selectLoginPanel, "SelectLogin");

        JButton btnIniciarSecin = new JButton("Iniciar sesión como Administrador");
        btnIniciarSecin.setForeground(Color.BLACK);
        btnIniciarSecin.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnIniciarSecin.setBackground(new Color(192, 192, 192));
        btnIniciarSecin.setBounds(144, 213, 287, 39);
        selectLoginPanel.add(btnIniciarSecin);

        btnIniciarSecin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "Login");
            }
        });

        JLabel lblNewLabel_4 = new JLabel("BOOKMASTER");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 32));
        lblNewLabel_4.setBounds(158, 93, 239, 29);
        selectLoginPanel.add(lblNewLabel_4);

        JButton btnNewButton = new JButton("Iniciar sesión como Usuario");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(new Color(192, 192, 192));
        btnNewButton.setBounds(144, 280, 287, 39);
        selectLoginPanel.add(btnNewButton);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("src\\main\\java\\Imagen\\Captura de pantalla 2024-11-01 211115 (1).png"));
        lblNewLabel.setBounds(576, 78, 260, 352);
        selectLoginPanel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setForeground(new Color(104, 105, 106));
        lblNewLabel_1.setIcon(new ImageIcon("src\\main\\java\\Imagen\\Captura de pantalla 2024-11-01 211334 (1).png"));
        lblNewLabel_1.setBounds(0, 0, 576, 512);
        selectLoginPanel.add(lblNewLabel_1);

        Login loginPanel = new Login(cardLayout, contentPane);
        contentPane.add(loginPanel, "Login");

        Home homePanel = new Home();
        contentPane.add(homePanel, "Home");
    }

    public static void main(String[] args) {
        SelectLogin frame = new SelectLogin();
        frame.setVisible(true);
    }
}

