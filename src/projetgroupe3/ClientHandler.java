package projetgroupe3;

import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class ClientHandler implements Runnable {
	private Socket client;
	private BufferedReader in;
	private PrintWriter out; 
	private int nbr;
	private Plateaudejeu plateau;
	private boolean i = true;
	
	public ClientHandler(Socket clientSocket, int nbr, Plateaudejeu plateau) throws IOException{
		this.client = clientSocket;
		this.nbr=nbr;
		this.plateau=plateau;
		in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		out = new PrintWriter(client.getOutputStream(),i); 
}

	//@Override
	public void run() {
		try {
			while(i) {
		out.println("Vous êtes bien connecté.");
		out.println("Veuillez entrer un pseudo.");
		String name = in.readLine(); 
		out.println(name+", la partie peut commencer.");
		out.println("Votre numéro de joueur est "+nbr);
	
		Personnage H = plateau.addPlayerServeur(name,nbr);
		for ( int x = 0 ; x<plateau.getX(); x++ ) {
			for ( int y = 0 ; y<plateau.getY(); y++ ) {
				out.print(plateau.valeurcaseperso(x, y));
				
			}
		out.println();
		}
		}
		i=false;	
		}catch(IOException e) {
			System.out.println("Erreur dans le run.");
		}finally {
		out.close();
		try {
		in.close();
		} catch(IOException e) {
			System.out.println("Erreur fermeture in.");
		}
		}
	}
		


}
		 


