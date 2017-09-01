import java.awt.Color;

public class Main {

	// Main method
	public static void main(String[] args)throws java.io.IOException, InterruptedException {
		
		// Creates an EZ Graphics window of size 1024 x 768
		EZ.initialize(1024, 768);
		
		// Sets the background color to green - Jack
		EZ.setBackgroundColor(new Color(0, 100, 0));
		
		// Creates the word list - Jack
		Version3.createWordList();
		
		// Loads the game - Raven
		Version3.load();	
			
	}
}

