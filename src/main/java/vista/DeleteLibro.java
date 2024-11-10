
package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DeleteLibro extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textField;

    /**
     * Create the panel.
     */
    public DeleteLibro() {
    	setPreferredSize(new java.awt.Dimension(1040, 600));
        setBackground(new Color(255, 255, 255));
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("<html>Eliminar<br>Libro</html>");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 35));
        lblNewLabel_1.setBounds(23, 28, 154, 112);
        add(lblNewLabel_1);

        JTextArea textArea = new JTextArea();
        textArea.setBackground(new Color(39, 91, 131));
        textArea.setBounds(0, 0, 262, 193);
        add(textArea);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("src\\main\\java\\Imagen\\Captura de pantalla 2024-11-01 215004.png"));
        lblNewLabel.setBounds(260, 0, 780, 193);
        add(lblNewLabel);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(199, 254, 251));
        panel.setBounds(35, 244, 109, 46);
        add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("ID");
        lblNewLabel_2.setBounds(41, 0, 68, 46);
        panel.add(lblNewLabel_2);
        lblNewLabel_2.setBackground(new Color(0, 255, 255));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textField.setBounds(166, 244, 215, 46);
        add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("Eliminar");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
        btnNewButton.setBounds(35, 466, 166, 46);
        add(btnNewButton);

        JTextArea textArea_1 = new JTextArea();
        textArea_1.setBounds(186, 450, 161, 34);
        add(textArea_1);
    }
}

