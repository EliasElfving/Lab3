package lab3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lab3.data.GameGrid;
import lab3.gui.GameGUI;

/**
 * Main class for a GUI client/server, representing a game board
 * @author Elias Elfving
 * @version 1.0
 * @date 10/10/19
 */

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GameGrid g = new GameGrid();
		GameListener listener = new GameListener(g, 1234);
		ExecutorService exec = Executors.newFixedThreadPool(1);
		exec.submit(listener);
		GameGUI gui = new GameGUI(g);

	}
}
