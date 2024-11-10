
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
        setBackground(new Color(255, 255, 255));
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("src\\main\\java\\Imagen\\pngegg (2) (1).png"));
        lblNewLabel.setBounds(608, 0, 228, 171);
        add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("<html>Eliminar<br>Usuario</html>");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel_1.setBounds(23, 28, 154, 112);
        add(lblNewLabel_1);

        JTextArea textArea = new JTextArea();
        textArea.setBackground(new Color(39, 91, 131));
        textArea.setBounds(0, 0, 836, 171);
        add(textArea);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(199, 254, 251));
        panel.setBounds(34, 217, 99, 36);
        add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("DNI");
        lblNewLabel_2.setBounds(21, 0, 68, 31);
        panel.add(lblNewLabel_2);
        lblNewLabel_2.setBackground(new Color(0, 255, 255));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textField.setBounds(153, 217, 194, 36);
        add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("Eliminar");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.setBounds(34, 450, 130, 36);
        add(btnNewButton);

        JTextArea textArea_1 = new JTextArea();
        textArea_1.setBounds(186, 450, 161, 34);
        add(textArea_1);

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("src\\main\\java\\Imagen\\pngegg (3) (1).png"));
        lblNewLabel_3.setBounds(608, 296, 190, 190);
        add(lblNewLabel_3);
    }
}

