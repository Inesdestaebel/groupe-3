package projetgroupe3;

import java.util.ArrayList;

public class Partie extends Thread{
	private int X;
	private int Y;
	private int murs;
	private int pieges;
	private int potions;
	private int nb_joueurs;
	private Plateaudejeu Plateau;
	private static ArrayList<Client> joueurs = new ArrayList<>();
	
	public Partie(int X, int Y, int murs, int pieges, int potions, int nb_joueurs) {
		this.nb_joueurs=nb_joueurs;
		this.X=X;
		this.Y=Y;
		this.murs=murs;
		this.pieges=pieges;
		this.potions=potions;
		Plateau = new Plateaudejeu(X,Y,murs,pieges,potions);
	}
	
	public boolean ready() {
		return joueurs.size()==this.nb_joueurs;
	}
	
	public void addPlayer(Client player) {
		joueurs.add(player);
	}
	
	public ArrayList<Client> getJoueurs(){
		return joueurs;
	}
	
	public void run() {
		//for(Client player : joueurs) {
			//player.send_message("Bienvenue dans la partie.");
			//Je n'arrive pas à faire la fonction send_message qui permettrait
			//D'envoyer les informations aux joueurs et pas au serveur.
		//}
		System.out.println("En attente des joueurs pour que la partie commence...");
		for(Client player : joueurs) {
			while(player.isReady()==false) { 
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
			
			System.out.println(player.getName()+" est prêt.");
			}
		
		for (int i=0;i<joueurs.size();i++) {
			Client player = joueurs.get(i);
			//renvoyer la vision du joueur : serializable
		}
		
		
			
		}
	}


	

