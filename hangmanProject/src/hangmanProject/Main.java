package hangmanProject;

public class Main {

	public static void main(String[] args) {
		
		//creating new game
		Play game1 = new Play();
		
		//a loop that keeps us in the game until we ask to terminate it
		boolean play = true;
		while(play){				
			//creating new word
			game1.newWord();		
			//starting game & playing
			game1.guessLetter();
			//opening main menu
			//stays in the loop as long as the player don't choose exit or play a new game
			while (true) {
				char x = game1.mainMenu();
				if (x=='S') {
					game1.printStats();
				}
				else  if(x=='E') {
					play = false;
					break;
				}else if (x=='N') {
					break;
				}else
					System.out.println("Wrong input. Please try again.");
			}
		}
		System.out.println("Game has bee terminated. Thank you for playing!");
	}
}