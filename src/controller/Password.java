package controller;

import javax.swing.JOptionPane;

import gui.GUI;

public class Password {
	private String password;
	private double combinations = 0;
	private int strength;
	private char[] character;
	
	private boolean hasNumbers = false;
	private boolean hasLowerChars = false;
	private boolean hasUpperChars = false;
	private boolean hasSpecialSigns = false;
	
	private int numbers = 10;
	private int lowerChars = 26;
	private int upperChars = 26;
	private int specialSigns = 34;
	
	private int base = 0;
	
	public Password(String password){
		this.password = password;
		passwordToCharacterList();
		setBase();
		setStrength();
	}
	
	public int getStrength(){
		return this.strength;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	private void passwordToCharacterList(){
		character = new char[this.password.length()];
		for(int i=0; i < this.password.length(); i++){
			character[i] = this.password.charAt(i);	
			checkChar(i);
		}
	}
	
	private void setStrength(){
		this.combinations =  Math.pow(this.base, this.password.length())/1000000000;
		if(this.password.equals("")){
			this.strength = 0;
		}
		else if(this.combinations < 1000) {
			this.strength = 20;
		}
		else if(this.combinations < 10000){
			this.strength = 40;
		}
		else if(this.combinations < 1000000){
			this.strength = 60;
		}
		else if(this.combinations < 1000000000){
			this.strength = 80; 
		}
		else{
			this.strength = 100;
		}

	}
	
	private void setBase(){
		if(this.hasNumbers){
			this.base += this.numbers;
		}
		if(this.hasLowerChars){
			this.base += this.lowerChars;
		}
		if(this.hasUpperChars){
			this.base += this.upperChars;
		}
		if(this.hasSpecialSigns){
			this.base += this.specialSigns;
		}
	}
	
	private void checkChar(int i){
		if(character[i] > 47 && character[i] < 58){
			this.hasNumbers = true;
		} else if(character[i] > 64 && character[i] < 91){
			this.hasUpperChars = true;
		} else if(character[i] > 96 && character[i] < 123){
			this.hasLowerChars = true;
		} else {
			this.hasSpecialSigns = true;
		}
	}
}
