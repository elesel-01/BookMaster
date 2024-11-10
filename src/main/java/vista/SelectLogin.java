package vista;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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

        JPanel selectLoginPanel = new JPanel(new GridBagLayout());
        selectLoginPanel.setBackground(new Color(39, 91, 131));
        contentPane.add(selectLoginPanel, "SelectLogin");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel lblNewLabel_4 = new JLabel("BOOKMASTER");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 32));
        selectLoginPanel.add(lblNewLabel_4, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton btnIniciarSecin = new JButton("Iniciar sesión como Administrador");
        btnIniciarSecin.setForeground(Color.BLACK);
        btnIniciarSecin.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnIniciarSecin.setBackground(new Color(192, 192, 192));
        selectLoginPanel.add(btnIniciarSecin, gbc);

        btnIniciarSecin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "Login");
            }
        });

        gbc.gridy++;

        JButton btnNewButton = new JButton("Iniciar sesión como Usuario");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(new Color(192, 192, 192));
        selectLoginPanel.add(btnNewButton, gbc);

        gbc.gridx++;
        gbc.gridy = 1;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("src\\main\\java\\Imagen\\Captura de pantalla 2024-11-01 211115 (1).png"));
        selectLoginPanel.add(lblNewLabel, gbc);

        gbc.gridx++;
        gbc.gridheight = 2;

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setForeground(new Color(104, 105, 106));
        lblNewLabel_1.setIcon(new ImageIcon("src\\main\\java\\Imagen\\Captura de pantalla 2024-11-01 211334 (1).png"));
        selectLoginPanel.add(lblNewLabel_1, gbc);

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

