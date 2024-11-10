
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

public class DeleteUsuario extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textField;

    /**
     * Create the panel.
     */
    public DeleteUsuario() {
    	setPreferredSize(new java.awt.Dimension(1040, 600));
    	setBackground(new Color(255, 255, 255));
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("src\\main\\java\\Imagen\\pngegg.png"));
        lblNewLabel.setBounds(793, 0, 247, 202);
        add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("<html>Eliminar<br>Usuario</html>");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 33));
        lblNewLabel_1.setBounds(23, 28, 181, 142);
        add(lblNewLabel_1);

        JTextArea textArea = new JTextArea();
        textArea.setBackground(new Color(39, 91, 131));
        textArea.setBounds(0, 0, 1040, 202);
        add(textArea);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(199, 254, 251));
        panel.setBounds(32, 270, 114, 55);
        add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("DNI");
        lblNewLabel_2.setBounds(36, 0, 68, 55);
        panel.add(lblNewLabel_2);
        lblNewLabel_2.setBackground(new Color(0, 255, 255));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 24));
        textField.setBounds(186, 270, 268, 55);
        add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("Eliminar");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
        btnNewButton.setBounds(34, 513, 194, 46);
        add(btnNewButton);

        JTextArea textArea_1 = new JTextArea();
        textArea_1.setBounds(258, 513, 181, 46);
        add(textArea_1);

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("src\\main\\java\\Imagen\\pngegg (3).png"));
        lblNewLabel_3.setBounds(812, 359, 228, 231);
        add(lblNewLabel_3);
    }
}

