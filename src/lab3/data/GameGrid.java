package lab3.data;

import java.util.Observable;


/**
 * A class representing a GameGrid that will be displayed on a GUI
 * @author Elias Elfving
 * @version 1.0
 * @date 10/10/19
 */
public class GameGrid extends Observable{
	
	public final int gridSize = 201;
	private String[][] grid;
	
	/**
	 * Constructor, creates a String[][] array and fills it with "BLANK"
	 */
	public GameGrid() {
		grid = new String[gridSize][gridSize];
		for(int x = 0; x < gridSize; x++) {
			for(int y = 0; y < gridSize; y++) {
				grid[x][y] = "BLANK";
			}
		}
	}
	
	/**
	 * 
	 * @return grid returns the gamegrid
	 */
	public String[][] getGrid() {
		return grid;
	}
	
	/**
	 * 
	 * @return gridSize returns the gridSize
	 */
	public int getGridSize() {
		return gridSize;
	}
	
	/**
	 * Returns a string representing a color
	 * @param x
	 * @param y
	 * @return returns the string found in the arrayposition
	 */
	public String getCellContent(int x, int y) {
		return grid[x][y];
	}
	
	/**
	 * Clears the grid by setting all elements to "BLANK" and notifies observers
	 */
	public void clearGrid() {
		for(int x = 0; x < gridSize; x++) {
			for(int y = 0; y < gridSize; y++) {
				grid[x][y] = "BLANK";
			}
		}
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Clears the specified cell position by setting it to "BLANK" and notifying observers
	 * @param x
	 * @param y
	 */
	public void clearCell(int x, int y) {
		grid[x][y] = "BLANK";
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Sets the color of the specified cellposition
	 * @param x
	 * @param y
	 * @param color
	 */
	public void setColor(int x, int y, String color) {
		grid[x][y] = color.toUpperCase();
		setChanged();
		notifyObservers();
	}
}
