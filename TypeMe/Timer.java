import java.awt.Color;
/**
 * Contains a timer which will run when the user is prompted to memorize a
 * set of words, and after the user inputs the words.
 * @author Raven Robles
 *
 */
public class Timer {
	
	// Declares timer of type EZText which is used to display the amount of time left - Raven
	private static EZText timer;
	
	/**
	 * Creates a timer which will graphically display and update the amount of time left after 
	 * every second. - Raven
	 * @param s The number of seconds to let the timer run
	 */
	public static void countdown(int s) {
		
		// Declares a long variable lastExecuted which is assigned the system's current time - Raven
		long lastExecuted = System.currentTimeMillis();
		
		// Declares an integer timeleft which is assigned the integer passed in the parameter s - Raven
		int timeleft = s;
		
		// Displays a graphical timer which shows the amount of time left - Raven
		timer = EZ.addText(900, 75, "Timer: " + timeleft + " seconds", Color.BLACK, 24);
		
		// While loop that runs forever - Raven
		while (true) {
			
			// Constantly update the system's current time to currentTime - Raven
			long currentTime = System.currentTimeMillis();
			
			/*
			 *  Checks if 1 second has passed between the currentTime and the lastExecuted time.
			 *  If so, it will decrement timeleft and update the graphical timer to reflect the
			 *  correct amount of time left. - Raven
			 */
			if ((currentTime - lastExecuted) > 1000 && timeleft != 2) {
				
				// Decrements timeleft - Raven
				timeleft--;
				// Updates the timer to reflect the current time left - Raven
				timer.setMsg("Timer: " + timeleft + " seconds");
				// Assign the current system time to lastExecuted - Raven
				lastExecuted = System.currentTimeMillis();
				
			}
			/*
			 *  Checks if 1 second has passed between the currentTime and lastExecuted time.
			 *  This is essentially the same as above, except it will display "Timer: 1 second"
			 *  for grammatical purposes. - Raven
			 */
			else if ((currentTime - lastExecuted) > 1000 && timeleft == 2) {
				
				// Decrements timeleft - Raven
				timeleft--;
				// Updates the timer to reflect that there is 1 second left - Raven
				timer.setMsg("Timer: " + timeleft + " second");
				// Assign the current system time to lastExecuted - Raven
				lastExecuted = System.currentTimeMillis();
			}
			
			/*
			 *  If there is no time left on the timer, then the timer is hidden and the while loop
			 *  stops running. - Raven
			 */
			else if (timeleft == 0) {
				
				// Hides the timer - Raven
				timer.hide();
				// Breaks out of the while loop - Raven
				break;
			} // End timeleft == 0
			
		} // End while loop
		
	} // End countdown method
	
	
	/**
	 * Starts a countdown timer. Unlike the method above, this does not display a graphical 
	 * timer. (NG means no graphics.) - Raven
	 * @param s The number of seconds to let the timer run
	 */
	public static void countdownNG(int s) {
		
		// Assigns the current system time to lastExecuted - Raven
		long lastExecuted = System.currentTimeMillis();
		
		// Declares an integer timeleft which is assigned the integer passed in the parameter s - Raven
		int timeleft = s;
		
		// While loop that runs forever - Raven
		while (true) {
			
			// Constantly update the system's current time to currentTime - Raven
			long currentTime = System.currentTimeMillis();
			
			/*
			 * If one second has passed between the currentTime and the lastExecuted time and
			 * if there is still time left, then decrement timeleft - Raven
			 */
			if ((currentTime - lastExecuted) > 1000 && timeleft != 0) {
				
				// Decrement timeleft - Raven
				timeleft--;
				// Assign the current system time to lastExecuted - Raven
				lastExecuted = System.currentTimeMillis();
			}
			
			/*
			 *  If there is no time left, then break out of the while loop. - Raven
			 */
			else if (timeleft == 0) {
				
				// Breaks out of the while loop - Raven
				break;
				
			} // End timeleft == 0
			
		} // End forever while loop
		
	} // End countdownNG method

} // End timer class
