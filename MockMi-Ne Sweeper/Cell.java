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
 * FILE:				Cell.java
 * 
 * DESCRIPTION:			This class contains the cell which will be stored in the Grid for the MineSweeper
 * 						program. This also serves as a foundation upon which the GUI board is presented.
 *
 *******************************************************************************************************/

import javax.swing.JToggleButton;

public class Cell {
    
    private Cell north;
    private Cell east;
    private Cell south;
    private Cell west;
    private Cell northWest;
    private Cell northEast;
    private Cell southWest;
    private Cell southEast;
    
    private int data;
    private JToggleButton button;

	/****************************************************************************************************
	 * 
	 * Method:			Cell
	 * 
	 * Description:		Constructor which creates a cell which will be placed in a grid.
	 * 
	 * @param			None
	 * 
	 * @return			None
	 * 
	 ***************************************************************************************************/
    
    public Cell() {
        this.north = null;
        this.east = null;
        this.south = null;
        this.west = null;
        this.northEast = null;
        this.northWest = null;
        this.southEast = null;
        this.southWest = null;
    }

	/****************************************************************************************************
	 * 
	 * Method:			getNorth
	 * 
	 * Description:		Returns the cell located directly above the current cell
	 * 
	 * @param			None
	 * 
	 * @return			the cell located directly above the current cell.
	 * 
	 ***************************************************************************************************/
    public Cell getNorth() {
        return this.north;   
    }
    
	/****************************************************************************************************
	 * 
	 * Method:			getEast
	 * 
	 * Description:		Returns the cell located directly to the right of the current cell
	 * 
	 * @param			None
	 * 
	 * @return			the cell located directly to the right of the current cell
	 * 
	 ***************************************************************************************************/
    public Cell getEast() {
        return this.east;
    }
    
	/****************************************************************************************************
	 * 
	 * Method:			getSouth
	 * 
	 * Description:		Returns the cell located directly below of the current cell
	 * 
	 * @param			None
	 * 
	 * @return			the cell located directly below of the current cell
	 * 
	 ***************************************************************************************************/
    public Cell getSouth() {
        return this.south;
    }    
    
	/****************************************************************************************************
	 * 
	 * Method:			getWest
	 * 
	 * Description:		Returns the cell located directly to the left of the current cell
	 * 
	 * @param			None
	 * 
	 * @return			the cell located directly to the left of the current cell
	 * 
	 ***************************************************************************************************/
    public Cell getWest() {
        return this.west;
    }
    
	/****************************************************************************************************
	 * 
	 * Method:			getNorthWest
	 * 
	 * Description:		Returns the cell located directly to the top left of the current cell
	 * 
	 * @param			None
	 * 
	 * @return			the cell located directly to the top left of the current cell
	 * 
	 ***************************************************************************************************/
    public Cell getNorthWest() {
        return this.northWest;   
    }
    
	/****************************************************************************************************
	 * 
	 * Method:			getNorthEast
	 * 
	 * Description:		Returns the cell located directly to the top right of the current cell
	 * 
	 * @param			None
	 * 
	 * @return			the cell located directly to the top right of the current cell
	 * 
	 ***************************************************************************************************/
    public Cell getNorthEast() {
        return this.northEast;
    }
    
	/****************************************************************************************************
	 * 
	 * Method:			getSouthEast
	 * 
	 * Description:		Returns the cell located directly to the bottom right of the current cell
	 * 
	 * @param			None
	 * 
	 * @return			the cell located directly to the bottom right of the current cell
	 * 
	 ***************************************************************************************************/
    public Cell getSouthEast() {
        return this.southEast;
    }    
    
	/****************************************************************************************************
	 * 
	 * Method:			getSouthWest
	 * 
	 * Description:		Returns the cell located directly to the bottom left of the current cell
	 * 
	 * @param			None
	 * 
	 * @return			the cell located directly to the bottom left of the current cell
	 * 
	 ***************************************************************************************************/
    public Cell getSouthWest() {
        return this.southWest;
    }
    
	/****************************************************************************************************
	 * 
	 * Method:			getButton
	 * 
	 * Description:		Returns the toggle button associated with the cell.
	 * 
	 * @param			None
	 * 
	 * @return			the toggle button associated with the cell.
	 * 
	 ***************************************************************************************************/
    public JToggleButton getButton() {
        return this.button;
    }
    
	/****************************************************************************************************
	 * 
	 * Method:			getData
	 * 
	 * Description:		Returns the data stored in the cell.
	 * 
	 * @param			None
	 * 
	 * @return			the data stored in the cell.
	 * 
	 ***************************************************************************************************/
    public int getData(){
    	return this.data;
    }
    
	/****************************************************************************************************
	 * 
	 * Method:			setNorth
	 * 
	 * Description:		Sets the cell above the current cell to the given cell.
	 *
	 * @param			cell the cell to be set as the north
	 * 
	 * @return			None
	 * 
	 ***************************************************************************************************/
    public void setNorth(Cell cell) {
        this.north = cell;
    }

	/****************************************************************************************************
	 * 
	 * Method:			setEast
	 * 
	 * Description:		Sets the cell to the right of the current cell to the given cell.
	 *
	 * @param			cell the cell to be set as the east
	 * 
	 * @return			None
	 * 
	 ***************************************************************************************************/
    public void setEast(Cell cell) {
        this.east = cell;
    }    
    
	/****************************************************************************************************
	 * 
	 * Method:			setNorth
	 * 
	 * Description:		Sets the cell below the current cell to the given cell.
	 *
	 * @param			cell the cell to be set as the south
	 * 
	 * @return			None
	 * 
	 ***************************************************************************************************/
    public void setSouth(Cell cell) {
        this.south = cell;
    }
    
	/****************************************************************************************************
	 * 
	 * Method:			setWest
	 * 
	 * Description:		Sets the cell to the left of the current cell to the given cell.
	 *
	 * @param			cell the cell to be set as the west
	 * 
	 * @return			None
	 * 
	 ***************************************************************************************************/
    public void setWest(Cell cell) {
        this.west = cell;
    } 

	/****************************************************************************************************
	 * 
	 * Method:			setNorthWest
	 * 
	 * Description:		Sets the cell to the top left of the current cell to the given cell.
	 *
	 * @param			cell the cell to be set as the north west
	 * 
	 * @return			None
	 * 
	 ***************************************************************************************************/
    public void setNorthWest(Cell cell) {
        this.northWest = cell;
    }

	/****************************************************************************************************
	 * 
	 * Method:			setNorthEast
	 * 
	 * Description:		Sets the cell to the top right of the current cell to the given cell.
	 *
	 * @param			cell the cell to be set as the north east
	 * 
	 * @return			None
	 * 
	 ***************************************************************************************************/
    public void setNorthEast(Cell cell) {
        this.northEast = cell;
    }    
    
	/****************************************************************************************************
	 * 
	 * Method:			setSouthEast
	 * 
	 * Description:		Sets the cell to the bottom right of  the current cell to the given cell.
	 *
	 * @param			cell the cell to be set as the south east
	 * 
	 * @return			None
	 * 
	 ***************************************************************************************************/
    public void setSouthEast(Cell cell) {
        this.southEast = cell;
    }
    
	/****************************************************************************************************
	 * 
	 * Method:			setSouthWest
	 * 
	 * Description:		Sets the cell to the bottom left of the current cell to the given cell.
	 *
	 * @param			cell the cell to be set as the south west
	 * 
	 * @return			None
	 * 
	 ***************************************************************************************************/
    
    public void setSouthWest(Cell cell) {
        this.southWest = cell;
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
    
    public void setButton(JToggleButton jToggleButton) {
        this.button = jToggleButton;
    }
    
	/****************************************************************************************************
	 * 
	 * Method:			setData
	 * 
	 * Description:		Sets the data stored in a cell.
	 *
	 * @param			data the data to be stored into the cell.
	 * 
	 * @return			None
	 * 
	 ***************************************************************************************************/
    
    public void setData(int d){
    	this.data = d;
    }
}