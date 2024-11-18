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
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.*;
import base_de_datos.Coneccion;


public class LibroList extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTable table;
    private JPanel contentPane;  // Sin inicializar aquí
    private CardLayout cardLayout;

    /**
     * Create the panel.
     */
    public LibroList(CardLayout cardLayout, JPanel contentPane) {
    	this.cardLayout = cardLayout;
        this.contentPane = contentPane;
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
        
        JButton volverButton = new JButton("Volver");
        volverButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        volverButton.setBounds(847, 530, 142, 46);
        add(volverButton);
        volverButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cardLayout.show(contentPane, "Home");
            }
        });

        JTextArea textArea_1 = new JTextArea();
        textArea_1.setBounds(186, 450, 161, 34);  // Tamaño y ubicación del área de texto
        add(textArea_1);
        
     // Agregar botón "Actualizar"
        JButton actualizarButton = new JButton("Actualizar");
        actualizarButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        actualizarButton.setBounds(847, 460, 142, 46); // Ubicación en la interfaz
        add(actualizarButton);
        actualizarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadTableData(); // Llama al método que recarga la tabla desde la BD
            }
        });
        
        loadTableData();
    }
    private void loadTableData() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Libro");
        model.addColumn("ID Estantería");
        model.addColumn("Título");
        model.addColumn("Autor");
        model.addColumn("Editorial");
        model.addColumn("Año Publicación");
        model.addColumn("Categoría");
        model.addColumn("Disponible");

        Coneccion db = new Coneccion();
        Connection connection = db.getConnection();

        if (connection != null) {
            try {
                String query = "SELECT * FROM libro"; 
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    Object[] row = new Object[8];  
                    row[0] = resultSet.getInt("idLibro");
                    row[1] = resultSet.getInt("idEstanteria");
                    row[2] = resultSet.getString("titulo");
                    row[3] = resultSet.getString("autor");
                    row[4] = resultSet.getString("editorial");
                    row[5] = resultSet.getInt("anioPublicacion");
                    row[6] = resultSet.getString("categoria");
                    row[7] = resultSet.getBoolean("disponible");

                    model.addRow(row);
                }

                table.setModel(model);
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void recargarTabla() {
        loadTableData();
    }


}
