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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.UsuarioDAO;
import models.Usuario;
import utils.HashPasswd;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class LoginView {

	//Propiedades
		private JFrame frmLogin;
		private JTextField tfUsuario;
		private JLabel lblUsuario;
		private JLabel lblPassword;
		private JLabel lblNewLabel;
		private JButton btnEntrar;
		private JPasswordField pfPassword;
		private JButton btnRegistro;
		private UsuarioDAO usuarioDAO;
		private JButton btnForgetPasswd;

		/**
		 * Create the application.
		 */
		public LoginView() {
			initialize();
			this.frmLogin.setVisible(true);
			usuarioDAO = new UsuarioDAO();

		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frmLogin = new JFrame();
			frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\adiaz\\OneDrive\\Escritorio\\Programaci\u00F3n\\Workspace\\PracticaNetflix\\assets\\icon netflix.png"));
			frmLogin.getContentPane().setBackground(Color.BLACK);
			frmLogin.getContentPane().setForeground(Color.WHITE);
			configureUIComponents();
			configureListeners();
		}
		
		/**
		 * Componentes de la view
		 */

		private void configureUIComponents() {
			frmLogin.setTitle("Netflix: Login");
			frmLogin.setBounds(100, 100, 532, 360);
			frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frmLogin.getContentPane().setLayout(null);

			lblNewLabel = new JLabel("");
			lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel.setIcon(new ImageIcon("assets/gif netflix.gif"));
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
			lblNewLabel.setBounds(10, 11, 456, 84);
			frmLogin.getContentPane().add(lblNewLabel);
			
			lblUsuario = new JLabel("Usuario");
			lblUsuario.setForeground(new Color(204, 51, 51));
			lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblUsuario.setHorizontalAlignment(SwingConstants.TRAILING);
			lblUsuario.setBounds(116, 121, 81, 31);
			frmLogin.getContentPane().add(lblUsuario);

			tfUsuario = new JTextField();
			tfUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
			tfUsuario.setBounds(228, 122, 223, 30);
			frmLogin.getContentPane().add(tfUsuario);
			tfUsuario.setColumns(10);

			lblPassword = new JLabel("Contrase\u00F1a");
			lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
			lblPassword.setForeground(new Color(204, 51, 51));
			lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblPassword.setBounds(83, 178, 114, 30);
			frmLogin.getContentPane().add(lblPassword);

			btnEntrar = new JButton("Entrar");
			btnEntrar.setForeground(new Color(0, 0, 0));
			btnEntrar.setBackground(new Color(51, 204, 51));
			btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnEntrar.setBounds(335, 271, 131, 31);
			frmLogin.getContentPane().add(btnEntrar);

			pfPassword = new JPasswordField();
			pfPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
			pfPassword.setBounds(228, 180, 223, 29);
			frmLogin.getContentPane().add(pfPassword);
			
			btnRegistro = new JButton("Registrarse");
			btnRegistro.setForeground(new Color(0, 0, 0));
			btnRegistro.setBackground(new Color(255, 255, 102));
			btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnRegistro.setBounds(187, 271, 131, 31);
			frmLogin.getContentPane().add(btnRegistro);
			
			
			btnForgetPasswd = new JButton("Forget Password");
			btnForgetPasswd.setForeground(new Color(0, 0, 0));
			btnForgetPasswd.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnForgetPasswd.setBackground(new Color(102, 153, 255));
			btnForgetPasswd.setBounds(35, 271, 131, 31);
			frmLogin.getContentPane().add(btnForgetPasswd);
		}
		
		/**
		 * Acciones de los botones del view
		 */

		private void configureListeners() {
			btnEntrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comprobarLogin();
				}
			});
			btnEntrar.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) { // Al pulsar la tecla enter, te deje acceder
						comprobarLogin();
					}
				}
			});
			pfPassword.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) { // Al pulsar la tecla enter, te deje acceder
						comprobarLogin();
					}
				}
			});
			btnRegistro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmLogin.setVisible(false); //Te hace invisible la pestaña del login
					new RegisterView(frmLogin); // Te muestra la pestaña de registro
				}
			});
			btnForgetPasswd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmLogin.setVisible(false);
					new ForgotView(frmLogin);
				}
			});
		}
		
		private void comprobarLogin() {
			String usuario = tfUsuario.getText();
			String password = new String(pfPassword.getPassword());
			boolean loginCorrecto = usuarioDAO.login(new Usuario(usuario,HashPasswd.hash(HashPasswd.hash(password,""), "")));
			if (loginCorrecto) {
				frmLogin.setVisible(false);
				new FilmsView();
			} else {
				JOptionPane.showMessageDialog(btnEntrar, "Login incorrecto");
			}
		}
}		
