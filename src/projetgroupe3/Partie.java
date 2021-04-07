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
			
			System.out.println(player.getNom()+" est prêt.");
			player.p = new Personnage(player.getNom());
			}
		
		//MISE EN PLACE DU PLATEAU PERSO DU JOUEUR
		for (int i=0;i<joueurs.size();i++) {
			Client player = joueurs.get(i);
			for(int x=0;x<X;x++) {
				for(int y=0;y<Y;y++) {
					int[] pos= {x,y};
					char a = Plateau.valeurcase(x, y);
					player.p.getPlateau().setOnePlateau(a,pos);
				}
			}
			player.p.setPosition(Plateau.addPlayerServeur(player.p));
			player.D = new Deplacements(player.p,Plateau); //va permettre d'actualiser le plateau
			player.Djoueurs = new Deplacements(player.p,player.p.getPlateau()); //va permettre
			//d'actualiser le plateau du joueur seulement dans vision joueur.
			player.p.getPlateau().setOnePlateauPerso('H',player.p.getPosition());//On ajoute un H sur le plateau joueur
			//A la même position que celui sur le plateau général
			player.p.getPlateau().setOnePlateau('H', player.p.getPosition());
			VisionJoueur v = new VisionJoueur(player.p);
			v.showVision(); //fonctionne mais je voudrais l'afficher chez les clients...
			//player.p.getPlateau().afficherPlateauPerso(); //SEULEMENT AU JOUEUR...
			System.out.println();

			
			//renvoyer la vision du joueur : serializable
		}
		//Plateau.afficher(); //Je l'affiche seulement pour tester, c'est bon, 2H
		
		boolean fin=false;
		while(fin==false) {
			System.out.println("En attente des actions des joueurs...");
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
			}
			for(int i=0;i<joueurs.size();i++) {
				Client player = joueurs.get(i);
				player.Djoueurs.Move(player.actions, player.p , player.p.getPlateau());//Je mets
				//à jour le plateau personnel du joueur afin qu'il est un plateau perso correct
				player.D.Move(player.actions, player.p ,Plateau);//Je mets a jour le plateau
				//de la partie lorsqu'un joueur joue.
				player.p.getPlateau().afficherPlateauPerso();//A ne renvoyer qu'au joueur
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


	

