package lab3.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import lab3.data.GameGrid;


/**
 * 
 * @author Elias Elfving
 * @version 1.0
 * @date 10/10/19
 */
public class GameGUI{
	private JFrame frame;
	
	/**
	 * Constructor, creates a display with the GamePanel created from the grid
	 * @param grid the grid that will be used
	 */
	public GameGUI(GameGrid grid) {

		frame = new JFrame("Game");
	
		
		GamePanel gridPanel = new GamePanel(grid);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(grid.gridSize * gridPanel.CELL_SIZE + 1,
										   grid.gridSize * gridPanel.CELL_SIZE + 1));
		
		frame.setResizable(false);
		frame.add(gridPanel);

		frame.pack();
		frame.setVisible(true);
		
	}

	
}
