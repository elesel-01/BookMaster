package vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorLibro;
import controlador.ControladorReserva;
import modelo.Libro;
import modelo.Session;
import modelo.Usuario;

public class BusquedaNombre extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField txtBuscar;
    private JPanel contentPane;
    private CardLayout cardLayout;
    private JTable table;
    private DefaultTableModel tableModel;
    private ControladorReserva controladorReserva = new ControladorReserva();
    Usuario usuarioActual = Session.getUsuarioActual();

    public BusquedaNombre(JPanel contentPane, CardLayout cardLayout) {
        this.contentPane = contentPane;
        this.cardLayout = cardLayout;
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
        btnNewButton.setIcon(new ImageIcon(BusquedaNombre.class.getResource("/media/volver resized.png")));
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
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
		btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "Login");
                JOptionPane.showMessageDialog(null, "Has cerrado sesión correctamente.");
            }
        });

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
        lblNewLabel_11.setIcon(new ImageIcon(BusquedaNombre.class.getResource("/media/luparesized.png")));
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
        txtBuscar.setText("Buscar");
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

        JButton btnBusquedaGenero = new JButton("Buscar por género");
        btnBusquedaGenero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "BusquedaGenero");
            }
        });
        btnBusquedaGenero.setHorizontalAlignment(SwingConstants.LEFT);
        botonn.add(btnBusquedaGenero, BorderLayout.CENTER);

        JPanel btonmid = new JPanel();
        btonmid.setBackground(Color.decode("#1F4E61"));
        panelbtnes.add(btonmid, BorderLayout.CENTER);
        btonmid.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel_21 = new JLabel("                                      ");
        btonmid.add(lblNewLabel_21, BorderLayout.WEST);

        JLabel lblNewLabel_33 = new JLabel("                                      ");
        btonmid.add(lblNewLabel_33, BorderLayout.EAST);

        JButton btnNewButton_4 = new JButton("Buscar por autor");
        btonmid.add(btnNewButton_4, BorderLayout.CENTER);
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "BusquedaAutor");
            }
        });

        JLabel lblNewLabel_23 = new JLabel("     ");
        lblNewLabel_23.setFont(new Font("Tahoma", Font.PLAIN, 13));
        panelBotonesSearch.add(lblNewLabel_23, BorderLayout.SOUTH);

        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(Color.decode("#1F4E61"));
        TopPanel.add(panelTitulo, BorderLayout.WEST);
        panelTitulo.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel_7 = new JLabel("Búsqueda por nombre");
        lblNewLabel_7.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_7.setForeground(Color.WHITE);
        lblNewLabel_7.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
        panelTitulo.add(lblNewLabel_7, BorderLayout.CENTER);

        JLabel lblNewLabel = new JLabel("   ");
        panelTitulo.add(lblNewLabel, BorderLayout.NORTH);

        JLabel lblNewLabel_31 = new JLabel("  ");
        panelTitulo.add(lblNewLabel_31, BorderLayout.WEST);
        
        JButton BttnMisDatos = new JButton("");
        BttnMisDatos.setIcon(new ImageIcon(BusquedaNombre.class.getResource("/media/agregar-usuario (1).png")));
        panelTitulo.add(BttnMisDatos, BorderLayout.SOUTH);
        BttnMisDatos.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        System.out.println("Intentando cambiar a MisDatos...");
		        cardLayout.show(contentPane, "MisDatos");

		        // Imprimir el panel visible actual
		        for (Component comp : contentPane.getComponents()) {
		            if (comp.isVisible()) {
		                System.out.println("Panel visible actual: " + comp.getClass().getName());
		            }
		        }
		    }
		});

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
		btnNewButton_5.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Crear el cuadro de diálogo
		        JDialog dialogoReserva = new JDialog((JFrame) SwingUtilities.getWindowAncestor(BusquedaNombre.this), "Reservar Libro", true);
		        dialogoReserva.setSize(400, 200);
		        dialogoReserva.setLocationRelativeTo(BusquedaNombre.this);
		        dialogoReserva.getContentPane().setLayout(new BorderLayout());
		        
		        // Panel superior con etiqueta
		        JPanel panelSuperior = new JPanel();
		        panelSuperior.add(new JLabel("Ingrese la ID del libro a reservar:"));
		        dialogoReserva.getContentPane().add(panelSuperior, BorderLayout.NORTH);

		        // Panel central con campo de texto
		        JPanel panelCentral = new JPanel();
		        JTextField campoID = new JTextField(20);
		        panelCentral.add(campoID);
		        dialogoReserva.getContentPane().add(panelCentral, BorderLayout.CENTER);

		        // Panel inferior con botones
		        JPanel panelInferior = new JPanel();
		        JButton botonReservar = new JButton("Reservar");
		        JButton botonCancelar = new JButton("Cancelar");
		        panelInferior.add(botonReservar);
		        panelInferior.add(botonCancelar);
		        dialogoReserva.getContentPane().add(panelInferior, BorderLayout.SOUTH);

		        // Acción para el botón Reservar
		        botonReservar.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                String idLibro = campoID.getText().trim();
		                int IdUsario=Session.getUsuarioId();
		                if (!idLibro.isEmpty()) {
		                	controladorReserva.solicitarLibro(Integer.parseInt(idLibro),IdUsario);
		                    JOptionPane.showMessageDialog(dialogoReserva, "Reserva realizada para el libro con ID: " + idLibro);
		                    
		                    dialogoReserva.dispose();
		                } else {
		                    JOptionPane.showMessageDialog(dialogoReserva, "Por favor, ingrese una ID válida.", "Error", JOptionPane.ERROR_MESSAGE);
		                }
		            }
		        });

		        // Acción para el botón Cancelar
		        botonCancelar.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                dialogoReserva.dispose();
		            }
		        });

		        // Mostrar el cuadro de diálogo
		        dialogoReserva.setVisible(true);
		    }
		});
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

        // Inicializar JTable y su modelo
        tableModel = new DefaultTableModel(new Object[]{"ID","Nombre", "Autor", "Categoría", "Disponibilidad", "Estantería"}, 0);
        table = new JTable(tableModel);
        scrollBusqueda.setViewportView(table);

        ControladorLibro controladorLibro = new ControladorLibro();

        txtBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombreLibro = txtBuscar.getText();
                if (!nombreLibro.trim().isEmpty()) {
                    List<Libro> libros = controladorLibro.buscarLibroPorNombre(nombreLibro);
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
    }

    // Método para mostrar los resultados en el JTable
    private void mostrarResultados(List<Libro> libros) {
        tableModel.setRowCount(0); // Limpiar la tabla
        for (Libro libro : libros) {
            tableModel.addRow(new Object[]{
            		libro.getIdLibro(),
            		libro.getTitulo(),
            		libro.getAutor(),
            		libro.getCategoria(),
            		libro.isDisponible(),
            		libro.getIdEstanteria()});
        }
    }
}

