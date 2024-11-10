
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

public class RegistroLibro extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;

    /**
     * Create the panel.
     */
    public RegistroLibro() {
    	setPreferredSize(new java.awt.Dimension(1040, 600));
        setBackground(new Color(255, 255, 255));
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("<html>Agregar<br>Libro</html>");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 35));
        lblNewLabel_1.setBounds(23, 28, 174, 132);
        add(lblNewLabel_1);

        JTextArea textArea = new JTextArea();
        textArea.setBackground(new Color(39, 91, 131));
        textArea.setBounds(0, 0, 259, 203);
        add(textArea);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("src\\main\\java\\Imagen\\Captura de pantalla 2024-11-01 215004.png"));
        lblNewLabel.setBounds(251, 0, 789, 203);
        add(lblNewLabel);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(199, 254, 251));
        panel.setBounds(34, 217, 99, 36);
        add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("Titulo");
        lblNewLabel_2.setBounds(21, 0, 68, 36);
        panel.add(lblNewLabel_2);
        lblNewLabel_2.setBackground(new Color(0, 255, 255));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBackground(new Color(199, 254, 251));
        panel_1.setBounds(34, 293, 99, 36);
        add(panel_1);

        JLabel lblNewLabel_2_1 = new JLabel("Autor");
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_2_1.setBackground(Color.CYAN);
        lblNewLabel_2_1.setBounds(21, 0, 68, 31);
        panel_1.add(lblNewLabel_2_1);

        JPanel panel_2 = new JPanel();
        panel_2.setLayout(null);
        panel_2.setBackground(new Color(199, 254, 251));
        panel_2.setBounds(546, 213, 99, 36);
        add(panel_2);

        JLabel lblNewLabel_2_2 = new JLabel("Editorial");
        lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_2_2.setBackground(Color.CYAN);
        lblNewLabel_2_2.setBounds(10, 0, 79, 31);
        panel_2.add(lblNewLabel_2_2);

        JPanel panel_3 = new JPanel();
        panel_3.setLayout(null);
        panel_3.setBackground(new Color(199, 254, 251));
        panel_3.setBounds(546, 280, 99, 36);
        add(panel_3);

        JLabel lblNewLabel_2_3 = new JLabel("Categoria");
        lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_2_3.setBackground(Color.CYAN);
        lblNewLabel_2_3.setBounds(10, 0, 89, 36);
        panel_3.add(lblNewLabel_2_3);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textField.setBounds(153, 217, 194, 36);
        add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textField_1.setColumns(10);
        textField_1.setBounds(153, 293, 194, 36);
        add(textField_1);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textField_2.setColumns(10);
        textField_2.setBounds(729, 213, 194, 36);
        add(textField_2);

        textField_3 = new JTextField();
        textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textField_3.setColumns(10);
        textField_3.setBounds(729, 280, 194, 36);
        add(textField_3);

        JButton btnNewButton = new JButton("Registrar");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 23));
        btnNewButton.setBounds(34, 505, 163, 47);
        add(btnNewButton);

        JTextArea textArea_1 = new JTextArea();
        textArea_1.setBounds(220, 505, 212, 47);
        add(textArea_1);
        
        JPanel panel_4 = new JPanel();
        panel_4.setLayout(null);
        panel_4.setBackground(new Color(199, 254, 251));
        panel_4.setBounds(34, 358, 99, 47);
        add(panel_4);
        
        JLabel lblNewLabel_2_4 = new JLabel("<html>Codigo<br>Estanteria</html>");
        lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_4.setBackground(Color.CYAN);
        lblNewLabel_2_4.setBounds(10, 0, 79, 47);
        panel_4.add(lblNewLabel_2_4);
        
        textField_4 = new JTextField();
        textField_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textField_4.setColumns(10);
        textField_4.setBounds(153, 358, 194, 47);
        add(textField_4);
        
        JPanel panel_4_1 = new JPanel();
        panel_4_1.setLayout(null);
        panel_4_1.setBackground(new Color(199, 254, 251));
        panel_4_1.setBounds(546, 358, 99, 47);
        add(panel_4_1);
        
        JLabel lblNewLabel_2_4_1 = new JLabel("<html>Año<br>Publicación</html>");
        lblNewLabel_2_4_1.setBounds(10, 0, 79, 47);
        panel_4_1.add(lblNewLabel_2_4_1);
        lblNewLabel_2_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_4_1.setBackground(Color.CYAN);
        
        textField_5 = new JTextField();
        textField_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textField_5.setColumns(10);
        textField_5.setBounds(729, 358, 194, 47);
        add(textField_5);
        
        JPanel panel_4_2 = new JPanel();
        panel_4_2.setLayout(null);
        panel_4_2.setBackground(new Color(199, 254, 251));
        panel_4_2.setBounds(603, 505, 107, 47);
        add(panel_4_2);
        
        JLabel lblNewLabel_2_4_2 = new JLabel("<html>Numero<br>de libros</html>");
        lblNewLabel_2_4_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_2_4_2.setBackground(Color.CYAN);
        lblNewLabel_2_4_2.setBounds(10, 0, 97, 47);
        panel_4_2.add(lblNewLabel_2_4_2);
        
        textField_6 = new JTextField();
        textField_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textField_6.setColumns(10);
        textField_6.setBounds(742, 505, 86, 47);
        add(textField_6);
    }
}

