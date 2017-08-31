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
 * FILE:				Grid.java
 * 
 * DESCRIPTION:			This class contains methods necessary for the Grid to function. This serves as
 * 						the foundation upon which the GUI board is presented.
 *
 *******************************************************************************************************/

import javax.swing.JToggleButton;

public class Grid{
	
	private Cell[][] grid;
    private int rows;
    private int cols;
    
    /****************************************************************************************************
	 * 
	 * Method:			Grid
	 * 
	 * Description:		Constructor which creates a grid of cells. This is the foundation for the game
	 * 					board.
	 * 
	 * @param			r the number of rows
	 * 					c the number of columns
	 * 
	 * @return			None
	 * 
	 ***************************************************************************************************/
    
    public Grid(int r, int c){
        grid = new Cell[r][c];
        this.rows = r;
        this.cols = c;
        
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                grid[i][j] = new Cell();
                grid[i][j].setButton(new JToggleButton());
            }
        }
        
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (i == 0){
                    if (j == 0){
                        grid[i][j].setSouth(grid[i+1][j]);
                        grid[i][j].setEast(grid[i][j+1]);
                        grid[i][j].setSouthEast(grid[i+1][j+1]);
                    }
                    else if (j == cols - 1){
                        grid[i][j].setSouth(grid[i+1][j]);
                        grid[i][j].setWest(grid[i][j-1]);
                        grid[i][j].setSouthWest(grid[i+1][j-1]);
                    }
                    else if (j > 0 && j < cols - 1){
                        grid[i][j].setSouth(grid[i+1][j]);
                        grid[i][j].setEast(grid[i][j+1]);
                        grid[i][j].setWest(grid[i][j-1]);
                        grid[i][j].setSouthEast(grid[i+1][j+1]);
                        grid[i][j].setSouthWest(grid[i+1][j-1]);
                    }
                }
                else if (i == rows - 1){
                    if (j == 0){
                        grid[i][j].setNorth(grid[i-1][j]);
                        grid[i][j].setEast(grid[i][j+1]);
                        grid[i][j].setNorthEast(grid[i-1][j+1]);
                    }
                    else if (j == cols - 1){
                        grid[i][j].setNorth(grid[i-1][j]);
                        grid[i][j].setWest(grid[i][j-1]);
                        grid[i][j].setNorthWest(grid[i-1][j-1]);
                    }
                    else if (j > 0 && j < cols - 1){
                        grid[i][j].setNorth(grid[i-1][j]);
                        grid[i][j].setEast(grid[i][j+1]);
                        grid[i][j].setWest(grid[i][j-1]);
                        grid[i][j].setNorthEast(grid[i-1][j+1]);
                        grid[i][j].setNorthWest(grid[i-1][j-1]);
                    }
                }
                else if (j == 0){
                    if (i > 0 && i < rows - 1){
                        grid[i][j].setNorth(grid[i-1][j]);
                        grid[i][j].setSouth(grid[i+1][j]);
                        grid[i][j].setEast(grid[i][j+1]);
                        grid[i][j].setNorthEast(grid[i-1][j+1]);
                        grid[i][j].setSouthEast(grid[i+1][j+1]);
                    }
                }
                else if (j == cols - 1){
                    if (i > 0 && i < rows - 1){
                        grid[i][j].setNorth(grid[i-1][j]);
                        grid[i][j].setSouth(grid[i+1][j]);
                        grid[i][j].setWest(grid[i][j-1]);
                        grid[i][j].setNorthWest(grid[i-1][j-1]);
                        grid[i][j].setSouthWest(grid[i+1][j-1]);
                    }
                }
                else{
                    grid[i][j].setNorth(grid[i-1][j]);
                    grid[i][j].setSouth(grid[i+1][j]);
                    grid[i][j].setEast(grid[i][j+1]);
                    grid[i][j].setWest(grid[i][j-1]);
                    grid[i][j].setNorthEast(grid[i-1][j+1]);
                    grid[i][j].setNorthWest(grid[i-1][j-1]);
                    grid[i][j].setSouthEast(grid[i+1][j+1]);
                    grid[i][j].setSouthWest(grid[i+1][j-1]);
                }
            }
        }
    }

	/****************************************************************************************************
	 * 
	 * Method:			setButton
	 * 
	 * Description:		Sets the toggle button associated with the cell to the button given.
	 *
	 * @param			jToggleButton the button to the associated with the cell
	 * 
	 * @return			None
	 * 
	 ***************************************************************************************************/
    
    public void setButton(int r, int c, JToggleButton d){
        grid[r][c].setButton(d);
    }

	/****************************************************************************************************
	 * 
	 * Method:			setData
	 * 
	 * Description:		Changes the data stored in the given cell.
	 * 
	 * @param			r the row where the cell is located
	 * 					c the column where the cell is located
	 * 					d the new data that is to be stored
	 * 
	 * @return			None
	 * 
	 ***************************************************************************************************/
    
    public void setData(int r, int c, int d){
        grid[r][c].setData(d);
    }
    
	/****************************************************************************************************
	 * 
	 * Method:			getData
	 * 
	 * Description:		Retrieves the data stored in the given cell.
	 * 
	 * @param			r the row where the cell is located
	 * 					c the column where the cell is located
	 * 
	 * @return			the data stored in the cell
	 * 
	 ***************************************************************************************************/
    
    public int getData(int r, int c){
        return grid[r][c].getData();
    }
    
	/****************************************************************************************************
	 * 
	 * Method:			getButton
	 * 
	 * Description:		Returns the toggle button that is linked to the cell
	 * 
	 * @param			r the row where the cell is located
	 * 					c the column where the cell is located
	 * 
	 * @return			the JToggleButton linked to the given cell.
	 * 
	 ***************************************************************************************************/
    
    public JToggleButton getButton(int r, int c){
        return grid[r][c].getButton();
    }
    
	/****************************************************************************************************
	 * 
	 * Method:			getCell
	 * 
	 * Description:		Returns the cell given its row and column
	 * 
	 * @param			r the row where the cell is located
	 * 					c the column where the cell is located
	 * 
	 * @return			the cell associated with the row and column
	 * 
	 ***************************************************************************************************/
    
    public Cell getCell(int r, int c){
        return grid[r][c];
    }
}