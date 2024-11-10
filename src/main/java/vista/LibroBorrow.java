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

public class LibroBorrow extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField txtId;
    private JTable table;

    /**
     * Create the panel.
     */
    public LibroBorrow() {
    	setPreferredSize(new java.awt.Dimension(1040, 600));
    	setBackground(new Color(255, 255, 255));
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(55, 221, 731, 355);
        add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        JLabel lblNewLabel_1 = new JLabel("<html>Libros<br>Prestados</html>");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel_1.setBounds(20, 10, 154, 112);
        add(lblNewLabel_1);

        JTextArea textArea = new JTextArea();
        textArea.setBackground(new Color(39, 91, 131));
        textArea.setBounds(0, 0, 249, 153);
        add(textArea);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("src\\main\\java\\Imagen\\Captura de pantalla 2024-11-01 215004.png"));
        lblNewLabel.setBounds(246, 0, 794, 153);
        add(lblNewLabel);

        txtId = new JTextField();
        txtId.setText("ID");
        txtId.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtId.setBounds(55, 163, 194, 36);
        add(txtId);
        txtId.setColumns(10);

        JButton btnNewButton = new JButton("Devolver");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.setBounds(269, 162, 130, 36);
        add(btnNewButton);

        JTextArea textArea_1 = new JTextArea();
        textArea_1.setBounds(186, 450, 161, 34);
        add(textArea_1);
    }
}
