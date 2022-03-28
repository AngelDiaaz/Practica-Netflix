package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.UsuarioDAO;
import models.Usuario;

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
			frmLogin.getContentPane().setBackground(new Color(153, 204, 204));
			frmLogin.getContentPane().setForeground(Color.WHITE);
			configureUIComponents();
			configureListeners();
		}
		
		/**
		 * Componentes de la view
		 */

		private void configureUIComponents() {
			frmLogin.setTitle("Login");
			frmLogin.setBounds(100, 100, 484, 259);
			frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frmLogin.getContentPane().setLayout(null);

			lblUsuario = new JLabel("Usuario");
			lblUsuario.setForeground(Color.WHITE);
			lblUsuario.setFont(new Font("Times New Roman", Font.BOLD, 17));
			lblUsuario.setHorizontalAlignment(SwingConstants.TRAILING);
			lblUsuario.setBounds(61, 78, 81, 31);
			frmLogin.getContentPane().add(lblUsuario);

			tfUsuario = new JTextField();
			tfUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			tfUsuario.setBounds(170, 79, 207, 30);
			frmLogin.getContentPane().add(tfUsuario);
			tfUsuario.setColumns(10);

			lblPassword = new JLabel("Contrase\u00F1a");
			lblPassword.setForeground(Color.WHITE);
			lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 17));
			lblPassword.setBounds(58, 119, 84, 30);
			frmLogin.getContentPane().add(lblPassword);

			btnEntrar = new JButton("Entrar");
			btnEntrar.setBackground(new Color(102, 204, 0));

			btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnEntrar.setBounds(329, 178, 123, 23);
			frmLogin.getContentPane().add(btnEntrar);

			pfPassword = new JPasswordField();
			pfPassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			pfPassword.setBounds(170, 120, 207, 29);
			frmLogin.getContentPane().add(pfPassword);
			
			btnRegistro = new JButton("Registrarse");
			btnRegistro.setBackground(new Color(255, 204, 51));
			btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnRegistro.setBounds(196, 178, 123, 23);
			frmLogin.getContentPane().add(btnRegistro);
			
			lblNewLabel = new JLabel("Login Netflix");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
			lblNewLabel.setBounds(113, 11, 207, 45);
			frmLogin.getContentPane().add(lblNewLabel);
			
			btnForgetPasswd = new JButton("Forget Password");
			btnForgetPasswd.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnForgetPasswd.setBackground(new Color(102, 153, 255));
			btnForgetPasswd.setBounds(20, 178, 144, 23);
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
			pfPassword.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) { // Para que al pulsar la tecla enter, te deje acceder
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
				}
			});
		}
		
		private void comprobarLogin() {
			String usuario = tfUsuario.getText();
			String password = new String(pfPassword.getPassword());
			boolean loginCorrecto = usuarioDAO.login(new Usuario(usuario,hashPasswd(hashPasswd(password,""), "")));
			if (loginCorrecto) {
				frmLogin.setVisible(false);
				new FilmsView();
			} else {
				JOptionPane.showMessageDialog(btnEntrar, "Login incorrecto");
			}
		}
		
		private String hashPasswd(String passwordToHash, String salt){
		    String generatedPassword = null;
		    try {
		        MessageDigest md = MessageDigest.getInstance("SHA-512");
		        md.update(salt.getBytes(StandardCharsets.UTF_8));
		        byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
		        StringBuilder sb = new StringBuilder();
		        for(int i=0; i< bytes.length ;i++){
		            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		        }
		        generatedPassword = sb.toString();
		    } catch (NoSuchAlgorithmException e) {
		        e.printStackTrace();
		    }
		    return generatedPassword;
		}
}
