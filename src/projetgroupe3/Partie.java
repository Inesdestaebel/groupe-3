package projetgroupe3;

import java.util.ArrayList;
import java.io.*;

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
		this.Plateau = new Plateaudejeu(X,Y,murs,pieges,potions);
	}
	
	public Plateaudejeu getPlateau() {
		return Plateau;
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
		for(Client player : joueurs) {
			player.send_message("Bienvenue dans la partie. Vous êtes "+nb_joueurs+" joueurs.");	
		}
		
		System.out.println("En attente des joueurs pour que la partie commence...");
		for(Client player : joueurs) {
			while(player.isReady()==false) {  
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
			
			System.out.println(player.getNom()+" est prêt.");
			player.p = new Personnage(player.getNom());
			}
		
		//MISE EN PLACE DU PLATEAU DU JOUEUR EXACTEMENT COMME LE PLATEAU PRINCIPAL, OKKK FONCTIONNE 
		for (int i=0;i<joueurs.size();i++) {
			Client player = joueurs.get(i);
			player.setPlateau(X,Y);
			for(int x=0;x<X;x++) {
				for(int y=0;y<Y;y++) {
					int[] pos= {x,y};
					char a = Plateau.valeurcase(x, y);
					player.p.getPlateau().setOnePlateau(a,pos);
				}
			}
		}
		for(int i=0;i<joueurs.size();i++) {
			Client player=joueurs.get(i);
			
			//Ajout du joueur sur le plateau et on associe la position au joueur.
			player.p.setPosition(Plateau.addPlayerServeur(player.p));
			
			//On met a jour le plateau du joueur en ajoutant le joueur à cette position.
			player.p.getPlateau().setOnePlateau('H',player.p.getPosition());
			player.p.getPlateau().setOnePlateauPerso('H',player.p.getPosition());
			
			//On ajoute les fonctions de déplacements pour les deux plateaux
			player.D = new Deplacements(player.p,Plateau); 
			player.Djoueurs = new Deplacements(player.p,player.p.getPlateau()); 
			
			player.p.getPlateau().afficher(); //OK JUSTE
			System.out.println("");
			
		}
		Plateau.afficher(); //OK JUSTE
		
		boolean fin=false;
		while(fin==false) {
			System.out.println("En attente des actions des joueurs...");
			for (int i=0;i<joueurs.size();i++) {
				Client player = joueurs.get(i);
				VisionJoueur v = new VisionJoueur(player);
				player.send_message(v.showplateau(player));
				player.send_message(v.showperso(player));
				player.send_message(v.demandeactions(player));
				//ICI ON RENVOIE SON PLATEAU AU JOUEUR AVEC LE PERSO ET LES CONSIGNES

			}
			
			for (int i=0;i<joueurs.size();i++) {
				Client player = joueurs.get(i);
				while(player.ReadyActions()==false && player.p.isAlive()) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(player.getNom()+" est prêt.");
				//ICI ON ATTEND LA CHAINE DE 4 CARACTERES ACTIONS DU JOUEUR
			}
			for(int i=0;i<joueurs.size();i++) {
				//C'EST ICI QU'IL COMMENCE A Y AVOIR DES PROBLEMES! IL FAUT VOIR LES FONCTIONS DE DEP
				Client player = joueurs.get(i);
				player.Djoueurs.Move(player.actions, player.p , player.p.getPlateau());//Je mets
				//à jour le plateau personnel du joueur afin qu'il ai un plateau perso correct
				player.p.getPlateau().afficher();
				player.D.Move(player.actions, player.p ,Plateau);//Je mets a jour le plateau
				//de la partie lorsqu'un joueur joue.
				Plateau.afficher();
				player.setActions("a"); //Pour que players.ReadyActions() passe à faux
				System.out.println("");
				if(player.D.getVictoire()) {
					fin=true;
					System.out.println(player.getNom()+" a gagné!!!");
				}
			}
		}
			
	}
}


	

