import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Input {
	
	// Used to determine which array slot to add the text in - Sae
	static int counter;
	
	// Used to display the time left on the clock - Raven Robles
	public static EZText timer;
	
	//Create a member variable of type EZText[] called text - Sae
	public static EZText[] text;
	
	//Create a member variable of type ArrayList<String> called keyinput - Sae
	public static ArrayList<String> keyinput;
	
	//Create a member variable of type int called timeleft - Raven
	public static int timeleft;
	
	/**
	 * Allows keyboard input from the user for the given amount of time
	 * @param s The number of seconds to allow keyboard input
	 * @throws IOException
	 */
	public static void getInput(int s) throws IOException {

		// Creates a String array list which will hold the user's key input - Sae
		keyinput = new ArrayList<String>();
		
		// Creates integer variables which hold where the user's input will be displayed - Sae
		int x = EZ.getWindowWidth()/2 - 450;
		int y = EZ.getWindowHeight()/2 + 300;
		
		// Set text to a 1000 slot array - Sae
		text = new EZText[1000];

		// Used to determine whether to run the loop or not - Sae
		boolean loopRunning = true;
		
		// Assign s to timeleft - Raven Robles
		timeleft = s;
		
		// Represents the last time the if statement was last executed - Raven
		long lastExecuted = System.currentTimeMillis();
		
		//Declare counter as an integer and assign 0 to it - Jack
		int counter = 0;	
		
		// Displays the current time left - Raven
		timer = EZ.addText(900, 75, "Timer: " + timeleft + " seconds", Color.BLACK, 24);
		
		// Runs while loopRunning is true - Sae
		while (loopRunning){
			
			// Creates a long integer which will contain the system's current time - Raven
			long current = System.currentTimeMillis();
			
			/* 
			 * If the current time and the time the if statement was last executed is greater than
			 * 1000 (1 second), then update the timer and decrement timeleft.  Then, assign the
			 * current system time to lastExecuted. - Raven Robles
			 */
			if (((current - lastExecuted) >= 1000) && timeleft != 2) {
				
				// Decrement timeleft - Raven
				timeleft--;
				// Update the timer to reflect the current time left - Raven
				timer.setMsg("Timer: " + (timeleft) + " seconds");
				// Set lastExecuted equal to the current system time - Raven
				lastExecuted = System.currentTimeMillis();
			}
			
			/*
			 * Checks if 1 second has passed between the currentTime and lastExecuted time.
			 * This is essentially the same as above, except it will display "Timer: 1 second"
			 * for grammatical purposes. - Raven
			 */
			if (((current - lastExecuted) > 1000) && timeleft == 2) {
				
				// Decrement timeleft - Raven
				timeleft--;
				// Update the timer to reflect the current time left
				timer.setMsg("Timer: " + (timeleft) + " second");
				// Set lastExecuted equal to the current system time - Raven
				lastExecuted = System.currentTimeMillis();
			}
			
			// Checks if timeleft is 0 - Raven
			else if (timeleft == 0) {
				// Stop running the loop - Raven
				loopRunning = false;
				// Hide the timer - Raven
				timer.hide();
				// Get out of the function - Raven
				return;
			}
			
			/*
			 * If the key 'a - z' was pressed, add the character to the keyinput arraylist
			 * add the text of the keyinput of counter to the text of counter
			 * make x = x + 15
			 * Increment counter
			 * Repeat for the rest of the characters on the keyboard 
			 * Sae/Jack
			 */
			if (EZInteraction.wasKeyPressed('a')){
				keyinput.add("a");
				text[counter] = EZ.addText(x, y, keyinput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('b')){
				keyinput.add("b");
				text[counter] = EZ.addText(x, y, keyinput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('c')){
				keyinput.add("c");
				text[counter] = EZ.addText(x, y, keyinput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('d')){
				keyinput.add("d");
				text[counter] = EZ.addText(x, y, keyinput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('e')){
				keyinput.add("e");
				text[counter] = EZ.addText(x, y, keyinput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('f')){
				keyinput.add("f");
				text[counter] = EZ.addText(x, y, keyinput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('g')){
				keyinput.add("g");
				text[counter] = EZ.addText(x, y, keyinput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('h')){
				keyinput.add("h");
				text[counter] = EZ.addText(x, y, keyinput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('i')){
				keyinput.add("i");
				text[counter] = EZ.addText(x, y, keyinput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('j')){
				keyinput.add("j");
				text[counter] = EZ.addText(x, y, keyinput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('k')){
				keyinput.add("k");
				text[counter] = EZ.addText(x, y, keyinput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('l')){
				keyinput.add("l");
				text[counter] = EZ.addText(x, y, keyinput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('m')){
				keyinput.add("m");
				text[counter] = EZ.addText(x, y, keyinput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('n')){
				keyinput.add("n");
				text[counter] = EZ.addText(x, y, keyinput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('o')){
				keyinput.add("o");
				text[counter] = EZ.addText(x, y, keyinput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('p')){
				keyinput.add("p");
				text[counter] = EZ.addText(x, y, keyinput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('q')){
				keyinput.add("q");
				text[counter] = EZ.addText(x, y, keyinput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('r')){
				keyinput.add("r");
				text[counter] = EZ.addText(x, y, keyinput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('s')){
				keyinput.add("s");
				text[counter] = EZ.addText(x, y, keyinput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('t')){
				keyinput.add("t");
				text[counter] = EZ.addText(x, y, keyinput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('u')){
				keyinput.add("u");
				text[counter] = EZ.addText(x, y, keyinput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('v')){
				keyinput.add("v");
				text[counter] = EZ.addText(x, y, keyinput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('w')){
				keyinput.add("w");
				text[counter] = EZ.addText(x, y, keyinput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('x')){
				keyinput.add("x");
				text[counter] = EZ.addText(x, y, keyinput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('y')){
				keyinput.add("y");
				text[counter] = EZ.addText(x, y, keyinput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('z')){
				keyinput.add("z");
				text[counter] = EZ.addText(x, y, keyinput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed(' ')){
				keyinput.add(" ");
				text[counter] = EZ.addText(x, y, keyinput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			
			// Checks if no time left - Sae
			else if (timeleft == 0) {
				// Stop running the loop
				loopRunning = false;
				// Writes user's input to input.txt - Sae
				FileWriter fw = new FileWriter(new File("input.txt"));
				for (int i = 0; i < keyinput.size(); i++){
					fw.write(keyinput.get(i));
				}
				// Close filewriter - Sae
				fw.close();
			}
			
			// Checks if backspace is pressed
			else if (EZInteraction.wasKeyPressed('\b')){
				
				// If there are no elements in the array then nothing happens - Sae
				if (keyinput.size() == 0) {	
					counter = 0;
					x = EZ.getWindowWidth()/2 - 450;
				}
				// Else remove the previous letter - Sae
				else {
					keyinput.remove(counter - 1);
					EZ.removeEZElement(text[counter - 1]);
					counter--;
					x = x - 15;
				}
			}
			
			/*
			 * If enter key is pressed, then write the user's input to input.txt, then hide the user's input on the screen - Sae
			 */
			else if (EZInteraction.wasKeyPressed('\n')){
				loopRunning = false;
				FileWriter fw = new FileWriter(new File("input.txt"));
				for (int i = 0; i < keyinput.size(); i++) {
					fw.write(keyinput.get(i));
				}
				fw.close();
				for (int i = 0; i < keyinput.size(); i ++){
					text[i].hide();
				}
				
			}
			
			//Refresh the Screen
			EZ.refreshScreen();
			
		} // End of while loop

	}
	/**
	 * Hides the user's input after their response is entered.
	 */
	public static void hideWords(){
		//for int i is 0 and i is less than keyinput.size(), increment i
		for (int i = 0; i < keyinput.size(); i ++){
			//hide text[i]
			text[i].hide();
		}
		
	}
	/**
	 * Hides the timer.
	 */
	public static void hideTimer() {
		//hide timer
		timer.hide();
	}
	
	/**
	 * Checks if there was no time left on the timer - Raven
	 * @return true if there was no time left. Returns false otherwise.
	 */
	public static boolean outOfTime() {
		// Checks if timeleft is 0
		if (timeleft == 0){
			// Return true
			return true;
		}
		// Else return false
		else {
			return false;
		}
	}
	
}	