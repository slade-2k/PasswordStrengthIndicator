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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.Password;

public class GUI extends JFrame{
	private JTextField txtPassword = new JTextField("");
	private JLabel lblPassword = new JLabel("Password: ");
	
	private JPanel pnlWrapper = new JPanel();
	
	private JProgressBar progBar;
	
	public GUI(){
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
		txtPassword.getDocument().addDocumentListener(new DocumentListener(){

			@Override
			public void changedUpdate(DocumentEvent arg0) {					
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				Password password = new Password(txtPassword.getText());
				progBar.setValue(password.getStrength());
				setStrengthLabel(password.getStrength());
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				Password password = new Password(txtPassword.getText());
				progBar.setValue(password.getStrength());
				setStrengthLabel(password.getStrength());
			}
		});
		
		this.add(pnlWrapper);
		pnlWrapper.setLayout(new BoxLayout(pnlWrapper, BoxLayout.X_AXIS));
		pnlWrapper.add(lblPassword);
		pnlWrapper.add(txtPassword);
		pnlWrapper.add(Box.createRigidArea(new Dimension(25,25)));
		pnlWrapper.add(progBar);
		
		validate();
	}
	
	public void setStrengthLabel(int strength){
		if(strength == 20){
			progBar.setString("Sehr schwach");
		}
		else if(strength == 40){
			progBar.setString("Schwach");
		}
		else if(strength == 60){
			progBar.setString("Mittel");
		}
		else if(strength == 80){
			progBar.setString("Stark");
		}
		else if(strength == 100){
			progBar.setString("Sehr stark");
		}
		else{
			progBar.setString("");
		}
	}
}
