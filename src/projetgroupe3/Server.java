package projetgroupe3;

import java.net.*; 
import java.io.*;

public class Server{
	public static final int PORT=5112;

	 public Server() {
		 ServerSocket serverSocket = null;
		 	try {
		 		serverSocket = new ServerSocket(PORT);
		 	}catch (IOException e) {
		 		e.printStackTrace();
		 	}
		 	int nb_j;
		 	while(true) {
		 	nb_j = 2 + (int)(Math.random() * ((5 - 2) + 1));
		 	Partie partie = new Partie(9,15,44,15,15,nb_j);
		 		Socket s;
		 		try {
		 			while(partie.ready()==false) {
		 			System.out.println("En attente de connexion...");
		 			s = serverSocket.accept();
		 			Client player = new Client(s);
		 			System.out.println("Connexion réussie.");
		 			player.start();
		 			partie.addPlayer(player);
		 			if(partie.ready()) {
		 				partie.start();
		 			}
		 			}
		 		}catch (IOException e) {
		 			e.printStackTrace();
		 		
		 		}
		 	}
	 }
	 
	 
	 public static void main(String argv[]) throws UnknownHostException, IOException {
		new Server();
		
	 }
}
	