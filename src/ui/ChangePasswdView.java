package ui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JButton;

public class ChangePasswdView {

	private JFrame frmChange;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JLabel lblChange;
	private JLabel lblNewPassword;
	private JLabel lblNewPasswordRepetir;
	private JButton btnGuardar;

	/**
	 * Create the application.
	 */
	public ChangePasswdView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChange = new JFrame();
		frmChange.getContentPane().setBackground(new Color(153, 204, 204));
		frmChange.getContentPane().setLayout(null);
		
		lblChange = new JLabel("Cambio de contrase\u00F1a");
		lblChange.setForeground(new Color(255, 255, 255));
		lblChange.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblChange.setBounds(58, 11, 346, 44);
		frmChange.getContentPane().add(lblChange);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		passwordField.setBounds(202, 89, 155, 26);
		frmChange.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		passwordField_1.setBounds(202, 126, 155, 26);
		frmChange.getContentPane().add(passwordField_1);
		
		lblNewPassword = new JLabel("Nueva contrase\u00F1a");
		lblNewPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewPassword.setForeground(Color.WHITE);
		lblNewPassword.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewPassword.setBounds(31, 89, 146, 26);
		frmChange.getContentPane().add(lblNewPassword);
		
		lblNewPasswordRepetir = new JLabel("Repetir contrase\u00F1a");
		lblNewPasswordRepetir.setForeground(Color.WHITE);
		lblNewPasswordRepetir.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewPasswordRepetir.setBackground(SystemColor.menu);
		lblNewPasswordRepetir.setBounds(31, 128, 146, 21);
		frmChange.getContentPane().add(lblNewPasswordRepetir);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGuardar.setBounds(159, 199, 101, 35);
		btnGuardar.setBackground(new Color(102, 204, 0));
		frmChange.getContentPane().add(btnGuardar);
		frmChange.setBounds(100, 100, 450, 300);
		frmChange.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
