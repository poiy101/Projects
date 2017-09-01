import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.awt.Color;

/**
 * This class contains the third version of the memory game.
 * © COPYRIGHT  2015 V3.4
 * @author Jack Torres
 * @author Sae Hyun Song
 * @author Megan Kahalehili
 * @author Raven Robles
 */

public class Version3 {

	// Creates a String array wordArray which can hold 10,000 elements - Jack Torres
	static String[] wordArray = new String[10000];

	// Hold the EZ Graphics window width and height - Jack Torres
	private static final int windowWidth = 1024;
	private static final int windowHeight = 768;

	// Holds the mouse's x and y positions - Raven Robles
	private static int mouseX = 0;
	private static int mouseY = 0;

	// Used to display the player's score
	private static int score = 0;

	// Used to show the amount of lives remaining for the player
	private static int lives = 0;

	// Used to iterate a segment of code only once - Jack Torres
	private static int counter = 0;
	
	/*
	 * Create an integer called diff and store 0 to it
	 * Create an integer called sc1 and store 10 to it (EASY MODE MEMORIZATION TIMER)
	 * Create an integer called sc2 and store 11 to it (MEDIUM MODE MEMORIZATION TIMER)
	 * Create an integer called sc3 and store 12 to it (HARD MODE MEMORIZATION TIMER)
	 */
	private static int diff = 0;
	private static int sc1 = 10;
	private static int sc2 = 11;
	private static int sc3 = 12;
	
	// Indicates the difficulty that is selected - Raven Robles
	private static String difficulty;

	// Used for detecting user input - Jack Torres
	private static String input;

	/*
	 * Denotes the screen you are in. - Raven Robles 
	 * 0: Main menu 
	 * 1: Difficulty menu 
	 * 2: Easy difficulty
	 * 3: Medium difficulty
	 * 4: Hard difficulty
	 * 5: User input screen
	 * 6: Ran out of lives
	 * 7: Scoreboard
	 */
	public static int menuScreen = 0;

	/*
	 * Indicates the difficulty that is selected - Raven Robles 
	 * 0: None selected
	 * 1: Easy 
	 * 2: Medium 
	 * 3: Hard
	 */
	private static int difficultySelected = 0;

	// ArrayList for displaying the words on the screen - Jack Torres
	private static ArrayList<String> wordsonScreen = new ArrayList<String>();
	private static ArrayList<String> usersinput = new ArrayList<String>();

	// Used to convert the words in the array list to a string - Jack Torres
	private static String words = "";
	
	//Background Images - Jack
	private static EZImage titleBackground = EZ.addImage("title.jpg", windowWidth/2, windowHeight/2);
	private static EZImage difficultyBackground = EZ.addImage("difficulty.jpg", windowWidth/2, windowHeight/2);
	private static EZImage playingBackground = EZ.addImage("playing.jpg", windowWidth/2, windowHeight/2);
	private static EZImage guessingBackground = EZ.addImage("other.jpg", windowWidth/2, windowHeight/2);

	// Creates the play button on the main menu - Megan
	private static EZImage playButton = EZ.addImage("PlayButton.png", windowWidth / 2 + 200, 600);

	// Creates text to select a difficulty - Raven
	private static EZText selectDifficultyText = EZ.addText(windowWidth / 2, 100, "Select a Difficulty", Color.BLACK,
			96);

	// Creates text in the buttons that say the difficulty - Raven
	private static EZText easyText = EZ.addText(windowWidth / 4, 350, "Easy", Color.BLACK, 36);
	private static EZText mediumText = EZ.addText(windowWidth / 2, 350, "Medium", Color.BLACK, 36);
	private static EZText hardText = EZ.addText((3 * windowWidth) / 4, 350, "Hard", Color.BLACK, 36);

	// Creates rectangles which serve as the button to select difficulty - Raven 
	private static EZRectangle easyButton = EZ.addRectangle(windowWidth / 4, 350, 225, 100, Color.BLACK, false);
	private static EZRectangle mediumButton = EZ.addRectangle(windowWidth / 2, 350, 225, 100, Color.BLACK, false);
	private static EZRectangle hardButton = EZ.addRectangle((3 * windowWidth) / 4, 350, 225, 100, Color.BLACK, false);

	// Creates a start button - Raven
	private static EZRectangle startButton = EZ.addRectangle(windowWidth / 2, 550, 225, 100, Color.BLACK, false);
	private static EZText startText = EZ.addText(windowWidth / 2, 550, "START", Color.BLACK, 36);
	
	// Used to indicate if a user has not selected a difficulty - Raven
	private static EZText difficultyNotChosen = EZ.addText(windowWidth / 2, 450, "You have not selected a difficulty!", Color.BLACK, 24);

	// Creates a text which tells the user the game is starting when the paly button is pressed - Raven
	private static EZText startInThree;
	private static EZText startInTwo;
	private static EZText startInOne;

	// Creates text which displays the user's score - Sae
	private static EZText scoreboard = EZ.addText(windowWidth / 2 - 100, windowHeight / 2 - 300, "Score: " + score,
			Color.CYAN, 50);
	
	// Creates text which display the number of lives remaining - Raven
	private static EZText livesRemaining = EZ.addText(900, 725, "Lives: " + lives, Color.BLACK, 24);
	
	// Creates a rectangle which will hold the timer - Raven
	private static EZRectangle timerBox = EZ.addRectangle(900, 75, 225, 70, Color.BLACK, false);

	// Creates text which tells the user's final score - Sae
	public static EZText finalScore = EZ.addText(windowWidth / 2, 400, "Your final score was " + score + "!",
			Color.BLACK, 24);
	
	// Creates text to ask user to enter their name - Sae
	public static EZText enterName = EZ.addText(windowWidth/2, 450, "Enter your name!", Color.BLACK, 24);
	
	// Creates text to tell user to press the spacebar to go back to the main menu - Sae
	public static EZText backToMainMenu = EZ.addText(windowWidth / 2, 450, "Press spacebar to go back to the menu!" + "", Color.BLACK, 24);
	
	// Creates text to tell user to press the enter key to view your rank
	public static EZText showEnter = EZ.addText(windowWidth/2, 500, "Press 'Enter' to view your rank!", Color.BLACK, 24);
	
	// Creates text to show the standings in the scoreboard - Raven
	private static EZText firstPlace;
	private static EZText secondPlace;
	private static EZText thirdPlace;
	private static EZText fourthPlace;
	private static EZText fifthPlace;
	private static EZText sixthPlace;
	private static EZText seventhPlace;
	private static EZText eighthPlace;
	private static EZText ninthPlace;
	private static EZText tenthPlace;
	
	// Creates an array which holds the names in the scoreboard - Raven
	private static String[] names = new String[10];
	
	// Creates an array which holds the scores in the scoreboard - Raven
	private static int[] scores = new int[10];
	
	
	
	/**
	 * Reads from the list of 10000 words and sets the words into an array
	 * @throws FileNotFoundException
	 */
	public static void createWordList() throws FileNotFoundException {

		// Creates a scanner object which reads from wordlist.txt - Jack Torres
		Scanner scanner = new Scanner(new File("wordlist.txt"));
		// Declares an integer variable i with an initial value of 0 - Jack Torres
		int i = 0;
		// Runs while there is another token is detected in the wordlist.txt file - Jack Torres
		while (scanner.hasNext()) {

			// Assigns the next token to the "i"th index of wordArray - JackTorres
			wordArray[i] = scanner.next();
			// Increment i by 1 - Jack Torres
			i++;
		}
		
		// Close scanner - Jack Torres
		scanner.close();
	}

	/**
	 * Loads the graphics onto the EZ Graphics window
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public static void load() throws InterruptedException, IOException {

		// Added sound files - Megan
		// Sound for when a user clicks on a button
		EZSound keyClicked = EZ.addSound("keyClicked_converted.wav");
		// Background music
		EZSound backgroundMusic = EZ.addSound("backgroundMusic.wav");
		// Sound effect for correct answer
		EZSound correctSound = EZ.addSound("correctSound.wav");
		// Sound effect for incorrect answer
		EZSound incorrectSound = EZ.addSound("incorrectSound.wav");
		// Sound effect for countdown
		EZSound countdown = EZ.addSound("countdown.wav");

		// Play background music - Megan Kahalehili
		backgroundMusic.play();

		// Forever while loop
		while (true) {
			
			// Assign mouse positions to mouseX and mouseY - Raven Robles
			mouseX = EZInteraction.getXMouse();
			mouseY = EZInteraction.getYMouse();

			// Checks if left mouse button was pressed - Raven Robles
			if (EZInteraction.wasMouseLeftButtonPressed()) {
				
				keyClicked.play();// sound for button - Megan Kahalehili

				// Checks if play button is clicked - can only be executed if it
				// is on main menu - Raven Robles
				if (playButton.isPointInElement(mouseX, mouseY) && menuScreen == 0) {

					// Move to difficulty selection menu - Raven Robles
					menuScreen = 1;

				}

				// Checks if easy button is clicked - can only be executed if on difficulty selection screen - Raven Robles
				if (easyButton.isPointInElement(mouseX, mouseY) && menuScreen == 1) {

					difficultyNotChosen.hide();
					
					// Highlights easy button - Raven Robles
					easyButton.setColor(Color.YELLOW);
					mediumButton.setColor(Color.BLACK);
					hardButton.setColor(Color.BLACK);

					// Assign 1 to difficultySelected - Raven Robles
					difficultySelected = 1;

				}

				// Checks if medium button is clicked - can only be executed if on difficulty selection screen - Raven Robles
				else if (mediumButton.isPointInElement(mouseX, mouseY) && menuScreen == 1) {

					difficultyNotChosen.hide();
					
					// Highlights medium button - Raven Robles
					easyButton.setColor(Color.BLACK);
					mediumButton.setColor(Color.YELLOW);
					hardButton.setColor(Color.BLACK);

					// Assign 2 to difficultySelected - Raven Robles
					difficultySelected = 2;

				}

				// Checks if hard button is clicked - can only be executed if on difficulty selection screen - Raven Robles
				else if (hardButton.isPointInElement(mouseX, mouseY) && menuScreen == 1) {

					difficultyNotChosen.hide();
					
					// Highlights hard button - Raven Robles
					easyButton.setColor(Color.BLACK);
					mediumButton.setColor(Color.BLACK);
					hardButton.setColor(Color.YELLOW);

					// Assign 3 to difficultySelected - Raven Robles
					difficultySelected = 3;

				}

				// Check if start button was pressed - can only be executed if on difficulty selection screen - Raven Robles
				if (startButton.isPointInElement(mouseX, mouseY) && menuScreen == 1) {
					// Switch operator on the difficulty selected - Raven Robles
					switch (difficultySelected) {

					case 0:
						// Lets user know a difficulty is not chosen - Raven
						// Robles
						difficultyNotChosen.show();
						break;
					case 1:
						// Assign difficulty to easy - Raven Robles
						difficulty = "Easy";
						
						// Stop background music - Sae
						backgroundMusic.stop();
						
						// Play countdown sound - Sae
						countdown.play();
						
						// Indicates the game will start in 3 seconds - Raven
						startInThree = EZ.addText(windowWidth / 2, 700, "Game is starting in 3", Color.BLACK, 24);
						Thread.sleep(1000);
						startInThree.hide();

						// Indicates the game will start in 2 seconds - Raven
						startInTwo = EZ.addText(windowWidth / 2, 700, "Game is starting in 2", Color.BLACK, 24);
						Thread.sleep(1000);
						startInTwo.hide();

						// Indicates the game will start in 1 second - Raven
						startInOne = EZ.addText(windowWidth / 2, 700, "Game is starting in 1", Color.BLACK, 24);
						Thread.sleep(1000);
						startInOne.hide();
						
						// Plays background music - Megan
						backgroundMusic.play();

						// Set initial number of lives to 4 - Sae
						lives = 4;

						// Assign 2 to diff - Sae
						diff = 2;
						
						// Assign diff to menuScreen - Sae
						menuScreen = diff;

						break;
					case 2:
						// Assign "Medium" to difficulty - Raven Robles
						difficulty = "Medium";

						// Stop background music - Sae
						backgroundMusic.stop();
						
						// Play countdown sound - Sae
						countdown.play();
						
						// Indicates the game will start in 3 seconds - Raven
						startInThree = EZ.addText(windowWidth / 2, 700, "Game is starting in 3", Color.BLACK, 24);
						Thread.sleep(1000);
						startInThree.hide();

						// Indicates the game will start in 2 seconds - Raven
						startInTwo = EZ.addText(windowWidth / 2, 700, "Game is starting in 2", Color.BLACK, 24);
						Thread.sleep(1000);
						startInTwo.hide();

						// Indicates the game will start in 1 second - Raven
						startInOne = EZ.addText(windowWidth / 2, 700, "Game is starting in 1", Color.BLACK, 24);
						Thread.sleep(1000);
						startInOne.hide();

						// Play background music - Sae
						backgroundMusic.play();
						
						// Set initial number of lives to 3 - Sae
						lives = 3;

						// Assign 3 to diff - Sae
						diff = 3;

						// Assign diff to menuScreen - Sae
						menuScreen = diff;

						break;
					case 3:
						// Assign "Hard" to difficulty - Raven Robles
						difficulty = "Hard";

						// Stop background music - Sae
						backgroundMusic.stop();
						
						// Play countdown sound - Sae
						countdown.play();
						
						// Indicates the game will start in 3 seconds - Raven
						startInThree = EZ.addText(windowWidth / 2, 700, "Game is starting in 3", Color.BLACK, 24);
						Thread.sleep(1000);
						startInThree.hide();

						// Indicates the game will start in 2 seconds - Raven
						startInTwo = EZ.addText(windowWidth / 2, 700, "Game is starting in 2", Color.BLACK, 24);
						Thread.sleep(1000);
						startInTwo.hide();

						// Indicates the game will start in 1 second - Raven
						startInOne = EZ.addText(windowWidth / 2, 700, "Game is starting in 1", Color.BLACK, 24);
						Thread.sleep(1000);
						startInOne.hide();
						
						// Play background music
						backgroundMusic.play();

						// Set initial number of lives to 3 - Sae
						lives = 3;

						// Assign 4 to diff - Sae
						diff = 4;

						// Assign diff to menuScreen - Sae
						menuScreen = diff;
						
						break;

					} // End switch

				} // End if

			} // End of checking left mouse button

			// Checks if menuScreen is 0 - indicates user is on the main menu - Raven
			if (menuScreen == 0) {

				titleBackground.show();
				difficultyBackground.hide();
				playingBackground.hide();
				guessingBackground.hide();

				// Adds the play button - Megan Kahalehili
				playButton.show();

				// Hides the elements of the difficulty screen - Raven Robles
				selectDifficultyText.hide();
				easyText.hide();
				mediumText.hide();
				hardText.hide();
				easyButton.hide();
				mediumButton.hide();
				hardButton.hide();
				startButton.hide();
				startText.hide();
				difficultyNotChosen.hide();
				scoreboard.hide();
				livesRemaining.hide();
				timerBox.hide();

				finalScore.hide();
				backToMainMenu.hide();
				showEnter.hide();
				enterName.hide();

			} // End if statement

			// Checks if menuScreen is 1 - indicates user is on the difficulty - Raven
			else if (menuScreen == 1) {

				// Shows the elements of the difficulty screen - Raven Robles
				selectDifficultyText.show();
				easyText.show();
				mediumText.show();
				hardText.show();
				easyButton.show();
				mediumButton.show();
				hardButton.show();
				startButton.show();
				startText.show();

				// Hides the main menu - Megan Kahalehili
				titleBackground.hide();
				difficultyBackground.show();
				playingBackground.hide();
				guessingBackground.hide();
				playButton.hide();

			}

			// Checks if menuScreen is equal to diff - Sae
			else if (menuScreen == diff) {

				// Checks if menuScreen is equal to diff - Sae
				if (menuScreen == diff) {
					// Hides the elements of the difficulty screen - Raven
					titleBackground.hide();
					difficultyBackground.hide();
					playingBackground.show();
					guessingBackground.hide();
					selectDifficultyText.hide();
					easyText.hide();
					mediumText.hide();
					hardText.hide();
					easyButton.hide();
					mediumButton.hide();
					hardButton.hide();
					startButton.hide();
					startText.hide();
					difficultyNotChosen.hide();

					// Calls randomization function - Sae/Raven
					randomization();
					
					// Set the message of livesRemaining to "Lives " + lives - Raven
					livesRemaining.setMsg("Lives: " + lives);
					// show livesRemaining - Raven
					livesRemaining.show();
					
					// Set the message of scoreboard to "Score: " + score - Sae
					scoreboard.setMsg("Score: " + score);
					// Show the scoreboard - Sae
					scoreboard.show();
					
					// if counter is 0 - Jack Torres
					if (counter == 0) {
						// Add text add the words to memorize onto the middle of the screen - Jack Torres
						EZText wordsToMemorize = EZ.addText(windowWidth / 2, windowHeight / 2, words, Color.BLACK, 30);
						
						// Set the words to memorize to the random words picked out - Jack
						wordsToMemorize.setMsg(words);
						
						// Show the rectangle which holds the timer - Raven
						timerBox.show();
						
						// Start the countdown to memorize
						Timer.countdown(sc1);
						
						// hide wordsToMemorize - Jack Torres
						wordsToMemorize.hide();
						
						// Increment counter - Jack Torres
						counter++;
						
						// Set menuScreen to 5 - Sae
						menuScreen = 5;
					}
				} 
				
				// Checks if menuScreen is equal to 3
				else if (menuScreen == 3) {
					// Hides the elements of the difficulty screen - Raven
					selectDifficultyText.hide();
					selectDifficultyText.hide();
					titleBackground.hide();
					difficultyBackground.hide();
					playingBackground.show();
					guessingBackground.hide();
					easyText.hide();
					mediumText.hide();
					hardText.hide();
					easyButton.hide();
					mediumButton.hide();
					hardButton.hide();
					startButton.hide();
					startText.hide();
					difficultyNotChosen.hide();

					// Calls randomization function - Sae/Raven
					randomization();
					
					// Set the message of livesRemaining to "Lives " + lives - Raven
					livesRemaining.setMsg("Lives: " + lives);
					// show livesRemaining - Raven
					livesRemaining.show();
					
					// Set the message of scoreboard to "Score: " + score - Sae
					scoreboard.setMsg("Score: " + score);
					// Show the scoreboard - Sae
					scoreboard.show();
					
					// if counter is 0 - Jack Torres
					if (counter == 0) {
						
						// Add text add the words to memorize onto the middle of the screen - Jack Torres
						EZText wordsToMemorize = EZ.addText(windowWidth / 2, windowHeight / 2, words, Color.BLACK, 30);
						
						// Set the words to memorize to the random words picked out - Jack
						wordsToMemorize.setMsg(words);
						
						// Show the rectangle which holds the timer - Raven
						timerBox.show();
						
						// Start a countdown to memorize the words - Sae
						Timer.countdown(sc2);
						
						// hide wordsToMemorize - Jack Torres
						wordsToMemorize.hide();
						
						// Increment counter - Jack Torres
						counter++;
						
						// Set menuScreen to 5
						menuScreen = 5;
					}
				} else if (menuScreen == 4) {
					// Hides the elements of the difficulty screen - Raven
					selectDifficultyText.hide();
					titleBackground.hide();
					difficultyBackground.hide();
					playingBackground.show();
					guessingBackground.hide();
					easyText.hide();
					mediumText.hide();
					hardText.hide();
					easyButton.hide();
					mediumButton.hide();
					hardButton.hide();
					startButton.hide();
					startText.hide();
					difficultyNotChosen.hide();

					// Calls randomization function - Sae/Raven
					randomization();
					
					// Set the message of livesRemaining to "Lives " + lives - Raven
					livesRemaining.setMsg("Lives: " + lives);
					// show livesRemaining - Raven
					livesRemaining.show();
					
					// Set the message of scoreboard to "Score: " + score - Sae
					scoreboard.setMsg("Score: " + score);
					// Show the scoreboard - Sae
					scoreboard.show();
					
					// if counter is 0 - Jack Torres
					if (counter == 0) {
						// Add text add the words to memorize onto the middle of the screen - Jack Torres
						EZText wordsToMemorize = EZ.addText(windowWidth / 2, windowHeight / 2, words, Color.BLACK, 30);
						System.out.println(sc3);
						
						// Set the words to memorize to the random words picked out - Jack
						wordsToMemorize.setMsg(words);
						
						// Show rectangle which holds timer - Raven
						timerBox.show();

						// Start a countdown to hold the timer
						Timer.countdown(sc3);
						
						// hide wordsToMemorize - Jack Torres
						wordsToMemorize.hide();
						// Increment counter - Jack Torres
						counter++;
						
						// Set menuScreen to 5 - Sae
						menuScreen = 5;
					}
				}

			}

			// Checks if menuScreen is 5
			else if (menuScreen == 5) {
				// Creates a scanner object for user input into the console - Sae
				Scanner userinput = new Scanner(System.in);

				// Checks if counter is 1 - Sae
				if (counter == 1) {

					// Print to the screen "Enter the words that were on the screen!" - Sae Hyun Song
					EZText wos = EZ.addText(windowWidth / 2, windowHeight / 2 + 200,
							"Enter the words that were on the screen!", Color.BLACK, 30);

					// Allow user input for 15 seconds - Sae/Raven
					Input.getInput(15);
					
					// Creates a new scanner object which reads from Input.txt - Sae
					Scanner fr = new Scanner(new FileReader("Input.txt"));
					
					// Attempt to set input to the next token - Raven
					try {

						// Sets input to the next token - Sae
						input = fr.nextLine();

					}
					// Catch NoSuchElementException if it occurs - Raven
					catch (java.util.NoSuchElementException e) {

					} 
					// Closes the scanner regardless of what happens - Raven
					finally {
						
						// Closes the scanner - Sae
						fr.close();

					}

					// Create filewriter which writes to userinput.txt - Sae
					FileWriter fw = new FileWriter("userinput.txt");

					// Attempt to write the user's input to userinput.txt
					try {
						
						// Write the user's input - Sae
						fw.write(input);	
					}
					
					// Catch NullPointerException - Raven
					catch (java.lang.NullPointerException e) {

					} 
					// Closes the filewriter regardless of what happens - Raven
					finally {

						// Close filewriter - Sae
						fw.close();
					}

					// Scans from userinput.txt - Sae
					Scanner scanner = new Scanner(new File("userinput.txt"));

					// Runs while there is a token left in the userinput.txt file - Sae
					while (scanner.hasNext()) {
						// Add the tokens in usersinput.txt into an array - Sae
						usersinput.add(scanner.next());
					}
					
					// Close scanner - Sae
					scanner.close();

					// Checks if the words to memorize matches the users input - Sae
					if (wordsonScreen.toString().contentEquals(usersinput.toString())) {
						
						// Checks if easy difficulty - Sae
						if (diff == 2) {
							
							// Increase score by 1 - Sae
							score++;
							
							//If a score is a multiple of 3, decrement the time to memorize words (EASY)
							if (!(score == 0) && score % 3 == 0 && sc1 > 7) {
								sc1--;
							}
						}
						// Checks if medium difficulty - Sae
						else if (diff == 3) {
							
							// Increase score by 2 - Sae
							score = score + 2;
							
							// If a score is multiple of 6, decrement the time to memorize words (MEDIUM)
							if (!(score == 0) && score % 6 == 0 && sc2 > 5) {
								sc2--;
							}
						}
						// Checks if hard difficulty - Sae
						else if (diff == 4) {
							
							// Increase score by 3
							score = score + 3;
							
							// If a score is a multiple of 9 decrement the time to memorize words (HARD)
							if (!(score == 0) && score % 9 == 0 && sc3 > 5) {
								sc3--;
							}
							
						}
						

						// set message of scoreboard to "Score: " + score - Sae
						scoreboard.setMsg("Score: " + score);
						
						// Print to console the user got it correct - Sae
						System.out.println("You got it correct!");
						
						// stop the background music - Sae
						backgroundMusic.stop();
						// sound for correct answer - Megan Kahalehili
						correctSound.play();
						
						// Adds text which tells user they got it correct - Sae
						EZText correct = EZ.addText(windowWidth / 2, windowHeight / 2, "You got it correct!", Color.BLACK, 50);
						
						// Hides wos - Sae
						wos.hide();
						
						// Hides the timer - Raven Robles
						Input.hideTimer();
						timerBox.hide();
						
						// Start a 2 second countdown - Raven
						Timer.countdownNG(2);
						
						// Hides correct - Sae
						correct.hide();
						
						// Play background music - Megan
						backgroundMusic.play();
						
						// Clear the words on screen - Jack
						wordsonScreen.clear();
						
						// Clear the words - Jack
						words = "";
						
						// Clears usersinput - Jack
						usersinput.clear();
						
						// Closes userinput scanner - Sae
						userinput.close();
						
						// Clears input - Jack
						input = "";
						
						// Assign 0 to counter - Jack
						counter = 0;
						
						// Assign diff to menuScreen - Sae
						menuScreen = diff;
						
						//Hide the background
						titleBackground.hide();
						difficultyBackground.hide();
						playingBackground.hide();
						guessingBackground.hide();

					} else if (lives == 1) {
						
						// Decrement lives - Raven
						lives--;
						// Update the number of lives left - Raven
						livesRemaining.setMsg("Lives: " + lives);
						
						// Prints "You ran out of lives!" to console - Sae
						System.out.println("You ran out of lives!");
						
						// Stop background music - Megan
						backgroundMusic.stop();
						
						// Plays sound for incorrect answer - Megan
						incorrectSound.play();
						
						// Adds text which tells user that he/she has run out of lives - Sae
						EZText outoflives = EZ.addText(windowWidth / 2, windowHeight / 2, "You ran out of lives!", Color.BLACK, 50);
						
						// Hides wos - Sae
						wos.hide();
						
						// Hides the user's input - Sae
						Input.hideWords();
						
						// Hides the timer - Raven
						Input.hideTimer();
						timerBox.hide();
						
						// Start a 3 second countdown - Raven
						Timer.countdownNG(3);
						
						// Hides outoflives - Sae
						outoflives.hide();
						
						// Play background music - Megan
						backgroundMusic.play();
						
						// Clear wordsonScreen - Jack
						wordsonScreen.clear();
						
						// Clear words - Jack
						words = "";
						
						// Clears usersinput - Jack
						usersinput.clear();
						
						// Close userinput scanner - Sae
						userinput.close();
						
						// Clears input - Jack
						input = "";
						
						// Set counter to 0 - Jack
						counter = 0;
						
						// Set menuScreen to 6
						menuScreen = 6;

					} 
					// Checks if user ran out of time
					else if (Input.outOfTime()) {
						// Decrement lives by 1 - Raven
						lives--;
						// set the message of liveRemaining to "Lives: " + lives - Raven
						livesRemaining.setMsg("Lives: " + lives);
						
						// Prints to console "You ran out of time!" - Sae
						System.out.println("You ran out of time!");
						
						// Stops background music - Megan
						backgroundMusic.stop();
						
						// Plays sound for incorrect music - Megan
						incorrectSound.play();
						
						// Adds text that says "You ran out of time!" - Sae
						EZText outoftime = EZ.addText(windowWidth / 2, windowHeight / 2, "You ran out of time!", Color.BLACK, 50);
						
						// Hides wos - Sae
						wos.hide();
						
						// Hides the user's input - Sae
						Input.hideWords();
						
						// Hides the timer - Raven
						Input.hideTimer();
						timerBox.hide();
						
						// Start a 3 second countdown - Raven
						Timer.countdownNG(3);
						
						// Hides outoftime - Sae
						outoftime.hide();
						
						// Play background music - Megan
						backgroundMusic.play();
						
						// Clears wordsonScreen - Jack
						wordsonScreen.clear();
						
						// Clears words - Jack
						words = "";
						
						// Clears usersinput - Jack
						usersinput.clear();
						
						// Close userinput scanner - Sae
						userinput.close();
						
						// Clears input - Jack
						input = "";
						
						// Set counter to 0 - Jack
						counter = 0;
						
						//Hide the background
						titleBackground.hide();
						difficultyBackground.hide();
						playingBackground.hide();
						guessingBackground.hide();
						
						// Assign diff to menuScreen
						menuScreen = diff;
						
					} 
					// Checks if user's input does not match the wordsonScreen - Sae
					else if (!wordsonScreen.toString().contentEquals(usersinput.toString())) {
						// Decrement lives by 1 - Raven
						lives--;
						// set the message of liveRemaining to "Lives: " + lives - Raven
						livesRemaining.setMsg("Lives: " + lives);
						
						// Print to the console "You entered it incorrectly." - Sae
						System.out.println("You entered it incorrectly.");
						
						// Stop the background music - Megan
						backgroundMusic.stop();
						
						// sound for incorrect answer - Megan Kahalehili
						incorrectSound.play();
						
						// Create a text called wrong that prints to the screen "You got it wrong!" - Sae
						
						EZText wrong = EZ.addText(windowWidth / 2, windowHeight / 2, "You got it wrong!", Color.BLACK, 50);
						
						// hide wos - Sae
						wos.hide();
						// hide the typed words on the screen - Sae
						Input.hideWords();
						
						// Hides the timer - Raven
						Input.hideTimer();
						timerBox.hide();
						
						// Start a 3 second timer - Raven
						Timer.countdownNG(3);
						// hide the wrong text - Sae
						wrong.hide();
						
						// Play background music - Megan
						backgroundMusic.play();
						
						// Clear wordsonScreen - Jack
						wordsonScreen.clear();
						
						// Clear words - Jack
						words = "";
						
						// Clears usersinput - Jack
						usersinput.clear();
						
						// Close userinput scanner - Sae
						userinput.close();
						
						// Clear input - Jack
						input = "";
						
						// Assign 0 to counter
						counter = 0;
						
						//Hide the background
						titleBackground.hide();
						difficultyBackground.hide();
						playingBackground.hide();
						guessingBackground.hide();
						
						// Assign diff to menuScreen
						menuScreen = diff;
					}

				} // end counter == 1 if statement

			} // end menuScreen == 3

			// Checks if menuScreen is 6
			else if (menuScreen == 6) {
				
				// Hides show enter - Sae
				showEnter.hide();
				
				// Hides number of lives remaining - Sae
				livesRemaining.hide();
				
				// Hides scoreboard - Sae
				scoreboard.hide();

				// Hide the background
				titleBackground.hide();
				difficultyBackground.hide();
				playingBackground.hide();
				guessingBackground.show();
				
				// Show enterName - Sae
				enterName.show();
				
				// Sets the finalScore message and shows it - Sae
				finalScore.setMsg("Your final score was " + score + "!");
				finalScore.show();
				
				// Allows user input to get the user's name - Sae
				KeyInput.getName();
			
			} // End menuScreen = 6
			
			// Checks if menuScreen is 7
			else if (menuScreen == 7) {

				// Hides enterName - Sae
				enterName.hide();
				
				// Creates a scanner which reads from Names.txt - Raven
				@SuppressWarnings("resource")
				Scanner scanner = new Scanner(new File("Names.txt"));

				// Runs while there is a token in Names.txt
				while (scanner.hasNext()) {

					// For loop which runs from i = 0 to i < 10 - Raven
					for (int i = 0; i < names.length; i++) {

						// Attempts to put the next string and integer into an array - Raven
						try {
							
							// Puts the next String into "i"th slot of names
							names[i] = scanner.next();
							
							// Puts the next integer into "i"th slot of scores
							scores[i] = scanner.nextInt();
						}
						// Catch NoSuchElementException if it occurs
						catch (NoSuchElementException e) {
							
						}

					} // End for loop
					
				} // End while loop
				
				// Creates a boolean variable which determines whether to run the sort - Raven
				boolean runSort = true;

				// Creates a boolean variable which determines whether elements in an array has swapped - Raven
				boolean hasSwapped = false;

				// Runs if runSort is true - Raven
				while (runSort) {

					// Set runSort to false - Raven
					runSort = false;

					// Performs a reverse bubble sort (higher integers are first in the array) - Raven
					for (int i = 0; i < (scores.length) - 1; i++) {

						// Checks if the left element is less than the right element 
						if (scores[i] < scores[i + 1]) {

							// Swap scores - Raven
							int temp = scores[i];
							scores[i] = scores[i + 1];
							scores[i + 1] = temp;

							// Sets runSort to true - Raven
							runSort = true;

							// Sets hasSwapped to true - Raven
							hasSwapped = true;
						}

						// Checks if hasSwapped is true - Raven
						if (hasSwapped) {

							// Swaps the names - Raven
							String temp = names[i];
							names[i] = names[i + 1];
							names[i + 1] = temp;
							
							// Set hasSwapped to false - Raven
							hasSwapped = false;
						}

					}

				}
					
				// Checks if enter key was pressed
				if (EZInteraction.wasKeyPressed('\n')){
						
					// Shows backToMainMenu - Sae
					backToMainMenu.show();
					
					// Hides elements of the ran out of lives screen - Sae
					showEnter.hide();
					finalScore.hide();
					showEnter.hide();
					enterName.hide();
						
					// Displays the scoreboard - Raven
					firstPlace = EZ.addText(windowWidth/2, 100, "1. " + names[0] + " " + scores[0], Color.BLACK, 24);
					secondPlace = EZ.addText(windowWidth/2, 125, "2. " + names[1] + " " + scores[1], Color.BLACK, 24);
					thirdPlace = EZ.addText(windowWidth/2, 150, "3. " + names[2] + " " + scores[2], Color.BLACK, 24);
					fourthPlace = EZ.addText(windowWidth/2, 175, "4. " + names[3] + " " + scores[3], Color.BLACK, 24);
					fifthPlace = EZ.addText(windowWidth/2, 200, "5. " + names[4] + " " + scores[4], Color.BLACK, 24);
					sixthPlace = EZ.addText(windowWidth/2, 225, "6. " + names[5] + " " + scores[5], Color.BLACK, 24);
					seventhPlace = EZ.addText(windowWidth/2, 250, "7. " + names[6] + " " + scores[6], Color.BLACK, 24);
					eighthPlace = EZ.addText(windowWidth/2, 275, "8. " + names[7] + " " + scores[7], Color.BLACK, 24);
					ninthPlace = EZ.addText(windowWidth/2, 300, "9. " + names[8] + " " + scores[8], Color.BLACK, 24);
					tenthPlace = EZ.addText(windowWidth/2, 325, "10. " + names[9] + " " + scores[9], Color.BLACK, 24);
					
				}
				
				// Checks if spacebar is pressed - Sae
				if (EZInteraction.wasKeyPressed(' ')) {
						
					// Hides the scoreboard - Sae
					firstPlace.hide();
					secondPlace.hide();
					thirdPlace.hide();
					fourthPlace.hide();
					fifthPlace.hide();
					sixthPlace.hide();
					seventhPlace.hide();
					eighthPlace.hide();
					ninthPlace.hide();
					tenthPlace.hide();
					backToMainMenu.hide();
					finalScore.hide();
					
					// Resets the variables - Sae
					reset();
						
					}
					
			} // End menuScreen = 7
			
			// Refreshes EZ Graphics window - Raven Robles
			EZ.refreshScreen();
			
		} // End of forever while loop

	} // End of load function

	/**
	 * Picks a random number of words from the array list depending on difficulty. - Sae/Raven/Jack
	 */
	public static void randomization() {
		
		// for int i is 0 and i is less than 3 increment i - JAck
		for (int i = 0; i < 2 + difficultySelected; i++) {
			// Add to wordsonScreen (wordArray[1 + (int)(Math.random() * ((10000 - 1) + 1))]) - Jack
			wordsonScreen.add(wordArray[1 + (int) (Math.random() * ((10000 - 1) + 1))]);
		}

		// String variable to add the random words into the string - Jack Torres
		String first = "";

		// Adds the random words from the array list into words - Jack Torres
		for (int i = 0; i < wordsonScreen.size(); i++) {
			first = wordsonScreen.get(i) + " ";
			words = words + first;
		}
		// return the function - Sae
		return;
	}

	/**
	 * Resets variables that change throughout the game when a user wants to play again after he/she has lost. - Sae/Raven
	 */
	public static void reset() {
		
		// Resets the variables to its initial values - Sae/Raven
		menuScreen = 0;
		score = 0;
		lives = 0;
		counter = 0;
		diff = 0;
		sc1 = 10;
		sc2 = 11;
		sc3 = 12;

	}
	
	/**
	 * Returns the user's final score - Sae
	 * @return user's score
	 */
	public static int score(){
		
		return score;
	
	}

}