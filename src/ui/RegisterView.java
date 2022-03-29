package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
		frmRegistro.getContentPane().setBackground(new Color(153, 204, 204));
		frmRegistro.getContentPane().setForeground(Color.BLACK);
		frmRegistro.setTitle("Registro");
		frmRegistro.setBounds(100, 100, 450, 292);
		frmRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistro.getContentPane().setLayout(null);

		lblRegistro = new JLabel("Crear Cuenta");
		lblRegistro.setForeground(Color.WHITE);
		lblRegistro.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblRegistro.setBounds(121, 0, 197, 54);
		frmRegistro.getContentPane().add(lblRegistro);

		lblNewUsuario = new JLabel("Usuario");
		lblNewUsuario.setForeground(Color.WHITE);
		lblNewUsuario.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewUsuario.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewUsuario.setBounds(107, 93, 62, 19);
		frmRegistro.getContentPane().add(lblNewUsuario);

		lblNewPassword = new JLabel("Contrase\u00F1a");
		lblNewPassword.setForeground(Color.WHITE);
		lblNewPassword.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewPassword.setBounds(74, 123, 96, 20);
		frmRegistro.getContentPane().add(lblNewPassword);

		lblNewPasswordRepetir = new JLabel("Repetir contrase\u00F1a");
		lblNewPasswordRepetir.setForeground(Color.WHITE);
		lblNewPasswordRepetir.setBackground(new Color(240, 240, 240));
		lblNewPasswordRepetir.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewPasswordRepetir.setBounds(28, 154, 141, 21);
		frmRegistro.getContentPane().add(lblNewPasswordRepetir);

		textUsuario = new JTextField();
		textUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textUsuario.setBounds(202, 93, 141, 20);
		frmRegistro.getContentPane().add(textUsuario);
		textUsuario.setColumns(10);

		pfPassword = new JPasswordField();
		pfPassword.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		pfPassword.setBounds(202, 124, 141, 20);
		frmRegistro.getContentPane().add(pfPassword);

		pfPasswordRepetir = new JPasswordField();
		pfPasswordRepetir.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		pfPasswordRepetir.setBounds(202, 155, 141, 20);
		frmRegistro.getContentPane().add(pfPasswordRepetir);

		btnRegistro = new JButton("Registrarse");
		btnRegistro.setBackground(new Color(102, 204, 0));
		btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegistro.setBounds(255, 213, 107, 29);
		frmRegistro.getContentPane().add(btnRegistro);

		btnInicioSesion = new JButton("Volver");
		btnInicioSesion.setBackground(new Color(255, 204, 51));
		btnInicioSesion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnInicioSesion.setBounds(73, 213, 107, 29);
		frmRegistro.getContentPane().add(btnInicioSesion);

		lblEmail = new JLabel("Correo electr\u00F3nico");
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblEmail.setBounds(0, 63, 169, 19);
		frmRegistro.getContentPane().add(lblEmail);

		textEmail = new JTextField();
		textEmail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textEmail.setColumns(10);
		textEmail.setBounds(202, 64, 141, 20);
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

			email(textEmail.getText(), pin);

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

	private void email(String email, int pin) {
		final String username = "prog.pruebas1@gmail.com";
		final String password = "manolo.bombo";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.trust", "*");
		prop.put("mail.smtp.starttls.required", "true");
		prop.put("mail.smtp.ssl.protocols", "TLSv1.2");

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from@gmail.com")); // Aqui se puede mandar el email a los que queramos
																	// demas
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("Pin de autentificación");
			message.setText("Hola aqui tiene el codigo de autentificación para poder registrarte,\n\n" + pin + ".");
			// mailchimp, sendinblue, mailjet Paguinas web para enviar correos con html
			// 18:37
			Transport.send(message);

//			     System.out.println("Done");

		} catch (MessagingException e) {
			JOptionPane.showMessageDialog(btnRegistro, "Correo eléctronico no válido, pruebe a insertarlo otra vez");
			e.printStackTrace();
		}
	}
}
