package lab3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import lab3.data.GameGrid;


/**
 * A listener class that listens for commands sent by a client
 * 
 * @author Elias Elfving
 * @version 1.0
 * @date 10/10/19
 * 
 */
public class GameListener implements Runnable {
	
	
	private GameGrid g;
	private final int port;
	
	/**
	 * Constructor
	 * 
	 * @param g A gamegrid object
	 * @param port a portnumber
	 */
	public GameListener(GameGrid g, int port) {
		this.g = g;
		this.port = port;
	}
	
	@Override
	/**
	 * A run function implemented from the runnable interface that listens for incoming packets
	 * on the same port specified in the constructor. It then processes the data and passes on the correct
	 * command to the GameGrid.
	 */
	public void run(){
		try(DatagramSocket socket = new DatagramSocket(port)){
			byte[] buffer = new byte[1024];
			socket.setSoTimeout(3000000);
			while(true) {
				
	            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
	            socket.receive(packet);
	           
	            //Creates an byte array with exact packet length to prevent data being
	            //wrong when later processed
	            byte[] data = new byte[packet.getLength()];
	            System.arraycopy(packet.getData(), packet.getOffset(), data, 0, packet.getLength());
	            
				String msg = new String(data);
				String[] cmd = msg.split(" ");
								
				if(cmd[0].equals("set")) {
					g.setColor(Integer.parseInt(cmd[1]), 
							   Integer.parseInt(cmd[2]), cmd[3]);
				} else if(cmd[0].equals("clear")) {
					g.clearGrid();
				} else if(cmd[0].equals("remove")){
					g.clearCell(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
				} 
			
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
