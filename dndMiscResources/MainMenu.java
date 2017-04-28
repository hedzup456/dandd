package dndMiscResources;

import java.util.Scanner;

public class MainMenu {
	private static void savePC(PlayerCharacter pc){
		// Act as in between for FO class and main class
		FileOperations fo = new FileOperations();
		String pN = pc.getPlayerName(); // Get the player name from the object, no point in passing it as an argument.
		if (fo.pcExists(pN)) fo.writePCToFile(pc); 	// If it exists, overwrite the existing version.
		else{ 										// Else create it then save it
			fo.createFile(pN);
			fo.writePCToFile(pc);
		}
	}
	
	public static PlayerCharacter loadPC(String pN) {
		// Act as in between for FO class and main class
		FileOperations fo = new FileOperations();
		PlayerCharacter toReturn;
		if (fo.pcExists(pN)) toReturn = fo.readPCFromFile(pN);
		else{
			System.out.println("Character not found.");
			toReturn = new PlayerCharacter();
		}
		return toReturn;
	}
	
	private static void list(){
		FileOperations fo = new FileOperations();
		fo.listExisting();
		
	}
	
	private static PlayerCharacter createPC(Scanner sc, String pName){
		// Create a new player using scanner and a name passed as input
		PlayerCharacter newPC = new PlayerCharacter(pName);
		System.out.print("Character name: ");
		newPC.setName(sc.nextLine());
		System.out.print("Character alignment: ");
		newPC.setAlignment(sc.nextLine());
		System.out.print("Character class: ");
		newPC.setPCClass(sc.nextLine());
		System.out.print("Character race: ");
		newPC.setRace(sc.nextLine());
		
		switch(newPC.getRace()){ // Set speed and size
		case "Gnome":
			newPC.setSpeed(20);
			newPC.setSize('S');
			break;
		case "Dwarf":
			newPC.setSpeed(20);
			newPC.setSize('S');
			break;
		case "Halfling":
			newPC.setSpeed(20);
			newPC.setSize('S');
			break;
		case "Human":
			newPC.setSpeed(30);
			newPC.setSize('M');
			break;
		case "Elf":
			newPC.setSpeed(30);
			newPC.setSize('M');
			break;
		case "Half-elf":
			newPC.setSpeed(30);
			newPC.setSize('M');
			break;
		case "Half-orc":
			newPC.setSpeed(30);
			newPC.setSize('M');
			break;
		}
		newPC.rollCoreStats(sc); // Run the method to roll core statistics
		
		return newPC;
	} // createPC
	
	private static void characterInterface(Scanner sc){
		PlayerCharacter currentPC = null; // Declare ready for loading and manipulating later
		
		System.out.println("1. Create new player.\n2. Load existing player.\n3. Display the loaded player.\n4. Edit the loaded player.\n5. Save the loaded player.\n6. Quit to main menu.");
		int menuChoice = sc.nextInt();
		sc.nextLine(); // Purge keyboard buffer
		while(menuChoice != 6){ // While the user wants to do something. 
			switch (menuChoice){ 	// Best 
				case 1: // Create new
					System.out.print("Enter your name: ");
					currentPC = createPC(sc, sc.nextLine());
					break;
				case 2: // Load existing
					list();
					System.out.print("Enter your name, to load your character: ");
					currentPC = loadPC(sc.nextLine());
					break;
				case 3: // Display loaded
					if(!currentPC.getName().equals("")){ // If the name isn't the default
						System.out.println("Name: " + currentPC.getName());
						System.out.println("Race and class: " + currentPC.getRace() + ", " + currentPC.getPCClass());
						System.out.println("Alignment: " + currentPC.getAlignment());
						System.out.println("Size and speed: " + currentPC.getSize() + ", " + currentPC.getSpeed());
						System.out.println("Core stats (Str, Dex, Cons, Int, Wis, Char): " + currentPC.getStrength() + ", " + currentPC.getDexterity() + 
								", " + currentPC.getConstitution() + ", " + currentPC.getIntelligence() + ", " + currentPC.getWisdom() + ", " + currentPC.getCharisma());
						System.out.println("PName: " + currentPC.getPlayerName());
					}
					break;
				case 4: // Edit loaded
					System.out.println("Editing " + currentPC.getName());
					// TODO add editing stuff
					// TODO seriously, add editing stuff
					break;
				case 5: // Save
					System.out.println("Saving...");
					savePC(currentPC);
					break;
				case 6: // Quit
					break; // Actual breaking of loop is done in loop condition.
				default:
					System.out.println("That's not a valid choice, you muffin.");
					break;
			} // switch
			System.out.println("1. Create new player.\n2. Load existing player.\n3. Display the loaded player.\n4. Edit the loaded player.\n5. Save the loaded player.\n6. Quit to main menu.");
			menuChoice = sc.nextInt();
			sc.nextLine(); // Purge kb buffer
		}
	}
	
	private static void dieInterface(Scanner sc){
		sc.nextLine(); // To clear buffer
		System.out.print("Enter what to roll (in the form nDr): ");
		String dieCode = sc.nextLine().toUpperCase();
		System.out.println("Rolling " + dieCode);
		DieRoller dr = new DieRoller();
		System.out.println(dr.nDr(dieCode));
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // Declare one scanner used by all sections
		System.out.println("Welcome to Richard's super amazing DnD tool and/or extreme mini-project.");
		System.out.println("What would you like to do today? ");
		System.out.println("1. Manage characters\n2. Roll die");
		int menuChoice = sc.nextInt();
		
		while (menuChoice != 3 && menuChoice <=3 && menuChoice >= 1){ // While valid choice
			switch (menuChoice){
			case 1: // if character manager is selected 
				characterInterface(sc);
				break;
			case 2: // if die roller
				dieInterface(sc);
				break;
			default:
				System.out.println("That's not a valid choice, you muffin.");
				break;
			}
			System.out.println("What would you like to do now? ");
			System.out.println("1. Manage characters\n2. Roll die\n3. Quit");
			menuChoice = sc.nextInt();
		}
		
		
		 // End program lol
		System.out.println("Kthxbye");
	}

}
