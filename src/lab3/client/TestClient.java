package lab3.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;


/**
 * Class for the testclient that will be used to send packets/commands to the gamelistener
 * @author Elias Elfving
 * @version 1.0
 * @date 10/10/19
 */
public class TestClient implements Runnable{
	 
    private int port;  
    
    /**
     * Constructor
     * @param port sets the port to send data to
     */
    public TestClient(int port) {
    	this.port = port;
    }
    
    /**
     * Scans for input and then packs the input into a datagrampacket and
     * sends it to the port specified in the constructor
     */
    @Override
    public void run() {
    	Scanner sc = new Scanner(System.in);   
        byte buf[] = null;
        //Since this is being tested on a localhost we can't send from the same socket 
        //as we the one we are sending to
        try (DatagramSocket socket = new DatagramSocket(5000)) {
             InetAddress ip = InetAddress.getLocalHost(); 
        	 while (true) 
             { 
                 String inp = sc.nextLine();
                 buf = inp.getBytes();     
                 // Step 2 : Create the datagramPacket for sending 
                 // the data. 
                 DatagramPacket DpSend = 
                       new DatagramPacket(buf, buf.length, ip, port);   
                 // Step 3 : invoke the send call to actually send 
                 // the data. 
                 socket.send(DpSend); 
                 if(inp.equals("exit")) {
                	 System.out.println("Exiting program");
                	 break;
                 }     
             }
        	 sc.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
