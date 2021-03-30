package projetgroupe3;

import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


import java.io.*;

public class Server extends Thread{
	public static final int PORT=5112;
	ServerSocket serverSocket = null;
	private static ArrayList<Partie> n = new ArrayList<>();
	private static ExecutorService pool = Executors.newCachedThreadPool();
	

	 public Server() {
        
	 }
	 
	 
	 public static void main(String argv[]) throws UnknownHostException, IOException {
		ServerSocket ss = new ServerSocket(PORT);
        Partie partie = new Partie(9,15,44,15,15,2);
        //Comment lancer plusieurs parties et choisir le nbre de joueurs?
		 	while (true && partie.ready()==false) {
            try {
            	Socket socket;
            	System.out.println("En attente de connexion...");
            	socket = ss.accept();
            	System.out.println("Connexion réussie.");
            
            	PrintStream out= new PrintStream( socket.getOutputStream() );
                BufferedReader in= new BufferedReader(new InputStreamReader(socket.getInputStream()));
                
                
                //PB : vu qu'il y a un in.ReadLine() dans la boucle while, 
                //quand on attend le prenom d'un joueur il ne peut pas 
                //y avoir l'affichage d'une connexion réussie. 
                //En plus il faut que le joueur qui s'est connecté en premier
                //entre son prénom et si il est prêt avant l'autre sinon : erreur
                
                //Si je choisis pour éviter ce pb de créer un client directement
                //Dans le main de Client, alors je ne sais pas comment ajouter ce
                //client à la partie de jeu...
                
            	String name = in.readLine();
            	Client c = new Client();
            	c.setName(name);
      	      
            	partie.addPlayer(c);
            	
            	String r = in.readLine();
            	if(r.equals("A")) {
                c.Ready(true);
            	}
      	       
      	       }
      	      
            	
              catch (IOException e) {
            	  System.err.println("Une erreur est arrivée lorsqu'un joueur a tenté de se connecter... ");
                  System.err.println(e);
                }
		 	}
              
             pool.execute(partie);
	 
}
}

		


