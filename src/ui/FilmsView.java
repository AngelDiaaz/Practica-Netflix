package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import dao.ShowDAO;
import models.Show;
import utils.DocumentWrite;

public class FilmsView {

	private JFrame frmNetflix;
	private JLabel lblTittle;
	private JLabel lblType;
	private JLabel lblDirector;
	private JLabel lblCountry;
	private JLabel lblDateAdd;
	private JLabel lblYear;
	private JLabel lblRating;
	private JLabel lblDuration;
	private JLabel lblListed;
	private JLabel lblDescription;
	private JButton btnBack;
	private JButton btnNext;
	private JButton btnBuscador;
	private JTextPane txtListed;
	private JLabel lblCast;
	private ShowDAO showDAO;
	private ArrayList<Show> shows;
	private JTextPane txtCast;
	private JTextPane txtDescription;
	private JButton btnFavorito;
	private JButton btnMyFavs;
	private JButton btnX;
	private int index = 0;
	private boolean first = true;
	private boolean questionFile = false;
	private boolean sobrescribir = true;
	private String separador = ","; // Pongo la coma por defecto, por si quiero cargar un fichero existente, que use
									// ese separador

	/**
	 * Create the application.
	 */
	public FilmsView() {
		this.showDAO = new ShowDAO();
		this.shows = showDAO.getAll();
		initialize();
		this.frmNetflix.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		configureComponents();
		configureListeners();
	}

	private void configureComponents() {
		frmNetflix = new JFrame();
		frmNetflix.setTitle("Netflix");
		frmNetflix.getContentPane().setBackground(Color.DARK_GRAY);
		frmNetflix.setBounds(100, 100, 860, 570);
		frmNetflix.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNetflix.getContentPane().setLayout(null);
		frmNetflix.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\adiaz\\OneDrive\\Escritorio\\Programaci\u00F3n\\Workspace\\PracticaNetflix\\assets\\icon netflix.png"));


		lblTittle = new JLabel("");
		lblTittle.setForeground(new Color(255, 255, 255));
		lblTittle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTittle.setBounds(55, 0, 711, 71);
		lblTittle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmNetflix.getContentPane().add(lblTittle);

		lblType = new JLabel("");
		lblType.setForeground(new Color(255, 255, 255));
		lblType.setBounds(692, 234, 127, 71);
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmNetflix.getContentPane().add(lblType);

		lblDirector = new JLabel("");
		lblDirector.setForeground(new Color(255, 255, 255));
		lblDirector.setBounds(45, 141, 774, 55);
		lblDirector.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmNetflix.getContentPane().add(lblDirector);

		lblCountry = new JLabel("");
		lblCountry.setForeground(new Color(255, 255, 255));
		lblCountry.setBounds(46, 82, 474, 55);
		lblCountry.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmNetflix.getContentPane().add(lblCountry);

		lblDateAdd = new JLabel("");
		lblDateAdd.setForeground(new Color(255, 255, 255));
		lblDateAdd.setBounds(546, 196, 156, 35);
		lblDateAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmNetflix.getContentPane().add(lblDateAdd);

		lblYear = new JLabel("");
		lblYear.setForeground(new Color(255, 255, 255));
		lblYear.setBounds(546, 89, 127, 41);
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmNetflix.getContentPane().add(lblYear);

		lblRating = new JLabel("");
		lblRating.setForeground(new Color(255, 255, 255));
		lblRating.setBounds(546, 247, 136, 44);
		lblRating.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmNetflix.getContentPane().add(lblRating);

		lblDuration = new JLabel("");
		lblDuration.setBounds(224, 94, 156, 41);
		lblDuration.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmNetflix.getContentPane().add(lblDuration);

		lblListed = new JLabel("Listed");
		lblListed.setForeground(new Color(255, 255, 255));
		lblListed.setBounds(197, 196, 76, 35);
		lblListed.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmNetflix.getContentPane().add(lblListed);

		lblDescription = new JLabel("Description");
		lblDescription.setForeground(new Color(255, 255, 255));
		lblDescription.setBounds(569, 302, 103, 55);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmNetflix.getContentPane().add(lblDescription);

		btnBack = new JButton("Back");
		btnBack.setBackground(new Color(153, 255, 204));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(35, 476, 301, 44);
		frmNetflix.getContentPane().add(btnBack);

		btnNext = new JButton("Next");
		btnNext.setBackground(new Color(153, 255, 204));
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNext.setBounds(524, 476, 301, 44);
		frmNetflix.getContentPane().add(btnNext);

		txtCast = new JTextPane();
		txtCast.setForeground(Color.WHITE);
		txtCast.setBackground(Color.DARK_GRAY);
		txtCast.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCast.setEditable(false);
		txtCast.setBounds(43, 352, 375, 99);
		frmNetflix.getContentPane().add(txtCast);

		txtDescription = new JTextPane();
		txtDescription.setForeground(Color.WHITE);
		txtDescription.setBackground(Color.DARK_GRAY);
		txtDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDescription.setBounds(439, 352, 375, 99);
		frmNetflix.getContentPane().add(txtDescription);

		lblCast = new JLabel("Cast");
		lblCast.setForeground(new Color(255, 255, 255));
		lblCast.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCast.setBounds(197, 312, 46, 35);
		frmNetflix.getContentPane().add(lblCast);

		txtListed = new JTextPane();
		txtListed.setForeground(Color.WHITE);
		txtListed.setBackground(Color.DARK_GRAY);
		txtListed.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtListed.setEditable(false);
		txtListed.setBounds(43, 241, 382, 71);
		frmNetflix.getContentPane().add(txtListed);

		btnFavorito = new JButton("FAV");
		btnFavorito.setBackground(Color.WHITE);
		btnFavorito.setForeground(Color.DARK_GRAY);
		btnFavorito.setBounds(35, 10, 61, 55);
		frmNetflix.getContentPane().add(btnFavorito);

		btnBuscador = new JButton("Buscador");
		btnBuscador.setBackground(new Color(153, 255, 153));
		btnBuscador.setForeground(new Color(0, 0, 0));
		btnBuscador.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBuscador.setBounds(728, 82, 91, 55);
		frmNetflix.getContentPane().add(btnBuscador);

		btnMyFavs = new JButton("Mis favoritos");
		btnMyFavs.setBackground(new Color(51, 153, 255));
		btnMyFavs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMyFavs.setBounds(367, 476, 127, 44);
		frmNetflix.getContentPane().add(btnMyFavs);
		
		btnX = new JButton("X");
		btnX.setForeground(Color.WHITE);
		btnX.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnX.setBackground(new Color(255, 0, 51));
		btnX.setBounds(758, 10, 61, 55);
		frmNetflix.getContentPane().add(btnX);

		showShows(index);
	}

	private void configureListeners() {
		btnBuscador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String buscar = "";

				// Te pregunta por cual campo quieres buscar el show
				int select = JOptionPane.showOptionDialog(frmNetflix, "¿Por cúal campo quieres buscar los shows?",
						"Selector de opciones", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
						new Object[] { "Nombre", "País", "Director", "Año" }, "");
				if (select == 0) {
					buscar = "tittle";
				} else if (select == 1) {
					buscar = "country";
				} else if (select == 2) {
					buscar = "director";
				} else if (select == 3) {
					buscar = "release_year";
				}

				// Si se selecciona algun campo del selector
				if (select >= 0 && select <= 3) {
					String busqueda = JOptionPane.showInputDialog(frmNetflix, "Buscador de shows");
					try {
						new SearchView(frmNetflix, buscar, busqueda, first, separador);
						frmNetflix.setVisible(false);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(frmNetflix, "No se ha encontrado nada, vuelve a intentarlo");
					}
				}
			}
		});
		btnMyFavs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				questionFile();

				try {
					new FavsView(frmNetflix, separador);
					frmNetflix.setVisible(false);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(frmNetflix, "No hay ningún show registrado, añade alguno");
				}
			}
		});
		btnBack.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) { // Al pulsar la tecla enter, te haga retroceda la lista para
															// atras
					back();
				}
			}
		});
		btnNext.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) { // Al pulsar la tecla enter, te haga avanzar la lista
					next();
				}
			}
		});
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				next();
			}
		});
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNetflix.dispose();
				new LoginView();
			}
		});
		btnFavorito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				questionFile();

				if (first) {
					// Si no se ha preguntado cual tipo de separador queremos que use para almacenar
					// la id en el fichero
					int seleccion = JOptionPane.showOptionDialog(frmNetflix,
							"¿Cúal separador quieres que se use en el documento?", "Selector de opciones",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, // null para icono
																									// por
																									// defecto.
							new Object[] { "Coma", "Punto y coma", "Tabulador" }, "");
					if (seleccion == 0) {
						separador = ",";
					} else if (seleccion == 1) {
						separador = ";";
					} else {
						separador = "\t";
					}
				}
				//Para que se ponga el boton en amarrillo al darle
				btnFavorito.setBackground(new Color(255, 255, 102));
				
				
				// Cada vez que se pulsa el boton escribe el id del show en un
				// documento
				DocumentWrite.write(shows.get(index).getId(), separador, sobrescribir, false);
				first = false;
				sobrescribir = true;
			}
		});
	}

	/**
	 * Metodo que pregunta si quieres cargar el fichero o eliminarlo
	 */

	private void questionFile() {
		// Si no se ha preguntado si se quiere crear o cargar el fichero con los shows
		// favoritos
		if (!questionFile) {
			int resp = JOptionPane.showConfirmDialog(frmNetflix,
					"¿Quieres cargar un fichero existente con los shows favoritos?\n(Sino se creará uno nuevo)");
			if (JOptionPane.OK_OPTION != resp) {
				// Al generar un nuevo archivo se sobrescribira todo, eliminando lo que habia
				// anteriormente
				DocumentWrite.write("", "", false, false);
				sobrescribir = false;
				showShows(index);
			} else {
				// Si seleccionamos cargar un fichero no te preguntara por los separadores
				first = false;
			}
			questionFile = true;
		}
	}

	/**
	 * Recorre el array a la posicion anterior
	 */

	private void back() {
		index--;
		if (index < 0) { // Cuando el index es la primera posicion del array list
			index = shows.size() - 1;
		}
		showShows(index);
	}

	/**
	 * Recorre el array a la posicion siguiente
	 */

	private void next() {
		index++;
		if (index == shows.size()) { // Cuando el index es la ultima posicion del array list
			index = 0;
		}
		showShows(index);
	}

	/**
	 * Metodo que muestra las caracteristicas de cada show en la interfaz grafica
	 * 
	 * @param index Posicion del show en el array que queremos mostrar
	 */

	private void showShows(int index) {

		lblTittle.setText(shows.get(index).getTitle());
		lblType.setText(shows.get(index).getType());
		lblDirector.setText(shows.get(index).getDirector());
		lblCountry.setText(shows.get(index).getCountry());
		lblDateAdd.setText(shows.get(index).getDate());
		lblYear.setText(shows.get(index).getYear());
		lblRating.setText(shows.get(index).getRating());
		txtCast.setText(shows.get(index).getCast());
		txtDescription.setText(shows.get(index).getDescription());
		txtListed.setText(shows.get(index).getListed());

		comprobarFav(shows.get(index));
	}
	
	/**
	 * Comprueba si el show esta en favorito o no, si lo esta el boton de fav se pondra amarrillo, sino se dejara en blanco
	 *
	 * @param show Show que queremos comprobar si esta en favorito
	 */
	
	private void comprobarFav(Show show) {
		if(DocumentWrite.comprobarFavoritos(show.getId())) {
			btnFavorito.setBackground(Color.WHITE);
		} else {
			btnFavorito.setBackground(new Color(255, 255, 102));
		}
	}
}
