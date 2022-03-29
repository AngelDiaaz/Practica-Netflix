package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import dao.ShowDAO;
import models.Show;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FilmsView {

	private JFrame frame;
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
	private ShowDAO showDAO;
	private ArrayList<Show> shows;
	private ArrayList<String> favs;
	private JTextPane txtCast;
	private JTextPane txtDescription;
	private JButton btnFavorito;
	private int index = 0;
	

	/**
	 * Create the application.
	 */
	public FilmsView() {
		this.showDAO = new ShowDAO();
		this.shows = showDAO.getAll();
		this.favs = new ArrayList<String>();
		initialize();
		this.frame.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		configureComponents();
		configureListeners();
	}

	private void configureComponents() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(153, 204, 204));
		frame.setBounds(100, 100, 860, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblTittle = new JLabel("");
		lblTittle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTittle.setBounds(23, 0, 798, 71);
		lblTittle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblTittle);
		
		lblType = new JLabel("");
		lblType.setBounds(546, 125, 171, 71);
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblType);
		
		lblDirector = new JLabel("");
		lblDirector.setBounds(35, 141, 481, 55);
		lblDirector.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblDirector);
		
		lblCountry = new JLabel("");
		lblCountry.setBounds(45, 80, 626, 55);
		lblCountry.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblCountry);
		
		lblDateAdd = new JLabel("");
		lblDateAdd.setBounds(546, 196, 156, 35);
		lblDateAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblDateAdd);
		
		lblYear = new JLabel("");
		lblYear.setBounds(692, 82, 127, 41);
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblYear);
		
		lblRating = new JLabel("");
		lblRating.setBounds(546, 247, 175, 44);
		lblRating.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblRating);
		
		lblDuration = new JLabel("");
		lblDuration.setBounds(224, 94, 156, 41);
		lblDuration.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblDuration);
		
		lblListed = new JLabel("Listed");
		lblListed.setForeground(Color.BLACK);
		lblListed.setBounds(197, 196, 76, 35);
		lblListed.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblListed);
		
		lblDescription = new JLabel("Description");
		lblDescription.setForeground(Color.BLACK);
		lblDescription.setBounds(569, 302, 103, 55);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblDescription);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(35, 476, 390, 44);
		frame.getContentPane().add(btnBack);
		
		btnNext = new JButton("Next");
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNext.setBounds(435, 476, 390, 44);
		frame.getContentPane().add(btnNext);
		
		txtCast = new JTextPane();
		txtCast.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCast.setEditable(false);
		txtCast.setBounds(43, 352, 375, 99);
		frame.getContentPane().add(txtCast);
		
		txtDescription = new JTextPane();
		txtDescription.setBackground(Color.WHITE);
		txtDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDescription.setBounds(439, 352, 375, 99);
		frame.getContentPane().add(txtDescription);
		
		lblCast = new JLabel("Cast");
		lblCast.setForeground(Color.BLACK);
		lblCast.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCast.setBounds(197, 312, 46, 35);
		frame.getContentPane().add(lblCast);
		
		txtListed = new JTextPane();
		txtListed.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtListed.setEditable(false);
		txtListed.setBounds(43, 241, 382, 71);
		frame.getContentPane().add(txtListed);
		
		btnFavorito = new JButton("FAV");
		btnFavorito.setBackground(new Color(255, 255, 102));
		btnFavorito.setForeground(Color.DARK_GRAY);
		btnFavorito.setBounds(758, 11, 61, 55);
		frame.getContentPane().add(btnFavorito);
		
		verShows(index);
	}
	
	private void configureListeners() {
		btnBack.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) { // Al pulsar la tecla enter, te haga retroceda la lista para atras
					back();
				}
			}
		});
		btnNext.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) { // Al pulsar la tecla enter, te haga avanza la lista
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
				favs.add(shows.get(index).getId());
			}
		});
	}
	
	private void back() {
		index--;
		if (index < 0) { //Cuando el index es la primera posicion del array list
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
