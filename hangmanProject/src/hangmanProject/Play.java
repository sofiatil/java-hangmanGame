package hangmanProject;
import java.util.ArrayList;
import java.util.Scanner;

public class Play {
	
	private static ArrayList<Character> wordArray;
	private static ArrayList<Character> testArray;
	private static int win; //number of wins
	private static int lost; //number of lost games
	private static int correctg;
		
	//constructor that gets a word and gives values to the stats
	public Play() {
		win =0;
		lost=0;
	}
	
	//creating of a random number & choosing a word from the Dictionary class
	public void newWord() {
		int randomN= RandomNumberGenerator.getRandomNumber();
		String word = Dictionary.getWord(randomN);
		wordArray=new ArrayList<>();
		testArray = new ArrayList<>();
		
		for(char c: word.toCharArray()) {
		wordArray.add(c);	
		testArray.add('-');
		}
		System.out.println("The game has started!");
	}
	
	public void guessLetter() {
		Scanner sc = new Scanner(System.in);	
		int correctletters=0;
		int guesses=8;
		correctg = 0;
		
		//loop of the game - checking if the player found the word or if its out of guesses
		while(guesses>0 && correctletters<wordArray.size()) {
			System.out.print("The random word is: " + testArray);
			System.out.println(" You have "+ guesses + " guess/es left.");
			System.out.println("Your guess: ");
			char letter = sc.next().charAt(0);
			
			//loop to check if the character that was inserted was a letter. if it was not a letter the user needs to add again an input
			while(Character.isLetter(letter)==false){
				System.out.println("Wrong input, please give me again your guess: ");
				letter = sc.next().charAt(0);			
			}
			
			int newletter=0;
			
			//checking for each letter in the array if the letter that the user guessed is correct
			for (int i=0; i<wordArray.size(); i++) {
				if(Character.toUpperCase(letter) == wordArray.get(i)) {
					//if the letter is correct then it checks if it has already been inserted from the user before
					//so it wont be counted twice as a correct input
					//it checks also if a letter is included twice in the word so it won't be counted as two correct answers
					
					if (wordArray.get(i) != testArray.get(i)) { //gets in the loop if the letter is not already added in the answer array (testArray) before
						testArray.set(i, Character.toUpperCase(letter));
						correctletters = correctletters +1; //its a counter that checks if all the letters have been found from the user
						newletter++; //counts how many new letters were found in this try
					}
				}
			}
			
			if (newletter == 0)guesses-=1;
			else if (newletter>=1)correctg++;
		}
		
		//counter for winning an loosing games
		if (guesses <= 0) {
			lost+=1;
			System.out.println("You lost. :( The word was: "+ wordArray);
		}else{
			win+=1;
			System.out.println("Congratulations! You guessed the word: "+ wordArray);
			System.out.println("You made " + correctg + " correct guesses and "+ (8-guesses) + " wrong guesses.");
		}	
		
	}
	
	//printing stats method
	public void printStats() {
		System.out.println("You played so far "+(win+lost)+" games. "+"You won "+ win +" times. "+"You lost "+ lost +" times.");	
	}
	
	//main menu method
	public char mainMenu() {
		System.out.println("MAIN MENU");
		System.out.println("	-Start a new Game (N)");
		System.out.println("	-Statistics (S)");
		System.out.println("	-Exit (E)");
		System.out.println("Please enter your choice:");
		Scanner scn=new Scanner(System.in);
		return Character.toUpperCase(scn.next().charAt(0));
	}
	
}
