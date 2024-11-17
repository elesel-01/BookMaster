package vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorLibro;
import modelo.Libro;

public class BusquedaGenero extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField txtBuscar;
	private JPanel contentPane;  // Sin inicializar aquí
    private CardLayout cardLayout;
    private JTable table;
    private DefaultTableModel tableModel;
	/**
	 * Create the panel.
	 */
	public BusquedaGenero(JPanel contentPane, CardLayout cardLayout) {
		this.contentPane = contentPane;  // Asigna contentPane que viene del contenedor principal
        this.cardLayout = cardLayout;    // Asigna cardLayout que viene del contenedor principal
		setBounds(0, 0, 1040, 640);
		setLayout(new BorderLayout(0, 0));
		
		JPanel TopPanel = new JPanel();
		TopPanel.setBackground(Color.decode("#1F4E61"));
		add(TopPanel, BorderLayout.NORTH);
		TopPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSalir = new JPanel();
		panelSalir.setBackground(Color.decode("#1F4E61"));
		TopPanel.add(panelSalir, BorderLayout.EAST);
		panelSalir.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("   ");
		panelSalir.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_2 = new JLabel("   ");
		panelSalir.add(lblNewLabel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(BusquedaGenero.class.getResource("/media/volver resized.png")));
		panelSalir.add(btnNewButton, BorderLayout.WEST);
		
		JLabel lblNewLabel_3 = new JLabel("   ");
		panelSalir.add(lblNewLabel_3, BorderLayout.EAST);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(Color.decode("#1F4E61"));
		panelSalir.add(panelLogin, BorderLayout.SOUTH);
		panelLogin.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("   ");
		panelLogin.add(lblNewLabel_4, BorderLayout.NORTH);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBackground(Color.decode("#1F4E61"));
		panelLogin.add(panelBotones, BorderLayout.SOUTH);
		panelBotones.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("   ");
		panelBotones.add(lblNewLabel_5, BorderLayout.WEST);
		
		JLabel lblNewLabel_24 = new JLabel("       ");
		panelBotones.add(lblNewLabel_24, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_25 = new JLabel("       ");
		panelBotones.add(lblNewLabel_25, BorderLayout.NORTH);
		
		JLabel lblNewLabel_26 = new JLabel("       ");
		panelBotones.add(lblNewLabel_26, BorderLayout.EAST);
		
		JPanel actualbutns = new JPanel();
		actualbutns.setBackground(Color.decode("#1F4E61"));
		panelBotones.add(actualbutns, BorderLayout.CENTER);
		actualbutns.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_1 = new JButton("Cerrar Sesión");
		actualbutns.add(btnNewButton_1, BorderLayout.NORTH);
		
		JPanel panelSearch = new JPanel();
		panelSearch.setBackground(Color.decode("#1F4E61"));
		TopPanel.add(panelSearch, BorderLayout.CENTER);
		panelSearch.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("                     ");
		panelSearch.add(lblNewLabel_6, BorderLayout.NORTH);
		
		JLabel lblNewLabel_8 = new JLabel("                  ");
		panelSearch.add(lblNewLabel_8, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_9 = new JLabel("         ");
		panelSearch.add(lblNewLabel_9, BorderLayout.WEST);
		
		JPanel panelSearchSuperior = new JPanel();
		panelSearchSuperior.setBackground(Color.decode("#1F4E61"));
		panelSearch.add(panelSearchSuperior, BorderLayout.CENTER);
		panelSearchSuperior.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_10 = new JLabel("         ");
		panelSearchSuperior.add(lblNewLabel_10, BorderLayout.EAST);
		
		JPanel pnlSearchContent = new JPanel();
		pnlSearchContent.setBackground(Color.decode("#1F4E61"));
		panelSearchSuperior.add(pnlSearchContent, BorderLayout.CENTER);
		pnlSearchContent.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(BusquedaGenero.class.getResource("/media/luparesized.png")));
		pnlSearchContent.add(lblNewLabel_11, BorderLayout.WEST);
		
		JPanel panelBusqueda = new JPanel();
		panelBusqueda.setBackground(Color.decode("#1F4E61"));
		pnlSearchContent.add(panelBusqueda, BorderLayout.CENTER);
		panelBusqueda.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_12 = new JLabel("Bienvenido , ¿Qué deseas leer hoy?       \r\n ");
		lblNewLabel_12.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		lblNewLabel_12.setForeground(Color.WHITE);
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		panelBusqueda.add(lblNewLabel_12, BorderLayout.NORTH);
		
		JLabel lblNewLabel_13 = new JLabel("           ");
		panelBusqueda.add(lblNewLabel_13, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_14 = new JLabel("     ");
		panelBusqueda.add(lblNewLabel_14, BorderLayout.WEST);
		
		JLabel lblNewLabel_15 = new JLabel("       ");
		panelBusqueda.add(lblNewLabel_15, BorderLayout.EAST);
		
		txtBuscar = new JTextField();
		txtBuscar.setText("¿Qué género estas buscando?");
		panelBusqueda.add(txtBuscar, BorderLayout.CENTER);
		txtBuscar.setColumns(10);
		
		JPanel panelBotonesSearch = new JPanel();
		panelBotonesSearch.setBackground(Color.decode("#1F4E61"));
		panelSearch.add(panelBotonesSearch, BorderLayout.SOUTH);
		panelBotonesSearch.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_20 = new JLabel("      ");
		panelBotonesSearch.add(lblNewLabel_20, BorderLayout.NORTH);
		
		JPanel panelbtnes = new JPanel();
		panelbtnes.setBackground(Color.decode("#1F4E61"));
		panelBotonesSearch.add(panelbtnes, BorderLayout.CENTER);
		panelbtnes.setLayout(new BorderLayout(0, 0));
		
		JPanel botonn = new JPanel();
		botonn.setBackground(Color.decode("#1F4E61"));
		panelbtnes.add(botonn, BorderLayout.WEST);
		botonn.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_22 = new JLabel("                  ");
		botonn.add(lblNewLabel_22, BorderLayout.WEST);
		
		JButton btnBusquedaNombre = new JButton("Buscar por Nombre");
		btnBusquedaNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "BusquedaNombre");
            }
		});
		btnBusquedaNombre.setHorizontalAlignment(SwingConstants.LEFT);
		botonn.add(btnBusquedaNombre, BorderLayout.CENTER);
		
		JPanel btn2 = new JPanel();
		btn2.setBackground(Color.decode("#1F4E61"));
		panelbtnes.add(btn2, BorderLayout.EAST);
		btn2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_34 = new JLabel("                  ");
		btn2.add(lblNewLabel_34, BorderLayout.EAST);
		
		JButton btnNewButton_2 = new JButton("Gestionar Libros");
		btn2.add(btnNewButton_2, BorderLayout.CENTER);
		
		JPanel btonmid = new JPanel();
		btonmid.setBackground(Color.decode("#1F4E61"));
		panelbtnes.add(btonmid, BorderLayout.CENTER);
		btonmid.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_21 = new JLabel("                                      ");
		btonmid.add(lblNewLabel_21, BorderLayout.WEST);
		
		JLabel lblNewLabel_33 = new JLabel("                                      ");
		btonmid.add(lblNewLabel_33, BorderLayout.EAST);
		
		JButton btnNewButton_4 = new JButton("Buscar por nombre");
		btonmid.add(btnNewButton_4, BorderLayout.CENTER);
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "BusquedaNombre");
            }
        });
		
		JLabel lblNewLabel_23 = new JLabel("     ");
		lblNewLabel_23.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelBotonesSearch.add(lblNewLabel_23, BorderLayout.SOUTH);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(Color.decode("#1F4E61"));
		TopPanel.add(panelTitulo, BorderLayout.WEST);
		panelTitulo.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_7 = new JLabel("Búsqueda por categoría");
		lblNewLabel_7.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		panelTitulo.add(lblNewLabel_7, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("   ");
		panelTitulo.add(lblNewLabel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_31 = new JLabel("  ");
		panelTitulo.add(lblNewLabel_31, BorderLayout.WEST);
		
		JLabel lblNewLabel_32 = new JLabel("");
		lblNewLabel_32.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_32.setIcon(new ImageIcon(BusquedaGenero.class.getResource("/media/agregar-usuario (1).png")));
		panelTitulo.add(lblNewLabel_32, BorderLayout.SOUTH);
		
		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(Color.decode("#D6D6D6"));
		add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_16 = new JLabel("          ");
		panelCentral.add(lblNewLabel_16, BorderLayout.NORTH);
		
		JLabel lblNewLabel_17 = new JLabel("            ");
		panelCentral.add(lblNewLabel_17, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_18 = new JLabel("                ");
		panelCentral.add(lblNewLabel_18, BorderLayout.WEST);
		
		JLabel lblNewLabel_19 = new JLabel("                ");
		panelCentral.add(lblNewLabel_19, BorderLayout.EAST);
		
		JPanel pnIncentral = new JPanel();
		pnIncentral.setBackground(Color.decode("#D6D6D6"));
		panelCentral.add(pnIncentral, BorderLayout.CENTER);
		pnIncentral.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_27 = new JLabel("          ");
		pnIncentral.add(lblNewLabel_27, BorderLayout.SOUTH);
		
		JPanel panelBotn = new JPanel();
		panelBotn.setBackground(Color.decode("#D6D6D6"));
		pnIncentral.add(panelBotn, BorderLayout.NORTH);
		panelBotn.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_28 = new JLabel("                                                                                                                                                                                                                            ");
		panelBotn.add(lblNewLabel_28, BorderLayout.EAST);
		
		JButton btnNewButton_5 = new JButton("Solicitar");
		btnNewButton_5.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		panelBotn.add(btnNewButton_5, BorderLayout.WEST);
		
		JPanel panelSeparador = new JPanel();
		panelSeparador.setBackground(Color.decode("#D6D6D6"));
		panelBotn.add(panelSeparador, BorderLayout.SOUTH);
		panelSeparador.setLayout(new BorderLayout(0, 0));
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		panelSeparador.add(separator, BorderLayout.NORTH);
		
		JLabel lblNewLabel_29 = new JLabel("      ");
		panelSeparador.add(lblNewLabel_29, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#D6D6D6"));
		pnIncentral.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_30 = new JLabel("          ");
		panel.add(lblNewLabel_30, BorderLayout.NORTH);
		
		JScrollPane scrollBusqueda = new JScrollPane();
		scrollBusqueda.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollBusqueda, BorderLayout.CENTER);
		
		JPanel Gridpanel = new JPanel();
		scrollBusqueda.setViewportView(Gridpanel);
		Gridpanel.setLayout(new GridLayout(0, 3, 10, 10));
		
		tableModel = new DefaultTableModel(new Object [] {"Categoría","Nombre", "Autor",  "Disponibilidad", "Estantería"}, 0);
		table = new JTable(tableModel);
        scrollBusqueda.setViewportView(table);
		
        ControladorLibro controladorLibro = new ControladorLibro();
        txtBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombreLibro = txtBuscar.getText();
                if (!nombreLibro.trim().isEmpty()) {
                    List<Libro> libros = controladorLibro.buscarLibroPorCategoria(nombreLibro);
                    if (libros.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No se encontraron libros con ese nombre.");
                    } else {
                        mostrarResultados(libros);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un nombre de libro.");
                }
            }
        });
        // Configurar el botón para navegar a BusquedaGenero
        JButton btnBusquedaAutor = new JButton("Buscar por autor");
        btnBusquedaAutor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "BusquedaAutor");
            }
        });
        btonmid.add(btnBusquedaAutor, BorderLayout.CENTER);

	}
	private void mostrarResultados(List<Libro> libros) {
        tableModel.setRowCount(0); // Limpiar la tabla
        for (Libro libro : libros) {
            tableModel.addRow(new Object[]{
            		libro.getCategoria(),
            		libro.getTitulo(),
            		libro.getAutor(),
            		libro.isDisponible(),
            		libro.getIdEstanteria()});
        }
    }
      
    
	


}
