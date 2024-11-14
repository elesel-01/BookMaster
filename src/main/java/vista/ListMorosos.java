package vista;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class ListMorosos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JPanel contentPane;  // Sin inicializar aquí
    private CardLayout cardLayout;
	/**
	 * Create the panel.
	 */
	public ListMorosos(CardLayout cardLayout, JPanel contentPane) {
		this.cardLayout = cardLayout;
        this.contentPane = contentPane;
		setPreferredSize(new java.awt.Dimension(1040, 600));
		setBackground(new Color(255, 255, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 171, 790, 391);
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
		textArea.setBounds(0, 0, 260, 152);
		add(textArea);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel
				.setIcon(new ImageIcon("src\\main\\java\\Imagen\\Captura de pantalla 2024-11-01 215004.png"));
		lblNewLabel.setBounds(258, 0, 782, 152);
		add(lblNewLabel);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(186, 450, 161, 34);
		add(textArea_1);
		
		JButton volverButton = new JButton("Volver");
        volverButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        volverButton.setBounds(847, 530, 142, 46);
        add(volverButton);
        volverButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cardLayout.show(contentPane, "Home");
            }
        });
	}
}
