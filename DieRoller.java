package dndMiscResources;

import java.util.Random;

public class DieRoller {
	private int rollDie(int sides){
		Random random = new Random();
		return random.nextInt(sides)+1;
	} // rollDie
	
	public int rollACoreStat(){
		int[] rolls = {rollDie(6), rollDie(6), rollDie(6), rollDie(6)};
		int smallest, smallestIndex = 100, total = 0;
		smallest = Integer.MAX_VALUE;
		for (int i = 0; i < 4; i++){ // determine the smallest value
			if(rolls[i] < smallest){
				smallest = rolls[i];
				smallestIndex = i;
			} // if	
		}
		
		for(int i = 0; i < 4; i++){ // find the total of the three highest rolls
			if(i != smallestIndex) total += rolls[i];
		}
		return total;
	} // roll a core stat
	
	public int nDr(int sides, int die){ // Rolls die given sides and number of die to roll
		if (sides < 2 || die < 1) return 0;
		int total = 0;
		for(int i = 0; i < die; i++){
			total += rollDie(sides);
		}
		return total;
	} // nDr - sides and die
	
	public int nDr(String dieCode){ // Rolls die given a die code
		dieCode = dieCode.toLowerCase();
		String[] dieArray= dieCode.split("d");
		int sides, numberOf;
		try{
			sides = Integer.parseInt(dieArray[1]);
			numberOf = Integer.parseInt(dieArray[0]);
		} catch (NumberFormatException e){
			System.out.println("Invalid die code");
			return -1;
		} catch (IndexOutOfBoundsException e){
			sides = Integer.parseInt(dieArray[0]);
			numberOf = 1;
		}
		
		return nDr(sides, numberOf);
	} // nDr - dieCode
} // DieRoller
