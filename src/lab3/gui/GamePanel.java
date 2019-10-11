package lab3.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import lab3.data.GameGrid;


/**
 * A class creating the GUI part of a Game grid 
 * @author Elias Elfving
 * @version 1.0
 * @date 10/10/19
 */
public class GamePanel extends JPanel implements Observer {
	private GameGrid grid;
	public final int CELL_SIZE = 5;
	
	/**
	 * Creates some necessary variables for the JPanel and also adds itself as an observer to the grid
	 * @param grid a gamegrid object
	 */
	public GamePanel(GameGrid grid) {
		this.grid = grid;
		grid.addObserver(this);
		Dimension d = new Dimension(grid.getGridSize() * CELL_SIZE + 1, grid.getGridSize() * CELL_SIZE + 1);
		this.setMinimumSize(d);
		this.setPreferredSize(d);
		this.setBackground(Color.WHITE);
	}

	@Override
	/**
	 * When observable objects notify a change this object repaints itself
	 */
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		this.repaint();
	}
	
	
	/**
	 * This functions is called when the update method is called, and it repaints the entire grid with new graphics
	 * in which the variables are read from the gamegrid object
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int x = 0; x < grid.getGridSize(); x++) {
			for (int y = 0; y < grid.getGridSize(); y++) {
				g.setColor(Color.black);
				g.drawRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
				if (grid.getCellContent(x, y).equals("GREEN")) {
					g.setColor(Color.green);
					g.fillRect(x * CELL_SIZE + 1, y * CELL_SIZE + 1, CELL_SIZE, CELL_SIZE);
				} else if (grid.getCellContent(x, y).equals("GREEN")) {
					g.setColor(Color.red);
					g.fillRect(x * CELL_SIZE + 1, y * CELL_SIZE + 1, CELL_SIZE, CELL_SIZE);
				} else if (grid.getCellContent(x, y).equals("BLUE")) {
					g.setColor(Color.blue);
					g.fillRect(x * CELL_SIZE + 1, y * CELL_SIZE + 1, CELL_SIZE, CELL_SIZE);
				} else if (grid.getCellContent(x, y).equals("YELLOW")) {
					g.setColor(Color.yellow);
					g.fillRect(x * CELL_SIZE + 1, y * CELL_SIZE + 1, CELL_SIZE, CELL_SIZE);
				} else if (grid.getCellContent(x, y).equals("PINK")) {
					g.setColor(Color.pink);
					g.fillRect(x * CELL_SIZE + 1, y * CELL_SIZE + 1, CELL_SIZE, CELL_SIZE);
				} else if (grid.getCellContent(x, y).equals("CYAN")) {
					g.setColor(Color.cyan);
					g.fillRect(x * CELL_SIZE + 1, y * CELL_SIZE + 1, CELL_SIZE, CELL_SIZE);
				} else if (grid.getCellContent(x, y).equals("ORANGE")) {
					g.setColor(Color.orange);
					g.fillRect(x * CELL_SIZE + 1, y * CELL_SIZE + 1, CELL_SIZE, CELL_SIZE);
				} else if (grid.getCellContent(x, y).equals("MAGENTA")) {
					g.setColor(Color.magenta);
					g.fillRect(x * CELL_SIZE + 1, y * CELL_SIZE + 1, CELL_SIZE, CELL_SIZE);
				} else if (grid.getCellContent(x, y).equals("BLANK")) {
					g.setColor(Color.white);
					g.fillRect(x * CELL_SIZE + 1, y * CELL_SIZE + 1, CELL_SIZE, CELL_SIZE);
				}

			}
		}

	}
}
