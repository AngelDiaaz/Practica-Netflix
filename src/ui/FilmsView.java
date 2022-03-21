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
	private ShowDAO showDAO;
	private ArrayList<Show> shows;
	private JTextPane txtCast;
	private JTextPane txtDescription;
	

	/**
	 * Create the application.
	 */
	public FilmsView() {
		this.showDAO = new ShowDAO();
		this.shows = showDAO.getAll();
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
		frame.setBounds(100, 100, 800, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblTittle = new JLabel("");
		lblTittle.setBounds(339, 11, 78, 71);
		lblTittle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblTittle);
		
		lblType = new JLabel("");
		lblType.setBounds(58, 79, 84, 71);
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblType);
		
		lblDirector = new JLabel("");
		lblDirector.setBounds(564, 212, 134, 71);
		lblDirector.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblDirector);
		
		lblCountry = new JLabel("");
		lblCountry.setBounds(245, 132, 108, 92);
		lblCountry.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblCountry);
		
		lblDateAdd = new JLabel("");
		lblDateAdd.setBounds(58, 161, 125, 35);
		lblDateAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblDateAdd);
		
		lblYear = new JLabel("");
		lblYear.setBounds(474, 94, 78, 41);
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblYear);
		
		lblRating = new JLabel("");
		lblRating.setBounds(462, 156, 108, 44);
		lblRating.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblRating);
		
		lblDuration = new JLabel("");
		lblDuration.setBounds(253, 94, 84, 41);
		lblDuration.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblDuration);
		
		lblListed = new JLabel("");
		lblListed.setBounds(58, 231, 466, 26);
		lblListed.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblListed);
		
		lblDescription = new JLabel("Description");
		lblDescription.setBounds(486, 270, 103, 71);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblDescription);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(27, 446, 359, 41);
		frame.getContentPane().add(btnBack);
		
		btnNext = new JButton("Next");
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNext.setBounds(396, 446, 359, 41);
		frame.getContentPane().add(btnNext);
		
		txtCast = new JTextPane();
		txtCast.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCast.setEditable(false);
		txtCast.setBounds(58, 329, 328, 92);
		frame.getContentPane().add(txtCast);
		
		txtDescription = new JTextPane();
		txtDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDescription.setBounds(396, 329, 359, 92);
		frame.getContentPane().add(txtDescription);
		
		JLabel lblCast = new JLabel("Cast");
		lblCast.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCast.setBounds(168, 300, 46, 18);
		frame.getContentPane().add(lblCast);
		
		verShows();
	}
	
	private void configureListeners() {
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
	
	public void verShows() {
		
		lblTittle.setText(shows.get(0).getTitle());
		lblType.setText(shows.get(0).getType());
		lblDirector.setText(shows.get(0).getDirector());
		lblCountry.setText(shows.get(0).getCountry());
		lblDateAdd.setText(shows.get(0).getDate());
		lblYear.setText(shows.get(0).getYear());
		lblRating.setText(shows.get(0).getRating());
		lblDuration.setText(shows.get(0).getDuration());
		lblListed.setText(shows.get(0).getListed());
		txtCast.setText(shows.get(0).getCast());
		txtDescription.setText(shows.get(0).getDescription());
		
		}
	}
