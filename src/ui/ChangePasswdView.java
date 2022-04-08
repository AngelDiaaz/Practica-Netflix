package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
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
import javax.swing.SwingConstants;

import dao.UsuarioDAO;
import models.Usuario;
import utils.HashPasswd;

public class ChangePasswdView {

	private JFrame frmChange;
	private JPasswordField pfPassword;
	private JPasswordField pfPasswordRepetir;
	private JLabel lblChange;
	private JLabel lblNewPassword;
	private JLabel lblNewPasswordRepetir;
	private JButton btnGuardar;
	private UsuarioDAO usuarioDAO;
	private Usuario usuario;

	/**
	 * Create the application.
	 */
	public ChangePasswdView(Usuario usuario) {
		this.usuarioDAO = new UsuarioDAO();
		this.usuario = usuario;
		initialize();
		this.frmChange.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		configureUIComponents();
		configureListeners();
	}

	private void configureUIComponents() {
		frmChange = new JFrame();
		frmChange.setTitle("Netflix: Password");
		frmChange.getContentPane().setBackground(new Color(0, 0, 0));
		frmChange.getContentPane().setLayout(null);
		frmChange.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\adiaz\\OneDrive\\Escritorio\\Programaci\u00F3n\\Workspace\\PracticaNetflix\\assets\\icon netflix.png"));

		lblChange = new JLabel("Cambio de contrase\u00F1a");
		lblChange.setForeground(new Color(204, 51, 51));
		lblChange.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblChange.setBounds(45, 11, 346, 44);
		frmChange.getContentPane().add(lblChange);

		pfPassword = new JPasswordField();
		pfPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pfPassword.setBounds(202, 89, 189, 26);
		frmChange.getContentPane().add(pfPassword);

		pfPasswordRepetir = new JPasswordField();
		pfPasswordRepetir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pfPasswordRepetir.setBounds(202, 126, 189, 26);
		frmChange.getContentPane().add(pfPasswordRepetir);

		lblNewPassword = new JLabel("Nueva contrase\u00F1a");
		lblNewPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewPassword.setForeground(new Color(204, 51, 51));
		lblNewPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewPassword.setBounds(31, 89, 146, 26);
		frmChange.getContentPane().add(lblNewPassword);

		lblNewPasswordRepetir = new JLabel("Repetir contrase\u00F1a");
		lblNewPasswordRepetir.setForeground(new Color(204, 51, 51));
		lblNewPasswordRepetir.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewPasswordRepetir.setBackground(SystemColor.menu);
		lblNewPasswordRepetir.setBounds(21, 128, 156, 21);
		frmChange.getContentPane().add(lblNewPasswordRepetir);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGuardar.setBounds(151, 182, 123, 35);
		btnGuardar.setBackground(new Color(51, 204, 51));
		frmChange.getContentPane().add(btnGuardar);
		frmChange.setBounds(100, 100, 450, 280);
		frmChange.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void configureListeners() {
		btnGuardar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) { // Al pulsar la tecla enter, te deje acceder
					updatePasswd();
				}
			}
		});
		pfPasswordRepetir.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) { // Al pulsar la tecla enter, te deje acceder
					updatePasswd();
				}
			}
		});
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePasswd();
			}
		});
	}

	private void updatePasswd() {
		String passwd = new String(pfPassword.getPassword());
		String repetir = new String(pfPasswordRepetir.getPassword());
		if (passwd.equals(repetir) && !passwd.equals("") && !repetir.equals("")) {

			boolean update = usuarioDAO.updatePassword(HashPasswd.hash(HashPasswd.hash(passwd, ""), ""), usuario);

			if (update) {
				JOptionPane.showMessageDialog(btnGuardar, "La contrase�a ha sido cambia");
				frmChange.dispose();
				new LoginView();
			} else {
				JOptionPane.showMessageDialog(btnGuardar,
						"Error la contrase�a no se ha podido cambiar intentelo de nuevo");
			}
		} else if (!passwd.equals(repetir)) {
			JOptionPane.showMessageDialog(btnGuardar, "La contrase�a no coincide, vuelvelo a intentar");
		} else if (passwd.equals("")) {
			JOptionPane.showMessageDialog(btnGuardar, "Campo contrase�a sin rellenar, rellenelo por favor");
		} else if (repetir.equals("")) {
			JOptionPane.showMessageDialog(btnGuardar, "Campo repetir contrase�a sin rellenar, rellenelo por favor");
		}
	}
}
