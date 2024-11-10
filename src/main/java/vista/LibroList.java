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
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class LibroList extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTable table;

    /**
     * Create the panel.
     */
    public LibroList() {
    	setPreferredSize(new java.awt.Dimension(1040, 600));
    	setBackground(new Color(255, 255, 255));
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(54, 195, 758, 382);
        add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        JLabel lblNewLabel_1 = new JLabel("<html>Lista de<br>Libros</html>");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel_1.setBounds(20, 10, 154, 112);
        add(lblNewLabel_1);

        JTextArea textArea = new JTextArea();
        textArea.setBackground(new Color(39, 91, 131));
        textArea.setBounds(0, 0, 293, 163);
        add(textArea);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("src\\main\\java\\Imagen\\Captura de pantalla 2024-11-01 215004.png"));
        lblNewLabel.setBounds(293, 0, 747, 163);
        add(lblNewLabel);

        JTextArea textArea_1 = new JTextArea();
        textArea_1.setBounds(186, 450, 161, 34);
        add(textArea_1);
    }
}
