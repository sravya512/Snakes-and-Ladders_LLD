import java.util.Scanner;

public class Player {

	private String name;
	private static Dice dice = new Dice();
	private boolean hasPowerup;
	private boolean hasDisadv;
	
	//Initialize the fields
	public Player(String name){
		this.name = name;
	}
	
	/**
	 * Sets hasPowerup to true
	 */
	public void earnPowerup(){
		this.hasPowerup = true;
		System.out.println(name + " earned powerup");
	}
	
	/**
	 * Sets hasDisadv to true
	 */
	public void earnDisadv(){
		this.hasDisadv = true;
		System.out.println(name + " has disadvantage");
	}
	
	
	/**
	 * This method plays out the player's turn.
	 * @return The number of spaces to move on the board.
	 */
	public int takeTurn(){
		
		//Initialize scanner
		Scanner scan = new Scanner(System.in);
		//Prompt user for roll
		System.out.print(name+"'s turn , please press enter to roll Dice: ");
		String input = scan.nextLine();
		
		
		//Translate the input to some numeric value between 1 and 9
		// int val = 0;
		// for (int idx = 0; idx < input.length(); idx++){
		// 	val+= input.charAt(idx);
        //     System.out.println(val+" "+ input+"  "+idx);
		// }
		// val = val % 10;
		// if (val == 0){
		// 	val = 1;
		// }
		
		//Throw away the next 'val' random values
		//for (int idx = 0; idx < val; idx++){
			//dice.rollD6();
		//}
		
		//Get the roll
		int roll = 0;
		if (hasPowerup){
			//If the player has the powerup, roll 2D6
			roll = dice.rollD6() + dice.rollD6();
			hasPowerup = false;
			System.out.print("Using powerup. ");
		} else if (hasDisadv){
			//If the player has disadvantage, then roll two
			//D6's and take the lower value
			int first = dice.rollD6();
			int second = dice.rollD6();
			
			if (first > second){
				roll = second;
			} else {
				roll = first;
			}
			hasDisadv = false;
			System.out.print("Using disadvantage. ");
		} 
        else {
			//Otherwise, roll normally
			 roll = dice.rollD6();
		}
		
		System.out.println(name + " rolled " + roll + ".");
		
		return roll;
	}
	
	
	public String toString(){
		return name;
	}
}