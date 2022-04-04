package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.UsuarioDAO;
import models.Usuario;
import utils.SendEmail;

public class ForgotView {

	private JFrame frmForgot;
	private JTextField txtEmail;
	private JTextField txtUsuario;
	private JFrame parent;
	private JLabel lblForgot;
	private JLabel lblEmail;
	private JLabel lblInfo;
	private JLabel lblUsuario;
	private JButton btnAtras;
	private JButton btnSiguiente;
	private UsuarioDAO usuarioDAO;
	private Usuario usuario;

	/**
	 * Create the application.
	 */
	public ForgotView(JFrame parent) {
		this.parent = parent;
		usuarioDAO = new UsuarioDAO();
		initialize();
		this.frmForgot.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		configureUIComponents();
		configureListeners();
	}
	
	public void configureUIComponents() {
		frmForgot = new JFrame();
		frmForgot.setTitle("Netlix: Password");
		frmForgot.getContentPane().setBackground(new Color(153, 204, 204));
		frmForgot.getContentPane().setLayout(null);
		
		lblForgot = new JLabel("Forgot Password");
		lblForgot.setForeground(Color.WHITE);
		lblForgot.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblForgot.setBounds(137, 11, 260, 53);
		frmForgot.getContentPane().add(lblForgot);
		
		lblEmail = new JLabel("Correo Electr\u00F3nico");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(67, 133, 146, 26);
		frmForgot.getContentPane().add(lblEmail);
		
		lblInfo = new JLabel("Rellene todos los campos para cambiar la contrase\u00F1a");
		lblInfo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblInfo.setForeground(Color.WHITE);
		lblInfo.setBounds(81, 75, 362, 36);
		frmForgot.getContentPane().add(lblInfo);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtEmail.setBounds(223, 132, 206, 28);
		frmForgot.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblUsuario.setBounds(154, 172, 59, 26);
		frmForgot.getContentPane().add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(223, 171, 206, 28);
		frmForgot.getContentPane().add(txtUsuario);
		
		btnAtras = new JButton("Volver");
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAtras.setBackground(new Color(255, 204, 51));
		btnAtras.setBounds(29, 239, 175, 26);
		frmForgot.getContentPane().add(btnAtras);
		
		btnSiguiente = new JButton("Continuar");
		btnSiguiente.setBackground(new Color(102, 204, 0));
		btnSiguiente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSiguiente.setBounds(287, 240, 175, 25);
		frmForgot.getContentPane().add(btnSiguiente);
		frmForgot.setBounds(100, 100, 515, 320);
		frmForgot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void configureListeners() {
		txtUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) { // Al pulsar la tecla enter, te deje acceder
					comprobar();
				}
			}
		});
		
		btnSiguiente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) { // Al pulsar la tecla enter, te deje acceder
					comprobar();
				}
			}
		});
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmForgot.dispose();
				parent.setVisible(true);
			}
		});
		
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobar();
			}
		});
	}
	
	private void comprobar() {
		var usuarios = usuarioDAO.getAll();
		int pin = (int) (Math.random() * 999999) + 100000;
		boolean correcto = false;
		
		for (Usuario usu : usuarios) {
			if(usu.getUsuario().equals(txtUsuario.getText()) && usu.getEmail().equals(txtEmail.getText())) {
				correcto = true;
				this.usuario = usu;
			}
		}
		
		if(correcto) {
			SendEmail.email(txtEmail.getText(), pin);
			int num = Integer.parseInt(JOptionPane
					.showInputDialog("Ingrese el número que se le ha enviado al correo para poder registrarse"));
			if(num == pin) {
				frmForgot.dispose();
				new ChangePasswdView(usuario);
			} else {
				JOptionPane.showMessageDialog(frmForgot, "El pin no coincide con el que te hemos enviado al email");
			}
		} else {
			JOptionPane.showMessageDialog(frmForgot, "Usuario o correo electrónico no válidos, vuelve a introducirlos");
		}
	}
	
}
