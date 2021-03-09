package day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

	public static Socket clientSocket;
	
	public Server(Socket socket) {
		this.clientSocket = socket;
	}
		
	public static void main(String[] args) {
		ServerSocket server = null;
		
		try {
			server = new ServerSocket(3000);
			System.out.println("Server ready...");
			
			while(true) {
				Socket client = server.accept();
				System.out.println(client.getInetAddress().getHostAddress());
				Server clientSocket = new Server(client);
				
				ExecutorService es = Executors.newFixedThreadPool(1);
				es.execute(() -> {
					PrintWriter out=null;
					BufferedReader in=null;
					BufferedReader br;
					
			        try {
			        	while(true) {
						out = new PrintWriter(client.getOutputStream(), true);					
						in = new BufferedReader(new InputStreamReader(System.in));
						System.out.println("Enter a message to Client: ");
						String msg = in.readLine();
						out.println(msg); 
						
						br = new BufferedReader(new InputStreamReader(client.getInputStream()));
						String msgFromClient = br.readLine();
						System.out.println("Message from Client: "+msgFromClient);
			        	}
			        } catch (IOException e) {
							e.printStackTrace();
					}			
				});
				es.shutdown();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}		
//				out = new PrintWriter(client.getOutputStream(), true);
//				in = new BufferedReader(new InputStreamReader(System.in));
//				System.out.println("Enter a message to Client: ");
//				String msg = in.readLine();
//				out.println(msg);
//				
//				


