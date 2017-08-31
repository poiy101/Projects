/********************************************************************************************************
 * 
 * NAME:				Sae Hyun Song
 * 						Raven Robles
 * 						Lee Ann Cauilan
 * 
 * 
 * HOMEWORK:			Group Project - Minesweeper
 * 
 * CLASS:				ICS 211
 * 
 * INSTRUCTOR:			Scott Robertson
 * 
 * DATE:				May 4, 2016
 * 
 * FILE:				MineSweeper.java
 * 
 * DESCRIPTION:			This class contains the GUI and methods needed to run the MineSweeper program.
 *
 *******************************************************************************************************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
	Grid grid = new Grid(0,0);
	private ArrayList<Integer> begScores, mediumScores, hardScores;
	private JFrame highFrame, frame;
	private JPanel highPanel, panel = new JPanel();
	private JLabel easy, medium, hard, scores, timerText = new JLabel();
	private JButton btnBeginner = new JButton("Beginner");
	private JButton btnMedium = new JButton("Medium");
	private JButton btnHard = new JButton("Hard");
	private JButton btnReset = new JButton("Reset");
	private JButton btnScore = new JButton("High Score");
	private JButton chngDiff = new JButton("Change Difficulty");
	private int height, width, mines, timer, pressedbuttons, totalbuttons, flagsRemaining = 0;
	private javax.swing.Timer time;
	int frameW = 483;
	int frameH = 575;
	
	/****************************************************************************************************
	 * 
	 * Method:			main
	 * 
	 * Description:		Launches the MineSweeper program.
	 * 
	 * @param 			args the command line arguments
	 * 
	 * @return			None
	 * 
	 ***************************************************************************************************/

	public static void main(String[] args) {
		MineSweeper mine = new MineSweeper();
		mine.frame.setVisible(true);
	}
	
	/****************************************************************************************************
	 * 
	 * Method:			MineSweeper
	 * 
	 * Description:		Constructor which will start up the MineSweeper program.
	 * 
	 * @param			None
	 * 
	 * @return			None
	 * 
	 ***************************************************************************************************/
	
	public MineSweeper(){
		initialize();
	}
	
	/****************************************************************************************************
	 * 
	 * Method:			initialize
	 * 
	 * Description:		Creates the window and panels for the program and sets it to the difficulty
	 * 					selection screen.
	 * 
	 * @param			None
	 * 
	 * @return			None
	 * 
	 ***************************************************************************************************/
	
	public void initialize(){
		height = 0;
		width = 0;
		mines = 0;
		
		begScores = new ArrayList<>();
		mediumScores = new ArrayList<>();
		hardScores = new ArrayList<>();
		
		frame = new JFrame();
		frame.setTitle("MINE SWEEPER");
		frame.setBounds(0, 0, frameW, frameH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		btnBeginner.setBounds(frameW/2 - 50, frameH/2 - 200, 100, 100);
		btnBeginner.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		btnBeginner.addActionListener(new easyButton());

		btnMedium.setBounds(frameW/2 - 50, frameH/2 - 100, 100, 100);
		btnMedium.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		btnMedium.addActionListener(new mediumButton());
		
		btnHard.setBounds(frameW/2 - 50, frameH/2 + 0, 100, 100);
		btnHard.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		btnHard.addActionListener(new hardButton());
		
		btnScore.setBounds(frameW/2 - 50, frameH/2 + 100, 100, 100);
		btnScore.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		btnScore.addActionListener(new highScoreButton());
		
		btnReset.setBounds(200, 490, 60, 40);
		btnReset.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		btnReset.addActionListener(new resetButton());
		btnReset.setEnabled(false);
		btnReset.hide();
		
		chngDiff.setBounds(200, 490, 60, 40);
		chngDiff.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		chngDiff.addActionListener(new changeDifficulty());
		chngDiff.setEnabled(false);
		chngDiff.hide();
		
		panel.setBounds(0, 0, frameW, frameH);
		panel.setLayout(null);
		panel.add(btnBeginner);
		panel.add(btnMedium);
		panel.add(btnHard);
		panel.add(btnReset);
		panel.add(btnScore);
		panel.add(chngDiff);
	}

	private class easyButton implements ActionListener{
		
		/************************************************************************************************
		 * 
		 * Method:		actionPerformed
		 * 
		 * Description:	Loads the easy difficulty when the easy button is clicked.
		 * 
		 * @param		e the event when the button is left clicked 
		 * 
		 * @return		None
		 * 
		 ***********************************************************************************************/
		
		public void actionPerformed(ActionEvent e) {
			height = 10;
			width = 10;
			pressedbuttons = 0;
			totalbuttons = height * width;
			grid = new Grid(height, width);
			frame.setSize(320, 400);
			hideButtons();
			for (int i = 0; i < height; i++){
				for (int j = 0; j < width; j++){
					grid.setButton(i, j, new JToggleButton());
					grid.getButton(i, j).setSize(32,32);
					grid.getButton(i, j).setLocation(j*575/18, i*575/18);
					grid.getButton(i, j).addMouseListener(tButton);
					panel.add(grid.getButton(i, j));
				}
			}
			setMines();
			setValues();
			
			btnReset.setVisible(true);
			btnReset.setEnabled(true);
			btnReset.setBounds(130, 333, 60, 40);
			
			chngDiff.setVisible(true);
			chngDiff.setEnabled(true);
			chngDiff.setBounds(195, 333, 120, 40);
			
			startTimer();
		}
	}

	private class mediumButton implements ActionListener{
		
		/************************************************************************************************
		 * 
		 * Method:		actionPerformed
		 * 
		 * Description:	Loads the medium difficulty when the medium button is clicked.
		 * 
		 * @param		e the event when the button is left clicked 
		 * 
		 * @return		None
		 * 
		 ***********************************************************************************************/
		
		public void actionPerformed(ActionEvent e) {
			height = 15;
			width = 15;
			pressedbuttons = 0;
			totalbuttons = height * width;
			grid = new Grid(height, width);
			hideButtons();
			for (int i = 0; i < height; i++){
				for (int j = 0; j < width; j++){
					grid.setButton(i, j, new JToggleButton());
					grid.getButton(i, j).setSize(32,32);
					panel.add(grid.getButton(i, j));
					grid.getButton(i, j).setLocation(j*575/18, i*575/18);
					grid.getButton(i, j).addMouseListener(tButton);
				}
			}
			setMines();
			setValues();
			
			btnReset.setVisible(true);
			btnReset.setEnabled(true);
			btnReset.setBounds(200, 490, 60, 40);
			
			chngDiff.setVisible(true);
			chngDiff.setEnabled(true);
			chngDiff.setBounds(350, 490, 120, 40);
			
			startTimer();
		}
	}
	
	private class hardButton implements ActionListener{
		
		/************************************************************************************************
		 * 
		 * Method:		actionPerformed
		 * 
		 * Description:	Loads the hard difficulty when the hard button is clicked.
		 * 
		 * @param		e the event when the button is left clicked 
		 * 
		 * @return		None
		 * 
		 ***********************************************************************************************/
		
		public void actionPerformed(ActionEvent e) {
			height = 20;
			width = 20;
			pressedbuttons = 0;
			totalbuttons = height * width;
			grid = new Grid(height, width);
			frame.setSize(frameW + 155, frameH + 200);
			hideButtons();
			for (int i = 0; i < height; i++){
				for (int j = 0; j < width; j++){
					grid.setButton(i, j, new JToggleButton());
					grid.getButton(i, j).setSize(32,32);
					panel.add(grid.getButton(i, j));
					grid.getButton(i, j).setLocation(j*575/18, i*575/18);
					grid.getButton(i, j).addMouseListener(tButton);
				}
			}
			setMines();
			setValues();
			
			btnReset.setVisible(true);
			btnReset.setEnabled(true);
			btnReset.setBounds(290, 645, 60, 40);
			
			chngDiff.setVisible(true);
			chngDiff.setEnabled(true);
			chngDiff.setBounds(500, 645, 120, 40);
			
			startTimer();
		}
	}
	
	private class highScoreButton implements ActionListener{

		/************************************************************************************************
		 * 
		 * Method:		actionPerformed
		 * 
		 * Description:	Loads the High Scores when the highscore button is clicked
		 * 
		 * @param		e the event when the button is left clicked 
		 * 
		 * @return		None
		 * 
		 ***********************************************************************************************/
		
		public void actionPerformed(ActionEvent e){
			highPanel = new JPanel();
			highFrame = new JFrame();
			highFrame.setTitle("HIGH SCORES");
			highFrame.setBounds(500, 0, 300, 400);
			highFrame.setDefaultCloseOperation(highFrame.HIDE_ON_CLOSE);
			highFrame.setVisible(true);
			highFrame.add(highPanel);
			
			easy = new JLabel();
			easy.setText("EASY");
			easy.setBounds(45, 10, 50, 50);
			easy.setVisible(true);
			
			medium = new JLabel();
			medium.setText("MEDIUM");
			medium.setBounds(125, 10, 100, 50);
			medium.setVisible(true);
			
			hard = new JLabel();
			hard.setText("HARD");
			hard.setBounds(225, 10, 100, 50);
			hard.setVisible(true);
			
			highPanel.setBounds(0, 0, frameW, frameH);
			highPanel.setLayout(null);
			highPanel.add(easy);
			highPanel.add(medium);
			highPanel.add(hard);
			highPanel.setVisible(true);
			readHighScores();
			
			int y = 30;
			for(int i = 0; i < begScores.size() && i < 10; i++){
				scores = new JLabel();
				scores.setText(begScores.get(i) + "");
				scores.setBounds(50, y, 100, 50);
				scores.setVisible(true);
				highPanel.add(scores);
				y+=30;
			}
			y = 30;
			for(int i = 0; i < mediumScores.size() && i < 10; i++){
				scores = new JLabel();
				scores.setText(mediumScores.get(i) + "");
				scores.setBounds(142, y, 100, 50);
				scores.setVisible(true);
				highPanel.add(scores);
				y+=30;
			}
			y = 30;
			for(int i = 0; i < hardScores.size() && i < 10; i++){
				scores = new JLabel();
				scores.setText(hardScores.get(i) + "");
				scores.setBounds(235, y, 100, 50);
				scores.setVisible(true);
				highPanel.add(scores);
				y+=30;
			}
		}
	}
	
	MouseListener tButton = new MouseListener(){
		
		/************************************************************************************************
		 * 
		 * Method:		mouseClicked
		 * 
		 * Description:	Invokes an action when the mouse is left clicked or right clicked.
		 * 
		 * @param		e the action
		 * 
		 * @return		None
		 * 
		 ***********************************************************************************************/
		
		public void mouseClicked(MouseEvent e){
			boolean found = false;
			int i = 0;
			int j = 0;
			for (i = 0; i < height; i++){
				for (j = 0; j < width; j++){
					if(e.getSource().equals(grid.getButton(i, j))){
						found = true;
						break;
					}
				}
				if(found){
					break;
				}
			}
			if(SwingUtilities.isLeftMouseButton(e)){
				if (grid.getData(i, j) > 0 && grid.getButton(i, j).getText() != "F" && grid.getButton(i, j).isEnabled()){					
					pressedbuttons++;
					grid.getButton(i, j).setText(grid.getData(i, j) + "");
					grid.getButton(i, j).setEnabled(false);
				}
				else if (grid.getData(i, j) == 0 && grid.getButton(i, j).getText() != "F" && grid.getButton(i, j).isEnabled()){
					traverseTo(grid.getCell(i, j));
				}
				else if(grid.getData(i, j) == -1 && grid.getButton(i, j).getText() != "F" && grid.getButton(i, j).isEnabled()){
					grid.getButton(i, j).setText("B");
					JOptionPane.showMessageDialog(panel, "GAME OVER");
					time.stop();
					reset();
				}
				else if (grid.getButton(i, j).getText() == "F"){
					grid.getButton(i, j).setSelected(false);
				}
			}
			if(SwingUtilities.isRightMouseButton(e)){
				if(grid.getData(i, j) >= -1 && grid.getButton(i, j).getText() != "F" && flagsRemaining > 0 && grid.getButton(i, j).isEnabled()){
					grid.getButton(i, j).setEnabled(false);
					grid.getButton(i, j).setText("F");
					flagsRemaining --;
				}
				else{
					if(grid.getData(i, j) == -1 && grid.getButton(i, j).getText() == "F"){
						grid.getButton(i, j).setEnabled(true);
						grid.getButton(i, j).setText("");
						flagsRemaining ++;
					}
					else if (grid.getData(i, j) >= 0 && grid.getButton(i, j).getText() == "F"){
						grid.getButton(i, j).setEnabled(true);
						grid.getButton(i, j).setText("");
						flagsRemaining ++;
					}
				}
			}
			if(pressedbuttons == (totalbuttons - mines)){
				time.stop();
				int option = JOptionPane.showConfirmDialog(panel, "You have cleared all the mines in " + timer + " seconds! Press Yes if you want your score inputed into the high scores.", "High Scores Input", JOptionPane.YES_NO_OPTION);
				if (option == 0) {
					switch (totalbuttons) {
					case 100:
						enterHighScore("easy.txt", timer);
						break;
					case 225:
						enterHighScore("medium.txt", timer);
						break;
					case 400:
						enterHighScore("hard.txt", timer);
						break;
					}
				}
				reset();
			}
		}
		
		/************************************************************************************************
		 * 
		 * Method:		mousePressed
		 * 
		 * Description:	Invokes an action when the mouse is pressed over a component. 
		 * 				This method is not used.
		 * 
		 * @param		e the action
		 * 
		 * @return		None
		 * 
		 ***********************************************************************************************/
		
		public void mousePressed(MouseEvent e) {
		}
		/************************************************************************************************
		 * 
		 * Method:		mouseReleased
		 * 
		 * Description:	Invokes an action when the mouse is released over a component. 
		 * 				This method is not used.
		 * 
		 * @param		e the action
		 * 
		 * @return		None
		 * 
		 ***********************************************************************************************/
		public void mouseReleased(MouseEvent e) {
		}
		/************************************************************************************************
		 * 
		 * Method:		mouseEntered
		 * 
		 * Description:	Invokes an action when the mouse is entered over a component. 
		 * 				This method is not used.
		 * 
		 * @param		e the action
		 * 
		 * @return		None
		 * 
		 ***********************************************************************************************/
		public void mouseEntered(MouseEvent e) {
		}
		/************************************************************************************************
		 * 
		 * Method:		mouseExited
		 * 
		 * Description:	Invokes an action when the mouse is exited over a component. 
		 * 				This method is not used.
		 * 
		 * @param		e the action
		 * 
		 * @return		None
		 * 
		 ***********************************************************************************************/
		public void mouseExited(MouseEvent e) {
		}
	};
	
	/****************************************************************************************************
	 * 
	 * Method:			setMines
	 * 
	 * Description:		Places mines into random cells in the grid. The amount of mines set depends on
	 * 					the difficulty selected
	 * 
	 * @param			None
	 * 
	 * @return			None
	 * 
	 ***************************************************************************************************/
	
	public void setMines() {
		mines = 0;
	    Random rng = new Random();
	    int mineCounter = 0;
	    int minesNeeded = 0;
	    if (this.height == 10 || this.width == 10) {
        minesNeeded = 9;
	    }
	    else if (this.height == 15 || this.width == 15) {
	       minesNeeded = 50;
	    }
	    else if (this.height == 20 || this.width == 20) {
	        minesNeeded = 100;
	    }
	    while (mineCounter < minesNeeded) {
	        int mineRow = rng.nextInt(width);
	        int mineCol = rng.nextInt(height);
	        if (grid.getData(mineRow, mineCol) != -1) {
	            grid.setData(mineRow, mineCol, -1);
	            mineCounter++;
	            mines = minesNeeded;
	            flagsRemaining = minesNeeded;
	        }
	    }
	}

	/****************************************************************************************************
	 * 
	 * Method:			setValues
	 * 
	 * Description:		Sets the values of the cells in the game board.
	 * 
	 * @param			None
	 * 
	 * @return			None
	 * 
	 ***************************************************************************************************/
	
	public void setValues(){
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				if(grid.getData(i, j) != -1){
					grid.setData(i, j, 0);
				}
			}
		}
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				int counter = 1;
				if(grid.getData(i, j) == 0){
					if(grid.getCell(i, j).getNorth() != null && grid.getCell(i, j).getNorth().getData() == -1){
						grid.setData(i, j, counter);
						counter++;
					}
					if(grid.getCell(i, j).getNorthEast() != null && grid.getCell(i, j).getNorthEast().getData() == -1){
						grid.setData(i, j, counter);
						counter++;
					}
					if(grid.getCell(i, j).getNorthWest() != null && grid.getCell(i, j).getNorthWest().getData() == -1){
						grid.setData(i, j, counter);
						counter++;
					}
					if(grid.getCell(i, j).getEast() != null && grid.getCell(i, j).getEast().getData() == -1){
						grid.setData(i, j, counter);
						counter++;
					}
					if(grid.getCell(i, j).getWest() != null && grid.getCell(i, j).getWest().getData() == -1){
						grid.setData(i, j, counter);
						counter++;
					}
					if(grid.getCell(i, j).getSouth() != null && grid.getCell(i, j).getSouth().getData() == -1){
						grid.setData(i, j, counter);
						counter++;
					}
					if(grid.getCell(i, j).getSouthEast() != null && grid.getCell(i, j).getSouthEast().getData() == -1){
						grid.setData(i, j, counter);
						counter++;
					}
					if(grid.getCell(i, j).getSouthWest() != null && grid.getCell(i, j).getSouthWest().getData() == -1){
						grid.setData(i, j, counter);
						counter++;
					}
				}
			}
		}
	}
	
	/****************************************************************************************************
	 * 
	 * Method:			traverseTo
	 * 
	 * Description:		Reveals the adjacent cells. Cells stop traversing to other cells when its current
	 * 					data is not 0.
	 * 
	 * @param			cell the cell which will be revealed
	 * 
	 * @return			None
	 * 
	 ***************************************************************************************************/
	
	private void traverseTo(Cell cell) {
		JToggleButton button = cell.getButton();
		button.setSelected(true);
	    button.setEnabled(false);
	    pressedbuttons++;
	    if (cell.getData() == 0) {
	        if (cell.getNorth() != null && cell.getNorth().getButton().isEnabled()) {
	            traverseTo(cell.getNorth());
	        }
	        if (cell.getNorthEast() != null && cell.getNorthEast().getButton().isEnabled()) {
	            traverseTo(cell.getNorthEast());
	        }
	        if (cell.getNorthWest() != null && cell.getNorthWest().getButton().isEnabled()) {
	            traverseTo(cell.getNorthWest());
	        }
	        if (cell.getSouth() != null && cell.getSouth().getButton().isEnabled()) {
	        	traverseTo(cell.getSouth());
	        }
	        if (cell.getSouthEast() != null && cell.getSouthEast().getButton().isEnabled()) {
	            traverseTo(cell.getSouthEast());
	        }
	        if (cell.getSouthWest() != null && cell.getSouthWest().getButton().isEnabled()) {
	            traverseTo(cell.getSouthWest());
	        }
	        if (cell.getEast() != null && cell.getEast().getButton().isEnabled()) {
	            traverseTo(cell.getEast());
	        }
	        if (cell.getWest() != null && cell.getWest().getButton().isEnabled()) {
	            traverseTo(cell.getWest());
	        }
	    }
	    if (cell.getData() > 0){
	    	cell.getButton().setText(cell.getData() + "");
	    }
	}
	
	/***********************************************************************************************
     * 
     * Method:            startTimer
     * 
     * Description:        Creates a timer which runs while the game is being played.
     * 
     * @param            None
     * 
     * @return            None
     * 
     **********************************************************************************************/
    private void startTimer() {
    	timerText = new JLabel("Time elapsed: ");
    	if(height == 10 && width == 10){
    		timerText.setBounds(9, 325, 150, 50);
    	}
    	else if (height == 15 && width == 15){
    		timerText.setBounds(9, 485, 150, 50);
    	}
    	else{
    		timerText.setBounds(9, 640, 150, 50);
    	}
        panel.add(timerText);
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
              timer++;
              timerText.setText("Time elapsed: " + timer);
            }
        };
        time = new Timer(1000, taskPerformer);
        time.start();
    }

	/****************************************************************************************************
	 * 
	 * Method:			hideButtons
	 * 
	 * Description:		Hides the buttons that are in the main menu.
	 * 
	 * @param			None
	 * 
	 * @return			None
	 * 
	 ***************************************************************************************************/
    
	public void hideButtons(){
		btnScore.setEnabled(false);
		btnScore.hide();
		btnBeginner.setEnabled(false);
		btnBeginner.hide();
		btnMedium.setEnabled(false);
		btnMedium.hide();
		btnHard.setEnabled(false);
		btnHard.hide();
	}
	
	/****************************************************************************************************
	 * 
	 * Method:			reset
	 * 
	 * Description:		Change the current screen to the main menu.
	 * 
	 * @param			None
	 * 
	 * @return			None
	 * 
	 ***************************************************************************************************/
	
	public void reset(){
		for (int i = 0; i < height; i++){
			for (int j = 0; j < width; j++){
				grid.getButton(i, j).hide();
				grid.getButton(i, j).setEnabled(false);
			}
		}
		pressedbuttons = 0;
		timer = 0;
		frame.setSize(frameW, frameH);
		btnBeginner.setEnabled(true);
		btnBeginner.show();
		btnMedium.setEnabled(true);
		btnMedium.show();
		btnHard.setEnabled(true);
		btnHard.show();
		btnReset.setEnabled(false);
		btnReset.hide();
		btnScore.setEnabled(true);
		btnScore.show();
		chngDiff.setEnabled(false);
		chngDiff.hide();
		timerText.setEnabled(false);
		timerText.hide();
	}
	
	/****************************************************************************************************
	 * 
	 * Method:			enterHighScore
	 * 
	 * Description:		Writes the name of the player and the time taken to a text file
	 * 
	 * @param 			textfile the file to write the player and time taken
	 * @param 			time the time taken for the player to successfully sweep the board
	 * 
	 * @return			None
	 * 
	 ***************************************************************************************************/
	private void enterHighScore(String textfile, int time) {
		try {
			FileWriter fw = new FileWriter(new File(textfile), true);
			fw.write(time + String.format("%n"));
			fw.close();
		}
		catch (java.io.IOException e) {
		}
	}
	
	/**************************************************************************************************
	 * 
	 * Method:			readHighScores
	 * 
	 * Description:		Reads the times stored in the text files and places them into an array
	 * 					list.
	 * 
	 * @param			None
	 * 
	 * @return			None
	 * 
	 *************************************************************************************************/
	private void readHighScores() {
		try {
			Scanner sc1 = new Scanner(new File("easy.txt"));
			Scanner sc2 = new Scanner(new File("medium.txt"));
			Scanner sc3 = new Scanner(new File("hard.txt"));
			while (sc1.hasNext()) {
				begScores.add(sc1.nextInt());
			}
			while (sc2.hasNext()) {
				mediumScores.add(sc2.nextInt());
			}
			while (sc3.hasNext()) {
				hardScores.add(sc3.nextInt());
			}
			sc1.close();
			sc2.close();
			sc3.close();
			InsertionSort(begScores);
			InsertionSort(mediumScores);
			InsertionSort(hardScores);
		}
		catch (java.io.IOException e) {	
		}
	}
	
	public class resetButton implements ActionListener{
		
		/****************************************************************************************************
		 * 
		 * Method:			actionPerformed
		 * 
		 * Description:		Creates a button to reset the maze during the game if the user chooses to do so.
		 * 
		 * @param			e whenever the button is clicked
		 * 
		 * @return			None
		 * 
		 ***************************************************************************************************/
		
		public void actionPerformed(ActionEvent e) {
			time.stop();
			reset();
			hideButtons();
			startTimer();
			grid = new Grid(height, width);
			if (width == 10 && height == 10){
				frame.setSize(320, 400);
				chngDiff.setEnabled(true);
				chngDiff.setVisible(true);
				for (int i = 0; i < height; i++){
					for (int j = 0; j < width; j++){
						grid.setButton(i, j, new JToggleButton());
						grid.getButton(i, j).setSize(32,32);
						panel.add(grid.getButton(i, j));
						grid.getButton(i, j).setLocation(j*575/18, i*575/18);
						grid.getButton(i, j).addMouseListener(tButton);
					}
				}
			}
			else if (width == 15 && height == 15){
				chngDiff.setEnabled(true);
				chngDiff.setVisible(true);
				for (int i = 0; i < height; i++){
					for (int j = 0; j < width; j++){
						grid.setButton(i, j, new JToggleButton());
						grid.getButton(i, j).setSize(32,32);
						panel.add(grid.getButton(i, j));
						grid.getButton(i, j).setLocation(j*575/18, i*575/18);
						grid.getButton(i, j).addMouseListener(tButton);
					}
				}
			}
			else{
				frame.setSize(frameW + 155, frameH + 200);
				chngDiff.setEnabled(true);
				chngDiff.setVisible(true);
				for (int i = 0; i < height; i++){
					for (int j = 0; j < width; j++){
						grid.setButton(i, j, new JToggleButton());
						grid.getButton(i, j).setSize(32,32);
						panel.add(grid.getButton(i, j));
						grid.getButton(i, j).setLocation(j*575/18, i*575/18);
						grid.getButton(i, j).addMouseListener(tButton);
					}
				}
			}
			btnReset.show();
			btnReset.setEnabled(true);
			setMines();
			setValues();
		}
	}

	public class changeDifficulty implements ActionListener{

		/****************************************************************************************************
		 * 
		 * Method:			changeDifficulty
		 * 
		 * Description:		Creates a change difficulty button which allows the user to change difficulty if
		 * 					they choose to do so.
		 * 
		 * @param			e when the button is clicked
		 * 
		 * @return			None
		 * 
		 ***************************************************************************************************/
		
		public void actionPerformed(ActionEvent e) {
			time.stop();
			reset();
		}
	}

	/********************************************************************************************************
	 * 
	 * METHOD:				InsertionSort()
	 * 
	 * DESCRIPTION:			This method called InsertionSort, sorts the elements in the list using the algorithm for Insertion Sort.
	 * 
	 * @param				none
	 * 
	 * @return				toString()
	 * 
	 ********************************************************************************************************/
	
	public void InsertionSort(ArrayList<Integer> list){
		int temp = 0;
		for (int k = 1; k < list.size(); k++){
			while(k > 0 && list.get(k-1) > list.get(k)){
				temp = list.get(k);
				list.set(k, list.get(k-1));
				list.set(k-1, temp);
				k--;
			}
		}
	}	
}
