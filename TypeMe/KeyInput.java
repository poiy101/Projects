import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class KeyInput {
	
	// Used to determine which array slot to add the text in - Sae
	static int counter;
	
	//Create an Array List of Strings called nameInput
	public static ArrayList<String> nameInput;
	
	//Create an EZText[] called text
	public static EZText[] text;
	
	//Create a FileWriter called names
	public static FileWriter names;
	
	//Create a Boolean called loopRunning and set it to true
	public static Boolean loopRunning = true;
	
	public static void getName() throws IOException{
		
		//Create an ArrayList of type String called nameInput
		nameInput = new ArrayList<String>();
		
		//Get the x and y coordinates
		int x = EZ.getWindowWidth()/2 - 450;
		int y = EZ.getWindowHeight()/2 + 300;
		
		//Create an array of 1000 slots called text
		text = new EZText[1000];
		
		//Create an integer called counter and store 0 to it
		int counter = 0;
		
		//Set loopRunning to true
		loopRunning = true;
		
		//While loopRunning is true
		while (loopRunning){
			
			/*
			 * If the key 'a - z' was pressed, add the character to the keyinput arraylist
			 * add the text of the keyinput of counter to the text of counter
			 * make x = x + 15
			 * Increment counter
			 * Repeat for the rest of the characters on the keyboard 
			 * Sae/Jack
			 */
			if (EZInteraction.wasKeyPressed('a')){
				nameInput.add("a");
				text[counter] = EZ.addText(x, y, nameInput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('b')){
				nameInput.add("b");
				text[counter] = EZ.addText(x, y, nameInput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('c')){
				nameInput.add("c");
				text[counter] = EZ.addText(x, y, nameInput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('d')){
				nameInput.add("d");
				text[counter] = EZ.addText(x, y, nameInput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('e')){
				nameInput.add("e");
				text[counter] = EZ.addText(x, y, nameInput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('f')){
				nameInput.add("f");
				text[counter] = EZ.addText(x, y, nameInput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('g')){
				nameInput.add("g");
				text[counter] = EZ.addText(x, y, nameInput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('h')){
				nameInput.add("h");
				text[counter] = EZ.addText(x, y, nameInput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('i')){
				nameInput.add("i");
				text[counter] = EZ.addText(x, y, nameInput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('j')){
				nameInput.add("j");
				text[counter] = EZ.addText(x, y, nameInput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('k')){
				nameInput.add("k");
				text[counter] = EZ.addText(x, y, nameInput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('l')){
				nameInput.add("l");
				text[counter] = EZ.addText(x, y, nameInput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('m')){
				nameInput.add("m");
				text[counter] = EZ.addText(x, y, nameInput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('n')){
				nameInput.add("n");
				text[counter] = EZ.addText(x, y, nameInput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('o')){
				nameInput.add("o");
				text[counter] = EZ.addText(x, y, nameInput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('p')){
				nameInput.add("p");
				text[counter] = EZ.addText(x, y, nameInput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('q')){
				nameInput.add("q");
				text[counter] = EZ.addText(x, y, nameInput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('r')){
				nameInput.add("r");
				text[counter] = EZ.addText(x, y, nameInput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('s')){
				nameInput.add("s");
				text[counter] = EZ.addText(x, y, nameInput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('t')){
				nameInput.add("t");
				text[counter] = EZ.addText(x, y, nameInput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('u')){
				nameInput.add("u");
				text[counter] = EZ.addText(x, y, nameInput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('v')){
				nameInput.add("v");
				text[counter] = EZ.addText(x, y, nameInput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('w')){
				nameInput.add("w");
				text[counter] = EZ.addText(x, y, nameInput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('x')){
				nameInput.add("x");
				text[counter] = EZ.addText(x, y, nameInput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('y')){
				nameInput.add("y");
				text[counter] = EZ.addText(x, y, nameInput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed('z')){
				nameInput.add("z");
				text[counter] = EZ.addText(x, y, nameInput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			else if (EZInteraction.wasKeyPressed(' ')){
				nameInput.add(" ");
				text[counter] = EZ.addText(x, y, nameInput.get(counter), Color.BLACK, 24);
				x = x + 15;
				counter++;
			}
			
			// Checks if backspace is pressed
			else if (EZInteraction.wasKeyPressed('\b')){
				
				// If there are no elements in the array then nothing happens - Sae
				if (nameInput.size() == 0) {	
					counter = 0;
					x = EZ.getWindowWidth()/2 - 450;
				}
				// Else remove the previous letter - Sae
				else {
					nameInput.remove(counter - 1);
					EZ.removeEZElement(text[counter - 1]);
					counter--;
					x = x - 15;
				}
			}
			/*
			 * If enter key is pressed, then write the user's input to Names.txt, then hide the user's input on the screen - Sae
			 */
			else if (EZInteraction.wasKeyPressed('\n')){
				names = new FileWriter(new File("Names.txt"), true);
				loopRunning = false;
				for (int i = 0; i < nameInput.size(); i++) {
					names.write(nameInput.get(i));
				}
				//Write the name and score
				names.write(" " + Version3.score());
				names.write("\n");
				names.close();
				for (int i = 0; i < nameInput.size(); i ++){
					text[i].hide();
				}
				
				//Set menuScreen to 7 and show the Text
				Version3.showEnter.show();
				Version3.menuScreen = 7;
				
			}
			
			//Refresh the Screen
			EZ.refreshScreen();
			
		}//End of while loop
	}
	
	public static void hideName(){
		//for int i is 0 and i is less than keyinput.size(), increment i
		for (int i = 0; i < nameInput.size(); i ++){
			//hide text[i]
			text[i].hide();
		}
	}
}

