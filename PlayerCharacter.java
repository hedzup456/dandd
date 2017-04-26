package dndMiscResources;

import java.io.Serializable;
import java.util.Scanner;

public class PlayerCharacter implements Serializable{
	// Bulk-declaration of object-wide variables
	private static final long serialVersionUID = 1L; // Unsure on what it does, just know it's needed for serialisation!
	private String name, race, pcClass, alignment, playerName;
	private int strength, dexterity, intelligence, constitution, wisdom, charisma, speed;
	private char size;
	
	// constructors
	public PlayerCharacter(){ // Defaults
		this.name = this.race = this.pcClass = this.alignment = "";
		this.strength = this.dexterity = this.intelligence = this.constitution = this.wisdom = this.charisma = this.speed = 0;
		this.size = 'M';
	}
	public PlayerCharacter(String playerName){ // When playername is passed in with creation of object
		this.playerName = playerName;
		this.race = this.pcClass = this.alignment = "";
		this.strength = this.dexterity = this.intelligence = this.constitution = this.wisdom = this.charisma = this.speed = 0;
		this.size = 'M';
	}
	// end constructors
	
	// Setters, all pretty self explanatory
	public void setName(String name){
		this.name = name;
	}
	public void setPCClass(String pcClass){
		this.pcClass = pcClass;
	}
	public void setRace(String race){
		this.race = race;
	}
	public void setAlignment(String alignment){
		if (alignment.length() == 2){ // Make sure that the alignment is set as the word value.
			switch (alignment){
			case "LG":
				this.alignment = "Lawful Good";
				break;
			case "LN":
				this.alignment = "Lawful Neutral";
				break;
			case "LE":
				this.alignment = "Lawful Evil";
				break;
			case "NG":
				this.alignment = "Neutral Good";
				break;
			case "TN": // Either case of true neutral
			case "NN":
				this.alignment = "True Neutral";
				break;
			case "NE":
				this.alignment = "Neutral Evil";
				break;
			case "CG":
				this.alignment = "Chaotic Good";
				break;
			case "CN":
				this.alignment = "Chaotic Neutral";
				break;
			case "CE":
				this.alignment = "Chaotic Evil";
				break;
			}
		} else this.alignment = alignment; // Assuming that the user gave the word-form.
	}
	public void setStrength(int strength){
		this.strength = strength;
	}
	public void setDexterity(int dex){
		this.dexterity = dex;
	}
	public void setIntelligence(int intelligence){
		this.intelligence = intelligence;
	}
	public void setConstitution(int con){
		this.constitution = con;
	}
	public void setWisom(int wis){
		this.wisdom = wis;
	}
	public void setCharisma(int charisma){
		this.charisma = charisma;
	}
	public void setSpeed(int speed){
		this.speed = speed;
	}
	public void setSize(char size){
		this.size = size;
	}
	public void setPlayerName(String pName){
		this.playerName = pName;
	}
	// end setters
	
	// getters, equally self explanatory
	public String getName(){
		return this.name;
	}
	public String getPCClass(){
		return this.pcClass;
	}
	public String getRace(){
		return this.race;
	}
	public String getAlignment(){
		return this.alignment;
	}
	public int getStrength(){
		return this.strength;
	}
	public int getDexterity(){
		return this.dexterity;
	}
	public int getIntelligence(){
		return this.intelligence;
	}
	public int getConstitution(){
		return this.constitution;
	}
	public int getWisdom(){
		return this.wisdom;
	}
	public int getCharisma(){
		return this.charisma;
	}
	public int getSpeed(){
		return this.speed;
	}
	public char getSize(){
		return this.size;
	}
	public String getPlayerName(){
		return this.playerName;
	}
	// end getters
	
	
	public void rollCoreStats(Scanner sc){	// Method to roll the six core stats needed by all characters. Has scanner passed to it from the main menu.
		DieRoller roller = new DieRoller(); // Create new DieRoller object

		int[] rolls = {roller.rollACoreStat(),roller.rollACoreStat(),roller.rollACoreStat(),roller.rollACoreStat(),roller.rollACoreStat(),roller.rollACoreStat()}; // Array of six rolls for core stats
		
		System.out.println(getPlayerName() + " your rolls are: 1." + rolls[0] + ", 2." + rolls[1] + ", 3." + rolls[2] + ", 4." + rolls[3] + ", 5." + rolls[4] + ", and 6." + rolls[5]);
		int str = 0, dex = 0, intel = 0, cons = 0, wis = 0, cha = 0;
		// Loop if values are at any point equal - i.e value 1 is chosen for strength and dexterity
		while(str + dex + intel + cons + wis + cha != 21 || //  1+2+3+4+5+6 = 21, so first check is to see if it totals 21 - if not, likely wrong numbers
				str == dex || str == intel || str == cons || str == wis || str == cha || // Strength vs everything
				dex == intel || dex == cons || dex == wis || dex == cha ||// Dex vs everything else
				intel == cons || intel == wis || intel ==cha ||
				cons == wis || cons == cha ||
				wis == cha){
			System.out.print("Choose Strength: ");
			str = sc.nextInt();
			System.out.print("Choose Dexterity: ");
			dex = sc.nextInt();
			System.out.print("Choose Intellegence: ");
			intel = sc.nextInt();
			System.out.print("Choose Constitution: ");
			cons = sc.nextInt();
			System.out.print("Choose Wisdom: ");
			wis = sc.nextInt();
			System.out.print("Choose Charisma: ");
			cha = sc.nextInt();
		} // End the stupidly conditioned while
		
		// Use setters to set rolls
		setCharisma(rolls[cha-1]);
		setConstitution(rolls[cons-1]);
		setDexterity(rolls[dex-1]);
		setIntelligence(rolls[intel-1]);
		setStrength(rolls[str-1]);
		setWisom(rolls[wis-1]);
	} // end rollcorestats;		
	
	
}
