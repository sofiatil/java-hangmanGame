package hangmanProject;
import java.util.Random;

public class RandomNumberGenerator {
	
			public static int getRandomNumber() {
			   	// Create a Random object
		        Random random = new Random();
		        // Generate a random integer between 0 (inclusive) and 100 (exclusive)
		        return random.nextInt(100);
			}	
}
