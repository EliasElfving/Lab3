package lab3.client;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Main class for the testclient
 * @author Elias Elfving
 * @version 1.0
 * @date 10/10/19
 */
public class ClientMain {
	
	public static void main(String[] args) {
		TestClient tc = new TestClient(1234);
		ExecutorService exec = Executors.newFixedThreadPool(1);		
		exec.submit(tc);
	}
}
