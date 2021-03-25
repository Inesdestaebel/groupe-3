package projetgroupe3;

import java.net.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.*;

public class Server {
	private static ArrayList<ClientHandler> clients = new ArrayList<>();
	private static ExecutorService pool = Executors.newFixedThreadPool(6);
	
	public static void main(String[]args)throws IOException{
		
		ServerSocket ss = new ServerSocket(4242);
		int nbr=0;
		int X = 9;
		int Y = 15;
		int murs = 44;
		int pieges = 15;
		int potion = 15;
		Plateaudejeu plateau = new Plateaudejeu(X,Y,murs,pieges,potion);
		while (true && nbr<5) {
		System.out.println("En attente de connexion.");
		Socket s = ss.accept();
		System.out.println("Serveur connecté au client.");
		nbr+=1;
		ClientHandler clientThread = new ClientHandler(s,nbr,plateau);
		clients.add(clientThread);
		pool.execute(clientThread);
		}
		
	}
}
		


