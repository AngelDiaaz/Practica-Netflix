package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
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
import utils.SendEmail;

public class RegisterView {

	// Propiedades
	private JFrame frmRegistro;
	private JTextField textUsuario;
	private JPasswordField pfPassword;
	private JPasswordField pfPasswordRepetir;
	private JLabel lblRegistro;
	private JLabel lblNewUsuario;
	private JLabel lblNewPassword;
	private JLabel lblNewPasswordRepetir;
	private JButton btnRegistro;
	private JButton btnInicioSesion;
	private JFrame parent;
	private UsuarioDAO usuarioDAO;
	private JTextField textEmail;
	private JLabel lblEmail;

	/**
	 * Create the application.
	 * 
	 * @param frmLogin
	 */
	public RegisterView(JFrame parent) {
		this.parent = parent;
		this.usuarioDAO = new UsuarioDAO();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		configureUIComponents();
		configureListeners();
	}

	/**
	 * Componentes del view
	 */

	private void configureUIComponents() {
		frmRegistro = new JFrame();
		frmRegistro.getContentPane().setBackground(Color.BLACK);
		frmRegistro.getContentPane().setForeground(Color.BLACK);
		frmRegistro.setTitle("Netflix: Registro");
		frmRegistro.setBounds(100, 100, 483, 325);
		frmRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistro.getContentPane().setLayout(null);
		frmRegistro.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\adiaz\\OneDrive\\Escritorio\\Programaci\u00F3n\\Workspace\\PracticaNetflix\\assets\\icon netflix.png"));

		lblRegistro = new JLabel("Crear Cuenta");
		lblRegistro.setForeground(new Color(204, 51, 51));
		lblRegistro.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblRegistro.setBounds(130, 0, 203, 54);
		frmRegistro.getContentPane().add(lblRegistro);

		lblNewUsuario = new JLabel("Usuario");
		lblNewUsuario.setForeground(new Color(204, 51, 51));
		lblNewUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewUsuario.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewUsuario.setBounds(130, 112, 62, 19);
		frmRegistro.getContentPane().add(lblNewUsuario);

		lblNewPassword = new JLabel("Contrase\u00F1a");
		lblNewPassword.setForeground(new Color(204, 51, 51));
		lblNewPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewPassword.setBounds(82, 147, 110, 20);
		frmRegistro.getContentPane().add(lblNewPassword);

		lblNewPasswordRepetir = new JLabel("Repetir contrase\u00F1a");
		lblNewPasswordRepetir.setForeground(new Color(204, 51, 51));
		lblNewPasswordRepetir.setBackground(new Color(240, 240, 240));
		lblNewPasswordRepetir.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewPasswordRepetir.setBounds(36, 183, 156, 21);
		frmRegistro.getContentPane().add(lblNewPasswordRepetir);

		textUsuario = new JTextField();
		textUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textUsuario.setBounds(222, 108, 191, 25);
		frmRegistro.getContentPane().add(textUsuario);
		textUsuario.setColumns(10);

		pfPassword = new JPasswordField();
		pfPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pfPassword.setBounds(222, 144, 191, 25);
		frmRegistro.getContentPane().add(pfPassword);

		pfPasswordRepetir = new JPasswordField();
		pfPasswordRepetir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pfPasswordRepetir.setBounds(222, 180, 191, 25);
		frmRegistro.getContentPane().add(pfPasswordRepetir);

		btnRegistro = new JButton("Registrarse");
		btnRegistro.setBackground(new Color(51, 204, 51));
		btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegistro.setBounds(302, 238, 123, 29);
		frmRegistro.getContentPane().add(btnRegistro);

		btnInicioSesion = new JButton("Volver");
		btnInicioSesion.setBackground(new Color(255, 255, 102));
		btnInicioSesion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnInicioSesion.setBounds(48, 238, 123, 29);
		frmRegistro.getContentPane().add(btnInicioSesion);

		lblEmail = new JLabel("Correo electr\u00F3nico");
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setForeground(new Color(204, 51, 51));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmail.setBounds(23, 76, 169, 19);
		frmRegistro.getContentPane().add(lblEmail);

		textEmail = new JTextField();
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textEmail.setColumns(10);
		textEmail.setBounds(222, 72, 191, 25);
		frmRegistro.getContentPane().add(textEmail);
		frmRegistro.setVisible(true);
	}

	/**
	 * Acciones de los botones del view
	 */

	private void configureListeners() {
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarse();
			}
		});
		btnRegistro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) { // Al pulsar la tecla enter, te deje acceder
					registrarse();
				}
			}
		});
		pfPasswordRepetir.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) { // Al pulsar la tecla enter, te deje acceder
					registrarse();
				}
			}
		});
		btnInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRegistro.dispose();
				parent.setVisible(true);
			}
		});
	}

	/**
	 * Comprueba que las credenciales que has metido son correctas, comprobando que
	 * las contraseñas son iguales en los dos campos
	 */

	private void registrarse() {
		String passwd = new String(pfPassword.getPassword());
		String repetir = new String(pfPasswordRepetir.getPassword());
		int pin = (int) (Math.random() * 999999) + 100000;

		// Cuando las constrañas coincidan y no haya ningun campo vacio
		if (passwd.equals(repetir) && !textUsuario.getText().equals("") && !passwd.equals("") && !repetir.equals("")) {

			SendEmail.email(textEmail.getText(), pin);

			int num = Integer.parseInt(JOptionPane
					.showInputDialog("Ingrese el número que se le ha enviado al correo para poder registrarse"));

			if (pin == num) {
				// Realizo el hash password dos veces para ser mas segura la contraseña
				boolean registrar = usuarioDAO.registrar(new Usuario(textUsuario.getText(),
						HashPasswd.hash(HashPasswd.hash(passwd, ""), ""), textEmail.getText()));
				JOptionPane.showMessageDialog(null, "Usuario " + textUsuario.getText() + " creado");
				frmRegistro.dispose();
				if (registrar == true) { // Si el usuario se registra correctamente
					new LoginView();
				} else { // Sino vuelve a abrirse otra pestaña de registro
					new RegisterView(parent);
				}
			} else {
				JOptionPane.showMessageDialog(btnRegistro, "El pin no coincide con el que te hemos enviado al email");
			}

		} else if (!passwd.equals(repetir)) {
			JOptionPane.showMessageDialog(btnRegistro, "La contraseña no coincide, vuelvelo a intentar");
		} else if (textUsuario.getText().equals("")) {
			JOptionPane.showMessageDialog(btnRegistro, "Campo usuario sin rellenar, rellenelo por favor");
		} else if (passwd.equals("")) {
			JOptionPane.showMessageDialog(btnRegistro, "Campo contraseña sin rellenar, rellenelo por favor");
		} else if (repetir.equals("")) {
			JOptionPane.showMessageDialog(btnRegistro, "Campo repetir contraseña sin rellenar, rellenelo por favor");
		} else if (textEmail.getText().equals("")) {
			JOptionPane.showMessageDialog(btnRegistro, "Campo correo electrónico sin rellenar, rellenelo por favor");
		}
	}

}
