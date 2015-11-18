package gui;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentListener;

public class GUI extends JFrame {
	private JTextField txtPassword = new JTextField("");
	private JLabel lblPassword = new JLabel("Password: ");

	private JPanel pnlWrapper = new JPanel();

	private JProgressBar progBar;

	public GUI() {
		this.setTitle("PasswordStrengthIndicator");
		this.setSize(350, 75);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		progBar = new JProgressBar();
		progBar.setStringPainted(true);
		progBar.setString("");

		Dimension dimTxt = new Dimension(100, 20);
		progBar.setMaximumSize(dimTxt);
		progBar.setSize(dimTxt);
		txtPassword.setMaximumSize(dimTxt);
		txtPassword.setSize(dimTxt);

		this.add(pnlWrapper);
		pnlWrapper.setLayout(new BoxLayout(pnlWrapper, BoxLayout.X_AXIS));
		pnlWrapper.add(lblPassword);
		pnlWrapper.add(txtPassword);
		pnlWrapper.add(Box.createRigidArea(new Dimension(25, 25)));
		pnlWrapper.add(progBar);

		validate();
	}

	public void setProgressBar(String strength, int value) {
		progBar.setString(strength);
		progBar.setValue(value);
	}

	public String getPasswordText() {
		return txtPassword.getText();
	}

	public void addTxtPasswordListener(DocumentListener action) {
		txtPassword.getDocument().addDocumentListener(action);
	}

}
