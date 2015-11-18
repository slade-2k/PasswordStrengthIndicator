package controller;

import java.awt.event.ActionEvent;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import gui.GUI;

public class Controller implements DocumentListener {
	private GUI gui;
	
	public Controller(){
		gui = new GUI();
		gui.addTxtPasswordListener(this);
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {	
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		documentEvent();	
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		documentEvent();
	}
	
	public void documentEvent(){
		Password password = new Password(gui.getPasswordText());
		gui.setProgressBar(password.getStrengthText(), password.getStrength());
	}
}