package ui;

import java.awt.Color;
import java.awt.Font;
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
	private int index = 0;
	private boolean first = true;
	private String separador = "";
	private JButton btnMyFavs;

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
		frmNetflix.getContentPane().setBackground(new Color(153, 204, 204));
		frmNetflix.setBounds(100, 100, 860, 570);
		frmNetflix.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNetflix.getContentPane().setLayout(null);

		lblTittle = new JLabel("");
		lblTittle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTittle.setBounds(55, 0, 711, 71);
		lblTittle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmNetflix.getContentPane().add(lblTittle);

		lblType = new JLabel("");
		lblType.setBounds(692, 234, 127, 71);
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmNetflix.getContentPane().add(lblType);

		lblDirector = new JLabel("");
		lblDirector.setBounds(45, 141, 774, 55);
		lblDirector.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmNetflix.getContentPane().add(lblDirector);

		lblCountry = new JLabel("");
		lblCountry.setBounds(46, 82, 626, 55);
		lblCountry.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmNetflix.getContentPane().add(lblCountry);

		lblDateAdd = new JLabel("");
		lblDateAdd.setBounds(546, 196, 156, 35);
		lblDateAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmNetflix.getContentPane().add(lblDateAdd);

		lblYear = new JLabel("");
		lblYear.setBounds(692, 82, 127, 41);
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmNetflix.getContentPane().add(lblYear);

		lblRating = new JLabel("");
		lblRating.setBounds(546, 247, 136, 44);
		lblRating.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmNetflix.getContentPane().add(lblRating);

		lblDuration = new JLabel("");
		lblDuration.setBounds(224, 94, 156, 41);
		lblDuration.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmNetflix.getContentPane().add(lblDuration);

		lblListed = new JLabel("Listed");
		lblListed.setForeground(Color.BLACK);
		lblListed.setBounds(197, 196, 76, 35);
		lblListed.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmNetflix.getContentPane().add(lblListed);

		lblDescription = new JLabel("Description");
		lblDescription.setForeground(Color.BLACK);
		lblDescription.setBounds(569, 302, 103, 55);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmNetflix.getContentPane().add(lblDescription);

		btnBack = new JButton("Back");
		btnBack.setBackground(new Color(255, 255, 255));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(35, 476, 301, 44);
		frmNetflix.getContentPane().add(btnBack);

		btnNext = new JButton("Next");
		btnNext.setBackground(new Color(255, 255, 255));
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNext.setBounds(524, 476, 301, 44);
		frmNetflix.getContentPane().add(btnNext);

		txtCast = new JTextPane();
		txtCast.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCast.setEditable(false);
		txtCast.setBounds(43, 352, 375, 99);
		frmNetflix.getContentPane().add(txtCast);

		txtDescription = new JTextPane();
		txtDescription.setBackground(Color.WHITE);
		txtDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDescription.setBounds(439, 352, 375, 99);
		frmNetflix.getContentPane().add(txtDescription);

		lblCast = new JLabel("Cast");
		lblCast.setForeground(Color.BLACK);
		lblCast.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCast.setBounds(197, 312, 46, 35);
		frmNetflix.getContentPane().add(lblCast);

		txtListed = new JTextPane();
		txtListed.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtListed.setEditable(false);
		txtListed.setBounds(43, 241, 382, 71);
		frmNetflix.getContentPane().add(txtListed);

		btnFavorito = new JButton("FAV");
		btnFavorito.setBackground(new Color(255, 255, 102));
		btnFavorito.setForeground(Color.DARK_GRAY);
		btnFavorito.setBounds(35, 10, 61, 55);
		frmNetflix.getContentPane().add(btnFavorito);

		btnBuscador = new JButton("Buscador");
		btnBuscador.setBackground(new Color(153, 255, 153));
		btnBuscador.setForeground(new Color(0, 0, 0));
		btnBuscador.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBuscador.setBounds(728, 9, 91, 55);
		frmNetflix.getContentPane().add(btnBuscador);

		btnMyFavs = new JButton("Mis favoritos");
		btnMyFavs.setBackground(new Color(51, 153, 255));
		btnMyFavs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMyFavs.setBounds(367, 476, 127, 44);
		frmNetflix.getContentPane().add(btnMyFavs);

		verShows(index);
	}

	private void configureListeners() {
		btnBuscador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String buscar = "";

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

				int resp = JOptionPane.showConfirmDialog(frmNetflix, "¿Quieres cargar un fichero existente?");
				if (JOptionPane.OK_OPTION == resp) {
					try {
						new FavsView(frmNetflix, separador);
						frmNetflix.setVisible(false);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(frmNetflix, "No hay ningún show registrado, añade alguno");
					}
				} else {
					System.out.println("No selecciona una opción afirmativa");
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
		btnFavorito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (first) {
					int seleccion = JOptionPane.showOptionDialog(frmNetflix,
							"¿Cúal separador quieres que se use en el documento?", "Selector de opciones",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, // null para icono por
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

				// Cada vez que se pulsa el boton escribe el id del show en un
				// documento
				DocumentWrite.write(shows.get(index).getId(), separador, true, false);
				first = false;
			}
		});
	}

	private void back() {
		index--;
		if (index < 0) { // Cuando el index es la primera posicion del array list
			index = shows.size() - 1;
		}
		verShows(index);
	}

	private void next() {
		index++;
		if (index == shows.size()) { // Cuando el index es la ultima posicion del array list
			index = 0;
		}
		verShows(index);
	}

	private void verShows(int index) {

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

	}
}
