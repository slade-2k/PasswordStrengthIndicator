package controller;

public class Password {
	
	private static final int NUMBERS = 10;
	private static final int LOWER_CHARS = 26;
	private static final int UPPER_CHARS = 26;
	private static final int SPECIAL_SIGNS = 34;
	
	private String password;
	private double combinations = 0;
	private int strength;
	private String strengthText;
	private char[] character;
	
	private boolean hasNumbers = false;
	private boolean hasLowerChars = false;
	private boolean hasUpperChars = false;
	private boolean hasSpecialSigns = false;
	
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
	
	public String getStrengthText(){
		return this.strengthText;
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
			this.strengthText ="";
		}
		else if(this.combinations < 1000) {
			this.strength = 20;
			this.strengthText ="Sehr schwach";
		}
		else if(this.combinations < 10000){
			this.strength = 40;
			this.strengthText ="Schwach";
		}
		else if(this.combinations < 1000000){
			this.strength = 60;
			this.strengthText ="Mittel";
		}
		else if(this.combinations < 1000000000){
			this.strength = 80; 
			this.strengthText ="Stark";
		}
		else{
			this.strength = 100;
			this.strengthText ="Sehr stark";
		}

	}
	
	private void setBase(){
		if(this.hasNumbers){
			this.base += NUMBERS;
		}
		if(this.hasLowerChars){
			this.base += LOWER_CHARS;
		}
		if(this.hasUpperChars){
			this.base += UPPER_CHARS;
		}
		if(this.hasSpecialSigns){
			this.base += SPECIAL_SIGNS;
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
