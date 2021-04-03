package projetgroupe3;

import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


import java.io.*;

public class Server{
	public static final int PORT=5112;
	private static ArrayList<Partie> n = new ArrayList<>();
	private static ExecutorService pool = Executors.newCachedThreadPool();
	

	 public Server() {
		 ServerSocket serverSocket = null;
		 	try {
		 		serverSocket = new ServerSocket(PORT);
		 	}catch (IOException e) {
		 		e.printStackTrace();
		 	}
		 	
		 	Partie partie = new Partie(9,15,44,15,15,2);
		 	while(true) {
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
	