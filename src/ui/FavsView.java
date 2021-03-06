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

import models.Show;
import utils.DocumentWrite;

public class FavsView {

	private JFrame frmNetflixBsqueda;
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
	private JTextPane txtListed;
	private JLabel lblCast;
	private ArrayList<Show> shows;
	private JTextPane txtCast;
	private JTextPane txtDescription;
	private JButton btnDelete;
	private JFrame parent;
	private String file;
	private int index = 0;
	private String separador;
	private JButton btnX;

	/**
	 * Create the application.
	 */
	public FavsView(JFrame parent, String separador, String file) {
		this.parent = parent;
		this.separador = separador;
		this.file = file;
		this.shows = DocumentWrite.readFavs();
		initialize();
		this.frmNetflixBsqueda.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		configureComponents();
		configureListeners();
	}

	private void configureComponents() {
		frmNetflixBsqueda = new JFrame();
		frmNetflixBsqueda.setTitle("Netflix: B\u00FAsqueda");
		frmNetflixBsqueda.getContentPane().setBackground(new Color(0, 0, 0));
		frmNetflixBsqueda.setBounds(100, 100, 860, 580);
		frmNetflixBsqueda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNetflixBsqueda.getContentPane().setLayout(null);
		frmNetflixBsqueda.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\adiaz\\OneDrive\\Escritorio\\Programaci\u00F3n\\Workspace\\PracticaNetflix\\assets\\icon netflix.png"));

		lblTittle = new JLabel("");
		lblTittle.setForeground(Color.WHITE);
		lblTittle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTittle.setBounds(86, 0, 711, 71);
		lblTittle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmNetflixBsqueda.getContentPane().add(lblTittle);

		lblType = new JLabel("");
		lblType.setForeground(Color.WHITE);
		lblType.setBounds(692, 234, 127, 71);
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmNetflixBsqueda.getContentPane().add(lblType);

		lblDirector = new JLabel("");
		lblDirector.setForeground(Color.WHITE);
		lblDirector.setBounds(45, 141, 774, 55);
		lblDirector.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmNetflixBsqueda.getContentPane().add(lblDirector);

		lblCountry = new JLabel("");
		lblCountry.setForeground(Color.WHITE);
		lblCountry.setBounds(45, 80, 626, 55);
		lblCountry.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmNetflixBsqueda.getContentPane().add(lblCountry);

		lblDateAdd = new JLabel("");
		lblDateAdd.setForeground(Color.WHITE);
		lblDateAdd.setBounds(546, 196, 156, 35);
		lblDateAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmNetflixBsqueda.getContentPane().add(lblDateAdd);

		lblYear = new JLabel("");
		lblYear.setForeground(Color.WHITE);
		lblYear.setBounds(692, 82, 127, 41);
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmNetflixBsqueda.getContentPane().add(lblYear);

		lblRating = new JLabel("");
		lblRating.setForeground(Color.WHITE);
		lblRating.setBounds(546, 247, 136, 44);
		lblRating.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmNetflixBsqueda.getContentPane().add(lblRating);

		lblDuration = new JLabel("");
		lblDuration.setBounds(224, 94, 156, 41);
		lblDuration.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmNetflixBsqueda.getContentPane().add(lblDuration);

		lblListed = new JLabel("Listed");
		lblListed.setForeground(Color.WHITE);
		lblListed.setBounds(197, 196, 76, 35);
		lblListed.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmNetflixBsqueda.getContentPane().add(lblListed);

		lblDescription = new JLabel("Description");
		lblDescription.setForeground(Color.WHITE);
		lblDescription.setBounds(569, 302, 103, 55);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmNetflixBsqueda.getContentPane().add(lblDescription);

		btnBack = new JButton("Back");
		btnBack.setBackground(new Color(51, 204, 204));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(35, 476, 390, 44);
		frmNetflixBsqueda.getContentPane().add(btnBack);

		btnNext = new JButton("Next");
		btnNext.setForeground(new Color(0, 0, 0));
		btnNext.setBackground(new Color(51, 204, 204));
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNext.setBounds(435, 476, 390, 44);
		frmNetflixBsqueda.getContentPane().add(btnNext);

		txtCast = new JTextPane();
		txtCast.setBackground(new Color(0, 0, 0));
		txtCast.setForeground(Color.WHITE);
		txtCast.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCast.setEditable(false);
		txtCast.setBounds(43, 352, 375, 99);
		frmNetflixBsqueda.getContentPane().add(txtCast);

		txtDescription = new JTextPane();
		txtDescription.setForeground(Color.WHITE);
		txtDescription.setBackground(new Color(0, 0, 0));
		txtDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDescription.setBounds(439, 352, 375, 99);
		frmNetflixBsqueda.getContentPane().add(txtDescription);

		lblCast = new JLabel("Cast");
		lblCast.setForeground(Color.WHITE);
		lblCast.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCast.setBounds(197, 312, 46, 35);
		frmNetflixBsqueda.getContentPane().add(lblCast);

		txtListed = new JTextPane();
		txtListed.setBackground(new Color(0, 0, 0));
		txtListed.setForeground(Color.WHITE);
		txtListed.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtListed.setEditable(false);
		txtListed.setBounds(43, 241, 375, 71);
		frmNetflixBsqueda.getContentPane().add(txtListed);

		btnDelete = new JButton("QUITAR");
		btnDelete.setBackground(new Color(255, 255, 102));
		btnDelete.setForeground(Color.DARK_GRAY);
		btnDelete.setBounds(35, 10, 83, 55);
		frmNetflixBsqueda.getContentPane().add(btnDelete);

		btnX = new JButton("X");
		btnX.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnX.setForeground(new Color(255, 255, 255));
		btnX.setBackground(new Color(255, 0, 51));
		btnX.setBounds(758, 10, 61, 55);
		frmNetflixBsqueda.getContentPane().add(btnX);

		showShows(index);
	}

	private void configureListeners() {
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNetflixBsqueda.dispose();
				parent.setVisible(true);
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
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DocumentWrite.eliminarFavoritos(file, shows.get(index).getId(), separador);

				// Si se quiere borrar el ultimo show de la lista de favoritos, te lanza un
				// mensaje informativo y te vuelve a enviar a la vista de los shows principal
				if (shows.size() == 1) {
					JOptionPane.showMessageDialog(frmNetflixBsqueda,
							"Se ha borrado todos los favoritos de la lista, a?ade m?s");
					DocumentWrite.write(file, "", "", false, false);
					frmNetflixBsqueda.dispose();
					parent.setVisible(true);
				} else {
					shows = DocumentWrite.readFavs();
					// Si el show es el ultimo de la lista, muestra el show anterior y no el
					// siguiente
					if (shows.size() == index) {
						back();
					} else {
						next();
					}
				}
			}
		});
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

		// Para cuando solo haya un elemento en favoritos no se muestren los botones de
		// avanzar y retroceder
		if (shows.size() == 1) {
			btnBack.setVisible(false);
			btnNext.setVisible(false);
		}
	}

}
