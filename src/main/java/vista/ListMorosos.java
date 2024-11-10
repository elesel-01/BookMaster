package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class ListMorosos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ListMorosos() {
		setBackground(new Color(255, 255, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 149, 656, 309);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1 = new JLabel("<html>Usuarios<br>Morosos</html>");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(20, 10, 154, 112);
		add(lblNewLabel_1);

		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(39, 91, 131));
		textArea.setBounds(0, 0, 249, 133);
		add(textArea);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel
				.setIcon(new ImageIcon("src\\main\\java\\Imagen\\Captura de pantalla 2024-11-01 215004 (1).png"));
		lblNewLabel.setBounds(246, 0, 590, 133);
		add(lblNewLabel);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(186, 450, 161, 34);
		add(textArea_1);
	}
}
