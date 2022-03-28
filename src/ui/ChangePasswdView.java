package ui;

import java.awt.Color;

import javax.swing.JFrame;

public class ChangePasswdView {

	private JFrame frmChange;

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
		frmChange.setBounds(100, 100, 450, 300);
		frmChange.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
